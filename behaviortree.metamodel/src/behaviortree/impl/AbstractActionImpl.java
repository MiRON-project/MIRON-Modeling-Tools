/**
 */
package behaviortree.impl;

import behaviortree.AbstractAction;
import behaviortree.BehaviorTreePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class AbstractActionImpl extends LeafNodeImpl implements AbstractAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorTreePackage.Literals.ABSTRACT_ACTION;
	}

} //AbstractActionImpl
