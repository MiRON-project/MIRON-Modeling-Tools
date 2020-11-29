/**
 */
package miron.metamodel.datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	 * The feature id for the '<em><b>Impacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL__IMPACTS = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL__REFERENCE = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Preset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL__PRESET = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Behavior Tree Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_LITERAL_FEATURE_COUNT = roqme.metamodel.datatypes.DatatypesPackage.ENUM_LITERAL_FEATURE_COUNT + 3;

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
	 * The meta object id for the '{@link miron.metamodel.datatypes.impl.BehaviorTreeEnumTypeImpl <em>Behavior Tree Enum Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.datatypes.impl.BehaviorTreeEnumTypeImpl
	 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getBehaviorTreeEnumType()
	 * @generated
	 */
	int BEHAVIOR_TREE_ENUM_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_ENUM_TYPE__CARDINALITY = roqme.metamodel.datatypes.DatatypesPackage.ENUM_TYPE__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_ENUM_TYPE__LITERALS = roqme.metamodel.datatypes.DatatypesPackage.ENUM_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Behavior Tree Enum Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_ENUM_TYPE_FEATURE_COUNT = roqme.metamodel.datatypes.DatatypesPackage.ENUM_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Behavior Tree Enum Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_ENUM_TYPE_OPERATION_COUNT = roqme.metamodel.datatypes.DatatypesPackage.ENUM_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.datatypes.impl.NumericSampledTypeImpl <em>Numeric Sampled Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.datatypes.impl.NumericSampledTypeImpl
	 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getNumericSampledType()
	 * @generated
	 */
	int NUMERIC_SAMPLED_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SAMPLED_TYPE__CARDINALITY = roqme.metamodel.datatypes.DatatypesPackage.NUMERIC_TYPE__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SAMPLED_TYPE__CONSTRAINTS = roqme.metamodel.datatypes.DatatypesPackage.NUMERIC_TYPE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Measurement Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SAMPLED_TYPE__MEASUREMENT_UNIT = roqme.metamodel.datatypes.DatatypesPackage.NUMERIC_TYPE__MEASUREMENT_UNIT;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SAMPLED_TYPE__SAMPLES = roqme.metamodel.datatypes.DatatypesPackage.NUMERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Sampled Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SAMPLED_TYPE_FEATURE_COUNT = roqme.metamodel.datatypes.DatatypesPackage.NUMERIC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Numeric Sampled Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SAMPLED_TYPE_OPERATION_COUNT = roqme.metamodel.datatypes.DatatypesPackage.NUMERIC_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.datatypes.impl.QoSProfiledValueImpl <em>Qo SProfiled Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.datatypes.impl.QoSProfiledValueImpl
	 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getQoSProfiledValue()
	 * @generated
	 */
	int QO_SPROFILED_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Impacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SPROFILED_VALUE__IMPACTS = 0;

	/**
	 * The number of structural features of the '<em>Qo SProfiled Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SPROFILED_VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Qo SProfiled Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SPROFILED_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.datatypes.impl.ImpactOnQualityImpl <em>Impact On Quality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.datatypes.impl.ImpactOnQualityImpl
	 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getImpactOnQuality()
	 * @generated
	 */
	int IMPACT_ON_QUALITY = 5;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ON_QUALITY__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Intensity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ON_QUALITY__INTENSITY = 1;

	/**
	 * The number of structural features of the '<em>Impact On Quality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ON_QUALITY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Impact On Quality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ON_QUALITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.datatypes.impl.SampleValueImpl <em>Sample Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.datatypes.impl.SampleValueImpl
	 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getSampleValue()
	 * @generated
	 */
	int SAMPLE_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Impacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_VALUE__IMPACTS = QO_SPROFILED_VALUE__IMPACTS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_VALUE__VALUE = QO_SPROFILED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sample Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_VALUE_FEATURE_COUNT = QO_SPROFILED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sample Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_VALUE_OPERATION_COUNT = QO_SPROFILED_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link miron.metamodel.datatypes.ImpactIntensityEnum <em>Impact Intensity Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see miron.metamodel.datatypes.ImpactIntensityEnum
	 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getImpactIntensityEnum()
	 * @generated
	 */
	int IMPACT_INTENSITY_ENUM = 7;


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
	 * Returns the meta object for the attribute '{@link miron.metamodel.datatypes.BehaviorTreeLiteral#isPreset <em>Preset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preset</em>'.
	 * @see miron.metamodel.datatypes.BehaviorTreeLiteral#isPreset()
	 * @see #getBehaviorTreeLiteral()
	 * @generated
	 */
	EAttribute getBehaviorTreeLiteral_Preset();

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
	 * Returns the meta object for class '{@link miron.metamodel.datatypes.BehaviorTreeEnumType <em>Behavior Tree Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Tree Enum Type</em>'.
	 * @see miron.metamodel.datatypes.BehaviorTreeEnumType
	 * @generated
	 */
	EClass getBehaviorTreeEnumType();

	/**
	 * Returns the meta object for the containment reference list '{@link miron.metamodel.datatypes.BehaviorTreeEnumType#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see miron.metamodel.datatypes.BehaviorTreeEnumType#getLiterals()
	 * @see #getBehaviorTreeEnumType()
	 * @generated
	 */
	EReference getBehaviorTreeEnumType_Literals();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.datatypes.NumericSampledType <em>Numeric Sampled Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Sampled Type</em>'.
	 * @see miron.metamodel.datatypes.NumericSampledType
	 * @generated
	 */
	EClass getNumericSampledType();

	/**
	 * Returns the meta object for the containment reference list '{@link miron.metamodel.datatypes.NumericSampledType#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Samples</em>'.
	 * @see miron.metamodel.datatypes.NumericSampledType#getSamples()
	 * @see #getNumericSampledType()
	 * @generated
	 */
	EReference getNumericSampledType_Samples();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.datatypes.QoSProfiledValue <em>Qo SProfiled Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qo SProfiled Value</em>'.
	 * @see miron.metamodel.datatypes.QoSProfiledValue
	 * @generated
	 */
	EClass getQoSProfiledValue();

	/**
	 * Returns the meta object for the containment reference list '{@link miron.metamodel.datatypes.QoSProfiledValue#getImpacts <em>Impacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Impacts</em>'.
	 * @see miron.metamodel.datatypes.QoSProfiledValue#getImpacts()
	 * @see #getQoSProfiledValue()
	 * @generated
	 */
	EReference getQoSProfiledValue_Impacts();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.datatypes.ImpactOnQuality <em>Impact On Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact On Quality</em>'.
	 * @see miron.metamodel.datatypes.ImpactOnQuality
	 * @generated
	 */
	EClass getImpactOnQuality();

	/**
	 * Returns the meta object for the reference '{@link miron.metamodel.datatypes.ImpactOnQuality#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see miron.metamodel.datatypes.ImpactOnQuality#getProperty()
	 * @see #getImpactOnQuality()
	 * @generated
	 */
	EReference getImpactOnQuality_Property();

	/**
	 * Returns the meta object for the attribute '{@link miron.metamodel.datatypes.ImpactOnQuality#getIntensity <em>Intensity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intensity</em>'.
	 * @see miron.metamodel.datatypes.ImpactOnQuality#getIntensity()
	 * @see #getImpactOnQuality()
	 * @generated
	 */
	EAttribute getImpactOnQuality_Intensity();

	/**
	 * Returns the meta object for class '{@link miron.metamodel.datatypes.SampleValue <em>Sample Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample Value</em>'.
	 * @see miron.metamodel.datatypes.SampleValue
	 * @generated
	 */
	EClass getSampleValue();

	/**
	 * Returns the meta object for the containment reference '{@link miron.metamodel.datatypes.SampleValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see miron.metamodel.datatypes.SampleValue#getValue()
	 * @see #getSampleValue()
	 * @generated
	 */
	EReference getSampleValue_Value();

	/**
	 * Returns the meta object for enum '{@link miron.metamodel.datatypes.ImpactIntensityEnum <em>Impact Intensity Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Impact Intensity Enum</em>'.
	 * @see miron.metamodel.datatypes.ImpactIntensityEnum
	 * @generated
	 */
	EEnum getImpactIntensityEnum();

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
		 * The meta object literal for the '<em><b>Preset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_TREE_LITERAL__PRESET = eINSTANCE.getBehaviorTreeLiteral_Preset();

		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.impl.MironModelImpl <em>Miron Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.impl.MironModelImpl
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getMironModel()
		 * @generated
		 */
		EClass MIRON_MODEL = eINSTANCE.getMironModel();

		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.impl.BehaviorTreeEnumTypeImpl <em>Behavior Tree Enum Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.impl.BehaviorTreeEnumTypeImpl
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getBehaviorTreeEnumType()
		 * @generated
		 */
		EClass BEHAVIOR_TREE_ENUM_TYPE = eINSTANCE.getBehaviorTreeEnumType();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TREE_ENUM_TYPE__LITERALS = eINSTANCE.getBehaviorTreeEnumType_Literals();

		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.impl.NumericSampledTypeImpl <em>Numeric Sampled Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.impl.NumericSampledTypeImpl
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getNumericSampledType()
		 * @generated
		 */
		EClass NUMERIC_SAMPLED_TYPE = eINSTANCE.getNumericSampledType();

		/**
		 * The meta object literal for the '<em><b>Samples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERIC_SAMPLED_TYPE__SAMPLES = eINSTANCE.getNumericSampledType_Samples();

		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.impl.QoSProfiledValueImpl <em>Qo SProfiled Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.impl.QoSProfiledValueImpl
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getQoSProfiledValue()
		 * @generated
		 */
		EClass QO_SPROFILED_VALUE = eINSTANCE.getQoSProfiledValue();

		/**
		 * The meta object literal for the '<em><b>Impacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QO_SPROFILED_VALUE__IMPACTS = eINSTANCE.getQoSProfiledValue_Impacts();

		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.impl.ImpactOnQualityImpl <em>Impact On Quality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.impl.ImpactOnQualityImpl
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getImpactOnQuality()
		 * @generated
		 */
		EClass IMPACT_ON_QUALITY = eINSTANCE.getImpactOnQuality();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ON_QUALITY__PROPERTY = eINSTANCE.getImpactOnQuality_Property();

		/**
		 * The meta object literal for the '<em><b>Intensity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT_ON_QUALITY__INTENSITY = eINSTANCE.getImpactOnQuality_Intensity();

		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.impl.SampleValueImpl <em>Sample Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.impl.SampleValueImpl
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getSampleValue()
		 * @generated
		 */
		EClass SAMPLE_VALUE = eINSTANCE.getSampleValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLE_VALUE__VALUE = eINSTANCE.getSampleValue_Value();

		/**
		 * The meta object literal for the '{@link miron.metamodel.datatypes.ImpactIntensityEnum <em>Impact Intensity Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see miron.metamodel.datatypes.ImpactIntensityEnum
		 * @see miron.metamodel.datatypes.impl.DatatypesPackageImpl#getImpactIntensityEnum()
		 * @generated
		 */
		EEnum IMPACT_INTENSITY_ENUM = eINSTANCE.getImpactIntensityEnum();

	}

} //DatatypesPackage
