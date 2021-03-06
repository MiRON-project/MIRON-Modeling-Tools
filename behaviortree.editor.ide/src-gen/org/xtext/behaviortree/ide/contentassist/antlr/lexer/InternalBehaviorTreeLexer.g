/*
 * generated by Xtext 2.12.0
 */
lexer grammar InternalBehaviorTreeLexer;

@header {
package org.xtext.behaviortree.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

BlackboardCheckDouble : ('B'|'b')('L'|'l')('A'|'a')('C'|'c')('K'|'k')('B'|'b')('O'|'o')('A'|'a')('R'|'r')('D'|'d')('C'|'c')('H'|'h')('E'|'e')('C'|'c')('K'|'k')('D'|'d')('O'|'o')('U'|'u')('B'|'b')('L'|'l')('E'|'e');

BlackboardCheckString : ('B'|'b')('L'|'l')('A'|'a')('C'|'c')('K'|'k')('B'|'b')('O'|'o')('A'|'a')('R'|'r')('D'|'d')('C'|'c')('H'|'h')('E'|'e')('C'|'c')('K'|'k')('S'|'s')('T'|'t')('R'|'r')('I'|'i')('N'|'n')('G'|'g');

Main_tree_to_execute : ('M'|'m')('A'|'a')('I'|'i')('N'|'n')'_'('T'|'t')('R'|'r')('E'|'e')('E'|'e')'_'('T'|'t')('O'|'o')'_'('E'|'e')('X'|'x')('E'|'e')('C'|'c')('U'|'u')('T'|'t')('E'|'e');

RetryUntilSuccesful : ('R'|'r')('E'|'e')('T'|'t')('R'|'r')('Y'|'y')('U'|'u')('N'|'n')('T'|'t')('I'|'i')('L'|'l')('S'|'s')('U'|'u')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('F'|'f')('U'|'u')('L'|'l');

BlackboardCheckInt : ('B'|'b')('L'|'l')('A'|'a')('C'|'c')('K'|'k')('B'|'b')('O'|'o')('A'|'a')('R'|'r')('D'|'d')('C'|'c')('H'|'h')('E'|'e')('C'|'c')('K'|'k')('I'|'i')('N'|'n')('T'|'t');

AlwaysFailure : ('A'|'a')('L'|'l')('W'|'w')('A'|'a')('Y'|'y')('S'|'s')('F'|'f')('A'|'a')('I'|'i')('L'|'l')('U'|'u')('R'|'r')('E'|'e');

AlwaysSuccess : ('A'|'a')('L'|'l')('W'|'w')('A'|'a')('Y'|'y')('S'|'s')('S'|'s')('U'|'u')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

SetBlackboard : ('S'|'s')('E'|'e')('T'|'t')('B'|'b')('L'|'l')('A'|'a')('C'|'c')('K'|'k')('B'|'b')('O'|'o')('A'|'a')('R'|'r')('D'|'d');

BehaviorTree : ('B'|'b')('E'|'e')('H'|'h')('A'|'a')('V'|'v')('I'|'i')('O'|'o')('R'|'r')('T'|'t')('R'|'r')('E'|'e')('E'|'e');

FallbackStar : ('F'|'f')('A'|'a')('L'|'l')('L'|'l')('B'|'b')('A'|'a')('C'|'c')('K'|'k')('S'|'s')('T'|'t')('A'|'a')('R'|'r');

ForceFailure : ('F'|'f')('O'|'o')('R'|'r')('C'|'c')('E'|'e')('F'|'f')('A'|'a')('I'|'i')('L'|'l')('U'|'u')('R'|'r')('E'|'e');

ForceSuccess : ('F'|'f')('O'|'o')('R'|'r')('C'|'c')('E'|'e')('S'|'s')('U'|'u')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

SequenceStar : ('S'|'s')('E'|'e')('Q'|'q')('U'|'u')('E'|'e')('N'|'n')('C'|'c')('E'|'e')('S'|'s')('T'|'t')('A'|'a')('R'|'r');

Condition : ('C'|'c')('O'|'o')('N'|'n')('D'|'d')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Fallback : ('F'|'f')('A'|'a')('L'|'l')('L'|'l')('B'|'b')('A'|'a')('C'|'c')('K'|'k');

Inverter : ('I'|'i')('N'|'n')('V'|'v')('E'|'e')('R'|'r')('T'|'t')('E'|'e')('R'|'r');

Parallel : ('P'|'p')('A'|'a')('R'|'r')('A'|'a')('L'|'l')('L'|'l')('E'|'e')('L'|'l');

Sequence : ('S'|'s')('E'|'e')('Q'|'q')('U'|'u')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

Timeout : ('T'|'t')('I'|'i')('M'|'m')('E'|'e')('O'|'o')('U'|'u')('T'|'t');

Include : ('I'|'i')('N'|'n')('C'|'c')('L'|'l')('U'|'u')('D'|'d')('E'|'e');

Action : ('A'|'a')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Repeat : ('R'|'r')('E'|'e')('P'|'p')('E'|'e')('A'|'a')('T'|'t');

Path : ('P'|'p')('A'|'a')('T'|'t')('H'|'h');

Root : ('R'|'r')('O'|'o')('O'|'o')('T'|'t');

SolidusGreaterThanSign : '/''>';

LessThanSignSolidus : '<''/';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

RULE_DEFINITION_STRING : '<' RULE_WS? ('T'|'t') 'ree' ('N'|'n') 'odes' ('M'|'m') 'odel' RULE_WS? '>' ( options {greedy=false;} : . )*'</' RULE_WS? ('T'|'t') 'ree' ('N'|'n') 'odes' ('M'|'m') 'odel' RULE_WS? '>';

RULE_SWITCH_KEYWORD : ('S'|'s') 'witch' RULE_INT;

RULE_SUBTREE_KEYWORD : ('S'|'s') 'ub' ('t'|'T') 'ree' RULE_WS ('I'|'i') ('D'|'d');

RULE_SUBTREEWRAPPER_KEYWORD : ('S'|'s') 'ub' ('T'|'t') 'ree' ('P'|'p') 'lus' RULE_WS ('I'|'i') ('D'|'d');

RULE_ML_COMMENT : ('<?' ( options {greedy=false;} : . )*'?>'|'<!--' ( options {greedy=false;} : . )*'-->');

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

fragment RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
