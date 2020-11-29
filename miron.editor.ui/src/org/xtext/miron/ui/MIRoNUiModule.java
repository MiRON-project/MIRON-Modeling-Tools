package org.xtext.miron.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.xtext.miron.ui.autoedit.MIRoNAutoEditStrategyProvider;
import org.xtext.miron.ui.syntaxcolor.MIRoNAntlrTokenToAttributeIdMapper;
import org.xtext.miron.ui.syntaxcolor.MIRoNHighlightingConfiguration;

import com.google.inject.Binder;

public class MIRoNUiModule extends AbstractMIRoNUiModule {

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration;
	  
	public MIRoNUiModule(final AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return MIRoNHighlightingConfiguration.class;
	}

	public void configureAbstractAntlrTokenToAttributeIdMapper(Binder binder) {
		binder.bind(AbstractAntlrTokenToAttributeIdMapper.class).to(MIRoNAntlrTokenToAttributeIdMapper.class);
	}
	
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return MIRoNAutoEditStrategyProvider.class;
	}
	
}
