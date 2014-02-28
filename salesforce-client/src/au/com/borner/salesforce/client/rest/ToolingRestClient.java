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

import au.com.borner.salesforce.client.rest.domain.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The client for the Salesforce Tooling Rest API
 *
 * @author mark
 */
public class ToolingRestClient extends AbstractRestClient {

    private static final String TOOLING_PATH = "/tooling";
    private static final String TOOLING_BASE_URI = SERVICES_URI + DEFAULT_API_VERSION + TOOLING_PATH;
    private static final String EXECUTE_ANONYMOUS_PATH = TOOLING_BASE_URI + "/executeAnonymous/";

    private static final String SOBJECTS_BASE_PATH = TOOLING_BASE_URI + SOBJECTS_PATH;
    private static final String CODE_COVERAGE_PATH = SOBJECTS_BASE_PATH + "ApexCodeCoverage/";
    private static final String CODE_COVERAGE_AGGREGATE_PATH = SOBJECTS_BASE_PATH + "ApexCodeCoverageAggregate/";

    public ToolingRestClient(@NotNull ConnectionManager connectionManager) {
        super(connectionManager);
    }

    // Describe methods

    @NotNull
    public List<BasicDescribeResult> describeAllObjects(@NotNull String versionUrl) {
        return super.describeAllObjects(versionUrl + TOOLING_PATH);
    }

    @NotNull
    public DescribeResult describeObject(@NotNull String versionUrl, @NotNull String name) {
        return super.describeObject(versionUrl + TOOLING_PATH, name);
    }

    @NotNull
    protected String getDefaultServicesUri() {
        return TOOLING_BASE_URI;
    }

    // --------------------

    // Execute Anonymous method

    @NotNull
    public ExecuteAnonymousResult executeAnonymous(@NotNull String statement) {
        return connectionManager.executeGet(EXECUTE_ANONYMOUS_PATH, singletonList("anonymousBody", statement), ExecuteAnonymousResult.class );
    }

    // --------------------

    // sObject methods

    @NotNull
    public <T extends AbstractIdentifiableJSONObject> T createSObject(@NotNull T sObject) {
        CreationResponse response = connectionManager.executePost(SOBJECTS_BASE_PATH + sObject.getSObjectName(), sObject, CreationResponse.class);
        if (response.isSuccessful()) {
            sObject.setId(response.getId());
            return sObject;
        } else {
            throw new ClientException(String.format("Unable to create sObject %s: %s ", sObject.getSObjectName(), response.getErrors()));
        }
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public <T extends AbstractIdentifiableJSONObject> T getSObject(@NotNull T sObject, @NotNull Class<T> sObjectClass) {
        return connectionManager.executeGet(SOBJECTS_BASE_PATH + sObject.getSObjectName() + "/" + sObject.getId(), sObjectClass);
    }

    @NotNull
    public QueryResult getApexClasses() {
        return executeQuery("select Id, Name, Body, BodyCrc, ApiVersion, SymbolTable from ApexClass");
    }


    @NotNull
    public QueryResult getApexTriggers() {
        return executeQuery("select Id, Name, Body, BodyCrc, ApiVersion from ApexTrigger");
    }

    @NotNull
    public QueryResult getVisualForcePages() {
        return executeQuery("select Id, Name, Markup, ApiVersion from ApexPage");
    }

    @NotNull
    public QueryResult getVisualForceComponent() {
        return executeQuery("select Id, Name, Markup, ApiVersion from ApexComponent");
    }

    public void deleteSObject(@NotNull AbstractIdentifiableJSONObject sObject) {
        connectionManager.executeDelete(SOBJECTS_BASE_PATH + sObject.getSObjectName() + "/" + sObject.getId());
    }

    // --------------------

    // Code Coverage

    @NotNull
    public CodeCoverageResult getCodeCoverageResult(@NotNull String id) {
        return connectionManager.executeGet(CODE_COVERAGE_PATH + id, CodeCoverageResult.class);
    }

    // --------------------

}
