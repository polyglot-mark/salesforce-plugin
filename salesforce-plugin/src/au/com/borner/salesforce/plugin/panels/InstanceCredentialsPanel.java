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
import au.com.borner.salesforce.client.rest.InstanceUtils;
import au.com.borner.salesforce.plugin.settings.instances.DuplicateInstanceNameChecker;
import com.intellij.openapi.options.ConfigurationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A JPanel for display/editing the credentials for a Salesforce instance
 *
 * Created by mark
 */
public class InstanceCredentialsPanel {

    private JTextField instanceName;
    private JLabel instanceNameLabel;
    private JTextField username;
    private JPasswordField password;
    private JPasswordField securityToken;
    private JLabel otherUrlLabel;
    private JTextField otherUrl;
    private JPanel instanceDetailsPanel;
    private JComboBox environmentComboBox;
    private JButton button;

    public InstanceCredentialsPanel() {
        environmentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (environmentComboBox.getSelectedItem() != null && environmentComboBox.getSelectedItem().equals(InstanceUtils.OTHER)) {
                    otherUrlLabel.setVisible(true);
                    otherUrl.setVisible(true);
                } else {
                    otherUrlLabel.setVisible(false);
                    otherUrl.setVisible(false);
                    otherUrl.setText(null);
                }
            }
        });

    }

    public void validate() throws ConfigurationException {
        if (instanceName.isVisible()) {
            if (instanceName.getText() == null || instanceName.getText().trim().length() == 0) {
                throw new ConfigurationException("Please specify an instance name.");
            }
            if (DuplicateInstanceNameChecker.isDuplicate(instanceName.getText())) {
                throw new ConfigurationException("Instance name already exists - please specify a different name.");
            }
        }
        if (username.getText() == null || username.getText().trim().length() == 0) {
            throw new ConfigurationException("Please specify your Username.");
        }
        if (password.getPassword().length == 0) {
            throw new ConfigurationException("Please specify your Password.");
        }
//        if (securityToken.getPassword().length == 0) {
//            throw new ConfigurationException("Please specify your Security Token");
//        }
        if (environmentComboBox.getSelectedIndex() < 0) {
            throw new ConfigurationException("Please select an Environment.");
        }
        if (environmentComboBox.getSelectedItem().equals(InstanceUtils.OTHER)) {
            if (otherUrl.getText() == null || otherUrl.getText().trim().length() == 0) {
                throw new ConfigurationException("Please specify Other URL.");
            }
        }
    }

    public void setInputFieldsEnabled(boolean enabled) {
        instanceName.setEnabled(enabled);
        username.setEnabled(enabled);
        password.setEnabled(enabled);
        securityToken.setEnabled(enabled);
        environmentComboBox.setEnabled(enabled);
        otherUrl.setEnabled(enabled);
    }

    public void addActionListener(ActionListener actionListener) {
        button.addActionListener(actionListener);
    }

    public void setButtonEnabled(boolean enabled) {
        button.setEnabled(enabled);
    }

    public void setButtonVisible(boolean visible) {
        button.setVisible(visible);
    }

    public String getInstanceName() {
        return instanceName.getText();
    }

    public String getUsername() {
        return username.getText();
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public void setPassword(String password) {
        this.password.setText(password);
    }

    public String getSecurityToken() {
        return new String(securityToken.getPassword());
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken.setText(securityToken);
    }

    public String getEnvironment() {
        return (String)environmentComboBox.getSelectedItem();
    }

    public void setEnvironment(String environment) {
        this.environmentComboBox.setSelectedItem(environment);
    }

    public String getOtherUrl() {
        return otherUrl.getText();
    }

    public void setOtherUrl(String otherUrl) {
        this.otherUrl.setText(otherUrl);
    }

    public JPanel getPanel() {
        return instanceDetailsPanel;
    }

    public void setInstanceNameVisible(boolean visible) {
        instanceName.setVisible(visible);
        instanceNameLabel.setVisible(visible);
    }

    public JComponent getPreferableFocusComponent() {
        return instanceName;
    }

    public InstanceCredentials getInstanceCredentials() {
        InstanceCredentials instanceCredentials = new InstanceCredentials(getInstanceName());
        instanceCredentials.setUsername(getUsername());
        instanceCredentials.setPassword(getPassword());
        instanceCredentials.setSecurityToken(getSecurityToken());
        instanceCredentials.setEnvironment(getEnvironment());
        instanceCredentials.setOtherUrl(getOtherUrl());
        return instanceCredentials;
    }

}
