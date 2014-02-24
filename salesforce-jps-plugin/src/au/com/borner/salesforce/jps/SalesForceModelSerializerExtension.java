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

import com.intellij.util.xmlb.XmlSerializer;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.serialization.JpsModelSerializerExtension;
import org.jetbrains.jps.model.serialization.JpsProjectExtensionSerializer;

import java.util.Arrays;
import java.util.List;

/**
 * The compiler doesn't have access to the Project instance like the plugin.  However, it can read the
 * project settings XML files from disk.  This class is a helper class which will serialize the SalesForce
 * settings from the XML files into the JpsProject object.
 *
 * @author mark
 */
public class SalesForceModelSerializerExtension extends JpsModelSerializerExtension {

    @NotNull
    @Override
    public List<? extends JpsProjectExtensionSerializer> getProjectExtensionSerializers() {
        return Arrays.asList(new JpsProjectExtensionSerializer("saleforce.xml", "SalesforceProjectSettings") {
            @Override
            public void loadExtension(@NotNull JpsProject jpsProject, @NotNull Element componentTag) {
                SalesForceProjectSettings settings = XmlSerializer.deserialize(componentTag, SalesForceProjectSettings.class);
                if (settings == null) {
                    settings = new SalesForceProjectSettings();
                }
                jpsProject.getContainer().setChild(SalesForceProjectSettings.ROLE, settings);
            }

            @Override
            public void saveExtension(@NotNull JpsProject jpsProject, @NotNull Element componentTag) {
                // nope
            }
        });
    }
}
