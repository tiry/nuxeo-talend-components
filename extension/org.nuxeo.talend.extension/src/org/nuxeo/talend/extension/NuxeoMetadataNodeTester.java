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

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.repository.metadata.tester.CoMetadataNodeTester;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class NuxeoMetadataNodeTester extends CoMetadataNodeTester {

    private static final String IS_NUXEO = "isNuxeo"; //$NON-NLS-1$

    @Override
    protected ERepositoryObjectType findType(String property) {
        if (IS_NUXEO.equals(property)) {
            return NuxeoRepositoryNodeType.repositoryNuxeoType;
        }
        return null;
    }
}
