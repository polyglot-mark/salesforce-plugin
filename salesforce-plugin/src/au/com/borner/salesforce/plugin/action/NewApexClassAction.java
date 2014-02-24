package au.com.borner.salesforce.plugin.action;

import au.com.borner.salesforce.client.rest.domain.AbstractSourceCode;
import au.com.borner.salesforce.client.rest.domain.ApexClass;
import au.com.borner.salesforce.plugin.apex.ApexIcons;
import au.com.borner.salesforce.plugin.apex.filetypes.ApexClassFileType;
import au.com.borner.salesforce.plugin.template.FileTemplates;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;

/**
 * Creates a new Apex Class (class, interface, or test class)
 *
 * @author mark
 */
public class NewApexClassAction extends AbstractFileAction {

    public NewApexClassAction() {
        super("New Apex class", "Create an Apex class", ApexClassFileType.INSTANCE.getIcon());
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory psiDirectory, CreateFileFromTemplateDialog.Builder builder) {
        super.buildDialog(project, psiDirectory, builder);
        builder.addKind("Class", ApexIcons.CLASS, FileTemplates.APEX_CLASS_TEMPLATE);
        builder.addKind("Interface", ApexIcons.INTERFACE, FileTemplates.APEX_INTERFACE_TEMPLATE);
        builder.addKind("Enum", ApexIcons.ENUM, FileTemplates.APEX_ENUM);
        builder.addKind("Test Class", ApexIcons.CLASS, FileTemplates.APEX_TEST_CLASS_TEMPLATE);
    }

    @Override
    protected String getExtension() {
        return ApexClassFileType.INSTANCE.getDefaultExtension();
    }

    @Override
    protected String getActionName(PsiDirectory directory, String newName, String templateName) {
        return "Creating an Apex class: " + newName;
    }

    @Override
    protected AbstractSourceCode getNewSObject() {
        return new ApexClass();
    }
}
