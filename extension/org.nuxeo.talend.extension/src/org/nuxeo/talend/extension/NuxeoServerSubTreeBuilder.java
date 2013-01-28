package org.nuxeo.talend.extension;

import org.eclipse.core.runtime.IPath;
import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.model.OperationDocumentation;
import org.nuxeo.talend.extension.automation.NuxeoServer;
import org.nuxeo.talend.extension.model.nuxeo.AutomationOperation;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.nuxeo.talend.extension.wizard.Messages;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.CorePlugin;
import org.talend.core.context.Context;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.metadata.builder.connection.ConnectionFactory;
import org.talend.core.model.metadata.builder.connection.MetadataTable;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.IRepositoryFactory;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.model.RepositoryFactoryProvider;
import org.talend.cwm.helper.ConnectionHelper;
import org.talend.cwm.helper.PackageHelper;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.ERepositoryStatus;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.model.StableRepositoryNode;
import orgomg.cwm.resource.record.RecordFactory;
import orgomg.cwm.resource.record.RecordFile;

public class NuxeoServerSubTreeBuilder {

	public static final boolean BUILD_NXSUBTREE_AT_CREATION = false;
	public static final boolean FETCH_OPERATIONS = true;
	public static final boolean PERSIST_TREE = false;
	public static final boolean BUILD_NXSUBTREE_VIA_EVENT = true;

	protected static RepositoryNode mkFolder(RepositoryNode parent,
			String title, IRepositoryViewObject repositoryObject) {

		RepositoryNode folderNode = new StableRepositoryNode(parent,
				Messages.getString(title), ECoreImage.FOLDER_CLOSE_ICON);

		folderNode.setParent(parent);
		parent.getChildren().add(folderNode);

		return folderNode;
	}

	protected static RepositoryNode mkFolderOb(RepositoryNode parent,
			String title, IRepositoryViewObject repositoryObject) {

		IRepositoryFactory repositoryFactory = RepositoryFactoryProvider
				.getRepositoriyById("local");

		RepositoryNode folderNode = new RepositoryNode(repositoryObject,
				parent, ENodeType.SIMPLE_FOLDER);
		folderNode.setProperties(EProperties.LABEL, Messages.getString(title));
		folderNode.setParent(parent);
		parent.getChildren().add(folderNode);

		return folderNode;
	}

	protected static void fetchOperations(NuxeoConnection conn,
			RepositoryNode opNode, IRepositoryViewObject repositoryObject,
			NuxeoConnectionItem nuxeoItem) throws PersistenceException {

		if (opNode.getChildren().size() > 0) {
			LogHelper.debug("operations are already there !");
			return;
		}

		ProjectManager pm = ProjectManager.getInstance();
		IRepositoryFactory repositoryFactory = RepositoryFactoryProvider
				.getRepositoriyById("local");

		if (conn.getOperations().size() > 0) {
			LogHelper.debug("use operation def saved in Connection");
		} else {
			LogHelper.debug("-> Fetching operation from server "
					+ conn.getHost());
			IPath npath = RepositoryNodeUtilities.getPath(opNode);

			Session nxsession = NuxeoServer.getSession(conn);

			for (OperationDocumentation opDoc : nxsession.getOperations()
					.values()) {
				opDoc.getId();

				LogHelper.debug("Adding operation " + opDoc.getId());

				RepositoryNode operation = new StableRepositoryNode(opNode,
						Messages.getString(opDoc.getId()), ENuxeoImage.NX_ICON);

				// RepositoryNode operation = new
				// NuxeoOperationNode(repositoryObject,opNode,
				// ENodeType.REPOSITORY_ELEMENT,
				// Messages.getString(opDoc.getId()),
				// ENuxeoImage.NX_ICON);

				// opNode.getChildren().add(operation);
				// operation.setParent(opNode);

				AutomationOperation op = NuxeoFactory.eINSTANCE
						.createAutomationOperation();
				op.setOperationId(opDoc.getId());
				op.setSignature(opDoc.getSignature()[0]);

				Property property = PropertiesFactory.eINSTANCE
						.createProperty();
				property.setAuthor(((RepositoryContext) CorePlugin.getContext()
						.getProperty(Context.REPOSITORY_CONTEXT_KEY)).getUser());
				property.setVersion(VersionUtils.DEFAULT_VERSION);
				property.setStatusCode(""); //$NON-NLS-1$		    
				property.setId(repositoryFactory.getNextId());

				op.setProperty(property);

				conn.getOperations().add(op);

				if (PERSIST_TREE) {
					// Because types are hard coded inside
					// LocalRepositoryFactory
					// this won't work
					LogHelper.debug("Saving operation " + opDoc.getId());
					try {
						repositoryFactory.create(pm.getCurrentProject(), op,
								npath, false);
					} catch (Throwable t) {
						LogHelper.debug("Error while saving operation item ; "
								+ t.getMessage());
						t.printStackTrace();
					}
					LogHelper.debug("Saved operation " + opDoc.getId());
				}
			}
		}

		for (AutomationOperation op : conn.getOperations()) {
			RepositoryNode operation = new StableRepositoryNode(opNode,
					Messages.getString(op.getOperationId()),
					ENuxeoImage.NX_ICON);
			opNode.getChildren().add(operation);
			operation.setParent(opNode);
		}

		if (PERSIST_TREE) {
			// manage update ?!
			IProxyRepositoryFactory factory = ProxyRepositoryFactory
					.getInstance();
			try {
				ERepositoryStatus status = factory.getStatus(nuxeoItem);
				while (status == ERepositoryStatus.LOCK_BY_OTHER
						|| status == ERepositoryStatus.LOCK_BY_USER) {
					LogHelper.debug("Wait for lock to be available");
					Thread.sleep(500);
					status = factory.getStatus(nuxeoItem);
				}
				factory.lock(nuxeoItem);
				factory.save(pm.getCurrentProject(), nuxeoItem);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				try {
					factory.unlock(nuxeoItem);
				} catch (LoginException e) {
					e.printStackTrace();
				}
			}
		}

	}

	protected static void fetchSchemas(NuxeoConnection conn,
			RepositoryNode schemaNode) {

		IRepositoryFactory repositoryFactory = RepositoryFactoryProvider
				.getRepositoriyById("local");

		MetadataTable metadataTable = ConnectionFactory.eINSTANCE
				.createMetadataTable();
		String nextId = ProxyRepositoryFactory.getInstance().getNextId();
		metadataTable.setId(nextId);
		metadataTable.setLabel("nxSchema");

		LogHelper.debug("created nxSchema metadata");

		RecordFile record = (RecordFile) ConnectionHelper.getPackage(
				conn.getName(), conn, RecordFile.class);
		if (record != null) {
			LogHelper.debug("update record to add metadata");
			PackageHelper.addMetadataTable(metadataTable, record);
		} else {
			LogHelper.debug("add record to add metadata");
			RecordFile newrecord = RecordFactory.eINSTANCE.createRecordFile();
			ConnectionHelper.addPackage(newrecord, conn);
			PackageHelper.addMetadataTable(metadataTable, newrecord);
		}

		/*
		 * RepositoryNode operation = new StableRepositoryNode(opNode,
		 * Messages.getString(opDoc.getId()), ENuxeoImage.NX_ICON);
		 * 
		 * 
		 * schemaNode.getChildren().add(metadataTable);
		 * operation.setParent(opNode);
		 */
	}

	public static void build(RepositoryNode node,
			IRepositoryViewObject repositoryObject) throws PersistenceException {

		if (node.getChildren().size() == 0) {

			LogHelper.debug("Generate sub nodes folders ...");
			RepositoryNode opNode = mkFolder(node, "Operations",
					repositoryObject);
			LogHelper.debug("-> created node " + opNode.getLabel());
			RepositoryNode chainNode = mkFolder(node, "Chains",
					repositoryObject);
			LogHelper.debug("-> created node " + chainNode.getLabel());
			RepositoryNode schemaNode = mkFolder(node, "Schemas",
					repositoryObject);
			LogHelper.debug("-> created node " + schemaNode.getLabel());

			if (FETCH_OPERATIONS) {
				if (node.getObject() != null
						&& node.getObject().getProperty().getItem() != null) {
					try {
						NuxeoConnection conn = (NuxeoConnection) ((ConnectionItem) node
								.getObject().getProperty().getItem())
								.getConnection();
						NuxeoConnectionItem nuxeoItem = ((NuxeoConnectionItem) node
								.getObject().getProperty().getItem());
						LogHelper.debug("Start fetching operation");
						fetchOperations(conn, opNode, repositoryObject,
								nuxeoItem);
						LogHelper.debug("Start fetching schemas");
						// fetchSchemas(conn, schemaNode);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				} else {
					LogHelper.debug("Unable to get Connection from node "
							+ node.getLabel());
				}
			}

			if (PERSIST_TREE) {
				ProxyRepositoryFactory.getInstance().saveProject(
						ProjectManager.getInstance().getCurrentProject());
			}

		} else {
			LogHelper.debug("YES !!! node " + node.getId() + " --- "
					+ node.getType().toString() + " has already "
					+ node.getChildren().size() + " children !");
		}
	}

}
