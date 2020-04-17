package org.xtext.behaviortree.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.xtext.behaviortree.ui.syntaxcoloring.BTAntlrTokenToAttributeIdMapper;
import org.xtext.behaviortree.ui.syntaxcoloring.BTHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

import com.google.inject.Binder;


/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class BehaviorTreeUiModule extends AbstractBehaviorTreeUiModule {
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration;
  
	public BehaviorTreeUiModule(final AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return BTHighlightingConfiguration.class;
	}

	public void configureAbstractAntlrTokenToAttributeIdMapper(Binder binder) {
		binder.bind(AbstractAntlrTokenToAttributeIdMapper.class).to(BTAntlrTokenToAttributeIdMapper.class);
	}
}