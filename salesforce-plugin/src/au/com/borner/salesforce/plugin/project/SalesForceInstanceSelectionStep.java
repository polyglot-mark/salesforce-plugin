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

package au.com.borner.salesforce.plugin.project;

import au.com.borner.salesforce.client.InstanceCredentials;
import au.com.borner.salesforce.plugin.panels.InstanceSelectionPanel;
import au.com.borner.salesforce.plugin.settings.instances.InstancesPersistentStateComponent;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;

import javax.swing.*;

/**
 * A Project Wizard Step for selecting the Salesforce instance to use for the new Project/Module
 *
 * Created by mark
 */
public class SalesForceInstanceSelectionStep extends ModuleWizardStep {

    private JPanel instanceSelectionWrapperPanel;
    private JPanel subPanel;

    private final InstanceSelectionPanel instanceSelectionPanel;
    private final SalesForceWizardStateBean stateBean;
    private final InstancesPersistentStateComponent instancesPersistentStateComponent;

    public SalesForceInstanceSelectionStep(Project project, SalesForceWizardStateBean stateBean) {
        this.stateBean = stateBean;

        instanceSelectionPanel = new InstanceSelectionPanel(project);
        subPanel.add(instanceSelectionPanel.getPanel());

        instancesPersistentStateComponent = InstancesPersistentStateComponent.getInstance();
    }

    @Override
    public JComponent getComponent() {
        return instanceSelectionWrapperPanel;
    }

    @Override
    public boolean validate() throws ConfigurationException {
        if (instanceSelectionPanel.getSelectedInstance() == null) {
            throw new ConfigurationException("Please select an instance.");
        }
        return true;
    }

    @Override
    public void updateDataModel() {
        stateBean.setSelectedInstance(instanceSelectionPanel.getSelectedInstance());
        InstanceCredentials instanceCredentials = instancesPersistentStateComponent.getInstance(stateBean.getSelectedInstance());
        stateBean.setInstanceCredentials(instanceCredentials);
    }

}
