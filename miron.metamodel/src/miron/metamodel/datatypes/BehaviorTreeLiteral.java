/**
 */
package miron.metamodel.datatypes;

import behaviortree.BehaviorTree;

import roqme.metamodel.datatypes.EnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Tree Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.BehaviorTreeLiteral#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.datatypes.DatatypesPackage#getBehaviorTreeLiteral()
 * @model
 * @generated
 */
public interface BehaviorTreeLiteral extends EnumLiteral {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(BehaviorTree)
	 * @see miron.metamodel.datatypes.DatatypesPackage#getBehaviorTreeLiteral_Reference()
	 * @model required="true"
	 * @generated
	 */
	BehaviorTree getReference();

	/**
	 * Sets the value of the '{@link miron.metamodel.datatypes.BehaviorTreeLiteral#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(BehaviorTree value);

} // BehaviorTreeLiteral
