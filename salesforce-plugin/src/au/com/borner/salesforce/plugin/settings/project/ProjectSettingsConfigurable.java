package au.com.borner.salesforce.plugin.settings.project;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mark
 */
public class ProjectSettingsConfigurable implements SearchableConfigurable {

    private final InstanceSelectionPanel instanceSelectionPanel;
    private final ProjectSettingsPersistentStateComponent projectSettingsPersistentStateComponent;

    public ProjectSettingsConfigurable(Project project) {
        this.instanceSelectionPanel = new InstanceSelectionPanel();
        this.projectSettingsPersistentStateComponent = ProjectSettingsPersistentStateComponent.getInstance(project);
    }

    @NotNull
    @Override
    public String getId() {
        return "salesforce.project";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Salesforce Instance";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return instanceSelectionPanel.getPanel();
    }

    @Override
    public boolean isModified() {
        return instanceSelectionPanel.getSelectedInstance() != null &&
               !instanceSelectionPanel.getSelectedInstance().equals(projectSettingsPersistentStateComponent.instanceName);
    }

    @Override
    public void apply() throws ConfigurationException {
        if (instanceSelectionPanel.getSelectedInstance() == null) {
            throw new ConfigurationException("Please select a Salesforce instance.");
        }
        projectSettingsPersistentStateComponent.instanceName = instanceSelectionPanel.getSelectedInstance();
    }

    @Override
    public void reset() {
        instanceSelectionPanel.resetSelectedInstance();
    }

    @Override
    public void disposeUIResources() {

    }
}
