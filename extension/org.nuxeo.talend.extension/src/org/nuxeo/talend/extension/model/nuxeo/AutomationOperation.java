/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo;

import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Automation Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.AutomationOperation#getOperationId <em>Operation Id</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.AutomationOperation#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getAutomationOperation()
 * @model
 * @generated
 */
public interface AutomationOperation extends Item, Property {
	/**
	 * Returns the value of the '<em><b>Operation Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Id</em>' attribute.
	 * @see #setOperationId(String)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getAutomationOperation_OperationId()
	 * @model dataType="orgomg.cwm.objectmodel.core.String"
	 * @generated
	 */
	String getOperationId();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.AutomationOperation#getOperationId <em>Operation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Id</em>' attribute.
	 * @see #getOperationId()
	 * @generated
	 */
	void setOperationId(String value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' attribute.
	 * @see #setSignature(String)
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#getAutomationOperation_Signature()
	 * @model dataType="orgomg.cwm.objectmodel.core.String"
	 * @generated
	 */
	String getSignature();

	/**
	 * Sets the value of the '{@link org.nuxeo.talend.extension.model.nuxeo.AutomationOperation#getSignature <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' attribute.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(String value);

} // AutomationOperation
