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

package au.com.borner.salesforce.jps;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsElementChildRole;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.ex.JpsElementBase;
import org.jetbrains.jps.model.ex.JpsElementChildRoleBase;

/**
 * @author mark
 */
public class SalesForceProjectSettings extends JpsElementBase<SalesForceProjectSettings> {

    public static final JpsElementChildRole<SalesForceProjectSettings> ROLE = JpsElementChildRoleBase.create("Salesforce Project Settings");

    public String instanceName;

    public SalesForceProjectSettings() {
    }

    public SalesForceProjectSettings(SalesForceProjectSettings other) {
        this.instanceName = other.instanceName;
    }

    @NotNull
    @Override
    public SalesForceProjectSettings createCopy() {
        return new SalesForceProjectSettings(this);
    }

    @Override
    public void applyChanges(@NotNull SalesForceProjectSettings modified) {
        // nada
    }

    @NotNull
    public static SalesForceProjectSettings getSettings(@NotNull JpsProject project) {
        SalesForceProjectSettings settings = project.getContainer().getChild(ROLE);
        return settings == null ? new SalesForceProjectSettings() : settings;
    }

}
