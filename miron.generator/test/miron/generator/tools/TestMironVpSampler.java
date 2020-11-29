package miron.generator.tools;

import org.junit.jupiter.api.Test;

import miron.metamodel.kernel.KernelFactory;
import miron.metamodel.kernel.VariationPoint;
import roqme.metamodel.datatypes.ContainedDeclaration;
import roqme.metamodel.datatypes.LowerBound;
import roqme.metamodel.datatypes.NumericValue;
import roqme.metamodel.datatypes.UpperBound;
import roqme.metamodel.kernel.Property;
import miron.metamodel.datatypes.MironModel;
import miron.metamodel.datatypes.NumericSampledType;
import miron.metamodel.datatypes.SampleValue;
import miron.generator.tools.MironVpSampler;
import miron.generator.tools.MironVpSampler.SamplerOptions;
import miron.metamodel.datatypes.BehaviorTreeEnumType;
import miron.metamodel.datatypes.BehaviorTreeLiteral;
import miron.metamodel.datatypes.DatatypesFactory;
import miron.metamodel.datatypes.ImpactIntensityEnum;
import miron.metamodel.datatypes.ImpactOnQuality;

public class TestMironVpSampler {

	@Test
	public void testSampleIntegerVarpoint() {
		
		MironModel model = createBtVarpointModel();//createIntVarpointModel();
		MironVpSampler sampler = new MironVpSampler(
				SamplerOptions.OPT_OUTPUT_FILEPATH, "/Users/jfingles/Downloads/results.txt",
				SamplerOptions.OPT_NUM_X_POINTS, "100");
		
		sampler.process(model);
		
	}
	
	private MironModel createBtVarpointModel() {

		// Factories
		roqme.metamodel.kernel.KernelFactory roqmeKernelFactory 
				= roqme.metamodel.kernel.KernelFactory.eINSTANCE;
		roqme.metamodel.datatypes.DatatypesFactory roqmeDatatypesFactory 
				= roqme.metamodel.datatypes.DatatypesFactory.eINSTANCE;
		KernelFactory mironKernelFactory = KernelFactory.eINSTANCE;
		DatatypesFactory mironDatatypesFactory = DatatypesFactory.eINSTANCE;
	
		// Property 1
		Property property1 = roqmeKernelFactory.createProperty();
		property1.setName("property1");
		property1.setDeclaration(roqmeDatatypesFactory.createInbuiltDeclaration());
		
		// Property 2
		Property property2 = roqmeKernelFactory.createProperty();
		property2.setName("property2");
		property2.setDeclaration(roqmeDatatypesFactory.createInbuiltDeclaration());
		
		// Type
		BehaviorTreeEnumType btEnumType = DatatypesFactory.eINSTANCE.createBehaviorTreeEnumType();
		
		// Alternative 1
		BehaviorTreeLiteral lit1 = DatatypesFactory.eINSTANCE.createBehaviorTreeLiteral();
		lit1.setName("Option1");
		btEnumType.getLiterals().add(lit1);
		
		ImpactOnQuality impactProp11 = mironDatatypesFactory.createImpactOnQuality();
		impactProp11.setIntensity(ImpactIntensityEnum.POSITIVE_HIGH);
		impactProp11.setProperty(property1);
		lit1.getImpacts().add(impactProp11);
		
		ImpactOnQuality impactProp12 = mironDatatypesFactory.createImpactOnQuality();
		impactProp12.setIntensity(ImpactIntensityEnum.POSITIVE_HIGH);
		impactProp12.setProperty(property2);
		lit1.getImpacts().add(impactProp12);
		
		// Alternative 2
		BehaviorTreeLiteral lit2 = DatatypesFactory.eINSTANCE.createBehaviorTreeLiteral();
		lit2.setName("Option2");
		btEnumType.getLiterals().add(lit2);
		
		ImpactOnQuality impactProp21 = mironDatatypesFactory.createImpactOnQuality();
		impactProp21.setIntensity(ImpactIntensityEnum.POSITIVE_HIGH);
		impactProp21.setProperty(property1);
		lit2.getImpacts().add(impactProp21);
		
		ImpactOnQuality impactProp22 = mironDatatypesFactory.createImpactOnQuality();
		impactProp22.setIntensity(ImpactIntensityEnum.POSITIVE_HIGH);
		impactProp22.setProperty(property2);
		lit2.getImpacts().add(impactProp22);
		
		// Alternative 3
		BehaviorTreeLiteral lit3 = DatatypesFactory.eINSTANCE.createBehaviorTreeLiteral();
		lit3.setName("Option3");
		btEnumType.getLiterals().add(lit3);
				
		ImpactOnQuality impactProp31 = mironDatatypesFactory.createImpactOnQuality();
		impactProp31.setIntensity(ImpactIntensityEnum.POSITIVE_HIGH);
		impactProp31.setProperty(property1);
		lit3.getImpacts().add(impactProp31);
				
		ImpactOnQuality impactProp32 = mironDatatypesFactory.createImpactOnQuality();
		impactProp32.setIntensity(ImpactIntensityEnum.POSITIVE_HIGH);
		impactProp32.setProperty(property2);
		lit3.getImpacts().add(impactProp32);
		
		// Data type declaration
		ContainedDeclaration dataTypeDeclaration = roqmeDatatypesFactory.createContainedDeclaration();
		dataTypeDeclaration.setType(btEnumType);		
		
		// Varpoint
		VariationPoint varpoint1 = mironKernelFactory.createVariationPoint();
		varpoint1.setName("vp1");
		varpoint1.setDeclaration(dataTypeDeclaration);
		
		// Default value ? //TODO
		
		// Miron model
		MironModel model = mironDatatypesFactory.createMironModel();
		model.getVariables().add(property1);
		model.getVariables().add(property2);
		model.getVariables().add(varpoint1);
				
		return model;
	}
	
	private MironModel createNumericVarpointModel() {

		// Factories
		roqme.metamodel.kernel.KernelFactory roqmeKernelFactory 
				= roqme.metamodel.kernel.KernelFactory.eINSTANCE;
		roqme.metamodel.datatypes.DatatypesFactory roqmeDatatypesFactory 
				= roqme.metamodel.datatypes.DatatypesFactory.eINSTANCE;
		KernelFactory mironKernelFactory = KernelFactory.eINSTANCE;
		DatatypesFactory mironDatatypesFactory = DatatypesFactory.eINSTANCE;
	
		// Property 1
		Property property1 = roqmeKernelFactory.createProperty();
		property1.setName("property1");
		property1.setDeclaration(roqmeDatatypesFactory.createInbuiltDeclaration());
		
		// Property 2
		Property property2 = roqmeKernelFactory.createProperty();
		property2.setName("property2");
		property2.setDeclaration(roqmeDatatypesFactory.createInbuiltDeclaration());
		
		// Sampled type
		NumericSampledType numericSampledType = DatatypesFactory.eINSTANCE.createNumericSampledType();
		LowerBound lowerBound = roqmeDatatypesFactory.createLowerBound();
		UpperBound upperBound = roqmeDatatypesFactory.createUpperBound();
		lowerBound.setValue(-3);
		upperBound.setValue(15);
		numericSampledType.getConstraints().add(lowerBound);
		numericSampledType.getConstraints().add(upperBound);
		
		// Data type declaration
		ContainedDeclaration dataTypeDeclaration = roqmeDatatypesFactory.createContainedDeclaration();
		dataTypeDeclaration.setType(numericSampledType);
		
		// Varpoint
		VariationPoint varpoint1 = mironKernelFactory.createVariationPoint();
		varpoint1.setName("vp1");
		varpoint1.setDeclaration(dataTypeDeclaration);
		
		// Sample 1
		SampleValue sample1 = mironDatatypesFactory.createSampleValue();
		NumericValue value1 = roqmeDatatypesFactory.createNumericValue();
		value1.setValue(0);
		sample1.setValue(value1);
		
		ImpactOnQuality impactProp11 = mironDatatypesFactory.createImpactOnQuality();
		impactProp11.setIntensity(ImpactIntensityEnum.POSITIVE_HIGH);
		impactProp11.setProperty(property1);
		sample1.getImpacts().add(impactProp11);
		
		ImpactOnQuality impactProp12 = mironDatatypesFactory.createImpactOnQuality();
		impactProp12.setIntensity(ImpactIntensityEnum.NEGATIVE_HIGH);
		impactProp12.setProperty(property2);
		sample1.getImpacts().add(impactProp12);
		
		numericSampledType.getSamples().add(sample1);
		
		// Sample 2
		SampleValue sample2 = mironDatatypesFactory.createSampleValue();
		NumericValue value2 = roqmeDatatypesFactory.createNumericValue();
		value2.setValue(10.2);
		sample2.setValue(value2);
		
		ImpactOnQuality impactProp21 = mironDatatypesFactory.createImpactOnQuality();
		impactProp21.setIntensity(ImpactIntensityEnum.POSITIVE_LOW);
		impactProp21.setProperty(property1);
		sample2.getImpacts().add(impactProp21);
		
		ImpactOnQuality impactProp22 = mironDatatypesFactory.createImpactOnQuality();
		impactProp22.setIntensity(ImpactIntensityEnum.POSITIVE_LOW);
		impactProp22.setProperty(property2);
		sample2.getImpacts().add(impactProp22);
		
		numericSampledType.getSamples().add(sample2);
		
		// Sample 3
		SampleValue sample3 = mironDatatypesFactory.createSampleValue();
		NumericValue value3 = roqmeDatatypesFactory.createNumericValue();
		value3.setValue(15);
		sample3.setValue(value3);
				
		ImpactOnQuality impactProp31 = mironDatatypesFactory.createImpactOnQuality();
		impactProp31.setIntensity(ImpactIntensityEnum.NEGATIVE_LOW);
		impactProp31.setProperty(property1);
		sample3.getImpacts().add(impactProp31);
				
		ImpactOnQuality impactProp32 = mironDatatypesFactory.createImpactOnQuality();
		impactProp32.setIntensity(ImpactIntensityEnum.NEUTRAL);
		impactProp32.setProperty(property2);
		sample3.getImpacts().add(impactProp32);
				
		numericSampledType.getSamples().add(sample3);
		
		// Miron model
		MironModel model = mironDatatypesFactory.createMironModel();
		model.getVariables().add(property1);
		model.getVariables().add(property2);
		model.getVariables().add(varpoint1);
		
		return model;
	}	
}
