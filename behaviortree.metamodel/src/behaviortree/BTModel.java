/**
 */
package behaviortree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BT Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link behaviortree.BTModel#getTrees <em>Trees</em>}</li>
 *   <li>{@link behaviortree.BTModel#getMain_tree_to_execute <em>Main tree to execute</em>}</li>
 *   <li>{@link behaviortree.BTModel#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @see behaviortree.BehaviorTreePackage#getBTModel()
 * @model
 * @generated
 */
public interface BTModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Trees</b></em>' containment reference list.
	 * The list contents are of type {@link behaviortree.BehaviorTree}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trees</em>' containment reference list.
	 * @see behaviortree.BehaviorTreePackage#getBTModel_Trees()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<BehaviorTree> getTrees();

	/**
	 * Returns the value of the '<em><b>Main tree to execute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main tree to execute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main tree to execute</em>' attribute.
	 * @see #setMain_tree_to_execute(String)
	 * @see behaviortree.BehaviorTreePackage#getBTModel_Main_tree_to_execute()
	 * @model
	 * @generated
	 */
	String getMain_tree_to_execute();

	/**
	 * Sets the value of the '{@link behaviortree.BTModel#getMain_tree_to_execute <em>Main tree to execute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main tree to execute</em>' attribute.
	 * @see #getMain_tree_to_execute()
	 * @generated
	 */
	void setMain_tree_to_execute(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link behaviortree.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see behaviortree.BehaviorTreePackage#getBTModel_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

} // BTModel
