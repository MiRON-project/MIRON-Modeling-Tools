/**
 */
package behaviortree.util;

import behaviortree.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see behaviortree.BehaviorTreePackage
 * @generated
 */
public class BehaviorTreeAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BehaviorTreePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTreeAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BehaviorTreePackage.eINSTANCE;
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
	protected BehaviorTreeSwitch<Adapter> modelSwitch =
		new BehaviorTreeSwitch<Adapter>() {
			@Override
			public Adapter caseBehaviorTree(BehaviorTree object) {
				return createBehaviorTreeAdapter();
			}
			@Override
			public Adapter caseTreeNode(TreeNode object) {
				return createTreeNodeAdapter();
			}
			@Override
			public Adapter caseControlNode(ControlNode object) {
				return createControlNodeAdapter();
			}
			@Override
			public Adapter caseLeafNode(LeafNode object) {
				return createLeafNodeAdapter();
			}
			@Override
			public Adapter caseDecoratorNode(DecoratorNode object) {
				return createDecoratorNodeAdapter();
			}
			@Override
			public Adapter caseAbstractAction(AbstractAction object) {
				return createAbstractActionAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseForceSuccess(ForceSuccess object) {
				return createForceSuccessAdapter();
			}
			@Override
			public Adapter caseForceFailure(ForceFailure object) {
				return createForceFailureAdapter();
			}
			@Override
			public Adapter caseAlwaysSuccess(AlwaysSuccess object) {
				return createAlwaysSuccessAdapter();
			}
			@Override
			public Adapter caseAlwaysFailure(AlwaysFailure object) {
				return createAlwaysFailureAdapter();
			}
			@Override
			public Adapter caseSequence(Sequence object) {
				return createSequenceAdapter();
			}
			@Override
			public Adapter caseRepeat(Repeat object) {
				return createRepeatAdapter();
			}
			@Override
			public Adapter caseTimeout(Timeout object) {
				return createTimeoutAdapter();
			}
			@Override
			public Adapter caseRetryUntilSuccess(RetryUntilSuccess object) {
				return createRetryUntilSuccessAdapter();
			}
			@Override
			public Adapter caseInverter(Inverter object) {
				return createInverterAdapter();
			}
			@Override
			public Adapter caseSequenceStar(SequenceStar object) {
				return createSequenceStarAdapter();
			}
			@Override
			public Adapter caseFallback(Fallback object) {
				return createFallbackAdapter();
			}
			@Override
			public Adapter caseFallbackStar(FallbackStar object) {
				return createFallbackStarAdapter();
			}
			@Override
			public Adapter caseParallel(Parallel object) {
				return createParallelAdapter();
			}
			@Override
			public Adapter caseSubtree(Subtree object) {
				return createSubtreeAdapter();
			}
			@Override
			public Adapter caseBTModel(BTModel object) {
				return createBTModelAdapter();
			}
			@Override
			public Adapter caseImport(Import object) {
				return createImportAdapter();
			}
			@Override
			public Adapter caseSetBlackboard(SetBlackboard object) {
				return createSetBlackboardAdapter();
			}
			@Override
			public Adapter caseBlackboardCheckDouble(BlackboardCheckDouble object) {
				return createBlackboardCheckDoubleAdapter();
			}
			@Override
			public Adapter caseBlackboardCheckInt(BlackboardCheckInt object) {
				return createBlackboardCheckIntAdapter();
			}
			@Override
			public Adapter caseBlackboardCheckString(BlackboardCheckString object) {
				return createBlackboardCheckStringAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseSwitch(Switch object) {
				return createSwitchAdapter();
			}
			@Override
			public Adapter caseSubtreeNode(SubtreeNode object) {
				return createSubtreeNodeAdapter();
			}
			@Override
			public Adapter caseSubTreeWrapper(SubTreeWrapper object) {
				return createSubTreeWrapperAdapter();
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
	 * Creates a new adapter for an object of class '{@link behaviortree.BehaviorTree <em>Behavior Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.BehaviorTree
	 * @generated
	 */
	public Adapter createBehaviorTreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.TreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.TreeNode
	 * @generated
	 */
	public Adapter createTreeNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.ControlNode <em>Control Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.ControlNode
	 * @generated
	 */
	public Adapter createControlNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.LeafNode <em>Leaf Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.LeafNode
	 * @generated
	 */
	public Adapter createLeafNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.DecoratorNode <em>Decorator Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.DecoratorNode
	 * @generated
	 */
	public Adapter createDecoratorNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.AbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.AbstractAction
	 * @generated
	 */
	public Adapter createAbstractActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.ForceSuccess <em>Force Success</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.ForceSuccess
	 * @generated
	 */
	public Adapter createForceSuccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.ForceFailure <em>Force Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.ForceFailure
	 * @generated
	 */
	public Adapter createForceFailureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.AlwaysSuccess <em>Always Success</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.AlwaysSuccess
	 * @generated
	 */
	public Adapter createAlwaysSuccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.AlwaysFailure <em>Always Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.AlwaysFailure
	 * @generated
	 */
	public Adapter createAlwaysFailureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Sequence
	 * @generated
	 */
	public Adapter createSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Repeat <em>Repeat</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Repeat
	 * @generated
	 */
	public Adapter createRepeatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Timeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Timeout
	 * @generated
	 */
	public Adapter createTimeoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.RetryUntilSuccess <em>Retry Until Success</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.RetryUntilSuccess
	 * @generated
	 */
	public Adapter createRetryUntilSuccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Inverter <em>Inverter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Inverter
	 * @generated
	 */
	public Adapter createInverterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.SequenceStar <em>Sequence Star</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.SequenceStar
	 * @generated
	 */
	public Adapter createSequenceStarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Fallback <em>Fallback</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Fallback
	 * @generated
	 */
	public Adapter createFallbackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.FallbackStar <em>Fallback Star</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.FallbackStar
	 * @generated
	 */
	public Adapter createFallbackStarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Parallel <em>Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Parallel
	 * @generated
	 */
	public Adapter createParallelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Subtree <em>Subtree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Subtree
	 * @generated
	 */
	public Adapter createSubtreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.BTModel <em>BT Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.BTModel
	 * @generated
	 */
	public Adapter createBTModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Import
	 * @generated
	 */
	public Adapter createImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.SetBlackboard <em>Set Blackboard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.SetBlackboard
	 * @generated
	 */
	public Adapter createSetBlackboardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.BlackboardCheckDouble <em>Blackboard Check Double</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.BlackboardCheckDouble
	 * @generated
	 */
	public Adapter createBlackboardCheckDoubleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.BlackboardCheckInt <em>Blackboard Check Int</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.BlackboardCheckInt
	 * @generated
	 */
	public Adapter createBlackboardCheckIntAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.BlackboardCheckString <em>Blackboard Check String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.BlackboardCheckString
	 * @generated
	 */
	public Adapter createBlackboardCheckStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.Switch
	 * @generated
	 */
	public Adapter createSwitchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.SubtreeNode <em>Subtree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.SubtreeNode
	 * @generated
	 */
	public Adapter createSubtreeNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link behaviortree.SubTreeWrapper <em>Sub Tree Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see behaviortree.SubTreeWrapper
	 * @generated
	 */
	public Adapter createSubTreeWrapperAdapter() {
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

} //BehaviorTreeAdapterFactory
