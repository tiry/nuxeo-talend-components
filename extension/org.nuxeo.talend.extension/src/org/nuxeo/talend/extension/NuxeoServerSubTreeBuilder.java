package org.nuxeo.talend.extension;

import org.eclipse.core.runtime.IPath;
import org.nuxeo.talend.extension.model.nuxeo.AutomationOperation;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.nuxeo.talend.extension.wizard.Messages;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.repository.RepositoryManager;
import org.talend.core.repository.model.IRepositoryFactory;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.model.RepositoryFactoryProvider;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.model.StableRepositoryNode;

public class NuxeoServerSubTreeBuilder {

	protected static RepositoryNode mkFolder(RepositoryNode parent, String title) {
		
		RepositoryNode folderNode = new StableRepositoryNode(parent,
                Messages.getString(title), ECoreImage.FOLDER_CLOSE_ICON); 	                
 	    folderNode.setParent(parent); 	    
 	    parent.getChildren().add(folderNode);
 	    
 	    return folderNode;
	}
	
	protected static void fetchOperations(NuxeoConnection conn, RepositoryNode opNode) throws PersistenceException {

	    ProjectManager pm = ProjectManager.getInstance();
        IRepositoryFactory repositoryFactory = RepositoryFactoryProvider.getRepositoriyById("local");
		
        IPath npath = RepositoryNodeUtilities.getPath(opNode);
        
    	for (int i = 0; i < 10; i++) {
      	    System.out.println("Adding operation " + i);
    		RepositoryNode operation = new StableRepositoryNode(opNode,
                      Messages.getString("Operation " + i), ENuxeoImage.NX_ICON);
      	    opNode.getChildren().add(operation);
      	    operation.setParent(opNode);
			AutomationOperation op = NuxeoFactory.eINSTANCE
					.createAutomationOperation();
			op.setOperationId("Op " + i);
			op.setSignature("sig" + i);
			System.out.println("Saving operation " + i);
			try {
				repositoryFactory.create(pm.getCurrentProject(),op, npath, false);
			} catch (Throwable t) {
				System.out.println("Error while saving operation item ; " + t.getMessage());
				t.printStackTrace();
			}
      	  System.out.println("Saved operation " + i);
  	    }

	}
	
	public static void build(RepositoryNode node) throws PersistenceException {

		if (node.getChildren().size()==0) {

	    	System.out.println("!!!!!!!!!!! Generate sub nodes ");			
	    	RepositoryNode opNode = mkFolder(node, "Operations");
	    	System.out.println("created node " + opNode.getLabel());
	    	RepositoryNode chainNode = mkFolder(node, "Chains");
	    	System.out.println("created node " + chainNode.getLabel());
	    	RepositoryNode schemaNode = mkFolder(node, "Schemas");
	    	System.out.println("created node " + schemaNode.getLabel());
	    		    	
	    	if (node.getObject().getProperty().getItem()!=null) {
	    		NuxeoConnection conn = (NuxeoConnection) ((ConnectionItem) node.getObject().getProperty().getItem()).getConnection();	    	    
	    	    fetchOperations(conn, opNode);
	    	} else {
	    		System.out.println("Unable to get Connection from node " + node.getLabel());
	    	}
    	    
		}   else {
  			  System.out.println("node " + node.getId() + " --- " + node.getType().toString() + " has already " + node.getChildren().size() + " children !");
		}
	}
	
	
}
