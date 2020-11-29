package org.xtext.miron.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class MIRoNAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(new MIRoNAutoEditStrategy(), IDocument.DEFAULT_CONTENT_TYPE);
	}
}
