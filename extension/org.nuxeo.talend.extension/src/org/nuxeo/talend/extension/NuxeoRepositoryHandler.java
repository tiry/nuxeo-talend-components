package org.nuxeo.talend.extension;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.ui.IWorkbench;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.commons.ui.runtime.image.IImage;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Status;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryContentHandler;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.utils.XmiResourceManager;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.repository.model.IRepositoryNode;
import org.talend.repository.model.RepositoryNode;

public class NuxeoRepositoryHandler implements IRepositoryContentHandler {

	protected static final boolean ASYNC_NODE_PROCESSING = false;

	private XmiResourceManager xmiResourceManager = new XmiResourceManager();

	public NuxeoRepositoryHandler() {
	}

	@Override
	public Resource create(IProject project, Item item, int classifierID,
			IPath path) throws PersistenceException {
		ERepositoryObjectType repositoryObjectType = getRepositoryObjectType(item);
		if (isRepObjType(repositoryObjectType)) {
			NuxeoConnectionItem nuxeoItem = (NuxeoConnectionItem) item;
			Resource itemResource = xmiResourceManager.createItemResource(
					project, item, path, repositoryObjectType, false);
			itemResource.getContents().add(nuxeoItem.getConnection());
			return itemResource;
		} else {
			LogHelper.debug("calling create on wrong type");
		}
		return null;

	}

	@Override
	public Resource save(Item item) throws PersistenceException {
		ERepositoryObjectType repositoryObjectType = getRepositoryObjectType(item);
		if (isRepObjType(repositoryObjectType)) {

			NuxeoConnectionItem nxItem = (NuxeoConnectionItem) item;
			Resource itemResource = xmiResourceManager.getItemResource(item);
			itemResource.getContents().clear();
			itemResource.getContents().add(nxItem.getConnection());
			return itemResource;
		}
		return null;
	}

	@Override
	public Item createNewItem(ERepositoryObjectType type) {
		if (isRepObjType(type)) {
			return NuxeoFactory.eINSTANCE.createNuxeoConnectionItem();
		}
		return null;
	}

	@Override
	public ERepositoryObjectType getRepositoryObjectType(Item item) {
		if (item instanceof NuxeoConnectionItem) {
			return NuxeoRepositoryNodeType.repositoryNuxeoType;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.talend.core.model.repository.IRepositoryContentHandler#isRepObjType
	 * (org.talend.core.model.repository. ERepositoryObjectType)
	 */
	@Override
	public boolean isRepObjType(ERepositoryObjectType type) {
		return NuxeoRepositoryNodeType.repositoryNuxeoType.equals(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.talend.core.model.repository.IRepositoryContentHandler#getIcon(org
	 * .talend.core.model.repository. ERepositoryObjectType)
	 */
	@Override
	public IImage getIcon(ERepositoryObjectType type) {
		if (isRepObjType(type)) {
			return ENuxeoImage.NX_ICON;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.talend.core.model.repository.IRepositoryContentHandler#getIcon(org
	 * .talend.core.model.properties.Item)
	 */
	@Override
	public IImage getIcon(Item item) {
		return getIcon(getRepositoryObjectType(item));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.talend.core.model.repository.IRepositoryContentHandler#isProcess(
	 * org.talend.core.model.properties.Item)
	 */
	@Override
	public boolean isProcess(Item item) {
		return false;
	}

	@Override
	public ERepositoryObjectType getProcessType() {
		return null;
	}

	@Override
	public ERepositoryObjectType getCodeType() {
		return null;
	}

	@Override
	public void addNode(ERepositoryObjectType type, RepositoryNode recBinNode,
			final IRepositoryViewObject repositoryObject,
			final RepositoryNode node) {

		if (NuxeoRepositoryNodeType.repositoryNuxeoType.equals(type)) {

			LogHelper
					.debug("Process on event to create SubNode on Nuxeo nodes of type "
							+ type.getType()
							+ " with id="
							+ node.getId()
							+ " and label=" + node.getLabel());

			if (node.getChildren().size() == 0) {
				try {
					if (!ASYNC_NODE_PROCESSING) {
						NuxeoServerSubTreeBuilder.buildTree(node, repositoryObject);
					} else {
						IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
							@Override
							public void run(IProgressMonitor arg0)
									throws CoreException {
								LogHelper.debug("Create sub nodes in async");
								try {
									NuxeoServerSubTreeBuilder.buildTree(node,
											repositoryObject);
								} catch (PersistenceException e1) {
									e1.printStackTrace();
								}
							}
						};
						IWorkspace workspace = ResourcesPlugin.getWorkspace();
						workspace.run(runnable, workspace.getRoot(),
								IWorkspace.AVOID_UPDATE, null);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void addContents(Collection<EObject> collection, Resource resource) {
		LogHelper.debug("Adding Content !!!!");
	}

	@Override
	public ERepositoryObjectType getHandleType() {
		return NuxeoRepositoryNodeType.repositoryNuxeoType;
	}

	@Override
	public boolean hasSchemas() {
		return true;
	}

	@Override
	public List<Status> getPropertyStatus(Item item) {
		try {
			return CoreRuntimePlugin.getInstance().getProxyRepositoryFactory()
					.getTechnicalStatus();
		} catch (PersistenceException e) {
			ExceptionHandler.process(e);
		}
		return null;
	}

	@Override
	public boolean hideAction(IRepositoryNode node, Class actionType) {
		return node != null ? isRepObjType(node.getObjectType()) : false;
	}

	@Override
	public boolean isOwnTable(IRepositoryNode node, Class type) {
		return node != null ? isRepObjType(node.getObjectType()) : false;
	}

	@Override
	public IWizard newWizard(IWorkbench workbench, boolean creation,
			RepositoryNode node, String[] existingNames) {
		return null;
	}

}
