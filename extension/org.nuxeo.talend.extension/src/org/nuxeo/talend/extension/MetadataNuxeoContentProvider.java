// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
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
