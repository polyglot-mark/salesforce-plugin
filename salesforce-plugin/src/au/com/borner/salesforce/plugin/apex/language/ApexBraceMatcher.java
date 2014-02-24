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

package au.com.borner.salesforce.plugin.apex.language;

import au.com.borner.salesforce.plugin.apex.psi.*;
import com.intellij.codeInsight.hint.DeclarationRangeUtil;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ApexBraceMatcher implements PairedBraceMatcher {

    private static TokenSet COMMENT_OR_WHITE_SPACE = TokenSet.create(ApexTypes.COMMENT, ApexTypes.LINE_COMMENT, com.intellij.psi.TokenType.WHITE_SPACE);

    private final BracePair[] pairs = new BracePair[] {
            new BracePair(ApexTypes.LPAREN, ApexTypes.RPAREN, false),
            new BracePair(ApexTypes.LBRACE, ApexTypes.RBRACE, true),
            new BracePair(ApexTypes.LBRACK, ApexTypes.RBRACK, false) //,
            //new BracePair(JavaDocTokenType.DOC_INLINE_TAG_START, JavaDocTokenType.DOC_INLINE_TAG_END, false),
    };

    @Override
    public BracePair[] getPairs() {
        return pairs;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull final IElementType lbraceType, @Nullable final IElementType contextType) {
        if (contextType instanceof ApexElementType) {
            return isPairedBracesAllowedBeforeTypeInApex(contextType);
        } else {
            return true;
        }
    }

    private static boolean isPairedBracesAllowedBeforeTypeInApex(final IElementType tokenType) {
        return COMMENT_OR_WHITE_SPACE.contains(tokenType)
                || tokenType == ApexTypes.SEMI
                || tokenType == ApexTypes.COMMA
                || tokenType == ApexTypes.RPAREN
                || tokenType == ApexTypes.RBRACK
                || tokenType == ApexTypes.RBRACE
                || tokenType == ApexTypes.LBRACE;
    }

    @Override
    public int getCodeConstructStart(final PsiFile file, int openingBraceOffset) {
        PsiElement element = file.findElementAt(openingBraceOffset);
        if (element == null || element instanceof PsiFile) return openingBraceOffset;
        PsiElement parent = element.getParent();
        if (parent instanceof ApexBlock) {
            parent = parent.getParent();
            if (parent instanceof ApexMethodBody) { // TODO: || parent instanceof PsiClassInitializer) {
                TextRange range = DeclarationRangeUtil.getDeclarationRange(parent);
                return range.getStartOffset();
            }
            else if (parent instanceof ApexStatement) {
                if (parent instanceof ApexBlockStatement && parent.getParent() instanceof ApexStatement) {
                    parent = parent.getParent();
                }
                return parent.getTextRange().getStartOffset();
            }
        }
        else if (parent instanceof ApexClassDeclaration) {
            TextRange range = DeclarationRangeUtil.getDeclarationRange(parent);
            return range.getStartOffset();
        }
        return openingBraceOffset;
    }
}