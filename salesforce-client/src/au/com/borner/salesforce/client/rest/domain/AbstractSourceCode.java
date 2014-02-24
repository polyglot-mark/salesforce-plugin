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

package au.com.borner.salesforce.client.rest.domain;

import org.json.JSONException;

/**
 * An abstract Source Code object which is the super class of all
 * domain objects that have source code: ApexClass, ApexTrigger,
 * VisualForceComponent, & VisualForcePage
 *
 * @author mark
 */
public abstract class AbstractSourceCode extends AbstractIdentifiableJSONObject {

    protected AbstractSourceCode() {
    }

    protected AbstractSourceCode(String string) throws JSONException {
        super(string);
    }

    public String getName() {
        return getString("Name");
    }

    public void setName(String name) {
        put("Name", name);
    }

    public String getNamespacePrefix() {
        return getString("NamespacePrefix");
    }

    public void setApiVersion(double apiVersion) {
        put("ApiVersion", apiVersion);
    }
    public double getApiVersion() {
        return getDouble("ApiVersion");
    }

    public void setBody(String body) {
        put("Body", body);
    }

    public String getBody() {
        return getString("Body");
    }

    public Double getBodyCRC() {
        return getDouble("BodyCrc");
    }

    public abstract String getFullyQualifiedFileName(String name);

}
