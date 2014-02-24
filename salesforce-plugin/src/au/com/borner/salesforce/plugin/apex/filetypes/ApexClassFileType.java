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
 * An Apex Class file
 *
 * @author mark
 */
public class ApexClassFileType extends LanguageFileType {

    public static final ApexClassFileType INSTANCE = new ApexClassFileType();

    public ApexClassFileType() {
        super(ApexLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Apex Class";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Apex class file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "cls";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ApexIcons.FileType.CLASS;
    }

}
