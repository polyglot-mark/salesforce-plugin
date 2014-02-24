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

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ApexVisitor extends PsiElementVisitor {

  public void visitDeclaration(@NotNull ApexDeclaration o) {
    visitDeclarationElement(o);
  }

  public void visitReference(@NotNull ApexReference o) {
    visitReferenceElement(o);
  }

  public void visitAdditionAssignExpression(@NotNull ApexAdditionAssignExpression o) {
    visitExpression(o);
  }

  public void visitAdditionExpression(@NotNull ApexAdditionExpression o) {
    visitExpression(o);
  }

  public void visitAndAssignExpression(@NotNull ApexAndAssignExpression o) {
    visitExpression(o);
  }

  public void visitAndExpression(@NotNull ApexAndExpression o) {
    visitExpression(o);
  }

  public void visitAnnotation(@NotNull ApexAnnotation o) {
    visitPsiElement(o);
  }

  public void visitAnnotationParameter(@NotNull ApexAnnotationParameter o) {
    visitPsiElement(o);
  }

  public void visitAnnotationParameterValue(@NotNull ApexAnnotationParameterValue o) {
    visitPsiElement(o);
  }

  public void visitArguments(@NotNull ApexArguments o) {
    visitPsiElement(o);
  }

  public void visitArrayCreatorRest(@NotNull ApexArrayCreatorRest o) {
    visitPsiElement(o);
  }

  public void visitArrayInitializer(@NotNull ApexArrayInitializer o) {
    visitPsiElement(o);
  }

  public void visitArrayPositionExpression(@NotNull ApexArrayPositionExpression o) {
    visitExpression(o);
  }

  public void visitAssignExpression(@NotNull ApexAssignExpression o) {
    visitExpression(o);
  }

  public void visitBitwiseAndExpression(@NotNull ApexBitwiseAndExpression o) {
    visitExpression(o);
  }

  public void visitBitwiseExclusiveOr1expression(@NotNull ApexBitwiseExclusiveOr1expression o) {
    visitExpression(o);
  }

  public void visitBitwiseExclusiveOr2expression(@NotNull ApexBitwiseExclusiveOr2expression o) {
    visitExpression(o);
  }

  public void visitBitwiseOrExpression(@NotNull ApexBitwiseOrExpression o) {
    visitExpression(o);
  }

  public void visitBitwiseShiftLeftExpression(@NotNull ApexBitwiseShiftLeftExpression o) {
    visitExpression(o);
  }

  public void visitBitwiseShiftRightExpression(@NotNull ApexBitwiseShiftRightExpression o) {
    visitExpression(o);
  }

  public void visitBitwiseShiftRightUnsignedExpression(@NotNull ApexBitwiseShiftRightUnsignedExpression o) {
    visitExpression(o);
  }

  public void visitBlock(@NotNull ApexBlock o) {
    visitPsiElement(o);
  }

  public void visitBlockStatement(@NotNull ApexBlockStatement o) {
    visitPsiElement(o);
  }

  public void visitBooleanLiteral(@NotNull ApexBooleanLiteral o) {
    visitPsiElement(o);
  }

  public void visitCastExpression(@NotNull ApexCastExpression o) {
    visitExpression(o);
  }

  public void visitCatchClause(@NotNull ApexCatchClause o) {
    visitPsiElement(o);
  }

  public void visitClassBody(@NotNull ApexClassBody o) {
    visitPsiElement(o);
  }

  public void visitClassCreatorRest(@NotNull ApexClassCreatorRest o) {
    visitPsiElement(o);
  }

  public void visitClassDeclaration(@NotNull ApexClassDeclaration o) {
    visitDeclaration(o);
  }

  public void visitClassInterfaceOrPrimitiveType(@NotNull ApexClassInterfaceOrPrimitiveType o) {
    visitPsiElement(o);
  }

  public void visitClassOrInterfaceReference(@NotNull ApexClassOrInterfaceReference o) {
    visitReference(o);
  }

  public void visitClassicForStatement(@NotNull ApexClassicForStatement o) {
    visitPsiElement(o);
  }

  public void visitConstructorBody(@NotNull ApexConstructorBody o) {
    visitPsiElement(o);
  }

  public void visitConstructorDeclaration(@NotNull ApexConstructorDeclaration o) {
    visitDeclaration(o);
  }

  public void visitCreatedName(@NotNull ApexCreatedName o) {
    visitPsiElement(o);
  }

  public void visitCreator(@NotNull ApexCreator o) {
    visitPsiElement(o);
  }

  public void visitDecrementAfterExpression(@NotNull ApexDecrementAfterExpression o) {
    visitExpression(o);
  }

  public void visitDecrementBeforeExpression(@NotNull ApexDecrementBeforeExpression o) {
    visitExpression(o);
  }

  public void visitDivideAssignExpression(@NotNull ApexDivideAssignExpression o) {
    visitExpression(o);
  }

  public void visitDivisionExpression(@NotNull ApexDivisionExpression o) {
    visitExpression(o);
  }

  public void visitDoStatement(@NotNull ApexDoStatement o) {
    visitPsiElement(o);
  }

  public void visitEnhancedForStatement(@NotNull ApexEnhancedForStatement o) {
    visitPsiElement(o);
  }

  public void visitEnumDeclaration(@NotNull ApexEnumDeclaration o) {
    visitDeclaration(o);
  }

  public void visitEqualityExpression(@NotNull ApexEqualityExpression o) {
    visitExpression(o);
  }

  public void visitExactEqualityExpression(@NotNull ApexExactEqualityExpression o) {
    visitExpression(o);
  }

  public void visitExactInequalityExpression(@NotNull ApexExactInequalityExpression o) {
    visitExpression(o);
  }

  public void visitExplicitGenericInvocation(@NotNull ApexExplicitGenericInvocation o) {
    visitPsiElement(o);
  }

  public void visitExplicitGenericInvocationSuffix(@NotNull ApexExplicitGenericInvocationSuffix o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull ApexExpression o) {
    visitPsiElement(o);
  }

  public void visitExpressionList(@NotNull ApexExpressionList o) {
    visitPsiElement(o);
  }

  public void visitExpressionListExpression(@NotNull ApexExpressionListExpression o) {
    visitExpression(o);
  }

  public void visitExtendsClause(@NotNull ApexExtendsClause o) {
    visitPsiElement(o);
  }

  public void visitFieldDeclarator(@NotNull ApexFieldDeclarator o) {
    visitPsiElement(o);
  }

  public void visitFieldVisibility(@NotNull ApexFieldVisibility o) {
    visitPsiElement(o);
  }

  public void visitFinallyBlock(@NotNull ApexFinallyBlock o) {
    visitPsiElement(o);
  }

  public void visitForInit(@NotNull ApexForInit o) {
    visitPsiElement(o);
  }

  public void visitForUpdate(@NotNull ApexForUpdate o) {
    visitPsiElement(o);
  }

  public void visitGenericExpression(@NotNull ApexGenericExpression o) {
    visitExpression(o);
  }

  public void visitGreaterEqualExpression(@NotNull ApexGreaterEqualExpression o) {
    visitExpression(o);
  }

  public void visitGreaterThanExpression(@NotNull ApexGreaterThanExpression o) {
    visitExpression(o);
  }

  public void visitIdentifierExpression(@NotNull ApexIdentifierExpression o) {
    visitExpression(o);
  }

  public void visitIfStatement(@NotNull ApexIfStatement o) {
    visitPsiElement(o);
  }

  public void visitImplementsClause(@NotNull ApexImplementsClause o) {
    visitPsiElement(o);
  }

  public void visitIncrementAfterExpression(@NotNull ApexIncrementAfterExpression o) {
    visitExpression(o);
  }

  public void visitIncrementBeforeExpression(@NotNull ApexIncrementBeforeExpression o) {
    visitExpression(o);
  }

  public void visitInequalityExpression(@NotNull ApexInequalityExpression o) {
    visitExpression(o);
  }

  public void visitInnerCreator(@NotNull ApexInnerCreator o) {
    visitPsiElement(o);
  }

  public void visitInstanceOfExpression(@NotNull ApexInstanceOfExpression o) {
    visitExpression(o);
  }

  public void visitInstantiationExpression(@NotNull ApexInstantiationExpression o) {
    visitExpression(o);
  }

  public void visitInterfaceBody(@NotNull ApexInterfaceBody o) {
    visitPsiElement(o);
  }

  public void visitInterfaceDeclaration(@NotNull ApexInterfaceDeclaration o) {
    visitDeclaration(o);
  }

  public void visitLessEqualExpression(@NotNull ApexLessEqualExpression o) {
    visitExpression(o);
  }

  public void visitLessThanExpression(@NotNull ApexLessThanExpression o) {
    visitExpression(o);
  }

  public void visitListCollection(@NotNull ApexListCollection o) {
    visitPsiElement(o);
  }

  public void visitLiteral(@NotNull ApexLiteral o) {
    visitPsiElement(o);
  }

  public void visitLocalVariableDeclarationStatement(@NotNull ApexLocalVariableDeclarationStatement o) {
    visitPsiElement(o);
  }

  public void visitLocalVariableDeclarator(@NotNull ApexLocalVariableDeclarator o) {
    visitPsiElement(o);
  }

  public void visitLogicalComplimentExpression(@NotNull ApexLogicalComplimentExpression o) {
    visitExpression(o);
  }

  public void visitMapCollection(@NotNull ApexMapCollection o) {
    visitPsiElement(o);
  }

  public void visitMethodBody(@NotNull ApexMethodBody o) {
    visitPsiElement(o);
  }

  public void visitMethodDeclaration(@NotNull ApexMethodDeclaration o) {
    visitDeclaration(o);
  }

  public void visitMultiplicationAssignExpression(@NotNull ApexMultiplicationAssignExpression o) {
    visitExpression(o);
  }

  public void visitMultiplicationExpression(@NotNull ApexMultiplicationExpression o) {
    visitExpression(o);
  }

  public void visitNonWildcardTypeArguments(@NotNull ApexNonWildcardTypeArguments o) {
    visitPsiElement(o);
  }

  public void visitNonWildcardTypeArgumentsOrDiamond(@NotNull ApexNonWildcardTypeArgumentsOrDiamond o) {
    visitPsiElement(o);
  }

  public void visitOrAssignExpression(@NotNull ApexOrAssignExpression o) {
    visitExpression(o);
  }

  public void visitOrExpression(@NotNull ApexOrExpression o) {
    visitExpression(o);
  }

  public void visitParameterDefinition(@NotNull ApexParameterDefinition o) {
    visitPsiElement(o);
  }

  public void visitParameters(@NotNull ApexParameters o) {
    visitPsiElement(o);
  }

  public void visitPrimaryExpression(@NotNull ApexPrimaryExpression o) {
    visitExpression(o);
  }

  public void visitPrimitiveType(@NotNull ApexPrimitiveType o) {
    visitPsiElement(o);
  }

  public void visitSetCollection(@NotNull ApexSetCollection o) {
    visitPsiElement(o);
  }

  public void visitSharingModifier(@NotNull ApexSharingModifier o) {
    visitPsiElement(o);
  }

  public void visitShiftLeftAssignExpression(@NotNull ApexShiftLeftAssignExpression o) {
    visitExpression(o);
  }

  public void visitShiftRightAssignExpression(@NotNull ApexShiftRightAssignExpression o) {
    visitExpression(o);
  }

  public void visitShiftRightUnsignedAssignExpression(@NotNull ApexShiftRightUnsignedAssignExpression o) {
    visitExpression(o);
  }

  public void visitStatement(@NotNull ApexStatement o) {
    visitPsiElement(o);
  }

  public void visitStaticBlock(@NotNull ApexStaticBlock o) {
    visitPsiElement(o);
  }

  public void visitStaticOrTransientModifier(@NotNull ApexStaticOrTransientModifier o) {
    visitPsiElement(o);
  }

  public void visitSubtractionAssignExpression(@NotNull ApexSubtractionAssignExpression o) {
    visitExpression(o);
  }

  public void visitSubtractionExpression(@NotNull ApexSubtractionExpression o) {
    visitExpression(o);
  }

  public void visitSuperSuffix(@NotNull ApexSuperSuffix o) {
    visitPsiElement(o);
  }

  public void visitSuperExpression(@NotNull ApexSuperExpression o) {
    visitExpression(o);
  }

  public void visitTernaryExpression(@NotNull ApexTernaryExpression o) {
    visitExpression(o);
  }

  public void visitThisExpression(@NotNull ApexThisExpression o) {
    visitExpression(o);
  }

  public void visitTriggerBody(@NotNull ApexTriggerBody o) {
    visitPsiElement(o);
  }

  public void visitTriggerDefinition(@NotNull ApexTriggerDefinition o) {
    visitPsiElement(o);
  }

  public void visitTriggerParameter(@NotNull ApexTriggerParameter o) {
    visitPsiElement(o);
  }

  public void visitTryStatement(@NotNull ApexTryStatement o) {
    visitPsiElement(o);
  }

  public void visitTypeArgument(@NotNull ApexTypeArgument o) {
    visitPsiElement(o);
  }

  public void visitTypeArgumentsOrDiamond(@NotNull ApexTypeArgumentsOrDiamond o) {
    visitPsiElement(o);
  }

  public void visitUnaryNegationExpression(@NotNull ApexUnaryNegationExpression o) {
    visitExpression(o);
  }

  public void visitVariableDefinition(@NotNull ApexVariableDefinition o) {
    visitPsiElement(o);
  }

  public void visitVariableInitializer(@NotNull ApexVariableInitializer o) {
    visitPsiElement(o);
  }

  public void visitVariableModifier(@NotNull ApexVariableModifier o) {
    visitPsiElement(o);
  }

  public void visitVirtualOrAbstractModifier(@NotNull ApexVirtualOrAbstractModifier o) {
    visitPsiElement(o);
  }

  public void visitVisibility(@NotNull ApexVisibility o) {
    visitPsiElement(o);
  }

  public void visitWeirdExpression(@NotNull ApexWeirdExpression o) {
    visitExpression(o);
  }

  public void visitWhileStatement(@NotNull ApexWhileStatement o) {
    visitPsiElement(o);
  }

  public void visitDeclarationElement(@NotNull ApexDeclarationElement o) {
    visitPsiElement(o);
  }

  public void visitReferenceElement(@NotNull ApexReferenceElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
