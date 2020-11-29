/**
 */
package miron.metamodel.datatypes.impl;

import java.util.Collection;

import miron.metamodel.datatypes.DatatypesPackage;
import miron.metamodel.datatypes.NumericSampledType;
import miron.metamodel.datatypes.SampleValue;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import roqme.metamodel.datatypes.impl.NumericTypeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numeric Sampled Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.impl.NumericSampledTypeImpl#getSamples <em>Samples</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumericSampledTypeImpl extends NumericTypeImpl implements NumericSampledType {
	/**
	 * The cached value of the '{@link #getSamples() <em>Samples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSamples()
	 * @generated
	 * @ordered
	 */
	protected EList<SampleValue> samples;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericSampledTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.NUMERIC_SAMPLED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SampleValue> getSamples() {
		if (samples == null) {
			samples = new EObjectContainmentEList<SampleValue>(SampleValue.class, this, DatatypesPackage.NUMERIC_SAMPLED_TYPE__SAMPLES);
		}
		return samples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatatypesPackage.NUMERIC_SAMPLED_TYPE__SAMPLES:
				return ((InternalEList<?>)getSamples()).basicRemove(otherEnd, msgs);
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
			case DatatypesPackage.NUMERIC_SAMPLED_TYPE__SAMPLES:
				return getSamples();
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
			case DatatypesPackage.NUMERIC_SAMPLED_TYPE__SAMPLES:
				getSamples().clear();
				getSamples().addAll((Collection<? extends SampleValue>)newValue);
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
			case DatatypesPackage.NUMERIC_SAMPLED_TYPE__SAMPLES:
				getSamples().clear();
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
			case DatatypesPackage.NUMERIC_SAMPLED_TYPE__SAMPLES:
				return samples != null && !samples.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NumericSampledTypeImpl
