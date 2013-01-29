package org.nuxeo.talend.extension;

import org.talend.repository.metadata.content.AbstractMetadataContentProvider;
import org.talend.repository.model.ProjectRepositoryNode;
import org.talend.repository.model.RepositoryNode;

public class MetadataNuxeoContentProvider extends AbstractMetadataContentProvider {
	
    @Override
    protected RepositoryNode getTopLevelNodeFromProjectRepositoryNode(ProjectRepositoryNode projectNode) {
    	return projectNode.getRootRepositoryNode(NuxeoRepositoryNodeType.repositoryNuxeoType);
    	    	
    }

}
