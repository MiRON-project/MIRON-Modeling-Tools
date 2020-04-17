/**
 */
package miron.metamodel.kernel;

import roqme.metamodel.datatypes.TypedVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.VariationPoint#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.kernel.KernelPackage#getVariationPoint()
 * @model
 * @generated
 */
public interface VariationPoint extends TypedVariable {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' containment reference.
	 * @see #setBinding(Binding)
	 * @see miron.metamodel.kernel.KernelPackage#getVariationPoint_Binding()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Binding getBinding();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.VariationPoint#getBinding <em>Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' containment reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(Binding value);

} // VariationPoint
