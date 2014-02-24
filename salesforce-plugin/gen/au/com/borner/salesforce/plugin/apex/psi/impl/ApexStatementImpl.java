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
package au.com.borner.salesforce.plugin.apex.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static au.com.borner.salesforce.plugin.apex.psi.ApexTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import au.com.borner.salesforce.plugin.apex.psi.*;

public class ApexStatementImpl extends ASTWrapperPsiElement implements ApexStatement {

  public ApexStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ApexVisitor) ((ApexVisitor)visitor).visitStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ApexBlock getBlock() {
    return findChildByClass(ApexBlock.class);
  }

  @Override
  @Nullable
  public ApexClassicForStatement getClassicForStatement() {
    return findChildByClass(ApexClassicForStatement.class);
  }

  @Override
  @Nullable
  public ApexDoStatement getDoStatement() {
    return findChildByClass(ApexDoStatement.class);
  }

  @Override
  @Nullable
  public ApexEnhancedForStatement getEnhancedForStatement() {
    return findChildByClass(ApexEnhancedForStatement.class);
  }

  @Override
  @Nullable
  public ApexExpression getExpression() {
    return findChildByClass(ApexExpression.class);
  }

  @Override
  @Nullable
  public ApexIfStatement getIfStatement() {
    return findChildByClass(ApexIfStatement.class);
  }

  @Override
  @Nullable
  public ApexTryStatement getTryStatement() {
    return findChildByClass(ApexTryStatement.class);
  }

  @Override
  @Nullable
  public ApexWhileStatement getWhileStatement() {
    return findChildByClass(ApexWhileStatement.class);
  }

}
