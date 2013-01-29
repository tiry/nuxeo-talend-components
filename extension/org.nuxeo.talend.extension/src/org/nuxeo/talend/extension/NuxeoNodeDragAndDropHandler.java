package org.nuxeo.talend.extension;

import java.util.List;

import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.talend.core.model.components.IComponent;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.process.IElement;
import org.talend.core.model.process.INode;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.utils.IComponentName;
import org.talend.core.model.utils.IDragAndDropServiceHandler;
import org.talend.repository.model.RepositoryNode;

public class NuxeoNodeDragAndDropHandler implements IDragAndDropServiceHandler {

    /**
     * DOC ggu ExampleDemoDragAndDropHandler constructor comment.
     */
    public NuxeoNodeDragAndDropHandler() {
    }

    @Override
    public boolean canHandle(Connection connection) {
        return connection instanceof NuxeoConnection;
    }

    @Override
    public String getComponentValue(Connection connection, String value, IMetadataTable table) {
        if (value != null && canHandle(connection)) {
            NuxeoConnection demoConn = (NuxeoConnection) connection;
/*            if ("TYPE".equals(value)) { //$NON-NLS-1$
                return demoConn.getType();
            } else if ("VALID".equals(value)) { //$NON-NLS-1$
                return Boolean.toString(demoConn.isValid());
            }*/
        }
        return null;
    }

    @Override
    public List<IComponent> filterNeededComponents(Item item, RepositoryNode seletetedNode, ERepositoryObjectType type) {
        // PTODO find the matched components with the item.
        return null;
    }

    @Override
    public IComponentName getCorrespondingComponentName(Item item, ERepositoryObjectType type) {
        // PTODO return the default component
        return null;
    }

    @Override
    public void setComponentValue(Connection connection, INode node, String repositoryValue) {
        if (node != null && canHandle(connection)) {
            NuxeoConnection demoConn = (NuxeoConnection) connection;
            // PTODO get the values from node, and set to the matched attributes(repositoryValue) of connection
        }
    }

    @Override
    public ERepositoryObjectType getType(String repositoryType) {
        // PTODO accordding to the checked type to return real object type.
        if (NuxeoRepositoryNodeType.NUXEO_NODE.equals(repositoryType)) {
            return NuxeoRepositoryNodeType.repositoryNuxeoType;
        }
        return null;
    }

    @Override
    public void handleTableRelevantParameters(IElement ele, IMetadataTable metadataTable) {
    }

}
