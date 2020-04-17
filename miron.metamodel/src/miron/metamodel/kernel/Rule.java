/**
 */
package miron.metamodel.kernel;

import org.eclipse.emf.common.util.EList;

import roqme.metamodel.datatypes.Sentence;

import roqme.metamodel.expressions.ContextPattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.Rule#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link miron.metamodel.kernel.Rule#getActions <em>Actions</em>}</li>
 *   <li>{@link miron.metamodel.kernel.Rule#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.kernel.KernelPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends Sentence {
	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference.
	 * @see #setTrigger(ContextPattern)
	 * @see miron.metamodel.kernel.KernelPackage#getRule_Trigger()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ContextPattern getTrigger();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.Rule#getTrigger <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' containment reference.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(ContextPattern value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link miron.metamodel.kernel.RuleAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see miron.metamodel.kernel.KernelPackage#getRule_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuleAction> getActions();

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

} // Rule
