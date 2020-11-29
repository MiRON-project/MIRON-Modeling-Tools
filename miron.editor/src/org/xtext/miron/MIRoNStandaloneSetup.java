package org.xtext.miron;

import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Injector;

import miron.metamodel.datatypes.DatatypesPackage;
import miron.metamodel.kernel.KernelPackage;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class MIRoNStandaloneSetup extends MIRoNStandaloneSetupGenerated {

	public static void doSetup() {  	  
		new MIRoNStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {

		if (!EPackage.Registry.INSTANCE.containsKey("https://robmosys.eu/miron/datatypes")) {
			EPackage.Registry.INSTANCE.put("https://robmosys.eu/miron/datatypes", DatatypesPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("https://robmosys.eu/miron/kernel")) {
			EPackage.Registry.INSTANCE.put("https://robmosys.eu/miron/kernel", KernelPackage.eINSTANCE);
		}
		
		return super.createInjectorAndDoEMFRegistration();
	}
}