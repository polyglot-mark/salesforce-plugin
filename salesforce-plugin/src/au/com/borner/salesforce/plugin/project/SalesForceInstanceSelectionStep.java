package au.com.borner.salesforce.plugin.project;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import au.com.borner.salesforce.plugin.settings.instances.InstancesPersistentStateComponent;
import au.com.borner.salesforce.plugin.settings.project.InstanceSelectionPanel;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.options.ConfigurationException;

import javax.swing.*;

/**
 * @author mark
 */
public class SalesForceInstanceSelectionStep extends ModuleWizardStep {

    private final InstanceSelectionPanel instanceSelectionPanel;
    private final SalesForceWizardStateBean stateBean;
    private final InstancesPersistentStateComponent instancesPersistentStateComponent;

    public SalesForceInstanceSelectionStep(SalesForceWizardStateBean stateBean) {
        this.instanceSelectionPanel = new InstanceSelectionPanel();
        this.stateBean = stateBean;
        this.instancesPersistentStateComponent = InstancesPersistentStateComponent.getInstance();
    }

    @Override
    public JComponent getComponent() {
        return instanceSelectionPanel.getPanel();
    }

    @Override
    public boolean validate() throws ConfigurationException {
        if (instanceSelectionPanel.getSelectedInstance() == null) {
            throw new ConfigurationException("Please select a Salesforce instance");
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
