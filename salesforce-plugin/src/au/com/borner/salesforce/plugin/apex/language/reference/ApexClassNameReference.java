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

package au.com.borner.salesforce.plugin.apex.language.reference;

import au.com.borner.salesforce.plugin.PsiUtilities;
import au.com.borner.salesforce.plugin.apex.psi.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark
 */
public class ApexClassNameReference extends PsiReferenceBase<ApexReferenceElement> implements PsiPolyVariantReference {

    private final String className;
    private final Project project;

    public ApexClassNameReference(@NotNull ApexReferenceElement apexClassReference, @NotNull TextRange textRange) {
        super(apexClassReference, textRange);
        className = apexClassReference.getIdentifier().getText();
        project = apexClassReference.getProject();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        final List<ApexClassDeclaration> apexClassDeclarations = ApexPsiUtilities.getApexClassDeclarations(project, className);
        List<ResolveResult> results = new ArrayList<ResolveResult>(apexClassDeclarations.size());
        for (ApexClassDeclaration apexClassDeclaration : apexClassDeclarations) {

            results.add(new PsiElementResolveResult(apexClassDeclaration.getIdentifier()));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        List<ApexClassDeclaration> apexClassDeclarations = ApexPsiUtilities.getApexClassDeclarations(project);
        List<LookupElement> variants = new ArrayList<LookupElement>(apexClassDeclarations.size());
        for (ApexClassDeclaration apexClassDeclaration : apexClassDeclarations) {
            String className = apexClassDeclaration.getName();
            if (className.length() > 0) {
                variants.add(LookupElementBuilder.create(apexClassDeclaration)
                        .withIcon(AllIcons.Nodes.Class)
                        .withTypeText(PsiUtilities.getFileName(apexClassDeclaration)));
            }
        }
        return variants.toArray();
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        myElement.getIdentifier().replace(ApexElementFactory.createLeafFromText(myElement.getProject(), newElementName));
        return myElement;
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
        boolean result = super.isReferenceTo(element);
        return result;
    }
}
