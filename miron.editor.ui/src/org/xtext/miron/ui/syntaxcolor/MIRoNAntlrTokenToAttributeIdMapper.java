package org.xtext.miron.ui.syntaxcolor;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

import com.google.inject.Singleton;

/**
 * This class maps tokens obtained in the lexical analysis with concrete styles defined in 
 * <code>BTHightlightingConfiguration</code>. This class needs to be bound in 
 * <code>RootUiModule</code>. 
 * 
 */
@Singleton
public class MIRoNAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {
	
private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		
		String result = MIRoNHighlightingConfiguration.DEFAULT_ID;
		String aux;
		
		if(PUNCTUATION.matcher(tokenName).matches()) {
			result = MIRoNHighlightingConfiguration.PUNCTUATION_ID;
		}	
		else if(QUOTED.matcher(tokenName).matches()) {
			
			aux = tokenName.substring(1, tokenName.length()-1);
			
			if(isFirstLevelKeywork(aux)) {	
				result = MIRoNHighlightingConfiguration.KEYWORD_ID;
			}
			else if(isSecondLevelKeywork(aux)) {
				result = MIRoNHighlightingConfiguration.SECOND_LEVEL_KEYWORD_ID;
			}
			else if(isThirdLevelKeywork(aux)) {
				result = MIRoNHighlightingConfiguration.THIRD_LEVEL_KEYWORD_ID;
			}
			else if(isFourthLevelKeywork(aux)) {
				result = MIRoNHighlightingConfiguration.FOURTH_LEVEL_KEYWORD_ID;
			}
			else if(isFifthLevelKeywork(aux)) {
				result = MIRoNHighlightingConfiguration.FIFTH_LEVEL_KEYWORD_ID;
			}
		}
		else if("RULE_STRING".equals(tokenName)) {
			return MIRoNHighlightingConfiguration.STRING_ID;
		}
		else if("RULE_INT".equals(tokenName)) {
			return MIRoNHighlightingConfiguration.NUMBER_ID;
		}
		else if("RULE_ML_COMMENT".equals(tokenName) || "RULE_SL_COMMENT".equals(tokenName)) {
			return MIRoNHighlightingConfiguration.COMMENT_ID;
		}
		else if("RULE_ROQME_DESCRIPTION".equals(tokenName)) {
			return MIRoNHighlightingConfiguration.DESCRIPTION_ID;
		}
		return result;
	}
	
	private boolean isFirstLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("import")
				|| tokenName.equalsIgnoreCase("miron") 
				|| tokenName.equalsIgnoreCase("varpoint")
				|| tokenName.equalsIgnoreCase("as")
				|| tokenName.equalsIgnoreCase("in") 
				|| tokenName.equalsIgnoreCase("after")
				|| tokenName.equalsIgnoreCase("before")
				|| tokenName.equalsIgnoreCase("rule")
				|| tokenName.equalsIgnoreCase("implies")
				|| tokenName.equalsIgnoreCase("roqme")
				|| tokenName.equalsIgnoreCase("type")
				|| tokenName.equalsIgnoreCase("context")
				|| tokenName.equalsIgnoreCase("beliefvar")
				|| tokenName.equalsIgnoreCase("property")
				|| tokenName.equalsIgnoreCase("observation")
				|| tokenName.equalsIgnoreCase("var")
				|| tokenName.equalsIgnoreCase("timer")
				|| tokenName.equalsIgnoreCase("param")
				|| tokenName.equalsIgnoreCase("reinforces")
				|| tokenName.equalsIgnoreCase("undermines")
				|| tokenName.equalsIgnoreCase("sets")
				|| tokenName.equalsIgnoreCase("starts")
				|| tokenName.equalsIgnoreCase("stops")
				|| tokenName.equalsIgnoreCase("resumes")
				|| tokenName.equalsIgnoreCase("clears")
				|| tokenName.equalsIgnoreCase("preset")
				|| tokenName.equalsIgnoreCase("arch");
	}
	
	private boolean isSecondLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("number") 
				|| tokenName.equalsIgnoreCase("boolean") 
				|| tokenName.equalsIgnoreCase("integer") 
				|| tokenName.equalsIgnoreCase("time") 
				|| tokenName.equalsIgnoreCase("enum")
				|| tokenName.equalsIgnoreCase("eventtype");
	}
	
	private boolean isThirdLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("upper") 
				|| tokenName.equalsIgnoreCase("lower") 
				|| tokenName.equalsIgnoreCase("precision")
				|| tokenName.equalsIgnoreCase("unit")
				|| tokenName.equalsIgnoreCase("veryhigh")
				|| tokenName.equalsIgnoreCase("verylow")
				|| tokenName.equalsIgnoreCase("low")
				|| tokenName.equalsIgnoreCase("high")
				|| tokenName.equalsIgnoreCase("default")
				|| tokenName.equalsIgnoreCase("survival")
				|| tokenName.equalsIgnoreCase("reference")
				|| tokenName.equalsIgnoreCase("onetime")
				|| tokenName.equalsIgnoreCase("offset")
				|| tokenName.equalsIgnoreCase("paused")
				|| tokenName.equalsIgnoreCase("affects")
				|| tokenName.equalsIgnoreCase("parameterSetRepository")
				|| tokenName.equalsIgnoreCase("parameterSet")
				|| tokenName.equalsIgnoreCase("component")
				|| tokenName.equalsIgnoreCase("parameter");
	}
	
	private boolean isFourthLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("while") 
				|| tokenName.equalsIgnoreCase("once")
				|| tokenName.equalsIgnoreCase("repeat")
				|| tokenName.equalsIgnoreCase("range")
				|| tokenName.equalsIgnoreCase("schedule")
				|| tokenName.equalsIgnoreCase("pow")
				|| tokenName.equalsIgnoreCase("sqrt")
				|| tokenName.equalsIgnoreCase("exp")
				|| tokenName.equalsIgnoreCase("abs")
				|| tokenName.equalsIgnoreCase("avg")
				|| tokenName.equalsIgnoreCase("min")
				|| tokenName.equalsIgnoreCase("max")
				|| tokenName.equalsIgnoreCase("count")
				|| tokenName.equalsIgnoreCase("sum")
				|| tokenName.equalsIgnoreCase("increasing")
				|| tokenName.equalsIgnoreCase("decreasing")
				|| tokenName.equalsIgnoreCase("stable")
				|| tokenName.equalsIgnoreCase("eventWhen")
				|| tokenName.equalsIgnoreCase("update")
				|| tokenName.equalsIgnoreCase("period")
				|| tokenName.equalsIgnoreCase("first")
				|| tokenName.equalsIgnoreCase("last")
				|| tokenName.equalsIgnoreCase("at")
				|| tokenName.equalsIgnoreCase("size")
				|| tokenName.equalsIgnoreCase("belief")
				|| tokenName.equalsIgnoreCase("and")
				|| tokenName.equalsIgnoreCase("or")
				|| tokenName.equalsIgnoreCase("not");
	}
	
	private boolean isFifthLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("true")
				|| tokenName.equalsIgnoreCase("false")
				|| tokenName.equalsIgnoreCase("event")
				|| tokenName.equalsIgnoreCase("milliseconds")
				|| tokenName.equalsIgnoreCase("seconds")
				|| tokenName.equalsIgnoreCase("minutes")
				|| tokenName.equalsIgnoreCase("hours")
				|| tokenName.equalsIgnoreCase("days")
				|| tokenName.equalsIgnoreCase("millisecond")
				|| tokenName.equalsIgnoreCase("second")
				|| tokenName.equalsIgnoreCase("minute")
				|| tokenName.equalsIgnoreCase("hour")
				|| tokenName.equalsIgnoreCase("day");
	}
}
