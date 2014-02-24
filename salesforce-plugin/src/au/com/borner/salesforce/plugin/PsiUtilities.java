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

package au.com.borner.salesforce.plugin;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by mark
 */
public abstract class PsiUtilities {

    public static String getFileName(PsiElement element) {
        VirtualFile virtualFile = getVirtualFile(element);
        return virtualFile == null ? null : virtualFile.getName();
    }

    @Nullable
    public static String getFileNameWithoutExtension(@NotNull PsiElement element) {
        VirtualFile virtualFile = getVirtualFile(element);
        return virtualFile == null ? null : virtualFile.getNameWithoutExtension();
    }

    @Nullable
    public static VirtualFile getVirtualFile(@NotNull PsiElement element) {
        PsiFile psiFile = element.getContainingFile();
        if (psiFile != null) {
            return psiFile.getVirtualFile();
        }
        return null;
    }

}
