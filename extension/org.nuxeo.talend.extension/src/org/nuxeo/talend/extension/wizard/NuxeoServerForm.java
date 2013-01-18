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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.talend.commons.ui.swt.formtools.LabelledText;
import org.talend.core.model.metadata.builder.ConvertionHelper;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.repository.ui.swt.utils.AbstractForm;

public class NuxeoServerForm extends AbstractForm {

	private LabelledText nuxeoLogin;

	private LabelledText nuxeoPassword;

	private LabelledText nuxeoServerPort;

	private LabelledText nuxeoServerHostName;

	public NuxeoServerForm(Composite parent, ConnectionItem connectionItem,
			String[] existingNames, boolean isCreation) {
		super(parent, SWT.NONE, existingNames);
		this.connectionItem = connectionItem;

		setConnectionItem(connectionItem); // must be first.

		this.metadataconnection = ConvertionHelper.convert(getConnection(),
				true);

		setupForm(true);
		GridLayout layout2 = (GridLayout) getLayout();
		layout2.marginHeight = 0;
		setLayout(layout2);
	}

	protected void adaptFormToReadOnly() {
		// TODO Auto-generated method stub
	}

	protected void addFields() {
		Group ftpParameterGroup = new Group(this, SWT.NULL);
		ftpParameterGroup.setText("Server"); //$NON-NLS-1$
		GridLayout layoutGroup = new GridLayout();
		layoutGroup.numColumns = 2;
		ftpParameterGroup.setLayout(layoutGroup);

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		ftpParameterGroup.setLayoutData(gridData);

		nuxeoLogin = new LabelledText(ftpParameterGroup, "Username", true); //$NON-NLS-1$
		nuxeoPassword = new LabelledText(ftpParameterGroup,
				"Password", 1, SWT.BORDER | SWT.PASSWORD); //$NON-NLS-1$
		nuxeoServerHostName = new LabelledText(ftpParameterGroup, "Host", true); //$NON-NLS-1$
		nuxeoServerPort = new LabelledText(ftpParameterGroup, "Port", true); //$NON-NLS-1$        

	}

	protected void addFieldsListeners() {
		nuxeoLogin.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				getConnection().setUsername(nuxeoLogin.getText());
				checkFieldsValue();
			}
		});

		nuxeoPassword.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				getConnection().setPassword(nuxeoPassword.getText());
				checkFieldsValue();
			}
		});
		nuxeoServerPort.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				getConnection().setPort(nuxeoServerPort.getText());
				checkFieldsValue();
			}
		});
		nuxeoServerHostName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				getConnection().setHost(nuxeoServerHostName.getText());
				checkFieldsValue();
			}
		});

	}

	public boolean checkFieldsValue() {
		if (nuxeoServerHostName.getCharCount() == 0) {
			updateStatus(IStatus.ERROR, "Host can not be null!"); //$NON-NLS-1$
			return false;
		}

		if (nuxeoServerPort.getCharCount() == 0) {
			updateStatus(IStatus.ERROR, "Port can not be null!"); //$NON-NLS-1$
			return false;
		}

		if (nuxeoLogin.getCharCount() == 0) {
			updateStatus(IStatus.ERROR, "Username can not be null!"); //$NON-NLS-1$
			return false;
		}

		if (nuxeoPassword.getCharCount() == 0) {
			updateStatus(IStatus.ERROR, "Password can not be null!"); //$NON-NLS-1$
			return false;
		}
		updateStatus(IStatus.OK, null);
		return true;
	}

	protected void initialize() {
		nuxeoLogin.setText(getConnection().getUsername());
		nuxeoPassword.setText(getConnection().getPassword());
		nuxeoServerPort.setText(getConnection().getPort());
		nuxeoServerHostName.setText(getConnection().getHost());
	}

	public void removeHideValue() {
	}

	protected NuxeoConnection getConnection() {
		return (NuxeoConnection) connectionItem.getConnection();
	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);
		checkFieldsValue();
	}

	@Override
	protected void addUtilsButtonListeners() {
		// TODO Auto-generated method stub

	}

}
