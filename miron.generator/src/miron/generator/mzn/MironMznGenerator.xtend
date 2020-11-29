package miron.generator.mzn

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import miron.metamodel.datatypes.MironModel
import miron.metamodel.kernel.VariationPoint
import roqme.metamodel.datatypes.RoqmeModel
import roqme.metamodel.datatypes.ReferencedDeclaration
import roqme.metamodel.datatypes.ContainedDeclaration
import miron.metamodel.datatypes.BehaviorTreeEnumType
import miron.metamodel.datatypes.NumericSampledType
import miron.metamodel.datatypes.ImpactOnQuality
import roqme.metamodel.kernel.Property
import java.util.List
import miron.metamodel.datatypes.QoSProfiledValue
import miron.generator.MironGenerator
import roqme.metamodel.datatypes.LowerBound
import java.util.Iterator
import roqme.metamodel.datatypes.NumericType
import roqme.metamodel.datatypes.NumericTypeConstraint
import roqme.metamodel.datatypes.UpperBound
import java.util.Formatter
import miron.metamodel.kernel.Rule
import roqme.metamodel.expressions.Term
import roqme.metamodel.expressions.ConstTerm
import roqme.metamodel.datatypes.NumericValue
import roqme.metamodel.datatypes.BooleanValue
import roqme.metamodel.datatypes.EnumValue
import roqme.metamodel.expressions.BinaryTermOp
import roqme.metamodel.expressions.AddTerm
import roqme.metamodel.expressions.SubTerm
import roqme.metamodel.expressions.MultTerm
import roqme.metamodel.expressions.DivTerm
import roqme.metamodel.expressions.ModTerm
import roqme.metamodel.expressions.LessThanTerm
import roqme.metamodel.expressions.EqualTerm
import roqme.metamodel.expressions.NotEqualTerm
import roqme.metamodel.expressions.LessEqualTerm
import roqme.metamodel.expressions.GreaterEqualTerm
import roqme.metamodel.expressions.GreaterThanTerm
import roqme.metamodel.expressions.AndBooleanTerm
import roqme.metamodel.expressions.OrBooleanTerm
import roqme.metamodel.expressions.VarTerm
import roqme.metamodel.expressions.UnaryTermOp
import roqme.metamodel.expressions.ArithFunction
import roqme.metamodel.expressions.ArithFtnEnum
import roqme.metamodel.expressions.NaryTermOp
import roqme.metamodel.datatypes.EnumLiteral
import miron.metamodel.datatypes.BehaviorTreeLiteral
import org.eclipse.emf.common.util.EList
import roqme.metamodel.kernel.Context
import roqme.metamodel.datatypes.TypedVariable
import roqme.metamodel.datatypes.BooleanType
import roqme.metamodel.datatypes.EventType
import roqme.metamodel.datatypes.EnumType
import roqme.metamodel.datatypes.SimpleEnumType
import roqme.metamodel.datatypes.SimpleEnumLiteral
import java.util.ArrayList
import java.util.Locale
import miron.metamodel.kernel.ArchBinding

class MironMznGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		if(resource.getURI().fileExtension().equalsIgnoreCase(MironGenerator.MIRON_FILE_EXT)) {

			for (model : resource.allContents.toIterable.filter(MironModel)) {		
					
				val splitStr = resource.getURI().lastSegment().split('\\.')
				fsa.generateFile(splitStr.get(0) + "."
					+ MironGenerator.MZN_FILE_EXT, 
					generateMzn(model)
				)
				
				fsa.generateFile(splitStr.get(0) + "."
					+ MironGenerator.MZN_IO_FILE_EXT, 
					generateIoSpec(model)
				)
			} 
		}
	}
	
	def generateIoSpec(MironModel model) {
		
		val List<TypedVariable> variables = newArrayList
		
		// Adding referenced metrics
		val propertiesInRules = searchTermsForReferences(model, Property)
		val List<Property> propertiesInVp = newArrayList
				
		for(VariationPoint varpoint : model.variables.filter(VariationPoint)) {
			searchForPropertiesRefs(varpoint, propertiesInVp)
		}
		
		variables.addAll(union(
			new ArrayList<TypedVariable>(propertiesInVp), propertiesInRules))
			
		// Adding referenced contexts
		variables.addAll(searchTermsForReferences(model, Context))
		
		// Adding varpoints
		for(varpoint : model.variables.filter(VariationPoint)) {
			variables.add(varpoint);
		}

		''' { "inputs" : [«
		FOR input : variables SEPARATOR ", "»«
			IF input instanceof Context»«
				"\n\t"»{"mzn_id":"context_«getContextName(input as Context)»", "class":"Context", "name":"«input.name»", "namespace":"«getVariableNamespace(input)»", "datatype":"«writeDataType(input)»"}«
			ELSEIF input instanceof Property»«
				"\n\t"»{"mzn_id":"metric_«getPropertyName(input as Property)»", "class":"Property", "name":"«input.name»", "namespace":"«getVariableNamespace(input)»", "datatype":"NumericType"}«
			ELSEIF input instanceof VariationPoint»«
				"\n\t"»{"mzn_id":"«input.name»_input", "datatype":"BooleanType", "class":"", "name":"", "namespace":""},«
				"\n\t"»{"mzn_id":"«input.name»_input_value", "class":"VariationPoint", "name":"«input.name»", "namespace":"«getVariableNamespace(input)»", "datatype":"«writeDataType(input)»"}«
			ENDIF»«
		ENDFOR»«
		"\n"»], "outputs" : [«
		FOR output : variables.filter(VariationPoint) SEPARATOR ", "»«
				"\n\t"»{"mzn_id":"«output.name»", "class":"VariationPoint", "name":"«output.name»", "namespace":"«getVariableNamespace(output)»", "datatype":"«writeDataType(output)»", "smartsoft":«writeSmartsoftOpts(output)»}«
		ENDFOR»«
		"\n"»]}
		'''
	}
	
	def generateMzn(MironModel model) {
		'''
		«generateContextDefs(model)»
		
		«generateMetricDefs(model)»
		
		«FOR varpoint : model.variables.filter(VariationPoint)»
			«generateVarpointDefs(varpoint)»
			
		«ENDFOR»
		«generateRuleDefs(model)»
		
		«generateObjective(model)»
		
		«generatePrettyOutput(model)»
		'''
	}
	
	def generateContextDefs(MironModel model) {
		'''
		«val references = searchTermsForReferences(model, Context)»
		«IF !references.isEmpty»
			%
			% Context variables
			%
			
			«FOR variable : references»
				«IF getDataType(variable) instanceof NumericType»
					float : context_«getContextName(variable as Context)»;
				«ELSEIF getDataType(variable) instanceof BooleanType»
					bool : context_«getContextName(variable as Context)»;
				«ELSEIF getDataType(variable) instanceof EventType»
					bool : context_«getContextName(variable as Context)»;
				«ELSEIF getDataType(variable) instanceof EnumType»
					int : context_«getContextName(variable as Context)»;
				«ELSE»
					% (UNSUPPORTED TYPE FOR context_«getContextName(variable as Context)»)
				«ENDIF»
			«ENDFOR»
		«ENDIF»
		'''
	}
	
	def generateMetricDefs(MironModel model) {
		
		val propertiesInRules = searchTermsForReferences(model, Property)
		val List<Property> propertiesInVp = newArrayList
		
		for(VariationPoint varpoint : model.variables.filter(VariationPoint)) {
			searchForPropertiesRefs(varpoint, propertiesInVp)
		}

		val List<TypedVariable> properties = union(
			new ArrayList<TypedVariable>(propertiesInVp), propertiesInRules)
		
		'''
		«IF !properties.empty»
			%
			% Metrics definitions
			%
			
			«FOR property : properties»
				float : metric_«getPropertyName(property as Property)»;
			«ENDFOR»
			«IF !propertiesInVp.empty»
			
				% Weights
				«FOR property : propertiesInVp»
					float : weight_«getPropertyName(property as Property)» = metric_«getPropertyName(property as Property)»;		
				«ENDFOR»
			«ENDIF»
		«ENDIF»
		'''
	}
	
	def generateVarpointDefs(VariationPoint varpoint) {
		'''
		%
		% Definitions for «varpoint.name»
		%
			
		% Fixed value support
		bool  : «varpoint.name»_input;
		float : «varpoint.name»_input_value;
			
		% Number of values
		int : «varpoint.name»_n;
			
		% Index definition
		set of int: «varpoint.name»_index = 1..«varpoint.name»_n;
			
		% X-Axis values
		array [«varpoint.name»_index] of float: «varpoint.name»_x;
		
		«IF getDataType(varpoint) instanceof BehaviorTreeEnumType»
			% X-Axis labels
			enum «varpoint.name»_lbl; 
		«ENDIF»
		«writeYAxisDeclarations(varpoint)»
			
		% Decision variable
		var 1..«varpoint.name»_n: «varpoint.name»_var;
		
		% Constraints
		«IF getDataType(varpoint) instanceof BehaviorTreeEnumType»
			constraint «varpoint.name»_input -> «varpoint.name»_x[«varpoint.name»_var] = «varpoint.name»_input_value;
		«ELSE»
			constraint «varpoint.name»_input -> abs(«varpoint.name»_x[«varpoint.name»_var] - «varpoint.name»_input_value) < «getResolution(varpoint)»;
		«ENDIF»
		'''
	}
	
	def generateRuleDefs(MironModel model) {
		'''
		%
		% MIRoN rules
		%
				
		«FOR rule : model.sentences.filter(Rule)»«var index = 1»
			«FOR implication : rule.implies»
				«val varpoint = getLeftEqualVarpoint(implication.term)»
				% Rule «rule.name»«IF rule.implies.size > 1» («index++»)«ENDIF»
				«IF rule.condition !== null»
					constraint «IF varpoint !== null»not(«varpoint.name»_input) /\ «ENDIF»«generateExpr(rule.condition.term)» -> «generateExpr(implication.term)»;
				«ELSE»
					constraint «IF varpoint !== null»not(«varpoint.name»_input) -> «ENDIF»«generateExpr(implication.term)»;
				«ENDIF»	
			«ENDFOR»	
		«ENDFOR»
		'''
	}
	
	def generateObjective(MironModel model) {
		val List<String> optimizationTerms = newArrayList
		
		for(varpoint : model.variables.filter(VariationPoint)) {
			for(property : searchForPropertiesRefs(varpoint)) {
				optimizationTerms.add(
					"weight_" + getPropertyName(property) + " * " + varpoint.name 
					+ "_y_" + getPropertyName(property) + "[" + varpoint.name + "_var]")
			}
		}
		'''
		%
		% Solver objective
		%
			
		«IF !optimizationTerms.empty»
			solve maximize«
			FOR term : optimizationTerms SEPARATOR " + "»«
				"\n\t" + term»«
			ENDFOR»;
		«ELSE»
			solve satisfy;
		«ENDIF»
		'''
	}
	
	def generatePrettyOutput(MironModel model) {
		'''
		%
		% Pretty-printed output
		%
		
		output [«
		FOR varpoint : model.variables.filter(VariationPoint) SEPARATOR ", "»«
			IF getDataType(varpoint) instanceof BehaviorTreeEnumType»«
				"\n\t"»"«varpoint.name» = ", show(«varpoint.name»_lbl[«varpoint.name»_var]),"; "«
			ELSE»«
				"\n\t"»"«varpoint.name» = ", show(«varpoint.name»_x[«varpoint.name»_var]),"; "«
			ENDIF»«
		ENDFOR»];
		'''
	}
	
	def writeSmartsoftOpts(VariationPoint varpoint) {
		var result = "{}";
		
		if(varpoint.binding instanceof ArchBinding) {
			val ArchBinding binding = varpoint.binding as ArchBinding
			result = '''{"parameterSetRepository":"«binding.parameterSetRepository»", "parameterSet":"«
						binding.parameterSet»", "component":"«binding.component»", "parameter":"«binding.parameter»"}'''
		}
		return result
	}
	
	def writeYAxisDeclarations(VariationPoint varpoint) {
		val properties = searchForPropertiesRefs(varpoint)
		
		'''
		«IF !properties.empty»
		
			% Y-Axis values (utility)
			«FOR Property property : properties»
				array [«varpoint.name»_index] of float: «varpoint.name»_y_«getPropertyName(property)»;
			«ENDFOR»
		«ENDIF»
		'''
	}
	
	def List<Property> searchForPropertiesRefs(VariationPoint varpoint) {
		return searchForPropertiesRefs(varpoint, newArrayList)
	}
	
	def List<Property> searchForPropertiesRefs(VariationPoint varpoint, List<Property> properties) {
		val dataType = getDataType(varpoint)
		
		val values = if (dataType instanceof BehaviorTreeEnumType) 
			(dataType as BehaviorTreeEnumType).literals else
			if(dataType instanceof NumericSampledType)
			(dataType as NumericSampledType).samples else null
		
		if(values !== null) {
			for(QoSProfiledValue value : values) {
				for(ImpactOnQuality impact : value.getImpacts()) {
					var found = false
					var i = 0
						
					while(!found && i<properties.size()) {
						found = properties.get(i).hashCode() == impact.getProperty().hashCode()
						i++
					}
					if(!found) {
						properties.add(impact.getProperty())
					}
				}
			}
		}
		return properties
	}
	
	def getResolution(VariationPoint varpoint) {
		val dataType = getDataType(varpoint)
		
		if(dataType instanceof NumericType) {
			
			val StringBuilder builder = new StringBuilder
			val Formatter fmt = new Formatter(builder, Locale.ROOT)
			
			val Double resolution = 
				((getUpperBound(dataType)-getLowerBound(dataType)) as Double) 
				/ (2.0 * ((MironGenerator.NUM_X_POINTS as Number).doubleValue - 1.0))
			fmt.format("%.4f", resolution)
			fmt.close
			return builder.toString()
		}
		else {
			return ""
		}
	}
	
	def getLowerBound(NumericType numericType) {
		var Double lowerBound = null
		var NumericTypeConstraint constraint = null
		val Iterator<NumericTypeConstraint> it = numericType.getConstraints().iterator()
		
		while(it.hasNext() && lowerBound === null) {
			constraint = it.next()
			if(constraint instanceof LowerBound) {
				lowerBound = (constraint as LowerBound).getValue()
			}
		}
		return lowerBound
	}
	
	def getUpperBound(NumericType numericType) {
		var Double upperBound = null
		var NumericTypeConstraint constraint = null
		val Iterator<NumericTypeConstraint> it = numericType.getConstraints().iterator()
		
		while(it.hasNext() && upperBound === null) {
			constraint = it.next()
			if(constraint instanceof UpperBound) {
				upperBound = (constraint as UpperBound).getValue()
			}
		}
		return upperBound
	}
	
	def getDataType(TypedVariable variable) {
		
		if(variable.getDeclaration() instanceof ReferencedDeclaration) {
			return (variable.getDeclaration() as ReferencedDeclaration).getType().getDataType()
		}
		else if(variable.getDeclaration() instanceof ContainedDeclaration) {
			return (variable.getDeclaration() as ContainedDeclaration).getType()
		}
		else {
			return null
		}
	}
	
	def writeDataType(TypedVariable variable) {
		val datatype = getDataType(variable)
		
		if(datatype instanceof EventType)
			return "EventType"
		else if(datatype instanceof BooleanType)
			return "BooleanType"
		else if(datatype instanceof NumericSampledType)
			return "NumericSampledType"
		else if(datatype instanceof NumericType)
			return "NumericType"
		else if(datatype instanceof BehaviorTreeEnumType)
			return "BehaviorTreeEnumType"
		else if(datatype instanceof EnumType)
			return "EnumType"
		else
			return "(UNKNOWN TYPE)"
	}
	
	def getPropertyName(Property property) {
		var result = property.getName;
		
		if(property.eContainer instanceof RoqmeModel) {
			val namespace = (property.eContainer as RoqmeModel).namespace;
			if(!namespace.empty) {
				result = namespace + "_" + result
			}
		}
		return result;
	}
	
	def getContextName(Context context) {
		var result = context.getName;
		
		if(context.eContainer instanceof RoqmeModel) {
			val namespace = (context.eContainer as RoqmeModel).namespace;
			if(!namespace.empty) {
				result = namespace + "_" + result
			}
		}
		return result;
	}
	
	def getVariableNamespace(TypedVariable variable) {
		var namespace = ""
		if(variable.eContainer instanceof RoqmeModel) {
			namespace = (variable.eContainer as RoqmeModel).namespace;
		}
		return namespace
	}
	
	def String generateExpr(Term term) {
		
		if(term instanceof ConstTerm) {
			val value = (term as ConstTerm).value
			
			if(value instanceof NumericValue) {
				'''«(value as NumericValue).value»'''
			}
			else if(value instanceof BooleanValue) {
				'''«(value as BooleanValue).value»'''
			}
			else if(value instanceof EnumValue) {
				'''«getLiteralAsInt((value as EnumValue).value)»'''
			}
		}
		else if(term instanceof VarTerm) {
			val variable = (term as VarTerm).variable
			
			if(variable instanceof VariationPoint) {
				'''«variable.getName()»_x[«variable.getName()»_var]'''
			}
			else if(variable instanceof Property) {
				'''metric_«getPropertyName(variable)»'''
			}
			else if(variable instanceof Context) {
				'''context_«getContextName(variable)»'''
			}
			else {
				'''«variable.getName()»'''
			}
		}
		else if(term instanceof BinaryTermOp) {
			val op = (term as BinaryTermOp)
			
			if(term instanceof EqualTerm
				&& isRealNumberVarpoint(op.left))
			{
				'''abs((«generateExpr(op.left)») - («generateExpr(op.right)»)) < «getResolution(getVarpointFromTerm(op.left))»'''
			}
			else {
				'''«generateExpr(op.left)» «writeOpSymbol(op)» «generateExpr(op.right)»'''	
			}
		}
		else if(term instanceof UnaryTermOp) {
			'''«writeOpSymbol(term)» «generateExpr((term as UnaryTermOp).term)»'''
		}
		else if(term instanceof ArithFunction) {
			val ftn = (term as ArithFunction);
			if(ftn.name == ArithFtnEnum.ABS) {
				'''abs(«generateExpr(ftn.terms.get(0))»)'''
			}
			else if(ftn.name == ArithFtnEnum.SQRT) {
				'''sqrt(«generateExpr(ftn.terms.get(0))»)'''
			}
			else if(ftn.name == ArithFtnEnum.POW) {
				'''pow(«generateExpr(ftn.terms.get(0))», «generateExpr(ftn.terms.get(0))»)'''
			}
			else {
				'''(UNSUPPORTED FUNCTION «ftn.name»)'''
			}
		}
		else {
			'''(UNSUPPORTED TERM «term»)'''
		}
	}
	
	def writeOpSymbol(Term op) {
		
		if(op instanceof AddTerm)
			return "+"
		else if(op instanceof SubTerm)
			return "-"
		else if(op instanceof MultTerm)
			return "*"
		else if(op instanceof DivTerm)
			return "/"
		else if(op instanceof ModTerm)
			return "mod"
		else if(op instanceof LessThanTerm)
			return "<"
		else if(op instanceof EqualTerm)
			return "="
		else if(op instanceof LessEqualTerm)
			return "<="
		else if(op instanceof NotEqualTerm)
			return "!="
		else if(op instanceof GreaterEqualTerm)
			return ">="
		else if(op instanceof GreaterThanTerm)
			return ">"
		else if(op instanceof AndBooleanTerm)
			return "/\\"
		else if(op instanceof OrBooleanTerm)
			return "\\/"
		else 
			return '''(UNSUPPORTED OPERATION «op»)'''
	}
	
	def boolean isRealNumberVarpoint(Term term) {
		return term instanceof VarTerm
			&& (term as VarTerm).variable instanceof VariationPoint
			&& getDataType((term as VarTerm).variable as VariationPoint) instanceof NumericType
	}
	
	def VariationPoint getLeftEqualVarpoint(Term term) {
		var VariationPoint result = null
		if(term instanceof EqualTerm 
			&& (term as EqualTerm).left instanceof VarTerm
			&& ((term as EqualTerm).left as VarTerm).variable instanceof VariationPoint)
		{
			result = ((term as EqualTerm).left as VarTerm).variable as VariationPoint
		}
		return result
	}
	
	def VariationPoint getVarpointFromTerm(Term term) {
		var VariationPoint result = null
		
		if(term instanceof VarTerm
			&& (term as VarTerm).variable instanceof VariationPoint)
		{
			result = (term as VarTerm).variable as VariationPoint
		}
		return result
	}
	
	def getLiteralAsInt(EnumLiteral literal) {
		var result = -1;
		var found = false
		var index = 0
		
		if(literal.eContainer instanceof BehaviorTreeEnumType) {
			val EList<BehaviorTreeLiteral> list 
				= (literal.eContainer as BehaviorTreeEnumType).literals
		
			while(!found && index<list.size) {
				if(found = literal.name.equals(list.get(index).name)) {
					result = index
				}
				index++
			}
		}
		else if(literal.eContainer instanceof SimpleEnumType) {
			val EList<SimpleEnumLiteral> list 
				= (literal.eContainer as SimpleEnumType).literals
		
			while(!found && index<list.size) {
				if(found = literal.name.equals(list.get(index).name)) {
					result = index
				}
				index++
			}
		}
		return result;
	}
	
	def <T> List<TypedVariable> searchTermsForReferences(MironModel model, Class<T> type) {
		val List<TypedVariable> result = newArrayList
		
		for(rule : model.sentences.filter(Rule)) {
			if(rule.condition !== null) {
				searchTermsForReferences(rule.condition.term, result, type)
			}
			for(imp : rule.implies) {
				searchTermsForReferences(imp.term, result, type)
			}
		}
		return result
	}
	
	def <T> void searchTermsForReferences(Term term, List<TypedVariable> cache, Class<T> type) {
		if(term instanceof VarTerm) {
			val variable = (term as VarTerm).variable
			if(type.isAssignableFrom(variable.getClass())) {
				val reference = (variable as TypedVariable)
				var found = false
				var index = 0
				
				while(!found && index < cache.size) {
					found = cache.get(index).hashCode == reference.hashCode
					index++
				}
				if(!found) {
					cache.add(reference)
				}
			}
		}
		else if(term instanceof UnaryTermOp) {
			searchTermsForReferences((term as UnaryTermOp).term, cache, type);
		}
		else if(term instanceof BinaryTermOp) {
			searchTermsForReferences((term as BinaryTermOp).left, cache, type);
			searchTermsForReferences((term as BinaryTermOp).right, cache, type);
		}
		else if(term instanceof NaryTermOp) {
			for(t : (term as NaryTermOp).terms) {
				searchTermsForReferences(t, cache, type);
			}
		}
	}
	
	def List<TypedVariable> union(List<TypedVariable> list1, List<TypedVariable> list2) {
		
		val List<TypedVariable> result = newArrayList
		val List<TypedVariable> cache  = newArrayList(list1)
		cache.addAll(list2)
		
		var boolean found
		var int index
		
		for(e : cache) {
			index = 0
			found = false
			while(!found && index < result.size) {
				found = (e.hashCode == result.get(index).hashCode)
				index++
			}	
			if(!found) {
				result.add(e)
			}
		}
		return result
	}
}