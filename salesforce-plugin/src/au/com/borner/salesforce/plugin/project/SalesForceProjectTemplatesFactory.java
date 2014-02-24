package au.com.borner.salesforce.plugin.project;

import com.intellij.icons.AllIcons;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.platform.ProjectTemplate;
import com.intellij.platform.ProjectTemplatesFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * A SalesForce Project Template Factory
 *
 * @author mark
 */
public class SalesForceProjectTemplatesFactory extends ProjectTemplatesFactory {

    @NotNull
    @Override
    public String[] getGroups() {
        return new String[] {"Salesforce"};
    }

    @NotNull
    @Override
    public ProjectTemplate[] createTemplates(String s, WizardContext wizardContext) {
        return new ProjectTemplate[] { new SalesForceProjectTemplate() };
    }

    public Icon getGroupIcon(String group) {
        return AllIcons.FileTypes.JavaClass;
    }

}
