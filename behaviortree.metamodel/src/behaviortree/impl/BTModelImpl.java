/**
 */
package behaviortree.impl;

import behaviortree.BTModel;
import behaviortree.BehaviorTree;
import behaviortree.BehaviorTreePackage;
import behaviortree.Import;
import behaviortree.TreeNodesModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BT Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link behaviortree.impl.BTModelImpl#getTrees <em>Trees</em>}</li>
 *   <li>{@link behaviortree.impl.BTModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link behaviortree.impl.BTModelImpl#getMain_tree_to_execute <em>Main tree to execute</em>}</li>
 *   <li>{@link behaviortree.impl.BTModelImpl#getNodesmodel <em>Nodesmodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BTModelImpl extends MinimalEObjectImpl.Container implements BTModel {
	/**
	 * The cached value of the '{@link #getTrees() <em>Trees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrees()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorTree> trees;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;

	/**
	 * The cached value of the '{@link #getMain_tree_to_execute() <em>Main tree to execute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain_tree_to_execute()
	 * @generated
	 * @ordered
	 */
	protected BehaviorTree main_tree_to_execute;

	/**
	 * The cached value of the '{@link #getNodesmodel() <em>Nodesmodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodesmodel()
	 * @generated
	 * @ordered
	 */
	protected TreeNodesModel nodesmodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BTModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BehaviorTreePackage.Literals.BT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviorTree> getTrees() {
		if (trees == null) {
			trees = new EObjectContainmentEList<BehaviorTree>(BehaviorTree.class, this, BehaviorTreePackage.BT_MODEL__TREES);
		}
		return trees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, BehaviorTreePackage.BT_MODEL__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree getMain_tree_to_execute() {
		if (main_tree_to_execute != null && main_tree_to_execute.eIsProxy()) {
			InternalEObject oldMain_tree_to_execute = (InternalEObject)main_tree_to_execute;
			main_tree_to_execute = (BehaviorTree)eResolveProxy(oldMain_tree_to_execute);
			if (main_tree_to_execute != oldMain_tree_to_execute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorTreePackage.BT_MODEL__MAIN_TREE_TO_EXECUTE, oldMain_tree_to_execute, main_tree_to_execute));
			}
		}
		return main_tree_to_execute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree basicGetMain_tree_to_execute() {
		return main_tree_to_execute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMain_tree_to_execute(BehaviorTree newMain_tree_to_execute) {
		BehaviorTree oldMain_tree_to_execute = main_tree_to_execute;
		main_tree_to_execute = newMain_tree_to_execute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorTreePackage.BT_MODEL__MAIN_TREE_TO_EXECUTE, oldMain_tree_to_execute, main_tree_to_execute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeNodesModel getNodesmodel() {
		return nodesmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNodesmodel(TreeNodesModel newNodesmodel, NotificationChain msgs) {
		TreeNodesModel oldNodesmodel = nodesmodel;
		nodesmodel = newNodesmodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorTreePackage.BT_MODEL__NODESMODEL, oldNodesmodel, newNodesmodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodesmodel(TreeNodesModel newNodesmodel) {
		if (newNodesmodel != nodesmodel) {
			NotificationChain msgs = null;
			if (nodesmodel != null)
				msgs = ((InternalEObject)nodesmodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorTreePackage.BT_MODEL__NODESMODEL, null, msgs);
			if (newNodesmodel != null)
				msgs = ((InternalEObject)newNodesmodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorTreePackage.BT_MODEL__NODESMODEL, null, msgs);
			msgs = basicSetNodesmodel(newNodesmodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorTreePackage.BT_MODEL__NODESMODEL, newNodesmodel, newNodesmodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BehaviorTreePackage.BT_MODEL__TREES:
				return ((InternalEList<?>)getTrees()).basicRemove(otherEnd, msgs);
			case BehaviorTreePackage.BT_MODEL__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case BehaviorTreePackage.BT_MODEL__NODESMODEL:
				return basicSetNodesmodel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BehaviorTreePackage.BT_MODEL__TREES:
				return getTrees();
			case BehaviorTreePackage.BT_MODEL__IMPORTS:
				return getImports();
			case BehaviorTreePackage.BT_MODEL__MAIN_TREE_TO_EXECUTE:
				if (resolve) return getMain_tree_to_execute();
				return basicGetMain_tree_to_execute();
			case BehaviorTreePackage.BT_MODEL__NODESMODEL:
				return getNodesmodel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BehaviorTreePackage.BT_MODEL__TREES:
				getTrees().clear();
				getTrees().addAll((Collection<? extends BehaviorTree>)newValue);
				return;
			case BehaviorTreePackage.BT_MODEL__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case BehaviorTreePackage.BT_MODEL__MAIN_TREE_TO_EXECUTE:
				setMain_tree_to_execute((BehaviorTree)newValue);
				return;
			case BehaviorTreePackage.BT_MODEL__NODESMODEL:
				setNodesmodel((TreeNodesModel)newValue);
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
			case BehaviorTreePackage.BT_MODEL__TREES:
				getTrees().clear();
				return;
			case BehaviorTreePackage.BT_MODEL__IMPORTS:
				getImports().clear();
				return;
			case BehaviorTreePackage.BT_MODEL__MAIN_TREE_TO_EXECUTE:
				setMain_tree_to_execute((BehaviorTree)null);
				return;
			case BehaviorTreePackage.BT_MODEL__NODESMODEL:
				setNodesmodel((TreeNodesModel)null);
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
			case BehaviorTreePackage.BT_MODEL__TREES:
				return trees != null && !trees.isEmpty();
			case BehaviorTreePackage.BT_MODEL__IMPORTS:
				return imports != null && !imports.isEmpty();
			case BehaviorTreePackage.BT_MODEL__MAIN_TREE_TO_EXECUTE:
				return main_tree_to_execute != null;
			case BehaviorTreePackage.BT_MODEL__NODESMODEL:
				return nodesmodel != null;
		}
		return super.eIsSet(featureID);
	}

} //BTModelImpl
