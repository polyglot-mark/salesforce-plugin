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

package au.com.borner.salesforce.client.rest;

import au.com.borner.salesforce.client.rest.domain.LimitResult;
import au.com.borner.salesforce.client.rest.domain.LimitsResult;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * The client for the Salesforce Rest API
 *
 * @author mark
 */
public class RestClient extends AbstractRestClient {

    private static final String LIMITS = "/limits/";

    public RestClient(@NotNull ConnectionManager connectionManager) {
        super(connectionManager);
    }

    @NotNull
    public Map<LimitsResult.LimitType, LimitResult> getLimits() {
        LimitsResult result = connectionManager.executeGet(getDefaultServicesUri() + LIMITS, LimitsResult.class);
        return result.getLimits();
    }

}
