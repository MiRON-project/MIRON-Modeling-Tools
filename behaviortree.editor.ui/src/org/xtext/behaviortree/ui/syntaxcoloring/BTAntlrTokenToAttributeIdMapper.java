//  This file belongs to the RoQME toolchain.
//  Copyright (C) 2019  University of Extremadura, University of Málaga, Biometric Vox.
//
//  RoQME is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; either version 3 of the License, or
//  any later version.
//
//  RoQME is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  GNU GPLv3 link: http://www.gnu.org/licenses/gpl-3.0.html

package org.xtext.behaviortree.ui.syntaxcoloring;

import java.util.regex.Pattern;
import com.google.inject.Singleton;

import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

/**
 * This class maps tokens obtained in the lexical analysis with concrete styles defined in 
 * <code>BTHightlightingConfiguration</code>. This class needs to be bound in 
 * <code>RootUiModule</code>. 
 * 
 * @author Juan F. Ingles Romero
 */
@Singleton
public class BTAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {

	private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		String result = BTHighlightingConfiguration.DEFAULT_ID;
		String aux;

		if (PUNCTUATION.matcher(tokenName).matches()) {
			result = BTHighlightingConfiguration.PUNCTUATION_ID;
		} else if (QUOTED.matcher(tokenName).matches()) {

			aux = tokenName.substring(1, tokenName.length() - 1);

			if (isFirstLevelKeywork(aux)) {
				result = BTHighlightingConfiguration.KEYWORD_ID;
			} else if (isSecondLevelKeywork(aux)) {
				result = BTHighlightingConfiguration.SECOND_LEVEL_KEYWORD_ID;
			}
		} else if ("RULE_ID".equals(tokenName)) {
			return BTHighlightingConfiguration.SECOND_LEVEL_KEYWORD_ID;
		} else if ("RULE_SUBTREE_KEYWORD".equals(tokenName)) {
			return BTHighlightingConfiguration.KEYWORD_ID;
		} else if ("RULE_SUBTREEWRAPPER_KEYWORD".equals(tokenName)) {
			return BTHighlightingConfiguration.KEYWORD_ID;
		} else if ("RULE_SWITCH_KEYWORD".equals(tokenName)) {
			return BTHighlightingConfiguration.KEYWORD_ID;
		} else if ("RULE_STRING".equals(tokenName)) {
			return BTHighlightingConfiguration.STRING_ID;
		} else if ("RULE_INT".equals(tokenName)) {
			return BTHighlightingConfiguration.NUMBER_ID;
		} else if ("RULE_ML_COMMENT".equals(tokenName) || "RULE_SL_COMMENT".equals(tokenName)) {
			return BTHighlightingConfiguration.COMMENT_ID;
		}
		return result;
	}
	
	private boolean isFirstLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("root")
				|| tokenName.equalsIgnoreCase("include")
				|| tokenName.equalsIgnoreCase("behaviortree")
				|| tokenName.equalsIgnoreCase("subtree")
				|| tokenName.equalsIgnoreCase("SubTreeWrapper")				
				|| tokenName.equalsIgnoreCase("sequence")
				|| tokenName.equalsIgnoreCase("sequencestar")
				|| tokenName.equalsIgnoreCase("switch")				
				|| tokenName.equalsIgnoreCase("fallback")
				|| tokenName.equalsIgnoreCase("fallbackstar")
				|| tokenName.equalsIgnoreCase("parallel")
				|| tokenName.equalsIgnoreCase("forcefailure")
				|| tokenName.equalsIgnoreCase("forcesuccess")
				|| tokenName.equalsIgnoreCase("repeat")
				|| tokenName.equalsIgnoreCase("inverter")
				|| tokenName.equalsIgnoreCase("timeout")
				|| tokenName.equalsIgnoreCase("RetryUntilSuccesful")
				|| tokenName.equalsIgnoreCase("BlackboardCheckDouble")
				|| tokenName.equalsIgnoreCase("BlackboardCheckInt")
				|| tokenName.equalsIgnoreCase("BlackboardCheckString")
				|| tokenName.equalsIgnoreCase("Condition")
				|| tokenName.equalsIgnoreCase("AlwaysSuccess")
				|| tokenName.equalsIgnoreCase("AlwaysFailure")
				|| tokenName.equalsIgnoreCase("SetBlackboard")
				|| tokenName.equalsIgnoreCase("Action");
	}
	
	private boolean isSecondLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("main_tree_to_execute") 
				|| tokenName.equalsIgnoreCase("path");
	}
}
