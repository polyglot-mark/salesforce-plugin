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
import au.com.borner.salesforce.plugin.apex.filetypes.ApexTriggerFileType;
import au.com.borner.salesforce.plugin.apex.language.ApexLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * An Apex Trigger file
 *
 * Created by mark
 */
public class ApexTriggerFile extends PsiFileBase {

    public ApexTriggerFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ApexLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ApexTriggerFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Apex trigger file";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return ApexIcons.FileType.TRIGGER;
    }
}
