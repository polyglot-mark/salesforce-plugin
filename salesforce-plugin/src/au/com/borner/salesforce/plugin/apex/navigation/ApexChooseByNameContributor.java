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

import au.com.borner.salesforce.plugin.apex.psi.ApexClassDeclaration;
import au.com.borner.salesforce.plugin.apex.psi.ApexInterfaceDeclaration;
import au.com.borner.salesforce.plugin.apex.psi.ApexPsiUtilities;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark
 */
public class ApexChooseByNameContributor implements ChooseByNameContributor {

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<String> result = new ArrayList<String>();

        List<ApexClassDeclaration> apexClassDeclarations = ApexPsiUtilities.getApexClassDeclarations(project);
        for (ApexClassDeclaration apexClassDeclaration : apexClassDeclarations) {
            String apexClassName = apexClassDeclaration.getName();
            result.add(apexClassName);
        }

        List<ApexInterfaceDeclaration> apexInterfaceDeclarations = ApexPsiUtilities.getApexInterfaceDeclarations(project);
        for (ApexInterfaceDeclaration apexInterfaceDeclaration : apexInterfaceDeclarations) {
            String apexClassName = apexInterfaceDeclaration.getName();
            result.add(apexClassName);
        }

        return result.toArray(new String[result.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {

        List<ApexClassDeclaration> apexClassNames = ApexPsiUtilities.getApexClassDeclarations(project, name);
        List<ApexInterfaceDeclaration> apexInterfaceNames = ApexPsiUtilities.getApexInterfaceDeclarations(project, name);

        return ArrayUtil.mergeArrays(apexClassNames.toArray(new NavigationItem[apexClassNames.size()]), apexInterfaceNames.toArray(new NavigationItem[apexInterfaceNames.size()]));
    }
}
