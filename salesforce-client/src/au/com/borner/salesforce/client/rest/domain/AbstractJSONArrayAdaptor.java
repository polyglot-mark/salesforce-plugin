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

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Unfortunately, JSONObject and JSONArray do not share a super type.
 * So instead of polluting the ConnectionManager with duplicate
 * methods (one taking a JSONObject and one taking a JSONArray),
 * I've created this Adaptor so I can pass in an AbstractJSONObject
 * sub-class, and it just holds the JSONArray (and doesn't pass it
 * to the super class).
 *
 * Subclasses should not use the standard get() and getString() etc
 * methods of JSONObject - they will return nil because we are
 * passing an empty JSON response to the super class.  Instead,
 * subclasses should invoke getString() on the jsonArray member
 * (ie. jsonArray.getString()).
 *
 * @author Mark Borner (gzhomzb)
 */
public class AbstractJSONArrayAdaptor extends AbstractJSONObject {

    protected final JSONArray jsonArray;

    public AbstractJSONArrayAdaptor(String string) throws JSONException {
        super("{}");
        this.jsonArray = new JSONArray(string);
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }
}
