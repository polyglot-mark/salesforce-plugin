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
package au.com.borner.salesforce.plugin.apex.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static au.com.borner.salesforce.plugin.apex.psi.ApexTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ApexParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("au.com.borner.salesforce.plugin.apex.parser.ApexParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, EXTENDS_SETS_);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == ADDITION_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 39);
    }
    else if (root_ == ADDITION_EXPRESSION) {
      result_ = expression(builder_, 0, 17);
    }
    else if (root_ == AND_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 44);
    }
    else if (root_ == AND_EXPRESSION) {
      result_ = expression(builder_, 0, 36);
    }
    else if (root_ == ANNOTATION) {
      result_ = annotation(builder_, 0);
    }
    else if (root_ == ANNOTATION_PARAMETER) {
      result_ = annotationParameter(builder_, 0);
    }
    else if (root_ == ANNOTATION_PARAMETER_VALUE) {
      result_ = annotationParameterValue(builder_, 0);
    }
    else if (root_ == ARGUMENTS) {
      result_ = arguments(builder_, 0);
    }
    else if (root_ == ARRAY_CREATOR_REST) {
      result_ = arrayCreatorRest(builder_, 0);
    }
    else if (root_ == ARRAY_INITIALIZER) {
      result_ = arrayInitializer(builder_, 0);
    }
    else if (root_ == ARRAY_POSITION_EXPRESSION) {
      result_ = expression(builder_, 0, 5);
    }
    else if (root_ == ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 38);
    }
    else if (root_ == BITWISE_AND_EXPRESSION) {
      result_ = expression(builder_, 0, 31);
    }
    else if (root_ == BITWISE_EXCLUSIVE_OR_1EXPRESSION) {
      result_ = expression(builder_, 0, 32);
    }
    else if (root_ == BITWISE_EXCLUSIVE_OR_2EXPRESSION) {
      result_ = expression(builder_, 0, 33);
    }
    else if (root_ == BITWISE_OR_EXPRESSION) {
      result_ = expression(builder_, 0, 34);
    }
    else if (root_ == BITWISE_SHIFT_LEFT_EXPRESSION) {
      result_ = expression(builder_, 0, 19);
    }
    else if (root_ == BITWISE_SHIFT_RIGHT_EXPRESSION) {
      result_ = expression(builder_, 0, 20);
    }
    else if (root_ == BITWISE_SHIFT_RIGHT_UNSIGNED_EXPRESSION) {
      result_ = expression(builder_, 0, 21);
    }
    else if (root_ == BLOCK) {
      result_ = block(builder_, 0);
    }
    else if (root_ == BLOCK_STATEMENT) {
      result_ = blockStatement(builder_, 0);
    }
    else if (root_ == BOOLEAN_LITERAL) {
      result_ = booleanLiteral(builder_, 0);
    }
    else if (root_ == CAST_EXPRESSION) {
      result_ = cast_expression(builder_, 0);
    }
    else if (root_ == CATCH_CLAUSE) {
      result_ = catchClause(builder_, 0);
    }
    else if (root_ == CLASS_BODY) {
      result_ = classBody(builder_, 0);
    }
    else if (root_ == CLASS_CREATOR_REST) {
      result_ = classCreatorRest(builder_, 0);
    }
    else if (root_ == CLASS_DECLARATION) {
      result_ = classDeclaration(builder_, 0);
    }
    else if (root_ == CLASS_INTERFACE_OR_PRIMITIVE_TYPE) {
      result_ = classInterfaceOrPrimitiveType(builder_, 0);
    }
    else if (root_ == CLASS_OR_INTERFACE_REFERENCE) {
      result_ = classOrInterfaceReference(builder_, 0);
    }
    else if (root_ == CLASSIC_FOR_STATEMENT) {
      result_ = classicForStatement(builder_, 0);
    }
    else if (root_ == CONSTRUCTOR_BODY) {
      result_ = constructorBody(builder_, 0);
    }
    else if (root_ == CONSTRUCTOR_DECLARATION) {
      result_ = constructorDeclaration(builder_, 0);
    }
    else if (root_ == CREATED_NAME) {
      result_ = createdName(builder_, 0);
    }
    else if (root_ == CREATOR) {
      result_ = creator(builder_, 0);
    }
    else if (root_ == DECREMENT_AFTER_EXPRESSION) {
      result_ = expression(builder_, 0, 10);
    }
    else if (root_ == DECREMENT_BEFORE_EXPRESSION) {
      result_ = decrement_before_expression(builder_, 0);
    }
    else if (root_ == DIVIDE_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 42);
    }
    else if (root_ == DIVISION_EXPRESSION) {
      result_ = expression(builder_, 0, 16);
    }
    else if (root_ == DO_STATEMENT) {
      result_ = doStatement(builder_, 0);
    }
    else if (root_ == ENHANCED_FOR_STATEMENT) {
      result_ = enhancedForStatement(builder_, 0);
    }
    else if (root_ == ENUM_DECLARATION) {
      result_ = enumDeclaration(builder_, 0);
    }
    else if (root_ == EQUALITY_EXPRESSION) {
      result_ = expression(builder_, 0, 29);
    }
    else if (root_ == EXACT_EQUALITY_EXPRESSION) {
      result_ = expression(builder_, 0, 27);
    }
    else if (root_ == EXACT_INEQUALITY_EXPRESSION) {
      result_ = expression(builder_, 0, 28);
    }
    else if (root_ == EXPLICIT_GENERIC_INVOCATION) {
      result_ = explicitGenericInvocation(builder_, 0);
    }
    else if (root_ == EXPLICIT_GENERIC_INVOCATION_SUFFIX) {
      result_ = explicitGenericInvocationSuffix(builder_, 0);
    }
    else if (root_ == EXPRESSION) {
      result_ = expression(builder_, 0, -1);
    }
    else if (root_ == EXPRESSION_LIST) {
      result_ = expressionList(builder_, 0);
    }
    else if (root_ == EXPRESSION_LIST_EXPRESSION) {
      result_ = expression(builder_, 0, 6);
    }
    else if (root_ == EXTENDS_CLAUSE) {
      result_ = extendsClause(builder_, 0);
    }
    else if (root_ == FIELD_DECLARATOR) {
      result_ = fieldDeclarator(builder_, 0);
    }
    else if (root_ == FIELD_VISIBILITY) {
      result_ = fieldVisibility(builder_, 0);
    }
    else if (root_ == FINALLY_BLOCK) {
      result_ = finallyBlock(builder_, 0);
    }
    else if (root_ == FOR_INIT) {
      result_ = forInit(builder_, 0);
    }
    else if (root_ == FOR_UPDATE) {
      result_ = forUpdate(builder_, 0);
    }
    else if (root_ == GENERIC_EXPRESSION) {
      result_ = expression(builder_, 0, 4);
    }
    else if (root_ == GREATER_EQUAL_EXPRESSION) {
      result_ = expression(builder_, 0, 22);
    }
    else if (root_ == GREATER_THAN_EXPRESSION) {
      result_ = expression(builder_, 0, 24);
    }
    else if (root_ == IDENTIFIER_EXPRESSION) {
      result_ = expression(builder_, 0, 0);
    }
    else if (root_ == IF_STATEMENT) {
      result_ = ifStatement(builder_, 0);
    }
    else if (root_ == IMPLEMENTS_CLAUSE) {
      result_ = implementsClause(builder_, 0);
    }
    else if (root_ == INCREMENT_AFTER_EXPRESSION) {
      result_ = expression(builder_, 0, 9);
    }
    else if (root_ == INCREMENT_BEFORE_EXPRESSION) {
      result_ = increment_before_expression(builder_, 0);
    }
    else if (root_ == INEQUALITY_EXPRESSION) {
      result_ = expression(builder_, 0, 30);
    }
    else if (root_ == INNER_CREATOR) {
      result_ = innerCreator(builder_, 0);
    }
    else if (root_ == INSTANCE_OF_EXPRESSION) {
      result_ = expression(builder_, 0, 26);
    }
    else if (root_ == INSTANTIATION_EXPRESSION) {
      result_ = instantiation_expression(builder_, 0);
    }
    else if (root_ == INTERFACE_BODY) {
      result_ = interfaceBody(builder_, 0);
    }
    else if (root_ == INTERFACE_DECLARATION) {
      result_ = interfaceDeclaration(builder_, 0);
    }
    else if (root_ == LESS_EQUAL_EXPRESSION) {
      result_ = expression(builder_, 0, 23);
    }
    else if (root_ == LESS_THAN_EXPRESSION) {
      result_ = expression(builder_, 0, 25);
    }
    else if (root_ == LIST_COLLECTION) {
      result_ = listCollection(builder_, 0);
    }
    else if (root_ == LITERAL) {
      result_ = literal(builder_, 0);
    }
    else if (root_ == LOCAL_VARIABLE_DECLARATION_STATEMENT) {
      result_ = localVariableDeclarationStatement(builder_, 0);
    }
    else if (root_ == LOCAL_VARIABLE_DECLARATOR) {
      result_ = localVariableDeclarator(builder_, 0);
    }
    else if (root_ == LOGICAL_COMPLIMENT_EXPRESSION) {
      result_ = logical_compliment_expression(builder_, 0);
    }
    else if (root_ == MAP_COLLECTION) {
      result_ = mapCollection(builder_, 0);
    }
    else if (root_ == METHOD_BODY) {
      result_ = methodBody(builder_, 0);
    }
    else if (root_ == METHOD_DECLARATION) {
      result_ = methodDeclaration(builder_, 0);
    }
    else if (root_ == MULTIPLICATION_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 40);
    }
    else if (root_ == MULTIPLICATION_EXPRESSION) {
      result_ = expression(builder_, 0, 15);
    }
    else if (root_ == NON_WILDCARD_TYPE_ARGUMENTS) {
      result_ = nonWildcardTypeArguments(builder_, 0);
    }
    else if (root_ == NON_WILDCARD_TYPE_ARGUMENTS_OR_DIAMOND) {
      result_ = nonWildcardTypeArgumentsOrDiamond(builder_, 0);
    }
    else if (root_ == OR_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 43);
    }
    else if (root_ == OR_EXPRESSION) {
      result_ = expression(builder_, 0, 35);
    }
    else if (root_ == PARAMETER_DEFINITION) {
      result_ = parameterDefinition(builder_, 0);
    }
    else if (root_ == PARAMETERS) {
      result_ = parameters(builder_, 0);
    }
    else if (root_ == PRIMARY_EXPRESSION) {
      result_ = primary_expression(builder_, 0);
    }
    else if (root_ == PRIMITIVE_TYPE) {
      result_ = primitiveType(builder_, 0);
    }
    else if (root_ == SET_COLLECTION) {
      result_ = setCollection(builder_, 0);
    }
    else if (root_ == SHARING_MODIFIER) {
      result_ = sharingModifier(builder_, 0);
    }
    else if (root_ == SHIFT_LEFT_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 47);
    }
    else if (root_ == SHIFT_RIGHT_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 45);
    }
    else if (root_ == SHIFT_RIGHT_UNSIGNED_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 46);
    }
    else if (root_ == STATEMENT) {
      result_ = statement(builder_, 0);
    }
    else if (root_ == STATIC_BLOCK) {
      result_ = staticBlock(builder_, 0);
    }
    else if (root_ == STATIC_OR_TRANSIENT_MODIFIER) {
      result_ = staticOrTransientModifier(builder_, 0);
    }
    else if (root_ == SUBTRACTION_ASSIGN_EXPRESSION) {
      result_ = expression(builder_, 0, 41);
    }
    else if (root_ == SUBTRACTION_EXPRESSION) {
      result_ = expression(builder_, 0, 18);
    }
    else if (root_ == SUPER_SUFFIX) {
      result_ = superSuffix(builder_, 0);
    }
    else if (root_ == SUPER_EXPRESSION) {
      result_ = expression(builder_, 0, 3);
    }
    else if (root_ == TERNARY_EXPRESSION) {
      result_ = expression(builder_, 0, 37);
    }
    else if (root_ == THIS_EXPRESSION) {
      result_ = expression(builder_, 0, 1);
    }
    else if (root_ == TRIGGER_BODY) {
      result_ = triggerBody(builder_, 0);
    }
    else if (root_ == TRIGGER_DEFINITION) {
      result_ = triggerDefinition(builder_, 0);
    }
    else if (root_ == TRIGGER_PARAMETER) {
      result_ = triggerParameter(builder_, 0);
    }
    else if (root_ == TRY_STATEMENT) {
      result_ = tryStatement(builder_, 0);
    }
    else if (root_ == TYPE_ARGUMENT) {
      result_ = typeArgument(builder_, 0);
    }
    else if (root_ == TYPE_ARGUMENTS_OR_DIAMOND) {
      result_ = typeArgumentsOrDiamond(builder_, 0);
    }
    else if (root_ == UNARY_NEGATION_EXPRESSION) {
      result_ = unary_negation_expression(builder_, 0);
    }
    else if (root_ == VARIABLE_DEFINITION) {
      result_ = variableDefinition(builder_, 0);
    }
    else if (root_ == VARIABLE_INITIALIZER) {
      result_ = variableInitializer(builder_, 0);
    }
    else if (root_ == VARIABLE_MODIFIER) {
      result_ = variableModifier(builder_, 0);
    }
    else if (root_ == VIRTUAL_OR_ABSTRACT_MODIFIER) {
      result_ = virtualOrAbstractModifier(builder_, 0);
    }
    else if (root_ == VISIBILITY) {
      result_ = visibility(builder_, 0);
    }
    else if (root_ == WEIRD_EXPRESSION) {
      result_ = expression(builder_, 0, 2);
    }
    else if (root_ == WHILE_STATEMENT) {
      result_ = whileStatement(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return apexFile(builder_, level_ + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ADDITION_ASSIGN_EXPRESSION, ADDITION_EXPRESSION, AND_ASSIGN_EXPRESSION, AND_EXPRESSION,
      ARRAY_POSITION_EXPRESSION, ASSIGN_EXPRESSION, BITWISE_AND_EXPRESSION, BITWISE_EXCLUSIVE_OR_1EXPRESSION,
      BITWISE_EXCLUSIVE_OR_2EXPRESSION, BITWISE_OR_EXPRESSION, BITWISE_SHIFT_LEFT_EXPRESSION, BITWISE_SHIFT_RIGHT_EXPRESSION,
      BITWISE_SHIFT_RIGHT_UNSIGNED_EXPRESSION, CAST_EXPRESSION, DECREMENT_AFTER_EXPRESSION, DECREMENT_BEFORE_EXPRESSION,
      DIVIDE_ASSIGN_EXPRESSION, DIVISION_EXPRESSION, EQUALITY_EXPRESSION, EXACT_EQUALITY_EXPRESSION,
      EXACT_INEQUALITY_EXPRESSION, EXPRESSION, EXPRESSION_LIST_EXPRESSION, GENERIC_EXPRESSION,
      GREATER_EQUAL_EXPRESSION, GREATER_THAN_EXPRESSION, IDENTIFIER_EXPRESSION, INCREMENT_AFTER_EXPRESSION,
      INCREMENT_BEFORE_EXPRESSION, INEQUALITY_EXPRESSION, INSTANCE_OF_EXPRESSION, INSTANTIATION_EXPRESSION,
      LESS_EQUAL_EXPRESSION, LESS_THAN_EXPRESSION, LOGICAL_COMPLIMENT_EXPRESSION, MULTIPLICATION_ASSIGN_EXPRESSION,
      MULTIPLICATION_EXPRESSION, OR_ASSIGN_EXPRESSION, OR_EXPRESSION, PRIMARY_EXPRESSION,
      SHIFT_LEFT_ASSIGN_EXPRESSION, SHIFT_RIGHT_ASSIGN_EXPRESSION, SHIFT_RIGHT_UNSIGNED_ASSIGN_EXPRESSION, SUBTRACTION_ASSIGN_EXPRESSION,
      SUBTRACTION_EXPRESSION, SUPER_EXPRESSION, TERNARY_EXPRESSION, THIS_EXPRESSION,
      UNARY_NEGATION_EXPRESSION, WEIRD_EXPRESSION),
  };

  /* ********************************************************** */
  // '@' identifier ( '(' annotationParameters ')' )?
  public static boolean annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation")) return false;
    if (!nextTokenIs(builder_, AT_SIGN)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, AT_SIGN);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    pinned_ = result_; // pin = 2
    result_ = result_ && annotation_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ANNOTATION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ( '(' annotationParameters ')' )?
  private static boolean annotation_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_2")) return false;
    annotation_2_0(builder_, level_ + 1);
    return true;
  }

  // '(' annotationParameters ')'
  private static boolean annotation_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && annotationParameters(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier '=' annotationParameterValue
  public static boolean annotationParameter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotationParameter")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, IDENTIFIER);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OPERATOR_ASSIGNMENT));
    result_ = pinned_ && annotationParameterValue(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, ANNOTATION_PARAMETER, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // STRING_LITERAL | booleanLiteral
  public static boolean annotationParameterValue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotationParameterValue")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<annotation parameter value>");
    result_ = consumeToken(builder_, STRING_LITERAL);
    if (!result_) result_ = booleanLiteral(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ANNOTATION_PARAMETER_VALUE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // annotationParameter (',' annotationParameter)*
  static boolean annotationParameters(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotationParameters")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = annotationParameter(builder_, level_ + 1);
    result_ = result_ && annotationParameters_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (',' annotationParameter)*
  private static boolean annotationParameters_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotationParameters_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!annotationParameters_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "annotationParameters_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' annotationParameter
  private static boolean annotationParameters_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotationParameters_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && annotationParameter(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // interfaceDeclaration
  //     |   classDeclaration
  //     |   triggerDefinition
  //     |   enumDeclaration
  static boolean apexFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "apexFile")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = interfaceDeclaration(builder_, level_ + 1);
    if (!result_) result_ = classDeclaration(builder_, level_ + 1);
    if (!result_) result_ = triggerDefinition(builder_, level_ + 1);
    if (!result_) result_ = enumDeclaration(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '(' expressionList? ')'
  public static boolean arguments(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arguments")) return false;
    if (!nextTokenIs(builder_, LPAREN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && arguments_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, ARGUMENTS, result_);
    return result_;
  }

  // expressionList?
  private static boolean arguments_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arguments_1")) return false;
    expressionList(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '['
  //         (   ']' ('[' ']')* arrayInitializer
  //         |   expression ']' ('[' expression ']')* ('[' ']')*
  //         )
  public static boolean arrayCreatorRest(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest")) return false;
    if (!nextTokenIs(builder_, LBRACK)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACK);
    result_ = result_ && arrayCreatorRest_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, ARRAY_CREATOR_REST, result_);
    return result_;
  }

  // ']' ('[' ']')* arrayInitializer
  //         |   expression ']' ('[' expression ']')* ('[' ']')*
  private static boolean arrayCreatorRest_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = arrayCreatorRest_1_0(builder_, level_ + 1);
    if (!result_) result_ = arrayCreatorRest_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ']' ('[' ']')* arrayInitializer
  private static boolean arrayCreatorRest_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RBRACK);
    result_ = result_ && arrayCreatorRest_1_0_1(builder_, level_ + 1);
    result_ = result_ && arrayInitializer(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('[' ']')*
  private static boolean arrayCreatorRest_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1_0_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!arrayCreatorRest_1_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arrayCreatorRest_1_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // '[' ']'
  private static boolean arrayCreatorRest_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACK);
    result_ = result_ && consumeToken(builder_, RBRACK);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // expression ']' ('[' expression ']')* ('[' ']')*
  private static boolean arrayCreatorRest_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = expression(builder_, level_ + 1, -1);
    result_ = result_ && consumeToken(builder_, RBRACK);
    result_ = result_ && arrayCreatorRest_1_1_2(builder_, level_ + 1);
    result_ = result_ && arrayCreatorRest_1_1_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('[' expression ']')*
  private static boolean arrayCreatorRest_1_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1_1_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!arrayCreatorRest_1_1_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arrayCreatorRest_1_1_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // '[' expression ']'
  private static boolean arrayCreatorRest_1_1_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1_1_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACK);
    result_ = result_ && expression(builder_, level_ + 1, -1);
    result_ = result_ && consumeToken(builder_, RBRACK);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('[' ']')*
  private static boolean arrayCreatorRest_1_1_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1_1_3")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!arrayCreatorRest_1_1_3_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arrayCreatorRest_1_1_3", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // '[' ']'
  private static boolean arrayCreatorRest_1_1_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayCreatorRest_1_1_3_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACK);
    result_ = result_ && consumeToken(builder_, RBRACK);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '{' (variableInitializer (',' variableInitializer)* (',')? )? '}'
  public static boolean arrayInitializer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayInitializer")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, arrayInitializer_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, ARRAY_INITIALIZER, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (variableInitializer (',' variableInitializer)* (',')? )?
  private static boolean arrayInitializer_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayInitializer_1")) return false;
    arrayInitializer_1_0(builder_, level_ + 1);
    return true;
  }

  // variableInitializer (',' variableInitializer)* (',')?
  private static boolean arrayInitializer_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayInitializer_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = variableInitializer(builder_, level_ + 1);
    result_ = result_ && arrayInitializer_1_0_1(builder_, level_ + 1);
    result_ = result_ && arrayInitializer_1_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (',' variableInitializer)*
  private static boolean arrayInitializer_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayInitializer_1_0_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!arrayInitializer_1_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arrayInitializer_1_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' variableInitializer
  private static boolean arrayInitializer_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayInitializer_1_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && variableInitializer(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (',')?
  private static boolean arrayInitializer_1_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayInitializer_1_0_2")) return false;
    arrayInitializer_1_0_2_0(builder_, level_ + 1);
    return true;
  }

  // (',')
  private static boolean arrayInitializer_1_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayInitializer_1_0_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '{' blockStatement* '}'
  public static boolean block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "block")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACE);
    result_ = result_ && block_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, BLOCK, result_);
    return result_;
  }

  // blockStatement*
  private static boolean block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "block_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!blockStatement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "block_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // localVariableDeclarationStatement
  //     |   statement
  //     |   classDeclaration
  //     |   interfaceDeclaration
  public static boolean blockStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "blockStatement")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<block statement>");
    result_ = localVariableDeclarationStatement(builder_, level_ + 1);
    if (!result_) result_ = statement(builder_, level_ + 1);
    if (!result_) result_ = classDeclaration(builder_, level_ + 1);
    if (!result_) result_ = interfaceDeclaration(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, BLOCK_STATEMENT, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // true
  //     |   false
  public static boolean booleanLiteral(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "booleanLiteral")) return false;
    if (!nextTokenIs(builder_, "<boolean literal>", FALSE, TRUE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<boolean literal>");
    result_ = consumeToken(builder_, TRUE);
    if (!result_) result_ = consumeToken(builder_, FALSE);
    exit_section_(builder_, level_, marker_, BOOLEAN_LITERAL, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // catch '(' variableModifier? classOrInterfaceReference identifier ')' block
  public static boolean catchClause(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "catchClause")) return false;
    if (!nextTokenIs(builder_, CATCH)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, CATCH);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LPAREN));
    result_ = pinned_ && report_error_(builder_, catchClause_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, classOrInterfaceReference(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RPAREN)) && result_;
    result_ = pinned_ && block(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, CATCH_CLAUSE, result_, pinned_, null);
    return result_ || pinned_;
  }

  // variableModifier?
  private static boolean catchClause_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "catchClause_2")) return false;
    variableModifier(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' '}'
  //     |   '{' (members | staticBlock | block)* '}'
  public static boolean classBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classBody")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = classBody_0(builder_, level_ + 1);
    if (!result_) result_ = classBody_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, CLASS_BODY, result_);
    return result_;
  }

  // '{' '}'
  private static boolean classBody_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classBody_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACE);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '{' (members | staticBlock | block)* '}'
  private static boolean classBody_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classBody_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACE);
    result_ = result_ && classBody_1_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (members | staticBlock | block)*
  private static boolean classBody_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classBody_1_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!classBody_1_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "classBody_1_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // members | staticBlock | block
  private static boolean classBody_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classBody_1_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = members(builder_, level_ + 1);
    if (!result_) result_ = staticBlock(builder_, level_ + 1);
    if (!result_) result_ = block(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // arguments classBody?
  public static boolean classCreatorRest(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classCreatorRest")) return false;
    if (!nextTokenIs(builder_, LPAREN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = arguments(builder_, level_ + 1);
    result_ = result_ && classCreatorRest_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, CLASS_CREATOR_REST, result_);
    return result_;
  }

  // classBody?
  private static boolean classCreatorRest_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classCreatorRest_1")) return false;
    classBody(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // annotation* visibility? virtualOrAbstractModifier? sharingModifier? CLASS_KEYWORD identifier extendsClause? implementsClause? classBody
  public static boolean classDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classDeclaration")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<class declaration>");
    result_ = classDeclaration_0(builder_, level_ + 1);
    result_ = result_ && classDeclaration_1(builder_, level_ + 1);
    result_ = result_ && classDeclaration_2(builder_, level_ + 1);
    result_ = result_ && classDeclaration_3(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 2, CLASS_KEYWORD, IDENTIFIER);
    pinned_ = result_; // pin = 6
    result_ = result_ && report_error_(builder_, classDeclaration_6(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, classDeclaration_7(builder_, level_ + 1)) && result_;
    result_ = pinned_ && classBody(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, CLASS_DECLARATION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // annotation*
  private static boolean classDeclaration_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classDeclaration_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!annotation(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "classDeclaration_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // visibility?
  private static boolean classDeclaration_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classDeclaration_1")) return false;
    visibility(builder_, level_ + 1);
    return true;
  }

  // virtualOrAbstractModifier?
  private static boolean classDeclaration_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classDeclaration_2")) return false;
    virtualOrAbstractModifier(builder_, level_ + 1);
    return true;
  }

  // sharingModifier?
  private static boolean classDeclaration_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classDeclaration_3")) return false;
    sharingModifier(builder_, level_ + 1);
    return true;
  }

  // extendsClause?
  private static boolean classDeclaration_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classDeclaration_6")) return false;
    extendsClause(builder_, level_ + 1);
    return true;
  }

  // implementsClause?
  private static boolean classDeclaration_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classDeclaration_7")) return false;
    implementsClause(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // classOrInterfaceReference ('[' ']')?
  //     |   primitiveType ('[' ']')?
  //     |   collectionType
  public static boolean classInterfaceOrPrimitiveType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classInterfaceOrPrimitiveType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<class interface or primitive type>");
    result_ = classInterfaceOrPrimitiveType_0(builder_, level_ + 1);
    if (!result_) result_ = classInterfaceOrPrimitiveType_1(builder_, level_ + 1);
    if (!result_) result_ = collectionType(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, CLASS_INTERFACE_OR_PRIMITIVE_TYPE, result_, false, null);
    return result_;
  }

  // classOrInterfaceReference ('[' ']')?
  private static boolean classInterfaceOrPrimitiveType_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classInterfaceOrPrimitiveType_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = classOrInterfaceReference(builder_, level_ + 1);
    result_ = result_ && classInterfaceOrPrimitiveType_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('[' ']')?
  private static boolean classInterfaceOrPrimitiveType_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classInterfaceOrPrimitiveType_0_1")) return false;
    classInterfaceOrPrimitiveType_0_1_0(builder_, level_ + 1);
    return true;
  }

  // '[' ']'
  private static boolean classInterfaceOrPrimitiveType_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classInterfaceOrPrimitiveType_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACK);
    result_ = result_ && consumeToken(builder_, RBRACK);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // primitiveType ('[' ']')?
  private static boolean classInterfaceOrPrimitiveType_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classInterfaceOrPrimitiveType_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = primitiveType(builder_, level_ + 1);
    result_ = result_ && classInterfaceOrPrimitiveType_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('[' ']')?
  private static boolean classInterfaceOrPrimitiveType_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classInterfaceOrPrimitiveType_1_1")) return false;
    classInterfaceOrPrimitiveType_1_1_0(builder_, level_ + 1);
    return true;
  }

  // '[' ']'
  private static boolean classInterfaceOrPrimitiveType_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classInterfaceOrPrimitiveType_1_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACK);
    result_ = result_ && consumeToken(builder_, RBRACK);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean classOrInterfaceReference(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classOrInterfaceReference")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, CLASS_OR_INTERFACE_REFERENCE, result_);
    return result_;
  }

  /* ********************************************************** */
  // for '(' forInit? ';' expression? ';' forUpdate? ')' statement
  public static boolean classicForStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classicForStatement")) return false;
    if (!nextTokenIs(builder_, FOR)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, FOR);
    result_ = result_ && consumeToken(builder_, LPAREN);
    result_ = result_ && classicForStatement_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMI);
    pinned_ = result_; // pin = 4
    result_ = result_ && report_error_(builder_, classicForStatement_4(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, SEMI)) && result_;
    result_ = pinned_ && report_error_(builder_, classicForStatement_6(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RPAREN)) && result_;
    result_ = pinned_ && statement(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, CLASSIC_FOR_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  // forInit?
  private static boolean classicForStatement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classicForStatement_2")) return false;
    forInit(builder_, level_ + 1);
    return true;
  }

  // expression?
  private static boolean classicForStatement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classicForStatement_4")) return false;
    expression(builder_, level_ + 1, -1);
    return true;
  }

  // forUpdate?
  private static boolean classicForStatement_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classicForStatement_6")) return false;
    forUpdate(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // listCollection | setCollection | mapCollection
  static boolean collectionType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "collectionType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = listCollection(builder_, level_ + 1);
    if (!result_) result_ = setCollection(builder_, level_ + 1);
    if (!result_) result_ = mapCollection(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // block
  public static boolean constructorBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "constructorBody")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = block(builder_, level_ + 1);
    exit_section_(builder_, marker_, CONSTRUCTOR_BODY, result_);
    return result_;
  }

  /* ********************************************************** */
  // visibility? identifier parameters constructorBody
  public static boolean constructorDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "constructorDeclaration")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<constructor declaration>");
    result_ = constructorDeclaration_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && parameters(builder_, level_ + 1);
    pinned_ = result_; // pin = 3
    result_ = result_ && constructorBody(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, CONSTRUCTOR_DECLARATION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // visibility?
  private static boolean constructorDeclaration_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "constructorDeclaration_0")) return false;
    visibility(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier typeArgumentsOrDiamond? ('.' identifier typeArgumentsOrDiamond?)*
  //     |   primitiveType
  public static boolean createdName(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "createdName")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<created name>");
    result_ = createdName_0(builder_, level_ + 1);
    if (!result_) result_ = primitiveType(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, CREATED_NAME, result_, false, null);
    return result_;
  }

  // identifier typeArgumentsOrDiamond? ('.' identifier typeArgumentsOrDiamond?)*
  private static boolean createdName_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "createdName_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && createdName_0_1(builder_, level_ + 1);
    result_ = result_ && createdName_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // typeArgumentsOrDiamond?
  private static boolean createdName_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "createdName_0_1")) return false;
    typeArgumentsOrDiamond(builder_, level_ + 1);
    return true;
  }

  // ('.' identifier typeArgumentsOrDiamond?)*
  private static boolean createdName_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "createdName_0_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!createdName_0_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "createdName_0_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // '.' identifier typeArgumentsOrDiamond?
  private static boolean createdName_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "createdName_0_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && createdName_0_2_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // typeArgumentsOrDiamond?
  private static boolean createdName_0_2_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "createdName_0_2_0_2")) return false;
    typeArgumentsOrDiamond(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // nonWildcardTypeArguments createdName classCreatorRest
  //     |   createdName (arrayCreatorRest | classCreatorRest)
  public static boolean creator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "creator")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<creator>");
    result_ = creator_0(builder_, level_ + 1);
    if (!result_) result_ = creator_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, CREATOR, result_, false, null);
    return result_;
  }

  // nonWildcardTypeArguments createdName classCreatorRest
  private static boolean creator_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "creator_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = nonWildcardTypeArguments(builder_, level_ + 1);
    result_ = result_ && createdName(builder_, level_ + 1);
    result_ = result_ && classCreatorRest(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // createdName (arrayCreatorRest | classCreatorRest)
  private static boolean creator_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "creator_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = createdName(builder_, level_ + 1);
    result_ = result_ && creator_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // arrayCreatorRest | classCreatorRest
  private static boolean creator_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "creator_1_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = arrayCreatorRest(builder_, level_ + 1);
    if (!result_) result_ = classCreatorRest(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // do statement while '(' expression ')' ';'
  public static boolean doStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "doStatement")) return false;
    if (!nextTokenIs(builder_, DO)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, DO);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, statement(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, WHILE)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LPAREN)) && result_;
    result_ = pinned_ && report_error_(builder_, expression(builder_, level_ + 1, -1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RPAREN)) && result_;
    result_ = pinned_ && consumeToken(builder_, SEMI) && result_;
    exit_section_(builder_, level_, marker_, DO_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // for '(' variableModifier? classInterfaceOrPrimitiveType identifier ':' expression ')' statement
  public static boolean enhancedForStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enhancedForStatement")) return false;
    if (!nextTokenIs(builder_, FOR)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, FOR);
    result_ = result_ && consumeToken(builder_, LPAREN);
    result_ = result_ && enhancedForStatement_2(builder_, level_ + 1);
    result_ = result_ && classInterfaceOrPrimitiveType(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && consumeToken(builder_, OPERATOR_COLON);
    pinned_ = result_; // pin = 6
    result_ = result_ && report_error_(builder_, expression(builder_, level_ + 1, -1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RPAREN)) && result_;
    result_ = pinned_ && statement(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, ENHANCED_FOR_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  // variableModifier?
  private static boolean enhancedForStatement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enhancedForStatement_2")) return false;
    variableModifier(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // annotation* visibility? enum identifier '{' enumIdentifiers '}'
  public static boolean enumDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumDeclaration")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<enum declaration>");
    result_ = enumDeclaration_0(builder_, level_ + 1);
    result_ = result_ && enumDeclaration_1(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 1, ENUM, IDENTIFIER);
    pinned_ = result_; // pin = 3
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LBRACE));
    result_ = pinned_ && report_error_(builder_, enumIdentifiers(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, ENUM_DECLARATION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // annotation*
  private static boolean enumDeclaration_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumDeclaration_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!annotation(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "enumDeclaration_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // visibility?
  private static boolean enumDeclaration_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumDeclaration_1")) return false;
    visibility(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier (',' identifier)*
  static boolean enumIdentifiers(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumIdentifiers")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && enumIdentifiers_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (',' identifier)*
  private static boolean enumIdentifiers_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumIdentifiers_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!enumIdentifiers_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "enumIdentifiers_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' identifier
  private static boolean enumIdentifiers_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumIdentifiers_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // nonWildcardTypeArguments explicitGenericInvocationSuffix
  public static boolean explicitGenericInvocation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "explicitGenericInvocation")) return false;
    if (!nextTokenIs(builder_, OPERATOR_LESS_THAN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = nonWildcardTypeArguments(builder_, level_ + 1);
    result_ = result_ && explicitGenericInvocationSuffix(builder_, level_ + 1);
    exit_section_(builder_, marker_, EXPLICIT_GENERIC_INVOCATION, result_);
    return result_;
  }

  /* ********************************************************** */
  // super superSuffix
  //     |   identifier arguments
  public static boolean explicitGenericInvocationSuffix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "explicitGenericInvocationSuffix")) return false;
    if (!nextTokenIs(builder_, "<explicit generic invocation suffix>", IDENTIFIER, SUPER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<explicit generic invocation suffix>");
    result_ = explicitGenericInvocationSuffix_0(builder_, level_ + 1);
    if (!result_) result_ = explicitGenericInvocationSuffix_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EXPLICIT_GENERIC_INVOCATION_SUFFIX, result_, false, null);
    return result_;
  }

  // super superSuffix
  private static boolean explicitGenericInvocationSuffix_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "explicitGenericInvocationSuffix_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SUPER);
    result_ = result_ && superSuffix(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // identifier arguments
  private static boolean explicitGenericInvocationSuffix_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "explicitGenericInvocationSuffix_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && arguments(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // expression (',' expression)*
  public static boolean expressionList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionList")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<expression list>");
    result_ = expression(builder_, level_ + 1, -1);
    result_ = result_ && expressionList_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EXPRESSION_LIST, result_, false, null);
    return result_;
  }

  // (',' expression)*
  private static boolean expressionList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionList_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!expressionList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "expressionList_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' expression
  private static boolean expressionList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionList_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && expression(builder_, level_ + 1, -1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // extends classOrInterfaceReference
  public static boolean extendsClause(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "extendsClause")) return false;
    if (!nextTokenIs(builder_, EXTENDS)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EXTENDS);
    result_ = result_ && classOrInterfaceReference(builder_, level_ + 1);
    exit_section_(builder_, marker_, EXTENDS_CLAUSE, result_);
    return result_;
  }

  /* ********************************************************** */
  // fieldVisibility? classInterfaceOrPrimitiveType variableDeclarators ';'
  public static boolean fieldDeclarator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldDeclarator")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<field declarator>");
    result_ = fieldDeclarator_0(builder_, level_ + 1);
    result_ = result_ && classInterfaceOrPrimitiveType(builder_, level_ + 1);
    result_ = result_ && variableDeclarators(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMI);
    exit_section_(builder_, level_, marker_, FIELD_DECLARATOR, result_, false, null);
    return result_;
  }

  // fieldVisibility?
  private static boolean fieldDeclarator_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldDeclarator_0")) return false;
    fieldVisibility(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // public | private | global | protected
  public static boolean fieldVisibility(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldVisibility")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<field visibility>");
    result_ = consumeToken(builder_, PUBLIC);
    if (!result_) result_ = consumeToken(builder_, PRIVATE);
    if (!result_) result_ = consumeToken(builder_, GLOBAL);
    if (!result_) result_ = consumeToken(builder_, PROTECTED);
    exit_section_(builder_, level_, marker_, FIELD_VISIBILITY, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // finally block
  public static boolean finallyBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "finallyBlock")) return false;
    if (!nextTokenIs(builder_, FINALLY)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, FINALLY);
    pinned_ = result_; // pin = 1
    result_ = result_ && block(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, FINALLY_BLOCK, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // localVariableDeclarator
  //     |    expressionList
  public static boolean forInit(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forInit")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<for init>");
    result_ = localVariableDeclarator(builder_, level_ + 1);
    if (!result_) result_ = expressionList(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, FOR_INIT, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // expressionList
  public static boolean forUpdate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forUpdate")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<for update>");
    result_ = expressionList(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, FOR_UPDATE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // if '(' expression ')' statement (else statement)?
  public static boolean ifStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifStatement")) return false;
    if (!nextTokenIs(builder_, IF)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, IF);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LPAREN));
    result_ = pinned_ && report_error_(builder_, expression(builder_, level_ + 1, -1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RPAREN)) && result_;
    result_ = pinned_ && report_error_(builder_, statement(builder_, level_ + 1)) && result_;
    result_ = pinned_ && ifStatement_5(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, IF_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (else statement)?
  private static boolean ifStatement_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifStatement_5")) return false;
    ifStatement_5_0(builder_, level_ + 1);
    return true;
  }

  // else statement
  private static boolean ifStatement_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifStatement_5_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ELSE);
    result_ = result_ && statement(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // implements classOrInterfaceReference (',' classOrInterfaceReference)*
  public static boolean implementsClause(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "implementsClause")) return false;
    if (!nextTokenIs(builder_, IMPLEMENTS)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, IMPLEMENTS);
    result_ = result_ && classOrInterfaceReference(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && implementsClause_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, IMPLEMENTS_CLAUSE, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (',' classOrInterfaceReference)*
  private static boolean implementsClause_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "implementsClause_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!implementsClause_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "implementsClause_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' classOrInterfaceReference
  private static boolean implementsClause_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "implementsClause_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && classOrInterfaceReference(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier nonWildcardTypeArgumentsOrDiamond? classCreatorRest
  public static boolean innerCreator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "innerCreator")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && innerCreator_1(builder_, level_ + 1);
    result_ = result_ && classCreatorRest(builder_, level_ + 1);
    exit_section_(builder_, marker_, INNER_CREATOR, result_);
    return result_;
  }

  // nonWildcardTypeArgumentsOrDiamond?
  private static boolean innerCreator_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "innerCreator_1")) return false;
    nonWildcardTypeArgumentsOrDiamond(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' '}'
  public static boolean interfaceBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "interfaceBody")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACE);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, INTERFACE_BODY, result_);
    return result_;
  }

  /* ********************************************************** */
  // visibility? virtual? interface identifier extendsClause? interfaceBody
  public static boolean interfaceDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "interfaceDeclaration")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<interface declaration>");
    result_ = interfaceDeclaration_0(builder_, level_ + 1);
    result_ = result_ && interfaceDeclaration_1(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 2, INTERFACE, IDENTIFIER);
    pinned_ = result_; // pin = 4
    result_ = result_ && report_error_(builder_, interfaceDeclaration_4(builder_, level_ + 1));
    result_ = pinned_ && interfaceBody(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, INTERFACE_DECLARATION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // visibility?
  private static boolean interfaceDeclaration_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "interfaceDeclaration_0")) return false;
    visibility(builder_, level_ + 1);
    return true;
  }

  // virtual?
  private static boolean interfaceDeclaration_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "interfaceDeclaration_1")) return false;
    consumeToken(builder_, VIRTUAL);
    return true;
  }

  // extendsClause?
  private static boolean interfaceDeclaration_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "interfaceDeclaration_4")) return false;
    extendsClause(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // List '<' typeArgument '>'
  public static boolean listCollection(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "listCollection")) return false;
    if (!nextTokenIs(builder_, LIST)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, LIST);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OPERATOR_LESS_THAN));
    result_ = pinned_ && report_error_(builder_, typeArgument(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, OPERATOR_GREATER_THAN) && result_;
    exit_section_(builder_, level_, marker_, LIST_COLLECTION, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // INTEGER_LITERAL
  //     |   DECIMAL_LITERAL
  //     |   LONG_LITERAL
  //     |   STRING_LITERAL
  //     |   booleanLiteral
  //     |   null
  public static boolean literal(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literal")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<literal>");
    result_ = consumeToken(builder_, INTEGER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, DECIMAL_LITERAL);
    if (!result_) result_ = consumeToken(builder_, LONG_LITERAL);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    if (!result_) result_ = booleanLiteral(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NULL);
    exit_section_(builder_, level_, marker_, LITERAL, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // localVariableDeclarator ';'
  public static boolean localVariableDeclarationStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "localVariableDeclarationStatement")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<local variable declaration statement>");
    result_ = localVariableDeclarator(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMI);
    exit_section_(builder_, level_, marker_, LOCAL_VARIABLE_DECLARATION_STATEMENT, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // variableModifier? classInterfaceOrPrimitiveType variableDeclarators
  public static boolean localVariableDeclarator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "localVariableDeclarator")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<local variable declarator>");
    result_ = localVariableDeclarator_0(builder_, level_ + 1);
    result_ = result_ && classInterfaceOrPrimitiveType(builder_, level_ + 1);
    result_ = result_ && variableDeclarators(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, LOCAL_VARIABLE_DECLARATOR, result_, false, null);
    return result_;
  }

  // variableModifier?
  private static boolean localVariableDeclarator_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "localVariableDeclarator_0")) return false;
    variableModifier(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // Map '<' typeArgument ',' typeArgument '>'
  public static boolean mapCollection(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mapCollection")) return false;
    if (!nextTokenIs(builder_, MAP)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, MAP);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OPERATOR_LESS_THAN));
    result_ = pinned_ && report_error_(builder_, typeArgument(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, COMMA)) && result_;
    result_ = pinned_ && report_error_(builder_, typeArgument(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, OPERATOR_GREATER_THAN) && result_;
    exit_section_(builder_, level_, marker_, MAP_COLLECTION, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // constructorDeclaration
  //     |   fieldDeclarator
  //     |   methodDeclaration
  //     |   interfaceDeclaration
  //     |   classDeclaration
  static boolean members(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "members")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = constructorDeclaration(builder_, level_ + 1);
    if (!result_) result_ = fieldDeclarator(builder_, level_ + 1);
    if (!result_) result_ = methodDeclaration(builder_, level_ + 1);
    if (!result_) result_ = interfaceDeclaration(builder_, level_ + 1);
    if (!result_) result_ = classDeclaration(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // block
  public static boolean methodBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodBody")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = block(builder_, level_ + 1);
    exit_section_(builder_, marker_, METHOD_BODY, result_);
    return result_;
  }

  /* ********************************************************** */
  // annotation* visibility? staticOrTransientModifier* virtualOrAbstractModifier? ( classInterfaceOrPrimitiveType | void ) identifier parameters methodBody
  public static boolean methodDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodDeclaration")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<method declaration>");
    result_ = methodDeclaration_0(builder_, level_ + 1);
    result_ = result_ && methodDeclaration_1(builder_, level_ + 1);
    result_ = result_ && methodDeclaration_2(builder_, level_ + 1);
    result_ = result_ && methodDeclaration_3(builder_, level_ + 1);
    result_ = result_ && methodDeclaration_4(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    pinned_ = result_; // pin = 6
    result_ = result_ && report_error_(builder_, parameters(builder_, level_ + 1));
    result_ = pinned_ && methodBody(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, METHOD_DECLARATION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // annotation*
  private static boolean methodDeclaration_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodDeclaration_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!annotation(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "methodDeclaration_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // visibility?
  private static boolean methodDeclaration_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodDeclaration_1")) return false;
    visibility(builder_, level_ + 1);
    return true;
  }

  // staticOrTransientModifier*
  private static boolean methodDeclaration_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodDeclaration_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!staticOrTransientModifier(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "methodDeclaration_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // virtualOrAbstractModifier?
  private static boolean methodDeclaration_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodDeclaration_3")) return false;
    virtualOrAbstractModifier(builder_, level_ + 1);
    return true;
  }

  // classInterfaceOrPrimitiveType | void
  private static boolean methodDeclaration_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodDeclaration_4")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = classInterfaceOrPrimitiveType(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, VOID);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '<' typeList '>'
  public static boolean nonWildcardTypeArguments(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "nonWildcardTypeArguments")) return false;
    if (!nextTokenIs(builder_, OPERATOR_LESS_THAN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPERATOR_LESS_THAN);
    result_ = result_ && consumeToken(builder_, TYPELIST);
    result_ = result_ && consumeToken(builder_, OPERATOR_GREATER_THAN);
    exit_section_(builder_, marker_, NON_WILDCARD_TYPE_ARGUMENTS, result_);
    return result_;
  }

  /* ********************************************************** */
  // '<' '>'
  //     |   nonWildcardTypeArguments
  public static boolean nonWildcardTypeArgumentsOrDiamond(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "nonWildcardTypeArgumentsOrDiamond")) return false;
    if (!nextTokenIs(builder_, OPERATOR_LESS_THAN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = nonWildcardTypeArgumentsOrDiamond_0(builder_, level_ + 1);
    if (!result_) result_ = nonWildcardTypeArguments(builder_, level_ + 1);
    exit_section_(builder_, marker_, NON_WILDCARD_TYPE_ARGUMENTS_OR_DIAMOND, result_);
    return result_;
  }

  // '<' '>'
  private static boolean nonWildcardTypeArgumentsOrDiamond_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "nonWildcardTypeArgumentsOrDiamond_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPERATOR_LESS_THAN);
    result_ = result_ && consumeToken(builder_, OPERATOR_GREATER_THAN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // variableModifier? classInterfaceOrPrimitiveType identifier
  public static boolean parameterDefinition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterDefinition")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<parameter definition>");
    result_ = parameterDefinition_0(builder_, level_ + 1);
    result_ = result_ && classInterfaceOrPrimitiveType(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, level_, marker_, PARAMETER_DEFINITION, result_, false, null);
    return result_;
  }

  // variableModifier?
  private static boolean parameterDefinition_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterDefinition_0")) return false;
    variableModifier(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // parameterDefinition (',' parameterDefinition)*
  static boolean parameterList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterList")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = parameterDefinition(builder_, level_ + 1);
    result_ = result_ && parameterList_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (',' parameterDefinition)*
  private static boolean parameterList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterList_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!parameterList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "parameterList_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' parameterDefinition
  private static boolean parameterList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterList_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && parameterDefinition(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '(' parameterList? ')'
  public static boolean parameters(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters")) return false;
    if (!nextTokenIs(builder_, LPAREN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && parameters_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, PARAMETERS, result_);
    return result_;
  }

  // parameterList?
  private static boolean parameters_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_1")) return false;
    parameterList(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // Blob
  //     |   Boolean
  //     |   Date
  //     |   Datetime
  //     |   Decimal
  //     |   Double
  //     |   ID
  //     |   Integer
  //     |   Long
  //     |   String
  //     |   Time
  public static boolean primitiveType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primitiveType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<primitive type>");
    result_ = consumeToken(builder_, BLOB);
    if (!result_) result_ = consumeToken(builder_, BOOLEAN);
    if (!result_) result_ = consumeToken(builder_, DATE);
    if (!result_) result_ = consumeToken(builder_, DATETIME);
    if (!result_) result_ = consumeToken(builder_, DECIMAL);
    if (!result_) result_ = consumeToken(builder_, DOUBLE);
    if (!result_) result_ = consumeToken(builder_, ID);
    if (!result_) result_ = consumeToken(builder_, INTEGER);
    if (!result_) result_ = consumeToken(builder_, LONG);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, TIME);
    exit_section_(builder_, level_, marker_, PRIMITIVE_TYPE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // Set '<' typeArgument '>'
  public static boolean setCollection(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "setCollection")) return false;
    if (!nextTokenIs(builder_, SET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, SET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OPERATOR_LESS_THAN));
    result_ = pinned_ && report_error_(builder_, typeArgument(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, OPERATOR_GREATER_THAN) && result_;
    exit_section_(builder_, level_, marker_, SET_COLLECTION, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // with sharing | without sharing
  public static boolean sharingModifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sharingModifier")) return false;
    if (!nextTokenIs(builder_, "<sharing modifier>", WITH, WITHOUT)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<sharing modifier>");
    result_ = parseTokens(builder_, 0, WITH, SHARING);
    if (!result_) result_ = parseTokens(builder_, 0, WITHOUT, SHARING);
    exit_section_(builder_, level_, marker_, SHARING_MODIFIER, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // block
  //     |   ifStatement
  //     |   classicForStatement
  //     |   enhancedForStatement
  //     |   whileStatement
  //     |   doStatement
  //     |   tryStatement
  //     |   return expression? ';'
  //     |   throw expression ';'
  //     |   break ';'
  //     |   continue ';'
  //     |   ';'
  //     |   expression ';'
  public static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<statement>");
    result_ = block(builder_, level_ + 1);
    if (!result_) result_ = ifStatement(builder_, level_ + 1);
    if (!result_) result_ = classicForStatement(builder_, level_ + 1);
    if (!result_) result_ = enhancedForStatement(builder_, level_ + 1);
    if (!result_) result_ = whileStatement(builder_, level_ + 1);
    if (!result_) result_ = doStatement(builder_, level_ + 1);
    if (!result_) result_ = tryStatement(builder_, level_ + 1);
    if (!result_) result_ = statement_7(builder_, level_ + 1);
    if (!result_) result_ = statement_8(builder_, level_ + 1);
    if (!result_) result_ = statement_9(builder_, level_ + 1);
    if (!result_) result_ = statement_10(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = statement_12(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, STATEMENT, result_, false, null);
    return result_;
  }

  // return expression? ';'
  private static boolean statement_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_7")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RETURN);
    result_ = result_ && statement_7_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMI);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // expression?
  private static boolean statement_7_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_7_1")) return false;
    expression(builder_, level_ + 1, -1);
    return true;
  }

  // throw expression ';'
  private static boolean statement_8(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_8")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, THROW);
    result_ = result_ && expression(builder_, level_ + 1, -1);
    result_ = result_ && consumeToken(builder_, SEMI);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // break ';'
  private static boolean statement_9(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_9")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BREAK);
    result_ = result_ && consumeToken(builder_, SEMI);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // continue ';'
  private static boolean statement_10(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_10")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CONTINUE);
    result_ = result_ && consumeToken(builder_, SEMI);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // expression ';'
  private static boolean statement_12(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_12")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = expression(builder_, level_ + 1, -1);
    result_ = result_ && consumeToken(builder_, SEMI);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // static block
  public static boolean staticBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "staticBlock")) return false;
    if (!nextTokenIs(builder_, STATIC)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, STATIC);
    pinned_ = result_; // pin = 1
    result_ = result_ && block(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, STATIC_BLOCK, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // static | transient
  public static boolean staticOrTransientModifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "staticOrTransientModifier")) return false;
    if (!nextTokenIs(builder_, "<static or transient modifier>", STATIC, TRANSIENT)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<static or transient modifier>");
    result_ = consumeToken(builder_, STATIC);
    if (!result_) result_ = consumeToken(builder_, TRANSIENT);
    exit_section_(builder_, level_, marker_, STATIC_OR_TRANSIENT_MODIFIER, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // arguments
  //     |   '.' identifier arguments?
  public static boolean superSuffix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "superSuffix")) return false;
    if (!nextTokenIs(builder_, "<super suffix>", LPAREN, DOT)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<super suffix>");
    result_ = arguments(builder_, level_ + 1);
    if (!result_) result_ = superSuffix_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SUPER_SUFFIX, result_, false, null);
    return result_;
  }

  // '.' identifier arguments?
  private static boolean superSuffix_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "superSuffix_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && superSuffix_1_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // arguments?
  private static boolean superSuffix_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "superSuffix_1_2")) return false;
    arguments(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' '}'
  public static boolean triggerBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "triggerBody")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACE);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, TRIGGER_BODY, result_);
    return result_;
  }

  /* ********************************************************** */
  // trigger identifier on identifier '(' triggerParameters ')' triggerBody
  public static boolean triggerDefinition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "triggerDefinition")) return false;
    if (!nextTokenIs(builder_, TRIGGER)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeTokens(builder_, 2, TRIGGER, IDENTIFIER, ON, IDENTIFIER);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LPAREN));
    result_ = pinned_ && report_error_(builder_, triggerParameters(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RPAREN)) && result_;
    result_ = pinned_ && triggerBody(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, TRIGGER_DEFINITION, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // before insert |
  //         before update |
  //         before delete |
  //         after insert |
  //         after update |
  //         after delete |
  //         after undelete
  public static boolean triggerParameter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "triggerParameter")) return false;
    if (!nextTokenIs(builder_, "<trigger parameter>", AFTER, BEFORE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<trigger parameter>");
    result_ = parseTokens(builder_, 0, BEFORE, INSERT);
    if (!result_) result_ = parseTokens(builder_, 0, BEFORE, UPDATE);
    if (!result_) result_ = parseTokens(builder_, 0, BEFORE, DELETE);
    if (!result_) result_ = parseTokens(builder_, 0, AFTER, INSERT);
    if (!result_) result_ = parseTokens(builder_, 0, AFTER, UPDATE);
    if (!result_) result_ = parseTokens(builder_, 0, AFTER, DELETE);
    if (!result_) result_ = parseTokens(builder_, 0, AFTER, UNDELETE);
    exit_section_(builder_, level_, marker_, TRIGGER_PARAMETER, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // triggerParameter (',' triggerParameter)*
  static boolean triggerParameters(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "triggerParameters")) return false;
    if (!nextTokenIs(builder_, "", AFTER, BEFORE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = triggerParameter(builder_, level_ + 1);
    result_ = result_ && triggerParameters_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (',' triggerParameter)*
  private static boolean triggerParameters_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "triggerParameters_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!triggerParameters_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "triggerParameters_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' triggerParameter
  private static boolean triggerParameters_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "triggerParameters_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && triggerParameter(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // try block (catchClause+ finallyBlock? | finallyBlock)
  public static boolean tryStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tryStatement")) return false;
    if (!nextTokenIs(builder_, TRY)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TRY);
    result_ = result_ && block(builder_, level_ + 1);
    result_ = result_ && tryStatement_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, TRY_STATEMENT, result_);
    return result_;
  }

  // catchClause+ finallyBlock? | finallyBlock
  private static boolean tryStatement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tryStatement_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = tryStatement_2_0(builder_, level_ + 1);
    if (!result_) result_ = finallyBlock(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // catchClause+ finallyBlock?
  private static boolean tryStatement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tryStatement_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = tryStatement_2_0_0(builder_, level_ + 1);
    result_ = result_ && tryStatement_2_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // catchClause+
  private static boolean tryStatement_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tryStatement_2_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = catchClause(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!catchClause(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "tryStatement_2_0_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // finallyBlock?
  private static boolean tryStatement_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tryStatement_2_0_1")) return false;
    finallyBlock(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // classInterfaceOrPrimitiveType
  public static boolean typeArgument(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "typeArgument")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<type argument>");
    result_ = classInterfaceOrPrimitiveType(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TYPE_ARGUMENT, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '<' '>'
  //     |   typeArguments
  public static boolean typeArgumentsOrDiamond(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "typeArgumentsOrDiamond")) return false;
    if (!nextTokenIs(builder_, "<type arguments or diamond>", OPERATOR_LESS_THAN, TYPEARGUMENTS)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<type arguments or diamond>");
    result_ = typeArgumentsOrDiamond_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TYPEARGUMENTS);
    exit_section_(builder_, level_, marker_, TYPE_ARGUMENTS_OR_DIAMOND, result_, false, null);
    return result_;
  }

  // '<' '>'
  private static boolean typeArgumentsOrDiamond_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "typeArgumentsOrDiamond_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPERATOR_LESS_THAN);
    result_ = result_ && consumeToken(builder_, OPERATOR_GREATER_THAN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // variableDefinition (',' variableDefinition)*
  static boolean variableDeclarators(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclarators")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = variableDefinition(builder_, level_ + 1);
    result_ = result_ && variableDeclarators_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (',' variableDefinition)*
  private static boolean variableDeclarators_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclarators_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!variableDeclarators_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "variableDeclarators_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' variableDefinition
  private static boolean variableDeclarators_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclarators_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && variableDefinition(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier ('=' variableInitializer)?
  public static boolean variableDefinition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDefinition")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, IDENTIFIER);
    pinned_ = result_; // pin = 1
    result_ = result_ && variableDefinition_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, VARIABLE_DEFINITION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ('=' variableInitializer)?
  private static boolean variableDefinition_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDefinition_1")) return false;
    variableDefinition_1_0(builder_, level_ + 1);
    return true;
  }

  // '=' variableInitializer
  private static boolean variableDefinition_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDefinition_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPERATOR_ASSIGNMENT);
    result_ = result_ && variableInitializer(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // arrayInitializer
  //     |   expression
  public static boolean variableInitializer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableInitializer")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<variable initializer>");
    result_ = arrayInitializer(builder_, level_ + 1);
    if (!result_) result_ = expression(builder_, level_ + 1, -1);
    exit_section_(builder_, level_, marker_, VARIABLE_INITIALIZER, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // final
  public static boolean variableModifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableModifier")) return false;
    if (!nextTokenIs(builder_, FINAL)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FINAL);
    exit_section_(builder_, marker_, VARIABLE_MODIFIER, result_);
    return result_;
  }

  /* ********************************************************** */
  // virtual | abstract
  public static boolean virtualOrAbstractModifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "virtualOrAbstractModifier")) return false;
    if (!nextTokenIs(builder_, "<virtual or abstract modifier>", ABSTRACT, VIRTUAL)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<virtual or abstract modifier>");
    result_ = consumeToken(builder_, VIRTUAL);
    if (!result_) result_ = consumeToken(builder_, ABSTRACT);
    exit_section_(builder_, level_, marker_, VIRTUAL_OR_ABSTRACT_MODIFIER, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // public | private | global | protected
  public static boolean visibility(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "visibility")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<visibility>");
    result_ = consumeToken(builder_, PUBLIC);
    if (!result_) result_ = consumeToken(builder_, PRIVATE);
    if (!result_) result_ = consumeToken(builder_, GLOBAL);
    if (!result_) result_ = consumeToken(builder_, PROTECTED);
    exit_section_(builder_, level_, marker_, VISIBILITY, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // while '(' expression ')' statement
  public static boolean whileStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "whileStatement")) return false;
    if (!nextTokenIs(builder_, WHILE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, WHILE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LPAREN));
    result_ = pinned_ && report_error_(builder_, expression(builder_, level_ + 1, -1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RPAREN)) && result_;
    result_ = pinned_ && statement(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, WHILE_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // Expression root: expression
  // Operator priority table:
  // 0: ATOM(primary_expression)
  // 1: POSTFIX(identifier_expression)
  // 2: POSTFIX(this_expression)
  // 3: POSTFIX(weird_expression)
  // 4: POSTFIX(super_expression)
  // 5: POSTFIX(generic_expression)
  // 6: BINARY(array_position_expression)
  // 7: POSTFIX(expressionList_expression)
  // 8: ATOM(instantiation_expression)
  // 9: PREFIX(cast_expression)
  // 10: POSTFIX(increment_after_expression)
  // 11: POSTFIX(decrement_after_expression)
  // 12: PREFIX(unary_negation_expression)
  // 13: PREFIX(decrement_before_expression)
  // 14: PREFIX(increment_before_expression)
  // 15: PREFIX(logical_compliment_expression)
  // 16: BINARY(multiplication_expression)
  // 17: BINARY(division_expression)
  // 18: BINARY(addition_expression)
  // 19: BINARY(subtraction_expression)
  // 20: BINARY(bitwise_shift_left_expression)
  // 21: BINARY(bitwise_shift_right_expression)
  // 22: BINARY(bitwise_shift_right_unsigned_expression)
  // 23: BINARY(greater_equal_expression)
  // 24: BINARY(less_equal_expression)
  // 25: BINARY(greater_than_expression)
  // 26: BINARY(less_than_expression)
  // 27: POSTFIX(instanceOf_expression)
  // 28: BINARY(exact_equality_expression)
  // 29: BINARY(exact_inequality_expression)
  // 30: BINARY(equality_expression)
  // 31: BINARY(inequality_expression)
  // 32: BINARY(bitwise_and_expression)
  // 33: BINARY(bitwise_exclusive_or_1expression)
  // 34: BINARY(bitwise_exclusive_or_2expression)
  // 35: BINARY(bitwise_or_expression)
  // 36: BINARY(or_expression)
  // 37: BINARY(and_expression)
  // 38: BINARY(ternary_expression)
  // 39: BINARY(assign_expression)
  // 40: BINARY(addition_assign_expression)
  // 41: BINARY(multiplication_assign_expression)
  // 42: BINARY(subtraction_assign_expression)
  // 43: BINARY(divide_assign_expression)
  // 44: BINARY(or_assign_expression)
  // 45: BINARY(and_assign_expression)
  // 46: BINARY(shift_right_assign_expression)
  // 47: BINARY(shift_right_unsigned_assign_expression)
  // 48: BINARY(shift_left_assign_expression)
  public static boolean expression(PsiBuilder builder_, int level_, int priority_) {
    if (!recursion_guard_(builder_, level_, "expression")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<expression>");
    result_ = primary_expression(builder_, level_ + 1);
    if (!result_) result_ = instantiation_expression(builder_, level_ + 1);
    if (!result_) result_ = cast_expression(builder_, level_ + 1);
    if (!result_) result_ = increment_before_expression(builder_, level_ + 1);
    if (!result_) result_ = decrement_before_expression(builder_, level_ + 1);
    if (!result_) result_ = unary_negation_expression(builder_, level_ + 1);
    if (!result_) result_ = logical_compliment_expression(builder_, level_ + 1);
    pinned_ = result_;
    result_ = result_ && expression_0(builder_, level_ + 1, priority_);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  public static boolean expression_0(PsiBuilder builder_, int level_, int priority_) {
    if (!recursion_guard_(builder_, level_, "expression_0")) return false;
    boolean result_ = true;
    while (true) {
      Marker left_marker_ = (Marker) builder_.getLatestDoneMarker();
      if (!invalid_left_marker_guard_(builder_, left_marker_, "expression_0")) return false;
      Marker marker_ = builder_.mark();
      if (priority_ < 1 && identifier_expression_0(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(IDENTIFIER_EXPRESSION);
      }
      else if (priority_ < 2 && this_expression_0(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(THIS_EXPRESSION);
      }
      else if (priority_ < 3 && weird_expression_0(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(WEIRD_EXPRESSION);
      }
      else if (priority_ < 4 && super_expression_0(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(SUPER_EXPRESSION);
      }
      else if (priority_ < 5 && generic_expression_0(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(GENERIC_EXPRESSION);
      }
      else if (priority_ < 6 && consumeToken(builder_, LBRACK)) {
        result_ = report_error_(builder_, expression(builder_, level_, 6));
        result_ = report_error_(builder_, consumeToken(builder_, RBRACK)) && result_;
        marker_.drop();
        left_marker_.precede().done(ARRAY_POSITION_EXPRESSION);
      }
      else if (priority_ < 7 && expressionList_expression_0(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(EXPRESSION_LIST_EXPRESSION);
      }
      else if (priority_ < 10 && consumeToken(builder_, OPERATOR_INCREMENT)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(INCREMENT_AFTER_EXPRESSION);
      }
      else if (priority_ < 11 && consumeToken(builder_, OPERATOR_DECREMENT)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(DECREMENT_AFTER_EXPRESSION);
      }
      else if (priority_ < 19 && consumeToken(builder_, OPERATOR_SUBTRACTION)) {
        result_ = report_error_(builder_, expression(builder_, level_, 19));
        marker_.drop();
        left_marker_.precede().done(SUBTRACTION_EXPRESSION);
      }
      else if (priority_ < 16 && consumeToken(builder_, OPERATOR_MULTIPLICATION)) {
        result_ = report_error_(builder_, expression(builder_, level_, 16));
        marker_.drop();
        left_marker_.precede().done(MULTIPLICATION_EXPRESSION);
      }
      else if (priority_ < 17 && consumeToken(builder_, OPERATOR_DIVSION)) {
        result_ = report_error_(builder_, expression(builder_, level_, 17));
        marker_.drop();
        left_marker_.precede().done(DIVISION_EXPRESSION);
      }
      else if (priority_ < 18 && consumeToken(builder_, OPERATOR_ADDITION)) {
        result_ = report_error_(builder_, expression(builder_, level_, 18));
        marker_.drop();
        left_marker_.precede().done(ADDITION_EXPRESSION);
      }
      else if (priority_ < 20 && consumeToken(builder_, "<<")) {
        result_ = report_error_(builder_, expression(builder_, level_, 20));
        marker_.drop();
        left_marker_.precede().done(BITWISE_SHIFT_LEFT_EXPRESSION);
      }
      else if (priority_ < 21 && consumeToken(builder_, ">>")) {
        result_ = report_error_(builder_, expression(builder_, level_, 21));
        marker_.drop();
        left_marker_.precede().done(BITWISE_SHIFT_RIGHT_EXPRESSION);
      }
      else if (priority_ < 22 && consumeToken(builder_, ">>>")) {
        result_ = report_error_(builder_, expression(builder_, level_, 22));
        marker_.drop();
        left_marker_.precede().done(BITWISE_SHIFT_RIGHT_UNSIGNED_EXPRESSION);
      }
      else if (priority_ < 23 && consumeToken(builder_, OPERATOR_GREATER_THAN_EQUAL)) {
        result_ = report_error_(builder_, expression(builder_, level_, 23));
        marker_.drop();
        left_marker_.precede().done(GREATER_EQUAL_EXPRESSION);
      }
      else if (priority_ < 24 && consumeToken(builder_, OPERATOR_LESS_THAN_EQUAL)) {
        result_ = report_error_(builder_, expression(builder_, level_, 24));
        marker_.drop();
        left_marker_.precede().done(LESS_EQUAL_EXPRESSION);
      }
      else if (priority_ < 25 && consumeToken(builder_, OPERATOR_GREATER_THAN)) {
        result_ = report_error_(builder_, expression(builder_, level_, 25));
        marker_.drop();
        left_marker_.precede().done(GREATER_THAN_EXPRESSION);
      }
      else if (priority_ < 26 && consumeToken(builder_, OPERATOR_LESS_THAN)) {
        result_ = report_error_(builder_, expression(builder_, level_, 26));
        marker_.drop();
        left_marker_.precede().done(LESS_THAN_EXPRESSION);
      }
      else if (priority_ < 27 && instanceOf_expression_0(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(INSTANCE_OF_EXPRESSION);
      }
      else if (priority_ < 28 && consumeToken(builder_, OPERATOR_EXACT_EQUALITY)) {
        result_ = report_error_(builder_, expression(builder_, level_, 28));
        marker_.drop();
        left_marker_.precede().done(EXACT_EQUALITY_EXPRESSION);
      }
      else if (priority_ < 29 && consumeToken(builder_, OPERATOR_EXACT_INEQUALITY)) {
        result_ = report_error_(builder_, expression(builder_, level_, 29));
        marker_.drop();
        left_marker_.precede().done(EXACT_INEQUALITY_EXPRESSION);
      }
      else if (priority_ < 30 && consumeToken(builder_, OPERATOR_EQUALITY)) {
        result_ = report_error_(builder_, expression(builder_, level_, 30));
        marker_.drop();
        left_marker_.precede().done(EQUALITY_EXPRESSION);
      }
      else if (priority_ < 31 && consumeToken(builder_, OPERATOR_INEQUALITY)) {
        result_ = report_error_(builder_, expression(builder_, level_, 31));
        marker_.drop();
        left_marker_.precede().done(INEQUALITY_EXPRESSION);
      }
      else if (priority_ < 32 && consumeToken(builder_, OPERATOR_BITWISE_AND)) {
        result_ = report_error_(builder_, expression(builder_, level_, 32));
        marker_.drop();
        left_marker_.precede().done(BITWISE_AND_EXPRESSION);
      }
      else if (priority_ < 33 && consumeToken(builder_, OPERATOR_BITWISE_EXCLUSIVE_OR1)) {
        result_ = report_error_(builder_, expression(builder_, level_, 33));
        marker_.drop();
        left_marker_.precede().done(BITWISE_EXCLUSIVE_OR_1EXPRESSION);
      }
      else if (priority_ < 34 && consumeToken(builder_, OPERATOR_BITWISE_EXCLUSIVE_OR2)) {
        result_ = report_error_(builder_, expression(builder_, level_, 34));
        marker_.drop();
        left_marker_.precede().done(BITWISE_EXCLUSIVE_OR_2EXPRESSION);
      }
      else if (priority_ < 35 && consumeToken(builder_, OPERATOR_BITWISE_OR)) {
        result_ = report_error_(builder_, expression(builder_, level_, 35));
        marker_.drop();
        left_marker_.precede().done(BITWISE_OR_EXPRESSION);
      }
      else if (priority_ < 36 && consumeToken(builder_, OPERATOR_OR)) {
        result_ = report_error_(builder_, expression(builder_, level_, 36));
        marker_.drop();
        left_marker_.precede().done(OR_EXPRESSION);
      }
      else if (priority_ < 37 && consumeToken(builder_, OPERATOR_AND)) {
        result_ = report_error_(builder_, expression(builder_, level_, 37));
        marker_.drop();
        left_marker_.precede().done(AND_EXPRESSION);
      }
      else if (priority_ < 38 && consumeToken(builder_, OPERATOR_TERNARY)) {
        result_ = report_error_(builder_, expression(builder_, level_, 38));
        result_ = report_error_(builder_, ternary_expression_1(builder_, level_ + 1)) && result_;
        marker_.drop();
        left_marker_.precede().done(TERNARY_EXPRESSION);
      }
      else if (priority_ < 39 && consumeToken(builder_, OPERATOR_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 38));
        marker_.drop();
        left_marker_.precede().done(ASSIGN_EXPRESSION);
      }
      else if (priority_ < 40 && consumeToken(builder_, OPERATOR_ADDITION_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 39));
        marker_.drop();
        left_marker_.precede().done(ADDITION_ASSIGN_EXPRESSION);
      }
      else if (priority_ < 41 && consumeToken(builder_, OPERATOR_MULTIPLICATION_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 40));
        marker_.drop();
        left_marker_.precede().done(MULTIPLICATION_ASSIGN_EXPRESSION);
      }
      else if (priority_ < 42 && consumeToken(builder_, OPERATOR_SUBTRACTION_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 41));
        marker_.drop();
        left_marker_.precede().done(SUBTRACTION_ASSIGN_EXPRESSION);
      }
      else if (priority_ < 43 && consumeToken(builder_, OPERATOR_DIVISION_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 42));
        marker_.drop();
        left_marker_.precede().done(DIVIDE_ASSIGN_EXPRESSION);
      }
      else if (priority_ < 45 && consumeToken(builder_, OPERATOR_AND_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 44));
        marker_.drop();
        left_marker_.precede().done(AND_ASSIGN_EXPRESSION);
      }
      else if (priority_ < 46 && consumeToken(builder_, OPERATOR_BITWISE_SHIFT_RIGHT_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 45));
        marker_.drop();
        left_marker_.precede().done(SHIFT_RIGHT_ASSIGN_EXPRESSION);
      }
      else if (priority_ < 47 && consumeToken(builder_, OPERATOR_BITWISE_SHIFT_RIGHT_UNSIGNED_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 46));
        marker_.drop();
        left_marker_.precede().done(SHIFT_RIGHT_UNSIGNED_ASSIGN_EXPRESSION);
      }
      else if (priority_ < 48 && consumeToken(builder_, OPERATOR_BITWISE_SHIFT_LEFT_ASSIGNMENT)) {
        result_ = report_error_(builder_, expression(builder_, level_, 47));
        marker_.drop();
        left_marker_.precede().done(SHIFT_LEFT_ASSIGN_EXPRESSION);
      }
      else {
        exit_section_(builder_, marker_, null, false);
        break;
      }
    }
    return result_;
  }

  // '(' expression ')'
  //     |   this
  //     |   super
  //     |   literal
  //     |   identifier
  //     |   classInterfaceOrPrimitiveType '.' CLASS_KEYWORD
  //     |   void '.' CLASS_KEYWORD
  //     |   nonWildcardTypeArguments (explicitGenericInvocationSuffix | this arguments)
  public static boolean primary_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_expression")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, "<primary expression>");
    result_ = primary_expression_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, THIS);
    if (!result_) result_ = consumeToken(builder_, SUPER);
    if (!result_) result_ = literal(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = primary_expression_5(builder_, level_ + 1);
    if (!result_) result_ = primary_expression_6(builder_, level_ + 1);
    if (!result_) result_ = primary_expression_7(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, PRIMARY_EXPRESSION, result_, false, null);
    return result_;
  }

  // '(' expression ')'
  private static boolean primary_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && expression(builder_, level_ + 1, -1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // classInterfaceOrPrimitiveType '.' CLASS_KEYWORD
  private static boolean primary_expression_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_expression_5")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = classInterfaceOrPrimitiveType(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, CLASS_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // void '.' CLASS_KEYWORD
  private static boolean primary_expression_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_expression_6")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, VOID);
    result_ = result_ && consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, CLASS_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // nonWildcardTypeArguments (explicitGenericInvocationSuffix | this arguments)
  private static boolean primary_expression_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_expression_7")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = nonWildcardTypeArguments(builder_, level_ + 1);
    result_ = result_ && primary_expression_7_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // explicitGenericInvocationSuffix | this arguments
  private static boolean primary_expression_7_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_expression_7_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = explicitGenericInvocationSuffix(builder_, level_ + 1);
    if (!result_) result_ = primary_expression_7_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // this arguments
  private static boolean primary_expression_7_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_expression_7_1_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, THIS);
    result_ = result_ && arguments(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '.' identifier
  private static boolean identifier_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '.' this
  private static boolean this_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "this_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, THIS);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '.' new nonWildcardTypeArguments? innerCreator
  private static boolean weird_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "weird_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, NEW);
    result_ = result_ && weird_expression_0_2(builder_, level_ + 1);
    result_ = result_ && innerCreator(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // nonWildcardTypeArguments?
  private static boolean weird_expression_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "weird_expression_0_2")) return false;
    nonWildcardTypeArguments(builder_, level_ + 1);
    return true;
  }

  // '.' super superSuffix
  private static boolean super_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "super_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, SUPER);
    result_ = result_ && superSuffix(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '.' explicitGenericInvocation
  private static boolean generic_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "generic_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && explicitGenericInvocation(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '(' expressionList? ')'
  private static boolean expressionList_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionList_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && expressionList_expression_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // expressionList?
  private static boolean expressionList_expression_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionList_expression_0_1")) return false;
    expressionList(builder_, level_ + 1);
    return true;
  }

  // new creator
  public static boolean instantiation_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "instantiation_expression")) return false;
    if (!nextTokenIs(builder_, NEW)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEW);
    result_ = result_ && creator(builder_, level_ + 1);
    exit_section_(builder_, marker_, INSTANTIATION_EXPRESSION, result_);
    return result_;
  }

  public static boolean cast_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "cast_expression")) return false;
    if (!nextTokenIs(builder_, "<expression>", LPAREN)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = cast_expression_0(builder_, level_ + 1);
    pinned_ = result_;
    result_ = pinned_ && expression(builder_, level_, 9);
    exit_section_(builder_, level_, marker_, CAST_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '(' classInterfaceOrPrimitiveType ')'
  private static boolean cast_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "cast_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && classInterfaceOrPrimitiveType(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  public static boolean increment_before_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "increment_before_expression")) return false;
    if (!nextTokenIs(builder_, "<expression>", OPERATOR_INCREMENT)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, OPERATOR_INCREMENT);
    pinned_ = result_;
    result_ = pinned_ && expression(builder_, level_, 14);
    exit_section_(builder_, level_, marker_, INCREMENT_BEFORE_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  public static boolean decrement_before_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "decrement_before_expression")) return false;
    if (!nextTokenIs(builder_, "<expression>", OPERATOR_DECREMENT)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, OPERATOR_DECREMENT);
    pinned_ = result_;
    result_ = pinned_ && expression(builder_, level_, 13);
    exit_section_(builder_, level_, marker_, DECREMENT_BEFORE_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  public static boolean unary_negation_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unary_negation_expression")) return false;
    if (!nextTokenIs(builder_, "<expression>", OPERATOR_SUBTRACTION)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, OPERATOR_SUBTRACTION);
    pinned_ = result_;
    result_ = pinned_ && expression(builder_, level_, 12);
    exit_section_(builder_, level_, marker_, UNARY_NEGATION_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  public static boolean logical_compliment_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logical_compliment_expression")) return false;
    if (!nextTokenIs(builder_, "<expression>", OPERATOR_NOT)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, OPERATOR_NOT);
    pinned_ = result_;
    result_ = pinned_ && expression(builder_, level_, 15);
    exit_section_(builder_, level_, marker_, LOGICAL_COMPLIMENT_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // instanceof classInterfaceOrPrimitiveType
  private static boolean instanceOf_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "instanceOf_expression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, INSTANCEOF);
    result_ = result_ && classInterfaceOrPrimitiveType(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ':' expression
  private static boolean ternary_expression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ternary_expression_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPERATOR_COLON);
    result_ = result_ && expression(builder_, level_ + 1, -1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

}
