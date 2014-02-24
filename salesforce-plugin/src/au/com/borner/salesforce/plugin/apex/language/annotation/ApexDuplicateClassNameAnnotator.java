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
 * @author Mark Borner (gzhomzb)
 */
public class ApexDuplicateClassNameAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
/*
        if (element instanceof ApexClassDeclaration) {
            ApexClassDeclaration apexClassDeclaration = (ApexClassDeclaration)element;
            ApexIdentifier apexIdentifier = apexClassDeclaration.getIdentifier();
            if (apexIdentifier == null) return;
            String apexClassName = apexIdentifier.getText();
            if (apexClassName == null) return;

            Project project = element.getProject();
            List<ApexClassDeclaration> apexClassNames = ApexUtilities.getApexClassDeclarations(project, apexClassName);
            if (apexClassNames.size() > 1) {
                Annotation annotation = holder.createErrorAnnotation(element, "Class names must be unique within a Module");
                annotation.setHighlightType(ProblemHighlightType.ERROR);
            }
        }
*/
    }
}
