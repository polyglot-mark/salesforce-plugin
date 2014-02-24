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

import java.util.List;

/**
 * The Salesforce Tooling API client
 *
 * @author mark
 */
public class ToolingClient extends AbstractRestClient {

    private static final String TOOLING_PATH = "/tooling";
    private static final String TOOLING_BASE_URI = SERVICES_URI + DEFAULT_API_VERSION + TOOLING_PATH;
    private static final String EXECUTE_ANONYMOUS_PATH = TOOLING_BASE_URI + "/executeAnonymous/";

    private static final String SOBJECTS_BASE_PATH = TOOLING_BASE_URI + SOBJECTS_PATH;
    private static final String CODE_COVERAGE_PATH = SOBJECTS_BASE_PATH + "ApexCodeCoverage/";
    private static final String CODE_COVERAGE_AGGREGATE_PATH = SOBJECTS_BASE_PATH + "ApexCodeCoverageAggregate/";

    public ToolingClient(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    // Describe methods

    public List<BasicDescribeResult> describeAllObjects(String versionUrl) {
        return super.describeAllObjects(versionUrl + TOOLING_PATH);
    }

    public DescribeResult describeObject(String versionUrl, String name) {
        return super.describeObject(versionUrl + TOOLING_PATH, name);
    }

    protected String getDefaultServicesUri() {
        return TOOLING_BASE_URI;
    }

    // --------------------

    // Execute Anonymous method

    public ExecuteAnonymousResult executeAnonymous(String statement) {
        return connectionManager.executeGet(EXECUTE_ANONYMOUS_PATH, singletonList("anonymousBody", statement), ExecuteAnonymousResult.class );
    }

    // --------------------

    // sObject methods

    public <T extends AbstractIdentifiableJSONObject> T createSObject(T sObject) {
        CreationResponse response = connectionManager.executePost(SOBJECTS_BASE_PATH + sObject.getSObjectName(), sObject, CreationResponse.class);
        if (response.isSuccessful()) {
            sObject.setId(response.getId());
            return sObject;
        } else {
            throw new ClientException(String.format("Unable to create sObject %s: %s ", sObject.getSObjectName(), response.getErrors()));
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractIdentifiableJSONObject> T getSObject(T sObject, Class<T> sObjectClass) {
        return connectionManager.executeGet(SOBJECTS_BASE_PATH + sObject.getSObjectName() + "/" + sObject.getId(), sObjectClass);
    }

    public QueryResult getApexClasses() {
        return executeQuery("select Id, Name, Body, BodyCrc, ApiVersion, SymbolTable from ApexClass");
    }


    public QueryResult getApexTriggers() {
        return executeQuery("select Id, Name, Body, BodyCrc, ApiVersion from ApexTrigger");
    }

    public QueryResult getVisualForcePages() {
        return executeQuery("select Id, Name, Markup, ApiVersion from ApexPage");
    }

    public QueryResult getVisualForceComponent() {
        return executeQuery("select Id, Name, Markup, ApiVersion from ApexComponent");
    }

    public void deleteSObject(AbstractIdentifiableJSONObject sObject) {
        connectionManager.executeDelete(SOBJECTS_BASE_PATH + sObject.getSObjectName() + "/" + sObject.getId());
    }

    // --------------------

    // Code Coverage

    public CodeCoverageResult getCodeCoverageResult(String id) {
        return connectionManager.executeGet(CODE_COVERAGE_PATH + id, CodeCoverageResult.class);
    }

    // --------------------

}
