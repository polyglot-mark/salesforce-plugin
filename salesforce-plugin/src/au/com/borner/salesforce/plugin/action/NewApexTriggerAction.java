package au.com.borner.salesforce.plugin.action;

import au.com.borner.salesforce.client.rest.domain.AbstractSourceCode;
import au.com.borner.salesforce.client.rest.domain.ApexTrigger;
import au.com.borner.salesforce.plugin.apex.filetypes.ApexTriggerFileType;
import au.com.borner.salesforce.plugin.template.FileTemplates;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;

/**
 * An Action which creates a new Apex trigger file
 *
 * @author mark
 */
public class NewApexTriggerAction extends AbstractFileAction {

    public NewApexTriggerAction() {
        super("New Apex trigger", "Create an Apex trigger", ApexTriggerFileType.INSTANCE.getIcon());
    }

    @Override
    protected void buildDialog(final Project project, PsiDirectory psiDirectory, CreateFileFromTemplateDialog.Builder builder) {
        super.buildDialog(project, psiDirectory, builder);
        builder.addKind("Trigger", ApexTriggerFileType.INSTANCE.getIcon(), FileTemplates.APEX_TRIGGER_TEMPLATE);
    }

    @Override
    protected String getActionName(PsiDirectory psiDirectory, String newName, String templateName) {
        return "Creating an Apex trigger " + newName;
    }

    @Override
    protected String getExtension() {
        return ApexTriggerFileType.INSTANCE.getDefaultExtension();
    }

    @Override
    protected AbstractSourceCode getNewSObject() {
        return new ApexTrigger();
    }
}
