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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Borner (gzhomzb)
 */
public class ContainerAsyncRequest extends AbstractIdentifiableJSONObject {

    public enum State {Queued, Invalidated, Completed, Failed, Error, Aborted}

    public ContainerAsyncRequest(String string) throws JSONException {
        super(string);
    }

    public ContainerAsyncRequest(MetadataContainer metadataContainer) {
        super();
        put("MetadataContainerId", metadataContainer.getId());
        setCheckOnly(false);
        setRunTests(true);
    }

    public void setCheckOnly(boolean checkOnly) {
        put("IsCheckOnly", checkOnly);
    }

    public void setRunTests(boolean runTests) {
        put("IsRunTests", runTests);
    }

    public State getState() {
        String state;
        try {
            state = getString("State");
        } catch (Exception e) {
            return null;
        }
        return State.valueOf(state);
    }

    public String getErrorMsg() {
        return getString("ErrorMsg");
    }

    public List<CompilerError> getCompilerErrors() {
        // CompilerErrors is a JSON Array wrapped in a String ..... :-(
        String compilerErrors = getString("CompilerErrors");
        JSONArray jsonArray = new JSONArray(compilerErrors);
        List<CompilerError> result = new ArrayList<CompilerError>(jsonArray.length());
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            result.add(new CompilerError(jsonObject.toString()));
        }
        return result;
    }

    @Override
    public String getSObjectName() {
        return "ContainerAsyncRequest";
    }
}
