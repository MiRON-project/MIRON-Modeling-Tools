/**
 */
package miron.metamodel.datatypes;

import org.eclipse.emf.ecore.EObject;

import roqme.metamodel.kernel.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact On Quality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.ImpactOnQuality#getProperty <em>Property</em>}</li>
 *   <li>{@link miron.metamodel.datatypes.ImpactOnQuality#getIntensity <em>Intensity</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.datatypes.DatatypesPackage#getImpactOnQuality()
 * @model
 * @generated
 */
public interface ImpactOnQuality extends EObject {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(Property)
	 * @see miron.metamodel.datatypes.DatatypesPackage#getImpactOnQuality_Property()
	 * @model required="true"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link miron.metamodel.datatypes.ImpactOnQuality#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Intensity</b></em>' attribute.
	 * The default value is <code>"NEUTRAL"</code>.
	 * The literals are from the enumeration {@link miron.metamodel.datatypes.ImpactIntensityEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intensity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intensity</em>' attribute.
	 * @see miron.metamodel.datatypes.ImpactIntensityEnum
	 * @see #setIntensity(ImpactIntensityEnum)
	 * @see miron.metamodel.datatypes.DatatypesPackage#getImpactOnQuality_Intensity()
	 * @model default="NEUTRAL" required="true"
	 * @generated
	 */
	ImpactIntensityEnum getIntensity();

	/**
	 * Sets the value of the '{@link miron.metamodel.datatypes.ImpactOnQuality#getIntensity <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intensity</em>' attribute.
	 * @see miron.metamodel.datatypes.ImpactIntensityEnum
	 * @see #getIntensity()
	 * @generated
	 */
	void setIntensity(ImpactIntensityEnum value);

} // ImpactOnQuality
