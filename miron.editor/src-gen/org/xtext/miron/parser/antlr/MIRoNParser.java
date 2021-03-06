/*
 * generated by Xtext 2.12.0
 */
package org.xtext.miron.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.miron.parser.antlr.internal.InternalMIRoNParser;
import org.xtext.miron.services.MIRoNGrammarAccess;

public class MIRoNParser extends AbstractAntlrParser {

	@Inject
	private MIRoNGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMIRoNParser createParser(XtextTokenStream stream) {
		return new InternalMIRoNParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "MironModel";
	}

	public MIRoNGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MIRoNGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
