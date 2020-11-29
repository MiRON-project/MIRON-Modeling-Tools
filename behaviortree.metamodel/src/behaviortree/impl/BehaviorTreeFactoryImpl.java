/**
 */
package behaviortree.impl;

import behaviortree.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BehaviorTreeFactoryImpl extends EFactoryImpl implements BehaviorTreeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BehaviorTreeFactory init() {
		try {
			BehaviorTreeFactory theBehaviorTreeFactory = (BehaviorTreeFactory)EPackage.Registry.INSTANCE.getEFactory(BehaviorTreePackage.eNS_URI);
			if (theBehaviorTreeFactory != null) {
				return theBehaviorTreeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BehaviorTreeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTreeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BehaviorTreePackage.BEHAVIOR_TREE: return createBehaviorTree();
			case BehaviorTreePackage.CONDITION: return createCondition();
			case BehaviorTreePackage.FORCE_SUCCESS: return createForceSuccess();
			case BehaviorTreePackage.FORCE_FAILURE: return createForceFailure();
			case BehaviorTreePackage.ALWAYS_SUCCESS: return createAlwaysSuccess();
			case BehaviorTreePackage.ALWAYS_FAILURE: return createAlwaysFailure();
			case BehaviorTreePackage.SEQUENCE: return createSequence();
			case BehaviorTreePackage.REPEAT: return createRepeat();
			case BehaviorTreePackage.TIMEOUT: return createTimeout();
			case BehaviorTreePackage.RETRY_UNTIL_SUCCESS: return createRetryUntilSuccess();
			case BehaviorTreePackage.INVERTER: return createInverter();
			case BehaviorTreePackage.SEQUENCE_STAR: return createSequenceStar();
			case BehaviorTreePackage.FALLBACK: return createFallback();
			case BehaviorTreePackage.FALLBACK_STAR: return createFallbackStar();
			case BehaviorTreePackage.PARALLEL: return createParallel();
			case BehaviorTreePackage.BT_MODEL: return createBTModel();
			case BehaviorTreePackage.IMPORT: return createImport();
			case BehaviorTreePackage.SET_BLACKBOARD: return createSetBlackboard();
			case BehaviorTreePackage.BLACKBOARD_CHECK_DOUBLE: return createBlackboardCheckDouble();
			case BehaviorTreePackage.BLACKBOARD_CHECK_INT: return createBlackboardCheckInt();
			case BehaviorTreePackage.BLACKBOARD_CHECK_STRING: return createBlackboardCheckString();
			case BehaviorTreePackage.ACTION: return createAction();
			case BehaviorTreePackage.ATTRIBUTE: return createAttribute();
			case BehaviorTreePackage.SUBTREE_PLUS: return createSubtreePlus();
			case BehaviorTreePackage.SWITCH: return createSwitch();
			case BehaviorTreePackage.SUBTREE: return createSubtree();
			case BehaviorTreePackage.TREE_NODES_MODEL: return createTreeNodesModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTree createBehaviorTree() {
		BehaviorTreeImpl behaviorTree = new BehaviorTreeImpl();
		return behaviorTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForceSuccess createForceSuccess() {
		ForceSuccessImpl forceSuccess = new ForceSuccessImpl();
		return forceSuccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForceFailure createForceFailure() {
		ForceFailureImpl forceFailure = new ForceFailureImpl();
		return forceFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysSuccess createAlwaysSuccess() {
		AlwaysSuccessImpl alwaysSuccess = new AlwaysSuccessImpl();
		return alwaysSuccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysFailure createAlwaysFailure() {
		AlwaysFailureImpl alwaysFailure = new AlwaysFailureImpl();
		return alwaysFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repeat createRepeat() {
		RepeatImpl repeat = new RepeatImpl();
		return repeat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timeout createTimeout() {
		TimeoutImpl timeout = new TimeoutImpl();
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RetryUntilSuccess createRetryUntilSuccess() {
		RetryUntilSuccessImpl retryUntilSuccess = new RetryUntilSuccessImpl();
		return retryUntilSuccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inverter createInverter() {
		InverterImpl inverter = new InverterImpl();
		return inverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceStar createSequenceStar() {
		SequenceStarImpl sequenceStar = new SequenceStarImpl();
		return sequenceStar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fallback createFallback() {
		FallbackImpl fallback = new FallbackImpl();
		return fallback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FallbackStar createFallbackStar() {
		FallbackStarImpl fallbackStar = new FallbackStarImpl();
		return fallbackStar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parallel createParallel() {
		ParallelImpl parallel = new ParallelImpl();
		return parallel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BTModel createBTModel() {
		BTModelImpl btModel = new BTModelImpl();
		return btModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetBlackboard createSetBlackboard() {
		SetBlackboardImpl setBlackboard = new SetBlackboardImpl();
		return setBlackboard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlackboardCheckDouble createBlackboardCheckDouble() {
		BlackboardCheckDoubleImpl blackboardCheckDouble = new BlackboardCheckDoubleImpl();
		return blackboardCheckDouble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlackboardCheckInt createBlackboardCheckInt() {
		BlackboardCheckIntImpl blackboardCheckInt = new BlackboardCheckIntImpl();
		return blackboardCheckInt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlackboardCheckString createBlackboardCheckString() {
		BlackboardCheckStringImpl blackboardCheckString = new BlackboardCheckStringImpl();
		return blackboardCheckString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubtreePlus createSubtreePlus() {
		SubtreePlusImpl subtreePlus = new SubtreePlusImpl();
		return subtreePlus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Switch createSwitch() {
		SwitchImpl switch_ = new SwitchImpl();
		return switch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subtree createSubtree() {
		SubtreeImpl subtree = new SubtreeImpl();
		return subtree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeNodesModel createTreeNodesModel() {
		TreeNodesModelImpl treeNodesModel = new TreeNodesModelImpl();
		return treeNodesModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTreePackage getBehaviorTreePackage() {
		return (BehaviorTreePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BehaviorTreePackage getPackage() {
		return BehaviorTreePackage.eINSTANCE;
	}

} //BehaviorTreeFactoryImpl
