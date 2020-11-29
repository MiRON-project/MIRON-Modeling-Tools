/**
 */
package miron.metamodel.kernel.impl;

import miron.metamodel.kernel.Binding;
import miron.metamodel.kernel.KernelPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class BindingImpl extends MinimalEObjectImpl.Container implements Binding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.BINDING;
	}

} //BindingImpl
