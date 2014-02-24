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

import java.util.ArrayList;
import java.util.List;

/**
 * An error response that is returned when the request generated an error
 *
 * @author mark
 */
public class ErrorsResponse extends AbstractJSONArrayAdaptor {

    public ErrorsResponse(String json) throws JSONException {
        super(json);
    }

    public List<ErrorResponse> getErrors() {
        List<ErrorResponse> result = new ArrayList<ErrorResponse>(jsonArray.length());
        for (int i=0; i<jsonArray.length(); i++) {
            result.add(new ErrorResponse(jsonArray.get(i).toString()));
        }
        return result;
    }

    @Override
    public String toString() {
        return jsonArray.toString();
    }
}
