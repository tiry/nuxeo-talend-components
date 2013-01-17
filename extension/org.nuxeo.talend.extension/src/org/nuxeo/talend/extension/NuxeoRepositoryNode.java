package org.nuxeo.talend.extension;

import org.talend.commons.ui.runtime.image.IImage;
import org.talend.core.repository.IExtendRepositoryNode;
import org.talend.repository.model.RepositoryNode;

public class NuxeoRepositoryNode implements IExtendRepositoryNode {

	@Override
	public IImage getNodeImage() {
		return ENuxeoImage.NX_ICON;
	}

	@Override
	public int getOrdinal() {		
		return 0;
	}

	@Override
	public Object[] getChildren() {
	    return new RepositoryNode[0];
	}

}
