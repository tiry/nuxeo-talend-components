package org.nuxeo.talend.extension;

import org.talend.commons.ui.runtime.image.IImage;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.repository.model.RepositoryNode;

public class NuxeoOperationNode extends RepositoryNode {

	protected String label;

	private IImage icon;

	public NuxeoOperationNode(IRepositoryViewObject object,
			RepositoryNode parent, ENodeType type, String label, IImage icon) {
		super(object, parent, type);
		this.label = label;
		this.icon = icon;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public IImage getIcon() {
		return this.icon;
	}

}
