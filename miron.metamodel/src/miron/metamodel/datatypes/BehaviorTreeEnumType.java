/**
 */
package miron.metamodel.datatypes;

import org.eclipse.emf.common.util.EList;

import roqme.metamodel.datatypes.EnumType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Tree Enum Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.datatypes.BehaviorTreeEnumType#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.datatypes.DatatypesPackage#getBehaviorTreeEnumType()
 * @model
 * @generated
 */
public interface BehaviorTreeEnumType extends EnumType {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link miron.metamodel.datatypes.BehaviorTreeLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see miron.metamodel.datatypes.DatatypesPackage#getBehaviorTreeEnumType_Literals()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<BehaviorTreeLiteral> getLiterals();

} // BehaviorTreeEnumType
