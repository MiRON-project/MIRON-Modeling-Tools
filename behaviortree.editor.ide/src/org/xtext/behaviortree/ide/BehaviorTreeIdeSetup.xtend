/*
 * generated by Xtext 2.12.0
 */
package org.xtext.behaviortree.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.xtext.behaviortree.BehaviorTreeRuntimeModule
import org.xtext.behaviortree.BehaviorTreeStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class BehaviorTreeIdeSetup extends BehaviorTreeStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new BehaviorTreeRuntimeModule, new BehaviorTreeIdeModule))
	}
	
}
