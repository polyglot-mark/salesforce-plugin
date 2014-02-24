package au.com.borner.salesforce.plugin.settings.application;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Application level Salesforce plugin settings
 *
 * @author Mark Borner (gzhomzb)
 */
public class ApplicationSettingsConfigurable implements SearchableConfigurable, Configurable.NoScroll {

    private JPanel settingsPanel;
    private JCheckBox latestAPICheckBox;
    private JCheckBox doNotShowToolingCheckBox;

    private final ApplicationSettingsPersistentStateComponent applicationSettings;

    public ApplicationSettingsConfigurable() {
        this.applicationSettings = ApplicationSettingsPersistentStateComponent.getInstance();
        latestAPICheckBox.setSelected(applicationSettings.latestAPICheckBox);
        doNotShowToolingCheckBox.setSelected(applicationSettings.doNotShowToolingCheckBox);
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Salesforce Settings";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return settingsPanel;
    }

    @Override
    public boolean isModified() {
        return latestAPICheckBox.isSelected() != applicationSettings.latestAPICheckBox ||
               doNotShowToolingCheckBox.isSelected() != applicationSettings.doNotShowToolingCheckBox;
    }

    @Override
    public void apply() throws ConfigurationException {
        applicationSettings.latestAPICheckBox = latestAPICheckBox.isSelected();
        applicationSettings.doNotShowToolingCheckBox = doNotShowToolingCheckBox.isSelected();
    }

    @Override
    public void reset() {
        latestAPICheckBox.setSelected(applicationSettings.latestAPICheckBox);
        doNotShowToolingCheckBox.setSelected(applicationSettings.doNotShowToolingCheckBox);
    }

    @Override
    public void disposeUIResources() {

    }

    @NotNull
    @Override
    public String getId() {
        return "salesforce.settings";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }

}
