package org.nuxeo.talend.extension.wizard;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.nuxeo.talend.extension.NuxeoRepositoryNodeType;
import org.nuxeo.talend.extension.NuxeoServerSubTreeBuilder;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.talend.commons.ui.runtime.exception.MessageBoxExceptionHandler;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.commons.ui.swt.dialogs.ErrorDialogWidthDetailArea;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.context.Context;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.metadata.IMetadataConnection;
import org.talend.core.model.metadata.builder.connection.DatabaseConnection;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.update.RepositoryUpdateManager;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.utils.AbstractResourceChangesService;
import org.talend.core.repository.utils.TDQServiceRegister;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.designer.core.IDesignerCoreService;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.IRepositoryNode;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.model.StableRepositoryNode;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.ui.utils.ConnectionContextHelper;
import org.talend.repository.ui.wizards.CheckLastVersionRepositoryWizard;
import org.talend.repository.ui.wizards.PropertiesWizardPage;
import org.talend.repository.ui.wizards.metadata.connection.Step0WizardPage;

/**
 * Wizard to create the connection to a Nuxeo server
 */
public class NuxeoWizard extends CheckLastVersionRepositoryWizard implements INewWizard {

    private static Logger log = Logger.getLogger(NuxeoWizard.class);

    private PropertiesWizardPage propertiesWizardPage;

    private NuxeoServerWizardPage nuxeoWizardPage;

    private NuxeoConnection connection;

    private Property connectionProperty;

    private String originaleObjectLabel;

    private String originalVersion;

    private String originalPurpose;

    private String originalDescription;

    private String originalStatus;

    private boolean isToolBar;

    private RepositoryNode node;

    protected static final boolean BUILD_NXSUBTREE_AT_CREATION = true;
    
    /**
     * Constructor for DatabaseWizard. Analyse Iselection to extract DatabaseConnection and the pathToSave. Start the
     * Lock Strategy.
     * 
     * @param selection
     * @param existingNames
     */
    public NuxeoWizard(IWorkbench workbench, boolean creation, RepositoryNode node, String[] existingNames) {
        super(workbench, creation);
        this.existingNames = existingNames;
        setNeedsProgressMonitor(true);
        this.node = node;
        switch (node.getType()) {
        case SIMPLE_FOLDER:
        case REPOSITORY_ELEMENT:
            pathToSave = RepositoryNodeUtilities.getPath(node);
            break;
        case SYSTEM_FOLDER:
            pathToSave = new Path(""); //$NON-NLS-1$
            break;
        }

        switch (node.getType()) {
        case SIMPLE_FOLDER:
        case SYSTEM_FOLDER:
        	System.out.println("NXWizard Start on System Folder");
            connection = NuxeoFactory.eINSTANCE.createNuxeoConnection();
            connectionProperty = PropertiesFactory.eINSTANCE.createProperty();
            connectionProperty.setAuthor(((RepositoryContext) CoreRuntimePlugin.getInstance().getContext()
                    .getProperty(Context.REPOSITORY_CONTEXT_KEY)).getUser());
            connectionProperty.setVersion(VersionUtils.DEFAULT_VERSION);
            connectionProperty.setStatusCode(""); //$NON-NLS-1$

            connectionItem = NuxeoFactory.eINSTANCE.createNuxeoConnectionItem();
            connectionItem.setProperty(connectionProperty);
            connectionItem.setConnection(connection);
            break;

        case REPOSITORY_ELEMENT:
        	// DEAD code !
        	System.out.println("NXWizard Start on repository element");
            connection = (NuxeoConnection) ((ConnectionItem) node.getObject().getProperty().getItem()).getConnection();
            connectionProperty = node.getObject().getProperty();
            connectionItem = (ConnectionItem) node.getObject().getProperty().getItem();

            // set the repositoryObject, lock and set isRepositoryObjectEditable
            setRepositoryObject(node.getObject());
            isRepositoryObjectEditable();
            initLockStrategy();
            break;
        }
        if (!creation) {
            this.originaleObjectLabel = this.connectionItem.getProperty().getDisplayName();
            this.originalVersion = this.connectionItem.getProperty().getVersion();
            this.originalDescription = this.connectionItem.getProperty().getDescription();
            this.originalPurpose = this.connectionItem.getProperty().getPurpose();
            this.originalStatus = this.connectionItem.getProperty().getStatusCode();

        }
        // initialize the context mode
        ConnectionContextHelper.checkContextMode(connectionItem);
    }

    /**
     * yzhang Comment method "setToolBar".
     * 
     * @param isToolbar
     */
    public void setToolBar(boolean isToolbar) {
        this.isToolBar = isToolbar;
    }

    /**
     * Adding the page to the wizard and set Title, Description and PageComplete.
     */
    @Override
    public void addPages() {
        setWindowTitle(Messages.getString("NuxeoWizard.windowTitle")); //$NON-NLS-1$
        setDefaultPageImageDescriptor(ImageProvider.getImageDesc(ECoreImage.METADATA_CONNECTION_WIZ));
        if (isToolBar) {
            pathToSave = null;
        }
        propertiesWizardPage = new Step0WizardPage(connectionProperty, pathToSave, ERepositoryObjectType.METADATA_CONNECTIONS,
                !isRepositoryObjectEditable(), creation);
        
        nuxeoWizardPage = new NuxeoServerWizardPage(connectionItem, isRepositoryObjectEditable(), existingNames);

        if (creation) {
            propertiesWizardPage.setTitle(Messages.getString("DatabaseWizardPage.titleCreate.Step1")); //$NON-NLS-1$
            propertiesWizardPage.setDescription(Messages.getString("DatabaseWizardPage.descriptionCreate.Step1")); //$NON-NLS-1$
            propertiesWizardPage.setPageComplete(false);

            nuxeoWizardPage.setTitle(Messages.getString("DatabaseWizardPage.titleCreate.Step2")); //$NON-NLS-1$
            nuxeoWizardPage.setDescription(Messages.getString("DatabaseWizardPage.descriptionCreate.Step2")); //$NON-NLS-1$
            nuxeoWizardPage.setPageComplete(false);
        } else {
            propertiesWizardPage.setTitle(Messages.getString("DatabaseWizardPage.titleUpdate.Step1")); //$NON-NLS-1$
            propertiesWizardPage.setDescription(Messages.getString("DatabaseWizardPage.descriptionUpdate.Step1")); //$NON-NLS-1$
            propertiesWizardPage.setPageComplete(isRepositoryObjectEditable());

            nuxeoWizardPage.setTitle(Messages.getString("DatabaseWizardPage.titleUpdate.Step2")); //$NON-NLS-1$
            nuxeoWizardPage.setDescription(Messages.getString("DatabaseWizardPage.descriptionUpdate.Step2")); //$NON-NLS-1$
            nuxeoWizardPage.setPageComplete(isRepositoryObjectEditable());
        }
        addPage(propertiesWizardPage);
        addPage(nuxeoWizardPage);
    }    
    
    /**
     * This method is called when 'Finish' button is pressed in the wizard. Save metadata close Lock Strategy and close
     * wizard.
     */
    @Override
    public boolean performFinish() {
    	System.out.println("performFinish");
        if (nuxeoWizardPage.isPageComplete()) {
        
        	System.out.println("performFinish / pageComplete");
        	            
            final IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();

            try {
                if (creation) {
                    String nextId = factory.getNextId();
                    connectionProperty.setId(nextId);
                    
                    String displayName = connectionProperty.getDisplayName();
                    connectionProperty.setLabel(displayName);
                    this.connection.setName(displayName);
                    this.connection.setLabel(displayName);
                    
                    IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

						@Override
						public void run(IProgressMonitor monitor)
								throws CoreException {
							try {
								System.out.println("create Nuxeo Server node");
								factory.create(connectionItem, propertiesWizardPage.getDestinationPath());								
																
								if (node.getType().equals(NuxeoRepositoryNodeType.NUXEO_NODE)) {
									System.out.println("Build sub tree on Nuxeo node " + node.getLabel() + " (" + node.getType() + ")");
									NuxeoServerSubTreeBuilder.build(node);	
								} else {
									
									IRepositoryNode targetParentNode = node;
									
									if (targetParentNode.getChildren().size()==1) {
										if (targetParentNode.getChildren().get(0).getLabel().equals("Nuxeo Platform")) {
											System.out.println("Skip intermediate node ...");
											targetParentNode =targetParentNode.getChildren().get(0); 
										}
									}									
									
									System.out.println("Build sub tree on children nodes of " + targetParentNode.getLabel() + " (" + node.getType() + ")");
									
									for (IRepositoryNode child : targetParentNode.getChildren()) {
										if (child.getChildren().size()==0) {
											System.out.println("create children for " + child.getLabel() + " (" + targetParentNode.getType() + ")");
											NuxeoServerSubTreeBuilder.build((RepositoryNode)child);
										} else {
											System.out.println("skip children gen for " + child.getLabel() + " (" + targetParentNode.getType() + ")");
										}
									}		
								}
								
								IPath npath = RepositoryNodeUtilities.getPath(node);
							} catch (Exception e) {
								e.printStackTrace();
							}							
						}
                    	
                    };

                    if (BUILD_NXSUBTREE_AT_CREATION) {                    
	                    IWorkspace workspace = ResourcesPlugin.getWorkspace();
	                    try {
	                        workspace.run(runnable, workspace.getRoot(), IWorkspace.AVOID_UPDATE, null);
	                    } catch (CoreException e) {
	                        e.printStackTrace();
	                    	MessageBoxExceptionHandler.process(e.getCause());                        
	                    }
                    }
                    
                    //factory.create(connectionItem, propertiesWizardPage.getDestinationPath());                    
                    //IPath npath = RepositoryNodeUtilities.getPath(node);

             	                 	    
                } else {
                	// update
                    //if (connectionItem.getConnection() instanceof NuxeoConnection) {
                    //	NuxeoConnection conn = (NuxeoConnection) connectionItem.getConnection();
                    //}
                    // changed by hqzhang for TDI-19527, label=displayName
                    connectionProperty.setLabel(connectionProperty.getDisplayName());
                    this.connection.setName(connectionProperty.getDisplayName());
                    this.connection.setLabel(connectionProperty.getDisplayName());

                    // Modified by Marvin Wang on Apr. 40, 2012 for bug TDI-20744
                    // factory.save(connectionItem);
                    // 0005170: Schema renamed - new name not pushed out to dependant jobs
                    boolean isNameModified = propertiesWizardPage.isNameModifiedByUser();

                    updateConnectionItem();

                    if (isNameModified) {
                        if (GlobalServiceRegister.getDefault().isServiceRegistered(IDesignerCoreService.class)) {
                            IDesignerCoreService service = (IDesignerCoreService) GlobalServiceRegister.getDefault().getService(
                                    IDesignerCoreService.class);
                            if (service != null) {
                                service.refreshComponentView(connectionItem);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                String detailError = e.toString();
                new ErrorDialogWidthDetailArea(getShell(), PID, Messages.getString("CommonWizard.persistenceException"), //$NON-NLS-1$
                        detailError);
                log.error(Messages.getString("CommonWizard.persistenceException") + "\n" + detailError); //$NON-NLS-1$ //$NON-NLS-2$
                e.printStackTrace();
                return false;
            }
            
            updateTdqDependencies();
            return true;
        } else {
            return false;
        }
    }

    private void updateTdqDependencies() {
        if (connectionItem != null) {
            String oldVersion = this.originalVersion;
            String newVersioin = connectionItem.getProperty().getVersion();
            if (oldVersion != null && newVersioin != null && !newVersioin.equals(oldVersion)) {
                AbstractResourceChangesService resChangeService = TDQServiceRegister.getInstance().getResourceChangeService(
                        AbstractResourceChangesService.class);
                if (resChangeService != null) {
                    resChangeService.updateDependeciesWhenVersionChange(connectionItem, oldVersion, newVersioin);
                }
            }
        }
    }

    @Override
    public boolean performCancel() {
        if (!creation) {
            connectionItem.getProperty().setVersion(this.originalVersion);
            connectionItem.getProperty().setDisplayName(this.originaleObjectLabel);
            connectionItem.getProperty().setDescription(this.originalDescription);
            connectionItem.getProperty().setPurpose(this.originalPurpose);
            connectionItem.getProperty().setStatusCode(this.originalStatus);
        }
        return super.performCancel();
    }

    /**
     * We will accept the selection in the workbench to see if we can initialize from it.
     * 
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    @Override
    public void init(final IWorkbench workbench, final IStructuredSelection selection2) {
        super.setWorkbench(workbench);
        this.selection = selection2;
    }

    @Override
    public ConnectionItem getConnectionItem() {
        return this.connectionItem;
    }

    private void updateConnectionInformation(DatabaseConnection dbConn, IMetadataConnection metaConnection) {

    }

    /**
     * reload the connection
     */
    public static final String RELOAD_FLAG_TRUE = "RELOAD";

    /**
     * don't reload the connection
     */
    public static final String RELOAD_FLAG_FALSE = "UNRELOAD";

    /**
     * judgement reload the connection or not
     * 
     * @param reloadFlag
     * @return
     */
    public static boolean needReload(String reloadFlag) {
        return RELOAD_FLAG_TRUE.equals(reloadFlag);
    }

}
