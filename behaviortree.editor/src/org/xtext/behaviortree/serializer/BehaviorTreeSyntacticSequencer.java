package org.xtext.behaviortree.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;

import behaviortree.Switch;

public class BehaviorTreeSyntacticSequencer extends AbstractBehaviorTreeSyntacticSequencer {
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getSUBTREEWRAPPER_KEYWORDRule())
			return getSUBTREEWRAPPER_KEYWORDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSUBTREE_KEYWORDRule())
			return getSUBTREE_KEYWORDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSWITCH_KEYWORDRule())
			return getSWITCH_KEYWORDToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal SWITCH_KEYWORD: 
	 * 	('S'|'s') 'witch' INT
	 * ;
	 */
	@Override
	protected String getSWITCH_KEYWORDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		String token = "Switch"; 
		
		if(semanticObject instanceof Switch) {
			int n = ((Switch)semanticObject).getNodes().size() - 1;
			return token + n;
		}
		return token;
	}
}
