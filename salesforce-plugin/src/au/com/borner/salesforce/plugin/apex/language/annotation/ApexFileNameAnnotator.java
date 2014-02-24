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
 * An Apex annotator which verifies that the class/interface/trigger name is also the name of the file
 *
 * @author Mark Borner (gzhomzb)
 */
public class ApexFileNameAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
/*
        if (element instanceof ApexClassDeclaration) {
            ApexClassDeclaration apexClassDeclaration = (ApexClassDeclaration)element;
            checkIdentifierNameWithFileName(apexClassDeclaration, holder);
        }

        if (element instanceof ApexInterfaceDeclaration) {
            ApexInterfaceDeclaration apexInterfaceDeclaration = (ApexInterfaceDeclaration)element;
            checkIdentifierNameWithFileName(apexInterfaceDeclaration, holder);
        }

        if (element instanceof ApexTriggerDeclaration) {
            ApexTriggerDeclaration apexTriggerDeclaration = (ApexTriggerDeclaration)element;
            checkIdentifierNameWithFileName(apexTriggerDeclaration, holder);
        }
*/
    }
/*
    private void checkIdentifierNameWithFileName(@NotNull ApexDeclaration apexDeclaration, @NotNull AnnotationHolder holder) {
        String name = apexDeclaration.getName();
        if (name != null) {
            String filename = PsiElementUtilities.getFileNameWithoutExtension(apexDeclaration);
            if (filename != null && !filename.equals(name)) {
                Annotation annotation = holder.createErrorAnnotation(apexDeclaration.getIdentifier(), getErrorMessage(name));
                annotation.setHighlightType(ProblemHighlightType.ERROR);
            }
        }
    }

    @NotNull
    private String getErrorMessage(@NotNull String entityName) {
        return entityName + " must be contained in a file named " + entityName;
    }
*/
}
