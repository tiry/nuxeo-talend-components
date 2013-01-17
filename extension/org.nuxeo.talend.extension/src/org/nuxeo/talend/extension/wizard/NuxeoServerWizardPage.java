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
package org.nuxeo.talend.extension.wizard;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.repository.ui.swt.utils.AbstractForm;
import org.talend.repository.ui.wizards.RepositoryWizard;

/**
 * DatabaseWizard present the DatabaseForm. Use to Use to manage the metadata connection. Page allows setting a
 * database.
 */
public class NuxeoServerWizardPage extends WizardPage {

    private ConnectionItem connectionItem;

    private NuxeoServerForm nuxeoServerForm;

    private final String[] existingNames;

    private final boolean isRepositoryObjectEditable;

    /**
     * DatabaseWizardPage constructor.
     * 
     * @param connection
     * @param isRepositoryObjectEditable
     * @param existingNames
     */
    public NuxeoServerWizardPage(ConnectionItem connectionItem, boolean isRepositoryObjectEditable, String[] existingNames) {
        super("wizardPage"); //$NON-NLS-1$
        this.connectionItem = connectionItem;
        this.existingNames = existingNames;
        this.isRepositoryObjectEditable = isRepositoryObjectEditable;
    }

    /**
     * Create the composites, initialize it and add controls.
     * 
     * @see IDialogPage#createControl(Composite)
     */
    @Override
    public void createControl(final Composite parent) {
        boolean isCreation = false;
        if (this.getWizard() instanceof RepositoryWizard) {
            isCreation = ((RepositoryWizard) getWizard()).isCreation();
        }
        nuxeoServerForm = new NuxeoServerForm(parent, connectionItem, existingNames, isCreation);
        nuxeoServerForm.setReadOnly(!isRepositoryObjectEditable);

        AbstractForm.ICheckListener listener = new AbstractForm.ICheckListener() {

            @Override
            public void checkPerformed(final AbstractForm source) {
                if (source.isStatusOnError()) {
                    NuxeoServerWizardPage.this.setPageComplete(false);
                    setErrorMessage(source.getStatus());
                } else {
                    NuxeoServerWizardPage.this.setPageComplete(isRepositoryObjectEditable);
                    setErrorMessage(null);
                    setMessage(source.getStatus(), source.getStatusLevel());
                }
            }
        };
        nuxeoServerForm.setListener(listener);
        setControl(nuxeoServerForm);
        if (connectionItem.getProperty().getLabel() != null && !connectionItem.getProperty().getLabel().equals("")) { //$NON-NLS-1$
            nuxeoServerForm.checkFieldsValue();
        }
    }

   
}
