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
 *   <li>{@link behaviortree.BTModel#getImports <em>Imports</em>}</li>
 *   <li>{@link behaviortree.BTModel#getMain_tree_to_execute <em>Main tree to execute</em>}</li>
 *   <li>{@link behaviortree.BTModel#getNodesmodel <em>Nodesmodel</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Main tree to execute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main tree to execute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main tree to execute</em>' reference.
	 * @see #setMain_tree_to_execute(BehaviorTree)
	 * @see behaviortree.BehaviorTreePackage#getBTModel_Main_tree_to_execute()
	 * @model
	 * @generated
	 */
	BehaviorTree getMain_tree_to_execute();

	/**
	 * Sets the value of the '{@link behaviortree.BTModel#getMain_tree_to_execute <em>Main tree to execute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main tree to execute</em>' reference.
	 * @see #getMain_tree_to_execute()
	 * @generated
	 */
	void setMain_tree_to_execute(BehaviorTree value);

	/**
	 * Returns the value of the '<em><b>Nodesmodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodesmodel</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodesmodel</em>' containment reference.
	 * @see #setNodesmodel(TreeNodesModel)
	 * @see behaviortree.BehaviorTreePackage#getBTModel_Nodesmodel()
	 * @model containment="true"
	 * @generated
	 */
	TreeNodesModel getNodesmodel();

	/**
	 * Sets the value of the '{@link behaviortree.BTModel#getNodesmodel <em>Nodesmodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nodesmodel</em>' containment reference.
	 * @see #getNodesmodel()
	 * @generated
	 */
	void setNodesmodel(TreeNodesModel value);

} // BTModel
