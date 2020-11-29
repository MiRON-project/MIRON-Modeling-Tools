package org.xtext.behaviortree;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.xtext.behaviortree.naming.BehaviorTreeQualifiedNameProvider;

import com.google.inject.Binder;

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
    
    @Override
    public void configure(Binder binder) {
    	super.configure(binder);
    	
    	binder.bind(IDefaultResourceDescriptionStrategy.class).to(BTResourceDescriptionStrategy.class);
    }
    
    @Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return ImportUriGlobalScopeProvider.class;
	}
	
}