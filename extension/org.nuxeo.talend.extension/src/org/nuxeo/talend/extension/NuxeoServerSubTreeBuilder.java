package org.nuxeo.talend.extension;

import org.eclipse.core.runtime.IPath;
import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.model.OperationDocumentation;
import org.nuxeo.talend.extension.automation.NuxeoServer;
import org.nuxeo.talend.extension.model.nuxeo.AutomationOperation;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.nuxeo.talend.extension.wizard.Messages;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.CorePlugin;
import org.talend.core.context.Context;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.IRepositoryFactory;
import org.talend.core.repository.model.RepositoryFactoryProvider;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.model.StableRepositoryNode;

public class NuxeoServerSubTreeBuilder {

	public static final boolean BUILD_NXSUBTREE_AT_CREATION = false;
	public static final boolean FETCH_OPERATIONS = true;
	public static final boolean PERSIST_OPERATIONS = false;
	public static final boolean BUILD_NXSUBTREE_VIA_EVENT = true;
	
	protected static RepositoryNode mkFolder(RepositoryNode parent, String title, IRepositoryViewObject repositoryObject) {
		
		RepositoryNode folderNode = new StableRepositoryNode(parent,
                Messages.getString(title), ECoreImage.FOLDER_CLOSE_ICON);
					
 	    folderNode.setParent(parent); 	    
 	    parent.getChildren().add(folderNode); 	    
 	    
 	    return folderNode;
	}

	
	protected static RepositoryNode mkFolderOb(RepositoryNode parent, String title, IRepositoryViewObject repositoryObject) {
		
		IRepositoryFactory repositoryFactory = RepositoryFactoryProvider.getRepositoriyById("local");
					
		RepositoryNode folderNode = new RepositoryNode(repositoryObject,parent,
				ENodeType.SIMPLE_FOLDER);	
		folderNode.setProperties(EProperties.LABEL, Messages.getString(title));		
 	    folderNode.setParent(parent); 	    
 	    parent.getChildren().add(folderNode);
 	    
 	    return folderNode;
	}
	
	protected static void fetchOperations(NuxeoConnection conn, RepositoryNode opNode, IRepositoryViewObject repositoryObject) throws PersistenceException {

		if (opNode.getChildren().size()>0) {
			LogHelper.debug("operations are already there !");
			return;
		}
		
		LogHelper.debug("-> Fetching operation from server " + conn.getHost());
	    ProjectManager pm = ProjectManager.getInstance();
        IRepositoryFactory repositoryFactory = RepositoryFactoryProvider.getRepositoriyById("local");		
        IPath npath = RepositoryNodeUtilities.getPath(opNode);
		
		Session nxsession = NuxeoServer.getSession(conn);
		
		for (OperationDocumentation opDoc : nxsession.getOperations().values()) {
			opDoc.getId();
			
      	    LogHelper.debug("Adding operation " + opDoc.getId());
      	    
    		RepositoryNode operation = new StableRepositoryNode(opNode,
                      Messages.getString(opDoc.getId()), ENuxeoImage.NX_ICON);
      	    
    		//RepositoryNode operation = new NuxeoOperationNode(repositoryObject,opNode,
    		//		ENodeType.REPOSITORY_ELEMENT, Messages.getString(opDoc.getId()), ENuxeoImage.NX_ICON);
    		
    		
    		opNode.getChildren().add(operation);
      	    operation.setParent(opNode);
      	          	          	    
			AutomationOperation op = NuxeoFactory.eINSTANCE
					.createAutomationOperation();
			op.setOperationId(opDoc.getId());			
			op.setSignature(opDoc.getSignature()[0]);			
			
			
			Property  property = PropertiesFactory.eINSTANCE.createProperty();
		    property.setAuthor(((RepositoryContext) CorePlugin.getContext().getProperty(Context.REPOSITORY_CONTEXT_KEY))
		                .getUser());
		    property.setVersion(VersionUtils.DEFAULT_VERSION);
		    property.setStatusCode(""); //$NON-NLS-1$		    
		    property.setId(repositoryFactory.getNextId());
		    
		    op.setProperty(property);
						
		    if (PERSIST_OPERATIONS) {
		    	// Because types are hard coded inside LocalRepositoryFactory 
		    	// this won't work 
				LogHelper.debug("Saving operation " + opDoc.getId());
				try {
					repositoryFactory.create(pm.getCurrentProject(),op, npath, false);
				} catch (Throwable t) {
					LogHelper.debug("Error while saving operation item ; " + t.getMessage());
					t.printStackTrace();
				}
				LogHelper.debug("Saved operation " + opDoc.getId());
		    }
  	    }

	}
	
	public static void build(RepositoryNode node, IRepositoryViewObject repositoryObject) throws PersistenceException {

		if (node.getChildren().size()==0) {

	    	LogHelper.debug("Generate sub nodes folders ...");			
	    	RepositoryNode opNode = mkFolder(node, "Operations", repositoryObject);
	    	LogHelper.debug("-> created node " + opNode.getLabel());
	    	RepositoryNode chainNode = mkFolder(node, "Chains", repositoryObject);
	    	LogHelper.debug("-> created node " + chainNode.getLabel());
	    	RepositoryNode schemaNode = mkFolder(node, "Schemas", repositoryObject);
	    	LogHelper.debug("-> created node " + schemaNode.getLabel());
	    		    	
	    	if (FETCH_OPERATIONS) {
		    	if (node.getObject()!=null && node.getObject().getProperty().getItem()!=null) {
		    		try {
			    		NuxeoConnection conn = (NuxeoConnection) ((ConnectionItem) node.getObject().getProperty().getItem()).getConnection();	    	    
			    	    fetchOperations(conn, opNode, repositoryObject);
		    		} catch (Throwable e) {
		    			e.printStackTrace();		    			
					}
		    	} else {
		    		LogHelper.debug("Unable to get Connection from node " + node.getLabel());
		    	}
	    	}
    	    
		}   else {
  			  LogHelper.debug("YES !!! node " + node.getId() + " --- " + node.getType().toString() + " has already " + node.getChildren().size() + " children !");
		}
	}
	
	
}
