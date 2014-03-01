package au.com.borner.salesforce.plugin.project;

import au.com.borner.salesforce.plugin.sdk.SalesForceSdkType;
import au.com.borner.salesforce.plugin.settings.project.ProjectSettingsPersistentStateComponent;
import com.intellij.ide.util.projectWizard.JavaModuleBuilder;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.projectRoots.SdkTypeId;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.File;

/**
 * A ModuleBuilder for a Salesforce module
 *
 * @author mark
 */
public class SalesForceModuleBuilder extends JavaModuleBuilder {

    private SalesForceWizardStateBean stateBean = new SalesForceWizardStateBean();

    @Override
    public String getName() {
        return "SalesForce Module Builder";
    }

    @Override
    public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {
        if (myJdk == null){
            modifiableRootModel.inheritSdk();
        } else {
            modifiableRootModel.setSdk(myJdk);
        }

        // Add root folder
        ContentEntry contentEntry = doAddContentEntry(modifiableRootModel);

        // The classes, trigger, pages, and components folder were created by one of the Wizard steps
        // Now, we need to add them as source folders under the root folder
        if (contentEntry != null) {
            for (SalesForceWizardStateBean.FOLDER_NAMES folderName : SalesForceWizardStateBean.FOLDER_NAMES.values()) {
                String path = getContentEntryPath() + File.separator + folderName.name().toLowerCase();
                addSourceFolder(contentEntry, path);
            }
        }

        ProjectSettingsPersistentStateComponent projectSettings = ServiceManager.getService(modifiableRootModel.getProject(), ProjectSettingsPersistentStateComponent.class);
        projectSettings.instanceName = stateBean.getSelectedInstance();

    }

    @Override
    public ModuleType getModuleType() {
        return new SalesForceModuleType();
    }

    @Override
    public boolean isSuitableSdkType(SdkTypeId sdkType) {
        return sdkType instanceof SalesForceSdkType;
    }

    private void addSourceFolder(ContentEntry contentEntry, String path) {
        final VirtualFile sourceRoot = LocalFileSystem.getInstance().refreshAndFindFileByPath(FileUtil.toSystemIndependentName(path));
        if (sourceRoot != null) {
            contentEntry.addSourceFolder(sourceRoot, false, "");
        }
    }

    public SalesForceWizardStateBean getStateBean() {
        return stateBean;
    }

}
