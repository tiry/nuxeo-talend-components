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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nuxeo.talend.extension.model.nuxeo.AutomationOperation;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoPackage;

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
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getModificationDate <em>Modification Date</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getInformations <em>Informations</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getMaxInformationLevel <em>Max Information Level</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getOldStatusCode <em>Old Status Code</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getAdditionalProperties <em>Additional Properties</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getOperationId <em>Operation Id</em>}</li>
 *   <li>{@link org.nuxeo.talend.extension.model.nuxeo.impl.AutomationOperationImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutomationOperationImpl extends ItemImpl implements AutomationOperation {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected static final String PURPOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected String purpose = PURPOSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModificationDate() <em>Modification Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date MODIFICATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModificationDate() <em>Modification Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationDate()
	 * @generated
	 * @ordered
	 */
	protected Date modificationDate = MODIFICATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
	protected String statusCode = STATUS_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItem() <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected Item item;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected User author;

	/**
	 * The cached value of the '{@link #getInformations() <em>Informations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInformations()
	 * @generated
	 * @ordered
	 */
	protected EList informations;

	/**
	 * The default value of the '{@link #getMaxInformationLevel() <em>Max Information Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInformationLevel()
	 * @generated
	 * @ordered
	 */
	protected static final InformationLevel MAX_INFORMATION_LEVEL_EDEFAULT = InformationLevel.DEBUG_LITERAL;

	/**
	 * The cached value of the '{@link #getMaxInformationLevel() <em>Max Information Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInformationLevel()
	 * @generated
	 * @ordered
	 */
	protected InformationLevel maxInformationLevel = MAX_INFORMATION_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldStatusCode() <em>Old Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldStatusCode()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_STATUS_CODE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOldStatusCode() <em>Old Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldStatusCode()
	 * @generated
	 * @ordered
	 */
	protected String oldStatusCode = OLD_STATUS_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdditionalProperties() <em>Additional Properties</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalProperties()
	 * @generated
	 * @ordered
	 */
	protected EMap additionalProperties;

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

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
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		String oldPurpose = purpose;
		purpose = newPurpose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__PURPOSE, oldPurpose, purpose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getModificationDate() {
		return modificationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModificationDate(Date newModificationDate) {
		Date oldModificationDate = modificationDate;
		modificationDate = newModificationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__MODIFICATION_DATE, oldModificationDate, modificationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusCode(String newStatusCode) {
		String oldStatusCode = statusCode;
		statusCode = newStatusCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__STATUS_CODE, oldStatusCode, statusCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item getItem() {
		if (item != null && item.eIsProxy()) {
			InternalEObject oldItem = (InternalEObject)item;
			item = (Item)eResolveProxy(oldItem);
			if (item != oldItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuxeoPackage.AUTOMATION_OPERATION__ITEM, oldItem, item));
			}
		}
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item basicGetItem() {
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItem(Item newItem, NotificationChain msgs) {
		Item oldItem = item;
		item = newItem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__ITEM, oldItem, newItem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItem(Item newItem) {
		if (newItem != item) {
			NotificationChain msgs = null;
			if (item != null)
				msgs = ((InternalEObject)item).eInverseRemove(this, PropertiesPackage.ITEM__PROPERTY, Item.class, msgs);
			if (newItem != null)
				msgs = ((InternalEObject)newItem).eInverseAdd(this, PropertiesPackage.ITEM__PROPERTY, Item.class, msgs);
			msgs = basicSetItem(newItem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__ITEM, newItem, newItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getAuthor() {
		if (author != null && author.eIsProxy()) {
			InternalEObject oldAuthor = (InternalEObject)author;
			author = (User)eResolveProxy(oldAuthor);
			if (author != oldAuthor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuxeoPackage.AUTOMATION_OPERATION__AUTHOR, oldAuthor, author));
			}
		}
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(User newAuthor) {
		User oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInformations() {
		if (informations == null) {
			informations = new EObjectContainmentEList<Information>(Information.class, this, NuxeoPackage.AUTOMATION_OPERATION__INFORMATIONS);
		}
		return informations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationLevel getMaxInformationLevel() {
		return maxInformationLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxInformationLevel(InformationLevel newMaxInformationLevel) {
		InformationLevel oldMaxInformationLevel = maxInformationLevel;
		maxInformationLevel = newMaxInformationLevel == null ? MAX_INFORMATION_LEVEL_EDEFAULT : newMaxInformationLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__MAX_INFORMATION_LEVEL, oldMaxInformationLevel, maxInformationLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldStatusCode() {
		return oldStatusCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldStatusCode(String newOldStatusCode) {
		String oldOldStatusCode = oldStatusCode;
		oldStatusCode = newOldStatusCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__OLD_STATUS_CODE, oldOldStatusCode, oldStatusCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getAdditionalProperties() {
		if (additionalProperties == null) {
			additionalProperties = new EcoreEMap<String,String>(PropertiesPackage.Literals.ADDITIONAL_INFO_MAP, AdditionalInfoMapImpl.class, this, NuxeoPackage.AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES);
		}
		return additionalProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuxeoPackage.AUTOMATION_OPERATION__DISPLAY_NAME, oldDisplayName, displayName));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NuxeoPackage.AUTOMATION_OPERATION__ITEM:
				if (item != null)
					msgs = ((InternalEObject)item).eInverseRemove(this, PropertiesPackage.ITEM__PROPERTY, Item.class, msgs);
				return basicSetItem((Item)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NuxeoPackage.AUTOMATION_OPERATION__ITEM:
				return basicSetItem(null, msgs);
			case NuxeoPackage.AUTOMATION_OPERATION__INFORMATIONS:
				return ((InternalEList<?>)getInformations()).basicRemove(otherEnd, msgs);
			case NuxeoPackage.AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES:
				return ((InternalEList<?>)getAdditionalProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NuxeoPackage.AUTOMATION_OPERATION__ID:
				return getId();
			case NuxeoPackage.AUTOMATION_OPERATION__LABEL:
				return getLabel();
			case NuxeoPackage.AUTOMATION_OPERATION__PURPOSE:
				return getPurpose();
			case NuxeoPackage.AUTOMATION_OPERATION__DESCRIPTION:
				return getDescription();
			case NuxeoPackage.AUTOMATION_OPERATION__CREATION_DATE:
				return getCreationDate();
			case NuxeoPackage.AUTOMATION_OPERATION__MODIFICATION_DATE:
				return getModificationDate();
			case NuxeoPackage.AUTOMATION_OPERATION__VERSION:
				return getVersion();
			case NuxeoPackage.AUTOMATION_OPERATION__STATUS_CODE:
				return getStatusCode();
			case NuxeoPackage.AUTOMATION_OPERATION__ITEM:
				if (resolve) return getItem();
				return basicGetItem();
			case NuxeoPackage.AUTOMATION_OPERATION__AUTHOR:
				if (resolve) return getAuthor();
				return basicGetAuthor();
			case NuxeoPackage.AUTOMATION_OPERATION__INFORMATIONS:
				return getInformations();
			case NuxeoPackage.AUTOMATION_OPERATION__MAX_INFORMATION_LEVEL:
				return getMaxInformationLevel();
			case NuxeoPackage.AUTOMATION_OPERATION__OLD_STATUS_CODE:
				return getOldStatusCode();
			case NuxeoPackage.AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES:
				if (coreType) return getAdditionalProperties();
				else return getAdditionalProperties().map();
			case NuxeoPackage.AUTOMATION_OPERATION__DISPLAY_NAME:
				return getDisplayName();
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
			case NuxeoPackage.AUTOMATION_OPERATION__ID:
				setId((String)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__LABEL:
				setLabel((String)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__PURPOSE:
				setPurpose((String)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__MODIFICATION_DATE:
				setModificationDate((Date)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__VERSION:
				setVersion((String)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__STATUS_CODE:
				setStatusCode((String)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__ITEM:
				setItem((Item)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__AUTHOR:
				setAuthor((User)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__INFORMATIONS:
				getInformations().clear();
				getInformations().addAll((Collection<? extends Information>)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__MAX_INFORMATION_LEVEL:
				setMaxInformationLevel((InformationLevel)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__OLD_STATUS_CODE:
				setOldStatusCode((String)newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES:
				((EStructuralFeature.Setting)getAdditionalProperties()).set(newValue);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
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
			case NuxeoPackage.AUTOMATION_OPERATION__ID:
				setId(ID_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__PURPOSE:
				setPurpose(PURPOSE_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__MODIFICATION_DATE:
				setModificationDate(MODIFICATION_DATE_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__STATUS_CODE:
				setStatusCode(STATUS_CODE_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__ITEM:
				setItem((Item)null);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__AUTHOR:
				setAuthor((User)null);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__INFORMATIONS:
				getInformations().clear();
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__MAX_INFORMATION_LEVEL:
				setMaxInformationLevel(MAX_INFORMATION_LEVEL_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__OLD_STATUS_CODE:
				setOldStatusCode(OLD_STATUS_CODE_EDEFAULT);
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES:
				getAdditionalProperties().clear();
				return;
			case NuxeoPackage.AUTOMATION_OPERATION__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
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
			case NuxeoPackage.AUTOMATION_OPERATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NuxeoPackage.AUTOMATION_OPERATION__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case NuxeoPackage.AUTOMATION_OPERATION__PURPOSE:
				return PURPOSE_EDEFAULT == null ? purpose != null : !PURPOSE_EDEFAULT.equals(purpose);
			case NuxeoPackage.AUTOMATION_OPERATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case NuxeoPackage.AUTOMATION_OPERATION__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case NuxeoPackage.AUTOMATION_OPERATION__MODIFICATION_DATE:
				return MODIFICATION_DATE_EDEFAULT == null ? modificationDate != null : !MODIFICATION_DATE_EDEFAULT.equals(modificationDate);
			case NuxeoPackage.AUTOMATION_OPERATION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case NuxeoPackage.AUTOMATION_OPERATION__STATUS_CODE:
				return STATUS_CODE_EDEFAULT == null ? statusCode != null : !STATUS_CODE_EDEFAULT.equals(statusCode);
			case NuxeoPackage.AUTOMATION_OPERATION__ITEM:
				return item != null;
			case NuxeoPackage.AUTOMATION_OPERATION__AUTHOR:
				return author != null;
			case NuxeoPackage.AUTOMATION_OPERATION__INFORMATIONS:
				return informations != null && !informations.isEmpty();
			case NuxeoPackage.AUTOMATION_OPERATION__MAX_INFORMATION_LEVEL:
				return maxInformationLevel != MAX_INFORMATION_LEVEL_EDEFAULT;
			case NuxeoPackage.AUTOMATION_OPERATION__OLD_STATUS_CODE:
				return OLD_STATUS_CODE_EDEFAULT == null ? oldStatusCode != null : !OLD_STATUS_CODE_EDEFAULT.equals(oldStatusCode);
			case NuxeoPackage.AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES:
				return additionalProperties != null && !additionalProperties.isEmpty();
			case NuxeoPackage.AUTOMATION_OPERATION__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Property.class) {
			switch (derivedFeatureID) {
				case NuxeoPackage.AUTOMATION_OPERATION__ID: return PropertiesPackage.PROPERTY__ID;
				case NuxeoPackage.AUTOMATION_OPERATION__LABEL: return PropertiesPackage.PROPERTY__LABEL;
				case NuxeoPackage.AUTOMATION_OPERATION__PURPOSE: return PropertiesPackage.PROPERTY__PURPOSE;
				case NuxeoPackage.AUTOMATION_OPERATION__DESCRIPTION: return PropertiesPackage.PROPERTY__DESCRIPTION;
				case NuxeoPackage.AUTOMATION_OPERATION__CREATION_DATE: return PropertiesPackage.PROPERTY__CREATION_DATE;
				case NuxeoPackage.AUTOMATION_OPERATION__MODIFICATION_DATE: return PropertiesPackage.PROPERTY__MODIFICATION_DATE;
				case NuxeoPackage.AUTOMATION_OPERATION__VERSION: return PropertiesPackage.PROPERTY__VERSION;
				case NuxeoPackage.AUTOMATION_OPERATION__STATUS_CODE: return PropertiesPackage.PROPERTY__STATUS_CODE;
				case NuxeoPackage.AUTOMATION_OPERATION__ITEM: return PropertiesPackage.PROPERTY__ITEM;
				case NuxeoPackage.AUTOMATION_OPERATION__AUTHOR: return PropertiesPackage.PROPERTY__AUTHOR;
				case NuxeoPackage.AUTOMATION_OPERATION__INFORMATIONS: return PropertiesPackage.PROPERTY__INFORMATIONS;
				case NuxeoPackage.AUTOMATION_OPERATION__MAX_INFORMATION_LEVEL: return PropertiesPackage.PROPERTY__MAX_INFORMATION_LEVEL;
				case NuxeoPackage.AUTOMATION_OPERATION__OLD_STATUS_CODE: return PropertiesPackage.PROPERTY__OLD_STATUS_CODE;
				case NuxeoPackage.AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES: return PropertiesPackage.PROPERTY__ADDITIONAL_PROPERTIES;
				case NuxeoPackage.AUTOMATION_OPERATION__DISPLAY_NAME: return PropertiesPackage.PROPERTY__DISPLAY_NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Property.class) {
			switch (baseFeatureID) {
				case PropertiesPackage.PROPERTY__ID: return NuxeoPackage.AUTOMATION_OPERATION__ID;
				case PropertiesPackage.PROPERTY__LABEL: return NuxeoPackage.AUTOMATION_OPERATION__LABEL;
				case PropertiesPackage.PROPERTY__PURPOSE: return NuxeoPackage.AUTOMATION_OPERATION__PURPOSE;
				case PropertiesPackage.PROPERTY__DESCRIPTION: return NuxeoPackage.AUTOMATION_OPERATION__DESCRIPTION;
				case PropertiesPackage.PROPERTY__CREATION_DATE: return NuxeoPackage.AUTOMATION_OPERATION__CREATION_DATE;
				case PropertiesPackage.PROPERTY__MODIFICATION_DATE: return NuxeoPackage.AUTOMATION_OPERATION__MODIFICATION_DATE;
				case PropertiesPackage.PROPERTY__VERSION: return NuxeoPackage.AUTOMATION_OPERATION__VERSION;
				case PropertiesPackage.PROPERTY__STATUS_CODE: return NuxeoPackage.AUTOMATION_OPERATION__STATUS_CODE;
				case PropertiesPackage.PROPERTY__ITEM: return NuxeoPackage.AUTOMATION_OPERATION__ITEM;
				case PropertiesPackage.PROPERTY__AUTHOR: return NuxeoPackage.AUTOMATION_OPERATION__AUTHOR;
				case PropertiesPackage.PROPERTY__INFORMATIONS: return NuxeoPackage.AUTOMATION_OPERATION__INFORMATIONS;
				case PropertiesPackage.PROPERTY__MAX_INFORMATION_LEVEL: return NuxeoPackage.AUTOMATION_OPERATION__MAX_INFORMATION_LEVEL;
				case PropertiesPackage.PROPERTY__OLD_STATUS_CODE: return NuxeoPackage.AUTOMATION_OPERATION__OLD_STATUS_CODE;
				case PropertiesPackage.PROPERTY__ADDITIONAL_PROPERTIES: return NuxeoPackage.AUTOMATION_OPERATION__ADDITIONAL_PROPERTIES;
				case PropertiesPackage.PROPERTY__DISPLAY_NAME: return NuxeoPackage.AUTOMATION_OPERATION__DISPLAY_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", label: ");
		result.append(label);
		result.append(", purpose: ");
		result.append(purpose);
		result.append(", description: ");
		result.append(description);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(", modificationDate: ");
		result.append(modificationDate);
		result.append(", version: ");
		result.append(version);
		result.append(", statusCode: ");
		result.append(statusCode);
		result.append(", maxInformationLevel: ");
		result.append(maxInformationLevel);
		result.append(", oldStatusCode: ");
		result.append(oldStatusCode);
		result.append(", displayName: ");
		result.append(displayName);
		result.append(", operationId: ");
		result.append(operationId);
		result.append(", signature: ");
		result.append(signature);
		result.append(')');
		return result.toString();
	}

} //AutomationOperationImpl
