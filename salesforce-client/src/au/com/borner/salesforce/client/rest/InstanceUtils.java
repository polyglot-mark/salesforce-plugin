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

package au.com.borner.salesforce.client.rest;

/**
 * @author mark
 */
public class InstanceUtils {

    public static final String PRODUCTION_DE = "Production / Developer Edition";
    public static final String SANDBOX = "Sandbox";
    public static final String PRE_RELEASE = "Pre-Release";
    public static final String OTHER = "Other";

    public static String getOAuthHostForEnvironment(String environment) {
        if (environment.equals(PRODUCTION_DE)) {
            return "login.salesforce.com";
        } else if (environment.equals(SANDBOX)) {
            return "test.salesforce.com";
        } else if (environment.equals(PRE_RELEASE)) {
            return "prerellogin.pre.salesforce.com";
        } else {
            return null;
        }
    }
}
