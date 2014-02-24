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

import au.com.borner.salesforce.plugin.apex.ApexIcons;
import au.com.borner.salesforce.plugin.apex.filetypes.ApexClassFileType;
import au.com.borner.salesforce.plugin.apex.language.ApexLanguage;
import au.com.borner.salesforce.plugin.util.IconUtilities;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.Iconable;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.RowIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by mark
 */
public class ApexClassFile extends PsiFileBase {


    public ApexClassFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ApexLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ApexClassFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Apex class file";
    }

    @Override
    protected boolean isVisibilitySupported() {
        return true;
    }

    @Override
    protected Icon getBaseIcon() {
        if (isException()) {
            return ApexIcons.EXCEPTION;
        } else if (isInterface()) {
            return ApexIcons.INTERFACE;
        } else if (isClass()) {
            return ApexIcons.CLASS;
        } else if (isEnum()) {
            return ApexIcons.ENUM;
        } else {
            return super.getBaseIcon();
        }
    }

    @Nullable
    @Override
    protected Icon getElementIcon(@IconFlags int flags) {
        return getAdjustedBaseIcon(getBaseIcon(), flags);
    }

    @Override
    protected Icon getAdjustedBaseIcon(Icon icon, @IconFlags int flags) {
        ApexDeclaration apexDeclaration = PsiTreeUtil.getChildOfType(this, ApexDeclaration.class);
        if (apexDeclaration != null) {
            if (apexDeclaration.isProtected()) {
                return IconUtilities.createIconRow(icon, ApexIcons.PROTECTED);
            }
            if (apexDeclaration.isPrivate()) {
                return IconUtilities.createIconRow(icon, ApexIcons.PRIVATE);
            }
            if (apexDeclaration.isPublic()) {
                return IconUtilities.createIconRow(icon, ApexIcons.PUBLIC);
            }
            if (apexDeclaration.isGlobal()) {
                return IconUtilities.createIconRow(icon, ApexIcons.GLOBAL);
            }
        }
        return icon;
    }

    public boolean isException() {
        return getVirtualFile().getNameWithoutExtension().endsWith("Exception");
    }

    public boolean isInterface() {
        return PsiTreeUtil.getChildOfType(this, ApexInterfaceDeclaration.class) != null;
    }

    public boolean isClass() {
        return PsiTreeUtil.getChildOfType(this, ApexClassDeclaration.class) != null;
    }

    public boolean isEnum() {
        return PsiTreeUtil.getChildOfType(this, ApexEnumDeclaration.class) != null;
    }

}
