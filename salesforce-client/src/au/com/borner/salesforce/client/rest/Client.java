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

import au.com.borner.salesforce.client.rest.domain.APIVersionResult;
import au.com.borner.salesforce.client.rest.domain.BasicDescribeResult;
import au.com.borner.salesforce.client.rest.domain.DescribeResult;
import au.com.borner.salesforce.client.rest.domain.QueryResult;

import java.util.List;

/**
 * An interface for a generic Salesforce Client
 *
 * Created by gzhomzb
 */
public interface Client {

    public String getDefaultServicesUri();

    public List<BasicDescribeResult> describeAllObjects(String versionUrl);

    public List<BasicDescribeResult> describeAllObjects();

    public DescribeResult describeObject(String versionUrl, String name);

    public DescribeResult describeObject(String name);

    public List<APIVersionResult> getVersions();

    public QueryResult executeQuery(String soql);

    public QueryResult executeQueryLocator(String queryLocator);

}
