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
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An Abstract JSONObject with common utility methods
 *
 * @author mark
 */
public abstract class AbstractJSONObject extends JSONObject{

    protected AbstractJSONObject() {
    }

    public AbstractJSONObject(String string) throws JSONException {
        super(string);
    }

    public List<String> toStringList(JSONArray array)   {
        try {
            List<String> result = new ArrayList<String>(array.length());
            for (int i=0; i<array.length(); i++) {
                result.add(array.getString(i));
            }
            return result;
        } catch (JSONException e) {
            return Collections.emptyList();
        }
    }

    @SuppressWarnings("unchecked")
    protected <T extends AbstractJSONObject> List<T> getChildEntities(String name, Class<T> resultClass) {
        try {
            Constructor<T> constructor = resultClass.getConstructor(String.class);
            JSONArray children = getJSONArray(name);
            List<T> result = new ArrayList<T>(children.length());
            for (int i=0; i<children.length(); i++) {
                JSONObject jsonObject = children.getJSONObject(i);
                T instance = constructor.newInstance(jsonObject.toString());  // is there any way to avoid double serialisation?
                result.add(instance);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error parsing child elements", e);
        }
    }

}
