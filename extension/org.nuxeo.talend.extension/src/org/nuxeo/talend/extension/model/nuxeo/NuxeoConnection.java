/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo;

import org.talend.core.model.metadata.builder.connection.Connection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#isValid <em>Valid</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getHost <em>Host</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getPort <em>Port</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getUsername <em>Username</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getPassword <em>Password</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getRepositoryName <em>Repository Name</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getContextPath <em>Context Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getNuxeoConnection()
 * @model
 * @generated
 */
public interface NuxeoConnection extends Connection {
	/**
	 * Returns the value of the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid</em>' attribute.
	 * @see #setValid(boolean)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getNuxeoConnection_Valid()
	 * @model
	 * @generated
	 */
	boolean isValid();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#isValid <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' attribute.
	 * @see #isValid()
	 * @generated
	 */
	void setValid(boolean value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * The default value is <code>"localhost"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getNuxeoConnection_Host()
	 * @model default="localhost"
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * The default value is <code>"8080"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getNuxeoConnection_Port()
	 * @model default="8080"
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * The default value is <code>"Administrator"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getNuxeoConnection_Username()
	 * @model default="Administrator"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * The default value is <code>"Administrator"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getNuxeoConnection_Password()
	 * @model default="Administrator"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Repository Name</b></em>' attribute.
	 * The default value is <code>"default"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Name</em>' attribute.
	 * @see #setRepositoryName(String)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getNuxeoConnection_RepositoryName()
	 * @model default="default"
	 * @generated
	 */
	String getRepositoryName();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getRepositoryName <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Name</em>' attribute.
	 * @see #getRepositoryName()
	 * @generated
	 */
	void setRepositoryName(String value);

	/**
	 * Returns the value of the '<em><b>Context Path</b></em>' attribute.
	 * The default value is <code>"nuxeo"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Path</em>' attribute.
	 * @see #setContextPath(String)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getNuxeoConnection_ContextPath()
	 * @model default="nuxeo"
	 * @generated
	 */
	String getContextPath();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getContextPath <em>Context Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Path</em>' attribute.
	 * @see #getContextPath()
	 * @generated
	 */
	void setContextPath(String value);

} // NuxeoConnection
