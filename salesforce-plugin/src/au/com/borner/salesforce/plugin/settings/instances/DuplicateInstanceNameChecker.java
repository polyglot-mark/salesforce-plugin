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

package au.com.borner.salesforce.plugin.settings.instances;

/**
 * A utility class to check for duplicate instance names
 *
 * Created by mark
 */
public abstract class DuplicateInstanceNameChecker {

    public static boolean isDuplicate(String instanceName) {
        InstancesPersistentStateComponent instancesPersistentStateComponent = InstancesPersistentStateComponent.getInstance();
        return instancesPersistentStateComponent.instanceNames.contains(instanceName);
    }

}
