package au.com.borner.salesforce.plugin.action;

import au.com.borner.salesforce.client.rest.domain.AbstractSourceCode;
import au.com.borner.salesforce.client.rest.domain.VisualForceComponent;
import au.com.borner.salesforce.plugin.template.FileTemplates;
import au.com.borner.salesforce.plugin.visualforce.filetypes.VisualForceComponentFileType;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;

/**
 * An Action which creates a new Visualforce component file
 *
 * @author mark
 */
public class NewVisualForceComponentAction extends AbstractFileAction {

    public NewVisualForceComponentAction() {
        super("New Visualforce component", "Create a Visualforce component", VisualForceComponentFileType.INSTANCE.getIcon());
    }

    @Override
    protected void buildDialog(final Project project, PsiDirectory psiDirectory, CreateFileFromTemplateDialog.Builder builder) {
        super.buildDialog(project, psiDirectory, builder);
        builder.addKind("Visualforce Component", VisualForceComponentFileType.INSTANCE.getIcon(), FileTemplates.VISUALFORCE_COMPONENT_TEMPLATE);
    }

    @Override
    protected String getActionName(PsiDirectory psiDirectory, String newName, String templateName) {
        return "Creating a Visualforce Component " + newName;
    }

    @Override
    protected String getExtension() {
        return VisualForceComponentFileType.INSTANCE.getDefaultExtension();
    }

    @Override
    protected AbstractSourceCode getNewSObject() {
        return new VisualForceComponent();
    }
}
