package au.com.borner.salesforce.plugin.project;

import com.intellij.icons.AllIcons;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.platform.ProjectTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * A ProjectTemplate for a SalesForce project
 *
 * @author mark
 */
public class SalesForceProjectTemplate implements ProjectTemplate {

    @NotNull
    @Override
    public String getName() {
        return "Salesforce Project";
    }

    @Nullable
    @Override
    public String getDescription() {
        return "Creates an empty SalesForce project.";
    }

    @NotNull
    @Override
    public ModuleBuilder createModuleBuilder() {
        return new SalesForceModuleBuilder();
    }

    @Nullable
    @Override
    public ValidationInfo validateSettings() {
        return null;
    }

    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Java;
    }

}
