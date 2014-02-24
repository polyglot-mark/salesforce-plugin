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

package au.com.borner.salesforce.plugin.apex.filetypes;

import au.com.borner.salesforce.plugin.apex.ApexIcons;
import au.com.borner.salesforce.plugin.apex.language.ApexLanguage;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * An Apex Trigger file
 *
 * Created by mark
 */
public class ApexTriggerFileType extends LanguageFileType {

    public static final ApexTriggerFileType INSTANCE = new ApexTriggerFileType();

    public ApexTriggerFileType() {
        super(ApexLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Apex Trigger";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Apex trigger file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "trigger";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ApexIcons.FileType.TRIGGER;
    }
}
