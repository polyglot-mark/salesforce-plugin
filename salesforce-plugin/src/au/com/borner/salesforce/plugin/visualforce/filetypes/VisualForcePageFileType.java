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

package au.com.borner.salesforce.plugin.visualforce.filetypes;

import au.com.borner.salesforce.plugin.visualforce.VisualForceIcons;
import au.com.borner.salesforce.plugin.visualforce.language.VisualForceLanguage;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by mark
 */
public class VisualForcePageFileType extends LanguageFileType {

    public static final VisualForcePageFileType INSTANCE = new VisualForcePageFileType();

    public VisualForcePageFileType() {
        super(VisualForceLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Visualforce Page";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Visualforce page file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "page";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return VisualForceIcons.FileType.PAGE;
    }

}
