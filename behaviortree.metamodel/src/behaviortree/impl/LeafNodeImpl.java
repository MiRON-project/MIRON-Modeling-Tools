/**
 */
package behaviortree.impl;

import behaviortree.BehaviorTreePackage;
import behaviortree.LeafNode;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Leaf Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class LeafNodeImpl extends TreeNodeImpl implements LeafNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorTreePackage.Literals.LEAF_NODE;
	}

} //LeafNodeImpl
