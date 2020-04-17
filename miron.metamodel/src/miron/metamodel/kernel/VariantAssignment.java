/**
 */
package miron.metamodel.kernel;

import roqme.metamodel.datatypes.TypedValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variant Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.VariantAssignment#getVariable <em>Variable</em>}</li>
 *   <li>{@link miron.metamodel.kernel.VariantAssignment#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.kernel.KernelPackage#getVariantAssignment()
 * @model
 * @generated
 */
public interface VariantAssignment extends RuleAction {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(VariationPoint)
	 * @see miron.metamodel.kernel.KernelPackage#getVariantAssignment_Variable()
	 * @model required="true"
	 * @generated
	 */
	VariationPoint getVariable();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.VariantAssignment#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariationPoint value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(TypedValue)
	 * @see miron.metamodel.kernel.KernelPackage#getVariantAssignment_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypedValue getValue();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.VariantAssignment#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(TypedValue value);

} // VariantAssignment
