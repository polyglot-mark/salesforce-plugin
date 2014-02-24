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
 * This class represents the model for the metadata that is stored with each
 * source file.  For example: the MyClass.class file will also have a
 * MyClass.class.sfmd file.  The "sfmd" file will contain the JSON metadata
 * that corresponds to this class.
 *
 * This class doesn't really belong in the client package, but since it's a
 * JSONObject, I've put it here for right now.
 *
 * @author mark
 */
public class SourceFileMetaData extends AbstractJSONObject {

    public SourceFileMetaData(String name, String id, double apiVersion) {
        setName(name);
        setId(id);
        setApiVersion(apiVersion);
    }

    public SourceFileMetaData(String string) throws JSONException {
        super(string);
    }

    public void setId(String id) {
        put("Id", id);
    }

    public String getId() {
        return getString("Id");
    }

    public void setName(String name) {
        put("Name", name);
    }

    public String getName() {
        return getString("Name");
    }

    public void setApiVersion(Double apiVersion) {
        put("ApiVersion", apiVersion);
    }

    public Double getApiVersion() {
        return getDouble("ApiVersion");
    }

}
