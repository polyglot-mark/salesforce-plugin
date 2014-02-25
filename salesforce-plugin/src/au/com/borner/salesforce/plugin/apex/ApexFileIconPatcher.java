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

package au.com.borner.salesforce.plugin.apex;

import au.com.borner.salesforce.plugin.apex.filetypes.ApexTriggerFileType;
import au.com.borner.salesforce.plugin.apex.psi.ApexClassFile;
import au.com.borner.salesforce.plugin.apex.psi.ApexDeclaration;
import au.com.borner.salesforce.plugin.util.IconUtilities;
import com.intellij.ide.FileIconPatcher;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * A File Icon Patcher which returns a RowIcon for the file which indicates
 * whether it is a class/interface/enum file along with the visibility of the
 * class/interface/enum
 *
 * Created by gzhomzb
 */
public class ApexFileIconPatcher implements FileIconPatcher {

    @Override
    public Icon patchIcon(Icon baseIcon, VirtualFile file, @Iconable.IconFlags int flags, @Nullable Project project) {
        if (project == null) return baseIcon;

        Icon result = baseIcon;
        PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
        if (psiFile instanceof ApexClassFile) {
            ApexClassFile apexClassFile = (ApexClassFile)psiFile;
            if (apexClassFile.isException()) {
                result = getIconWithVisibility(ApexIcons.EXCEPTION, apexClassFile, flags);
            } else if (apexClassFile.isInterface()) {
                result = getIconWithVisibility(ApexIcons.INTERFACE, apexClassFile, flags);
            } else if (apexClassFile.isClass()) {
                result =  getIconWithVisibility(ApexIcons.CLASS, apexClassFile, flags);
            } else if (apexClassFile.isEnum()) {
                result = getIconWithVisibility(ApexIcons.ENUM, apexClassFile, flags);
            } else if (apexClassFile.isTrigger()) {
                // Triggers do not have any visibility
                result = ApexTriggerFileType.INSTANCE.getIcon();
            }
        }
        return result;
    }

    private Icon getIconWithVisibility(@NotNull Icon baseIcon, @NotNull PsiFile psiFile, @Iconable.IconFlags int flags) {
        if (flags == 0) {
            // we are displaying the Icon in the project tree - add visibility to base Icon
            ApexDeclaration apexDeclaration = PsiTreeUtil.getChildOfType(psiFile, ApexDeclaration.class);
            if (apexDeclaration != null) {
                if (apexDeclaration.isProtected()) {
                    return IconUtilities.createIconRow(baseIcon, ApexIcons.PROTECTED);
                }
                if (apexDeclaration.isPrivate()) {
                    return IconUtilities.createIconRow(baseIcon, ApexIcons.PRIVATE);
                }
                if (apexDeclaration.isPublic()) {
                    return IconUtilities.createIconRow(baseIcon, ApexIcons.PUBLIC);
                }
                if (apexDeclaration.isGlobal()) {
                    return IconUtilities.createIconRow(baseIcon, ApexIcons.GLOBAL);
                }
            }
        }

        // we are display the Icon on the tab - do not add visibility
        return baseIcon;
    }

}
