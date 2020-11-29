package org.xtext.miron.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.miron.services.MIRoNGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMIRoNParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ROQME_DESCRIPTION", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'miron'", "'import'", "'as'", "'number'", "'['", "']'", "'unit'", "'('", "':'", "')'", "'{'", "','", "'}'", "'affects'", "'enum'", "'preset'", "'varpoint'", "'in'", "'arch'", "'parameterSetRepository'", "'parameterSet'", "'component'", "'parameter'", "'rule'", "'implies'", "'context'", "':='", "'var'", "'param'", "'default'", "'timer'", "'offset'", "'onetime'", "'paused'", "'beliefvar'", "'reference'", "'survival'", "'property'", "'observation'", "'sets'", "'clears'", "'starts'", "'stops'", "'resumes'", "'type'", "'boolean'", "'eventtype'", "'lower'", "'upper'", "'precision'", "'time'", "'event'", "'milliseconds'", "'seconds'", "'minutes'", "'hours'", "'days'", "'millisecond'", "'second'", "'minute'", "'hour'", "'day'", "'once'", "'while'", "'repeat'", "'range'", "'->'", "'or'", "'and'", "'not'", "'?'", "'|'", "'&'", "'!'", "'='", "'<'", "'>'", "'<='", "'>='", "'!='", "'+'", "'-'", "'*'", "'/'", "'belief'", "'schedule'", "'\\''", "'.'", "'true'", "'false'", "'::'", "'---'", "'--'", "'+++'", "'++'", "'after'", "'before'", "'reinforces'", "'undermines'", "'veryhigh'", "'high'", "'MEDIUM'", "'low'", "'verylow'", "'pow'", "'sqrt'", "'exp'", "'abs'", "'avg'", "'min'", "'max'", "'count'", "'sum'", "'decreasing'", "'increasing'", "'stable'", "'eventWhen'", "'update'", "'period'", "'first'", "'last'", "'at'", "'size'", "'isEmpty'", "'includes'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=4;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=10;
    public static final int RULE_ROQME_DESCRIPTION=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalMIRoNParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMIRoNParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMIRoNParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMIRoN.g"; }



     	private MIRoNGrammarAccess grammarAccess;

        public InternalMIRoNParser(TokenStream input, MIRoNGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MironModel";
       	}

       	@Override
       	protected MIRoNGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMironModel"
    // InternalMIRoN.g:65:1: entryRuleMironModel returns [EObject current=null] : iv_ruleMironModel= ruleMironModel EOF ;
    public final EObject entryRuleMironModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMironModel = null;


        try {
            // InternalMIRoN.g:65:51: (iv_ruleMironModel= ruleMironModel EOF )
            // InternalMIRoN.g:66:2: iv_ruleMironModel= ruleMironModel EOF
            {
             newCompositeNode(grammarAccess.getMironModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMironModel=ruleMironModel();

            state._fsp--;

             current =iv_ruleMironModel; 
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
    // $ANTLR end "entryRuleMironModel"


    // $ANTLR start "ruleMironModel"
    // InternalMIRoN.g:72:1: ruleMironModel returns [EObject current=null] : ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'miron' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )* ) ;
    public final EObject ruleMironModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        AntlrDatatypeRuleToken lv_namespace_2_0 = null;

        EObject lv_sentences_3_0 = null;

        EObject lv_dataTypes_4_0 = null;

        EObject lv_variables_5_0 = null;

        EObject lv_sentences_6_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:78:2: ( ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'miron' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )* ) )
            // InternalMIRoN.g:79:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'miron' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )* )
            {
            // InternalMIRoN.g:79:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'miron' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )* )
            // InternalMIRoN.g:80:3: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'miron' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )*
            {
            // InternalMIRoN.g:80:3: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'miron' ( (lv_namespace_2_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ROQME_DESCRIPTION) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==12) ) {
                    alt2=1;
                }
            }
            else if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMIRoN.g:81:4: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'miron' ( (lv_namespace_2_0= ruleEString ) )
                    {
                    // InternalMIRoN.g:81:4: ( (lv_description_0_0= ruleElementDescription ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_ROQME_DESCRIPTION) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalMIRoN.g:82:5: (lv_description_0_0= ruleElementDescription )
                            {
                            // InternalMIRoN.g:82:5: (lv_description_0_0= ruleElementDescription )
                            // InternalMIRoN.g:83:6: lv_description_0_0= ruleElementDescription
                            {

                            						newCompositeNode(grammarAccess.getMironModelAccess().getDescriptionElementDescriptionParserRuleCall_0_0_0());
                            					
                            pushFollow(FOLLOW_3);
                            lv_description_0_0=ruleElementDescription();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getMironModelRule());
                            						}
                            						set(
                            							current,
                            							"description",
                            							lv_description_0_0,
                            							"org.xtext.roqme.RoQME.ElementDescription");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_1=(Token)match(input,12,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getMironModelAccess().getMironKeyword_0_1());
                    			
                    // InternalMIRoN.g:104:4: ( (lv_namespace_2_0= ruleEString ) )
                    // InternalMIRoN.g:105:5: (lv_namespace_2_0= ruleEString )
                    {
                    // InternalMIRoN.g:105:5: (lv_namespace_2_0= ruleEString )
                    // InternalMIRoN.g:106:6: lv_namespace_2_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getMironModelAccess().getNamespaceEStringParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_namespace_2_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMironModelRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_2_0,
                    							"org.xtext.roqme.RoQME.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMIRoN.g:124:3: ( (lv_sentences_3_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMIRoN.g:125:4: (lv_sentences_3_0= ruleImport )
            	    {
            	    // InternalMIRoN.g:125:4: (lv_sentences_3_0= ruleImport )
            	    // InternalMIRoN.g:126:5: lv_sentences_3_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getMironModelAccess().getSentencesImportParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_sentences_3_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMironModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sentences",
            	    						lv_sentences_3_0,
            	    						"org.xtext.miron.MIRoN.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalMIRoN.g:143:3: ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 56:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_ROQME_DESCRIPTION:
                    {
                    int LA4_3 = input.LA(2);

                    if ( (LA4_3==37||LA4_3==40||LA4_3==46||LA4_3==49) ) {
                        alt4=2;
                    }
                    else if ( (LA4_3==50) ) {
                        alt4=3;
                    }


                    }
                    break;
                case 28:
                case 37:
                case 39:
                case 40:
                case 42:
                case 46:
                case 49:
                    {
                    alt4=2;
                    }
                    break;
                case 35:
                case 50:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // InternalMIRoN.g:144:4: ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) )
            	    {
            	    // InternalMIRoN.g:144:4: ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) )
            	    // InternalMIRoN.g:145:5: (lv_dataTypes_4_0= ruleDataTypeDefinition )
            	    {
            	    // InternalMIRoN.g:145:5: (lv_dataTypes_4_0= ruleDataTypeDefinition )
            	    // InternalMIRoN.g:146:6: lv_dataTypes_4_0= ruleDataTypeDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getMironModelAccess().getDataTypesDataTypeDefinitionParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_dataTypes_4_0=ruleDataTypeDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMironModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"dataTypes",
            	    							lv_dataTypes_4_0,
            	    							"org.xtext.roqme.RoQME.DataTypeDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMIRoN.g:164:4: ( (lv_variables_5_0= ruleTypedVariable ) )
            	    {
            	    // InternalMIRoN.g:164:4: ( (lv_variables_5_0= ruleTypedVariable ) )
            	    // InternalMIRoN.g:165:5: (lv_variables_5_0= ruleTypedVariable )
            	    {
            	    // InternalMIRoN.g:165:5: (lv_variables_5_0= ruleTypedVariable )
            	    // InternalMIRoN.g:166:6: lv_variables_5_0= ruleTypedVariable
            	    {

            	    						newCompositeNode(grammarAccess.getMironModelAccess().getVariablesTypedVariableParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_variables_5_0=ruleTypedVariable();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMironModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"variables",
            	    							lv_variables_5_0,
            	    							"org.xtext.miron.MIRoN.TypedVariable");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMIRoN.g:184:4: ( (lv_sentences_6_0= ruleSentence ) )
            	    {
            	    // InternalMIRoN.g:184:4: ( (lv_sentences_6_0= ruleSentence ) )
            	    // InternalMIRoN.g:185:5: (lv_sentences_6_0= ruleSentence )
            	    {
            	    // InternalMIRoN.g:185:5: (lv_sentences_6_0= ruleSentence )
            	    // InternalMIRoN.g:186:6: lv_sentences_6_0= ruleSentence
            	    {

            	    						newCompositeNode(grammarAccess.getMironModelAccess().getSentencesSentenceParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_sentences_6_0=ruleSentence();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMironModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"sentences",
            	    							lv_sentences_6_0,
            	    							"org.xtext.miron.MIRoN.Sentence");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


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
    // $ANTLR end "ruleMironModel"


    // $ANTLR start "entryRuleImport"
    // InternalMIRoN.g:208:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMIRoN.g:208:47: (iv_ruleImport= ruleImport EOF )
            // InternalMIRoN.g:209:2: iv_ruleImport= ruleImport EOF
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
    // InternalMIRoN.g:215:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_importURI_1_0 = null;

        AntlrDatatypeRuleToken lv_alias_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:221:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleEString ) ) )? ) )
            // InternalMIRoN.g:222:2: (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleEString ) ) )? )
            {
            // InternalMIRoN.g:222:2: (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleEString ) ) )? )
            // InternalMIRoN.g:223:3: otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalMIRoN.g:227:3: ( (lv_importURI_1_0= ruleEString ) )
            // InternalMIRoN.g:228:4: (lv_importURI_1_0= ruleEString )
            {
            // InternalMIRoN.g:228:4: (lv_importURI_1_0= ruleEString )
            // InternalMIRoN.g:229:5: lv_importURI_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportURIEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_importURI_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importURI",
            						lv_importURI_1_0,
            						"org.xtext.roqme.RoQME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:246:3: (otherlv_2= 'as' ( (lv_alias_3_0= ruleEString ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMIRoN.g:247:4: otherlv_2= 'as' ( (lv_alias_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getImportAccess().getAsKeyword_2_0());
                    			
                    // InternalMIRoN.g:251:4: ( (lv_alias_3_0= ruleEString ) )
                    // InternalMIRoN.g:252:5: (lv_alias_3_0= ruleEString )
                    {
                    // InternalMIRoN.g:252:5: (lv_alias_3_0= ruleEString )
                    // InternalMIRoN.g:253:6: lv_alias_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getImportAccess().getAliasEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_alias_3_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getImportRule());
                    						}
                    						set(
                    							current,
                    							"alias",
                    							lv_alias_3_0,
                    							"org.xtext.roqme.RoQME.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleDataType"
    // InternalMIRoN.g:275:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalMIRoN.g:275:49: (iv_ruleDataType= ruleDataType EOF )
            // InternalMIRoN.g:276:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalMIRoN.g:282:1: ruleDataType returns [EObject current=null] : (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_TimeType_4= ruleTimeType | this_NumericSampledType_5= ruleNumericSampledType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanType_0 = null;

        EObject this_EnumType_1 = null;

        EObject this_EventType_2 = null;

        EObject this_NumericType_3 = null;

        EObject this_TimeType_4 = null;

        EObject this_NumericSampledType_5 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:288:2: ( (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_TimeType_4= ruleTimeType | this_NumericSampledType_5= ruleNumericSampledType ) )
            // InternalMIRoN.g:289:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_TimeType_4= ruleTimeType | this_NumericSampledType_5= ruleNumericSampledType )
            {
            // InternalMIRoN.g:289:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_TimeType_4= ruleTimeType | this_NumericSampledType_5= ruleNumericSampledType )
            int alt6=6;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalMIRoN.g:290:3: this_BooleanType_0= ruleBooleanType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getBooleanTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanType_0=ruleBooleanType();

                    state._fsp--;


                    			current = this_BooleanType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:299:3: this_EnumType_1= ruleEnumType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getEnumTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumType_1=ruleEnumType();

                    state._fsp--;


                    			current = this_EnumType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:308:3: this_EventType_2= ruleEventType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getEventTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EventType_2=ruleEventType();

                    state._fsp--;


                    			current = this_EventType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:317:3: this_NumericType_3= ruleNumericType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getNumericTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericType_3=ruleNumericType();

                    state._fsp--;


                    			current = this_NumericType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:326:3: this_TimeType_4= ruleTimeType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getTimeTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeType_4=ruleTimeType();

                    state._fsp--;


                    			current = this_TimeType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:335:3: this_NumericSampledType_5= ruleNumericSampledType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getNumericSampledTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericSampledType_5=ruleNumericSampledType();

                    state._fsp--;


                    			current = this_NumericSampledType_5;
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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleEnumType"
    // InternalMIRoN.g:347:1: entryRuleEnumType returns [EObject current=null] : iv_ruleEnumType= ruleEnumType EOF ;
    public final EObject entryRuleEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumType = null;


        try {
            // InternalMIRoN.g:347:49: (iv_ruleEnumType= ruleEnumType EOF )
            // InternalMIRoN.g:348:2: iv_ruleEnumType= ruleEnumType EOF
            {
             newCompositeNode(grammarAccess.getEnumTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumType=ruleEnumType();

            state._fsp--;

             current =iv_ruleEnumType; 
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
    // $ANTLR end "entryRuleEnumType"


    // $ANTLR start "ruleEnumType"
    // InternalMIRoN.g:354:1: ruleEnumType returns [EObject current=null] : (this_BehaviorTreeEnumType_0= ruleBehaviorTreeEnumType | this_SimpleEnumType_1= ruleSimpleEnumType ) ;
    public final EObject ruleEnumType() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorTreeEnumType_0 = null;

        EObject this_SimpleEnumType_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:360:2: ( (this_BehaviorTreeEnumType_0= ruleBehaviorTreeEnumType | this_SimpleEnumType_1= ruleSimpleEnumType ) )
            // InternalMIRoN.g:361:2: (this_BehaviorTreeEnumType_0= ruleBehaviorTreeEnumType | this_SimpleEnumType_1= ruleSimpleEnumType )
            {
            // InternalMIRoN.g:361:2: (this_BehaviorTreeEnumType_0= ruleBehaviorTreeEnumType | this_SimpleEnumType_1= ruleSimpleEnumType )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==26) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==16) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==RULE_INT) ) {
                        int LA7_4 = input.LA(4);

                        if ( (LA7_4==17) ) {
                            int LA7_6 = input.LA(5);

                            if ( (LA7_6==22) ) {
                                int LA7_3 = input.LA(6);

                                if ( (LA7_3==RULE_ID) ) {
                                    int LA7_5 = input.LA(7);

                                    if ( (LA7_5==23) ) {
                                        alt7=2;
                                    }
                                    else if ( (LA7_5==20) ) {
                                        alt7=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 7, 5, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 7, 3, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 7, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_1==22) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==RULE_ID) ) {
                        int LA7_5 = input.LA(4);

                        if ( (LA7_5==23) ) {
                            alt7=2;
                        }
                        else if ( (LA7_5==20) ) {
                            alt7=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
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
                    // InternalMIRoN.g:362:3: this_BehaviorTreeEnumType_0= ruleBehaviorTreeEnumType
                    {

                    			newCompositeNode(grammarAccess.getEnumTypeAccess().getBehaviorTreeEnumTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BehaviorTreeEnumType_0=ruleBehaviorTreeEnumType();

                    state._fsp--;


                    			current = this_BehaviorTreeEnumType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:371:3: this_SimpleEnumType_1= ruleSimpleEnumType
                    {

                    			newCompositeNode(grammarAccess.getEnumTypeAccess().getSimpleEnumTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleEnumType_1=ruleSimpleEnumType();

                    state._fsp--;


                    			current = this_SimpleEnumType_1;
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
    // $ANTLR end "ruleEnumType"


    // $ANTLR start "entryRuleNumericSampledType"
    // InternalMIRoN.g:383:1: entryRuleNumericSampledType returns [EObject current=null] : iv_ruleNumericSampledType= ruleNumericSampledType EOF ;
    public final EObject entryRuleNumericSampledType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericSampledType = null;


        try {
            // InternalMIRoN.g:383:59: (iv_ruleNumericSampledType= ruleNumericSampledType EOF )
            // InternalMIRoN.g:384:2: iv_ruleNumericSampledType= ruleNumericSampledType EOF
            {
             newCompositeNode(grammarAccess.getNumericSampledTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericSampledType=ruleNumericSampledType();

            state._fsp--;

             current =iv_ruleNumericSampledType; 
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
    // $ANTLR end "entryRuleNumericSampledType"


    // $ANTLR start "ruleNumericSampledType"
    // InternalMIRoN.g:390:1: ruleNumericSampledType returns [EObject current=null] : (otherlv_0= 'number' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) otherlv_20= '{' ( (lv_samples_21_0= ruleSampleValue ) ) (otherlv_22= ',' ( (lv_samples_23_0= ruleSampleValue ) ) )* otherlv_24= '}' ) ;
    public final EObject ruleNumericSampledType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_cardinality_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        AntlrDatatypeRuleToken lv_measurementUnit_6_0 = null;

        EObject lv_constraints_8_0 = null;

        EObject lv_constraints_10_0 = null;

        EObject lv_constraints_12_0 = null;

        EObject lv_constraints_15_0 = null;

        EObject lv_constraints_17_0 = null;

        EObject lv_constraints_19_0 = null;

        EObject lv_samples_21_0 = null;

        EObject lv_samples_23_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:396:2: ( (otherlv_0= 'number' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) otherlv_20= '{' ( (lv_samples_21_0= ruleSampleValue ) ) (otherlv_22= ',' ( (lv_samples_23_0= ruleSampleValue ) ) )* otherlv_24= '}' ) )
            // InternalMIRoN.g:397:2: (otherlv_0= 'number' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) otherlv_20= '{' ( (lv_samples_21_0= ruleSampleValue ) ) (otherlv_22= ',' ( (lv_samples_23_0= ruleSampleValue ) ) )* otherlv_24= '}' )
            {
            // InternalMIRoN.g:397:2: (otherlv_0= 'number' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) otherlv_20= '{' ( (lv_samples_21_0= ruleSampleValue ) ) (otherlv_22= ',' ( (lv_samples_23_0= ruleSampleValue ) ) )* otherlv_24= '}' )
            // InternalMIRoN.g:398:3: otherlv_0= 'number' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) otherlv_20= '{' ( (lv_samples_21_0= ruleSampleValue ) ) (otherlv_22= ',' ( (lv_samples_23_0= ruleSampleValue ) ) )* otherlv_24= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getNumericSampledTypeAccess().getNumberKeyword_0());
            		
            // InternalMIRoN.g:402:3: (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMIRoN.g:403:4: otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getNumericSampledTypeAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalMIRoN.g:407:4: ( (lv_cardinality_2_0= RULE_INT ) )
                    // InternalMIRoN.g:408:5: (lv_cardinality_2_0= RULE_INT )
                    {
                    // InternalMIRoN.g:408:5: (lv_cardinality_2_0= RULE_INT )
                    // InternalMIRoN.g:409:6: lv_cardinality_2_0= RULE_INT
                    {
                    lv_cardinality_2_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_2_0, grammarAccess.getNumericSampledTypeAccess().getCardinalityINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNumericSampledTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getNumericSampledTypeAccess().getRightSquareBracketKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:430:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) )
            // InternalMIRoN.g:431:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) )
            {
            // InternalMIRoN.g:431:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) )
            // InternalMIRoN.g:432:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2());
            				
            // InternalMIRoN.g:435:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )* )
            // InternalMIRoN.g:436:6: ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )*
            {
            // InternalMIRoN.g:436:6: ( ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) ) )*
            loop11:
            do {
                int alt11=4;
                int LA11_0 = input.LA(1);

                if ( LA11_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 0) ) {
                    alt11=1;
                }
                else if ( LA11_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 1) ) {
                    alt11=2;
                }
                else if ( LA11_0 >= 59 && LA11_0 <= 61 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 2) ) {
                    alt11=3;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMIRoN.g:437:4: ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:437:4: ({...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) ) )
            	    // InternalMIRoN.g:438:5: {...}? => ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNumericSampledType", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalMIRoN.g:438:115: ( ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) ) )
            	    // InternalMIRoN.g:439:6: ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalMIRoN.g:442:9: ({...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) ) )
            	    // InternalMIRoN.g:442:10: {...}? => (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericSampledType", "true");
            	    }
            	    // InternalMIRoN.g:442:19: (otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) ) )
            	    // InternalMIRoN.g:442:20: otherlv_5= 'unit' ( (lv_measurementUnit_6_0= ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_4); 

            	    									newLeafNode(otherlv_5, grammarAccess.getNumericSampledTypeAccess().getUnitKeyword_2_0_0());
            	    								
            	    // InternalMIRoN.g:446:9: ( (lv_measurementUnit_6_0= ruleEString ) )
            	    // InternalMIRoN.g:447:10: (lv_measurementUnit_6_0= ruleEString )
            	    {
            	    // InternalMIRoN.g:447:10: (lv_measurementUnit_6_0= ruleEString )
            	    // InternalMIRoN.g:448:11: lv_measurementUnit_6_0= ruleEString
            	    {

            	    											newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getMeasurementUnitEStringParserRuleCall_2_0_1_0());
            	    										
            	    pushFollow(FOLLOW_11);
            	    lv_measurementUnit_6_0=ruleEString();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            	    											}
            	    											set(
            	    												current,
            	    												"measurementUnit",
            	    												lv_measurementUnit_6_0,
            	    												"org.xtext.roqme.RoQME.EString");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMIRoN.g:471:4: ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:471:4: ({...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) ) )
            	    // InternalMIRoN.g:472:5: {...}? => ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNumericSampledType", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalMIRoN.g:472:115: ( ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) ) )
            	    // InternalMIRoN.g:473:6: ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalMIRoN.g:476:9: ({...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) ) )
            	    // InternalMIRoN.g:476:10: {...}? => ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericSampledType", "true");
            	    }
            	    // InternalMIRoN.g:476:19: ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) )
            	    int alt9=2;
            	    alt9 = dfa9.predict(input);
            	    switch (alt9) {
            	        case 1 :
            	            // InternalMIRoN.g:476:20: (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' )
            	            {
            	            // InternalMIRoN.g:476:20: (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' )
            	            // InternalMIRoN.g:477:10: otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')'
            	            {
            	            otherlv_7=(Token)match(input,19,FOLLOW_12); 

            	            										newLeafNode(otherlv_7, grammarAccess.getNumericSampledTypeAccess().getLeftParenthesisKeyword_2_1_0_0());
            	            									
            	            // InternalMIRoN.g:481:10: ( (lv_constraints_8_0= ruleCompactLowerBound ) )
            	            // InternalMIRoN.g:482:11: (lv_constraints_8_0= ruleCompactLowerBound )
            	            {
            	            // InternalMIRoN.g:482:11: (lv_constraints_8_0= ruleCompactLowerBound )
            	            // InternalMIRoN.g:483:12: lv_constraints_8_0= ruleCompactLowerBound
            	            {

            	            												newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getConstraintsCompactLowerBoundParserRuleCall_2_1_0_1_0());
            	            											
            	            pushFollow(FOLLOW_13);
            	            lv_constraints_8_0=ruleCompactLowerBound();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_8_0,
            	            													"org.xtext.roqme.RoQME.CompactLowerBound");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_9=(Token)match(input,20,FOLLOW_12); 

            	            										newLeafNode(otherlv_9, grammarAccess.getNumericSampledTypeAccess().getColonKeyword_2_1_0_2());
            	            									
            	            // InternalMIRoN.g:504:10: ( (lv_constraints_10_0= ruleCompactPrecision ) )
            	            // InternalMIRoN.g:505:11: (lv_constraints_10_0= ruleCompactPrecision )
            	            {
            	            // InternalMIRoN.g:505:11: (lv_constraints_10_0= ruleCompactPrecision )
            	            // InternalMIRoN.g:506:12: lv_constraints_10_0= ruleCompactPrecision
            	            {

            	            												newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getConstraintsCompactPrecisionParserRuleCall_2_1_0_3_0());
            	            											
            	            pushFollow(FOLLOW_13);
            	            lv_constraints_10_0=ruleCompactPrecision();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_10_0,
            	            													"org.xtext.roqme.RoQME.CompactPrecision");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_11=(Token)match(input,20,FOLLOW_12); 

            	            										newLeafNode(otherlv_11, grammarAccess.getNumericSampledTypeAccess().getColonKeyword_2_1_0_4());
            	            									
            	            // InternalMIRoN.g:527:10: ( (lv_constraints_12_0= ruleCompactUpperBound ) )
            	            // InternalMIRoN.g:528:11: (lv_constraints_12_0= ruleCompactUpperBound )
            	            {
            	            // InternalMIRoN.g:528:11: (lv_constraints_12_0= ruleCompactUpperBound )
            	            // InternalMIRoN.g:529:12: lv_constraints_12_0= ruleCompactUpperBound
            	            {

            	            												newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getConstraintsCompactUpperBoundParserRuleCall_2_1_0_5_0());
            	            											
            	            pushFollow(FOLLOW_14);
            	            lv_constraints_12_0=ruleCompactUpperBound();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_12_0,
            	            													"org.xtext.roqme.RoQME.CompactUpperBound");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_13=(Token)match(input,21,FOLLOW_11); 

            	            										newLeafNode(otherlv_13, grammarAccess.getNumericSampledTypeAccess().getRightParenthesisKeyword_2_1_0_6());
            	            									

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMIRoN.g:552:9: (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' )
            	            {
            	            // InternalMIRoN.g:552:9: (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' )
            	            // InternalMIRoN.g:553:10: otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')'
            	            {
            	            otherlv_14=(Token)match(input,19,FOLLOW_12); 

            	            										newLeafNode(otherlv_14, grammarAccess.getNumericSampledTypeAccess().getLeftParenthesisKeyword_2_1_1_0());
            	            									
            	            // InternalMIRoN.g:557:10: ( (lv_constraints_15_0= ruleCompactLowerBound ) )
            	            // InternalMIRoN.g:558:11: (lv_constraints_15_0= ruleCompactLowerBound )
            	            {
            	            // InternalMIRoN.g:558:11: (lv_constraints_15_0= ruleCompactLowerBound )
            	            // InternalMIRoN.g:559:12: lv_constraints_15_0= ruleCompactLowerBound
            	            {

            	            												newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getConstraintsCompactLowerBoundParserRuleCall_2_1_1_1_0());
            	            											
            	            pushFollow(FOLLOW_13);
            	            lv_constraints_15_0=ruleCompactLowerBound();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_15_0,
            	            													"org.xtext.roqme.RoQME.CompactLowerBound");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_16=(Token)match(input,20,FOLLOW_12); 

            	            										newLeafNode(otherlv_16, grammarAccess.getNumericSampledTypeAccess().getColonKeyword_2_1_1_2());
            	            									
            	            // InternalMIRoN.g:580:10: ( (lv_constraints_17_0= ruleCompactUpperBound ) )
            	            // InternalMIRoN.g:581:11: (lv_constraints_17_0= ruleCompactUpperBound )
            	            {
            	            // InternalMIRoN.g:581:11: (lv_constraints_17_0= ruleCompactUpperBound )
            	            // InternalMIRoN.g:582:12: lv_constraints_17_0= ruleCompactUpperBound
            	            {

            	            												newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getConstraintsCompactUpperBoundParserRuleCall_2_1_1_3_0());
            	            											
            	            pushFollow(FOLLOW_14);
            	            lv_constraints_17_0=ruleCompactUpperBound();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_17_0,
            	            													"org.xtext.roqme.RoQME.CompactUpperBound");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_18=(Token)match(input,21,FOLLOW_11); 

            	            										newLeafNode(otherlv_18, grammarAccess.getNumericSampledTypeAccess().getRightParenthesisKeyword_2_1_1_4());
            	            									

            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMIRoN.g:610:4: ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) )
            	    {
            	    // InternalMIRoN.g:610:4: ({...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ ) )
            	    // InternalMIRoN.g:611:5: {...}? => ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNumericSampledType", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalMIRoN.g:611:115: ( ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+ )
            	    // InternalMIRoN.g:612:6: ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalMIRoN.g:615:9: ({...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        switch ( input.LA(1) ) {
            	        case 59:
            	            {
            	            int LA10_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt10=1;
            	            }


            	            }
            	            break;
            	        case 60:
            	            {
            	            int LA10_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt10=1;
            	            }


            	            }
            	            break;
            	        case 61:
            	            {
            	            int LA10_4 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt10=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalMIRoN.g:615:10: {...}? => ( (lv_constraints_19_0= ruleNumericTypeConstraint ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleNumericSampledType", "true");
            	    	    }
            	    	    // InternalMIRoN.g:615:19: ( (lv_constraints_19_0= ruleNumericTypeConstraint ) )
            	    	    // InternalMIRoN.g:615:20: (lv_constraints_19_0= ruleNumericTypeConstraint )
            	    	    {
            	    	    // InternalMIRoN.g:615:20: (lv_constraints_19_0= ruleNumericTypeConstraint )
            	    	    // InternalMIRoN.g:616:10: lv_constraints_19_0= ruleNumericTypeConstraint
            	    	    {

            	    	    										newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_2_2_0());
            	    	    									
            	    	    pushFollow(FOLLOW_11);
            	    	    lv_constraints_19_0=ruleNumericTypeConstraint();

            	    	    state._fsp--;


            	    	    										if (current==null) {
            	    	    											current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            	    	    										}
            	    	    										add(
            	    	    											current,
            	    	    											"constraints",
            	    	    											lv_constraints_19_0,
            	    	    											"org.xtext.roqme.RoQME.NumericTypeConstraint");
            	    	    										afterParserOrEnumRuleCall();
            	    	    									

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getNumericSampledTypeAccess().getUnorderedGroup_2());
            				

            }

            otherlv_20=(Token)match(input,22,FOLLOW_12); 

            			newLeafNode(otherlv_20, grammarAccess.getNumericSampledTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMIRoN.g:649:3: ( (lv_samples_21_0= ruleSampleValue ) )
            // InternalMIRoN.g:650:4: (lv_samples_21_0= ruleSampleValue )
            {
            // InternalMIRoN.g:650:4: (lv_samples_21_0= ruleSampleValue )
            // InternalMIRoN.g:651:5: lv_samples_21_0= ruleSampleValue
            {

            					newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getSamplesSampleValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_15);
            lv_samples_21_0=ruleSampleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            					}
            					add(
            						current,
            						"samples",
            						lv_samples_21_0,
            						"org.xtext.miron.MIRoN.SampleValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:668:3: (otherlv_22= ',' ( (lv_samples_23_0= ruleSampleValue ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMIRoN.g:669:4: otherlv_22= ',' ( (lv_samples_23_0= ruleSampleValue ) )
            	    {
            	    otherlv_22=(Token)match(input,23,FOLLOW_12); 

            	    				newLeafNode(otherlv_22, grammarAccess.getNumericSampledTypeAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMIRoN.g:673:4: ( (lv_samples_23_0= ruleSampleValue ) )
            	    // InternalMIRoN.g:674:5: (lv_samples_23_0= ruleSampleValue )
            	    {
            	    // InternalMIRoN.g:674:5: (lv_samples_23_0= ruleSampleValue )
            	    // InternalMIRoN.g:675:6: lv_samples_23_0= ruleSampleValue
            	    {

            	    						newCompositeNode(grammarAccess.getNumericSampledTypeAccess().getSamplesSampleValueParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_samples_23_0=ruleSampleValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNumericSampledTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"samples",
            	    							lv_samples_23_0,
            	    							"org.xtext.miron.MIRoN.SampleValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_24=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_24, grammarAccess.getNumericSampledTypeAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleNumericSampledType"


    // $ANTLR start "entryRuleSampleValue"
    // InternalMIRoN.g:701:1: entryRuleSampleValue returns [EObject current=null] : iv_ruleSampleValue= ruleSampleValue EOF ;
    public final EObject entryRuleSampleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSampleValue = null;


        try {
            // InternalMIRoN.g:701:52: (iv_ruleSampleValue= ruleSampleValue EOF )
            // InternalMIRoN.g:702:2: iv_ruleSampleValue= ruleSampleValue EOF
            {
             newCompositeNode(grammarAccess.getSampleValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSampleValue=ruleSampleValue();

            state._fsp--;

             current =iv_ruleSampleValue; 
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
    // $ANTLR end "entryRuleSampleValue"


    // $ANTLR start "ruleSampleValue"
    // InternalMIRoN.g:708:1: ruleSampleValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleNumericValue ) ) otherlv_1= 'affects' ( ( (lv_impacts_2_0= ruleImpactOnQuality ) ) | (otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}' ) ) ) ;
    public final EObject ruleSampleValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_value_0_0 = null;

        EObject lv_impacts_2_0 = null;

        EObject lv_impacts_4_0 = null;

        EObject lv_impacts_6_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:714:2: ( ( ( (lv_value_0_0= ruleNumericValue ) ) otherlv_1= 'affects' ( ( (lv_impacts_2_0= ruleImpactOnQuality ) ) | (otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}' ) ) ) )
            // InternalMIRoN.g:715:2: ( ( (lv_value_0_0= ruleNumericValue ) ) otherlv_1= 'affects' ( ( (lv_impacts_2_0= ruleImpactOnQuality ) ) | (otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}' ) ) )
            {
            // InternalMIRoN.g:715:2: ( ( (lv_value_0_0= ruleNumericValue ) ) otherlv_1= 'affects' ( ( (lv_impacts_2_0= ruleImpactOnQuality ) ) | (otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}' ) ) )
            // InternalMIRoN.g:716:3: ( (lv_value_0_0= ruleNumericValue ) ) otherlv_1= 'affects' ( ( (lv_impacts_2_0= ruleImpactOnQuality ) ) | (otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}' ) )
            {
            // InternalMIRoN.g:716:3: ( (lv_value_0_0= ruleNumericValue ) )
            // InternalMIRoN.g:717:4: (lv_value_0_0= ruleNumericValue )
            {
            // InternalMIRoN.g:717:4: (lv_value_0_0= ruleNumericValue )
            // InternalMIRoN.g:718:5: lv_value_0_0= ruleNumericValue
            {

            					newCompositeNode(grammarAccess.getSampleValueAccess().getValueNumericValueParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_16);
            lv_value_0_0=ruleNumericValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSampleValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_0_0,
            						"org.xtext.roqme.RoQME.NumericValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getSampleValueAccess().getAffectsKeyword_1());
            		
            // InternalMIRoN.g:739:3: ( ( (lv_impacts_2_0= ruleImpactOnQuality ) ) | (otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            else if ( (LA15_0==22) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalMIRoN.g:740:4: ( (lv_impacts_2_0= ruleImpactOnQuality ) )
                    {
                    // InternalMIRoN.g:740:4: ( (lv_impacts_2_0= ruleImpactOnQuality ) )
                    // InternalMIRoN.g:741:5: (lv_impacts_2_0= ruleImpactOnQuality )
                    {
                    // InternalMIRoN.g:741:5: (lv_impacts_2_0= ruleImpactOnQuality )
                    // InternalMIRoN.g:742:6: lv_impacts_2_0= ruleImpactOnQuality
                    {

                    						newCompositeNode(grammarAccess.getSampleValueAccess().getImpactsImpactOnQualityParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_impacts_2_0=ruleImpactOnQuality();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSampleValueRule());
                    						}
                    						add(
                    							current,
                    							"impacts",
                    							lv_impacts_2_0,
                    							"org.xtext.miron.MIRoN.ImpactOnQuality");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:760:4: (otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}' )
                    {
                    // InternalMIRoN.g:760:4: (otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}' )
                    // InternalMIRoN.g:761:5: otherlv_3= '{' ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )? otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_18); 

                    					newLeafNode(otherlv_3, grammarAccess.getSampleValueAccess().getLeftCurlyBracketKeyword_2_1_0());
                    				
                    // InternalMIRoN.g:765:5: ( ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )* )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_ID) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalMIRoN.g:766:6: ( (lv_impacts_4_0= ruleImpactOnQuality ) ) (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )*
                            {
                            // InternalMIRoN.g:766:6: ( (lv_impacts_4_0= ruleImpactOnQuality ) )
                            // InternalMIRoN.g:767:7: (lv_impacts_4_0= ruleImpactOnQuality )
                            {
                            // InternalMIRoN.g:767:7: (lv_impacts_4_0= ruleImpactOnQuality )
                            // InternalMIRoN.g:768:8: lv_impacts_4_0= ruleImpactOnQuality
                            {

                            								newCompositeNode(grammarAccess.getSampleValueAccess().getImpactsImpactOnQualityParserRuleCall_2_1_1_0_0());
                            							
                            pushFollow(FOLLOW_15);
                            lv_impacts_4_0=ruleImpactOnQuality();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getSampleValueRule());
                            								}
                            								add(
                            									current,
                            									"impacts",
                            									lv_impacts_4_0,
                            									"org.xtext.miron.MIRoN.ImpactOnQuality");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalMIRoN.g:785:6: (otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) ) )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==23) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // InternalMIRoN.g:786:7: otherlv_5= ',' ( (lv_impacts_6_0= ruleImpactOnQuality ) )
                            	    {
                            	    otherlv_5=(Token)match(input,23,FOLLOW_19); 

                            	    							newLeafNode(otherlv_5, grammarAccess.getSampleValueAccess().getCommaKeyword_2_1_1_1_0());
                            	    						
                            	    // InternalMIRoN.g:790:7: ( (lv_impacts_6_0= ruleImpactOnQuality ) )
                            	    // InternalMIRoN.g:791:8: (lv_impacts_6_0= ruleImpactOnQuality )
                            	    {
                            	    // InternalMIRoN.g:791:8: (lv_impacts_6_0= ruleImpactOnQuality )
                            	    // InternalMIRoN.g:792:9: lv_impacts_6_0= ruleImpactOnQuality
                            	    {

                            	    									newCompositeNode(grammarAccess.getSampleValueAccess().getImpactsImpactOnQualityParserRuleCall_2_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_15);
                            	    lv_impacts_6_0=ruleImpactOnQuality();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getSampleValueRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"impacts",
                            	    										lv_impacts_6_0,
                            	    										"org.xtext.miron.MIRoN.ImpactOnQuality");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(otherlv_7, grammarAccess.getSampleValueAccess().getRightCurlyBracketKeyword_2_1_2());
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleSampleValue"


    // $ANTLR start "entryRuleBehaviorTreeEnumType"
    // InternalMIRoN.g:821:1: entryRuleBehaviorTreeEnumType returns [EObject current=null] : iv_ruleBehaviorTreeEnumType= ruleBehaviorTreeEnumType EOF ;
    public final EObject entryRuleBehaviorTreeEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTreeEnumType = null;


        try {
            // InternalMIRoN.g:821:61: (iv_ruleBehaviorTreeEnumType= ruleBehaviorTreeEnumType EOF )
            // InternalMIRoN.g:822:2: iv_ruleBehaviorTreeEnumType= ruleBehaviorTreeEnumType EOF
            {
             newCompositeNode(grammarAccess.getBehaviorTreeEnumTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBehaviorTreeEnumType=ruleBehaviorTreeEnumType();

            state._fsp--;

             current =iv_ruleBehaviorTreeEnumType; 
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
    // $ANTLR end "entryRuleBehaviorTreeEnumType"


    // $ANTLR start "ruleBehaviorTreeEnumType"
    // InternalMIRoN.g:828:1: ruleBehaviorTreeEnumType returns [EObject current=null] : (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleBehaviorTreeLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleBehaviorTreeLiteral ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleBehaviorTreeEnumType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_cardinality_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_literals_5_0 = null;

        EObject lv_literals_7_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:834:2: ( (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleBehaviorTreeLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleBehaviorTreeLiteral ) ) )* otherlv_8= '}' ) )
            // InternalMIRoN.g:835:2: (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleBehaviorTreeLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleBehaviorTreeLiteral ) ) )* otherlv_8= '}' )
            {
            // InternalMIRoN.g:835:2: (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleBehaviorTreeLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleBehaviorTreeLiteral ) ) )* otherlv_8= '}' )
            // InternalMIRoN.g:836:3: otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleBehaviorTreeLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleBehaviorTreeLiteral ) ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getBehaviorTreeEnumTypeAccess().getEnumKeyword_0());
            		
            // InternalMIRoN.g:840:3: (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==16) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMIRoN.g:841:4: otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getBehaviorTreeEnumTypeAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalMIRoN.g:845:4: ( (lv_cardinality_2_0= RULE_INT ) )
                    // InternalMIRoN.g:846:5: (lv_cardinality_2_0= RULE_INT )
                    {
                    // InternalMIRoN.g:846:5: (lv_cardinality_2_0= RULE_INT )
                    // InternalMIRoN.g:847:6: lv_cardinality_2_0= RULE_INT
                    {
                    lv_cardinality_2_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_2_0, grammarAccess.getBehaviorTreeEnumTypeAccess().getCardinalityINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBehaviorTreeEnumTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getBehaviorTreeEnumTypeAccess().getRightSquareBracketKeyword_1_2());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getBehaviorTreeEnumTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMIRoN.g:872:3: ( (lv_literals_5_0= ruleBehaviorTreeLiteral ) )
            // InternalMIRoN.g:873:4: (lv_literals_5_0= ruleBehaviorTreeLiteral )
            {
            // InternalMIRoN.g:873:4: (lv_literals_5_0= ruleBehaviorTreeLiteral )
            // InternalMIRoN.g:874:5: lv_literals_5_0= ruleBehaviorTreeLiteral
            {

            					newCompositeNode(grammarAccess.getBehaviorTreeEnumTypeAccess().getLiteralsBehaviorTreeLiteralParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_15);
            lv_literals_5_0=ruleBehaviorTreeLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBehaviorTreeEnumTypeRule());
            					}
            					add(
            						current,
            						"literals",
            						lv_literals_5_0,
            						"org.xtext.miron.MIRoN.BehaviorTreeLiteral");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:891:3: (otherlv_6= ',' ( (lv_literals_7_0= ruleBehaviorTreeLiteral ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==23) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMIRoN.g:892:4: otherlv_6= ',' ( (lv_literals_7_0= ruleBehaviorTreeLiteral ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_19); 

            	    				newLeafNode(otherlv_6, grammarAccess.getBehaviorTreeEnumTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMIRoN.g:896:4: ( (lv_literals_7_0= ruleBehaviorTreeLiteral ) )
            	    // InternalMIRoN.g:897:5: (lv_literals_7_0= ruleBehaviorTreeLiteral )
            	    {
            	    // InternalMIRoN.g:897:5: (lv_literals_7_0= ruleBehaviorTreeLiteral )
            	    // InternalMIRoN.g:898:6: lv_literals_7_0= ruleBehaviorTreeLiteral
            	    {

            	    						newCompositeNode(grammarAccess.getBehaviorTreeEnumTypeAccess().getLiteralsBehaviorTreeLiteralParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_literals_7_0=ruleBehaviorTreeLiteral();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBehaviorTreeEnumTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"literals",
            	    							lv_literals_7_0,
            	    							"org.xtext.miron.MIRoN.BehaviorTreeLiteral");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_8=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getBehaviorTreeEnumTypeAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleBehaviorTreeEnumType"


    // $ANTLR start "entryRuleBehaviorTreeLiteral"
    // InternalMIRoN.g:924:1: entryRuleBehaviorTreeLiteral returns [EObject current=null] : iv_ruleBehaviorTreeLiteral= ruleBehaviorTreeLiteral EOF ;
    public final EObject entryRuleBehaviorTreeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTreeLiteral = null;


        try {
            // InternalMIRoN.g:924:60: (iv_ruleBehaviorTreeLiteral= ruleBehaviorTreeLiteral EOF )
            // InternalMIRoN.g:925:2: iv_ruleBehaviorTreeLiteral= ruleBehaviorTreeLiteral EOF
            {
             newCompositeNode(grammarAccess.getBehaviorTreeLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBehaviorTreeLiteral=ruleBehaviorTreeLiteral();

            state._fsp--;

             current =iv_ruleBehaviorTreeLiteral; 
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
    // $ANTLR end "entryRuleBehaviorTreeLiteral"


    // $ANTLR start "ruleBehaviorTreeLiteral"
    // InternalMIRoN.g:931:1: ruleBehaviorTreeLiteral returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_preset_3_0= 'preset' ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_5= 'affects' ( ( (lv_impacts_6_0= ruleImpactOnQuality ) ) | (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' ) ) )? ) ;
    public final EObject ruleBehaviorTreeLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_preset_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_impacts_6_0 = null;

        EObject lv_impacts_8_0 = null;

        EObject lv_impacts_10_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:937:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_preset_3_0= 'preset' ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_5= 'affects' ( ( (lv_impacts_6_0= ruleImpactOnQuality ) ) | (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' ) ) )? ) )
            // InternalMIRoN.g:938:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_preset_3_0= 'preset' ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_5= 'affects' ( ( (lv_impacts_6_0= ruleImpactOnQuality ) ) | (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' ) ) )? )
            {
            // InternalMIRoN.g:938:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_preset_3_0= 'preset' ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_5= 'affects' ( ( (lv_impacts_6_0= ruleImpactOnQuality ) ) | (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' ) ) )? )
            // InternalMIRoN.g:939:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_preset_3_0= 'preset' ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_5= 'affects' ( ( (lv_impacts_6_0= ruleImpactOnQuality ) ) | (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' ) ) )?
            {
            // InternalMIRoN.g:939:3: ()
            // InternalMIRoN.g:940:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBehaviorTreeLiteralAccess().getBehaviorTreeLiteralAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:946:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:947:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:947:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:948:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getBehaviorTreeLiteralAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBehaviorTreeLiteralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getBehaviorTreeLiteralAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:968:3: ( ( (lv_preset_3_0= 'preset' ) ) | ( ( ruleQualifiedName ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ID) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalMIRoN.g:969:4: ( (lv_preset_3_0= 'preset' ) )
                    {
                    // InternalMIRoN.g:969:4: ( (lv_preset_3_0= 'preset' ) )
                    // InternalMIRoN.g:970:5: (lv_preset_3_0= 'preset' )
                    {
                    // InternalMIRoN.g:970:5: (lv_preset_3_0= 'preset' )
                    // InternalMIRoN.g:971:6: lv_preset_3_0= 'preset'
                    {
                    lv_preset_3_0=(Token)match(input,27,FOLLOW_23); 

                    						newLeafNode(lv_preset_3_0, grammarAccess.getBehaviorTreeLiteralAccess().getPresetPresetKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBehaviorTreeLiteralRule());
                    						}
                    						setWithLastConsumed(current, "preset", true, "preset");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:984:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalMIRoN.g:984:4: ( ( ruleQualifiedName ) )
                    // InternalMIRoN.g:985:5: ( ruleQualifiedName )
                    {
                    // InternalMIRoN.g:985:5: ( ruleQualifiedName )
                    // InternalMIRoN.g:986:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBehaviorTreeLiteralRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getBehaviorTreeLiteralAccess().getReferenceBehaviorTreeCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMIRoN.g:1001:3: (otherlv_5= 'affects' ( ( (lv_impacts_6_0= ruleImpactOnQuality ) ) | (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMIRoN.g:1002:4: otherlv_5= 'affects' ( ( (lv_impacts_6_0= ruleImpactOnQuality ) ) | (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' ) )
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_17); 

                    				newLeafNode(otherlv_5, grammarAccess.getBehaviorTreeLiteralAccess().getAffectsKeyword_4_0());
                    			
                    // InternalMIRoN.g:1006:4: ( ( (lv_impacts_6_0= ruleImpactOnQuality ) ) | (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_ID) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==22) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalMIRoN.g:1007:5: ( (lv_impacts_6_0= ruleImpactOnQuality ) )
                            {
                            // InternalMIRoN.g:1007:5: ( (lv_impacts_6_0= ruleImpactOnQuality ) )
                            // InternalMIRoN.g:1008:6: (lv_impacts_6_0= ruleImpactOnQuality )
                            {
                            // InternalMIRoN.g:1008:6: (lv_impacts_6_0= ruleImpactOnQuality )
                            // InternalMIRoN.g:1009:7: lv_impacts_6_0= ruleImpactOnQuality
                            {

                            							newCompositeNode(grammarAccess.getBehaviorTreeLiteralAccess().getImpactsImpactOnQualityParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_impacts_6_0=ruleImpactOnQuality();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getBehaviorTreeLiteralRule());
                            							}
                            							add(
                            								current,
                            								"impacts",
                            								lv_impacts_6_0,
                            								"org.xtext.miron.MIRoN.ImpactOnQuality");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMIRoN.g:1027:5: (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' )
                            {
                            // InternalMIRoN.g:1027:5: (otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}' )
                            // InternalMIRoN.g:1028:6: otherlv_7= '{' ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )? otherlv_11= '}'
                            {
                            otherlv_7=(Token)match(input,22,FOLLOW_18); 

                            						newLeafNode(otherlv_7, grammarAccess.getBehaviorTreeLiteralAccess().getLeftCurlyBracketKeyword_4_1_1_0());
                            					
                            // InternalMIRoN.g:1032:6: ( ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )* )?
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==RULE_ID) ) {
                                alt20=1;
                            }
                            switch (alt20) {
                                case 1 :
                                    // InternalMIRoN.g:1033:7: ( (lv_impacts_8_0= ruleImpactOnQuality ) ) (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )*
                                    {
                                    // InternalMIRoN.g:1033:7: ( (lv_impacts_8_0= ruleImpactOnQuality ) )
                                    // InternalMIRoN.g:1034:8: (lv_impacts_8_0= ruleImpactOnQuality )
                                    {
                                    // InternalMIRoN.g:1034:8: (lv_impacts_8_0= ruleImpactOnQuality )
                                    // InternalMIRoN.g:1035:9: lv_impacts_8_0= ruleImpactOnQuality
                                    {

                                    									newCompositeNode(grammarAccess.getBehaviorTreeLiteralAccess().getImpactsImpactOnQualityParserRuleCall_4_1_1_1_0_0());
                                    								
                                    pushFollow(FOLLOW_15);
                                    lv_impacts_8_0=ruleImpactOnQuality();

                                    state._fsp--;


                                    									if (current==null) {
                                    										current = createModelElementForParent(grammarAccess.getBehaviorTreeLiteralRule());
                                    									}
                                    									add(
                                    										current,
                                    										"impacts",
                                    										lv_impacts_8_0,
                                    										"org.xtext.miron.MIRoN.ImpactOnQuality");
                                    									afterParserOrEnumRuleCall();
                                    								

                                    }


                                    }

                                    // InternalMIRoN.g:1052:7: (otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) ) )*
                                    loop19:
                                    do {
                                        int alt19=2;
                                        int LA19_0 = input.LA(1);

                                        if ( (LA19_0==23) ) {
                                            alt19=1;
                                        }


                                        switch (alt19) {
                                    	case 1 :
                                    	    // InternalMIRoN.g:1053:8: otherlv_9= ',' ( (lv_impacts_10_0= ruleImpactOnQuality ) )
                                    	    {
                                    	    otherlv_9=(Token)match(input,23,FOLLOW_19); 

                                    	    								newLeafNode(otherlv_9, grammarAccess.getBehaviorTreeLiteralAccess().getCommaKeyword_4_1_1_1_1_0());
                                    	    							
                                    	    // InternalMIRoN.g:1057:8: ( (lv_impacts_10_0= ruleImpactOnQuality ) )
                                    	    // InternalMIRoN.g:1058:9: (lv_impacts_10_0= ruleImpactOnQuality )
                                    	    {
                                    	    // InternalMIRoN.g:1058:9: (lv_impacts_10_0= ruleImpactOnQuality )
                                    	    // InternalMIRoN.g:1059:10: lv_impacts_10_0= ruleImpactOnQuality
                                    	    {

                                    	    										newCompositeNode(grammarAccess.getBehaviorTreeLiteralAccess().getImpactsImpactOnQualityParserRuleCall_4_1_1_1_1_1_0());
                                    	    									
                                    	    pushFollow(FOLLOW_15);
                                    	    lv_impacts_10_0=ruleImpactOnQuality();

                                    	    state._fsp--;


                                    	    										if (current==null) {
                                    	    											current = createModelElementForParent(grammarAccess.getBehaviorTreeLiteralRule());
                                    	    										}
                                    	    										add(
                                    	    											current,
                                    	    											"impacts",
                                    	    											lv_impacts_10_0,
                                    	    											"org.xtext.miron.MIRoN.ImpactOnQuality");
                                    	    										afterParserOrEnumRuleCall();
                                    	    									

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop19;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            otherlv_11=(Token)match(input,24,FOLLOW_2); 

                            						newLeafNode(otherlv_11, grammarAccess.getBehaviorTreeLiteralAccess().getRightCurlyBracketKeyword_4_1_1_2());
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

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
    // $ANTLR end "ruleBehaviorTreeLiteral"


    // $ANTLR start "entryRuleImpactOnQuality"
    // InternalMIRoN.g:1089:1: entryRuleImpactOnQuality returns [EObject current=null] : iv_ruleImpactOnQuality= ruleImpactOnQuality EOF ;
    public final EObject entryRuleImpactOnQuality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpactOnQuality = null;


        try {
            // InternalMIRoN.g:1089:56: (iv_ruleImpactOnQuality= ruleImpactOnQuality EOF )
            // InternalMIRoN.g:1090:2: iv_ruleImpactOnQuality= ruleImpactOnQuality EOF
            {
             newCompositeNode(grammarAccess.getImpactOnQualityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImpactOnQuality=ruleImpactOnQuality();

            state._fsp--;

             current =iv_ruleImpactOnQuality; 
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
    // $ANTLR end "entryRuleImpactOnQuality"


    // $ANTLR start "ruleImpactOnQuality"
    // InternalMIRoN.g:1096:1: ruleImpactOnQuality returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_intensity_1_0= ruleImpactIntensityEnum ) ) ) ;
    public final EObject ruleImpactOnQuality() throws RecognitionException {
        EObject current = null;

        Enumerator lv_intensity_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1102:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_intensity_1_0= ruleImpactIntensityEnum ) ) ) )
            // InternalMIRoN.g:1103:2: ( ( ( ruleQualifiedName ) ) ( (lv_intensity_1_0= ruleImpactIntensityEnum ) ) )
            {
            // InternalMIRoN.g:1103:2: ( ( ( ruleQualifiedName ) ) ( (lv_intensity_1_0= ruleImpactIntensityEnum ) ) )
            // InternalMIRoN.g:1104:3: ( ( ruleQualifiedName ) ) ( (lv_intensity_1_0= ruleImpactIntensityEnum ) )
            {
            // InternalMIRoN.g:1104:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:1105:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:1105:4: ( ruleQualifiedName )
            // InternalMIRoN.g:1106:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImpactOnQualityRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImpactOnQualityAccess().getPropertyPropertyCrossReference_0_0());
            				
            pushFollow(FOLLOW_24);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:1120:3: ( (lv_intensity_1_0= ruleImpactIntensityEnum ) )
            // InternalMIRoN.g:1121:4: (lv_intensity_1_0= ruleImpactIntensityEnum )
            {
            // InternalMIRoN.g:1121:4: (lv_intensity_1_0= ruleImpactIntensityEnum )
            // InternalMIRoN.g:1122:5: lv_intensity_1_0= ruleImpactIntensityEnum
            {

            					newCompositeNode(grammarAccess.getImpactOnQualityAccess().getIntensityImpactIntensityEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_intensity_1_0=ruleImpactIntensityEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImpactOnQualityRule());
            					}
            					set(
            						current,
            						"intensity",
            						lv_intensity_1_0,
            						"org.xtext.miron.MIRoN.ImpactIntensityEnum");
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
    // $ANTLR end "ruleImpactOnQuality"


    // $ANTLR start "entryRuleTypedVariable"
    // InternalMIRoN.g:1143:1: entryRuleTypedVariable returns [EObject current=null] : iv_ruleTypedVariable= ruleTypedVariable EOF ;
    public final EObject entryRuleTypedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedVariable = null;


        try {
            // InternalMIRoN.g:1143:54: (iv_ruleTypedVariable= ruleTypedVariable EOF )
            // InternalMIRoN.g:1144:2: iv_ruleTypedVariable= ruleTypedVariable EOF
            {
             newCompositeNode(grammarAccess.getTypedVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedVariable=ruleTypedVariable();

            state._fsp--;

             current =iv_ruleTypedVariable; 
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
    // $ANTLR end "entryRuleTypedVariable"


    // $ANTLR start "ruleTypedVariable"
    // InternalMIRoN.g:1150:1: ruleTypedVariable returns [EObject current=null] : (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable | this_VariationPoint_5= ruleVariationPoint ) ;
    public final EObject ruleTypedVariable() throws RecognitionException {
        EObject current = null;

        EObject this_Parameter_0 = null;

        EObject this_Timer_1 = null;

        EObject this_GeneralPurposeVariable_2 = null;

        EObject this_Context_3 = null;

        EObject this_BeliefVariable_4 = null;

        EObject this_VariationPoint_5 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1156:2: ( (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable | this_VariationPoint_5= ruleVariationPoint ) )
            // InternalMIRoN.g:1157:2: (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable | this_VariationPoint_5= ruleVariationPoint )
            {
            // InternalMIRoN.g:1157:2: (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable | this_VariationPoint_5= ruleVariationPoint )
            int alt23=6;
            switch ( input.LA(1) ) {
            case RULE_ROQME_DESCRIPTION:
                {
                switch ( input.LA(2) ) {
                case 37:
                    {
                    alt23=4;
                    }
                    break;
                case 46:
                case 49:
                    {
                    alt23=5;
                    }
                    break;
                case 40:
                    {
                    alt23=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }

                }
                break;
            case 40:
                {
                alt23=1;
                }
                break;
            case 42:
                {
                alt23=2;
                }
                break;
            case 39:
                {
                alt23=3;
                }
                break;
            case 37:
                {
                alt23=4;
                }
                break;
            case 46:
            case 49:
                {
                alt23=5;
                }
                break;
            case 28:
                {
                alt23=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalMIRoN.g:1158:3: this_Parameter_0= ruleParameter
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getParameterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Parameter_0=ruleParameter();

                    state._fsp--;


                    			current = this_Parameter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:1167:3: this_Timer_1= ruleTimer
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getTimerParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Timer_1=ruleTimer();

                    state._fsp--;


                    			current = this_Timer_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:1176:3: this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getGeneralPurposeVariableParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_GeneralPurposeVariable_2=ruleGeneralPurposeVariable();

                    state._fsp--;


                    			current = this_GeneralPurposeVariable_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:1185:3: this_Context_3= ruleContext
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getContextParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Context_3=ruleContext();

                    state._fsp--;


                    			current = this_Context_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:1194:3: this_BeliefVariable_4= ruleBeliefVariable
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getBeliefVariableParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BeliefVariable_4=ruleBeliefVariable();

                    state._fsp--;


                    			current = this_BeliefVariable_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:1203:3: this_VariationPoint_5= ruleVariationPoint
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getVariationPointParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariationPoint_5=ruleVariationPoint();

                    state._fsp--;


                    			current = this_VariationPoint_5;
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
    // $ANTLR end "ruleTypedVariable"


    // $ANTLR start "entryRuleVariationPoint"
    // InternalMIRoN.g:1215:1: entryRuleVariationPoint returns [EObject current=null] : iv_ruleVariationPoint= ruleVariationPoint EOF ;
    public final EObject entryRuleVariationPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariationPoint = null;


        try {
            // InternalMIRoN.g:1215:55: (iv_ruleVariationPoint= ruleVariationPoint EOF )
            // InternalMIRoN.g:1216:2: iv_ruleVariationPoint= ruleVariationPoint EOF
            {
             newCompositeNode(grammarAccess.getVariationPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariationPoint=ruleVariationPoint();

            state._fsp--;

             current =iv_ruleVariationPoint; 
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
    // $ANTLR end "entryRuleVariationPoint"


    // $ANTLR start "ruleVariationPoint"
    // InternalMIRoN.g:1222:1: ruleVariationPoint returns [EObject current=null] : (otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) )? ) ;
    public final EObject ruleVariationPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_declaration_3_0 = null;

        EObject lv_binding_4_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1228:2: ( (otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) )? ) )
            // InternalMIRoN.g:1229:2: (otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) )? )
            {
            // InternalMIRoN.g:1229:2: (otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) )? )
            // InternalMIRoN.g:1230:3: otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getVariationPointAccess().getVarpointKeyword_0());
            		
            // InternalMIRoN.g:1234:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:1235:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:1235:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:1236:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVariationPointAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariationPointRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getVariationPointAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:1256:3: ( (lv_declaration_3_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:1257:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:1257:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:1258:5: lv_declaration_3_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getVariationPointAccess().getDeclarationDataTypeDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_26);
            lv_declaration_3_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariationPointRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_3_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:1275:3: ( (lv_binding_4_0= ruleBinding ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29||(LA24_0>=107 && LA24_0<=108)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMIRoN.g:1276:4: (lv_binding_4_0= ruleBinding )
                    {
                    // InternalMIRoN.g:1276:4: (lv_binding_4_0= ruleBinding )
                    // InternalMIRoN.g:1277:5: lv_binding_4_0= ruleBinding
                    {

                    					newCompositeNode(grammarAccess.getVariationPointAccess().getBindingBindingParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_binding_4_0=ruleBinding();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getVariationPointRule());
                    					}
                    					set(
                    						current,
                    						"binding",
                    						lv_binding_4_0,
                    						"org.xtext.miron.MIRoN.Binding");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleVariationPoint"


    // $ANTLR start "entryRuleBinding"
    // InternalMIRoN.g:1298:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalMIRoN.g:1298:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalMIRoN.g:1299:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
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
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // InternalMIRoN.g:1305:1: ruleBinding returns [EObject current=null] : (this_BtBinding_0= ruleBtBinding | this_ArchBinding_1= ruleArchBinding ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject this_BtBinding_0 = null;

        EObject this_ArchBinding_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1311:2: ( (this_BtBinding_0= ruleBtBinding | this_ArchBinding_1= ruleArchBinding ) )
            // InternalMIRoN.g:1312:2: (this_BtBinding_0= ruleBtBinding | this_ArchBinding_1= ruleArchBinding )
            {
            // InternalMIRoN.g:1312:2: (this_BtBinding_0= ruleBtBinding | this_ArchBinding_1= ruleArchBinding )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==29) ) {
                int LA25_1 = input.LA(2);

                if ( ((LA25_1>=RULE_ID && LA25_1<=RULE_STRING)) ) {
                    alt25=1;
                }
                else if ( (LA25_1==30) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA25_0>=107 && LA25_0<=108)) ) {
                alt25=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalMIRoN.g:1313:3: this_BtBinding_0= ruleBtBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getBtBindingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BtBinding_0=ruleBtBinding();

                    state._fsp--;


                    			current = this_BtBinding_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:1322:3: this_ArchBinding_1= ruleArchBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getArchBindingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArchBinding_1=ruleArchBinding();

                    state._fsp--;


                    			current = this_ArchBinding_1;
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
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleArchBinding"
    // InternalMIRoN.g:1334:1: entryRuleArchBinding returns [EObject current=null] : iv_ruleArchBinding= ruleArchBinding EOF ;
    public final EObject entryRuleArchBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArchBinding = null;


        try {
            // InternalMIRoN.g:1334:52: (iv_ruleArchBinding= ruleArchBinding EOF )
            // InternalMIRoN.g:1335:2: iv_ruleArchBinding= ruleArchBinding EOF
            {
             newCompositeNode(grammarAccess.getArchBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArchBinding=ruleArchBinding();

            state._fsp--;

             current =iv_ruleArchBinding; 
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
    // $ANTLR end "entryRuleArchBinding"


    // $ANTLR start "ruleArchBinding"
    // InternalMIRoN.g:1341:1: ruleArchBinding returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= 'arch' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) otherlv_12= '}' ) ;
    public final EObject ruleArchBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_parameterSetRepository_5_0 = null;

        AntlrDatatypeRuleToken lv_parameterSet_7_0 = null;

        AntlrDatatypeRuleToken lv_component_9_0 = null;

        AntlrDatatypeRuleToken lv_parameter_11_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1347:2: ( (otherlv_0= 'in' otherlv_1= 'arch' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) otherlv_12= '}' ) )
            // InternalMIRoN.g:1348:2: (otherlv_0= 'in' otherlv_1= 'arch' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) otherlv_12= '}' )
            {
            // InternalMIRoN.g:1348:2: (otherlv_0= 'in' otherlv_1= 'arch' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) otherlv_12= '}' )
            // InternalMIRoN.g:1349:3: otherlv_0= 'in' otherlv_1= 'arch' otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getArchBindingAccess().getInKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getArchBindingAccess().getArchKeyword_1());
            		
            otherlv_2=(Token)match(input,22,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getArchBindingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMIRoN.g:1361:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) )
            // InternalMIRoN.g:1362:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalMIRoN.g:1362:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
            // InternalMIRoN.g:1363:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getArchBindingAccess().getUnorderedGroup_3());
            				
            // InternalMIRoN.g:1366:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?)
            // InternalMIRoN.g:1367:6: ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+ {...}?
            {
            // InternalMIRoN.g:1367:6: ( ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=5;
                int LA26_0 = input.LA(1);

                if ( LA26_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 0) ) {
                    alt26=1;
                }
                else if ( LA26_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 1) ) {
                    alt26=2;
                }
                else if ( LA26_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 2) ) {
                    alt26=3;
                }
                else if ( LA26_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 3) ) {
                    alt26=4;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMIRoN.g:1368:4: ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1368:4: ({...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) ) )
            	    // InternalMIRoN.g:1369:5: {...}? => ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleArchBinding", "getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalMIRoN.g:1369:108: ( ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) ) )
            	    // InternalMIRoN.g:1370:6: ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalMIRoN.g:1373:9: ({...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) ) )
            	    // InternalMIRoN.g:1373:10: {...}? => (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleArchBinding", "true");
            	    }
            	    // InternalMIRoN.g:1373:19: (otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) ) )
            	    // InternalMIRoN.g:1373:20: otherlv_4= 'parameterSetRepository' ( (lv_parameterSetRepository_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,31,FOLLOW_4); 

            	    									newLeafNode(otherlv_4, grammarAccess.getArchBindingAccess().getParameterSetRepositoryKeyword_3_0_0());
            	    								
            	    // InternalMIRoN.g:1377:9: ( (lv_parameterSetRepository_5_0= ruleEString ) )
            	    // InternalMIRoN.g:1378:10: (lv_parameterSetRepository_5_0= ruleEString )
            	    {
            	    // InternalMIRoN.g:1378:10: (lv_parameterSetRepository_5_0= ruleEString )
            	    // InternalMIRoN.g:1379:11: lv_parameterSetRepository_5_0= ruleEString
            	    {

            	    											newCompositeNode(grammarAccess.getArchBindingAccess().getParameterSetRepositoryEStringParserRuleCall_3_0_1_0());
            	    										
            	    pushFollow(FOLLOW_29);
            	    lv_parameterSetRepository_5_0=ruleEString();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getArchBindingRule());
            	    											}
            	    											set(
            	    												current,
            	    												"parameterSetRepository",
            	    												lv_parameterSetRepository_5_0,
            	    												"org.xtext.roqme.RoQME.EString");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getArchBindingAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMIRoN.g:1402:4: ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1402:4: ({...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) ) )
            	    // InternalMIRoN.g:1403:5: {...}? => ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleArchBinding", "getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalMIRoN.g:1403:108: ( ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) ) )
            	    // InternalMIRoN.g:1404:6: ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalMIRoN.g:1407:9: ({...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) ) )
            	    // InternalMIRoN.g:1407:10: {...}? => (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleArchBinding", "true");
            	    }
            	    // InternalMIRoN.g:1407:19: (otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) ) )
            	    // InternalMIRoN.g:1407:20: otherlv_6= 'parameterSet' ( (lv_parameterSet_7_0= ruleEString ) )
            	    {
            	    otherlv_6=(Token)match(input,32,FOLLOW_4); 

            	    									newLeafNode(otherlv_6, grammarAccess.getArchBindingAccess().getParameterSetKeyword_3_1_0());
            	    								
            	    // InternalMIRoN.g:1411:9: ( (lv_parameterSet_7_0= ruleEString ) )
            	    // InternalMIRoN.g:1412:10: (lv_parameterSet_7_0= ruleEString )
            	    {
            	    // InternalMIRoN.g:1412:10: (lv_parameterSet_7_0= ruleEString )
            	    // InternalMIRoN.g:1413:11: lv_parameterSet_7_0= ruleEString
            	    {

            	    											newCompositeNode(grammarAccess.getArchBindingAccess().getParameterSetEStringParserRuleCall_3_1_1_0());
            	    										
            	    pushFollow(FOLLOW_29);
            	    lv_parameterSet_7_0=ruleEString();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getArchBindingRule());
            	    											}
            	    											set(
            	    												current,
            	    												"parameterSet",
            	    												lv_parameterSet_7_0,
            	    												"org.xtext.roqme.RoQME.EString");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getArchBindingAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMIRoN.g:1436:4: ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1436:4: ({...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) ) )
            	    // InternalMIRoN.g:1437:5: {...}? => ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleArchBinding", "getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalMIRoN.g:1437:108: ( ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) ) )
            	    // InternalMIRoN.g:1438:6: ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalMIRoN.g:1441:9: ({...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) ) )
            	    // InternalMIRoN.g:1441:10: {...}? => (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleArchBinding", "true");
            	    }
            	    // InternalMIRoN.g:1441:19: (otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) ) )
            	    // InternalMIRoN.g:1441:20: otherlv_8= 'component' ( (lv_component_9_0= ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,33,FOLLOW_4); 

            	    									newLeafNode(otherlv_8, grammarAccess.getArchBindingAccess().getComponentKeyword_3_2_0());
            	    								
            	    // InternalMIRoN.g:1445:9: ( (lv_component_9_0= ruleEString ) )
            	    // InternalMIRoN.g:1446:10: (lv_component_9_0= ruleEString )
            	    {
            	    // InternalMIRoN.g:1446:10: (lv_component_9_0= ruleEString )
            	    // InternalMIRoN.g:1447:11: lv_component_9_0= ruleEString
            	    {

            	    											newCompositeNode(grammarAccess.getArchBindingAccess().getComponentEStringParserRuleCall_3_2_1_0());
            	    										
            	    pushFollow(FOLLOW_29);
            	    lv_component_9_0=ruleEString();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getArchBindingRule());
            	    											}
            	    											set(
            	    												current,
            	    												"component",
            	    												lv_component_9_0,
            	    												"org.xtext.roqme.RoQME.EString");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getArchBindingAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalMIRoN.g:1470:4: ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1470:4: ({...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) ) )
            	    // InternalMIRoN.g:1471:5: {...}? => ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleArchBinding", "getUnorderedGroupHelper().canSelect(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalMIRoN.g:1471:108: ( ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) ) )
            	    // InternalMIRoN.g:1472:6: ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getArchBindingAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalMIRoN.g:1475:9: ({...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) ) )
            	    // InternalMIRoN.g:1475:10: {...}? => (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleArchBinding", "true");
            	    }
            	    // InternalMIRoN.g:1475:19: (otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) ) )
            	    // InternalMIRoN.g:1475:20: otherlv_10= 'parameter' ( (lv_parameter_11_0= ruleEString ) )
            	    {
            	    otherlv_10=(Token)match(input,34,FOLLOW_4); 

            	    									newLeafNode(otherlv_10, grammarAccess.getArchBindingAccess().getParameterKeyword_3_3_0());
            	    								
            	    // InternalMIRoN.g:1479:9: ( (lv_parameter_11_0= ruleEString ) )
            	    // InternalMIRoN.g:1480:10: (lv_parameter_11_0= ruleEString )
            	    {
            	    // InternalMIRoN.g:1480:10: (lv_parameter_11_0= ruleEString )
            	    // InternalMIRoN.g:1481:11: lv_parameter_11_0= ruleEString
            	    {

            	    											newCompositeNode(grammarAccess.getArchBindingAccess().getParameterEStringParserRuleCall_3_3_1_0());
            	    										
            	    pushFollow(FOLLOW_29);
            	    lv_parameter_11_0=ruleEString();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getArchBindingRule());
            	    											}
            	    											set(
            	    												current,
            	    												"parameter",
            	    												lv_parameter_11_0,
            	    												"org.xtext.roqme.RoQME.EString");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getArchBindingAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getArchBindingAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleArchBinding", "getUnorderedGroupHelper().canLeave(grammarAccess.getArchBindingAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getArchBindingAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getArchBindingAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleArchBinding"


    // $ANTLR start "entryRuleBtBinding"
    // InternalMIRoN.g:1520:1: entryRuleBtBinding returns [EObject current=null] : iv_ruleBtBinding= ruleBtBinding EOF ;
    public final EObject entryRuleBtBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBtBinding = null;


        try {
            // InternalMIRoN.g:1520:50: (iv_ruleBtBinding= ruleBtBinding EOF )
            // InternalMIRoN.g:1521:2: iv_ruleBtBinding= ruleBtBinding EOF
            {
             newCompositeNode(grammarAccess.getBtBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBtBinding=ruleBtBinding();

            state._fsp--;

             current =iv_ruleBtBinding; 
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
    // $ANTLR end "entryRuleBtBinding"


    // $ANTLR start "ruleBtBinding"
    // InternalMIRoN.g:1527:1: ruleBtBinding returns [EObject current=null] : ( ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (lv_xpath_1_0= ruleEString ) )? ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleBtBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Enumerator lv_insertionType_0_0 = null;

        AntlrDatatypeRuleToken lv_xpath_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1533:2: ( ( ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (lv_xpath_1_0= ruleEString ) )? ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )* ) )
            // InternalMIRoN.g:1534:2: ( ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (lv_xpath_1_0= ruleEString ) )? ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )* )
            {
            // InternalMIRoN.g:1534:2: ( ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (lv_xpath_1_0= ruleEString ) )? ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )* )
            // InternalMIRoN.g:1535:3: ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (lv_xpath_1_0= ruleEString ) )? ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )*
            {
            // InternalMIRoN.g:1535:3: ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) )
            // InternalMIRoN.g:1536:4: (lv_insertionType_0_0= ruleInsertionTypeEnum )
            {
            // InternalMIRoN.g:1536:4: (lv_insertionType_0_0= ruleInsertionTypeEnum )
            // InternalMIRoN.g:1537:5: lv_insertionType_0_0= ruleInsertionTypeEnum
            {

            					newCompositeNode(grammarAccess.getBtBindingAccess().getInsertionTypeInsertionTypeEnumEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_insertionType_0_0=ruleInsertionTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBtBindingRule());
            					}
            					set(
            						current,
            						"insertionType",
            						lv_insertionType_0_0,
            						"org.xtext.miron.MIRoN.InsertionTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:1554:3: ( (lv_xpath_1_0= ruleEString ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_STRING) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_ID) ) {
                int LA27_2 = input.LA(2);

                if ( (LA27_2==RULE_ID) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // InternalMIRoN.g:1555:4: (lv_xpath_1_0= ruleEString )
                    {
                    // InternalMIRoN.g:1555:4: (lv_xpath_1_0= ruleEString )
                    // InternalMIRoN.g:1556:5: lv_xpath_1_0= ruleEString
                    {

                    					newCompositeNode(grammarAccess.getBtBindingAccess().getXpathEStringParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_19);
                    lv_xpath_1_0=ruleEString();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBtBindingRule());
                    					}
                    					set(
                    						current,
                    						"xpath",
                    						lv_xpath_1_0,
                    						"org.xtext.roqme.RoQME.EString");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMIRoN.g:1573:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:1574:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:1574:4: ( ruleQualifiedName )
            // InternalMIRoN.g:1575:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBtBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBtBindingAccess().getTargetsEObjectCrossReference_2_0());
            				
            pushFollow(FOLLOW_30);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:1589:3: (otherlv_3= ',' ( ( ruleQualifiedName ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==23) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalMIRoN.g:1590:4: otherlv_3= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_19); 

            	    				newLeafNode(otherlv_3, grammarAccess.getBtBindingAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMIRoN.g:1594:4: ( ( ruleQualifiedName ) )
            	    // InternalMIRoN.g:1595:5: ( ruleQualifiedName )
            	    {
            	    // InternalMIRoN.g:1595:5: ( ruleQualifiedName )
            	    // InternalMIRoN.g:1596:6: ruleQualifiedName
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getBtBindingRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getBtBindingAccess().getTargetsEObjectCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_30);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


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
    // $ANTLR end "ruleBtBinding"


    // $ANTLR start "entryRuleSentence"
    // InternalMIRoN.g:1615:1: entryRuleSentence returns [EObject current=null] : iv_ruleSentence= ruleSentence EOF ;
    public final EObject entryRuleSentence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSentence = null;


        try {
            // InternalMIRoN.g:1615:49: (iv_ruleSentence= ruleSentence EOF )
            // InternalMIRoN.g:1616:2: iv_ruleSentence= ruleSentence EOF
            {
             newCompositeNode(grammarAccess.getSentenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSentence=ruleSentence();

            state._fsp--;

             current =iv_ruleSentence; 
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
    // $ANTLR end "entryRuleSentence"


    // $ANTLR start "ruleSentence"
    // InternalMIRoN.g:1622:1: ruleSentence returns [EObject current=null] : (this_Observation_0= ruleObservation | this_Rule_1= ruleRule ) ;
    public final EObject ruleSentence() throws RecognitionException {
        EObject current = null;

        EObject this_Observation_0 = null;

        EObject this_Rule_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1628:2: ( (this_Observation_0= ruleObservation | this_Rule_1= ruleRule ) )
            // InternalMIRoN.g:1629:2: (this_Observation_0= ruleObservation | this_Rule_1= ruleRule )
            {
            // InternalMIRoN.g:1629:2: (this_Observation_0= ruleObservation | this_Rule_1= ruleRule )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ROQME_DESCRIPTION||LA29_0==50) ) {
                alt29=1;
            }
            else if ( (LA29_0==35) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalMIRoN.g:1630:3: this_Observation_0= ruleObservation
                    {

                    			newCompositeNode(grammarAccess.getSentenceAccess().getObservationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Observation_0=ruleObservation();

                    state._fsp--;


                    			current = this_Observation_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:1639:3: this_Rule_1= ruleRule
                    {

                    			newCompositeNode(grammarAccess.getSentenceAccess().getRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Rule_1=ruleRule();

                    state._fsp--;


                    			current = this_Rule_1;
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
    // $ANTLR end "ruleSentence"


    // $ANTLR start "entryRuleRule"
    // InternalMIRoN.g:1651:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalMIRoN.g:1651:45: (iv_ruleRule= ruleRule EOF )
            // InternalMIRoN.g:1652:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
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
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalMIRoN.g:1658:1: ruleRule returns [EObject current=null] : (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= 'implies' ( ( (lv_implies_5_0= ruleConstraint ) ) | (otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}' ) ) ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_condition_3_0 = null;

        EObject lv_implies_5_0 = null;

        EObject lv_implies_7_0 = null;

        EObject lv_implies_9_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1664:2: ( (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= 'implies' ( ( (lv_implies_5_0= ruleConstraint ) ) | (otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}' ) ) ) )
            // InternalMIRoN.g:1665:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= 'implies' ( ( (lv_implies_5_0= ruleConstraint ) ) | (otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}' ) ) )
            {
            // InternalMIRoN.g:1665:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= 'implies' ( ( (lv_implies_5_0= ruleConstraint ) ) | (otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}' ) ) )
            // InternalMIRoN.g:1666:3: otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= 'implies' ( ( (lv_implies_5_0= ruleConstraint ) ) | (otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}' ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
            		
            // InternalMIRoN.g:1670:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:1671:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:1671:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:1672:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_31); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:1692:3: ( (lv_condition_3_0= ruleCondition ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_INT && LA30_0<=RULE_ID)||LA30_0==16||LA30_0==19||LA30_0==63||LA30_0==74||LA30_0==81||LA30_0==85||LA30_0==93||(LA30_0>=96 && LA30_0<=97)||(LA30_0>=100 && LA30_0<=101)||(LA30_0>=116 && LA30_0<=136)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMIRoN.g:1693:4: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalMIRoN.g:1693:4: (lv_condition_3_0= ruleCondition )
                    // InternalMIRoN.g:1694:5: lv_condition_3_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getRuleAccess().getConditionConditionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_32);
                    lv_condition_3_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRuleRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_3_0,
                    						"org.xtext.miron.MIRoN.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,36,FOLLOW_33); 

            			newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getImpliesKeyword_4());
            		
            // InternalMIRoN.g:1715:3: ( ( (lv_implies_5_0= ruleConstraint ) ) | (otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_INT && LA32_0<=RULE_ID)||LA32_0==16||LA32_0==19||LA32_0==63||LA32_0==74||LA32_0==81||LA32_0==85||LA32_0==93||(LA32_0>=96 && LA32_0<=97)||(LA32_0>=100 && LA32_0<=101)||(LA32_0>=116 && LA32_0<=136)) ) {
                alt32=1;
            }
            else if ( (LA32_0==22) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalMIRoN.g:1716:4: ( (lv_implies_5_0= ruleConstraint ) )
                    {
                    // InternalMIRoN.g:1716:4: ( (lv_implies_5_0= ruleConstraint ) )
                    // InternalMIRoN.g:1717:5: (lv_implies_5_0= ruleConstraint )
                    {
                    // InternalMIRoN.g:1717:5: (lv_implies_5_0= ruleConstraint )
                    // InternalMIRoN.g:1718:6: lv_implies_5_0= ruleConstraint
                    {

                    						newCompositeNode(grammarAccess.getRuleAccess().getImpliesConstraintParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_implies_5_0=ruleConstraint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRuleRule());
                    						}
                    						add(
                    							current,
                    							"implies",
                    							lv_implies_5_0,
                    							"org.xtext.miron.MIRoN.Constraint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:1736:4: (otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}' )
                    {
                    // InternalMIRoN.g:1736:4: (otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}' )
                    // InternalMIRoN.g:1737:5: otherlv_6= '{' ( (lv_implies_7_0= ruleConstraint ) ) (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+ otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_34); 

                    					newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_5_1_0());
                    				
                    // InternalMIRoN.g:1741:5: ( (lv_implies_7_0= ruleConstraint ) )
                    // InternalMIRoN.g:1742:6: (lv_implies_7_0= ruleConstraint )
                    {
                    // InternalMIRoN.g:1742:6: (lv_implies_7_0= ruleConstraint )
                    // InternalMIRoN.g:1743:7: lv_implies_7_0= ruleConstraint
                    {

                    							newCompositeNode(grammarAccess.getRuleAccess().getImpliesConstraintParserRuleCall_5_1_1_0());
                    						
                    pushFollow(FOLLOW_35);
                    lv_implies_7_0=ruleConstraint();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRuleRule());
                    							}
                    							add(
                    								current,
                    								"implies",
                    								lv_implies_7_0,
                    								"org.xtext.miron.MIRoN.Constraint");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalMIRoN.g:1760:5: (otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==23) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalMIRoN.g:1761:6: otherlv_8= ',' ( (lv_implies_9_0= ruleConstraint ) )
                    	    {
                    	    otherlv_8=(Token)match(input,23,FOLLOW_34); 

                    	    						newLeafNode(otherlv_8, grammarAccess.getRuleAccess().getCommaKeyword_5_1_2_0());
                    	    					
                    	    // InternalMIRoN.g:1765:6: ( (lv_implies_9_0= ruleConstraint ) )
                    	    // InternalMIRoN.g:1766:7: (lv_implies_9_0= ruleConstraint )
                    	    {
                    	    // InternalMIRoN.g:1766:7: (lv_implies_9_0= ruleConstraint )
                    	    // InternalMIRoN.g:1767:8: lv_implies_9_0= ruleConstraint
                    	    {

                    	    								newCompositeNode(grammarAccess.getRuleAccess().getImpliesConstraintParserRuleCall_5_1_2_1_0());
                    	    							
                    	    pushFollow(FOLLOW_15);
                    	    lv_implies_9_0=ruleConstraint();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getRuleRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"implies",
                    	    									lv_implies_9_0,
                    	    									"org.xtext.miron.MIRoN.Constraint");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);

                    otherlv_10=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(otherlv_10, grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_5_1_3());
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleCondition"
    // InternalMIRoN.g:1795:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalMIRoN.g:1795:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalMIRoN.g:1796:2: iv_ruleCondition= ruleCondition EOF
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
    // InternalMIRoN.g:1802:1: ruleCondition returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1808:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalMIRoN.g:1809:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalMIRoN.g:1809:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalMIRoN.g:1810:3: (lv_term_0_0= ruleTerm )
            {
            // InternalMIRoN.g:1810:3: (lv_term_0_0= ruleTerm )
            // InternalMIRoN.g:1811:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getConditionAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getConditionRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"org.xtext.roqme.RoQME.Term");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleConstraint"
    // InternalMIRoN.g:1831:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalMIRoN.g:1831:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalMIRoN.g:1832:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
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
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalMIRoN.g:1838:1: ruleConstraint returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1844:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalMIRoN.g:1845:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalMIRoN.g:1845:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalMIRoN.g:1846:3: (lv_term_0_0= ruleTerm )
            {
            // InternalMIRoN.g:1846:3: (lv_term_0_0= ruleTerm )
            // InternalMIRoN.g:1847:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getConstraintAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getConstraintRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"org.xtext.roqme.RoQME.Term");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleContext"
    // InternalMIRoN.g:1867:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalMIRoN.g:1867:48: (iv_ruleContext= ruleContext EOF )
            // InternalMIRoN.g:1868:2: iv_ruleContext= ruleContext EOF
            {
             newCompositeNode(grammarAccess.getContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContext=ruleContext();

            state._fsp--;

             current =iv_ruleContext; 
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
    // $ANTLR end "entryRuleContext"


    // $ANTLR start "ruleContext"
    // InternalMIRoN.g:1874:1: ruleContext returns [EObject current=null] : (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        EObject this_DerivedContext_0 = null;

        EObject this_PrimitiveContext_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1880:2: ( (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext ) )
            // InternalMIRoN.g:1881:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )
            {
            // InternalMIRoN.g:1881:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // InternalMIRoN.g:1882:3: this_DerivedContext_0= ruleDerivedContext
                    {

                    			newCompositeNode(grammarAccess.getContextAccess().getDerivedContextParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DerivedContext_0=ruleDerivedContext();

                    state._fsp--;


                    			current = this_DerivedContext_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:1891:3: this_PrimitiveContext_1= rulePrimitiveContext
                    {

                    			newCompositeNode(grammarAccess.getContextAccess().getPrimitiveContextParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimitiveContext_1=rulePrimitiveContext();

                    state._fsp--;


                    			current = this_PrimitiveContext_1;
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
    // $ANTLR end "ruleContext"


    // $ANTLR start "entryRulePrimitiveContext"
    // InternalMIRoN.g:1903:1: entryRulePrimitiveContext returns [EObject current=null] : iv_rulePrimitiveContext= rulePrimitiveContext EOF ;
    public final EObject entryRulePrimitiveContext() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveContext = null;


        try {
            // InternalMIRoN.g:1903:57: (iv_rulePrimitiveContext= rulePrimitiveContext EOF )
            // InternalMIRoN.g:1904:2: iv_rulePrimitiveContext= rulePrimitiveContext EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveContextRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveContext=rulePrimitiveContext();

            state._fsp--;

             current =iv_rulePrimitiveContext; 
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
    // $ANTLR end "entryRulePrimitiveContext"


    // $ANTLR start "rulePrimitiveContext"
    // InternalMIRoN.g:1910:1: rulePrimitiveContext returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) ) ;
    public final EObject rulePrimitiveContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1916:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) ) )
            // InternalMIRoN.g:1917:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) )
            {
            // InternalMIRoN.g:1917:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) )
            // InternalMIRoN.g:1918:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            {
            // InternalMIRoN.g:1918:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ROQME_DESCRIPTION) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMIRoN.g:1919:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:1919:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:1920:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getPrimitiveContextAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_36);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimitiveContextRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,37,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getPrimitiveContextAccess().getContextKeyword_1());
            		
            // InternalMIRoN.g:1941:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:1942:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:1942:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:1943:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_2_0, grammarAccess.getPrimitiveContextAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveContextRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_25); 

            			newLeafNode(otherlv_3, grammarAccess.getPrimitiveContextAccess().getColonKeyword_3());
            		
            // InternalMIRoN.g:1963:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:1964:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:1964:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:1965:5: lv_declaration_4_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getPrimitiveContextAccess().getDeclarationDataTypeDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_declaration_4_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrimitiveContextRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_4_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
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
    // $ANTLR end "rulePrimitiveContext"


    // $ANTLR start "entryRuleDerivedContext"
    // InternalMIRoN.g:1986:1: entryRuleDerivedContext returns [EObject current=null] : iv_ruleDerivedContext= ruleDerivedContext EOF ;
    public final EObject entryRuleDerivedContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedContext = null;


        try {
            // InternalMIRoN.g:1986:55: (iv_ruleDerivedContext= ruleDerivedContext EOF )
            // InternalMIRoN.g:1987:2: iv_ruleDerivedContext= ruleDerivedContext EOF
            {
             newCompositeNode(grammarAccess.getDerivedContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDerivedContext=ruleDerivedContext();

            state._fsp--;

             current =iv_ruleDerivedContext; 
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
    // $ANTLR end "entryRuleDerivedContext"


    // $ANTLR start "ruleDerivedContext"
    // InternalMIRoN.g:1993:1: ruleDerivedContext returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) ) ;
    public final EObject ruleDerivedContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;

        EObject lv_definition_6_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1999:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) ) )
            // InternalMIRoN.g:2000:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) )
            {
            // InternalMIRoN.g:2000:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) )
            // InternalMIRoN.g:2001:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) )
            {
            // InternalMIRoN.g:2001:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ROQME_DESCRIPTION) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMIRoN.g:2002:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:2002:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:2003:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getDerivedContextAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_36);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDerivedContextRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,37,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getDerivedContextAccess().getContextKeyword_1());
            		
            // InternalMIRoN.g:2024:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:2025:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:2025:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:2026:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_2_0, grammarAccess.getDerivedContextAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDerivedContextRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_25); 

            			newLeafNode(otherlv_3, grammarAccess.getDerivedContextAccess().getColonKeyword_3());
            		
            // InternalMIRoN.g:2046:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:2047:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:2047:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:2048:5: lv_declaration_4_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getDerivedContextAccess().getDeclarationDataTypeDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_37);
            lv_declaration_4_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedContextRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_4_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,38,FOLLOW_34); 

            			newLeafNode(otherlv_5, grammarAccess.getDerivedContextAccess().getColonEqualsSignKeyword_5());
            		
            // InternalMIRoN.g:2069:3: ( (lv_definition_6_0= ruleContextPattern ) )
            // InternalMIRoN.g:2070:4: (lv_definition_6_0= ruleContextPattern )
            {
            // InternalMIRoN.g:2070:4: (lv_definition_6_0= ruleContextPattern )
            // InternalMIRoN.g:2071:5: lv_definition_6_0= ruleContextPattern
            {

            					newCompositeNode(grammarAccess.getDerivedContextAccess().getDefinitionContextPatternParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_definition_6_0=ruleContextPattern();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedContextRule());
            					}
            					set(
            						current,
            						"definition",
            						lv_definition_6_0,
            						"org.xtext.roqme.RoQME.ContextPattern");
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
    // $ANTLR end "ruleDerivedContext"


    // $ANTLR start "entryRuleGeneralPurposeVariable"
    // InternalMIRoN.g:2092:1: entryRuleGeneralPurposeVariable returns [EObject current=null] : iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF ;
    public final EObject entryRuleGeneralPurposeVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralPurposeVariable = null;


        try {
            // InternalMIRoN.g:2092:63: (iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF )
            // InternalMIRoN.g:2093:2: iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF
            {
             newCompositeNode(grammarAccess.getGeneralPurposeVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneralPurposeVariable=ruleGeneralPurposeVariable();

            state._fsp--;

             current =iv_ruleGeneralPurposeVariable; 
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
    // $ANTLR end "entryRuleGeneralPurposeVariable"


    // $ANTLR start "ruleGeneralPurposeVariable"
    // InternalMIRoN.g:2099:1: ruleGeneralPurposeVariable returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) ) ;
    public final EObject ruleGeneralPurposeVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_declaration_3_0 = null;

        EObject lv_definition_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2105:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) ) )
            // InternalMIRoN.g:2106:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) )
            {
            // InternalMIRoN.g:2106:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) )
            // InternalMIRoN.g:2107:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneralPurposeVariableAccess().getVarKeyword_0());
            		
            // InternalMIRoN.g:2111:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:2112:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:2112:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:2113:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGeneralPurposeVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneralPurposeVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getGeneralPurposeVariableAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:2133:3: ( (lv_declaration_3_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:2134:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:2134:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:2135:5: lv_declaration_3_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getGeneralPurposeVariableAccess().getDeclarationDataTypeDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_37);
            lv_declaration_3_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGeneralPurposeVariableRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_3_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:2152:3: (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) )
            // InternalMIRoN.g:2153:4: otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) )
            {
            otherlv_4=(Token)match(input,38,FOLLOW_34); 

            				newLeafNode(otherlv_4, grammarAccess.getGeneralPurposeVariableAccess().getColonEqualsSignKeyword_4_0());
            			
            // InternalMIRoN.g:2157:4: ( (lv_definition_5_0= ruleGeneralExpression ) )
            // InternalMIRoN.g:2158:5: (lv_definition_5_0= ruleGeneralExpression )
            {
            // InternalMIRoN.g:2158:5: (lv_definition_5_0= ruleGeneralExpression )
            // InternalMIRoN.g:2159:6: lv_definition_5_0= ruleGeneralExpression
            {

            						newCompositeNode(grammarAccess.getGeneralPurposeVariableAccess().getDefinitionGeneralExpressionParserRuleCall_4_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_definition_5_0=ruleGeneralExpression();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getGeneralPurposeVariableRule());
            						}
            						set(
            							current,
            							"definition",
            							lv_definition_5_0,
            							"org.xtext.roqme.RoQME.GeneralExpression");
            						afterParserOrEnumRuleCall();
            					

            }


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
    // $ANTLR end "ruleGeneralPurposeVariable"


    // $ANTLR start "entryRuleParameter"
    // InternalMIRoN.g:2181:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMIRoN.g:2181:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMIRoN.g:2182:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalMIRoN.g:2188:1: ruleParameter returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;

        EObject lv_initializedTo_6_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2194:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? ) )
            // InternalMIRoN.g:2195:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? )
            {
            // InternalMIRoN.g:2195:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? )
            // InternalMIRoN.g:2196:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )?
            {
            // InternalMIRoN.g:2196:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ROQME_DESCRIPTION) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMIRoN.g:2197:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:2197:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:2198:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_38);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParameterRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,40,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getParamKeyword_1());
            		
            // InternalMIRoN.g:2219:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:2220:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:2220:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:2221:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_2_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_25); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterAccess().getColonKeyword_3());
            		
            // InternalMIRoN.g:2241:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:2242:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:2242:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:2243:5: lv_declaration_4_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getDeclarationDataTypeDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_39);
            lv_declaration_4_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_4_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:2260:3: (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==41) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMIRoN.g:2261:4: otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) )
                    {
                    otherlv_5=(Token)match(input,41,FOLLOW_40); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getDefaultKeyword_5_0());
                    			
                    // InternalMIRoN.g:2265:4: ( (lv_initializedTo_6_0= ruleTypedValue ) )
                    // InternalMIRoN.g:2266:5: (lv_initializedTo_6_0= ruleTypedValue )
                    {
                    // InternalMIRoN.g:2266:5: (lv_initializedTo_6_0= ruleTypedValue )
                    // InternalMIRoN.g:2267:6: lv_initializedTo_6_0= ruleTypedValue
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getInitializedToTypedValueParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_initializedTo_6_0=ruleTypedValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"initializedTo",
                    							lv_initializedTo_6_0,
                    							"org.xtext.roqme.RoQME.TypedValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTimer"
    // InternalMIRoN.g:2289:1: entryRuleTimer returns [EObject current=null] : iv_ruleTimer= ruleTimer EOF ;
    public final EObject entryRuleTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimer = null;


        try {
            // InternalMIRoN.g:2289:46: (iv_ruleTimer= ruleTimer EOF )
            // InternalMIRoN.g:2290:2: iv_ruleTimer= ruleTimer EOF
            {
             newCompositeNode(grammarAccess.getTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimer=ruleTimer();

            state._fsp--;

             current =iv_ruleTimer; 
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
    // $ANTLR end "entryRuleTimer"


    // $ANTLR start "ruleTimer"
    // InternalMIRoN.g:2296:1: ruleTimer returns [EObject current=null] : (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        Token lv_once_6_0=null;
        Token lv_paused_7_0=null;
        Token otherlv_8=null;
        EObject lv_declaration_2_0 = null;

        EObject lv_offset_5_0 = null;

        EObject lv_definition_9_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2302:2: ( (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) ) )
            // InternalMIRoN.g:2303:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalMIRoN.g:2303:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) )
            // InternalMIRoN.g:2304:3: otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getTimerAccess().getTimerKeyword_0());
            		
            // InternalMIRoN.g:2308:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:2309:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:2309:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:2310:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTimerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMIRoN.g:2326:3: ( (lv_declaration_2_0= ruleInbuiltDeclaration ) )
            // InternalMIRoN.g:2327:4: (lv_declaration_2_0= ruleInbuiltDeclaration )
            {
            // InternalMIRoN.g:2327:4: (lv_declaration_2_0= ruleInbuiltDeclaration )
            // InternalMIRoN.g:2328:5: lv_declaration_2_0= ruleInbuiltDeclaration
            {

            					newCompositeNode(grammarAccess.getTimerAccess().getDeclarationInbuiltDeclarationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_41);
            lv_declaration_2_0=ruleInbuiltDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimerRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_2_0,
            						"org.xtext.roqme.RoQME.InbuiltDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:2345:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) )
            // InternalMIRoN.g:2346:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalMIRoN.g:2346:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) )
            // InternalMIRoN.g:2347:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            				
            // InternalMIRoN.g:2350:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?)
            // InternalMIRoN.g:2351:6: ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?
            {
            // InternalMIRoN.g:2351:6: ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+
            int cnt38=0;
            loop38:
            do {
                int alt38=5;
                int LA38_0 = input.LA(1);

                if ( LA38_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0) ) {
                    alt38=1;
                }
                else if ( LA38_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1) ) {
                    alt38=2;
                }
                else if ( LA38_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2) ) {
                    alt38=3;
                }
                else if ( LA38_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3) ) {
                    alt38=4;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalMIRoN.g:2352:4: ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2352:4: ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalMIRoN.g:2353:5: {...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalMIRoN.g:2353:102: ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) )
            	    // InternalMIRoN.g:2354:6: ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalMIRoN.g:2357:9: ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) )
            	    // InternalMIRoN.g:2357:10: {...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalMIRoN.g:2357:19: (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) )
            	    // InternalMIRoN.g:2357:20: otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) )
            	    {
            	    otherlv_4=(Token)match(input,43,FOLLOW_12); 

            	    									newLeafNode(otherlv_4, grammarAccess.getTimerAccess().getOffsetKeyword_3_0_0());
            	    								
            	    // InternalMIRoN.g:2361:9: ( (lv_offset_5_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:2362:10: (lv_offset_5_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:2362:10: (lv_offset_5_0= ruleTimeValue )
            	    // InternalMIRoN.g:2363:11: lv_offset_5_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getTimerAccess().getOffsetTimeValueParserRuleCall_3_0_1_0());
            	    										
            	    pushFollow(FOLLOW_42);
            	    lv_offset_5_0=ruleTimeValue();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTimerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"offset",
            	    												lv_offset_5_0,
            	    												"org.xtext.roqme.RoQME.TimeValue");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMIRoN.g:2386:4: ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2386:4: ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) )
            	    // InternalMIRoN.g:2387:5: {...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalMIRoN.g:2387:102: ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) )
            	    // InternalMIRoN.g:2388:6: ({...}? => ( (lv_once_6_0= 'onetime' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalMIRoN.g:2391:9: ({...}? => ( (lv_once_6_0= 'onetime' ) ) )
            	    // InternalMIRoN.g:2391:10: {...}? => ( (lv_once_6_0= 'onetime' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalMIRoN.g:2391:19: ( (lv_once_6_0= 'onetime' ) )
            	    // InternalMIRoN.g:2391:20: (lv_once_6_0= 'onetime' )
            	    {
            	    // InternalMIRoN.g:2391:20: (lv_once_6_0= 'onetime' )
            	    // InternalMIRoN.g:2392:10: lv_once_6_0= 'onetime'
            	    {
            	    lv_once_6_0=(Token)match(input,44,FOLLOW_42); 

            	    										newLeafNode(lv_once_6_0, grammarAccess.getTimerAccess().getOnceOnetimeKeyword_3_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getTimerRule());
            	    										}
            	    										setWithLastConsumed(current, "once", true, "onetime");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMIRoN.g:2409:4: ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2409:4: ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) )
            	    // InternalMIRoN.g:2410:5: {...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalMIRoN.g:2410:102: ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) )
            	    // InternalMIRoN.g:2411:6: ({...}? => ( (lv_paused_7_0= 'paused' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalMIRoN.g:2414:9: ({...}? => ( (lv_paused_7_0= 'paused' ) ) )
            	    // InternalMIRoN.g:2414:10: {...}? => ( (lv_paused_7_0= 'paused' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalMIRoN.g:2414:19: ( (lv_paused_7_0= 'paused' ) )
            	    // InternalMIRoN.g:2414:20: (lv_paused_7_0= 'paused' )
            	    {
            	    // InternalMIRoN.g:2414:20: (lv_paused_7_0= 'paused' )
            	    // InternalMIRoN.g:2415:10: lv_paused_7_0= 'paused'
            	    {
            	    lv_paused_7_0=(Token)match(input,45,FOLLOW_42); 

            	    										newLeafNode(lv_paused_7_0, grammarAccess.getTimerAccess().getPausedPausedKeyword_3_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getTimerRule());
            	    										}
            	    										setWithLastConsumed(current, "paused", true, "paused");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalMIRoN.g:2432:4: ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2432:4: ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) )
            	    // InternalMIRoN.g:2433:5: {...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalMIRoN.g:2433:102: ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) )
            	    // InternalMIRoN.g:2434:6: ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalMIRoN.g:2437:9: ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) )
            	    // InternalMIRoN.g:2437:10: {...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalMIRoN.g:2437:19: (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) )
            	    // InternalMIRoN.g:2437:20: otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) )
            	    {
            	    otherlv_8=(Token)match(input,38,FOLLOW_34); 

            	    									newLeafNode(otherlv_8, grammarAccess.getTimerAccess().getColonEqualsSignKeyword_3_3_0());
            	    								
            	    // InternalMIRoN.g:2441:9: ( (lv_definition_9_0= ruleGeneralExpression ) )
            	    // InternalMIRoN.g:2442:10: (lv_definition_9_0= ruleGeneralExpression )
            	    {
            	    // InternalMIRoN.g:2442:10: (lv_definition_9_0= ruleGeneralExpression )
            	    // InternalMIRoN.g:2443:11: lv_definition_9_0= ruleGeneralExpression
            	    {

            	    											newCompositeNode(grammarAccess.getTimerAccess().getDefinitionGeneralExpressionParserRuleCall_3_3_1_0());
            	    										
            	    pushFollow(FOLLOW_42);
            	    lv_definition_9_0=ruleGeneralExpression();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTimerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"definition",
            	    												lv_definition_9_0,
            	    												"org.xtext.roqme.RoQME.GeneralExpression");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTimerAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canLeave(grammarAccess.getTimerAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            				

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
    // $ANTLR end "ruleTimer"


    // $ANTLR start "entryRuleBeliefVariable"
    // InternalMIRoN.g:2478:1: entryRuleBeliefVariable returns [EObject current=null] : iv_ruleBeliefVariable= ruleBeliefVariable EOF ;
    public final EObject entryRuleBeliefVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefVariable = null;


        try {
            // InternalMIRoN.g:2478:55: (iv_ruleBeliefVariable= ruleBeliefVariable EOF )
            // InternalMIRoN.g:2479:2: iv_ruleBeliefVariable= ruleBeliefVariable EOF
            {
             newCompositeNode(grammarAccess.getBeliefVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeliefVariable=ruleBeliefVariable();

            state._fsp--;

             current =iv_ruleBeliefVariable; 
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
    // $ANTLR end "entryRuleBeliefVariable"


    // $ANTLR start "ruleBeliefVariable"
    // InternalMIRoN.g:2485:1: ruleBeliefVariable returns [EObject current=null] : (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty ) ;
    public final EObject ruleBeliefVariable() throws RecognitionException {
        EObject current = null;

        EObject this_BeliefVariableImpl_0 = null;

        EObject this_Property_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2491:2: ( (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty ) )
            // InternalMIRoN.g:2492:2: (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty )
            {
            // InternalMIRoN.g:2492:2: (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty )
            int alt39=2;
            switch ( input.LA(1) ) {
            case RULE_ROQME_DESCRIPTION:
                {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==49) ) {
                    alt39=2;
                }
                else if ( (LA39_1==46) ) {
                    alt39=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                alt39=1;
                }
                break;
            case 49:
                {
                alt39=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalMIRoN.g:2493:3: this_BeliefVariableImpl_0= ruleBeliefVariableImpl
                    {

                    			newCompositeNode(grammarAccess.getBeliefVariableAccess().getBeliefVariableImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BeliefVariableImpl_0=ruleBeliefVariableImpl();

                    state._fsp--;


                    			current = this_BeliefVariableImpl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:2502:3: this_Property_1= ruleProperty
                    {

                    			newCompositeNode(grammarAccess.getBeliefVariableAccess().getPropertyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Property_1=ruleProperty();

                    state._fsp--;


                    			current = this_Property_1;
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
    // $ANTLR end "ruleBeliefVariable"


    // $ANTLR start "entryRuleBeliefVariableImpl"
    // InternalMIRoN.g:2514:1: entryRuleBeliefVariableImpl returns [EObject current=null] : iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF ;
    public final EObject entryRuleBeliefVariableImpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefVariableImpl = null;


        try {
            // InternalMIRoN.g:2514:59: (iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF )
            // InternalMIRoN.g:2515:2: iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF
            {
             newCompositeNode(grammarAccess.getBeliefVariableImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeliefVariableImpl=ruleBeliefVariableImpl();

            state._fsp--;

             current =iv_ruleBeliefVariableImpl; 
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
    // $ANTLR end "entryRuleBeliefVariableImpl"


    // $ANTLR start "ruleBeliefVariableImpl"
    // InternalMIRoN.g:2521:1: ruleBeliefVariableImpl returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleBeliefVariableImpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_3_0 = null;

        AntlrDatatypeRuleToken lv_reference_6_0 = null;

        EObject lv_survival_8_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2527:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalMIRoN.g:2528:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalMIRoN.g:2528:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalMIRoN.g:2529:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalMIRoN.g:2529:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ROQME_DESCRIPTION) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalMIRoN.g:2530:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:2530:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:2531:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_43);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBeliefVariableImplRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,46,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getBeliefVariableImplAccess().getBeliefvarKeyword_1());
            		
            // InternalMIRoN.g:2552:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:2553:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:2553:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:2554:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_44); 

            					newLeafNode(lv_name_2_0, grammarAccess.getBeliefVariableImplAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBeliefVariableImplRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMIRoN.g:2570:3: ( (lv_declaration_3_0= ruleInbuiltDeclaration ) )
            // InternalMIRoN.g:2571:4: (lv_declaration_3_0= ruleInbuiltDeclaration )
            {
            // InternalMIRoN.g:2571:4: (lv_declaration_3_0= ruleInbuiltDeclaration )
            // InternalMIRoN.g:2572:5: lv_declaration_3_0= ruleInbuiltDeclaration
            {

            					newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getDeclarationInbuiltDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_45);
            lv_declaration_3_0=ruleInbuiltDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBeliefVariableImplRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_3_0,
            						"org.xtext.roqme.RoQME.InbuiltDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:2589:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalMIRoN.g:2590:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalMIRoN.g:2590:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalMIRoN.g:2591:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            				
            // InternalMIRoN.g:2594:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalMIRoN.g:2595:6: ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalMIRoN.g:2595:6: ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )*
            loop41:
            do {
                int alt41=3;
                int LA41_0 = input.LA(1);

                if ( LA41_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0) ) {
                    alt41=1;
                }
                else if ( LA41_0 == 48 && getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1) ) {
                    alt41=2;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalMIRoN.g:2596:4: ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2596:4: ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) )
            	    // InternalMIRoN.g:2597:5: {...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalMIRoN.g:2597:115: ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) )
            	    // InternalMIRoN.g:2598:6: ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalMIRoN.g:2601:9: ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) )
            	    // InternalMIRoN.g:2601:10: {...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "true");
            	    }
            	    // InternalMIRoN.g:2601:19: (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) )
            	    // InternalMIRoN.g:2601:20: otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) )
            	    {
            	    otherlv_5=(Token)match(input,47,FOLLOW_12); 

            	    									newLeafNode(otherlv_5, grammarAccess.getBeliefVariableImplAccess().getReferenceKeyword_4_0_0());
            	    								
            	    // InternalMIRoN.g:2605:9: ( (lv_reference_6_0= ruleEDouble ) )
            	    // InternalMIRoN.g:2606:10: (lv_reference_6_0= ruleEDouble )
            	    {
            	    // InternalMIRoN.g:2606:10: (lv_reference_6_0= ruleEDouble )
            	    // InternalMIRoN.g:2607:11: lv_reference_6_0= ruleEDouble
            	    {

            	    											newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getReferenceEDoubleParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_45);
            	    lv_reference_6_0=ruleEDouble();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getBeliefVariableImplRule());
            	    											}
            	    											set(
            	    												current,
            	    												"reference",
            	    												lv_reference_6_0,
            	    												"org.xtext.roqme.RoQME.EDouble");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMIRoN.g:2630:4: ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2630:4: ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalMIRoN.g:2631:5: {...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalMIRoN.g:2631:115: ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) )
            	    // InternalMIRoN.g:2632:6: ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalMIRoN.g:2635:9: ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) )
            	    // InternalMIRoN.g:2635:10: {...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "true");
            	    }
            	    // InternalMIRoN.g:2635:19: (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) )
            	    // InternalMIRoN.g:2635:20: otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) )
            	    {
            	    otherlv_7=(Token)match(input,48,FOLLOW_12); 

            	    									newLeafNode(otherlv_7, grammarAccess.getBeliefVariableImplAccess().getSurvivalKeyword_4_1_0());
            	    								
            	    // InternalMIRoN.g:2639:9: ( (lv_survival_8_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:2640:10: (lv_survival_8_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:2640:10: (lv_survival_8_0= ruleTimeValue )
            	    // InternalMIRoN.g:2641:11: lv_survival_8_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getSurvivalTimeValueParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_45);
            	    lv_survival_8_0=ruleTimeValue();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getBeliefVariableImplRule());
            	    											}
            	    											set(
            	    												current,
            	    												"survival",
            	    												lv_survival_8_0,
            	    												"org.xtext.roqme.RoQME.TimeValue");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            				

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
    // $ANTLR end "ruleBeliefVariableImpl"


    // $ANTLR start "entryRuleProperty"
    // InternalMIRoN.g:2675:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalMIRoN.g:2675:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalMIRoN.g:2676:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalMIRoN.g:2682:1: ruleProperty returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;

        EObject lv_transformation_6_0 = null;

        EObject lv_declaration_7_0 = null;

        AntlrDatatypeRuleToken lv_reference_10_0 = null;

        EObject lv_survival_12_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2688:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalMIRoN.g:2689:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalMIRoN.g:2689:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalMIRoN.g:2690:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalMIRoN.g:2690:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ROQME_DESCRIPTION) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMIRoN.g:2691:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:2691:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:2692:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getPropertyAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_46);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPropertyRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,49,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getPropertyKeyword_1());
            		
            // InternalMIRoN.g:2713:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:2714:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:2714:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:2715:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(lv_name_2_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMIRoN.g:2731:3: ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==20) ) {
                alt43=1;
            }
            else if ( (LA43_0==EOF||LA43_0==RULE_ROQME_DESCRIPTION||(LA43_0>=28 && LA43_0<=29)||LA43_0==35||(LA43_0>=37 && LA43_0<=50)||LA43_0==56||(LA43_0>=107 && LA43_0<=108)) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalMIRoN.g:2732:4: (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) )
                    {
                    // InternalMIRoN.g:2732:4: (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) )
                    // InternalMIRoN.g:2733:5: otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) )
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_25); 

                    					newLeafNode(otherlv_3, grammarAccess.getPropertyAccess().getColonKeyword_3_0_0());
                    				
                    // InternalMIRoN.g:2737:5: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
                    // InternalMIRoN.g:2738:6: (lv_declaration_4_0= ruleDataTypeDeclaration )
                    {
                    // InternalMIRoN.g:2738:6: (lv_declaration_4_0= ruleDataTypeDeclaration )
                    // InternalMIRoN.g:2739:7: lv_declaration_4_0= ruleDataTypeDeclaration
                    {

                    							newCompositeNode(grammarAccess.getPropertyAccess().getDeclarationDataTypeDeclarationParserRuleCall_3_0_1_0());
                    						
                    pushFollow(FOLLOW_37);
                    lv_declaration_4_0=ruleDataTypeDeclaration();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPropertyRule());
                    							}
                    							set(
                    								current,
                    								"declaration",
                    								lv_declaration_4_0,
                    								"org.xtext.roqme.RoQME.DataTypeDeclaration");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,38,FOLLOW_34); 

                    					newLeafNode(otherlv_5, grammarAccess.getPropertyAccess().getColonEqualsSignKeyword_3_0_2());
                    				
                    // InternalMIRoN.g:2760:5: ( (lv_transformation_6_0= ruleOutputTransformation ) )
                    // InternalMIRoN.g:2761:6: (lv_transformation_6_0= ruleOutputTransformation )
                    {
                    // InternalMIRoN.g:2761:6: (lv_transformation_6_0= ruleOutputTransformation )
                    // InternalMIRoN.g:2762:7: lv_transformation_6_0= ruleOutputTransformation
                    {

                    							newCompositeNode(grammarAccess.getPropertyAccess().getTransformationOutputTransformationParserRuleCall_3_0_3_0());
                    						
                    pushFollow(FOLLOW_45);
                    lv_transformation_6_0=ruleOutputTransformation();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPropertyRule());
                    							}
                    							set(
                    								current,
                    								"transformation",
                    								lv_transformation_6_0,
                    								"org.xtext.roqme.RoQME.OutputTransformation");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:2781:4: ( (lv_declaration_7_0= ruleInbuiltDeclaration ) )
                    {
                    // InternalMIRoN.g:2781:4: ( (lv_declaration_7_0= ruleInbuiltDeclaration ) )
                    // InternalMIRoN.g:2782:5: (lv_declaration_7_0= ruleInbuiltDeclaration )
                    {
                    // InternalMIRoN.g:2782:5: (lv_declaration_7_0= ruleInbuiltDeclaration )
                    // InternalMIRoN.g:2783:6: lv_declaration_7_0= ruleInbuiltDeclaration
                    {

                    						newCompositeNode(grammarAccess.getPropertyAccess().getDeclarationInbuiltDeclarationParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_declaration_7_0=ruleInbuiltDeclaration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPropertyRule());
                    						}
                    						set(
                    							current,
                    							"declaration",
                    							lv_declaration_7_0,
                    							"org.xtext.roqme.RoQME.InbuiltDeclaration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMIRoN.g:2801:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalMIRoN.g:2802:4: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalMIRoN.g:2802:4: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalMIRoN.g:2803:5: ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            				
            // InternalMIRoN.g:2806:5: ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalMIRoN.g:2807:6: ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalMIRoN.g:2807:6: ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )*
            loop44:
            do {
                int alt44=3;
                int LA44_0 = input.LA(1);

                if ( LA44_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0) ) {
                    alt44=1;
                }
                else if ( LA44_0 == 48 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1) ) {
                    alt44=2;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalMIRoN.g:2808:4: ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2808:4: ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) )
            	    // InternalMIRoN.g:2809:5: {...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalMIRoN.g:2809:105: ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) )
            	    // InternalMIRoN.g:2810:6: ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalMIRoN.g:2813:9: ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) )
            	    // InternalMIRoN.g:2813:10: {...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalMIRoN.g:2813:19: (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) )
            	    // InternalMIRoN.g:2813:20: otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) )
            	    {
            	    otherlv_9=(Token)match(input,47,FOLLOW_12); 

            	    									newLeafNode(otherlv_9, grammarAccess.getPropertyAccess().getReferenceKeyword_4_0_0());
            	    								
            	    // InternalMIRoN.g:2817:9: ( (lv_reference_10_0= ruleEDouble ) )
            	    // InternalMIRoN.g:2818:10: (lv_reference_10_0= ruleEDouble )
            	    {
            	    // InternalMIRoN.g:2818:10: (lv_reference_10_0= ruleEDouble )
            	    // InternalMIRoN.g:2819:11: lv_reference_10_0= ruleEDouble
            	    {

            	    											newCompositeNode(grammarAccess.getPropertyAccess().getReferenceEDoubleParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_45);
            	    lv_reference_10_0=ruleEDouble();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPropertyRule());
            	    											}
            	    											set(
            	    												current,
            	    												"reference",
            	    												lv_reference_10_0,
            	    												"org.xtext.roqme.RoQME.EDouble");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMIRoN.g:2842:4: ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2842:4: ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalMIRoN.g:2843:5: {...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalMIRoN.g:2843:105: ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) )
            	    // InternalMIRoN.g:2844:6: ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalMIRoN.g:2847:9: ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) )
            	    // InternalMIRoN.g:2847:10: {...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalMIRoN.g:2847:19: (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) )
            	    // InternalMIRoN.g:2847:20: otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) )
            	    {
            	    otherlv_11=(Token)match(input,48,FOLLOW_12); 

            	    									newLeafNode(otherlv_11, grammarAccess.getPropertyAccess().getSurvivalKeyword_4_1_0());
            	    								
            	    // InternalMIRoN.g:2851:9: ( (lv_survival_12_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:2852:10: (lv_survival_12_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:2852:10: (lv_survival_12_0= ruleTimeValue )
            	    // InternalMIRoN.g:2853:11: lv_survival_12_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getPropertyAccess().getSurvivalTimeValueParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_45);
            	    lv_survival_12_0=ruleTimeValue();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPropertyRule());
            	    											}
            	    											set(
            	    												current,
            	    												"survival",
            	    												lv_survival_12_0,
            	    												"org.xtext.roqme.RoQME.TimeValue");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            				

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleObservation"
    // InternalMIRoN.g:2887:1: entryRuleObservation returns [EObject current=null] : iv_ruleObservation= ruleObservation EOF ;
    public final EObject entryRuleObservation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObservation = null;


        try {
            // InternalMIRoN.g:2887:52: (iv_ruleObservation= ruleObservation EOF )
            // InternalMIRoN.g:2888:2: iv_ruleObservation= ruleObservation EOF
            {
             newCompositeNode(grammarAccess.getObservationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObservation=ruleObservation();

            state._fsp--;

             current =iv_ruleObservation; 
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
    // $ANTLR end "entryRuleObservation"


    // $ANTLR start "ruleObservation"
    // InternalMIRoN.g:2894:1: ruleObservation returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) ) ;
    public final EObject ruleObservation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_pattern_4_0 = null;

        EObject lv_actions_5_0 = null;

        EObject lv_actions_7_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2900:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) ) )
            // InternalMIRoN.g:2901:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) )
            {
            // InternalMIRoN.g:2901:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) )
            // InternalMIRoN.g:2902:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) )
            {
            // InternalMIRoN.g:2902:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ROQME_DESCRIPTION) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMIRoN.g:2903:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:2903:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:2904:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getObservationAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_48);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getObservationRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,50,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getObservationAccess().getObservationKeyword_1());
            		
            // InternalMIRoN.g:2925:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:2926:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:2926:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:2927:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_2_0, grammarAccess.getObservationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObservationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_34); 

            			newLeafNode(otherlv_3, grammarAccess.getObservationAccess().getColonKeyword_3());
            		
            // InternalMIRoN.g:2947:3: ( (lv_pattern_4_0= ruleContextPattern ) )
            // InternalMIRoN.g:2948:4: (lv_pattern_4_0= ruleContextPattern )
            {
            // InternalMIRoN.g:2948:4: (lv_pattern_4_0= ruleContextPattern )
            // InternalMIRoN.g:2949:5: lv_pattern_4_0= ruleContextPattern
            {

            					newCompositeNode(grammarAccess.getObservationAccess().getPatternContextPatternParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_49);
            lv_pattern_4_0=ruleContextPattern();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObservationRule());
            					}
            					set(
            						current,
            						"pattern",
            						lv_pattern_4_0,
            						"org.xtext.roqme.RoQME.ContextPattern");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:2966:3: ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=51 && LA47_0<=55)||(LA47_0>=109 && LA47_0<=110)) ) {
                alt47=1;
            }
            else if ( (LA47_0==22) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalMIRoN.g:2967:4: ( (lv_actions_5_0= ruleAction ) )
                    {
                    // InternalMIRoN.g:2967:4: ( (lv_actions_5_0= ruleAction ) )
                    // InternalMIRoN.g:2968:5: (lv_actions_5_0= ruleAction )
                    {
                    // InternalMIRoN.g:2968:5: (lv_actions_5_0= ruleAction )
                    // InternalMIRoN.g:2969:6: lv_actions_5_0= ruleAction
                    {

                    						newCompositeNode(grammarAccess.getObservationAccess().getActionsActionParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_actions_5_0=ruleAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObservationRule());
                    						}
                    						add(
                    							current,
                    							"actions",
                    							lv_actions_5_0,
                    							"org.xtext.roqme.RoQME.Action");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:2987:4: (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' )
                    {
                    // InternalMIRoN.g:2987:4: (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' )
                    // InternalMIRoN.g:2988:5: otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_50); 

                    					newLeafNode(otherlv_6, grammarAccess.getObservationAccess().getLeftCurlyBracketKeyword_5_1_0());
                    				
                    // InternalMIRoN.g:2992:5: ( (lv_actions_7_0= ruleAction ) )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( ((LA46_0>=51 && LA46_0<=55)||(LA46_0>=109 && LA46_0<=110)) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalMIRoN.g:2993:6: (lv_actions_7_0= ruleAction )
                    	    {
                    	    // InternalMIRoN.g:2993:6: (lv_actions_7_0= ruleAction )
                    	    // InternalMIRoN.g:2994:7: lv_actions_7_0= ruleAction
                    	    {

                    	    							newCompositeNode(grammarAccess.getObservationAccess().getActionsActionParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
                    	    lv_actions_7_0=ruleAction();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getObservationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"actions",
                    	    								lv_actions_7_0,
                    	    								"org.xtext.roqme.RoQME.Action");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);

                    otherlv_8=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getObservationAccess().getRightCurlyBracketKeyword_5_1_2());
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleObservation"


    // $ANTLR start "entryRuleAction"
    // InternalMIRoN.g:3021:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalMIRoN.g:3021:47: (iv_ruleAction= ruleAction EOF )
            // InternalMIRoN.g:3022:2: iv_ruleAction= ruleAction EOF
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
    // InternalMIRoN.g:3028:1: ruleAction returns [EObject current=null] : (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_SetVariable_0 = null;

        EObject this_ClearEvidence_1 = null;

        EObject this_SetEvidence_2 = null;

        EObject this_TimerAction_3 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3034:2: ( (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction ) )
            // InternalMIRoN.g:3035:2: (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction )
            {
            // InternalMIRoN.g:3035:2: (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction )
            int alt48=4;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt48=1;
                }
                break;
            case 52:
                {
                alt48=2;
                }
                break;
            case 109:
            case 110:
                {
                alt48=3;
                }
                break;
            case 53:
            case 54:
            case 55:
                {
                alt48=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalMIRoN.g:3036:3: this_SetVariable_0= ruleSetVariable
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getSetVariableParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetVariable_0=ruleSetVariable();

                    state._fsp--;


                    			current = this_SetVariable_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:3045:3: this_ClearEvidence_1= ruleClearEvidence
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getClearEvidenceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ClearEvidence_1=ruleClearEvidence();

                    state._fsp--;


                    			current = this_ClearEvidence_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:3054:3: this_SetEvidence_2= ruleSetEvidence
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getSetEvidenceParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetEvidence_2=ruleSetEvidence();

                    state._fsp--;


                    			current = this_SetEvidence_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:3063:3: this_TimerAction_3= ruleTimerAction
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getTimerActionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimerAction_3=ruleTimerAction();

                    state._fsp--;


                    			current = this_TimerAction_3;
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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleTimerAction"
    // InternalMIRoN.g:3075:1: entryRuleTimerAction returns [EObject current=null] : iv_ruleTimerAction= ruleTimerAction EOF ;
    public final EObject entryRuleTimerAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimerAction = null;


        try {
            // InternalMIRoN.g:3075:52: (iv_ruleTimerAction= ruleTimerAction EOF )
            // InternalMIRoN.g:3076:2: iv_ruleTimerAction= ruleTimerAction EOF
            {
             newCompositeNode(grammarAccess.getTimerActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimerAction=ruleTimerAction();

            state._fsp--;

             current =iv_ruleTimerAction; 
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
    // $ANTLR end "entryRuleTimerAction"


    // $ANTLR start "ruleTimerAction"
    // InternalMIRoN.g:3082:1: ruleTimerAction returns [EObject current=null] : (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer ) ;
    public final EObject ruleTimerAction() throws RecognitionException {
        EObject current = null;

        EObject this_StartTimer_0 = null;

        EObject this_StopTimer_1 = null;

        EObject this_ResumeTimer_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3088:2: ( (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer ) )
            // InternalMIRoN.g:3089:2: (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer )
            {
            // InternalMIRoN.g:3089:2: (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer )
            int alt49=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt49=1;
                }
                break;
            case 54:
                {
                alt49=2;
                }
                break;
            case 55:
                {
                alt49=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalMIRoN.g:3090:3: this_StartTimer_0= ruleStartTimer
                    {

                    			newCompositeNode(grammarAccess.getTimerActionAccess().getStartTimerParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StartTimer_0=ruleStartTimer();

                    state._fsp--;


                    			current = this_StartTimer_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:3099:3: this_StopTimer_1= ruleStopTimer
                    {

                    			newCompositeNode(grammarAccess.getTimerActionAccess().getStopTimerParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StopTimer_1=ruleStopTimer();

                    state._fsp--;


                    			current = this_StopTimer_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:3108:3: this_ResumeTimer_2= ruleResumeTimer
                    {

                    			newCompositeNode(grammarAccess.getTimerActionAccess().getResumeTimerParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ResumeTimer_2=ruleResumeTimer();

                    state._fsp--;


                    			current = this_ResumeTimer_2;
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
    // $ANTLR end "ruleTimerAction"


    // $ANTLR start "entryRuleSetVariable"
    // InternalMIRoN.g:3120:1: entryRuleSetVariable returns [EObject current=null] : iv_ruleSetVariable= ruleSetVariable EOF ;
    public final EObject entryRuleSetVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetVariable = null;


        try {
            // InternalMIRoN.g:3120:52: (iv_ruleSetVariable= ruleSetVariable EOF )
            // InternalMIRoN.g:3121:2: iv_ruleSetVariable= ruleSetVariable EOF
            {
             newCompositeNode(grammarAccess.getSetVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetVariable=ruleSetVariable();

            state._fsp--;

             current =iv_ruleSetVariable; 
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
    // $ANTLR end "entryRuleSetVariable"


    // $ANTLR start "ruleSetVariable"
    // InternalMIRoN.g:3127:1: ruleSetVariable returns [EObject current=null] : (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) ) ;
    public final EObject ruleSetVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3133:2: ( (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) ) )
            // InternalMIRoN.g:3134:2: (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) )
            {
            // InternalMIRoN.g:3134:2: (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) )
            // InternalMIRoN.g:3135:3: otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getSetVariableAccess().getSetsKeyword_0());
            		
            // InternalMIRoN.g:3139:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:3140:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:3140:4: ( ruleQualifiedName )
            // InternalMIRoN.g:3141:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetVariableRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSetVariableAccess().getVariableTypedVariableCrossReference_1_0());
            				
            pushFollow(FOLLOW_37);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getSetVariableAccess().getColonEqualsSignKeyword_2());
            		
            // InternalMIRoN.g:3159:3: ( (lv_expression_3_0= ruleGeneralExpression ) )
            // InternalMIRoN.g:3160:4: (lv_expression_3_0= ruleGeneralExpression )
            {
            // InternalMIRoN.g:3160:4: (lv_expression_3_0= ruleGeneralExpression )
            // InternalMIRoN.g:3161:5: lv_expression_3_0= ruleGeneralExpression
            {

            					newCompositeNode(grammarAccess.getSetVariableAccess().getExpressionGeneralExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_3_0=ruleGeneralExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSetVariableRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.roqme.RoQME.GeneralExpression");
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
    // $ANTLR end "ruleSetVariable"


    // $ANTLR start "entryRuleClearEvidence"
    // InternalMIRoN.g:3182:1: entryRuleClearEvidence returns [EObject current=null] : iv_ruleClearEvidence= ruleClearEvidence EOF ;
    public final EObject entryRuleClearEvidence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClearEvidence = null;


        try {
            // InternalMIRoN.g:3182:54: (iv_ruleClearEvidence= ruleClearEvidence EOF )
            // InternalMIRoN.g:3183:2: iv_ruleClearEvidence= ruleClearEvidence EOF
            {
             newCompositeNode(grammarAccess.getClearEvidenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClearEvidence=ruleClearEvidence();

            state._fsp--;

             current =iv_ruleClearEvidence; 
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
    // $ANTLR end "entryRuleClearEvidence"


    // $ANTLR start "ruleClearEvidence"
    // InternalMIRoN.g:3189:1: ruleClearEvidence returns [EObject current=null] : (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleClearEvidence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3195:2: ( (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) ) )
            // InternalMIRoN.g:3196:2: (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) )
            {
            // InternalMIRoN.g:3196:2: (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:3197:3: otherlv_0= 'clears' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getClearEvidenceAccess().getClearsKeyword_0());
            		
            // InternalMIRoN.g:3201:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:3202:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:3202:4: ( ruleQualifiedName )
            // InternalMIRoN.g:3203:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClearEvidenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClearEvidenceAccess().getTargetBeliefVariableCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleClearEvidence"


    // $ANTLR start "entryRuleSetEvidence"
    // InternalMIRoN.g:3221:1: entryRuleSetEvidence returns [EObject current=null] : iv_ruleSetEvidence= ruleSetEvidence EOF ;
    public final EObject entryRuleSetEvidence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetEvidence = null;


        try {
            // InternalMIRoN.g:3221:52: (iv_ruleSetEvidence= ruleSetEvidence EOF )
            // InternalMIRoN.g:3222:2: iv_ruleSetEvidence= ruleSetEvidence EOF
            {
             newCompositeNode(grammarAccess.getSetEvidenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetEvidence=ruleSetEvidence();

            state._fsp--;

             current =iv_ruleSetEvidence; 
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
    // $ANTLR end "entryRuleSetEvidence"


    // $ANTLR start "ruleSetEvidence"
    // InternalMIRoN.g:3228:1: ruleSetEvidence returns [EObject current=null] : ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleSetEvidence() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Enumerator lv_influence_0_0 = null;

        Enumerator lv_strength_3_0 = null;

        EObject lv_survival_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3234:2: ( ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalMIRoN.g:3235:2: ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalMIRoN.g:3235:2: ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalMIRoN.g:3236:3: ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalMIRoN.g:3236:3: ( (lv_influence_0_0= ruleInfluenceEnum ) )
            // InternalMIRoN.g:3237:4: (lv_influence_0_0= ruleInfluenceEnum )
            {
            // InternalMIRoN.g:3237:4: (lv_influence_0_0= ruleInfluenceEnum )
            // InternalMIRoN.g:3238:5: lv_influence_0_0= ruleInfluenceEnum
            {

            					newCompositeNode(grammarAccess.getSetEvidenceAccess().getInfluenceInfluenceEnumEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_19);
            lv_influence_0_0=ruleInfluenceEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSetEvidenceRule());
            					}
            					set(
            						current,
            						"influence",
            						lv_influence_0_0,
            						"org.xtext.roqme.RoQME.InfluenceEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:3255:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:3256:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:3256:4: ( ruleQualifiedName )
            // InternalMIRoN.g:3257:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetEvidenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSetEvidenceAccess().getTargetBeliefVariableCrossReference_1_0());
            				
            pushFollow(FOLLOW_52);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:3271:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalMIRoN.g:3272:4: ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalMIRoN.g:3272:4: ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalMIRoN.g:3273:5: ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            				
            // InternalMIRoN.g:3276:5: ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalMIRoN.g:3277:6: ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalMIRoN.g:3277:6: ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )*
            loop50:
            do {
                int alt50=3;
                int LA50_0 = input.LA(1);

                if ( LA50_0 >= 111 && LA50_0 <= 115 && getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0) ) {
                    alt50=1;
                }
                else if ( LA50_0 == 48 && getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1) ) {
                    alt50=2;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalMIRoN.g:3278:4: ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:3278:4: ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) )
            	    // InternalMIRoN.g:3279:5: {...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalMIRoN.g:3279:108: ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) )
            	    // InternalMIRoN.g:3280:6: ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalMIRoN.g:3283:9: ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) )
            	    // InternalMIRoN.g:3283:10: {...}? => ( (lv_strength_3_0= ruleStrengthEnum ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "true");
            	    }
            	    // InternalMIRoN.g:3283:19: ( (lv_strength_3_0= ruleStrengthEnum ) )
            	    // InternalMIRoN.g:3283:20: (lv_strength_3_0= ruleStrengthEnum )
            	    {
            	    // InternalMIRoN.g:3283:20: (lv_strength_3_0= ruleStrengthEnum )
            	    // InternalMIRoN.g:3284:10: lv_strength_3_0= ruleStrengthEnum
            	    {

            	    										newCompositeNode(grammarAccess.getSetEvidenceAccess().getStrengthStrengthEnumEnumRuleCall_2_0_0());
            	    									
            	    pushFollow(FOLLOW_52);
            	    lv_strength_3_0=ruleStrengthEnum();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getSetEvidenceRule());
            	    										}
            	    										set(
            	    											current,
            	    											"strength",
            	    											lv_strength_3_0,
            	    											"org.xtext.roqme.RoQME.StrengthEnum");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMIRoN.g:3306:4: ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:3306:4: ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalMIRoN.g:3307:5: {...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalMIRoN.g:3307:108: ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) )
            	    // InternalMIRoN.g:3308:6: ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalMIRoN.g:3311:9: ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) )
            	    // InternalMIRoN.g:3311:10: {...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "true");
            	    }
            	    // InternalMIRoN.g:3311:19: (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) )
            	    // InternalMIRoN.g:3311:20: otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) )
            	    {
            	    otherlv_4=(Token)match(input,48,FOLLOW_12); 

            	    									newLeafNode(otherlv_4, grammarAccess.getSetEvidenceAccess().getSurvivalKeyword_2_1_0());
            	    								
            	    // InternalMIRoN.g:3315:9: ( (lv_survival_5_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:3316:10: (lv_survival_5_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:3316:10: (lv_survival_5_0= ruleTimeValue )
            	    // InternalMIRoN.g:3317:11: lv_survival_5_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getSetEvidenceAccess().getSurvivalTimeValueParserRuleCall_2_1_1_0());
            	    										
            	    pushFollow(FOLLOW_52);
            	    lv_survival_5_0=ruleTimeValue();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getSetEvidenceRule());
            	    											}
            	    											set(
            	    												current,
            	    												"survival",
            	    												lv_survival_5_0,
            	    												"org.xtext.roqme.RoQME.TimeValue");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            				

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
    // $ANTLR end "ruleSetEvidence"


    // $ANTLR start "entryRuleStartTimer"
    // InternalMIRoN.g:3351:1: entryRuleStartTimer returns [EObject current=null] : iv_ruleStartTimer= ruleStartTimer EOF ;
    public final EObject entryRuleStartTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartTimer = null;


        try {
            // InternalMIRoN.g:3351:51: (iv_ruleStartTimer= ruleStartTimer EOF )
            // InternalMIRoN.g:3352:2: iv_ruleStartTimer= ruleStartTimer EOF
            {
             newCompositeNode(grammarAccess.getStartTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartTimer=ruleStartTimer();

            state._fsp--;

             current =iv_ruleStartTimer; 
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
    // $ANTLR end "entryRuleStartTimer"


    // $ANTLR start "ruleStartTimer"
    // InternalMIRoN.g:3358:1: ruleStartTimer returns [EObject current=null] : (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStartTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3364:2: ( (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) ) )
            // InternalMIRoN.g:3365:2: (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) )
            {
            // InternalMIRoN.g:3365:2: (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:3366:3: otherlv_0= 'starts' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getStartTimerAccess().getStartsKeyword_0());
            		
            // InternalMIRoN.g:3370:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:3371:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:3371:4: ( ruleQualifiedName )
            // InternalMIRoN.g:3372:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStartTimerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStartTimerAccess().getTimerTimerCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleStartTimer"


    // $ANTLR start "entryRuleStopTimer"
    // InternalMIRoN.g:3390:1: entryRuleStopTimer returns [EObject current=null] : iv_ruleStopTimer= ruleStopTimer EOF ;
    public final EObject entryRuleStopTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopTimer = null;


        try {
            // InternalMIRoN.g:3390:50: (iv_ruleStopTimer= ruleStopTimer EOF )
            // InternalMIRoN.g:3391:2: iv_ruleStopTimer= ruleStopTimer EOF
            {
             newCompositeNode(grammarAccess.getStopTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStopTimer=ruleStopTimer();

            state._fsp--;

             current =iv_ruleStopTimer; 
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
    // $ANTLR end "entryRuleStopTimer"


    // $ANTLR start "ruleStopTimer"
    // InternalMIRoN.g:3397:1: ruleStopTimer returns [EObject current=null] : (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStopTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3403:2: ( (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) ) )
            // InternalMIRoN.g:3404:2: (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) )
            {
            // InternalMIRoN.g:3404:2: (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:3405:3: otherlv_0= 'stops' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getStopTimerAccess().getStopsKeyword_0());
            		
            // InternalMIRoN.g:3409:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:3410:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:3410:4: ( ruleQualifiedName )
            // InternalMIRoN.g:3411:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStopTimerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStopTimerAccess().getTimerTimerCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleStopTimer"


    // $ANTLR start "entryRuleResumeTimer"
    // InternalMIRoN.g:3429:1: entryRuleResumeTimer returns [EObject current=null] : iv_ruleResumeTimer= ruleResumeTimer EOF ;
    public final EObject entryRuleResumeTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResumeTimer = null;


        try {
            // InternalMIRoN.g:3429:52: (iv_ruleResumeTimer= ruleResumeTimer EOF )
            // InternalMIRoN.g:3430:2: iv_ruleResumeTimer= ruleResumeTimer EOF
            {
             newCompositeNode(grammarAccess.getResumeTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResumeTimer=ruleResumeTimer();

            state._fsp--;

             current =iv_ruleResumeTimer; 
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
    // $ANTLR end "entryRuleResumeTimer"


    // $ANTLR start "ruleResumeTimer"
    // InternalMIRoN.g:3436:1: ruleResumeTimer returns [EObject current=null] : (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleResumeTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3442:2: ( (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) ) )
            // InternalMIRoN.g:3443:2: (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) )
            {
            // InternalMIRoN.g:3443:2: (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:3444:3: otherlv_0= 'resumes' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getResumeTimerAccess().getResumesKeyword_0());
            		
            // InternalMIRoN.g:3448:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:3449:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:3449:4: ( ruleQualifiedName )
            // InternalMIRoN.g:3450:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getResumeTimerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getResumeTimerAccess().getTimerTimerCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleResumeTimer"


    // $ANTLR start "entryRuleDataTypeDefinition"
    // InternalMIRoN.g:3468:1: entryRuleDataTypeDefinition returns [EObject current=null] : iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF ;
    public final EObject entryRuleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinition = null;


        try {
            // InternalMIRoN.g:3468:59: (iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF )
            // InternalMIRoN.g:3469:2: iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF
            {
             newCompositeNode(grammarAccess.getDataTypeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeDefinition=ruleDataTypeDefinition();

            state._fsp--;

             current =iv_ruleDataTypeDefinition; 
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
    // $ANTLR end "entryRuleDataTypeDefinition"


    // $ANTLR start "ruleDataTypeDefinition"
    // InternalMIRoN.g:3475:1: ruleDataTypeDefinition returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) ) ;
    public final EObject ruleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dataType_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3481:2: ( (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) ) )
            // InternalMIRoN.g:3482:2: (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) )
            {
            // InternalMIRoN.g:3482:2: (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) )
            // InternalMIRoN.g:3483:3: otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDataTypeDefinitionAccess().getTypeKeyword_0());
            		
            // InternalMIRoN.g:3487:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMIRoN.g:3488:4: (lv_name_1_0= ruleEString )
            {
            // InternalMIRoN.g:3488:4: (lv_name_1_0= ruleEString )
            // InternalMIRoN.g:3489:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataTypeDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.roqme.RoQME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getDataTypeDefinitionAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:3510:3: ( (lv_dataType_3_0= ruleDataType ) )
            // InternalMIRoN.g:3511:4: (lv_dataType_3_0= ruleDataType )
            {
            // InternalMIRoN.g:3511:4: (lv_dataType_3_0= ruleDataType )
            // InternalMIRoN.g:3512:5: lv_dataType_3_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getDataTypeDataTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_dataType_3_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataTypeDefinitionRule());
            					}
            					set(
            						current,
            						"dataType",
            						lv_dataType_3_0,
            						"org.xtext.miron.MIRoN.DataType");
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
    // $ANTLR end "ruleDataTypeDefinition"


    // $ANTLR start "entryRuleBooleanType"
    // InternalMIRoN.g:3533:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalMIRoN.g:3533:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalMIRoN.g:3534:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
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
    // $ANTLR end "entryRuleBooleanType"


    // $ANTLR start "ruleBooleanType"
    // InternalMIRoN.g:3540:1: ruleBooleanType returns [EObject current=null] : ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3546:2: ( ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // InternalMIRoN.g:3547:2: ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // InternalMIRoN.g:3547:2: ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // InternalMIRoN.g:3548:3: () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // InternalMIRoN.g:3548:3: ()
            // InternalMIRoN.g:3549:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanTypeAccess().getBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,57,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalMIRoN.g:3559:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==16) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalMIRoN.g:3560:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:3564:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:3565:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:3565:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:3566:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getBooleanTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getBooleanTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleSimpleEnumType"
    // InternalMIRoN.g:3591:1: entryRuleSimpleEnumType returns [EObject current=null] : iv_ruleSimpleEnumType= ruleSimpleEnumType EOF ;
    public final EObject entryRuleSimpleEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEnumType = null;


        try {
            // InternalMIRoN.g:3591:55: (iv_ruleSimpleEnumType= ruleSimpleEnumType EOF )
            // InternalMIRoN.g:3592:2: iv_ruleSimpleEnumType= ruleSimpleEnumType EOF
            {
             newCompositeNode(grammarAccess.getSimpleEnumTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleEnumType=ruleSimpleEnumType();

            state._fsp--;

             current =iv_ruleSimpleEnumType; 
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
    // $ANTLR end "entryRuleSimpleEnumType"


    // $ANTLR start "ruleSimpleEnumType"
    // InternalMIRoN.g:3598:1: ruleSimpleEnumType returns [EObject current=null] : (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleSimpleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleSimpleEnumLiteral ) ) )+ otherlv_8= '}' ) ;
    public final EObject ruleSimpleEnumType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_cardinality_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_literals_5_0 = null;

        EObject lv_literals_7_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3604:2: ( (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleSimpleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleSimpleEnumLiteral ) ) )+ otherlv_8= '}' ) )
            // InternalMIRoN.g:3605:2: (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleSimpleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleSimpleEnumLiteral ) ) )+ otherlv_8= '}' )
            {
            // InternalMIRoN.g:3605:2: (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleSimpleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleSimpleEnumLiteral ) ) )+ otherlv_8= '}' )
            // InternalMIRoN.g:3606:3: otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleSimpleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleSimpleEnumLiteral ) ) )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleEnumTypeAccess().getEnumKeyword_0());
            		
            // InternalMIRoN.g:3610:3: (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==16) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMIRoN.g:3611:4: otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getSimpleEnumTypeAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalMIRoN.g:3615:4: ( (lv_cardinality_2_0= RULE_INT ) )
                    // InternalMIRoN.g:3616:5: (lv_cardinality_2_0= RULE_INT )
                    {
                    // InternalMIRoN.g:3616:5: (lv_cardinality_2_0= RULE_INT )
                    // InternalMIRoN.g:3617:6: lv_cardinality_2_0= RULE_INT
                    {
                    lv_cardinality_2_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_2_0, grammarAccess.getSimpleEnumTypeAccess().getCardinalityINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleEnumTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getSimpleEnumTypeAccess().getRightSquareBracketKeyword_1_2());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getSimpleEnumTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMIRoN.g:3642:3: ( (lv_literals_5_0= ruleSimpleEnumLiteral ) )
            // InternalMIRoN.g:3643:4: (lv_literals_5_0= ruleSimpleEnumLiteral )
            {
            // InternalMIRoN.g:3643:4: (lv_literals_5_0= ruleSimpleEnumLiteral )
            // InternalMIRoN.g:3644:5: lv_literals_5_0= ruleSimpleEnumLiteral
            {

            					newCompositeNode(grammarAccess.getSimpleEnumTypeAccess().getLiteralsSimpleEnumLiteralParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_35);
            lv_literals_5_0=ruleSimpleEnumLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleEnumTypeRule());
            					}
            					add(
            						current,
            						"literals",
            						lv_literals_5_0,
            						"org.xtext.roqme.RoQME.SimpleEnumLiteral");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:3661:3: (otherlv_6= ',' ( (lv_literals_7_0= ruleSimpleEnumLiteral ) ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==23) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalMIRoN.g:3662:4: otherlv_6= ',' ( (lv_literals_7_0= ruleSimpleEnumLiteral ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_19); 

            	    				newLeafNode(otherlv_6, grammarAccess.getSimpleEnumTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMIRoN.g:3666:4: ( (lv_literals_7_0= ruleSimpleEnumLiteral ) )
            	    // InternalMIRoN.g:3667:5: (lv_literals_7_0= ruleSimpleEnumLiteral )
            	    {
            	    // InternalMIRoN.g:3667:5: (lv_literals_7_0= ruleSimpleEnumLiteral )
            	    // InternalMIRoN.g:3668:6: lv_literals_7_0= ruleSimpleEnumLiteral
            	    {

            	    						newCompositeNode(grammarAccess.getSimpleEnumTypeAccess().getLiteralsSimpleEnumLiteralParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_literals_7_0=ruleSimpleEnumLiteral();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSimpleEnumTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"literals",
            	    							lv_literals_7_0,
            	    							"org.xtext.roqme.RoQME.SimpleEnumLiteral");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            otherlv_8=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSimpleEnumTypeAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleSimpleEnumType"


    // $ANTLR start "entryRuleSimpleEnumLiteral"
    // InternalMIRoN.g:3694:1: entryRuleSimpleEnumLiteral returns [EObject current=null] : iv_ruleSimpleEnumLiteral= ruleSimpleEnumLiteral EOF ;
    public final EObject entryRuleSimpleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEnumLiteral = null;


        try {
            // InternalMIRoN.g:3694:58: (iv_ruleSimpleEnumLiteral= ruleSimpleEnumLiteral EOF )
            // InternalMIRoN.g:3695:2: iv_ruleSimpleEnumLiteral= ruleSimpleEnumLiteral EOF
            {
             newCompositeNode(grammarAccess.getSimpleEnumLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleEnumLiteral=ruleSimpleEnumLiteral();

            state._fsp--;

             current =iv_ruleSimpleEnumLiteral; 
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
    // $ANTLR end "entryRuleSimpleEnumLiteral"


    // $ANTLR start "ruleSimpleEnumLiteral"
    // InternalMIRoN.g:3701:1: ruleSimpleEnumLiteral returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3707:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMIRoN.g:3708:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMIRoN.g:3708:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMIRoN.g:3709:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalMIRoN.g:3709:3: ()
            // InternalMIRoN.g:3710:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleEnumLiteralAccess().getSimpleEnumLiteralAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:3716:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:3717:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:3717:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:3718:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSimpleEnumLiteralAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleEnumLiteralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleSimpleEnumLiteral"


    // $ANTLR start "entryRuleEventType"
    // InternalMIRoN.g:3738:1: entryRuleEventType returns [EObject current=null] : iv_ruleEventType= ruleEventType EOF ;
    public final EObject entryRuleEventType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventType = null;


        try {
            // InternalMIRoN.g:3738:50: (iv_ruleEventType= ruleEventType EOF )
            // InternalMIRoN.g:3739:2: iv_ruleEventType= ruleEventType EOF
            {
             newCompositeNode(grammarAccess.getEventTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventType=ruleEventType();

            state._fsp--;

             current =iv_ruleEventType; 
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
    // $ANTLR end "entryRuleEventType"


    // $ANTLR start "ruleEventType"
    // InternalMIRoN.g:3745:1: ruleEventType returns [EObject current=null] : ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleEventType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3751:2: ( ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // InternalMIRoN.g:3752:2: ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // InternalMIRoN.g:3752:2: ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // InternalMIRoN.g:3753:3: () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // InternalMIRoN.g:3753:3: ()
            // InternalMIRoN.g:3754:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEventTypeAccess().getEventTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,58,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getEventTypeAccess().getEventtypeKeyword_1());
            		
            // InternalMIRoN.g:3764:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==16) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMIRoN.g:3765:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:3769:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:3770:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:3770:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:3771:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getEventTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEventTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getEventTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleEventType"


    // $ANTLR start "entryRuleNumericType"
    // InternalMIRoN.g:3796:1: entryRuleNumericType returns [EObject current=null] : iv_ruleNumericType= ruleNumericType EOF ;
    public final EObject entryRuleNumericType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericType = null;


        try {
            // InternalMIRoN.g:3796:52: (iv_ruleNumericType= ruleNumericType EOF )
            // InternalMIRoN.g:3797:2: iv_ruleNumericType= ruleNumericType EOF
            {
             newCompositeNode(grammarAccess.getNumericTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericType=ruleNumericType();

            state._fsp--;

             current =iv_ruleNumericType; 
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
    // $ANTLR end "entryRuleNumericType"


    // $ANTLR start "ruleNumericType"
    // InternalMIRoN.g:3803:1: ruleNumericType returns [EObject current=null] : ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) ) ;
    public final EObject ruleNumericType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_measurementUnit_7_0 = null;

        EObject lv_constraints_9_0 = null;

        EObject lv_constraints_11_0 = null;

        EObject lv_constraints_13_0 = null;

        EObject lv_constraints_16_0 = null;

        EObject lv_constraints_18_0 = null;

        EObject lv_constraints_20_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3809:2: ( ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) ) )
            // InternalMIRoN.g:3810:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) )
            {
            // InternalMIRoN.g:3810:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) ) )
            // InternalMIRoN.g:3811:3: () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) )
            {
            // InternalMIRoN.g:3811:3: ()
            // InternalMIRoN.g:3812:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumericTypeAccess().getNumericTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_54); 

            			newLeafNode(otherlv_1, grammarAccess.getNumericTypeAccess().getNumberKeyword_1());
            		
            // InternalMIRoN.g:3822:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==16) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalMIRoN.g:3823:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getNumericTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:3827:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:3828:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:3828:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:3829:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getNumericTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNumericTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_55); 

                    				newLeafNode(otherlv_4, grammarAccess.getNumericTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:3850:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) ) )
            // InternalMIRoN.g:3851:4: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) )
            {
            // InternalMIRoN.g:3851:4: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* ) )
            // InternalMIRoN.g:3852:5: ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3());
            				
            // InternalMIRoN.g:3855:5: ( ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )* )
            // InternalMIRoN.g:3856:6: ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )*
            {
            // InternalMIRoN.g:3856:6: ( ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) ) )*
            loop58:
            do {
                int alt58=4;
                int LA58_0 = input.LA(1);

                if ( LA58_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 0) ) {
                    alt58=1;
                }
                else if ( LA58_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 1) ) {
                    alt58=2;
                }
                else if ( LA58_0 >= 59 && LA58_0 <= 61 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 2) ) {
                    alt58=3;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalMIRoN.g:3857:4: ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:3857:4: ({...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) ) )
            	    // InternalMIRoN.g:3858:5: {...}? => ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNumericType", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalMIRoN.g:3858:108: ( ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) ) )
            	    // InternalMIRoN.g:3859:6: ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalMIRoN.g:3862:9: ({...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) ) )
            	    // InternalMIRoN.g:3862:10: {...}? => (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericType", "true");
            	    }
            	    // InternalMIRoN.g:3862:19: (otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) ) )
            	    // InternalMIRoN.g:3862:20: otherlv_6= 'unit' ( (lv_measurementUnit_7_0= ruleEString ) )
            	    {
            	    otherlv_6=(Token)match(input,18,FOLLOW_4); 

            	    									newLeafNode(otherlv_6, grammarAccess.getNumericTypeAccess().getUnitKeyword_3_0_0());
            	    								
            	    // InternalMIRoN.g:3866:9: ( (lv_measurementUnit_7_0= ruleEString ) )
            	    // InternalMIRoN.g:3867:10: (lv_measurementUnit_7_0= ruleEString )
            	    {
            	    // InternalMIRoN.g:3867:10: (lv_measurementUnit_7_0= ruleEString )
            	    // InternalMIRoN.g:3868:11: lv_measurementUnit_7_0= ruleEString
            	    {

            	    											newCompositeNode(grammarAccess.getNumericTypeAccess().getMeasurementUnitEStringParserRuleCall_3_0_1_0());
            	    										
            	    pushFollow(FOLLOW_55);
            	    lv_measurementUnit_7_0=ruleEString();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getNumericTypeRule());
            	    											}
            	    											set(
            	    												current,
            	    												"measurementUnit",
            	    												lv_measurementUnit_7_0,
            	    												"org.xtext.roqme.RoQME.EString");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMIRoN.g:3891:4: ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:3891:4: ({...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) ) )
            	    // InternalMIRoN.g:3892:5: {...}? => ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNumericType", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalMIRoN.g:3892:108: ( ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) ) )
            	    // InternalMIRoN.g:3893:6: ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalMIRoN.g:3896:9: ({...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) ) )
            	    // InternalMIRoN.g:3896:10: {...}? => ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericType", "true");
            	    }
            	    // InternalMIRoN.g:3896:19: ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) )
            	    int alt56=2;
            	    alt56 = dfa56.predict(input);
            	    switch (alt56) {
            	        case 1 :
            	            // InternalMIRoN.g:3896:20: (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' )
            	            {
            	            // InternalMIRoN.g:3896:20: (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' )
            	            // InternalMIRoN.g:3897:10: otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')'
            	            {
            	            otherlv_8=(Token)match(input,19,FOLLOW_12); 

            	            										newLeafNode(otherlv_8, grammarAccess.getNumericTypeAccess().getLeftParenthesisKeyword_3_1_0_0());
            	            									
            	            // InternalMIRoN.g:3901:10: ( (lv_constraints_9_0= ruleCompactLowerBound ) )
            	            // InternalMIRoN.g:3902:11: (lv_constraints_9_0= ruleCompactLowerBound )
            	            {
            	            // InternalMIRoN.g:3902:11: (lv_constraints_9_0= ruleCompactLowerBound )
            	            // InternalMIRoN.g:3903:12: lv_constraints_9_0= ruleCompactLowerBound
            	            {

            	            												newCompositeNode(grammarAccess.getNumericTypeAccess().getConstraintsCompactLowerBoundParserRuleCall_3_1_0_1_0());
            	            											
            	            pushFollow(FOLLOW_13);
            	            lv_constraints_9_0=ruleCompactLowerBound();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_9_0,
            	            													"org.xtext.roqme.RoQME.CompactLowerBound");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_10=(Token)match(input,20,FOLLOW_12); 

            	            										newLeafNode(otherlv_10, grammarAccess.getNumericTypeAccess().getColonKeyword_3_1_0_2());
            	            									
            	            // InternalMIRoN.g:3924:10: ( (lv_constraints_11_0= ruleCompactPrecision ) )
            	            // InternalMIRoN.g:3925:11: (lv_constraints_11_0= ruleCompactPrecision )
            	            {
            	            // InternalMIRoN.g:3925:11: (lv_constraints_11_0= ruleCompactPrecision )
            	            // InternalMIRoN.g:3926:12: lv_constraints_11_0= ruleCompactPrecision
            	            {

            	            												newCompositeNode(grammarAccess.getNumericTypeAccess().getConstraintsCompactPrecisionParserRuleCall_3_1_0_3_0());
            	            											
            	            pushFollow(FOLLOW_13);
            	            lv_constraints_11_0=ruleCompactPrecision();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_11_0,
            	            													"org.xtext.roqme.RoQME.CompactPrecision");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_12=(Token)match(input,20,FOLLOW_12); 

            	            										newLeafNode(otherlv_12, grammarAccess.getNumericTypeAccess().getColonKeyword_3_1_0_4());
            	            									
            	            // InternalMIRoN.g:3947:10: ( (lv_constraints_13_0= ruleCompactUpperBound ) )
            	            // InternalMIRoN.g:3948:11: (lv_constraints_13_0= ruleCompactUpperBound )
            	            {
            	            // InternalMIRoN.g:3948:11: (lv_constraints_13_0= ruleCompactUpperBound )
            	            // InternalMIRoN.g:3949:12: lv_constraints_13_0= ruleCompactUpperBound
            	            {

            	            												newCompositeNode(grammarAccess.getNumericTypeAccess().getConstraintsCompactUpperBoundParserRuleCall_3_1_0_5_0());
            	            											
            	            pushFollow(FOLLOW_14);
            	            lv_constraints_13_0=ruleCompactUpperBound();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_13_0,
            	            													"org.xtext.roqme.RoQME.CompactUpperBound");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_14=(Token)match(input,21,FOLLOW_55); 

            	            										newLeafNode(otherlv_14, grammarAccess.getNumericTypeAccess().getRightParenthesisKeyword_3_1_0_6());
            	            									

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMIRoN.g:3972:9: (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' )
            	            {
            	            // InternalMIRoN.g:3972:9: (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' )
            	            // InternalMIRoN.g:3973:10: otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')'
            	            {
            	            otherlv_15=(Token)match(input,19,FOLLOW_12); 

            	            										newLeafNode(otherlv_15, grammarAccess.getNumericTypeAccess().getLeftParenthesisKeyword_3_1_1_0());
            	            									
            	            // InternalMIRoN.g:3977:10: ( (lv_constraints_16_0= ruleCompactLowerBound ) )
            	            // InternalMIRoN.g:3978:11: (lv_constraints_16_0= ruleCompactLowerBound )
            	            {
            	            // InternalMIRoN.g:3978:11: (lv_constraints_16_0= ruleCompactLowerBound )
            	            // InternalMIRoN.g:3979:12: lv_constraints_16_0= ruleCompactLowerBound
            	            {

            	            												newCompositeNode(grammarAccess.getNumericTypeAccess().getConstraintsCompactLowerBoundParserRuleCall_3_1_1_1_0());
            	            											
            	            pushFollow(FOLLOW_13);
            	            lv_constraints_16_0=ruleCompactLowerBound();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_16_0,
            	            													"org.xtext.roqme.RoQME.CompactLowerBound");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_17=(Token)match(input,20,FOLLOW_12); 

            	            										newLeafNode(otherlv_17, grammarAccess.getNumericTypeAccess().getColonKeyword_3_1_1_2());
            	            									
            	            // InternalMIRoN.g:4000:10: ( (lv_constraints_18_0= ruleCompactUpperBound ) )
            	            // InternalMIRoN.g:4001:11: (lv_constraints_18_0= ruleCompactUpperBound )
            	            {
            	            // InternalMIRoN.g:4001:11: (lv_constraints_18_0= ruleCompactUpperBound )
            	            // InternalMIRoN.g:4002:12: lv_constraints_18_0= ruleCompactUpperBound
            	            {

            	            												newCompositeNode(grammarAccess.getNumericTypeAccess().getConstraintsCompactUpperBoundParserRuleCall_3_1_1_3_0());
            	            											
            	            pushFollow(FOLLOW_14);
            	            lv_constraints_18_0=ruleCompactUpperBound();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getNumericTypeRule());
            	            												}
            	            												add(
            	            													current,
            	            													"constraints",
            	            													lv_constraints_18_0,
            	            													"org.xtext.roqme.RoQME.CompactUpperBound");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }

            	            otherlv_19=(Token)match(input,21,FOLLOW_55); 

            	            										newLeafNode(otherlv_19, grammarAccess.getNumericTypeAccess().getRightParenthesisKeyword_3_1_1_4());
            	            									

            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMIRoN.g:4030:4: ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) )
            	    {
            	    // InternalMIRoN.g:4030:4: ({...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ ) )
            	    // InternalMIRoN.g:4031:5: {...}? => ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNumericType", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalMIRoN.g:4031:108: ( ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+ )
            	    // InternalMIRoN.g:4032:6: ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalMIRoN.g:4035:9: ({...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) ) )+
            	    int cnt57=0;
            	    loop57:
            	    do {
            	        int alt57=2;
            	        switch ( input.LA(1) ) {
            	        case 59:
            	            {
            	            int LA57_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt57=1;
            	            }


            	            }
            	            break;
            	        case 60:
            	            {
            	            int LA57_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt57=1;
            	            }


            	            }
            	            break;
            	        case 61:
            	            {
            	            int LA57_4 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt57=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt57) {
            	    	case 1 :
            	    	    // InternalMIRoN.g:4035:10: {...}? => ( (lv_constraints_20_0= ruleNumericTypeConstraint ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleNumericType", "true");
            	    	    }
            	    	    // InternalMIRoN.g:4035:19: ( (lv_constraints_20_0= ruleNumericTypeConstraint ) )
            	    	    // InternalMIRoN.g:4035:20: (lv_constraints_20_0= ruleNumericTypeConstraint )
            	    	    {
            	    	    // InternalMIRoN.g:4035:20: (lv_constraints_20_0= ruleNumericTypeConstraint )
            	    	    // InternalMIRoN.g:4036:10: lv_constraints_20_0= ruleNumericTypeConstraint
            	    	    {

            	    	    										newCompositeNode(grammarAccess.getNumericTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_3_2_0());
            	    	    									
            	    	    pushFollow(FOLLOW_55);
            	    	    lv_constraints_20_0=ruleNumericTypeConstraint();

            	    	    state._fsp--;


            	    	    										if (current==null) {
            	    	    											current = createModelElementForParent(grammarAccess.getNumericTypeRule());
            	    	    										}
            	    	    										add(
            	    	    											current,
            	    	    											"constraints",
            	    	    											lv_constraints_20_0,
            	    	    											"org.xtext.roqme.RoQME.NumericTypeConstraint");
            	    	    										afterParserOrEnumRuleCall();
            	    	    									

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt57 >= 1 ) break loop57;
            	                EarlyExitException eee =
            	                    new EarlyExitException(57, input);
            	                throw eee;
            	        }
            	        cnt57++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getNumericTypeAccess().getUnorderedGroup_3());
            				

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
    // $ANTLR end "ruleNumericType"


    // $ANTLR start "entryRuleNumericTypeConstraint"
    // InternalMIRoN.g:4069:1: entryRuleNumericTypeConstraint returns [EObject current=null] : iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF ;
    public final EObject entryRuleNumericTypeConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericTypeConstraint = null;


        try {
            // InternalMIRoN.g:4069:62: (iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF )
            // InternalMIRoN.g:4070:2: iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF
            {
             newCompositeNode(grammarAccess.getNumericTypeConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericTypeConstraint=ruleNumericTypeConstraint();

            state._fsp--;

             current =iv_ruleNumericTypeConstraint; 
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
    // $ANTLR end "entryRuleNumericTypeConstraint"


    // $ANTLR start "ruleNumericTypeConstraint"
    // InternalMIRoN.g:4076:1: ruleNumericTypeConstraint returns [EObject current=null] : (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound | this_Precision_2= rulePrecision ) ;
    public final EObject ruleNumericTypeConstraint() throws RecognitionException {
        EObject current = null;

        EObject this_LowerBound_0 = null;

        EObject this_UpperBound_1 = null;

        EObject this_Precision_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4082:2: ( (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound | this_Precision_2= rulePrecision ) )
            // InternalMIRoN.g:4083:2: (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound | this_Precision_2= rulePrecision )
            {
            // InternalMIRoN.g:4083:2: (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound | this_Precision_2= rulePrecision )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt59=1;
                }
                break;
            case 60:
                {
                alt59=2;
                }
                break;
            case 61:
                {
                alt59=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalMIRoN.g:4084:3: this_LowerBound_0= ruleLowerBound
                    {

                    			newCompositeNode(grammarAccess.getNumericTypeConstraintAccess().getLowerBoundParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LowerBound_0=ruleLowerBound();

                    state._fsp--;


                    			current = this_LowerBound_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4093:3: this_UpperBound_1= ruleUpperBound
                    {

                    			newCompositeNode(grammarAccess.getNumericTypeConstraintAccess().getUpperBoundParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpperBound_1=ruleUpperBound();

                    state._fsp--;


                    			current = this_UpperBound_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:4102:3: this_Precision_2= rulePrecision
                    {

                    			newCompositeNode(grammarAccess.getNumericTypeConstraintAccess().getPrecisionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Precision_2=rulePrecision();

                    state._fsp--;


                    			current = this_Precision_2;
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
    // $ANTLR end "ruleNumericTypeConstraint"


    // $ANTLR start "entryRuleLowerBound"
    // InternalMIRoN.g:4114:1: entryRuleLowerBound returns [EObject current=null] : iv_ruleLowerBound= ruleLowerBound EOF ;
    public final EObject entryRuleLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBound = null;


        try {
            // InternalMIRoN.g:4114:51: (iv_ruleLowerBound= ruleLowerBound EOF )
            // InternalMIRoN.g:4115:2: iv_ruleLowerBound= ruleLowerBound EOF
            {
             newCompositeNode(grammarAccess.getLowerBoundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLowerBound=ruleLowerBound();

            state._fsp--;

             current =iv_ruleLowerBound; 
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
    // $ANTLR end "entryRuleLowerBound"


    // $ANTLR start "ruleLowerBound"
    // InternalMIRoN.g:4121:1: ruleLowerBound returns [EObject current=null] : (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4127:2: ( (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalMIRoN.g:4128:2: (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalMIRoN.g:4128:2: (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalMIRoN.g:4129:3: otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getLowerBoundAccess().getLowerKeyword_0());
            		
            // InternalMIRoN.g:4133:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:4134:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:4134:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:4135:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getLowerBoundAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLowerBoundRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
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
    // $ANTLR end "ruleLowerBound"


    // $ANTLR start "entryRuleUpperBound"
    // InternalMIRoN.g:4156:1: entryRuleUpperBound returns [EObject current=null] : iv_ruleUpperBound= ruleUpperBound EOF ;
    public final EObject entryRuleUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperBound = null;


        try {
            // InternalMIRoN.g:4156:51: (iv_ruleUpperBound= ruleUpperBound EOF )
            // InternalMIRoN.g:4157:2: iv_ruleUpperBound= ruleUpperBound EOF
            {
             newCompositeNode(grammarAccess.getUpperBoundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpperBound=ruleUpperBound();

            state._fsp--;

             current =iv_ruleUpperBound; 
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
    // $ANTLR end "entryRuleUpperBound"


    // $ANTLR start "ruleUpperBound"
    // InternalMIRoN.g:4163:1: ruleUpperBound returns [EObject current=null] : (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4169:2: ( (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalMIRoN.g:4170:2: (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalMIRoN.g:4170:2: (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalMIRoN.g:4171:3: otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getUpperBoundAccess().getUpperKeyword_0());
            		
            // InternalMIRoN.g:4175:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:4176:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:4176:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:4177:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getUpperBoundAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUpperBoundRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
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
    // $ANTLR end "ruleUpperBound"


    // $ANTLR start "entryRulePrecision"
    // InternalMIRoN.g:4198:1: entryRulePrecision returns [EObject current=null] : iv_rulePrecision= rulePrecision EOF ;
    public final EObject entryRulePrecision() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrecision = null;


        try {
            // InternalMIRoN.g:4198:50: (iv_rulePrecision= rulePrecision EOF )
            // InternalMIRoN.g:4199:2: iv_rulePrecision= rulePrecision EOF
            {
             newCompositeNode(grammarAccess.getPrecisionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrecision=rulePrecision();

            state._fsp--;

             current =iv_rulePrecision; 
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
    // $ANTLR end "entryRulePrecision"


    // $ANTLR start "rulePrecision"
    // InternalMIRoN.g:4205:1: rulePrecision returns [EObject current=null] : (otherlv_0= 'precision' ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject rulePrecision() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4211:2: ( (otherlv_0= 'precision' ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalMIRoN.g:4212:2: (otherlv_0= 'precision' ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalMIRoN.g:4212:2: (otherlv_0= 'precision' ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalMIRoN.g:4213:3: otherlv_0= 'precision' ( (lv_value_1_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getPrecisionAccess().getPrecisionKeyword_0());
            		
            // InternalMIRoN.g:4217:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:4218:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:4218:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:4219:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPrecisionAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrecisionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
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
    // $ANTLR end "rulePrecision"


    // $ANTLR start "entryRuleCompactLowerBound"
    // InternalMIRoN.g:4240:1: entryRuleCompactLowerBound returns [EObject current=null] : iv_ruleCompactLowerBound= ruleCompactLowerBound EOF ;
    public final EObject entryRuleCompactLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompactLowerBound = null;


        try {
            // InternalMIRoN.g:4240:58: (iv_ruleCompactLowerBound= ruleCompactLowerBound EOF )
            // InternalMIRoN.g:4241:2: iv_ruleCompactLowerBound= ruleCompactLowerBound EOF
            {
             newCompositeNode(grammarAccess.getCompactLowerBoundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompactLowerBound=ruleCompactLowerBound();

            state._fsp--;

             current =iv_ruleCompactLowerBound; 
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
    // $ANTLR end "entryRuleCompactLowerBound"


    // $ANTLR start "ruleCompactLowerBound"
    // InternalMIRoN.g:4247:1: ruleCompactLowerBound returns [EObject current=null] : ( (lv_value_0_0= ruleEDouble ) ) ;
    public final EObject ruleCompactLowerBound() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4253:2: ( ( (lv_value_0_0= ruleEDouble ) ) )
            // InternalMIRoN.g:4254:2: ( (lv_value_0_0= ruleEDouble ) )
            {
            // InternalMIRoN.g:4254:2: ( (lv_value_0_0= ruleEDouble ) )
            // InternalMIRoN.g:4255:3: (lv_value_0_0= ruleEDouble )
            {
            // InternalMIRoN.g:4255:3: (lv_value_0_0= ruleEDouble )
            // InternalMIRoN.g:4256:4: lv_value_0_0= ruleEDouble
            {

            				newCompositeNode(grammarAccess.getCompactLowerBoundAccess().getValueEDoubleParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleEDouble();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getCompactLowerBoundRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.roqme.RoQME.EDouble");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleCompactLowerBound"


    // $ANTLR start "entryRuleCompactUpperBound"
    // InternalMIRoN.g:4276:1: entryRuleCompactUpperBound returns [EObject current=null] : iv_ruleCompactUpperBound= ruleCompactUpperBound EOF ;
    public final EObject entryRuleCompactUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompactUpperBound = null;


        try {
            // InternalMIRoN.g:4276:58: (iv_ruleCompactUpperBound= ruleCompactUpperBound EOF )
            // InternalMIRoN.g:4277:2: iv_ruleCompactUpperBound= ruleCompactUpperBound EOF
            {
             newCompositeNode(grammarAccess.getCompactUpperBoundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompactUpperBound=ruleCompactUpperBound();

            state._fsp--;

             current =iv_ruleCompactUpperBound; 
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
    // $ANTLR end "entryRuleCompactUpperBound"


    // $ANTLR start "ruleCompactUpperBound"
    // InternalMIRoN.g:4283:1: ruleCompactUpperBound returns [EObject current=null] : ( (lv_value_0_0= ruleEDouble ) ) ;
    public final EObject ruleCompactUpperBound() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4289:2: ( ( (lv_value_0_0= ruleEDouble ) ) )
            // InternalMIRoN.g:4290:2: ( (lv_value_0_0= ruleEDouble ) )
            {
            // InternalMIRoN.g:4290:2: ( (lv_value_0_0= ruleEDouble ) )
            // InternalMIRoN.g:4291:3: (lv_value_0_0= ruleEDouble )
            {
            // InternalMIRoN.g:4291:3: (lv_value_0_0= ruleEDouble )
            // InternalMIRoN.g:4292:4: lv_value_0_0= ruleEDouble
            {

            				newCompositeNode(grammarAccess.getCompactUpperBoundAccess().getValueEDoubleParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleEDouble();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getCompactUpperBoundRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.roqme.RoQME.EDouble");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleCompactUpperBound"


    // $ANTLR start "entryRuleCompactPrecision"
    // InternalMIRoN.g:4312:1: entryRuleCompactPrecision returns [EObject current=null] : iv_ruleCompactPrecision= ruleCompactPrecision EOF ;
    public final EObject entryRuleCompactPrecision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompactPrecision = null;


        try {
            // InternalMIRoN.g:4312:57: (iv_ruleCompactPrecision= ruleCompactPrecision EOF )
            // InternalMIRoN.g:4313:2: iv_ruleCompactPrecision= ruleCompactPrecision EOF
            {
             newCompositeNode(grammarAccess.getCompactPrecisionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompactPrecision=ruleCompactPrecision();

            state._fsp--;

             current =iv_ruleCompactPrecision; 
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
    // $ANTLR end "entryRuleCompactPrecision"


    // $ANTLR start "ruleCompactPrecision"
    // InternalMIRoN.g:4319:1: ruleCompactPrecision returns [EObject current=null] : ( (lv_value_0_0= ruleEDouble ) ) ;
    public final EObject ruleCompactPrecision() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4325:2: ( ( (lv_value_0_0= ruleEDouble ) ) )
            // InternalMIRoN.g:4326:2: ( (lv_value_0_0= ruleEDouble ) )
            {
            // InternalMIRoN.g:4326:2: ( (lv_value_0_0= ruleEDouble ) )
            // InternalMIRoN.g:4327:3: (lv_value_0_0= ruleEDouble )
            {
            // InternalMIRoN.g:4327:3: (lv_value_0_0= ruleEDouble )
            // InternalMIRoN.g:4328:4: lv_value_0_0= ruleEDouble
            {

            				newCompositeNode(grammarAccess.getCompactPrecisionAccess().getValueEDoubleParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleEDouble();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getCompactPrecisionRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.roqme.RoQME.EDouble");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleCompactPrecision"


    // $ANTLR start "entryRuleTimeType"
    // InternalMIRoN.g:4348:1: entryRuleTimeType returns [EObject current=null] : iv_ruleTimeType= ruleTimeType EOF ;
    public final EObject entryRuleTimeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeType = null;


        try {
            // InternalMIRoN.g:4348:49: (iv_ruleTimeType= ruleTimeType EOF )
            // InternalMIRoN.g:4349:2: iv_ruleTimeType= ruleTimeType EOF
            {
             newCompositeNode(grammarAccess.getTimeTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeType=ruleTimeType();

            state._fsp--;

             current =iv_ruleTimeType; 
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
    // $ANTLR end "entryRuleTimeType"


    // $ANTLR start "ruleTimeType"
    // InternalMIRoN.g:4355:1: ruleTimeType returns [EObject current=null] : ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* ) ;
    public final EObject ruleTimeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;
        EObject lv_constraints_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4361:2: ( ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* ) )
            // InternalMIRoN.g:4362:2: ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* )
            {
            // InternalMIRoN.g:4362:2: ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* )
            // InternalMIRoN.g:4363:3: () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )*
            {
            // InternalMIRoN.g:4363:3: ()
            // InternalMIRoN.g:4364:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeTypeAccess().getTimeTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,62,FOLLOW_54); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeTypeAccess().getTimeKeyword_1());
            		
            // InternalMIRoN.g:4374:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==16) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalMIRoN.g:4375:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getTimeTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:4379:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:4380:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:4380:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:4381:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getTimeTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_55); 

                    				newLeafNode(otherlv_4, grammarAccess.getTimeTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:4402:3: ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=59 && LA61_0<=61)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalMIRoN.g:4403:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    {
            	    // InternalMIRoN.g:4403:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    // InternalMIRoN.g:4404:5: lv_constraints_5_0= ruleNumericTypeConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getTimeTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_55);
            	    lv_constraints_5_0=ruleNumericTypeConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTimeTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_5_0,
            	    						"org.xtext.roqme.RoQME.NumericTypeConstraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


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
    // $ANTLR end "ruleTimeType"


    // $ANTLR start "entryRuleTypedValue"
    // InternalMIRoN.g:4425:1: entryRuleTypedValue returns [EObject current=null] : iv_ruleTypedValue= ruleTypedValue EOF ;
    public final EObject entryRuleTypedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedValue = null;


        try {
            // InternalMIRoN.g:4425:51: (iv_ruleTypedValue= ruleTypedValue EOF )
            // InternalMIRoN.g:4426:2: iv_ruleTypedValue= ruleTypedValue EOF
            {
             newCompositeNode(grammarAccess.getTypedValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedValue=ruleTypedValue();

            state._fsp--;

             current =iv_ruleTypedValue; 
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
    // $ANTLR end "entryRuleTypedValue"


    // $ANTLR start "ruleTypedValue"
    // InternalMIRoN.g:4432:1: ruleTypedValue returns [EObject current=null] : (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue ) ;
    public final EObject ruleTypedValue() throws RecognitionException {
        EObject current = null;

        EObject this_SingleValue_0 = null;

        EObject this_ArrayValue_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4438:2: ( (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue ) )
            // InternalMIRoN.g:4439:2: (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue )
            {
            // InternalMIRoN.g:4439:2: (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=RULE_INT && LA62_0<=RULE_ID)||LA62_0==63||LA62_0==93||(LA62_0>=100 && LA62_0<=101)) ) {
                alt62=1;
            }
            else if ( (LA62_0==16) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalMIRoN.g:4440:3: this_SingleValue_0= ruleSingleValue
                    {

                    			newCompositeNode(grammarAccess.getTypedValueAccess().getSingleValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SingleValue_0=ruleSingleValue();

                    state._fsp--;


                    			current = this_SingleValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4449:3: this_ArrayValue_1= ruleArrayValue
                    {

                    			newCompositeNode(grammarAccess.getTypedValueAccess().getArrayValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArrayValue_1=ruleArrayValue();

                    state._fsp--;


                    			current = this_ArrayValue_1;
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
    // $ANTLR end "ruleTypedValue"


    // $ANTLR start "entryRuleSingleValue"
    // InternalMIRoN.g:4461:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // InternalMIRoN.g:4461:52: (iv_ruleSingleValue= ruleSingleValue EOF )
            // InternalMIRoN.g:4462:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
             newCompositeNode(grammarAccess.getSingleValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleValue=ruleSingleValue();

            state._fsp--;

             current =iv_ruleSingleValue; 
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
    // $ANTLR end "entryRuleSingleValue"


    // $ANTLR start "ruleSingleValue"
    // InternalMIRoN.g:4468:1: ruleSingleValue returns [EObject current=null] : (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue ) ;
    public final EObject ruleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanValue_0 = null;

        EObject this_EnumValue_1 = null;

        EObject this_NumericValue_2 = null;

        EObject this_EventValue_3 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4474:2: ( (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue ) )
            // InternalMIRoN.g:4475:2: (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue )
            {
            // InternalMIRoN.g:4475:2: (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue )
            int alt63=4;
            switch ( input.LA(1) ) {
            case 100:
            case 101:
                {
                alt63=1;
                }
                break;
            case RULE_ID:
                {
                alt63=2;
                }
                break;
            case RULE_INT:
            case 93:
                {
                alt63=3;
                }
                break;
            case 63:
                {
                alt63=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalMIRoN.g:4476:3: this_BooleanValue_0= ruleBooleanValue
                    {

                    			newCompositeNode(grammarAccess.getSingleValueAccess().getBooleanValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanValue_0=ruleBooleanValue();

                    state._fsp--;


                    			current = this_BooleanValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4485:3: this_EnumValue_1= ruleEnumValue
                    {

                    			newCompositeNode(grammarAccess.getSingleValueAccess().getEnumValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumValue_1=ruleEnumValue();

                    state._fsp--;


                    			current = this_EnumValue_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:4494:3: this_NumericValue_2= ruleNumericValue
                    {

                    			newCompositeNode(grammarAccess.getSingleValueAccess().getNumericValueParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericValue_2=ruleNumericValue();

                    state._fsp--;


                    			current = this_NumericValue_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:4503:3: this_EventValue_3= ruleEventValue
                    {

                    			newCompositeNode(grammarAccess.getSingleValueAccess().getEventValueParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_EventValue_3=ruleEventValue();

                    state._fsp--;


                    			current = this_EventValue_3;
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
    // $ANTLR end "ruleSingleValue"


    // $ANTLR start "entryRuleEventValue"
    // InternalMIRoN.g:4515:1: entryRuleEventValue returns [EObject current=null] : iv_ruleEventValue= ruleEventValue EOF ;
    public final EObject entryRuleEventValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventValue = null;


        try {
            // InternalMIRoN.g:4515:51: (iv_ruleEventValue= ruleEventValue EOF )
            // InternalMIRoN.g:4516:2: iv_ruleEventValue= ruleEventValue EOF
            {
             newCompositeNode(grammarAccess.getEventValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventValue=ruleEventValue();

            state._fsp--;

             current =iv_ruleEventValue; 
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
    // $ANTLR end "entryRuleEventValue"


    // $ANTLR start "ruleEventValue"
    // InternalMIRoN.g:4522:1: ruleEventValue returns [EObject current=null] : ( () otherlv_1= 'event' ) ;
    public final EObject ruleEventValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMIRoN.g:4528:2: ( ( () otherlv_1= 'event' ) )
            // InternalMIRoN.g:4529:2: ( () otherlv_1= 'event' )
            {
            // InternalMIRoN.g:4529:2: ( () otherlv_1= 'event' )
            // InternalMIRoN.g:4530:3: () otherlv_1= 'event'
            {
            // InternalMIRoN.g:4530:3: ()
            // InternalMIRoN.g:4531:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEventValueAccess().getEventValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,63,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getEventValueAccess().getEventKeyword_1());
            		

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
    // $ANTLR end "ruleEventValue"


    // $ANTLR start "entryRuleBooleanValue"
    // InternalMIRoN.g:4545:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // InternalMIRoN.g:4545:53: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // InternalMIRoN.g:4546:2: iv_ruleBooleanValue= ruleBooleanValue EOF
            {
             newCompositeNode(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanValue=ruleBooleanValue();

            state._fsp--;

             current =iv_ruleBooleanValue; 
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
    // $ANTLR end "entryRuleBooleanValue"


    // $ANTLR start "ruleBooleanValue"
    // InternalMIRoN.g:4552:1: ruleBooleanValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEBoolean ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4558:2: ( ( () ( (lv_value_1_0= ruleEBoolean ) ) ) )
            // InternalMIRoN.g:4559:2: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            {
            // InternalMIRoN.g:4559:2: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            // InternalMIRoN.g:4560:3: () ( (lv_value_1_0= ruleEBoolean ) )
            {
            // InternalMIRoN.g:4560:3: ()
            // InternalMIRoN.g:4561:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanValueAccess().getBooleanValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:4567:3: ( (lv_value_1_0= ruleEBoolean ) )
            // InternalMIRoN.g:4568:4: (lv_value_1_0= ruleEBoolean )
            {
            // InternalMIRoN.g:4568:4: (lv_value_1_0= ruleEBoolean )
            // InternalMIRoN.g:4569:5: lv_value_1_0= ruleEBoolean
            {

            					newCompositeNode(grammarAccess.getBooleanValueAccess().getValueEBooleanParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBooleanValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EBoolean");
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
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "entryRuleEnumValue"
    // InternalMIRoN.g:4590:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // InternalMIRoN.g:4590:50: (iv_ruleEnumValue= ruleEnumValue EOF )
            // InternalMIRoN.g:4591:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
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
    // $ANTLR end "entryRuleEnumValue"


    // $ANTLR start "ruleEnumValue"
    // InternalMIRoN.g:4597:1: ruleEnumValue returns [EObject current=null] : ( () ( ( ruleLiteralQualifiedName ) ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMIRoN.g:4603:2: ( ( () ( ( ruleLiteralQualifiedName ) ) ) )
            // InternalMIRoN.g:4604:2: ( () ( ( ruleLiteralQualifiedName ) ) )
            {
            // InternalMIRoN.g:4604:2: ( () ( ( ruleLiteralQualifiedName ) ) )
            // InternalMIRoN.g:4605:3: () ( ( ruleLiteralQualifiedName ) )
            {
            // InternalMIRoN.g:4605:3: ()
            // InternalMIRoN.g:4606:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumValueAccess().getEnumValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:4612:3: ( ( ruleLiteralQualifiedName ) )
            // InternalMIRoN.g:4613:4: ( ruleLiteralQualifiedName )
            {
            // InternalMIRoN.g:4613:4: ( ruleLiteralQualifiedName )
            // InternalMIRoN.g:4614:5: ruleLiteralQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEnumValueAccess().getValueEnumLiteralCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleLiteralQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleEnumValue"


    // $ANTLR start "entryRuleNumericValue"
    // InternalMIRoN.g:4632:1: entryRuleNumericValue returns [EObject current=null] : iv_ruleNumericValue= ruleNumericValue EOF ;
    public final EObject entryRuleNumericValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericValue = null;


        try {
            // InternalMIRoN.g:4632:53: (iv_ruleNumericValue= ruleNumericValue EOF )
            // InternalMIRoN.g:4633:2: iv_ruleNumericValue= ruleNumericValue EOF
            {
             newCompositeNode(grammarAccess.getNumericValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericValue=ruleNumericValue();

            state._fsp--;

             current =iv_ruleNumericValue; 
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
    // $ANTLR end "entryRuleNumericValue"


    // $ANTLR start "ruleNumericValue"
    // InternalMIRoN.g:4639:1: ruleNumericValue returns [EObject current=null] : (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_TimeValue_1= ruleTimeValue ) ;
    public final EObject ruleNumericValue() throws RecognitionException {
        EObject current = null;

        EObject this_NumericValue_Impl_0 = null;

        EObject this_TimeValue_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4645:2: ( (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_TimeValue_1= ruleTimeValue ) )
            // InternalMIRoN.g:4646:2: (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_TimeValue_1= ruleTimeValue )
            {
            // InternalMIRoN.g:4646:2: (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_TimeValue_1= ruleTimeValue )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==93) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 99:
                        {
                        int LA64_3 = input.LA(4);

                        if ( (LA64_3==RULE_INT) ) {
                            int LA64_6 = input.LA(5);

                            if ( ((LA64_6>=64 && LA64_6<=73)) ) {
                                alt64=2;
                            }
                            else if ( (LA64_6==EOF||(LA64_6>=RULE_ID && LA64_6<=RULE_ROQME_DESCRIPTION)||(LA64_6>=20 && LA64_6<=25)||LA64_6==28||(LA64_6>=35 && LA64_6<=40)||(LA64_6>=42 && LA64_6<=56)||(LA64_6>=75 && LA64_6<=80)||(LA64_6>=82 && LA64_6<=84)||(LA64_6>=86 && LA64_6<=95)||(LA64_6>=109 && LA64_6<=110)) ) {
                                alt64=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 64, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 64, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                        {
                        alt64=2;
                        }
                        break;
                    case EOF:
                    case RULE_ID:
                    case RULE_STRING:
                    case RULE_ROQME_DESCRIPTION:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 28:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 82:
                    case 83:
                    case 84:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 109:
                    case 110:
                        {
                        alt64=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA64_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 99:
                    {
                    int LA64_3 = input.LA(3);

                    if ( (LA64_3==RULE_INT) ) {
                        int LA64_6 = input.LA(4);

                        if ( ((LA64_6>=64 && LA64_6<=73)) ) {
                            alt64=2;
                        }
                        else if ( (LA64_6==EOF||(LA64_6>=RULE_ID && LA64_6<=RULE_ROQME_DESCRIPTION)||(LA64_6>=20 && LA64_6<=25)||LA64_6==28||(LA64_6>=35 && LA64_6<=40)||(LA64_6>=42 && LA64_6<=56)||(LA64_6>=75 && LA64_6<=80)||(LA64_6>=82 && LA64_6<=84)||(LA64_6>=86 && LA64_6<=95)||(LA64_6>=109 && LA64_6<=110)) ) {
                            alt64=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 64, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                    {
                    alt64=2;
                    }
                    break;
                case EOF:
                case RULE_ID:
                case RULE_STRING:
                case RULE_ROQME_DESCRIPTION:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 82:
                case 83:
                case 84:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 109:
                case 110:
                    {
                    alt64=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalMIRoN.g:4647:3: this_NumericValue_Impl_0= ruleNumericValue_Impl
                    {

                    			newCompositeNode(grammarAccess.getNumericValueAccess().getNumericValue_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericValue_Impl_0=ruleNumericValue_Impl();

                    state._fsp--;


                    			current = this_NumericValue_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4656:3: this_TimeValue_1= ruleTimeValue
                    {

                    			newCompositeNode(grammarAccess.getNumericValueAccess().getTimeValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeValue_1=ruleTimeValue();

                    state._fsp--;


                    			current = this_TimeValue_1;
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
    // $ANTLR end "ruleNumericValue"


    // $ANTLR start "entryRuleNumericValue_Impl"
    // InternalMIRoN.g:4668:1: entryRuleNumericValue_Impl returns [EObject current=null] : iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF ;
    public final EObject entryRuleNumericValue_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericValue_Impl = null;


        try {
            // InternalMIRoN.g:4668:58: (iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF )
            // InternalMIRoN.g:4669:2: iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF
            {
             newCompositeNode(grammarAccess.getNumericValue_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericValue_Impl=ruleNumericValue_Impl();

            state._fsp--;

             current =iv_ruleNumericValue_Impl; 
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
    // $ANTLR end "entryRuleNumericValue_Impl"


    // $ANTLR start "ruleNumericValue_Impl"
    // InternalMIRoN.g:4675:1: ruleNumericValue_Impl returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleEString ) )? ) ;
    public final EObject ruleNumericValue_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_measurementUnit_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4681:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleEString ) )? ) )
            // InternalMIRoN.g:4682:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleEString ) )? )
            {
            // InternalMIRoN.g:4682:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleEString ) )? )
            // InternalMIRoN.g:4683:3: () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleEString ) )?
            {
            // InternalMIRoN.g:4683:3: ()
            // InternalMIRoN.g:4684:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumericValue_ImplAccess().getNumericValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:4690:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:4691:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:4691:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:4692:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getNumericValue_ImplAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_56);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumericValue_ImplRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:4709:3: ( (lv_measurementUnit_2_0= ruleEString ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=RULE_ID && LA65_0<=RULE_STRING)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalMIRoN.g:4710:4: (lv_measurementUnit_2_0= ruleEString )
                    {
                    // InternalMIRoN.g:4710:4: (lv_measurementUnit_2_0= ruleEString )
                    // InternalMIRoN.g:4711:5: lv_measurementUnit_2_0= ruleEString
                    {

                    					newCompositeNode(grammarAccess.getNumericValue_ImplAccess().getMeasurementUnitEStringParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_measurementUnit_2_0=ruleEString();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getNumericValue_ImplRule());
                    					}
                    					set(
                    						current,
                    						"measurementUnit",
                    						lv_measurementUnit_2_0,
                    						"org.xtext.roqme.RoQME.EString");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleNumericValue_Impl"


    // $ANTLR start "entryRuleTimeValue"
    // InternalMIRoN.g:4732:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // InternalMIRoN.g:4732:50: (iv_ruleTimeValue= ruleTimeValue EOF )
            // InternalMIRoN.g:4733:2: iv_ruleTimeValue= ruleTimeValue EOF
            {
             newCompositeNode(grammarAccess.getTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeValue=ruleTimeValue();

            state._fsp--;

             current =iv_ruleTimeValue; 
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
    // $ANTLR end "entryRuleTimeValue"


    // $ANTLR start "ruleTimeValue"
    // InternalMIRoN.g:4739:1: ruleTimeValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleTimeUnitEnum ) ) ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_measurementUnit_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4745:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleTimeUnitEnum ) ) ) )
            // InternalMIRoN.g:4746:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleTimeUnitEnum ) ) )
            {
            // InternalMIRoN.g:4746:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleTimeUnitEnum ) ) )
            // InternalMIRoN.g:4747:3: () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_measurementUnit_2_0= ruleTimeUnitEnum ) )
            {
            // InternalMIRoN.g:4747:3: ()
            // InternalMIRoN.g:4748:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeValueAccess().getTimeValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:4754:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:4755:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:4755:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:4756:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTimeValueAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_57);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:4773:3: ( (lv_measurementUnit_2_0= ruleTimeUnitEnum ) )
            // InternalMIRoN.g:4774:4: (lv_measurementUnit_2_0= ruleTimeUnitEnum )
            {
            // InternalMIRoN.g:4774:4: (lv_measurementUnit_2_0= ruleTimeUnitEnum )
            // InternalMIRoN.g:4775:5: lv_measurementUnit_2_0= ruleTimeUnitEnum
            {

            					newCompositeNode(grammarAccess.getTimeValueAccess().getMeasurementUnitTimeUnitEnumParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_measurementUnit_2_0=ruleTimeUnitEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeValueRule());
            					}
            					set(
            						current,
            						"measurementUnit",
            						lv_measurementUnit_2_0,
            						"org.xtext.roqme.RoQME.TimeUnitEnum");
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
    // $ANTLR end "ruleTimeValue"


    // $ANTLR start "entryRuleTimeUnitEnum"
    // InternalMIRoN.g:4796:1: entryRuleTimeUnitEnum returns [String current=null] : iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF ;
    public final String entryRuleTimeUnitEnum() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimeUnitEnum = null;


        try {
            // InternalMIRoN.g:4796:52: (iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF )
            // InternalMIRoN.g:4797:2: iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF
            {
             newCompositeNode(grammarAccess.getTimeUnitEnumRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeUnitEnum=ruleTimeUnitEnum();

            state._fsp--;

             current =iv_ruleTimeUnitEnum.getText(); 
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
    // $ANTLR end "entryRuleTimeUnitEnum"


    // $ANTLR start "ruleTimeUnitEnum"
    // InternalMIRoN.g:4803:1: ruleTimeUnitEnum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' ) ;
    public final AntlrDatatypeRuleToken ruleTimeUnitEnum() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMIRoN.g:4809:2: ( (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' ) )
            // InternalMIRoN.g:4810:2: (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' )
            {
            // InternalMIRoN.g:4810:2: (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' )
            int alt66=10;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt66=1;
                }
                break;
            case 65:
                {
                alt66=2;
                }
                break;
            case 66:
                {
                alt66=3;
                }
                break;
            case 67:
                {
                alt66=4;
                }
                break;
            case 68:
                {
                alt66=5;
                }
                break;
            case 69:
                {
                alt66=6;
                }
                break;
            case 70:
                {
                alt66=7;
                }
                break;
            case 71:
                {
                alt66=8;
                }
                break;
            case 72:
                {
                alt66=9;
                }
                break;
            case 73:
                {
                alt66=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalMIRoN.g:4811:3: kw= 'milliseconds'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMillisecondsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4817:3: kw= 'seconds'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getSecondsKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:4823:3: kw= 'minutes'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMinutesKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:4829:3: kw= 'hours'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getHoursKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:4835:3: kw= 'days'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getDaysKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:4841:3: kw= 'millisecond'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMillisecondKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMIRoN.g:4847:3: kw= 'second'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getSecondKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalMIRoN.g:4853:3: kw= 'minute'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMinuteKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalMIRoN.g:4859:3: kw= 'hour'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getHourKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalMIRoN.g:4865:3: kw= 'day'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getDayKeyword_9());
                    		

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
    // $ANTLR end "ruleTimeUnitEnum"


    // $ANTLR start "entryRuleArrayValue"
    // InternalMIRoN.g:4874:1: entryRuleArrayValue returns [EObject current=null] : iv_ruleArrayValue= ruleArrayValue EOF ;
    public final EObject entryRuleArrayValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayValue = null;


        try {
            // InternalMIRoN.g:4874:51: (iv_ruleArrayValue= ruleArrayValue EOF )
            // InternalMIRoN.g:4875:2: iv_ruleArrayValue= ruleArrayValue EOF
            {
             newCompositeNode(grammarAccess.getArrayValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayValue=ruleArrayValue();

            state._fsp--;

             current =iv_ruleArrayValue; 
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
    // $ANTLR end "entryRuleArrayValue"


    // $ANTLR start "ruleArrayValue"
    // InternalMIRoN.g:4881:1: ruleArrayValue returns [EObject current=null] : (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray ) ;
    public final EObject ruleArrayValue() throws RecognitionException {
        EObject current = null;

        EObject this_NumericArray_0 = null;

        EObject this_BooleanArray_1 = null;

        EObject this_EnumArray_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4887:2: ( (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray ) )
            // InternalMIRoN.g:4888:2: (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray )
            {
            // InternalMIRoN.g:4888:2: (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray )
            int alt67=3;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==16) ) {
                switch ( input.LA(2) ) {
                case RULE_INT:
                case 93:
                    {
                    alt67=1;
                    }
                    break;
                case 100:
                case 101:
                    {
                    alt67=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt67=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalMIRoN.g:4889:3: this_NumericArray_0= ruleNumericArray
                    {

                    			newCompositeNode(grammarAccess.getArrayValueAccess().getNumericArrayParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericArray_0=ruleNumericArray();

                    state._fsp--;


                    			current = this_NumericArray_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4898:3: this_BooleanArray_1= ruleBooleanArray
                    {

                    			newCompositeNode(grammarAccess.getArrayValueAccess().getBooleanArrayParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanArray_1=ruleBooleanArray();

                    state._fsp--;


                    			current = this_BooleanArray_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:4907:3: this_EnumArray_2= ruleEnumArray
                    {

                    			newCompositeNode(grammarAccess.getArrayValueAccess().getEnumArrayParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumArray_2=ruleEnumArray();

                    state._fsp--;


                    			current = this_EnumArray_2;
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
    // $ANTLR end "ruleArrayValue"


    // $ANTLR start "entryRuleBooleanArray"
    // InternalMIRoN.g:4919:1: entryRuleBooleanArray returns [EObject current=null] : iv_ruleBooleanArray= ruleBooleanArray EOF ;
    public final EObject entryRuleBooleanArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanArray = null;


        try {
            // InternalMIRoN.g:4919:53: (iv_ruleBooleanArray= ruleBooleanArray EOF )
            // InternalMIRoN.g:4920:2: iv_ruleBooleanArray= ruleBooleanArray EOF
            {
             newCompositeNode(grammarAccess.getBooleanArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanArray=ruleBooleanArray();

            state._fsp--;

             current =iv_ruleBooleanArray; 
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
    // $ANTLR end "entryRuleBooleanArray"


    // $ANTLR start "ruleBooleanArray"
    // InternalMIRoN.g:4926:1: ruleBooleanArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleBooleanArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4932:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:4933:2: (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:4933:2: (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:4934:3: otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_58); 

            			newLeafNode(otherlv_0, grammarAccess.getBooleanArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:4938:3: ( (lv_values_1_0= ruleBooleanValue ) )
            // InternalMIRoN.g:4939:4: (lv_values_1_0= ruleBooleanValue )
            {
            // InternalMIRoN.g:4939:4: (lv_values_1_0= ruleBooleanValue )
            // InternalMIRoN.g:4940:5: lv_values_1_0= ruleBooleanValue
            {

            					newCompositeNode(grammarAccess.getBooleanArrayAccess().getValuesBooleanValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_59);
            lv_values_1_0=ruleBooleanValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBooleanArrayRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.BooleanValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:4957:3: (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==23) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalMIRoN.g:4958:4: otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) )
            	    {
            	    otherlv_2=(Token)match(input,23,FOLLOW_58); 

            	    				newLeafNode(otherlv_2, grammarAccess.getBooleanArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:4962:4: ( (lv_values_3_0= ruleBooleanValue ) )
            	    // InternalMIRoN.g:4963:5: (lv_values_3_0= ruleBooleanValue )
            	    {
            	    // InternalMIRoN.g:4963:5: (lv_values_3_0= ruleBooleanValue )
            	    // InternalMIRoN.g:4964:6: lv_values_3_0= ruleBooleanValue
            	    {

            	    						newCompositeNode(grammarAccess.getBooleanArrayAccess().getValuesBooleanValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_59);
            	    lv_values_3_0=ruleBooleanValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBooleanArrayRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.BooleanValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getBooleanArrayAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleBooleanArray"


    // $ANTLR start "entryRuleEnumArray"
    // InternalMIRoN.g:4990:1: entryRuleEnumArray returns [EObject current=null] : iv_ruleEnumArray= ruleEnumArray EOF ;
    public final EObject entryRuleEnumArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumArray = null;


        try {
            // InternalMIRoN.g:4990:50: (iv_ruleEnumArray= ruleEnumArray EOF )
            // InternalMIRoN.g:4991:2: iv_ruleEnumArray= ruleEnumArray EOF
            {
             newCompositeNode(grammarAccess.getEnumArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumArray=ruleEnumArray();

            state._fsp--;

             current =iv_ruleEnumArray; 
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
    // $ANTLR end "entryRuleEnumArray"


    // $ANTLR start "ruleEnumArray"
    // InternalMIRoN.g:4997:1: ruleEnumArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleEnumArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5003:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:5004:2: (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:5004:2: (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:5005:3: otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:5009:3: ( (lv_values_1_0= ruleEnumValue ) )
            // InternalMIRoN.g:5010:4: (lv_values_1_0= ruleEnumValue )
            {
            // InternalMIRoN.g:5010:4: (lv_values_1_0= ruleEnumValue )
            // InternalMIRoN.g:5011:5: lv_values_1_0= ruleEnumValue
            {

            					newCompositeNode(grammarAccess.getEnumArrayAccess().getValuesEnumValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_59);
            lv_values_1_0=ruleEnumValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumArrayRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.EnumValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:5028:3: (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==23) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalMIRoN.g:5029:4: otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) )
            	    {
            	    otherlv_2=(Token)match(input,23,FOLLOW_19); 

            	    				newLeafNode(otherlv_2, grammarAccess.getEnumArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:5033:4: ( (lv_values_3_0= ruleEnumValue ) )
            	    // InternalMIRoN.g:5034:5: (lv_values_3_0= ruleEnumValue )
            	    {
            	    // InternalMIRoN.g:5034:5: (lv_values_3_0= ruleEnumValue )
            	    // InternalMIRoN.g:5035:6: lv_values_3_0= ruleEnumValue
            	    {

            	    						newCompositeNode(grammarAccess.getEnumArrayAccess().getValuesEnumValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_59);
            	    lv_values_3_0=ruleEnumValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumArrayRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.EnumValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumArrayAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleEnumArray"


    // $ANTLR start "entryRuleNumericArray"
    // InternalMIRoN.g:5061:1: entryRuleNumericArray returns [EObject current=null] : iv_ruleNumericArray= ruleNumericArray EOF ;
    public final EObject entryRuleNumericArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericArray = null;


        try {
            // InternalMIRoN.g:5061:53: (iv_ruleNumericArray= ruleNumericArray EOF )
            // InternalMIRoN.g:5062:2: iv_ruleNumericArray= ruleNumericArray EOF
            {
             newCompositeNode(grammarAccess.getNumericArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericArray=ruleNumericArray();

            state._fsp--;

             current =iv_ruleNumericArray; 
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
    // $ANTLR end "entryRuleNumericArray"


    // $ANTLR start "ruleNumericArray"
    // InternalMIRoN.g:5068:1: ruleNumericArray returns [EObject current=null] : (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_TimeArray_1= ruleTimeArray ) ;
    public final EObject ruleNumericArray() throws RecognitionException {
        EObject current = null;

        EObject this_NumericArray_Impl_0 = null;

        EObject this_TimeArray_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5074:2: ( (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_TimeArray_1= ruleTimeArray ) )
            // InternalMIRoN.g:5075:2: (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_TimeArray_1= ruleTimeArray )
            {
            // InternalMIRoN.g:5075:2: (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_TimeArray_1= ruleTimeArray )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==16) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==93) ) {
                    int LA70_2 = input.LA(3);

                    if ( (LA70_2==RULE_INT) ) {
                        switch ( input.LA(4) ) {
                        case 99:
                            {
                            int LA70_4 = input.LA(5);

                            if ( (LA70_4==RULE_INT) ) {
                                int LA70_7 = input.LA(6);

                                if ( ((LA70_7>=64 && LA70_7<=73)) ) {
                                    alt70=2;
                                }
                                else if ( ((LA70_7>=RULE_ID && LA70_7<=RULE_STRING)||LA70_7==17||LA70_7==23) ) {
                                    alt70=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 70, 7, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 70, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                        case 17:
                        case 23:
                            {
                            alt70=1;
                            }
                            break;
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                            {
                            alt70=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 70, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA70_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 99:
                        {
                        int LA70_4 = input.LA(4);

                        if ( (LA70_4==RULE_INT) ) {
                            int LA70_7 = input.LA(5);

                            if ( ((LA70_7>=64 && LA70_7<=73)) ) {
                                alt70=2;
                            }
                            else if ( ((LA70_7>=RULE_ID && LA70_7<=RULE_STRING)||LA70_7==17||LA70_7==23) ) {
                                alt70=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 70, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 70, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                    case 17:
                    case 23:
                        {
                        alt70=1;
                        }
                        break;
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                        {
                        alt70=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalMIRoN.g:5076:3: this_NumericArray_Impl_0= ruleNumericArray_Impl
                    {

                    			newCompositeNode(grammarAccess.getNumericArrayAccess().getNumericArray_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericArray_Impl_0=ruleNumericArray_Impl();

                    state._fsp--;


                    			current = this_NumericArray_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:5085:3: this_TimeArray_1= ruleTimeArray
                    {

                    			newCompositeNode(grammarAccess.getNumericArrayAccess().getTimeArrayParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeArray_1=ruleTimeArray();

                    state._fsp--;


                    			current = this_TimeArray_1;
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
    // $ANTLR end "ruleNumericArray"


    // $ANTLR start "entryRuleNumericArray_Impl"
    // InternalMIRoN.g:5097:1: entryRuleNumericArray_Impl returns [EObject current=null] : iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF ;
    public final EObject entryRuleNumericArray_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericArray_Impl = null;


        try {
            // InternalMIRoN.g:5097:58: (iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF )
            // InternalMIRoN.g:5098:2: iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF
            {
             newCompositeNode(grammarAccess.getNumericArray_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericArray_Impl=ruleNumericArray_Impl();

            state._fsp--;

             current =iv_ruleNumericArray_Impl; 
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
    // $ANTLR end "entryRuleNumericArray_Impl"


    // $ANTLR start "ruleNumericArray_Impl"
    // InternalMIRoN.g:5104:1: ruleNumericArray_Impl returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleNumericArray_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5110:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:5111:2: (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:5111:2: (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:5112:3: otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getNumericArray_ImplAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:5116:3: ( (lv_values_1_0= ruleNumericValue_Impl ) )
            // InternalMIRoN.g:5117:4: (lv_values_1_0= ruleNumericValue_Impl )
            {
            // InternalMIRoN.g:5117:4: (lv_values_1_0= ruleNumericValue_Impl )
            // InternalMIRoN.g:5118:5: lv_values_1_0= ruleNumericValue_Impl
            {

            					newCompositeNode(grammarAccess.getNumericArray_ImplAccess().getValuesNumericValue_ImplParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_59);
            lv_values_1_0=ruleNumericValue_Impl();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumericArray_ImplRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.NumericValue_Impl");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:5135:3: (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==23) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalMIRoN.g:5136:4: otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) )
            	    {
            	    otherlv_2=(Token)match(input,23,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getNumericArray_ImplAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:5140:4: ( (lv_values_3_0= ruleNumericValue_Impl ) )
            	    // InternalMIRoN.g:5141:5: (lv_values_3_0= ruleNumericValue_Impl )
            	    {
            	    // InternalMIRoN.g:5141:5: (lv_values_3_0= ruleNumericValue_Impl )
            	    // InternalMIRoN.g:5142:6: lv_values_3_0= ruleNumericValue_Impl
            	    {

            	    						newCompositeNode(grammarAccess.getNumericArray_ImplAccess().getValuesNumericValue_ImplParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_59);
            	    lv_values_3_0=ruleNumericValue_Impl();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNumericArray_ImplRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.NumericValue_Impl");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getNumericArray_ImplAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleNumericArray_Impl"


    // $ANTLR start "entryRuleTimeArray"
    // InternalMIRoN.g:5168:1: entryRuleTimeArray returns [EObject current=null] : iv_ruleTimeArray= ruleTimeArray EOF ;
    public final EObject entryRuleTimeArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeArray = null;


        try {
            // InternalMIRoN.g:5168:50: (iv_ruleTimeArray= ruleTimeArray EOF )
            // InternalMIRoN.g:5169:2: iv_ruleTimeArray= ruleTimeArray EOF
            {
             newCompositeNode(grammarAccess.getTimeArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeArray=ruleTimeArray();

            state._fsp--;

             current =iv_ruleTimeArray; 
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
    // $ANTLR end "entryRuleTimeArray"


    // $ANTLR start "ruleTimeArray"
    // InternalMIRoN.g:5175:1: ruleTimeArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleTimeArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5181:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:5182:2: (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:5182:2: (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:5183:3: otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:5187:3: ( (lv_values_1_0= ruleTimeValue ) )
            // InternalMIRoN.g:5188:4: (lv_values_1_0= ruleTimeValue )
            {
            // InternalMIRoN.g:5188:4: (lv_values_1_0= ruleTimeValue )
            // InternalMIRoN.g:5189:5: lv_values_1_0= ruleTimeValue
            {

            					newCompositeNode(grammarAccess.getTimeArrayAccess().getValuesTimeValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_59);
            lv_values_1_0=ruleTimeValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeArrayRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.TimeValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:5206:3: (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==23) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalMIRoN.g:5207:4: otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) )
            	    {
            	    otherlv_2=(Token)match(input,23,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getTimeArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:5211:4: ( (lv_values_3_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:5212:5: (lv_values_3_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:5212:5: (lv_values_3_0= ruleTimeValue )
            	    // InternalMIRoN.g:5213:6: lv_values_3_0= ruleTimeValue
            	    {

            	    						newCompositeNode(grammarAccess.getTimeArrayAccess().getValuesTimeValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_59);
            	    lv_values_3_0=ruleTimeValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTimeArrayRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.TimeValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTimeArrayAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleTimeArray"


    // $ANTLR start "entryRuleDataTypeDeclaration"
    // InternalMIRoN.g:5239:1: entryRuleDataTypeDeclaration returns [EObject current=null] : iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF ;
    public final EObject entryRuleDataTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDeclaration = null;


        try {
            // InternalMIRoN.g:5239:60: (iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF )
            // InternalMIRoN.g:5240:2: iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDataTypeDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeDeclaration=ruleDataTypeDeclaration();

            state._fsp--;

             current =iv_ruleDataTypeDeclaration; 
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
    // $ANTLR end "entryRuleDataTypeDeclaration"


    // $ANTLR start "ruleDataTypeDeclaration"
    // InternalMIRoN.g:5246:1: ruleDataTypeDeclaration returns [EObject current=null] : (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration ) ;
    public final EObject ruleDataTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_InbuiltDeclaration_0 = null;

        EObject this_ReferencedDeclaration_1 = null;

        EObject this_ContainedDeclaration_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5252:2: ( (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration ) )
            // InternalMIRoN.g:5253:2: (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration )
            {
            // InternalMIRoN.g:5253:2: (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration )
            int alt73=3;
            switch ( input.LA(1) ) {
            case EOF:
            case RULE_ROQME_DESCRIPTION:
            case 28:
            case 29:
            case 35:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 56:
            case 107:
            case 108:
                {
                alt73=1;
                }
                break;
            case RULE_ID:
                {
                alt73=2;
                }
                break;
            case 15:
            case 26:
            case 57:
            case 58:
            case 62:
                {
                alt73=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalMIRoN.g:5254:3: this_InbuiltDeclaration_0= ruleInbuiltDeclaration
                    {

                    			newCompositeNode(grammarAccess.getDataTypeDeclarationAccess().getInbuiltDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InbuiltDeclaration_0=ruleInbuiltDeclaration();

                    state._fsp--;


                    			current = this_InbuiltDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:5263:3: this_ReferencedDeclaration_1= ruleReferencedDeclaration
                    {

                    			newCompositeNode(grammarAccess.getDataTypeDeclarationAccess().getReferencedDeclarationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReferencedDeclaration_1=ruleReferencedDeclaration();

                    state._fsp--;


                    			current = this_ReferencedDeclaration_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:5272:3: this_ContainedDeclaration_2= ruleContainedDeclaration
                    {

                    			newCompositeNode(grammarAccess.getDataTypeDeclarationAccess().getContainedDeclarationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContainedDeclaration_2=ruleContainedDeclaration();

                    state._fsp--;


                    			current = this_ContainedDeclaration_2;
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
    // $ANTLR end "ruleDataTypeDeclaration"


    // $ANTLR start "entryRuleContainedDeclaration"
    // InternalMIRoN.g:5284:1: entryRuleContainedDeclaration returns [EObject current=null] : iv_ruleContainedDeclaration= ruleContainedDeclaration EOF ;
    public final EObject entryRuleContainedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedDeclaration = null;


        try {
            // InternalMIRoN.g:5284:61: (iv_ruleContainedDeclaration= ruleContainedDeclaration EOF )
            // InternalMIRoN.g:5285:2: iv_ruleContainedDeclaration= ruleContainedDeclaration EOF
            {
             newCompositeNode(grammarAccess.getContainedDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainedDeclaration=ruleContainedDeclaration();

            state._fsp--;

             current =iv_ruleContainedDeclaration; 
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
    // $ANTLR end "entryRuleContainedDeclaration"


    // $ANTLR start "ruleContainedDeclaration"
    // InternalMIRoN.g:5291:1: ruleContainedDeclaration returns [EObject current=null] : ( (lv_type_0_0= ruleDataType ) ) ;
    public final EObject ruleContainedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5297:2: ( ( (lv_type_0_0= ruleDataType ) ) )
            // InternalMIRoN.g:5298:2: ( (lv_type_0_0= ruleDataType ) )
            {
            // InternalMIRoN.g:5298:2: ( (lv_type_0_0= ruleDataType ) )
            // InternalMIRoN.g:5299:3: (lv_type_0_0= ruleDataType )
            {
            // InternalMIRoN.g:5299:3: (lv_type_0_0= ruleDataType )
            // InternalMIRoN.g:5300:4: lv_type_0_0= ruleDataType
            {

            				newCompositeNode(grammarAccess.getContainedDeclarationAccess().getTypeDataTypeParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_type_0_0=ruleDataType();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getContainedDeclarationRule());
            				}
            				set(
            					current,
            					"type",
            					lv_type_0_0,
            					"org.xtext.miron.MIRoN.DataType");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleContainedDeclaration"


    // $ANTLR start "entryRuleInbuiltDeclaration"
    // InternalMIRoN.g:5320:1: entryRuleInbuiltDeclaration returns [EObject current=null] : iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF ;
    public final EObject entryRuleInbuiltDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInbuiltDeclaration = null;


        try {
            // InternalMIRoN.g:5320:59: (iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF )
            // InternalMIRoN.g:5321:2: iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF
            {
             newCompositeNode(grammarAccess.getInbuiltDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInbuiltDeclaration=ruleInbuiltDeclaration();

            state._fsp--;

             current =iv_ruleInbuiltDeclaration; 
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
    // $ANTLR end "entryRuleInbuiltDeclaration"


    // $ANTLR start "ruleInbuiltDeclaration"
    // InternalMIRoN.g:5327:1: ruleInbuiltDeclaration returns [EObject current=null] : () ;
    public final EObject ruleInbuiltDeclaration() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMIRoN.g:5333:2: ( () )
            // InternalMIRoN.g:5334:2: ()
            {
            // InternalMIRoN.g:5334:2: ()
            // InternalMIRoN.g:5335:3: 
            {

            			current = forceCreateModelElement(
            				grammarAccess.getInbuiltDeclarationAccess().getInbuiltDeclarationAction(),
            				current);
            		

            }


            }


            	leaveRule();

        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInbuiltDeclaration"


    // $ANTLR start "entryRuleReferencedDeclaration"
    // InternalMIRoN.g:5344:1: entryRuleReferencedDeclaration returns [EObject current=null] : iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF ;
    public final EObject entryRuleReferencedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedDeclaration = null;


        try {
            // InternalMIRoN.g:5344:62: (iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF )
            // InternalMIRoN.g:5345:2: iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF
            {
             newCompositeNode(grammarAccess.getReferencedDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferencedDeclaration=ruleReferencedDeclaration();

            state._fsp--;

             current =iv_ruleReferencedDeclaration; 
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
    // $ANTLR end "entryRuleReferencedDeclaration"


    // $ANTLR start "ruleReferencedDeclaration"
    // InternalMIRoN.g:5351:1: ruleReferencedDeclaration returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleReferencedDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:5357:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalMIRoN.g:5358:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalMIRoN.g:5358:2: ( (otherlv_0= RULE_ID ) )
            // InternalMIRoN.g:5359:3: (otherlv_0= RULE_ID )
            {
            // InternalMIRoN.g:5359:3: (otherlv_0= RULE_ID )
            // InternalMIRoN.g:5360:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getReferencedDeclarationRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getReferencedDeclarationAccess().getTypeDataTypeDefinitionCrossReference_0());
            			

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
    // $ANTLR end "ruleReferencedDeclaration"


    // $ANTLR start "entryRuleGeneralExpression"
    // InternalMIRoN.g:5374:1: entryRuleGeneralExpression returns [EObject current=null] : iv_ruleGeneralExpression= ruleGeneralExpression EOF ;
    public final EObject entryRuleGeneralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralExpression = null;


        try {
            // InternalMIRoN.g:5374:58: (iv_ruleGeneralExpression= ruleGeneralExpression EOF )
            // InternalMIRoN.g:5375:2: iv_ruleGeneralExpression= ruleGeneralExpression EOF
            {
             newCompositeNode(grammarAccess.getGeneralExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneralExpression=ruleGeneralExpression();

            state._fsp--;

             current =iv_ruleGeneralExpression; 
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
    // $ANTLR end "entryRuleGeneralExpression"


    // $ANTLR start "ruleGeneralExpression"
    // InternalMIRoN.g:5381:1: ruleGeneralExpression returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleGeneralExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5387:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalMIRoN.g:5388:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalMIRoN.g:5388:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalMIRoN.g:5389:3: (lv_term_0_0= ruleTerm )
            {
            // InternalMIRoN.g:5389:3: (lv_term_0_0= ruleTerm )
            // InternalMIRoN.g:5390:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getGeneralExpressionAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getGeneralExpressionRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"org.xtext.roqme.RoQME.Term");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleGeneralExpression"


    // $ANTLR start "entryRuleOutputTransformation"
    // InternalMIRoN.g:5410:1: entryRuleOutputTransformation returns [EObject current=null] : iv_ruleOutputTransformation= ruleOutputTransformation EOF ;
    public final EObject entryRuleOutputTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputTransformation = null;


        try {
            // InternalMIRoN.g:5410:61: (iv_ruleOutputTransformation= ruleOutputTransformation EOF )
            // InternalMIRoN.g:5411:2: iv_ruleOutputTransformation= ruleOutputTransformation EOF
            {
             newCompositeNode(grammarAccess.getOutputTransformationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputTransformation=ruleOutputTransformation();

            state._fsp--;

             current =iv_ruleOutputTransformation; 
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
    // $ANTLR end "entryRuleOutputTransformation"


    // $ANTLR start "ruleOutputTransformation"
    // InternalMIRoN.g:5417:1: ruleOutputTransformation returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleOutputTransformation() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5423:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalMIRoN.g:5424:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalMIRoN.g:5424:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalMIRoN.g:5425:3: (lv_term_0_0= ruleTerm )
            {
            // InternalMIRoN.g:5425:3: (lv_term_0_0= ruleTerm )
            // InternalMIRoN.g:5426:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getOutputTransformationAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getOutputTransformationRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"org.xtext.roqme.RoQME.Term");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleOutputTransformation"


    // $ANTLR start "entryRuleContextPattern"
    // InternalMIRoN.g:5446:1: entryRuleContextPattern returns [EObject current=null] : iv_ruleContextPattern= ruleContextPattern EOF ;
    public final EObject entryRuleContextPattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextPattern = null;


        try {
            // InternalMIRoN.g:5446:55: (iv_ruleContextPattern= ruleContextPattern EOF )
            // InternalMIRoN.g:5447:2: iv_ruleContextPattern= ruleContextPattern EOF
            {
             newCompositeNode(grammarAccess.getContextPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextPattern=ruleContextPattern();

            state._fsp--;

             current =iv_ruleContextPattern; 
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
    // $ANTLR end "entryRuleContextPattern"


    // $ANTLR start "ruleContextPattern"
    // InternalMIRoN.g:5453:1: ruleContextPattern returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleContextPattern() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5459:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalMIRoN.g:5460:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalMIRoN.g:5460:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalMIRoN.g:5461:3: (lv_term_0_0= ruleTerm )
            {
            // InternalMIRoN.g:5461:3: (lv_term_0_0= ruleTerm )
            // InternalMIRoN.g:5462:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getContextPatternAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getContextPatternRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"org.xtext.roqme.RoQME.Term");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleContextPattern"


    // $ANTLR start "entryRuleTerm"
    // InternalMIRoN.g:5482:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalMIRoN.g:5482:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalMIRoN.g:5483:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalMIRoN.g:5489:1: ruleTerm returns [EObject current=null] : (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_OnceTerm_0 = null;

        EObject this_WhileTerm_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5495:2: ( (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm ) )
            // InternalMIRoN.g:5496:2: (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm )
            {
            // InternalMIRoN.g:5496:2: (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==74) ) {
                alt74=1;
            }
            else if ( ((LA74_0>=RULE_INT && LA74_0<=RULE_ID)||LA74_0==16||LA74_0==19||LA74_0==63||LA74_0==81||LA74_0==85||LA74_0==93||(LA74_0>=96 && LA74_0<=97)||(LA74_0>=100 && LA74_0<=101)||(LA74_0>=116 && LA74_0<=136)) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalMIRoN.g:5497:3: this_OnceTerm_0= ruleOnceTerm
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getOnceTermParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_OnceTerm_0=ruleOnceTerm();

                    state._fsp--;


                    			current = this_OnceTerm_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:5506:3: this_WhileTerm_1= ruleWhileTerm
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getWhileTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_WhileTerm_1=ruleWhileTerm();

                    state._fsp--;


                    			current = this_WhileTerm_1;
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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleOnceTerm"
    // InternalMIRoN.g:5518:1: entryRuleOnceTerm returns [EObject current=null] : iv_ruleOnceTerm= ruleOnceTerm EOF ;
    public final EObject entryRuleOnceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnceTerm = null;


        try {
            // InternalMIRoN.g:5518:49: (iv_ruleOnceTerm= ruleOnceTerm EOF )
            // InternalMIRoN.g:5519:2: iv_ruleOnceTerm= ruleOnceTerm EOF
            {
             newCompositeNode(grammarAccess.getOnceTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOnceTerm=ruleOnceTerm();

            state._fsp--;

             current =iv_ruleOnceTerm; 
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
    // $ANTLR end "entryRuleOnceTerm"


    // $ANTLR start "ruleOnceTerm"
    // InternalMIRoN.g:5525:1: ruleOnceTerm returns [EObject current=null] : (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) ) ;
    public final EObject ruleOnceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_term_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5531:2: ( (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) ) )
            // InternalMIRoN.g:5532:2: (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) )
            {
            // InternalMIRoN.g:5532:2: (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) )
            // InternalMIRoN.g:5533:3: otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_34); 

            			newLeafNode(otherlv_0, grammarAccess.getOnceTermAccess().getOnceKeyword_0());
            		
            // InternalMIRoN.g:5537:3: ( (lv_term_1_0= ruleWhileTerm ) )
            // InternalMIRoN.g:5538:4: (lv_term_1_0= ruleWhileTerm )
            {
            // InternalMIRoN.g:5538:4: (lv_term_1_0= ruleWhileTerm )
            // InternalMIRoN.g:5539:5: lv_term_1_0= ruleWhileTerm
            {

            					newCompositeNode(grammarAccess.getOnceTermAccess().getTermWhileTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_term_1_0=ruleWhileTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOnceTermRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_1_0,
            						"org.xtext.roqme.RoQME.WhileTerm");
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
    // $ANTLR end "ruleOnceTerm"


    // $ANTLR start "entryRuleWhileTerm"
    // InternalMIRoN.g:5560:1: entryRuleWhileTerm returns [EObject current=null] : iv_ruleWhileTerm= ruleWhileTerm EOF ;
    public final EObject entryRuleWhileTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileTerm = null;


        try {
            // InternalMIRoN.g:5560:50: (iv_ruleWhileTerm= ruleWhileTerm EOF )
            // InternalMIRoN.g:5561:2: iv_ruleWhileTerm= ruleWhileTerm EOF
            {
             newCompositeNode(grammarAccess.getWhileTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhileTerm=ruleWhileTerm();

            state._fsp--;

             current =iv_ruleWhileTerm; 
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
    // $ANTLR end "entryRuleWhileTerm"


    // $ANTLR start "ruleWhileTerm"
    // InternalMIRoN.g:5567:1: ruleWhileTerm returns [EObject current=null] : (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleWhileTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_RepetionTerm_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5573:2: ( (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? ) )
            // InternalMIRoN.g:5574:2: (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? )
            {
            // InternalMIRoN.g:5574:2: (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? )
            // InternalMIRoN.g:5575:3: this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )?
            {

            			newCompositeNode(grammarAccess.getWhileTermAccess().getRepetionTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_60);
            this_RepetionTerm_0=ruleRepetionTerm();

            state._fsp--;


            			current = this_RepetionTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5583:3: ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==75) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalMIRoN.g:5584:4: () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')'
                    {
                    // InternalMIRoN.g:5584:4: ()
                    // InternalMIRoN.g:5585:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getWhileTermAccess().getWhileTermLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,75,FOLLOW_61); 

                    				newLeafNode(otherlv_2, grammarAccess.getWhileTermAccess().getWhileKeyword_1_1());
                    			
                    otherlv_3=(Token)match(input,19,FOLLOW_34); 

                    				newLeafNode(otherlv_3, grammarAccess.getWhileTermAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMIRoN.g:5599:4: ( (lv_right_4_0= ruleOrBooleanTerm ) )
                    // InternalMIRoN.g:5600:5: (lv_right_4_0= ruleOrBooleanTerm )
                    {
                    // InternalMIRoN.g:5600:5: (lv_right_4_0= ruleOrBooleanTerm )
                    // InternalMIRoN.g:5601:6: lv_right_4_0= ruleOrBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getWhileTermAccess().getRightOrBooleanTermParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_right_4_0=ruleOrBooleanTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWhileTermRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_4_0,
                    							"org.xtext.roqme.RoQME.OrBooleanTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getWhileTermAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleWhileTerm"


    // $ANTLR start "entryRuleRepetionTerm"
    // InternalMIRoN.g:5627:1: entryRuleRepetionTerm returns [EObject current=null] : iv_ruleRepetionTerm= ruleRepetionTerm EOF ;
    public final EObject entryRuleRepetionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepetionTerm = null;


        try {
            // InternalMIRoN.g:5627:53: (iv_ruleRepetionTerm= ruleRepetionTerm EOF )
            // InternalMIRoN.g:5628:2: iv_ruleRepetionTerm= ruleRepetionTerm EOF
            {
             newCompositeNode(grammarAccess.getRepetionTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRepetionTerm=ruleRepetionTerm();

            state._fsp--;

             current =iv_ruleRepetionTerm; 
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
    // $ANTLR end "entryRuleRepetionTerm"


    // $ANTLR start "ruleRepetionTerm"
    // InternalMIRoN.g:5634:1: ruleRepetionTerm returns [EObject current=null] : (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? ) ;
    public final EObject ruleRepetionTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_nrep_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_lowerBound_9_0=null;
        Token otherlv_10=null;
        Token lv_upperBound_11_0=null;
        Token otherlv_12=null;
        EObject this_SequenceTerm_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5640:2: ( (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? ) )
            // InternalMIRoN.g:5641:2: (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? )
            {
            // InternalMIRoN.g:5641:2: (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? )
            // InternalMIRoN.g:5642:3: this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )?
            {

            			newCompositeNode(grammarAccess.getRepetionTermAccess().getSequenceTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_62);
            this_SequenceTerm_0=ruleSequenceTerm();

            state._fsp--;


            			current = this_SequenceTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5650:3: ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )?
            int alt76=3;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==76) ) {
                alt76=1;
            }
            else if ( (LA76_0==77) ) {
                alt76=2;
            }
            switch (alt76) {
                case 1 :
                    // InternalMIRoN.g:5651:4: ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' )
                    {
                    // InternalMIRoN.g:5651:4: ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' )
                    // InternalMIRoN.g:5652:5: () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')'
                    {
                    // InternalMIRoN.g:5652:5: ()
                    // InternalMIRoN.g:5653:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getRepetionTermAccess().getRepeatTermTermAction_1_0_0(),
                    							current);
                    					

                    }

                    otherlv_2=(Token)match(input,76,FOLLOW_61); 

                    					newLeafNode(otherlv_2, grammarAccess.getRepetionTermAccess().getRepeatKeyword_1_0_1());
                    				
                    otherlv_3=(Token)match(input,19,FOLLOW_9); 

                    					newLeafNode(otherlv_3, grammarAccess.getRepetionTermAccess().getLeftParenthesisKeyword_1_0_2());
                    				
                    // InternalMIRoN.g:5667:5: ( (lv_nrep_4_0= RULE_INT ) )
                    // InternalMIRoN.g:5668:6: (lv_nrep_4_0= RULE_INT )
                    {
                    // InternalMIRoN.g:5668:6: (lv_nrep_4_0= RULE_INT )
                    // InternalMIRoN.g:5669:7: lv_nrep_4_0= RULE_INT
                    {
                    lv_nrep_4_0=(Token)match(input,RULE_INT,FOLLOW_14); 

                    							newLeafNode(lv_nrep_4_0, grammarAccess.getRepetionTermAccess().getNrepINTTerminalRuleCall_1_0_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRepetionTermRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"nrep",
                    								lv_nrep_4_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,21,FOLLOW_2); 

                    					newLeafNode(otherlv_5, grammarAccess.getRepetionTermAccess().getRightParenthesisKeyword_1_0_4());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:5691:4: ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' )
                    {
                    // InternalMIRoN.g:5691:4: ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' )
                    // InternalMIRoN.g:5692:5: () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')'
                    {
                    // InternalMIRoN.g:5692:5: ()
                    // InternalMIRoN.g:5693:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getRepetionTermAccess().getRangeTermTermAction_1_1_0(),
                    							current);
                    					

                    }

                    otherlv_7=(Token)match(input,77,FOLLOW_61); 

                    					newLeafNode(otherlv_7, grammarAccess.getRepetionTermAccess().getRangeKeyword_1_1_1());
                    				
                    otherlv_8=(Token)match(input,19,FOLLOW_9); 

                    					newLeafNode(otherlv_8, grammarAccess.getRepetionTermAccess().getLeftParenthesisKeyword_1_1_2());
                    				
                    // InternalMIRoN.g:5707:5: ( (lv_lowerBound_9_0= RULE_INT ) )
                    // InternalMIRoN.g:5708:6: (lv_lowerBound_9_0= RULE_INT )
                    {
                    // InternalMIRoN.g:5708:6: (lv_lowerBound_9_0= RULE_INT )
                    // InternalMIRoN.g:5709:7: lv_lowerBound_9_0= RULE_INT
                    {
                    lv_lowerBound_9_0=(Token)match(input,RULE_INT,FOLLOW_35); 

                    							newLeafNode(lv_lowerBound_9_0, grammarAccess.getRepetionTermAccess().getLowerBoundINTTerminalRuleCall_1_1_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRepetionTermRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"lowerBound",
                    								lv_lowerBound_9_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }

                    otherlv_10=(Token)match(input,23,FOLLOW_9); 

                    					newLeafNode(otherlv_10, grammarAccess.getRepetionTermAccess().getCommaKeyword_1_1_4());
                    				
                    // InternalMIRoN.g:5729:5: ( (lv_upperBound_11_0= RULE_INT ) )
                    // InternalMIRoN.g:5730:6: (lv_upperBound_11_0= RULE_INT )
                    {
                    // InternalMIRoN.g:5730:6: (lv_upperBound_11_0= RULE_INT )
                    // InternalMIRoN.g:5731:7: lv_upperBound_11_0= RULE_INT
                    {
                    lv_upperBound_11_0=(Token)match(input,RULE_INT,FOLLOW_14); 

                    							newLeafNode(lv_upperBound_11_0, grammarAccess.getRepetionTermAccess().getUpperBoundINTTerminalRuleCall_1_1_5_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRepetionTermRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"upperBound",
                    								lv_upperBound_11_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }

                    otherlv_12=(Token)match(input,21,FOLLOW_2); 

                    					newLeafNode(otherlv_12, grammarAccess.getRepetionTermAccess().getRightParenthesisKeyword_1_1_6());
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleRepetionTerm"


    // $ANTLR start "entryRuleSequenceTerm"
    // InternalMIRoN.g:5757:1: entryRuleSequenceTerm returns [EObject current=null] : iv_ruleSequenceTerm= ruleSequenceTerm EOF ;
    public final EObject entryRuleSequenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceTerm = null;


        try {
            // InternalMIRoN.g:5757:53: (iv_ruleSequenceTerm= ruleSequenceTerm EOF )
            // InternalMIRoN.g:5758:2: iv_ruleSequenceTerm= ruleSequenceTerm EOF
            {
             newCompositeNode(grammarAccess.getSequenceTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequenceTerm=ruleSequenceTerm();

            state._fsp--;

             current =iv_ruleSequenceTerm; 
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
    // $ANTLR end "entryRuleSequenceTerm"


    // $ANTLR start "ruleSequenceTerm"
    // InternalMIRoN.g:5764:1: ruleSequenceTerm returns [EObject current=null] : (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* ) ;
    public final EObject ruleSequenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_OrEventTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5770:2: ( (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* ) )
            // InternalMIRoN.g:5771:2: (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* )
            {
            // InternalMIRoN.g:5771:2: (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* )
            // InternalMIRoN.g:5772:3: this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getSequenceTermAccess().getOrEventTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_63);
            this_OrEventTerm_0=ruleOrEventTerm();

            state._fsp--;


            			current = this_OrEventTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5780:3: ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==78) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalMIRoN.g:5781:4: () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) )
            	    {
            	    // InternalMIRoN.g:5781:4: ()
            	    // InternalMIRoN.g:5782:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getSequenceTermAccess().getFollowedByTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,78,FOLLOW_34); 

            	    				newLeafNode(otherlv_2, grammarAccess.getSequenceTermAccess().getHyphenMinusGreaterThanSignKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:5792:4: ( (lv_right_3_0= ruleConditionalTerm ) )
            	    // InternalMIRoN.g:5793:5: (lv_right_3_0= ruleConditionalTerm )
            	    {
            	    // InternalMIRoN.g:5793:5: (lv_right_3_0= ruleConditionalTerm )
            	    // InternalMIRoN.g:5794:6: lv_right_3_0= ruleConditionalTerm
            	    {

            	    						newCompositeNode(grammarAccess.getSequenceTermAccess().getRightConditionalTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_63);
            	    lv_right_3_0=ruleConditionalTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSequenceTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.roqme.RoQME.ConditionalTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


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
    // $ANTLR end "ruleSequenceTerm"


    // $ANTLR start "entryRuleOrEventTerm"
    // InternalMIRoN.g:5816:1: entryRuleOrEventTerm returns [EObject current=null] : iv_ruleOrEventTerm= ruleOrEventTerm EOF ;
    public final EObject entryRuleOrEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrEventTerm = null;


        try {
            // InternalMIRoN.g:5816:52: (iv_ruleOrEventTerm= ruleOrEventTerm EOF )
            // InternalMIRoN.g:5817:2: iv_ruleOrEventTerm= ruleOrEventTerm EOF
            {
             newCompositeNode(grammarAccess.getOrEventTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrEventTerm=ruleOrEventTerm();

            state._fsp--;

             current =iv_ruleOrEventTerm; 
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
    // $ANTLR end "entryRuleOrEventTerm"


    // $ANTLR start "ruleOrEventTerm"
    // InternalMIRoN.g:5823:1: ruleOrEventTerm returns [EObject current=null] : (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* ) ;
    public final EObject ruleOrEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndEventTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5829:2: ( (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* ) )
            // InternalMIRoN.g:5830:2: (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* )
            {
            // InternalMIRoN.g:5830:2: (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* )
            // InternalMIRoN.g:5831:3: this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrEventTermAccess().getAndEventTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_64);
            this_AndEventTerm_0=ruleAndEventTerm();

            state._fsp--;


            			current = this_AndEventTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5839:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==79) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalMIRoN.g:5840:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) )
            	    {
            	    // InternalMIRoN.g:5840:4: ()
            	    // InternalMIRoN.g:5841:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrEventTermAccess().getOrEventTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,79,FOLLOW_34); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrEventTermAccess().getOrKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:5851:4: ( (lv_right_3_0= ruleAndEventTerm ) )
            	    // InternalMIRoN.g:5852:5: (lv_right_3_0= ruleAndEventTerm )
            	    {
            	    // InternalMIRoN.g:5852:5: (lv_right_3_0= ruleAndEventTerm )
            	    // InternalMIRoN.g:5853:6: lv_right_3_0= ruleAndEventTerm
            	    {

            	    						newCompositeNode(grammarAccess.getOrEventTermAccess().getRightAndEventTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_64);
            	    lv_right_3_0=ruleAndEventTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrEventTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.roqme.RoQME.AndEventTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);


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
    // $ANTLR end "ruleOrEventTerm"


    // $ANTLR start "entryRuleAndEventTerm"
    // InternalMIRoN.g:5875:1: entryRuleAndEventTerm returns [EObject current=null] : iv_ruleAndEventTerm= ruleAndEventTerm EOF ;
    public final EObject entryRuleAndEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndEventTerm = null;


        try {
            // InternalMIRoN.g:5875:53: (iv_ruleAndEventTerm= ruleAndEventTerm EOF )
            // InternalMIRoN.g:5876:2: iv_ruleAndEventTerm= ruleAndEventTerm EOF
            {
             newCompositeNode(grammarAccess.getAndEventTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndEventTerm=ruleAndEventTerm();

            state._fsp--;

             current =iv_ruleAndEventTerm; 
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
    // $ANTLR end "entryRuleAndEventTerm"


    // $ANTLR start "ruleAndEventTerm"
    // InternalMIRoN.g:5882:1: ruleAndEventTerm returns [EObject current=null] : ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* ) ;
    public final EObject ruleAndEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_NotEventTerm_0 = null;

        EObject this_ConditionalTerm_1 = null;

        EObject lv_right_4_1 = null;

        EObject lv_right_4_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5888:2: ( ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* ) )
            // InternalMIRoN.g:5889:2: ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* )
            {
            // InternalMIRoN.g:5889:2: ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* )
            // InternalMIRoN.g:5890:3: (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )*
            {
            // InternalMIRoN.g:5890:3: (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==81) ) {
                alt79=1;
            }
            else if ( ((LA79_0>=RULE_INT && LA79_0<=RULE_ID)||LA79_0==16||LA79_0==19||LA79_0==63||LA79_0==85||LA79_0==93||(LA79_0>=96 && LA79_0<=97)||(LA79_0>=100 && LA79_0<=101)||(LA79_0>=116 && LA79_0<=136)) ) {
                alt79=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalMIRoN.g:5891:4: this_NotEventTerm_0= ruleNotEventTerm
                    {

                    				newCompositeNode(grammarAccess.getAndEventTermAccess().getNotEventTermParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_65);
                    this_NotEventTerm_0=ruleNotEventTerm();

                    state._fsp--;


                    				current = this_NotEventTerm_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:5900:4: this_ConditionalTerm_1= ruleConditionalTerm
                    {

                    				newCompositeNode(grammarAccess.getAndEventTermAccess().getConditionalTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_65);
                    this_ConditionalTerm_1=ruleConditionalTerm();

                    state._fsp--;


                    				current = this_ConditionalTerm_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:5909:3: ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==80) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalMIRoN.g:5910:4: () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) )
            	    {
            	    // InternalMIRoN.g:5910:4: ()
            	    // InternalMIRoN.g:5911:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndEventTermAccess().getAndEventTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,80,FOLLOW_34); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAndEventTermAccess().getAndKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:5921:4: ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) )
            	    // InternalMIRoN.g:5922:5: ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) )
            	    {
            	    // InternalMIRoN.g:5922:5: ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) )
            	    // InternalMIRoN.g:5923:6: (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm )
            	    {
            	    // InternalMIRoN.g:5923:6: (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm )
            	    int alt80=2;
            	    int LA80_0 = input.LA(1);

            	    if ( (LA80_0==81) ) {
            	        alt80=1;
            	    }
            	    else if ( ((LA80_0>=RULE_INT && LA80_0<=RULE_ID)||LA80_0==16||LA80_0==19||LA80_0==63||LA80_0==85||LA80_0==93||(LA80_0>=96 && LA80_0<=97)||(LA80_0>=100 && LA80_0<=101)||(LA80_0>=116 && LA80_0<=136)) ) {
            	        alt80=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 80, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt80) {
            	        case 1 :
            	            // InternalMIRoN.g:5924:7: lv_right_4_1= ruleNotEventTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndEventTermAccess().getRightNotEventTermParserRuleCall_1_2_0_0());
            	            						
            	            pushFollow(FOLLOW_65);
            	            lv_right_4_1=ruleNotEventTerm();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getAndEventTermRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_1,
            	            								"org.xtext.roqme.RoQME.NotEventTerm");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalMIRoN.g:5940:7: lv_right_4_2= ruleConditionalTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndEventTermAccess().getRightConditionalTermParserRuleCall_1_2_0_1());
            	            						
            	            pushFollow(FOLLOW_65);
            	            lv_right_4_2=ruleConditionalTerm();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getAndEventTermRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_2,
            	            								"org.xtext.roqme.RoQME.ConditionalTerm");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


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
    // $ANTLR end "ruleAndEventTerm"


    // $ANTLR start "entryRuleNotEventTerm"
    // InternalMIRoN.g:5963:1: entryRuleNotEventTerm returns [EObject current=null] : iv_ruleNotEventTerm= ruleNotEventTerm EOF ;
    public final EObject entryRuleNotEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotEventTerm = null;


        try {
            // InternalMIRoN.g:5963:53: (iv_ruleNotEventTerm= ruleNotEventTerm EOF )
            // InternalMIRoN.g:5964:2: iv_ruleNotEventTerm= ruleNotEventTerm EOF
            {
             newCompositeNode(grammarAccess.getNotEventTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotEventTerm=ruleNotEventTerm();

            state._fsp--;

             current =iv_ruleNotEventTerm; 
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
    // $ANTLR end "entryRuleNotEventTerm"


    // $ANTLR start "ruleNotEventTerm"
    // InternalMIRoN.g:5970:1: ruleNotEventTerm returns [EObject current=null] : ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) ) ;
    public final EObject ruleNotEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5976:2: ( ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) ) )
            // InternalMIRoN.g:5977:2: ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) )
            {
            // InternalMIRoN.g:5977:2: ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) )
            // InternalMIRoN.g:5978:3: () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) )
            {
            // InternalMIRoN.g:5978:3: ()
            // InternalMIRoN.g:5979:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotEventTermAccess().getNotEventTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,81,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getNotEventTermAccess().getNotKeyword_1());
            		
            // InternalMIRoN.g:5989:3: ( (lv_term_2_0= ruleConditionalTerm ) )
            // InternalMIRoN.g:5990:4: (lv_term_2_0= ruleConditionalTerm )
            {
            // InternalMIRoN.g:5990:4: (lv_term_2_0= ruleConditionalTerm )
            // InternalMIRoN.g:5991:5: lv_term_2_0= ruleConditionalTerm
            {

            					newCompositeNode(grammarAccess.getNotEventTermAccess().getTermConditionalTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_term_2_0=ruleConditionalTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotEventTermRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.xtext.roqme.RoQME.ConditionalTerm");
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
    // $ANTLR end "ruleNotEventTerm"


    // $ANTLR start "entryRuleConditionalTerm"
    // InternalMIRoN.g:6012:1: entryRuleConditionalTerm returns [EObject current=null] : iv_ruleConditionalTerm= ruleConditionalTerm EOF ;
    public final EObject entryRuleConditionalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalTerm = null;


        try {
            // InternalMIRoN.g:6012:56: (iv_ruleConditionalTerm= ruleConditionalTerm EOF )
            // InternalMIRoN.g:6013:2: iv_ruleConditionalTerm= ruleConditionalTerm EOF
            {
             newCompositeNode(grammarAccess.getConditionalTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionalTerm=ruleConditionalTerm();

            state._fsp--;

             current =iv_ruleConditionalTerm; 
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
    // $ANTLR end "entryRuleConditionalTerm"


    // $ANTLR start "ruleConditionalTerm"
    // InternalMIRoN.g:6019:1: ruleConditionalTerm returns [EObject current=null] : (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? ) ;
    public final EObject ruleConditionalTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_OrBooleanTerm_0 = null;

        EObject lv_terms_3_0 = null;

        EObject lv_terms_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6025:2: ( (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? ) )
            // InternalMIRoN.g:6026:2: (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? )
            {
            // InternalMIRoN.g:6026:2: (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? )
            // InternalMIRoN.g:6027:3: this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )?
            {

            			newCompositeNode(grammarAccess.getConditionalTermAccess().getOrBooleanTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_66);
            this_OrBooleanTerm_0=ruleOrBooleanTerm();

            state._fsp--;


            			current = this_OrBooleanTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:6035:3: ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==82) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalMIRoN.g:6036:4: () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) )
                    {
                    // InternalMIRoN.g:6036:4: ()
                    // InternalMIRoN.g:6037:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getConditionalTermAccess().getConditionalTermTermsAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,82,FOLLOW_34); 

                    				newLeafNode(otherlv_2, grammarAccess.getConditionalTermAccess().getQuestionMarkKeyword_1_1());
                    			
                    // InternalMIRoN.g:6047:4: ( (lv_terms_3_0= ruleOrBooleanTerm ) )
                    // InternalMIRoN.g:6048:5: (lv_terms_3_0= ruleOrBooleanTerm )
                    {
                    // InternalMIRoN.g:6048:5: (lv_terms_3_0= ruleOrBooleanTerm )
                    // InternalMIRoN.g:6049:6: lv_terms_3_0= ruleOrBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getConditionalTermAccess().getTermsOrBooleanTermParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_terms_3_0=ruleOrBooleanTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalTermRule());
                    						}
                    						add(
                    							current,
                    							"terms",
                    							lv_terms_3_0,
                    							"org.xtext.roqme.RoQME.OrBooleanTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,20,FOLLOW_34); 

                    				newLeafNode(otherlv_4, grammarAccess.getConditionalTermAccess().getColonKeyword_1_3());
                    			
                    // InternalMIRoN.g:6070:4: ( (lv_terms_5_0= ruleConditionalTerm ) )
                    // InternalMIRoN.g:6071:5: (lv_terms_5_0= ruleConditionalTerm )
                    {
                    // InternalMIRoN.g:6071:5: (lv_terms_5_0= ruleConditionalTerm )
                    // InternalMIRoN.g:6072:6: lv_terms_5_0= ruleConditionalTerm
                    {

                    						newCompositeNode(grammarAccess.getConditionalTermAccess().getTermsConditionalTermParserRuleCall_1_4_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_terms_5_0=ruleConditionalTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalTermRule());
                    						}
                    						add(
                    							current,
                    							"terms",
                    							lv_terms_5_0,
                    							"org.xtext.roqme.RoQME.ConditionalTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleConditionalTerm"


    // $ANTLR start "entryRuleOrBooleanTerm"
    // InternalMIRoN.g:6094:1: entryRuleOrBooleanTerm returns [EObject current=null] : iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF ;
    public final EObject entryRuleOrBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBooleanTerm = null;


        try {
            // InternalMIRoN.g:6094:54: (iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF )
            // InternalMIRoN.g:6095:2: iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF
            {
             newCompositeNode(grammarAccess.getOrBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrBooleanTerm=ruleOrBooleanTerm();

            state._fsp--;

             current =iv_ruleOrBooleanTerm; 
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
    // $ANTLR end "entryRuleOrBooleanTerm"


    // $ANTLR start "ruleOrBooleanTerm"
    // InternalMIRoN.g:6101:1: ruleOrBooleanTerm returns [EObject current=null] : (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* ) ;
    public final EObject ruleOrBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndBooleanTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6107:2: ( (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* ) )
            // InternalMIRoN.g:6108:2: (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* )
            {
            // InternalMIRoN.g:6108:2: (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* )
            // InternalMIRoN.g:6109:3: this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrBooleanTermAccess().getAndBooleanTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_67);
            this_AndBooleanTerm_0=ruleAndBooleanTerm();

            state._fsp--;


            			current = this_AndBooleanTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:6117:3: ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==83) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalMIRoN.g:6118:4: () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) )
            	    {
            	    // InternalMIRoN.g:6118:4: ()
            	    // InternalMIRoN.g:6119:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrBooleanTermAccess().getOrBooleanTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,83,FOLLOW_34); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrBooleanTermAccess().getVerticalLineKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:6129:4: ( (lv_right_3_0= ruleAndBooleanTerm ) )
            	    // InternalMIRoN.g:6130:5: (lv_right_3_0= ruleAndBooleanTerm )
            	    {
            	    // InternalMIRoN.g:6130:5: (lv_right_3_0= ruleAndBooleanTerm )
            	    // InternalMIRoN.g:6131:6: lv_right_3_0= ruleAndBooleanTerm
            	    {

            	    						newCompositeNode(grammarAccess.getOrBooleanTermAccess().getRightAndBooleanTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_67);
            	    lv_right_3_0=ruleAndBooleanTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrBooleanTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.roqme.RoQME.AndBooleanTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);


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
    // $ANTLR end "ruleOrBooleanTerm"


    // $ANTLR start "entryRuleAndBooleanTerm"
    // InternalMIRoN.g:6153:1: entryRuleAndBooleanTerm returns [EObject current=null] : iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF ;
    public final EObject entryRuleAndBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndBooleanTerm = null;


        try {
            // InternalMIRoN.g:6153:55: (iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF )
            // InternalMIRoN.g:6154:2: iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF
            {
             newCompositeNode(grammarAccess.getAndBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndBooleanTerm=ruleAndBooleanTerm();

            state._fsp--;

             current =iv_ruleAndBooleanTerm; 
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
    // $ANTLR end "entryRuleAndBooleanTerm"


    // $ANTLR start "ruleAndBooleanTerm"
    // InternalMIRoN.g:6160:1: ruleAndBooleanTerm returns [EObject current=null] : ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* ) ;
    public final EObject ruleAndBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_NotBooleanTerm_0 = null;

        EObject this_RelationalTerm_1 = null;

        EObject lv_right_4_1 = null;

        EObject lv_right_4_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6166:2: ( ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* ) )
            // InternalMIRoN.g:6167:2: ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* )
            {
            // InternalMIRoN.g:6167:2: ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* )
            // InternalMIRoN.g:6168:3: (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )*
            {
            // InternalMIRoN.g:6168:3: (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==85) ) {
                alt84=1;
            }
            else if ( ((LA84_0>=RULE_INT && LA84_0<=RULE_ID)||LA84_0==16||LA84_0==19||LA84_0==63||LA84_0==93||(LA84_0>=96 && LA84_0<=97)||(LA84_0>=100 && LA84_0<=101)||(LA84_0>=116 && LA84_0<=136)) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalMIRoN.g:6169:4: this_NotBooleanTerm_0= ruleNotBooleanTerm
                    {

                    				newCompositeNode(grammarAccess.getAndBooleanTermAccess().getNotBooleanTermParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_68);
                    this_NotBooleanTerm_0=ruleNotBooleanTerm();

                    state._fsp--;


                    				current = this_NotBooleanTerm_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6178:4: this_RelationalTerm_1= ruleRelationalTerm
                    {

                    				newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRelationalTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_68);
                    this_RelationalTerm_1=ruleRelationalTerm();

                    state._fsp--;


                    				current = this_RelationalTerm_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:6187:3: ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==84) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalMIRoN.g:6188:4: () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) )
            	    {
            	    // InternalMIRoN.g:6188:4: ()
            	    // InternalMIRoN.g:6189:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndBooleanTermAccess().getAndBooleanTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,84,FOLLOW_34); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAndBooleanTermAccess().getAmpersandKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:6199:4: ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) )
            	    // InternalMIRoN.g:6200:5: ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) )
            	    {
            	    // InternalMIRoN.g:6200:5: ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) )
            	    // InternalMIRoN.g:6201:6: (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm )
            	    {
            	    // InternalMIRoN.g:6201:6: (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm )
            	    int alt85=2;
            	    int LA85_0 = input.LA(1);

            	    if ( (LA85_0==85) ) {
            	        alt85=1;
            	    }
            	    else if ( ((LA85_0>=RULE_INT && LA85_0<=RULE_ID)||LA85_0==16||LA85_0==19||LA85_0==63||LA85_0==93||(LA85_0>=96 && LA85_0<=97)||(LA85_0>=100 && LA85_0<=101)||(LA85_0>=116 && LA85_0<=136)) ) {
            	        alt85=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 85, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt85) {
            	        case 1 :
            	            // InternalMIRoN.g:6202:7: lv_right_4_1= ruleNotBooleanTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRightNotBooleanTermParserRuleCall_1_2_0_0());
            	            						
            	            pushFollow(FOLLOW_68);
            	            lv_right_4_1=ruleNotBooleanTerm();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getAndBooleanTermRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_1,
            	            								"org.xtext.roqme.RoQME.NotBooleanTerm");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalMIRoN.g:6218:7: lv_right_4_2= ruleRelationalTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRightRelationalTermParserRuleCall_1_2_0_1());
            	            						
            	            pushFollow(FOLLOW_68);
            	            lv_right_4_2=ruleRelationalTerm();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getAndBooleanTermRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_2,
            	            								"org.xtext.roqme.RoQME.RelationalTerm");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


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
    // $ANTLR end "ruleAndBooleanTerm"


    // $ANTLR start "entryRuleNotBooleanTerm"
    // InternalMIRoN.g:6241:1: entryRuleNotBooleanTerm returns [EObject current=null] : iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF ;
    public final EObject entryRuleNotBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotBooleanTerm = null;


        try {
            // InternalMIRoN.g:6241:55: (iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF )
            // InternalMIRoN.g:6242:2: iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF
            {
             newCompositeNode(grammarAccess.getNotBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotBooleanTerm=ruleNotBooleanTerm();

            state._fsp--;

             current =iv_ruleNotBooleanTerm; 
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
    // $ANTLR end "entryRuleNotBooleanTerm"


    // $ANTLR start "ruleNotBooleanTerm"
    // InternalMIRoN.g:6248:1: ruleNotBooleanTerm returns [EObject current=null] : ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) ) ;
    public final EObject ruleNotBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6254:2: ( ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) ) )
            // InternalMIRoN.g:6255:2: ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) )
            {
            // InternalMIRoN.g:6255:2: ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) )
            // InternalMIRoN.g:6256:3: () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) )
            {
            // InternalMIRoN.g:6256:3: ()
            // InternalMIRoN.g:6257:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotBooleanTermAccess().getNotBooleanTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,85,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getNotBooleanTermAccess().getExclamationMarkKeyword_1());
            		
            // InternalMIRoN.g:6267:3: ( (lv_term_2_0= ruleRelationalTerm ) )
            // InternalMIRoN.g:6268:4: (lv_term_2_0= ruleRelationalTerm )
            {
            // InternalMIRoN.g:6268:4: (lv_term_2_0= ruleRelationalTerm )
            // InternalMIRoN.g:6269:5: lv_term_2_0= ruleRelationalTerm
            {

            					newCompositeNode(grammarAccess.getNotBooleanTermAccess().getTermRelationalTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_term_2_0=ruleRelationalTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotBooleanTermRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.xtext.roqme.RoQME.RelationalTerm");
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
    // $ANTLR end "ruleNotBooleanTerm"


    // $ANTLR start "entryRuleRelationalTerm"
    // InternalMIRoN.g:6290:1: entryRuleRelationalTerm returns [EObject current=null] : iv_ruleRelationalTerm= ruleRelationalTerm EOF ;
    public final EObject entryRuleRelationalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalTerm = null;


        try {
            // InternalMIRoN.g:6290:55: (iv_ruleRelationalTerm= ruleRelationalTerm EOF )
            // InternalMIRoN.g:6291:2: iv_ruleRelationalTerm= ruleRelationalTerm EOF
            {
             newCompositeNode(grammarAccess.getRelationalTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationalTerm=ruleRelationalTerm();

            state._fsp--;

             current =iv_ruleRelationalTerm; 
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
    // $ANTLR end "entryRuleRelationalTerm"


    // $ANTLR start "ruleRelationalTerm"
    // InternalMIRoN.g:6297:1: ruleRelationalTerm returns [EObject current=null] : (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? ) ;
    public final EObject ruleRelationalTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject this_AdditionTerm_0 = null;

        EObject lv_right_13_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6303:2: ( (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? ) )
            // InternalMIRoN.g:6304:2: (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? )
            {
            // InternalMIRoN.g:6304:2: (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? )
            // InternalMIRoN.g:6305:3: this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )?
            {

            			newCompositeNode(grammarAccess.getRelationalTermAccess().getAdditionTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_69);
            this_AdditionTerm_0=ruleAdditionTerm();

            state._fsp--;


            			current = this_AdditionTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:6313:3: ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( ((LA88_0>=86 && LA88_0<=91)) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalMIRoN.g:6314:4: ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) )
                    {
                    // InternalMIRoN.g:6314:4: ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) )
                    int alt87=6;
                    switch ( input.LA(1) ) {
                    case 86:
                        {
                        alt87=1;
                        }
                        break;
                    case 87:
                        {
                        alt87=2;
                        }
                        break;
                    case 88:
                        {
                        alt87=3;
                        }
                        break;
                    case 89:
                        {
                        alt87=4;
                        }
                        break;
                    case 90:
                        {
                        alt87=5;
                        }
                        break;
                    case 91:
                        {
                        alt87=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 87, 0, input);

                        throw nvae;
                    }

                    switch (alt87) {
                        case 1 :
                            // InternalMIRoN.g:6315:5: ( () otherlv_2= '=' )
                            {
                            // InternalMIRoN.g:6315:5: ( () otherlv_2= '=' )
                            // InternalMIRoN.g:6316:6: () otherlv_2= '='
                            {
                            // InternalMIRoN.g:6316:6: ()
                            // InternalMIRoN.g:6317:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getEqualTermLeftAction_1_0_0_0(),
                            								current);
                            						

                            }

                            otherlv_2=(Token)match(input,86,FOLLOW_34); 

                            						newLeafNode(otherlv_2, grammarAccess.getRelationalTermAccess().getEqualsSignKeyword_1_0_0_1());
                            					

                            }


                            }
                            break;
                        case 2 :
                            // InternalMIRoN.g:6329:5: ( () otherlv_4= '<' )
                            {
                            // InternalMIRoN.g:6329:5: ( () otherlv_4= '<' )
                            // InternalMIRoN.g:6330:6: () otherlv_4= '<'
                            {
                            // InternalMIRoN.g:6330:6: ()
                            // InternalMIRoN.g:6331:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getLessThanTermLeftAction_1_0_1_0(),
                            								current);
                            						

                            }

                            otherlv_4=(Token)match(input,87,FOLLOW_34); 

                            						newLeafNode(otherlv_4, grammarAccess.getRelationalTermAccess().getLessThanSignKeyword_1_0_1_1());
                            					

                            }


                            }
                            break;
                        case 3 :
                            // InternalMIRoN.g:6343:5: ( () otherlv_6= '>' )
                            {
                            // InternalMIRoN.g:6343:5: ( () otherlv_6= '>' )
                            // InternalMIRoN.g:6344:6: () otherlv_6= '>'
                            {
                            // InternalMIRoN.g:6344:6: ()
                            // InternalMIRoN.g:6345:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getGreaterThanTermLeftAction_1_0_2_0(),
                            								current);
                            						

                            }

                            otherlv_6=(Token)match(input,88,FOLLOW_34); 

                            						newLeafNode(otherlv_6, grammarAccess.getRelationalTermAccess().getGreaterThanSignKeyword_1_0_2_1());
                            					

                            }


                            }
                            break;
                        case 4 :
                            // InternalMIRoN.g:6357:5: ( () otherlv_8= '<=' )
                            {
                            // InternalMIRoN.g:6357:5: ( () otherlv_8= '<=' )
                            // InternalMIRoN.g:6358:6: () otherlv_8= '<='
                            {
                            // InternalMIRoN.g:6358:6: ()
                            // InternalMIRoN.g:6359:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getLessEqualTermLeftAction_1_0_3_0(),
                            								current);
                            						

                            }

                            otherlv_8=(Token)match(input,89,FOLLOW_34); 

                            						newLeafNode(otherlv_8, grammarAccess.getRelationalTermAccess().getLessThanSignEqualsSignKeyword_1_0_3_1());
                            					

                            }


                            }
                            break;
                        case 5 :
                            // InternalMIRoN.g:6371:5: ( () otherlv_10= '>=' )
                            {
                            // InternalMIRoN.g:6371:5: ( () otherlv_10= '>=' )
                            // InternalMIRoN.g:6372:6: () otherlv_10= '>='
                            {
                            // InternalMIRoN.g:6372:6: ()
                            // InternalMIRoN.g:6373:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getGreaterEqualTermLeftAction_1_0_4_0(),
                            								current);
                            						

                            }

                            otherlv_10=(Token)match(input,90,FOLLOW_34); 

                            						newLeafNode(otherlv_10, grammarAccess.getRelationalTermAccess().getGreaterThanSignEqualsSignKeyword_1_0_4_1());
                            					

                            }


                            }
                            break;
                        case 6 :
                            // InternalMIRoN.g:6385:5: ( () otherlv_12= '!=' )
                            {
                            // InternalMIRoN.g:6385:5: ( () otherlv_12= '!=' )
                            // InternalMIRoN.g:6386:6: () otherlv_12= '!='
                            {
                            // InternalMIRoN.g:6386:6: ()
                            // InternalMIRoN.g:6387:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getNotEqualTermLeftAction_1_0_5_0(),
                            								current);
                            						

                            }

                            otherlv_12=(Token)match(input,91,FOLLOW_34); 

                            						newLeafNode(otherlv_12, grammarAccess.getRelationalTermAccess().getExclamationMarkEqualsSignKeyword_1_0_5_1());
                            					

                            }


                            }
                            break;

                    }

                    // InternalMIRoN.g:6399:4: ( (lv_right_13_0= ruleAdditionTerm ) )
                    // InternalMIRoN.g:6400:5: (lv_right_13_0= ruleAdditionTerm )
                    {
                    // InternalMIRoN.g:6400:5: (lv_right_13_0= ruleAdditionTerm )
                    // InternalMIRoN.g:6401:6: lv_right_13_0= ruleAdditionTerm
                    {

                    						newCompositeNode(grammarAccess.getRelationalTermAccess().getRightAdditionTermParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_13_0=ruleAdditionTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelationalTermRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_13_0,
                    							"org.xtext.roqme.RoQME.AdditionTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleRelationalTerm"


    // $ANTLR start "entryRuleAdditionTerm"
    // InternalMIRoN.g:6423:1: entryRuleAdditionTerm returns [EObject current=null] : iv_ruleAdditionTerm= ruleAdditionTerm EOF ;
    public final EObject entryRuleAdditionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionTerm = null;


        try {
            // InternalMIRoN.g:6423:53: (iv_ruleAdditionTerm= ruleAdditionTerm EOF )
            // InternalMIRoN.g:6424:2: iv_ruleAdditionTerm= ruleAdditionTerm EOF
            {
             newCompositeNode(grammarAccess.getAdditionTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditionTerm=ruleAdditionTerm();

            state._fsp--;

             current =iv_ruleAdditionTerm; 
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
    // $ANTLR end "entryRuleAdditionTerm"


    // $ANTLR start "ruleAdditionTerm"
    // InternalMIRoN.g:6430:1: ruleAdditionTerm returns [EObject current=null] : (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* ) ;
    public final EObject ruleAdditionTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_MultiplicationTerm_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6436:2: ( (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* ) )
            // InternalMIRoN.g:6437:2: (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* )
            {
            // InternalMIRoN.g:6437:2: (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* )
            // InternalMIRoN.g:6438:3: this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionTermAccess().getMultiplicationTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_70);
            this_MultiplicationTerm_0=ruleMultiplicationTerm();

            state._fsp--;


            			current = this_MultiplicationTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:6446:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( ((LA90_0>=92 && LA90_0<=93)) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalMIRoN.g:6447:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) )
            	    {
            	    // InternalMIRoN.g:6447:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt89=2;
            	    int LA89_0 = input.LA(1);

            	    if ( (LA89_0==92) ) {
            	        alt89=1;
            	    }
            	    else if ( (LA89_0==93) ) {
            	        alt89=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 89, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt89) {
            	        case 1 :
            	            // InternalMIRoN.g:6448:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalMIRoN.g:6448:5: ( () otherlv_2= '+' )
            	            // InternalMIRoN.g:6449:6: () otherlv_2= '+'
            	            {
            	            // InternalMIRoN.g:6449:6: ()
            	            // InternalMIRoN.g:6450:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionTermAccess().getAddTermLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,92,FOLLOW_34); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionTermAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMIRoN.g:6462:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalMIRoN.g:6462:5: ( () otherlv_4= '-' )
            	            // InternalMIRoN.g:6463:6: () otherlv_4= '-'
            	            {
            	            // InternalMIRoN.g:6463:6: ()
            	            // InternalMIRoN.g:6464:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionTermAccess().getSubTermLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,93,FOLLOW_34); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionTermAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMIRoN.g:6476:4: ( (lv_right_5_0= ruleMultiplicationTerm ) )
            	    // InternalMIRoN.g:6477:5: (lv_right_5_0= ruleMultiplicationTerm )
            	    {
            	    // InternalMIRoN.g:6477:5: (lv_right_5_0= ruleMultiplicationTerm )
            	    // InternalMIRoN.g:6478:6: lv_right_5_0= ruleMultiplicationTerm
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionTermAccess().getRightMultiplicationTermParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_70);
            	    lv_right_5_0=ruleMultiplicationTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"org.xtext.roqme.RoQME.MultiplicationTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


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
    // $ANTLR end "ruleAdditionTerm"


    // $ANTLR start "entryRuleMultiplicationTerm"
    // InternalMIRoN.g:6500:1: entryRuleMultiplicationTerm returns [EObject current=null] : iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF ;
    public final EObject entryRuleMultiplicationTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicationTerm = null;


        try {
            // InternalMIRoN.g:6500:59: (iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF )
            // InternalMIRoN.g:6501:2: iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicationTerm=ruleMultiplicationTerm();

            state._fsp--;

             current =iv_ruleMultiplicationTerm; 
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
    // $ANTLR end "entryRuleMultiplicationTerm"


    // $ANTLR start "ruleMultiplicationTerm"
    // InternalMIRoN.g:6507:1: ruleMultiplicationTerm returns [EObject current=null] : (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* ) ;
    public final EObject ruleMultiplicationTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryTerm_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6513:2: ( (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* ) )
            // InternalMIRoN.g:6514:2: (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* )
            {
            // InternalMIRoN.g:6514:2: (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* )
            // InternalMIRoN.g:6515:3: this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationTermAccess().getPrimaryTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_71);
            this_PrimaryTerm_0=rulePrimaryTerm();

            state._fsp--;


            			current = this_PrimaryTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:6523:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( ((LA92_0>=94 && LA92_0<=95)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalMIRoN.g:6524:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) )
            	    {
            	    // InternalMIRoN.g:6524:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt91=2;
            	    int LA91_0 = input.LA(1);

            	    if ( (LA91_0==94) ) {
            	        alt91=1;
            	    }
            	    else if ( (LA91_0==95) ) {
            	        alt91=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 91, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt91) {
            	        case 1 :
            	            // InternalMIRoN.g:6525:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalMIRoN.g:6525:5: ( () otherlv_2= '*' )
            	            // InternalMIRoN.g:6526:6: () otherlv_2= '*'
            	            {
            	            // InternalMIRoN.g:6526:6: ()
            	            // InternalMIRoN.g:6527:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationTermAccess().getMultTermLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,94,FOLLOW_34); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationTermAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMIRoN.g:6539:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalMIRoN.g:6539:5: ( () otherlv_4= '/' )
            	            // InternalMIRoN.g:6540:6: () otherlv_4= '/'
            	            {
            	            // InternalMIRoN.g:6540:6: ()
            	            // InternalMIRoN.g:6541:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationTermAccess().getDivTermLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,95,FOLLOW_34); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationTermAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMIRoN.g:6553:4: ( (lv_right_5_0= rulePrimaryTerm ) )
            	    // InternalMIRoN.g:6554:5: (lv_right_5_0= rulePrimaryTerm )
            	    {
            	    // InternalMIRoN.g:6554:5: (lv_right_5_0= rulePrimaryTerm )
            	    // InternalMIRoN.g:6555:6: lv_right_5_0= rulePrimaryTerm
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationTermAccess().getRightPrimaryTermParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_right_5_0=rulePrimaryTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"org.xtext.roqme.RoQME.PrimaryTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


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
    // $ANTLR end "ruleMultiplicationTerm"


    // $ANTLR start "entryRulePrimaryTerm"
    // InternalMIRoN.g:6577:1: entryRulePrimaryTerm returns [EObject current=null] : iv_rulePrimaryTerm= rulePrimaryTerm EOF ;
    public final EObject entryRulePrimaryTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryTerm = null;


        try {
            // InternalMIRoN.g:6577:52: (iv_rulePrimaryTerm= rulePrimaryTerm EOF )
            // InternalMIRoN.g:6578:2: iv_rulePrimaryTerm= rulePrimaryTerm EOF
            {
             newCompositeNode(grammarAccess.getPrimaryTermRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryTerm=rulePrimaryTerm();

            state._fsp--;

             current =iv_rulePrimaryTerm; 
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
    // $ANTLR end "entryRulePrimaryTerm"


    // $ANTLR start "rulePrimaryTerm"
    // InternalMIRoN.g:6584:1: rulePrimaryTerm returns [EObject current=null] : ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm ) ;
    public final EObject rulePrimaryTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Term_1 = null;

        EObject this_ConstTerm_3 = null;

        EObject this_VarTerm_4 = null;

        EObject this_SelfTerm_5 = null;

        EObject this_FunctionTerm_6 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6590:2: ( ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm ) )
            // InternalMIRoN.g:6591:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )
            {
            // InternalMIRoN.g:6591:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )
            int alt93=5;
            alt93 = dfa93.predict(input);
            switch (alt93) {
                case 1 :
                    // InternalMIRoN.g:6592:3: (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' )
                    {
                    // InternalMIRoN.g:6592:3: (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' )
                    // InternalMIRoN.g:6593:4: otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_34); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryTermAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryTermAccess().getTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_14);
                    this_Term_1=ruleTerm();

                    state._fsp--;


                    				current = this_Term_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryTermAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6611:3: this_ConstTerm_3= ruleConstTerm
                    {

                    			newCompositeNode(grammarAccess.getPrimaryTermAccess().getConstTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConstTerm_3=ruleConstTerm();

                    state._fsp--;


                    			current = this_ConstTerm_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:6620:3: this_VarTerm_4= ruleVarTerm
                    {

                    			newCompositeNode(grammarAccess.getPrimaryTermAccess().getVarTermParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_VarTerm_4=ruleVarTerm();

                    state._fsp--;


                    			current = this_VarTerm_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:6629:3: this_SelfTerm_5= ruleSelfTerm
                    {

                    			newCompositeNode(grammarAccess.getPrimaryTermAccess().getSelfTermParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SelfTerm_5=ruleSelfTerm();

                    state._fsp--;


                    			current = this_SelfTerm_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:6638:3: this_FunctionTerm_6= ruleFunctionTerm
                    {

                    			newCompositeNode(grammarAccess.getPrimaryTermAccess().getFunctionTermParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionTerm_6=ruleFunctionTerm();

                    state._fsp--;


                    			current = this_FunctionTerm_6;
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
    // $ANTLR end "rulePrimaryTerm"


    // $ANTLR start "entryRuleVarTerm"
    // InternalMIRoN.g:6650:1: entryRuleVarTerm returns [EObject current=null] : iv_ruleVarTerm= ruleVarTerm EOF ;
    public final EObject entryRuleVarTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarTerm = null;


        try {
            // InternalMIRoN.g:6650:48: (iv_ruleVarTerm= ruleVarTerm EOF )
            // InternalMIRoN.g:6651:2: iv_ruleVarTerm= ruleVarTerm EOF
            {
             newCompositeNode(grammarAccess.getVarTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarTerm=ruleVarTerm();

            state._fsp--;

             current =iv_ruleVarTerm; 
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
    // $ANTLR end "entryRuleVarTerm"


    // $ANTLR start "ruleVarTerm"
    // InternalMIRoN.g:6657:1: ruleVarTerm returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVarTerm() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMIRoN.g:6663:2: ( ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:6664:2: ( ( ruleQualifiedName ) )
            {
            // InternalMIRoN.g:6664:2: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:6665:3: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:6665:3: ( ruleQualifiedName )
            // InternalMIRoN.g:6666:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVarTermRule());
            				}
            			

            				newCompositeNode(grammarAccess.getVarTermAccess().getVariableTypedVariableCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleVarTerm"


    // $ANTLR start "entryRuleConstTerm"
    // InternalMIRoN.g:6683:1: entryRuleConstTerm returns [EObject current=null] : iv_ruleConstTerm= ruleConstTerm EOF ;
    public final EObject entryRuleConstTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstTerm = null;


        try {
            // InternalMIRoN.g:6683:50: (iv_ruleConstTerm= ruleConstTerm EOF )
            // InternalMIRoN.g:6684:2: iv_ruleConstTerm= ruleConstTerm EOF
            {
             newCompositeNode(grammarAccess.getConstTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstTerm=ruleConstTerm();

            state._fsp--;

             current =iv_ruleConstTerm; 
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
    // $ANTLR end "entryRuleConstTerm"


    // $ANTLR start "ruleConstTerm"
    // InternalMIRoN.g:6690:1: ruleConstTerm returns [EObject current=null] : ( (lv_value_0_0= ruleTypedValue ) ) ;
    public final EObject ruleConstTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6696:2: ( ( (lv_value_0_0= ruleTypedValue ) ) )
            // InternalMIRoN.g:6697:2: ( (lv_value_0_0= ruleTypedValue ) )
            {
            // InternalMIRoN.g:6697:2: ( (lv_value_0_0= ruleTypedValue ) )
            // InternalMIRoN.g:6698:3: (lv_value_0_0= ruleTypedValue )
            {
            // InternalMIRoN.g:6698:3: (lv_value_0_0= ruleTypedValue )
            // InternalMIRoN.g:6699:4: lv_value_0_0= ruleTypedValue
            {

            				newCompositeNode(grammarAccess.getConstTermAccess().getValueTypedValueParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleTypedValue();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getConstTermRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.roqme.RoQME.TypedValue");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleConstTerm"


    // $ANTLR start "entryRuleSelfTerm"
    // InternalMIRoN.g:6719:1: entryRuleSelfTerm returns [EObject current=null] : iv_ruleSelfTerm= ruleSelfTerm EOF ;
    public final EObject entryRuleSelfTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfTerm = null;


        try {
            // InternalMIRoN.g:6719:49: (iv_ruleSelfTerm= ruleSelfTerm EOF )
            // InternalMIRoN.g:6720:2: iv_ruleSelfTerm= ruleSelfTerm EOF
            {
             newCompositeNode(grammarAccess.getSelfTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelfTerm=ruleSelfTerm();

            state._fsp--;

             current =iv_ruleSelfTerm; 
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
    // $ANTLR end "entryRuleSelfTerm"


    // $ANTLR start "ruleSelfTerm"
    // InternalMIRoN.g:6726:1: ruleSelfTerm returns [EObject current=null] : ( () otherlv_1= 'belief' ) ;
    public final EObject ruleSelfTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6732:2: ( ( () otherlv_1= 'belief' ) )
            // InternalMIRoN.g:6733:2: ( () otherlv_1= 'belief' )
            {
            // InternalMIRoN.g:6733:2: ( () otherlv_1= 'belief' )
            // InternalMIRoN.g:6734:3: () otherlv_1= 'belief'
            {
            // InternalMIRoN.g:6734:3: ()
            // InternalMIRoN.g:6735:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSelfTermAccess().getSelfTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,96,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSelfTermAccess().getBeliefKeyword_1());
            		

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
    // $ANTLR end "ruleSelfTerm"


    // $ANTLR start "entryRuleFunctionTerm"
    // InternalMIRoN.g:6749:1: entryRuleFunctionTerm returns [EObject current=null] : iv_ruleFunctionTerm= ruleFunctionTerm EOF ;
    public final EObject entryRuleFunctionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionTerm = null;


        try {
            // InternalMIRoN.g:6749:53: (iv_ruleFunctionTerm= ruleFunctionTerm EOF )
            // InternalMIRoN.g:6750:2: iv_ruleFunctionTerm= ruleFunctionTerm EOF
            {
             newCompositeNode(grammarAccess.getFunctionTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionTerm=ruleFunctionTerm();

            state._fsp--;

             current =iv_ruleFunctionTerm; 
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
    // $ANTLR end "entryRuleFunctionTerm"


    // $ANTLR start "ruleFunctionTerm"
    // InternalMIRoN.g:6756:1: ruleFunctionTerm returns [EObject current=null] : (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction ) ;
    public final EObject ruleFunctionTerm() throws RecognitionException {
        EObject current = null;

        EObject this_ArithFunction_0 = null;

        EObject this_AggregationFunction_1 = null;

        EObject this_PatternFunction_2 = null;

        EObject this_CollectionFunction_3 = null;

        EObject this_ScheduleFunction_4 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6762:2: ( (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction ) )
            // InternalMIRoN.g:6763:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )
            {
            // InternalMIRoN.g:6763:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )
            int alt94=5;
            alt94 = dfa94.predict(input);
            switch (alt94) {
                case 1 :
                    // InternalMIRoN.g:6764:3: this_ArithFunction_0= ruleArithFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getArithFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithFunction_0=ruleArithFunction();

                    state._fsp--;


                    			current = this_ArithFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6773:3: this_AggregationFunction_1= ruleAggregationFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getAggregationFunctionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AggregationFunction_1=ruleAggregationFunction();

                    state._fsp--;


                    			current = this_AggregationFunction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:6782:3: this_PatternFunction_2= rulePatternFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getPatternFunctionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PatternFunction_2=rulePatternFunction();

                    state._fsp--;


                    			current = this_PatternFunction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:6791:3: this_CollectionFunction_3= ruleCollectionFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getCollectionFunctionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_CollectionFunction_3=ruleCollectionFunction();

                    state._fsp--;


                    			current = this_CollectionFunction_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:6800:3: this_ScheduleFunction_4= ruleScheduleFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getScheduleFunctionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScheduleFunction_4=ruleScheduleFunction();

                    state._fsp--;


                    			current = this_ScheduleFunction_4;
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
    // $ANTLR end "ruleFunctionTerm"


    // $ANTLR start "entryRuleScheduleFunction"
    // InternalMIRoN.g:6812:1: entryRuleScheduleFunction returns [EObject current=null] : iv_ruleScheduleFunction= ruleScheduleFunction EOF ;
    public final EObject entryRuleScheduleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScheduleFunction = null;


        try {
            // InternalMIRoN.g:6812:57: (iv_ruleScheduleFunction= ruleScheduleFunction EOF )
            // InternalMIRoN.g:6813:2: iv_ruleScheduleFunction= ruleScheduleFunction EOF
            {
             newCompositeNode(grammarAccess.getScheduleFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScheduleFunction=ruleScheduleFunction();

            state._fsp--;

             current =iv_ruleScheduleFunction; 
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
    // $ANTLR end "entryRuleScheduleFunction"


    // $ANTLR start "ruleScheduleFunction"
    // InternalMIRoN.g:6819:1: ruleScheduleFunction returns [EObject current=null] : ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' ) ;
    public final EObject ruleScheduleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_pattern_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6825:2: ( ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' ) )
            // InternalMIRoN.g:6826:2: ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' )
            {
            // InternalMIRoN.g:6826:2: ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' )
            // InternalMIRoN.g:6827:3: () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')'
            {
            // InternalMIRoN.g:6827:3: ()
            // InternalMIRoN.g:6828:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getScheduleFunctionAccess().getScheduleFunctionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,97,FOLLOW_61); 

            			newLeafNode(otherlv_1, grammarAccess.getScheduleFunctionAccess().getScheduleKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getScheduleFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIRoN.g:6842:3: ( (lv_pattern_3_0= ruleEString ) )
            // InternalMIRoN.g:6843:4: (lv_pattern_3_0= ruleEString )
            {
            // InternalMIRoN.g:6843:4: (lv_pattern_3_0= ruleEString )
            // InternalMIRoN.g:6844:5: lv_pattern_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getScheduleFunctionAccess().getPatternEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
            lv_pattern_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScheduleFunctionRule());
            					}
            					set(
            						current,
            						"pattern",
            						lv_pattern_3_0,
            						"org.xtext.roqme.RoQME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getScheduleFunctionAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleScheduleFunction"


    // $ANTLR start "entryRuleArithFunction"
    // InternalMIRoN.g:6869:1: entryRuleArithFunction returns [EObject current=null] : iv_ruleArithFunction= ruleArithFunction EOF ;
    public final EObject entryRuleArithFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithFunction = null;


        try {
            // InternalMIRoN.g:6869:54: (iv_ruleArithFunction= ruleArithFunction EOF )
            // InternalMIRoN.g:6870:2: iv_ruleArithFunction= ruleArithFunction EOF
            {
             newCompositeNode(grammarAccess.getArithFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithFunction=ruleArithFunction();

            state._fsp--;

             current =iv_ruleArithFunction; 
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
    // $ANTLR end "entryRuleArithFunction"


    // $ANTLR start "ruleArithFunction"
    // InternalMIRoN.g:6876:1: ruleArithFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject ruleArithFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_terms_0_1 = null;

        EObject lv_terms_0_2 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_terms_6_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:6882:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalMIRoN.g:6883:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalMIRoN.g:6883:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalMIRoN.g:6884:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalMIRoN.g:6884:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_ID||LA96_0==96) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalMIRoN.g:6885:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalMIRoN.g:6885:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalMIRoN.g:6886:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalMIRoN.g:6886:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalMIRoN.g:6887:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalMIRoN.g:6887:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==RULE_ID) ) {
                        alt95=1;
                    }
                    else if ( (LA95_0==96) ) {
                        alt95=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 95, 0, input);

                        throw nvae;
                    }
                    switch (alt95) {
                        case 1 :
                            // InternalMIRoN.g:6888:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_72);
                            lv_terms_0_1=ruleVarTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getArithFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_1,
                            								"org.xtext.roqme.RoQME.VarTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalMIRoN.g:6904:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_72);
                            lv_terms_0_2=ruleSelfTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getArithFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_2,
                            								"org.xtext.roqme.RoQME.SelfTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,98,FOLLOW_73); 

                    				newLeafNode(otherlv_1, grammarAccess.getArithFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:6927:3: ( (lv_name_2_0= ruleArithFtnEnum ) )
            // InternalMIRoN.g:6928:4: (lv_name_2_0= ruleArithFtnEnum )
            {
            // InternalMIRoN.g:6928:4: (lv_name_2_0= ruleArithFtnEnum )
            // InternalMIRoN.g:6929:5: lv_name_2_0= ruleArithFtnEnum
            {

            					newCompositeNode(grammarAccess.getArithFunctionAccess().getNameArithFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_74);
            lv_name_2_0=ruleArithFtnEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.roqme.RoQME.ArithFtnEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:6946:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==19) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalMIRoN.g:6947:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_75); 

                    				newLeafNode(otherlv_3, grammarAccess.getArithFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMIRoN.g:6951:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( ((LA98_0>=RULE_INT && LA98_0<=RULE_ID)||LA98_0==16||LA98_0==19||LA98_0==63||LA98_0==74||LA98_0==81||LA98_0==85||LA98_0==93||(LA98_0>=96 && LA98_0<=97)||(LA98_0>=100 && LA98_0<=101)||(LA98_0>=116 && LA98_0<=136)) ) {
                        alt98=1;
                    }
                    switch (alt98) {
                        case 1 :
                            // InternalMIRoN.g:6952:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalMIRoN.g:6952:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalMIRoN.g:6953:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalMIRoN.g:6953:6: (lv_terms_4_0= ruleTerm )
                            // InternalMIRoN.g:6954:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_76);
                            lv_terms_4_0=ruleTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getArithFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_4_0,
                            								"org.xtext.roqme.RoQME.Term");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalMIRoN.g:6971:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop97:
                            do {
                                int alt97=2;
                                int LA97_0 = input.LA(1);

                                if ( (LA97_0==23) ) {
                                    alt97=1;
                                }


                                switch (alt97) {
                            	case 1 :
                            	    // InternalMIRoN.g:6972:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,23,FOLLOW_34); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getArithFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalMIRoN.g:6976:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalMIRoN.g:6977:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalMIRoN.g:6977:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalMIRoN.g:6978:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_76);
                            	    lv_terms_6_0=ruleTerm();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getArithFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"terms",
                            	    									lv_terms_6_0,
                            	    									"org.xtext.roqme.RoQME.Term");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop97;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getArithFunctionAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleArithFunction"


    // $ANTLR start "entryRuleAggregationFunction"
    // InternalMIRoN.g:7006:1: entryRuleAggregationFunction returns [EObject current=null] : iv_ruleAggregationFunction= ruleAggregationFunction EOF ;
    public final EObject entryRuleAggregationFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregationFunction = null;


        try {
            // InternalMIRoN.g:7006:60: (iv_ruleAggregationFunction= ruleAggregationFunction EOF )
            // InternalMIRoN.g:7007:2: iv_ruleAggregationFunction= ruleAggregationFunction EOF
            {
             newCompositeNode(grammarAccess.getAggregationFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAggregationFunction=ruleAggregationFunction();

            state._fsp--;

             current =iv_ruleAggregationFunction; 
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
    // $ANTLR end "entryRuleAggregationFunction"


    // $ANTLR start "ruleAggregationFunction"
    // InternalMIRoN.g:7013:1: ruleAggregationFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject ruleAggregationFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_terms_0_1 = null;

        EObject lv_terms_0_2 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_terms_6_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:7019:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalMIRoN.g:7020:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalMIRoN.g:7020:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalMIRoN.g:7021:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalMIRoN.g:7021:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==RULE_ID||LA101_0==96) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalMIRoN.g:7022:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalMIRoN.g:7022:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalMIRoN.g:7023:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalMIRoN.g:7023:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalMIRoN.g:7024:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalMIRoN.g:7024:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==RULE_ID) ) {
                        alt100=1;
                    }
                    else if ( (LA100_0==96) ) {
                        alt100=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 100, 0, input);

                        throw nvae;
                    }
                    switch (alt100) {
                        case 1 :
                            // InternalMIRoN.g:7025:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_72);
                            lv_terms_0_1=ruleVarTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_1,
                            								"org.xtext.roqme.RoQME.VarTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalMIRoN.g:7041:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_72);
                            lv_terms_0_2=ruleSelfTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_2,
                            								"org.xtext.roqme.RoQME.SelfTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,98,FOLLOW_77); 

                    				newLeafNode(otherlv_1, grammarAccess.getAggregationFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:7064:3: ( (lv_name_2_0= ruleAggregationFtnEnum ) )
            // InternalMIRoN.g:7065:4: (lv_name_2_0= ruleAggregationFtnEnum )
            {
            // InternalMIRoN.g:7065:4: (lv_name_2_0= ruleAggregationFtnEnum )
            // InternalMIRoN.g:7066:5: lv_name_2_0= ruleAggregationFtnEnum
            {

            					newCompositeNode(grammarAccess.getAggregationFunctionAccess().getNameAggregationFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_74);
            lv_name_2_0=ruleAggregationFtnEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.roqme.RoQME.AggregationFtnEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:7083:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==19) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalMIRoN.g:7084:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_75); 

                    				newLeafNode(otherlv_3, grammarAccess.getAggregationFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMIRoN.g:7088:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( ((LA103_0>=RULE_INT && LA103_0<=RULE_ID)||LA103_0==16||LA103_0==19||LA103_0==63||LA103_0==74||LA103_0==81||LA103_0==85||LA103_0==93||(LA103_0>=96 && LA103_0<=97)||(LA103_0>=100 && LA103_0<=101)||(LA103_0>=116 && LA103_0<=136)) ) {
                        alt103=1;
                    }
                    switch (alt103) {
                        case 1 :
                            // InternalMIRoN.g:7089:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalMIRoN.g:7089:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalMIRoN.g:7090:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalMIRoN.g:7090:6: (lv_terms_4_0= ruleTerm )
                            // InternalMIRoN.g:7091:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_76);
                            lv_terms_4_0=ruleTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_4_0,
                            								"org.xtext.roqme.RoQME.Term");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalMIRoN.g:7108:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop102:
                            do {
                                int alt102=2;
                                int LA102_0 = input.LA(1);

                                if ( (LA102_0==23) ) {
                                    alt102=1;
                                }


                                switch (alt102) {
                            	case 1 :
                            	    // InternalMIRoN.g:7109:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,23,FOLLOW_34); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getAggregationFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalMIRoN.g:7113:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalMIRoN.g:7114:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalMIRoN.g:7114:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalMIRoN.g:7115:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_76);
                            	    lv_terms_6_0=ruleTerm();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"terms",
                            	    									lv_terms_6_0,
                            	    									"org.xtext.roqme.RoQME.Term");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop102;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getAggregationFunctionAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleAggregationFunction"


    // $ANTLR start "entryRulePatternFunction"
    // InternalMIRoN.g:7143:1: entryRulePatternFunction returns [EObject current=null] : iv_rulePatternFunction= rulePatternFunction EOF ;
    public final EObject entryRulePatternFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternFunction = null;


        try {
            // InternalMIRoN.g:7143:56: (iv_rulePatternFunction= rulePatternFunction EOF )
            // InternalMIRoN.g:7144:2: iv_rulePatternFunction= rulePatternFunction EOF
            {
             newCompositeNode(grammarAccess.getPatternFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternFunction=rulePatternFunction();

            state._fsp--;

             current =iv_rulePatternFunction; 
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
    // $ANTLR end "entryRulePatternFunction"


    // $ANTLR start "rulePatternFunction"
    // InternalMIRoN.g:7150:1: rulePatternFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject rulePatternFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_terms_0_1 = null;

        EObject lv_terms_0_2 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_terms_6_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:7156:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalMIRoN.g:7157:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalMIRoN.g:7157:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalMIRoN.g:7158:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalMIRoN.g:7158:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_ID||LA106_0==96) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalMIRoN.g:7159:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalMIRoN.g:7159:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalMIRoN.g:7160:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalMIRoN.g:7160:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalMIRoN.g:7161:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalMIRoN.g:7161:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==RULE_ID) ) {
                        alt105=1;
                    }
                    else if ( (LA105_0==96) ) {
                        alt105=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 105, 0, input);

                        throw nvae;
                    }
                    switch (alt105) {
                        case 1 :
                            // InternalMIRoN.g:7162:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_72);
                            lv_terms_0_1=ruleVarTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_1,
                            								"org.xtext.roqme.RoQME.VarTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalMIRoN.g:7178:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_72);
                            lv_terms_0_2=ruleSelfTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_2,
                            								"org.xtext.roqme.RoQME.SelfTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,98,FOLLOW_78); 

                    				newLeafNode(otherlv_1, grammarAccess.getPatternFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:7201:3: ( (lv_name_2_0= rulePatternFtnEnum ) )
            // InternalMIRoN.g:7202:4: (lv_name_2_0= rulePatternFtnEnum )
            {
            // InternalMIRoN.g:7202:4: (lv_name_2_0= rulePatternFtnEnum )
            // InternalMIRoN.g:7203:5: lv_name_2_0= rulePatternFtnEnum
            {

            					newCompositeNode(grammarAccess.getPatternFunctionAccess().getNamePatternFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_74);
            lv_name_2_0=rulePatternFtnEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.roqme.RoQME.PatternFtnEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:7220:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==19) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalMIRoN.g:7221:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_75); 

                    				newLeafNode(otherlv_3, grammarAccess.getPatternFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMIRoN.g:7225:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( ((LA108_0>=RULE_INT && LA108_0<=RULE_ID)||LA108_0==16||LA108_0==19||LA108_0==63||LA108_0==74||LA108_0==81||LA108_0==85||LA108_0==93||(LA108_0>=96 && LA108_0<=97)||(LA108_0>=100 && LA108_0<=101)||(LA108_0>=116 && LA108_0<=136)) ) {
                        alt108=1;
                    }
                    switch (alt108) {
                        case 1 :
                            // InternalMIRoN.g:7226:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalMIRoN.g:7226:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalMIRoN.g:7227:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalMIRoN.g:7227:6: (lv_terms_4_0= ruleTerm )
                            // InternalMIRoN.g:7228:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_76);
                            lv_terms_4_0=ruleTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_4_0,
                            								"org.xtext.roqme.RoQME.Term");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalMIRoN.g:7245:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop107:
                            do {
                                int alt107=2;
                                int LA107_0 = input.LA(1);

                                if ( (LA107_0==23) ) {
                                    alt107=1;
                                }


                                switch (alt107) {
                            	case 1 :
                            	    // InternalMIRoN.g:7246:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,23,FOLLOW_34); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getPatternFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalMIRoN.g:7250:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalMIRoN.g:7251:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalMIRoN.g:7251:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalMIRoN.g:7252:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_76);
                            	    lv_terms_6_0=ruleTerm();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"terms",
                            	    									lv_terms_6_0,
                            	    									"org.xtext.roqme.RoQME.Term");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop107;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPatternFunctionAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

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
    // $ANTLR end "rulePatternFunction"


    // $ANTLR start "entryRuleCollectionFunction"
    // InternalMIRoN.g:7280:1: entryRuleCollectionFunction returns [EObject current=null] : iv_ruleCollectionFunction= ruleCollectionFunction EOF ;
    public final EObject entryRuleCollectionFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionFunction = null;


        try {
            // InternalMIRoN.g:7280:59: (iv_ruleCollectionFunction= ruleCollectionFunction EOF )
            // InternalMIRoN.g:7281:2: iv_ruleCollectionFunction= ruleCollectionFunction EOF
            {
             newCompositeNode(grammarAccess.getCollectionFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectionFunction=ruleCollectionFunction();

            state._fsp--;

             current =iv_ruleCollectionFunction; 
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
    // $ANTLR end "entryRuleCollectionFunction"


    // $ANTLR start "ruleCollectionFunction"
    // InternalMIRoN.g:7287:1: ruleCollectionFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject ruleCollectionFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_terms_0_1 = null;

        EObject lv_terms_0_2 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_terms_6_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:7293:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalMIRoN.g:7294:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalMIRoN.g:7294:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalMIRoN.g:7295:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalMIRoN.g:7295:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==RULE_ID||LA111_0==96) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalMIRoN.g:7296:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalMIRoN.g:7296:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalMIRoN.g:7297:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalMIRoN.g:7297:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalMIRoN.g:7298:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalMIRoN.g:7298:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==RULE_ID) ) {
                        alt110=1;
                    }
                    else if ( (LA110_0==96) ) {
                        alt110=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 110, 0, input);

                        throw nvae;
                    }
                    switch (alt110) {
                        case 1 :
                            // InternalMIRoN.g:7299:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_72);
                            lv_terms_0_1=ruleVarTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_1,
                            								"org.xtext.roqme.RoQME.VarTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalMIRoN.g:7315:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_72);
                            lv_terms_0_2=ruleSelfTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_2,
                            								"org.xtext.roqme.RoQME.SelfTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,98,FOLLOW_79); 

                    				newLeafNode(otherlv_1, grammarAccess.getCollectionFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:7338:3: ( (lv_name_2_0= ruleCollectionFtnEnum ) )
            // InternalMIRoN.g:7339:4: (lv_name_2_0= ruleCollectionFtnEnum )
            {
            // InternalMIRoN.g:7339:4: (lv_name_2_0= ruleCollectionFtnEnum )
            // InternalMIRoN.g:7340:5: lv_name_2_0= ruleCollectionFtnEnum
            {

            					newCompositeNode(grammarAccess.getCollectionFunctionAccess().getNameCollectionFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_74);
            lv_name_2_0=ruleCollectionFtnEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.roqme.RoQME.CollectionFtnEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:7357:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==19) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalMIRoN.g:7358:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_75); 

                    				newLeafNode(otherlv_3, grammarAccess.getCollectionFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMIRoN.g:7362:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( ((LA113_0>=RULE_INT && LA113_0<=RULE_ID)||LA113_0==16||LA113_0==19||LA113_0==63||LA113_0==74||LA113_0==81||LA113_0==85||LA113_0==93||(LA113_0>=96 && LA113_0<=97)||(LA113_0>=100 && LA113_0<=101)||(LA113_0>=116 && LA113_0<=136)) ) {
                        alt113=1;
                    }
                    switch (alt113) {
                        case 1 :
                            // InternalMIRoN.g:7363:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalMIRoN.g:7363:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalMIRoN.g:7364:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalMIRoN.g:7364:6: (lv_terms_4_0= ruleTerm )
                            // InternalMIRoN.g:7365:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_76);
                            lv_terms_4_0=ruleTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_4_0,
                            								"org.xtext.roqme.RoQME.Term");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalMIRoN.g:7382:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop112:
                            do {
                                int alt112=2;
                                int LA112_0 = input.LA(1);

                                if ( (LA112_0==23) ) {
                                    alt112=1;
                                }


                                switch (alt112) {
                            	case 1 :
                            	    // InternalMIRoN.g:7383:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,23,FOLLOW_34); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getCollectionFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalMIRoN.g:7387:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalMIRoN.g:7388:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalMIRoN.g:7388:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalMIRoN.g:7389:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_76);
                            	    lv_terms_6_0=ruleTerm();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"terms",
                            	    									lv_terms_6_0,
                            	    									"org.xtext.roqme.RoQME.Term");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop112;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getCollectionFunctionAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleCollectionFunction"


    // $ANTLR start "entryRuleEString"
    // InternalMIRoN.g:7417:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMIRoN.g:7417:47: (iv_ruleEString= ruleEString EOF )
            // InternalMIRoN.g:7418:2: iv_ruleEString= ruleEString EOF
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
    // InternalMIRoN.g:7424:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7430:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMIRoN.g:7431:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMIRoN.g:7431:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==RULE_STRING) ) {
                alt115=1;
            }
            else if ( (LA115_0==RULE_ID) ) {
                alt115=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }
            switch (alt115) {
                case 1 :
                    // InternalMIRoN.g:7432:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7440:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

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
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEDouble"
    // InternalMIRoN.g:7451:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalMIRoN.g:7451:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalMIRoN.g:7452:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
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
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalMIRoN.g:7458:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7464:2: ( ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) )
            // InternalMIRoN.g:7465:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            {
            // InternalMIRoN.g:7465:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            // InternalMIRoN.g:7466:3: (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )?
            {
            // InternalMIRoN.g:7466:3: (kw= '-' )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==93) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalMIRoN.g:7467:4: kw= '-'
                    {
                    kw=(Token)match(input,93,FOLLOW_9); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_80); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
            		
            // InternalMIRoN.g:7480:3: (kw= '.' this_INT_3= RULE_INT )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==99) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalMIRoN.g:7481:4: kw= '.' this_INT_3= RULE_INT
                    {
                    kw=(Token)match(input,99,FOLLOW_9); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2_0());
                    			
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_3);
                    			

                    				newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_1());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleEBoolean"
    // InternalMIRoN.g:7498:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalMIRoN.g:7498:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalMIRoN.g:7499:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalMIRoN.g:7505:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7511:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalMIRoN.g:7512:2: (kw= 'true' | kw= 'false' )
            {
            // InternalMIRoN.g:7512:2: (kw= 'true' | kw= 'false' )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==100) ) {
                alt118=1;
            }
            else if ( (LA118_0==101) ) {
                alt118=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // InternalMIRoN.g:7513:3: kw= 'true'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7519:3: kw= 'false'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
                    		

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
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalMIRoN.g:7528:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMIRoN.g:7528:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMIRoN.g:7529:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalMIRoN.g:7535:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7541:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMIRoN.g:7542:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMIRoN.g:7542:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMIRoN.g:7543:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_80); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMIRoN.g:7550:3: (kw= '.' this_ID_2= RULE_ID )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==99) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // InternalMIRoN.g:7551:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,99,FOLLOW_19); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_80); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop119;
                }
            } while (true);


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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleLiteralQualifiedName"
    // InternalMIRoN.g:7568:1: entryRuleLiteralQualifiedName returns [String current=null] : iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF ;
    public final String entryRuleLiteralQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralQualifiedName = null;


        try {
            // InternalMIRoN.g:7568:60: (iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF )
            // InternalMIRoN.g:7569:2: iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getLiteralQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralQualifiedName=ruleLiteralQualifiedName();

            state._fsp--;

             current =iv_ruleLiteralQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleLiteralQualifiedName"


    // $ANTLR start "ruleLiteralQualifiedName"
    // InternalMIRoN.g:7575:1: ruleLiteralQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ ) ;
    public final AntlrDatatypeRuleToken ruleLiteralQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7581:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ ) )
            // InternalMIRoN.g:7582:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ )
            {
            // InternalMIRoN.g:7582:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ )
            // InternalMIRoN.g:7583:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_81); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getLiteralQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMIRoN.g:7590:3: (kw= '::' this_ID_2= RULE_ID )+
            int cnt120=0;
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==102) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalMIRoN.g:7591:4: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,102,FOLLOW_19); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getLiteralQualifiedNameAccess().getColonColonKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_82); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getLiteralQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt120 >= 1 ) break loop120;
                        EarlyExitException eee =
                            new EarlyExitException(120, input);
                        throw eee;
                }
                cnt120++;
            } while (true);


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
    // $ANTLR end "ruleLiteralQualifiedName"


    // $ANTLR start "entryRuleElementDescription"
    // InternalMIRoN.g:7608:1: entryRuleElementDescription returns [String current=null] : iv_ruleElementDescription= ruleElementDescription EOF ;
    public final String entryRuleElementDescription() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleElementDescription = null;


        try {
            // InternalMIRoN.g:7608:58: (iv_ruleElementDescription= ruleElementDescription EOF )
            // InternalMIRoN.g:7609:2: iv_ruleElementDescription= ruleElementDescription EOF
            {
             newCompositeNode(grammarAccess.getElementDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElementDescription=ruleElementDescription();

            state._fsp--;

             current =iv_ruleElementDescription.getText(); 
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
    // $ANTLR end "entryRuleElementDescription"


    // $ANTLR start "ruleElementDescription"
    // InternalMIRoN.g:7615:1: ruleElementDescription returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION ;
    public final AntlrDatatypeRuleToken ruleElementDescription() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROQME_DESCRIPTION_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7621:2: (this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION )
            // InternalMIRoN.g:7622:2: this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION
            {
            this_ROQME_DESCRIPTION_0=(Token)match(input,RULE_ROQME_DESCRIPTION,FOLLOW_2); 

            		current.merge(this_ROQME_DESCRIPTION_0);
            	

            		newLeafNode(this_ROQME_DESCRIPTION_0, grammarAccess.getElementDescriptionAccess().getROQME_DESCRIPTIONTerminalRuleCall());
            	

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
    // $ANTLR end "ruleElementDescription"


    // $ANTLR start "ruleImpactIntensityEnum"
    // InternalMIRoN.g:7632:1: ruleImpactIntensityEnum returns [Enumerator current=null] : ( (enumLiteral_0= '---' ) | (enumLiteral_1= '--' ) | (enumLiteral_2= '-' ) | (enumLiteral_3= '+++' ) | (enumLiteral_4= '++' ) | (enumLiteral_5= '+' ) ) ;
    public final Enumerator ruleImpactIntensityEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7638:2: ( ( (enumLiteral_0= '---' ) | (enumLiteral_1= '--' ) | (enumLiteral_2= '-' ) | (enumLiteral_3= '+++' ) | (enumLiteral_4= '++' ) | (enumLiteral_5= '+' ) ) )
            // InternalMIRoN.g:7639:2: ( (enumLiteral_0= '---' ) | (enumLiteral_1= '--' ) | (enumLiteral_2= '-' ) | (enumLiteral_3= '+++' ) | (enumLiteral_4= '++' ) | (enumLiteral_5= '+' ) )
            {
            // InternalMIRoN.g:7639:2: ( (enumLiteral_0= '---' ) | (enumLiteral_1= '--' ) | (enumLiteral_2= '-' ) | (enumLiteral_3= '+++' ) | (enumLiteral_4= '++' ) | (enumLiteral_5= '+' ) )
            int alt121=6;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt121=1;
                }
                break;
            case 104:
                {
                alt121=2;
                }
                break;
            case 93:
                {
                alt121=3;
                }
                break;
            case 105:
                {
                alt121=4;
                }
                break;
            case 106:
                {
                alt121=5;
                }
                break;
            case 92:
                {
                alt121=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // InternalMIRoN.g:7640:3: (enumLiteral_0= '---' )
                    {
                    // InternalMIRoN.g:7640:3: (enumLiteral_0= '---' )
                    // InternalMIRoN.g:7641:4: enumLiteral_0= '---'
                    {
                    enumLiteral_0=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getImpactIntensityEnumAccess().getNEGATIVE_HIGHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImpactIntensityEnumAccess().getNEGATIVE_HIGHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7648:3: (enumLiteral_1= '--' )
                    {
                    // InternalMIRoN.g:7648:3: (enumLiteral_1= '--' )
                    // InternalMIRoN.g:7649:4: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getImpactIntensityEnumAccess().getNEGATIVE_MEDIUMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImpactIntensityEnumAccess().getNEGATIVE_MEDIUMEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:7656:3: (enumLiteral_2= '-' )
                    {
                    // InternalMIRoN.g:7656:3: (enumLiteral_2= '-' )
                    // InternalMIRoN.g:7657:4: enumLiteral_2= '-'
                    {
                    enumLiteral_2=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getImpactIntensityEnumAccess().getNEGATIVE_LOWEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getImpactIntensityEnumAccess().getNEGATIVE_LOWEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:7664:3: (enumLiteral_3= '+++' )
                    {
                    // InternalMIRoN.g:7664:3: (enumLiteral_3= '+++' )
                    // InternalMIRoN.g:7665:4: enumLiteral_3= '+++'
                    {
                    enumLiteral_3=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getImpactIntensityEnumAccess().getPOSITIVE_HIGHEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getImpactIntensityEnumAccess().getPOSITIVE_HIGHEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:7672:3: (enumLiteral_4= '++' )
                    {
                    // InternalMIRoN.g:7672:3: (enumLiteral_4= '++' )
                    // InternalMIRoN.g:7673:4: enumLiteral_4= '++'
                    {
                    enumLiteral_4=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getImpactIntensityEnumAccess().getPOSITIVE_MEDIUMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getImpactIntensityEnumAccess().getPOSITIVE_MEDIUMEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:7680:3: (enumLiteral_5= '+' )
                    {
                    // InternalMIRoN.g:7680:3: (enumLiteral_5= '+' )
                    // InternalMIRoN.g:7681:4: enumLiteral_5= '+'
                    {
                    enumLiteral_5=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getImpactIntensityEnumAccess().getPOSITIVE_LOWEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getImpactIntensityEnumAccess().getPOSITIVE_LOWEnumLiteralDeclaration_5());
                    			

                    }


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
    // $ANTLR end "ruleImpactIntensityEnum"


    // $ANTLR start "ruleInsertionTypeEnum"
    // InternalMIRoN.g:7691:1: ruleInsertionTypeEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'after' ) | (enumLiteral_2= 'before' ) ) ;
    public final Enumerator ruleInsertionTypeEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7697:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'after' ) | (enumLiteral_2= 'before' ) ) )
            // InternalMIRoN.g:7698:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'after' ) | (enumLiteral_2= 'before' ) )
            {
            // InternalMIRoN.g:7698:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'after' ) | (enumLiteral_2= 'before' ) )
            int alt122=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt122=1;
                }
                break;
            case 107:
                {
                alt122=2;
                }
                break;
            case 108:
                {
                alt122=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }

            switch (alt122) {
                case 1 :
                    // InternalMIRoN.g:7699:3: (enumLiteral_0= 'in' )
                    {
                    // InternalMIRoN.g:7699:3: (enumLiteral_0= 'in' )
                    // InternalMIRoN.g:7700:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getInsertionTypeEnumAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getInsertionTypeEnumAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7707:3: (enumLiteral_1= 'after' )
                    {
                    // InternalMIRoN.g:7707:3: (enumLiteral_1= 'after' )
                    // InternalMIRoN.g:7708:4: enumLiteral_1= 'after'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getInsertionTypeEnumAccess().getAFTEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getInsertionTypeEnumAccess().getAFTEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:7715:3: (enumLiteral_2= 'before' )
                    {
                    // InternalMIRoN.g:7715:3: (enumLiteral_2= 'before' )
                    // InternalMIRoN.g:7716:4: enumLiteral_2= 'before'
                    {
                    enumLiteral_2=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getInsertionTypeEnumAccess().getBEFOREEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getInsertionTypeEnumAccess().getBEFOREEnumLiteralDeclaration_2());
                    			

                    }


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
    // $ANTLR end "ruleInsertionTypeEnum"


    // $ANTLR start "ruleInfluenceEnum"
    // InternalMIRoN.g:7726:1: ruleInfluenceEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) ) ;
    public final Enumerator ruleInfluenceEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7732:2: ( ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) ) )
            // InternalMIRoN.g:7733:2: ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) )
            {
            // InternalMIRoN.g:7733:2: ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==109) ) {
                alt123=1;
            }
            else if ( (LA123_0==110) ) {
                alt123=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalMIRoN.g:7734:3: (enumLiteral_0= 'reinforces' )
                    {
                    // InternalMIRoN.g:7734:3: (enumLiteral_0= 'reinforces' )
                    // InternalMIRoN.g:7735:4: enumLiteral_0= 'reinforces'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getInfluenceEnumAccess().getREINFORCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getInfluenceEnumAccess().getREINFORCEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7742:3: (enumLiteral_1= 'undermines' )
                    {
                    // InternalMIRoN.g:7742:3: (enumLiteral_1= 'undermines' )
                    // InternalMIRoN.g:7743:4: enumLiteral_1= 'undermines'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getInfluenceEnumAccess().getUNDERMINEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getInfluenceEnumAccess().getUNDERMINEEnumLiteralDeclaration_1());
                    			

                    }


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
    // $ANTLR end "ruleInfluenceEnum"


    // $ANTLR start "ruleStrengthEnum"
    // InternalMIRoN.g:7753:1: ruleStrengthEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) ) ;
    public final Enumerator ruleStrengthEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7759:2: ( ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) ) )
            // InternalMIRoN.g:7760:2: ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) )
            {
            // InternalMIRoN.g:7760:2: ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) )
            int alt124=5;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt124=1;
                }
                break;
            case 112:
                {
                alt124=2;
                }
                break;
            case 113:
                {
                alt124=3;
                }
                break;
            case 114:
                {
                alt124=4;
                }
                break;
            case 115:
                {
                alt124=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }

            switch (alt124) {
                case 1 :
                    // InternalMIRoN.g:7761:3: (enumLiteral_0= 'veryhigh' )
                    {
                    // InternalMIRoN.g:7761:3: (enumLiteral_0= 'veryhigh' )
                    // InternalMIRoN.g:7762:4: enumLiteral_0= 'veryhigh'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getVERY_HIGHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStrengthEnumAccess().getVERY_HIGHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7769:3: (enumLiteral_1= 'high' )
                    {
                    // InternalMIRoN.g:7769:3: (enumLiteral_1= 'high' )
                    // InternalMIRoN.g:7770:4: enumLiteral_1= 'high'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getHIGHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStrengthEnumAccess().getHIGHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:7777:3: (enumLiteral_2= 'MEDIUM' )
                    {
                    // InternalMIRoN.g:7777:3: (enumLiteral_2= 'MEDIUM' )
                    // InternalMIRoN.g:7778:4: enumLiteral_2= 'MEDIUM'
                    {
                    enumLiteral_2=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getMEDIUMEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getStrengthEnumAccess().getMEDIUMEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:7785:3: (enumLiteral_3= 'low' )
                    {
                    // InternalMIRoN.g:7785:3: (enumLiteral_3= 'low' )
                    // InternalMIRoN.g:7786:4: enumLiteral_3= 'low'
                    {
                    enumLiteral_3=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getStrengthEnumAccess().getLOWEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:7793:3: (enumLiteral_4= 'verylow' )
                    {
                    // InternalMIRoN.g:7793:3: (enumLiteral_4= 'verylow' )
                    // InternalMIRoN.g:7794:4: enumLiteral_4= 'verylow'
                    {
                    enumLiteral_4=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getVERY_LOWEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getStrengthEnumAccess().getVERY_LOWEnumLiteralDeclaration_4());
                    			

                    }


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
    // $ANTLR end "ruleStrengthEnum"


    // $ANTLR start "ruleArithFtnEnum"
    // InternalMIRoN.g:7804:1: ruleArithFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) ) ;
    public final Enumerator ruleArithFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7810:2: ( ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) ) )
            // InternalMIRoN.g:7811:2: ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) )
            {
            // InternalMIRoN.g:7811:2: ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) )
            int alt125=4;
            switch ( input.LA(1) ) {
            case 116:
                {
                alt125=1;
                }
                break;
            case 117:
                {
                alt125=2;
                }
                break;
            case 118:
                {
                alt125=3;
                }
                break;
            case 119:
                {
                alt125=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // InternalMIRoN.g:7812:3: (enumLiteral_0= 'pow' )
                    {
                    // InternalMIRoN.g:7812:3: (enumLiteral_0= 'pow' )
                    // InternalMIRoN.g:7813:4: enumLiteral_0= 'pow'
                    {
                    enumLiteral_0=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getPOWEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getArithFtnEnumAccess().getPOWEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7820:3: (enumLiteral_1= 'sqrt' )
                    {
                    // InternalMIRoN.g:7820:3: (enumLiteral_1= 'sqrt' )
                    // InternalMIRoN.g:7821:4: enumLiteral_1= 'sqrt'
                    {
                    enumLiteral_1=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getSQRTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getArithFtnEnumAccess().getSQRTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:7828:3: (enumLiteral_2= 'exp' )
                    {
                    // InternalMIRoN.g:7828:3: (enumLiteral_2= 'exp' )
                    // InternalMIRoN.g:7829:4: enumLiteral_2= 'exp'
                    {
                    enumLiteral_2=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getEXPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getArithFtnEnumAccess().getEXPEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:7836:3: (enumLiteral_3= 'abs' )
                    {
                    // InternalMIRoN.g:7836:3: (enumLiteral_3= 'abs' )
                    // InternalMIRoN.g:7837:4: enumLiteral_3= 'abs'
                    {
                    enumLiteral_3=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getABSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getArithFtnEnumAccess().getABSEnumLiteralDeclaration_3());
                    			

                    }


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
    // $ANTLR end "ruleArithFtnEnum"


    // $ANTLR start "ruleAggregationFtnEnum"
    // InternalMIRoN.g:7847:1: ruleAggregationFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) ) ;
    public final Enumerator ruleAggregationFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7853:2: ( ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) ) )
            // InternalMIRoN.g:7854:2: ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) )
            {
            // InternalMIRoN.g:7854:2: ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) )
            int alt126=8;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt126=1;
                }
                break;
            case 121:
                {
                alt126=2;
                }
                break;
            case 122:
                {
                alt126=3;
                }
                break;
            case 123:
                {
                alt126=4;
                }
                break;
            case 124:
                {
                alt126=5;
                }
                break;
            case 125:
                {
                alt126=6;
                }
                break;
            case 126:
                {
                alt126=7;
                }
                break;
            case 127:
                {
                alt126=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }

            switch (alt126) {
                case 1 :
                    // InternalMIRoN.g:7855:3: (enumLiteral_0= 'avg' )
                    {
                    // InternalMIRoN.g:7855:3: (enumLiteral_0= 'avg' )
                    // InternalMIRoN.g:7856:4: enumLiteral_0= 'avg'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getAVGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAggregationFtnEnumAccess().getAVGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7863:3: (enumLiteral_1= 'min' )
                    {
                    // InternalMIRoN.g:7863:3: (enumLiteral_1= 'min' )
                    // InternalMIRoN.g:7864:4: enumLiteral_1= 'min'
                    {
                    enumLiteral_1=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getMINEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAggregationFtnEnumAccess().getMINEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:7871:3: (enumLiteral_2= 'max' )
                    {
                    // InternalMIRoN.g:7871:3: (enumLiteral_2= 'max' )
                    // InternalMIRoN.g:7872:4: enumLiteral_2= 'max'
                    {
                    enumLiteral_2=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getMAXEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAggregationFtnEnumAccess().getMAXEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:7879:3: (enumLiteral_3= 'count' )
                    {
                    // InternalMIRoN.g:7879:3: (enumLiteral_3= 'count' )
                    // InternalMIRoN.g:7880:4: enumLiteral_3= 'count'
                    {
                    enumLiteral_3=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getCOUNTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAggregationFtnEnumAccess().getCOUNTEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:7887:3: (enumLiteral_4= 'sum' )
                    {
                    // InternalMIRoN.g:7887:3: (enumLiteral_4= 'sum' )
                    // InternalMIRoN.g:7888:4: enumLiteral_4= 'sum'
                    {
                    enumLiteral_4=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getSUMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getAggregationFtnEnumAccess().getSUMEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:7895:3: (enumLiteral_5= 'decreasing' )
                    {
                    // InternalMIRoN.g:7895:3: (enumLiteral_5= 'decreasing' )
                    // InternalMIRoN.g:7896:4: enumLiteral_5= 'decreasing'
                    {
                    enumLiteral_5=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getDECREASINGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getAggregationFtnEnumAccess().getDECREASINGEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMIRoN.g:7903:3: (enumLiteral_6= 'increasing' )
                    {
                    // InternalMIRoN.g:7903:3: (enumLiteral_6= 'increasing' )
                    // InternalMIRoN.g:7904:4: enumLiteral_6= 'increasing'
                    {
                    enumLiteral_6=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getINCREASINGEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getAggregationFtnEnumAccess().getINCREASINGEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMIRoN.g:7911:3: (enumLiteral_7= 'stable' )
                    {
                    // InternalMIRoN.g:7911:3: (enumLiteral_7= 'stable' )
                    // InternalMIRoN.g:7912:4: enumLiteral_7= 'stable'
                    {
                    enumLiteral_7=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getSTABLEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getAggregationFtnEnumAccess().getSTABLEEnumLiteralDeclaration_7());
                    			

                    }


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
    // $ANTLR end "ruleAggregationFtnEnum"


    // $ANTLR start "rulePatternFtnEnum"
    // InternalMIRoN.g:7922:1: rulePatternFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) ) ;
    public final Enumerator rulePatternFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7928:2: ( ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) ) )
            // InternalMIRoN.g:7929:2: ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) )
            {
            // InternalMIRoN.g:7929:2: ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) )
            int alt127=3;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt127=1;
                }
                break;
            case 129:
                {
                alt127=2;
                }
                break;
            case 130:
                {
                alt127=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }

            switch (alt127) {
                case 1 :
                    // InternalMIRoN.g:7930:3: (enumLiteral_0= 'eventWhen' )
                    {
                    // InternalMIRoN.g:7930:3: (enumLiteral_0= 'eventWhen' )
                    // InternalMIRoN.g:7931:4: enumLiteral_0= 'eventWhen'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getPatternFtnEnumAccess().getEVENT_WHENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPatternFtnEnumAccess().getEVENT_WHENEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7938:3: (enumLiteral_1= 'update' )
                    {
                    // InternalMIRoN.g:7938:3: (enumLiteral_1= 'update' )
                    // InternalMIRoN.g:7939:4: enumLiteral_1= 'update'
                    {
                    enumLiteral_1=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getPatternFtnEnumAccess().getUPDATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPatternFtnEnumAccess().getUPDATEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:7946:3: (enumLiteral_2= 'period' )
                    {
                    // InternalMIRoN.g:7946:3: (enumLiteral_2= 'period' )
                    // InternalMIRoN.g:7947:4: enumLiteral_2= 'period'
                    {
                    enumLiteral_2=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getPatternFtnEnumAccess().getPERIODEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPatternFtnEnumAccess().getPERIODEnumLiteralDeclaration_2());
                    			

                    }


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
    // $ANTLR end "rulePatternFtnEnum"


    // $ANTLR start "ruleCollectionFtnEnum"
    // InternalMIRoN.g:7957:1: ruleCollectionFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) ) ;
    public final Enumerator ruleCollectionFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalMIRoN.g:7963:2: ( ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) ) )
            // InternalMIRoN.g:7964:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) )
            {
            // InternalMIRoN.g:7964:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) )
            int alt128=6;
            switch ( input.LA(1) ) {
            case 131:
                {
                alt128=1;
                }
                break;
            case 132:
                {
                alt128=2;
                }
                break;
            case 133:
                {
                alt128=3;
                }
                break;
            case 134:
                {
                alt128=4;
                }
                break;
            case 135:
                {
                alt128=5;
                }
                break;
            case 136:
                {
                alt128=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }

            switch (alt128) {
                case 1 :
                    // InternalMIRoN.g:7965:3: (enumLiteral_0= 'first' )
                    {
                    // InternalMIRoN.g:7965:3: (enumLiteral_0= 'first' )
                    // InternalMIRoN.g:7966:4: enumLiteral_0= 'first'
                    {
                    enumLiteral_0=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getFIRSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCollectionFtnEnumAccess().getFIRSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:7973:3: (enumLiteral_1= 'last' )
                    {
                    // InternalMIRoN.g:7973:3: (enumLiteral_1= 'last' )
                    // InternalMIRoN.g:7974:4: enumLiteral_1= 'last'
                    {
                    enumLiteral_1=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getLASTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCollectionFtnEnumAccess().getLASTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:7981:3: (enumLiteral_2= 'at' )
                    {
                    // InternalMIRoN.g:7981:3: (enumLiteral_2= 'at' )
                    // InternalMIRoN.g:7982:4: enumLiteral_2= 'at'
                    {
                    enumLiteral_2=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getATEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCollectionFtnEnumAccess().getATEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:7989:3: (enumLiteral_3= 'size' )
                    {
                    // InternalMIRoN.g:7989:3: (enumLiteral_3= 'size' )
                    // InternalMIRoN.g:7990:4: enumLiteral_3= 'size'
                    {
                    enumLiteral_3=(Token)match(input,134,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getSIZEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCollectionFtnEnumAccess().getSIZEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:7997:3: (enumLiteral_4= 'isEmpty' )
                    {
                    // InternalMIRoN.g:7997:3: (enumLiteral_4= 'isEmpty' )
                    // InternalMIRoN.g:7998:4: enumLiteral_4= 'isEmpty'
                    {
                    enumLiteral_4=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getIS_EMPTYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getCollectionFtnEnumAccess().getIS_EMPTYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:8005:3: (enumLiteral_5= 'includes' )
                    {
                    // InternalMIRoN.g:8005:3: (enumLiteral_5= 'includes' )
                    // InternalMIRoN.g:8006:4: enumLiteral_5= 'includes'
                    {
                    enumLiteral_5=(Token)match(input,136,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getINCLUDESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getCollectionFtnEnumAccess().getINCLUDESEnumLiteralDeclaration_5());
                    			

                    }


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
    // $ANTLR end "ruleCollectionFtnEnum"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA94 dfa94 = new DFA94(this);
    static final String dfa_1s = "\56\uffff";
    static final String dfa_2s = "\4\uffff\1\14\12\uffff\2\14\3\uffff\1\14\1\uffff\1\14\1\uffff\2\14\10\uffff\3\14\2\uffff\1\14\4\uffff\1\14\1\uffff";
    static final String dfa_3s = "\1\17\3\uffff\1\7\1\uffff\1\4\1\5\4\4\2\uffff\1\21\2\7\1\4\1\24\1\4\1\7\1\4\1\7\1\4\2\7\5\4\1\24\1\4\1\24\3\7\2\4\1\7\1\24\1\4\1\25\1\4\1\7\1\25";
    static final String dfa_4s = "\1\76\3\uffff\1\154\1\uffff\1\4\1\6\4\135\2\uffff\1\21\2\154\1\4\1\143\1\4\1\154\1\4\1\154\1\4\2\154\1\4\1\135\3\4\1\24\1\4\1\143\3\154\1\4\1\135\1\154\1\25\1\4\1\143\1\4\1\154\1\25";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\6\uffff\1\4\1\6\40\uffff";
    static final String dfa_6s = "\56\uffff}>";
    static final String[] dfa_7s = {
            "\1\4\12\uffff\1\2\36\uffff\1\1\1\3\3\uffff\1\5",
            "",
            "",
            "",
            "\1\14\10\uffff\1\6\1\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "",
            "\1\16",
            "\1\20\1\17",
            "\1\22\130\uffff\1\21",
            "\1\24\130\uffff\1\23",
            "\1\26\130\uffff\1\25",
            "\1\30\130\uffff\1\27",
            "",
            "",
            "\1\31",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "\1\22",
            "\1\33\116\uffff\1\32",
            "\1\24",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\45\uffff\1\34\7\uffff\2\14",
            "\1\26",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\45\uffff\1\35\7\uffff\2\14",
            "\1\30",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\45\uffff\1\36\7\uffff\2\14",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "\1\37",
            "\1\41\130\uffff\1\40",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\33",
            "\1\41",
            "\1\46\1\47\115\uffff\1\45",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "\1\50",
            "\1\52\130\uffff\1\51",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "\1\46\1\47",
            "\1\52",
            "\1\54\115\uffff\1\53",
            "\1\55",
            "\1\14\12\uffff\1\7\1\10\2\uffff\1\15\5\uffff\2\14\5\uffff\1\14\1\uffff\6\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\11\1\12\1\13\55\uffff\2\14",
            "\1\54"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "289:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_TimeType_4= ruleTimeType | this_NumericSampledType_5= ruleNumericSampledType )";
        }
    }
    static final String dfa_8s = "\15\uffff";
    static final String dfa_9s = "\1\23\2\4\1\24\2\4\1\24\1\4\1\24\1\4\2\uffff\1\24";
    static final String dfa_10s = "\1\23\1\135\1\4\1\143\1\4\1\135\1\24\1\4\1\143\1\4\2\uffff\1\25";
    static final String dfa_11s = "\12\uffff\1\2\1\1\1\uffff";
    static final String dfa_12s = "\15\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\3\130\uffff\1\2",
            "\1\3",
            "\1\5\116\uffff\1\4",
            "\1\6",
            "\1\10\130\uffff\1\7",
            "\1\5",
            "\1\10",
            "\1\13\1\12\115\uffff\1\11",
            "\1\14",
            "",
            "",
            "\1\13\1\12"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "476:19: ( (otherlv_7= '(' ( (lv_constraints_8_0= ruleCompactLowerBound ) ) otherlv_9= ':' ( (lv_constraints_10_0= ruleCompactPrecision ) ) otherlv_11= ':' ( (lv_constraints_12_0= ruleCompactUpperBound ) ) otherlv_13= ')' ) | (otherlv_14= '(' ( (lv_constraints_15_0= ruleCompactLowerBound ) ) otherlv_16= ':' ( (lv_constraints_17_0= ruleCompactUpperBound ) ) otherlv_18= ')' ) )";
        }
    }
    static final String dfa_14s = "\u00ff\uffff";
    static final String dfa_15s = "\4\uffff\1\14\1\uffff\2\14\1\uffff\3\14\25\uffff\2\14\3\uffff\1\14\1\uffff\1\14\1\uffff\1\14\4\uffff\1\14\1\uffff\1\14\1\uffff\2\14\3\uffff\2\14\23\uffff\1\14\11\uffff\3\14\3\uffff\4\14\2\uffff\1\14\2\uffff\1\14\23\uffff\1\14\22\uffff\1\14\161\uffff";
    static final String dfa_16s = "\1\7\1\45\1\5\1\24\1\5\1\uffff\2\7\1\20\3\7\1\uffff\2\4\1\5\2\4\1\5\11\4\2\21\1\24\2\21\2\7\1\4\1\24\1\4\1\7\1\4\1\7\1\4\1\7\1\4\1\5\1\21\1\4\1\7\1\4\1\7\1\4\2\7\1\26\2\5\2\7\6\4\14\31\1\5\1\7\3\4\3\27\1\24\1\4\1\24\3\7\1\5\1\134\1\5\4\7\2\5\1\7\1\5\1\4\1\7\1\4\1\5\6\27\1\134\1\27\1\134\1\5\1\24\1\27\1\24\1\4\1\25\1\134\1\4\1\7\1\5\6\27\1\5\6\27\1\134\1\27\1\5\1\4\1\7\1\4\1\5\1\134\1\5\1\134\1\5\10\27\1\25\1\4\2\31\1\5\12\31\2\134\4\5\1\134\2\5\6\27\2\134\1\5\1\27\1\5\6\27\1\134\1\27\1\134\1\5\6\27\1\5\6\27\1\134\1\27\1\134\1\5\6\27\2\134\1\5\6\27\1\134\1\5\1\134\1\5\2\134\1\5\6\27\1\5\6\27\2\134";
    static final String dfa_17s = "\2\45\1\5\1\24\1\76\1\uffff\2\70\1\26\1\70\2\75\1\uffff\2\4\1\5\2\4\1\6\5\135\1\4\3\135\2\21\1\27\2\21\2\75\1\4\1\143\1\4\1\143\1\4\1\143\1\4\1\143\1\4\1\143\1\21\1\4\1\143\1\4\1\143\1\4\1\143\1\70\1\26\1\5\1\33\1\70\1\75\1\4\1\135\4\4\14\31\1\26\1\75\3\4\1\30\1\31\1\143\1\24\1\4\1\143\3\75\1\111\1\152\1\30\3\75\1\70\1\26\1\5\1\70\1\5\1\4\1\75\1\135\1\5\6\30\1\152\1\30\1\152\1\30\1\24\1\143\1\25\1\4\1\143\1\152\1\135\1\70\1\5\6\30\1\5\6\30\1\152\1\30\1\33\1\4\1\75\1\4\1\143\1\152\1\5\1\152\1\5\6\30\1\31\1\143\1\25\1\4\2\31\1\26\12\31\2\152\1\5\1\26\1\5\1\111\1\152\1\30\1\5\6\30\2\152\1\30\1\143\1\5\6\30\1\152\1\30\1\152\1\5\6\30\1\5\6\30\1\152\1\30\1\152\1\5\6\30\2\152\1\5\6\30\1\152\1\5\1\152\1\5\2\152\1\5\6\30\1\5\6\30\2\152";
    static final String dfa_18s = "\5\uffff\1\1\6\uffff\1\2\u00f2\uffff";
    static final String dfa_19s = "\u00ff\uffff}>";
    static final String[] dfa_20s = {
            "\1\1\35\uffff\1\2",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\1\uffff\1\14\7\uffff\1\12\12\uffff\1\10\1\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\1\7\1\11\3\uffff\1\13",
            "",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\14\10\uffff\1\15\13\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\16\5\uffff\1\17",
            "\1\14\10\uffff\1\20\13\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\14\10\uffff\1\21\1\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\14\10\uffff\1\30\13\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\31\1\32\1\33",
            "",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\42\1\41",
            "\1\44\130\uffff\1\43",
            "\1\46\130\uffff\1\45",
            "\1\50\130\uffff\1\47",
            "\1\52\130\uffff\1\51",
            "\1\54\130\uffff\1\53",
            "\1\55",
            "\1\57\130\uffff\1\56",
            "\1\61\130\uffff\1\60",
            "\1\63\130\uffff\1\62",
            "\1\64",
            "\1\65",
            "\1\67\2\uffff\1\66",
            "\1\70",
            "\1\71",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\44",
            "\1\73\116\uffff\1\72",
            "\1\46",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26\45\uffff\1\74",
            "\1\50",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26\45\uffff\1\75",
            "\1\52",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26\45\uffff\1\76",
            "\1\54",
            "\1\113\1\112\22\uffff\1\114\46\uffff\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\31\uffff\1\77",
            "\1\115",
            "\1\57",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\31\1\32\1\33\45\uffff\1\116",
            "\1\61",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\31\1\32\1\33\45\uffff\1\117",
            "\1\63",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\31\1\32\1\33\45\uffff\1\120",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\17",
            "\1\121",
            "\1\123\25\uffff\1\122",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\124",
            "\1\126\130\uffff\1\125",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\133\20\uffff\1\134",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\31\1\32\1\33",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\66\1\140",
            "\1\142\1\143\1\141",
            "\1\142\1\143\1\141\111\uffff\1\144",
            "\1\73",
            "\1\126",
            "\1\147\1\146\115\uffff\1\145",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\113\1\112\22\uffff\1\114\46\uffff\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111",
            "\1\156\1\153\5\uffff\1\150\3\uffff\1\151\1\152\1\154\1\155",
            "\1\157\22\uffff\1\160",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\31\1\32\1\33",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\31\1\32\1\33",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\31\1\32\1\33",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\161\20\uffff\1\162",
            "\1\163",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\164",
            "\1\165",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\167\130\uffff\1\166",
            "\1\170",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\u0081\1\176\5\uffff\1\173\3\uffff\1\174\1\175\1\177\1\u0080",
            "\1\171\1\172",
            "\1\u0088\1\u0085\5\uffff\1\u0082\3\uffff\1\u0083\1\u0084\1\u0086\1\u0087",
            "\1\u0089\22\uffff\1\u008a",
            "\1\u008b",
            "\1\142\1\143\1\141\111\uffff\1\144",
            "\1\147\1\146",
            "\1\167",
            "\1\u008d\115\uffff\1\u008c",
            "\1\156\1\153\5\uffff\1\150\3\uffff\1\151\1\152\1\154\1\155",
            "\1\u008f\130\uffff\1\u008e",
            "\1\14\24\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\u0090",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0092",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\u0099\1\u0096\5\uffff\1\u0093\3\uffff\1\u0094\1\u0095\1\u0097\1\u0098",
            "\1\142\1\143",
            "\1\u009b\25\uffff\1\u009a",
            "\1\u009c",
            "\1\14\12\uffff\1\22\1\23\2\uffff\1\27\5\uffff\1\14\6\uffff\1\14\1\uffff\1\14\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\2\uffff\1\24\1\25\1\26",
            "\1\u008f",
            "\1\u009f\1\u009e\22\uffff\1\u00a0\46\uffff\1\u00a1\1\u00a2\1\u00a3\1\u00a4\1\u00a5\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa\31\uffff\1\u009d",
            "\1\u0081\1\176\5\uffff\1\173\3\uffff\1\174\1\175\1\177\1\u0080",
            "\1\u00ab",
            "\1\u0088\1\u0085\5\uffff\1\u0082\3\uffff\1\u0083\1\u0084\1\u0086\1\u0087",
            "\1\u00ac",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\142\1\143\1\u00ae",
            "\1\142\1\143\1\u00ae\111\uffff\1\u00af",
            "\1\u008d",
            "\1\u00b0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00b1\20\uffff\1\u00b2",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00a0",
            "\1\u00b9\1\u00b6\5\uffff\1\u00b3\3\uffff\1\u00b4\1\u00b5\1\u00b7\1\u00b8",
            "\1\u0099\1\u0096\5\uffff\1\u0093\3\uffff\1\u0094\1\u0095\1\u0097\1\u0098",
            "\1\u00ba",
            "\1\u00bb\20\uffff\1\u00bc",
            "\1\u00bd",
            "\1\u009f\1\u009e\22\uffff\1\u00a0\46\uffff\1\u00a1\1\u00a2\1\u00a3\1\u00a4\1\u00a5\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa",
            "\1\u00c4\1\u00c1\5\uffff\1\u00be\3\uffff\1\u00bf\1\u00c0\1\u00c2\1\u00c3",
            "\1\u00c5\22\uffff\1\u00c6",
            "\1\u00c7",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u0091\1\160",
            "\1\u00ce\1\u00cb\5\uffff\1\u00c8\3\uffff\1\u00c9\1\u00ca\1\u00cc\1\u00cd",
            "\1\u00d5\1\u00d2\5\uffff\1\u00cf\3\uffff\1\u00d0\1\u00d1\1\u00d3\1\u00d4",
            "\1\u00d6\22\uffff\1\u00d7",
            "\1\142\1\143\1\u00ae\111\uffff\1\u00af",
            "\1\u00d8",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\171\1\172",
            "\1\u00df\1\u00dc\5\uffff\1\u00d9\3\uffff\1\u00da\1\u00db\1\u00dd\1\u00de",
            "\1\171\1\172",
            "\1\u00b9\1\u00b6\5\uffff\1\u00b3\3\uffff\1\u00b4\1\u00b5\1\u00b7\1\u00b8",
            "\1\u00e0",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00ad\1\u008a",
            "\1\u00e1",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\142\1\143",
            "\1\u00e8\1\u00e5\5\uffff\1\u00e2\3\uffff\1\u00e3\1\u00e4\1\u00e6\1\u00e7",
            "\1\142\1\143",
            "\1\u00c4\1\u00c1\5\uffff\1\u00be\3\uffff\1\u00bf\1\u00c0\1\u00c2\1\u00c3",
            "\1\u00e9",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ce\1\u00cb\5\uffff\1\u00c8\3\uffff\1\u00c9\1\u00ca\1\u00cc\1\u00cd",
            "\1\u00d5\1\u00d2\5\uffff\1\u00cf\3\uffff\1\u00d0\1\u00d1\1\u00d3\1\u00d4",
            "\1\u00eb",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00df\1\u00dc\5\uffff\1\u00d9\3\uffff\1\u00da\1\u00db\1\u00dd\1\u00de",
            "\1\u00ed",
            "\1\u00e8\1\u00e5\5\uffff\1\u00e2\3\uffff\1\u00e3\1\u00e4\1\u00e6\1\u00e7",
            "\1\u00ee",
            "\1\u00f5\1\u00f2\5\uffff\1\u00ef\3\uffff\1\u00f0\1\u00f1\1\u00f3\1\u00f4",
            "\1\u00fc\1\u00f9\5\uffff\1\u00f6\3\uffff\1\u00f7\1\u00f8\1\u00fa\1\u00fb",
            "\1\u00fd",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00ea\1\u00c6",
            "\1\u00fe",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00ec\1\u00d7",
            "\1\u00f5\1\u00f2\5\uffff\1\u00ef\3\uffff\1\u00f0\1\u00f1\1\u00f3\1\u00f4",
            "\1\u00fc\1\u00f9\5\uffff\1\u00f6\3\uffff\1\u00f7\1\u00f8\1\u00fa\1\u00fb"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "1881:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )";
        }
    }
    static final String dfa_21s = "\12\uffff\1\1\1\2\1\uffff";
    static final String[] dfa_22s = {
            "\1\1",
            "\1\3\130\uffff\1\2",
            "\1\3",
            "\1\5\116\uffff\1\4",
            "\1\6",
            "\1\10\130\uffff\1\7",
            "\1\5",
            "\1\10",
            "\1\12\1\13\115\uffff\1\11",
            "\1\14",
            "",
            "",
            "\1\12\1\13"
    };
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_21;
            this.special = dfa_12;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "3896:19: ( (otherlv_8= '(' ( (lv_constraints_9_0= ruleCompactLowerBound ) ) otherlv_10= ':' ( (lv_constraints_11_0= ruleCompactPrecision ) ) otherlv_12= ':' ( (lv_constraints_13_0= ruleCompactUpperBound ) ) otherlv_14= ')' ) | (otherlv_15= '(' ( (lv_constraints_16_0= ruleCompactLowerBound ) ) otherlv_17= ':' ( (lv_constraints_18_0= ruleCompactUpperBound ) ) otherlv_19= ')' ) )";
        }
    }
    static final String dfa_23s = "\12\uffff";
    static final String dfa_24s = "\3\uffff\1\7\1\10\4\uffff\1\7";
    static final String dfa_25s = "\1\4\2\uffff\2\7\1\uffff\1\5\2\uffff\1\7";
    static final String dfa_26s = "\1\u0088\2\uffff\2\156\1\uffff\1\5\2\uffff\1\156";
    static final String dfa_27s = "\1\uffff\1\1\1\2\2\uffff\1\5\1\uffff\1\3\1\4\1\uffff";
    static final String dfa_28s = "\12\uffff}>";
    static final String[] dfa_29s = {
            "\1\2\1\3\12\uffff\1\2\2\uffff\1\1\53\uffff\1\2\35\uffff\1\2\2\uffff\1\4\1\5\2\uffff\2\2\16\uffff\25\5",
            "",
            "",
            "\1\7\14\uffff\5\7\3\uffff\1\7\6\uffff\6\7\1\uffff\17\7\22\uffff\6\7\1\uffff\3\7\1\uffff\12\7\2\uffff\1\5\1\6\2\uffff\1\2\6\uffff\2\7",
            "\1\10\14\uffff\5\10\3\uffff\1\10\6\uffff\6\10\1\uffff\17\10\22\uffff\6\10\1\uffff\3\10\1\uffff\12\10\2\uffff\1\5\12\uffff\2\10",
            "",
            "\1\11",
            "",
            "",
            "\1\7\14\uffff\5\7\3\uffff\1\7\6\uffff\6\7\1\uffff\17\7\22\uffff\6\7\1\uffff\3\7\1\uffff\12\7\2\uffff\1\5\1\6\11\uffff\2\7"
    };

    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

    class DFA93 extends DFA {

        public DFA93(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 93;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_28;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "6591:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )";
        }
    }
    static final String dfa_30s = "\13\uffff";
    static final String dfa_31s = "\1\5\2\142\5\uffff\1\5\1\164\1\142";
    static final String dfa_32s = "\1\u0088\1\143\1\142\5\uffff\1\5\1\u0088\1\143";
    static final String dfa_33s = "\3\uffff\1\1\1\2\1\3\1\4\1\5\3\uffff";
    static final String dfa_34s = "\13\uffff}>";
    static final String[] dfa_35s = {
            "\1\1\132\uffff\1\2\1\7\22\uffff\4\3\10\4\3\5\6\6",
            "\1\11\1\10",
            "\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "\4\3\10\4\3\5\6\6",
            "\1\11\1\10"
    };

    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

    class DFA94 extends DFA {

        public DFA94(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 94;
            this.eot = dfa_30;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "6763:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x010645A810002082L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x010645A810000082L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x38000000004D0000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x38000000004C0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L,0x0000000020000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000078030000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x4600000004008020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020000002L,0x0000180000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000780000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000781000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x8000001000090030L,0xFFF0003320220400L,0x00000000000001FFL});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x8000000000490030L,0xFFF0003320220400L,0x00000000000001FFL});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x8000000000090030L,0xFFF0003320220400L,0x00000000000001FFL});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x8000000000010030L,0x0000003020000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000384000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000384000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0001800000100000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x00F8000000400000L,0x0000600000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00F8000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x00F8000001000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0001000000000002L,0x000F800000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x38000000000D0002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x38000000000C0002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000003000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x000000000FC00000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0000000030000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000020L,0x00F0000100000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x8000000000290030L,0xFFF0003320220400L,0x00000000000001FFL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000020L,0xFF00000100000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000020L,0x0000000100000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000020L,0x0000000100000000L,0x00000000000001F8L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});

}
