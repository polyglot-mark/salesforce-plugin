package au.com.borner.salesforce.plugin.settings.instances;

import au.com.borner.salesforce.client.rest.InstanceCredentials;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonShortcuts;
import com.intellij.openapi.actionSystem.CustomShortcutSet;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.InputValidator;
import com.intellij.openapi.ui.MasterDetailsComponent;
import com.intellij.openapi.ui.MasterDetailsStateService;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.Conditions;
import com.intellij.util.IconUtil;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * The Salesforce instances Configurable which is a Master Details Component
 *
 * @author Mark Borner (gzhomzb)
 */
public class InstancesConfigurable extends MasterDetailsComponent implements SearchableConfigurable {

    private final InstancesPersistentStateComponent instancesPersistentStateComponent;

    public InstancesConfigurable() {
        this.instancesPersistentStateComponent = InstancesPersistentStateComponent.getInstance();
        initTree();
        myTree.setShowsRootHandles(false);
        loadPersistedInstances();
    }

    private void loadPersistedInstances() {
        for (String instanceName : instancesPersistentStateComponent.instanceNames) {
            InstanceCredentials instanceCredentials = new InstanceCredentials(instanceName);
            addInstanceNode(instanceCredentials);
        }
    }

    // Master Details Component

    @Override
    protected MasterDetailsStateService getStateService() {
        return MasterDetailsStateService.getInstance(ProjectManager.getInstance().getDefaultProject());
    }

    @Nullable
    @Override
    protected String getComponentStateKey() {
        return "Salesforce.Instances.UI";
    }

    @Nullable
    @Override
    protected ArrayList<AnAction> createActions(boolean fromPopup) {
        ArrayList<AnAction> result = new ArrayList<AnAction>();

        // Add new instance
        result.add(new AnAction("Add", "Add", IconUtil.getAddIcon()) {
            {
                registerCustomShortcutSet(CommonShortcuts.INSERT, myTree);
            }

            public void actionPerformed(AnActionEvent event) {
                String instanceName = askForInstanceName("Add Salesforce Instance");
                if (instanceName == null) return;
                InstanceCredentials instance = new InstanceCredentials();
                instance.setName(instanceName);
                addNewInstanceNode(instance);
            }
        });

        // Delete an instance
        result.add(new MyDeleteAction(forAll(Conditions.alwaysTrue())));

        // Copy an instance
        result.add(new AnAction("Copy", "Copy", PlatformIcons.COPY_ICON) {
            {
                registerCustomShortcutSet(new CustomShortcutSet(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK)), myTree);
            }

            public void actionPerformed(AnActionEvent event) {
                InstanceCredentials oldInstance = (InstanceCredentials)getSelectedObject();
                if (oldInstance == null) return;
                if (!oldInstance.isRetrievedFromSafe()) {
                    Messages.showErrorDialog("Please retrieve details from Safe before copying.", "Error");
                    return;
                }
                String newInstanceName = askForInstanceName("Copy Salesforce Instance");
                if (newInstanceName == null) return;
                InstanceCredentials newInstance = new InstanceCredentials(oldInstance);
                newInstance.setName(newInstanceName);
                addNewInstanceNode(newInstance);
            }

            public void update(AnActionEvent event) {
                super.update(event);
                event.getPresentation().setEnabled(getSelectedObject() != null);
            }
        });
        return result;
    }

    @Nullable
    @Override
    protected String getEmptySelectionString() {
        return "No Salesforce instances are defined.  Click + to add one.";
    }

    @Override
    protected void processRemovedItems() {
        // Get all the profile names from the settings page
        List<String> currentNames = new ArrayList<String>(myRoot.getChildCount());
        for (int i=0; i<myRoot.getChildCount(); i++) {
            MyNode node = (MyNode)myRoot.getChildAt(i);
            InstanceNamedConfigurable instanceNamedConfigurable = (InstanceNamedConfigurable)node.getConfigurable();
            currentNames.add(instanceNamedConfigurable.getEditableObject().getName());
        }
        // Now flip through all the persisted names, and if they don't exist on the settings page, delete them
        List<String> persistedInstanceNames = new ArrayList<String>(instancesPersistentStateComponent.instanceNames);
        for (String instanceName : persistedInstanceNames) {
            if (!currentNames.contains(instanceName)) {
                instancesPersistentStateComponent.removeInstance(instanceName);
            }
        }
    }

    @Override
    protected boolean wasObjectStored(Object editableObject) {
        InstanceCredentials instanceCredentials = (InstanceCredentials)editableObject;
        return (instancesPersistentStateComponent.instanceNames.contains(instanceCredentials.getName()));
    }

    @Override
    public void reset() {
        myRoot.removeAllChildren();
        loadPersistedInstances();
        super.reset();
    }

    // Configurable interface

    @Nls
    @Override
    public String getDisplayName() {
        return "Salesforce Instances";
    }

    // Searchable Configurable interface

    @NotNull
    @Override
    public String getId() {
        return "salesforce.instances";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }

    // Helper methods

    private void addNewInstanceNode(InstanceCredentials instance) {
        InstanceNamedConfigurable namedConfigurable = new InstanceNamedConfigurable(instance, TREE_UPDATER, true);
        addNode(namedConfigurable);
    }

    private void addInstanceNode(InstanceCredentials instance) {
        InstanceNamedConfigurable namedConfigurable = new InstanceNamedConfigurable(instance, TREE_UPDATER, false);
        addNode(namedConfigurable);
    }

    private void addNode(InstanceNamedConfigurable namedConfigurable) {
        MyNode node = new MyNode(namedConfigurable);
        addNode(node, myRoot);
        selectNodeInTree(node);
    }

    public List<String> getInstancesInTree() {
        List<String> currentNames = new ArrayList<String>(myRoot.getChildCount());
        for (int i=0; i<myRoot.getChildCount(); i++) {
            MyNode node = (MyNode)myRoot.getChildAt(i);
            InstanceNamedConfigurable instanceNamedConfigurable = (InstanceNamedConfigurable)node.getConfigurable();
            currentNames.add(instanceNamedConfigurable.getEditableObject().getName());
        }
        return currentNames;
    }

    @Nullable
    private String askForInstanceName(String title) {
        return Messages.showInputDialog("New instance name:", title, Messages.getQuestionIcon(), "", new InputValidator() {
            public boolean checkInput(String instanceName) {
                if (instanceName.length() == 0) {
                    return false;
                }
                if (DuplicateInstanceNameChecker.isDuplicate(instanceName) || getInstancesInTree().contains(instanceName)) {
                    return false;
                }
                for (int i=0; i<myRoot.getChildCount(); i++) {
                    MyNode node = (MyNode)myRoot.getChildAt(i);
                    InstanceNamedConfigurable instanceNamedConfigurable = (InstanceNamedConfigurable)node.getConfigurable();
                    if (instanceName.equals(instanceNamedConfigurable.getEditableObject().getName())) {
                        return false;
                    }
                }
                return true;
            }

            public boolean canClose(String instanceName) {
                return checkInput(instanceName);
            }
        });
    }

}
