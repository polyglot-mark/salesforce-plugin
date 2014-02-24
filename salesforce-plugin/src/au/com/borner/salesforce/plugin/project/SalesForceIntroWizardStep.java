package au.com.borner.salesforce.plugin.project;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.*;

/**
 * @author mark
 */
public class SalesForceIntroWizardStep extends ModuleWizardStep {

    private JPanel introPanel;

    @Override
    public JComponent getComponent() {
        return introPanel;
    }

    @Override
    public void updateDataModel() {
        // nothing to see here....move along
    }
}
