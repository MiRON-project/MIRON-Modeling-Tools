package org.xtext.miron;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.xtext.roqme.naming.RoQMEQualifiedNameConverter;
import org.xtext.roqme.naming.RoQMEQualifiedNameProvider;
import org.xtext.roqme.scoping.RoQMEImportUriScopeProvider;


/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class MIRoNRuntimeModule extends AbstractMIRoNRuntimeModule {
	public MIRoNRuntimeModule() {
		super();
	}
	
	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return RoQMEQualifiedNameConverter.class;
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return RoQMEQualifiedNameProvider.class;
	}
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return RoQMEImportUriScopeProvider.class;
	}
}

