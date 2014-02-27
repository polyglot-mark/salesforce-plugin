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

package au.com.borner.salesforce.client.rest.impl;

import au.com.borner.salesforce.client.rest.Client;
import au.com.borner.salesforce.client.rest.ConnectionManager;
import au.com.borner.salesforce.client.rest.domain.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract Rest Client with common stuffs
 *
 * Created by gzhomzb
 */
public abstract class AbstractRestClient implements Client {

    protected static final String DEFAULT_API_VERSION = "v29.0";

    protected static final String SERVICES_URI = "/services/data/";
    protected static final String SOBJECTS_PATH = "/sobjects/";
    protected static final String DESCRIBE_PATH = "/describe/";
    protected static final String SOBJECTS = "sobjects";
    protected static final String QUERY_PATH = "/query/";

    protected final ConnectionManager connectionManager;

    public AbstractRestClient(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public String getDefaultServicesUri() {
        return SERVICES_URI + DEFAULT_API_VERSION;
    }

    // Describe methods

    @Override
    @NotNull
    public List<BasicDescribeResult> describeAllObjects(@NotNull String versionUrl) {
        QueryResult queryResult = connectionManager.executeGet(versionUrl + SOBJECTS_PATH, QueryResult.class);
        return queryResult.getEntities(SOBJECTS, BasicDescribeResult.class);
    }

    @Override
    @NotNull
    public List<BasicDescribeResult> describeAllObjects() {
        return describeAllObjects(getDefaultServicesUri() + SOBJECTS_PATH);
    }

    @Override
    @NotNull
    public DescribeResult describeObject(@NotNull String versionUrl, @NotNull String name) {
        String uri = versionUrl + SOBJECTS_PATH + name + DESCRIBE_PATH;
        return connectionManager.executeGet(uri, DescribeResult.class);
    }

    @Override
    @NotNull
    public DescribeResult describeObject(@NotNull String name) {
        return describeObject(getDefaultServicesUri() + DESCRIBE_PATH, name);
    }

    // --------------------

    // Version methods

    @Override
    @NotNull
    public List<APIVersionResult> getVersions() {
        APIVersionsResult apiVersionsResult = connectionManager.executeGet(SERVICES_URI, APIVersionsResult.class);
        return apiVersionsResult.getVersions();
    }

    // --------------------

    // Query methods

    @Override
    @NotNull
    public QueryResult executeQuery(@NotNull String soql) {
        return connectionManager.executeGet(getDefaultServicesUri() + QUERY_PATH, singletonList("q", soql), QueryResult.class);
    }

    @Override
    @NotNull
    public QueryResult executeQueryLocator(@NotNull String queryLocator) {
        return connectionManager.executeGet(getDefaultServicesUri() + QUERY_PATH + queryLocator, QueryResult.class);
    }

    // --------------------

    @NotNull
    protected List<NameValuePair> singletonList(@NotNull String name, @NotNull String value) {
        List<NameValuePair> list = new ArrayList<NameValuePair>(1);
        list.add(new BasicNameValuePair(name, value));
        return list;
    }


}
