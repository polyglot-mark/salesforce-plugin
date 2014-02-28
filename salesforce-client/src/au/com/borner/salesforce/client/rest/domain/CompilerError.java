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

import com.intellij.openapi.util.Pair;
import org.json.JSONException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mark Borner (gzhomzb)
 */
public class CompilerError extends AbstractJSONObject {

    private Pattern pattern = Pattern.compile("line (\\d)\\:(\\d+).*");
    private String adjustedProblem;

    public CompilerError(String string) throws JSONException {
        super(string);
    }

    public String extent() {
        return getString("extent");
    }

    public String getId() {
        return getString("id");
    }

    public String getName() {
        return getString("name");
    }

    public int getLine() {
        return getInt("line");
    }

    public String getProblem() {
        if (adjustedProblem == null) {
            return getString("problem");
        } else {
            return adjustedProblem;
        }
    }

    public Pair<Integer,Integer> getLocation() {
        String problem = getProblem();
        Matcher matcher = pattern.matcher(problem);
        if (matcher.matches()) {
            int start = matcher.start(1);
            int end = matcher.end(1);
            Integer row = Integer.parseInt(problem.substring(start, end));
            start = matcher.start(2);
            end = matcher.end(2);
            Integer column = Integer.parseInt(problem.substring(start, end));
            adjustedProblem = problem.substring(end);
            return new Pair<Integer, Integer>(row, ++column);
        } else {
            return null;
        }
    }

}
