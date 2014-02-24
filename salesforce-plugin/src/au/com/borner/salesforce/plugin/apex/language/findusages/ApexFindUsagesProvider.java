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

package au.com.borner.salesforce.plugin.apex.language.findusages;

import au.com.borner.salesforce.plugin.apex.lexer.ApexLexer;
import au.com.borner.salesforce.plugin.apex.psi.*;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author mark
 */
public class ApexFindUsagesProvider implements FindUsagesProvider {

    private static final DefaultWordsScanner WORDS_SCANNER =
            new DefaultWordsScanner(new ApexLexer(),
                    TokenSet.create(ApexTypes.CLASS_DECLARATION, ApexTypes.INTERFACE_DECLARATION, ApexTypes.CLASS_OR_INTERFACE_REFERENCE),
                    TokenSet.create(ApexTypes.COMMENT, ApexTypes.LINE_COMMENT),
                    TokenSet.EMPTY);

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return WORDS_SCANNER;
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return true;
//        boolean result = psiElement instanceof ApexDeclarationElement || psiElement.getParent() instanceof ApexDeclarationElement;
//        System.out.println("canFindUsagesFor (" + result + "): " + psiElement.getParent().getClass().getSimpleName() + ":" + psiElement.getClass().getSimpleName() + "/" + psiElement.getText());
//        return result;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof ApexClassDeclaration) {
            return "Apex Class";
        } else if (element instanceof ApexInterfaceDeclaration) {
            return "Apex Interface";
        } else if (element instanceof ApexTriggerDefinition) {
            return "Apex Trigger";
        } else {
            return "Unknown type";
        }
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof ApexDeclarationElement) {
            String name = ((ApexDeclarationElement)element).getName();
            return name == null ? "" : name;
        } else {
            return "Unknown Desc";
        }
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return element.getText();
    }

}
