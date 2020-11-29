/**
 */
package miron.metamodel.kernel;

import org.eclipse.emf.common.util.EList;

import roqme.metamodel.datatypes.Sentence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.Rule#getImplies <em>Implies</em>}</li>
 *   <li>{@link miron.metamodel.kernel.Rule#getName <em>Name</em>}</li>
 *   <li>{@link miron.metamodel.kernel.Rule#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.kernel.KernelPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends Sentence {
	/**
	 * Returns the value of the '<em><b>Implies</b></em>' containment reference list.
	 * The list contents are of type {@link miron.metamodel.kernel.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implies</em>' containment reference list.
	 * @see miron.metamodel.kernel.KernelPackage#getRule_Implies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getImplies();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see miron.metamodel.kernel.KernelPackage#getRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.Rule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Condition)
	 * @see miron.metamodel.kernel.KernelPackage#getRule_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Condition getCondition();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.Rule#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Condition value);

} // Rule
