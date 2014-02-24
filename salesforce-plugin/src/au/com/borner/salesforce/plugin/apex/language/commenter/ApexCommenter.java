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

package au.com.borner.salesforce.plugin.apex.language.commenter;

import au.com.borner.salesforce.plugin.apex.psi.ApexTypes;
import com.intellij.lang.java.JavaCommenter;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;

/**
 * @author mark
 */
public class ApexCommenter extends JavaCommenter {

    @Override
    @Nullable
    public IElementType getLineCommentTokenType() {
        return ApexTypes.LINE_COMMENT;
    }

    @Override
    @Nullable
    public IElementType getBlockCommentTokenType() {
        return ApexTypes.COMMENT;
    }

    @Override
    @Nullable
    public IElementType getDocumentationCommentTokenType() {
        return null;
//        return JavaDocElementType.DOC_COMMENT;
    }

    @Override
    public boolean isDocumentationComment(final PsiComment element) {
        return false;
//        return element instanceof PsiDocComment;
    }

    @Override
    public boolean isDocumentationCommentText(final PsiElement element) {
        return false;
//        if (element == null) return false;
//        final ASTNode node = element.getNode();
//        return node != null && (node.getElementType() == JavaDocTokenType.DOC_COMMENT_DATA || node.getElementType() == JavaDocTokenType.DOC_TAG_VALUE_TOKEN);
    }
}
