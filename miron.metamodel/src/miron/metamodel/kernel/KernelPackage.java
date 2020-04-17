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
	int BINDING = 1;

	/**
	 * The feature id for the '<em><b>Xpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__XPATH = 0;

	/**
	 * The feature id for the '<em><b>Insertion Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__INSERTION_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__TARGETS = 2;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__TRIGGER = DatatypesPackage.SENTENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ACTIONS = DatatypesPackage.SENTENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = DatatypesPackage.SENTENCE_FEATURE_COUNT + 2;

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
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.RuleActionImpl <em>Rule Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.RuleActionImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getRuleAction()
	 * @generated
	 */
	int RULE_ACTION = 3;

	/**
	 * The number of structural features of the '<em>Rule Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ACTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Rule Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.VariantAssignmentImpl <em>Variant Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.VariantAssignmentImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getVariantAssignment()
	 * @generated
	 */
	int VARIANT_ASSIGNMENT = 4;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNMENT__VARIABLE = RULE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNMENT__VALUE = RULE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variant Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNMENT_FEATURE_COUNT = RULE_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variant Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNMENT_OPERATION_COUNT = RULE_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.kernel.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.impl.ImportImpl
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 5;

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
	 * The meta object id for the '{@link miron.metamodel.kernel.InsertionTypeEnum <em>Insertion Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.kernel.InsertionTypeEnum
	 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getInsertionTypeEnum()
	 * @generated
	 */
	int INSERTION_TYPE_ENUM = 6;


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
	 * Returns the meta object for class '{@link miron.metamodel.kernel.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see miron.metamodel.kernel.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.Binding#getXpath <em>Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xpath</em>'.
	 * @see miron.metamodel.kernel.Binding#getXpath()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Xpath();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.kernel.Binding#getInsertionType <em>Insertion Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insertion Type</em>'.
	 * @see miron.metamodel.kernel.Binding#getInsertionType()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_InsertionType();

	/**
	 * Returns the meta object for the reference list '{@link miron.metamodel.kernel.Binding#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see miron.metamodel.kernel.Binding#getTargets()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Targets();

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
	 * Returns the meta object for the containment reference '{@link miron.metamodel.kernel.Rule#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trigger</em>'.
	 * @see miron.metamodel.kernel.Rule#getTrigger()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Trigger();

	/**
	 * Returns the meta object for the containment reference list '{@link miron.metamodel.kernel.Rule#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see miron.metamodel.kernel.Rule#getActions()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Actions();

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
	 * Returns the meta object for class '{@link miron.metamodel.kernel.RuleAction <em>Rule Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Action</em>'.
	 * @see miron.metamodel.kernel.RuleAction
	 * @generated
	 */
	EClass getRuleAction();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.kernel.VariantAssignment <em>Variant Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant Assignment</em>'.
	 * @see miron.metamodel.kernel.VariantAssignment
	 * @generated
	 */
	EClass getVariantAssignment();

	/**
	 * Returns the meta object for the reference '{@link miron.metamodel.kernel.VariantAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see miron.metamodel.kernel.VariantAssignment#getVariable()
	 * @see #getVariantAssignment()
	 * @generated
	 */
	EReference getVariantAssignment_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link miron.metamodel.kernel.VariantAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see miron.metamodel.kernel.VariantAssignment#getValue()
	 * @see #getVariantAssignment()
	 * @generated
	 */
	EReference getVariantAssignment_Value();

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
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.BindingImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Xpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__XPATH = eINSTANCE.getBinding_Xpath();

		/**
		 * The meta object literal for the '<em><b>Insertion Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__INSERTION_TYPE = eINSTANCE.getBinding_InsertionType();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__TARGETS = eINSTANCE.getBinding_Targets();

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
		 * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__TRIGGER = eINSTANCE.getRule_Trigger();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__ACTIONS = eINSTANCE.getRule_Actions();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__NAME = eINSTANCE.getRule_Name();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.RuleActionImpl <em>Rule Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.RuleActionImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getRuleAction()
		 * @generated
		 */
		EClass RULE_ACTION = eINSTANCE.getRuleAction();

		/**
		 * The meta object literal for the '{@link miron.metamodel.kernel.impl.VariantAssignmentImpl <em>Variant Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.kernel.impl.VariantAssignmentImpl
		 * @see miron.metamodel.kernel.impl.KernelPackageImpl#getVariantAssignment()
		 * @generated
		 */
		EClass VARIANT_ASSIGNMENT = eINSTANCE.getVariantAssignment();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT_ASSIGNMENT__VARIABLE = eINSTANCE.getVariantAssignment_Variable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT_ASSIGNMENT__VALUE = eINSTANCE.getVariantAssignment_Value();

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
