package au.com.borner.salesforce.plugin.settings.project;

import au.com.borner.salesforce.plugin.settings.instances.InstancesPersistentStateComponent;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mark
 */
public class InstanceSelectionPanel {

    private JPanel instanceSelectionPanel;
    private JComboBox instancesComboBox;

    public InstanceSelectionPanel() {
        InstancesPersistentStateComponent instancesPersistentStateComponent = InstancesPersistentStateComponent.getInstance();
        ComboBoxModel model = new DefaultComboBoxModel(instancesPersistentStateComponent.instanceNames.toArray());
        instancesComboBox.setModel(model);
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

    public void resetSelectedInstance() {
        instancesComboBox.setSelectedIndex(-1);
    }

}
