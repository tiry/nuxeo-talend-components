/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage;

import org.talend.core.model.metadata.builder.connection.impl.ConnectionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl#getHost <em>Host</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl#getRepositoryName <em>Repository Name</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl#getContextPath <em>Context Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NuxeoConnectionImpl extends ConnectionImpl implements NuxeoConnection {
	/**
	 * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected boolean valid = VALID_EDEFAULT;

	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_EDEFAULT = "8080";

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected String host = HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final String PORT_EDEFAULT = "localhost";

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected String port = PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = "Administrator";

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = "Administrator";

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryName() <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryName()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_NAME_EDEFAULT = "default";

	/**
	 * The cached value of the '{@link #getRepositoryName() <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryName()
	 * @generated
	 * @ordered
	 */
	protected String repositoryName = REPOSITORY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getContextPath() <em>Context Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextPath()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_PATH_EDEFAULT = "nuxeo";

	/**
	 * The cached value of the '{@link #getContextPath() <em>Context Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextPath()
	 * @generated
	 * @ordered
	 */
	protected String contextPath = CONTEXT_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuxeoConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NuxeoPackage.Literals.NUXEO_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid(boolean newValid) {
		boolean oldValid = valid;
		valid = newValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.NUXEO_CONNECTION__VALID, oldValid, valid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(String newHost) {
		String oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.NUXEO_CONNECTION__HOST, oldHost, host));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(String newPort) {
		String oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.NUXEO_CONNECTION__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.NUXEO_CONNECTION__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.NUXEO_CONNECTION__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryName() {
		return repositoryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryName(String newRepositoryName) {
		String oldRepositoryName = repositoryName;
		repositoryName = newRepositoryName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.NUXEO_CONNECTION__REPOSITORY_NAME, oldRepositoryName, repositoryName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContextPath() {
		return contextPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextPath(String newContextPath) {
		String oldContextPath = contextPath;
		contextPath = newContextPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.NUXEO_CONNECTION__CONTEXT_PATH, oldContextPath, contextPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NuxeoPackage.NUXEO_CONNECTION__VALID:
				return isValid();
			case NuxeoPackage.NUXEO_CONNECTION__HOST:
				return getHost();
			case NuxeoPackage.NUXEO_CONNECTION__PORT:
				return getPort();
			case NuxeoPackage.NUXEO_CONNECTION__USERNAME:
				return getUsername();
			case NuxeoPackage.NUXEO_CONNECTION__PASSWORD:
				return getPassword();
			case NuxeoPackage.NUXEO_CONNECTION__REPOSITORY_NAME:
				return getRepositoryName();
			case NuxeoPackage.NUXEO_CONNECTION__CONTEXT_PATH:
				return getContextPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NuxeoPackage.NUXEO_CONNECTION__VALID:
				setValid((Boolean)newValue);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__HOST:
				setHost((String)newValue);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__PORT:
				setPort((String)newValue);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__USERNAME:
				setUsername((String)newValue);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__PASSWORD:
				setPassword((String)newValue);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__REPOSITORY_NAME:
				setRepositoryName((String)newValue);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__CONTEXT_PATH:
				setContextPath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NuxeoPackage.NUXEO_CONNECTION__VALID:
				setValid(VALID_EDEFAULT);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__REPOSITORY_NAME:
				setRepositoryName(REPOSITORY_NAME_EDEFAULT);
				return;
			case NuxeoPackage.NUXEO_CONNECTION__CONTEXT_PATH:
				setContextPath(CONTEXT_PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NuxeoPackage.NUXEO_CONNECTION__VALID:
				return valid != VALID_EDEFAULT;
			case NuxeoPackage.NUXEO_CONNECTION__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case NuxeoPackage.NUXEO_CONNECTION__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case NuxeoPackage.NUXEO_CONNECTION__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case NuxeoPackage.NUXEO_CONNECTION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case NuxeoPackage.NUXEO_CONNECTION__REPOSITORY_NAME:
				return REPOSITORY_NAME_EDEFAULT == null ? repositoryName != null : !REPOSITORY_NAME_EDEFAULT.equals(repositoryName);
			case NuxeoPackage.NUXEO_CONNECTION__CONTEXT_PATH:
				return CONTEXT_PATH_EDEFAULT == null ? contextPath != null : !CONTEXT_PATH_EDEFAULT.equals(contextPath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (valid: ");
		result.append(valid);
		result.append(", Host: ");
		result.append(host);
		result.append(", Port: ");
		result.append(port);
		result.append(", Username: ");
		result.append(username);
		result.append(", Password: ");
		result.append(password);
		result.append(", RepositoryName: ");
		result.append(repositoryName);
		result.append(", ContextPath: ");
		result.append(contextPath);
		result.append(')');
		return result.toString();
	}

} //NuxeoConnectionImpl
