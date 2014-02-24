package au.com.borner.salesforce.plugin.settings.application;

import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

/**
 * A persistent state component for application level Salesforce plugin settings
 *
 * @author Mark Borner (gzhomzb)
 */
@State(
        name = "Salesforce",
        storages = {
                @Storage(file = StoragePathMacros.APP_CONFIG + "/salesforce.xml")
        }
)
public class ApplicationSettingsPersistentStateComponent implements PersistentStateComponent<ApplicationSettingsPersistentStateComponent> {

    public boolean latestAPICheckBox = true;
    public boolean doNotShowToolingCheckBox = true;

    public static ApplicationSettingsPersistentStateComponent getInstance() {
        return ServiceManager.getService(ApplicationSettingsPersistentStateComponent.class);
    }

    public ApplicationSettingsPersistentStateComponent() {
    }

    @Nullable
    @Override
    public ApplicationSettingsPersistentStateComponent getState() {
        return this;
    }

    @Override
    public void loadState(ApplicationSettingsPersistentStateComponent state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}
