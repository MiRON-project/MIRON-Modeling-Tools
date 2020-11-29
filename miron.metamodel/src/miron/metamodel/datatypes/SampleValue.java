/**
 */
package miron.metamodel.datatypes;

import roqme.metamodel.datatypes.NumericValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sample Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.SampleValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.datatypes.DatatypesPackage#getSampleValue()
 * @model
 * @generated
 */
public interface SampleValue extends QoSProfiledValue {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(NumericValue)
	 * @see miron.metamodel.datatypes.DatatypesPackage#getSampleValue_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NumericValue getValue();

	/**
	 * Sets the value of the '{@link miron.metamodel.datatypes.SampleValue#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(NumericValue value);

} // SampleValue
