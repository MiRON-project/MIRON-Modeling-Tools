/**
 */
package miron.metamodel.kernel.impl;

import miron.metamodel.kernel.ArchBinding;
import miron.metamodel.kernel.KernelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arch Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link miron.metamodel.kernel.impl.ArchBindingImpl#getParameterSetRepository <em>Parameter Set Repository</em>}</li>
 *   <li>{@link miron.metamodel.kernel.impl.ArchBindingImpl#getParameterSet <em>Parameter Set</em>}</li>
 *   <li>{@link miron.metamodel.kernel.impl.ArchBindingImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link miron.metamodel.kernel.impl.ArchBindingImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArchBindingImpl extends BindingImpl implements ArchBinding {
	/**
	 * The default value of the '{@link #getParameterSetRepository() <em>Parameter Set Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterSetRepository()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_SET_REPOSITORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterSetRepository() <em>Parameter Set Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterSetRepository()
	 * @generated
	 * @ordered
	 */
	protected String parameterSetRepository = PARAMETER_SET_REPOSITORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getParameterSet() <em>Parameter Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterSet()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterSet() <em>Parameter Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterSet()
	 * @generated
	 * @ordered
	 */
	protected String parameterSet = PARAMETER_SET_EDEFAULT;

	/**
	 * The default value of the '{@link #getComponent() <em>Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected String component = COMPONENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected String parameter = PARAMETER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.ARCH_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterSetRepository() {
		return parameterSetRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterSetRepository(String newParameterSetRepository) {
		String oldParameterSetRepository = parameterSetRepository;
		parameterSetRepository = newParameterSetRepository;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.ARCH_BINDING__PARAMETER_SET_REPOSITORY, oldParameterSetRepository, parameterSetRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterSet() {
		return parameterSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterSet(String newParameterSet) {
		String oldParameterSet = parameterSet;
		parameterSet = newParameterSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.ARCH_BINDING__PARAMETER_SET, oldParameterSet, parameterSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(String newComponent) {
		String oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.ARCH_BINDING__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(String newParameter) {
		String oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.ARCH_BINDING__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KernelPackage.ARCH_BINDING__PARAMETER_SET_REPOSITORY:
				return getParameterSetRepository();
			case KernelPackage.ARCH_BINDING__PARAMETER_SET:
				return getParameterSet();
			case KernelPackage.ARCH_BINDING__COMPONENT:
				return getComponent();
			case KernelPackage.ARCH_BINDING__PARAMETER:
				return getParameter();
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
			case KernelPackage.ARCH_BINDING__PARAMETER_SET_REPOSITORY:
				setParameterSetRepository((String)newValue);
				return;
			case KernelPackage.ARCH_BINDING__PARAMETER_SET:
				setParameterSet((String)newValue);
				return;
			case KernelPackage.ARCH_BINDING__COMPONENT:
				setComponent((String)newValue);
				return;
			case KernelPackage.ARCH_BINDING__PARAMETER:
				setParameter((String)newValue);
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
			case KernelPackage.ARCH_BINDING__PARAMETER_SET_REPOSITORY:
				setParameterSetRepository(PARAMETER_SET_REPOSITORY_EDEFAULT);
				return;
			case KernelPackage.ARCH_BINDING__PARAMETER_SET:
				setParameterSet(PARAMETER_SET_EDEFAULT);
				return;
			case KernelPackage.ARCH_BINDING__COMPONENT:
				setComponent(COMPONENT_EDEFAULT);
				return;
			case KernelPackage.ARCH_BINDING__PARAMETER:
				setParameter(PARAMETER_EDEFAULT);
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
			case KernelPackage.ARCH_BINDING__PARAMETER_SET_REPOSITORY:
				return PARAMETER_SET_REPOSITORY_EDEFAULT == null ? parameterSetRepository != null : !PARAMETER_SET_REPOSITORY_EDEFAULT.equals(parameterSetRepository);
			case KernelPackage.ARCH_BINDING__PARAMETER_SET:
				return PARAMETER_SET_EDEFAULT == null ? parameterSet != null : !PARAMETER_SET_EDEFAULT.equals(parameterSet);
			case KernelPackage.ARCH_BINDING__COMPONENT:
				return COMPONENT_EDEFAULT == null ? component != null : !COMPONENT_EDEFAULT.equals(component);
			case KernelPackage.ARCH_BINDING__PARAMETER:
				return PARAMETER_EDEFAULT == null ? parameter != null : !PARAMETER_EDEFAULT.equals(parameter);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (parameterSetRepository: ");
		result.append(parameterSetRepository);
		result.append(", parameterSet: ");
		result.append(parameterSet);
		result.append(", component: ");
		result.append(component);
		result.append(", parameter: ");
		result.append(parameter);
		result.append(')');
		return result.toString();
	}

} //ArchBindingImpl
