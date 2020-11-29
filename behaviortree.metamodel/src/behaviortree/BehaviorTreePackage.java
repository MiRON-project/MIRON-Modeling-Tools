/**
 */
package behaviortree;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see behaviortree.BehaviorTreeFactory
 * @model kind="package"
 * @generated
 */
public interface BehaviorTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "behaviortree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://robmosys.eu/behaviortree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "behaviortree";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BehaviorTreePackage eINSTANCE = behaviortree.impl.BehaviorTreePackageImpl.init();

	/**
	 * The meta object id for the '{@link behaviortree.impl.BehaviorTreeImpl <em>Behavior Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.BehaviorTreeImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getBehaviorTree()
	 * @generated
	 */
	int BEHAVIOR_TREE = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE__NODES = 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE__ATTRIBUTES = 1;

	/**
	 * The number of structural features of the '<em>Behavior Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Behavior Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TREE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.TreeNodeImpl <em>Tree Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.TreeNodeImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getTreeNode()
	 * @generated
	 */
	int TREE_NODE = 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__ATTRIBUTES = 0;

	/**
	 * The number of structural features of the '<em>Tree Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tree Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ControlNodeImpl <em>Control Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ControlNodeImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getControlNode()
	 * @generated
	 */
	int CONTROL_NODE = 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE__ATTRIBUTES = TREE_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE__NODES = TREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Control Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE_FEATURE_COUNT = TREE_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Control Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE_OPERATION_COUNT = TREE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.LeafNodeImpl <em>Leaf Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.LeafNodeImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getLeafNode()
	 * @generated
	 */
	int LEAF_NODE = 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE__ATTRIBUTES = TREE_NODE__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Leaf Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE_FEATURE_COUNT = TREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Leaf Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_NODE_OPERATION_COUNT = TREE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.DecoratorNodeImpl <em>Decorator Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.DecoratorNodeImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getDecoratorNode()
	 * @generated
	 */
	int DECORATOR_NODE = 4;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR_NODE__ATTRIBUTES = TREE_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR_NODE__NODE = TREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decorator Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR_NODE_FEATURE_COUNT = TREE_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Decorator Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR_NODE_OPERATION_COUNT = TREE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.AbstractActionImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getAbstractAction()
	 * @generated
	 */
	int ABSTRACT_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__ATTRIBUTES = LEAF_NODE__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_FEATURE_COUNT = LEAF_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_OPERATION_COUNT = LEAF_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ConditionImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 6;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__ATTRIBUTES = LEAF_NODE__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = LEAF_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = LEAF_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ForceSuccessImpl <em>Force Success</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ForceSuccessImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getForceSuccess()
	 * @generated
	 */
	int FORCE_SUCCESS = 7;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_SUCCESS__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_SUCCESS__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Force Success</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_SUCCESS_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Force Success</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_SUCCESS_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ForceFailureImpl <em>Force Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ForceFailureImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getForceFailure()
	 * @generated
	 */
	int FORCE_FAILURE = 8;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_FAILURE__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_FAILURE__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Force Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_FAILURE_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Force Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCE_FAILURE_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.AlwaysSuccessImpl <em>Always Success</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.AlwaysSuccessImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getAlwaysSuccess()
	 * @generated
	 */
	int ALWAYS_SUCCESS = 9;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_SUCCESS__ATTRIBUTES = ABSTRACT_ACTION__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Always Success</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_SUCCESS_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Always Success</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_SUCCESS_OPERATION_COUNT = ABSTRACT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.AlwaysFailureImpl <em>Always Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.AlwaysFailureImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getAlwaysFailure()
	 * @generated
	 */
	int ALWAYS_FAILURE = 10;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_FAILURE__ATTRIBUTES = ABSTRACT_ACTION__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Always Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_FAILURE_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Always Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_FAILURE_OPERATION_COUNT = ABSTRACT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.SequenceImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 11;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__ATTRIBUTES = CONTROL_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__NODES = CONTROL_NODE__NODES;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_OPERATION_COUNT = CONTROL_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.RepeatImpl <em>Repeat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.RepeatImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getRepeat()
	 * @generated
	 */
	int REPEAT = 12;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Repeat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Repeat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.TimeoutImpl <em>Timeout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.TimeoutImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getTimeout()
	 * @generated
	 */
	int TIMEOUT = 13;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Timeout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Timeout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.RetryUntilSuccessImpl <em>Retry Until Success</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.RetryUntilSuccessImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getRetryUntilSuccess()
	 * @generated
	 */
	int RETRY_UNTIL_SUCCESS = 14;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETRY_UNTIL_SUCCESS__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETRY_UNTIL_SUCCESS__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Retry Until Success</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETRY_UNTIL_SUCCESS_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Retry Until Success</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETRY_UNTIL_SUCCESS_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.InverterImpl <em>Inverter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.InverterImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getInverter()
	 * @generated
	 */
	int INVERTER = 15;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERTER__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERTER__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Inverter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERTER_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Inverter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERTER_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.SequenceStarImpl <em>Sequence Star</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.SequenceStarImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getSequenceStar()
	 * @generated
	 */
	int SEQUENCE_STAR = 16;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_STAR__ATTRIBUTES = CONTROL_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_STAR__NODES = CONTROL_NODE__NODES;

	/**
	 * The number of structural features of the '<em>Sequence Star</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_STAR_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sequence Star</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_STAR_OPERATION_COUNT = CONTROL_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.FallbackImpl <em>Fallback</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.FallbackImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getFallback()
	 * @generated
	 */
	int FALLBACK = 17;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALLBACK__ATTRIBUTES = CONTROL_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALLBACK__NODES = CONTROL_NODE__NODES;

	/**
	 * The number of structural features of the '<em>Fallback</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALLBACK_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fallback</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALLBACK_OPERATION_COUNT = CONTROL_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.FallbackStarImpl <em>Fallback Star</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.FallbackStarImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getFallbackStar()
	 * @generated
	 */
	int FALLBACK_STAR = 18;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALLBACK_STAR__ATTRIBUTES = CONTROL_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALLBACK_STAR__NODES = CONTROL_NODE__NODES;

	/**
	 * The number of structural features of the '<em>Fallback Star</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALLBACK_STAR_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fallback Star</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALLBACK_STAR_OPERATION_COUNT = CONTROL_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ParallelImpl <em>Parallel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ParallelImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getParallel()
	 * @generated
	 */
	int PARALLEL = 19;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__ATTRIBUTES = CONTROL_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__NODES = CONTROL_NODE__NODES;

	/**
	 * The number of structural features of the '<em>Parallel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parallel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_OPERATION_COUNT = CONTROL_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.SubtreeNodeImpl <em>Subtree Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.SubtreeNodeImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getSubtreeNode()
	 * @generated
	 */
	int SUBTREE_NODE = 20;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_NODE__ATTRIBUTES = TREE_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Behaviortree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_NODE__BEHAVIORTREE = TREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subtree Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_NODE_FEATURE_COUNT = TREE_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Subtree Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_NODE_OPERATION_COUNT = TREE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.BTModelImpl <em>BT Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.BTModelImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getBTModel()
	 * @generated
	 */
	int BT_MODEL = 21;

	/**
	 * The feature id for the '<em><b>Trees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_MODEL__TREES = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_MODEL__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Main tree to execute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_MODEL__MAIN_TREE_TO_EXECUTE = 2;

	/**
	 * The feature id for the '<em><b>Nodesmodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_MODEL__NODESMODEL = 3;

	/**
	 * The number of structural features of the '<em>BT Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>BT Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BT_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ImportImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 22;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORT_URI = 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.SetBlackboardImpl <em>Set Blackboard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.SetBlackboardImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getSetBlackboard()
	 * @generated
	 */
	int SET_BLACKBOARD = 23;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_BLACKBOARD__ATTRIBUTES = ABSTRACT_ACTION__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Set Blackboard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_BLACKBOARD_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Set Blackboard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_BLACKBOARD_OPERATION_COUNT = ABSTRACT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.BlackboardCheckDoubleImpl <em>Blackboard Check Double</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.BlackboardCheckDoubleImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getBlackboardCheckDouble()
	 * @generated
	 */
	int BLACKBOARD_CHECK_DOUBLE = 24;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_DOUBLE__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_DOUBLE__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Blackboard Check Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_DOUBLE_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Blackboard Check Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_DOUBLE_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.BlackboardCheckIntImpl <em>Blackboard Check Int</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.BlackboardCheckIntImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getBlackboardCheckInt()
	 * @generated
	 */
	int BLACKBOARD_CHECK_INT = 25;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_INT__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_INT__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Blackboard Check Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_INT_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Blackboard Check Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_INT_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.BlackboardCheckStringImpl <em>Blackboard Check String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.BlackboardCheckStringImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getBlackboardCheckString()
	 * @generated
	 */
	int BLACKBOARD_CHECK_STRING = 26;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_STRING__ATTRIBUTES = DECORATOR_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_STRING__NODE = DECORATOR_NODE__NODE;

	/**
	 * The number of structural features of the '<em>Blackboard Check String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_STRING_FEATURE_COUNT = DECORATOR_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Blackboard Check String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKBOARD_CHECK_STRING_OPERATION_COUNT = DECORATOR_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.ActionImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 27;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ATTRIBUTES = ABSTRACT_ACTION__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = ABSTRACT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.AttributeImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.SubtreePlusImpl <em>Subtree Plus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.SubtreePlusImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getSubtreePlus()
	 * @generated
	 */
	int SUBTREE_PLUS = 29;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_PLUS__ATTRIBUTES = SUBTREE_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Behaviortree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_PLUS__BEHAVIORTREE = SUBTREE_NODE__BEHAVIORTREE;

	/**
	 * The number of structural features of the '<em>Subtree Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_PLUS_FEATURE_COUNT = SUBTREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Subtree Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_PLUS_OPERATION_COUNT = SUBTREE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.SwitchImpl <em>Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.SwitchImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getSwitch()
	 * @generated
	 */
	int SWITCH = 30;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__ATTRIBUTES = CONTROL_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__NODES = CONTROL_NODE__NODES;

	/**
	 * The number of structural features of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_OPERATION_COUNT = CONTROL_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.SubtreeImpl <em>Subtree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.SubtreeImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getSubtree()
	 * @generated
	 */
	int SUBTREE = 31;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE__ATTRIBUTES = SUBTREE_NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Behaviortree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE__BEHAVIORTREE = SUBTREE_NODE__BEHAVIORTREE;

	/**
	 * The number of structural features of the '<em>Subtree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_FEATURE_COUNT = SUBTREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Subtree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTREE_OPERATION_COUNT = SUBTREE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link behaviortree.impl.TreeNodesModelImpl <em>Tree Nodes Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see behaviortree.impl.TreeNodesModelImpl
	 * @see behaviortree.impl.BehaviorTreePackageImpl#getTreeNodesModel()
	 * @generated
	 */
	int TREE_NODES_MODEL = 32;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODES_MODEL__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Tree Nodes Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODES_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tree Nodes Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODES_MODEL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link behaviortree.BehaviorTree <em>Behavior Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Tree</em>'.
	 * @see behaviortree.BehaviorTree
	 * @generated
	 */
	EClass getBehaviorTree();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.BehaviorTree#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see behaviortree.BehaviorTree#getNodes()
	 * @see #getBehaviorTree()
	 * @generated
	 */
	EReference getBehaviorTree_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.BehaviorTree#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see behaviortree.BehaviorTree#getAttributes()
	 * @see #getBehaviorTree()
	 * @generated
	 */
	EReference getBehaviorTree_Attributes();

	/**
	 * Returns the meta object for class '{@link behaviortree.TreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Node</em>'.
	 * @see behaviortree.TreeNode
	 * @generated
	 */
	EClass getTreeNode();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.TreeNode#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see behaviortree.TreeNode#getAttributes()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Attributes();

	/**
	 * Returns the meta object for class '{@link behaviortree.ControlNode <em>Control Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Node</em>'.
	 * @see behaviortree.ControlNode
	 * @generated
	 */
	EClass getControlNode();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.ControlNode#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see behaviortree.ControlNode#getNodes()
	 * @see #getControlNode()
	 * @generated
	 */
	EReference getControlNode_Nodes();

	/**
	 * Returns the meta object for class '{@link behaviortree.LeafNode <em>Leaf Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Node</em>'.
	 * @see behaviortree.LeafNode
	 * @generated
	 */
	EClass getLeafNode();

	/**
	 * Returns the meta object for class '{@link behaviortree.DecoratorNode <em>Decorator Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decorator Node</em>'.
	 * @see behaviortree.DecoratorNode
	 * @generated
	 */
	EClass getDecoratorNode();

	/**
	 * Returns the meta object for the containment reference '{@link behaviortree.DecoratorNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see behaviortree.DecoratorNode#getNode()
	 * @see #getDecoratorNode()
	 * @generated
	 */
	EReference getDecoratorNode_Node();

	/**
	 * Returns the meta object for class '{@link behaviortree.AbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Action</em>'.
	 * @see behaviortree.AbstractAction
	 * @generated
	 */
	EClass getAbstractAction();

	/**
	 * Returns the meta object for class '{@link behaviortree.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see behaviortree.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link behaviortree.ForceSuccess <em>Force Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Force Success</em>'.
	 * @see behaviortree.ForceSuccess
	 * @generated
	 */
	EClass getForceSuccess();

	/**
	 * Returns the meta object for class '{@link behaviortree.ForceFailure <em>Force Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Force Failure</em>'.
	 * @see behaviortree.ForceFailure
	 * @generated
	 */
	EClass getForceFailure();

	/**
	 * Returns the meta object for class '{@link behaviortree.AlwaysSuccess <em>Always Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Always Success</em>'.
	 * @see behaviortree.AlwaysSuccess
	 * @generated
	 */
	EClass getAlwaysSuccess();

	/**
	 * Returns the meta object for class '{@link behaviortree.AlwaysFailure <em>Always Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Always Failure</em>'.
	 * @see behaviortree.AlwaysFailure
	 * @generated
	 */
	EClass getAlwaysFailure();

	/**
	 * Returns the meta object for class '{@link behaviortree.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see behaviortree.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for class '{@link behaviortree.Repeat <em>Repeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repeat</em>'.
	 * @see behaviortree.Repeat
	 * @generated
	 */
	EClass getRepeat();

	/**
	 * Returns the meta object for class '{@link behaviortree.Timeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timeout</em>'.
	 * @see behaviortree.Timeout
	 * @generated
	 */
	EClass getTimeout();

	/**
	 * Returns the meta object for class '{@link behaviortree.RetryUntilSuccess <em>Retry Until Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Retry Until Success</em>'.
	 * @see behaviortree.RetryUntilSuccess
	 * @generated
	 */
	EClass getRetryUntilSuccess();

	/**
	 * Returns the meta object for class '{@link behaviortree.Inverter <em>Inverter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inverter</em>'.
	 * @see behaviortree.Inverter
	 * @generated
	 */
	EClass getInverter();

	/**
	 * Returns the meta object for class '{@link behaviortree.SequenceStar <em>Sequence Star</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Star</em>'.
	 * @see behaviortree.SequenceStar
	 * @generated
	 */
	EClass getSequenceStar();

	/**
	 * Returns the meta object for class '{@link behaviortree.Fallback <em>Fallback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fallback</em>'.
	 * @see behaviortree.Fallback
	 * @generated
	 */
	EClass getFallback();

	/**
	 * Returns the meta object for class '{@link behaviortree.FallbackStar <em>Fallback Star</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fallback Star</em>'.
	 * @see behaviortree.FallbackStar
	 * @generated
	 */
	EClass getFallbackStar();

	/**
	 * Returns the meta object for class '{@link behaviortree.Parallel <em>Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel</em>'.
	 * @see behaviortree.Parallel
	 * @generated
	 */
	EClass getParallel();

	/**
	 * Returns the meta object for class '{@link behaviortree.SubtreeNode <em>Subtree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subtree Node</em>'.
	 * @see behaviortree.SubtreeNode
	 * @generated
	 */
	EClass getSubtreeNode();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.SubtreeNode#getBehaviortree <em>Behaviortree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behaviortree</em>'.
	 * @see behaviortree.SubtreeNode#getBehaviortree()
	 * @see #getSubtreeNode()
	 * @generated
	 */
	EReference getSubtreeNode_Behaviortree();

	/**
	 * Returns the meta object for class '{@link behaviortree.BTModel <em>BT Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BT Model</em>'.
	 * @see behaviortree.BTModel
	 * @generated
	 */
	EClass getBTModel();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.BTModel#getTrees <em>Trees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trees</em>'.
	 * @see behaviortree.BTModel#getTrees()
	 * @see #getBTModel()
	 * @generated
	 */
	EReference getBTModel_Trees();

	/**
	 * Returns the meta object for the containment reference list '{@link behaviortree.BTModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see behaviortree.BTModel#getImports()
	 * @see #getBTModel()
	 * @generated
	 */
	EReference getBTModel_Imports();

	/**
	 * Returns the meta object for the reference '{@link behaviortree.BTModel#getMain_tree_to_execute <em>Main tree to execute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main tree to execute</em>'.
	 * @see behaviortree.BTModel#getMain_tree_to_execute()
	 * @see #getBTModel()
	 * @generated
	 */
	EReference getBTModel_Main_tree_to_execute();

	/**
	 * Returns the meta object for the containment reference '{@link behaviortree.BTModel#getNodesmodel <em>Nodesmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Nodesmodel</em>'.
	 * @see behaviortree.BTModel#getNodesmodel()
	 * @see #getBTModel()
	 * @generated
	 */
	EReference getBTModel_Nodesmodel();

	/**
	 * Returns the meta object for class '{@link behaviortree.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see behaviortree.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Import#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see behaviortree.Import#getImportURI()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportURI();

	/**
	 * Returns the meta object for class '{@link behaviortree.SetBlackboard <em>Set Blackboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Blackboard</em>'.
	 * @see behaviortree.SetBlackboard
	 * @generated
	 */
	EClass getSetBlackboard();

	/**
	 * Returns the meta object for class '{@link behaviortree.BlackboardCheckDouble <em>Blackboard Check Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blackboard Check Double</em>'.
	 * @see behaviortree.BlackboardCheckDouble
	 * @generated
	 */
	EClass getBlackboardCheckDouble();

	/**
	 * Returns the meta object for class '{@link behaviortree.BlackboardCheckInt <em>Blackboard Check Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blackboard Check Int</em>'.
	 * @see behaviortree.BlackboardCheckInt
	 * @generated
	 */
	EClass getBlackboardCheckInt();

	/**
	 * Returns the meta object for class '{@link behaviortree.BlackboardCheckString <em>Blackboard Check String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blackboard Check String</em>'.
	 * @see behaviortree.BlackboardCheckString
	 * @generated
	 */
	EClass getBlackboardCheckString();

	/**
	 * Returns the meta object for class '{@link behaviortree.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see behaviortree.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link behaviortree.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see behaviortree.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see behaviortree.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see behaviortree.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for class '{@link behaviortree.SubtreePlus <em>Subtree Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subtree Plus</em>'.
	 * @see behaviortree.SubtreePlus
	 * @generated
	 */
	EClass getSubtreePlus();

	/**
	 * Returns the meta object for class '{@link behaviortree.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch</em>'.
	 * @see behaviortree.Switch
	 * @generated
	 */
	EClass getSwitch();

	/**
	 * Returns the meta object for class '{@link behaviortree.Subtree <em>Subtree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subtree</em>'.
	 * @see behaviortree.Subtree
	 * @generated
	 */
	EClass getSubtree();

	/**
	 * Returns the meta object for class '{@link behaviortree.TreeNodesModel <em>Tree Nodes Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Nodes Model</em>'.
	 * @see behaviortree.TreeNodesModel
	 * @generated
	 */
	EClass getTreeNodesModel();

	/**
	 * Returns the meta object for the attribute '{@link behaviortree.TreeNodesModel#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see behaviortree.TreeNodesModel#getContent()
	 * @see #getTreeNodesModel()
	 * @generated
	 */
	EAttribute getTreeNodesModel_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BehaviorTreeFactory getBehaviorTreeFactory();

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
		 * The meta object literal for the '{@link behaviortree.impl.BehaviorTreeImpl <em>Behavior Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.BehaviorTreeImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getBehaviorTree()
		 * @generated
		 */
		EClass BEHAVIOR_TREE = eINSTANCE.getBehaviorTree();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TREE__NODES = eINSTANCE.getBehaviorTree_Nodes();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TREE__ATTRIBUTES = eINSTANCE.getBehaviorTree_Attributes();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.TreeNodeImpl <em>Tree Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.TreeNodeImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getTreeNode()
		 * @generated
		 */
		EClass TREE_NODE = eINSTANCE.getTreeNode();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__ATTRIBUTES = eINSTANCE.getTreeNode_Attributes();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ControlNodeImpl <em>Control Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ControlNodeImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getControlNode()
		 * @generated
		 */
		EClass CONTROL_NODE = eINSTANCE.getControlNode();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_NODE__NODES = eINSTANCE.getControlNode_Nodes();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.LeafNodeImpl <em>Leaf Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.LeafNodeImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getLeafNode()
		 * @generated
		 */
		EClass LEAF_NODE = eINSTANCE.getLeafNode();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.DecoratorNodeImpl <em>Decorator Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.DecoratorNodeImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getDecoratorNode()
		 * @generated
		 */
		EClass DECORATOR_NODE = eINSTANCE.getDecoratorNode();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECORATOR_NODE__NODE = eINSTANCE.getDecoratorNode_Node();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.AbstractActionImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getAbstractAction()
		 * @generated
		 */
		EClass ABSTRACT_ACTION = eINSTANCE.getAbstractAction();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ConditionImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ForceSuccessImpl <em>Force Success</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ForceSuccessImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getForceSuccess()
		 * @generated
		 */
		EClass FORCE_SUCCESS = eINSTANCE.getForceSuccess();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ForceFailureImpl <em>Force Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ForceFailureImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getForceFailure()
		 * @generated
		 */
		EClass FORCE_FAILURE = eINSTANCE.getForceFailure();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.AlwaysSuccessImpl <em>Always Success</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.AlwaysSuccessImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getAlwaysSuccess()
		 * @generated
		 */
		EClass ALWAYS_SUCCESS = eINSTANCE.getAlwaysSuccess();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.AlwaysFailureImpl <em>Always Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.AlwaysFailureImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getAlwaysFailure()
		 * @generated
		 */
		EClass ALWAYS_FAILURE = eINSTANCE.getAlwaysFailure();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.SequenceImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.RepeatImpl <em>Repeat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.RepeatImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getRepeat()
		 * @generated
		 */
		EClass REPEAT = eINSTANCE.getRepeat();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.TimeoutImpl <em>Timeout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.TimeoutImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getTimeout()
		 * @generated
		 */
		EClass TIMEOUT = eINSTANCE.getTimeout();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.RetryUntilSuccessImpl <em>Retry Until Success</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.RetryUntilSuccessImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getRetryUntilSuccess()
		 * @generated
		 */
		EClass RETRY_UNTIL_SUCCESS = eINSTANCE.getRetryUntilSuccess();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.InverterImpl <em>Inverter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.InverterImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getInverter()
		 * @generated
		 */
		EClass INVERTER = eINSTANCE.getInverter();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.SequenceStarImpl <em>Sequence Star</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.SequenceStarImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getSequenceStar()
		 * @generated
		 */
		EClass SEQUENCE_STAR = eINSTANCE.getSequenceStar();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.FallbackImpl <em>Fallback</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.FallbackImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getFallback()
		 * @generated
		 */
		EClass FALLBACK = eINSTANCE.getFallback();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.FallbackStarImpl <em>Fallback Star</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.FallbackStarImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getFallbackStar()
		 * @generated
		 */
		EClass FALLBACK_STAR = eINSTANCE.getFallbackStar();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ParallelImpl <em>Parallel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ParallelImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getParallel()
		 * @generated
		 */
		EClass PARALLEL = eINSTANCE.getParallel();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.SubtreeNodeImpl <em>Subtree Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.SubtreeNodeImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getSubtreeNode()
		 * @generated
		 */
		EClass SUBTREE_NODE = eINSTANCE.getSubtreeNode();

		/**
		 * The meta object literal for the '<em><b>Behaviortree</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBTREE_NODE__BEHAVIORTREE = eINSTANCE.getSubtreeNode_Behaviortree();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.BTModelImpl <em>BT Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.BTModelImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getBTModel()
		 * @generated
		 */
		EClass BT_MODEL = eINSTANCE.getBTModel();

		/**
		 * The meta object literal for the '<em><b>Trees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BT_MODEL__TREES = eINSTANCE.getBTModel_Trees();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BT_MODEL__IMPORTS = eINSTANCE.getBTModel_Imports();

		/**
		 * The meta object literal for the '<em><b>Main tree to execute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BT_MODEL__MAIN_TREE_TO_EXECUTE = eINSTANCE.getBTModel_Main_tree_to_execute();

		/**
		 * The meta object literal for the '<em><b>Nodesmodel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BT_MODEL__NODESMODEL = eINSTANCE.getBTModel_Nodesmodel();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ImportImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.SetBlackboardImpl <em>Set Blackboard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.SetBlackboardImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getSetBlackboard()
		 * @generated
		 */
		EClass SET_BLACKBOARD = eINSTANCE.getSetBlackboard();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.BlackboardCheckDoubleImpl <em>Blackboard Check Double</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.BlackboardCheckDoubleImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getBlackboardCheckDouble()
		 * @generated
		 */
		EClass BLACKBOARD_CHECK_DOUBLE = eINSTANCE.getBlackboardCheckDouble();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.BlackboardCheckIntImpl <em>Blackboard Check Int</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.BlackboardCheckIntImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getBlackboardCheckInt()
		 * @generated
		 */
		EClass BLACKBOARD_CHECK_INT = eINSTANCE.getBlackboardCheckInt();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.BlackboardCheckStringImpl <em>Blackboard Check String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.BlackboardCheckStringImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getBlackboardCheckString()
		 * @generated
		 */
		EClass BLACKBOARD_CHECK_STRING = eINSTANCE.getBlackboardCheckString();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.ActionImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.AttributeImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.SubtreePlusImpl <em>Subtree Plus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.SubtreePlusImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getSubtreePlus()
		 * @generated
		 */
		EClass SUBTREE_PLUS = eINSTANCE.getSubtreePlus();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.SwitchImpl <em>Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.SwitchImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getSwitch()
		 * @generated
		 */
		EClass SWITCH = eINSTANCE.getSwitch();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.SubtreeImpl <em>Subtree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.SubtreeImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getSubtree()
		 * @generated
		 */
		EClass SUBTREE = eINSTANCE.getSubtree();

		/**
		 * The meta object literal for the '{@link behaviortree.impl.TreeNodesModelImpl <em>Tree Nodes Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see behaviortree.impl.TreeNodesModelImpl
		 * @see behaviortree.impl.BehaviorTreePackageImpl#getTreeNodesModel()
		 * @generated
		 */
		EClass TREE_NODES_MODEL = eINSTANCE.getTreeNodesModel();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_NODES_MODEL__CONTENT = eINSTANCE.getTreeNodesModel_Content();

	}

} //BehaviorTreePackage
