package au.com.borner.salesforce.plugin.project;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.*;

/**
 * @author mark
 */
public class SalesForceSynchroniseOptionsStep extends ModuleWizardStep {

    private final SalesForceWizardStateBean stateBean;

    private JCheckBox apexClassesCheckBox;
    private JCheckBox apexTriggersCheckBox;
    private JCheckBox visualforcePagesCheckBox;
    private JCheckBox visualforceComponentsCheckBox;
    private JPanel syncPanel;

    public SalesForceSynchroniseOptionsStep(SalesForceWizardStateBean stateBean) {
        this.stateBean = stateBean;
        apexClassesCheckBox.setSelected(true);
        apexTriggersCheckBox.setSelected(true);
        visualforceComponentsCheckBox.setSelected(true);
        visualforcePagesCheckBox.setSelected(true);
    }

    @Override
    public JComponent getComponent() {
        return syncPanel;
    }

    @Override
    public void updateDataModel() {
        stateBean.setSyncClasses(apexClassesCheckBox.isSelected());
        stateBean.setSyncTriggers(apexTriggersCheckBox.isSelected());
        stateBean.setSyncPages(visualforcePagesCheckBox.isSelected());
        stateBean.setSyncComponents(visualforceComponentsCheckBox.isSelected());

    }


}
