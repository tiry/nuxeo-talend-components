package org.nuxeo.talend.extension;

import org.nuxeo.talend.extension.wizard.Messages;
import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.IImage;
import org.talend.core.repository.IExtendRepositoryNode;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.StableRepositoryNode;

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
		
		//RepositoryNode folderNode1 = new StableRepositoryNode(this,
		//		Messages.getString("title1"), ECoreImage.FOLDER_CLOSE_ICON);
		
		
	    return new RepositoryNode[0];
	}

}
