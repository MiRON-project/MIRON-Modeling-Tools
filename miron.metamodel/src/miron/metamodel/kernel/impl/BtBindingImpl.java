/**
 */
package miron.metamodel.kernel.impl;

import java.util.Collection;

import miron.metamodel.kernel.BtBinding;
import miron.metamodel.kernel.InsertionTypeEnum;
import miron.metamodel.kernel.KernelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bt Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.impl.BtBindingImpl#getXpath <em>Xpath</em>}</li>
 *   <li>{@link miron.metamodel.kernel.impl.BtBindingImpl#getInsertionType <em>Insertion Type</em>}</li>
 *   <li>{@link miron.metamodel.kernel.impl.BtBindingImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BtBindingImpl extends BindingImpl implements BtBinding {
	/**
	 * The default value of the '{@link #getXpath() <em>Xpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpath()
	 * @generated
	 * @ordered
	 */
	protected static final String XPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXpath() <em>Xpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpath()
	 * @generated
	 * @ordered
	 */
	protected String xpath = XPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getInsertionType() <em>Insertion Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsertionType()
	 * @generated
	 * @ordered
	 */
	protected static final InsertionTypeEnum INSERTION_TYPE_EDEFAULT = InsertionTypeEnum.IN;

	/**
	 * The cached value of the '{@link #getInsertionType() <em>Insertion Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsertionType()
	 * @generated
	 * @ordered
	 */
	protected InsertionTypeEnum insertionType = INSERTION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> targets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BtBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.BT_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXpath(String newXpath) {
		String oldXpath = xpath;
		xpath = newXpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.BT_BINDING__XPATH, oldXpath, xpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InsertionTypeEnum getInsertionType() {
		return insertionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsertionType(InsertionTypeEnum newInsertionType) {
		InsertionTypeEnum oldInsertionType = insertionType;
		insertionType = newInsertionType == null ? INSERTION_TYPE_EDEFAULT : newInsertionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.BT_BINDING__INSERTION_TYPE, oldInsertionType, insertionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getTargets() {
		if (targets == null) {
			targets = new EObjectResolvingEList<EObject>(EObject.class, this, KernelPackage.BT_BINDING__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KernelPackage.BT_BINDING__XPATH:
				return getXpath();
			case KernelPackage.BT_BINDING__INSERTION_TYPE:
				return getInsertionType();
			case KernelPackage.BT_BINDING__TARGETS:
				return getTargets();
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
			case KernelPackage.BT_BINDING__XPATH:
				setXpath((String)newValue);
				return;
			case KernelPackage.BT_BINDING__INSERTION_TYPE:
				setInsertionType((InsertionTypeEnum)newValue);
				return;
			case KernelPackage.BT_BINDING__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends EObject>)newValue);
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
			case KernelPackage.BT_BINDING__XPATH:
				setXpath(XPATH_EDEFAULT);
				return;
			case KernelPackage.BT_BINDING__INSERTION_TYPE:
				setInsertionType(INSERTION_TYPE_EDEFAULT);
				return;
			case KernelPackage.BT_BINDING__TARGETS:
				getTargets().clear();
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
			case KernelPackage.BT_BINDING__XPATH:
				return XPATH_EDEFAULT == null ? xpath != null : !XPATH_EDEFAULT.equals(xpath);
			case KernelPackage.BT_BINDING__INSERTION_TYPE:
				return insertionType != INSERTION_TYPE_EDEFAULT;
			case KernelPackage.BT_BINDING__TARGETS:
				return targets != null && !targets.isEmpty();
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
		result.append(" (xpath: ");
		result.append(xpath);
		result.append(", insertionType: ");
		result.append(insertionType);
		result.append(')');
		return result.toString();
	}

} //BtBindingImpl
