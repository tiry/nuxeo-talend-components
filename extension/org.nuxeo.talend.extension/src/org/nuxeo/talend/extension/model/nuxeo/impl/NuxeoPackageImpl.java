/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.nuxeo.talend.extension.model.nuxeo.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.nuxeo.talend.extension.model.nuxeo.AutomationOperation;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnectionItem;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoFactory;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage;

import org.nuxeo.talend.extension.model.nuxeo.NuxeoSchema;
import org.talend.core.model.metadata.builder.connection.ConnectionPackage;

import org.talend.core.model.properties.PropertiesPackage;
import orgomg.cwm.objectmodel.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NuxeoPackageImpl extends EPackageImpl implements NuxeoPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuxeoConnectionItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuxeoConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass automationOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuxeoSchemaEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NuxeoPackageImpl() {
		super(eNS_URI, NuxeoFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link NuxeoPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NuxeoPackage init() {
		if (isInited) return (NuxeoPackage)EPackage.Registry.INSTANCE.getEPackage(NuxeoPackage.eNS_URI);

		// Obtain or create and register package
		NuxeoPackageImpl theNuxeoPackage = (NuxeoPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NuxeoPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NuxeoPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PropertiesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theNuxeoPackage.createPackageContents();

		// Initialize created meta-data
		theNuxeoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNuxeoPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NuxeoPackage.eNS_URI, theNuxeoPackage);
		return theNuxeoPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNuxeoConnectionItem() {
		return nuxeoConnectionItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNuxeoConnection() {
		return nuxeoConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNuxeoConnection_Valid() {
		return (EAttribute)nuxeoConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNuxeoConnection_Host() {
		return (EAttribute)nuxeoConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNuxeoConnection_Port() {
		return (EAttribute)nuxeoConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNuxeoConnection_Username() {
		return (EAttribute)nuxeoConnectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNuxeoConnection_Password() {
		return (EAttribute)nuxeoConnectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNuxeoConnection_RepositoryName() {
		return (EAttribute)nuxeoConnectionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNuxeoConnection_ContextPath() {
		return (EAttribute)nuxeoConnectionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNuxeoConnection_Operations() {
		return (EReference)nuxeoConnectionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutomationOperation() {
		return automationOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutomationOperation_OperationId() {
		return (EAttribute)automationOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutomationOperation_Signature() {
		return (EAttribute)automationOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNuxeoSchema() {
		return nuxeoSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuxeoFactory getNuxeoFactory() {
		return (NuxeoFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		nuxeoConnectionItemEClass = createEClass(NUXEO_CONNECTION_ITEM);

		nuxeoConnectionEClass = createEClass(NUXEO_CONNECTION);
		createEAttribute(nuxeoConnectionEClass, NUXEO_CONNECTION__VALID);
		createEAttribute(nuxeoConnectionEClass, NUXEO_CONNECTION__HOST);
		createEAttribute(nuxeoConnectionEClass, NUXEO_CONNECTION__PORT);
		createEAttribute(nuxeoConnectionEClass, NUXEO_CONNECTION__USERNAME);
		createEAttribute(nuxeoConnectionEClass, NUXEO_CONNECTION__PASSWORD);
		createEAttribute(nuxeoConnectionEClass, NUXEO_CONNECTION__REPOSITORY_NAME);
		createEAttribute(nuxeoConnectionEClass, NUXEO_CONNECTION__CONTEXT_PATH);
		createEReference(nuxeoConnectionEClass, NUXEO_CONNECTION__OPERATIONS);

		automationOperationEClass = createEClass(AUTOMATION_OPERATION);
		createEAttribute(automationOperationEClass, AUTOMATION_OPERATION__OPERATION_ID);
		createEAttribute(automationOperationEClass, AUTOMATION_OPERATION__SIGNATURE);

		nuxeoSchemaEClass = createEClass(NUXEO_SCHEMA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PropertiesPackage thePropertiesPackage = (PropertiesPackage)EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI);
		ConnectionPackage theConnectionPackage = (ConnectionPackage)EPackage.Registry.INSTANCE.getEPackage(ConnectionPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nuxeoConnectionItemEClass.getESuperTypes().add(thePropertiesPackage.getConnectionItem());
		nuxeoConnectionEClass.getESuperTypes().add(theConnectionPackage.getConnection());
		automationOperationEClass.getESuperTypes().add(theConnectionPackage.getAbstractMetadataObject());
		nuxeoSchemaEClass.getESuperTypes().add(thePropertiesPackage.getProperty());

		// Initialize classes and features; add operations and parameters
		initEClass(nuxeoConnectionItemEClass, NuxeoConnectionItem.class, "NuxeoConnectionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nuxeoConnectionEClass, NuxeoConnection.class, "NuxeoConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNuxeoConnection_Valid(), ecorePackage.getEBoolean(), "valid", null, 0, 1, NuxeoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuxeoConnection_Host(), ecorePackage.getEString(), "Host", "localhost", 0, 1, NuxeoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuxeoConnection_Port(), ecorePackage.getEString(), "Port", "8080", 0, 1, NuxeoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuxeoConnection_Username(), ecorePackage.getEString(), "Username", "Administrator", 0, 1, NuxeoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuxeoConnection_Password(), ecorePackage.getEString(), "Password", "Administrator", 0, 1, NuxeoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuxeoConnection_RepositoryName(), ecorePackage.getEString(), "RepositoryName", "default", 0, 1, NuxeoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuxeoConnection_ContextPath(), ecorePackage.getEString(), "ContextPath", "nuxeo", 0, 1, NuxeoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuxeoConnection_Operations(), this.getAutomationOperation(), null, "Operations", null, 0, -1, NuxeoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(automationOperationEClass, AutomationOperation.class, "AutomationOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutomationOperation_OperationId(), theCorePackage.getString(), "operationId", null, 0, 1, AutomationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutomationOperation_Signature(), theCorePackage.getString(), "signature", null, 0, 1, AutomationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuxeoSchemaEClass, NuxeoSchema.class, "NuxeoSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //NuxeoPackageImpl
