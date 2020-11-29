/**
 */
package behaviortree;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link behaviortree.ControlNode#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see behaviortree.BehaviorTreePackage#getControlNode()
 * @model abstract="true"
 * @generated
 */
public interface ControlNode extends TreeNode {
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
	 * @see behaviortree.BehaviorTreePackage#getControlNode_Nodes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TreeNode> getNodes();

} // ControlNode
