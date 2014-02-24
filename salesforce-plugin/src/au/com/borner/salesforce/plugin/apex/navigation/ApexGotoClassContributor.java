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

package au.com.borner.salesforce.plugin.apex.navigation;

import com.intellij.navigation.GotoClassContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by mark
 */
public class ApexGotoClassContributor extends ApexChooseByNameContributor implements GotoClassContributor {

    private static final String DUMMY = "dummy.";
    private static final String PERIOD = ".";

    @Nullable
    @Override
    public String getQualifiedName(NavigationItem item) {
        return DUMMY + item.getName();
    }

    @Nullable
    @Override
    public String getQualifiedNameSeparator() {
        return PERIOD;  // needed to fake out lookups
    }

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        return super.getNames(project, includeNonProjectItems);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        return super.getItemsByName(name, pattern, project, includeNonProjectItems);
    }

}

