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

package au.com.borner.salesforce.client.wsc;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.client.rest.InstanceUtils;
import com.intellij.openapi.diagnostic.Logger;
import com.sforce.soap.apex.SoapConnection;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The client for the Salesforce Soap API
 *
 * Created by gzhomzb
 */
public class SoapClient {

    private Logger logger = Logger.getInstance(getClass());
    private EnterpriseConnection enterpriseConnection;
    private MetadataConnection metadataConnection;
    private SoapConnection apexConnection;

    public void login(@NotNull InstanceCredentials instanceCredentials, boolean traceMessages) {
        clearAllConnections();
        ConnectorConfig loginConfig = createConnectorConfig(instanceCredentials, traceMessages);
        try {
            // Create the Enterprise Connection which will log into Salesforce
            enterpriseConnection = Connector.newConnection(loginConfig);

            // Setup the Metadata Connection which will use the session Id from the Enterprise Connection
            ConnectorConfig metadataConfig = createConnectorConfig(instanceCredentials, traceMessages);
            metadataConfig.setSessionId(enterpriseConnection.getConfig().getSessionId());
            metadataConfig.setServiceEndpoint(enterpriseConnection.getConfig().getServiceEndpoint().replace("services/Soap/c", "services/Soap/m"));
            metadataConnection = com.sforce.soap.metadata.Connector.newConnection(metadataConfig);

            // Setup the Apex Connection which will use the session Id from the Enterprise Connection
            ConnectorConfig apexConfig = createConnectorConfig(instanceCredentials, traceMessages);
            apexConfig.setSessionId(enterpriseConnection.getConfig().getSessionId());
            apexConfig.setServiceEndpoint(enterpriseConnection.getConfig().getServiceEndpoint().replace("services/Soap/c", "services/Soap/s"));
            apexConnection = com.sforce.soap.apex.Connector.newConnection(apexConfig);
        } catch (ConnectionException e) {
            logger.error("Unable to login to Salesforce", e);
        }
    }

    public void logoff() {
        try {
            enterpriseConnection.logout();
            clearAllConnections();
        } catch (ConnectionException e) {
            // ignore
        }
    }

    private void clearAllConnections() {
        enterpriseConnection = null;
        metadataConnection = null;
        apexConnection = null;
    }

    private ConnectorConfig createConnectorConfig(@NotNull InstanceCredentials instanceCredentials, boolean traceMessages) {
        ConnectorConfig config = new ConnectorConfig();
        // TODO: set proxy!
        config.setTraceMessage(traceMessages);
        config.setUsername(instanceCredentials.getUsername());
        config.setPassword(instanceCredentials.getPassword() + instanceCredentials.getSecurityToken());
        config.setAuthEndpoint(InstanceUtils.getSoapLoginUrlForEnvironment(instanceCredentials.getEnvironment()));
        return config;
    }

    @Nullable
    public String getSessionId() {
        return enterpriseConnection == null ? null : enterpriseConnection.getSessionHeader().getSessionId();
    }

    @Nullable
    public String getServiceHost() {
        if (enterpriseConnection == null) {
            return null;
        }
        try {
            URL url = new URL(enterpriseConnection.getConfig().getServiceEndpoint());
            return url.getHost();
        } catch (MalformedURLException e) {
            logger.error("Bad service URL returned from Salesforce", e);
            return null;
        }
    }

}
