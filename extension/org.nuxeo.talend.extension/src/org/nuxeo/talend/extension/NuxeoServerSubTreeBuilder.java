package org.nuxeo.talend.extension;

import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.model.OperationDocumentation;
import org.nuxeo.talend.extension.automation.NuxeoServer;
import org.nuxeo.talend.extension.model.nuxeo.AutomationOperation;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.nuxeo.talend.extension.wizard.Messages;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.core.model.metadata.builder.connection.ConnectionFactory;
import org.talend.core.model.metadata.builder.connection.MetadataTable;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.IRepositoryFactory;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.model.RepositoryFactoryProvider;
import org.talend.cwm.helper.ConnectionHelper;
import org.talend.cwm.helper.PackageHelper;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.StableRepositoryNode;
import orgomg.cwm.resource.record.RecordFactory;
import orgomg.cwm.resource.record.RecordFile;

public class NuxeoServerSubTreeBuilder {

	protected static RepositoryNode mkFolder(RepositoryNode parent,
			String title, IRepositoryViewObject repositoryObject) {

		RepositoryNode folderNode = new StableRepositoryNode(parent,
				Messages.getString(title), ECoreImage.FOLDER_CLOSE_ICON);

		folderNode.setParent(parent);
		parent.getChildren().add(folderNode);

		return folderNode;
	}

	public static void fetchOperationsMetaData(NuxeoConnection conn) {
		
		if (conn.getOperations().size() == 0) {
			LogHelper.debug("fetch operations def from server");

			Session nxsession = NuxeoServer.getSession(conn);
			
			for (OperationDocumentation opDoc : nxsession.getOperations()
					.values()) {
				opDoc.getId();

				LogHelper.debug("Adding operation " + opDoc.getId());

				AutomationOperation op = NuxeoFactory.eINSTANCE
						.createAutomationOperation();
				op.setOperationId(opDoc.getId());
				op.setSignature(opDoc.getSignature()[0]);
				
				conn.getOperations().add(op);
			}
			
		} else {
			LogHelper.debug("using cached operations def");
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

	}

	public static void buildTree(RepositoryNode node,
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

			NuxeoConnection conn = (NuxeoConnection) ((ConnectionItem) node
					.getObject().getProperty().getItem())
					.getConnection();
			NuxeoConnectionItem nuxeoItem = ((NuxeoConnectionItem) node
					.getObject().getProperty().getItem());
			
			for (AutomationOperation op : conn.getOperations()) {
				RepositoryNode operation = new StableRepositoryNode(opNode,
						Messages.getString(op.getOperationId()),
						ENuxeoImage.NX_OP);
				opNode.getChildren().add(operation);
				operation.setParent(opNode);
			}

		} else {
			LogHelper.debug("YES !!! node " + node.getId() + " --- "
					+ node.getType().toString() + " has already "
					+ node.getChildren().size() + " children !");
		}
	}

}
