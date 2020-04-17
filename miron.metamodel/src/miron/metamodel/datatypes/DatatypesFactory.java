/**
 */
package miron.metamodel.datatypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see miron.metamodel.datatypes.DatatypesPackage
 * @generated
 */
public interface DatatypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatatypesFactory eINSTANCE = miron.metamodel.datatypes.impl.DatatypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Behavior Tree Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Tree Literal</em>'.
	 * @generated
	 */
	BehaviorTreeLiteral createBehaviorTreeLiteral();

	/**
	 * Returns a new object of class '<em>Miron Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Miron Model</em>'.
	 * @generated
	 */
	MironModel createMironModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DatatypesPackage getDatatypesPackage();

} //DatatypesFactory
