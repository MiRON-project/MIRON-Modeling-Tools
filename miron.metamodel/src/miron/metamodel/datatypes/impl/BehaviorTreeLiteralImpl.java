/**
 */
package miron.metamodel.datatypes.impl;

import behaviortree.BehaviorTree;

import java.util.Collection;

import miron.metamodel.datatypes.BehaviorTreeLiteral;
import miron.metamodel.datatypes.DatatypesPackage;
import miron.metamodel.datatypes.ImpactOnQuality;
import miron.metamodel.datatypes.QoSProfiledValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import roqme.metamodel.datatypes.impl.EnumLiteralImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Tree Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.impl.BehaviorTreeLiteralImpl#getImpacts <em>Impacts</em>}</li>
 *   <li>{@link miron.metamodel.datatypes.impl.BehaviorTreeLiteralImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link miron.metamodel.datatypes.impl.BehaviorTreeLiteralImpl#isPreset <em>Preset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorTreeLiteralImpl extends EnumLiteralImpl implements BehaviorTreeLiteral {
	/**
	 * The cached value of the '{@link #getImpacts() <em>Impacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpacts()
	 * @generated
	 * @ordered
	 */
	protected EList<ImpactOnQuality> impacts;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected BehaviorTree reference;

	/**
	 * The default value of the '{@link #isPreset() <em>Preset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPreset()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRESET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPreset() <em>Preset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPreset()
	 * @generated
	 * @ordered
	 */
	protected boolean preset = PRESET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorTreeLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.BEHAVIOR_TREE_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImpactOnQuality> getImpacts() {
		if (impacts == null) {
			impacts = new EObjectContainmentEList<ImpactOnQuality>(ImpactOnQuality.class, this, DatatypesPackage.BEHAVIOR_TREE_LITERAL__IMPACTS);
		}
		return impacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (BehaviorTree)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypesPackage.BEHAVIOR_TREE_LITERAL__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(BehaviorTree newReference) {
		BehaviorTree oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.BEHAVIOR_TREE_LITERAL__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPreset() {
		return preset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreset(boolean newPreset) {
		boolean oldPreset = preset;
		preset = newPreset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.BEHAVIOR_TREE_LITERAL__PRESET, oldPreset, preset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__IMPACTS:
				return ((InternalEList<?>)getImpacts()).basicRemove(otherEnd, msgs);
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
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__IMPACTS:
				return getImpacts();
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__PRESET:
				return isPreset();
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
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__IMPACTS:
				getImpacts().clear();
				getImpacts().addAll((Collection<? extends ImpactOnQuality>)newValue);
				return;
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__REFERENCE:
				setReference((BehaviorTree)newValue);
				return;
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__PRESET:
				setPreset((Boolean)newValue);
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
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__IMPACTS:
				getImpacts().clear();
				return;
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__REFERENCE:
				setReference((BehaviorTree)null);
				return;
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__PRESET:
				setPreset(PRESET_EDEFAULT);
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
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__IMPACTS:
				return impacts != null && !impacts.isEmpty();
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__REFERENCE:
				return reference != null;
			case DatatypesPackage.BEHAVIOR_TREE_LITERAL__PRESET:
				return preset != PRESET_EDEFAULT;
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
		if (baseClass == QoSProfiledValue.class) {
			switch (derivedFeatureID) {
				case DatatypesPackage.BEHAVIOR_TREE_LITERAL__IMPACTS: return DatatypesPackage.QO_SPROFILED_VALUE__IMPACTS;
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
		if (baseClass == QoSProfiledValue.class) {
			switch (baseFeatureID) {
				case DatatypesPackage.QO_SPROFILED_VALUE__IMPACTS: return DatatypesPackage.BEHAVIOR_TREE_LITERAL__IMPACTS;
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
		result.append(" (preset: ");
		result.append(preset);
		result.append(')');
		return result.toString();
	}

} //BehaviorTreeLiteralImpl
