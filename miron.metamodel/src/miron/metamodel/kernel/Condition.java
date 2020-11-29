/**
 */
package miron.metamodel.kernel;

import org.eclipse.emf.ecore.EObject;

import roqme.metamodel.expressions.Term;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.Condition#getTerm <em>Term</em>}</li>
 * </ul>
 *
 * @see miron.metamodel.kernel.KernelPackage#getCondition()
 * @model
 * @generated
 */
public interface Condition extends EObject {
	/**
	 * Returns the value of the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' containment reference.
	 * @see #setTerm(Term)
	 * @see miron.metamodel.kernel.KernelPackage#getCondition_Term()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getTerm();

	/**
	 * Sets the value of the '{@link miron.metamodel.kernel.Condition#getTerm <em>Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' containment reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Term value);

} // Condition
