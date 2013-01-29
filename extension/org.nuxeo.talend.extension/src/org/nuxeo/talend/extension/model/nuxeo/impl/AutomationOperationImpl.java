/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo.impl;

import java.util.Collection;
import java.util.Date;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nuxeo.talend.extension.model.nuxeo.AutomationOperation;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage;

import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.metadata.builder.connection.impl.AbstractMetadataObjectImpl;
import orgomg.cwm.objectmodel.core.impl.ModelElementImpl;
import org.talend.core.model.properties.Information;
import org.talend.core.model.properties.InformationLevel;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.PropertiesPackage;
import org.talend.core.model.properties.Property;
import org.talend.core.model.properties.User;
import org.talend.core.model.properties.impl.AdditionalInfoMapImpl;
import org.talend.core.model.properties.impl.ItemImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Automation Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getOperationId <em>Operation Id</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutomationOperationImpl extends AbstractMetadataObjectImpl implements AutomationOperation {
	/**
	 * The default value of the '{@link #getOperationId() <em>Operation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationId()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationId() <em>Operation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationId()
	 * @generated
	 * @ordered
	 */
	protected String operationId = OPERATION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected String signature = SIGNATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AutomationOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NuxeoPackage.Literals.AUTOMATION_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperationId() {
		return operationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationId(String newOperationId) {
		String oldOperationId = operationId;
		operationId = newOperationId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__OPERATION_ID, oldOperationId, operationId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(String newSignature) {
		String oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__SIGNATURE, oldSignature, signature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NuxeoPackage.AUTOMATION_OPERATION__OPERATION_ID:
				return getOperationId();
			case NuxeoPackage.AUTOMATION_OPERATION__SIGNATURE:
				return getSignature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NuxeoPackage.AUTOMATION_OPERATION__OPERATION_ID:
				setOperationId((String)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__SIGNATURE:
				setSignature((String)newValue);
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
			case NuxeoPackage.AUTOMATION_OPERATION__OPERATION_ID:
				setOperationId(OPERATION_ID_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__SIGNATURE:
				setSignature(SIGNATURE_EDEFAULT);
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
			case NuxeoPackage.AUTOMATION_OPERATION__OPERATION_ID:
				return OPERATION_ID_EDEFAULT == null ? operationId != null : !OPERATION_ID_EDEFAULT.equals(operationId);
			case NuxeoPackage.AUTOMATION_OPERATION__SIGNATURE:
				return SIGNATURE_EDEFAULT == null ? signature != null : !SIGNATURE_EDEFAULT.equals(signature);
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
		result.append(" (operationId: ");
		result.append(operationId);
		result.append(", signature: ");
		result.append(signature);
		result.append(')');
		return result.toString();
	}
	
    public boolean isReadOnly() {
    	return false;
    }

} //AutomationOperationImpl
