/**
 */
package behaviortree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behaviortree.BehaviorTreePackage
 * @generated
 */
public interface BehaviorTreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BehaviorTreeFactory eINSTANCE = behaviortree.impl.BehaviorTreeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Behavior Tree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Tree</em>'.
	 * @generated
	 */
	BehaviorTree createBehaviorTree();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

	/**
	 * Returns a new object of class '<em>Force Success</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Force Success</em>'.
	 * @generated
	 */
	ForceSuccess createForceSuccess();

	/**
	 * Returns a new object of class '<em>Force Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Force Failure</em>'.
	 * @generated
	 */
	ForceFailure createForceFailure();

	/**
	 * Returns a new object of class '<em>Always Success</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Always Success</em>'.
	 * @generated
	 */
	AlwaysSuccess createAlwaysSuccess();

	/**
	 * Returns a new object of class '<em>Always Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Always Failure</em>'.
	 * @generated
	 */
	AlwaysFailure createAlwaysFailure();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>Repeat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repeat</em>'.
	 * @generated
	 */
	Repeat createRepeat();

	/**
	 * Returns a new object of class '<em>Timeout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timeout</em>'.
	 * @generated
	 */
	Timeout createTimeout();

	/**
	 * Returns a new object of class '<em>Retry Until Success</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Retry Until Success</em>'.
	 * @generated
	 */
	RetryUntilSuccess createRetryUntilSuccess();

	/**
	 * Returns a new object of class '<em>Inverter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inverter</em>'.
	 * @generated
	 */
	Inverter createInverter();

	/**
	 * Returns a new object of class '<em>Sequence Star</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Star</em>'.
	 * @generated
	 */
	SequenceStar createSequenceStar();

	/**
	 * Returns a new object of class '<em>Fallback</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fallback</em>'.
	 * @generated
	 */
	Fallback createFallback();

	/**
	 * Returns a new object of class '<em>Fallback Star</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fallback Star</em>'.
	 * @generated
	 */
	FallbackStar createFallbackStar();

	/**
	 * Returns a new object of class '<em>Parallel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel</em>'.
	 * @generated
	 */
	Parallel createParallel();

	/**
	 * Returns a new object of class '<em>Subtree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subtree</em>'.
	 * @generated
	 */
	Subtree createSubtree();

	/**
	 * Returns a new object of class '<em>BT Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BT Model</em>'.
	 * @generated
	 */
	BTModel createBTModel();

	/**
	 * Returns a new object of class '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import</em>'.
	 * @generated
	 */
	Import createImport();

	/**
	 * Returns a new object of class '<em>Set Blackboard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Blackboard</em>'.
	 * @generated
	 */
	SetBlackboard createSetBlackboard();

	/**
	 * Returns a new object of class '<em>Blackboard Check Double</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Blackboard Check Double</em>'.
	 * @generated
	 */
	BlackboardCheckDouble createBlackboardCheckDouble();

	/**
	 * Returns a new object of class '<em>Blackboard Check Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Blackboard Check Int</em>'.
	 * @generated
	 */
	BlackboardCheckInt createBlackboardCheckInt();

	/**
	 * Returns a new object of class '<em>Blackboard Check String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Blackboard Check String</em>'.
	 * @generated
	 */
	BlackboardCheckString createBlackboardCheckString();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Returns a new object of class '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute</em>'.
	 * @generated
	 */
	Attribute createAttribute();

	/**
	 * Returns a new object of class '<em>Switch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch</em>'.
	 * @generated
	 */
	Switch createSwitch();

	/**
	 * Returns a new object of class '<em>Sub Tree Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Tree Wrapper</em>'.
	 * @generated
	 */
	SubTreeWrapper createSubTreeWrapper();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BehaviorTreePackage getBehaviorTreePackage();

} //BehaviorTreeFactory
