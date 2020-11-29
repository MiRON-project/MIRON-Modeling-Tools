/**
 */
package miron.metamodel.datatypes.util;

import miron.metamodel.datatypes.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import roqme.metamodel.datatypes.DataType;
import roqme.metamodel.datatypes.DocumentableElement;
import roqme.metamodel.datatypes.EnumLiteral;
import roqme.metamodel.datatypes.EnumType;
import roqme.metamodel.datatypes.NumericType;
import roqme.metamodel.datatypes.RoqmeModel;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see miron.metamodel.datatypes.DatatypesPackage
 * @generated
 */
public class DatatypesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DatatypesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DatatypesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatatypesSwitch<Adapter> modelSwitch =
		new DatatypesSwitch<Adapter>() {
			@Override
			public Adapter caseBehaviorTreeLiteral(BehaviorTreeLiteral object) {
				return createBehaviorTreeLiteralAdapter();
			}
			@Override
			public Adapter caseMironModel(MironModel object) {
				return createMironModelAdapter();
			}
			@Override
			public Adapter caseBehaviorTreeEnumType(BehaviorTreeEnumType object) {
				return createBehaviorTreeEnumTypeAdapter();
			}
			@Override
			public Adapter caseNumericSampledType(NumericSampledType object) {
				return createNumericSampledTypeAdapter();
			}
			@Override
			public Adapter caseQoSProfiledValue(QoSProfiledValue object) {
				return createQoSProfiledValueAdapter();
			}
			@Override
			public Adapter caseImpactOnQuality(ImpactOnQuality object) {
				return createImpactOnQualityAdapter();
			}
			@Override
			public Adapter caseSampleValue(SampleValue object) {
				return createSampleValueAdapter();
			}
			@Override
			public Adapter caseEnumLiteral(EnumLiteral object) {
				return createEnumLiteralAdapter();
			}
			@Override
			public Adapter caseDocumentableElement(DocumentableElement object) {
				return createDocumentableElementAdapter();
			}
			@Override
			public Adapter caseRoqmeModel(RoqmeModel object) {
				return createRoqmeModelAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseEnumType(EnumType object) {
				return createEnumTypeAdapter();
			}
			@Override
			public Adapter caseNumericType(NumericType object) {
				return createNumericTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link miron.metamodel.datatypes.BehaviorTreeLiteral <em>Behavior Tree Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see miron.metamodel.datatypes.BehaviorTreeLiteral
	 * @generated
	 */
	public Adapter createBehaviorTreeLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link miron.metamodel.datatypes.MironModel <em>Miron Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see miron.metamodel.datatypes.MironModel
	 * @generated
	 */
	public Adapter createMironModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link miron.metamodel.datatypes.BehaviorTreeEnumType <em>Behavior Tree Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see miron.metamodel.datatypes.BehaviorTreeEnumType
	 * @generated
	 */
	public Adapter createBehaviorTreeEnumTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link miron.metamodel.datatypes.NumericSampledType <em>Numeric Sampled Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see miron.metamodel.datatypes.NumericSampledType
	 * @generated
	 */
	public Adapter createNumericSampledTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link miron.metamodel.datatypes.QoSProfiledValue <em>Qo SProfiled Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see miron.metamodel.datatypes.QoSProfiledValue
	 * @generated
	 */
	public Adapter createQoSProfiledValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link miron.metamodel.datatypes.ImpactOnQuality <em>Impact On Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see miron.metamodel.datatypes.ImpactOnQuality
	 * @generated
	 */
	public Adapter createImpactOnQualityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link miron.metamodel.datatypes.SampleValue <em>Sample Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see miron.metamodel.datatypes.SampleValue
	 * @generated
	 */
	public Adapter createSampleValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.EnumLiteral
	 * @generated
	 */
	public Adapter createEnumLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.DocumentableElement <em>Documentable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.DocumentableElement
	 * @generated
	 */
	public Adapter createDocumentableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.RoqmeModel <em>Roqme Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.RoqmeModel
	 * @generated
	 */
	public Adapter createRoqmeModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.EnumType <em>Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.EnumType
	 * @generated
	 */
	public Adapter createEnumTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.NumericType <em>Numeric Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.NumericType
	 * @generated
	 */
	public Adapter createNumericTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DatatypesAdapterFactory
