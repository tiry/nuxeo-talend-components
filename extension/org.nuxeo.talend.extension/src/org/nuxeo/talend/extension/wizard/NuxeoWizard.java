package org.nuxeo.talend.extension.wizard;

//import java.sql.DatabaseMetaData;
//import java.sql.Driver;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.commons.ui.swt.dialogs.ErrorDialogWidthDetailArea;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.ITDQRepositoryService;
import org.talend.core.context.Context;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.metadata.IMetadataConnection;
import org.talend.core.model.metadata.builder.ConvertionHelper;
import org.talend.core.model.metadata.builder.connection.DatabaseConnection;
import org.talend.core.model.metadata.builder.util.MetadataConnectionUtils;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.update.RepositoryUpdateManager;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.utils.AbstractResourceChangesService;
import org.talend.core.repository.utils.TDQServiceRegister;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.cwm.helper.ConnectionHelper;
import org.talend.cwm.helper.SwitchHelpers;
import org.talend.designer.core.IDesignerCoreService;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.IRepositoryService;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.ui.utils.ConnectionContextHelper;
import org.talend.repository.ui.wizards.CheckLastVersionRepositoryWizard;
import org.talend.repository.ui.wizards.PropertiesWizardPage;
import org.talend.repository.ui.wizards.metadata.connection.Step0WizardPage;
import org.talend.utils.sugars.ReturnCode;
import orgomg.cwm.resource.relational.Catalog;
import orgomg.cwm.resource.relational.Schema;

/**
 * DatabaseWizard present the DatabaseForm. Use to manage the metadata connection.
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

    private String originalSid;

    private String originalUiSchema;

    private boolean isToolBar;

    private RepositoryNode node;

    /**
     * Constructor for DatabaseWizard. Analyse Iselection to extract DatabaseConnection and the pathToSave. Start the
     * Lock Strategy.
     * 
     * @param selection
     * @param existingNames
     */
    public NuxeoWizard(IWorkbench workbench, boolean creation, ISelection selection, String[] existingNames) {
        super(workbench, creation);
        this.selection = selection;
        this.existingNames = existingNames;
        setNeedsProgressMonitor(true);
        // RepositoryNode node = null;
        Object obj = ((IStructuredSelection) selection).getFirstElement();
        if (obj instanceof RepositoryNode) {
            node = (RepositoryNode) obj;
        } else {
            return;
        }

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
        if (nuxeoWizardPage.isPageComplete()) {
            /*
             * if create connection in TOS with context model,should use the original value when create catalog or //
             * schema,see bug 0016636,using metadataConnection can be sure that all the values has been parse to
             * original. hywang
             */
        	
            IMetadataConnection metadataConnection = null;
            metadataConnection = ConvertionHelper.convert(connection, true);
            final IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();

            ITDQRepositoryService tdqRepService = null;

            if (GlobalServiceRegister.getDefault().isServiceRegistered(ITDQRepositoryService.class)) {
                tdqRepService = (ITDQRepositoryService) GlobalServiceRegister.getDefault()
                        .getService(ITDQRepositoryService.class);
            }

            try {
                if (creation) {
                    String nextId = factory.getNextId();
                    connectionProperty.setId(nextId);
                    

                    String displayName = connectionProperty.getDisplayName();
                    connectionProperty.setLabel(displayName);
                    this.connection.setName(displayName);
                    this.connection.setLabel(displayName);

                    if (tdqRepService != null) {
                        tdqRepService.checkUsernameBeforeSaveConnection(connectionItem);
                    }
                    factory.create(connectionItem, propertiesWizardPage.getDestinationPath());

                    // MOD yyi 2011-04-14:20362 reload connection
                    ConnectionHelper.setIsConnNeedReload(connection, Boolean.TRUE);
                    // MOD klliu 2012-02-08 TDQ-4645 add package filter for connection
                    ConnectionHelper.setPackageFilter(connection, "");//$NON-NLS-1$

                    MetadataConnectionUtils.fillConnectionInformation(connectionItem, metadataConnection);

                    // if after fillConnection there is still no dataPackages, need to fill them from extractor
                    List<Catalog> catalogs = ConnectionHelper.getCatalogs(connection);
                    List<Schema> schemas = ConnectionHelper.getSchema(connection);
/*                    if (catalogs.isEmpty() && schemas.isEmpty()) {
                        IDBMetadataProvider extractor = ExtractMetaDataFromDataBase.getProviderByDbType(metadataConnection
                                .getDbType());
                        if (extractor != null && type.isUseProvider()) {
                            extractor.fillConnection(connection);
                            factory.save(connectionItem);
                        }
                    }*/
                } else {
                    if (connectionItem.getConnection() instanceof DatabaseConnection) {
                        DatabaseConnection conn = (DatabaseConnection) connectionItem.getConnection();
                        ReturnCode reloadCheck = new ReturnCode(false);
                        if (tdqRepService != null && ConnectionHelper.isUrlChanged(conn)) {
                            reloadCheck = openConfirmReloadConnectionDialog(Display.getCurrent().getActiveShell());
                            if (!reloadCheck.isOk()) {
                                return false;
                            }
                        }
                        if (reloadCheck.isOk()) {
                            if (needReload(reloadCheck.getMessage())) {
                                if (tdqRepService != null) {
                                    ReturnCode retCode = tdqRepService.reloadDatabase(connectionItem);
                                    if (!retCode.isOk()) {
                                        return Boolean.FALSE;
                                    }
                                }
                            }
                        } else {
                            DatabaseConnection dbConn = SwitchHelpers.DATABASECONNECTION_SWITCH.doSwitch(conn);
                            if (dbConn != null) {
                                updateConnectionInformation(dbConn, metadataConnection);
                            }
                        }
                        // update
                        RepositoryUpdateManager.updateDBConnection(connectionItem);
                    }
                    // changed by hqzhang for TDI-19527, label=displayName
                    connectionProperty.setLabel(connectionProperty.getDisplayName());
                    this.connection.setName(connectionProperty.getDisplayName());
                    this.connection.setLabel(connectionProperty.getDisplayName());

                    // Modified by Marvin Wang on Apr. 40, 2012 for bug TDI-20744
                    // factory.save(connectionItem);
                    // 0005170: Schema renamed - new name not pushed out to dependant jobs
                    boolean isNameModified = propertiesWizardPage.isNameModifiedByUser();

                    // MOD yyin 20121115 TDQ-6395, save all dependency of the connection when the name is changed.
                    if (isNameModified && tdqRepService != null) {
                        tdqRepService.saveConnectionWithDependency(connectionItem);
                        closeLockStrategy();
                    } else {
                        updateConnectionItem();
                    }
                    // ~

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
                return false;
            }
            List<IRepositoryViewObject> list = new ArrayList<IRepositoryViewObject>();
            list.add(repositoryObject);
            if (GlobalServiceRegister.getDefault().isServiceRegistered(IRepositoryService.class)) {
                IRepositoryService service = (IRepositoryService) GlobalServiceRegister.getDefault().getService(
                        IRepositoryService.class);
                service.notifySQLBuilder(list);
            }

            if (tdqRepService != null) {
                // MOD qiongli 2012-11-19 TDQ-6287
                if (creation) {
                    tdqRepService.notifySQLExplorer(connectionItem);
                    tdqRepService.openConnectionEditor(connectionItem);
                } else {
                    tdqRepService.removeAliasInSQLExplorer(node);
                    tdqRepService.notifySQLExplorer(connectionItem);
                    // refresh the opened connection editor whatever is in DI or DQ perspective.
                    tdqRepService.refreshConnectionEditor(connectionItem);
                }
                if (CoreRuntimePlugin.getInstance().isDataProfilePerspectiveSelected()) {
                    tdqRepService.refresh(node.getParent());
                }
            }
            updateTdqDependencies();
            return true;
        } else {
            return false;
        }
    }

    /**
     * DOC xqliu Comment method "updateTdqDependencies".
     */
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
            
            //DBConnectionContextUtils.setDatabaseConnectionParameter((DatabaseConnection) connectionItem.getConnection(),
            //        databaseWizardPage.getMetadataConnection());
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

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.repository.ui.wizards.RepositoryWizard#getConnectionItem()
     */
    @Override
    public ConnectionItem getConnectionItem() {
        return this.connectionItem;
    }

    /**
     * 
     * DOC Comment method "updateConnectionInformation".
     * 
     * @param dbConn
     */
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

    /**
     * open the confirm dialog
     * 
     * @param shell
     * @return
     */
    public static ReturnCode openConfirmReloadConnectionDialog(Shell shell) {
        ReturnCode result = new ReturnCode(false);
        ConfirmReloadConnectionDialog dialog = new ConfirmReloadConnectionDialog(shell);
        if (dialog.open() == Window.OK) {
            result.setOk(true);
            result.setMessage(dialog.getReloadFlag());
        }
        return result;
    }

}
