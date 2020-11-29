/**
 */
package behaviortree.impl;

import behaviortree.BehaviorTreePackage;
import behaviortree.Timeout;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timeout</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TimeoutImpl extends DecoratorNodeImpl implements Timeout {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorTreePackage.Literals.TIMEOUT;
	}

} //TimeoutImpl
