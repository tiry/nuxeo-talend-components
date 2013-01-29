package org.nuxeo.talend.extension.nodes;

import java.util.Date;
import java.util.List;

import org.nuxeo.talend.extension.NuxeoRepositoryNodeType;
import org.nuxeo.talend.extension.model.nuxeo.AutomationOperation;
import org.talend.core.model.metadata.builder.connection.AbstractMetadataObject;
import org.talend.core.model.properties.Property;
import org.talend.core.model.properties.User;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ISubRepositoryObject;
import org.talend.cwm.helper.SubItemHelper;
import org.talend.repository.model.ERepositoryStatus;
import org.talend.repository.model.IRepositoryNode;
import orgomg.cwm.objectmodel.core.ModelElement;

public class NuxeoOperationRepositoryObject implements ISubRepositoryObject {

    protected final IRepositoryViewObject viewObject;

    private IRepositoryNode repositoryNode;

    protected final AutomationOperation op;
    
    public IRepositoryViewObject getViewObject() {
        return this.viewObject;
    }

    public NuxeoOperationRepositoryObject(IRepositoryViewObject repObj,
    		AutomationOperation op) {
        this.viewObject = repObj;
        this.op=op;
    }

    @Override
    public Property getProperty() {
        Property property = viewObject.getProperty();
        // update table
        //updateTable(property);
        return property;
    }

    @Override
    public String getVersion() {
        return viewObject.getVersion();
    }

    @Override
    public String getLabel() {
        return op.getOperationId();
    }

    @Override
    public String getId() {
        return op.getOperationId();
    }

    @Override
    public AbstractMetadataObject getAbstractMetadataObject() {
        return op;
    }

    @Override
    public void removeFromParent() {
        return;
    }

    @Override
    public User getAuthor() {
        return viewObject.getAuthor();
    }

    @Override
    public List<IRepositoryViewObject> getChildren() {
        return viewObject.getChildren();
    }

    @Override
    public Date getCreationDate() {
        return viewObject.getCreationDate();
    }

    @Override
    public String getDescription() {
        return viewObject.getDescription();
    }

    @Override
    public ERepositoryStatus getInformationStatus() {
        return viewObject.getInformationStatus();
    }

    @Override
    public Date getModificationDate() {
        return viewObject.getModificationDate();
    }

    @Override
    public String getPath() {
        return viewObject.getPath();
    }

    @Override
    public String getProjectLabel() {
        return viewObject.getProjectLabel();
    }

    @Override
    public String getPurpose() {
        return viewObject.getPurpose();
    }

    @Override
    public IRepositoryNode getRepositoryNode() {
        return this.repositoryNode;
    }

    @Override
    public ERepositoryStatus getRepositoryStatus() {
        return viewObject.getRepositoryStatus();
    }

    @Override
    public String getStatusCode() {
        return viewObject.getStatusCode();
    }

    @Override
    public ERepositoryObjectType getRepositoryObjectType() {
    	return NuxeoRepositoryNodeType.repositoryNuxeoType;        
    }

    @Override
    public boolean isDeleted() {
        return SubItemHelper.isDeleted(op);
    }

    @Override
    public void setRepositoryNode(IRepositoryNode node) {
        this.repositoryNode = node;
    }

    @Override
    public ModelElement getModelElement() {
        return this.op;
    }

    @Override
    public boolean isModified() {
        return viewObject.isModified();
    }

}
