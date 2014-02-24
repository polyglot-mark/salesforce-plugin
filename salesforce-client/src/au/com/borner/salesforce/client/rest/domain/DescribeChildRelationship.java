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
 * @author mark
 */
public class DescribeChildRelationship extends AbstractJSONObject {

    public DescribeChildRelationship(String string) throws JSONException {
        super(string);
    }

    public String getField() {
        return getString("field");
    }

    public boolean isRestrictedDelete() {
        return getBoolean("restrictedDelete");
    }

    public boolean isCascadeDelete() {
        return getBoolean("cascadeDelete");
    }

    public String getChildObject() {
        return getString("childSObject");
    }

    public String getRelationshipName() {
        return getString("relationshipName");
    }

    public boolean isDeprecatedAndHidden() {
        return getBoolean("deprecatedAndHidden");
    }


}
