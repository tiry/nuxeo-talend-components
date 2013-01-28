package org.nuxeo.talend.extension;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem;
import org.nuxeo.talend.extension.wizard.Messages;
import org.nuxeo.talend.extension.wizard.NuxeoWizard;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.RepositoryManager;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.ui.actions.metadata.AbstractCreateAction;
import org.talend.core.ui.images.OverlayImageProvider;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.StableRepositoryNode;

public class NuxeoRepositoryContextAction extends AbstractCreateAction {

	private static final String EDIT_LABEL = "Edit Nuxeo Server";

	private static final String CREATE_LABEL = "Add Nuxeo Server";

	private static final String OPEN_LABEL = "Open Nuxeo Server";

	private static ImageDescriptor defaultImage = ImageProvider
			.getImageDesc(ENuxeoImage.NX_ICON);

	private static ImageDescriptor createImage = OverlayImageProvider
			.getImageWithNew(ImageProvider.getImage(ENuxeoImage.NX_ICON));

	private boolean creation = false;

	public NuxeoRepositoryContextAction() {
		super();
		this.setText(CREATE_LABEL);
		this.setToolTipText(CREATE_LABEL);
		this.setImageDescriptor(defaultImage);
	}

	@Override
	protected void init(RepositoryNode node) {
				
		ERepositoryObjectType nodeType = (ERepositoryObjectType) node
				.getProperties(EProperties.CONTENT_TYPE);
				
//		if (!NuxeoRepositoryNodeType.repositoryNuxeoType.equals(nodeType)) {
//			return;
//		}

		LogHelper.debug("init context Action on node " + node.getLabel() + " (" + nodeType.toString() + ")");
		
		IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
		switch (node.getType()) {
		
		case SIMPLE_FOLDER:
			LogHelper.debug("Simple Folder");
			if (node.getObject() != null
					&& node.getObject().getProperty().getItem().getState()
							.isDeleted()) {
				setEnabled(false);
				return;
			}
		case SYSTEM_FOLDER:
			LogHelper.debug("System Folder");
			if (factory.isUserReadOnlyOnCurrentProject()
					|| !ProjectManager.getInstance().isInCurrentMainProject(
							node)) {
				setEnabled(false);
				return;
			}
			this.setText(CREATE_LABEL);
			collectChildNames(node);
			this.setImageDescriptor(createImage);
			creation = true;
			break;
		case REPOSITORY_ELEMENT:
			LogHelper.debug("Repo Element");
			if (factory.isPotentiallyEditable(node.getObject())) {
				this.setText(EDIT_LABEL);
				this.setImageDescriptor(defaultImage);
				collectSiblingNames(node);
			} else {
				this.setText(OPEN_LABEL);
				this.setImageDescriptor(defaultImage);
			}
			collectSiblingNames(node);
			creation = false;
			break;
		default:
			LogHelper.debug("Can not find nodeType");
			return;
		}
		setEnabled(true);
	}

	protected void displayMessage(final String title, final String msg) {
		this.getWorkbench().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.openInformation(getWorkbench().getDisplay()
						.getActiveShell(), title, msg);
			}
		});
	}

	@Override
	protected void doRun() {
		LogHelper.debug("Run NX Action");

		if (repositoryNode == null) {
			repositoryNode = getCurrentRepositoryNode();
		}
		if (repositoryNode == null) {
			return;
		}

        IPath npath = RepositoryNodeUtilities.getPath(repositoryNode);
        
		LogHelper.debug("Run create Action on node of type " + repositoryNode.getType().toString());

		NuxeoWizard nxWizard = new NuxeoWizard(PlatformUI.getWorkbench(), creation,
				repositoryNode, getExistingNames());
		
		WizardDialog wizardDialog = new WizardDialog(Display.getCurrent().getActiveShell(),nxWizard);

		wizardDialog.setPageSize(800, 400);
		wizardDialog.create();
		wizardDialog.open();
		if (!creation) {
	            RepositoryManager.refreshSavedNode(repositoryNode);
	    }		
	}

	@Override
	public Class getClassForDoubleClick() {
		return NuxeoConnectionItem.class;
	}
}
