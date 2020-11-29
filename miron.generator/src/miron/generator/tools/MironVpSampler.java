package miron.generator.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;

import miron.metamodel.datatypes.BehaviorTreeEnumType;
import miron.metamodel.datatypes.BehaviorTreeLiteral;
import miron.metamodel.datatypes.ImpactIntensityEnum;
import miron.metamodel.datatypes.ImpactOnQuality;
import miron.metamodel.datatypes.MironModel;
import miron.metamodel.datatypes.NumericSampledType;
import miron.metamodel.datatypes.SampleValue;
import miron.metamodel.kernel.VariationPoint;
import roqme.metamodel.datatypes.ContainedDeclaration;
import roqme.metamodel.datatypes.DataType;
import roqme.metamodel.datatypes.LowerBound;
import roqme.metamodel.datatypes.NumericType;
import roqme.metamodel.datatypes.NumericTypeConstraint;
import roqme.metamodel.datatypes.Precision;
import roqme.metamodel.datatypes.ReferencedDeclaration;
import roqme.metamodel.datatypes.RoqmeModel;
import roqme.metamodel.datatypes.TypedVariable;
import roqme.metamodel.datatypes.UpperBound;
import roqme.metamodel.kernel.Property;

public class MironVpSampler {

	private final Logger LOGGER = new Logger();//LoggerFactory.getLogger(MironVpSampler.class);
	
	private final static double MAX_UTILITY = 100;
	private final static double MIN_UTILITY = 0;
	
	private SamplerOptions options;
	private HashMap<String, Vector<Object>> results;
	
	
	public MironVpSampler(String... options) {
		this.options = new SamplerOptions(options);
		results = new HashMap<>();
	}
	
	public void process(MironModel model) {
		for(TypedVariable var : model.getVariables()) {
			if(var instanceof VariationPoint) {
				sampleVarpoint((VariationPoint)var);
			}
		}
		saveAll();
	}
	
	protected void sampleVarpoint(VariationPoint varpoint) {

		DataType dataType = getDataType(varpoint);
		
		if(dataType instanceof NumericType) {
			sampleRealVarpoint(varpoint);
		}
		else if(dataType instanceof BehaviorTreeEnumType) {
			sampleEnumVarpoint(varpoint);
		}
	}
	
	protected void saveAll() {
		
		String outputPath = options.get(SamplerOptions.OPT_OUTPUT_FILEPATH, String.class);

		try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
		
			StringBuilder builder = new StringBuilder();
			Formatter fmt = new Formatter(builder, Locale.ROOT);
			Vector<Object> vector;
			String valueFormat;
			String[] encloserFormat;
			
			for(String key : results.keySet()) {
				vector = results.get(key);
				
				if(vector.size() == 1) {
					fmt.format("%s = " + getValueFormat(vector.get(0)) + ";%n", key, vector.get(0));
				}
				else if(vector.size() > 1) {
					valueFormat = getValueFormat(vector.get(0));
					encloserFormat = getEncloserFormat(vector.get(0));
					
					fmt.format("%s = %s", key, encloserFormat[0]);
					for(int i=0; i<vector.size()-1; i++) {
						fmt.format(valueFormat + ",", vector.get(i));
					}
					fmt.format(valueFormat + "%s;%n", vector.lastElement(), encloserFormat[1]);
				}
			}
		    writer.write(builder.toString());
		    writer.close();
		    fmt.close();
		} catch (IOException e) {
			LOGGER.error("Error while writing the results: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private String getValueFormat(Object value) {
		String result = null;
		if(value instanceof Integer
				|| value instanceof Long
				|| value instanceof Short) 
		{
			result = "%d";
		}
		else if(value instanceof Double
				|| value instanceof Float) 
		{
			result = "%.4f";
		}
		else if(value instanceof String) {
			result = "%s";
		}
		return result;
	}
	
	private String[] getEncloserFormat(Object value) {
		String[] result;
		
		if(value instanceof String) {
			result = new String[] {"{", "}"};
		}
		else {
			result = new String[] {"[", "]"};
		}
		return result;
	}
	
	protected void sampleRealVarpoint(VariationPoint varpoint) {

		assert getDataType(varpoint) instanceof NumericType 
			: "Wrong data type for variation point";
		
		NumericType dataType = (NumericType) getDataType(varpoint);
		
		Double lowerBound = getLowerBound(dataType);
		Double upperBound = getUpperBound(dataType);
		Double precision  = getPrecision(dataType);

		if(lowerBound == null || upperBound == null) {
			LOGGER.error("Variation point is unbounded");
			throw new IllegalStateException("Variation point is unbounded");
		}

		// Resolving precision
		if(precision == null) {
			Double maxXResolution = options.get(SamplerOptions.OPT_MAX_X_RESOLUTION, Double.class);
			Integer N = maxXResolution != null ? 
					(int) Math.ceil((upperBound - lowerBound) / maxXResolution) :
					options.get(SamplerOptions.OPT_NUM_X_POINTS, Integer.class);
			
			assert N != null : "The max resolution or the number of points has not been configured";
			
			precision = (upperBound - lowerBound) / N;
		}
		
		// x-axis
		Vector<Object> x_val = getVarpointVector(varpoint);
		double x = lowerBound;
		while(x<=upperBound) {
			x_val.add(x);
			x += precision;
		}
		
		// length
		Vector<Object> n_val = getLengthVector(varpoint);
		n_val.add(x_val.size());

		if(dataType instanceof NumericSampledType) {
			// y-axis		
			for(SampleValue sample : getSortedNumericSamples((NumericSampledType)dataType)) {
				fillUtilityVector(varpoint, sample);
			}
			closeUtilityVectors(varpoint);
		}
	}
	
	protected void sampleEnumVarpoint(VariationPoint varpoint) {
		
		assert getDataType(varpoint) instanceof BehaviorTreeEnumType 
			: "Wrong data type for variation point";
		
		BehaviorTreeEnumType dataType = (BehaviorTreeEnumType) getDataType(varpoint);
		Vector<Object> utility;
		Vector<Object> x_val = getVarpointVector(varpoint);
		Vector<Object> labels = getLabelVector(varpoint);
		ImpactOnQuality impact;
		int i, idx = 0;
		boolean found;
		List<Property> properties = new ArrayList<>();
		
		// Gathering properties
		for(BehaviorTreeLiteral opt : dataType.getLiterals()) {
			for(ImpactOnQuality imp : opt.getImpacts()) {
				found = false;
				i = 0;
				while(!found && i<properties.size()) {
					found = properties.get(i).hashCode() == imp.getProperty().hashCode();
					i++;
				}
				if(!found) {
					properties.add(imp.getProperty());
				}
			}
		}
		
		for(BehaviorTreeLiteral opt : dataType.getLiterals()) {
			for(Property property : properties) {
				utility = getUtilityVector(varpoint, property);

				if((impact = getImpactByProperty(property, opt.getImpacts())) != null) {
					utility.add(getIntensityValue(impact.getIntensity()));
				}
				else {
					utility.add(getIntensityValue(ImpactIntensityEnum.NEUTRAL));
				}
			}			
			x_val.add(idx++);
			labels.add(opt.getName()); // TODO Check what needs to be sent to identify the alternative
		}
		// length
		Vector<Object> n_val = getLengthVector(varpoint);
		n_val.add(x_val.size());
	}
	
	private ImpactOnQuality getImpactByProperty(Property property, EList<ImpactOnQuality> impacts) {
		ImpactOnQuality result = null;
		boolean found = false;
		int i = 0;
		
		while(!found && i<impacts.size()) {
			if(found = impacts.get(i).getProperty().hashCode() == property.hashCode()) {
				result = impacts.get(i);
			}
			i++;
		}
		return result;
	}
	
	private void fillUtilityVector(VariationPoint varpoint, SampleValue sample) {
		Vector<Object> utility;
		Vector<Object> x = getVarpointVector(varpoint);
		int idx = 0;
		assert x!=null : "X-axis not found";
		
		for(ImpactOnQuality impact : sample.getImpacts()) {
			utility = getUtilityVector(varpoint, impact.getProperty());
			idx = findSampleIndex(x, sample.getValue().getValue());
			
			if(utility.size() == 0) {
				utility.add(getIntensityValue(ImpactIntensityEnum.NEUTRAL));
			}
			if(idx == 0) {
				utility.set(0, getIntensityValue(impact.getIntensity()));
			}
			else {
				addIntepolation(x, utility, sample, impact.getIntensity());
			}
		}
	}
	
	private void closeUtilityVectors(VariationPoint varpoint) {
		
		Vector<Object> x = getVarpointVector(varpoint);
		assert x!=null : "X-axis not found";
		
		for(Vector<Object> utility : getUtilityVectors(varpoint)) {
			closeInterpolation(x, utility);
		}
	}
	
	private void addIntepolation(Vector<Object> x, Vector<Object> utility, SampleValue sample, ImpactIntensityEnum intensity) {
		
		assert x.size() > 0 && x.get(0) instanceof Number;
		assert utility.size() > 0 && utility.get(0) instanceof Double;
		
		double prev_val = (Double) utility.lastElement();
		double curr_val = getIntensityValue(intensity);
		int prev_ind = utility.size()-1;
		int curr_ind = findSampleIndex(x, sample.getValue().getValue());
		
		for(int i=0; i<curr_ind-prev_ind; i++) {
			utility.add((curr_val - prev_val) / (double) (curr_ind - prev_ind) * (double) (i+1) + prev_val);
		}
	}
	
	private void closeInterpolation(Vector<Object> x, Vector<Object> utility) {
		
		assert x.size() > 0 && x.get(0) instanceof Number;
		assert utility.size() > 0 && utility.get(0) instanceof Double;
		
		double prev_val = (Double) utility.lastElement();
		double curr_val = getIntensityValue(ImpactIntensityEnum.NEUTRAL);
		int prev_ind = utility.size()-1;
		int curr_ind = x.size()-1;
		
		for(int i=0; i<curr_ind-prev_ind; i++) {
			utility.add((curr_val - prev_val) / (double) (curr_ind - prev_ind) * (double) (i+1) + prev_val);
		}
	}
	
	private Integer findSampleIndex(Vector<Object> x, double value) {
		assert x.size() > 0 && x.get(0) instanceof Number;
		Integer result = null;
		double error, minError = Double.MAX_VALUE;
		
		if(value < ((Number)x.firstElement()).doubleValue()) {
			result = 0;
		}
		else if(value > ((Number)x.lastElement()).doubleValue()) {
			result = x.size()-1;
		}
		else {
			for(int i=0; i<x.size(); i++) {
				if((error = Math.abs(value - ((Number)x.get(i)).doubleValue())) < minError) {
					minError = error;
					result = i;
				}
			}	
		}
		return result;
	}
		
	protected Vector<Object> getVarpointVector(VariationPoint varpoint) {		
		Vector<Object> vector;
		String key = varpoint.getName() + "_x";
		
		if(results.containsKey(key)) {
			vector = results.get(key);
		}
		else {
			vector = new Vector<Object>();
			results.put(key, vector);
		}
		return vector;
	}
	
	protected Vector<Object> getLengthVector(VariationPoint varpoint) {		
		Vector<Object> vector;
		String key = varpoint.getName() + "_n";
		
		if(results.containsKey(key)) {
			vector = results.get(key);
		}
		else {
			vector = new Vector<Object>();
			results.put(key, vector);
		}
		return vector;
	}
	
	protected Vector<Object> getLabelVector(VariationPoint varpoint) {		
		Vector<Object> vector;
		String key = varpoint.getName() + "_lbl";
		
		if(results.containsKey(key)) {
			vector = results.get(key);
		}
		else {
			vector = new Vector<Object>();
			results.put(key, vector);
		}
		return vector;
	}
	
	protected List<Vector<Object>> getUtilityVectors(VariationPoint varpoint) {
		List<Vector<Object>> vectors = new ArrayList<>();
		
		for(String key : results.keySet()) {
			if(key.startsWith(varpoint.getName() + "_y_")) {
				vectors.add(results.get(key));
			}
		}
		return vectors;
	}
	
	protected Vector<Object> getUtilityVector(VariationPoint varpoint, Property property) {
		Vector<Object> vector;
		String key = varpoint.getName() + "_y_" + getPropertyName(property);
		
		if(results.containsKey(key)) {
			vector = results.get(key);
		}
		else {
			vector = new Vector<Object>();
			results.put(key, vector);
		}
		return vector;
	}
	
	private String getPropertyName(Property property) {
		String result = property.getName();
		
		if(property.eContainer() instanceof RoqmeModel) {
			String namespace = ((RoqmeModel) property.eContainer()).getNamespace();
			if(!namespace.isEmpty()) {
				result = namespace + "_" + result;
			}
		}
		return result;
	}
	
	private double getIntensityValue(ImpactIntensityEnum intensity) {		
		return ((double) MAX_UTILITY - (double) MIN_UTILITY) / 6.0f
				* (double) intensity.getValue() + (double) MIN_UTILITY;
	}
	
	private List<SampleValue> getSortedNumericSamples(NumericSampledType dataType) {

		List<SampleValue> result = new ArrayList<SampleValue>();
		for(SampleValue sample : dataType.getSamples()) {
			result.add(sample);
		}
		Collections.sort(result, new Comparator<SampleValue>() {
			@Override
			public int compare(SampleValue o1, SampleValue o2) {
				return (o1.getValue().getValue() < o2.getValue().getValue()) ? -1 : 
					(o1.getValue().getValue() > o2.getValue().getValue()) ? 1 : 0;
			}
		});
		return result;
	}
	
	private Double getLowerBound(NumericType numericType) {
		Double lowerBound = null;
		NumericTypeConstraint constraint = null; 
		Iterator<NumericTypeConstraint> it = numericType.getConstraints().iterator();
		
		while(it.hasNext() && lowerBound == null) {
			if((constraint = it.next()) instanceof LowerBound) {
				lowerBound = ((LowerBound) constraint).getValue();
			}
		}
		return lowerBound;
	}
	
	private Double getUpperBound(NumericType numericType) {
		Double upperBound = null;
		NumericTypeConstraint constraint = null; 
		Iterator<NumericTypeConstraint> it = numericType.getConstraints().iterator();
		
		while(it.hasNext() && upperBound == null) {
			if((constraint = it.next()) instanceof UpperBound) {
				upperBound = ((UpperBound) constraint).getValue();
			}
		}
		return upperBound;
	}
	
	private Double getPrecision(NumericType numericType) {
		Double precision = null;
		NumericTypeConstraint constraint = null; 
		Iterator<NumericTypeConstraint> it = numericType.getConstraints().iterator();
		
		while(it.hasNext() && precision == null) {
			if((constraint = it.next()) instanceof Precision) {
				precision = ((Precision) constraint).getValue();
			}
		}
		return precision;
	}
	
	private DataType getDataType(VariationPoint varpoint) {
		DataType result = null;
		
		if(varpoint.getDeclaration() instanceof ReferencedDeclaration) {
			result = ((ReferencedDeclaration) varpoint.getDeclaration()).getType().getDataType();
		}
		else if(varpoint.getDeclaration() instanceof ContainedDeclaration) {
			result = ((ContainedDeclaration) varpoint.getDeclaration()).getType();
		}
		return result;
	}
	
	
	public class SamplerOptions {
		
		public static final String OPT_MAX_X_RESOLUTION  = "max_x_resolution";
		public static final String OPT_NUM_X_POINTS  	 = "num_x_points";
		public static final String OPT_OUTPUT_FILEPATH 	 = "output_filepath";
		
		private Map<String, Object> options;

		public SamplerOptions(String opts []) {
			if(isValid(opts)) {
				options = mapOf(opts);
			}
			else {
				throw new IllegalArgumentException("Invalid sampler options");
			}
		}
		
		@SuppressWarnings("unchecked")
		public <T> T get(String opt, Class<T> type) {
			
			Object result = options.get(opt);
			
			if(result != null && type.isAssignableFrom(result.getClass())) {
				return (T) result;
			}
			else {
				return null;
			}
		}
		
		protected Map<String, Object> mapOf(String opts []) {
			HashMap<String, Object> result = new HashMap<String, Object>();

			for(int i=0; i<opts.length; i+=2) {
				result.put((String) opts[i], parseOptValue(opts[i], opts[i+1]));
			}
			return result;
		}
		
		protected boolean isValid(String opts[]) {
			boolean isValid = opts.length % 2 == 0;		
			int i=0;
			
			while(isValid && i<opts.length) {
				isValid &= isValid(opts[i], opts[i+1]);
				i+=2;
			}
			return isValid;
		}
		
		protected boolean isValid(String name, String value) {
			boolean isValid = true;
			
			if(!(value != null && !value.isEmpty())) {
				LOGGER.error("Parameter value null or empty");
				isValid = false;
			}
			else if(OPT_MAX_X_RESOLUTION.equalsIgnoreCase(name)
					&& !(isValidNumber(value, Double.class) && Double.valueOf(value) > 0)) 
			{
				LOGGER.error("Invalid number for the parameter \"" + name + "\"");
				isValid = false;
			}
			else if(OPT_NUM_X_POINTS.equalsIgnoreCase(name)
					&& !(isValidNumber(value, Integer.class) && Integer.valueOf(value) > 0)) 
			{
				LOGGER.error("Invalid number for the parameter \"" + name + "\"");
				isValid = false;
			}
			return isValid;
		}
		
		protected boolean isValidFile(String path) {
			File file = new File(path);
			return file != null && file.exists() && file.isFile();
		}
		
		protected boolean isValidBoolean(String value) {		
			return value != null && !value.isEmpty() 
					&& value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
		}
		
		protected boolean isValidNumber(String value, Class<? extends Number> type) {		
			boolean result = false;
			
			try {
				if(value != null && !value.isEmpty()) {
					type.getMethod("valueOf", String.class).invoke(null, value);
					result = true;
				}
			} catch (Exception e) {}
			return result;
		}
	
		protected Object parseOptValue(String name, String value) {
			switch(name) {
						
			case OPT_MAX_X_RESOLUTION:
				return Double.valueOf(value);
				
			case OPT_NUM_X_POINTS:
				return Integer.valueOf(value);
				
			case OPT_OUTPUT_FILEPATH:
				return value;

			default:
				return value;
			}
		}
	}
	
	public class Logger {
		public void error(String msj) {
			System.out.println("[MironVpSampler] Error: " + msj);
		}
		public void warn(String msj) {
			System.out.println("[MironVpSampler] Warn: " + msj);
		}
	}
}
