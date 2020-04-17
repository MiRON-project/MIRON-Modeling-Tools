/**
 */
package behaviortree;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decorator Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link behaviortree.DecoratorNode#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see behaviortree.BehaviorTreePackage#getDecoratorNode()
 * @model abstract="true"
 * @generated
 */
public interface DecoratorNode extends TreeNode {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(TreeNode)
	 * @see behaviortree.BehaviorTreePackage#getDecoratorNode_Node()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TreeNode getNode();

	/**
	 * Sets the value of the '{@link behaviortree.DecoratorNode#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(TreeNode value);

} // DecoratorNode
