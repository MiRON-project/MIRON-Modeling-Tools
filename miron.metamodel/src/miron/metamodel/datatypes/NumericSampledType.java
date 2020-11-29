/**
 */
package miron.metamodel.datatypes;

import org.eclipse.emf.common.util.EList;

import roqme.metamodel.datatypes.NumericType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Sampled Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.NumericSampledType#getSamples <em>Samples</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.datatypes.DatatypesPackage#getNumericSampledType()
 * @model
 * @generated
 */
public interface NumericSampledType extends NumericType {
	/**
	 * Returns the value of the '<em><b>Samples</b></em>' containment reference list.
	 * The list contents are of type {@link miron.metamodel.datatypes.SampleValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Samples</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Samples</em>' containment reference list.
	 * @see miron.metamodel.datatypes.DatatypesPackage#getNumericSampledType_Samples()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<SampleValue> getSamples();

} // NumericSampledType
