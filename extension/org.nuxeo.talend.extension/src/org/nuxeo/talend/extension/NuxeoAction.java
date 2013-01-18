package org.nuxeo.talend.extension;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem;
import org.nuxeo.talend.extension.wizard.NuxeoWizard;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.RepositoryManager;
import org.talend.core.repository.i18n.Messages;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.ui.actions.metadata.AbstractCreateAction;
import org.talend.core.ui.images.OverlayImageProvider;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.StableRepositoryNode;

public class NuxeoAction extends AbstractCreateAction {

	private static final String EDIT_LABEL = "Edit Nuxeo Server";

	private static final String CREATE_LABEL = "Add Nuxeo Server";

	private static final String OPEN_LABEL = "Open Nuxeo Server";

	private static ImageDescriptor defaultImage = ImageProvider
			.getImageDesc(ENuxeoImage.NX_ICON);

	private static ImageDescriptor createImage = OverlayImageProvider
			.getImageWithNew(ImageProvider.getImage(ENuxeoImage.NX_ICON));

	private boolean creation = false;

	public NuxeoAction() {
		super();
		this.setText(CREATE_LABEL);
		this.setToolTipText(CREATE_LABEL);
		this.setImageDescriptor(defaultImage);
	}

	@Override
	protected void init(RepositoryNode node) {
		ERepositoryObjectType nodeType = (ERepositoryObjectType) node
				.getProperties(EProperties.CONTENT_TYPE);
		if (!NuxeoRepositoryNodeType.repositoryNuxeoType.equals(nodeType)) {
			return;
		}

		IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
		switch (node.getType()) {
		case SIMPLE_FOLDER:
			if (node.getObject() != null
					&& node.getObject().getProperty().getItem().getState()
							.isDeleted()) {
				setEnabled(false);
				return;
			}
		case SYSTEM_FOLDER:
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
		System.out.println("Run NX Action");

		if (repositoryNode == null) {
			repositoryNode = getCurrentRepositoryNode();
		}
		if (repositoryNode == null) {
			return;
		}

		System.out.println("CreateDialog");

		NuxeoWizard nxWizard = new NuxeoWizard(PlatformUI.getWorkbench(), creation,
				repositoryNode, getExistingNames());
		
		WizardDialog wizardDialog = new WizardDialog(Display.getCurrent().getActiveShell(),nxWizard);

		if (creation) {
			RepositoryNode opNode = new StableRepositoryNode(
					repositoryNode,
					Messages.getString("Automation Operations2"), ECoreImage.FOLDER_CLOSE_ICON); //$NON-NLS-1$
			repositoryNode.getChildren().add(opNode);
		}

	    
		wizardDialog.setPageSize(800, 400);
		wizardDialog.create();
		wizardDialog.open();
		RepositoryManager.refreshSavedNode(repositoryNode);

	}

	@Override
	public Class getClassForDoubleClick() {
		return NuxeoConnectionItem.class;
	}
}
