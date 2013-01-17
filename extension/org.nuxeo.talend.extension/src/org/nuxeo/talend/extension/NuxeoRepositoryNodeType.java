package org.nuxeo.talend.extension;

import org.talend.core.model.repository.ERepositoryObjectType;

public class NuxeoRepositoryNodeType {

	 public static final String NUXEO_NODE = "NUXEO"; 

	 public static ERepositoryObjectType repositoryNuxeoType = ERepositoryObjectType.valueOf(ERepositoryObjectType.class,
			 NUXEO_NODE);
}
