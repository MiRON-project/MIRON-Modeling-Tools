/**
 */
package behaviortree.impl;

import behaviortree.BehaviorTree;
import behaviortree.BehaviorTreePackage;
import behaviortree.SubtreeNode;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subtree Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link behaviortree.impl.SubtreeNodeImpl#getBehaviortree <em>Behaviortree</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SubtreeNodeImpl extends TreeNodeImpl implements SubtreeNode {
	/**
	 * The cached value of the '{@link #getBehaviortree() <em>Behaviortree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviortree()
	 * @generated
	 * @ordered
	 */
	protected BehaviorTree behaviortree;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubtreeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorTreePackage.Literals.SUBTREE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree getBehaviortree() {
		if (behaviortree != null && behaviortree.eIsProxy()) {
			InternalEObject oldBehaviortree = (InternalEObject)behaviortree;
			behaviortree = (BehaviorTree)eResolveProxy(oldBehaviortree);
			if (behaviortree != oldBehaviortree) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorTreePackage.SUBTREE_NODE__BEHAVIORTREE, oldBehaviortree, behaviortree));
			}
		}
		return behaviortree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree basicGetBehaviortree() {
		return behaviortree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviortree(BehaviorTree newBehaviortree) {
		BehaviorTree oldBehaviortree = behaviortree;
		behaviortree = newBehaviortree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorTreePackage.SUBTREE_NODE__BEHAVIORTREE, oldBehaviortree, behaviortree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviorTreePackage.SUBTREE_NODE__BEHAVIORTREE:
				if (resolve) return getBehaviortree();
				return basicGetBehaviortree();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BehaviorTreePackage.SUBTREE_NODE__BEHAVIORTREE:
				setBehaviortree((BehaviorTree)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BehaviorTreePackage.SUBTREE_NODE__BEHAVIORTREE:
				setBehaviortree((BehaviorTree)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BehaviorTreePackage.SUBTREE_NODE__BEHAVIORTREE:
				return behaviortree != null;
		}
		return super.eIsSet(featureID);
	}

} //SubtreeNodeImpl
