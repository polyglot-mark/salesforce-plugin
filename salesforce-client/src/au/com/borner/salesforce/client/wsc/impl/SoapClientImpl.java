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

package au.com.borner.salesforce.client.wsc.impl;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.client.rest.InstanceUtils;
import au.com.borner.salesforce.client.wsc.SoapClient;
import com.intellij.openapi.diagnostic.Logger;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import org.jetbrains.annotations.NotNull;

/**
 * Created by gzhomzb
 */
public class SoapClientImpl implements SoapClient {

    private Logger logger = Logger.getInstance(getClass());

    @Override
    public String login(@NotNull InstanceCredentials instanceCredentials) {
        String sessionId = null;
        ConnectorConfig loginConfig = new ConnectorConfig();
        loginConfig.setUsername(instanceCredentials.getUsername());
        loginConfig.setPassword(instanceCredentials.getPassword() + instanceCredentials.getSecurityToken());
        loginConfig.setAuthEndpoint(InstanceUtils.getOAuthHostForEnvironment(instanceCredentials.getEnvironment()));
        try {
            EnterpriseConnection enterpriseConnection = Connector.newConnection(loginConfig);
            sessionId = enterpriseConnection.getConfig().getSessionId();
        } catch (ConnectionException e) {
            logger.error("Unable to login to Salesforce", e);
        }
        return sessionId;
    }

}
