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

package au.com.borner.salesforce.plugin.apex.psi;

import au.com.borner.salesforce.plugin.apex.language.ApexLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;

/**
 * A Factory for creating Apex psi Elements
 *
 * Created by mark
 */
public abstract class ApexElementFactory {

    private static final String DUMMY_CLASS_FILENAME = "dummy.cls";

    private static PsiFile createApexFile(Project project, String text) {
        return PsiFileFactory.getInstance(project).createFileFromText(DUMMY_CLASS_FILENAME, ApexLanguage.INSTANCE, text, false, false);
    }

    public static PsiElement createLeafFromText(Project project, String text) {
        return PsiTreeUtil.getDeepestFirst(createApexFile(project, text));
    }

}
