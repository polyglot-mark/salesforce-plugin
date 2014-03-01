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

package au.com.borner.salesforce.plugin.panels;

import au.com.borner.salesforce.plugin.settings.instances.InstancesPersistentStateComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * A JPanel for selecting a Salesforce instance
 *
 * Created by mark
 */
public class InstanceSelectionPanel {

    private JComboBox instancesComboBox;
    private JPanel instanceSelectionPanel;
    private JButton newInstanceButton;

    private final InstancesPersistentStateComponent instancesPersistentStateComponent;

    public InstanceSelectionPanel(final Project project) {
        instancesPersistentStateComponent = InstancesPersistentStateComponent.getInstance();
        refreshInstances();
        newInstanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = new NewInstanceDialog(project).showAndGet();
                if (result) refreshInstances();
            }
        });
    }

    public JPanel getPanel() {
        return instanceSelectionPanel;
    }

    @Nullable
    public String getSelectedInstance() {
        if (instancesComboBox.getSelectedIndex() < 0) {
            return null;
        }
        return (String)instancesComboBox.getSelectedItem();
    }

    public void setSelectedInstance(String selectedInstance) {
        instancesComboBox.setSelectedItem(selectedInstance);
    }

    public void refreshInstances() {
        Object[] names = instancesPersistentStateComponent.instanceNames.toArray();
        Arrays.sort(names);
        ComboBoxModel model = new DefaultComboBoxModel(names);
        instancesComboBox.setModel(model);

    }

}
