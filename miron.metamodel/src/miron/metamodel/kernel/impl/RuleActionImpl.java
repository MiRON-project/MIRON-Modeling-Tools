/**
 */
package miron.metamodel.kernel.impl;

import miron.metamodel.kernel.KernelPackage;
import miron.metamodel.kernel.RuleAction;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class RuleActionImpl extends MinimalEObjectImpl.Container implements RuleAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.RULE_ACTION;
	}

} //RuleActionImpl
