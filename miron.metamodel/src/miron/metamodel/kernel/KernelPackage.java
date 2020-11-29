/**
 */
package miron.metamodel.kernel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import roqme.metamodel.datatypes.DatatypesPackage;

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
 * @see miron.metamodel.kernel.KernelFactory
 * @model kind="package"
 * @generated
 */
public interface KernelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kernel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://robmosys.eu/miron/kernel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "miron.kernel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KernelPackage eINSTANCE = miron.metamodel.kernel.impl.KernelPackageImpl.init();

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.VariationPointImpl <em>Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.VariationPointImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__DESCRIPTION = DatatypesPackage.TYPED_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__NAME = DatatypesPackage.TYPED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__DECLARATION = DatatypesPackage.TYPED_VARIABLE__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__INITIALIZED_TO = DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__BINDING = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_OPERATION_COUNT = DatatypesPackage.TYPED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.BindingImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 6;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.BtBindingImpl <em>Bt Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.BtBindingImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getBtBinding()
	 * @generated
	 */
	int BT_BINDING = 1;

	/**
	 * The feature id for the '<em><b>Xpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_BINDING__XPATH = BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Insertion Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_BINDING__INSERTION_TYPE = BINDING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_BINDING__TARGETS = BINDING_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bt Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Bt Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_BINDING_OPERATION_COUNT = BINDING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.RuleImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__DESCRIPTION = DatatypesPackage.SENTENCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__IMPLIES = DatatypesPackage.SENTENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = DatatypesPackage.SENTENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__CONDITION = DatatypesPackage.SENTENCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = DatatypesPackage.SENTENCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = DatatypesPackage.SENTENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.ConstraintImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TERM = 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.ImportImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__DESCRIPTION = roqme.metamodel.kernel.KernelPackage.IMPORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORT_URI = roqme.metamodel.kernel.KernelPackage.IMPORT__IMPORT_URI;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__ALIAS = roqme.metamodel.kernel.KernelPackage.IMPORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = roqme.metamodel.kernel.KernelPackage.IMPORT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = roqme.metamodel.kernel.KernelPackage.IMPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.ConditionImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 5;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__TERM = 0;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.ArchBindingImpl <em>Arch Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.ArchBindingImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getArchBinding()
	 * @generated
	 */
	int ARCH_BINDING = 7;

	/**
	 * The feature id for the '<em><b>Parameter Set Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCH_BINDING__PARAMETER_SET_REPOSITORY = BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCH_BINDING__PARAMETER_SET = BINDING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCH_BINDING__COMPONENT = BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCH_BINDING__PARAMETER = BINDING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Arch Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCH_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Arch Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCH_BINDING_OPERATION_COUNT = BINDING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.InsertionTypeEnum <em>Insertion Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.InsertionTypeEnum
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getInsertionTypeEnum()
	 * @generated
	 */
	int INSERTION_TYPE_ENUM = 8;


	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see miron.metamodel.kernel.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for the containment reference '{@link miron.metamodel.kernel.VariationPoint#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Binding</em>'.
	 * @see miron.metamodel.kernel.VariationPoint#getBinding()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_Binding();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.BtBinding <em>Bt Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bt Binding</em>'.
	 * @see miron.metamodel.kernel.BtBinding
	 * @generated
	 */
	EClass getBtBinding();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.BtBinding#getXpath <em>Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xpath</em>'.
	 * @see miron.metamodel.kernel.BtBinding#getXpath()
	 * @see #getBtBinding()
	 * @generated
	 */
	EAttribute getBtBinding_Xpath();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.BtBinding#getInsertionType <em>Insertion Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insertion Type</em>'.
	 * @see miron.metamodel.kernel.BtBinding#getInsertionType()
	 * @see #getBtBinding()
	 * @generated
	 */
	EAttribute getBtBinding_InsertionType();

	/**
	 * Returns the meta object for the reference list '{@link miron.metamodel.kernel.BtBinding#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see miron.metamodel.kernel.BtBinding#getTargets()
	 * @see #getBtBinding()
	 * @generated
	 */
	EReference getBtBinding_Targets();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see miron.metamodel.kernel.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference list '{@link miron.metamodel.kernel.Rule#getImplies <em>Implies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implies</em>'.
	 * @see miron.metamodel.kernel.Rule#getImplies()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Implies();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.Rule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see miron.metamodel.kernel.Rule#getName()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link miron.metamodel.kernel.Rule#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see miron.metamodel.kernel.Rule#getCondition()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Condition();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see miron.metamodel.kernel.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link miron.metamodel.kernel.Constraint#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see miron.metamodel.kernel.Constraint#getTerm()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Term();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see miron.metamodel.kernel.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.Import#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see miron.metamodel.kernel.Import#getAlias()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Alias();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see miron.metamodel.kernel.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the containment reference '{@link miron.metamodel.kernel.Condition#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see miron.metamodel.kernel.Condition#getTerm()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Term();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see miron.metamodel.kernel.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.ArchBinding <em>Arch Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arch Binding</em>'.
	 * @see miron.metamodel.kernel.ArchBinding
	 * @generated
	 */
	EClass getArchBinding();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.ArchBinding#getParameterSetRepository <em>Parameter Set Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Set Repository</em>'.
	 * @see miron.metamodel.kernel.ArchBinding#getParameterSetRepository()
	 * @see #getArchBinding()
	 * @generated
	 */
	EAttribute getArchBinding_ParameterSetRepository();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.ArchBinding#getParameterSet <em>Parameter Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Set</em>'.
	 * @see miron.metamodel.kernel.ArchBinding#getParameterSet()
	 * @see #getArchBinding()
	 * @generated
	 */
	EAttribute getArchBinding_ParameterSet();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.ArchBinding#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component</em>'.
	 * @see miron.metamodel.kernel.ArchBinding#getComponent()
	 * @see #getArchBinding()
	 * @generated
	 */
	EAttribute getArchBinding_Component();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.ArchBinding#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter</em>'.
	 * @see miron.metamodel.kernel.ArchBinding#getParameter()
	 * @see #getArchBinding()
	 * @generated
	 */
	EAttribute getArchBinding_Parameter();

	/**
	 * Returns the meta object for enum '{@link miron.metamodel.kernel.InsertionTypeEnum <em>Insertion Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Insertion Type Enum</em>'.
	 * @see miron.metamodel.kernel.InsertionTypeEnum
	 * @generated
	 */
	EEnum getInsertionTypeEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KernelFactory getKernelFactory();

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
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.VariationPointImpl <em>Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.VariationPointImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getVariationPoint()
		 * @generated
		 */
		EClass VARIATION_POINT = eINSTANCE.getVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__BINDING = eINSTANCE.getVariationPoint_Binding();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.BtBindingImpl <em>Bt Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.BtBindingImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getBtBinding()
		 * @generated
		 */
		EClass BT_BINDING = eINSTANCE.getBtBinding();

		/**
		 * The meta object literal for the '<em><b>Xpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BT_BINDING__XPATH = eINSTANCE.getBtBinding_Xpath();

		/**
		 * The meta object literal for the '<em><b>Insertion Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BT_BINDING__INSERTION_TYPE = eINSTANCE.getBtBinding_InsertionType();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BT_BINDING__TARGETS = eINSTANCE.getBtBinding_Targets();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.RuleImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Implies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__IMPLIES = eINSTANCE.getRule_Implies();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__NAME = eINSTANCE.getRule_Name();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__CONDITION = eINSTANCE.getRule_Condition();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.ConstraintImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__TERM = eINSTANCE.getConstraint_Term();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.ImportImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__ALIAS = eINSTANCE.getImport_Alias();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.ConditionImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__TERM = eINSTANCE.getCondition_Term();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.BindingImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.ArchBindingImpl <em>Arch Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.ArchBindingImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getArchBinding()
		 * @generated
		 */
		EClass ARCH_BINDING = eINSTANCE.getArchBinding();

		/**
		 * The meta object literal for the '<em><b>Parameter Set Repository</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCH_BINDING__PARAMETER_SET_REPOSITORY = eINSTANCE.getArchBinding_ParameterSetRepository();

		/**
		 * The meta object literal for the '<em><b>Parameter Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCH_BINDING__PARAMETER_SET = eINSTANCE.getArchBinding_ParameterSet();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCH_BINDING__COMPONENT = eINSTANCE.getArchBinding_Component();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCH_BINDING__PARAMETER = eINSTANCE.getArchBinding_Parameter();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.InsertionTypeEnum <em>Insertion Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.InsertionTypeEnum
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getInsertionTypeEnum()
		 * @generated
		 */
		EEnum INSERTION_TYPE_ENUM = eINSTANCE.getInsertionTypeEnum();

	}

} //KernelPackage
