/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.talend.core.model.metadata.builder.connection.ConnectionPackage;

import org.talend.core.model.properties.PropertiesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory
 * @model kind="package"
 * @generated
 */
public interface NuxeoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nuxeo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.nuxeo.com/talendNuxeo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nuxeo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NuxeoPackage eINSTANCE = org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionItemImpl <em>Connection Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionItemImpl
	 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl#getNuxeoConnectionItem()
	 * @generated
	 */
	int NUXEO_CONNECTION_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION_ITEM__PROPERTY = PropertiesPackage.CONNECTION_ITEM__PROPERTY;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION_ITEM__STATE = PropertiesPackage.CONNECTION_ITEM__STATE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION_ITEM__PARENT = PropertiesPackage.CONNECTION_ITEM__PARENT;

	/**
	 * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION_ITEM__REFERENCE_RESOURCES = PropertiesPackage.CONNECTION_ITEM__REFERENCE_RESOURCES;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION_ITEM__FILE_EXTENSION = PropertiesPackage.CONNECTION_ITEM__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION_ITEM__CONNECTION = PropertiesPackage.CONNECTION_ITEM__CONNECTION;

	/**
	 * The number of structural features of the '<em>Connection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION_ITEM_FEATURE_COUNT = PropertiesPackage.CONNECTION_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl
	 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl#getNuxeoConnection()
	 * @generated
	 */
	int NUXEO_CONNECTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__NAME = ConnectionPackage.CONNECTION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__VISIBILITY = ConnectionPackage.CONNECTION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__CLIENT_DEPENDENCY = ConnectionPackage.CONNECTION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Supplier Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__SUPPLIER_DEPENDENCY = ConnectionPackage.CONNECTION__SUPPLIER_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__CONSTRAINT = ConnectionPackage.CONNECTION__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__NAMESPACE = ConnectionPackage.CONNECTION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Importer</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__IMPORTER = ConnectionPackage.CONNECTION__IMPORTER;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__STEREOTYPE = ConnectionPackage.CONNECTION__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__TAGGED_VALUE = ConnectionPackage.CONNECTION__TAGGED_VALUE;

	/**
	 * The feature id for the '<em><b>Document</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__DOCUMENT = ConnectionPackage.CONNECTION__DOCUMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__DESCRIPTION = ConnectionPackage.CONNECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Responsible Party</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__RESPONSIBLE_PARTY = ConnectionPackage.CONNECTION__RESPONSIBLE_PARTY;

	/**
	 * The feature id for the '<em><b>Element Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__ELEMENT_NODE = ConnectionPackage.CONNECTION__ELEMENT_NODE;

	/**
	 * The feature id for the '<em><b>Set</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__SET = ConnectionPackage.CONNECTION__SET;

	/**
	 * The feature id for the '<em><b>Rendered Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__RENDERED_OBJECT = ConnectionPackage.CONNECTION__RENDERED_OBJECT;

	/**
	 * The feature id for the '<em><b>Vocabulary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__VOCABULARY_ELEMENT = ConnectionPackage.CONNECTION__VOCABULARY_ELEMENT;

	/**
	 * The feature id for the '<em><b>Measurement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__MEASUREMENT = ConnectionPackage.CONNECTION__MEASUREMENT;

	/**
	 * The feature id for the '<em><b>Change Request</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__CHANGE_REQUEST = ConnectionPackage.CONNECTION__CHANGE_REQUEST;

	/**
	 * The feature id for the '<em><b>Dasdl Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__DASDL_PROPERTY = ConnectionPackage.CONNECTION__DASDL_PROPERTY;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__PROPERTIES = ConnectionPackage.CONNECTION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__ID = ConnectionPackage.CONNECTION__ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__COMMENT = ConnectionPackage.CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__LABEL = ConnectionPackage.CONNECTION__LABEL;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__READ_ONLY = ConnectionPackage.CONNECTION__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Synchronised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__SYNCHRONISED = ConnectionPackage.CONNECTION__SYNCHRONISED;

	/**
	 * The feature id for the '<em><b>Divergency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__DIVERGENCY = ConnectionPackage.CONNECTION__DIVERGENCY;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__OWNED_ELEMENT = ConnectionPackage.CONNECTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Imported Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__IMPORTED_ELEMENT = ConnectionPackage.CONNECTION__IMPORTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Data Manager</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__DATA_MANAGER = ConnectionPackage.CONNECTION__DATA_MANAGER;

	/**
	 * The feature id for the '<em><b>Pathname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__PATHNAME = ConnectionPackage.CONNECTION__PATHNAME;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__MACHINE = ConnectionPackage.CONNECTION__MACHINE;

	/**
	 * The feature id for the '<em><b>Deployed Software System</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__DEPLOYED_SOFTWARE_SYSTEM = ConnectionPackage.CONNECTION__DEPLOYED_SOFTWARE_SYSTEM;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__COMPONENT = ConnectionPackage.CONNECTION__COMPONENT;

	/**
	 * The feature id for the '<em><b>Is Case Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__IS_CASE_SENSITIVE = ConnectionPackage.CONNECTION__IS_CASE_SENSITIVE;

	/**
	 * The feature id for the '<em><b>Client Connection</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__CLIENT_CONNECTION = ConnectionPackage.CONNECTION__CLIENT_CONNECTION;

	/**
	 * The feature id for the '<em><b>Data Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__DATA_PACKAGE = ConnectionPackage.CONNECTION__DATA_PACKAGE;

	/**
	 * The feature id for the '<em><b>Resource Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__RESOURCE_CONNECTION = ConnectionPackage.CONNECTION__RESOURCE_CONNECTION;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__VERSION = ConnectionPackage.CONNECTION__VERSION;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__QUERIES = ConnectionPackage.CONNECTION__QUERIES;

	/**
	 * The feature id for the '<em><b>Context Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__CONTEXT_MODE = ConnectionPackage.CONNECTION__CONTEXT_MODE;

	/**
	 * The feature id for the '<em><b>Context Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__CONTEXT_ID = ConnectionPackage.CONNECTION__CONTEXT_ID;

	/**
	 * The feature id for the '<em><b>Context Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__CONTEXT_NAME = ConnectionPackage.CONNECTION__CONTEXT_NAME;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__VALID = ConnectionPackage.CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__HOST = ConnectionPackage.CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__PORT = ConnectionPackage.CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__USERNAME = ConnectionPackage.CONNECTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__PASSWORD = ConnectionPackage.CONNECTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Repository Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__REPOSITORY_NAME = ConnectionPackage.CONNECTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Context Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION__CONTEXT_PATH = ConnectionPackage.CONNECTION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_CONNECTION_FEATURE_COUNT = ConnectionPackage.CONNECTION_FEATURE_COUNT + 7;


	/**
	 * The meta object id for the '{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl <em>Automation Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl
	 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl#getAutomationOperation()
	 * @generated
	 */
	int AUTOMATION_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__PROPERTY = PropertiesPackage.ITEM__PROPERTY;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__STATE = PropertiesPackage.ITEM__STATE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__PARENT = PropertiesPackage.ITEM__PARENT;

	/**
	 * The feature id for the '<em><b>Reference Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__REFERENCE_RESOURCES = PropertiesPackage.ITEM__REFERENCE_RESOURCES;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__FILE_EXTENSION = PropertiesPackage.ITEM__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__ID = PropertiesPackage.ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__LABEL = PropertiesPackage.ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__PURPOSE = PropertiesPackage.ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__DESCRIPTION = PropertiesPackage.ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__CREATION_DATE = PropertiesPackage.ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Modification Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__MODIFICATION_DATE = PropertiesPackage.ITEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__VERSION = PropertiesPackage.ITEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__STATUS_CODE = PropertiesPackage.ITEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__ITEM = PropertiesPackage.ITEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__AUTHOR = PropertiesPackage.ITEM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Informations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__INFORMATIONS = PropertiesPackage.ITEM_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Max Information Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__MAX_INFORMATION_LEVEL = PropertiesPackage.ITEM_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Old Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__OLD_STATUS_CODE = PropertiesPackage.ITEM_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Additional Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES = PropertiesPackage.ITEM_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__DISPLAY_NAME = PropertiesPackage.ITEM_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Operation Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__OPERATION_ID = PropertiesPackage.ITEM_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION__SIGNATURE = PropertiesPackage.ITEM_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Automation Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATION_OPERATION_FEATURE_COUNT = PropertiesPackage.ITEM_FEATURE_COUNT + 17;


	/**
	 * The meta object id for the '{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoSchemaImpl <em>Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoSchemaImpl
	 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl#getNuxeoSchema()
	 * @generated
	 */
	int NUXEO_SCHEMA = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__ID = PropertiesPackage.PROPERTY__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__LABEL = PropertiesPackage.PROPERTY__LABEL;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__PURPOSE = PropertiesPackage.PROPERTY__PURPOSE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__DESCRIPTION = PropertiesPackage.PROPERTY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__CREATION_DATE = PropertiesPackage.PROPERTY__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Modification Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__MODIFICATION_DATE = PropertiesPackage.PROPERTY__MODIFICATION_DATE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__VERSION = PropertiesPackage.PROPERTY__VERSION;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__STATUS_CODE = PropertiesPackage.PROPERTY__STATUS_CODE;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__ITEM = PropertiesPackage.PROPERTY__ITEM;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__AUTHOR = PropertiesPackage.PROPERTY__AUTHOR;

	/**
	 * The feature id for the '<em><b>Informations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__INFORMATIONS = PropertiesPackage.PROPERTY__INFORMATIONS;

	/**
	 * The feature id for the '<em><b>Max Information Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__MAX_INFORMATION_LEVEL = PropertiesPackage.PROPERTY__MAX_INFORMATION_LEVEL;

	/**
	 * The feature id for the '<em><b>Old Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__OLD_STATUS_CODE = PropertiesPackage.PROPERTY__OLD_STATUS_CODE;

	/**
	 * The feature id for the '<em><b>Additional Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__ADDITIONAL_PROPERTIES = PropertiesPackage.PROPERTY__ADDITIONAL_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA__DISPLAY_NAME = PropertiesPackage.PROPERTY__DISPLAY_NAME;

	/**
	 * The number of structural features of the '<em>Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUXEO_SCHEMA_FEATURE_COUNT = PropertiesPackage.PROPERTY_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem <em>Connection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Item</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem
	 * @generated
	 */
	EClass getNuxeoConnectionItem();

	/**
	 * Returns the meta object for class '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection
	 * @generated
	 */
	EClass getNuxeoConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#isValid <em>Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#isValid()
	 * @see #getNuxeoConnection()
	 * @generated
	 */
	EAttribute getNuxeoConnection_Valid();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getHost()
	 * @see #getNuxeoConnection()
	 * @generated
	 */
	EAttribute getNuxeoConnection_Host();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getPort()
	 * @see #getNuxeoConnection()
	 * @generated
	 */
	EAttribute getNuxeoConnection_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getUsername()
	 * @see #getNuxeoConnection()
	 * @generated
	 */
	EAttribute getNuxeoConnection_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getPassword()
	 * @see #getNuxeoConnection()
	 * @generated
	 */
	EAttribute getNuxeoConnection_Password();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getRepositoryName <em>Repository Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Name</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getRepositoryName()
	 * @see #getNuxeoConnection()
	 * @generated
	 */
	EAttribute getNuxeoConnection_RepositoryName();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getContextPath <em>Context Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Path</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection#getContextPath()
	 * @see #getNuxeoConnection()
	 * @generated
	 */
	EAttribute getNuxeoConnection_ContextPath();

	/**
	 * Returns the meta object for class '{@link org.nuxeo.talend.extension.model.nuxeo.AutomationOperation <em>Automation Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Automation Operation</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.AutomationOperation
	 * @generated
	 */
	EClass getAutomationOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.AutomationOperation#getOperationId <em>Operation Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Id</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.AutomationOperation#getOperationId()
	 * @see #getAutomationOperation()
	 * @generated
	 */
	EAttribute getAutomationOperation_OperationId();

	/**
	 * Returns the meta object for the attribute '{@link org.nuxeo.talend.extension.model.nuxeo.AutomationOperation#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signature</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.AutomationOperation#getSignature()
	 * @see #getAutomationOperation()
	 * @generated
	 */
	EAttribute getAutomationOperation_Signature();

	/**
	 * Returns the meta object for class '{@link org.nuxeo.talend.extension.model.nuxeo.NuxeoSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema</em>'.
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoSchema
	 * @generated
	 */
	EClass getNuxeoSchema();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NuxeoFactory getNuxeoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionItemImpl <em>Connection Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionItemImpl
		 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl#getNuxeoConnectionItem()
		 * @generated
		 */
		EClass NUXEO_CONNECTION_ITEM = eINSTANCE.getNuxeoConnectionItem();

		/**
		 * The meta object literal for the '{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoConnectionImpl
		 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl#getNuxeoConnection()
		 * @generated
		 */
		EClass NUXEO_CONNECTION = eINSTANCE.getNuxeoConnection();

		/**
		 * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUXEO_CONNECTION__VALID = eINSTANCE.getNuxeoConnection_Valid();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUXEO_CONNECTION__HOST = eINSTANCE.getNuxeoConnection_Host();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUXEO_CONNECTION__PORT = eINSTANCE.getNuxeoConnection_Port();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUXEO_CONNECTION__USERNAME = eINSTANCE.getNuxeoConnection_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUXEO_CONNECTION__PASSWORD = eINSTANCE.getNuxeoConnection_Password();

		/**
		 * The meta object literal for the '<em><b>Repository Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUXEO_CONNECTION__REPOSITORY_NAME = eINSTANCE.getNuxeoConnection_RepositoryName();

		/**
		 * The meta object literal for the '<em><b>Context Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUXEO_CONNECTION__CONTEXT_PATH = eINSTANCE.getNuxeoConnection_ContextPath();

		/**
		 * The meta object literal for the '{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl <em>Automation Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl
		 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl#getAutomationOperation()
		 * @generated
		 */
		EClass AUTOMATION_OPERATION = eINSTANCE.getAutomationOperation();

		/**
		 * The meta object literal for the '<em><b>Operation Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMATION_OPERATION__OPERATION_ID = eINSTANCE.getAutomationOperation_OperationId();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMATION_OPERATION__SIGNATURE = eINSTANCE.getAutomationOperation_Signature();

		/**
		 * The meta object literal for the '{@link org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoSchemaImpl <em>Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoSchemaImpl
		 * @see org.nuxeo.talend.extension.model.nuxeo.impl.NuxeoPackageImpl#getNuxeoSchema()
		 * @generated
		 */
		EClass NUXEO_SCHEMA = eINSTANCE.getNuxeoSchema();

	}

} //NuxeoPackage
