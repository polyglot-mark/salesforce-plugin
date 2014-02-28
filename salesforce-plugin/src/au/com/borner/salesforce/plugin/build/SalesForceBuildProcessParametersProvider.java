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

package au.com.borner.salesforce.plugin.build;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.plugin.service.SoapClientService;
import au.com.borner.salesforce.plugin.settings.instances.InstancesPersistentStateComponent;
import au.com.borner.salesforce.plugin.settings.project.ProjectSettingsPersistentStateComponent;
import com.intellij.compiler.server.BuildProcessParametersProvider;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This Build Process Parameters Provider add a VM argument to the invocation of
 * the Build Server.  The parameters is a -D define with the session Id for
 * Salesforce.
 *
 * @see au.com.borner.salesforce.jps.SalesForceModuleLevelBuilder
 * @see au.com.borner.salesforce.jps.SalesForceBuilderService
 *
 * Created by mark
 */
public class SalesForceBuildProcessParametersProvider extends BuildProcessParametersProvider {

    private final Project project;

    public SalesForceBuildProcessParametersProvider(Project project) {
        this.project = project;
    }

    @NotNull
    @Override
    public List<String> getVMArguments() {
        List<String> arguments = new ArrayList<String>(1);
        ProjectSettingsPersistentStateComponent projectSettings = ProjectSettingsPersistentStateComponent.getInstance(project);
        InstancesPersistentStateComponent instanceSettings = InstancesPersistentStateComponent.getInstance();
        InstanceCredentials instanceCredentials = instanceSettings.getInstance(projectSettings.instanceName);
        if (instanceCredentials != null) {
            arguments.add("-Dusername=" + instanceCredentials.getUsername());
            arguments.add("-Dpassword=" + instanceCredentials.getPassword());
            arguments.add("-DsecurityToken=" + instanceCredentials.getSecurityToken());
            arguments.add("-Denvironment=" + instanceCredentials.getEnvironment());
            arguments.add("-DtraceMessages=true");
        }
        return arguments;
    }

}
