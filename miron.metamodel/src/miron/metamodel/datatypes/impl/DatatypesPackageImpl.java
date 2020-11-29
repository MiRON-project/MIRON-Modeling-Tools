/**
 */
package miron.metamodel.datatypes.impl;

import behaviortree.BehaviorTreePackage;

import miron.metamodel.datatypes.BehaviorTreeEnumType;
import miron.metamodel.datatypes.BehaviorTreeLiteral;
import miron.metamodel.datatypes.DatatypesFactory;
import miron.metamodel.datatypes.DatatypesPackage;
import miron.metamodel.datatypes.ImpactIntensityEnum;
import miron.metamodel.datatypes.ImpactOnQuality;
import miron.metamodel.datatypes.MironModel;
import miron.metamodel.datatypes.NumericSampledType;
import miron.metamodel.datatypes.QoSProfiledValue;
import miron.metamodel.datatypes.SampleValue;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import roqme.metamodel.expressions.ExpressionsPackage;

import roqme.metamodel.kernel.KernelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypesPackageImpl extends EPackageImpl implements DatatypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorTreeLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mironModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorTreeEnumTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericSampledTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qoSProfiledValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impactOnQualityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sampleValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum impactIntensityEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see miron.metamodel.datatypes.DatatypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatatypesPackageImpl() {
		super(eNS_URI, DatatypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DatatypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatatypesPackage init() {
		if (isInited) return (DatatypesPackage)EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);

		// Obtain or create and register package
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DatatypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DatatypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BehaviorTreePackage.eINSTANCE.eClass();
		roqme.metamodel.datatypes.DatatypesPackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();
		KernelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDatatypesPackage.createPackageContents();

		// Initialize created meta-data
		theDatatypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDatatypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatatypesPackage.eNS_URI, theDatatypesPackage);
		return theDatatypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorTreeLiteral() {
		return behaviorTreeLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTreeLiteral_Reference() {
		return (EReference)behaviorTreeLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorTreeLiteral_Preset() {
		return (EAttribute)behaviorTreeLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMironModel() {
		return mironModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorTreeEnumType() {
		return behaviorTreeEnumTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTreeEnumType_Literals() {
		return (EReference)behaviorTreeEnumTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericSampledType() {
		return numericSampledTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericSampledType_Samples() {
		return (EReference)numericSampledTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQoSProfiledValue() {
		return qoSProfiledValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQoSProfiledValue_Impacts() {
		return (EReference)qoSProfiledValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImpactOnQuality() {
		return impactOnQualityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactOnQuality_Property() {
		return (EReference)impactOnQualityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpactOnQuality_Intensity() {
		return (EAttribute)impactOnQualityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSampleValue() {
		return sampleValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSampleValue_Value() {
		return (EReference)sampleValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImpactIntensityEnum() {
		return impactIntensityEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypesFactory getDatatypesFactory() {
		return (DatatypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		behaviorTreeLiteralEClass = createEClass(BEHAVIOR_TREE_LITERAL);
		createEReference(behaviorTreeLiteralEClass, BEHAVIOR_TREE_LITERAL__REFERENCE);
		createEAttribute(behaviorTreeLiteralEClass, BEHAVIOR_TREE_LITERAL__PRESET);

		mironModelEClass = createEClass(MIRON_MODEL);

		behaviorTreeEnumTypeEClass = createEClass(BEHAVIOR_TREE_ENUM_TYPE);
		createEReference(behaviorTreeEnumTypeEClass, BEHAVIOR_TREE_ENUM_TYPE__LITERALS);

		numericSampledTypeEClass = createEClass(NUMERIC_SAMPLED_TYPE);
		createEReference(numericSampledTypeEClass, NUMERIC_SAMPLED_TYPE__SAMPLES);

		qoSProfiledValueEClass = createEClass(QO_SPROFILED_VALUE);
		createEReference(qoSProfiledValueEClass, QO_SPROFILED_VALUE__IMPACTS);

		impactOnQualityEClass = createEClass(IMPACT_ON_QUALITY);
		createEReference(impactOnQualityEClass, IMPACT_ON_QUALITY__PROPERTY);
		createEAttribute(impactOnQualityEClass, IMPACT_ON_QUALITY__INTENSITY);

		sampleValueEClass = createEClass(SAMPLE_VALUE);
		createEReference(sampleValueEClass, SAMPLE_VALUE__VALUE);

		// Create enums
		impactIntensityEnumEEnum = createEEnum(IMPACT_INTENSITY_ENUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		roqme.metamodel.datatypes.DatatypesPackage theDatatypesPackage_1 = (roqme.metamodel.datatypes.DatatypesPackage)EPackage.Registry.INSTANCE.getEPackage(roqme.metamodel.datatypes.DatatypesPackage.eNS_URI);
		BehaviorTreePackage theBehaviorTreePackage = (BehaviorTreePackage)EPackage.Registry.INSTANCE.getEPackage(BehaviorTreePackage.eNS_URI);
		KernelPackage theKernelPackage = (KernelPackage)EPackage.Registry.INSTANCE.getEPackage(KernelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		behaviorTreeLiteralEClass.getESuperTypes().add(theDatatypesPackage_1.getEnumLiteral());
		behaviorTreeLiteralEClass.getESuperTypes().add(this.getQoSProfiledValue());
		mironModelEClass.getESuperTypes().add(theDatatypesPackage_1.getRoqmeModel());
		behaviorTreeEnumTypeEClass.getESuperTypes().add(theDatatypesPackage_1.getEnumType());
		numericSampledTypeEClass.getESuperTypes().add(theDatatypesPackage_1.getNumericType());
		sampleValueEClass.getESuperTypes().add(this.getQoSProfiledValue());

		// Initialize classes, features, and operations; add parameters
		initEClass(behaviorTreeLiteralEClass, BehaviorTreeLiteral.class, "BehaviorTreeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorTreeLiteral_Reference(), theBehaviorTreePackage.getBehaviorTree(), null, "reference", null, 0, 1, BehaviorTreeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorTreeLiteral_Preset(), ecorePackage.getEBoolean(), "preset", "false", 0, 1, BehaviorTreeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mironModelEClass, MironModel.class, "MironModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorTreeEnumTypeEClass, BehaviorTreeEnumType.class, "BehaviorTreeEnumType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorTreeEnumType_Literals(), this.getBehaviorTreeLiteral(), null, "literals", null, 1, -1, BehaviorTreeEnumType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericSampledTypeEClass, NumericSampledType.class, "NumericSampledType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumericSampledType_Samples(), this.getSampleValue(), null, "samples", null, 1, -1, NumericSampledType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qoSProfiledValueEClass, QoSProfiledValue.class, "QoSProfiledValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQoSProfiledValue_Impacts(), this.getImpactOnQuality(), null, "impacts", null, 0, -1, QoSProfiledValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impactOnQualityEClass, ImpactOnQuality.class, "ImpactOnQuality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImpactOnQuality_Property(), theKernelPackage.getProperty(), null, "property", null, 1, 1, ImpactOnQuality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImpactOnQuality_Intensity(), this.getImpactIntensityEnum(), "intensity", "NEUTRAL", 1, 1, ImpactOnQuality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sampleValueEClass, SampleValue.class, "SampleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSampleValue_Value(), theDatatypesPackage_1.getNumericValue(), null, "value", null, 1, 1, SampleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(impactIntensityEnumEEnum, ImpactIntensityEnum.class, "ImpactIntensityEnum");
		addEEnumLiteral(impactIntensityEnumEEnum, ImpactIntensityEnum.NEGATIVE_HIGH);
		addEEnumLiteral(impactIntensityEnumEEnum, ImpactIntensityEnum.NEGATIVE_MEDIUM);
		addEEnumLiteral(impactIntensityEnumEEnum, ImpactIntensityEnum.NEGATIVE_LOW);
		addEEnumLiteral(impactIntensityEnumEEnum, ImpactIntensityEnum.NEUTRAL);
		addEEnumLiteral(impactIntensityEnumEEnum, ImpactIntensityEnum.POSITIVE_LOW);
		addEEnumLiteral(impactIntensityEnumEEnum, ImpactIntensityEnum.POSITIVE_MEDIUM);
		addEEnumLiteral(impactIntensityEnumEEnum, ImpactIntensityEnum.POSITIVE_HIGH);

		// Create resource
		createResource(eNS_URI);
	}

} //DatatypesPackageImpl
