/**
 */
package miron.metamodel.datatypes.impl;

import java.util.Collection;

import miron.metamodel.datatypes.DatatypesPackage;
import miron.metamodel.datatypes.ImpactOnQuality;
import miron.metamodel.datatypes.QoSProfiledValue;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qo SProfiled Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.impl.QoSProfiledValueImpl#getImpacts <em>Impacts</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class QoSProfiledValueImpl extends MinimalEObjectImpl.Container implements QoSProfiledValue {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QoSProfiledValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.QO_SPROFILED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImpactOnQuality> getImpacts() {
		if (impacts == null) {
			impacts = new EObjectContainmentEList<ImpactOnQuality>(ImpactOnQuality.class, this, DatatypesPackage.QO_SPROFILED_VALUE__IMPACTS);
		}
		return impacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatatypesPackage.QO_SPROFILED_VALUE__IMPACTS:
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
			case DatatypesPackage.QO_SPROFILED_VALUE__IMPACTS:
				return getImpacts();
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
			case DatatypesPackage.QO_SPROFILED_VALUE__IMPACTS:
				getImpacts().clear();
				getImpacts().addAll((Collection<? extends ImpactOnQuality>)newValue);
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
			case DatatypesPackage.QO_SPROFILED_VALUE__IMPACTS:
				getImpacts().clear();
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
			case DatatypesPackage.QO_SPROFILED_VALUE__IMPACTS:
				return impacts != null && !impacts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QoSProfiledValueImpl
