package org.xtext.behaviortree;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.xtext.behaviortree.naming.BehaviorTreeQualifiedNameProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class BehaviorTreeRuntimeModule extends AbstractBehaviorTreeRuntimeModule {
	
	public BehaviorTreeRuntimeModule() {
		super();
	}

    @Override
    public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
        return BehaviorTreeQualifiedNameProvider.class;
    }
}