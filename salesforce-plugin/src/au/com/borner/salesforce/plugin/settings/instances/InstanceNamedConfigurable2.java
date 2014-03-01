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

package au.com.borner.salesforce.plugin.settings.instances;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.client.rest.InstanceUtils;
import au.com.borner.salesforce.plugin.panels.InstanceCredentialsPanel;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.ui.NamedConfigurable;
import com.intellij.openapi.util.Comparing;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Named Configurable for a Salesforce instance
 *
 * Created by mark
 */
public class InstanceNamedConfigurable2 extends NamedConfigurable<InstanceCredentials> {

    private boolean isNew;
    private final InstanceCredentials instanceCredentials;
    private final InstanceCredentialsPanel instanceCredentialsPanel;

    public InstanceNamedConfigurable2(@NotNull final InstanceCredentials instanceCredentials, @Nullable Runnable updateTree, boolean isNew) {
        super(false, updateTree);
        this.instanceCredentials = instanceCredentials;
        this.isNew = isNew;
        this.instanceCredentialsPanel = new InstanceCredentialsPanel();
        this.instanceCredentialsPanel.setButtonEnabled(true);
        this.instanceCredentialsPanel.setInstanceNameVisible(false);

        if (this.isNew) {
            instanceCredentialsPanel.setEnvironment(InstanceUtils.PRODUCTION_DE);
            instanceCredentialsPanel.setButtonEnabled(false);
        } else {
            instanceCredentialsPanel.setInputFieldsEnabled(false);
            instanceCredentialsPanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InstanceCredentials retrievedCredentials = InstancesPersistentStateComponent.getInstance().getInstance(instanceCredentials.getName());
                    if (retrievedCredentials != null) {
                        instanceCredentials.setUsername(retrievedCredentials.getUsername());
                        instanceCredentials.setPassword(retrievedCredentials.getPassword());
                        instanceCredentials.setSecurityToken(retrievedCredentials.getSecurityToken());
                        instanceCredentials.setEnvironment(retrievedCredentials.getEnvironment());
                        instanceCredentials.setOtherUrl(retrievedCredentials.getOtherUrl());
                        instanceCredentials.setRetrievedFromSafe(true);
                        instanceCredentialsPanel.setButtonEnabled(false);
                        instanceCredentialsPanel.setInputFieldsEnabled(true);
                        reset();
                    }
                }
            });
        }
    }


    @Nls
    @Override
    public String getDisplayName() {
        return instanceCredentials.getName();
    }

    @Override
    public void setDisplayName(String name) {
        throw new UnsupportedOperationException("Name cannot be changed");
    }

    @Override
    public InstanceCredentials getEditableObject() {
        return instanceCredentials;
    }

    @Override
    public String getBannerSlogan() {
        return instanceCredentials.getName();
    }

    @Override
    public JComponent createOptionsPanel() {
        return instanceCredentialsPanel.getPanel();
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Override
    public boolean isModified() {
        return isNew ||
                !Comparing.strEqual(instanceCredentialsPanel.getUsername().trim(), instanceCredentials.getUsername()) ||
                !Comparing.strEqual(instanceCredentialsPanel.getPassword().trim(), instanceCredentials.getPassword()) ||
                !Comparing.strEqual(instanceCredentialsPanel.getSecurityToken().trim(), instanceCredentials.getSecurityToken()) ||
                !Comparing.strEqual(instanceCredentialsPanel.getEnvironment(), instanceCredentials.getEnvironment()) ||
                !Comparing.strEqual(instanceCredentialsPanel.getOtherUrl().trim(), instanceCredentials.getOtherUrl());
    }

    @Override
    public void apply() throws ConfigurationException {
        instanceCredentialsPanel.validate();
        instanceCredentials.setUsername(instanceCredentialsPanel.getUsername());
        instanceCredentials.setPassword(instanceCredentialsPanel.getPassword());
        instanceCredentials.setSecurityToken(instanceCredentialsPanel.getSecurityToken());
        instanceCredentials.setEnvironment(instanceCredentialsPanel.getEnvironment());
        instanceCredentials.setOtherUrl(instanceCredentialsPanel.getOtherUrl());
        InstancesPersistentStateComponent.getInstance().addInstance(instanceCredentials);
        isNew = false;
    }

    @Override
    public void reset() {
        instanceCredentialsPanel.setUsername(instanceCredentials.getUsername());
        instanceCredentialsPanel.setPassword(instanceCredentials.getPassword());
        instanceCredentialsPanel.setSecurityToken(instanceCredentials.getSecurityToken());
        instanceCredentialsPanel.setEnvironment(instanceCredentials.getEnvironment());
        instanceCredentialsPanel.setOtherUrl(instanceCredentials.getOtherUrl());
    }

    @Override
    public void disposeUIResources() {

    }
}
