/*
 * generated by Xtext 2.12.0
 */
package org.xtext.miron.ui;

import com.google.inject.Injector;
import miron.editor.ui.internal.EditorActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MIRoNExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return EditorActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return EditorActivator.getInstance().getInjector(EditorActivator.ORG_XTEXT_MIRON_MIRON);
	}
	
}
