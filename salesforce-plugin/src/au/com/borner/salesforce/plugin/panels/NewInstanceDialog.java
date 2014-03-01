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

package au.com.borner.salesforce.plugin.panels;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.plugin.settings.instances.InstancesPersistentStateComponent;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * A Dialog for creating a new Salesforce instance
 *
 * Created by mark
 */
public class NewInstanceDialog extends DialogWrapper {

    private final InstanceCredentialsPanel instanceCredentialsPanel;

    public NewInstanceDialog(@Nullable Project project) {
        super(project);
        instanceCredentialsPanel = new InstanceCredentialsPanel();
        instanceCredentialsPanel.setButtonVisible(false);
        init();
        setTitle("New Salesforce Instance");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return instanceCredentialsPanel.getPanel();
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return instanceCredentialsPanel.getPreferableFocusComponent();
    }

    @Nullable
    @Override
    protected ValidationInfo doValidate() {
        try {
            instanceCredentialsPanel.validate();
        } catch (ConfigurationException e) {
            return new ValidationInfo(e.getMessage());
        }
        return null;
    }

    @Override
    protected void doOKAction() {
        InstancesPersistentStateComponent instancesPersistentStateComponent = InstancesPersistentStateComponent.getInstance();
        instancesPersistentStateComponent.addInstance(instanceCredentialsPanel.getInstanceCredentials());
        super.doOKAction();
    }
}
