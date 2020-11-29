/**
 */
package behaviortree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link behaviortree.BehaviorTree#getNodes <em>Nodes</em>}</li>
 *   <li>{@link behaviortree.BehaviorTree#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see behaviortree.BehaviorTreePackage#getBehaviorTree()
 * @model
 * @generated
 */
public interface BehaviorTree extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link behaviortree.TreeNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see behaviortree.BehaviorTreePackage#getBehaviorTree_Nodes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TreeNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link behaviortree.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see behaviortree.BehaviorTreePackage#getBehaviorTree_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

} // BehaviorTree
