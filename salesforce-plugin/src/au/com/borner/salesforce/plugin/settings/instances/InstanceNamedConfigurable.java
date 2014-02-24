package au.com.borner.salesforce.plugin.settings.instances;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.client.rest.InstanceUtils;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.ui.NamedConfigurable;
import com.intellij.openapi.util.Comparing;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An individual Salesforce instance which is identified by a name
 *
 * @author Mark Borner (gzhomzb)
 */
public class InstanceNamedConfigurable extends NamedConfigurable<InstanceCredentials> {

    private final InstanceCredentials instance;
    private Boolean isNewOrModified;
    private JPanel instancePanel;
    private JTextField username;
    private JPasswordField password;
    private JPasswordField securityToken;
    private JTextField consumerKey;
    private JPasswordField consumerSecret;
    private JComboBox environmentComboBox;
    private JTextField otherUrlTextField;
    private JButton retrieveDetailsButton;
    private JLabel otherUrlLabel;

    public InstanceNamedConfigurable(final InstanceCredentials instance, @Nullable Runnable updateTree, boolean isNewOrModified) {
        super(true, updateTree);
        this.instance = instance;
        this.isNewOrModified = isNewOrModified;

        if (this.isNewOrModified) {
            environmentComboBox.setSelectedItem(InstanceUtils.PRODUCTION_DE);
            retrieveDetailsButton.setEnabled(false);
        } else {
            setInputFieldsEnabled(false);
            retrieveDetailsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InstanceCredentials retrievedCredentials = InstancesPersistentStateComponent.getInstance().getInstance(instance.getName());
                    if (retrievedCredentials != null) {
                        instance.setUsername(retrievedCredentials.getUsername());
                        instance.setPassword(retrievedCredentials.getPassword());
                        instance.setSecurityToken(retrievedCredentials.getSecurityToken());
                        instance.setConsumerKey(retrievedCredentials.getConsumerKey());
                        instance.setConsumerSecret(retrievedCredentials.getConsumerSecret());
                        instance.setEnvironment(retrievedCredentials.getEnvironment());
                        instance.setOtherUrl(retrievedCredentials.getOtherUrl());
                        instance.setRetrievedFromSafe(true);
                        retrieveDetailsButton.setEnabled(false);
                        setInputFieldsEnabled(true);
                        reset();
                    }
                }
            });
        }

        environmentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (environmentComboBox.getSelectedItem() != null && environmentComboBox.getSelectedItem().equals(InstanceUtils.OTHER)) {
                    otherUrlLabel.setVisible(true);
                    otherUrlTextField.setVisible(true);
                } else {
                    otherUrlLabel.setVisible(false);
                    otherUrlTextField.setVisible(false);
                    otherUrlTextField.setText(null);
                }
            }
        });
    }

    // Named Configurable interface

    @Override
    public void setDisplayName(String name) {
        if (name.length() > 0 && !name.equals(instance.getName())) {
            isNewOrModified = true;
            instance.setName(name);
        }
    }

    @Override
    public InstanceCredentials getEditableObject() {
        return instance;
    }

    @Override
    public String getBannerSlogan() {
        return instance.getName();
    }

    @Override
    public JComponent createOptionsPanel() {
        return instancePanel;
    }

    // Unnamed Configurable interface

    @Override
    public boolean isModified() {
        return isNewOrModified ||
               !Comparing.strEqual(username.getText().trim(), instance.getUsername()) ||
               !Comparing.strEqual(new String(password.getPassword()), instance.getPassword()) ||
               !Comparing.strEqual(new String(securityToken.getPassword()), instance.getSecurityToken()) ||
               !Comparing.strEqual(consumerKey.getText().trim(), instance.getConsumerKey()) ||
               !Comparing.strEqual(new String(consumerSecret.getPassword()), instance.getConsumerSecret()) ||
               !Comparing.strEqual((String)environmentComboBox.getSelectedItem(), instance.getEnvironment()) ||
               !Comparing.strEqual(otherUrlTextField.getText().trim(), instance.getOtherUrl());
    }

    @Override
    public void apply() throws ConfigurationException {
        if (username.getText() == null || username.getText().trim().length() == 0) {
            throw new ConfigurationException("Please specify your Username.");
        }
        if (password.getPassword().length == 0) {
            throw new ConfigurationException("Please specify your Password.");
        }
        if (securityToken.getPassword().length == 0) {
            throw new ConfigurationException("Please specify your Security Token");
        }
        if (consumerKey.getText() == null || consumerKey.getText().trim().length() == 0) {
            throw new ConfigurationException("Please specify your Consumer Key.");
        }
        if (consumerSecret.getPassword().length == 0) {
            throw new ConfigurationException("Please specify your Consumer Secret");
        }
        if (environmentComboBox.getSelectedIndex() < 0) {
            throw new ConfigurationException("Please select an Environment.");
        }
        if (environmentComboBox.getSelectedItem().equals(InstanceUtils.OTHER)) {
            if (otherUrlTextField.getText() == null || otherUrlTextField.getText().trim().length() == 0) {
                throw new ConfigurationException("Please specify Other URL.");
            }
        }
        instance.setUsername(username.getText());
        instance.setPassword(new String(password.getPassword()));
        instance.setSecurityToken(new String(securityToken.getPassword()));
        instance.setConsumerKey(consumerKey.getText());
        instance.setConsumerSecret(new String(consumerSecret.getPassword()));
        instance.setEnvironment((String)environmentComboBox.getSelectedItem());
        instance.setOtherUrl(otherUrlTextField.getText());
        InstancesPersistentStateComponent.getInstance().addInstance(instance);
        isNewOrModified = false;
    }

    @Override
    public void reset() {
        username.setText(instance.getUsername());
        password.setText(instance.getPassword());
        securityToken.setText(instance.getSecurityToken());
        consumerKey.setText(instance.getConsumerKey());
        consumerSecret.setText(instance.getConsumerSecret());
        environmentComboBox.setSelectedItem(instance.getEnvironment());
        otherUrlTextField.setText(instance.getOtherUrl());
    }

    @Override
    public void disposeUIResources() {

    }

    // Configurable interface

    @Nls
    @Override
    public String getDisplayName() {
        return instance.getName();
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    // Helper methods

    public void setInputFieldsEnabled(boolean enabled) {
        username.setEnabled(enabled);
        password.setEnabled(enabled);
        securityToken.setEnabled(enabled);
        consumerKey.setEnabled(enabled);
        consumerSecret.setEnabled(enabled);
        environmentComboBox.setEnabled(enabled);
        otherUrlTextField.setEnabled(enabled);
    }

    private void createUIComponents() {
        // This is here because if we let IntelliJ instantiate it, it will throw exceptions trying to set the selected item!  BUG!!!
        environmentComboBox = new JComboBox(new Object[] {"Production / Developer Edition", "Sandbox", "Pre-Release", "Other"});
    }
}
