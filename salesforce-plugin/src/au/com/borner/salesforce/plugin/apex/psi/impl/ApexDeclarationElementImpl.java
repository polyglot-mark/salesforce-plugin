/*
 * Copyright 2014 Mark Borner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package au.com.borner.salesforce.plugin.apex.psi.impl;

import au.com.borner.salesforce.plugin.apex.ApexIcons;
import au.com.borner.salesforce.plugin.apex.psi.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.RowIcon;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by mark
 */
public abstract class ApexDeclarationElementImpl extends ASTWrapperPsiElement implements ApexDeclarationElement {

    private volatile String cachedName;

    public ApexDeclarationElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void subtreeChanged() {
        super.subtreeChanged();
        cachedName = null;
    }

    @NotNull
    @Override
    public String getName() {
        if (cachedName == null) {
            cachedName = getIdentifier().getText();
        }
        return cachedName;
    }

    @Override
    public PsiElement setName(@NonNls @NotNull String s) throws IncorrectOperationException {
        getIdentifier().replace(ApexElementFactory.createLeafFromText(getProject(), s));
        return this;
    }

    @Override
    public int getTextOffset() {
        return getIdentifier().getTextOffset();
    }

//    @Override
//    public Icon getIcon(int flags) {
//        if (this instanceof ApexClassDeclaration) {
//            Icon base = ApexIcons.CLASS;
//            Icon modifier = ApexIcons.PUBLIC;  // TODO: set correct modifier
//            return createRowIcon(base, modifier);
//        } else if (this instanceof ApexInterfaceDeclaration) {
//            Icon base = ApexIcons.INTERFACE;
//            Icon modifier = ApexIcons.PUBLIC;  // TODO: set correct modifier
//            return createRowIcon(base, modifier);
//        } else if (this instanceof ApexTriggerDeclaration) {
//            return ApexIcons.TRIGGER;
//        }
//        return super.getIcon(flags);
//    }

    @Override
    public PsiElement getNameIdentifier() {
        return getIdentifier();
    }

    @Override
    public String toString() {
        return super.toString() + ":" + getName();
    }

//    private RowIcon createRowIcon(Icon first, Icon second) {
//        RowIcon rowIcon = new RowIcon(2);
//        rowIcon.setIcon(first, 0);
//        rowIcon.setIcon(second, 1);
//        return rowIcon;
//    }

//    @Nullable
//    public PsiReference getReference() {
//        PsiReference[] references = getReferences();
//        return references.length == 0 ? null : references[0];
//    }
//
//    @NotNull
//    @Override
//    public PsiReference[] getReferences() {
//        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
//    }

    @Override
    public boolean isEquivalentTo(PsiElement another) {
        return getIdentifier().getText().equals(another.getText());
    }

    @Override
    public boolean isPublic() {
        return getVisibility() != null && getVisibility().getText().equals("public");
    }

    @Override
    public boolean isPrivate() {
        return getVisibility() != null && getVisibility().getText().equals("private");
    }

    @Override
    public boolean isProtected() {
        return getVisibility() != null && getVisibility().getText().equals("protected");
    }

    @Override
    public boolean isGlobal() {
        return getVisibility() != null && getVisibility().getText().equals("global");
    }

}
