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

package au.com.borner.salesforce.plugin.apex.language.completion;

import au.com.borner.salesforce.plugin.apex.psi.ApexClassFile;
import au.com.borner.salesforce.plugin.apex.psi.ApexTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiErrorElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.*;

/**
 * @author Mark Borner (gzhomzb)
 */
public class ApexKeywordCompletionContributor extends CompletionContributor {

    public ApexKeywordCompletionContributor() {

        extend(CompletionType.BASIC, psiElement().atStartOf(psiFile(ApexClassFile.class)),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                        result.addElement(createKeywordLookupElement("public"));
                        result.addElement(createKeywordLookupElement("private"));
                        result.addElement(createKeywordLookupElement("global"));
                        result.addElement(createKeywordLookupElement("trigger"));
                    }
                });

        extend(CompletionType.BASIC, psiElement(ApexTypes.IDENTIFIER).afterLeaf("public", "private", "global"),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                        result.addElement(createKeywordLookupElement("virtual"));
                        result.addElement(createKeywordLookupElement("abstract"));
                        result.addElement(createKeywordLookupElement("class"));
                        result.addElement(createKeywordLookupElement("interface"));
                    }
                });

        extend(CompletionType.BASIC, psiElement(ApexTypes.IDENTIFIER).afterLeaf("virtual", "abstract"),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                        result.addElement(createKeywordLookupElement("with sharing"));
                        result.addElement(createKeywordLookupElement("without sharing"));
                    }
                });

        extend(CompletionType.BASIC, psiElement(PsiErrorElement.class),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                        result.addElement(createKeywordLookupElement("extends"));
                        result.addElement(createKeywordLookupElement("implements"));
                    }
                });











//        extend(CompletionType.BASIC, psiElement(ApexTypes.IDENTIFIER).afterSibling(psiElement(ApexExtendsClassName.class)),
//                new CompletionProvider<CompletionParameters>() {
//                    @Override
//                    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
//                        result.addElement(createKeywordLookupElement("implements"));
//                    }
//                });
    }

    private static LookupElement createKeywordLookupElement(String keyword) {
        return LookupElementBuilder.create(keyword).bold().withCaseSensitivity(false);
    }
}
