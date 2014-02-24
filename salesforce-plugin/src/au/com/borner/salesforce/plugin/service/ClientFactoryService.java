package au.com.borner.salesforce.plugin.service;

import au.com.borner.salesforce.client.rest.ConnectionManager;
import au.com.borner.salesforce.client.rest.DataClient;
import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.client.rest.ToolingClient;
import au.com.borner.salesforce.plugin.settings.instances.InstancesPersistentStateComponent;
import au.com.borner.salesforce.plugin.settings.project.ProjectSettingsPersistentStateComponent;
import com.intellij.openapi.project.Project;

/**
 * @author mark
 */
public class ClientFactoryService {

    private final Project project;

    private ConnectionManager connectionManager;
    private DataClient dataClient;
    private ToolingClient toolingClient;

    public ClientFactoryService(Project project) {
        this.project = project;
    }

    public DataClient getDataClient() {
        if (dataClient == null) {
            dataClient = new DataClient(getConnectionManager());
        }
        return dataClient;
    }

    public ToolingClient getToolingClient() {
        if (toolingClient == null) {
            toolingClient = new ToolingClient(getConnectionManager());
        }
        return toolingClient;
    }

    private ConnectionManager getConnectionManager() {
        if (connectionManager == null) {
            ProjectSettingsPersistentStateComponent projectSettings = ProjectSettingsPersistentStateComponent.getInstance(project);
            InstancesPersistentStateComponent instanceSettings = InstancesPersistentStateComponent.getInstance();
            InstanceCredentials instanceCredentials = instanceSettings.getInstance(projectSettings.instanceName);
            connectionManager = new ConnectionManager(instanceCredentials);
        }
        return connectionManager;
    }
}
