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

public class ApexClassBodyImpl extends ASTWrapperPsiElement implements ApexClassBody {

  public ApexClassBodyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ApexVisitor) ((ApexVisitor)visitor).visitClassBody(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ApexDeclaration> getDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ApexDeclaration.class);
  }

  @Override
  @NotNull
  public List<ApexBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ApexBlock.class);
  }

  @Override
  @NotNull
  public List<ApexFieldDeclarator> getFieldDeclaratorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ApexFieldDeclarator.class);
  }

  @Override
  @NotNull
  public List<ApexStaticBlock> getStaticBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ApexStaticBlock.class);
  }

}
