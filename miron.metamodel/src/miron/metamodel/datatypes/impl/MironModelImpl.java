/**
 */
package miron.metamodel.datatypes.impl;

import miron.metamodel.datatypes.DatatypesPackage;
import miron.metamodel.datatypes.MironModel;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.datatypes.impl.RoqmeModelImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Miron Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MironModelImpl extends RoqmeModelImpl implements MironModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MironModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.MIRON_MODEL;
	}

} //MironModelImpl
