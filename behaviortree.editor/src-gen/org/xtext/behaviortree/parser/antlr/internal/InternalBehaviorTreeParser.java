package org.xtext.behaviortree.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.behaviortree.services.BehaviorTreeGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBehaviorTreeParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BlackboardCheckDouble", "BlackboardCheckString", "Main_tree_to_execute", "RetryUntilSuccesful", "BlackboardCheckInt", "AlwaysFailure", "AlwaysSuccess", "SetBlackboard", "BehaviorTree", "FallbackStar", "ForceFailure", "ForceSuccess", "SequenceStar", "Condition", "Fallback", "Inverter", "Parallel", "Sequence", "Timeout", "Include", "Action", "Repeat", "Path", "Root", "SolidusGreaterThanSign", "LessThanSignSolidus", "LessThanSign", "EqualsSign", "GreaterThanSign", "RULE_WS", "RULE_DEFINITION_STRING", "RULE_INT", "RULE_SWITCH_KEYWORD", "RULE_SUBTREE_KEYWORD", "RULE_SUBTREEWRAPPER_KEYWORD", "RULE_ML_COMMENT", "RULE_ID", "RULE_STRING", "RULE_SL_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int Include=23;
    public static final int Repeat=25;
    public static final int Parallel=20;
    public static final int ForceFailure=14;
    public static final int LessThanSign=30;
    public static final int AlwaysSuccess=10;
    public static final int ForceSuccess=15;
    public static final int AlwaysFailure=9;
    public static final int BlackboardCheckInt=8;
    public static final int GreaterThanSign=32;
    public static final int RetryUntilSuccesful=7;
    public static final int SetBlackboard=11;
    public static final int Root=27;
    public static final int RULE_ID=40;
    public static final int Timeout=22;
    public static final int Sequence=21;
    public static final int RULE_INT=35;
    public static final int Fallback=18;
    public static final int RULE_ML_COMMENT=39;
    public static final int SolidusGreaterThanSign=28;
    public static final int SequenceStar=16;
    public static final int Action=24;
    public static final int RULE_STRING=41;
    public static final int RULE_SUBTREE_KEYWORD=37;
    public static final int RULE_SL_COMMENT=42;
    public static final int EqualsSign=31;
    public static final int BlackboardCheckDouble=4;
    public static final int EOF=-1;
    public static final int Condition=17;
    public static final int Inverter=19;
    public static final int Path=26;
    public static final int RULE_WS=33;
    public static final int RULE_SUBTREEWRAPPER_KEYWORD=38;
    public static final int RULE_ANY_OTHER=43;
    public static final int BehaviorTree=12;
    public static final int Main_tree_to_execute=6;
    public static final int RULE_DEFINITION_STRING=34;
    public static final int FallbackStar=13;
    public static final int RULE_SWITCH_KEYWORD=36;
    public static final int BlackboardCheckString=5;
    public static final int LessThanSignSolidus=29;

    // delegates
    // delegators


        public InternalBehaviorTreeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBehaviorTreeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBehaviorTreeParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBehaviorTreeParser.g"; }



     	private BehaviorTreeGrammarAccess grammarAccess;

        public InternalBehaviorTreeParser(TokenStream input, BehaviorTreeGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "BTModel";
       	}

       	@Override
       	protected BehaviorTreeGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleBTModel"
    // InternalBehaviorTreeParser.g:57:1: entryRuleBTModel returns [EObject current=null] : iv_ruleBTModel= ruleBTModel EOF ;
    public final EObject entryRuleBTModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBTModel = null;


        try {
            // InternalBehaviorTreeParser.g:57:48: (iv_ruleBTModel= ruleBTModel EOF )
            // InternalBehaviorTreeParser.g:58:2: iv_ruleBTModel= ruleBTModel EOF
            {
             newCompositeNode(grammarAccess.getBTModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBTModel=ruleBTModel();

            state._fsp--;

             current =iv_ruleBTModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBTModel"


    // $ANTLR start "ruleBTModel"
    // InternalBehaviorTreeParser.g:64:1: ruleBTModel returns [EObject current=null] : (otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?) ) ) otherlv_10= LessThanSignSolidus otherlv_11= Root otherlv_12= GreaterThanSign ) ;
    public final EObject ruleBTModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_imports_6_0 = null;

        EObject lv_trees_8_0 = null;

        EObject lv_nodesmodel_9_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:70:2: ( (otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?) ) ) otherlv_10= LessThanSignSolidus otherlv_11= Root otherlv_12= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:71:2: (otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?) ) ) otherlv_10= LessThanSignSolidus otherlv_11= Root otherlv_12= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:71:2: (otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?) ) ) otherlv_10= LessThanSignSolidus otherlv_11= Root otherlv_12= GreaterThanSign )
            // InternalBehaviorTreeParser.g:72:3: otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( ( ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?) ) ) otherlv_10= LessThanSignSolidus otherlv_11= Root otherlv_12= GreaterThanSign
            {
            otherlv_0=(Token)match(input,LessThanSign,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBTModelAccess().getLessThanSignKeyword_0());
            		
            otherlv_1=(Token)match(input,Root,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getBTModelAccess().getRootKeyword_1());
            		
            otherlv_2=(Token)match(input,Main_tree_to_execute,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getBTModelAccess().getMain_tree_to_executeKeyword_2());
            		
            otherlv_3=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getBTModelAccess().getEqualsSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:88:3: ( (otherlv_4= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:89:4: (otherlv_4= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:89:4: (otherlv_4= RULE_STRING )
            // InternalBehaviorTreeParser.g:90:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBTModelRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(otherlv_4, grammarAccess.getBTModelAccess().getMain_tree_to_executeBehaviorTreeCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_5, grammarAccess.getBTModelAccess().getGreaterThanSignKeyword_5());
            		
            // InternalBehaviorTreeParser.g:105:3: ( (lv_imports_6_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==LessThanSign) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==Include) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:106:4: (lv_imports_6_0= ruleImport )
            	    {
            	    // InternalBehaviorTreeParser.g:106:4: (lv_imports_6_0= ruleImport )
            	    // InternalBehaviorTreeParser.g:107:5: lv_imports_6_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getBTModelAccess().getImportsImportParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_imports_6_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBTModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_6_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalBehaviorTreeParser.g:124:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?) ) )
            // InternalBehaviorTreeParser.g:125:4: ( ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?) )
            {
            // InternalBehaviorTreeParser.g:125:4: ( ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?) )
            // InternalBehaviorTreeParser.g:126:5: ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBTModelAccess().getUnorderedGroup_7());
            				
            // InternalBehaviorTreeParser.g:129:5: ( ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?)
            // InternalBehaviorTreeParser.g:130:6: ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+ {...}?
            {
            // InternalBehaviorTreeParser.g:130:6: ( ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( LA3_0 == LessThanSign && getUnorderedGroupHelper().canSelect(grammarAccess.getBTModelAccess().getUnorderedGroup_7(), 0) ) {
                    alt3=1;
                }
                else if ( LA3_0 == RULE_DEFINITION_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getBTModelAccess().getUnorderedGroup_7(), 1) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:131:4: ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) )
            	    {
            	    // InternalBehaviorTreeParser.g:131:4: ({...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ ) )
            	    // InternalBehaviorTreeParser.g:132:5: {...}? => ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBTModelAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBTModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getBTModelAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // InternalBehaviorTreeParser.g:132:104: ( ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+ )
            	    // InternalBehaviorTreeParser.g:133:6: ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBTModelAccess().getUnorderedGroup_7(), 0);
            	    					
            	    // InternalBehaviorTreeParser.g:136:9: ({...}? => ( (lv_trees_8_0= ruleBehaviorTree ) ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==LessThanSign) ) {
            	            int LA2_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalBehaviorTreeParser.g:136:10: {...}? => ( (lv_trees_8_0= ruleBehaviorTree ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleBTModel", "true");
            	    	    }
            	    	    // InternalBehaviorTreeParser.g:136:19: ( (lv_trees_8_0= ruleBehaviorTree ) )
            	    	    // InternalBehaviorTreeParser.g:136:20: (lv_trees_8_0= ruleBehaviorTree )
            	    	    {
            	    	    // InternalBehaviorTreeParser.g:136:20: (lv_trees_8_0= ruleBehaviorTree )
            	    	    // InternalBehaviorTreeParser.g:137:10: lv_trees_8_0= ruleBehaviorTree
            	    	    {

            	    	    										newCompositeNode(grammarAccess.getBTModelAccess().getTreesBehaviorTreeParserRuleCall_7_0_0());
            	    	    									
            	    	    pushFollow(FOLLOW_9);
            	    	    lv_trees_8_0=ruleBehaviorTree();

            	    	    state._fsp--;


            	    	    										if (current==null) {
            	    	    											current = createModelElementForParent(grammarAccess.getBTModelRule());
            	    	    										}
            	    	    										add(
            	    	    											current,
            	    	    											"trees",
            	    	    											lv_trees_8_0,
            	    	    											"org.xtext.behaviortree.BehaviorTree.BehaviorTree");
            	    	    										afterParserOrEnumRuleCall();
            	    	    									

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBTModelAccess().getUnorderedGroup_7());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBehaviorTreeParser.g:159:4: ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) )
            	    {
            	    // InternalBehaviorTreeParser.g:159:4: ({...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) ) )
            	    // InternalBehaviorTreeParser.g:160:5: {...}? => ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBTModelAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBTModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getBTModelAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // InternalBehaviorTreeParser.g:160:104: ( ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) ) )
            	    // InternalBehaviorTreeParser.g:161:6: ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBTModelAccess().getUnorderedGroup_7(), 1);
            	    					
            	    // InternalBehaviorTreeParser.g:164:9: ({...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) ) )
            	    // InternalBehaviorTreeParser.g:164:10: {...}? => ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBTModel", "true");
            	    }
            	    // InternalBehaviorTreeParser.g:164:19: ( (lv_nodesmodel_9_0= ruleTreeNodesModel ) )
            	    // InternalBehaviorTreeParser.g:164:20: (lv_nodesmodel_9_0= ruleTreeNodesModel )
            	    {
            	    // InternalBehaviorTreeParser.g:164:20: (lv_nodesmodel_9_0= ruleTreeNodesModel )
            	    // InternalBehaviorTreeParser.g:165:10: lv_nodesmodel_9_0= ruleTreeNodesModel
            	    {

            	    										newCompositeNode(grammarAccess.getBTModelAccess().getNodesmodelTreeNodesModelParserRuleCall_7_1_0());
            	    									
            	    pushFollow(FOLLOW_9);
            	    lv_nodesmodel_9_0=ruleTreeNodesModel();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getBTModelRule());
            	    										}
            	    										set(
            	    											current,
            	    											"nodesmodel",
            	    											lv_nodesmodel_9_0,
            	    											"org.xtext.behaviortree.BehaviorTree.TreeNodesModel");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBTModelAccess().getUnorderedGroup_7());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getBTModelAccess().getUnorderedGroup_7()) ) {
                throw new FailedPredicateException(input, "ruleBTModel", "getUnorderedGroupHelper().canLeave(grammarAccess.getBTModelAccess().getUnorderedGroup_7())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBTModelAccess().getUnorderedGroup_7());
            				

            }

            otherlv_10=(Token)match(input,LessThanSignSolidus,FOLLOW_3); 

            			newLeafNode(otherlv_10, grammarAccess.getBTModelAccess().getLessThanSignSolidusKeyword_8());
            		
            otherlv_11=(Token)match(input,Root,FOLLOW_7); 

            			newLeafNode(otherlv_11, grammarAccess.getBTModelAccess().getRootKeyword_9());
            		
            otherlv_12=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getBTModelAccess().getGreaterThanSignKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBTModel"


    // $ANTLR start "entryRuleImport"
    // InternalBehaviorTreeParser.g:211:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalBehaviorTreeParser.g:211:47: (iv_ruleImport= ruleImport EOF )
            // InternalBehaviorTreeParser.g:212:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalBehaviorTreeParser.g:218:1: ruleImport returns [EObject current=null] : (otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:224:2: ( (otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:225:2: (otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:225:2: (otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:226:3: otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign
            {
            otherlv_0=(Token)match(input,LessThanSign,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getLessThanSignKeyword_0());
            		
            otherlv_1=(Token)match(input,Include,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getImportAccess().getIncludeKeyword_1());
            		
            otherlv_2=(Token)match(input,Path,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getPathKeyword_2());
            		
            otherlv_3=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getImportAccess().getEqualsSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:242:3: ( (lv_importURI_4_0= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:243:4: (lv_importURI_4_0= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:243:4: (lv_importURI_4_0= RULE_STRING )
            // InternalBehaviorTreeParser.g:244:5: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_importURI_4_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,SolidusGreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getImportAccess().getSolidusGreaterThanSignKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleBehaviorTree"
    // InternalBehaviorTreeParser.g:268:1: entryRuleBehaviorTree returns [EObject current=null] : iv_ruleBehaviorTree= ruleBehaviorTree EOF ;
    public final EObject entryRuleBehaviorTree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTree = null;


        try {
            // InternalBehaviorTreeParser.g:268:53: (iv_ruleBehaviorTree= ruleBehaviorTree EOF )
            // InternalBehaviorTreeParser.g:269:2: iv_ruleBehaviorTree= ruleBehaviorTree EOF
            {
             newCompositeNode(grammarAccess.getBehaviorTreeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBehaviorTree=ruleBehaviorTree();

            state._fsp--;

             current =iv_ruleBehaviorTree; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBehaviorTree"


    // $ANTLR start "ruleBehaviorTree"
    // InternalBehaviorTreeParser.g:275:1: ruleBehaviorTree returns [EObject current=null] : (otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign ) ;
    public final EObject ruleBehaviorTree() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_attributes_2_0 = null;

        EObject lv_nodes_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:281:2: ( (otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:282:2: (otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:282:2: (otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign )
            // InternalBehaviorTreeParser.g:283:3: otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign
            {
            otherlv_0=(Token)match(input,LessThanSign,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getBehaviorTreeAccess().getLessThanSignKeyword_0());
            		
            otherlv_1=(Token)match(input,BehaviorTree,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getBehaviorTreeAccess().getBehaviorTreeKeyword_1());
            		
            // InternalBehaviorTreeParser.g:291:3: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:292:4: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:292:4: (lv_attributes_2_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:293:5: lv_attributes_2_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getBehaviorTreeAccess().getAttributesAttributeParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_2_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBehaviorTreeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_2_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_3=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getBehaviorTreeAccess().getGreaterThanSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:314:3: ( (lv_nodes_4_0= ruleTreeNode ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==LessThanSign) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:315:4: (lv_nodes_4_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:315:4: (lv_nodes_4_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:316:5: lv_nodes_4_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getBehaviorTreeAccess().getNodesTreeNodeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_nodes_4_0=ruleTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBehaviorTreeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_4_0,
            	    						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            otherlv_5=(Token)match(input,LessThanSignSolidus,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getBehaviorTreeAccess().getLessThanSignSolidusKeyword_5());
            		
            otherlv_6=(Token)match(input,BehaviorTree,FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getBehaviorTreeAccess().getBehaviorTreeKeyword_6());
            		
            otherlv_7=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getBehaviorTreeAccess().getGreaterThanSignKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBehaviorTree"


    // $ANTLR start "entryRuleAttribute"
    // InternalBehaviorTreeParser.g:349:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalBehaviorTreeParser.g:349:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalBehaviorTreeParser.g:350:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalBehaviorTreeParser.g:356:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:362:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalBehaviorTreeParser.g:363:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalBehaviorTreeParser.g:363:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalBehaviorTreeParser.g:364:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalBehaviorTreeParser.g:364:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorTreeParser.g:365:4: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorTreeParser.g:365:4: (lv_name_0_0= RULE_ID )
            // InternalBehaviorTreeParser.g:366:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1());
            		
            // InternalBehaviorTreeParser.g:386:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:387:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:387:4: (lv_value_2_0= RULE_STRING )
            // InternalBehaviorTreeParser.g:388:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleTreeNode"
    // InternalBehaviorTreeParser.g:408:1: entryRuleTreeNode returns [EObject current=null] : iv_ruleTreeNode= ruleTreeNode EOF ;
    public final EObject entryRuleTreeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTreeNode = null;


        try {
            // InternalBehaviorTreeParser.g:408:49: (iv_ruleTreeNode= ruleTreeNode EOF )
            // InternalBehaviorTreeParser.g:409:2: iv_ruleTreeNode= ruleTreeNode EOF
            {
             newCompositeNode(grammarAccess.getTreeNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTreeNode=ruleTreeNode();

            state._fsp--;

             current =iv_ruleTreeNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTreeNode"


    // $ANTLR start "ruleTreeNode"
    // InternalBehaviorTreeParser.g:415:1: ruleTreeNode returns [EObject current=null] : (this_ControlNode_0= ruleControlNode | this_DecoratorNode_1= ruleDecoratorNode | this_LeafNode_2= ruleLeafNode | this_SubtreeNode_3= ruleSubtreeNode ) ;
    public final EObject ruleTreeNode() throws RecognitionException {
        EObject current = null;

        EObject this_ControlNode_0 = null;

        EObject this_DecoratorNode_1 = null;

        EObject this_LeafNode_2 = null;

        EObject this_SubtreeNode_3 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:421:2: ( (this_ControlNode_0= ruleControlNode | this_DecoratorNode_1= ruleDecoratorNode | this_LeafNode_2= ruleLeafNode | this_SubtreeNode_3= ruleSubtreeNode ) )
            // InternalBehaviorTreeParser.g:422:2: (this_ControlNode_0= ruleControlNode | this_DecoratorNode_1= ruleDecoratorNode | this_LeafNode_2= ruleLeafNode | this_SubtreeNode_3= ruleSubtreeNode )
            {
            // InternalBehaviorTreeParser.g:422:2: (this_ControlNode_0= ruleControlNode | this_DecoratorNode_1= ruleDecoratorNode | this_LeafNode_2= ruleLeafNode | this_SubtreeNode_3= ruleSubtreeNode )
            int alt6=4;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LessThanSign) ) {
                switch ( input.LA(2) ) {
                case BlackboardCheckDouble:
                case BlackboardCheckString:
                case RetryUntilSuccesful:
                case BlackboardCheckInt:
                case ForceFailure:
                case ForceSuccess:
                case Inverter:
                case Timeout:
                case Repeat:
                    {
                    alt6=2;
                    }
                    break;
                case FallbackStar:
                case SequenceStar:
                case Fallback:
                case Parallel:
                case Sequence:
                case RULE_SWITCH_KEYWORD:
                    {
                    alt6=1;
                    }
                    break;
                case AlwaysFailure:
                case AlwaysSuccess:
                case SetBlackboard:
                case Condition:
                case Action:
                    {
                    alt6=3;
                    }
                    break;
                case RULE_SUBTREE_KEYWORD:
                case RULE_SUBTREEWRAPPER_KEYWORD:
                    {
                    alt6=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBehaviorTreeParser.g:423:3: this_ControlNode_0= ruleControlNode
                    {

                    			newCompositeNode(grammarAccess.getTreeNodeAccess().getControlNodeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ControlNode_0=ruleControlNode();

                    state._fsp--;


                    			current = this_ControlNode_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBehaviorTreeParser.g:432:3: this_DecoratorNode_1= ruleDecoratorNode
                    {

                    			newCompositeNode(grammarAccess.getTreeNodeAccess().getDecoratorNodeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DecoratorNode_1=ruleDecoratorNode();

                    state._fsp--;


                    			current = this_DecoratorNode_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBehaviorTreeParser.g:441:3: this_LeafNode_2= ruleLeafNode
                    {

                    			newCompositeNode(grammarAccess.getTreeNodeAccess().getLeafNodeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_LeafNode_2=ruleLeafNode();

                    state._fsp--;


                    			current = this_LeafNode_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalBehaviorTreeParser.g:450:3: this_SubtreeNode_3= ruleSubtreeNode
                    {

                    			newCompositeNode(grammarAccess.getTreeNodeAccess().getSubtreeNodeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubtreeNode_3=ruleSubtreeNode();

                    state._fsp--;


                    			current = this_SubtreeNode_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTreeNode"


    // $ANTLR start "entryRuleSubtreeNode"
    // InternalBehaviorTreeParser.g:462:1: entryRuleSubtreeNode returns [EObject current=null] : iv_ruleSubtreeNode= ruleSubtreeNode EOF ;
    public final EObject entryRuleSubtreeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubtreeNode = null;


        try {
            // InternalBehaviorTreeParser.g:462:52: (iv_ruleSubtreeNode= ruleSubtreeNode EOF )
            // InternalBehaviorTreeParser.g:463:2: iv_ruleSubtreeNode= ruleSubtreeNode EOF
            {
             newCompositeNode(grammarAccess.getSubtreeNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubtreeNode=ruleSubtreeNode();

            state._fsp--;

             current =iv_ruleSubtreeNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubtreeNode"


    // $ANTLR start "ruleSubtreeNode"
    // InternalBehaviorTreeParser.g:469:1: ruleSubtreeNode returns [EObject current=null] : (this_Subtree_0= ruleSubtree | this_SubtreePlus_1= ruleSubtreePlus ) ;
    public final EObject ruleSubtreeNode() throws RecognitionException {
        EObject current = null;

        EObject this_Subtree_0 = null;

        EObject this_SubtreePlus_1 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:475:2: ( (this_Subtree_0= ruleSubtree | this_SubtreePlus_1= ruleSubtreePlus ) )
            // InternalBehaviorTreeParser.g:476:2: (this_Subtree_0= ruleSubtree | this_SubtreePlus_1= ruleSubtreePlus )
            {
            // InternalBehaviorTreeParser.g:476:2: (this_Subtree_0= ruleSubtree | this_SubtreePlus_1= ruleSubtreePlus )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LessThanSign) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_SUBTREEWRAPPER_KEYWORD) ) {
                    alt7=2;
                }
                else if ( (LA7_1==RULE_SUBTREE_KEYWORD) ) {
                    alt7=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBehaviorTreeParser.g:477:3: this_Subtree_0= ruleSubtree
                    {

                    			newCompositeNode(grammarAccess.getSubtreeNodeAccess().getSubtreeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Subtree_0=ruleSubtree();

                    state._fsp--;


                    			current = this_Subtree_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBehaviorTreeParser.g:486:3: this_SubtreePlus_1= ruleSubtreePlus
                    {

                    			newCompositeNode(grammarAccess.getSubtreeNodeAccess().getSubtreePlusParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubtreePlus_1=ruleSubtreePlus();

                    state._fsp--;


                    			current = this_SubtreePlus_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubtreeNode"


    // $ANTLR start "entryRuleSubtree"
    // InternalBehaviorTreeParser.g:498:1: entryRuleSubtree returns [EObject current=null] : iv_ruleSubtree= ruleSubtree EOF ;
    public final EObject entryRuleSubtree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubtree = null;


        try {
            // InternalBehaviorTreeParser.g:498:48: (iv_ruleSubtree= ruleSubtree EOF )
            // InternalBehaviorTreeParser.g:499:2: iv_ruleSubtree= ruleSubtree EOF
            {
             newCompositeNode(grammarAccess.getSubtreeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubtree=ruleSubtree();

            state._fsp--;

             current =iv_ruleSubtree; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubtree"


    // $ANTLR start "ruleSubtree"
    // InternalBehaviorTreeParser.g:505:1: ruleSubtree returns [EObject current=null] : ( () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign ) ;
    public final EObject ruleSubtree() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_SUBTREE_KEYWORD_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_attributes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:511:2: ( ( () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:512:2: ( () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:512:2: ( () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:513:3: () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:513:3: ()
            // InternalBehaviorTreeParser.g:514:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubtreeAccess().getSubtreeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getSubtreeAccess().getLessThanSignKeyword_1());
            		
            this_SUBTREE_KEYWORD_2=(Token)match(input,RULE_SUBTREE_KEYWORD,FOLLOW_5); 

            			newLeafNode(this_SUBTREE_KEYWORD_2, grammarAccess.getSubtreeAccess().getSUBTREE_KEYWORDTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getSubtreeAccess().getEqualsSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:532:3: ( (otherlv_4= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:533:4: (otherlv_4= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:533:4: (otherlv_4= RULE_STRING )
            // InternalBehaviorTreeParser.g:534:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubtreeRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_18); 

            					newLeafNode(otherlv_4, grammarAccess.getSubtreeAccess().getBehaviortreeBehaviorTreeCrossReference_4_0());
            				

            }


            }

            // InternalBehaviorTreeParser.g:545:3: ( (lv_attributes_5_0= ruleAttribute ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:546:4: (lv_attributes_5_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:546:4: (lv_attributes_5_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:547:5: lv_attributes_5_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSubtreeAccess().getAttributesAttributeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_attributes_5_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubtreeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_5_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_6=(Token)match(input,SolidusGreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSubtreeAccess().getSolidusGreaterThanSignKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubtree"


    // $ANTLR start "entryRuleSubtreePlus"
    // InternalBehaviorTreeParser.g:572:1: entryRuleSubtreePlus returns [EObject current=null] : iv_ruleSubtreePlus= ruleSubtreePlus EOF ;
    public final EObject entryRuleSubtreePlus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubtreePlus = null;


        try {
            // InternalBehaviorTreeParser.g:572:52: (iv_ruleSubtreePlus= ruleSubtreePlus EOF )
            // InternalBehaviorTreeParser.g:573:2: iv_ruleSubtreePlus= ruleSubtreePlus EOF
            {
             newCompositeNode(grammarAccess.getSubtreePlusRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubtreePlus=ruleSubtreePlus();

            state._fsp--;

             current =iv_ruleSubtreePlus; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubtreePlus"


    // $ANTLR start "ruleSubtreePlus"
    // InternalBehaviorTreeParser.g:579:1: ruleSubtreePlus returns [EObject current=null] : ( () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign ) ;
    public final EObject ruleSubtreePlus() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_SUBTREEWRAPPER_KEYWORD_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_attributes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:585:2: ( ( () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:586:2: ( () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:586:2: ( () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:587:3: () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:587:3: ()
            // InternalBehaviorTreeParser.g:588:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubtreePlusAccess().getSubtreePlusAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSubtreePlusAccess().getLessThanSignKeyword_1());
            		
            this_SUBTREEWRAPPER_KEYWORD_2=(Token)match(input,RULE_SUBTREEWRAPPER_KEYWORD,FOLLOW_5); 

            			newLeafNode(this_SUBTREEWRAPPER_KEYWORD_2, grammarAccess.getSubtreePlusAccess().getSUBTREEWRAPPER_KEYWORDTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getSubtreePlusAccess().getEqualsSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:606:3: ( (otherlv_4= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:607:4: (otherlv_4= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:607:4: (otherlv_4= RULE_STRING )
            // InternalBehaviorTreeParser.g:608:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubtreePlusRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_18); 

            					newLeafNode(otherlv_4, grammarAccess.getSubtreePlusAccess().getBehaviortreeBehaviorTreeCrossReference_4_0());
            				

            }


            }

            // InternalBehaviorTreeParser.g:619:3: ( (lv_attributes_5_0= ruleAttribute ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:620:4: (lv_attributes_5_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:620:4: (lv_attributes_5_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:621:5: lv_attributes_5_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSubtreePlusAccess().getAttributesAttributeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_attributes_5_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubtreePlusRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_5_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_6=(Token)match(input,SolidusGreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSubtreePlusAccess().getSolidusGreaterThanSignKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubtreePlus"


    // $ANTLR start "entryRuleControlNode"
    // InternalBehaviorTreeParser.g:646:1: entryRuleControlNode returns [EObject current=null] : iv_ruleControlNode= ruleControlNode EOF ;
    public final EObject entryRuleControlNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleControlNode = null;


        try {
            // InternalBehaviorTreeParser.g:646:52: (iv_ruleControlNode= ruleControlNode EOF )
            // InternalBehaviorTreeParser.g:647:2: iv_ruleControlNode= ruleControlNode EOF
            {
             newCompositeNode(grammarAccess.getControlNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleControlNode=ruleControlNode();

            state._fsp--;

             current =iv_ruleControlNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleControlNode"


    // $ANTLR start "ruleControlNode"
    // InternalBehaviorTreeParser.g:653:1: ruleControlNode returns [EObject current=null] : (this_Sequence_0= ruleSequence | this_SequenceStar_1= ruleSequenceStar | this_Parallel_2= ruleParallel | this_Fallback_3= ruleFallback | this_FallbackStar_4= ruleFallbackStar | this_Switch_5= ruleSwitch ) ;
    public final EObject ruleControlNode() throws RecognitionException {
        EObject current = null;

        EObject this_Sequence_0 = null;

        EObject this_SequenceStar_1 = null;

        EObject this_Parallel_2 = null;

        EObject this_Fallback_3 = null;

        EObject this_FallbackStar_4 = null;

        EObject this_Switch_5 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:659:2: ( (this_Sequence_0= ruleSequence | this_SequenceStar_1= ruleSequenceStar | this_Parallel_2= ruleParallel | this_Fallback_3= ruleFallback | this_FallbackStar_4= ruleFallbackStar | this_Switch_5= ruleSwitch ) )
            // InternalBehaviorTreeParser.g:660:2: (this_Sequence_0= ruleSequence | this_SequenceStar_1= ruleSequenceStar | this_Parallel_2= ruleParallel | this_Fallback_3= ruleFallback | this_FallbackStar_4= ruleFallbackStar | this_Switch_5= ruleSwitch )
            {
            // InternalBehaviorTreeParser.g:660:2: (this_Sequence_0= ruleSequence | this_SequenceStar_1= ruleSequenceStar | this_Parallel_2= ruleParallel | this_Fallback_3= ruleFallback | this_FallbackStar_4= ruleFallbackStar | this_Switch_5= ruleSwitch )
            int alt10=6;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LessThanSign) ) {
                switch ( input.LA(2) ) {
                case Parallel:
                    {
                    alt10=3;
                    }
                    break;
                case FallbackStar:
                    {
                    alt10=5;
                    }
                    break;
                case RULE_SWITCH_KEYWORD:
                    {
                    alt10=6;
                    }
                    break;
                case Sequence:
                    {
                    alt10=1;
                    }
                    break;
                case Fallback:
                    {
                    alt10=4;
                    }
                    break;
                case SequenceStar:
                    {
                    alt10=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalBehaviorTreeParser.g:661:3: this_Sequence_0= ruleSequence
                    {

                    			newCompositeNode(grammarAccess.getControlNodeAccess().getSequenceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Sequence_0=ruleSequence();

                    state._fsp--;


                    			current = this_Sequence_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBehaviorTreeParser.g:670:3: this_SequenceStar_1= ruleSequenceStar
                    {

                    			newCompositeNode(grammarAccess.getControlNodeAccess().getSequenceStarParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SequenceStar_1=ruleSequenceStar();

                    state._fsp--;


                    			current = this_SequenceStar_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBehaviorTreeParser.g:679:3: this_Parallel_2= ruleParallel
                    {

                    			newCompositeNode(grammarAccess.getControlNodeAccess().getParallelParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Parallel_2=ruleParallel();

                    state._fsp--;


                    			current = this_Parallel_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalBehaviorTreeParser.g:688:3: this_Fallback_3= ruleFallback
                    {

                    			newCompositeNode(grammarAccess.getControlNodeAccess().getFallbackParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Fallback_3=ruleFallback();

                    state._fsp--;


                    			current = this_Fallback_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalBehaviorTreeParser.g:697:3: this_FallbackStar_4= ruleFallbackStar
                    {

                    			newCompositeNode(grammarAccess.getControlNodeAccess().getFallbackStarParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_FallbackStar_4=ruleFallbackStar();

                    state._fsp--;


                    			current = this_FallbackStar_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalBehaviorTreeParser.g:706:3: this_Switch_5= ruleSwitch
                    {

                    			newCompositeNode(grammarAccess.getControlNodeAccess().getSwitchParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Switch_5=ruleSwitch();

                    state._fsp--;


                    			current = this_Switch_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleControlNode"


    // $ANTLR start "entryRuleSequence"
    // InternalBehaviorTreeParser.g:718:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // InternalBehaviorTreeParser.g:718:49: (iv_ruleSequence= ruleSequence EOF )
            // InternalBehaviorTreeParser.g:719:2: iv_ruleSequence= ruleSequence EOF
            {
             newCompositeNode(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // InternalBehaviorTreeParser.g:725:1: ruleSequence returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_nodes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:731:2: ( ( () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:732:2: ( () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:732:2: ( () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:733:3: () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:733:3: ()
            // InternalBehaviorTreeParser.g:734:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSequenceAccess().getSequenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getSequenceAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Sequence,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getSequenceAccess().getSequenceKeyword_2());
            		
            // InternalBehaviorTreeParser.g:748:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:749:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:749:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:750:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSequenceAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSequenceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:771:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==LessThanSign) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:772:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:772:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:773:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getSequenceAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_nodes_5_0=ruleTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSequenceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_5_0,
            	    						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_20); 

            			newLeafNode(otherlv_6, grammarAccess.getSequenceAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,Sequence,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getSequenceAccess().getSequenceKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleSequenceStar"
    // InternalBehaviorTreeParser.g:806:1: entryRuleSequenceStar returns [EObject current=null] : iv_ruleSequenceStar= ruleSequenceStar EOF ;
    public final EObject entryRuleSequenceStar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceStar = null;


        try {
            // InternalBehaviorTreeParser.g:806:53: (iv_ruleSequenceStar= ruleSequenceStar EOF )
            // InternalBehaviorTreeParser.g:807:2: iv_ruleSequenceStar= ruleSequenceStar EOF
            {
             newCompositeNode(grammarAccess.getSequenceStarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequenceStar=ruleSequenceStar();

            state._fsp--;

             current =iv_ruleSequenceStar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceStar"


    // $ANTLR start "ruleSequenceStar"
    // InternalBehaviorTreeParser.g:813:1: ruleSequenceStar returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign ) ;
    public final EObject ruleSequenceStar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_nodes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:819:2: ( ( () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:820:2: ( () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:820:2: ( () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:821:3: () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:821:3: ()
            // InternalBehaviorTreeParser.g:822:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSequenceStarAccess().getSequenceStarAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getSequenceStarAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,SequenceStar,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getSequenceStarAccess().getSequenceStarKeyword_2());
            		
            // InternalBehaviorTreeParser.g:836:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:837:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:837:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:838:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSequenceStarAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSequenceStarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getSequenceStarAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:859:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==LessThanSign) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:860:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:860:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:861:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getSequenceStarAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_nodes_5_0=ruleTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSequenceStarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_5_0,
            	    						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_21); 

            			newLeafNode(otherlv_6, grammarAccess.getSequenceStarAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,SequenceStar,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getSequenceStarAccess().getSequenceStarKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSequenceStarAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceStar"


    // $ANTLR start "entryRuleFallback"
    // InternalBehaviorTreeParser.g:894:1: entryRuleFallback returns [EObject current=null] : iv_ruleFallback= ruleFallback EOF ;
    public final EObject entryRuleFallback() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFallback = null;


        try {
            // InternalBehaviorTreeParser.g:894:49: (iv_ruleFallback= ruleFallback EOF )
            // InternalBehaviorTreeParser.g:895:2: iv_ruleFallback= ruleFallback EOF
            {
             newCompositeNode(grammarAccess.getFallbackRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFallback=ruleFallback();

            state._fsp--;

             current =iv_ruleFallback; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFallback"


    // $ANTLR start "ruleFallback"
    // InternalBehaviorTreeParser.g:901:1: ruleFallback returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign ) ;
    public final EObject ruleFallback() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_nodes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:907:2: ( ( () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:908:2: ( () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:908:2: ( () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:909:3: () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:909:3: ()
            // InternalBehaviorTreeParser.g:910:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFallbackAccess().getFallbackAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getFallbackAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Fallback,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getFallbackAccess().getFallbackKeyword_2());
            		
            // InternalBehaviorTreeParser.g:924:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:925:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:925:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:926:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getFallbackAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFallbackRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getFallbackAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:947:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==LessThanSign) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:948:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:948:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:949:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getFallbackAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_nodes_5_0=ruleTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFallbackRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_5_0,
            	    						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_22); 

            			newLeafNode(otherlv_6, grammarAccess.getFallbackAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,Fallback,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getFallbackAccess().getFallbackKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getFallbackAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFallback"


    // $ANTLR start "entryRuleFallbackStar"
    // InternalBehaviorTreeParser.g:982:1: entryRuleFallbackStar returns [EObject current=null] : iv_ruleFallbackStar= ruleFallbackStar EOF ;
    public final EObject entryRuleFallbackStar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFallbackStar = null;


        try {
            // InternalBehaviorTreeParser.g:982:53: (iv_ruleFallbackStar= ruleFallbackStar EOF )
            // InternalBehaviorTreeParser.g:983:2: iv_ruleFallbackStar= ruleFallbackStar EOF
            {
             newCompositeNode(grammarAccess.getFallbackStarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFallbackStar=ruleFallbackStar();

            state._fsp--;

             current =iv_ruleFallbackStar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFallbackStar"


    // $ANTLR start "ruleFallbackStar"
    // InternalBehaviorTreeParser.g:989:1: ruleFallbackStar returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign ) ;
    public final EObject ruleFallbackStar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_nodes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:995:2: ( ( () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:996:2: ( () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:996:2: ( () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:997:3: () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:997:3: ()
            // InternalBehaviorTreeParser.g:998:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFallbackStarAccess().getFallbackStarAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getFallbackStarAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,FallbackStar,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getFallbackStarAccess().getFallbackStarKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1012:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1013:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1013:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1014:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getFallbackStarAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFallbackStarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getFallbackStarAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1035:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==LessThanSign) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1036:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:1036:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:1037:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getFallbackStarAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_nodes_5_0=ruleTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFallbackStarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_5_0,
            	    						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_23); 

            			newLeafNode(otherlv_6, grammarAccess.getFallbackStarAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,FallbackStar,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getFallbackStarAccess().getFallbackStarKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getFallbackStarAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFallbackStar"


    // $ANTLR start "entryRuleParallel"
    // InternalBehaviorTreeParser.g:1070:1: entryRuleParallel returns [EObject current=null] : iv_ruleParallel= ruleParallel EOF ;
    public final EObject entryRuleParallel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParallel = null;


        try {
            // InternalBehaviorTreeParser.g:1070:49: (iv_ruleParallel= ruleParallel EOF )
            // InternalBehaviorTreeParser.g:1071:2: iv_ruleParallel= ruleParallel EOF
            {
             newCompositeNode(grammarAccess.getParallelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParallel=ruleParallel();

            state._fsp--;

             current =iv_ruleParallel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParallel"


    // $ANTLR start "ruleParallel"
    // InternalBehaviorTreeParser.g:1077:1: ruleParallel returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign ) ;
    public final EObject ruleParallel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_nodes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1083:2: ( ( () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1084:2: ( () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1084:2: ( () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1085:3: () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1085:3: ()
            // InternalBehaviorTreeParser.g:1086:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParallelAccess().getParallelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getParallelAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Parallel,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getParallelAccess().getParallelKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1100:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1101:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1101:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1102:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getParallelAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParallelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getParallelAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1123:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==LessThanSign) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1124:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:1124:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:1125:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getParallelAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_nodes_5_0=ruleTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParallelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_5_0,
            	    						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_24); 

            			newLeafNode(otherlv_6, grammarAccess.getParallelAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,Parallel,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getParallelAccess().getParallelKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getParallelAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParallel"


    // $ANTLR start "entryRuleSwitch"
    // InternalBehaviorTreeParser.g:1158:1: entryRuleSwitch returns [EObject current=null] : iv_ruleSwitch= ruleSwitch EOF ;
    public final EObject entryRuleSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch = null;


        try {
            // InternalBehaviorTreeParser.g:1158:47: (iv_ruleSwitch= ruleSwitch EOF )
            // InternalBehaviorTreeParser.g:1159:2: iv_ruleSwitch= ruleSwitch EOF
            {
             newCompositeNode(grammarAccess.getSwitchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSwitch=ruleSwitch();

            state._fsp--;

             current =iv_ruleSwitch; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitch"


    // $ANTLR start "ruleSwitch"
    // InternalBehaviorTreeParser.g:1165:1: ruleSwitch returns [EObject current=null] : ( () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign ) ;
    public final EObject ruleSwitch() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_SWITCH_KEYWORD_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_SWITCH_KEYWORD_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_nodes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1171:2: ( ( () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1172:2: ( () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1172:2: ( () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1173:3: () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1173:3: ()
            // InternalBehaviorTreeParser.g:1174:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSwitchAccess().getSwitchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getSwitchAccess().getLessThanSignKeyword_1());
            		
            this_SWITCH_KEYWORD_2=(Token)match(input,RULE_SWITCH_KEYWORD,FOLLOW_14); 

            			newLeafNode(this_SWITCH_KEYWORD_2, grammarAccess.getSwitchAccess().getSWITCH_KEYWORDTerminalRuleCall_2());
            		
            // InternalBehaviorTreeParser.g:1188:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1189:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1189:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1190:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSwitchAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSwitchRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getSwitchAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1211:3: ( (lv_nodes_5_0= ruleTreeNode ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==LessThanSign) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1212:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:1212:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:1213:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getSwitchAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_nodes_5_0=ruleTreeNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSwitchRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_5_0,
            	    						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_25); 

            			newLeafNode(otherlv_6, grammarAccess.getSwitchAccess().getLessThanSignSolidusKeyword_6());
            		
            this_SWITCH_KEYWORD_7=(Token)match(input,RULE_SWITCH_KEYWORD,FOLLOW_7); 

            			newLeafNode(this_SWITCH_KEYWORD_7, grammarAccess.getSwitchAccess().getSWITCH_KEYWORDTerminalRuleCall_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSwitchAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitch"


    // $ANTLR start "entryRuleDecoratorNode"
    // InternalBehaviorTreeParser.g:1246:1: entryRuleDecoratorNode returns [EObject current=null] : iv_ruleDecoratorNode= ruleDecoratorNode EOF ;
    public final EObject entryRuleDecoratorNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecoratorNode = null;


        try {
            // InternalBehaviorTreeParser.g:1246:54: (iv_ruleDecoratorNode= ruleDecoratorNode EOF )
            // InternalBehaviorTreeParser.g:1247:2: iv_ruleDecoratorNode= ruleDecoratorNode EOF
            {
             newCompositeNode(grammarAccess.getDecoratorNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecoratorNode=ruleDecoratorNode();

            state._fsp--;

             current =iv_ruleDecoratorNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecoratorNode"


    // $ANTLR start "ruleDecoratorNode"
    // InternalBehaviorTreeParser.g:1253:1: ruleDecoratorNode returns [EObject current=null] : (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString ) ;
    public final EObject ruleDecoratorNode() throws RecognitionException {
        EObject current = null;

        EObject this_ForceSuccess_0 = null;

        EObject this_ForceFailure_1 = null;

        EObject this_Repeat_2 = null;

        EObject this_RetryUntilSuccess_3 = null;

        EObject this_Inverter_4 = null;

        EObject this_Timeout_5 = null;

        EObject this_BlackboardCheckDouble_6 = null;

        EObject this_BlackboardCheckInt_7 = null;

        EObject this_BlackboardCheckString_8 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1259:2: ( (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString ) )
            // InternalBehaviorTreeParser.g:1260:2: (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString )
            {
            // InternalBehaviorTreeParser.g:1260:2: (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString )
            int alt23=9;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalBehaviorTreeParser.g:1261:3: this_ForceSuccess_0= ruleForceSuccess
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getForceSuccessParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForceSuccess_0=ruleForceSuccess();

                    state._fsp--;


                    			current = this_ForceSuccess_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBehaviorTreeParser.g:1270:3: this_ForceFailure_1= ruleForceFailure
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getForceFailureParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForceFailure_1=ruleForceFailure();

                    state._fsp--;


                    			current = this_ForceFailure_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBehaviorTreeParser.g:1279:3: this_Repeat_2= ruleRepeat
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getRepeatParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Repeat_2=ruleRepeat();

                    state._fsp--;


                    			current = this_Repeat_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalBehaviorTreeParser.g:1288:3: this_RetryUntilSuccess_3= ruleRetryUntilSuccess
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getRetryUntilSuccessParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_RetryUntilSuccess_3=ruleRetryUntilSuccess();

                    state._fsp--;


                    			current = this_RetryUntilSuccess_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalBehaviorTreeParser.g:1297:3: this_Inverter_4= ruleInverter
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getInverterParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Inverter_4=ruleInverter();

                    state._fsp--;


                    			current = this_Inverter_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalBehaviorTreeParser.g:1306:3: this_Timeout_5= ruleTimeout
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getTimeoutParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Timeout_5=ruleTimeout();

                    state._fsp--;


                    			current = this_Timeout_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalBehaviorTreeParser.g:1315:3: this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getBlackboardCheckDoubleParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_BlackboardCheckDouble_6=ruleBlackboardCheckDouble();

                    state._fsp--;


                    			current = this_BlackboardCheckDouble_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalBehaviorTreeParser.g:1324:3: this_BlackboardCheckInt_7= ruleBlackboardCheckInt
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getBlackboardCheckIntParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_BlackboardCheckInt_7=ruleBlackboardCheckInt();

                    state._fsp--;


                    			current = this_BlackboardCheckInt_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalBehaviorTreeParser.g:1333:3: this_BlackboardCheckString_8= ruleBlackboardCheckString
                    {

                    			newCompositeNode(grammarAccess.getDecoratorNodeAccess().getBlackboardCheckStringParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_BlackboardCheckString_8=ruleBlackboardCheckString();

                    state._fsp--;


                    			current = this_BlackboardCheckString_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecoratorNode"


    // $ANTLR start "entryRuleForceSuccess"
    // InternalBehaviorTreeParser.g:1345:1: entryRuleForceSuccess returns [EObject current=null] : iv_ruleForceSuccess= ruleForceSuccess EOF ;
    public final EObject entryRuleForceSuccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForceSuccess = null;


        try {
            // InternalBehaviorTreeParser.g:1345:53: (iv_ruleForceSuccess= ruleForceSuccess EOF )
            // InternalBehaviorTreeParser.g:1346:2: iv_ruleForceSuccess= ruleForceSuccess EOF
            {
             newCompositeNode(grammarAccess.getForceSuccessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForceSuccess=ruleForceSuccess();

            state._fsp--;

             current =iv_ruleForceSuccess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForceSuccess"


    // $ANTLR start "ruleForceSuccess"
    // InternalBehaviorTreeParser.g:1352:1: ruleForceSuccess returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign ) ;
    public final EObject ruleForceSuccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1358:2: ( ( () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1359:2: ( () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1359:2: ( () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1360:3: () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1360:3: ()
            // InternalBehaviorTreeParser.g:1361:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForceSuccessAccess().getForceSuccessAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getForceSuccessAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,ForceSuccess,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getForceSuccessAccess().getForceSuccessKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1375:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1376:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1376:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1377:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getForceSuccessAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getForceSuccessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getForceSuccessAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1398:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1399:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1399:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1400:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getForceSuccessAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForceSuccessRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_26); 

            			newLeafNode(otherlv_6, grammarAccess.getForceSuccessAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,ForceSuccess,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getForceSuccessAccess().getForceSuccessKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getForceSuccessAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForceSuccess"


    // $ANTLR start "entryRuleForceFailure"
    // InternalBehaviorTreeParser.g:1433:1: entryRuleForceFailure returns [EObject current=null] : iv_ruleForceFailure= ruleForceFailure EOF ;
    public final EObject entryRuleForceFailure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForceFailure = null;


        try {
            // InternalBehaviorTreeParser.g:1433:53: (iv_ruleForceFailure= ruleForceFailure EOF )
            // InternalBehaviorTreeParser.g:1434:2: iv_ruleForceFailure= ruleForceFailure EOF
            {
             newCompositeNode(grammarAccess.getForceFailureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForceFailure=ruleForceFailure();

            state._fsp--;

             current =iv_ruleForceFailure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForceFailure"


    // $ANTLR start "ruleForceFailure"
    // InternalBehaviorTreeParser.g:1440:1: ruleForceFailure returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign ) ;
    public final EObject ruleForceFailure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1446:2: ( ( () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1447:2: ( () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1447:2: ( () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1448:3: () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1448:3: ()
            // InternalBehaviorTreeParser.g:1449:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForceFailureAccess().getForceFailureAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getForceFailureAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,ForceFailure,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getForceFailureAccess().getForceFailureKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1463:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1464:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1464:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1465:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getForceFailureAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getForceFailureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getForceFailureAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1486:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1487:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1487:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1488:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getForceFailureAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForceFailureRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_28); 

            			newLeafNode(otherlv_6, grammarAccess.getForceFailureAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,ForceFailure,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getForceFailureAccess().getForceFailureKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getForceFailureAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForceFailure"


    // $ANTLR start "entryRuleRepeat"
    // InternalBehaviorTreeParser.g:1521:1: entryRuleRepeat returns [EObject current=null] : iv_ruleRepeat= ruleRepeat EOF ;
    public final EObject entryRuleRepeat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeat = null;


        try {
            // InternalBehaviorTreeParser.g:1521:47: (iv_ruleRepeat= ruleRepeat EOF )
            // InternalBehaviorTreeParser.g:1522:2: iv_ruleRepeat= ruleRepeat EOF
            {
             newCompositeNode(grammarAccess.getRepeatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRepeat=ruleRepeat();

            state._fsp--;

             current =iv_ruleRepeat; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRepeat"


    // $ANTLR start "ruleRepeat"
    // InternalBehaviorTreeParser.g:1528:1: ruleRepeat returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign ) ;
    public final EObject ruleRepeat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1534:2: ( ( () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1535:2: ( () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1535:2: ( () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1536:3: () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1536:3: ()
            // InternalBehaviorTreeParser.g:1537:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRepeatAccess().getRepeatAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getRepeatAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Repeat,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getRepeatAccess().getRepeatKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1551:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1552:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1552:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1553:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getRepeatAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRepeatRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getRepeatAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1574:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1575:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1575:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1576:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getRepeatAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRepeatRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_29); 

            			newLeafNode(otherlv_6, grammarAccess.getRepeatAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,Repeat,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getRepeatAccess().getRepeatKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getRepeatAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRepeat"


    // $ANTLR start "entryRuleInverter"
    // InternalBehaviorTreeParser.g:1609:1: entryRuleInverter returns [EObject current=null] : iv_ruleInverter= ruleInverter EOF ;
    public final EObject entryRuleInverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInverter = null;


        try {
            // InternalBehaviorTreeParser.g:1609:49: (iv_ruleInverter= ruleInverter EOF )
            // InternalBehaviorTreeParser.g:1610:2: iv_ruleInverter= ruleInverter EOF
            {
             newCompositeNode(grammarAccess.getInverterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInverter=ruleInverter();

            state._fsp--;

             current =iv_ruleInverter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInverter"


    // $ANTLR start "ruleInverter"
    // InternalBehaviorTreeParser.g:1616:1: ruleInverter returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign ) ;
    public final EObject ruleInverter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1622:2: ( ( () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1623:2: ( () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1623:2: ( () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1624:3: () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1624:3: ()
            // InternalBehaviorTreeParser.g:1625:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInverterAccess().getInverterAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getInverterAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Inverter,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getInverterAccess().getInverterKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1639:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1640:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1640:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1641:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getInverterAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInverterRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getInverterAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1662:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1663:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1663:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1664:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getInverterAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInverterRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_30); 

            			newLeafNode(otherlv_6, grammarAccess.getInverterAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,Inverter,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getInverterAccess().getInverterKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getInverterAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInverter"


    // $ANTLR start "entryRuleTimeout"
    // InternalBehaviorTreeParser.g:1697:1: entryRuleTimeout returns [EObject current=null] : iv_ruleTimeout= ruleTimeout EOF ;
    public final EObject entryRuleTimeout() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeout = null;


        try {
            // InternalBehaviorTreeParser.g:1697:48: (iv_ruleTimeout= ruleTimeout EOF )
            // InternalBehaviorTreeParser.g:1698:2: iv_ruleTimeout= ruleTimeout EOF
            {
             newCompositeNode(grammarAccess.getTimeoutRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeout=ruleTimeout();

            state._fsp--;

             current =iv_ruleTimeout; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeout"


    // $ANTLR start "ruleTimeout"
    // InternalBehaviorTreeParser.g:1704:1: ruleTimeout returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign ) ;
    public final EObject ruleTimeout() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1710:2: ( ( () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1711:2: ( () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1711:2: ( () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1712:3: () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1712:3: ()
            // InternalBehaviorTreeParser.g:1713:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeoutAccess().getTimeoutAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeoutAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Timeout,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeoutAccess().getTimeoutKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1727:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1728:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1728:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1729:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getTimeoutAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTimeoutRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getTimeoutAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1750:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1751:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1751:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1752:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getTimeoutAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeoutRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_31); 

            			newLeafNode(otherlv_6, grammarAccess.getTimeoutAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,Timeout,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getTimeoutAccess().getTimeoutKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getTimeoutAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeout"


    // $ANTLR start "entryRuleRetryUntilSuccess"
    // InternalBehaviorTreeParser.g:1785:1: entryRuleRetryUntilSuccess returns [EObject current=null] : iv_ruleRetryUntilSuccess= ruleRetryUntilSuccess EOF ;
    public final EObject entryRuleRetryUntilSuccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRetryUntilSuccess = null;


        try {
            // InternalBehaviorTreeParser.g:1785:58: (iv_ruleRetryUntilSuccess= ruleRetryUntilSuccess EOF )
            // InternalBehaviorTreeParser.g:1786:2: iv_ruleRetryUntilSuccess= ruleRetryUntilSuccess EOF
            {
             newCompositeNode(grammarAccess.getRetryUntilSuccessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRetryUntilSuccess=ruleRetryUntilSuccess();

            state._fsp--;

             current =iv_ruleRetryUntilSuccess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRetryUntilSuccess"


    // $ANTLR start "ruleRetryUntilSuccess"
    // InternalBehaviorTreeParser.g:1792:1: ruleRetryUntilSuccess returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign ) ;
    public final EObject ruleRetryUntilSuccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1798:2: ( ( () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1799:2: ( () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1799:2: ( () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1800:3: () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1800:3: ()
            // InternalBehaviorTreeParser.g:1801:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRetryUntilSuccessAccess().getRetryUntilSuccessAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getRetryUntilSuccessAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,RetryUntilSuccesful,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getRetryUntilSuccessAccess().getRetryUntilSuccesfulKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1815:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1816:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1816:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1817:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getRetryUntilSuccessAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRetryUntilSuccessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getRetryUntilSuccessAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1838:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1839:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1839:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1840:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getRetryUntilSuccessAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRetryUntilSuccessRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_32); 

            			newLeafNode(otherlv_6, grammarAccess.getRetryUntilSuccessAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,RetryUntilSuccesful,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getRetryUntilSuccessAccess().getRetryUntilSuccesfulKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getRetryUntilSuccessAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRetryUntilSuccess"


    // $ANTLR start "entryRuleBlackboardCheckDouble"
    // InternalBehaviorTreeParser.g:1873:1: entryRuleBlackboardCheckDouble returns [EObject current=null] : iv_ruleBlackboardCheckDouble= ruleBlackboardCheckDouble EOF ;
    public final EObject entryRuleBlackboardCheckDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlackboardCheckDouble = null;


        try {
            // InternalBehaviorTreeParser.g:1873:62: (iv_ruleBlackboardCheckDouble= ruleBlackboardCheckDouble EOF )
            // InternalBehaviorTreeParser.g:1874:2: iv_ruleBlackboardCheckDouble= ruleBlackboardCheckDouble EOF
            {
             newCompositeNode(grammarAccess.getBlackboardCheckDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlackboardCheckDouble=ruleBlackboardCheckDouble();

            state._fsp--;

             current =iv_ruleBlackboardCheckDouble; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlackboardCheckDouble"


    // $ANTLR start "ruleBlackboardCheckDouble"
    // InternalBehaviorTreeParser.g:1880:1: ruleBlackboardCheckDouble returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign ) ;
    public final EObject ruleBlackboardCheckDouble() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1886:2: ( ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1887:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1887:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1888:3: () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1888:3: ()
            // InternalBehaviorTreeParser.g:1889:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlackboardCheckDoubleAccess().getBlackboardCheckDoubleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getBlackboardCheckDoubleAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,BlackboardCheckDouble,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getBlackboardCheckDoubleAccess().getBlackboardCheckDoubleKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1903:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1904:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1904:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1905:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getBlackboardCheckDoubleAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlackboardCheckDoubleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getBlackboardCheckDoubleAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1926:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1927:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1927:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1928:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getBlackboardCheckDoubleAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBlackboardCheckDoubleRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_33); 

            			newLeafNode(otherlv_6, grammarAccess.getBlackboardCheckDoubleAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,BlackboardCheckDouble,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getBlackboardCheckDoubleAccess().getBlackboardCheckDoubleKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getBlackboardCheckDoubleAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlackboardCheckDouble"


    // $ANTLR start "entryRuleBlackboardCheckInt"
    // InternalBehaviorTreeParser.g:1961:1: entryRuleBlackboardCheckInt returns [EObject current=null] : iv_ruleBlackboardCheckInt= ruleBlackboardCheckInt EOF ;
    public final EObject entryRuleBlackboardCheckInt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlackboardCheckInt = null;


        try {
            // InternalBehaviorTreeParser.g:1961:59: (iv_ruleBlackboardCheckInt= ruleBlackboardCheckInt EOF )
            // InternalBehaviorTreeParser.g:1962:2: iv_ruleBlackboardCheckInt= ruleBlackboardCheckInt EOF
            {
             newCompositeNode(grammarAccess.getBlackboardCheckIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlackboardCheckInt=ruleBlackboardCheckInt();

            state._fsp--;

             current =iv_ruleBlackboardCheckInt; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlackboardCheckInt"


    // $ANTLR start "ruleBlackboardCheckInt"
    // InternalBehaviorTreeParser.g:1968:1: ruleBlackboardCheckInt returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign ) ;
    public final EObject ruleBlackboardCheckInt() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:1974:2: ( ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1975:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1975:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1976:3: () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1976:3: ()
            // InternalBehaviorTreeParser.g:1977:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlackboardCheckIntAccess().getBlackboardCheckIntAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getBlackboardCheckIntAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,BlackboardCheckInt,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getBlackboardCheckIntAccess().getBlackboardCheckIntKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1991:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1992:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1992:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1993:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getBlackboardCheckIntAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlackboardCheckIntRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getBlackboardCheckIntAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:2014:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:2015:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:2015:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:2016:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getBlackboardCheckIntAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBlackboardCheckIntRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_34); 

            			newLeafNode(otherlv_6, grammarAccess.getBlackboardCheckIntAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,BlackboardCheckInt,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getBlackboardCheckIntAccess().getBlackboardCheckIntKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getBlackboardCheckIntAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlackboardCheckInt"


    // $ANTLR start "entryRuleBlackboardCheckString"
    // InternalBehaviorTreeParser.g:2049:1: entryRuleBlackboardCheckString returns [EObject current=null] : iv_ruleBlackboardCheckString= ruleBlackboardCheckString EOF ;
    public final EObject entryRuleBlackboardCheckString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlackboardCheckString = null;


        try {
            // InternalBehaviorTreeParser.g:2049:62: (iv_ruleBlackboardCheckString= ruleBlackboardCheckString EOF )
            // InternalBehaviorTreeParser.g:2050:2: iv_ruleBlackboardCheckString= ruleBlackboardCheckString EOF
            {
             newCompositeNode(grammarAccess.getBlackboardCheckStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlackboardCheckString=ruleBlackboardCheckString();

            state._fsp--;

             current =iv_ruleBlackboardCheckString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlackboardCheckString"


    // $ANTLR start "ruleBlackboardCheckString"
    // InternalBehaviorTreeParser.g:2056:1: ruleBlackboardCheckString returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign ) ;
    public final EObject ruleBlackboardCheckString() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_node_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2062:2: ( ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2063:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2063:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:2064:3: () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2064:3: ()
            // InternalBehaviorTreeParser.g:2065:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlackboardCheckStringAccess().getBlackboardCheckStringAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getBlackboardCheckStringAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,BlackboardCheckString,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getBlackboardCheckStringAccess().getBlackboardCheckStringKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2079:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2080:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2080:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2081:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getBlackboardCheckStringAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlackboardCheckStringRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getBlackboardCheckStringAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:2102:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:2103:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:2103:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:2104:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getBlackboardCheckStringAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_node_5_0=ruleTreeNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBlackboardCheckStringRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_5_0,
            						"org.xtext.behaviortree.BehaviorTree.TreeNode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_35); 

            			newLeafNode(otherlv_6, grammarAccess.getBlackboardCheckStringAccess().getLessThanSignSolidusKeyword_6());
            		
            otherlv_7=(Token)match(input,BlackboardCheckString,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getBlackboardCheckStringAccess().getBlackboardCheckStringKeyword_7());
            		
            otherlv_8=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getBlackboardCheckStringAccess().getGreaterThanSignKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlackboardCheckString"


    // $ANTLR start "entryRuleLeafNode"
    // InternalBehaviorTreeParser.g:2137:1: entryRuleLeafNode returns [EObject current=null] : iv_ruleLeafNode= ruleLeafNode EOF ;
    public final EObject entryRuleLeafNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeafNode = null;


        try {
            // InternalBehaviorTreeParser.g:2137:49: (iv_ruleLeafNode= ruleLeafNode EOF )
            // InternalBehaviorTreeParser.g:2138:2: iv_ruleLeafNode= ruleLeafNode EOF
            {
             newCompositeNode(grammarAccess.getLeafNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLeafNode=ruleLeafNode();

            state._fsp--;

             current =iv_ruleLeafNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLeafNode"


    // $ANTLR start "ruleLeafNode"
    // InternalBehaviorTreeParser.g:2144:1: ruleLeafNode returns [EObject current=null] : (this_AbstractAction_0= ruleAbstractAction | this_Condition_1= ruleCondition ) ;
    public final EObject ruleLeafNode() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractAction_0 = null;

        EObject this_Condition_1 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2150:2: ( (this_AbstractAction_0= ruleAbstractAction | this_Condition_1= ruleCondition ) )
            // InternalBehaviorTreeParser.g:2151:2: (this_AbstractAction_0= ruleAbstractAction | this_Condition_1= ruleCondition )
            {
            // InternalBehaviorTreeParser.g:2151:2: (this_AbstractAction_0= ruleAbstractAction | this_Condition_1= ruleCondition )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==LessThanSign) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==Condition) ) {
                    alt33=2;
                }
                else if ( ((LA33_1>=AlwaysFailure && LA33_1<=SetBlackboard)||LA33_1==Action) ) {
                    alt33=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalBehaviorTreeParser.g:2152:3: this_AbstractAction_0= ruleAbstractAction
                    {

                    			newCompositeNode(grammarAccess.getLeafNodeAccess().getAbstractActionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AbstractAction_0=ruleAbstractAction();

                    state._fsp--;


                    			current = this_AbstractAction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBehaviorTreeParser.g:2161:3: this_Condition_1= ruleCondition
                    {

                    			newCompositeNode(grammarAccess.getLeafNodeAccess().getConditionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Condition_1=ruleCondition();

                    state._fsp--;


                    			current = this_Condition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLeafNode"


    // $ANTLR start "entryRuleAbstractAction"
    // InternalBehaviorTreeParser.g:2173:1: entryRuleAbstractAction returns [EObject current=null] : iv_ruleAbstractAction= ruleAbstractAction EOF ;
    public final EObject entryRuleAbstractAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractAction = null;


        try {
            // InternalBehaviorTreeParser.g:2173:55: (iv_ruleAbstractAction= ruleAbstractAction EOF )
            // InternalBehaviorTreeParser.g:2174:2: iv_ruleAbstractAction= ruleAbstractAction EOF
            {
             newCompositeNode(grammarAccess.getAbstractActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractAction=ruleAbstractAction();

            state._fsp--;

             current =iv_ruleAbstractAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractAction"


    // $ANTLR start "ruleAbstractAction"
    // InternalBehaviorTreeParser.g:2180:1: ruleAbstractAction returns [EObject current=null] : (this_AlwaysSuccess_0= ruleAlwaysSuccess | this_AlwaysFailure_1= ruleAlwaysFailure | this_SetBlackboard_2= ruleSetBlackboard | this_Action_3= ruleAction ) ;
    public final EObject ruleAbstractAction() throws RecognitionException {
        EObject current = null;

        EObject this_AlwaysSuccess_0 = null;

        EObject this_AlwaysFailure_1 = null;

        EObject this_SetBlackboard_2 = null;

        EObject this_Action_3 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2186:2: ( (this_AlwaysSuccess_0= ruleAlwaysSuccess | this_AlwaysFailure_1= ruleAlwaysFailure | this_SetBlackboard_2= ruleSetBlackboard | this_Action_3= ruleAction ) )
            // InternalBehaviorTreeParser.g:2187:2: (this_AlwaysSuccess_0= ruleAlwaysSuccess | this_AlwaysFailure_1= ruleAlwaysFailure | this_SetBlackboard_2= ruleSetBlackboard | this_Action_3= ruleAction )
            {
            // InternalBehaviorTreeParser.g:2187:2: (this_AlwaysSuccess_0= ruleAlwaysSuccess | this_AlwaysFailure_1= ruleAlwaysFailure | this_SetBlackboard_2= ruleSetBlackboard | this_Action_3= ruleAction )
            int alt34=4;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==LessThanSign) ) {
                switch ( input.LA(2) ) {
                case Action:
                    {
                    alt34=4;
                    }
                    break;
                case SetBlackboard:
                    {
                    alt34=3;
                    }
                    break;
                case AlwaysFailure:
                    {
                    alt34=2;
                    }
                    break;
                case AlwaysSuccess:
                    {
                    alt34=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalBehaviorTreeParser.g:2188:3: this_AlwaysSuccess_0= ruleAlwaysSuccess
                    {

                    			newCompositeNode(grammarAccess.getAbstractActionAccess().getAlwaysSuccessParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AlwaysSuccess_0=ruleAlwaysSuccess();

                    state._fsp--;


                    			current = this_AlwaysSuccess_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBehaviorTreeParser.g:2197:3: this_AlwaysFailure_1= ruleAlwaysFailure
                    {

                    			newCompositeNode(grammarAccess.getAbstractActionAccess().getAlwaysFailureParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AlwaysFailure_1=ruleAlwaysFailure();

                    state._fsp--;


                    			current = this_AlwaysFailure_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBehaviorTreeParser.g:2206:3: this_SetBlackboard_2= ruleSetBlackboard
                    {

                    			newCompositeNode(grammarAccess.getAbstractActionAccess().getSetBlackboardParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetBlackboard_2=ruleSetBlackboard();

                    state._fsp--;


                    			current = this_SetBlackboard_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalBehaviorTreeParser.g:2215:3: this_Action_3= ruleAction
                    {

                    			newCompositeNode(grammarAccess.getAbstractActionAccess().getActionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Action_3=ruleAction();

                    state._fsp--;


                    			current = this_Action_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractAction"


    // $ANTLR start "entryRuleCondition"
    // InternalBehaviorTreeParser.g:2227:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalBehaviorTreeParser.g:2227:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalBehaviorTreeParser.g:2228:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalBehaviorTreeParser.g:2234:1: ruleCondition returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2240:2: ( ( () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2241:2: ( () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2241:2: ( () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2242:3: () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2242:3: ()
            // InternalBehaviorTreeParser.g:2243:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConditionAccess().getConditionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Condition,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getConditionKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2257:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2258:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2258:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2259:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getConditionAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConditionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_4=(Token)match(input,SolidusGreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getConditionAccess().getSolidusGreaterThanSignKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleAlwaysSuccess"
    // InternalBehaviorTreeParser.g:2284:1: entryRuleAlwaysSuccess returns [EObject current=null] : iv_ruleAlwaysSuccess= ruleAlwaysSuccess EOF ;
    public final EObject entryRuleAlwaysSuccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlwaysSuccess = null;


        try {
            // InternalBehaviorTreeParser.g:2284:54: (iv_ruleAlwaysSuccess= ruleAlwaysSuccess EOF )
            // InternalBehaviorTreeParser.g:2285:2: iv_ruleAlwaysSuccess= ruleAlwaysSuccess EOF
            {
             newCompositeNode(grammarAccess.getAlwaysSuccessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlwaysSuccess=ruleAlwaysSuccess();

            state._fsp--;

             current =iv_ruleAlwaysSuccess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlwaysSuccess"


    // $ANTLR start "ruleAlwaysSuccess"
    // InternalBehaviorTreeParser.g:2291:1: ruleAlwaysSuccess returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleAlwaysSuccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2297:2: ( ( () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2298:2: ( () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2298:2: ( () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2299:3: () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2299:3: ()
            // InternalBehaviorTreeParser.g:2300:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAlwaysSuccessAccess().getAlwaysSuccessAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getAlwaysSuccessAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,AlwaysSuccess,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getAlwaysSuccessAccess().getAlwaysSuccessKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2314:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2315:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2315:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2316:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getAlwaysSuccessAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlwaysSuccessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_4=(Token)match(input,SolidusGreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getAlwaysSuccessAccess().getSolidusGreaterThanSignKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlwaysSuccess"


    // $ANTLR start "entryRuleAlwaysFailure"
    // InternalBehaviorTreeParser.g:2341:1: entryRuleAlwaysFailure returns [EObject current=null] : iv_ruleAlwaysFailure= ruleAlwaysFailure EOF ;
    public final EObject entryRuleAlwaysFailure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlwaysFailure = null;


        try {
            // InternalBehaviorTreeParser.g:2341:54: (iv_ruleAlwaysFailure= ruleAlwaysFailure EOF )
            // InternalBehaviorTreeParser.g:2342:2: iv_ruleAlwaysFailure= ruleAlwaysFailure EOF
            {
             newCompositeNode(grammarAccess.getAlwaysFailureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlwaysFailure=ruleAlwaysFailure();

            state._fsp--;

             current =iv_ruleAlwaysFailure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlwaysFailure"


    // $ANTLR start "ruleAlwaysFailure"
    // InternalBehaviorTreeParser.g:2348:1: ruleAlwaysFailure returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleAlwaysFailure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2354:2: ( ( () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2355:2: ( () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2355:2: ( () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2356:3: () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2356:3: ()
            // InternalBehaviorTreeParser.g:2357:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAlwaysFailureAccess().getAlwaysFailureAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_38); 

            			newLeafNode(otherlv_1, grammarAccess.getAlwaysFailureAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,AlwaysFailure,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getAlwaysFailureAccess().getAlwaysFailureKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2371:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2372:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2372:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2373:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getAlwaysFailureAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlwaysFailureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_4=(Token)match(input,SolidusGreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getAlwaysFailureAccess().getSolidusGreaterThanSignKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlwaysFailure"


    // $ANTLR start "entryRuleSetBlackboard"
    // InternalBehaviorTreeParser.g:2398:1: entryRuleSetBlackboard returns [EObject current=null] : iv_ruleSetBlackboard= ruleSetBlackboard EOF ;
    public final EObject entryRuleSetBlackboard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetBlackboard = null;


        try {
            // InternalBehaviorTreeParser.g:2398:54: (iv_ruleSetBlackboard= ruleSetBlackboard EOF )
            // InternalBehaviorTreeParser.g:2399:2: iv_ruleSetBlackboard= ruleSetBlackboard EOF
            {
             newCompositeNode(grammarAccess.getSetBlackboardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetBlackboard=ruleSetBlackboard();

            state._fsp--;

             current =iv_ruleSetBlackboard; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetBlackboard"


    // $ANTLR start "ruleSetBlackboard"
    // InternalBehaviorTreeParser.g:2405:1: ruleSetBlackboard returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleSetBlackboard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2411:2: ( ( () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2412:2: ( () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2412:2: ( () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2413:3: () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2413:3: ()
            // InternalBehaviorTreeParser.g:2414:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSetBlackboardAccess().getSetBlackboardAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getSetBlackboardAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,SetBlackboard,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getSetBlackboardAccess().getSetBlackboardKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2428:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2429:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2429:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2430:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSetBlackboardAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSetBlackboardRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            otherlv_4=(Token)match(input,SolidusGreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSetBlackboardAccess().getSolidusGreaterThanSignKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetBlackboard"


    // $ANTLR start "entryRuleAction"
    // InternalBehaviorTreeParser.g:2455:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalBehaviorTreeParser.g:2455:47: (iv_ruleAction= ruleAction EOF )
            // InternalBehaviorTreeParser.g:2456:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalBehaviorTreeParser.g:2462:1: ruleAction returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2468:2: ( ( () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2469:2: ( () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2469:2: ( () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2470:3: () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2470:3: ()
            // InternalBehaviorTreeParser.g:2471:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionAccess().getActionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getActionAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Action,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getActionAccess().getActionKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2485:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2486:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2486:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2487:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getActionAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"org.xtext.behaviortree.BehaviorTree.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_4=(Token)match(input,SolidusGreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getActionAccess().getSolidusGreaterThanSignKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleTreeNodesModel"
    // InternalBehaviorTreeParser.g:2512:1: entryRuleTreeNodesModel returns [EObject current=null] : iv_ruleTreeNodesModel= ruleTreeNodesModel EOF ;
    public final EObject entryRuleTreeNodesModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTreeNodesModel = null;


        try {
            // InternalBehaviorTreeParser.g:2512:55: (iv_ruleTreeNodesModel= ruleTreeNodesModel EOF )
            // InternalBehaviorTreeParser.g:2513:2: iv_ruleTreeNodesModel= ruleTreeNodesModel EOF
            {
             newCompositeNode(grammarAccess.getTreeNodesModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTreeNodesModel=ruleTreeNodesModel();

            state._fsp--;

             current =iv_ruleTreeNodesModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTreeNodesModel"


    // $ANTLR start "ruleTreeNodesModel"
    // InternalBehaviorTreeParser.g:2519:1: ruleTreeNodesModel returns [EObject current=null] : ( () ( (lv_content_1_0= ruleEString ) ) ) ;
    public final EObject ruleTreeNodesModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_content_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2525:2: ( ( () ( (lv_content_1_0= ruleEString ) ) ) )
            // InternalBehaviorTreeParser.g:2526:2: ( () ( (lv_content_1_0= ruleEString ) ) )
            {
            // InternalBehaviorTreeParser.g:2526:2: ( () ( (lv_content_1_0= ruleEString ) ) )
            // InternalBehaviorTreeParser.g:2527:3: () ( (lv_content_1_0= ruleEString ) )
            {
            // InternalBehaviorTreeParser.g:2527:3: ()
            // InternalBehaviorTreeParser.g:2528:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTreeNodesModelAccess().getTreeNodesModelAction_0(),
            					current);
            			

            }

            // InternalBehaviorTreeParser.g:2534:3: ( (lv_content_1_0= ruleEString ) )
            // InternalBehaviorTreeParser.g:2535:4: (lv_content_1_0= ruleEString )
            {
            // InternalBehaviorTreeParser.g:2535:4: (lv_content_1_0= ruleEString )
            // InternalBehaviorTreeParser.g:2536:5: lv_content_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTreeNodesModelAccess().getContentEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_content_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTreeNodesModelRule());
            					}
            					set(
            						current,
            						"content",
            						lv_content_1_0,
            						"org.xtext.behaviortree.BehaviorTree.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTreeNodesModel"


    // $ANTLR start "entryRuleEString"
    // InternalBehaviorTreeParser.g:2557:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalBehaviorTreeParser.g:2557:47: (iv_ruleEString= ruleEString EOF )
            // InternalBehaviorTreeParser.g:2558:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalBehaviorTreeParser.g:2564:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DEFINITION_STRING_0= RULE_DEFINITION_STRING ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DEFINITION_STRING_0=null;


        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2570:2: (this_DEFINITION_STRING_0= RULE_DEFINITION_STRING )
            // InternalBehaviorTreeParser.g:2571:2: this_DEFINITION_STRING_0= RULE_DEFINITION_STRING
            {
            this_DEFINITION_STRING_0=(Token)match(input,RULE_DEFINITION_STRING,FOLLOW_2); 

            		current.merge(this_DEFINITION_STRING_0);
            	

            		newLeafNode(this_DEFINITION_STRING_0, grammarAccess.getEStringAccess().getDEFINITION_STRINGTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"

    // Delegated rules


    protected DFA23 dfa23 = new DFA23(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\36\1\4\11\uffff";
    static final String dfa_3s = "\1\36\1\31\11\uffff";
    static final String dfa_4s = "\2\uffff\1\1\1\5\1\4\1\7\1\2\1\6\1\10\1\3\1\11";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\5\1\12\1\uffff\1\4\1\10\5\uffff\1\6\1\2\3\uffff\1\3\2\uffff\1\7\2\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1260:2: (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000440000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000460000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000010100000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000010010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000001000000L});

}
