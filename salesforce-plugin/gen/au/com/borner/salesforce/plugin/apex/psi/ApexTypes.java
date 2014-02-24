/*
 *  Copyright 2014 Mark Borner
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package au.com.borner.salesforce.plugin.apex.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import au.com.borner.salesforce.plugin.apex.psi.impl.*;

public interface ApexTypes {

  IElementType ADDITION_ASSIGN_EXPRESSION = new ApexElementType("ADDITION_ASSIGN_EXPRESSION");
  IElementType ADDITION_EXPRESSION = new ApexElementType("ADDITION_EXPRESSION");
  IElementType AND_ASSIGN_EXPRESSION = new ApexElementType("AND_ASSIGN_EXPRESSION");
  IElementType AND_EXPRESSION = new ApexElementType("AND_EXPRESSION");
  IElementType ANNOTATION = new ApexElementType("ANNOTATION");
  IElementType ANNOTATION_PARAMETER = new ApexElementType("ANNOTATION_PARAMETER");
  IElementType ANNOTATION_PARAMETER_VALUE = new ApexElementType("ANNOTATION_PARAMETER_VALUE");
  IElementType ARGUMENTS = new ApexElementType("ARGUMENTS");
  IElementType ARRAY_CREATOR_REST = new ApexElementType("ARRAY_CREATOR_REST");
  IElementType ARRAY_INITIALIZER = new ApexElementType("ARRAY_INITIALIZER");
  IElementType ARRAY_POSITION_EXPRESSION = new ApexElementType("ARRAY_POSITION_EXPRESSION");
  IElementType ASSIGN_EXPRESSION = new ApexElementType("ASSIGN_EXPRESSION");
  IElementType BITWISE_AND_EXPRESSION = new ApexElementType("BITWISE_AND_EXPRESSION");
  IElementType BITWISE_EXCLUSIVE_OR_1EXPRESSION = new ApexElementType("BITWISE_EXCLUSIVE_OR_1EXPRESSION");
  IElementType BITWISE_EXCLUSIVE_OR_2EXPRESSION = new ApexElementType("BITWISE_EXCLUSIVE_OR_2EXPRESSION");
  IElementType BITWISE_OR_EXPRESSION = new ApexElementType("BITWISE_OR_EXPRESSION");
  IElementType BITWISE_SHIFT_LEFT_EXPRESSION = new ApexElementType("BITWISE_SHIFT_LEFT_EXPRESSION");
  IElementType BITWISE_SHIFT_RIGHT_EXPRESSION = new ApexElementType("BITWISE_SHIFT_RIGHT_EXPRESSION");
  IElementType BITWISE_SHIFT_RIGHT_UNSIGNED_EXPRESSION = new ApexElementType("BITWISE_SHIFT_RIGHT_UNSIGNED_EXPRESSION");
  IElementType BLOCK = new ApexElementType("BLOCK");
  IElementType BLOCK_STATEMENT = new ApexElementType("BLOCK_STATEMENT");
  IElementType BOOLEAN_LITERAL = new ApexElementType("BOOLEAN_LITERAL");
  IElementType CAST_EXPRESSION = new ApexElementType("CAST_EXPRESSION");
  IElementType CATCH_CLAUSE = new ApexElementType("CATCH_CLAUSE");
  IElementType CLASSIC_FOR_STATEMENT = new ApexElementType("CLASSIC_FOR_STATEMENT");
  IElementType CLASS_BODY = new ApexElementType("CLASS_BODY");
  IElementType CLASS_CREATOR_REST = new ApexElementType("CLASS_CREATOR_REST");
  IElementType CLASS_DECLARATION = new ApexElementType("CLASS_DECLARATION");
  IElementType CLASS_INTERFACE_OR_PRIMITIVE_TYPE = new ApexElementType("CLASS_INTERFACE_OR_PRIMITIVE_TYPE");
  IElementType CLASS_OR_INTERFACE_REFERENCE = new ApexElementType("CLASS_OR_INTERFACE_REFERENCE");
  IElementType CONSTRUCTOR_BODY = new ApexElementType("CONSTRUCTOR_BODY");
  IElementType CONSTRUCTOR_DECLARATION = new ApexElementType("CONSTRUCTOR_DECLARATION");
  IElementType CREATED_NAME = new ApexElementType("CREATED_NAME");
  IElementType CREATOR = new ApexElementType("CREATOR");
  IElementType DECREMENT_AFTER_EXPRESSION = new ApexElementType("DECREMENT_AFTER_EXPRESSION");
  IElementType DECREMENT_BEFORE_EXPRESSION = new ApexElementType("DECREMENT_BEFORE_EXPRESSION");
  IElementType DIVIDE_ASSIGN_EXPRESSION = new ApexElementType("DIVIDE_ASSIGN_EXPRESSION");
  IElementType DIVISION_EXPRESSION = new ApexElementType("DIVISION_EXPRESSION");
  IElementType DO_STATEMENT = new ApexElementType("DO_STATEMENT");
  IElementType ENHANCED_FOR_STATEMENT = new ApexElementType("ENHANCED_FOR_STATEMENT");
  IElementType ENUM_DECLARATION = new ApexElementType("ENUM_DECLARATION");
  IElementType EQUALITY_EXPRESSION = new ApexElementType("EQUALITY_EXPRESSION");
  IElementType EXACT_EQUALITY_EXPRESSION = new ApexElementType("EXACT_EQUALITY_EXPRESSION");
  IElementType EXACT_INEQUALITY_EXPRESSION = new ApexElementType("EXACT_INEQUALITY_EXPRESSION");
  IElementType EXPLICIT_GENERIC_INVOCATION = new ApexElementType("EXPLICIT_GENERIC_INVOCATION");
  IElementType EXPLICIT_GENERIC_INVOCATION_SUFFIX = new ApexElementType("EXPLICIT_GENERIC_INVOCATION_SUFFIX");
  IElementType EXPRESSION = new ApexElementType("EXPRESSION");
  IElementType EXPRESSION_LIST = new ApexElementType("EXPRESSION_LIST");
  IElementType EXPRESSION_LIST_EXPRESSION = new ApexElementType("EXPRESSION_LIST_EXPRESSION");
  IElementType EXTENDS_CLAUSE = new ApexElementType("EXTENDS_CLAUSE");
  IElementType FIELD_DECLARATOR = new ApexElementType("FIELD_DECLARATOR");
  IElementType FIELD_VISIBILITY = new ApexElementType("FIELD_VISIBILITY");
  IElementType FINALLY_BLOCK = new ApexElementType("FINALLY_BLOCK");
  IElementType FOR_INIT = new ApexElementType("FOR_INIT");
  IElementType FOR_UPDATE = new ApexElementType("FOR_UPDATE");
  IElementType GENERIC_EXPRESSION = new ApexElementType("GENERIC_EXPRESSION");
  IElementType GREATER_EQUAL_EXPRESSION = new ApexElementType("GREATER_EQUAL_EXPRESSION");
  IElementType GREATER_THAN_EXPRESSION = new ApexElementType("GREATER_THAN_EXPRESSION");
  IElementType IDENTIFIER_EXPRESSION = new ApexElementType("IDENTIFIER_EXPRESSION");
  IElementType IF_STATEMENT = new ApexElementType("IF_STATEMENT");
  IElementType IMPLEMENTS_CLAUSE = new ApexElementType("IMPLEMENTS_CLAUSE");
  IElementType INCREMENT_AFTER_EXPRESSION = new ApexElementType("INCREMENT_AFTER_EXPRESSION");
  IElementType INCREMENT_BEFORE_EXPRESSION = new ApexElementType("INCREMENT_BEFORE_EXPRESSION");
  IElementType INEQUALITY_EXPRESSION = new ApexElementType("INEQUALITY_EXPRESSION");
  IElementType INNER_CREATOR = new ApexElementType("INNER_CREATOR");
  IElementType INSTANCE_OF_EXPRESSION = new ApexElementType("INSTANCE_OF_EXPRESSION");
  IElementType INSTANTIATION_EXPRESSION = new ApexElementType("INSTANTIATION_EXPRESSION");
  IElementType INTERFACE_BODY = new ApexElementType("INTERFACE_BODY");
  IElementType INTERFACE_DECLARATION = new ApexElementType("INTERFACE_DECLARATION");
  IElementType LESS_EQUAL_EXPRESSION = new ApexElementType("LESS_EQUAL_EXPRESSION");
  IElementType LESS_THAN_EXPRESSION = new ApexElementType("LESS_THAN_EXPRESSION");
  IElementType LIST_COLLECTION = new ApexElementType("LIST_COLLECTION");
  IElementType LITERAL = new ApexElementType("LITERAL");
  IElementType LOCAL_VARIABLE_DECLARATION_STATEMENT = new ApexElementType("LOCAL_VARIABLE_DECLARATION_STATEMENT");
  IElementType LOCAL_VARIABLE_DECLARATOR = new ApexElementType("LOCAL_VARIABLE_DECLARATOR");
  IElementType LOGICAL_COMPLIMENT_EXPRESSION = new ApexElementType("LOGICAL_COMPLIMENT_EXPRESSION");
  IElementType MAP_COLLECTION = new ApexElementType("MAP_COLLECTION");
  IElementType METHOD_BODY = new ApexElementType("METHOD_BODY");
  IElementType METHOD_DECLARATION = new ApexElementType("METHOD_DECLARATION");
  IElementType MULTIPLICATION_ASSIGN_EXPRESSION = new ApexElementType("MULTIPLICATION_ASSIGN_EXPRESSION");
  IElementType MULTIPLICATION_EXPRESSION = new ApexElementType("MULTIPLICATION_EXPRESSION");
  IElementType NON_WILDCARD_TYPE_ARGUMENTS = new ApexElementType("NON_WILDCARD_TYPE_ARGUMENTS");
  IElementType NON_WILDCARD_TYPE_ARGUMENTS_OR_DIAMOND = new ApexElementType("NON_WILDCARD_TYPE_ARGUMENTS_OR_DIAMOND");
  IElementType OR_ASSIGN_EXPRESSION = new ApexElementType("OR_ASSIGN_EXPRESSION");
  IElementType OR_EXPRESSION = new ApexElementType("OR_EXPRESSION");
  IElementType PARAMETERS = new ApexElementType("PARAMETERS");
  IElementType PARAMETER_DEFINITION = new ApexElementType("PARAMETER_DEFINITION");
  IElementType PRIMARY_EXPRESSION = new ApexElementType("PRIMARY_EXPRESSION");
  IElementType PRIMITIVE_TYPE = new ApexElementType("PRIMITIVE_TYPE");
  IElementType SET_COLLECTION = new ApexElementType("SET_COLLECTION");
  IElementType SHARING_MODIFIER = new ApexElementType("SHARING_MODIFIER");
  IElementType SHIFT_LEFT_ASSIGN_EXPRESSION = new ApexElementType("SHIFT_LEFT_ASSIGN_EXPRESSION");
  IElementType SHIFT_RIGHT_ASSIGN_EXPRESSION = new ApexElementType("SHIFT_RIGHT_ASSIGN_EXPRESSION");
  IElementType SHIFT_RIGHT_UNSIGNED_ASSIGN_EXPRESSION = new ApexElementType("SHIFT_RIGHT_UNSIGNED_ASSIGN_EXPRESSION");
  IElementType STATEMENT = new ApexElementType("STATEMENT");
  IElementType STATIC_BLOCK = new ApexElementType("STATIC_BLOCK");
  IElementType STATIC_OR_TRANSIENT_MODIFIER = new ApexElementType("STATIC_OR_TRANSIENT_MODIFIER");
  IElementType SUBTRACTION_ASSIGN_EXPRESSION = new ApexElementType("SUBTRACTION_ASSIGN_EXPRESSION");
  IElementType SUBTRACTION_EXPRESSION = new ApexElementType("SUBTRACTION_EXPRESSION");
  IElementType SUPER_EXPRESSION = new ApexElementType("SUPER_EXPRESSION");
  IElementType SUPER_SUFFIX = new ApexElementType("SUPER_SUFFIX");
  IElementType TERNARY_EXPRESSION = new ApexElementType("TERNARY_EXPRESSION");
  IElementType THIS_EXPRESSION = new ApexElementType("THIS_EXPRESSION");
  IElementType TRIGGER_BODY = new ApexElementType("TRIGGER_BODY");
  IElementType TRIGGER_DEFINITION = new ApexElementType("TRIGGER_DEFINITION");
  IElementType TRIGGER_PARAMETER = new ApexElementType("TRIGGER_PARAMETER");
  IElementType TRY_STATEMENT = new ApexElementType("TRY_STATEMENT");
  IElementType TYPE_ARGUMENT = new ApexElementType("TYPE_ARGUMENT");
  IElementType TYPE_ARGUMENTS_OR_DIAMOND = new ApexElementType("TYPE_ARGUMENTS_OR_DIAMOND");
  IElementType UNARY_NEGATION_EXPRESSION = new ApexElementType("UNARY_NEGATION_EXPRESSION");
  IElementType VARIABLE_DEFINITION = new ApexElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_INITIALIZER = new ApexElementType("VARIABLE_INITIALIZER");
  IElementType VARIABLE_MODIFIER = new ApexElementType("VARIABLE_MODIFIER");
  IElementType VIRTUAL_OR_ABSTRACT_MODIFIER = new ApexElementType("VIRTUAL_OR_ABSTRACT_MODIFIER");
  IElementType VISIBILITY = new ApexElementType("VISIBILITY");
  IElementType WEIRD_EXPRESSION = new ApexElementType("WEIRD_EXPRESSION");
  IElementType WHILE_STATEMENT = new ApexElementType("WHILE_STATEMENT");

  IElementType ABSTRACT = new ApexTokenType("abstract");
  IElementType AFTER = new ApexTokenType("after");
  IElementType AT_SIGN = new ApexTokenType("@");
  IElementType BEFORE = new ApexTokenType("before");
  IElementType BLOB = new ApexTokenType("Blob");
  IElementType BOOLEAN = new ApexTokenType("Boolean");
  IElementType BREAK = new ApexTokenType("break");
  IElementType CATCH = new ApexTokenType("catch");
  IElementType CLASS_KEYWORD = new ApexTokenType("class");
  IElementType COMMA = new ApexTokenType(",");
  IElementType COMMENT = new ApexTokenType("COMMENT");
  IElementType CONTINUE = new ApexTokenType("continue");
  IElementType DATE = new ApexTokenType("Date");
  IElementType DATETIME = new ApexTokenType("Datetime");
  IElementType DECIMAL = new ApexTokenType("Decimal");
  IElementType DECIMAL_LITERAL = new ApexTokenType("DECIMAL_LITERAL");
  IElementType DELETE = new ApexTokenType("delete");
  IElementType DO = new ApexTokenType("do");
  IElementType DOT = new ApexTokenType(".");
  IElementType DOUBLE = new ApexTokenType("Double");
  IElementType ELSE = new ApexTokenType("else");
  IElementType ENUM = new ApexTokenType("enum");
  IElementType EXTENDS = new ApexTokenType("extends");
  IElementType FALSE = new ApexTokenType("false");
  IElementType FINAL = new ApexTokenType("final");
  IElementType FINALLY = new ApexTokenType("finally");
  IElementType FOR = new ApexTokenType("for");
  IElementType GLOBAL = new ApexTokenType("global");
  IElementType ID = new ApexTokenType("ID");
  IElementType IDENTIFIER = new ApexTokenType("identifier");
  IElementType IF = new ApexTokenType("if");
  IElementType IMPLEMENTS = new ApexTokenType("implements");
  IElementType INSERT = new ApexTokenType("insert");
  IElementType INSTANCEOF = new ApexTokenType("instanceof");
  IElementType INTEGER = new ApexTokenType("Integer");
  IElementType INTEGER_LITERAL = new ApexTokenType("INTEGER_LITERAL");
  IElementType INTERFACE = new ApexTokenType("interface");
  IElementType LBRACE = new ApexTokenType("{");
  IElementType LBRACK = new ApexTokenType("[");
  IElementType LINE_COMMENT = new ApexTokenType("LINE_COMMENT");
  IElementType LIST = new ApexTokenType("List");
  IElementType LONG = new ApexTokenType("Long");
  IElementType LONG_LITERAL = new ApexTokenType("LONG_LITERAL");
  IElementType LPAREN = new ApexTokenType("(");
  IElementType MAP = new ApexTokenType("Map");
  IElementType NEW = new ApexTokenType("new");
  IElementType NULL = new ApexTokenType("null");
  IElementType ON = new ApexTokenType("on");
  IElementType OPERATOR_ADDITION = new ApexTokenType("+");
  IElementType OPERATOR_ADDITION_ASSIGNMENT = new ApexTokenType("+=");
  IElementType OPERATOR_AND = new ApexTokenType("&&");
  IElementType OPERATOR_AND_ASSIGNMENT = new ApexTokenType("&=");
  IElementType OPERATOR_ASSIGNMENT = new ApexTokenType("=");
  IElementType OPERATOR_BITWISE_AND = new ApexTokenType("&");
  IElementType OPERATOR_BITWISE_EXCLUSIVE_OR1 = new ApexTokenType("^");
  IElementType OPERATOR_BITWISE_EXCLUSIVE_OR2 = new ApexTokenType("^=");
  IElementType OPERATOR_BITWISE_OR = new ApexTokenType("|");
  IElementType OPERATOR_BITWISE_SHIFT_LEFT_ASSIGNMENT = new ApexTokenType("<<=");
  IElementType OPERATOR_BITWISE_SHIFT_RIGHT_ASSIGNMENT = new ApexTokenType(">>=");
  IElementType OPERATOR_BITWISE_SHIFT_RIGHT_UNSIGNED_ASSIGNMENT = new ApexTokenType(">>>=");
  IElementType OPERATOR_COLON = new ApexTokenType(":");
  IElementType OPERATOR_DECREMENT = new ApexTokenType("--");
  IElementType OPERATOR_DIVISION_ASSIGNMENT = new ApexTokenType("/=");
  IElementType OPERATOR_DIVSION = new ApexTokenType("/");
  IElementType OPERATOR_EQUALITY = new ApexTokenType("==");
  IElementType OPERATOR_EXACT_EQUALITY = new ApexTokenType("===");
  IElementType OPERATOR_EXACT_INEQUALITY = new ApexTokenType("!==");
  IElementType OPERATOR_GREATER_THAN = new ApexTokenType(">");
  IElementType OPERATOR_GREATER_THAN_EQUAL = new ApexTokenType(">=");
  IElementType OPERATOR_INCREMENT = new ApexTokenType("++");
  IElementType OPERATOR_INEQUALITY = new ApexTokenType("!=");
  IElementType OPERATOR_LESS_THAN = new ApexTokenType("<");
  IElementType OPERATOR_LESS_THAN_EQUAL = new ApexTokenType("<=");
  IElementType OPERATOR_MULTIPLICATION = new ApexTokenType("*");
  IElementType OPERATOR_MULTIPLICATION_ASSIGNMENT = new ApexTokenType("*=");
  IElementType OPERATOR_NOT = new ApexTokenType("!");
  IElementType OPERATOR_OR = new ApexTokenType("||");
  IElementType OPERATOR_OR_ASSIGNMENT = new ApexTokenType("|=");
  IElementType OPERATOR_SUBTRACTION = new ApexTokenType("-");
  IElementType OPERATOR_SUBTRACTION_ASSIGNMENT = new ApexTokenType("-=");
  IElementType OPERATOR_TERNARY = new ApexTokenType("?");
  IElementType PRIVATE = new ApexTokenType("private");
  IElementType PROTECTED = new ApexTokenType("protected");
  IElementType PUBLIC = new ApexTokenType("public");
  IElementType RBRACE = new ApexTokenType("}");
  IElementType RBRACK = new ApexTokenType("]");
  IElementType RETURN = new ApexTokenType("return");
  IElementType RPAREN = new ApexTokenType(")");
  IElementType SEMI = new ApexTokenType(";");
  IElementType SET = new ApexTokenType("Set");
  IElementType SHARING = new ApexTokenType("sharing");
  IElementType STATIC = new ApexTokenType("static");
  IElementType STRING = new ApexTokenType("String");
  IElementType STRING_LITERAL = new ApexTokenType("STRING_LITERAL");
  IElementType SUPER = new ApexTokenType("super");
  IElementType THIS = new ApexTokenType("this");
  IElementType THROW = new ApexTokenType("throw");
  IElementType TIME = new ApexTokenType("Time");
  IElementType TRANSIENT = new ApexTokenType("transient");
  IElementType TRIGGER = new ApexTokenType("trigger");
  IElementType TRUE = new ApexTokenType("true");
  IElementType TRY = new ApexTokenType("try");
  IElementType TYPEARGUMENTS = new ApexTokenType("typeArguments");
  IElementType TYPELIST = new ApexTokenType("typeList");
  IElementType UNDELETE = new ApexTokenType("undelete");
  IElementType UPDATE = new ApexTokenType("update");
  IElementType VIRTUAL = new ApexTokenType("virtual");
  IElementType VOID = new ApexTokenType("void");
  IElementType WHILE = new ApexTokenType("while");
  IElementType WITH = new ApexTokenType("with");
  IElementType WITHOUT = new ApexTokenType("without");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ADDITION_ASSIGN_EXPRESSION) {
        return new ApexAdditionAssignExpressionImpl(node);
      }
      else if (type == ADDITION_EXPRESSION) {
        return new ApexAdditionExpressionImpl(node);
      }
      else if (type == AND_ASSIGN_EXPRESSION) {
        return new ApexAndAssignExpressionImpl(node);
      }
      else if (type == AND_EXPRESSION) {
        return new ApexAndExpressionImpl(node);
      }
      else if (type == ANNOTATION) {
        return new ApexAnnotationImpl(node);
      }
      else if (type == ANNOTATION_PARAMETER) {
        return new ApexAnnotationParameterImpl(node);
      }
      else if (type == ANNOTATION_PARAMETER_VALUE) {
        return new ApexAnnotationParameterValueImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new ApexArgumentsImpl(node);
      }
      else if (type == ARRAY_CREATOR_REST) {
        return new ApexArrayCreatorRestImpl(node);
      }
      else if (type == ARRAY_INITIALIZER) {
        return new ApexArrayInitializerImpl(node);
      }
      else if (type == ARRAY_POSITION_EXPRESSION) {
        return new ApexArrayPositionExpressionImpl(node);
      }
      else if (type == ASSIGN_EXPRESSION) {
        return new ApexAssignExpressionImpl(node);
      }
      else if (type == BITWISE_AND_EXPRESSION) {
        return new ApexBitwiseAndExpressionImpl(node);
      }
      else if (type == BITWISE_EXCLUSIVE_OR_1EXPRESSION) {
        return new ApexBitwiseExclusiveOr1expressionImpl(node);
      }
      else if (type == BITWISE_EXCLUSIVE_OR_2EXPRESSION) {
        return new ApexBitwiseExclusiveOr2expressionImpl(node);
      }
      else if (type == BITWISE_OR_EXPRESSION) {
        return new ApexBitwiseOrExpressionImpl(node);
      }
      else if (type == BITWISE_SHIFT_LEFT_EXPRESSION) {
        return new ApexBitwiseShiftLeftExpressionImpl(node);
      }
      else if (type == BITWISE_SHIFT_RIGHT_EXPRESSION) {
        return new ApexBitwiseShiftRightExpressionImpl(node);
      }
      else if (type == BITWISE_SHIFT_RIGHT_UNSIGNED_EXPRESSION) {
        return new ApexBitwiseShiftRightUnsignedExpressionImpl(node);
      }
      else if (type == BLOCK) {
        return new ApexBlockImpl(node);
      }
      else if (type == BLOCK_STATEMENT) {
        return new ApexBlockStatementImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new ApexBooleanLiteralImpl(node);
      }
      else if (type == CAST_EXPRESSION) {
        return new ApexCastExpressionImpl(node);
      }
      else if (type == CATCH_CLAUSE) {
        return new ApexCatchClauseImpl(node);
      }
      else if (type == CLASSIC_FOR_STATEMENT) {
        return new ApexClassicForStatementImpl(node);
      }
      else if (type == CLASS_BODY) {
        return new ApexClassBodyImpl(node);
      }
      else if (type == CLASS_CREATOR_REST) {
        return new ApexClassCreatorRestImpl(node);
      }
      else if (type == CLASS_DECLARATION) {
        return new ApexClassDeclarationImpl(node);
      }
      else if (type == CLASS_INTERFACE_OR_PRIMITIVE_TYPE) {
        return new ApexClassInterfaceOrPrimitiveTypeImpl(node);
      }
      else if (type == CLASS_OR_INTERFACE_REFERENCE) {
        return new ApexClassOrInterfaceReferenceImpl(node);
      }
      else if (type == CONSTRUCTOR_BODY) {
        return new ApexConstructorBodyImpl(node);
      }
      else if (type == CONSTRUCTOR_DECLARATION) {
        return new ApexConstructorDeclarationImpl(node);
      }
      else if (type == CREATED_NAME) {
        return new ApexCreatedNameImpl(node);
      }
      else if (type == CREATOR) {
        return new ApexCreatorImpl(node);
      }
      else if (type == DECREMENT_AFTER_EXPRESSION) {
        return new ApexDecrementAfterExpressionImpl(node);
      }
      else if (type == DECREMENT_BEFORE_EXPRESSION) {
        return new ApexDecrementBeforeExpressionImpl(node);
      }
      else if (type == DIVIDE_ASSIGN_EXPRESSION) {
        return new ApexDivideAssignExpressionImpl(node);
      }
      else if (type == DIVISION_EXPRESSION) {
        return new ApexDivisionExpressionImpl(node);
      }
      else if (type == DO_STATEMENT) {
        return new ApexDoStatementImpl(node);
      }
      else if (type == ENHANCED_FOR_STATEMENT) {
        return new ApexEnhancedForStatementImpl(node);
      }
      else if (type == ENUM_DECLARATION) {
        return new ApexEnumDeclarationImpl(node);
      }
      else if (type == EQUALITY_EXPRESSION) {
        return new ApexEqualityExpressionImpl(node);
      }
      else if (type == EXACT_EQUALITY_EXPRESSION) {
        return new ApexExactEqualityExpressionImpl(node);
      }
      else if (type == EXACT_INEQUALITY_EXPRESSION) {
        return new ApexExactInequalityExpressionImpl(node);
      }
      else if (type == EXPLICIT_GENERIC_INVOCATION) {
        return new ApexExplicitGenericInvocationImpl(node);
      }
      else if (type == EXPLICIT_GENERIC_INVOCATION_SUFFIX) {
        return new ApexExplicitGenericInvocationSuffixImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ApexExpressionImpl(node);
      }
      else if (type == EXPRESSION_LIST) {
        return new ApexExpressionListImpl(node);
      }
      else if (type == EXPRESSION_LIST_EXPRESSION) {
        return new ApexExpressionListExpressionImpl(node);
      }
      else if (type == EXTENDS_CLAUSE) {
        return new ApexExtendsClauseImpl(node);
      }
      else if (type == FIELD_DECLARATOR) {
        return new ApexFieldDeclaratorImpl(node);
      }
      else if (type == FIELD_VISIBILITY) {
        return new ApexFieldVisibilityImpl(node);
      }
      else if (type == FINALLY_BLOCK) {
        return new ApexFinallyBlockImpl(node);
      }
      else if (type == FOR_INIT) {
        return new ApexForInitImpl(node);
      }
      else if (type == FOR_UPDATE) {
        return new ApexForUpdateImpl(node);
      }
      else if (type == GENERIC_EXPRESSION) {
        return new ApexGenericExpressionImpl(node);
      }
      else if (type == GREATER_EQUAL_EXPRESSION) {
        return new ApexGreaterEqualExpressionImpl(node);
      }
      else if (type == GREATER_THAN_EXPRESSION) {
        return new ApexGreaterThanExpressionImpl(node);
      }
      else if (type == IDENTIFIER_EXPRESSION) {
        return new ApexIdentifierExpressionImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new ApexIfStatementImpl(node);
      }
      else if (type == IMPLEMENTS_CLAUSE) {
        return new ApexImplementsClauseImpl(node);
      }
      else if (type == INCREMENT_AFTER_EXPRESSION) {
        return new ApexIncrementAfterExpressionImpl(node);
      }
      else if (type == INCREMENT_BEFORE_EXPRESSION) {
        return new ApexIncrementBeforeExpressionImpl(node);
      }
      else if (type == INEQUALITY_EXPRESSION) {
        return new ApexInequalityExpressionImpl(node);
      }
      else if (type == INNER_CREATOR) {
        return new ApexInnerCreatorImpl(node);
      }
      else if (type == INSTANCE_OF_EXPRESSION) {
        return new ApexInstanceOfExpressionImpl(node);
      }
      else if (type == INSTANTIATION_EXPRESSION) {
        return new ApexInstantiationExpressionImpl(node);
      }
      else if (type == INTERFACE_BODY) {
        return new ApexInterfaceBodyImpl(node);
      }
      else if (type == INTERFACE_DECLARATION) {
        return new ApexInterfaceDeclarationImpl(node);
      }
      else if (type == LESS_EQUAL_EXPRESSION) {
        return new ApexLessEqualExpressionImpl(node);
      }
      else if (type == LESS_THAN_EXPRESSION) {
        return new ApexLessThanExpressionImpl(node);
      }
      else if (type == LIST_COLLECTION) {
        return new ApexListCollectionImpl(node);
      }
      else if (type == LITERAL) {
        return new ApexLiteralImpl(node);
      }
      else if (type == LOCAL_VARIABLE_DECLARATION_STATEMENT) {
        return new ApexLocalVariableDeclarationStatementImpl(node);
      }
      else if (type == LOCAL_VARIABLE_DECLARATOR) {
        return new ApexLocalVariableDeclaratorImpl(node);
      }
      else if (type == LOGICAL_COMPLIMENT_EXPRESSION) {
        return new ApexLogicalComplimentExpressionImpl(node);
      }
      else if (type == MAP_COLLECTION) {
        return new ApexMapCollectionImpl(node);
      }
      else if (type == METHOD_BODY) {
        return new ApexMethodBodyImpl(node);
      }
      else if (type == METHOD_DECLARATION) {
        return new ApexMethodDeclarationImpl(node);
      }
      else if (type == MULTIPLICATION_ASSIGN_EXPRESSION) {
        return new ApexMultiplicationAssignExpressionImpl(node);
      }
      else if (type == MULTIPLICATION_EXPRESSION) {
        return new ApexMultiplicationExpressionImpl(node);
      }
      else if (type == NON_WILDCARD_TYPE_ARGUMENTS) {
        return new ApexNonWildcardTypeArgumentsImpl(node);
      }
      else if (type == NON_WILDCARD_TYPE_ARGUMENTS_OR_DIAMOND) {
        return new ApexNonWildcardTypeArgumentsOrDiamondImpl(node);
      }
      else if (type == OR_ASSIGN_EXPRESSION) {
        return new ApexOrAssignExpressionImpl(node);
      }
      else if (type == OR_EXPRESSION) {
        return new ApexOrExpressionImpl(node);
      }
      else if (type == PARAMETERS) {
        return new ApexParametersImpl(node);
      }
      else if (type == PARAMETER_DEFINITION) {
        return new ApexParameterDefinitionImpl(node);
      }
      else if (type == PRIMARY_EXPRESSION) {
        return new ApexPrimaryExpressionImpl(node);
      }
      else if (type == PRIMITIVE_TYPE) {
        return new ApexPrimitiveTypeImpl(node);
      }
      else if (type == SET_COLLECTION) {
        return new ApexSetCollectionImpl(node);
      }
      else if (type == SHARING_MODIFIER) {
        return new ApexSharingModifierImpl(node);
      }
      else if (type == SHIFT_LEFT_ASSIGN_EXPRESSION) {
        return new ApexShiftLeftAssignExpressionImpl(node);
      }
      else if (type == SHIFT_RIGHT_ASSIGN_EXPRESSION) {
        return new ApexShiftRightAssignExpressionImpl(node);
      }
      else if (type == SHIFT_RIGHT_UNSIGNED_ASSIGN_EXPRESSION) {
        return new ApexShiftRightUnsignedAssignExpressionImpl(node);
      }
      else if (type == STATEMENT) {
        return new ApexStatementImpl(node);
      }
      else if (type == STATIC_BLOCK) {
        return new ApexStaticBlockImpl(node);
      }
      else if (type == STATIC_OR_TRANSIENT_MODIFIER) {
        return new ApexStaticOrTransientModifierImpl(node);
      }
      else if (type == SUBTRACTION_ASSIGN_EXPRESSION) {
        return new ApexSubtractionAssignExpressionImpl(node);
      }
      else if (type == SUBTRACTION_EXPRESSION) {
        return new ApexSubtractionExpressionImpl(node);
      }
      else if (type == SUPER_EXPRESSION) {
        return new ApexSuperExpressionImpl(node);
      }
      else if (type == SUPER_SUFFIX) {
        return new ApexSuperSuffixImpl(node);
      }
      else if (type == TERNARY_EXPRESSION) {
        return new ApexTernaryExpressionImpl(node);
      }
      else if (type == THIS_EXPRESSION) {
        return new ApexThisExpressionImpl(node);
      }
      else if (type == TRIGGER_BODY) {
        return new ApexTriggerBodyImpl(node);
      }
      else if (type == TRIGGER_DEFINITION) {
        return new ApexTriggerDefinitionImpl(node);
      }
      else if (type == TRIGGER_PARAMETER) {
        return new ApexTriggerParameterImpl(node);
      }
      else if (type == TRY_STATEMENT) {
        return new ApexTryStatementImpl(node);
      }
      else if (type == TYPE_ARGUMENT) {
        return new ApexTypeArgumentImpl(node);
      }
      else if (type == TYPE_ARGUMENTS_OR_DIAMOND) {
        return new ApexTypeArgumentsOrDiamondImpl(node);
      }
      else if (type == UNARY_NEGATION_EXPRESSION) {
        return new ApexUnaryNegationExpressionImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new ApexVariableDefinitionImpl(node);
      }
      else if (type == VARIABLE_INITIALIZER) {
        return new ApexVariableInitializerImpl(node);
      }
      else if (type == VARIABLE_MODIFIER) {
        return new ApexVariableModifierImpl(node);
      }
      else if (type == VIRTUAL_OR_ABSTRACT_MODIFIER) {
        return new ApexVirtualOrAbstractModifierImpl(node);
      }
      else if (type == VISIBILITY) {
        return new ApexVisibilityImpl(node);
      }
      else if (type == WEIRD_EXPRESSION) {
        return new ApexWeirdExpressionImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new ApexWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
