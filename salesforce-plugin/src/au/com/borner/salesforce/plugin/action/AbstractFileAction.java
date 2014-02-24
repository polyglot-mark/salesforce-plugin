package au.com.borner.salesforce.plugin.action;

import au.com.borner.salesforce.client.rest.domain.AbstractSourceCode;
import au.com.borner.salesforce.client.rest.domain.AbstractVisualForceSource;
import au.com.borner.salesforce.plugin.service.ClientFactoryService;
import au.com.borner.salesforce.plugin.service.VersionsService;
import au.com.borner.salesforce.plugin.util.FileUtilities;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.actions.CreateTemplateInPackageAction;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.ide.fileTemplates.FileTemplateUtil;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.progress.PerformInBackgroundOption;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.InputValidatorEx;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.java.JavaSourceRootType;

import javax.swing.*;
import java.util.Collections;
import java.util.Properties;

/**
 * An abstract file action with common stuffs
 *
 * @author mark
 */
public abstract class AbstractFileAction extends CreateTemplateInPackageAction<PsiElement> {

    protected Project project;

    public AbstractFileAction(String text, String description, Icon icon) {
        super(text, description, icon, Collections.singleton(JavaSourceRootType.SOURCE));
    }

    @Override
    protected void buildDialog(final Project project, PsiDirectory psiDirectory, CreateFileFromTemplateDialog.Builder builder) {
        this.project = project;
        // Add validator - Salesforce doesn't have namespaces, so validate the filename does not contain a period
        builder.setValidator(new InputValidatorEx() {
            @Override
            public String getErrorText(String inputString) {
                if (inputString.length() > 0 && (inputString.contains(".") || inputString.contains(" "))) {
                    return "This is not a valid Apex file name";
                }
                return null;
            }

            @Override
            public boolean checkInput(String inputString) {
                return true;
            }

            @Override
            public boolean canClose(String inputString) {
                return !StringUtil.isEmptyOrSpaces(inputString) && getErrorText(inputString) == null;
            }
        });
    }

    @Nullable
    @Override
    protected PsiElement getNavigationElement(@NotNull PsiElement psiElement) {
        return psiElement;
    }

    @Override
    protected boolean checkPackageExists(PsiDirectory directory) {
        return true;
    }

    @Nullable
    @Override
    protected PsiElement doCreate(final PsiDirectory psiDirectory, final String className, String templateName) throws IncorrectOperationException {

        FileTemplate template = FileTemplateManager.getInstance().getInternalTemplate(templateName);

        Properties defaultProperties = FileTemplateManager.getInstance().getDefaultProperties(psiDirectory.getProject());
        Properties properties = new Properties(defaultProperties);
        properties.setProperty(FileTemplate.ATTRIBUTE_NAME, className);

        final String fileName = className + "." + getExtension();

        final PsiElement element;
        try {
            element = FileTemplateUtil.createFromTemplate(template, fileName, properties, psiDirectory);
        }
        catch (IncorrectOperationException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Error creating file from template", e);
            return null;
        }

        // Create file in Salesforce and save local metadata file
        ProgressManager.getInstance().run(new Task.Backgroundable(project, "Creating file in Salesforce", false, PerformInBackgroundOption.ALWAYS_BACKGROUND) {
            @Override
            public void run(@NotNull ProgressIndicator indicator) {
                ClientFactoryService clientFactoryService = ServiceManager.getService(project, ClientFactoryService.class);
                VersionsService versionsService = ServiceManager.getService(project, VersionsService.class);
                AbstractSourceCode sObject = getNewSObject();
                sObject.setBody(element.getText());
                sObject.setName(className);
                if (sObject instanceof AbstractVisualForceSource) {
                    AbstractVisualForceSource avfs = (AbstractVisualForceSource)sObject;
                    avfs.setMasterLabel(className);
                }
                sObject.setApiVersion(versionsService.getLatestVersion().getAPIVersion());
                sObject = clientFactoryService.getToolingClient().createSObject(sObject);
                try {
                    FileUtilities.createMetadataFile(psiDirectory.getVirtualFile().getPath(), fileName, sObject);
                } catch (Exception e) {
                    System.out.println("Ouch!");
                    // Uh oh, what to do now?
                }
            }
        });

        return element;
    }

    protected abstract String getExtension();

    protected abstract AbstractSourceCode getNewSObject();
}
