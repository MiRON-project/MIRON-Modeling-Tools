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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BlackboardCheckDouble", "BlackboardCheckString", "Main_tree_to_execute", "RetryUntilSuccesful", "BlackboardCheckInt", "AlwaysFailure", "AlwaysSuccess", "SetBlackboard", "BehaviorTree", "FallbackStar", "ForceFailure", "ForceSuccess", "SequenceStar", "Condition", "Fallback", "Inverter", "Parallel", "Sequence", "Timeout", "Include", "Action", "Repeat", "Path", "Root", "SolidusGreaterThanSign", "LessThanSignSolidus", "LessThanSign", "EqualsSign", "GreaterThanSign", "RULE_INT", "RULE_SWITCH_KEYWORD", "RULE_WS", "RULE_SUBTREE_KEYWORD", "RULE_SUBTREEWRAPPER_KEYWORD", "RULE_ML_COMMENT", "RULE_ID", "RULE_STRING", "RULE_SL_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int Action=24;
    public static final int Include=23;
    public static final int Repeat=25;
    public static final int RULE_STRING=40;
    public static final int Parallel=20;
    public static final int ForceFailure=14;
    public static final int LessThanSign=30;
    public static final int RULE_SUBTREE_KEYWORD=36;
    public static final int RULE_SL_COMMENT=41;
    public static final int EqualsSign=31;
    public static final int AlwaysSuccess=10;
    public static final int ForceSuccess=15;
    public static final int AlwaysFailure=9;
    public static final int BlackboardCheckDouble=4;
    public static final int BlackboardCheckInt=8;
    public static final int EOF=-1;
    public static final int Condition=17;
    public static final int Inverter=19;
    public static final int Path=26;
    public static final int GreaterThanSign=32;
    public static final int RetryUntilSuccesful=7;
    public static final int SetBlackboard=11;
    public static final int Root=27;
    public static final int RULE_ID=39;
    public static final int RULE_WS=35;
    public static final int RULE_SUBTREEWRAPPER_KEYWORD=37;
    public static final int Timeout=22;
    public static final int Sequence=21;
    public static final int RULE_ANY_OTHER=42;
    public static final int BehaviorTree=12;
    public static final int Main_tree_to_execute=6;
    public static final int FallbackStar=13;
    public static final int RULE_INT=33;
    public static final int Fallback=18;
    public static final int RULE_SWITCH_KEYWORD=34;
    public static final int RULE_ML_COMMENT=38;
    public static final int SolidusGreaterThanSign=28;
    public static final int BlackboardCheckString=5;
    public static final int SequenceStar=16;
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
    // InternalBehaviorTreeParser.g:64:1: ruleBTModel returns [EObject current=null] : (otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (lv_main_tree_to_execute_4_0= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( (lv_trees_7_0= ruleBehaviorTree ) )+ otherlv_8= LessThanSignSolidus otherlv_9= Root otherlv_10= GreaterThanSign ) ;
    public final EObject ruleBTModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_main_tree_to_execute_4_0=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_imports_6_0 = null;

        EObject lv_trees_7_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:70:2: ( (otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (lv_main_tree_to_execute_4_0= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( (lv_trees_7_0= ruleBehaviorTree ) )+ otherlv_8= LessThanSignSolidus otherlv_9= Root otherlv_10= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:71:2: (otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (lv_main_tree_to_execute_4_0= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( (lv_trees_7_0= ruleBehaviorTree ) )+ otherlv_8= LessThanSignSolidus otherlv_9= Root otherlv_10= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:71:2: (otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (lv_main_tree_to_execute_4_0= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( (lv_trees_7_0= ruleBehaviorTree ) )+ otherlv_8= LessThanSignSolidus otherlv_9= Root otherlv_10= GreaterThanSign )
            // InternalBehaviorTreeParser.g:72:3: otherlv_0= LessThanSign otherlv_1= Root otherlv_2= Main_tree_to_execute otherlv_3= EqualsSign ( (lv_main_tree_to_execute_4_0= RULE_STRING ) ) otherlv_5= GreaterThanSign ( (lv_imports_6_0= ruleImport ) )* ( (lv_trees_7_0= ruleBehaviorTree ) )+ otherlv_8= LessThanSignSolidus otherlv_9= Root otherlv_10= GreaterThanSign
            {
            otherlv_0=(Token)match(input,LessThanSign,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBTModelAccess().getLessThanSignKeyword_0());
            		
            otherlv_1=(Token)match(input,Root,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getBTModelAccess().getRootKeyword_1());
            		
            otherlv_2=(Token)match(input,Main_tree_to_execute,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getBTModelAccess().getMain_tree_to_executeKeyword_2());
            		
            otherlv_3=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getBTModelAccess().getEqualsSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:88:3: ( (lv_main_tree_to_execute_4_0= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:89:4: (lv_main_tree_to_execute_4_0= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:89:4: (lv_main_tree_to_execute_4_0= RULE_STRING )
            // InternalBehaviorTreeParser.g:90:5: lv_main_tree_to_execute_4_0= RULE_STRING
            {
            lv_main_tree_to_execute_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_main_tree_to_execute_4_0, grammarAccess.getBTModelAccess().getMain_tree_to_executeSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBTModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"main_tree_to_execute",
            						lv_main_tree_to_execute_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_5, grammarAccess.getBTModelAccess().getGreaterThanSignKeyword_5());
            		
            // InternalBehaviorTreeParser.g:110:3: ( (lv_imports_6_0= ruleImport ) )*
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
            	    // InternalBehaviorTreeParser.g:111:4: (lv_imports_6_0= ruleImport )
            	    {
            	    // InternalBehaviorTreeParser.g:111:4: (lv_imports_6_0= ruleImport )
            	    // InternalBehaviorTreeParser.g:112:5: lv_imports_6_0= ruleImport
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

            // InternalBehaviorTreeParser.g:129:3: ( (lv_trees_7_0= ruleBehaviorTree ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==LessThanSign) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:130:4: (lv_trees_7_0= ruleBehaviorTree )
            	    {
            	    // InternalBehaviorTreeParser.g:130:4: (lv_trees_7_0= ruleBehaviorTree )
            	    // InternalBehaviorTreeParser.g:131:5: lv_trees_7_0= ruleBehaviorTree
            	    {

            	    					newCompositeNode(grammarAccess.getBTModelAccess().getTreesBehaviorTreeParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_trees_7_0=ruleBehaviorTree();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBTModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"trees",
            	    						lv_trees_7_0,
            	    						"org.xtext.behaviortree.BehaviorTree.BehaviorTree");
            	    					afterParserOrEnumRuleCall();
            	    				

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

            otherlv_8=(Token)match(input,LessThanSignSolidus,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getBTModelAccess().getLessThanSignSolidusKeyword_8());
            		
            otherlv_9=(Token)match(input,Root,FOLLOW_7); 

            			newLeafNode(otherlv_9, grammarAccess.getBTModelAccess().getRootKeyword_9());
            		
            otherlv_10=(Token)match(input,GreaterThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getBTModelAccess().getGreaterThanSignKeyword_10());
            		

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
    // InternalBehaviorTreeParser.g:164:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalBehaviorTreeParser.g:164:47: (iv_ruleImport= ruleImport EOF )
            // InternalBehaviorTreeParser.g:165:2: iv_ruleImport= ruleImport EOF
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
    // InternalBehaviorTreeParser.g:171:1: ruleImport returns [EObject current=null] : (otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:177:2: ( (otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:178:2: (otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:178:2: (otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:179:3: otherlv_0= LessThanSign otherlv_1= Include otherlv_2= Path otherlv_3= EqualsSign ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= SolidusGreaterThanSign
            {
            otherlv_0=(Token)match(input,LessThanSign,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getLessThanSignKeyword_0());
            		
            otherlv_1=(Token)match(input,Include,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getImportAccess().getIncludeKeyword_1());
            		
            otherlv_2=(Token)match(input,Path,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getPathKeyword_2());
            		
            otherlv_3=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getImportAccess().getEqualsSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:195:3: ( (lv_importURI_4_0= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:196:4: (lv_importURI_4_0= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:196:4: (lv_importURI_4_0= RULE_STRING )
            // InternalBehaviorTreeParser.g:197:5: lv_importURI_4_0= RULE_STRING
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
    // InternalBehaviorTreeParser.g:221:1: entryRuleBehaviorTree returns [EObject current=null] : iv_ruleBehaviorTree= ruleBehaviorTree EOF ;
    public final EObject entryRuleBehaviorTree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTree = null;


        try {
            // InternalBehaviorTreeParser.g:221:53: (iv_ruleBehaviorTree= ruleBehaviorTree EOF )
            // InternalBehaviorTreeParser.g:222:2: iv_ruleBehaviorTree= ruleBehaviorTree EOF
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
    // InternalBehaviorTreeParser.g:228:1: ruleBehaviorTree returns [EObject current=null] : (otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:234:2: ( (otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:235:2: (otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:235:2: (otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign )
            // InternalBehaviorTreeParser.g:236:3: otherlv_0= LessThanSign otherlv_1= BehaviorTree ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= GreaterThanSign ( (lv_nodes_4_0= ruleTreeNode ) )+ otherlv_5= LessThanSignSolidus otherlv_6= BehaviorTree otherlv_7= GreaterThanSign
            {
            otherlv_0=(Token)match(input,LessThanSign,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getBehaviorTreeAccess().getLessThanSignKeyword_0());
            		
            otherlv_1=(Token)match(input,BehaviorTree,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getBehaviorTreeAccess().getBehaviorTreeKeyword_1());
            		
            // InternalBehaviorTreeParser.g:244:3: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:245:4: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:245:4: (lv_attributes_2_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:246:5: lv_attributes_2_0= ruleAttribute
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
            	    break loop3;
                }
            } while (true);

            otherlv_3=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getBehaviorTreeAccess().getGreaterThanSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:267:3: ( (lv_nodes_4_0= ruleTreeNode ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==LessThanSign) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:268:4: (lv_nodes_4_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:268:4: (lv_nodes_4_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:269:5: lv_nodes_4_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getBehaviorTreeAccess().getNodesTreeNodeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // InternalBehaviorTreeParser.g:302:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalBehaviorTreeParser.g:302:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalBehaviorTreeParser.g:303:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalBehaviorTreeParser.g:309:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:315:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalBehaviorTreeParser.g:316:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalBehaviorTreeParser.g:316:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalBehaviorTreeParser.g:317:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalBehaviorTreeParser.g:317:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorTreeParser.g:318:4: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorTreeParser.g:318:4: (lv_name_0_0= RULE_ID )
            // InternalBehaviorTreeParser.g:319:5: lv_name_0_0= RULE_ID
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
            		
            // InternalBehaviorTreeParser.g:339:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:340:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:340:4: (lv_value_2_0= RULE_STRING )
            // InternalBehaviorTreeParser.g:341:5: lv_value_2_0= RULE_STRING
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
    // InternalBehaviorTreeParser.g:361:1: entryRuleTreeNode returns [EObject current=null] : iv_ruleTreeNode= ruleTreeNode EOF ;
    public final EObject entryRuleTreeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTreeNode = null;


        try {
            // InternalBehaviorTreeParser.g:361:49: (iv_ruleTreeNode= ruleTreeNode EOF )
            // InternalBehaviorTreeParser.g:362:2: iv_ruleTreeNode= ruleTreeNode EOF
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
    // InternalBehaviorTreeParser.g:368:1: ruleTreeNode returns [EObject current=null] : (this_ControlNode_0= ruleControlNode | this_DecoratorNode_1= ruleDecoratorNode | this_LeafNode_2= ruleLeafNode | this_SubtreeNode_3= ruleSubtreeNode ) ;
    public final EObject ruleTreeNode() throws RecognitionException {
        EObject current = null;

        EObject this_ControlNode_0 = null;

        EObject this_DecoratorNode_1 = null;

        EObject this_LeafNode_2 = null;

        EObject this_SubtreeNode_3 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:374:2: ( (this_ControlNode_0= ruleControlNode | this_DecoratorNode_1= ruleDecoratorNode | this_LeafNode_2= ruleLeafNode | this_SubtreeNode_3= ruleSubtreeNode ) )
            // InternalBehaviorTreeParser.g:375:2: (this_ControlNode_0= ruleControlNode | this_DecoratorNode_1= ruleDecoratorNode | this_LeafNode_2= ruleLeafNode | this_SubtreeNode_3= ruleSubtreeNode )
            {
            // InternalBehaviorTreeParser.g:375:2: (this_ControlNode_0= ruleControlNode | this_DecoratorNode_1= ruleDecoratorNode | this_LeafNode_2= ruleLeafNode | this_SubtreeNode_3= ruleSubtreeNode )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LessThanSign) ) {
                switch ( input.LA(2) ) {
                case AlwaysFailure:
                case AlwaysSuccess:
                case SetBlackboard:
                case Condition:
                case Action:
                    {
                    alt5=3;
                    }
                    break;
                case FallbackStar:
                case SequenceStar:
                case Fallback:
                case Parallel:
                case Sequence:
                case RULE_SWITCH_KEYWORD:
                    {
                    alt5=1;
                    }
                    break;
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
                    alt5=2;
                    }
                    break;
                case RULE_SUBTREE_KEYWORD:
                case RULE_SUBTREEWRAPPER_KEYWORD:
                    {
                    alt5=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBehaviorTreeParser.g:376:3: this_ControlNode_0= ruleControlNode
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
                    // InternalBehaviorTreeParser.g:385:3: this_DecoratorNode_1= ruleDecoratorNode
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
                    // InternalBehaviorTreeParser.g:394:3: this_LeafNode_2= ruleLeafNode
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
                    // InternalBehaviorTreeParser.g:403:3: this_SubtreeNode_3= ruleSubtreeNode
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
    // InternalBehaviorTreeParser.g:415:1: entryRuleSubtreeNode returns [EObject current=null] : iv_ruleSubtreeNode= ruleSubtreeNode EOF ;
    public final EObject entryRuleSubtreeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubtreeNode = null;


        try {
            // InternalBehaviorTreeParser.g:415:52: (iv_ruleSubtreeNode= ruleSubtreeNode EOF )
            // InternalBehaviorTreeParser.g:416:2: iv_ruleSubtreeNode= ruleSubtreeNode EOF
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
    // InternalBehaviorTreeParser.g:422:1: ruleSubtreeNode returns [EObject current=null] : (this_Subtree_0= ruleSubtree | this_SubtreeWrapper_1= ruleSubtreeWrapper ) ;
    public final EObject ruleSubtreeNode() throws RecognitionException {
        EObject current = null;

        EObject this_Subtree_0 = null;

        EObject this_SubtreeWrapper_1 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:428:2: ( (this_Subtree_0= ruleSubtree | this_SubtreeWrapper_1= ruleSubtreeWrapper ) )
            // InternalBehaviorTreeParser.g:429:2: (this_Subtree_0= ruleSubtree | this_SubtreeWrapper_1= ruleSubtreeWrapper )
            {
            // InternalBehaviorTreeParser.g:429:2: (this_Subtree_0= ruleSubtree | this_SubtreeWrapper_1= ruleSubtreeWrapper )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LessThanSign) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_SUBTREEWRAPPER_KEYWORD) ) {
                    alt6=2;
                }
                else if ( (LA6_1==RULE_SUBTREE_KEYWORD) ) {
                    alt6=1;
                }
                else {
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
                    // InternalBehaviorTreeParser.g:430:3: this_Subtree_0= ruleSubtree
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
                    // InternalBehaviorTreeParser.g:439:3: this_SubtreeWrapper_1= ruleSubtreeWrapper
                    {

                    			newCompositeNode(grammarAccess.getSubtreeNodeAccess().getSubtreeWrapperParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubtreeWrapper_1=ruleSubtreeWrapper();

                    state._fsp--;


                    			current = this_SubtreeWrapper_1;
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
    // InternalBehaviorTreeParser.g:451:1: entryRuleSubtree returns [EObject current=null] : iv_ruleSubtree= ruleSubtree EOF ;
    public final EObject entryRuleSubtree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubtree = null;


        try {
            // InternalBehaviorTreeParser.g:451:48: (iv_ruleSubtree= ruleSubtree EOF )
            // InternalBehaviorTreeParser.g:452:2: iv_ruleSubtree= ruleSubtree EOF
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
    // InternalBehaviorTreeParser.g:458:1: ruleSubtree returns [EObject current=null] : ( () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:464:2: ( ( () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:465:2: ( () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:465:2: ( () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:466:3: () otherlv_1= LessThanSign this_SUBTREE_KEYWORD_2= RULE_SUBTREE_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:466:3: ()
            // InternalBehaviorTreeParser.g:467:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubtreeAccess().getSubtreeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getSubtreeAccess().getLessThanSignKeyword_1());
            		
            this_SUBTREE_KEYWORD_2=(Token)match(input,RULE_SUBTREE_KEYWORD,FOLLOW_5); 

            			newLeafNode(this_SUBTREE_KEYWORD_2, grammarAccess.getSubtreeAccess().getSUBTREE_KEYWORDTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getSubtreeAccess().getEqualsSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:485:3: ( (otherlv_4= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:486:4: (otherlv_4= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:486:4: (otherlv_4= RULE_STRING )
            // InternalBehaviorTreeParser.g:487:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubtreeRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getSubtreeAccess().getBehaviortreeBehaviorTreeCrossReference_4_0());
            				

            }


            }

            // InternalBehaviorTreeParser.g:498:3: ( (lv_attributes_5_0= ruleAttribute ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:499:4: (lv_attributes_5_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:499:4: (lv_attributes_5_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:500:5: lv_attributes_5_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSubtreeAccess().getAttributesAttributeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop7;
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


    // $ANTLR start "entryRuleSubtreeWrapper"
    // InternalBehaviorTreeParser.g:525:1: entryRuleSubtreeWrapper returns [EObject current=null] : iv_ruleSubtreeWrapper= ruleSubtreeWrapper EOF ;
    public final EObject entryRuleSubtreeWrapper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubtreeWrapper = null;


        try {
            // InternalBehaviorTreeParser.g:525:55: (iv_ruleSubtreeWrapper= ruleSubtreeWrapper EOF )
            // InternalBehaviorTreeParser.g:526:2: iv_ruleSubtreeWrapper= ruleSubtreeWrapper EOF
            {
             newCompositeNode(grammarAccess.getSubtreeWrapperRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubtreeWrapper=ruleSubtreeWrapper();

            state._fsp--;

             current =iv_ruleSubtreeWrapper; 
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
    // $ANTLR end "entryRuleSubtreeWrapper"


    // $ANTLR start "ruleSubtreeWrapper"
    // InternalBehaviorTreeParser.g:532:1: ruleSubtreeWrapper returns [EObject current=null] : ( () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign ) ;
    public final EObject ruleSubtreeWrapper() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_SUBTREEWRAPPER_KEYWORD_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_attributes_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:538:2: ( ( () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:539:2: ( () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:539:2: ( () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:540:3: () otherlv_1= LessThanSign this_SUBTREEWRAPPER_KEYWORD_2= RULE_SUBTREEWRAPPER_KEYWORD otherlv_3= EqualsSign ( (otherlv_4= RULE_STRING ) ) ( (lv_attributes_5_0= ruleAttribute ) )* otherlv_6= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:540:3: ()
            // InternalBehaviorTreeParser.g:541:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubtreeWrapperAccess().getSubTreeWrapperAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getSubtreeWrapperAccess().getLessThanSignKeyword_1());
            		
            this_SUBTREEWRAPPER_KEYWORD_2=(Token)match(input,RULE_SUBTREEWRAPPER_KEYWORD,FOLLOW_5); 

            			newLeafNode(this_SUBTREEWRAPPER_KEYWORD_2, grammarAccess.getSubtreeWrapperAccess().getSUBTREEWRAPPER_KEYWORDTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,EqualsSign,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getSubtreeWrapperAccess().getEqualsSignKeyword_3());
            		
            // InternalBehaviorTreeParser.g:559:3: ( (otherlv_4= RULE_STRING ) )
            // InternalBehaviorTreeParser.g:560:4: (otherlv_4= RULE_STRING )
            {
            // InternalBehaviorTreeParser.g:560:4: (otherlv_4= RULE_STRING )
            // InternalBehaviorTreeParser.g:561:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubtreeWrapperRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getSubtreeWrapperAccess().getBehaviortreeBehaviorTreeCrossReference_4_0());
            				

            }


            }

            // InternalBehaviorTreeParser.g:572:3: ( (lv_attributes_5_0= ruleAttribute ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:573:4: (lv_attributes_5_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:573:4: (lv_attributes_5_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:574:5: lv_attributes_5_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSubtreeWrapperAccess().getAttributesAttributeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_attributes_5_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubtreeWrapperRule());
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

            			newLeafNode(otherlv_6, grammarAccess.getSubtreeWrapperAccess().getSolidusGreaterThanSignKeyword_6());
            		

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
    // $ANTLR end "ruleSubtreeWrapper"


    // $ANTLR start "entryRuleControlNode"
    // InternalBehaviorTreeParser.g:599:1: entryRuleControlNode returns [EObject current=null] : iv_ruleControlNode= ruleControlNode EOF ;
    public final EObject entryRuleControlNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleControlNode = null;


        try {
            // InternalBehaviorTreeParser.g:599:52: (iv_ruleControlNode= ruleControlNode EOF )
            // InternalBehaviorTreeParser.g:600:2: iv_ruleControlNode= ruleControlNode EOF
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
    // InternalBehaviorTreeParser.g:606:1: ruleControlNode returns [EObject current=null] : (this_Sequence_0= ruleSequence | this_SequenceStar_1= ruleSequenceStar | this_Parallel_2= ruleParallel | this_Fallback_3= ruleFallback | this_FallbackStar_4= ruleFallbackStar | this_Switch_5= ruleSwitch ) ;
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
            // InternalBehaviorTreeParser.g:612:2: ( (this_Sequence_0= ruleSequence | this_SequenceStar_1= ruleSequenceStar | this_Parallel_2= ruleParallel | this_Fallback_3= ruleFallback | this_FallbackStar_4= ruleFallbackStar | this_Switch_5= ruleSwitch ) )
            // InternalBehaviorTreeParser.g:613:2: (this_Sequence_0= ruleSequence | this_SequenceStar_1= ruleSequenceStar | this_Parallel_2= ruleParallel | this_Fallback_3= ruleFallback | this_FallbackStar_4= ruleFallbackStar | this_Switch_5= ruleSwitch )
            {
            // InternalBehaviorTreeParser.g:613:2: (this_Sequence_0= ruleSequence | this_SequenceStar_1= ruleSequenceStar | this_Parallel_2= ruleParallel | this_Fallback_3= ruleFallback | this_FallbackStar_4= ruleFallbackStar | this_Switch_5= ruleSwitch )
            int alt9=6;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LessThanSign) ) {
                switch ( input.LA(2) ) {
                case Sequence:
                    {
                    alt9=1;
                    }
                    break;
                case Fallback:
                    {
                    alt9=4;
                    }
                    break;
                case SequenceStar:
                    {
                    alt9=2;
                    }
                    break;
                case RULE_SWITCH_KEYWORD:
                    {
                    alt9=6;
                    }
                    break;
                case Parallel:
                    {
                    alt9=3;
                    }
                    break;
                case FallbackStar:
                    {
                    alt9=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBehaviorTreeParser.g:614:3: this_Sequence_0= ruleSequence
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
                    // InternalBehaviorTreeParser.g:623:3: this_SequenceStar_1= ruleSequenceStar
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
                    // InternalBehaviorTreeParser.g:632:3: this_Parallel_2= ruleParallel
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
                    // InternalBehaviorTreeParser.g:641:3: this_Fallback_3= ruleFallback
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
                    // InternalBehaviorTreeParser.g:650:3: this_FallbackStar_4= ruleFallbackStar
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
                    // InternalBehaviorTreeParser.g:659:3: this_Switch_5= ruleSwitch
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
    // InternalBehaviorTreeParser.g:671:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // InternalBehaviorTreeParser.g:671:49: (iv_ruleSequence= ruleSequence EOF )
            // InternalBehaviorTreeParser.g:672:2: iv_ruleSequence= ruleSequence EOF
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
    // InternalBehaviorTreeParser.g:678:1: ruleSequence returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:684:2: ( ( () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:685:2: ( () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:685:2: ( () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:686:3: () otherlv_1= LessThanSign otherlv_2= Sequence ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Sequence otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:686:3: ()
            // InternalBehaviorTreeParser.g:687:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSequenceAccess().getSequenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getSequenceAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Sequence,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getSequenceAccess().getSequenceKeyword_2());
            		
            // InternalBehaviorTreeParser.g:701:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:702:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:702:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:703:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop10;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:724:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==LessThanSign) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:725:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:725:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:726:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getSequenceAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_18); 

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
    // InternalBehaviorTreeParser.g:759:1: entryRuleSequenceStar returns [EObject current=null] : iv_ruleSequenceStar= ruleSequenceStar EOF ;
    public final EObject entryRuleSequenceStar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceStar = null;


        try {
            // InternalBehaviorTreeParser.g:759:53: (iv_ruleSequenceStar= ruleSequenceStar EOF )
            // InternalBehaviorTreeParser.g:760:2: iv_ruleSequenceStar= ruleSequenceStar EOF
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
    // InternalBehaviorTreeParser.g:766:1: ruleSequenceStar returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:772:2: ( ( () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:773:2: ( () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:773:2: ( () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:774:3: () otherlv_1= LessThanSign otherlv_2= SequenceStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= SequenceStar otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:774:3: ()
            // InternalBehaviorTreeParser.g:775:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSequenceStarAccess().getSequenceStarAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSequenceStarAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,SequenceStar,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getSequenceStarAccess().getSequenceStarKeyword_2());
            		
            // InternalBehaviorTreeParser.g:789:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:790:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:790:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:791:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getSequenceStarAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:812:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==LessThanSign) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:813:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:813:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:814:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getSequenceStarAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_19); 

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
    // InternalBehaviorTreeParser.g:847:1: entryRuleFallback returns [EObject current=null] : iv_ruleFallback= ruleFallback EOF ;
    public final EObject entryRuleFallback() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFallback = null;


        try {
            // InternalBehaviorTreeParser.g:847:49: (iv_ruleFallback= ruleFallback EOF )
            // InternalBehaviorTreeParser.g:848:2: iv_ruleFallback= ruleFallback EOF
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
    // InternalBehaviorTreeParser.g:854:1: ruleFallback returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:860:2: ( ( () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:861:2: ( () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:861:2: ( () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:862:3: () otherlv_1= LessThanSign otherlv_2= Fallback ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Fallback otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:862:3: ()
            // InternalBehaviorTreeParser.g:863:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFallbackAccess().getFallbackAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getFallbackAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Fallback,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getFallbackAccess().getFallbackKeyword_2());
            		
            // InternalBehaviorTreeParser.g:877:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:878:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:878:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:879:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop14;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getFallbackAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:900:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==LessThanSign) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:901:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:901:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:902:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getFallbackAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_20); 

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
    // InternalBehaviorTreeParser.g:935:1: entryRuleFallbackStar returns [EObject current=null] : iv_ruleFallbackStar= ruleFallbackStar EOF ;
    public final EObject entryRuleFallbackStar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFallbackStar = null;


        try {
            // InternalBehaviorTreeParser.g:935:53: (iv_ruleFallbackStar= ruleFallbackStar EOF )
            // InternalBehaviorTreeParser.g:936:2: iv_ruleFallbackStar= ruleFallbackStar EOF
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
    // InternalBehaviorTreeParser.g:942:1: ruleFallbackStar returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:948:2: ( ( () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:949:2: ( () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:949:2: ( () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:950:3: () otherlv_1= LessThanSign otherlv_2= FallbackStar ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= FallbackStar otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:950:3: ()
            // InternalBehaviorTreeParser.g:951:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFallbackStarAccess().getFallbackStarAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getFallbackStarAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,FallbackStar,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getFallbackStarAccess().getFallbackStarKeyword_2());
            		
            // InternalBehaviorTreeParser.g:965:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:966:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:966:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:967:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop16;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getFallbackStarAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:988:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==LessThanSign) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:989:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:989:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:990:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getFallbackStarAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_21); 

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
    // InternalBehaviorTreeParser.g:1023:1: entryRuleParallel returns [EObject current=null] : iv_ruleParallel= ruleParallel EOF ;
    public final EObject entryRuleParallel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParallel = null;


        try {
            // InternalBehaviorTreeParser.g:1023:49: (iv_ruleParallel= ruleParallel EOF )
            // InternalBehaviorTreeParser.g:1024:2: iv_ruleParallel= ruleParallel EOF
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
    // InternalBehaviorTreeParser.g:1030:1: ruleParallel returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1036:2: ( ( () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1037:2: ( () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1037:2: ( () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1038:3: () otherlv_1= LessThanSign otherlv_2= Parallel ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )+ otherlv_6= LessThanSignSolidus otherlv_7= Parallel otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1038:3: ()
            // InternalBehaviorTreeParser.g:1039:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParallelAccess().getParallelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getParallelAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Parallel,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getParallelAccess().getParallelKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1053:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1054:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1054:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1055:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop18;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getParallelAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1076:3: ( (lv_nodes_5_0= ruleTreeNode ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==LessThanSign) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1077:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:1077:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:1078:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getParallelAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_22); 

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


    // $ANTLR start "entryRuleDecoratorNode"
    // InternalBehaviorTreeParser.g:1111:1: entryRuleDecoratorNode returns [EObject current=null] : iv_ruleDecoratorNode= ruleDecoratorNode EOF ;
    public final EObject entryRuleDecoratorNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecoratorNode = null;


        try {
            // InternalBehaviorTreeParser.g:1111:54: (iv_ruleDecoratorNode= ruleDecoratorNode EOF )
            // InternalBehaviorTreeParser.g:1112:2: iv_ruleDecoratorNode= ruleDecoratorNode EOF
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
    // InternalBehaviorTreeParser.g:1118:1: ruleDecoratorNode returns [EObject current=null] : (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString ) ;
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
            // InternalBehaviorTreeParser.g:1124:2: ( (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString ) )
            // InternalBehaviorTreeParser.g:1125:2: (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString )
            {
            // InternalBehaviorTreeParser.g:1125:2: (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString )
            int alt20=9;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalBehaviorTreeParser.g:1126:3: this_ForceSuccess_0= ruleForceSuccess
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
                    // InternalBehaviorTreeParser.g:1135:3: this_ForceFailure_1= ruleForceFailure
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
                    // InternalBehaviorTreeParser.g:1144:3: this_Repeat_2= ruleRepeat
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
                    // InternalBehaviorTreeParser.g:1153:3: this_RetryUntilSuccess_3= ruleRetryUntilSuccess
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
                    // InternalBehaviorTreeParser.g:1162:3: this_Inverter_4= ruleInverter
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
                    // InternalBehaviorTreeParser.g:1171:3: this_Timeout_5= ruleTimeout
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
                    // InternalBehaviorTreeParser.g:1180:3: this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble
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
                    // InternalBehaviorTreeParser.g:1189:3: this_BlackboardCheckInt_7= ruleBlackboardCheckInt
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
                    // InternalBehaviorTreeParser.g:1198:3: this_BlackboardCheckString_8= ruleBlackboardCheckString
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
    // InternalBehaviorTreeParser.g:1210:1: entryRuleForceSuccess returns [EObject current=null] : iv_ruleForceSuccess= ruleForceSuccess EOF ;
    public final EObject entryRuleForceSuccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForceSuccess = null;


        try {
            // InternalBehaviorTreeParser.g:1210:53: (iv_ruleForceSuccess= ruleForceSuccess EOF )
            // InternalBehaviorTreeParser.g:1211:2: iv_ruleForceSuccess= ruleForceSuccess EOF
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
    // InternalBehaviorTreeParser.g:1217:1: ruleForceSuccess returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1223:2: ( ( () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1224:2: ( () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1224:2: ( () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1225:3: () otherlv_1= LessThanSign otherlv_2= ForceSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceSuccess otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1225:3: ()
            // InternalBehaviorTreeParser.g:1226:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForceSuccessAccess().getForceSuccessAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getForceSuccessAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,ForceSuccess,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getForceSuccessAccess().getForceSuccessKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1240:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1241:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1241:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1242:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getForceSuccessAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1263:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1264:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1264:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1265:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getForceSuccessAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_23); 

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
    // InternalBehaviorTreeParser.g:1298:1: entryRuleForceFailure returns [EObject current=null] : iv_ruleForceFailure= ruleForceFailure EOF ;
    public final EObject entryRuleForceFailure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForceFailure = null;


        try {
            // InternalBehaviorTreeParser.g:1298:53: (iv_ruleForceFailure= ruleForceFailure EOF )
            // InternalBehaviorTreeParser.g:1299:2: iv_ruleForceFailure= ruleForceFailure EOF
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
    // InternalBehaviorTreeParser.g:1305:1: ruleForceFailure returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1311:2: ( ( () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1312:2: ( () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1312:2: ( () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1313:3: () otherlv_1= LessThanSign otherlv_2= ForceFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= ForceFailure otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1313:3: ()
            // InternalBehaviorTreeParser.g:1314:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForceFailureAccess().getForceFailureAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getForceFailureAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,ForceFailure,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getForceFailureAccess().getForceFailureKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1328:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1329:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1329:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1330:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop22;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getForceFailureAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1351:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1352:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1352:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1353:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getForceFailureAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_25); 

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
    // InternalBehaviorTreeParser.g:1386:1: entryRuleRepeat returns [EObject current=null] : iv_ruleRepeat= ruleRepeat EOF ;
    public final EObject entryRuleRepeat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeat = null;


        try {
            // InternalBehaviorTreeParser.g:1386:47: (iv_ruleRepeat= ruleRepeat EOF )
            // InternalBehaviorTreeParser.g:1387:2: iv_ruleRepeat= ruleRepeat EOF
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
    // InternalBehaviorTreeParser.g:1393:1: ruleRepeat returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1399:2: ( ( () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1400:2: ( () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1400:2: ( () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1401:3: () otherlv_1= LessThanSign otherlv_2= Repeat ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Repeat otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1401:3: ()
            // InternalBehaviorTreeParser.g:1402:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRepeatAccess().getRepeatAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getRepeatAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Repeat,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getRepeatAccess().getRepeatKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1416:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1417:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1417:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1418:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop23;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getRepeatAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1439:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1440:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1440:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1441:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getRepeatAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_26); 

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
    // InternalBehaviorTreeParser.g:1474:1: entryRuleInverter returns [EObject current=null] : iv_ruleInverter= ruleInverter EOF ;
    public final EObject entryRuleInverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInverter = null;


        try {
            // InternalBehaviorTreeParser.g:1474:49: (iv_ruleInverter= ruleInverter EOF )
            // InternalBehaviorTreeParser.g:1475:2: iv_ruleInverter= ruleInverter EOF
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
    // InternalBehaviorTreeParser.g:1481:1: ruleInverter returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1487:2: ( ( () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1488:2: ( () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1488:2: ( () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1489:3: () otherlv_1= LessThanSign otherlv_2= Inverter ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Inverter otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1489:3: ()
            // InternalBehaviorTreeParser.g:1490:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInverterAccess().getInverterAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_27); 

            			newLeafNode(otherlv_1, grammarAccess.getInverterAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Inverter,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getInverterAccess().getInverterKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1504:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1505:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1505:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1506:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop24;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getInverterAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1527:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1528:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1528:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1529:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getInverterAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_27); 

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
    // InternalBehaviorTreeParser.g:1562:1: entryRuleTimeout returns [EObject current=null] : iv_ruleTimeout= ruleTimeout EOF ;
    public final EObject entryRuleTimeout() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeout = null;


        try {
            // InternalBehaviorTreeParser.g:1562:48: (iv_ruleTimeout= ruleTimeout EOF )
            // InternalBehaviorTreeParser.g:1563:2: iv_ruleTimeout= ruleTimeout EOF
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
    // InternalBehaviorTreeParser.g:1569:1: ruleTimeout returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1575:2: ( ( () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1576:2: ( () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1576:2: ( () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1577:3: () otherlv_1= LessThanSign otherlv_2= Timeout ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= Timeout otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1577:3: ()
            // InternalBehaviorTreeParser.g:1578:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeoutAccess().getTimeoutAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeoutAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Timeout,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeoutAccess().getTimeoutKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1592:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1593:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1593:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1594:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop25;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getTimeoutAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1615:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1616:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1616:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1617:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getTimeoutAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_28); 

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
    // InternalBehaviorTreeParser.g:1650:1: entryRuleRetryUntilSuccess returns [EObject current=null] : iv_ruleRetryUntilSuccess= ruleRetryUntilSuccess EOF ;
    public final EObject entryRuleRetryUntilSuccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRetryUntilSuccess = null;


        try {
            // InternalBehaviorTreeParser.g:1650:58: (iv_ruleRetryUntilSuccess= ruleRetryUntilSuccess EOF )
            // InternalBehaviorTreeParser.g:1651:2: iv_ruleRetryUntilSuccess= ruleRetryUntilSuccess EOF
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
    // InternalBehaviorTreeParser.g:1657:1: ruleRetryUntilSuccess returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1663:2: ( ( () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1664:2: ( () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1664:2: ( () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1665:3: () otherlv_1= LessThanSign otherlv_2= RetryUntilSuccesful ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= RetryUntilSuccesful otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1665:3: ()
            // InternalBehaviorTreeParser.g:1666:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRetryUntilSuccessAccess().getRetryUntilSuccessAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getRetryUntilSuccessAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,RetryUntilSuccesful,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getRetryUntilSuccessAccess().getRetryUntilSuccesfulKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1680:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1681:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1681:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1682:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop26;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getRetryUntilSuccessAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1703:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1704:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1704:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1705:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getRetryUntilSuccessAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_29); 

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
    // InternalBehaviorTreeParser.g:1738:1: entryRuleBlackboardCheckDouble returns [EObject current=null] : iv_ruleBlackboardCheckDouble= ruleBlackboardCheckDouble EOF ;
    public final EObject entryRuleBlackboardCheckDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlackboardCheckDouble = null;


        try {
            // InternalBehaviorTreeParser.g:1738:62: (iv_ruleBlackboardCheckDouble= ruleBlackboardCheckDouble EOF )
            // InternalBehaviorTreeParser.g:1739:2: iv_ruleBlackboardCheckDouble= ruleBlackboardCheckDouble EOF
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
    // InternalBehaviorTreeParser.g:1745:1: ruleBlackboardCheckDouble returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1751:2: ( ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1752:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1752:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1753:3: () otherlv_1= LessThanSign otherlv_2= BlackboardCheckDouble ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckDouble otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1753:3: ()
            // InternalBehaviorTreeParser.g:1754:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlackboardCheckDoubleAccess().getBlackboardCheckDoubleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getBlackboardCheckDoubleAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,BlackboardCheckDouble,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getBlackboardCheckDoubleAccess().getBlackboardCheckDoubleKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1768:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1769:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1769:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1770:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop27;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getBlackboardCheckDoubleAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1791:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1792:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1792:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1793:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getBlackboardCheckDoubleAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_30); 

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
    // InternalBehaviorTreeParser.g:1826:1: entryRuleBlackboardCheckInt returns [EObject current=null] : iv_ruleBlackboardCheckInt= ruleBlackboardCheckInt EOF ;
    public final EObject entryRuleBlackboardCheckInt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlackboardCheckInt = null;


        try {
            // InternalBehaviorTreeParser.g:1826:59: (iv_ruleBlackboardCheckInt= ruleBlackboardCheckInt EOF )
            // InternalBehaviorTreeParser.g:1827:2: iv_ruleBlackboardCheckInt= ruleBlackboardCheckInt EOF
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
    // InternalBehaviorTreeParser.g:1833:1: ruleBlackboardCheckInt returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1839:2: ( ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1840:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1840:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1841:3: () otherlv_1= LessThanSign otherlv_2= BlackboardCheckInt ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckInt otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1841:3: ()
            // InternalBehaviorTreeParser.g:1842:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlackboardCheckIntAccess().getBlackboardCheckIntAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getBlackboardCheckIntAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,BlackboardCheckInt,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getBlackboardCheckIntAccess().getBlackboardCheckIntKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1856:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1857:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1857:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1858:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop28;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getBlackboardCheckIntAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1879:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1880:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1880:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1881:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getBlackboardCheckIntAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_31); 

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
    // InternalBehaviorTreeParser.g:1914:1: entryRuleBlackboardCheckString returns [EObject current=null] : iv_ruleBlackboardCheckString= ruleBlackboardCheckString EOF ;
    public final EObject entryRuleBlackboardCheckString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlackboardCheckString = null;


        try {
            // InternalBehaviorTreeParser.g:1914:62: (iv_ruleBlackboardCheckString= ruleBlackboardCheckString EOF )
            // InternalBehaviorTreeParser.g:1915:2: iv_ruleBlackboardCheckString= ruleBlackboardCheckString EOF
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
    // InternalBehaviorTreeParser.g:1921:1: ruleBlackboardCheckString returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:1927:2: ( ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:1928:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:1928:2: ( () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:1929:3: () otherlv_1= LessThanSign otherlv_2= BlackboardCheckString ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_node_5_0= ruleTreeNode ) ) otherlv_6= LessThanSignSolidus otherlv_7= BlackboardCheckString otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:1929:3: ()
            // InternalBehaviorTreeParser.g:1930:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlackboardCheckStringAccess().getBlackboardCheckStringAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getBlackboardCheckStringAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,BlackboardCheckString,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getBlackboardCheckStringAccess().getBlackboardCheckStringKeyword_2());
            		
            // InternalBehaviorTreeParser.g:1944:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:1945:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:1945:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:1946:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop29;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getBlackboardCheckStringAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:1967:3: ( (lv_node_5_0= ruleTreeNode ) )
            // InternalBehaviorTreeParser.g:1968:4: (lv_node_5_0= ruleTreeNode )
            {
            // InternalBehaviorTreeParser.g:1968:4: (lv_node_5_0= ruleTreeNode )
            // InternalBehaviorTreeParser.g:1969:5: lv_node_5_0= ruleTreeNode
            {

            					newCompositeNode(grammarAccess.getBlackboardCheckStringAccess().getNodeTreeNodeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_32); 

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
    // InternalBehaviorTreeParser.g:2002:1: entryRuleLeafNode returns [EObject current=null] : iv_ruleLeafNode= ruleLeafNode EOF ;
    public final EObject entryRuleLeafNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeafNode = null;


        try {
            // InternalBehaviorTreeParser.g:2002:49: (iv_ruleLeafNode= ruleLeafNode EOF )
            // InternalBehaviorTreeParser.g:2003:2: iv_ruleLeafNode= ruleLeafNode EOF
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
    // InternalBehaviorTreeParser.g:2009:1: ruleLeafNode returns [EObject current=null] : (this_AbstractAction_0= ruleAbstractAction | this_Condition_1= ruleCondition ) ;
    public final EObject ruleLeafNode() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractAction_0 = null;

        EObject this_Condition_1 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2015:2: ( (this_AbstractAction_0= ruleAbstractAction | this_Condition_1= ruleCondition ) )
            // InternalBehaviorTreeParser.g:2016:2: (this_AbstractAction_0= ruleAbstractAction | this_Condition_1= ruleCondition )
            {
            // InternalBehaviorTreeParser.g:2016:2: (this_AbstractAction_0= ruleAbstractAction | this_Condition_1= ruleCondition )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==LessThanSign) ) {
                int LA30_1 = input.LA(2);

                if ( ((LA30_1>=AlwaysFailure && LA30_1<=SetBlackboard)||LA30_1==Action) ) {
                    alt30=1;
                }
                else if ( (LA30_1==Condition) ) {
                    alt30=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalBehaviorTreeParser.g:2017:3: this_AbstractAction_0= ruleAbstractAction
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
                    // InternalBehaviorTreeParser.g:2026:3: this_Condition_1= ruleCondition
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
    // InternalBehaviorTreeParser.g:2038:1: entryRuleAbstractAction returns [EObject current=null] : iv_ruleAbstractAction= ruleAbstractAction EOF ;
    public final EObject entryRuleAbstractAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractAction = null;


        try {
            // InternalBehaviorTreeParser.g:2038:55: (iv_ruleAbstractAction= ruleAbstractAction EOF )
            // InternalBehaviorTreeParser.g:2039:2: iv_ruleAbstractAction= ruleAbstractAction EOF
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
    // InternalBehaviorTreeParser.g:2045:1: ruleAbstractAction returns [EObject current=null] : (this_AlwaysSuccess_0= ruleAlwaysSuccess | this_AlwaysFailure_1= ruleAlwaysFailure | this_SetBlackboard_2= ruleSetBlackboard | this_Action_3= ruleAction ) ;
    public final EObject ruleAbstractAction() throws RecognitionException {
        EObject current = null;

        EObject this_AlwaysSuccess_0 = null;

        EObject this_AlwaysFailure_1 = null;

        EObject this_SetBlackboard_2 = null;

        EObject this_Action_3 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2051:2: ( (this_AlwaysSuccess_0= ruleAlwaysSuccess | this_AlwaysFailure_1= ruleAlwaysFailure | this_SetBlackboard_2= ruleSetBlackboard | this_Action_3= ruleAction ) )
            // InternalBehaviorTreeParser.g:2052:2: (this_AlwaysSuccess_0= ruleAlwaysSuccess | this_AlwaysFailure_1= ruleAlwaysFailure | this_SetBlackboard_2= ruleSetBlackboard | this_Action_3= ruleAction )
            {
            // InternalBehaviorTreeParser.g:2052:2: (this_AlwaysSuccess_0= ruleAlwaysSuccess | this_AlwaysFailure_1= ruleAlwaysFailure | this_SetBlackboard_2= ruleSetBlackboard | this_Action_3= ruleAction )
            int alt31=4;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==LessThanSign) ) {
                switch ( input.LA(2) ) {
                case SetBlackboard:
                    {
                    alt31=3;
                    }
                    break;
                case AlwaysFailure:
                    {
                    alt31=2;
                    }
                    break;
                case AlwaysSuccess:
                    {
                    alt31=1;
                    }
                    break;
                case Action:
                    {
                    alt31=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalBehaviorTreeParser.g:2053:3: this_AlwaysSuccess_0= ruleAlwaysSuccess
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
                    // InternalBehaviorTreeParser.g:2062:3: this_AlwaysFailure_1= ruleAlwaysFailure
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
                    // InternalBehaviorTreeParser.g:2071:3: this_SetBlackboard_2= ruleSetBlackboard
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
                    // InternalBehaviorTreeParser.g:2080:3: this_Action_3= ruleAction
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
    // InternalBehaviorTreeParser.g:2092:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalBehaviorTreeParser.g:2092:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalBehaviorTreeParser.g:2093:2: iv_ruleCondition= ruleCondition EOF
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
    // InternalBehaviorTreeParser.g:2099:1: ruleCondition returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2105:2: ( ( () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2106:2: ( () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2106:2: ( () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2107:3: () otherlv_1= LessThanSign otherlv_2= Condition ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2107:3: ()
            // InternalBehaviorTreeParser.g:2108:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConditionAccess().getConditionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Condition,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getConditionKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2122:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2123:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2123:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2124:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getConditionAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop32;
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
    // InternalBehaviorTreeParser.g:2149:1: entryRuleAlwaysSuccess returns [EObject current=null] : iv_ruleAlwaysSuccess= ruleAlwaysSuccess EOF ;
    public final EObject entryRuleAlwaysSuccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlwaysSuccess = null;


        try {
            // InternalBehaviorTreeParser.g:2149:54: (iv_ruleAlwaysSuccess= ruleAlwaysSuccess EOF )
            // InternalBehaviorTreeParser.g:2150:2: iv_ruleAlwaysSuccess= ruleAlwaysSuccess EOF
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
    // InternalBehaviorTreeParser.g:2156:1: ruleAlwaysSuccess returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleAlwaysSuccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2162:2: ( ( () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2163:2: ( () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2163:2: ( () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2164:3: () otherlv_1= LessThanSign otherlv_2= AlwaysSuccess ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2164:3: ()
            // InternalBehaviorTreeParser.g:2165:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAlwaysSuccessAccess().getAlwaysSuccessAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getAlwaysSuccessAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,AlwaysSuccess,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getAlwaysSuccessAccess().getAlwaysSuccessKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2179:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2180:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2180:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2181:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getAlwaysSuccessAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop33;
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
    // InternalBehaviorTreeParser.g:2206:1: entryRuleAlwaysFailure returns [EObject current=null] : iv_ruleAlwaysFailure= ruleAlwaysFailure EOF ;
    public final EObject entryRuleAlwaysFailure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlwaysFailure = null;


        try {
            // InternalBehaviorTreeParser.g:2206:54: (iv_ruleAlwaysFailure= ruleAlwaysFailure EOF )
            // InternalBehaviorTreeParser.g:2207:2: iv_ruleAlwaysFailure= ruleAlwaysFailure EOF
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
    // InternalBehaviorTreeParser.g:2213:1: ruleAlwaysFailure returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleAlwaysFailure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2219:2: ( ( () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2220:2: ( () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2220:2: ( () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2221:3: () otherlv_1= LessThanSign otherlv_2= AlwaysFailure ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2221:3: ()
            // InternalBehaviorTreeParser.g:2222:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAlwaysFailureAccess().getAlwaysFailureAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getAlwaysFailureAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,AlwaysFailure,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getAlwaysFailureAccess().getAlwaysFailureKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2236:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2237:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2237:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2238:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getAlwaysFailureAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop34;
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
    // InternalBehaviorTreeParser.g:2263:1: entryRuleSetBlackboard returns [EObject current=null] : iv_ruleSetBlackboard= ruleSetBlackboard EOF ;
    public final EObject entryRuleSetBlackboard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetBlackboard = null;


        try {
            // InternalBehaviorTreeParser.g:2263:54: (iv_ruleSetBlackboard= ruleSetBlackboard EOF )
            // InternalBehaviorTreeParser.g:2264:2: iv_ruleSetBlackboard= ruleSetBlackboard EOF
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
    // InternalBehaviorTreeParser.g:2270:1: ruleSetBlackboard returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleSetBlackboard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2276:2: ( ( () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2277:2: ( () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2277:2: ( () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2278:3: () otherlv_1= LessThanSign otherlv_2= SetBlackboard ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2278:3: ()
            // InternalBehaviorTreeParser.g:2279:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSetBlackboardAccess().getSetBlackboardAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getSetBlackboardAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,SetBlackboard,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getSetBlackboardAccess().getSetBlackboardKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2293:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2294:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2294:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2295:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getSetBlackboardAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop35;
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
    // InternalBehaviorTreeParser.g:2320:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalBehaviorTreeParser.g:2320:47: (iv_ruleAction= ruleAction EOF )
            // InternalBehaviorTreeParser.g:2321:2: iv_ruleAction= ruleAction EOF
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
    // InternalBehaviorTreeParser.g:2327:1: ruleAction returns [EObject current=null] : ( () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorTreeParser.g:2333:2: ( ( () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2334:2: ( () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2334:2: ( () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign )
            // InternalBehaviorTreeParser.g:2335:3: () otherlv_1= LessThanSign otherlv_2= Action ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= SolidusGreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2335:3: ()
            // InternalBehaviorTreeParser.g:2336:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionAccess().getActionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getActionAccess().getLessThanSignKeyword_1());
            		
            otherlv_2=(Token)match(input,Action,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getActionAccess().getActionKeyword_2());
            		
            // InternalBehaviorTreeParser.g:2350:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2351:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2351:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2352:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getActionAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop36;
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


    // $ANTLR start "entryRuleSwitch"
    // InternalBehaviorTreeParser.g:2377:1: entryRuleSwitch returns [EObject current=null] : iv_ruleSwitch= ruleSwitch EOF ;
    public final EObject entryRuleSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch = null;


        try {
            // InternalBehaviorTreeParser.g:2377:47: (iv_ruleSwitch= ruleSwitch EOF )
            // InternalBehaviorTreeParser.g:2378:2: iv_ruleSwitch= ruleSwitch EOF
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
    // InternalBehaviorTreeParser.g:2384:1: ruleSwitch returns [EObject current=null] : ( () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign ) ;
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
            // InternalBehaviorTreeParser.g:2390:2: ( ( () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign ) )
            // InternalBehaviorTreeParser.g:2391:2: ( () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign )
            {
            // InternalBehaviorTreeParser.g:2391:2: ( () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign )
            // InternalBehaviorTreeParser.g:2392:3: () otherlv_1= LessThanSign this_SWITCH_KEYWORD_2= RULE_SWITCH_KEYWORD ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= GreaterThanSign ( (lv_nodes_5_0= ruleTreeNode ) )* otherlv_6= LessThanSignSolidus this_SWITCH_KEYWORD_7= RULE_SWITCH_KEYWORD otherlv_8= GreaterThanSign
            {
            // InternalBehaviorTreeParser.g:2392:3: ()
            // InternalBehaviorTreeParser.g:2393:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSwitchAccess().getSwitchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LessThanSign,FOLLOW_38); 

            			newLeafNode(otherlv_1, grammarAccess.getSwitchAccess().getLessThanSignKeyword_1());
            		
            this_SWITCH_KEYWORD_2=(Token)match(input,RULE_SWITCH_KEYWORD,FOLLOW_14); 

            			newLeafNode(this_SWITCH_KEYWORD_2, grammarAccess.getSwitchAccess().getSWITCH_KEYWORDTerminalRuleCall_2());
            		
            // InternalBehaviorTreeParser.g:2407:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2408:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalBehaviorTreeParser.g:2408:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalBehaviorTreeParser.g:2409:5: lv_attributes_3_0= ruleAttribute
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
            	    break loop37;
                }
            } while (true);

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getSwitchAccess().getGreaterThanSignKeyword_4());
            		
            // InternalBehaviorTreeParser.g:2430:3: ( (lv_nodes_5_0= ruleTreeNode ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==LessThanSign) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBehaviorTreeParser.g:2431:4: (lv_nodes_5_0= ruleTreeNode )
            	    {
            	    // InternalBehaviorTreeParser.g:2431:4: (lv_nodes_5_0= ruleTreeNode )
            	    // InternalBehaviorTreeParser.g:2432:5: lv_nodes_5_0= ruleTreeNode
            	    {

            	    					newCompositeNode(grammarAccess.getSwitchAccess().getNodesTreeNodeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    break loop38;
                }
            } while (true);

            otherlv_6=(Token)match(input,LessThanSignSolidus,FOLLOW_38); 

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

    // Delegated rules


    protected DFA20 dfa20 = new DFA20(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\36\1\4\11\uffff";
    static final String dfa_3s = "\1\36\1\31\11\uffff";
    static final String dfa_4s = "\2\uffff\1\4\1\7\1\2\1\6\1\10\1\3\1\11\1\1\1\5";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\3\1\10\1\uffff\1\2\1\6\5\uffff\1\4\1\11\3\uffff\1\12\2\uffff\1\5\2\uffff\1\7",
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

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1125:2: (this_ForceSuccess_0= ruleForceSuccess | this_ForceFailure_1= ruleForceFailure | this_Repeat_2= ruleRepeat | this_RetryUntilSuccess_3= ruleRetryUntilSuccess | this_Inverter_4= ruleInverter | this_Timeout_5= ruleTimeout | this_BlackboardCheckDouble_6= ruleBlackboardCheckDouble | this_BlackboardCheckInt_7= ruleBlackboardCheckInt | this_BlackboardCheckString_8= ruleBlackboardCheckString )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000008100000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000008010000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000400000000L});

}