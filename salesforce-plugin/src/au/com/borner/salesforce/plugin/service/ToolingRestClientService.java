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

import au.com.borner.salesforce.client.rest.ToolingRestClient;

/**
 * A Project service which wraps the Tooling Rest Client and instantiates it from a Connection Manager Service
 *
 * Created by mark
 */
public class ToolingRestClientService extends ToolingRestClient {

    public ToolingRestClientService(ConnectionManagerService connectionManagerService) {
        super(connectionManagerService);
    }

}
