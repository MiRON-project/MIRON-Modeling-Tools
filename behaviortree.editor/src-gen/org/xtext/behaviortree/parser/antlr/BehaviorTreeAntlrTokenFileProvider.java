/*
 * generated by Xtext 2.16.0
 */
package org.xtext.behaviortree.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class BehaviorTreeAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/xtext/behaviortree/parser/antlr/internal/InternalBehaviorTreeParser.tokens");
	}
}
