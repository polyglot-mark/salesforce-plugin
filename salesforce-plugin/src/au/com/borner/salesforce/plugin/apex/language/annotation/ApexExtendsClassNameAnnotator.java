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

package au.com.borner.salesforce.plugin.apex.language.annotation;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * An annotator which inspects the class which an Apex class extends to ensure
 * the class name exists.
 *
 * @author Mark Borner (gzhomzb)
 */
public class ApexExtendsClassNameAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
/*
        if (element instanceof ApexExtendsDeclaration) {
            ApexExtendsDeclaration apexExtendsClause = (ApexExtendsDeclaration)element;
            ApexIdentifier apexIdentifier = apexExtendsClause.getIdentifier();
            String name = apexIdentifier.getText();
            if (name == null) return;
            if (apexExtendsClause.getParent() instanceof ApexClassDeclaration) {
                checkClassName(name, apexIdentifier, holder);
            } else if (apexExtendsClause.getParent() instanceof ApexInterfaceDeclaration) {
                checkInterfaceName(name, apexIdentifier, holder);
            }
        }
    }

    private void checkClassName(String name, ApexIdentifier apexIdentifier, AnnotationHolder holder) {
        Project project = apexIdentifier.getProject();
        List<ApexClassDeclaration> existingClassNames = ApexUtilities.getApexClassDeclarations(project, name);
        if (existingClassNames.size() == 0) {
            Annotation annotation = holder.createErrorAnnotation(apexIdentifier, "Unknown class name");
            annotation.setHighlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL);
        }

    }

    private void checkInterfaceName(String name, ApexIdentifier apexIdentifier, AnnotationHolder holder) {
        Project project = apexIdentifier.getProject();
        List<ApexInterfaceDeclaration> existingClassNames = ApexUtilities.getApexInterfaceDeclarations(project, name);
        if (existingClassNames.size() == 0) {
            Annotation annotation = holder.createErrorAnnotation(apexIdentifier, "Unknown interface name");
            annotation.setHighlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL);
        }
*/
    }
}
