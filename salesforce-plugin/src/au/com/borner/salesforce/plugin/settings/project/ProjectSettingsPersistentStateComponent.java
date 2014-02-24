package au.com.borner.salesforce.plugin.settings.project;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

/**
 * A PersistentStateComponent for storing the Salesforce project settings
 *
 * @author mark
 */
@State(
    name = "SalesforceProjectSettings",
        storages = {
            @Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
            @Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR + "/salesforce.xml", scheme = StorageScheme.DIRECTORY_BASED)
        }
)
public class ProjectSettingsPersistentStateComponent implements PersistentStateComponent<ProjectSettingsPersistentStateComponent> {

    public String instanceName;

    public static ProjectSettingsPersistentStateComponent getInstance(Project project) {
        return ServiceManager.getService(project, ProjectSettingsPersistentStateComponent.class);
    }

    @Nullable
    @Override
    public ProjectSettingsPersistentStateComponent getState() {
        return this;
    }

    @Override
    public void loadState(ProjectSettingsPersistentStateComponent state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}
