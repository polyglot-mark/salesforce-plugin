package au.com.borner.salesforce.plugin.action;

import au.com.borner.salesforce.client.rest.domain.AbstractSourceCode;
import au.com.borner.salesforce.client.rest.domain.VisualForcePage;
import au.com.borner.salesforce.plugin.template.FileTemplates;
import au.com.borner.salesforce.plugin.visualforce.filetypes.VisualForcePageFileType;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;

/**
 * An Action which creates a new Visualforce page file
 *
 * @author mark
 */
public class NewVisualForcePageAction extends AbstractFileAction {

    public NewVisualForcePageAction() {
        super("New Visualforce page", "Create a Visualforce page", VisualForcePageFileType.INSTANCE.getIcon());
    }

    @Override
    protected void buildDialog(final Project project, PsiDirectory psiDirectory, CreateFileFromTemplateDialog.Builder builder) {
        super.buildDialog(project, psiDirectory, builder);
        builder.addKind("Visualforce Page", VisualForcePageFileType.INSTANCE.getIcon(), FileTemplates.VISUALFORCE_PAGE_TEMPLATE);
    }

    @Override
    protected String getActionName(PsiDirectory psiDirectory, String newName, String templateName) {
        return "Creating a Visualforce page " + newName;
    }

    @Override
    protected String getExtension() {
        return VisualForcePageFileType.INSTANCE.getDefaultExtension();
    }

    @Override
    protected AbstractSourceCode getNewSObject() {
        return new VisualForcePage();
    }
}
