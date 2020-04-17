/*
 * generated by Xtext 2.12.0
 */
package org.xtext.miron.formatting2

import com.google.inject.Inject
import miron.metamodel.datatypes.MironModel
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xtext.miron.services.MIRoNGrammarAccess
import org.xtext.roqme.formatting2.RoQMEFormatter
import roqme.metamodel.datatypes.DataTypeDefinition
import roqme.metamodel.datatypes.EnumLiteral
import roqme.metamodel.datatypes.EnumType
import roqme.metamodel.datatypes.Sentence
import roqme.metamodel.datatypes.TypedVariable

class MIRoNFormatter extends RoQMEFormatter {
	
	@Inject extension MIRoNGrammarAccess

	def dispatch void format(MironModel mironModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Sentence sentence : mironModel.getSentences()) {
			sentence.format;
		}
		for (DataTypeDefinition dataTypeDefinition : mironModel.getDataTypes()) {
			dataTypeDefinition.format;
		}
		for (TypedVariable typedVariable : mironModel.getVariables()) {
			typedVariable.format;
		}
	}

	def dispatch void format(EnumType enumType, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (EnumLiteral enumLiteral : enumType.getLiterals()) {
			enumLiteral.format;
		}
	}
	
	// TODO: implement for VariationPoint, Rule, VariantAssignment
}