package org.nuxeo.talend.extension;

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.repository.metadata.tester.CoMetadataNodeTester;

public class NuxeoMetadataNodeTester extends CoMetadataNodeTester {

    private static final String IS_NUXEO = "isNuxeo";

    @Override
    protected ERepositoryObjectType findType(String property) {
        if (IS_NUXEO.equals(property)) {
            return NuxeoRepositoryNodeType.repositoryNuxeoType;
        }
        return null;
    }
}
