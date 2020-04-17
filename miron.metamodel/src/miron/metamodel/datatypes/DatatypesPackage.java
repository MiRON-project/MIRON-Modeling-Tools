/**
 */
package miron.metamodel.datatypes;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see miron.metamodel.datatypes.DatatypesFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://robmosys.eu/miron/datatypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "miron.datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatatypesPackage eINSTANCE = miron.metamodel.datatypes.impl.DatatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link miron.metamodel.datatypes.impl.BehaviorTreeLiteralImpl <em>Behavior Tree Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.datatypes.impl.BehaviorTreeLiteralImpl
	 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getBehaviorTreeLiteral()
	 * @generated
	 */
	int BEHAVIOR_TREE_LITERAL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL__NAME = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL__NAME;

	/**
	 * The feature id for the '<em><b>Enum Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL__ENUM_TYPE = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL__ENUM_TYPE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL__REFERENCE = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Behavior Tree Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL_FEATURE_COUNT = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Behavior Tree Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL_OPERATION_COUNT = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.datatypes.impl.MironModelImpl <em>Miron Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.datatypes.impl.MironModelImpl
	 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getMironModel()
	 * @generated
	 */
	int MIRON_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIRON_MODEL__DESCRIPTION = roqme.metamodel.datatypes.DatatypesPackage.ROQME_MODEL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIRON_MODEL__NAMESPACE = roqme.metamodel.datatypes.DatatypesPackage.ROQME_MODEL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Data Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIRON_MODEL__DATA_TYPES = roqme.metamodel.datatypes.DatatypesPackage.ROQME_MODEL__DATA_TYPES;

	/**
	 * The feature id for the '<em><b>Sentences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIRON_MODEL__SENTENCES = roqme.metamodel.datatypes.DatatypesPackage.ROQME_MODEL__SENTENCES;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIRON_MODEL__VARIABLES = roqme.metamodel.datatypes.DatatypesPackage.ROQME_MODEL__VARIABLES;

	/**
	 * The number of structural features of the '<em>Miron Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIRON_MODEL_FEATURE_COUNT = roqme.metamodel.datatypes.DatatypesPackage.ROQME_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Miron Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIRON_MODEL_OPERATION_COUNT = roqme.metamodel.datatypes.DatatypesPackage.ROQME_MODEL_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link miron.metamodel.datatypes.BehaviorTreeLiteral <em>Behavior Tree Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Tree Literal</em>'.
	 * @see miron.metamodel.datatypes.BehaviorTreeLiteral
	 * @generated
	 */
	EClass getBehaviorTreeLiteral();

	/**
	 * Returns the meta object for the reference '{@link miron.metamodel.datatypes.BehaviorTreeLiteral#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see miron.metamodel.datatypes.BehaviorTreeLiteral#getReference()
	 * @see #getBehaviorTreeLiteral()
	 * @generated
	 */
	EReference getBehaviorTreeLiteral_Reference();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.datatypes.MironModel <em>Miron Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Miron Model</em>'.
	 * @see miron.metamodel.datatypes.MironModel
	 * @generated
	 */
	EClass getMironModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatatypesFactory getDatatypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.impl.BehaviorTreeLiteralImpl <em>Behavior Tree Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.impl.BehaviorTreeLiteralImpl
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getBehaviorTreeLiteral()
		 * @generated
		 */
		EClass BEHAVIOR_TREE_LITERAL = eINSTANCE.getBehaviorTreeLiteral();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TREE_LITERAL__REFERENCE = eINSTANCE.getBehaviorTreeLiteral_Reference();

		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.impl.MironModelImpl <em>Miron Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.impl.MironModelImpl
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getMironModel()
		 * @generated
		 */
		EClass MIRON_MODEL = eINSTANCE.getMironModel();

	}

} //DatatypesPackage
