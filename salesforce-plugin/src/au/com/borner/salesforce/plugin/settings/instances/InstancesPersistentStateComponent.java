package au.com.borner.salesforce.plugin.settings.instances;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import com.intellij.ide.passwordSafe.PasswordSafe;
import com.intellij.openapi.components.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * The Persistent State Component which persists the Salesforce instance details
 *
 * @author Mark Borner (gzhomzb)
 */
@State(
        name = "SalesforceInstances",
        storages = {
                @Storage(file = StoragePathMacros.APP_CONFIG + "/salesforce.xml")
        }
)
public class InstancesPersistentStateComponent implements PersistentStateComponent<InstancesPersistentStateComponent> {

    private static final String SALES_FORCE_INSTANCE = "SALES_FORCE_INSTANCE_";
    private Logger logger = Logger.getInstance(getClass());

    // Only the instance names are stored in clear text
    public Set<String> instanceNames = new HashSet<String>();

    // The actual instance credentials are stored in memory only, and fetched on-demand from the password safe
    private Map<String,InstanceCredentials> instanceMap = new HashMap<String, InstanceCredentials>();

    public static InstancesPersistentStateComponent getInstance() {
        return ServiceManager.getService(InstancesPersistentStateComponent.class);
    }

    public InstancesPersistentStateComponent() {
    }

    @Nullable
    @Override
    public InstancesPersistentStateComponent getState() {
        return this;
    }

    @Override
    public void loadState(InstancesPersistentStateComponent state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    @Nullable
    public InstanceCredentials getInstance(String name) {
        if (!instanceNames.contains(name)) {
            return null;
        }
        if (instanceMap.get(name) != null) {
            return instanceMap.get(name);
        }
        String clearString;
        try {
            clearString = PasswordSafe.getInstance().getPassword(ProjectManager.getInstance().getDefaultProject(), InstancesPersistentStateComponent.class, SALES_FORCE_INSTANCE + name);
        } catch (Exception e) {
            logger.warn("Unable to get credentials from password safe", e);
            return null;
        }
        InstanceCredentials instance = InstanceCredentials.fromString(clearString);
        instanceMap.put(name, instance);
        return instance;
    }

    public boolean addInstance(@NotNull InstanceCredentials instance) {
        try {
            PasswordSafe.getInstance().storePassword(ProjectManager.getInstance().getDefaultProject(), InstancesPersistentStateComponent.class, SALES_FORCE_INSTANCE + instance.getName(), instance.toString());
        } catch (Exception e) {
            logger.error("Unable to save credentials", e);
            Messages.showErrorDialog("Your credentials were unable to be saved.  Please try again.", "Error");
            return false;
        }
        instanceNames.add(instance.getName());
        instanceMap.put(instance.getName(), instance);
        return true;
    }

    public void removeInstance(@NotNull String instanceName) {
        try {
            PasswordSafe.getInstance().removePassword(ProjectManager.getInstance().getDefaultProject(), InstancesPersistentStateComponent.class, SALES_FORCE_INSTANCE + instanceName);
        } catch (Exception e) {
            logger.warn("Unable to delete credentials", e);
            return;
        }
        instanceNames.remove(instanceName);
        instanceMap.remove(instanceName);
    }

}
