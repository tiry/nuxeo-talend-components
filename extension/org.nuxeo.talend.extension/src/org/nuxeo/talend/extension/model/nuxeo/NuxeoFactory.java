/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage
 * @generated
 */
public interface NuxeoFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NuxeoFactory eINSTANCE = org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Connection Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Item</em>'.
	 * @generated
	 */
	NuxeoConnectionItem createNuxeoConnectionItem();

	/**
	 * Returns a new object of class '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection</em>'.
	 * @generated
	 */
	NuxeoConnection createNuxeoConnection();

	/**
	 * Returns a new object of class '<em>Automation Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Automation Operation</em>'.
	 * @generated
	 */
	AutomationOperation createAutomationOperation();

	/**
	 * Returns a new object of class '<em>Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schema</em>'.
	 * @generated
	 */
	NuxeoSchema createNuxeoSchema();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NuxeoPackage getNuxeoPackage();

} //NuxeoFactory
