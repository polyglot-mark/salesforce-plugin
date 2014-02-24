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
 * @author Mark Borner (gzhomzb)
 */
public class ExecuteAnonymousResult extends AbstractJSONObject {

    public ExecuteAnonymousResult(String string) throws JSONException {
        super(string);
    }

    // TODO:  how to get the execution results??!!??!!

    public boolean isSuccessful() {
        return getBoolean("success");
    }

    public boolean isCompiled() {
        return getBoolean("compiled");
    }

    public String getCompileProblem() {
        return getString("compileProblem");
    }

    public String getExceptionStackTrace() {
        try {
            return getString("exceptionStackTrace");
        } catch (Exception e) {
            return "";
        }
    }

    public int getColumn() {
        return getInt("column");
    }

    public int getLine() {
        return getInt("line");
    }

    public String getExceptionMessage() {
        try {
            return getString("exceptionMessage");
        } catch (Exception e) {
            return "";
        }
    }
}

/*
{
   "success": false,
   "compiled": false,
   "compileProblem": "Expression cannot be a statement",
   "exceptionStackTrace": null,
   "column": 1,
   "line": 1,
   "exceptionMessage": null
}

{
   "success": true,
   "exceptionMessage": null,
   "exceptionStackTrace": null,
   "line": -1,
   "column": -1,
   "compiled": true,
   "compileProblem": null
}

 */
