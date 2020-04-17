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

import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;

/**
 * This class allows defining different highlighting styles. It basically 
 * associates a style with an ID that later is used in the lexical analysis 
 * (see <code>BTAntlrTokenToAttributeIdMapper</code>). This class needs to be bound in 
 * <code>RootUiModule</code>. 
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class BTHighlightingConfiguration implements IHighlightingConfiguration {

	/**
	 * First-level keywords. It is used for the most important keywords, 
	 * such as "context", "observation" and "property"
	 */
	public static final String KEYWORD_ID = "keyword";
	
	/**
	 * Second-level keywords
	 */
	public static final String SECOND_LEVEL_KEYWORD_ID = "keyword2";
	
	/**
	 * Identifies punctuation characters.
	 */
	public static final String PUNCTUATION_ID = "punctuation";
	
	/**
	 * Identifies comments.
	 */
	public static final String COMMENT_ID = "comment";
	
	/**
	 * Identifies strings.
	 */
	public static final String STRING_ID = "string";
	
	/**
	 * Identifies numbers.
	 */
	public static final String NUMBER_ID = "number";
	
	/**
	 * Default identifier. 
	 */
	public static final String DEFAULT_ID = "default";
	
	/**
	 * Identifies errors.
	 */
	public static final String INVALID_TOKEN_ID = "error";
	
	
	/**
	 * Establishes the mapping between the IDs and the method to defined the style.
	 */
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keyword1TextStyle());
		acceptor.acceptDefaultHighlighting(SECOND_LEVEL_KEYWORD_ID, "Second-level keyword", keyword2TextStyle());
		acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, "Punctuation character", punctuationTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());
		acceptor.acceptDefaultHighlighting(STRING_ID, "String", stringTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, "Invalid Symbol", errorTextStyle());
	}   
	
	/**
	 * Style definition for first-level keywords.
	 * @return text style.
	 */
	public TextStyle keyword1TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	/**
	 * Style definition for second-level keywords.
	 * @return text style.
	 */
	public TextStyle keyword2TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(142, 74, 25));
		return textStyle;
	}
	
	/**
	 * Style definition for errors.
	 * @return text style.
	 */
	public TextStyle errorTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}
	
	/**
	 * Style definition for numbers.
	 * @return text style.
	 */
	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}

	/**
	 * Style definition for strings.
	 * @return text style.
	 */
	public TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(69, 9, 244));
		return textStyle;
	}

	/**
	 * Style definition for comments.
	 * @return text style.
	 */
	public TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	/**
	 * Style definition for punctuation characters.
	 * @return text style.
	 */
	public TextStyle punctuationTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}
	
	/**
	 * Default style definition.
	 * @return text style.
	 */
	public TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
}

