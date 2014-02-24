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

import au.com.borner.salesforce.plugin.apex.filetypes.ApexClassFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A set of utility methods for working with Apex psi Elements
 *
 * @author mark
 */
public abstract class ApexPsiUtilities {

    @NotNull
    public static List<ApexClassDeclaration> getApexClassDeclarations(@NotNull Project project, @NotNull String name) {
        List<ApexClassDeclaration> result = new ArrayList<ApexClassDeclaration>();

        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, ApexClassFileType.INSTANCE,
                GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            ApexClassFile apexClassFile = (ApexClassFile)PsiManager.getInstance(project).findFile(virtualFile);
            ApexClassDeclaration apexClassDeclaration = PsiTreeUtil.getChildOfType(apexClassFile, ApexClassDeclaration.class);
            if (apexClassDeclaration != null) {
                String className = apexClassDeclaration.getName();
                if (name.equals(className)) {
                    result.add(apexClassDeclaration);
                }
            }
        }
        return result;
    }

    @NotNull
    public static List<ApexClassDeclaration> getApexClassDeclarations(@NotNull Project project) {
        List<ApexClassDeclaration> result = new ArrayList<ApexClassDeclaration>();

        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, ApexClassFileType.INSTANCE,
                GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            ApexClassFile apexClassFile = (ApexClassFile)PsiManager.getInstance(project).findFile(virtualFile);
            ApexClassDeclaration apexClassDeclaration = PsiTreeUtil.getChildOfType(apexClassFile, ApexClassDeclaration.class);
            if (apexClassDeclaration != null) {
                result.add(apexClassDeclaration);
            }
        }
        return result;
    }

    @NotNull
    public static List<ApexInterfaceDeclaration> getApexInterfaceDeclarations(@NotNull Project project, @NotNull String name) {
        List<ApexInterfaceDeclaration> result = new ArrayList<ApexInterfaceDeclaration>();

        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, ApexClassFileType.INSTANCE,
                GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            ApexClassFile apexClassFile = (ApexClassFile)PsiManager.getInstance(project).findFile(virtualFile);
            ApexInterfaceDeclaration apexInterfaceDeclaration = PsiTreeUtil.getChildOfType(apexClassFile, ApexInterfaceDeclaration.class);
            if (apexInterfaceDeclaration != null) {
                String interfaceName = apexInterfaceDeclaration.getName();
                if (name.equals(interfaceName)) {
                    result.add(apexInterfaceDeclaration);
                }
            }
        }
        return result;
    }

    @NotNull
    public static List<ApexInterfaceDeclaration> getApexInterfaceDeclarations(@NotNull Project project) {
        List<ApexInterfaceDeclaration> result = new ArrayList<ApexInterfaceDeclaration>();

        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, ApexClassFileType.INSTANCE,
                GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            ApexClassFile apexClassFile = (ApexClassFile)PsiManager.getInstance(project).findFile(virtualFile);
            ApexInterfaceDeclaration apexInterfaceDeclaration = PsiTreeUtil.getChildOfType(apexClassFile, ApexInterfaceDeclaration.class);
            if (apexInterfaceDeclaration != null) {
                result.add(apexInterfaceDeclaration);
            }
        }
        return result;
    }

/*
    @Nullable
    public static String getIdentifierValue(@Nullable ApexDeclaration apexDeclaration) {
        if (apexDeclaration != null) {
            ApexIdentifier apexIdentifier = apexDeclaration.getIdentifier();
            if (apexIdentifier != null) {
                return apexIdentifier.getText();
            }
        }
        return null;
    }

    @Nullable
    public static <T extends ApexDeclaration> ApexIdentifier getIdentifierByType(@Nullable ApexClassFile apexClassFile, @NotNull Class<T> type) {
        T result = PsiTreeUtil.getChildOfType(apexClassFile, type);
        if (result != null) {
            return result.getIdentifier();
        }
        return null;
    }
*/
}
