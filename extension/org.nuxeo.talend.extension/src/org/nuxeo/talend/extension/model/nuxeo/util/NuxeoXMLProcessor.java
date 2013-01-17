/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NuxeoXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuxeoXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		NuxeoPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the NuxeoResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new NuxeoResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new NuxeoResourceFactoryImpl());
		}
		return registrations;
	}

} //NuxeoXMLProcessor
