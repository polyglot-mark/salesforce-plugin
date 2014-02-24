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

import java.util.List;

/**
 * A response that is returned to a Http Post
 *
 * @author Mark Borner (gzhomzb)
 */
public class CreationResponse extends AbstractJSONObject {

    public CreationResponse(String string) throws JSONException {
        super(string);
    }

    public String getId() {
        return getString("id");
    }

    public boolean isSuccessful() {
        return getBoolean("success");
    }

    public List<String> getErrors() {
        return toStringList(getJSONArray("errors"));
    }

}
