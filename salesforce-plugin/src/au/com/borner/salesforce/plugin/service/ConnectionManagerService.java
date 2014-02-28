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

package au.com.borner.salesforce.plugin.service;

import au.com.borner.salesforce.client.rest.ConnectionManager;
import au.com.borner.salesforce.client.rest.ConnectionSessionException;
import au.com.borner.salesforce.client.rest.domain.AbstractJSONObject;
import org.apache.http.client.methods.HttpRequestBase;
import org.jetbrains.annotations.NotNull;

/**
 * A Project Service which wraps the Connection Manager and sets the session details from the Soap Client Server.
 * This service also catches any session exceptions and logs the user back in using the Soap Client Server.
 *
 * Created by mark
 */
public class ConnectionManagerService extends ConnectionManager {

    private final SoapClientService soapClientService;

    public ConnectionManagerService(@NotNull SoapClientService soapClientService) {
        this.soapClientService = soapClientService;
        setSessionDetails(soapClientService.getSessionId(), soapClientService.getServiceHost());
    }

    @Override
    protected <Response extends AbstractJSONObject> Response execute(HttpRequestBase request, Class<Response> responseClass) {
        try {
            return super.execute(request, responseClass);
        } catch (ConnectionSessionException e) {
            soapClientService.login();
            setSessionDetails(soapClientService.getSessionId(), soapClientService.getServiceHost());
            return super.execute(request, responseClass);
        }
    }

}
