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
import au.com.borner.salesforce.plugin.apex.psi.ApexClassOrInterfaceReference;
import au.com.borner.salesforce.plugin.apex.psi.ApexInterfaceDeclaration;
import au.com.borner.salesforce.plugin.apex.psi.ApexPsiUtilities;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark
 */
public class ApexInterfaceNameReference extends PsiReferenceBase<ApexClassOrInterfaceReference> implements PsiPolyVariantReference {

    private final String interfaceName;
    private final Project project;

    public ApexInterfaceNameReference(@NotNull ApexClassOrInterfaceReference apexInterfaceReference, @NotNull TextRange textRange) {
        super(apexInterfaceReference, textRange);
        interfaceName = apexInterfaceReference.getText();
        project = apexInterfaceReference.getProject();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        final List<ApexInterfaceDeclaration> apexInterfaceDeclarations = ApexPsiUtilities.getApexInterfaceDeclarations(project, interfaceName);
        List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (ApexInterfaceDeclaration apexInterfaceDeclaration : apexInterfaceDeclarations) {
            results.add(new PsiElementResolveResult(apexInterfaceDeclaration.getIdentifier()));
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
        List<ApexInterfaceDeclaration> apexInterfaceDeclarations = ApexPsiUtilities.getApexInterfaceDeclarations(project);
        List<LookupElement> variants = new ArrayList<LookupElement>(apexInterfaceDeclarations.size());
        for (ApexInterfaceDeclaration apexInterfaceDeclaration : apexInterfaceDeclarations) {
            String interfaceName = apexInterfaceDeclaration.getName();
            if (interfaceName.length() > 0) {
                variants.add(LookupElementBuilder.create(apexInterfaceDeclaration)
                        .withIcon(AllIcons.Nodes.Interface)
                        .withTypeText(PsiUtilities.getFileName(apexInterfaceDeclaration)));
            }
        }
        return variants.toArray();
    }

}
