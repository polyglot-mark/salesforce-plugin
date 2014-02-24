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
 * @author mark
 */
public class ApexAnnotationAnnotator implements Annotator {

//    private Map<String,AnnotationValidator> annotationValidators = new HashMap<String, AnnotationValidator>();

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
/*
        if (element instanceof ApexAnnotationDeclaration) {
            ApexAnnotationDeclaration apexAnnotationDeclaration = (ApexAnnotationDeclaration)element;
            String annotationName = apexAnnotationDeclaration.getName();
            if (annotationName == null) {
                annotateAsError(element, holder, "Invalid annotation");
            } else {
                AnnotationValidator annotationValidator = annotationValidators.get(annotationName);
                if (annotationValidator == null) {
                    annotateAsError(element, holder, "Unknown annotation");
                } else {
                    if (annotationValidator.isValid(apexAnnotationDeclaration, holder)) {
                        Annotation annotation = holder.createInfoAnnotation(element, null);
                        annotation.setTextAttributes(CodeInsightColors.ANNOTATION_NAME_ATTRIBUTES);
                    }
                }
            }
        }
*/
    }

/*
    private void annotateAsError(@NotNull PsiElement element, @NotNull AnnotationHolder holder, @NotNull String message) {
        Annotation annotation = holder.createErrorAnnotation(element, message);
        annotation.setHighlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL);
    }

    private abstract class AnnotationValidator {

        protected abstract boolean isValid(@NotNull ApexAnnotationDeclaration annotation, @NotNull AnnotationHolder holder);

    }

    {
        annotationValidators.put("Deprecated", new AnnotationValidator() {
            @Override
            protected boolean isValid(@NotNull ApexAnnotationDeclaration annotation, @NotNull AnnotationHolder holder) {
                // TODO: add all restrictions on @Deprecated annotation
                List<ApexAnnotationParameterDeclaration> apexAnnotationParameterDeclarations = annotation.getAnnotationParameterDeclarationList();
                if (apexAnnotationParameterDeclarations.size() != 0) {
                    annotateAsError(annotation, holder, "@Deprecated takes no parameters");
                    return false;
                }
                return true;
            }
        });

        annotationValidators.put("IsTest", new AnnotationValidator() {
            @Override
            protected boolean isValid(@NotNull ApexAnnotationDeclaration annotation, @NotNull AnnotationHolder holder) {
                // TODO: add all restrictions on @IsTest annotation
                List<ApexAnnotationParameterDeclaration> apexAnnotationParameterDeclarations = annotation.getAnnotationParameterDeclarationList();
                if (apexAnnotationParameterDeclarations.size() == 0) return true;
                for (ApexAnnotationParameterDeclaration apexAnnotationParameterDeclaration : apexAnnotationParameterDeclarations) {
                    String parameterName = apexAnnotationParameterDeclaration.getName();
                    if (StringUtil.isEmpty(parameterName)) {
                        annotateAsError(apexAnnotationParameterDeclaration, holder, "Parameter name is missing");
                        return false;
                    }
                    ApexAnnotationParameterValue apexAnnotationParameterValue = apexAnnotationParameterDeclaration.getAnnotationParameterValue();
                    String parameterValue = apexAnnotationParameterValue.getText();
                    if (StringUtil.isEmpty(parameterValue)) {
                        annotateAsError(apexAnnotationParameterDeclaration, holder, "Parameter value is missing");
                        return false;
                    }
                    if ("SeeAllData".equals(parameterName) || "OnInstall".equals(parameterName)) {
                        if (!isValidApexAnnotationParameterValue(apexAnnotationParameterValue, holder)) {
                            return false;
                        }
                    } else {
                        annotateAsError(apexAnnotationParameterDeclaration, holder, "Parameter key is unknown");
                        return false;
                    }
                }
                return true;
            }

            private boolean isValidApexAnnotationParameterValue(ApexAnnotationParameterValue value, AnnotationHolder holder) {
                if ("true".equals(value.getText()) || "false".equals(value.getText())) {
                    return true;
                } else {
                    annotateAsError(value, holder, "Parameter value must be true or false");
                    return false;
                }
            }
        });

        annotationValidators.put("ReadOnly", new AnnotationValidator() {
            @Override
            protected boolean isValid(@NotNull ApexAnnotationDeclaration annotation, @NotNull AnnotationHolder holder) {
                // TODO: add all restrictions on @ReadOnly annotation
                List<ApexAnnotationParameterDeclaration> apexAnnotationParameterDeclarations = annotation.getAnnotationParameterDeclarationList();
                if (apexAnnotationParameterDeclarations.size() != 0) {
                    annotateAsError(annotation, holder, "@ReadOnly takes no parameters");
                    return false;
                }
                return true;
            }
        });

        annotationValidators.put("RestResource", new AnnotationValidator() {
            @Override
            protected boolean isValid(@NotNull ApexAnnotationDeclaration annotation, @NotNull AnnotationHolder holder) {
                // TODO: add all restrictions on @RestResource annotation
                List<ApexAnnotationParameterDeclaration> apexAnnotationParameterDeclarations = annotation.getAnnotationParameterDeclarationList();
                if (apexAnnotationParameterDeclarations.size() == 0) {
                    annotateAsError(annotation, holder, "Missing parameter: urlMapping");
                    return false;
                } else {
                    if (apexAnnotationParameterDeclarations.size() == 1) {
                        ApexAnnotationParameterDeclaration apexAnnotationParameterDeclaration = apexAnnotationParameterDeclarations.get(0);
                        String parameterName = apexAnnotationParameterDeclaration.getName();
                        if (StringUtil.isEmpty(parameterName)) {
                            annotateAsError(annotation, holder, "Parameter name is missing: urlMapping");
                            return false;
                        }
                        ApexAnnotationParameterValue apexAnnotationParameterValue = apexAnnotationParameterDeclaration.getAnnotationParameterValue();
                        String parameterValue = apexAnnotationParameterValue.getText();
                        if (StringUtil.isEmpty(parameterValue)) {
                            annotateAsError(annotation, holder, "Parameter value is missing");
                            return false;
                        }
                        if ("urlMapping".equals(parameterName)) {
                            String value = apexAnnotationParameterValue.getText();
                            if (StringUtil.isEmpty(value) || !value.startsWith("'") || !value.endsWith("'")) {
                                annotateAsError(apexAnnotationParameterValue, holder, "urlMapping value must be a quoted string");
                                return false;
                            }
                        } else {
                            annotateAsError(annotation, holder, "Parameter name is unknown");
                            return false;
                        }
                    } else {
                        annotateAsError(annotation, holder, "@RestResource only takes one parameter: urlMapping");
                        return false;
                    }

                }
                return true;
            }
        });

        // TODO:  add method annotations: @Future @RemoteAction @TestVisible @Http....
    }

*/
}
