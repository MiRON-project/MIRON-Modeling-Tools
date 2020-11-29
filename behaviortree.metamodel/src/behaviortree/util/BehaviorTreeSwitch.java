/**
 */
package behaviortree.util;

import behaviortree.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see behaviortree.BehaviorTreePackage
 * @generated
 */
public class BehaviorTreeSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BehaviorTreePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTreeSwitch() {
		if (modelPackage == null) {
			modelPackage = BehaviorTreePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BehaviorTreePackage.BEHAVIOR_TREE: {
				BehaviorTree behaviorTree = (BehaviorTree)theEObject;
				T result = caseBehaviorTree(behaviorTree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.TREE_NODE: {
				TreeNode treeNode = (TreeNode)theEObject;
				T result = caseTreeNode(treeNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.CONTROL_NODE: {
				ControlNode controlNode = (ControlNode)theEObject;
				T result = caseControlNode(controlNode);
				if (result == null) result = caseTreeNode(controlNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.LEAF_NODE: {
				LeafNode leafNode = (LeafNode)theEObject;
				T result = caseLeafNode(leafNode);
				if (result == null) result = caseTreeNode(leafNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.DECORATOR_NODE: {
				DecoratorNode decoratorNode = (DecoratorNode)theEObject;
				T result = caseDecoratorNode(decoratorNode);
				if (result == null) result = caseTreeNode(decoratorNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.ABSTRACT_ACTION: {
				AbstractAction abstractAction = (AbstractAction)theEObject;
				T result = caseAbstractAction(abstractAction);
				if (result == null) result = caseLeafNode(abstractAction);
				if (result == null) result = caseTreeNode(abstractAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = caseLeafNode(condition);
				if (result == null) result = caseTreeNode(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.FORCE_SUCCESS: {
				ForceSuccess forceSuccess = (ForceSuccess)theEObject;
				T result = caseForceSuccess(forceSuccess);
				if (result == null) result = caseDecoratorNode(forceSuccess);
				if (result == null) result = caseTreeNode(forceSuccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.FORCE_FAILURE: {
				ForceFailure forceFailure = (ForceFailure)theEObject;
				T result = caseForceFailure(forceFailure);
				if (result == null) result = caseDecoratorNode(forceFailure);
				if (result == null) result = caseTreeNode(forceFailure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.ALWAYS_SUCCESS: {
				AlwaysSuccess alwaysSuccess = (AlwaysSuccess)theEObject;
				T result = caseAlwaysSuccess(alwaysSuccess);
				if (result == null) result = caseAbstractAction(alwaysSuccess);
				if (result == null) result = caseLeafNode(alwaysSuccess);
				if (result == null) result = caseTreeNode(alwaysSuccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.ALWAYS_FAILURE: {
				AlwaysFailure alwaysFailure = (AlwaysFailure)theEObject;
				T result = caseAlwaysFailure(alwaysFailure);
				if (result == null) result = caseAbstractAction(alwaysFailure);
				if (result == null) result = caseLeafNode(alwaysFailure);
				if (result == null) result = caseTreeNode(alwaysFailure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = caseControlNode(sequence);
				if (result == null) result = caseTreeNode(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.REPEAT: {
				Repeat repeat = (Repeat)theEObject;
				T result = caseRepeat(repeat);
				if (result == null) result = caseDecoratorNode(repeat);
				if (result == null) result = caseTreeNode(repeat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.TIMEOUT: {
				Timeout timeout = (Timeout)theEObject;
				T result = caseTimeout(timeout);
				if (result == null) result = caseDecoratorNode(timeout);
				if (result == null) result = caseTreeNode(timeout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.RETRY_UNTIL_SUCCESS: {
				RetryUntilSuccess retryUntilSuccess = (RetryUntilSuccess)theEObject;
				T result = caseRetryUntilSuccess(retryUntilSuccess);
				if (result == null) result = caseDecoratorNode(retryUntilSuccess);
				if (result == null) result = caseTreeNode(retryUntilSuccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.INVERTER: {
				Inverter inverter = (Inverter)theEObject;
				T result = caseInverter(inverter);
				if (result == null) result = caseDecoratorNode(inverter);
				if (result == null) result = caseTreeNode(inverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.SEQUENCE_STAR: {
				SequenceStar sequenceStar = (SequenceStar)theEObject;
				T result = caseSequenceStar(sequenceStar);
				if (result == null) result = caseControlNode(sequenceStar);
				if (result == null) result = caseTreeNode(sequenceStar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.FALLBACK: {
				Fallback fallback = (Fallback)theEObject;
				T result = caseFallback(fallback);
				if (result == null) result = caseControlNode(fallback);
				if (result == null) result = caseTreeNode(fallback);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.FALLBACK_STAR: {
				FallbackStar fallbackStar = (FallbackStar)theEObject;
				T result = caseFallbackStar(fallbackStar);
				if (result == null) result = caseControlNode(fallbackStar);
				if (result == null) result = caseTreeNode(fallbackStar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.PARALLEL: {
				Parallel parallel = (Parallel)theEObject;
				T result = caseParallel(parallel);
				if (result == null) result = caseControlNode(parallel);
				if (result == null) result = caseTreeNode(parallel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.SUBTREE_NODE: {
				SubtreeNode subtreeNode = (SubtreeNode)theEObject;
				T result = caseSubtreeNode(subtreeNode);
				if (result == null) result = caseTreeNode(subtreeNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.BT_MODEL: {
				BTModel btModel = (BTModel)theEObject;
				T result = caseBTModel(btModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.IMPORT: {
				Import import_ = (Import)theEObject;
				T result = caseImport(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.SET_BLACKBOARD: {
				SetBlackboard setBlackboard = (SetBlackboard)theEObject;
				T result = caseSetBlackboard(setBlackboard);
				if (result == null) result = caseAbstractAction(setBlackboard);
				if (result == null) result = caseLeafNode(setBlackboard);
				if (result == null) result = caseTreeNode(setBlackboard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.BLACKBOARD_CHECK_DOUBLE: {
				BlackboardCheckDouble blackboardCheckDouble = (BlackboardCheckDouble)theEObject;
				T result = caseBlackboardCheckDouble(blackboardCheckDouble);
				if (result == null) result = caseDecoratorNode(blackboardCheckDouble);
				if (result == null) result = caseTreeNode(blackboardCheckDouble);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.BLACKBOARD_CHECK_INT: {
				BlackboardCheckInt blackboardCheckInt = (BlackboardCheckInt)theEObject;
				T result = caseBlackboardCheckInt(blackboardCheckInt);
				if (result == null) result = caseDecoratorNode(blackboardCheckInt);
				if (result == null) result = caseTreeNode(blackboardCheckInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.BLACKBOARD_CHECK_STRING: {
				BlackboardCheckString blackboardCheckString = (BlackboardCheckString)theEObject;
				T result = caseBlackboardCheckString(blackboardCheckString);
				if (result == null) result = caseDecoratorNode(blackboardCheckString);
				if (result == null) result = caseTreeNode(blackboardCheckString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseAbstractAction(action);
				if (result == null) result = caseLeafNode(action);
				if (result == null) result = caseTreeNode(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.SUBTREE_PLUS: {
				SubtreePlus subtreePlus = (SubtreePlus)theEObject;
				T result = caseSubtreePlus(subtreePlus);
				if (result == null) result = caseSubtreeNode(subtreePlus);
				if (result == null) result = caseTreeNode(subtreePlus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.SWITCH: {
				behaviortree.Switch switch_ = (behaviortree.Switch)theEObject;
				T result = caseSwitch(switch_);
				if (result == null) result = caseControlNode(switch_);
				if (result == null) result = caseTreeNode(switch_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.SUBTREE: {
				Subtree subtree = (Subtree)theEObject;
				T result = caseSubtree(subtree);
				if (result == null) result = caseSubtreeNode(subtree);
				if (result == null) result = caseTreeNode(subtree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BehaviorTreePackage.TREE_NODES_MODEL: {
				TreeNodesModel treeNodesModel = (TreeNodesModel)theEObject;
				T result = caseTreeNodesModel(treeNodesModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Tree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Tree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorTree(BehaviorTree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tree Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tree Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTreeNode(TreeNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlNode(ControlNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeafNode(LeafNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decorator Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decorator Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecoratorNode(DecoratorNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractAction(AbstractAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Force Success</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Force Success</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForceSuccess(ForceSuccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Force Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Force Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForceFailure(ForceFailure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Always Success</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Always Success</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlwaysSuccess(AlwaysSuccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Always Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Always Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlwaysFailure(AlwaysFailure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repeat</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repeat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepeat(Repeat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timeout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timeout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeout(Timeout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Retry Until Success</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Retry Until Success</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRetryUntilSuccess(RetryUntilSuccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inverter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inverter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInverter(Inverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Star</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Star</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceStar(SequenceStar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fallback</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fallback</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFallback(Fallback object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fallback Star</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fallback Star</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFallbackStar(FallbackStar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parallel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parallel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParallel(Parallel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subtree Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subtree Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubtreeNode(SubtreeNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BT Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BT Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBTModel(BTModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Blackboard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Blackboard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetBlackboard(SetBlackboard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blackboard Check Double</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blackboard Check Double</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlackboardCheckDouble(BlackboardCheckDouble object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blackboard Check Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blackboard Check Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlackboardCheckInt(BlackboardCheckInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blackboard Check String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blackboard Check String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlackboardCheckString(BlackboardCheckString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subtree Plus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subtree Plus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubtreePlus(SubtreePlus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitch(behaviortree.Switch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subtree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subtree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubtree(Subtree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tree Nodes Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tree Nodes Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTreeNodesModel(TreeNodesModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //BehaviorTreeSwitch
