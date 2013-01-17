package org.nuxeo.talend.extension;

import org.talend.commons.ui.runtime.image.IImage;

public enum ENuxeoImage implements IImage {
    NX_ICON("/icons/nx.png"),     
    ;
    
    private String path;

    ENuxeoImage() {
        this.path = "/icons/nx.png"; 
    }

    ENuxeoImage(String path) {
        this.path = path;
    }


    @Override
    public String getPath() {
        return this.path;
    }

    /**
     * Getter for clazz.
     * 
     * @return the clazz
     */
    @Override
    public Class getLocation() {
        return ENuxeoImage.class;
    }

}
