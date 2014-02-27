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

package au.com.borner.salesforce.plugin.service;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.client.wsc.impl.SoapClientImpl;
import au.com.borner.salesforce.plugin.settings.instances.InstancesPersistentStateComponent;
import au.com.borner.salesforce.plugin.settings.project.ProjectSettingsPersistentStateComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A Project Service which wraps the Soap Client implementation and gets the credentials from the
 * project's persistent state components
 *
 * Created by gzhomzb
 */
public class SoapClientService extends SoapClientImpl {

    private String sessionId;

    public SoapClientService(@NotNull Project project) {
        ProjectSettingsPersistentStateComponent projectSettings = ProjectSettingsPersistentStateComponent.getInstance(project);
        InstancesPersistentStateComponent instanceSettings = InstancesPersistentStateComponent.getInstance();
        InstanceCredentials instanceCredentials = instanceSettings.getInstance(projectSettings.instanceName);
        if (instanceCredentials != null) {
            sessionId = login(instanceCredentials);
        }
    }

    @Nullable
    public String getSessionId() {
        return sessionId;
    }

}
