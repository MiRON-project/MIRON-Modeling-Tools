/**
 */
package behaviortree;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subtree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link behaviortree.SubtreeNode#getBehaviortree <em>Behaviortree</em>}</li>
 * </ul>
 *
 * @see behaviortree.BehaviorTreePackage#getSubtreeNode()
 * @model abstract="true"
 * @generated
 */
public interface SubtreeNode extends TreeNode {
	/**
	 * Returns the value of the '<em><b>Behaviortree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behaviortree</em>' reference.
	 * @see #setBehaviortree(BehaviorTree)
	 * @see behaviortree.BehaviorTreePackage#getSubtreeNode_Behaviortree()
	 * @model required="true"
	 * @generated
	 */
	BehaviorTree getBehaviortree();

	/**
	 * Sets the value of the '{@link behaviortree.SubtreeNode#getBehaviortree <em>Behaviortree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behaviortree</em>' reference.
	 * @see #getBehaviortree()
	 * @generated
	 */
	void setBehaviortree(BehaviorTree value);

} // SubtreeNode
