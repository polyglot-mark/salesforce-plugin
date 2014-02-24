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
 * An annotator which inspects the interface which an Apex class implements to ensure
 * the interface name exists.
 * 
 * @author mark
 */
public class ApexInterfaceNameAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
/*
        if (element instanceof ApexImplementsDeclaration) {
            ApexImplementsDeclaration apexImplementsClause = (ApexImplementsDeclaration)element;
            for (ApexIdentifier apexIdentifier : apexImplementsClause.getIdentifierList()) {
                String interfaceName = apexIdentifier.getText();
                if (interfaceName != null) {
                    Project project = element.getProject();
                    List<ApexInterfaceDeclaration> existingInterfaceIdentifiers = ApexUtilities.getApexInterfaceDeclarations(project, interfaceName);
                    if (existingInterfaceIdentifiers.size() == 0) {
                        Annotation annotation = holder.createErrorAnnotation(apexIdentifier, "Unknown interface name");
                        annotation.setHighlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL);
                    }
                }
            }
        }
*/
    }
}
