package org.nuxeo.talend.extension;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.nuxeo.talend.extension.wizard.NuxeoWizard;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.commons.ui.runtime.exception.MessageBoxExceptionHandler;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.context.Context;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.RepositoryManager;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.ui.actions.metadata.AbstractCreateAction;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.core.ui.images.OverlayImageProvider;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.ui.wizards.metadata.connection.files.delimited.DelimitedFileWizard;

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
                MessageDialog.openInformation(getWorkbench().getDisplay().getActiveShell(), title, msg);
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
        
        WizardDialog wizardDialog;

        
        wizardDialog = new WizardDialog(Display.getCurrent().getActiveShell(), new NuxeoWizard(
                    PlatformUI.getWorkbench(), creation, repositoryNode, getExistingNames()));

        if (!creation) {
            RepositoryManager.refreshSavedNode(repositoryNode);
        }

        System.out.println("Dialog created, displaying ");
        
        wizardDialog.setPageSize(800, 400);
        wizardDialog.create();
        wizardDialog.open();
    	
        System.out.println("dialog displayed");
        
        if (creation) {
        	System.out.println("Creation model !");
        	//displayMessage("Create", "Yes!!!");
        	
        	IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
                @Override
                public void run(final IProgressMonitor monitor) throws CoreException {
                    IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
           
                    // find the path
                    IPath pathToSave = new Path("");//$NON-NLS-1$
                    switch (repositoryNode.getType()) {
                    case SIMPLE_FOLDER:
                    case REPOSITORY_ELEMENT:
                        pathToSave = RepositoryNodeUtilities.getPath(repositoryNode);
                        break;
                    case SYSTEM_FOLDER:
                        pathToSave = new Path(""); //$NON-NLS-1$
                        break;
                    }

                    System.out.println("Creation new Item");
                    
                    // create the items
                    Property connectionProperty = PropertiesFactory.eINSTANCE.createProperty();
           
                    connectionProperty.setLabel("Nuxeo Server");
                    connectionProperty.setAuthor(((RepositoryContext) CoreRuntimePlugin.getInstance().getContext()
                            .getProperty(Context.REPOSITORY_CONTEXT_KEY)).getUser());
                    connectionProperty.setVersion(VersionUtils.DEFAULT_VERSION);
                    connectionProperty.setId(factory.getNextId());

                    
                    NuxeoConnectionItem nuxeoItem = NuxeoFactory.eINSTANCE.createNuxeoConnectionItem();
                    nuxeoItem.setProperty(connectionProperty);

                    NuxeoConnection nuxeoConn = NuxeoFactory.eINSTANCE.createNuxeoConnection();
                    nuxeoItem.setConnection(nuxeoConn);

                    nuxeoConn.setName(NuxeoRepositoryNodeType.repositoryNuxeoType.getType());
                    nuxeoConn.setValid(true);

                    // set the label same as displayName
                    nuxeoItem.getProperty().setLabel(nuxeoItem.getProperty().getDisplayName());

                    System.out.println("Object created in memory, start save on " + pathToSave);
                    
                    // create item
                    try {
                    	EClass eclass = nuxeoItem.eClass();
                    	int cid = eclass.getClassifierID();
                    	System.out.println("Start creation from " + eclass.getInstanceTypeName() + " with cid=" + cid); 
                        factory.create(nuxeoItem, pathToSave);
                        System.out.println("Creation completed on path" + pathToSave);
                        //displayDetails(nuxeoItem, "Create successfully");
                    } catch (PersistenceException e) {
                        ExceptionHandler.process(e);
                    }
                }
            };
            
            
            
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            try {
            	System.out.println("Run creation");
                workspace.run(runnable, workspace.getRoot(), IWorkspace.AVOID_UPDATE, null);
            } catch (CoreException e) {
                MessageBoxExceptionHandler.process(e.getCause());
            }
        }
        else {
        	displayMessage("Edit ??? ", "Yes!!!");
        }
        
        
        
        
	}

}
