/**
 */
package miron.metamodel.datatypes.impl;

import miron.metamodel.datatypes.DatatypesPackage;
import miron.metamodel.datatypes.ImpactIntensityEnum;
import miron.metamodel.datatypes.ImpactOnQuality;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import roqme.metamodel.kernel.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact On Quality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.impl.ImpactOnQualityImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link miron.metamodel.datatypes.impl.ImpactOnQualityImpl#getIntensity <em>Intensity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImpactOnQualityImpl extends MinimalEObjectImpl.Container implements ImpactOnQuality {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The default value of the '{@link #getIntensity() <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntensity()
	 * @generated
	 * @ordered
	 */
	protected static final ImpactIntensityEnum INTENSITY_EDEFAULT = ImpactIntensityEnum.NEUTRAL;

	/**
	 * The cached value of the '{@link #getIntensity() <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntensity()
	 * @generated
	 * @ordered
	 */
	protected ImpactIntensityEnum intensity = INTENSITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpactOnQualityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.IMPACT_ON_QUALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (Property)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypesPackage.IMPACT_ON_QUALITY__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.IMPACT_ON_QUALITY__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactIntensityEnum getIntensity() {
		return intensity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntensity(ImpactIntensityEnum newIntensity) {
		ImpactIntensityEnum oldIntensity = intensity;
		intensity = newIntensity == null ? INTENSITY_EDEFAULT : newIntensity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.IMPACT_ON_QUALITY__INTENSITY, oldIntensity, intensity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatatypesPackage.IMPACT_ON_QUALITY__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case DatatypesPackage.IMPACT_ON_QUALITY__INTENSITY:
				return getIntensity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DatatypesPackage.IMPACT_ON_QUALITY__PROPERTY:
				setProperty((Property)newValue);
				return;
			case DatatypesPackage.IMPACT_ON_QUALITY__INTENSITY:
				setIntensity((ImpactIntensityEnum)newValue);
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
			case DatatypesPackage.IMPACT_ON_QUALITY__PROPERTY:
				setProperty((Property)null);
				return;
			case DatatypesPackage.IMPACT_ON_QUALITY__INTENSITY:
				setIntensity(INTENSITY_EDEFAULT);
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
			case DatatypesPackage.IMPACT_ON_QUALITY__PROPERTY:
				return property != null;
			case DatatypesPackage.IMPACT_ON_QUALITY__INTENSITY:
				return intensity != INTENSITY_EDEFAULT;
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
		result.append(" (intensity: ");
		result.append(intensity);
		result.append(')');
		return result.toString();
	}

} //ImpactOnQualityImpl
