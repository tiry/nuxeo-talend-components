/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nuxeo.talend.extension.model.nuxeo.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NuxeoFactoryImpl extends EFactoryImpl implements NuxeoFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NuxeoFactory init() {
		try {
			NuxeoFactory theNuxeoFactory = (NuxeoFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.nuxeo.com/talendNuxeo"); 
			if (theNuxeoFactory != null) {
				return theNuxeoFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NuxeoFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuxeoFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NuxeoPackage.NUXEO_CONNECTION_ITEM: return createNuxeoConnectionItem();
			case NuxeoPackage.NUXEO_CONNECTION: return createNuxeoConnection();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuxeoConnectionItem createNuxeoConnectionItem() {
		NuxeoConnectionItemImpl nuxeoConnectionItem = new NuxeoConnectionItemImpl();
		return nuxeoConnectionItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuxeoConnection createNuxeoConnection() {
		NuxeoConnectionImpl nuxeoConnection = new NuxeoConnectionImpl();
		return nuxeoConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuxeoPackage getNuxeoPackage() {
		return (NuxeoPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NuxeoPackage getPackage() {
		return NuxeoPackage.eINSTANCE;
	}

} //NuxeoFactoryImpl
