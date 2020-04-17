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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ROQME_DESCRIPTION", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'miron'", "'import'", "'as'", "'enum'", "'['", "']'", "'{'", "','", "'}'", "':'", "'varpoint'", "'xpath'", "'('", "')'", "'rule'", "'implies'", "':='", "'context'", "'var'", "'param'", "'default'", "'timer'", "'offset'", "'onetime'", "'paused'", "'beliefvar'", "'reference'", "'survival'", "'property'", "'observation'", "'sets'", "'clears'", "'starts'", "'stops'", "'resumes'", "'type'", "'boolean'", "'eventtype'", "'number'", "'lower'", "'upper'", "'unit'", "'time'", "'event'", "'milliseconds'", "'seconds'", "'minutes'", "'hours'", "'days'", "'millisecond'", "'second'", "'minute'", "'hour'", "'day'", "'once'", "'while'", "'repeat'", "'range'", "'->'", "'or'", "'and'", "'not'", "'?'", "'|'", "'&'", "'!'", "'='", "'<'", "'>'", "'<='", "'>='", "'!='", "'+'", "'-'", "'*'", "'/'", "'belief'", "'schedule'", "'\\''", "'.'", "'true'", "'false'", "'::'", "'in'", "'after'", "'before'", "'reinforces'", "'undermines'", "'veryhigh'", "'high'", "'MEDIUM'", "'low'", "'verylow'", "'pow'", "'sqrt'", "'exp'", "'abs'", "'avg'", "'min'", "'max'", "'count'", "'sum'", "'decreasing'", "'increasing'", "'stable'", "'eventWhen'", "'update'", "'period'", "'first'", "'last'", "'at'", "'size'", "'isEmpty'", "'includes'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=4;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__65=65;
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
                case 47:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_ROQME_DESCRIPTION:
                    {
                    int LA4_3 = input.LA(2);

                    if ( (LA4_3==29||LA4_3==31||LA4_3==37||LA4_3==40) ) {
                        alt4=2;
                    }
                    else if ( (LA4_3==41) ) {
                        alt4=3;
                    }


                    }
                    break;
                case 22:
                case 29:
                case 30:
                case 31:
                case 33:
                case 37:
                case 40:
                    {
                    alt4=2;
                    }
                    break;
                case 26:
                case 41:
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


    // $ANTLR start "entryRuleEnumType"
    // InternalMIRoN.g:275:1: entryRuleEnumType returns [EObject current=null] : iv_ruleEnumType= ruleEnumType EOF ;
    public final EObject entryRuleEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumType = null;


        try {
            // InternalMIRoN.g:275:49: (iv_ruleEnumType= ruleEnumType EOF )
            // InternalMIRoN.g:276:2: iv_ruleEnumType= ruleEnumType EOF
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
    // InternalMIRoN.g:282:1: ruleEnumType returns [EObject current=null] : (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteralAux ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralAux ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleEnumType() throws RecognitionException {
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
            // InternalMIRoN.g:288:2: ( (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteralAux ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralAux ) ) )* otherlv_8= '}' ) )
            // InternalMIRoN.g:289:2: (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteralAux ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralAux ) ) )* otherlv_8= '}' )
            {
            // InternalMIRoN.g:289:2: (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteralAux ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralAux ) ) )* otherlv_8= '}' )
            // InternalMIRoN.g:290:3: otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteralAux ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralAux ) ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumTypeAccess().getEnumKeyword_0());
            		
            // InternalMIRoN.g:294:3: (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMIRoN.g:295:4: otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumTypeAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalMIRoN.g:299:4: ( (lv_cardinality_2_0= RULE_INT ) )
                    // InternalMIRoN.g:300:5: (lv_cardinality_2_0= RULE_INT )
                    {
                    // InternalMIRoN.g:300:5: (lv_cardinality_2_0= RULE_INT )
                    // InternalMIRoN.g:301:6: lv_cardinality_2_0= RULE_INT
                    {
                    lv_cardinality_2_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_2_0, grammarAccess.getEnumTypeAccess().getCardinalityINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEnumTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getEnumTypeAccess().getRightSquareBracketKeyword_1_2());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMIRoN.g:326:3: ( (lv_literals_5_0= ruleEnumLiteralAux ) )
            // InternalMIRoN.g:327:4: (lv_literals_5_0= ruleEnumLiteralAux )
            {
            // InternalMIRoN.g:327:4: (lv_literals_5_0= ruleEnumLiteralAux )
            // InternalMIRoN.g:328:5: lv_literals_5_0= ruleEnumLiteralAux
            {

            					newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralAuxParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_13);
            lv_literals_5_0=ruleEnumLiteralAux();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumTypeRule());
            					}
            					add(
            						current,
            						"literals",
            						lv_literals_5_0,
            						"org.xtext.miron.MIRoN.EnumLiteralAux");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:345:3: (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralAux ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMIRoN.g:346:4: otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteralAux ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FOLLOW_12); 

            	    				newLeafNode(otherlv_6, grammarAccess.getEnumTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMIRoN.g:350:4: ( (lv_literals_7_0= ruleEnumLiteralAux ) )
            	    // InternalMIRoN.g:351:5: (lv_literals_7_0= ruleEnumLiteralAux )
            	    {
            	    // InternalMIRoN.g:351:5: (lv_literals_7_0= ruleEnumLiteralAux )
            	    // InternalMIRoN.g:352:6: lv_literals_7_0= ruleEnumLiteralAux
            	    {

            	    						newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralAuxParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_literals_7_0=ruleEnumLiteralAux();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"literals",
            	    							lv_literals_7_0,
            	    							"org.xtext.miron.MIRoN.EnumLiteralAux");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getEnumTypeAccess().getRightCurlyBracketKeyword_5());
            		

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


    // $ANTLR start "entryRuleEnumLiteralAux"
    // InternalMIRoN.g:378:1: entryRuleEnumLiteralAux returns [EObject current=null] : iv_ruleEnumLiteralAux= ruleEnumLiteralAux EOF ;
    public final EObject entryRuleEnumLiteralAux() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralAux = null;


        try {
            // InternalMIRoN.g:378:55: (iv_ruleEnumLiteralAux= ruleEnumLiteralAux EOF )
            // InternalMIRoN.g:379:2: iv_ruleEnumLiteralAux= ruleEnumLiteralAux EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralAuxRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteralAux=ruleEnumLiteralAux();

            state._fsp--;

             current =iv_ruleEnumLiteralAux; 
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
    // $ANTLR end "entryRuleEnumLiteralAux"


    // $ANTLR start "ruleEnumLiteralAux"
    // InternalMIRoN.g:385:1: ruleEnumLiteralAux returns [EObject current=null] : (this_EnumLiteral_0= ruleEnumLiteral | this_BehaviorTreeLiteral_1= ruleBehaviorTreeLiteral ) ;
    public final EObject ruleEnumLiteralAux() throws RecognitionException {
        EObject current = null;

        EObject this_EnumLiteral_0 = null;

        EObject this_BehaviorTreeLiteral_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:391:2: ( (this_EnumLiteral_0= ruleEnumLiteral | this_BehaviorTreeLiteral_1= ruleBehaviorTreeLiteral ) )
            // InternalMIRoN.g:392:2: (this_EnumLiteral_0= ruleEnumLiteral | this_BehaviorTreeLiteral_1= ruleBehaviorTreeLiteral )
            {
            // InternalMIRoN.g:392:2: (this_EnumLiteral_0= ruleEnumLiteral | this_BehaviorTreeLiteral_1= ruleBehaviorTreeLiteral )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==21) ) {
                    alt8=2;
                }
                else if ( (LA8_1==EOF||(LA8_1>=19 && LA8_1<=20)) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalMIRoN.g:393:3: this_EnumLiteral_0= ruleEnumLiteral
                    {

                    			newCompositeNode(grammarAccess.getEnumLiteralAuxAccess().getEnumLiteralParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumLiteral_0=ruleEnumLiteral();

                    state._fsp--;


                    			current = this_EnumLiteral_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:402:3: this_BehaviorTreeLiteral_1= ruleBehaviorTreeLiteral
                    {

                    			newCompositeNode(grammarAccess.getEnumLiteralAuxAccess().getBehaviorTreeLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BehaviorTreeLiteral_1=ruleBehaviorTreeLiteral();

                    state._fsp--;


                    			current = this_BehaviorTreeLiteral_1;
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
    // $ANTLR end "ruleEnumLiteralAux"


    // $ANTLR start "entryRuleBehaviorTreeLiteral"
    // InternalMIRoN.g:414:1: entryRuleBehaviorTreeLiteral returns [EObject current=null] : iv_ruleBehaviorTreeLiteral= ruleBehaviorTreeLiteral EOF ;
    public final EObject entryRuleBehaviorTreeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTreeLiteral = null;


        try {
            // InternalMIRoN.g:414:60: (iv_ruleBehaviorTreeLiteral= ruleBehaviorTreeLiteral EOF )
            // InternalMIRoN.g:415:2: iv_ruleBehaviorTreeLiteral= ruleBehaviorTreeLiteral EOF
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
    // InternalMIRoN.g:421:1: ruleBehaviorTreeLiteral returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleEString ) ) ) ;
    public final EObject ruleBehaviorTreeLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:427:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleEString ) ) ) )
            // InternalMIRoN.g:428:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleEString ) ) )
            {
            // InternalMIRoN.g:428:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleEString ) ) )
            // InternalMIRoN.g:429:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleEString ) )
            {
            // InternalMIRoN.g:429:3: ()
            // InternalMIRoN.g:430:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBehaviorTreeLiteralAccess().getBehaviorTreeLiteralAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:436:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:437:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:437:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:438:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getBehaviorTreeLiteralAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:458:3: ( ( ruleEString ) )
            // InternalMIRoN.g:459:4: ( ruleEString )
            {
            // InternalMIRoN.g:459:4: ( ruleEString )
            // InternalMIRoN.g:460:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBehaviorTreeLiteralRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBehaviorTreeLiteralAccess().getReferenceBehaviorTreeCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

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
    // $ANTLR end "ruleBehaviorTreeLiteral"


    // $ANTLR start "entryRuleTypedVariable"
    // InternalMIRoN.g:478:1: entryRuleTypedVariable returns [EObject current=null] : iv_ruleTypedVariable= ruleTypedVariable EOF ;
    public final EObject entryRuleTypedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedVariable = null;


        try {
            // InternalMIRoN.g:478:54: (iv_ruleTypedVariable= ruleTypedVariable EOF )
            // InternalMIRoN.g:479:2: iv_ruleTypedVariable= ruleTypedVariable EOF
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
    // InternalMIRoN.g:485:1: ruleTypedVariable returns [EObject current=null] : (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable | this_VariationPoint_5= ruleVariationPoint ) ;
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
            // InternalMIRoN.g:491:2: ( (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable | this_VariationPoint_5= ruleVariationPoint ) )
            // InternalMIRoN.g:492:2: (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable | this_VariationPoint_5= ruleVariationPoint )
            {
            // InternalMIRoN.g:492:2: (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable | this_VariationPoint_5= ruleVariationPoint )
            int alt9=6;
            switch ( input.LA(1) ) {
            case RULE_ROQME_DESCRIPTION:
                {
                switch ( input.LA(2) ) {
                case 31:
                    {
                    alt9=1;
                    }
                    break;
                case 29:
                    {
                    alt9=4;
                    }
                    break;
                case 37:
                case 40:
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
                break;
            case 31:
                {
                alt9=1;
                }
                break;
            case 33:
                {
                alt9=2;
                }
                break;
            case 30:
                {
                alt9=3;
                }
                break;
            case 29:
                {
                alt9=4;
                }
                break;
            case 37:
            case 40:
                {
                alt9=5;
                }
                break;
            case 22:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalMIRoN.g:493:3: this_Parameter_0= ruleParameter
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
                    // InternalMIRoN.g:502:3: this_Timer_1= ruleTimer
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
                    // InternalMIRoN.g:511:3: this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable
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
                    // InternalMIRoN.g:520:3: this_Context_3= ruleContext
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
                    // InternalMIRoN.g:529:3: this_BeliefVariable_4= ruleBeliefVariable
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
                    // InternalMIRoN.g:538:3: this_VariationPoint_5= ruleVariationPoint
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
    // InternalMIRoN.g:550:1: entryRuleVariationPoint returns [EObject current=null] : iv_ruleVariationPoint= ruleVariationPoint EOF ;
    public final EObject entryRuleVariationPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariationPoint = null;


        try {
            // InternalMIRoN.g:550:55: (iv_ruleVariationPoint= ruleVariationPoint EOF )
            // InternalMIRoN.g:551:2: iv_ruleVariationPoint= ruleVariationPoint EOF
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
    // InternalMIRoN.g:557:1: ruleVariationPoint returns [EObject current=null] : (otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) ) ) ;
    public final EObject ruleVariationPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_declaration_3_0 = null;

        EObject lv_binding_4_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:563:2: ( (otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) ) ) )
            // InternalMIRoN.g:564:2: (otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) ) )
            {
            // InternalMIRoN.g:564:2: (otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) ) )
            // InternalMIRoN.g:565:3: otherlv_0= 'varpoint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) ( (lv_binding_4_0= ruleBinding ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getVariationPointAccess().getVarpointKeyword_0());
            		
            // InternalMIRoN.g:569:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:570:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:570:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:571:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getVariationPointAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:591:3: ( (lv_declaration_3_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:592:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:592:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:593:5: lv_declaration_3_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getVariationPointAccess().getDeclarationDataTypeDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
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

            // InternalMIRoN.g:610:3: ( (lv_binding_4_0= ruleBinding ) )
            // InternalMIRoN.g:611:4: (lv_binding_4_0= ruleBinding )
            {
            // InternalMIRoN.g:611:4: (lv_binding_4_0= ruleBinding )
            // InternalMIRoN.g:612:5: lv_binding_4_0= ruleBinding
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
    // InternalMIRoN.g:633:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalMIRoN.g:633:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalMIRoN.g:634:2: iv_ruleBinding= ruleBinding EOF
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
    // InternalMIRoN.g:640:1: ruleBinding returns [EObject current=null] : ( ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')' ) | ( ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_insertionType_0_0 = null;

        AntlrDatatypeRuleToken lv_xpath_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:646:2: ( ( ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')' ) | ( ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* ) ) ) )
            // InternalMIRoN.g:647:2: ( ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')' ) | ( ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* ) ) )
            {
            // InternalMIRoN.g:647:2: ( ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')' ) | ( ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* ) ) )
            // InternalMIRoN.g:648:3: ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) ) ( (otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')' ) | ( ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* ) )
            {
            // InternalMIRoN.g:648:3: ( (lv_insertionType_0_0= ruleInsertionTypeEnum ) )
            // InternalMIRoN.g:649:4: (lv_insertionType_0_0= ruleInsertionTypeEnum )
            {
            // InternalMIRoN.g:649:4: (lv_insertionType_0_0= ruleInsertionTypeEnum )
            // InternalMIRoN.g:650:5: lv_insertionType_0_0= ruleInsertionTypeEnum
            {

            					newCompositeNode(grammarAccess.getBindingAccess().getInsertionTypeInsertionTypeEnumEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_insertionType_0_0=ruleInsertionTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBindingRule());
            					}
            					set(
            						current,
            						"insertionType",
            						lv_insertionType_0_0,
            						"org.xtext.miron.MIRoN.InsertionTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:667:3: ( (otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')' ) | ( ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_STRING)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalMIRoN.g:668:4: (otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')' )
                    {
                    // InternalMIRoN.g:668:4: (otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')' )
                    // InternalMIRoN.g:669:5: otherlv_1= 'xpath' otherlv_2= '(' ( (lv_xpath_3_0= ruleEString ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_18); 

                    					newLeafNode(otherlv_1, grammarAccess.getBindingAccess().getXpathKeyword_1_0_0());
                    				
                    otherlv_2=(Token)match(input,24,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getLeftParenthesisKeyword_1_0_1());
                    				
                    // InternalMIRoN.g:677:5: ( (lv_xpath_3_0= ruleEString ) )
                    // InternalMIRoN.g:678:6: (lv_xpath_3_0= ruleEString )
                    {
                    // InternalMIRoN.g:678:6: (lv_xpath_3_0= ruleEString )
                    // InternalMIRoN.g:679:7: lv_xpath_3_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getBindingAccess().getXpathEStringParserRuleCall_1_0_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    lv_xpath_3_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getBindingRule());
                    							}
                    							set(
                    								current,
                    								"xpath",
                    								lv_xpath_3_0,
                    								"org.xtext.roqme.RoQME.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(otherlv_4, grammarAccess.getBindingAccess().getRightParenthesisKeyword_1_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:702:4: ( ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )
                    {
                    // InternalMIRoN.g:702:4: ( ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* )
                    // InternalMIRoN.g:703:5: ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )*
                    {
                    // InternalMIRoN.g:703:5: ( ( ruleEString ) )
                    // InternalMIRoN.g:704:6: ( ruleEString )
                    {
                    // InternalMIRoN.g:704:6: ( ruleEString )
                    // InternalMIRoN.g:705:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getBindingRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getBindingAccess().getTargetsEObjectCrossReference_1_1_0_0());
                    						
                    pushFollow(FOLLOW_20);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalMIRoN.g:719:5: (otherlv_6= ',' ( ( ruleEString ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==19) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalMIRoN.g:720:6: otherlv_6= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_6=(Token)match(input,19,FOLLOW_4); 

                    	    						newLeafNode(otherlv_6, grammarAccess.getBindingAccess().getCommaKeyword_1_1_1_0());
                    	    					
                    	    // InternalMIRoN.g:724:6: ( ( ruleEString ) )
                    	    // InternalMIRoN.g:725:7: ( ruleEString )
                    	    {
                    	    // InternalMIRoN.g:725:7: ( ruleEString )
                    	    // InternalMIRoN.g:726:8: ruleEString
                    	    {

                    	    								if (current==null) {
                    	    									current = createModelElement(grammarAccess.getBindingRule());
                    	    								}
                    	    							

                    	    								newCompositeNode(grammarAccess.getBindingAccess().getTargetsEObjectCrossReference_1_1_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_20);
                    	    ruleEString();

                    	    state._fsp--;


                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


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
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleSentence"
    // InternalMIRoN.g:747:1: entryRuleSentence returns [EObject current=null] : iv_ruleSentence= ruleSentence EOF ;
    public final EObject entryRuleSentence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSentence = null;


        try {
            // InternalMIRoN.g:747:49: (iv_ruleSentence= ruleSentence EOF )
            // InternalMIRoN.g:748:2: iv_ruleSentence= ruleSentence EOF
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
    // InternalMIRoN.g:754:1: ruleSentence returns [EObject current=null] : (this_Observation_0= ruleObservation | this_Rule_1= ruleRule ) ;
    public final EObject ruleSentence() throws RecognitionException {
        EObject current = null;

        EObject this_Observation_0 = null;

        EObject this_Rule_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:760:2: ( (this_Observation_0= ruleObservation | this_Rule_1= ruleRule ) )
            // InternalMIRoN.g:761:2: (this_Observation_0= ruleObservation | this_Rule_1= ruleRule )
            {
            // InternalMIRoN.g:761:2: (this_Observation_0= ruleObservation | this_Rule_1= ruleRule )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ROQME_DESCRIPTION||LA12_0==41) ) {
                alt12=1;
            }
            else if ( (LA12_0==26) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalMIRoN.g:762:3: this_Observation_0= ruleObservation
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
                    // InternalMIRoN.g:771:3: this_Rule_1= ruleRule
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
    // InternalMIRoN.g:783:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalMIRoN.g:783:45: (iv_ruleRule= ruleRule EOF )
            // InternalMIRoN.g:784:2: iv_ruleRule= ruleRule EOF
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
    // InternalMIRoN.g:790:1: ruleRule returns [EObject current=null] : (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_trigger_3_0= ruleContextPattern ) ) otherlv_4= 'implies' ( ( (lv_actions_5_0= ruleRuleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}' ) ) ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_trigger_3_0 = null;

        EObject lv_actions_5_0 = null;

        EObject lv_actions_7_0 = null;

        EObject lv_actions_9_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:796:2: ( (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_trigger_3_0= ruleContextPattern ) ) otherlv_4= 'implies' ( ( (lv_actions_5_0= ruleRuleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}' ) ) ) )
            // InternalMIRoN.g:797:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_trigger_3_0= ruleContextPattern ) ) otherlv_4= 'implies' ( ( (lv_actions_5_0= ruleRuleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}' ) ) )
            {
            // InternalMIRoN.g:797:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_trigger_3_0= ruleContextPattern ) ) otherlv_4= 'implies' ( ( (lv_actions_5_0= ruleRuleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}' ) ) )
            // InternalMIRoN.g:798:3: otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_trigger_3_0= ruleContextPattern ) ) otherlv_4= 'implies' ( ( (lv_actions_5_0= ruleRuleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}' ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
            		
            // InternalMIRoN.g:802:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:803:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:803:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:804:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:824:3: ( (lv_trigger_3_0= ruleContextPattern ) )
            // InternalMIRoN.g:825:4: (lv_trigger_3_0= ruleContextPattern )
            {
            // InternalMIRoN.g:825:4: (lv_trigger_3_0= ruleContextPattern )
            // InternalMIRoN.g:826:5: lv_trigger_3_0= ruleContextPattern
            {

            					newCompositeNode(grammarAccess.getRuleAccess().getTriggerContextPatternParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_22);
            lv_trigger_3_0=ruleContextPattern();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleRule());
            					}
            					set(
            						current,
            						"trigger",
            						lv_trigger_3_0,
            						"org.xtext.roqme.RoQME.ContextPattern");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,27,FOLLOW_23); 

            			newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getImpliesKeyword_4());
            		
            // InternalMIRoN.g:847:3: ( ( (lv_actions_5_0= ruleRuleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==18) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalMIRoN.g:848:4: ( (lv_actions_5_0= ruleRuleAction ) )
                    {
                    // InternalMIRoN.g:848:4: ( (lv_actions_5_0= ruleRuleAction ) )
                    // InternalMIRoN.g:849:5: (lv_actions_5_0= ruleRuleAction )
                    {
                    // InternalMIRoN.g:849:5: (lv_actions_5_0= ruleRuleAction )
                    // InternalMIRoN.g:850:6: lv_actions_5_0= ruleRuleAction
                    {

                    						newCompositeNode(grammarAccess.getRuleAccess().getActionsRuleActionParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_actions_5_0=ruleRuleAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRuleRule());
                    						}
                    						add(
                    							current,
                    							"actions",
                    							lv_actions_5_0,
                    							"org.xtext.miron.MIRoN.RuleAction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:868:4: (otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}' )
                    {
                    // InternalMIRoN.g:868:4: (otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}' )
                    // InternalMIRoN.g:869:5: otherlv_6= '{' ( (lv_actions_7_0= ruleRuleAction ) ) (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+ otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_12); 

                    					newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_5_1_0());
                    				
                    // InternalMIRoN.g:873:5: ( (lv_actions_7_0= ruleRuleAction ) )
                    // InternalMIRoN.g:874:6: (lv_actions_7_0= ruleRuleAction )
                    {
                    // InternalMIRoN.g:874:6: (lv_actions_7_0= ruleRuleAction )
                    // InternalMIRoN.g:875:7: lv_actions_7_0= ruleRuleAction
                    {

                    							newCompositeNode(grammarAccess.getRuleAccess().getActionsRuleActionParserRuleCall_5_1_1_0());
                    						
                    pushFollow(FOLLOW_24);
                    lv_actions_7_0=ruleRuleAction();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRuleRule());
                    							}
                    							add(
                    								current,
                    								"actions",
                    								lv_actions_7_0,
                    								"org.xtext.miron.MIRoN.RuleAction");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalMIRoN.g:892:5: (otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) ) )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==19) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalMIRoN.g:893:6: otherlv_8= ',' ( (lv_actions_9_0= ruleRuleAction ) )
                    	    {
                    	    otherlv_8=(Token)match(input,19,FOLLOW_12); 

                    	    						newLeafNode(otherlv_8, grammarAccess.getRuleAccess().getCommaKeyword_5_1_2_0());
                    	    					
                    	    // InternalMIRoN.g:897:6: ( (lv_actions_9_0= ruleRuleAction ) )
                    	    // InternalMIRoN.g:898:7: (lv_actions_9_0= ruleRuleAction )
                    	    {
                    	    // InternalMIRoN.g:898:7: (lv_actions_9_0= ruleRuleAction )
                    	    // InternalMIRoN.g:899:8: lv_actions_9_0= ruleRuleAction
                    	    {

                    	    								newCompositeNode(grammarAccess.getRuleAccess().getActionsRuleActionParserRuleCall_5_1_2_1_0());
                    	    							
                    	    pushFollow(FOLLOW_13);
                    	    lv_actions_9_0=ruleRuleAction();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getRuleRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"actions",
                    	    									lv_actions_9_0,
                    	    									"org.xtext.miron.MIRoN.RuleAction");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


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

                    otherlv_10=(Token)match(input,20,FOLLOW_2); 

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


    // $ANTLR start "entryRuleRuleAction"
    // InternalMIRoN.g:927:1: entryRuleRuleAction returns [EObject current=null] : iv_ruleRuleAction= ruleRuleAction EOF ;
    public final EObject entryRuleRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleAction = null;


        try {
            // InternalMIRoN.g:927:51: (iv_ruleRuleAction= ruleRuleAction EOF )
            // InternalMIRoN.g:928:2: iv_ruleRuleAction= ruleRuleAction EOF
            {
             newCompositeNode(grammarAccess.getRuleActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRuleAction=ruleRuleAction();

            state._fsp--;

             current =iv_ruleRuleAction; 
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
    // $ANTLR end "entryRuleRuleAction"


    // $ANTLR start "ruleRuleAction"
    // InternalMIRoN.g:934:1: ruleRuleAction returns [EObject current=null] : this_VariantAssignment_0= ruleVariantAssignment ;
    public final EObject ruleRuleAction() throws RecognitionException {
        EObject current = null;

        EObject this_VariantAssignment_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:940:2: (this_VariantAssignment_0= ruleVariantAssignment )
            // InternalMIRoN.g:941:2: this_VariantAssignment_0= ruleVariantAssignment
            {

            		newCompositeNode(grammarAccess.getRuleActionAccess().getVariantAssignmentParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_VariantAssignment_0=ruleVariantAssignment();

            state._fsp--;


            		current = this_VariantAssignment_0;
            		afterParserOrEnumRuleCall();
            	

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
    // $ANTLR end "ruleRuleAction"


    // $ANTLR start "entryRuleVariantAssignment"
    // InternalMIRoN.g:952:1: entryRuleVariantAssignment returns [EObject current=null] : iv_ruleVariantAssignment= ruleVariantAssignment EOF ;
    public final EObject entryRuleVariantAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantAssignment = null;


        try {
            // InternalMIRoN.g:952:58: (iv_ruleVariantAssignment= ruleVariantAssignment EOF )
            // InternalMIRoN.g:953:2: iv_ruleVariantAssignment= ruleVariantAssignment EOF
            {
             newCompositeNode(grammarAccess.getVariantAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariantAssignment=ruleVariantAssignment();

            state._fsp--;

             current =iv_ruleVariantAssignment; 
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
    // $ANTLR end "entryRuleVariantAssignment"


    // $ANTLR start "ruleVariantAssignment"
    // InternalMIRoN.g:959:1: ruleVariantAssignment returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleTypedValue ) ) ) ;
    public final EObject ruleVariantAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:965:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleTypedValue ) ) ) )
            // InternalMIRoN.g:966:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleTypedValue ) ) )
            {
            // InternalMIRoN.g:966:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleTypedValue ) ) )
            // InternalMIRoN.g:967:3: ( ( ruleQualifiedName ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleTypedValue ) )
            {
            // InternalMIRoN.g:967:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:968:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:968:4: ( ruleQualifiedName )
            // InternalMIRoN.g:969:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariantAssignmentRule());
            					}
            				

            					newCompositeNode(grammarAccess.getVariantAssignmentAccess().getVariableVariationPointCrossReference_0_0());
            				
            pushFollow(FOLLOW_25);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getVariantAssignmentAccess().getColonEqualsSignKeyword_1());
            		
            // InternalMIRoN.g:987:3: ( (lv_value_2_0= ruleTypedValue ) )
            // InternalMIRoN.g:988:4: (lv_value_2_0= ruleTypedValue )
            {
            // InternalMIRoN.g:988:4: (lv_value_2_0= ruleTypedValue )
            // InternalMIRoN.g:989:5: lv_value_2_0= ruleTypedValue
            {

            					newCompositeNode(grammarAccess.getVariantAssignmentAccess().getValueTypedValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleTypedValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariantAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.xtext.roqme.RoQME.TypedValue");
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
    // $ANTLR end "ruleVariantAssignment"


    // $ANTLR start "entryRuleContext"
    // InternalMIRoN.g:1010:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalMIRoN.g:1010:48: (iv_ruleContext= ruleContext EOF )
            // InternalMIRoN.g:1011:2: iv_ruleContext= ruleContext EOF
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
    // InternalMIRoN.g:1017:1: ruleContext returns [EObject current=null] : (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        EObject this_DerivedContext_0 = null;

        EObject this_PrimitiveContext_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1023:2: ( (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext ) )
            // InternalMIRoN.g:1024:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )
            {
            // InternalMIRoN.g:1024:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalMIRoN.g:1025:3: this_DerivedContext_0= ruleDerivedContext
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
                    // InternalMIRoN.g:1034:3: this_PrimitiveContext_1= rulePrimitiveContext
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
    // InternalMIRoN.g:1046:1: entryRulePrimitiveContext returns [EObject current=null] : iv_rulePrimitiveContext= rulePrimitiveContext EOF ;
    public final EObject entryRulePrimitiveContext() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveContext = null;


        try {
            // InternalMIRoN.g:1046:57: (iv_rulePrimitiveContext= rulePrimitiveContext EOF )
            // InternalMIRoN.g:1047:2: iv_rulePrimitiveContext= rulePrimitiveContext EOF
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
    // InternalMIRoN.g:1053:1: rulePrimitiveContext returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) ) ;
    public final EObject rulePrimitiveContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1059:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) ) )
            // InternalMIRoN.g:1060:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) )
            {
            // InternalMIRoN.g:1060:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) )
            // InternalMIRoN.g:1061:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            {
            // InternalMIRoN.g:1061:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ROQME_DESCRIPTION) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMIRoN.g:1062:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:1062:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:1063:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getPrimitiveContextAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_27);
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

            otherlv_1=(Token)match(input,29,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getPrimitiveContextAccess().getContextKeyword_1());
            		
            // InternalMIRoN.g:1084:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:1085:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:1085:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:1086:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_3=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getPrimitiveContextAccess().getColonKeyword_3());
            		
            // InternalMIRoN.g:1106:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:1107:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:1107:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:1108:5: lv_declaration_4_0= ruleDataTypeDeclaration
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
    // InternalMIRoN.g:1129:1: entryRuleDerivedContext returns [EObject current=null] : iv_ruleDerivedContext= ruleDerivedContext EOF ;
    public final EObject entryRuleDerivedContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedContext = null;


        try {
            // InternalMIRoN.g:1129:55: (iv_ruleDerivedContext= ruleDerivedContext EOF )
            // InternalMIRoN.g:1130:2: iv_ruleDerivedContext= ruleDerivedContext EOF
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
    // InternalMIRoN.g:1136:1: ruleDerivedContext returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) ) ;
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
            // InternalMIRoN.g:1142:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) ) )
            // InternalMIRoN.g:1143:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) )
            {
            // InternalMIRoN.g:1143:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) )
            // InternalMIRoN.g:1144:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) )
            {
            // InternalMIRoN.g:1144:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ROQME_DESCRIPTION) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMIRoN.g:1145:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:1145:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:1146:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getDerivedContextAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_27);
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

            otherlv_1=(Token)match(input,29,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getDerivedContextAccess().getContextKeyword_1());
            		
            // InternalMIRoN.g:1167:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:1168:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:1168:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:1169:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_3=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getDerivedContextAccess().getColonKeyword_3());
            		
            // InternalMIRoN.g:1189:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:1190:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:1190:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:1191:5: lv_declaration_4_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getDerivedContextAccess().getDeclarationDataTypeDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_25);
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

            otherlv_5=(Token)match(input,28,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getDerivedContextAccess().getColonEqualsSignKeyword_5());
            		
            // InternalMIRoN.g:1212:3: ( (lv_definition_6_0= ruleContextPattern ) )
            // InternalMIRoN.g:1213:4: (lv_definition_6_0= ruleContextPattern )
            {
            // InternalMIRoN.g:1213:4: (lv_definition_6_0= ruleContextPattern )
            // InternalMIRoN.g:1214:5: lv_definition_6_0= ruleContextPattern
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
    // InternalMIRoN.g:1235:1: entryRuleGeneralPurposeVariable returns [EObject current=null] : iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF ;
    public final EObject entryRuleGeneralPurposeVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralPurposeVariable = null;


        try {
            // InternalMIRoN.g:1235:63: (iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF )
            // InternalMIRoN.g:1236:2: iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF
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
    // InternalMIRoN.g:1242:1: ruleGeneralPurposeVariable returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) ) ;
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
            // InternalMIRoN.g:1248:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) ) )
            // InternalMIRoN.g:1249:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) )
            {
            // InternalMIRoN.g:1249:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) )
            // InternalMIRoN.g:1250:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneralPurposeVariableAccess().getVarKeyword_0());
            		
            // InternalMIRoN.g:1254:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:1255:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:1255:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:1256:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getGeneralPurposeVariableAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:1276:3: ( (lv_declaration_3_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:1277:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:1277:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:1278:5: lv_declaration_3_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getGeneralPurposeVariableAccess().getDeclarationDataTypeDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_25);
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

            // InternalMIRoN.g:1295:3: (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) )
            // InternalMIRoN.g:1296:4: otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) )
            {
            otherlv_4=(Token)match(input,28,FOLLOW_21); 

            				newLeafNode(otherlv_4, grammarAccess.getGeneralPurposeVariableAccess().getColonEqualsSignKeyword_4_0());
            			
            // InternalMIRoN.g:1300:4: ( (lv_definition_5_0= ruleGeneralExpression ) )
            // InternalMIRoN.g:1301:5: (lv_definition_5_0= ruleGeneralExpression )
            {
            // InternalMIRoN.g:1301:5: (lv_definition_5_0= ruleGeneralExpression )
            // InternalMIRoN.g:1302:6: lv_definition_5_0= ruleGeneralExpression
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
    // InternalMIRoN.g:1324:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMIRoN.g:1324:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMIRoN.g:1325:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalMIRoN.g:1331:1: ruleParameter returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? ) ;
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
            // InternalMIRoN.g:1337:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? ) )
            // InternalMIRoN.g:1338:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? )
            {
            // InternalMIRoN.g:1338:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? )
            // InternalMIRoN.g:1339:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )?
            {
            // InternalMIRoN.g:1339:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ROQME_DESCRIPTION) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMIRoN.g:1340:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:1340:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:1341:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_28);
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

            otherlv_1=(Token)match(input,31,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getParamKeyword_1());
            		
            // InternalMIRoN.g:1362:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:1363:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:1363:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:1364:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_3=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterAccess().getColonKeyword_3());
            		
            // InternalMIRoN.g:1384:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalMIRoN.g:1385:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalMIRoN.g:1385:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalMIRoN.g:1386:5: lv_declaration_4_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getDeclarationDataTypeDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_29);
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

            // InternalMIRoN.g:1403:3: (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMIRoN.g:1404:4: otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) )
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_26); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getDefaultKeyword_5_0());
                    			
                    // InternalMIRoN.g:1408:4: ( (lv_initializedTo_6_0= ruleTypedValue ) )
                    // InternalMIRoN.g:1409:5: (lv_initializedTo_6_0= ruleTypedValue )
                    {
                    // InternalMIRoN.g:1409:5: (lv_initializedTo_6_0= ruleTypedValue )
                    // InternalMIRoN.g:1410:6: lv_initializedTo_6_0= ruleTypedValue
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
    // InternalMIRoN.g:1432:1: entryRuleTimer returns [EObject current=null] : iv_ruleTimer= ruleTimer EOF ;
    public final EObject entryRuleTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimer = null;


        try {
            // InternalMIRoN.g:1432:46: (iv_ruleTimer= ruleTimer EOF )
            // InternalMIRoN.g:1433:2: iv_ruleTimer= ruleTimer EOF
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
    // InternalMIRoN.g:1439:1: ruleTimer returns [EObject current=null] : (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) ) ;
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
            // InternalMIRoN.g:1445:2: ( (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) ) )
            // InternalMIRoN.g:1446:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalMIRoN.g:1446:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) )
            // InternalMIRoN.g:1447:3: otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getTimerAccess().getTimerKeyword_0());
            		
            // InternalMIRoN.g:1451:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:1452:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:1452:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:1453:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_30); 

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

            // InternalMIRoN.g:1469:3: ( (lv_declaration_2_0= ruleInbuiltDeclaration ) )
            // InternalMIRoN.g:1470:4: (lv_declaration_2_0= ruleInbuiltDeclaration )
            {
            // InternalMIRoN.g:1470:4: (lv_declaration_2_0= ruleInbuiltDeclaration )
            // InternalMIRoN.g:1471:5: lv_declaration_2_0= ruleInbuiltDeclaration
            {

            					newCompositeNode(grammarAccess.getTimerAccess().getDeclarationInbuiltDeclarationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
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

            // InternalMIRoN.g:1488:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) )
            // InternalMIRoN.g:1489:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalMIRoN.g:1489:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) )
            // InternalMIRoN.g:1490:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            				
            // InternalMIRoN.g:1493:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?)
            // InternalMIRoN.g:1494:6: ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?
            {
            // InternalMIRoN.g:1494:6: ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=5;
                int LA20_0 = input.LA(1);

                if ( LA20_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0) ) {
                    alt20=1;
                }
                else if ( LA20_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1) ) {
                    alt20=2;
                }
                else if ( LA20_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2) ) {
                    alt20=3;
                }
                else if ( LA20_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3) ) {
                    alt20=4;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMIRoN.g:1495:4: ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1495:4: ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalMIRoN.g:1496:5: {...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalMIRoN.g:1496:102: ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) )
            	    // InternalMIRoN.g:1497:6: ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalMIRoN.g:1500:9: ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) )
            	    // InternalMIRoN.g:1500:10: {...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalMIRoN.g:1500:19: (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) )
            	    // InternalMIRoN.g:1500:20: otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) )
            	    {
            	    otherlv_4=(Token)match(input,34,FOLLOW_31); 

            	    									newLeafNode(otherlv_4, grammarAccess.getTimerAccess().getOffsetKeyword_3_0_0());
            	    								
            	    // InternalMIRoN.g:1504:9: ( (lv_offset_5_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:1505:10: (lv_offset_5_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:1505:10: (lv_offset_5_0= ruleTimeValue )
            	    // InternalMIRoN.g:1506:11: lv_offset_5_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getTimerAccess().getOffsetTimeValueParserRuleCall_3_0_1_0());
            	    										
            	    pushFollow(FOLLOW_32);
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
            	    // InternalMIRoN.g:1529:4: ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1529:4: ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) )
            	    // InternalMIRoN.g:1530:5: {...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalMIRoN.g:1530:102: ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) )
            	    // InternalMIRoN.g:1531:6: ({...}? => ( (lv_once_6_0= 'onetime' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalMIRoN.g:1534:9: ({...}? => ( (lv_once_6_0= 'onetime' ) ) )
            	    // InternalMIRoN.g:1534:10: {...}? => ( (lv_once_6_0= 'onetime' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalMIRoN.g:1534:19: ( (lv_once_6_0= 'onetime' ) )
            	    // InternalMIRoN.g:1534:20: (lv_once_6_0= 'onetime' )
            	    {
            	    // InternalMIRoN.g:1534:20: (lv_once_6_0= 'onetime' )
            	    // InternalMIRoN.g:1535:10: lv_once_6_0= 'onetime'
            	    {
            	    lv_once_6_0=(Token)match(input,35,FOLLOW_32); 

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
            	    // InternalMIRoN.g:1552:4: ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1552:4: ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) )
            	    // InternalMIRoN.g:1553:5: {...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalMIRoN.g:1553:102: ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) )
            	    // InternalMIRoN.g:1554:6: ({...}? => ( (lv_paused_7_0= 'paused' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalMIRoN.g:1557:9: ({...}? => ( (lv_paused_7_0= 'paused' ) ) )
            	    // InternalMIRoN.g:1557:10: {...}? => ( (lv_paused_7_0= 'paused' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalMIRoN.g:1557:19: ( (lv_paused_7_0= 'paused' ) )
            	    // InternalMIRoN.g:1557:20: (lv_paused_7_0= 'paused' )
            	    {
            	    // InternalMIRoN.g:1557:20: (lv_paused_7_0= 'paused' )
            	    // InternalMIRoN.g:1558:10: lv_paused_7_0= 'paused'
            	    {
            	    lv_paused_7_0=(Token)match(input,36,FOLLOW_32); 

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
            	    // InternalMIRoN.g:1575:4: ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1575:4: ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) )
            	    // InternalMIRoN.g:1576:5: {...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalMIRoN.g:1576:102: ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) )
            	    // InternalMIRoN.g:1577:6: ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalMIRoN.g:1580:9: ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) )
            	    // InternalMIRoN.g:1580:10: {...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalMIRoN.g:1580:19: (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) )
            	    // InternalMIRoN.g:1580:20: otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) )
            	    {
            	    otherlv_8=(Token)match(input,28,FOLLOW_21); 

            	    									newLeafNode(otherlv_8, grammarAccess.getTimerAccess().getColonEqualsSignKeyword_3_3_0());
            	    								
            	    // InternalMIRoN.g:1584:9: ( (lv_definition_9_0= ruleGeneralExpression ) )
            	    // InternalMIRoN.g:1585:10: (lv_definition_9_0= ruleGeneralExpression )
            	    {
            	    // InternalMIRoN.g:1585:10: (lv_definition_9_0= ruleGeneralExpression )
            	    // InternalMIRoN.g:1586:11: lv_definition_9_0= ruleGeneralExpression
            	    {

            	    											newCompositeNode(grammarAccess.getTimerAccess().getDefinitionGeneralExpressionParserRuleCall_3_3_1_0());
            	    										
            	    pushFollow(FOLLOW_32);
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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
    // InternalMIRoN.g:1621:1: entryRuleBeliefVariable returns [EObject current=null] : iv_ruleBeliefVariable= ruleBeliefVariable EOF ;
    public final EObject entryRuleBeliefVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefVariable = null;


        try {
            // InternalMIRoN.g:1621:55: (iv_ruleBeliefVariable= ruleBeliefVariable EOF )
            // InternalMIRoN.g:1622:2: iv_ruleBeliefVariable= ruleBeliefVariable EOF
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
    // InternalMIRoN.g:1628:1: ruleBeliefVariable returns [EObject current=null] : (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty ) ;
    public final EObject ruleBeliefVariable() throws RecognitionException {
        EObject current = null;

        EObject this_BeliefVariableImpl_0 = null;

        EObject this_Property_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:1634:2: ( (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty ) )
            // InternalMIRoN.g:1635:2: (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty )
            {
            // InternalMIRoN.g:1635:2: (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty )
            int alt21=2;
            switch ( input.LA(1) ) {
            case RULE_ROQME_DESCRIPTION:
                {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==37) ) {
                    alt21=1;
                }
                else if ( (LA21_1==40) ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
                }
                break;
            case 37:
                {
                alt21=1;
                }
                break;
            case 40:
                {
                alt21=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalMIRoN.g:1636:3: this_BeliefVariableImpl_0= ruleBeliefVariableImpl
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
                    // InternalMIRoN.g:1645:3: this_Property_1= ruleProperty
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
    // InternalMIRoN.g:1657:1: entryRuleBeliefVariableImpl returns [EObject current=null] : iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF ;
    public final EObject entryRuleBeliefVariableImpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefVariableImpl = null;


        try {
            // InternalMIRoN.g:1657:59: (iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF )
            // InternalMIRoN.g:1658:2: iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF
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
    // InternalMIRoN.g:1664:1: ruleBeliefVariableImpl returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
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
            // InternalMIRoN.g:1670:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalMIRoN.g:1671:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalMIRoN.g:1671:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalMIRoN.g:1672:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalMIRoN.g:1672:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ROQME_DESCRIPTION) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMIRoN.g:1673:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:1673:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:1674:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_33);
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

            otherlv_1=(Token)match(input,37,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getBeliefVariableImplAccess().getBeliefvarKeyword_1());
            		
            // InternalMIRoN.g:1695:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:1696:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:1696:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:1697:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_34); 

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

            // InternalMIRoN.g:1713:3: ( (lv_declaration_3_0= ruleInbuiltDeclaration ) )
            // InternalMIRoN.g:1714:4: (lv_declaration_3_0= ruleInbuiltDeclaration )
            {
            // InternalMIRoN.g:1714:4: (lv_declaration_3_0= ruleInbuiltDeclaration )
            // InternalMIRoN.g:1715:5: lv_declaration_3_0= ruleInbuiltDeclaration
            {

            					newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getDeclarationInbuiltDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_35);
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

            // InternalMIRoN.g:1732:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalMIRoN.g:1733:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalMIRoN.g:1733:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalMIRoN.g:1734:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            				
            // InternalMIRoN.g:1737:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalMIRoN.g:1738:6: ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalMIRoN.g:1738:6: ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( LA23_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0) ) {
                    alt23=1;
                }
                else if ( LA23_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalMIRoN.g:1739:4: ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1739:4: ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) )
            	    // InternalMIRoN.g:1740:5: {...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalMIRoN.g:1740:115: ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) )
            	    // InternalMIRoN.g:1741:6: ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalMIRoN.g:1744:9: ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) )
            	    // InternalMIRoN.g:1744:10: {...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "true");
            	    }
            	    // InternalMIRoN.g:1744:19: (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) )
            	    // InternalMIRoN.g:1744:20: otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) )
            	    {
            	    otherlv_5=(Token)match(input,38,FOLLOW_31); 

            	    									newLeafNode(otherlv_5, grammarAccess.getBeliefVariableImplAccess().getReferenceKeyword_4_0_0());
            	    								
            	    // InternalMIRoN.g:1748:9: ( (lv_reference_6_0= ruleEDouble ) )
            	    // InternalMIRoN.g:1749:10: (lv_reference_6_0= ruleEDouble )
            	    {
            	    // InternalMIRoN.g:1749:10: (lv_reference_6_0= ruleEDouble )
            	    // InternalMIRoN.g:1750:11: lv_reference_6_0= ruleEDouble
            	    {

            	    											newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getReferenceEDoubleParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_35);
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
            	    // InternalMIRoN.g:1773:4: ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1773:4: ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalMIRoN.g:1774:5: {...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalMIRoN.g:1774:115: ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) )
            	    // InternalMIRoN.g:1775:6: ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalMIRoN.g:1778:9: ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) )
            	    // InternalMIRoN.g:1778:10: {...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "true");
            	    }
            	    // InternalMIRoN.g:1778:19: (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) )
            	    // InternalMIRoN.g:1778:20: otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) )
            	    {
            	    otherlv_7=(Token)match(input,39,FOLLOW_31); 

            	    									newLeafNode(otherlv_7, grammarAccess.getBeliefVariableImplAccess().getSurvivalKeyword_4_1_0());
            	    								
            	    // InternalMIRoN.g:1782:9: ( (lv_survival_8_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:1783:10: (lv_survival_8_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:1783:10: (lv_survival_8_0= ruleTimeValue )
            	    // InternalMIRoN.g:1784:11: lv_survival_8_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getSurvivalTimeValueParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_35);
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
            	    break loop23;
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
    // InternalMIRoN.g:1818:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalMIRoN.g:1818:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalMIRoN.g:1819:2: iv_ruleProperty= ruleProperty EOF
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
    // InternalMIRoN.g:1825:1: ruleProperty returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
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
            // InternalMIRoN.g:1831:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalMIRoN.g:1832:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalMIRoN.g:1832:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalMIRoN.g:1833:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalMIRoN.g:1833:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ROQME_DESCRIPTION) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMIRoN.g:1834:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:1834:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:1835:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getPropertyAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_36);
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

            otherlv_1=(Token)match(input,40,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getPropertyKeyword_1());
            		
            // InternalMIRoN.g:1856:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:1857:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:1857:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:1858:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_37); 

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

            // InternalMIRoN.g:1874:3: ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==21) ) {
                alt25=1;
            }
            else if ( (LA25_0==EOF||LA25_0==RULE_ROQME_DESCRIPTION||LA25_0==22||LA25_0==26||(LA25_0>=28 && LA25_0<=41)||LA25_0==47||(LA25_0>=95 && LA25_0<=97)) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalMIRoN.g:1875:4: (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) )
                    {
                    // InternalMIRoN.g:1875:4: (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) )
                    // InternalMIRoN.g:1876:5: otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) )
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_15); 

                    					newLeafNode(otherlv_3, grammarAccess.getPropertyAccess().getColonKeyword_3_0_0());
                    				
                    // InternalMIRoN.g:1880:5: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
                    // InternalMIRoN.g:1881:6: (lv_declaration_4_0= ruleDataTypeDeclaration )
                    {
                    // InternalMIRoN.g:1881:6: (lv_declaration_4_0= ruleDataTypeDeclaration )
                    // InternalMIRoN.g:1882:7: lv_declaration_4_0= ruleDataTypeDeclaration
                    {

                    							newCompositeNode(grammarAccess.getPropertyAccess().getDeclarationDataTypeDeclarationParserRuleCall_3_0_1_0());
                    						
                    pushFollow(FOLLOW_25);
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

                    otherlv_5=(Token)match(input,28,FOLLOW_21); 

                    					newLeafNode(otherlv_5, grammarAccess.getPropertyAccess().getColonEqualsSignKeyword_3_0_2());
                    				
                    // InternalMIRoN.g:1903:5: ( (lv_transformation_6_0= ruleOutputTransformation ) )
                    // InternalMIRoN.g:1904:6: (lv_transformation_6_0= ruleOutputTransformation )
                    {
                    // InternalMIRoN.g:1904:6: (lv_transformation_6_0= ruleOutputTransformation )
                    // InternalMIRoN.g:1905:7: lv_transformation_6_0= ruleOutputTransformation
                    {

                    							newCompositeNode(grammarAccess.getPropertyAccess().getTransformationOutputTransformationParserRuleCall_3_0_3_0());
                    						
                    pushFollow(FOLLOW_35);
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
                    // InternalMIRoN.g:1924:4: ( (lv_declaration_7_0= ruleInbuiltDeclaration ) )
                    {
                    // InternalMIRoN.g:1924:4: ( (lv_declaration_7_0= ruleInbuiltDeclaration ) )
                    // InternalMIRoN.g:1925:5: (lv_declaration_7_0= ruleInbuiltDeclaration )
                    {
                    // InternalMIRoN.g:1925:5: (lv_declaration_7_0= ruleInbuiltDeclaration )
                    // InternalMIRoN.g:1926:6: lv_declaration_7_0= ruleInbuiltDeclaration
                    {

                    						newCompositeNode(grammarAccess.getPropertyAccess().getDeclarationInbuiltDeclarationParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_35);
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

            // InternalMIRoN.g:1944:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalMIRoN.g:1945:4: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalMIRoN.g:1945:4: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalMIRoN.g:1946:5: ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            				
            // InternalMIRoN.g:1949:5: ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalMIRoN.g:1950:6: ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalMIRoN.g:1950:6: ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )*
            loop26:
            do {
                int alt26=3;
                int LA26_0 = input.LA(1);

                if ( LA26_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0) ) {
                    alt26=1;
                }
                else if ( LA26_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1) ) {
                    alt26=2;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMIRoN.g:1951:4: ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1951:4: ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) )
            	    // InternalMIRoN.g:1952:5: {...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalMIRoN.g:1952:105: ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) )
            	    // InternalMIRoN.g:1953:6: ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalMIRoN.g:1956:9: ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) )
            	    // InternalMIRoN.g:1956:10: {...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalMIRoN.g:1956:19: (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) )
            	    // InternalMIRoN.g:1956:20: otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) )
            	    {
            	    otherlv_9=(Token)match(input,38,FOLLOW_31); 

            	    									newLeafNode(otherlv_9, grammarAccess.getPropertyAccess().getReferenceKeyword_4_0_0());
            	    								
            	    // InternalMIRoN.g:1960:9: ( (lv_reference_10_0= ruleEDouble ) )
            	    // InternalMIRoN.g:1961:10: (lv_reference_10_0= ruleEDouble )
            	    {
            	    // InternalMIRoN.g:1961:10: (lv_reference_10_0= ruleEDouble )
            	    // InternalMIRoN.g:1962:11: lv_reference_10_0= ruleEDouble
            	    {

            	    											newCompositeNode(grammarAccess.getPropertyAccess().getReferenceEDoubleParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_35);
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
            	    // InternalMIRoN.g:1985:4: ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:1985:4: ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalMIRoN.g:1986:5: {...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalMIRoN.g:1986:105: ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) )
            	    // InternalMIRoN.g:1987:6: ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalMIRoN.g:1990:9: ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) )
            	    // InternalMIRoN.g:1990:10: {...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalMIRoN.g:1990:19: (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) )
            	    // InternalMIRoN.g:1990:20: otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) )
            	    {
            	    otherlv_11=(Token)match(input,39,FOLLOW_31); 

            	    									newLeafNode(otherlv_11, grammarAccess.getPropertyAccess().getSurvivalKeyword_4_1_0());
            	    								
            	    // InternalMIRoN.g:1994:9: ( (lv_survival_12_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:1995:10: (lv_survival_12_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:1995:10: (lv_survival_12_0= ruleTimeValue )
            	    // InternalMIRoN.g:1996:11: lv_survival_12_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getPropertyAccess().getSurvivalTimeValueParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_35);
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
            	    break loop26;
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
    // InternalMIRoN.g:2030:1: entryRuleObservation returns [EObject current=null] : iv_ruleObservation= ruleObservation EOF ;
    public final EObject entryRuleObservation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObservation = null;


        try {
            // InternalMIRoN.g:2030:52: (iv_ruleObservation= ruleObservation EOF )
            // InternalMIRoN.g:2031:2: iv_ruleObservation= ruleObservation EOF
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
    // InternalMIRoN.g:2037:1: ruleObservation returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) ) ;
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
            // InternalMIRoN.g:2043:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) ) )
            // InternalMIRoN.g:2044:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) )
            {
            // InternalMIRoN.g:2044:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) )
            // InternalMIRoN.g:2045:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) )
            {
            // InternalMIRoN.g:2045:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ROQME_DESCRIPTION) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMIRoN.g:2046:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalMIRoN.g:2046:4: (lv_description_0_0= ruleElementDescription )
                    // InternalMIRoN.g:2047:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getObservationAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_38);
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

            otherlv_1=(Token)match(input,41,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getObservationAccess().getObservationKeyword_1());
            		
            // InternalMIRoN.g:2068:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMIRoN.g:2069:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMIRoN.g:2069:4: (lv_name_2_0= RULE_ID )
            // InternalMIRoN.g:2070:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_3=(Token)match(input,21,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getObservationAccess().getColonKeyword_3());
            		
            // InternalMIRoN.g:2090:3: ( (lv_pattern_4_0= ruleContextPattern ) )
            // InternalMIRoN.g:2091:4: (lv_pattern_4_0= ruleContextPattern )
            {
            // InternalMIRoN.g:2091:4: (lv_pattern_4_0= ruleContextPattern )
            // InternalMIRoN.g:2092:5: lv_pattern_4_0= ruleContextPattern
            {

            					newCompositeNode(grammarAccess.getObservationAccess().getPatternContextPatternParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_39);
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

            // InternalMIRoN.g:2109:3: ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=42 && LA29_0<=46)||(LA29_0>=98 && LA29_0<=99)) ) {
                alt29=1;
            }
            else if ( (LA29_0==18) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalMIRoN.g:2110:4: ( (lv_actions_5_0= ruleAction ) )
                    {
                    // InternalMIRoN.g:2110:4: ( (lv_actions_5_0= ruleAction ) )
                    // InternalMIRoN.g:2111:5: (lv_actions_5_0= ruleAction )
                    {
                    // InternalMIRoN.g:2111:5: (lv_actions_5_0= ruleAction )
                    // InternalMIRoN.g:2112:6: lv_actions_5_0= ruleAction
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
                    // InternalMIRoN.g:2130:4: (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' )
                    {
                    // InternalMIRoN.g:2130:4: (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' )
                    // InternalMIRoN.g:2131:5: otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_40); 

                    					newLeafNode(otherlv_6, grammarAccess.getObservationAccess().getLeftCurlyBracketKeyword_5_1_0());
                    				
                    // InternalMIRoN.g:2135:5: ( (lv_actions_7_0= ruleAction ) )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>=42 && LA28_0<=46)||(LA28_0>=98 && LA28_0<=99)) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalMIRoN.g:2136:6: (lv_actions_7_0= ruleAction )
                    	    {
                    	    // InternalMIRoN.g:2136:6: (lv_actions_7_0= ruleAction )
                    	    // InternalMIRoN.g:2137:7: lv_actions_7_0= ruleAction
                    	    {

                    	    							newCompositeNode(grammarAccess.getObservationAccess().getActionsActionParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_41);
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
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMIRoN.g:2164:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalMIRoN.g:2164:47: (iv_ruleAction= ruleAction EOF )
            // InternalMIRoN.g:2165:2: iv_ruleAction= ruleAction EOF
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
    // InternalMIRoN.g:2171:1: ruleAction returns [EObject current=null] : (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_SetVariable_0 = null;

        EObject this_ClearEvidence_1 = null;

        EObject this_SetEvidence_2 = null;

        EObject this_TimerAction_3 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2177:2: ( (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction ) )
            // InternalMIRoN.g:2178:2: (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction )
            {
            // InternalMIRoN.g:2178:2: (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt30=1;
                }
                break;
            case 43:
                {
                alt30=2;
                }
                break;
            case 98:
            case 99:
                {
                alt30=3;
                }
                break;
            case 44:
            case 45:
            case 46:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalMIRoN.g:2179:3: this_SetVariable_0= ruleSetVariable
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
                    // InternalMIRoN.g:2188:3: this_ClearEvidence_1= ruleClearEvidence
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
                    // InternalMIRoN.g:2197:3: this_SetEvidence_2= ruleSetEvidence
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
                    // InternalMIRoN.g:2206:3: this_TimerAction_3= ruleTimerAction
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
    // InternalMIRoN.g:2218:1: entryRuleTimerAction returns [EObject current=null] : iv_ruleTimerAction= ruleTimerAction EOF ;
    public final EObject entryRuleTimerAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimerAction = null;


        try {
            // InternalMIRoN.g:2218:52: (iv_ruleTimerAction= ruleTimerAction EOF )
            // InternalMIRoN.g:2219:2: iv_ruleTimerAction= ruleTimerAction EOF
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
    // InternalMIRoN.g:2225:1: ruleTimerAction returns [EObject current=null] : (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer ) ;
    public final EObject ruleTimerAction() throws RecognitionException {
        EObject current = null;

        EObject this_StartTimer_0 = null;

        EObject this_StopTimer_1 = null;

        EObject this_ResumeTimer_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2231:2: ( (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer ) )
            // InternalMIRoN.g:2232:2: (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer )
            {
            // InternalMIRoN.g:2232:2: (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt31=1;
                }
                break;
            case 45:
                {
                alt31=2;
                }
                break;
            case 46:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalMIRoN.g:2233:3: this_StartTimer_0= ruleStartTimer
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
                    // InternalMIRoN.g:2242:3: this_StopTimer_1= ruleStopTimer
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
                    // InternalMIRoN.g:2251:3: this_ResumeTimer_2= ruleResumeTimer
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
    // InternalMIRoN.g:2263:1: entryRuleSetVariable returns [EObject current=null] : iv_ruleSetVariable= ruleSetVariable EOF ;
    public final EObject entryRuleSetVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetVariable = null;


        try {
            // InternalMIRoN.g:2263:52: (iv_ruleSetVariable= ruleSetVariable EOF )
            // InternalMIRoN.g:2264:2: iv_ruleSetVariable= ruleSetVariable EOF
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
    // InternalMIRoN.g:2270:1: ruleSetVariable returns [EObject current=null] : (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) ) ;
    public final EObject ruleSetVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2276:2: ( (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) ) )
            // InternalMIRoN.g:2277:2: (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) )
            {
            // InternalMIRoN.g:2277:2: (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) )
            // InternalMIRoN.g:2278:3: otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getSetVariableAccess().getSetsKeyword_0());
            		
            // InternalMIRoN.g:2282:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:2283:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:2283:4: ( ruleQualifiedName )
            // InternalMIRoN.g:2284:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetVariableRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSetVariableAccess().getVariableTypedVariableCrossReference_1_0());
            				
            pushFollow(FOLLOW_25);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSetVariableAccess().getColonEqualsSignKeyword_2());
            		
            // InternalMIRoN.g:2302:3: ( (lv_expression_3_0= ruleGeneralExpression ) )
            // InternalMIRoN.g:2303:4: (lv_expression_3_0= ruleGeneralExpression )
            {
            // InternalMIRoN.g:2303:4: (lv_expression_3_0= ruleGeneralExpression )
            // InternalMIRoN.g:2304:5: lv_expression_3_0= ruleGeneralExpression
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
    // InternalMIRoN.g:2325:1: entryRuleClearEvidence returns [EObject current=null] : iv_ruleClearEvidence= ruleClearEvidence EOF ;
    public final EObject entryRuleClearEvidence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClearEvidence = null;


        try {
            // InternalMIRoN.g:2325:54: (iv_ruleClearEvidence= ruleClearEvidence EOF )
            // InternalMIRoN.g:2326:2: iv_ruleClearEvidence= ruleClearEvidence EOF
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
    // InternalMIRoN.g:2332:1: ruleClearEvidence returns [EObject current=null] : (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleClearEvidence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:2338:2: ( (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) ) )
            // InternalMIRoN.g:2339:2: (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) )
            {
            // InternalMIRoN.g:2339:2: (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:2340:3: otherlv_0= 'clears' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getClearEvidenceAccess().getClearsKeyword_0());
            		
            // InternalMIRoN.g:2344:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:2345:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:2345:4: ( ruleQualifiedName )
            // InternalMIRoN.g:2346:5: ruleQualifiedName
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
    // InternalMIRoN.g:2364:1: entryRuleSetEvidence returns [EObject current=null] : iv_ruleSetEvidence= ruleSetEvidence EOF ;
    public final EObject entryRuleSetEvidence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetEvidence = null;


        try {
            // InternalMIRoN.g:2364:52: (iv_ruleSetEvidence= ruleSetEvidence EOF )
            // InternalMIRoN.g:2365:2: iv_ruleSetEvidence= ruleSetEvidence EOF
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
    // InternalMIRoN.g:2371:1: ruleSetEvidence returns [EObject current=null] : ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleSetEvidence() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Enumerator lv_influence_0_0 = null;

        Enumerator lv_strength_3_0 = null;

        EObject lv_survival_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2377:2: ( ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalMIRoN.g:2378:2: ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalMIRoN.g:2378:2: ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalMIRoN.g:2379:3: ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalMIRoN.g:2379:3: ( (lv_influence_0_0= ruleInfluenceEnum ) )
            // InternalMIRoN.g:2380:4: (lv_influence_0_0= ruleInfluenceEnum )
            {
            // InternalMIRoN.g:2380:4: (lv_influence_0_0= ruleInfluenceEnum )
            // InternalMIRoN.g:2381:5: lv_influence_0_0= ruleInfluenceEnum
            {

            					newCompositeNode(grammarAccess.getSetEvidenceAccess().getInfluenceInfluenceEnumEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalMIRoN.g:2398:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:2399:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:2399:4: ( ruleQualifiedName )
            // InternalMIRoN.g:2400:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetEvidenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSetEvidenceAccess().getTargetBeliefVariableCrossReference_1_0());
            				
            pushFollow(FOLLOW_42);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:2414:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalMIRoN.g:2415:4: ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalMIRoN.g:2415:4: ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalMIRoN.g:2416:5: ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            				
            // InternalMIRoN.g:2419:5: ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalMIRoN.g:2420:6: ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalMIRoN.g:2420:6: ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )*
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( LA32_0 >= 100 && LA32_0 <= 104 && getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0) ) {
                    alt32=1;
                }
                else if ( LA32_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1) ) {
                    alt32=2;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalMIRoN.g:2421:4: ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2421:4: ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) )
            	    // InternalMIRoN.g:2422:5: {...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalMIRoN.g:2422:108: ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) )
            	    // InternalMIRoN.g:2423:6: ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalMIRoN.g:2426:9: ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) )
            	    // InternalMIRoN.g:2426:10: {...}? => ( (lv_strength_3_0= ruleStrengthEnum ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "true");
            	    }
            	    // InternalMIRoN.g:2426:19: ( (lv_strength_3_0= ruleStrengthEnum ) )
            	    // InternalMIRoN.g:2426:20: (lv_strength_3_0= ruleStrengthEnum )
            	    {
            	    // InternalMIRoN.g:2426:20: (lv_strength_3_0= ruleStrengthEnum )
            	    // InternalMIRoN.g:2427:10: lv_strength_3_0= ruleStrengthEnum
            	    {

            	    										newCompositeNode(grammarAccess.getSetEvidenceAccess().getStrengthStrengthEnumEnumRuleCall_2_0_0());
            	    									
            	    pushFollow(FOLLOW_42);
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
            	    // InternalMIRoN.g:2449:4: ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalMIRoN.g:2449:4: ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalMIRoN.g:2450:5: {...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalMIRoN.g:2450:108: ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) )
            	    // InternalMIRoN.g:2451:6: ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalMIRoN.g:2454:9: ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) )
            	    // InternalMIRoN.g:2454:10: {...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "true");
            	    }
            	    // InternalMIRoN.g:2454:19: (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) )
            	    // InternalMIRoN.g:2454:20: otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) )
            	    {
            	    otherlv_4=(Token)match(input,39,FOLLOW_31); 

            	    									newLeafNode(otherlv_4, grammarAccess.getSetEvidenceAccess().getSurvivalKeyword_2_1_0());
            	    								
            	    // InternalMIRoN.g:2458:9: ( (lv_survival_5_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:2459:10: (lv_survival_5_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:2459:10: (lv_survival_5_0= ruleTimeValue )
            	    // InternalMIRoN.g:2460:11: lv_survival_5_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getSetEvidenceAccess().getSurvivalTimeValueParserRuleCall_2_1_1_0());
            	    										
            	    pushFollow(FOLLOW_42);
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
            	    break loop32;
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
    // InternalMIRoN.g:2494:1: entryRuleStartTimer returns [EObject current=null] : iv_ruleStartTimer= ruleStartTimer EOF ;
    public final EObject entryRuleStartTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartTimer = null;


        try {
            // InternalMIRoN.g:2494:51: (iv_ruleStartTimer= ruleStartTimer EOF )
            // InternalMIRoN.g:2495:2: iv_ruleStartTimer= ruleStartTimer EOF
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
    // InternalMIRoN.g:2501:1: ruleStartTimer returns [EObject current=null] : (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStartTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:2507:2: ( (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) ) )
            // InternalMIRoN.g:2508:2: (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) )
            {
            // InternalMIRoN.g:2508:2: (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:2509:3: otherlv_0= 'starts' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getStartTimerAccess().getStartsKeyword_0());
            		
            // InternalMIRoN.g:2513:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:2514:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:2514:4: ( ruleQualifiedName )
            // InternalMIRoN.g:2515:5: ruleQualifiedName
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
    // InternalMIRoN.g:2533:1: entryRuleStopTimer returns [EObject current=null] : iv_ruleStopTimer= ruleStopTimer EOF ;
    public final EObject entryRuleStopTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopTimer = null;


        try {
            // InternalMIRoN.g:2533:50: (iv_ruleStopTimer= ruleStopTimer EOF )
            // InternalMIRoN.g:2534:2: iv_ruleStopTimer= ruleStopTimer EOF
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
    // InternalMIRoN.g:2540:1: ruleStopTimer returns [EObject current=null] : (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStopTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:2546:2: ( (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) ) )
            // InternalMIRoN.g:2547:2: (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) )
            {
            // InternalMIRoN.g:2547:2: (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:2548:3: otherlv_0= 'stops' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getStopTimerAccess().getStopsKeyword_0());
            		
            // InternalMIRoN.g:2552:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:2553:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:2553:4: ( ruleQualifiedName )
            // InternalMIRoN.g:2554:5: ruleQualifiedName
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
    // InternalMIRoN.g:2572:1: entryRuleResumeTimer returns [EObject current=null] : iv_ruleResumeTimer= ruleResumeTimer EOF ;
    public final EObject entryRuleResumeTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResumeTimer = null;


        try {
            // InternalMIRoN.g:2572:52: (iv_ruleResumeTimer= ruleResumeTimer EOF )
            // InternalMIRoN.g:2573:2: iv_ruleResumeTimer= ruleResumeTimer EOF
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
    // InternalMIRoN.g:2579:1: ruleResumeTimer returns [EObject current=null] : (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleResumeTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:2585:2: ( (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) ) )
            // InternalMIRoN.g:2586:2: (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) )
            {
            // InternalMIRoN.g:2586:2: (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:2587:3: otherlv_0= 'resumes' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getResumeTimerAccess().getResumesKeyword_0());
            		
            // InternalMIRoN.g:2591:3: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:2592:4: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:2592:4: ( ruleQualifiedName )
            // InternalMIRoN.g:2593:5: ruleQualifiedName
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
    // InternalMIRoN.g:2611:1: entryRuleDataTypeDefinition returns [EObject current=null] : iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF ;
    public final EObject entryRuleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinition = null;


        try {
            // InternalMIRoN.g:2611:59: (iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF )
            // InternalMIRoN.g:2612:2: iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF
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
    // InternalMIRoN.g:2618:1: ruleDataTypeDefinition returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) ) ;
    public final EObject ruleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dataType_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2624:2: ( (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) ) )
            // InternalMIRoN.g:2625:2: (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) )
            {
            // InternalMIRoN.g:2625:2: (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) )
            // InternalMIRoN.g:2626:3: otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDataTypeDefinitionAccess().getTypeKeyword_0());
            		
            // InternalMIRoN.g:2630:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMIRoN.g:2631:4: (lv_name_1_0= ruleEString )
            {
            // InternalMIRoN.g:2631:4: (lv_name_1_0= ruleEString )
            // InternalMIRoN.g:2632:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_2=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getDataTypeDefinitionAccess().getColonKeyword_2());
            		
            // InternalMIRoN.g:2653:3: ( (lv_dataType_3_0= ruleDataType ) )
            // InternalMIRoN.g:2654:4: (lv_dataType_3_0= ruleDataType )
            {
            // InternalMIRoN.g:2654:4: (lv_dataType_3_0= ruleDataType )
            // InternalMIRoN.g:2655:5: lv_dataType_3_0= ruleDataType
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
            						"org.xtext.roqme.RoQME.DataType");
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


    // $ANTLR start "entryRuleDataType"
    // InternalMIRoN.g:2676:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalMIRoN.g:2676:49: (iv_ruleDataType= ruleDataType EOF )
            // InternalMIRoN.g:2677:2: iv_ruleDataType= ruleDataType EOF
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
    // InternalMIRoN.g:2683:1: ruleDataType returns [EObject current=null] : (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanType_0 = null;

        EObject this_EnumType_1 = null;

        EObject this_EventType_2 = null;

        EObject this_NumericType_3 = null;

        EObject this_UnitMeasuredType_4 = null;

        EObject this_TimeType_5 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2689:2: ( (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType ) )
            // InternalMIRoN.g:2690:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType )
            {
            // InternalMIRoN.g:2690:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType )
            int alt33=6;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // InternalMIRoN.g:2691:3: this_BooleanType_0= ruleBooleanType
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
                    // InternalMIRoN.g:2700:3: this_EnumType_1= ruleEnumType
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
                    // InternalMIRoN.g:2709:3: this_EventType_2= ruleEventType
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
                    // InternalMIRoN.g:2718:3: this_NumericType_3= ruleNumericType
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
                    // InternalMIRoN.g:2727:3: this_UnitMeasuredType_4= ruleUnitMeasuredType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getUnitMeasuredTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredType_4=ruleUnitMeasuredType();

                    state._fsp--;


                    			current = this_UnitMeasuredType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:2736:3: this_TimeType_5= ruleTimeType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getTimeTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeType_5=ruleTimeType();

                    state._fsp--;


                    			current = this_TimeType_5;
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


    // $ANTLR start "entryRuleBooleanType"
    // InternalMIRoN.g:2748:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalMIRoN.g:2748:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalMIRoN.g:2749:2: iv_ruleBooleanType= ruleBooleanType EOF
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
    // InternalMIRoN.g:2755:1: ruleBooleanType returns [EObject current=null] : ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIRoN.g:2761:2: ( ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // InternalMIRoN.g:2762:2: ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // InternalMIRoN.g:2762:2: ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // InternalMIRoN.g:2763:3: () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // InternalMIRoN.g:2763:3: ()
            // InternalMIRoN.g:2764:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanTypeAccess().getBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,48,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalMIRoN.g:2774:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==16) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMIRoN.g:2775:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:2779:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:2780:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:2780:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:2781:6: lv_cardinality_3_0= RULE_INT
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


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalMIRoN.g:2806:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalMIRoN.g:2806:52: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalMIRoN.g:2807:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteral=ruleEnumLiteral();

            state._fsp--;

             current =iv_ruleEnumLiteral; 
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
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalMIRoN.g:2813:1: ruleEnumLiteral returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:2819:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMIRoN.g:2820:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMIRoN.g:2820:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMIRoN.g:2821:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalMIRoN.g:2821:3: ()
            // InternalMIRoN.g:2822:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumLiteralAccess().getEnumLiteralAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:2828:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIRoN.g:2829:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIRoN.g:2829:4: (lv_name_1_0= RULE_ID )
            // InternalMIRoN.g:2830:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumLiteralRule());
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
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "entryRuleEventType"
    // InternalMIRoN.g:2850:1: entryRuleEventType returns [EObject current=null] : iv_ruleEventType= ruleEventType EOF ;
    public final EObject entryRuleEventType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventType = null;


        try {
            // InternalMIRoN.g:2850:50: (iv_ruleEventType= ruleEventType EOF )
            // InternalMIRoN.g:2851:2: iv_ruleEventType= ruleEventType EOF
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
    // InternalMIRoN.g:2857:1: ruleEventType returns [EObject current=null] : ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleEventType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIRoN.g:2863:2: ( ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // InternalMIRoN.g:2864:2: ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // InternalMIRoN.g:2864:2: ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // InternalMIRoN.g:2865:3: () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // InternalMIRoN.g:2865:3: ()
            // InternalMIRoN.g:2866:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEventTypeAccess().getEventTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,49,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getEventTypeAccess().getEventtypeKeyword_1());
            		
            // InternalMIRoN.g:2876:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMIRoN.g:2877:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:2881:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:2882:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:2882:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:2883:6: lv_cardinality_3_0= RULE_INT
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
    // InternalMIRoN.g:2908:1: entryRuleNumericType returns [EObject current=null] : iv_ruleNumericType= ruleNumericType EOF ;
    public final EObject entryRuleNumericType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericType = null;


        try {
            // InternalMIRoN.g:2908:52: (iv_ruleNumericType= ruleNumericType EOF )
            // InternalMIRoN.g:2909:2: iv_ruleNumericType= ruleNumericType EOF
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
    // InternalMIRoN.g:2915:1: ruleNumericType returns [EObject current=null] : ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* ) ;
    public final EObject ruleNumericType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;
        EObject lv_constraints_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2921:2: ( ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* ) )
            // InternalMIRoN.g:2922:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* )
            {
            // InternalMIRoN.g:2922:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* )
            // InternalMIRoN.g:2923:3: () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )*
            {
            // InternalMIRoN.g:2923:3: ()
            // InternalMIRoN.g:2924:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumericTypeAccess().getNumericTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,50,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getNumericTypeAccess().getNumberKeyword_1());
            		
            // InternalMIRoN.g:2934:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==16) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMIRoN.g:2935:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getNumericTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:2939:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:2940:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:2940:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:2941:6: lv_cardinality_3_0= RULE_INT
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

                    otherlv_4=(Token)match(input,17,FOLLOW_45); 

                    				newLeafNode(otherlv_4, grammarAccess.getNumericTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:2962:3: ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=51 && LA37_0<=52)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalMIRoN.g:2963:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    {
            	    // InternalMIRoN.g:2963:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    // InternalMIRoN.g:2964:5: lv_constraints_5_0= ruleNumericTypeConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getNumericTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_45);
            	    lv_constraints_5_0=ruleNumericTypeConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNumericTypeRule());
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
            	    break loop37;
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
    // $ANTLR end "ruleNumericType"


    // $ANTLR start "entryRuleNumericTypeConstraint"
    // InternalMIRoN.g:2985:1: entryRuleNumericTypeConstraint returns [EObject current=null] : iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF ;
    public final EObject entryRuleNumericTypeConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericTypeConstraint = null;


        try {
            // InternalMIRoN.g:2985:62: (iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF )
            // InternalMIRoN.g:2986:2: iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF
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
    // InternalMIRoN.g:2992:1: ruleNumericTypeConstraint returns [EObject current=null] : (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound ) ;
    public final EObject ruleNumericTypeConstraint() throws RecognitionException {
        EObject current = null;

        EObject this_LowerBound_0 = null;

        EObject this_UpperBound_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:2998:2: ( (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound ) )
            // InternalMIRoN.g:2999:2: (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound )
            {
            // InternalMIRoN.g:2999:2: (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==51) ) {
                alt38=1;
            }
            else if ( (LA38_0==52) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalMIRoN.g:3000:3: this_LowerBound_0= ruleLowerBound
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
                    // InternalMIRoN.g:3009:3: this_UpperBound_1= ruleUpperBound
                    {

                    			newCompositeNode(grammarAccess.getNumericTypeConstraintAccess().getUpperBoundParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpperBound_1=ruleUpperBound();

                    state._fsp--;


                    			current = this_UpperBound_1;
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
    // InternalMIRoN.g:3021:1: entryRuleLowerBound returns [EObject current=null] : iv_ruleLowerBound= ruleLowerBound EOF ;
    public final EObject entryRuleLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBound = null;


        try {
            // InternalMIRoN.g:3021:51: (iv_ruleLowerBound= ruleLowerBound EOF )
            // InternalMIRoN.g:3022:2: iv_ruleLowerBound= ruleLowerBound EOF
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
    // InternalMIRoN.g:3028:1: ruleLowerBound returns [EObject current=null] : (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3034:2: ( (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalMIRoN.g:3035:2: (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalMIRoN.g:3035:2: (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalMIRoN.g:3036:3: otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getLowerBoundAccess().getLowerKeyword_0());
            		
            // InternalMIRoN.g:3040:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:3041:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:3041:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:3042:5: lv_value_1_0= ruleEDouble
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
    // InternalMIRoN.g:3063:1: entryRuleUpperBound returns [EObject current=null] : iv_ruleUpperBound= ruleUpperBound EOF ;
    public final EObject entryRuleUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperBound = null;


        try {
            // InternalMIRoN.g:3063:51: (iv_ruleUpperBound= ruleUpperBound EOF )
            // InternalMIRoN.g:3064:2: iv_ruleUpperBound= ruleUpperBound EOF
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
    // InternalMIRoN.g:3070:1: ruleUpperBound returns [EObject current=null] : (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3076:2: ( (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalMIRoN.g:3077:2: (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalMIRoN.g:3077:2: (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalMIRoN.g:3078:3: otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getUpperBoundAccess().getUpperKeyword_0());
            		
            // InternalMIRoN.g:3082:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:3083:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:3083:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:3084:5: lv_value_1_0= ruleEDouble
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


    // $ANTLR start "entryRuleUnitMeasuredType"
    // InternalMIRoN.g:3105:1: entryRuleUnitMeasuredType returns [EObject current=null] : iv_ruleUnitMeasuredType= ruleUnitMeasuredType EOF ;
    public final EObject entryRuleUnitMeasuredType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredType = null;


        try {
            // InternalMIRoN.g:3105:57: (iv_ruleUnitMeasuredType= ruleUnitMeasuredType EOF )
            // InternalMIRoN.g:3106:2: iv_ruleUnitMeasuredType= ruleUnitMeasuredType EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredType=ruleUnitMeasuredType();

            state._fsp--;

             current =iv_ruleUnitMeasuredType; 
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
    // $ANTLR end "entryRuleUnitMeasuredType"


    // $ANTLR start "ruleUnitMeasuredType"
    // InternalMIRoN.g:3112:1: ruleUnitMeasuredType returns [EObject current=null] : ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )* ) ;
    public final EObject ruleUnitMeasuredType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_constraints_5_0 = null;

        AntlrDatatypeRuleToken lv_unit_7_0 = null;

        EObject lv_constraints_8_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3118:2: ( ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )* ) )
            // InternalMIRoN.g:3119:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )* )
            {
            // InternalMIRoN.g:3119:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )* )
            // InternalMIRoN.g:3120:3: () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )*
            {
            // InternalMIRoN.g:3120:3: ()
            // InternalMIRoN.g:3121:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnitMeasuredTypeAccess().getUnitMeasuredTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,50,FOLLOW_46); 

            			newLeafNode(otherlv_1, grammarAccess.getUnitMeasuredTypeAccess().getNumberKeyword_1());
            		
            // InternalMIRoN.g:3131:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==16) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMIRoN.g:3132:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getUnitMeasuredTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:3136:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:3137:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:3137:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:3138:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_10); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getUnitMeasuredTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUnitMeasuredTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_47); 

                    				newLeafNode(otherlv_4, grammarAccess.getUnitMeasuredTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:3159:3: ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=51 && LA40_0<=52)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalMIRoN.g:3160:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    {
            	    // InternalMIRoN.g:3160:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    // InternalMIRoN.g:3161:5: lv_constraints_5_0= ruleNumericTypeConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getUnitMeasuredTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_47);
            	    lv_constraints_5_0=ruleNumericTypeConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnitMeasuredTypeRule());
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
            	    break loop40;
                }
            } while (true);

            otherlv_6=(Token)match(input,53,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getUnitMeasuredTypeAccess().getUnitKeyword_4());
            		
            // InternalMIRoN.g:3182:3: ( (lv_unit_7_0= ruleEString ) )
            // InternalMIRoN.g:3183:4: (lv_unit_7_0= ruleEString )
            {
            // InternalMIRoN.g:3183:4: (lv_unit_7_0= ruleEString )
            // InternalMIRoN.g:3184:5: lv_unit_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getUnitMeasuredTypeAccess().getUnitEStringParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_45);
            lv_unit_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitMeasuredTypeRule());
            					}
            					set(
            						current,
            						"unit",
            						lv_unit_7_0,
            						"org.xtext.roqme.RoQME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:3201:3: ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=51 && LA41_0<=52)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalMIRoN.g:3202:4: (lv_constraints_8_0= ruleNumericTypeConstraint )
            	    {
            	    // InternalMIRoN.g:3202:4: (lv_constraints_8_0= ruleNumericTypeConstraint )
            	    // InternalMIRoN.g:3203:5: lv_constraints_8_0= ruleNumericTypeConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getUnitMeasuredTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_45);
            	    lv_constraints_8_0=ruleNumericTypeConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnitMeasuredTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_8_0,
            	    						"org.xtext.roqme.RoQME.NumericTypeConstraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // $ANTLR end "ruleUnitMeasuredType"


    // $ANTLR start "entryRuleTimeType"
    // InternalMIRoN.g:3224:1: entryRuleTimeType returns [EObject current=null] : iv_ruleTimeType= ruleTimeType EOF ;
    public final EObject entryRuleTimeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeType = null;


        try {
            // InternalMIRoN.g:3224:49: (iv_ruleTimeType= ruleTimeType EOF )
            // InternalMIRoN.g:3225:2: iv_ruleTimeType= ruleTimeType EOF
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
    // InternalMIRoN.g:3231:1: ruleTimeType returns [EObject current=null] : ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleTimeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3237:2: ( ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // InternalMIRoN.g:3238:2: ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // InternalMIRoN.g:3238:2: ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // InternalMIRoN.g:3239:3: () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // InternalMIRoN.g:3239:3: ()
            // InternalMIRoN.g:3240:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeTypeAccess().getTimeTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,54,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeTypeAccess().getTimeKeyword_1());
            		
            // InternalMIRoN.g:3250:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==16) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMIRoN.g:3251:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getTimeTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalMIRoN.g:3255:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalMIRoN.g:3256:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalMIRoN.g:3256:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalMIRoN.g:3257:6: lv_cardinality_3_0= RULE_INT
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

                    otherlv_4=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getTimeTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

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
    // $ANTLR end "ruleTimeType"


    // $ANTLR start "entryRuleTypedValue"
    // InternalMIRoN.g:3282:1: entryRuleTypedValue returns [EObject current=null] : iv_ruleTypedValue= ruleTypedValue EOF ;
    public final EObject entryRuleTypedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedValue = null;


        try {
            // InternalMIRoN.g:3282:51: (iv_ruleTypedValue= ruleTypedValue EOF )
            // InternalMIRoN.g:3283:2: iv_ruleTypedValue= ruleTypedValue EOF
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
    // InternalMIRoN.g:3289:1: ruleTypedValue returns [EObject current=null] : (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue ) ;
    public final EObject ruleTypedValue() throws RecognitionException {
        EObject current = null;

        EObject this_SingleValue_0 = null;

        EObject this_ArrayValue_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3295:2: ( (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue ) )
            // InternalMIRoN.g:3296:2: (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue )
            {
            // InternalMIRoN.g:3296:2: (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_INT && LA43_0<=RULE_ID)||LA43_0==55||LA43_0==85||(LA43_0>=92 && LA43_0<=93)) ) {
                alt43=1;
            }
            else if ( (LA43_0==16) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalMIRoN.g:3297:3: this_SingleValue_0= ruleSingleValue
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
                    // InternalMIRoN.g:3306:3: this_ArrayValue_1= ruleArrayValue
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
    // InternalMIRoN.g:3318:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // InternalMIRoN.g:3318:52: (iv_ruleSingleValue= ruleSingleValue EOF )
            // InternalMIRoN.g:3319:2: iv_ruleSingleValue= ruleSingleValue EOF
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
    // InternalMIRoN.g:3325:1: ruleSingleValue returns [EObject current=null] : (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue ) ;
    public final EObject ruleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanValue_0 = null;

        EObject this_EnumValue_1 = null;

        EObject this_NumericValue_2 = null;

        EObject this_EventValue_3 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3331:2: ( (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue ) )
            // InternalMIRoN.g:3332:2: (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue )
            {
            // InternalMIRoN.g:3332:2: (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 92:
            case 93:
                {
                alt44=1;
                }
                break;
            case RULE_ID:
                {
                alt44=2;
                }
                break;
            case RULE_INT:
            case 85:
                {
                alt44=3;
                }
                break;
            case 55:
                {
                alt44=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalMIRoN.g:3333:3: this_BooleanValue_0= ruleBooleanValue
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
                    // InternalMIRoN.g:3342:3: this_EnumValue_1= ruleEnumValue
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
                    // InternalMIRoN.g:3351:3: this_NumericValue_2= ruleNumericValue
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
                    // InternalMIRoN.g:3360:3: this_EventValue_3= ruleEventValue
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
    // InternalMIRoN.g:3372:1: entryRuleEventValue returns [EObject current=null] : iv_ruleEventValue= ruleEventValue EOF ;
    public final EObject entryRuleEventValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventValue = null;


        try {
            // InternalMIRoN.g:3372:51: (iv_ruleEventValue= ruleEventValue EOF )
            // InternalMIRoN.g:3373:2: iv_ruleEventValue= ruleEventValue EOF
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
    // InternalMIRoN.g:3379:1: ruleEventValue returns [EObject current=null] : ( () otherlv_1= 'event' ) ;
    public final EObject ruleEventValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3385:2: ( ( () otherlv_1= 'event' ) )
            // InternalMIRoN.g:3386:2: ( () otherlv_1= 'event' )
            {
            // InternalMIRoN.g:3386:2: ( () otherlv_1= 'event' )
            // InternalMIRoN.g:3387:3: () otherlv_1= 'event'
            {
            // InternalMIRoN.g:3387:3: ()
            // InternalMIRoN.g:3388:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEventValueAccess().getEventValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,55,FOLLOW_2); 

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
    // InternalMIRoN.g:3402:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // InternalMIRoN.g:3402:53: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // InternalMIRoN.g:3403:2: iv_ruleBooleanValue= ruleBooleanValue EOF
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
    // InternalMIRoN.g:3409:1: ruleBooleanValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEBoolean ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3415:2: ( ( () ( (lv_value_1_0= ruleEBoolean ) ) ) )
            // InternalMIRoN.g:3416:2: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            {
            // InternalMIRoN.g:3416:2: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            // InternalMIRoN.g:3417:3: () ( (lv_value_1_0= ruleEBoolean ) )
            {
            // InternalMIRoN.g:3417:3: ()
            // InternalMIRoN.g:3418:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanValueAccess().getBooleanValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:3424:3: ( (lv_value_1_0= ruleEBoolean ) )
            // InternalMIRoN.g:3425:4: (lv_value_1_0= ruleEBoolean )
            {
            // InternalMIRoN.g:3425:4: (lv_value_1_0= ruleEBoolean )
            // InternalMIRoN.g:3426:5: lv_value_1_0= ruleEBoolean
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
    // InternalMIRoN.g:3447:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // InternalMIRoN.g:3447:50: (iv_ruleEnumValue= ruleEnumValue EOF )
            // InternalMIRoN.g:3448:2: iv_ruleEnumValue= ruleEnumValue EOF
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
    // InternalMIRoN.g:3454:1: ruleEnumValue returns [EObject current=null] : ( () ( ( ruleLiteralQualifiedName ) ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMIRoN.g:3460:2: ( ( () ( ( ruleLiteralQualifiedName ) ) ) )
            // InternalMIRoN.g:3461:2: ( () ( ( ruleLiteralQualifiedName ) ) )
            {
            // InternalMIRoN.g:3461:2: ( () ( ( ruleLiteralQualifiedName ) ) )
            // InternalMIRoN.g:3462:3: () ( ( ruleLiteralQualifiedName ) )
            {
            // InternalMIRoN.g:3462:3: ()
            // InternalMIRoN.g:3463:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumValueAccess().getEnumValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:3469:3: ( ( ruleLiteralQualifiedName ) )
            // InternalMIRoN.g:3470:4: ( ruleLiteralQualifiedName )
            {
            // InternalMIRoN.g:3470:4: ( ruleLiteralQualifiedName )
            // InternalMIRoN.g:3471:5: ruleLiteralQualifiedName
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
    // InternalMIRoN.g:3489:1: entryRuleNumericValue returns [EObject current=null] : iv_ruleNumericValue= ruleNumericValue EOF ;
    public final EObject entryRuleNumericValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericValue = null;


        try {
            // InternalMIRoN.g:3489:53: (iv_ruleNumericValue= ruleNumericValue EOF )
            // InternalMIRoN.g:3490:2: iv_ruleNumericValue= ruleNumericValue EOF
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
    // InternalMIRoN.g:3496:1: ruleNumericValue returns [EObject current=null] : (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_UnitMeasuredValue_1= ruleUnitMeasuredValue ) ;
    public final EObject ruleNumericValue() throws RecognitionException {
        EObject current = null;

        EObject this_NumericValue_Impl_0 = null;

        EObject this_UnitMeasuredValue_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3502:2: ( (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_UnitMeasuredValue_1= ruleUnitMeasuredValue ) )
            // InternalMIRoN.g:3503:2: (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_UnitMeasuredValue_1= ruleUnitMeasuredValue )
            {
            // InternalMIRoN.g:3503:2: (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_UnitMeasuredValue_1= ruleUnitMeasuredValue )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==85) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 91:
                        {
                        int LA45_3 = input.LA(4);

                        if ( (LA45_3==RULE_INT) ) {
                            int LA45_6 = input.LA(5);

                            if ( ((LA45_6>=RULE_ID && LA45_6<=RULE_STRING)||(LA45_6>=56 && LA45_6<=65)) ) {
                                alt45=2;
                            }
                            else if ( (LA45_6==EOF||LA45_6==RULE_ROQME_DESCRIPTION||(LA45_6>=18 && LA45_6<=22)||(LA45_6>=25 && LA45_6<=31)||(LA45_6>=33 && LA45_6<=47)||(LA45_6>=67 && LA45_6<=72)||(LA45_6>=74 && LA45_6<=76)||(LA45_6>=78 && LA45_6<=87)||(LA45_6>=98 && LA45_6<=99)) ) {
                                alt45=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 45, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 45, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                        {
                        alt45=2;
                        }
                        break;
                    case EOF:
                    case RULE_ROQME_DESCRIPTION:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
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
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 74:
                    case 75:
                    case 76:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 98:
                    case 99:
                        {
                        alt45=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA45_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 91:
                    {
                    int LA45_3 = input.LA(3);

                    if ( (LA45_3==RULE_INT) ) {
                        int LA45_6 = input.LA(4);

                        if ( ((LA45_6>=RULE_ID && LA45_6<=RULE_STRING)||(LA45_6>=56 && LA45_6<=65)) ) {
                            alt45=2;
                        }
                        else if ( (LA45_6==EOF||LA45_6==RULE_ROQME_DESCRIPTION||(LA45_6>=18 && LA45_6<=22)||(LA45_6>=25 && LA45_6<=31)||(LA45_6>=33 && LA45_6<=47)||(LA45_6>=67 && LA45_6<=72)||(LA45_6>=74 && LA45_6<=76)||(LA45_6>=78 && LA45_6<=87)||(LA45_6>=98 && LA45_6<=99)) ) {
                            alt45=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 45, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                    {
                    alt45=2;
                    }
                    break;
                case EOF:
                case RULE_ROQME_DESCRIPTION:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 34:
                case 35:
                case 36:
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
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 74:
                case 75:
                case 76:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 98:
                case 99:
                    {
                    alt45=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalMIRoN.g:3504:3: this_NumericValue_Impl_0= ruleNumericValue_Impl
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
                    // InternalMIRoN.g:3513:3: this_UnitMeasuredValue_1= ruleUnitMeasuredValue
                    {

                    			newCompositeNode(grammarAccess.getNumericValueAccess().getUnitMeasuredValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredValue_1=ruleUnitMeasuredValue();

                    state._fsp--;


                    			current = this_UnitMeasuredValue_1;
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


    // $ANTLR start "entryRuleUnitMeasuredValue"
    // InternalMIRoN.g:3525:1: entryRuleUnitMeasuredValue returns [EObject current=null] : iv_ruleUnitMeasuredValue= ruleUnitMeasuredValue EOF ;
    public final EObject entryRuleUnitMeasuredValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredValue = null;


        try {
            // InternalMIRoN.g:3525:58: (iv_ruleUnitMeasuredValue= ruleUnitMeasuredValue EOF )
            // InternalMIRoN.g:3526:2: iv_ruleUnitMeasuredValue= ruleUnitMeasuredValue EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredValue=ruleUnitMeasuredValue();

            state._fsp--;

             current =iv_ruleUnitMeasuredValue; 
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
    // $ANTLR end "entryRuleUnitMeasuredValue"


    // $ANTLR start "ruleUnitMeasuredValue"
    // InternalMIRoN.g:3532:1: ruleUnitMeasuredValue returns [EObject current=null] : (this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl | this_TimeValue_1= ruleTimeValue ) ;
    public final EObject ruleUnitMeasuredValue() throws RecognitionException {
        EObject current = null;

        EObject this_UnitMeasuredValue_Impl_0 = null;

        EObject this_TimeValue_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3538:2: ( (this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl | this_TimeValue_1= ruleTimeValue ) )
            // InternalMIRoN.g:3539:2: (this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl | this_TimeValue_1= ruleTimeValue )
            {
            // InternalMIRoN.g:3539:2: (this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl | this_TimeValue_1= ruleTimeValue )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==85) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 91:
                        {
                        int LA46_3 = input.LA(4);

                        if ( (LA46_3==RULE_INT) ) {
                            int LA46_6 = input.LA(5);

                            if ( ((LA46_6>=RULE_ID && LA46_6<=RULE_STRING)) ) {
                                alt46=1;
                            }
                            else if ( ((LA46_6>=56 && LA46_6<=65)) ) {
                                alt46=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 46, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 46, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt46=1;
                        }
                        break;
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                        {
                        alt46=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA46_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 91:
                    {
                    int LA46_3 = input.LA(3);

                    if ( (LA46_3==RULE_INT) ) {
                        int LA46_6 = input.LA(4);

                        if ( ((LA46_6>=RULE_ID && LA46_6<=RULE_STRING)) ) {
                            alt46=1;
                        }
                        else if ( ((LA46_6>=56 && LA46_6<=65)) ) {
                            alt46=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 46, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                    {
                    alt46=1;
                    }
                    break;
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                    {
                    alt46=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalMIRoN.g:3540:3: this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl
                    {

                    			newCompositeNode(grammarAccess.getUnitMeasuredValueAccess().getUnitMeasuredValue_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredValue_Impl_0=ruleUnitMeasuredValue_Impl();

                    state._fsp--;


                    			current = this_UnitMeasuredValue_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:3549:3: this_TimeValue_1= ruleTimeValue
                    {

                    			newCompositeNode(grammarAccess.getUnitMeasuredValueAccess().getTimeValueParserRuleCall_1());
                    		
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
    // $ANTLR end "ruleUnitMeasuredValue"


    // $ANTLR start "entryRuleNumericValue_Impl"
    // InternalMIRoN.g:3561:1: entryRuleNumericValue_Impl returns [EObject current=null] : iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF ;
    public final EObject entryRuleNumericValue_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericValue_Impl = null;


        try {
            // InternalMIRoN.g:3561:58: (iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF )
            // InternalMIRoN.g:3562:2: iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF
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
    // InternalMIRoN.g:3568:1: ruleNumericValue_Impl returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleNumericValue_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3574:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalMIRoN.g:3575:2: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalMIRoN.g:3575:2: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalMIRoN.g:3576:3: () ( (lv_value_1_0= ruleEDouble ) )
            {
            // InternalMIRoN.g:3576:3: ()
            // InternalMIRoN.g:3577:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumericValue_ImplAccess().getNumericValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:3583:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:3584:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:3584:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:3585:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getNumericValue_ImplAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleUnitMeasuredValue_Impl"
    // InternalMIRoN.g:3606:1: entryRuleUnitMeasuredValue_Impl returns [EObject current=null] : iv_ruleUnitMeasuredValue_Impl= ruleUnitMeasuredValue_Impl EOF ;
    public final EObject entryRuleUnitMeasuredValue_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredValue_Impl = null;


        try {
            // InternalMIRoN.g:3606:63: (iv_ruleUnitMeasuredValue_Impl= ruleUnitMeasuredValue_Impl EOF )
            // InternalMIRoN.g:3607:2: iv_ruleUnitMeasuredValue_Impl= ruleUnitMeasuredValue_Impl EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredValue_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredValue_Impl=ruleUnitMeasuredValue_Impl();

            state._fsp--;

             current =iv_ruleUnitMeasuredValue_Impl; 
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
    // $ANTLR end "entryRuleUnitMeasuredValue_Impl"


    // $ANTLR start "ruleUnitMeasuredValue_Impl"
    // InternalMIRoN.g:3613:1: ruleUnitMeasuredValue_Impl returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) ) ) ;
    public final EObject ruleUnitMeasuredValue_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_unit_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3619:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) ) ) )
            // InternalMIRoN.g:3620:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) ) )
            {
            // InternalMIRoN.g:3620:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) ) )
            // InternalMIRoN.g:3621:3: () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) )
            {
            // InternalMIRoN.g:3621:3: ()
            // InternalMIRoN.g:3622:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnitMeasuredValue_ImplAccess().getUnitMeasuredValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:3628:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:3629:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:3629:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:3630:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getUnitMeasuredValue_ImplAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitMeasuredValue_ImplRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:3647:3: ( (lv_unit_2_0= ruleEString ) )
            // InternalMIRoN.g:3648:4: (lv_unit_2_0= ruleEString )
            {
            // InternalMIRoN.g:3648:4: (lv_unit_2_0= ruleEString )
            // InternalMIRoN.g:3649:5: lv_unit_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getUnitMeasuredValue_ImplAccess().getUnitEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_unit_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitMeasuredValue_ImplRule());
            					}
            					set(
            						current,
            						"unit",
            						lv_unit_2_0,
            						"org.xtext.roqme.RoQME.EString");
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
    // $ANTLR end "ruleUnitMeasuredValue_Impl"


    // $ANTLR start "entryRuleTimeValue"
    // InternalMIRoN.g:3670:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // InternalMIRoN.g:3670:50: (iv_ruleTimeValue= ruleTimeValue EOF )
            // InternalMIRoN.g:3671:2: iv_ruleTimeValue= ruleTimeValue EOF
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
    // InternalMIRoN.g:3677:1: ruleTimeValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) ) ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_unit_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3683:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) ) ) )
            // InternalMIRoN.g:3684:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) ) )
            {
            // InternalMIRoN.g:3684:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) ) )
            // InternalMIRoN.g:3685:3: () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) )
            {
            // InternalMIRoN.g:3685:3: ()
            // InternalMIRoN.g:3686:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeValueAccess().getTimeValueAction_0(),
            					current);
            			

            }

            // InternalMIRoN.g:3692:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalMIRoN.g:3693:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalMIRoN.g:3693:4: (lv_value_1_0= ruleEDouble )
            // InternalMIRoN.g:3694:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTimeValueAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_48);
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

            // InternalMIRoN.g:3711:3: ( (lv_unit_2_0= ruleTimeUnitEnum ) )
            // InternalMIRoN.g:3712:4: (lv_unit_2_0= ruleTimeUnitEnum )
            {
            // InternalMIRoN.g:3712:4: (lv_unit_2_0= ruleTimeUnitEnum )
            // InternalMIRoN.g:3713:5: lv_unit_2_0= ruleTimeUnitEnum
            {

            					newCompositeNode(grammarAccess.getTimeValueAccess().getUnitTimeUnitEnumParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_unit_2_0=ruleTimeUnitEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeValueRule());
            					}
            					set(
            						current,
            						"unit",
            						lv_unit_2_0,
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
    // InternalMIRoN.g:3734:1: entryRuleTimeUnitEnum returns [String current=null] : iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF ;
    public final String entryRuleTimeUnitEnum() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimeUnitEnum = null;


        try {
            // InternalMIRoN.g:3734:52: (iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF )
            // InternalMIRoN.g:3735:2: iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF
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
    // InternalMIRoN.g:3741:1: ruleTimeUnitEnum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' ) ;
    public final AntlrDatatypeRuleToken ruleTimeUnitEnum() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMIRoN.g:3747:2: ( (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' ) )
            // InternalMIRoN.g:3748:2: (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' )
            {
            // InternalMIRoN.g:3748:2: (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' )
            int alt47=10;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt47=1;
                }
                break;
            case 57:
                {
                alt47=2;
                }
                break;
            case 58:
                {
                alt47=3;
                }
                break;
            case 59:
                {
                alt47=4;
                }
                break;
            case 60:
                {
                alt47=5;
                }
                break;
            case 61:
                {
                alt47=6;
                }
                break;
            case 62:
                {
                alt47=7;
                }
                break;
            case 63:
                {
                alt47=8;
                }
                break;
            case 64:
                {
                alt47=9;
                }
                break;
            case 65:
                {
                alt47=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalMIRoN.g:3749:3: kw= 'milliseconds'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMillisecondsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:3755:3: kw= 'seconds'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getSecondsKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:3761:3: kw= 'minutes'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMinutesKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:3767:3: kw= 'hours'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getHoursKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:3773:3: kw= 'days'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getDaysKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:3779:3: kw= 'millisecond'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMillisecondKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMIRoN.g:3785:3: kw= 'second'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getSecondKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalMIRoN.g:3791:3: kw= 'minute'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMinuteKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalMIRoN.g:3797:3: kw= 'hour'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getHourKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalMIRoN.g:3803:3: kw= 'day'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

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
    // InternalMIRoN.g:3812:1: entryRuleArrayValue returns [EObject current=null] : iv_ruleArrayValue= ruleArrayValue EOF ;
    public final EObject entryRuleArrayValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayValue = null;


        try {
            // InternalMIRoN.g:3812:51: (iv_ruleArrayValue= ruleArrayValue EOF )
            // InternalMIRoN.g:3813:2: iv_ruleArrayValue= ruleArrayValue EOF
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
    // InternalMIRoN.g:3819:1: ruleArrayValue returns [EObject current=null] : (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray ) ;
    public final EObject ruleArrayValue() throws RecognitionException {
        EObject current = null;

        EObject this_NumericArray_0 = null;

        EObject this_BooleanArray_1 = null;

        EObject this_EnumArray_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3825:2: ( (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray ) )
            // InternalMIRoN.g:3826:2: (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray )
            {
            // InternalMIRoN.g:3826:2: (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray )
            int alt48=3;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==16) ) {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt48=3;
                    }
                    break;
                case RULE_INT:
                case 85:
                    {
                    alt48=1;
                    }
                    break;
                case 92:
                case 93:
                    {
                    alt48=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalMIRoN.g:3827:3: this_NumericArray_0= ruleNumericArray
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
                    // InternalMIRoN.g:3836:3: this_BooleanArray_1= ruleBooleanArray
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
                    // InternalMIRoN.g:3845:3: this_EnumArray_2= ruleEnumArray
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
    // InternalMIRoN.g:3857:1: entryRuleBooleanArray returns [EObject current=null] : iv_ruleBooleanArray= ruleBooleanArray EOF ;
    public final EObject entryRuleBooleanArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanArray = null;


        try {
            // InternalMIRoN.g:3857:53: (iv_ruleBooleanArray= ruleBooleanArray EOF )
            // InternalMIRoN.g:3858:2: iv_ruleBooleanArray= ruleBooleanArray EOF
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
    // InternalMIRoN.g:3864:1: ruleBooleanArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleBooleanArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3870:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:3871:2: (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:3871:2: (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:3872:3: otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_49); 

            			newLeafNode(otherlv_0, grammarAccess.getBooleanArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:3876:3: ( (lv_values_1_0= ruleBooleanValue ) )
            // InternalMIRoN.g:3877:4: (lv_values_1_0= ruleBooleanValue )
            {
            // InternalMIRoN.g:3877:4: (lv_values_1_0= ruleBooleanValue )
            // InternalMIRoN.g:3878:5: lv_values_1_0= ruleBooleanValue
            {

            					newCompositeNode(grammarAccess.getBooleanArrayAccess().getValuesBooleanValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
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

            // InternalMIRoN.g:3895:3: (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==19) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalMIRoN.g:3896:4: otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_49); 

            	    				newLeafNode(otherlv_2, grammarAccess.getBooleanArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:3900:4: ( (lv_values_3_0= ruleBooleanValue ) )
            	    // InternalMIRoN.g:3901:5: (lv_values_3_0= ruleBooleanValue )
            	    {
            	    // InternalMIRoN.g:3901:5: (lv_values_3_0= ruleBooleanValue )
            	    // InternalMIRoN.g:3902:6: lv_values_3_0= ruleBooleanValue
            	    {

            	    						newCompositeNode(grammarAccess.getBooleanArrayAccess().getValuesBooleanValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
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
            	    break loop49;
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
    // InternalMIRoN.g:3928:1: entryRuleEnumArray returns [EObject current=null] : iv_ruleEnumArray= ruleEnumArray EOF ;
    public final EObject entryRuleEnumArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumArray = null;


        try {
            // InternalMIRoN.g:3928:50: (iv_ruleEnumArray= ruleEnumArray EOF )
            // InternalMIRoN.g:3929:2: iv_ruleEnumArray= ruleEnumArray EOF
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
    // InternalMIRoN.g:3935:1: ruleEnumArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleEnumArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:3941:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:3942:2: (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:3942:2: (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:3943:3: otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:3947:3: ( (lv_values_1_0= ruleEnumValue ) )
            // InternalMIRoN.g:3948:4: (lv_values_1_0= ruleEnumValue )
            {
            // InternalMIRoN.g:3948:4: (lv_values_1_0= ruleEnumValue )
            // InternalMIRoN.g:3949:5: lv_values_1_0= ruleEnumValue
            {

            					newCompositeNode(grammarAccess.getEnumArrayAccess().getValuesEnumValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
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

            // InternalMIRoN.g:3966:3: (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==19) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalMIRoN.g:3967:4: otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getEnumArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:3971:4: ( (lv_values_3_0= ruleEnumValue ) )
            	    // InternalMIRoN.g:3972:5: (lv_values_3_0= ruleEnumValue )
            	    {
            	    // InternalMIRoN.g:3972:5: (lv_values_3_0= ruleEnumValue )
            	    // InternalMIRoN.g:3973:6: lv_values_3_0= ruleEnumValue
            	    {

            	    						newCompositeNode(grammarAccess.getEnumArrayAccess().getValuesEnumValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
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
            	    break loop50;
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
    // InternalMIRoN.g:3999:1: entryRuleNumericArray returns [EObject current=null] : iv_ruleNumericArray= ruleNumericArray EOF ;
    public final EObject entryRuleNumericArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericArray = null;


        try {
            // InternalMIRoN.g:3999:53: (iv_ruleNumericArray= ruleNumericArray EOF )
            // InternalMIRoN.g:4000:2: iv_ruleNumericArray= ruleNumericArray EOF
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
    // InternalMIRoN.g:4006:1: ruleNumericArray returns [EObject current=null] : (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_UnitMeasuredArray_1= ruleUnitMeasuredArray ) ;
    public final EObject ruleNumericArray() throws RecognitionException {
        EObject current = null;

        EObject this_NumericArray_Impl_0 = null;

        EObject this_UnitMeasuredArray_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4012:2: ( (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_UnitMeasuredArray_1= ruleUnitMeasuredArray ) )
            // InternalMIRoN.g:4013:2: (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_UnitMeasuredArray_1= ruleUnitMeasuredArray )
            {
            // InternalMIRoN.g:4013:2: (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_UnitMeasuredArray_1= ruleUnitMeasuredArray )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==16) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==85) ) {
                    int LA51_2 = input.LA(3);

                    if ( (LA51_2==RULE_INT) ) {
                        switch ( input.LA(4) ) {
                        case 91:
                            {
                            int LA51_4 = input.LA(5);

                            if ( (LA51_4==RULE_INT) ) {
                                int LA51_7 = input.LA(6);

                                if ( ((LA51_7>=RULE_ID && LA51_7<=RULE_STRING)||(LA51_7>=56 && LA51_7<=65)) ) {
                                    alt51=2;
                                }
                                else if ( (LA51_7==17||LA51_7==19) ) {
                                    alt51=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 51, 7, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 51, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                            {
                            alt51=2;
                            }
                            break;
                        case 17:
                        case 19:
                            {
                            alt51=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 51, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA51_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 91:
                        {
                        int LA51_4 = input.LA(4);

                        if ( (LA51_4==RULE_INT) ) {
                            int LA51_7 = input.LA(5);

                            if ( ((LA51_7>=RULE_ID && LA51_7<=RULE_STRING)||(LA51_7>=56 && LA51_7<=65)) ) {
                                alt51=2;
                            }
                            else if ( (LA51_7==17||LA51_7==19) ) {
                                alt51=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 51, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 51, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                        {
                        alt51=2;
                        }
                        break;
                    case 17:
                    case 19:
                        {
                        alt51=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalMIRoN.g:4014:3: this_NumericArray_Impl_0= ruleNumericArray_Impl
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
                    // InternalMIRoN.g:4023:3: this_UnitMeasuredArray_1= ruleUnitMeasuredArray
                    {

                    			newCompositeNode(grammarAccess.getNumericArrayAccess().getUnitMeasuredArrayParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredArray_1=ruleUnitMeasuredArray();

                    state._fsp--;


                    			current = this_UnitMeasuredArray_1;
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


    // $ANTLR start "entryRuleUnitMeasuredArray"
    // InternalMIRoN.g:4035:1: entryRuleUnitMeasuredArray returns [EObject current=null] : iv_ruleUnitMeasuredArray= ruleUnitMeasuredArray EOF ;
    public final EObject entryRuleUnitMeasuredArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredArray = null;


        try {
            // InternalMIRoN.g:4035:58: (iv_ruleUnitMeasuredArray= ruleUnitMeasuredArray EOF )
            // InternalMIRoN.g:4036:2: iv_ruleUnitMeasuredArray= ruleUnitMeasuredArray EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredArray=ruleUnitMeasuredArray();

            state._fsp--;

             current =iv_ruleUnitMeasuredArray; 
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
    // $ANTLR end "entryRuleUnitMeasuredArray"


    // $ANTLR start "ruleUnitMeasuredArray"
    // InternalMIRoN.g:4042:1: ruleUnitMeasuredArray returns [EObject current=null] : (this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl | this_TimeArray_1= ruleTimeArray ) ;
    public final EObject ruleUnitMeasuredArray() throws RecognitionException {
        EObject current = null;

        EObject this_UnitMeasuredArray_Impl_0 = null;

        EObject this_TimeArray_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4048:2: ( (this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl | this_TimeArray_1= ruleTimeArray ) )
            // InternalMIRoN.g:4049:2: (this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl | this_TimeArray_1= ruleTimeArray )
            {
            // InternalMIRoN.g:4049:2: (this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl | this_TimeArray_1= ruleTimeArray )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==16) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==85) ) {
                    int LA52_2 = input.LA(3);

                    if ( (LA52_2==RULE_INT) ) {
                        switch ( input.LA(4) ) {
                        case 91:
                            {
                            int LA52_4 = input.LA(5);

                            if ( (LA52_4==RULE_INT) ) {
                                int LA52_7 = input.LA(6);

                                if ( ((LA52_7>=RULE_ID && LA52_7<=RULE_STRING)) ) {
                                    alt52=1;
                                }
                                else if ( ((LA52_7>=56 && LA52_7<=65)) ) {
                                    alt52=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 52, 7, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 52, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                            {
                            alt52=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt52=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 52, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA52_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 91:
                        {
                        int LA52_4 = input.LA(4);

                        if ( (LA52_4==RULE_INT) ) {
                            int LA52_7 = input.LA(5);

                            if ( ((LA52_7>=RULE_ID && LA52_7<=RULE_STRING)) ) {
                                alt52=1;
                            }
                            else if ( ((LA52_7>=56 && LA52_7<=65)) ) {
                                alt52=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 52, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 52, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                        {
                        alt52=2;
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt52=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalMIRoN.g:4050:3: this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl
                    {

                    			newCompositeNode(grammarAccess.getUnitMeasuredArrayAccess().getUnitMeasuredArray_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredArray_Impl_0=ruleUnitMeasuredArray_Impl();

                    state._fsp--;


                    			current = this_UnitMeasuredArray_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4059:3: this_TimeArray_1= ruleTimeArray
                    {

                    			newCompositeNode(grammarAccess.getUnitMeasuredArrayAccess().getTimeArrayParserRuleCall_1());
                    		
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
    // $ANTLR end "ruleUnitMeasuredArray"


    // $ANTLR start "entryRuleNumericArray_Impl"
    // InternalMIRoN.g:4071:1: entryRuleNumericArray_Impl returns [EObject current=null] : iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF ;
    public final EObject entryRuleNumericArray_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericArray_Impl = null;


        try {
            // InternalMIRoN.g:4071:58: (iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF )
            // InternalMIRoN.g:4072:2: iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF
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
    // InternalMIRoN.g:4078:1: ruleNumericArray_Impl returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleNumericArray_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4084:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:4085:2: (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:4085:2: (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:4086:3: otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getNumericArray_ImplAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:4090:3: ( (lv_values_1_0= ruleNumericValue_Impl ) )
            // InternalMIRoN.g:4091:4: (lv_values_1_0= ruleNumericValue_Impl )
            {
            // InternalMIRoN.g:4091:4: (lv_values_1_0= ruleNumericValue_Impl )
            // InternalMIRoN.g:4092:5: lv_values_1_0= ruleNumericValue_Impl
            {

            					newCompositeNode(grammarAccess.getNumericArray_ImplAccess().getValuesNumericValue_ImplParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
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

            // InternalMIRoN.g:4109:3: (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==19) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalMIRoN.g:4110:4: otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_31); 

            	    				newLeafNode(otherlv_2, grammarAccess.getNumericArray_ImplAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:4114:4: ( (lv_values_3_0= ruleNumericValue_Impl ) )
            	    // InternalMIRoN.g:4115:5: (lv_values_3_0= ruleNumericValue_Impl )
            	    {
            	    // InternalMIRoN.g:4115:5: (lv_values_3_0= ruleNumericValue_Impl )
            	    // InternalMIRoN.g:4116:6: lv_values_3_0= ruleNumericValue_Impl
            	    {

            	    						newCompositeNode(grammarAccess.getNumericArray_ImplAccess().getValuesNumericValue_ImplParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
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
            	    break loop53;
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


    // $ANTLR start "entryRuleUnitMeasuredArray_Impl"
    // InternalMIRoN.g:4142:1: entryRuleUnitMeasuredArray_Impl returns [EObject current=null] : iv_ruleUnitMeasuredArray_Impl= ruleUnitMeasuredArray_Impl EOF ;
    public final EObject entryRuleUnitMeasuredArray_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredArray_Impl = null;


        try {
            // InternalMIRoN.g:4142:63: (iv_ruleUnitMeasuredArray_Impl= ruleUnitMeasuredArray_Impl EOF )
            // InternalMIRoN.g:4143:2: iv_ruleUnitMeasuredArray_Impl= ruleUnitMeasuredArray_Impl EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredArray_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredArray_Impl=ruleUnitMeasuredArray_Impl();

            state._fsp--;

             current =iv_ruleUnitMeasuredArray_Impl; 
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
    // $ANTLR end "entryRuleUnitMeasuredArray_Impl"


    // $ANTLR start "ruleUnitMeasuredArray_Impl"
    // InternalMIRoN.g:4149:1: ruleUnitMeasuredArray_Impl returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleUnitMeasuredArray_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4155:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:4156:2: (otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:4156:2: (otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:4157:3: otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getUnitMeasuredArray_ImplAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:4161:3: ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) )
            // InternalMIRoN.g:4162:4: (lv_values_1_0= ruleUnitMeasuredValue_Impl )
            {
            // InternalMIRoN.g:4162:4: (lv_values_1_0= ruleUnitMeasuredValue_Impl )
            // InternalMIRoN.g:4163:5: lv_values_1_0= ruleUnitMeasuredValue_Impl
            {

            					newCompositeNode(grammarAccess.getUnitMeasuredArray_ImplAccess().getValuesUnitMeasuredValue_ImplParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
            lv_values_1_0=ruleUnitMeasuredValue_Impl();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitMeasuredArray_ImplRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.UnitMeasuredValue_Impl");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIRoN.g:4180:3: (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==19) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalMIRoN.g:4181:4: otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_31); 

            	    				newLeafNode(otherlv_2, grammarAccess.getUnitMeasuredArray_ImplAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:4185:4: ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) )
            	    // InternalMIRoN.g:4186:5: (lv_values_3_0= ruleUnitMeasuredValue_Impl )
            	    {
            	    // InternalMIRoN.g:4186:5: (lv_values_3_0= ruleUnitMeasuredValue_Impl )
            	    // InternalMIRoN.g:4187:6: lv_values_3_0= ruleUnitMeasuredValue_Impl
            	    {

            	    						newCompositeNode(grammarAccess.getUnitMeasuredArray_ImplAccess().getValuesUnitMeasuredValue_ImplParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
            	    lv_values_3_0=ruleUnitMeasuredValue_Impl();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUnitMeasuredArray_ImplRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.UnitMeasuredValue_Impl");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getUnitMeasuredArray_ImplAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleUnitMeasuredArray_Impl"


    // $ANTLR start "entryRuleTimeArray"
    // InternalMIRoN.g:4213:1: entryRuleTimeArray returns [EObject current=null] : iv_ruleTimeArray= ruleTimeArray EOF ;
    public final EObject entryRuleTimeArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeArray = null;


        try {
            // InternalMIRoN.g:4213:50: (iv_ruleTimeArray= ruleTimeArray EOF )
            // InternalMIRoN.g:4214:2: iv_ruleTimeArray= ruleTimeArray EOF
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
    // InternalMIRoN.g:4220:1: ruleTimeArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleTimeArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4226:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' ) )
            // InternalMIRoN.g:4227:2: (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' )
            {
            // InternalMIRoN.g:4227:2: (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' )
            // InternalMIRoN.g:4228:3: otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMIRoN.g:4232:3: ( (lv_values_1_0= ruleTimeValue ) )
            // InternalMIRoN.g:4233:4: (lv_values_1_0= ruleTimeValue )
            {
            // InternalMIRoN.g:4233:4: (lv_values_1_0= ruleTimeValue )
            // InternalMIRoN.g:4234:5: lv_values_1_0= ruleTimeValue
            {

            					newCompositeNode(grammarAccess.getTimeArrayAccess().getValuesTimeValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
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

            // InternalMIRoN.g:4251:3: (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==19) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalMIRoN.g:4252:4: otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_31); 

            	    				newLeafNode(otherlv_2, grammarAccess.getTimeArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMIRoN.g:4256:4: ( (lv_values_3_0= ruleTimeValue ) )
            	    // InternalMIRoN.g:4257:5: (lv_values_3_0= ruleTimeValue )
            	    {
            	    // InternalMIRoN.g:4257:5: (lv_values_3_0= ruleTimeValue )
            	    // InternalMIRoN.g:4258:6: lv_values_3_0= ruleTimeValue
            	    {

            	    						newCompositeNode(grammarAccess.getTimeArrayAccess().getValuesTimeValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
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
            	    break loop55;
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
    // InternalMIRoN.g:4284:1: entryRuleDataTypeDeclaration returns [EObject current=null] : iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF ;
    public final EObject entryRuleDataTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDeclaration = null;


        try {
            // InternalMIRoN.g:4284:60: (iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF )
            // InternalMIRoN.g:4285:2: iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF
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
    // InternalMIRoN.g:4291:1: ruleDataTypeDeclaration returns [EObject current=null] : (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration ) ;
    public final EObject ruleDataTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_InbuiltDeclaration_0 = null;

        EObject this_ReferencedDeclaration_1 = null;

        EObject this_ContainedDeclaration_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4297:2: ( (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration ) )
            // InternalMIRoN.g:4298:2: (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration )
            {
            // InternalMIRoN.g:4298:2: (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration )
            int alt56=3;
            switch ( input.LA(1) ) {
            case EOF:
            case RULE_ROQME_DESCRIPTION:
            case 22:
            case 26:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 47:
            case 95:
            case 96:
            case 97:
                {
                alt56=1;
                }
                break;
            case RULE_ID:
                {
                alt56=2;
                }
                break;
            case 15:
            case 48:
            case 49:
            case 50:
            case 54:
                {
                alt56=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalMIRoN.g:4299:3: this_InbuiltDeclaration_0= ruleInbuiltDeclaration
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
                    // InternalMIRoN.g:4308:3: this_ReferencedDeclaration_1= ruleReferencedDeclaration
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
                    // InternalMIRoN.g:4317:3: this_ContainedDeclaration_2= ruleContainedDeclaration
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
    // InternalMIRoN.g:4329:1: entryRuleContainedDeclaration returns [EObject current=null] : iv_ruleContainedDeclaration= ruleContainedDeclaration EOF ;
    public final EObject entryRuleContainedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedDeclaration = null;


        try {
            // InternalMIRoN.g:4329:61: (iv_ruleContainedDeclaration= ruleContainedDeclaration EOF )
            // InternalMIRoN.g:4330:2: iv_ruleContainedDeclaration= ruleContainedDeclaration EOF
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
    // InternalMIRoN.g:4336:1: ruleContainedDeclaration returns [EObject current=null] : ( (lv_type_0_0= ruleDataType ) ) ;
    public final EObject ruleContainedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4342:2: ( ( (lv_type_0_0= ruleDataType ) ) )
            // InternalMIRoN.g:4343:2: ( (lv_type_0_0= ruleDataType ) )
            {
            // InternalMIRoN.g:4343:2: ( (lv_type_0_0= ruleDataType ) )
            // InternalMIRoN.g:4344:3: (lv_type_0_0= ruleDataType )
            {
            // InternalMIRoN.g:4344:3: (lv_type_0_0= ruleDataType )
            // InternalMIRoN.g:4345:4: lv_type_0_0= ruleDataType
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
            					"org.xtext.roqme.RoQME.DataType");
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
    // InternalMIRoN.g:4365:1: entryRuleInbuiltDeclaration returns [EObject current=null] : iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF ;
    public final EObject entryRuleInbuiltDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInbuiltDeclaration = null;


        try {
            // InternalMIRoN.g:4365:59: (iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF )
            // InternalMIRoN.g:4366:2: iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF
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
    // InternalMIRoN.g:4372:1: ruleInbuiltDeclaration returns [EObject current=null] : () ;
    public final EObject ruleInbuiltDeclaration() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMIRoN.g:4378:2: ( () )
            // InternalMIRoN.g:4379:2: ()
            {
            // InternalMIRoN.g:4379:2: ()
            // InternalMIRoN.g:4380:3: 
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
    // InternalMIRoN.g:4389:1: entryRuleReferencedDeclaration returns [EObject current=null] : iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF ;
    public final EObject entryRuleReferencedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedDeclaration = null;


        try {
            // InternalMIRoN.g:4389:62: (iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF )
            // InternalMIRoN.g:4390:2: iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF
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
    // InternalMIRoN.g:4396:1: ruleReferencedDeclaration returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleReferencedDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:4402:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalMIRoN.g:4403:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalMIRoN.g:4403:2: ( (otherlv_0= RULE_ID ) )
            // InternalMIRoN.g:4404:3: (otherlv_0= RULE_ID )
            {
            // InternalMIRoN.g:4404:3: (otherlv_0= RULE_ID )
            // InternalMIRoN.g:4405:4: otherlv_0= RULE_ID
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
    // InternalMIRoN.g:4419:1: entryRuleGeneralExpression returns [EObject current=null] : iv_ruleGeneralExpression= ruleGeneralExpression EOF ;
    public final EObject entryRuleGeneralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralExpression = null;


        try {
            // InternalMIRoN.g:4419:58: (iv_ruleGeneralExpression= ruleGeneralExpression EOF )
            // InternalMIRoN.g:4420:2: iv_ruleGeneralExpression= ruleGeneralExpression EOF
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
    // InternalMIRoN.g:4426:1: ruleGeneralExpression returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleGeneralExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4432:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalMIRoN.g:4433:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalMIRoN.g:4433:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalMIRoN.g:4434:3: (lv_term_0_0= ruleTerm )
            {
            // InternalMIRoN.g:4434:3: (lv_term_0_0= ruleTerm )
            // InternalMIRoN.g:4435:4: lv_term_0_0= ruleTerm
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
    // InternalMIRoN.g:4455:1: entryRuleOutputTransformation returns [EObject current=null] : iv_ruleOutputTransformation= ruleOutputTransformation EOF ;
    public final EObject entryRuleOutputTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputTransformation = null;


        try {
            // InternalMIRoN.g:4455:61: (iv_ruleOutputTransformation= ruleOutputTransformation EOF )
            // InternalMIRoN.g:4456:2: iv_ruleOutputTransformation= ruleOutputTransformation EOF
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
    // InternalMIRoN.g:4462:1: ruleOutputTransformation returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleOutputTransformation() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4468:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalMIRoN.g:4469:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalMIRoN.g:4469:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalMIRoN.g:4470:3: (lv_term_0_0= ruleTerm )
            {
            // InternalMIRoN.g:4470:3: (lv_term_0_0= ruleTerm )
            // InternalMIRoN.g:4471:4: lv_term_0_0= ruleTerm
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
    // InternalMIRoN.g:4491:1: entryRuleContextPattern returns [EObject current=null] : iv_ruleContextPattern= ruleContextPattern EOF ;
    public final EObject entryRuleContextPattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextPattern = null;


        try {
            // InternalMIRoN.g:4491:55: (iv_ruleContextPattern= ruleContextPattern EOF )
            // InternalMIRoN.g:4492:2: iv_ruleContextPattern= ruleContextPattern EOF
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
    // InternalMIRoN.g:4498:1: ruleContextPattern returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleContextPattern() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4504:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalMIRoN.g:4505:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalMIRoN.g:4505:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalMIRoN.g:4506:3: (lv_term_0_0= ruleTerm )
            {
            // InternalMIRoN.g:4506:3: (lv_term_0_0= ruleTerm )
            // InternalMIRoN.g:4507:4: lv_term_0_0= ruleTerm
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
    // InternalMIRoN.g:4527:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalMIRoN.g:4527:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalMIRoN.g:4528:2: iv_ruleTerm= ruleTerm EOF
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
    // InternalMIRoN.g:4534:1: ruleTerm returns [EObject current=null] : (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_OnceTerm_0 = null;

        EObject this_WhileTerm_1 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4540:2: ( (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm ) )
            // InternalMIRoN.g:4541:2: (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm )
            {
            // InternalMIRoN.g:4541:2: (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==66) ) {
                alt57=1;
            }
            else if ( ((LA57_0>=RULE_INT && LA57_0<=RULE_ID)||LA57_0==16||LA57_0==24||LA57_0==55||LA57_0==73||LA57_0==77||LA57_0==85||(LA57_0>=88 && LA57_0<=89)||(LA57_0>=92 && LA57_0<=93)||(LA57_0>=105 && LA57_0<=125)) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalMIRoN.g:4542:3: this_OnceTerm_0= ruleOnceTerm
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
                    // InternalMIRoN.g:4551:3: this_WhileTerm_1= ruleWhileTerm
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
    // InternalMIRoN.g:4563:1: entryRuleOnceTerm returns [EObject current=null] : iv_ruleOnceTerm= ruleOnceTerm EOF ;
    public final EObject entryRuleOnceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnceTerm = null;


        try {
            // InternalMIRoN.g:4563:49: (iv_ruleOnceTerm= ruleOnceTerm EOF )
            // InternalMIRoN.g:4564:2: iv_ruleOnceTerm= ruleOnceTerm EOF
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
    // InternalMIRoN.g:4570:1: ruleOnceTerm returns [EObject current=null] : (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) ) ;
    public final EObject ruleOnceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_term_1_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4576:2: ( (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) ) )
            // InternalMIRoN.g:4577:2: (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) )
            {
            // InternalMIRoN.g:4577:2: (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) )
            // InternalMIRoN.g:4578:3: otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getOnceTermAccess().getOnceKeyword_0());
            		
            // InternalMIRoN.g:4582:3: ( (lv_term_1_0= ruleWhileTerm ) )
            // InternalMIRoN.g:4583:4: (lv_term_1_0= ruleWhileTerm )
            {
            // InternalMIRoN.g:4583:4: (lv_term_1_0= ruleWhileTerm )
            // InternalMIRoN.g:4584:5: lv_term_1_0= ruleWhileTerm
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
    // InternalMIRoN.g:4605:1: entryRuleWhileTerm returns [EObject current=null] : iv_ruleWhileTerm= ruleWhileTerm EOF ;
    public final EObject entryRuleWhileTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileTerm = null;


        try {
            // InternalMIRoN.g:4605:50: (iv_ruleWhileTerm= ruleWhileTerm EOF )
            // InternalMIRoN.g:4606:2: iv_ruleWhileTerm= ruleWhileTerm EOF
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
    // InternalMIRoN.g:4612:1: ruleWhileTerm returns [EObject current=null] : (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleWhileTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_RepetionTerm_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4618:2: ( (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? ) )
            // InternalMIRoN.g:4619:2: (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? )
            {
            // InternalMIRoN.g:4619:2: (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? )
            // InternalMIRoN.g:4620:3: this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )?
            {

            			newCompositeNode(grammarAccess.getWhileTermAccess().getRepetionTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_51);
            this_RepetionTerm_0=ruleRepetionTerm();

            state._fsp--;


            			current = this_RepetionTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:4628:3: ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==67) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalMIRoN.g:4629:4: () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')'
                    {
                    // InternalMIRoN.g:4629:4: ()
                    // InternalMIRoN.g:4630:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getWhileTermAccess().getWhileTermLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,67,FOLLOW_18); 

                    				newLeafNode(otherlv_2, grammarAccess.getWhileTermAccess().getWhileKeyword_1_1());
                    			
                    otherlv_3=(Token)match(input,24,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getWhileTermAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMIRoN.g:4644:4: ( (lv_right_4_0= ruleOrBooleanTerm ) )
                    // InternalMIRoN.g:4645:5: (lv_right_4_0= ruleOrBooleanTerm )
                    {
                    // InternalMIRoN.g:4645:5: (lv_right_4_0= ruleOrBooleanTerm )
                    // InternalMIRoN.g:4646:6: lv_right_4_0= ruleOrBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getWhileTermAccess().getRightOrBooleanTermParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_19);
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

                    otherlv_5=(Token)match(input,25,FOLLOW_2); 

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
    // InternalMIRoN.g:4672:1: entryRuleRepetionTerm returns [EObject current=null] : iv_ruleRepetionTerm= ruleRepetionTerm EOF ;
    public final EObject entryRuleRepetionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepetionTerm = null;


        try {
            // InternalMIRoN.g:4672:53: (iv_ruleRepetionTerm= ruleRepetionTerm EOF )
            // InternalMIRoN.g:4673:2: iv_ruleRepetionTerm= ruleRepetionTerm EOF
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
    // InternalMIRoN.g:4679:1: ruleRepetionTerm returns [EObject current=null] : (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? ) ;
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
            // InternalMIRoN.g:4685:2: ( (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? ) )
            // InternalMIRoN.g:4686:2: (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? )
            {
            // InternalMIRoN.g:4686:2: (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? )
            // InternalMIRoN.g:4687:3: this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )?
            {

            			newCompositeNode(grammarAccess.getRepetionTermAccess().getSequenceTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_52);
            this_SequenceTerm_0=ruleSequenceTerm();

            state._fsp--;


            			current = this_SequenceTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:4695:3: ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )?
            int alt59=3;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==68) ) {
                alt59=1;
            }
            else if ( (LA59_0==69) ) {
                alt59=2;
            }
            switch (alt59) {
                case 1 :
                    // InternalMIRoN.g:4696:4: ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' )
                    {
                    // InternalMIRoN.g:4696:4: ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' )
                    // InternalMIRoN.g:4697:5: () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')'
                    {
                    // InternalMIRoN.g:4697:5: ()
                    // InternalMIRoN.g:4698:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getRepetionTermAccess().getRepeatTermTermAction_1_0_0(),
                    							current);
                    					

                    }

                    otherlv_2=(Token)match(input,68,FOLLOW_18); 

                    					newLeafNode(otherlv_2, grammarAccess.getRepetionTermAccess().getRepeatKeyword_1_0_1());
                    				
                    otherlv_3=(Token)match(input,24,FOLLOW_9); 

                    					newLeafNode(otherlv_3, grammarAccess.getRepetionTermAccess().getLeftParenthesisKeyword_1_0_2());
                    				
                    // InternalMIRoN.g:4712:5: ( (lv_nrep_4_0= RULE_INT ) )
                    // InternalMIRoN.g:4713:6: (lv_nrep_4_0= RULE_INT )
                    {
                    // InternalMIRoN.g:4713:6: (lv_nrep_4_0= RULE_INT )
                    // InternalMIRoN.g:4714:7: lv_nrep_4_0= RULE_INT
                    {
                    lv_nrep_4_0=(Token)match(input,RULE_INT,FOLLOW_19); 

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

                    otherlv_5=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(otherlv_5, grammarAccess.getRepetionTermAccess().getRightParenthesisKeyword_1_0_4());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4736:4: ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' )
                    {
                    // InternalMIRoN.g:4736:4: ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' )
                    // InternalMIRoN.g:4737:5: () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')'
                    {
                    // InternalMIRoN.g:4737:5: ()
                    // InternalMIRoN.g:4738:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getRepetionTermAccess().getRangeTermTermAction_1_1_0(),
                    							current);
                    					

                    }

                    otherlv_7=(Token)match(input,69,FOLLOW_18); 

                    					newLeafNode(otherlv_7, grammarAccess.getRepetionTermAccess().getRangeKeyword_1_1_1());
                    				
                    otherlv_8=(Token)match(input,24,FOLLOW_9); 

                    					newLeafNode(otherlv_8, grammarAccess.getRepetionTermAccess().getLeftParenthesisKeyword_1_1_2());
                    				
                    // InternalMIRoN.g:4752:5: ( (lv_lowerBound_9_0= RULE_INT ) )
                    // InternalMIRoN.g:4753:6: (lv_lowerBound_9_0= RULE_INT )
                    {
                    // InternalMIRoN.g:4753:6: (lv_lowerBound_9_0= RULE_INT )
                    // InternalMIRoN.g:4754:7: lv_lowerBound_9_0= RULE_INT
                    {
                    lv_lowerBound_9_0=(Token)match(input,RULE_INT,FOLLOW_24); 

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

                    otherlv_10=(Token)match(input,19,FOLLOW_9); 

                    					newLeafNode(otherlv_10, grammarAccess.getRepetionTermAccess().getCommaKeyword_1_1_4());
                    				
                    // InternalMIRoN.g:4774:5: ( (lv_upperBound_11_0= RULE_INT ) )
                    // InternalMIRoN.g:4775:6: (lv_upperBound_11_0= RULE_INT )
                    {
                    // InternalMIRoN.g:4775:6: (lv_upperBound_11_0= RULE_INT )
                    // InternalMIRoN.g:4776:7: lv_upperBound_11_0= RULE_INT
                    {
                    lv_upperBound_11_0=(Token)match(input,RULE_INT,FOLLOW_19); 

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

                    otherlv_12=(Token)match(input,25,FOLLOW_2); 

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
    // InternalMIRoN.g:4802:1: entryRuleSequenceTerm returns [EObject current=null] : iv_ruleSequenceTerm= ruleSequenceTerm EOF ;
    public final EObject entryRuleSequenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceTerm = null;


        try {
            // InternalMIRoN.g:4802:53: (iv_ruleSequenceTerm= ruleSequenceTerm EOF )
            // InternalMIRoN.g:4803:2: iv_ruleSequenceTerm= ruleSequenceTerm EOF
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
    // InternalMIRoN.g:4809:1: ruleSequenceTerm returns [EObject current=null] : (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* ) ;
    public final EObject ruleSequenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_OrEventTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4815:2: ( (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* ) )
            // InternalMIRoN.g:4816:2: (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* )
            {
            // InternalMIRoN.g:4816:2: (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* )
            // InternalMIRoN.g:4817:3: this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getSequenceTermAccess().getOrEventTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_OrEventTerm_0=ruleOrEventTerm();

            state._fsp--;


            			current = this_OrEventTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:4825:3: ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==70) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalMIRoN.g:4826:4: () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) )
            	    {
            	    // InternalMIRoN.g:4826:4: ()
            	    // InternalMIRoN.g:4827:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getSequenceTermAccess().getFollowedByTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,70,FOLLOW_21); 

            	    				newLeafNode(otherlv_2, grammarAccess.getSequenceTermAccess().getHyphenMinusGreaterThanSignKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:4837:4: ( (lv_right_3_0= ruleConditionalTerm ) )
            	    // InternalMIRoN.g:4838:5: (lv_right_3_0= ruleConditionalTerm )
            	    {
            	    // InternalMIRoN.g:4838:5: (lv_right_3_0= ruleConditionalTerm )
            	    // InternalMIRoN.g:4839:6: lv_right_3_0= ruleConditionalTerm
            	    {

            	    						newCompositeNode(grammarAccess.getSequenceTermAccess().getRightConditionalTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_53);
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
            	    break loop60;
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
    // InternalMIRoN.g:4861:1: entryRuleOrEventTerm returns [EObject current=null] : iv_ruleOrEventTerm= ruleOrEventTerm EOF ;
    public final EObject entryRuleOrEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrEventTerm = null;


        try {
            // InternalMIRoN.g:4861:52: (iv_ruleOrEventTerm= ruleOrEventTerm EOF )
            // InternalMIRoN.g:4862:2: iv_ruleOrEventTerm= ruleOrEventTerm EOF
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
    // InternalMIRoN.g:4868:1: ruleOrEventTerm returns [EObject current=null] : (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* ) ;
    public final EObject ruleOrEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndEventTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4874:2: ( (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* ) )
            // InternalMIRoN.g:4875:2: (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* )
            {
            // InternalMIRoN.g:4875:2: (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* )
            // InternalMIRoN.g:4876:3: this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrEventTermAccess().getAndEventTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_AndEventTerm_0=ruleAndEventTerm();

            state._fsp--;


            			current = this_AndEventTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:4884:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==71) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalMIRoN.g:4885:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) )
            	    {
            	    // InternalMIRoN.g:4885:4: ()
            	    // InternalMIRoN.g:4886:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrEventTermAccess().getOrEventTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,71,FOLLOW_21); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrEventTermAccess().getOrKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:4896:4: ( (lv_right_3_0= ruleAndEventTerm ) )
            	    // InternalMIRoN.g:4897:5: (lv_right_3_0= ruleAndEventTerm )
            	    {
            	    // InternalMIRoN.g:4897:5: (lv_right_3_0= ruleAndEventTerm )
            	    // InternalMIRoN.g:4898:6: lv_right_3_0= ruleAndEventTerm
            	    {

            	    						newCompositeNode(grammarAccess.getOrEventTermAccess().getRightAndEventTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_54);
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
    // $ANTLR end "ruleOrEventTerm"


    // $ANTLR start "entryRuleAndEventTerm"
    // InternalMIRoN.g:4920:1: entryRuleAndEventTerm returns [EObject current=null] : iv_ruleAndEventTerm= ruleAndEventTerm EOF ;
    public final EObject entryRuleAndEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndEventTerm = null;


        try {
            // InternalMIRoN.g:4920:53: (iv_ruleAndEventTerm= ruleAndEventTerm EOF )
            // InternalMIRoN.g:4921:2: iv_ruleAndEventTerm= ruleAndEventTerm EOF
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
    // InternalMIRoN.g:4927:1: ruleAndEventTerm returns [EObject current=null] : ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* ) ;
    public final EObject ruleAndEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_NotEventTerm_0 = null;

        EObject this_ConditionalTerm_1 = null;

        EObject lv_right_4_1 = null;

        EObject lv_right_4_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:4933:2: ( ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* ) )
            // InternalMIRoN.g:4934:2: ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* )
            {
            // InternalMIRoN.g:4934:2: ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* )
            // InternalMIRoN.g:4935:3: (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )*
            {
            // InternalMIRoN.g:4935:3: (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==73) ) {
                alt62=1;
            }
            else if ( ((LA62_0>=RULE_INT && LA62_0<=RULE_ID)||LA62_0==16||LA62_0==24||LA62_0==55||LA62_0==77||LA62_0==85||(LA62_0>=88 && LA62_0<=89)||(LA62_0>=92 && LA62_0<=93)||(LA62_0>=105 && LA62_0<=125)) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalMIRoN.g:4936:4: this_NotEventTerm_0= ruleNotEventTerm
                    {

                    				newCompositeNode(grammarAccess.getAndEventTermAccess().getNotEventTermParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_55);
                    this_NotEventTerm_0=ruleNotEventTerm();

                    state._fsp--;


                    				current = this_NotEventTerm_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:4945:4: this_ConditionalTerm_1= ruleConditionalTerm
                    {

                    				newCompositeNode(grammarAccess.getAndEventTermAccess().getConditionalTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_55);
                    this_ConditionalTerm_1=ruleConditionalTerm();

                    state._fsp--;


                    				current = this_ConditionalTerm_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:4954:3: ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==72) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalMIRoN.g:4955:4: () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) )
            	    {
            	    // InternalMIRoN.g:4955:4: ()
            	    // InternalMIRoN.g:4956:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndEventTermAccess().getAndEventTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,72,FOLLOW_21); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAndEventTermAccess().getAndKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:4966:4: ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) )
            	    // InternalMIRoN.g:4967:5: ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) )
            	    {
            	    // InternalMIRoN.g:4967:5: ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) )
            	    // InternalMIRoN.g:4968:6: (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm )
            	    {
            	    // InternalMIRoN.g:4968:6: (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm )
            	    int alt63=2;
            	    int LA63_0 = input.LA(1);

            	    if ( (LA63_0==73) ) {
            	        alt63=1;
            	    }
            	    else if ( ((LA63_0>=RULE_INT && LA63_0<=RULE_ID)||LA63_0==16||LA63_0==24||LA63_0==55||LA63_0==77||LA63_0==85||(LA63_0>=88 && LA63_0<=89)||(LA63_0>=92 && LA63_0<=93)||(LA63_0>=105 && LA63_0<=125)) ) {
            	        alt63=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 63, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt63) {
            	        case 1 :
            	            // InternalMIRoN.g:4969:7: lv_right_4_1= ruleNotEventTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndEventTermAccess().getRightNotEventTermParserRuleCall_1_2_0_0());
            	            						
            	            pushFollow(FOLLOW_55);
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
            	            // InternalMIRoN.g:4985:7: lv_right_4_2= ruleConditionalTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndEventTermAccess().getRightConditionalTermParserRuleCall_1_2_0_1());
            	            						
            	            pushFollow(FOLLOW_55);
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
            	    break loop64;
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
    // InternalMIRoN.g:5008:1: entryRuleNotEventTerm returns [EObject current=null] : iv_ruleNotEventTerm= ruleNotEventTerm EOF ;
    public final EObject entryRuleNotEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotEventTerm = null;


        try {
            // InternalMIRoN.g:5008:53: (iv_ruleNotEventTerm= ruleNotEventTerm EOF )
            // InternalMIRoN.g:5009:2: iv_ruleNotEventTerm= ruleNotEventTerm EOF
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
    // InternalMIRoN.g:5015:1: ruleNotEventTerm returns [EObject current=null] : ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) ) ;
    public final EObject ruleNotEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5021:2: ( ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) ) )
            // InternalMIRoN.g:5022:2: ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) )
            {
            // InternalMIRoN.g:5022:2: ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) )
            // InternalMIRoN.g:5023:3: () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) )
            {
            // InternalMIRoN.g:5023:3: ()
            // InternalMIRoN.g:5024:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotEventTermAccess().getNotEventTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,73,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getNotEventTermAccess().getNotKeyword_1());
            		
            // InternalMIRoN.g:5034:3: ( (lv_term_2_0= ruleConditionalTerm ) )
            // InternalMIRoN.g:5035:4: (lv_term_2_0= ruleConditionalTerm )
            {
            // InternalMIRoN.g:5035:4: (lv_term_2_0= ruleConditionalTerm )
            // InternalMIRoN.g:5036:5: lv_term_2_0= ruleConditionalTerm
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
    // InternalMIRoN.g:5057:1: entryRuleConditionalTerm returns [EObject current=null] : iv_ruleConditionalTerm= ruleConditionalTerm EOF ;
    public final EObject entryRuleConditionalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalTerm = null;


        try {
            // InternalMIRoN.g:5057:56: (iv_ruleConditionalTerm= ruleConditionalTerm EOF )
            // InternalMIRoN.g:5058:2: iv_ruleConditionalTerm= ruleConditionalTerm EOF
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
    // InternalMIRoN.g:5064:1: ruleConditionalTerm returns [EObject current=null] : (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? ) ;
    public final EObject ruleConditionalTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_OrBooleanTerm_0 = null;

        EObject lv_terms_3_0 = null;

        EObject lv_terms_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5070:2: ( (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? ) )
            // InternalMIRoN.g:5071:2: (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? )
            {
            // InternalMIRoN.g:5071:2: (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? )
            // InternalMIRoN.g:5072:3: this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )?
            {

            			newCompositeNode(grammarAccess.getConditionalTermAccess().getOrBooleanTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_56);
            this_OrBooleanTerm_0=ruleOrBooleanTerm();

            state._fsp--;


            			current = this_OrBooleanTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5080:3: ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==74) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalMIRoN.g:5081:4: () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) )
                    {
                    // InternalMIRoN.g:5081:4: ()
                    // InternalMIRoN.g:5082:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getConditionalTermAccess().getConditionalTermTermsAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,74,FOLLOW_21); 

                    				newLeafNode(otherlv_2, grammarAccess.getConditionalTermAccess().getQuestionMarkKeyword_1_1());
                    			
                    // InternalMIRoN.g:5092:4: ( (lv_terms_3_0= ruleOrBooleanTerm ) )
                    // InternalMIRoN.g:5093:5: (lv_terms_3_0= ruleOrBooleanTerm )
                    {
                    // InternalMIRoN.g:5093:5: (lv_terms_3_0= ruleOrBooleanTerm )
                    // InternalMIRoN.g:5094:6: lv_terms_3_0= ruleOrBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getConditionalTermAccess().getTermsOrBooleanTermParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_14);
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

                    otherlv_4=(Token)match(input,21,FOLLOW_21); 

                    				newLeafNode(otherlv_4, grammarAccess.getConditionalTermAccess().getColonKeyword_1_3());
                    			
                    // InternalMIRoN.g:5115:4: ( (lv_terms_5_0= ruleConditionalTerm ) )
                    // InternalMIRoN.g:5116:5: (lv_terms_5_0= ruleConditionalTerm )
                    {
                    // InternalMIRoN.g:5116:5: (lv_terms_5_0= ruleConditionalTerm )
                    // InternalMIRoN.g:5117:6: lv_terms_5_0= ruleConditionalTerm
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
    // InternalMIRoN.g:5139:1: entryRuleOrBooleanTerm returns [EObject current=null] : iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF ;
    public final EObject entryRuleOrBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBooleanTerm = null;


        try {
            // InternalMIRoN.g:5139:54: (iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF )
            // InternalMIRoN.g:5140:2: iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF
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
    // InternalMIRoN.g:5146:1: ruleOrBooleanTerm returns [EObject current=null] : (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* ) ;
    public final EObject ruleOrBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndBooleanTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5152:2: ( (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* ) )
            // InternalMIRoN.g:5153:2: (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* )
            {
            // InternalMIRoN.g:5153:2: (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* )
            // InternalMIRoN.g:5154:3: this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrBooleanTermAccess().getAndBooleanTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_57);
            this_AndBooleanTerm_0=ruleAndBooleanTerm();

            state._fsp--;


            			current = this_AndBooleanTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5162:3: ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==75) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalMIRoN.g:5163:4: () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) )
            	    {
            	    // InternalMIRoN.g:5163:4: ()
            	    // InternalMIRoN.g:5164:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrBooleanTermAccess().getOrBooleanTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,75,FOLLOW_21); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrBooleanTermAccess().getVerticalLineKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:5174:4: ( (lv_right_3_0= ruleAndBooleanTerm ) )
            	    // InternalMIRoN.g:5175:5: (lv_right_3_0= ruleAndBooleanTerm )
            	    {
            	    // InternalMIRoN.g:5175:5: (lv_right_3_0= ruleAndBooleanTerm )
            	    // InternalMIRoN.g:5176:6: lv_right_3_0= ruleAndBooleanTerm
            	    {

            	    						newCompositeNode(grammarAccess.getOrBooleanTermAccess().getRightAndBooleanTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_57);
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
            	    break loop66;
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
    // InternalMIRoN.g:5198:1: entryRuleAndBooleanTerm returns [EObject current=null] : iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF ;
    public final EObject entryRuleAndBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndBooleanTerm = null;


        try {
            // InternalMIRoN.g:5198:55: (iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF )
            // InternalMIRoN.g:5199:2: iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF
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
    // InternalMIRoN.g:5205:1: ruleAndBooleanTerm returns [EObject current=null] : ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* ) ;
    public final EObject ruleAndBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_NotBooleanTerm_0 = null;

        EObject this_RelationalTerm_1 = null;

        EObject lv_right_4_1 = null;

        EObject lv_right_4_2 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5211:2: ( ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* ) )
            // InternalMIRoN.g:5212:2: ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* )
            {
            // InternalMIRoN.g:5212:2: ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* )
            // InternalMIRoN.g:5213:3: (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )*
            {
            // InternalMIRoN.g:5213:3: (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==77) ) {
                alt67=1;
            }
            else if ( ((LA67_0>=RULE_INT && LA67_0<=RULE_ID)||LA67_0==16||LA67_0==24||LA67_0==55||LA67_0==85||(LA67_0>=88 && LA67_0<=89)||(LA67_0>=92 && LA67_0<=93)||(LA67_0>=105 && LA67_0<=125)) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalMIRoN.g:5214:4: this_NotBooleanTerm_0= ruleNotBooleanTerm
                    {

                    				newCompositeNode(grammarAccess.getAndBooleanTermAccess().getNotBooleanTermParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_58);
                    this_NotBooleanTerm_0=ruleNotBooleanTerm();

                    state._fsp--;


                    				current = this_NotBooleanTerm_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:5223:4: this_RelationalTerm_1= ruleRelationalTerm
                    {

                    				newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRelationalTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_58);
                    this_RelationalTerm_1=ruleRelationalTerm();

                    state._fsp--;


                    				current = this_RelationalTerm_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:5232:3: ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==76) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalMIRoN.g:5233:4: () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) )
            	    {
            	    // InternalMIRoN.g:5233:4: ()
            	    // InternalMIRoN.g:5234:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndBooleanTermAccess().getAndBooleanTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,76,FOLLOW_21); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAndBooleanTermAccess().getAmpersandKeyword_1_1());
            	    			
            	    // InternalMIRoN.g:5244:4: ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) )
            	    // InternalMIRoN.g:5245:5: ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) )
            	    {
            	    // InternalMIRoN.g:5245:5: ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) )
            	    // InternalMIRoN.g:5246:6: (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm )
            	    {
            	    // InternalMIRoN.g:5246:6: (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm )
            	    int alt68=2;
            	    int LA68_0 = input.LA(1);

            	    if ( (LA68_0==77) ) {
            	        alt68=1;
            	    }
            	    else if ( ((LA68_0>=RULE_INT && LA68_0<=RULE_ID)||LA68_0==16||LA68_0==24||LA68_0==55||LA68_0==85||(LA68_0>=88 && LA68_0<=89)||(LA68_0>=92 && LA68_0<=93)||(LA68_0>=105 && LA68_0<=125)) ) {
            	        alt68=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 68, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt68) {
            	        case 1 :
            	            // InternalMIRoN.g:5247:7: lv_right_4_1= ruleNotBooleanTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRightNotBooleanTermParserRuleCall_1_2_0_0());
            	            						
            	            pushFollow(FOLLOW_58);
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
            	            // InternalMIRoN.g:5263:7: lv_right_4_2= ruleRelationalTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRightRelationalTermParserRuleCall_1_2_0_1());
            	            						
            	            pushFollow(FOLLOW_58);
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
            	    break loop69;
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
    // InternalMIRoN.g:5286:1: entryRuleNotBooleanTerm returns [EObject current=null] : iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF ;
    public final EObject entryRuleNotBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotBooleanTerm = null;


        try {
            // InternalMIRoN.g:5286:55: (iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF )
            // InternalMIRoN.g:5287:2: iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF
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
    // InternalMIRoN.g:5293:1: ruleNotBooleanTerm returns [EObject current=null] : ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) ) ;
    public final EObject ruleNotBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5299:2: ( ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) ) )
            // InternalMIRoN.g:5300:2: ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) )
            {
            // InternalMIRoN.g:5300:2: ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) )
            // InternalMIRoN.g:5301:3: () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) )
            {
            // InternalMIRoN.g:5301:3: ()
            // InternalMIRoN.g:5302:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotBooleanTermAccess().getNotBooleanTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,77,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getNotBooleanTermAccess().getExclamationMarkKeyword_1());
            		
            // InternalMIRoN.g:5312:3: ( (lv_term_2_0= ruleRelationalTerm ) )
            // InternalMIRoN.g:5313:4: (lv_term_2_0= ruleRelationalTerm )
            {
            // InternalMIRoN.g:5313:4: (lv_term_2_0= ruleRelationalTerm )
            // InternalMIRoN.g:5314:5: lv_term_2_0= ruleRelationalTerm
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
    // InternalMIRoN.g:5335:1: entryRuleRelationalTerm returns [EObject current=null] : iv_ruleRelationalTerm= ruleRelationalTerm EOF ;
    public final EObject entryRuleRelationalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalTerm = null;


        try {
            // InternalMIRoN.g:5335:55: (iv_ruleRelationalTerm= ruleRelationalTerm EOF )
            // InternalMIRoN.g:5336:2: iv_ruleRelationalTerm= ruleRelationalTerm EOF
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
    // InternalMIRoN.g:5342:1: ruleRelationalTerm returns [EObject current=null] : (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? ) ;
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
            // InternalMIRoN.g:5348:2: ( (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? ) )
            // InternalMIRoN.g:5349:2: (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? )
            {
            // InternalMIRoN.g:5349:2: (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? )
            // InternalMIRoN.g:5350:3: this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )?
            {

            			newCompositeNode(grammarAccess.getRelationalTermAccess().getAdditionTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_59);
            this_AdditionTerm_0=ruleAdditionTerm();

            state._fsp--;


            			current = this_AdditionTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5358:3: ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=78 && LA71_0<=83)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalMIRoN.g:5359:4: ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) )
                    {
                    // InternalMIRoN.g:5359:4: ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) )
                    int alt70=6;
                    switch ( input.LA(1) ) {
                    case 78:
                        {
                        alt70=1;
                        }
                        break;
                    case 79:
                        {
                        alt70=2;
                        }
                        break;
                    case 80:
                        {
                        alt70=3;
                        }
                        break;
                    case 81:
                        {
                        alt70=4;
                        }
                        break;
                    case 82:
                        {
                        alt70=5;
                        }
                        break;
                    case 83:
                        {
                        alt70=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }

                    switch (alt70) {
                        case 1 :
                            // InternalMIRoN.g:5360:5: ( () otherlv_2= '=' )
                            {
                            // InternalMIRoN.g:5360:5: ( () otherlv_2= '=' )
                            // InternalMIRoN.g:5361:6: () otherlv_2= '='
                            {
                            // InternalMIRoN.g:5361:6: ()
                            // InternalMIRoN.g:5362:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getEqualTermLeftAction_1_0_0_0(),
                            								current);
                            						

                            }

                            otherlv_2=(Token)match(input,78,FOLLOW_21); 

                            						newLeafNode(otherlv_2, grammarAccess.getRelationalTermAccess().getEqualsSignKeyword_1_0_0_1());
                            					

                            }


                            }
                            break;
                        case 2 :
                            // InternalMIRoN.g:5374:5: ( () otherlv_4= '<' )
                            {
                            // InternalMIRoN.g:5374:5: ( () otherlv_4= '<' )
                            // InternalMIRoN.g:5375:6: () otherlv_4= '<'
                            {
                            // InternalMIRoN.g:5375:6: ()
                            // InternalMIRoN.g:5376:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getLessThanTermLeftAction_1_0_1_0(),
                            								current);
                            						

                            }

                            otherlv_4=(Token)match(input,79,FOLLOW_21); 

                            						newLeafNode(otherlv_4, grammarAccess.getRelationalTermAccess().getLessThanSignKeyword_1_0_1_1());
                            					

                            }


                            }
                            break;
                        case 3 :
                            // InternalMIRoN.g:5388:5: ( () otherlv_6= '>' )
                            {
                            // InternalMIRoN.g:5388:5: ( () otherlv_6= '>' )
                            // InternalMIRoN.g:5389:6: () otherlv_6= '>'
                            {
                            // InternalMIRoN.g:5389:6: ()
                            // InternalMIRoN.g:5390:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getGreaterThanTermLeftAction_1_0_2_0(),
                            								current);
                            						

                            }

                            otherlv_6=(Token)match(input,80,FOLLOW_21); 

                            						newLeafNode(otherlv_6, grammarAccess.getRelationalTermAccess().getGreaterThanSignKeyword_1_0_2_1());
                            					

                            }


                            }
                            break;
                        case 4 :
                            // InternalMIRoN.g:5402:5: ( () otherlv_8= '<=' )
                            {
                            // InternalMIRoN.g:5402:5: ( () otherlv_8= '<=' )
                            // InternalMIRoN.g:5403:6: () otherlv_8= '<='
                            {
                            // InternalMIRoN.g:5403:6: ()
                            // InternalMIRoN.g:5404:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getLessEqualTermLeftAction_1_0_3_0(),
                            								current);
                            						

                            }

                            otherlv_8=(Token)match(input,81,FOLLOW_21); 

                            						newLeafNode(otherlv_8, grammarAccess.getRelationalTermAccess().getLessThanSignEqualsSignKeyword_1_0_3_1());
                            					

                            }


                            }
                            break;
                        case 5 :
                            // InternalMIRoN.g:5416:5: ( () otherlv_10= '>=' )
                            {
                            // InternalMIRoN.g:5416:5: ( () otherlv_10= '>=' )
                            // InternalMIRoN.g:5417:6: () otherlv_10= '>='
                            {
                            // InternalMIRoN.g:5417:6: ()
                            // InternalMIRoN.g:5418:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getGreaterEqualTermLeftAction_1_0_4_0(),
                            								current);
                            						

                            }

                            otherlv_10=(Token)match(input,82,FOLLOW_21); 

                            						newLeafNode(otherlv_10, grammarAccess.getRelationalTermAccess().getGreaterThanSignEqualsSignKeyword_1_0_4_1());
                            					

                            }


                            }
                            break;
                        case 6 :
                            // InternalMIRoN.g:5430:5: ( () otherlv_12= '!=' )
                            {
                            // InternalMIRoN.g:5430:5: ( () otherlv_12= '!=' )
                            // InternalMIRoN.g:5431:6: () otherlv_12= '!='
                            {
                            // InternalMIRoN.g:5431:6: ()
                            // InternalMIRoN.g:5432:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getNotEqualTermLeftAction_1_0_5_0(),
                            								current);
                            						

                            }

                            otherlv_12=(Token)match(input,83,FOLLOW_21); 

                            						newLeafNode(otherlv_12, grammarAccess.getRelationalTermAccess().getExclamationMarkEqualsSignKeyword_1_0_5_1());
                            					

                            }


                            }
                            break;

                    }

                    // InternalMIRoN.g:5444:4: ( (lv_right_13_0= ruleAdditionTerm ) )
                    // InternalMIRoN.g:5445:5: (lv_right_13_0= ruleAdditionTerm )
                    {
                    // InternalMIRoN.g:5445:5: (lv_right_13_0= ruleAdditionTerm )
                    // InternalMIRoN.g:5446:6: lv_right_13_0= ruleAdditionTerm
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
    // InternalMIRoN.g:5468:1: entryRuleAdditionTerm returns [EObject current=null] : iv_ruleAdditionTerm= ruleAdditionTerm EOF ;
    public final EObject entryRuleAdditionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionTerm = null;


        try {
            // InternalMIRoN.g:5468:53: (iv_ruleAdditionTerm= ruleAdditionTerm EOF )
            // InternalMIRoN.g:5469:2: iv_ruleAdditionTerm= ruleAdditionTerm EOF
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
    // InternalMIRoN.g:5475:1: ruleAdditionTerm returns [EObject current=null] : (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* ) ;
    public final EObject ruleAdditionTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_MultiplicationTerm_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5481:2: ( (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* ) )
            // InternalMIRoN.g:5482:2: (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* )
            {
            // InternalMIRoN.g:5482:2: (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* )
            // InternalMIRoN.g:5483:3: this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionTermAccess().getMultiplicationTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_60);
            this_MultiplicationTerm_0=ruleMultiplicationTerm();

            state._fsp--;


            			current = this_MultiplicationTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5491:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( ((LA73_0>=84 && LA73_0<=85)) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalMIRoN.g:5492:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) )
            	    {
            	    // InternalMIRoN.g:5492:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt72=2;
            	    int LA72_0 = input.LA(1);

            	    if ( (LA72_0==84) ) {
            	        alt72=1;
            	    }
            	    else if ( (LA72_0==85) ) {
            	        alt72=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 72, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt72) {
            	        case 1 :
            	            // InternalMIRoN.g:5493:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalMIRoN.g:5493:5: ( () otherlv_2= '+' )
            	            // InternalMIRoN.g:5494:6: () otherlv_2= '+'
            	            {
            	            // InternalMIRoN.g:5494:6: ()
            	            // InternalMIRoN.g:5495:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionTermAccess().getAddTermLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,84,FOLLOW_21); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionTermAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMIRoN.g:5507:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalMIRoN.g:5507:5: ( () otherlv_4= '-' )
            	            // InternalMIRoN.g:5508:6: () otherlv_4= '-'
            	            {
            	            // InternalMIRoN.g:5508:6: ()
            	            // InternalMIRoN.g:5509:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionTermAccess().getSubTermLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,85,FOLLOW_21); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionTermAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMIRoN.g:5521:4: ( (lv_right_5_0= ruleMultiplicationTerm ) )
            	    // InternalMIRoN.g:5522:5: (lv_right_5_0= ruleMultiplicationTerm )
            	    {
            	    // InternalMIRoN.g:5522:5: (lv_right_5_0= ruleMultiplicationTerm )
            	    // InternalMIRoN.g:5523:6: lv_right_5_0= ruleMultiplicationTerm
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionTermAccess().getRightMultiplicationTermParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
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
            	    break loop73;
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
    // InternalMIRoN.g:5545:1: entryRuleMultiplicationTerm returns [EObject current=null] : iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF ;
    public final EObject entryRuleMultiplicationTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicationTerm = null;


        try {
            // InternalMIRoN.g:5545:59: (iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF )
            // InternalMIRoN.g:5546:2: iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF
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
    // InternalMIRoN.g:5552:1: ruleMultiplicationTerm returns [EObject current=null] : (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* ) ;
    public final EObject ruleMultiplicationTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryTerm_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5558:2: ( (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* ) )
            // InternalMIRoN.g:5559:2: (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* )
            {
            // InternalMIRoN.g:5559:2: (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* )
            // InternalMIRoN.g:5560:3: this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationTermAccess().getPrimaryTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_61);
            this_PrimaryTerm_0=rulePrimaryTerm();

            state._fsp--;


            			current = this_PrimaryTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMIRoN.g:5568:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( ((LA75_0>=86 && LA75_0<=87)) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalMIRoN.g:5569:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) )
            	    {
            	    // InternalMIRoN.g:5569:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt74=2;
            	    int LA74_0 = input.LA(1);

            	    if ( (LA74_0==86) ) {
            	        alt74=1;
            	    }
            	    else if ( (LA74_0==87) ) {
            	        alt74=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 74, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt74) {
            	        case 1 :
            	            // InternalMIRoN.g:5570:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalMIRoN.g:5570:5: ( () otherlv_2= '*' )
            	            // InternalMIRoN.g:5571:6: () otherlv_2= '*'
            	            {
            	            // InternalMIRoN.g:5571:6: ()
            	            // InternalMIRoN.g:5572:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationTermAccess().getMultTermLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,86,FOLLOW_21); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationTermAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMIRoN.g:5584:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalMIRoN.g:5584:5: ( () otherlv_4= '/' )
            	            // InternalMIRoN.g:5585:6: () otherlv_4= '/'
            	            {
            	            // InternalMIRoN.g:5585:6: ()
            	            // InternalMIRoN.g:5586:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationTermAccess().getDivTermLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,87,FOLLOW_21); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationTermAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMIRoN.g:5598:4: ( (lv_right_5_0= rulePrimaryTerm ) )
            	    // InternalMIRoN.g:5599:5: (lv_right_5_0= rulePrimaryTerm )
            	    {
            	    // InternalMIRoN.g:5599:5: (lv_right_5_0= rulePrimaryTerm )
            	    // InternalMIRoN.g:5600:6: lv_right_5_0= rulePrimaryTerm
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationTermAccess().getRightPrimaryTermParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_61);
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
            	    break loop75;
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
    // InternalMIRoN.g:5622:1: entryRulePrimaryTerm returns [EObject current=null] : iv_rulePrimaryTerm= rulePrimaryTerm EOF ;
    public final EObject entryRulePrimaryTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryTerm = null;


        try {
            // InternalMIRoN.g:5622:52: (iv_rulePrimaryTerm= rulePrimaryTerm EOF )
            // InternalMIRoN.g:5623:2: iv_rulePrimaryTerm= rulePrimaryTerm EOF
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
    // InternalMIRoN.g:5629:1: rulePrimaryTerm returns [EObject current=null] : ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm ) ;
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
            // InternalMIRoN.g:5635:2: ( ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm ) )
            // InternalMIRoN.g:5636:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )
            {
            // InternalMIRoN.g:5636:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )
            int alt76=5;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // InternalMIRoN.g:5637:3: (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' )
                    {
                    // InternalMIRoN.g:5637:3: (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' )
                    // InternalMIRoN.g:5638:4: otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryTermAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryTermAccess().getTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_19);
                    this_Term_1=ruleTerm();

                    state._fsp--;


                    				current = this_Term_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryTermAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:5656:3: this_ConstTerm_3= ruleConstTerm
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
                    // InternalMIRoN.g:5665:3: this_VarTerm_4= ruleVarTerm
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
                    // InternalMIRoN.g:5674:3: this_SelfTerm_5= ruleSelfTerm
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
                    // InternalMIRoN.g:5683:3: this_FunctionTerm_6= ruleFunctionTerm
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
    // InternalMIRoN.g:5695:1: entryRuleVarTerm returns [EObject current=null] : iv_ruleVarTerm= ruleVarTerm EOF ;
    public final EObject entryRuleVarTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarTerm = null;


        try {
            // InternalMIRoN.g:5695:48: (iv_ruleVarTerm= ruleVarTerm EOF )
            // InternalMIRoN.g:5696:2: iv_ruleVarTerm= ruleVarTerm EOF
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
    // InternalMIRoN.g:5702:1: ruleVarTerm returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVarTerm() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMIRoN.g:5708:2: ( ( ( ruleQualifiedName ) ) )
            // InternalMIRoN.g:5709:2: ( ( ruleQualifiedName ) )
            {
            // InternalMIRoN.g:5709:2: ( ( ruleQualifiedName ) )
            // InternalMIRoN.g:5710:3: ( ruleQualifiedName )
            {
            // InternalMIRoN.g:5710:3: ( ruleQualifiedName )
            // InternalMIRoN.g:5711:4: ruleQualifiedName
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
    // InternalMIRoN.g:5728:1: entryRuleConstTerm returns [EObject current=null] : iv_ruleConstTerm= ruleConstTerm EOF ;
    public final EObject entryRuleConstTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstTerm = null;


        try {
            // InternalMIRoN.g:5728:50: (iv_ruleConstTerm= ruleConstTerm EOF )
            // InternalMIRoN.g:5729:2: iv_ruleConstTerm= ruleConstTerm EOF
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
    // InternalMIRoN.g:5735:1: ruleConstTerm returns [EObject current=null] : ( (lv_value_0_0= ruleTypedValue ) ) ;
    public final EObject ruleConstTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5741:2: ( ( (lv_value_0_0= ruleTypedValue ) ) )
            // InternalMIRoN.g:5742:2: ( (lv_value_0_0= ruleTypedValue ) )
            {
            // InternalMIRoN.g:5742:2: ( (lv_value_0_0= ruleTypedValue ) )
            // InternalMIRoN.g:5743:3: (lv_value_0_0= ruleTypedValue )
            {
            // InternalMIRoN.g:5743:3: (lv_value_0_0= ruleTypedValue )
            // InternalMIRoN.g:5744:4: lv_value_0_0= ruleTypedValue
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
    // InternalMIRoN.g:5764:1: entryRuleSelfTerm returns [EObject current=null] : iv_ruleSelfTerm= ruleSelfTerm EOF ;
    public final EObject entryRuleSelfTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfTerm = null;


        try {
            // InternalMIRoN.g:5764:49: (iv_ruleSelfTerm= ruleSelfTerm EOF )
            // InternalMIRoN.g:5765:2: iv_ruleSelfTerm= ruleSelfTerm EOF
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
    // InternalMIRoN.g:5771:1: ruleSelfTerm returns [EObject current=null] : ( () otherlv_1= 'belief' ) ;
    public final EObject ruleSelfTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMIRoN.g:5777:2: ( ( () otherlv_1= 'belief' ) )
            // InternalMIRoN.g:5778:2: ( () otherlv_1= 'belief' )
            {
            // InternalMIRoN.g:5778:2: ( () otherlv_1= 'belief' )
            // InternalMIRoN.g:5779:3: () otherlv_1= 'belief'
            {
            // InternalMIRoN.g:5779:3: ()
            // InternalMIRoN.g:5780:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSelfTermAccess().getSelfTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,88,FOLLOW_2); 

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
    // InternalMIRoN.g:5794:1: entryRuleFunctionTerm returns [EObject current=null] : iv_ruleFunctionTerm= ruleFunctionTerm EOF ;
    public final EObject entryRuleFunctionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionTerm = null;


        try {
            // InternalMIRoN.g:5794:53: (iv_ruleFunctionTerm= ruleFunctionTerm EOF )
            // InternalMIRoN.g:5795:2: iv_ruleFunctionTerm= ruleFunctionTerm EOF
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
    // InternalMIRoN.g:5801:1: ruleFunctionTerm returns [EObject current=null] : (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction ) ;
    public final EObject ruleFunctionTerm() throws RecognitionException {
        EObject current = null;

        EObject this_ArithFunction_0 = null;

        EObject this_AggregationFunction_1 = null;

        EObject this_PatternFunction_2 = null;

        EObject this_CollectionFunction_3 = null;

        EObject this_ScheduleFunction_4 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5807:2: ( (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction ) )
            // InternalMIRoN.g:5808:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )
            {
            // InternalMIRoN.g:5808:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )
            int alt77=5;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // InternalMIRoN.g:5809:3: this_ArithFunction_0= ruleArithFunction
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
                    // InternalMIRoN.g:5818:3: this_AggregationFunction_1= ruleAggregationFunction
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
                    // InternalMIRoN.g:5827:3: this_PatternFunction_2= rulePatternFunction
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
                    // InternalMIRoN.g:5836:3: this_CollectionFunction_3= ruleCollectionFunction
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
                    // InternalMIRoN.g:5845:3: this_ScheduleFunction_4= ruleScheduleFunction
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
    // InternalMIRoN.g:5857:1: entryRuleScheduleFunction returns [EObject current=null] : iv_ruleScheduleFunction= ruleScheduleFunction EOF ;
    public final EObject entryRuleScheduleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScheduleFunction = null;


        try {
            // InternalMIRoN.g:5857:57: (iv_ruleScheduleFunction= ruleScheduleFunction EOF )
            // InternalMIRoN.g:5858:2: iv_ruleScheduleFunction= ruleScheduleFunction EOF
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
    // InternalMIRoN.g:5864:1: ruleScheduleFunction returns [EObject current=null] : ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' ) ;
    public final EObject ruleScheduleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_pattern_3_0 = null;



        	enterRule();

        try {
            // InternalMIRoN.g:5870:2: ( ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' ) )
            // InternalMIRoN.g:5871:2: ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' )
            {
            // InternalMIRoN.g:5871:2: ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' )
            // InternalMIRoN.g:5872:3: () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')'
            {
            // InternalMIRoN.g:5872:3: ()
            // InternalMIRoN.g:5873:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getScheduleFunctionAccess().getScheduleFunctionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,89,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getScheduleFunctionAccess().getScheduleKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getScheduleFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIRoN.g:5887:3: ( (lv_pattern_3_0= ruleEString ) )
            // InternalMIRoN.g:5888:4: (lv_pattern_3_0= ruleEString )
            {
            // InternalMIRoN.g:5888:4: (lv_pattern_3_0= ruleEString )
            // InternalMIRoN.g:5889:5: lv_pattern_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getScheduleFunctionAccess().getPatternEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_4=(Token)match(input,25,FOLLOW_2); 

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
    // InternalMIRoN.g:5914:1: entryRuleArithFunction returns [EObject current=null] : iv_ruleArithFunction= ruleArithFunction EOF ;
    public final EObject entryRuleArithFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithFunction = null;


        try {
            // InternalMIRoN.g:5914:54: (iv_ruleArithFunction= ruleArithFunction EOF )
            // InternalMIRoN.g:5915:2: iv_ruleArithFunction= ruleArithFunction EOF
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
    // InternalMIRoN.g:5921:1: ruleArithFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
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
            // InternalMIRoN.g:5927:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalMIRoN.g:5928:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalMIRoN.g:5928:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalMIRoN.g:5929:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalMIRoN.g:5929:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_ID||LA79_0==88) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalMIRoN.g:5930:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalMIRoN.g:5930:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalMIRoN.g:5931:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalMIRoN.g:5931:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalMIRoN.g:5932:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalMIRoN.g:5932:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==RULE_ID) ) {
                        alt78=1;
                    }
                    else if ( (LA78_0==88) ) {
                        alt78=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 78, 0, input);

                        throw nvae;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalMIRoN.g:5933:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_62);
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
                            // InternalMIRoN.g:5949:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_62);
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

                    otherlv_1=(Token)match(input,90,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getArithFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:5972:3: ( (lv_name_2_0= ruleArithFtnEnum ) )
            // InternalMIRoN.g:5973:4: (lv_name_2_0= ruleArithFtnEnum )
            {
            // InternalMIRoN.g:5973:4: (lv_name_2_0= ruleArithFtnEnum )
            // InternalMIRoN.g:5974:5: lv_name_2_0= ruleArithFtnEnum
            {

            					newCompositeNode(grammarAccess.getArithFunctionAccess().getNameArithFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_64);
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

            // InternalMIRoN.g:5991:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==24) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalMIRoN.g:5992:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_65); 

                    				newLeafNode(otherlv_3, grammarAccess.getArithFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMIRoN.g:5996:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( ((LA81_0>=RULE_INT && LA81_0<=RULE_ID)||LA81_0==16||LA81_0==24||LA81_0==55||LA81_0==66||LA81_0==73||LA81_0==77||LA81_0==85||(LA81_0>=88 && LA81_0<=89)||(LA81_0>=92 && LA81_0<=93)||(LA81_0>=105 && LA81_0<=125)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalMIRoN.g:5997:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalMIRoN.g:5997:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalMIRoN.g:5998:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalMIRoN.g:5998:6: (lv_terms_4_0= ruleTerm )
                            // InternalMIRoN.g:5999:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_66);
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

                            // InternalMIRoN.g:6016:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop80:
                            do {
                                int alt80=2;
                                int LA80_0 = input.LA(1);

                                if ( (LA80_0==19) ) {
                                    alt80=1;
                                }


                                switch (alt80) {
                            	case 1 :
                            	    // InternalMIRoN.g:6017:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,19,FOLLOW_21); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getArithFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalMIRoN.g:6021:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalMIRoN.g:6022:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalMIRoN.g:6022:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalMIRoN.g:6023:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_66);
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
                            	    break loop80;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,25,FOLLOW_2); 

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
    // InternalMIRoN.g:6051:1: entryRuleAggregationFunction returns [EObject current=null] : iv_ruleAggregationFunction= ruleAggregationFunction EOF ;
    public final EObject entryRuleAggregationFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregationFunction = null;


        try {
            // InternalMIRoN.g:6051:60: (iv_ruleAggregationFunction= ruleAggregationFunction EOF )
            // InternalMIRoN.g:6052:2: iv_ruleAggregationFunction= ruleAggregationFunction EOF
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
    // InternalMIRoN.g:6058:1: ruleAggregationFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
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
            // InternalMIRoN.g:6064:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalMIRoN.g:6065:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalMIRoN.g:6065:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalMIRoN.g:6066:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalMIRoN.g:6066:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_ID||LA84_0==88) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalMIRoN.g:6067:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalMIRoN.g:6067:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalMIRoN.g:6068:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalMIRoN.g:6068:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalMIRoN.g:6069:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalMIRoN.g:6069:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==RULE_ID) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==88) ) {
                        alt83=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalMIRoN.g:6070:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_62);
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
                            // InternalMIRoN.g:6086:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_62);
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

                    otherlv_1=(Token)match(input,90,FOLLOW_67); 

                    				newLeafNode(otherlv_1, grammarAccess.getAggregationFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:6109:3: ( (lv_name_2_0= ruleAggregationFtnEnum ) )
            // InternalMIRoN.g:6110:4: (lv_name_2_0= ruleAggregationFtnEnum )
            {
            // InternalMIRoN.g:6110:4: (lv_name_2_0= ruleAggregationFtnEnum )
            // InternalMIRoN.g:6111:5: lv_name_2_0= ruleAggregationFtnEnum
            {

            					newCompositeNode(grammarAccess.getAggregationFunctionAccess().getNameAggregationFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_64);
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

            // InternalMIRoN.g:6128:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==24) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalMIRoN.g:6129:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_65); 

                    				newLeafNode(otherlv_3, grammarAccess.getAggregationFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMIRoN.g:6133:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( ((LA86_0>=RULE_INT && LA86_0<=RULE_ID)||LA86_0==16||LA86_0==24||LA86_0==55||LA86_0==66||LA86_0==73||LA86_0==77||LA86_0==85||(LA86_0>=88 && LA86_0<=89)||(LA86_0>=92 && LA86_0<=93)||(LA86_0>=105 && LA86_0<=125)) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalMIRoN.g:6134:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalMIRoN.g:6134:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalMIRoN.g:6135:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalMIRoN.g:6135:6: (lv_terms_4_0= ruleTerm )
                            // InternalMIRoN.g:6136:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_66);
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

                            // InternalMIRoN.g:6153:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop85:
                            do {
                                int alt85=2;
                                int LA85_0 = input.LA(1);

                                if ( (LA85_0==19) ) {
                                    alt85=1;
                                }


                                switch (alt85) {
                            	case 1 :
                            	    // InternalMIRoN.g:6154:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,19,FOLLOW_21); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getAggregationFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalMIRoN.g:6158:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalMIRoN.g:6159:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalMIRoN.g:6159:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalMIRoN.g:6160:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_66);
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
                            	    break loop85;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,25,FOLLOW_2); 

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
    // InternalMIRoN.g:6188:1: entryRulePatternFunction returns [EObject current=null] : iv_rulePatternFunction= rulePatternFunction EOF ;
    public final EObject entryRulePatternFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternFunction = null;


        try {
            // InternalMIRoN.g:6188:56: (iv_rulePatternFunction= rulePatternFunction EOF )
            // InternalMIRoN.g:6189:2: iv_rulePatternFunction= rulePatternFunction EOF
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
    // InternalMIRoN.g:6195:1: rulePatternFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
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
            // InternalMIRoN.g:6201:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalMIRoN.g:6202:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalMIRoN.g:6202:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalMIRoN.g:6203:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalMIRoN.g:6203:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_ID||LA89_0==88) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalMIRoN.g:6204:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalMIRoN.g:6204:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalMIRoN.g:6205:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalMIRoN.g:6205:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalMIRoN.g:6206:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalMIRoN.g:6206:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==RULE_ID) ) {
                        alt88=1;
                    }
                    else if ( (LA88_0==88) ) {
                        alt88=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 88, 0, input);

                        throw nvae;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalMIRoN.g:6207:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_62);
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
                            // InternalMIRoN.g:6223:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_62);
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

                    otherlv_1=(Token)match(input,90,FOLLOW_68); 

                    				newLeafNode(otherlv_1, grammarAccess.getPatternFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:6246:3: ( (lv_name_2_0= rulePatternFtnEnum ) )
            // InternalMIRoN.g:6247:4: (lv_name_2_0= rulePatternFtnEnum )
            {
            // InternalMIRoN.g:6247:4: (lv_name_2_0= rulePatternFtnEnum )
            // InternalMIRoN.g:6248:5: lv_name_2_0= rulePatternFtnEnum
            {

            					newCompositeNode(grammarAccess.getPatternFunctionAccess().getNamePatternFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_64);
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

            // InternalMIRoN.g:6265:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==24) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalMIRoN.g:6266:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_65); 

                    				newLeafNode(otherlv_3, grammarAccess.getPatternFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMIRoN.g:6270:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( ((LA91_0>=RULE_INT && LA91_0<=RULE_ID)||LA91_0==16||LA91_0==24||LA91_0==55||LA91_0==66||LA91_0==73||LA91_0==77||LA91_0==85||(LA91_0>=88 && LA91_0<=89)||(LA91_0>=92 && LA91_0<=93)||(LA91_0>=105 && LA91_0<=125)) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // InternalMIRoN.g:6271:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalMIRoN.g:6271:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalMIRoN.g:6272:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalMIRoN.g:6272:6: (lv_terms_4_0= ruleTerm )
                            // InternalMIRoN.g:6273:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_66);
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

                            // InternalMIRoN.g:6290:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop90:
                            do {
                                int alt90=2;
                                int LA90_0 = input.LA(1);

                                if ( (LA90_0==19) ) {
                                    alt90=1;
                                }


                                switch (alt90) {
                            	case 1 :
                            	    // InternalMIRoN.g:6291:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,19,FOLLOW_21); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getPatternFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalMIRoN.g:6295:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalMIRoN.g:6296:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalMIRoN.g:6296:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalMIRoN.g:6297:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_66);
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
                            	    break loop90;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,25,FOLLOW_2); 

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
    // InternalMIRoN.g:6325:1: entryRuleCollectionFunction returns [EObject current=null] : iv_ruleCollectionFunction= ruleCollectionFunction EOF ;
    public final EObject entryRuleCollectionFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionFunction = null;


        try {
            // InternalMIRoN.g:6325:59: (iv_ruleCollectionFunction= ruleCollectionFunction EOF )
            // InternalMIRoN.g:6326:2: iv_ruleCollectionFunction= ruleCollectionFunction EOF
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
    // InternalMIRoN.g:6332:1: ruleCollectionFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
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
            // InternalMIRoN.g:6338:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalMIRoN.g:6339:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalMIRoN.g:6339:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalMIRoN.g:6340:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalMIRoN.g:6340:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_ID||LA94_0==88) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalMIRoN.g:6341:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalMIRoN.g:6341:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalMIRoN.g:6342:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalMIRoN.g:6342:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalMIRoN.g:6343:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalMIRoN.g:6343:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==RULE_ID) ) {
                        alt93=1;
                    }
                    else if ( (LA93_0==88) ) {
                        alt93=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 0, input);

                        throw nvae;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalMIRoN.g:6344:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_62);
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
                            // InternalMIRoN.g:6360:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_62);
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

                    otherlv_1=(Token)match(input,90,FOLLOW_69); 

                    				newLeafNode(otherlv_1, grammarAccess.getCollectionFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMIRoN.g:6383:3: ( (lv_name_2_0= ruleCollectionFtnEnum ) )
            // InternalMIRoN.g:6384:4: (lv_name_2_0= ruleCollectionFtnEnum )
            {
            // InternalMIRoN.g:6384:4: (lv_name_2_0= ruleCollectionFtnEnum )
            // InternalMIRoN.g:6385:5: lv_name_2_0= ruleCollectionFtnEnum
            {

            					newCompositeNode(grammarAccess.getCollectionFunctionAccess().getNameCollectionFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_64);
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

            // InternalMIRoN.g:6402:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==24) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalMIRoN.g:6403:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_65); 

                    				newLeafNode(otherlv_3, grammarAccess.getCollectionFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMIRoN.g:6407:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( ((LA96_0>=RULE_INT && LA96_0<=RULE_ID)||LA96_0==16||LA96_0==24||LA96_0==55||LA96_0==66||LA96_0==73||LA96_0==77||LA96_0==85||(LA96_0>=88 && LA96_0<=89)||(LA96_0>=92 && LA96_0<=93)||(LA96_0>=105 && LA96_0<=125)) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // InternalMIRoN.g:6408:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalMIRoN.g:6408:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalMIRoN.g:6409:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalMIRoN.g:6409:6: (lv_terms_4_0= ruleTerm )
                            // InternalMIRoN.g:6410:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_66);
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

                            // InternalMIRoN.g:6427:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop95:
                            do {
                                int alt95=2;
                                int LA95_0 = input.LA(1);

                                if ( (LA95_0==19) ) {
                                    alt95=1;
                                }


                                switch (alt95) {
                            	case 1 :
                            	    // InternalMIRoN.g:6428:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,19,FOLLOW_21); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getCollectionFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalMIRoN.g:6432:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalMIRoN.g:6433:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalMIRoN.g:6433:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalMIRoN.g:6434:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_66);
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
                            	    break loop95;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,25,FOLLOW_2); 

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
    // InternalMIRoN.g:6462:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMIRoN.g:6462:47: (iv_ruleEString= ruleEString EOF )
            // InternalMIRoN.g:6463:2: iv_ruleEString= ruleEString EOF
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
    // InternalMIRoN.g:6469:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6475:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMIRoN.g:6476:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMIRoN.g:6476:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==RULE_STRING) ) {
                alt98=1;
            }
            else if ( (LA98_0==RULE_ID) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // InternalMIRoN.g:6477:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6485:3: this_ID_1= RULE_ID
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
    // InternalMIRoN.g:6496:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalMIRoN.g:6496:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalMIRoN.g:6497:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalMIRoN.g:6503:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6509:2: ( ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) )
            // InternalMIRoN.g:6510:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            {
            // InternalMIRoN.g:6510:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            // InternalMIRoN.g:6511:3: (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )?
            {
            // InternalMIRoN.g:6511:3: (kw= '-' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==85) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalMIRoN.g:6512:4: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_9); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_70); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
            		
            // InternalMIRoN.g:6525:3: (kw= '.' this_INT_3= RULE_INT )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==91) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalMIRoN.g:6526:4: kw= '.' this_INT_3= RULE_INT
                    {
                    kw=(Token)match(input,91,FOLLOW_9); 

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
    // InternalMIRoN.g:6543:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalMIRoN.g:6543:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalMIRoN.g:6544:2: iv_ruleEBoolean= ruleEBoolean EOF
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
    // InternalMIRoN.g:6550:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6556:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalMIRoN.g:6557:2: (kw= 'true' | kw= 'false' )
            {
            // InternalMIRoN.g:6557:2: (kw= 'true' | kw= 'false' )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==92) ) {
                alt101=1;
            }
            else if ( (LA101_0==93) ) {
                alt101=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // InternalMIRoN.g:6558:3: kw= 'true'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6564:3: kw= 'false'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

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
    // InternalMIRoN.g:6573:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMIRoN.g:6573:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMIRoN.g:6574:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalMIRoN.g:6580:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6586:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMIRoN.g:6587:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMIRoN.g:6587:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMIRoN.g:6588:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_70); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMIRoN.g:6595:3: (kw= '.' this_ID_2= RULE_ID )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==91) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalMIRoN.g:6596:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,91,FOLLOW_12); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_70); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop102;
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
    // InternalMIRoN.g:6613:1: entryRuleLiteralQualifiedName returns [String current=null] : iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF ;
    public final String entryRuleLiteralQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralQualifiedName = null;


        try {
            // InternalMIRoN.g:6613:60: (iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF )
            // InternalMIRoN.g:6614:2: iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF
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
    // InternalMIRoN.g:6620:1: ruleLiteralQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ ) ;
    public final AntlrDatatypeRuleToken ruleLiteralQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6626:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ ) )
            // InternalMIRoN.g:6627:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ )
            {
            // InternalMIRoN.g:6627:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ )
            // InternalMIRoN.g:6628:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_71); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getLiteralQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMIRoN.g:6635:3: (kw= '::' this_ID_2= RULE_ID )+
            int cnt103=0;
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==94) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // InternalMIRoN.g:6636:4: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,94,FOLLOW_12); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getLiteralQualifiedNameAccess().getColonColonKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_72); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getLiteralQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt103 >= 1 ) break loop103;
                        EarlyExitException eee =
                            new EarlyExitException(103, input);
                        throw eee;
                }
                cnt103++;
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
    // InternalMIRoN.g:6653:1: entryRuleElementDescription returns [String current=null] : iv_ruleElementDescription= ruleElementDescription EOF ;
    public final String entryRuleElementDescription() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleElementDescription = null;


        try {
            // InternalMIRoN.g:6653:58: (iv_ruleElementDescription= ruleElementDescription EOF )
            // InternalMIRoN.g:6654:2: iv_ruleElementDescription= ruleElementDescription EOF
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
    // InternalMIRoN.g:6660:1: ruleElementDescription returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION ;
    public final AntlrDatatypeRuleToken ruleElementDescription() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROQME_DESCRIPTION_0=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6666:2: (this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION )
            // InternalMIRoN.g:6667:2: this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION
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


    // $ANTLR start "ruleInsertionTypeEnum"
    // InternalMIRoN.g:6677:1: ruleInsertionTypeEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'after' ) | (enumLiteral_2= 'before' ) ) ;
    public final Enumerator ruleInsertionTypeEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6683:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'after' ) | (enumLiteral_2= 'before' ) ) )
            // InternalMIRoN.g:6684:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'after' ) | (enumLiteral_2= 'before' ) )
            {
            // InternalMIRoN.g:6684:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'after' ) | (enumLiteral_2= 'before' ) )
            int alt104=3;
            switch ( input.LA(1) ) {
            case 95:
                {
                alt104=1;
                }
                break;
            case 96:
                {
                alt104=2;
                }
                break;
            case 97:
                {
                alt104=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // InternalMIRoN.g:6685:3: (enumLiteral_0= 'in' )
                    {
                    // InternalMIRoN.g:6685:3: (enumLiteral_0= 'in' )
                    // InternalMIRoN.g:6686:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getInsertionTypeEnumAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getInsertionTypeEnumAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6693:3: (enumLiteral_1= 'after' )
                    {
                    // InternalMIRoN.g:6693:3: (enumLiteral_1= 'after' )
                    // InternalMIRoN.g:6694:4: enumLiteral_1= 'after'
                    {
                    enumLiteral_1=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getInsertionTypeEnumAccess().getAFTEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getInsertionTypeEnumAccess().getAFTEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:6701:3: (enumLiteral_2= 'before' )
                    {
                    // InternalMIRoN.g:6701:3: (enumLiteral_2= 'before' )
                    // InternalMIRoN.g:6702:4: enumLiteral_2= 'before'
                    {
                    enumLiteral_2=(Token)match(input,97,FOLLOW_2); 

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
    // InternalMIRoN.g:6712:1: ruleInfluenceEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) ) ;
    public final Enumerator ruleInfluenceEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6718:2: ( ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) ) )
            // InternalMIRoN.g:6719:2: ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) )
            {
            // InternalMIRoN.g:6719:2: ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==98) ) {
                alt105=1;
            }
            else if ( (LA105_0==99) ) {
                alt105=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalMIRoN.g:6720:3: (enumLiteral_0= 'reinforces' )
                    {
                    // InternalMIRoN.g:6720:3: (enumLiteral_0= 'reinforces' )
                    // InternalMIRoN.g:6721:4: enumLiteral_0= 'reinforces'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getInfluenceEnumAccess().getREINFORCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getInfluenceEnumAccess().getREINFORCEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6728:3: (enumLiteral_1= 'undermines' )
                    {
                    // InternalMIRoN.g:6728:3: (enumLiteral_1= 'undermines' )
                    // InternalMIRoN.g:6729:4: enumLiteral_1= 'undermines'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); 

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
    // InternalMIRoN.g:6739:1: ruleStrengthEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) ) ;
    public final Enumerator ruleStrengthEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6745:2: ( ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) ) )
            // InternalMIRoN.g:6746:2: ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) )
            {
            // InternalMIRoN.g:6746:2: ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) )
            int alt106=5;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt106=1;
                }
                break;
            case 101:
                {
                alt106=2;
                }
                break;
            case 102:
                {
                alt106=3;
                }
                break;
            case 103:
                {
                alt106=4;
                }
                break;
            case 104:
                {
                alt106=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // InternalMIRoN.g:6747:3: (enumLiteral_0= 'veryhigh' )
                    {
                    // InternalMIRoN.g:6747:3: (enumLiteral_0= 'veryhigh' )
                    // InternalMIRoN.g:6748:4: enumLiteral_0= 'veryhigh'
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getVERY_HIGHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStrengthEnumAccess().getVERY_HIGHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6755:3: (enumLiteral_1= 'high' )
                    {
                    // InternalMIRoN.g:6755:3: (enumLiteral_1= 'high' )
                    // InternalMIRoN.g:6756:4: enumLiteral_1= 'high'
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getHIGHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStrengthEnumAccess().getHIGHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:6763:3: (enumLiteral_2= 'MEDIUM' )
                    {
                    // InternalMIRoN.g:6763:3: (enumLiteral_2= 'MEDIUM' )
                    // InternalMIRoN.g:6764:4: enumLiteral_2= 'MEDIUM'
                    {
                    enumLiteral_2=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getMEDIUMEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getStrengthEnumAccess().getMEDIUMEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:6771:3: (enumLiteral_3= 'low' )
                    {
                    // InternalMIRoN.g:6771:3: (enumLiteral_3= 'low' )
                    // InternalMIRoN.g:6772:4: enumLiteral_3= 'low'
                    {
                    enumLiteral_3=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getStrengthEnumAccess().getLOWEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:6779:3: (enumLiteral_4= 'verylow' )
                    {
                    // InternalMIRoN.g:6779:3: (enumLiteral_4= 'verylow' )
                    // InternalMIRoN.g:6780:4: enumLiteral_4= 'verylow'
                    {
                    enumLiteral_4=(Token)match(input,104,FOLLOW_2); 

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
    // InternalMIRoN.g:6790:1: ruleArithFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) ) ;
    public final Enumerator ruleArithFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6796:2: ( ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) ) )
            // InternalMIRoN.g:6797:2: ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) )
            {
            // InternalMIRoN.g:6797:2: ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) )
            int alt107=4;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt107=1;
                }
                break;
            case 106:
                {
                alt107=2;
                }
                break;
            case 107:
                {
                alt107=3;
                }
                break;
            case 108:
                {
                alt107=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // InternalMIRoN.g:6798:3: (enumLiteral_0= 'pow' )
                    {
                    // InternalMIRoN.g:6798:3: (enumLiteral_0= 'pow' )
                    // InternalMIRoN.g:6799:4: enumLiteral_0= 'pow'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getPOWEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getArithFtnEnumAccess().getPOWEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6806:3: (enumLiteral_1= 'sqrt' )
                    {
                    // InternalMIRoN.g:6806:3: (enumLiteral_1= 'sqrt' )
                    // InternalMIRoN.g:6807:4: enumLiteral_1= 'sqrt'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getSQRTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getArithFtnEnumAccess().getSQRTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:6814:3: (enumLiteral_2= 'exp' )
                    {
                    // InternalMIRoN.g:6814:3: (enumLiteral_2= 'exp' )
                    // InternalMIRoN.g:6815:4: enumLiteral_2= 'exp'
                    {
                    enumLiteral_2=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getEXPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getArithFtnEnumAccess().getEXPEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:6822:3: (enumLiteral_3= 'abs' )
                    {
                    // InternalMIRoN.g:6822:3: (enumLiteral_3= 'abs' )
                    // InternalMIRoN.g:6823:4: enumLiteral_3= 'abs'
                    {
                    enumLiteral_3=(Token)match(input,108,FOLLOW_2); 

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
    // InternalMIRoN.g:6833:1: ruleAggregationFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) ) ;
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
            // InternalMIRoN.g:6839:2: ( ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) ) )
            // InternalMIRoN.g:6840:2: ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) )
            {
            // InternalMIRoN.g:6840:2: ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) )
            int alt108=8;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt108=1;
                }
                break;
            case 110:
                {
                alt108=2;
                }
                break;
            case 111:
                {
                alt108=3;
                }
                break;
            case 112:
                {
                alt108=4;
                }
                break;
            case 113:
                {
                alt108=5;
                }
                break;
            case 114:
                {
                alt108=6;
                }
                break;
            case 115:
                {
                alt108=7;
                }
                break;
            case 116:
                {
                alt108=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalMIRoN.g:6841:3: (enumLiteral_0= 'avg' )
                    {
                    // InternalMIRoN.g:6841:3: (enumLiteral_0= 'avg' )
                    // InternalMIRoN.g:6842:4: enumLiteral_0= 'avg'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getAVGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAggregationFtnEnumAccess().getAVGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6849:3: (enumLiteral_1= 'min' )
                    {
                    // InternalMIRoN.g:6849:3: (enumLiteral_1= 'min' )
                    // InternalMIRoN.g:6850:4: enumLiteral_1= 'min'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getMINEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAggregationFtnEnumAccess().getMINEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:6857:3: (enumLiteral_2= 'max' )
                    {
                    // InternalMIRoN.g:6857:3: (enumLiteral_2= 'max' )
                    // InternalMIRoN.g:6858:4: enumLiteral_2= 'max'
                    {
                    enumLiteral_2=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getMAXEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAggregationFtnEnumAccess().getMAXEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:6865:3: (enumLiteral_3= 'count' )
                    {
                    // InternalMIRoN.g:6865:3: (enumLiteral_3= 'count' )
                    // InternalMIRoN.g:6866:4: enumLiteral_3= 'count'
                    {
                    enumLiteral_3=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getCOUNTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAggregationFtnEnumAccess().getCOUNTEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:6873:3: (enumLiteral_4= 'sum' )
                    {
                    // InternalMIRoN.g:6873:3: (enumLiteral_4= 'sum' )
                    // InternalMIRoN.g:6874:4: enumLiteral_4= 'sum'
                    {
                    enumLiteral_4=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getSUMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getAggregationFtnEnumAccess().getSUMEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:6881:3: (enumLiteral_5= 'decreasing' )
                    {
                    // InternalMIRoN.g:6881:3: (enumLiteral_5= 'decreasing' )
                    // InternalMIRoN.g:6882:4: enumLiteral_5= 'decreasing'
                    {
                    enumLiteral_5=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getDECREASINGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getAggregationFtnEnumAccess().getDECREASINGEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMIRoN.g:6889:3: (enumLiteral_6= 'increasing' )
                    {
                    // InternalMIRoN.g:6889:3: (enumLiteral_6= 'increasing' )
                    // InternalMIRoN.g:6890:4: enumLiteral_6= 'increasing'
                    {
                    enumLiteral_6=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getINCREASINGEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getAggregationFtnEnumAccess().getINCREASINGEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMIRoN.g:6897:3: (enumLiteral_7= 'stable' )
                    {
                    // InternalMIRoN.g:6897:3: (enumLiteral_7= 'stable' )
                    // InternalMIRoN.g:6898:4: enumLiteral_7= 'stable'
                    {
                    enumLiteral_7=(Token)match(input,116,FOLLOW_2); 

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
    // InternalMIRoN.g:6908:1: rulePatternFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) ) ;
    public final Enumerator rulePatternFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMIRoN.g:6914:2: ( ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) ) )
            // InternalMIRoN.g:6915:2: ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) )
            {
            // InternalMIRoN.g:6915:2: ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) )
            int alt109=3;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt109=1;
                }
                break;
            case 118:
                {
                alt109=2;
                }
                break;
            case 119:
                {
                alt109=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // InternalMIRoN.g:6916:3: (enumLiteral_0= 'eventWhen' )
                    {
                    // InternalMIRoN.g:6916:3: (enumLiteral_0= 'eventWhen' )
                    // InternalMIRoN.g:6917:4: enumLiteral_0= 'eventWhen'
                    {
                    enumLiteral_0=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getPatternFtnEnumAccess().getEVENT_WHENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPatternFtnEnumAccess().getEVENT_WHENEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6924:3: (enumLiteral_1= 'update' )
                    {
                    // InternalMIRoN.g:6924:3: (enumLiteral_1= 'update' )
                    // InternalMIRoN.g:6925:4: enumLiteral_1= 'update'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getPatternFtnEnumAccess().getUPDATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPatternFtnEnumAccess().getUPDATEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:6932:3: (enumLiteral_2= 'period' )
                    {
                    // InternalMIRoN.g:6932:3: (enumLiteral_2= 'period' )
                    // InternalMIRoN.g:6933:4: enumLiteral_2= 'period'
                    {
                    enumLiteral_2=(Token)match(input,119,FOLLOW_2); 

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
    // InternalMIRoN.g:6943:1: ruleCollectionFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) ) ;
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
            // InternalMIRoN.g:6949:2: ( ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) ) )
            // InternalMIRoN.g:6950:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) )
            {
            // InternalMIRoN.g:6950:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) )
            int alt110=6;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt110=1;
                }
                break;
            case 121:
                {
                alt110=2;
                }
                break;
            case 122:
                {
                alt110=3;
                }
                break;
            case 123:
                {
                alt110=4;
                }
                break;
            case 124:
                {
                alt110=5;
                }
                break;
            case 125:
                {
                alt110=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // InternalMIRoN.g:6951:3: (enumLiteral_0= 'first' )
                    {
                    // InternalMIRoN.g:6951:3: (enumLiteral_0= 'first' )
                    // InternalMIRoN.g:6952:4: enumLiteral_0= 'first'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getFIRSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCollectionFtnEnumAccess().getFIRSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMIRoN.g:6959:3: (enumLiteral_1= 'last' )
                    {
                    // InternalMIRoN.g:6959:3: (enumLiteral_1= 'last' )
                    // InternalMIRoN.g:6960:4: enumLiteral_1= 'last'
                    {
                    enumLiteral_1=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getLASTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCollectionFtnEnumAccess().getLASTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMIRoN.g:6967:3: (enumLiteral_2= 'at' )
                    {
                    // InternalMIRoN.g:6967:3: (enumLiteral_2= 'at' )
                    // InternalMIRoN.g:6968:4: enumLiteral_2= 'at'
                    {
                    enumLiteral_2=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getATEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCollectionFtnEnumAccess().getATEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMIRoN.g:6975:3: (enumLiteral_3= 'size' )
                    {
                    // InternalMIRoN.g:6975:3: (enumLiteral_3= 'size' )
                    // InternalMIRoN.g:6976:4: enumLiteral_3= 'size'
                    {
                    enumLiteral_3=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getSIZEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCollectionFtnEnumAccess().getSIZEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMIRoN.g:6983:3: (enumLiteral_4= 'isEmpty' )
                    {
                    // InternalMIRoN.g:6983:3: (enumLiteral_4= 'isEmpty' )
                    // InternalMIRoN.g:6984:4: enumLiteral_4= 'isEmpty'
                    {
                    enumLiteral_4=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getIS_EMPTYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getCollectionFtnEnumAccess().getIS_EMPTYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMIRoN.g:6991:3: (enumLiteral_5= 'includes' )
                    {
                    // InternalMIRoN.g:6991:3: (enumLiteral_5= 'includes' )
                    // InternalMIRoN.g:6992:4: enumLiteral_5= 'includes'
                    {
                    enumLiteral_5=(Token)match(input,125,FOLLOW_2); 

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


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA77 dfa77 = new DFA77(this);
    static final String dfa_1s = "\76\uffff";
    static final String dfa_2s = "\4\uffff\1\14\1\uffff\2\14\1\uffff\3\14\20\uffff\1\14\1\uffff\3\14\1\uffff\1\14\3\uffff\3\14\4\uffff\1\14\3\uffff\2\14\1\uffff\1\14\1\uffff\1\14\5\uffff\2\14";
    static final String dfa_3s = "\1\7\1\35\1\5\1\25\1\5\1\uffff\2\7\1\20\3\7\1\uffff\2\4\1\5\4\4\1\5\1\4\2\21\1\23\2\21\1\4\1\7\1\4\3\7\1\21\1\7\1\22\2\5\3\7\4\4\1\7\3\23\2\7\1\4\1\7\1\4\1\7\1\5\2\4\2\23\2\7";
    static final String dfa_4s = "\2\35\1\5\1\25\1\66\1\uffff\2\57\1\22\1\57\1\65\1\57\1\uffff\2\4\1\5\2\4\2\125\1\6\1\4\2\21\1\25\2\21\1\4\1\133\1\4\1\133\2\64\1\21\1\57\1\22\1\6\1\5\2\57\1\65\2\4\2\125\1\57\2\24\1\25\2\65\1\4\1\133\1\4\1\133\1\6\2\4\2\24\2\64";
    static final String dfa_5s = "\5\uffff\1\1\6\uffff\1\2\61\uffff";
    static final String dfa_6s = "\76\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\25\uffff\1\2",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\1\uffff\1\14\7\uffff\1\10\6\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\1\7\1\11\1\12\3\uffff\1\13",
            "",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\14\10\uffff\1\15\5\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\16\1\uffff\1\17",
            "\1\14\10\uffff\1\20\5\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\14\10\uffff\1\21\5\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\22\1\23\1\24",
            "\1\14\10\uffff\1\25\5\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\34\120\uffff\1\33",
            "\1\36\120\uffff\1\35",
            "\1\40\1\37",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\45\1\46\1\44",
            "\1\47",
            "\1\50",
            "\1\34",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\22\1\23\1\24\45\uffff\1\51",
            "\1\36",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\22\1\23\1\24\45\uffff\1\52",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\53\1\54",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\53\1\54",
            "\1\55",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\17",
            "\1\57\1\56",
            "\1\60",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\22\1\23\1\24",
            "\1\61",
            "\1\62",
            "\1\64\120\uffff\1\63",
            "\1\66\120\uffff\1\65",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14",
            "\1\45\1\46",
            "\1\45\1\46",
            "\1\45\1\46\1\67",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\22\1\23\1\24",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\22\1\23\1\24",
            "\1\64",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\53\1\54\46\uffff\1\70",
            "\1\66",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\53\1\54\46\uffff\1\71",
            "\1\73\1\72",
            "\1\74",
            "\1\75",
            "\1\45\1\46",
            "\1\45\1\46",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\53\1\54",
            "\1\14\16\uffff\1\14\3\uffff\1\14\1\uffff\1\5\3\14\1\uffff\1\14\3\uffff\1\14\2\uffff\2\14\5\uffff\1\14\3\uffff\1\53\1\54"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1024:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )";
        }
    }
    static final String dfa_8s = "\25\uffff";
    static final String dfa_9s = "\4\uffff\1\11\10\uffff\1\11\1\uffff\2\11\2\uffff\2\11";
    static final String dfa_10s = "\1\17\3\uffff\1\7\1\uffff\3\4\2\uffff\1\21\1\4\1\7\1\4\2\7\2\4\2\7";
    static final String dfa_11s = "\1\66\3\uffff\1\141\1\uffff\1\4\2\125\2\uffff\1\21\1\4\1\141\1\4\2\141\2\4\2\141";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\3\uffff\1\4\1\5\12\uffff";
    static final String dfa_13s = "\25\uffff}>";
    static final String[] dfa_14s = {
            "\1\2\40\uffff\1\1\1\3\1\4\3\uffff\1\5",
            "",
            "",
            "",
            "\1\11\10\uffff\1\6\5\uffff\1\11\3\uffff\1\11\1\uffff\6\11\3\uffff\1\11\2\uffff\2\11\5\uffff\1\11\3\uffff\1\7\1\10\1\12\51\uffff\3\11",
            "",
            "\1\13",
            "\1\15\120\uffff\1\14",
            "\1\17\120\uffff\1\16",
            "",
            "",
            "\1\20",
            "\1\15",
            "\1\11\16\uffff\1\11\3\uffff\1\11\1\uffff\6\11\3\uffff\1\11\2\uffff\2\11\5\uffff\1\11\3\uffff\1\7\1\10\1\12\45\uffff\1\21\3\uffff\3\11",
            "\1\17",
            "\1\11\16\uffff\1\11\3\uffff\1\11\1\uffff\6\11\3\uffff\1\11\2\uffff\2\11\5\uffff\1\11\3\uffff\1\7\1\10\1\12\45\uffff\1\22\3\uffff\3\11",
            "\1\11\16\uffff\1\11\3\uffff\1\11\1\uffff\6\11\3\uffff\1\11\2\uffff\2\11\5\uffff\1\11\3\uffff\1\7\1\10\1\12\51\uffff\3\11",
            "\1\23",
            "\1\24",
            "\1\11\16\uffff\1\11\3\uffff\1\11\1\uffff\6\11\3\uffff\1\11\2\uffff\2\11\5\uffff\1\11\3\uffff\1\7\1\10\1\12\51\uffff\3\11",
            "\1\11\16\uffff\1\11\3\uffff\1\11\1\uffff\6\11\3\uffff\1\11\2\uffff\2\11\5\uffff\1\11\3\uffff\1\7\1\10\1\12\51\uffff\3\11"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2690:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType )";
        }
    }
    static final String dfa_15s = "\12\uffff";
    static final String dfa_16s = "\3\uffff\1\7\1\10\4\uffff\1\7";
    static final String dfa_17s = "\1\4\2\uffff\2\7\1\uffff\1\5\2\uffff\1\7";
    static final String dfa_18s = "\1\175\2\uffff\2\143\1\uffff\1\5\2\uffff\1\143";
    static final String dfa_19s = "\1\uffff\1\1\1\2\2\uffff\1\5\1\uffff\1\3\1\4\1\uffff";
    static final String dfa_20s = "\12\uffff}>";
    static final String[] dfa_21s = {
            "\1\2\1\3\12\uffff\1\2\7\uffff\1\1\36\uffff\1\2\35\uffff\1\2\2\uffff\1\4\1\5\2\uffff\2\2\13\uffff\25\5",
            "",
            "",
            "\1\7\12\uffff\5\7\2\uffff\7\7\1\uffff\17\7\23\uffff\6\7\1\uffff\3\7\1\uffff\12\7\2\uffff\1\5\1\6\2\uffff\1\2\3\uffff\2\7",
            "\1\10\12\uffff\5\10\2\uffff\7\10\1\uffff\17\10\23\uffff\6\10\1\uffff\3\10\1\uffff\12\10\2\uffff\1\5\7\uffff\2\10",
            "",
            "\1\11",
            "",
            "",
            "\1\7\12\uffff\5\7\2\uffff\7\7\1\uffff\17\7\23\uffff\6\7\1\uffff\3\7\1\uffff\12\7\2\uffff\1\5\1\6\6\uffff\2\7"
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "5636:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )";
        }
    }
    static final String dfa_22s = "\13\uffff";
    static final String dfa_23s = "\1\5\2\132\5\uffff\1\5\1\151\1\132";
    static final String dfa_24s = "\1\175\1\133\1\132\5\uffff\1\5\1\175\1\133";
    static final String dfa_25s = "\3\uffff\1\1\1\2\1\3\1\4\1\5\3\uffff";
    static final String dfa_26s = "\13\uffff}>";
    static final String[] dfa_27s = {
            "\1\1\122\uffff\1\2\1\7\17\uffff\4\3\10\4\3\5\6\6",
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

    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = dfa_22;
            this.eof = dfa_22;
            this.min = dfa_23;
            this.max = dfa_24;
            this.accept = dfa_25;
            this.special = dfa_26;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "5808:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00008322E4402082L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00008322E4400082L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0047000000008020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000380000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800060L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0080000001010030L,0x3FFFFE0033202204L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0080000000010030L,0x0000000030200000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001C10000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000010L,0x0000000000200000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001C10000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000000C000200000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00007C0000040000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00007C0000000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00007C0000100000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000008000000002L,0x000001F000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0018000000010002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0038000000010000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0038000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000030000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x00000000000FC000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000020L,0x00001E0001000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0080000003010030L,0x3FFFFE0033202204L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000020L,0x001FE00001000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000020L,0x00E0000001000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000020L,0x3F00000001000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});

}
