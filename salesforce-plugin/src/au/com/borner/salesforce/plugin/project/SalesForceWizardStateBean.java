package au.com.borner.salesforce.plugin.project;

import au.com.borner.salesforce.client.rest.ConnectionManager;
import au.com.borner.salesforce.client.rest.InstanceCredentials;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple bean to carry state between the Wizard steps and the Module Builder
 *
 * @author mark
 */
public class SalesForceWizardStateBean {

    public enum FOLDER_NAMES {CLASSES, TRIGGERS, PAGES, COMPONENTS
    }
    private String selectedInstance;
    private boolean syncClasses;
    private boolean syncTriggers;
    private boolean syncPages;
    private boolean syncComponents;
    private InstanceCredentials instanceCredentials;
    private Map<FOLDER_NAMES, String> createdFolders = new HashMap<FOLDER_NAMES, String>();

    public String getSelectedInstance() {
        return selectedInstance;
    }

    public void setSelectedInstance(String selectedInstance) {
        this.selectedInstance = selectedInstance;
    }

    public boolean isSyncClasses() {
        return syncClasses;
    }

    public void setSyncClasses(boolean syncClasses) {
        this.syncClasses = syncClasses;
    }

    public boolean isSyncTriggers() {
        return syncTriggers;
    }

    public void setSyncTriggers(boolean syncTriggers) {
        this.syncTriggers = syncTriggers;
    }

    public boolean isSyncPages() {
        return syncPages;
    }

    public void setSyncPages(boolean syncPages) {
        this.syncPages = syncPages;
    }

    public boolean isSyncComponents() {
        return syncComponents;
    }

    public void setSyncComponents(boolean syncComponents) {
        this.syncComponents = syncComponents;
    }

    public void addCreatedFolder(FOLDER_NAMES name, String path) {
        createdFolders.put(name, path);
    }

    public String getFolderPath(FOLDER_NAMES name) {
        return createdFolders.get(name);
    }

    public InstanceCredentials getInstanceCredentials() {
        return instanceCredentials;
    }

    public void setInstanceCredentials(InstanceCredentials instanceCredentials) {
        this.instanceCredentials = instanceCredentials;
    }
}
