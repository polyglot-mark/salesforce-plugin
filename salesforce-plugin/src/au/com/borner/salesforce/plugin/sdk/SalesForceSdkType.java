package au.com.borner.salesforce.plugin.sdk;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.projectRoots.*;
import com.intellij.openapi.projectRoots.impl.JavaDependentSdkType;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.JarFileSystem;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.util.ArrayUtil;
import com.intellij.util.cls.BytePointer;
import com.intellij.util.cls.ClsFormatException;
import com.intellij.util.cls.ClsUtil;
import org.jdom.Element;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A custom SDK for Salesforce
 *
 * @author mark
 */
public class SalesForceSdkType extends JavaDependentSdkType implements JavaSdkType {

    private static final String SALES_FORCE_PLUGIN_JAR_FILE_NAME = "salesforce-plugin.jar";
    private static final String SALES_FORCE_SDK_NAME = "Salesforce SDK";

    public static SalesForceSdkType getInstance() {
        return SdkType.findInstance(SalesForceSdkType.class);
    }

    public SalesForceSdkType() {
        super(SALES_FORCE_SDK_NAME);
    }

    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Java;
    }

    @Nullable
    @Override
    public String suggestHomePath() {
        return PathManager.getJarPathForClass(SalesForceSdkType.class);
    }

    @Override
    public boolean isValidSdkHome(String path) {
        File f = new File(path, SALES_FORCE_PLUGIN_JAR_FILE_NAME);
        return f.exists() || path.contains("plugins-sandbox/plugins/salesforce-plugin/classes");
    }

    @Nullable
    @Override
    public String getVersionString(Sdk sdk) {
        Sdk javaSdk = getJavaSdk(sdk);
        return javaSdk == null ? null : javaSdk.getVersionString();
    }

    @Override
    public String suggestSdkName(String currentSdkName, String sdkHome) {
        return SALES_FORCE_SDK_NAME;
    }

    @Override
    public boolean setupSdkPaths(Sdk salesForceSdk, SdkModel sdkModel) {
        SdkModificator sdkModificator = salesForceSdk.getSdkModificator();

        List<String> candidateJavaSdks = new ArrayList<String>();
        Sdk[] currentlyConfiguredSdks = sdkModel.getSdks();

        JavaSdkVersion requiredSdkVersion = getRequiredSdkVersion(salesForceSdk);

        for (Sdk sdk : currentlyConfiguredSdks) {
            if (isValidJavaSdk(requiredSdkVersion, sdk)) {
                candidateJavaSdks.add(sdk.getName());
            }
        }

        if (candidateJavaSdks.isEmpty()) {
            if (requiredSdkVersion == null) {
                Messages.showErrorDialog("A Java SDK was not found.  Please configure one", "Java SDK Not Found");
            } else {
                Messages.showErrorDialog("A Java SDK of at least version " + requiredSdkVersion.getDescription() + " was not found.  Please configure one.", "Java SDK Not Found");
            }
            return false;
        }

        final int choice = Messages
                .showChooseDialog("Select Java SDK to be used with the SalesForce plugin", "Select Java Platform", ArrayUtil.toStringArray(candidateJavaSdks), candidateJavaSdks.get(0), Messages.getQuestionIcon());

        if (choice != -1) {
            String name = candidateJavaSdks.get(choice);
            Sdk selectedJavaSdk = sdkModel.findSdk(name);
            assert(selectedJavaSdk != null);
            addJavaSdkPaths(sdkModificator, selectedJavaSdk, salesForceSdk.getHomePath());
            sdkModificator.setSdkAdditionalData(new SalesForceSdkAdditionalData(selectedJavaSdk, salesForceSdk));
            sdkModificator.setVersionString(selectedJavaSdk.getVersionString());
            sdkModificator.commitChanges();
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public AdditionalDataConfigurable createAdditionalDataConfigurable(SdkModel sdkModel, SdkModificator sdkModificator) {
        return null;  // We don't need any additional configuration data for our SDK
    }

    @Override
    public String getPresentableName() {
        return "Salesforce SDK";
    }

    @Override
    public void saveAdditionalData(SdkAdditionalData additionalData, Element element) {
        if (additionalData instanceof SalesForceSdkAdditionalData) {
            ((SalesForceSdkAdditionalData)additionalData).save(element);
        }
    }

    @Nullable
    @Override
    public SdkAdditionalData loadAdditionalData(Sdk sdk, Element element) {
        return new SalesForceSdkAdditionalData(sdk, element);
    }

    // JavaSdkType interface ------------------

    @Nullable
    public String getBinPath(Sdk sdk) {
        Sdk javaSdk = getJavaSdk(sdk);
        return javaSdk == null ? null : JavaSdk.getInstance().getBinPath(javaSdk);
    }

    @Nullable
    public String getToolsPath(Sdk sdk) {
        Sdk javaSdk = getJavaSdk(sdk);
        if (javaSdk != null && javaSdk.getVersionString() != null) {
            return JavaSdk.getInstance().getToolsPath(javaSdk);
        }
        return null;
    }

    @Nullable
    public String getVMExecutablePath(Sdk sdk) {
        Sdk javaSdk = getJavaSdk(sdk);
        return javaSdk == null ? null : JavaSdk.getInstance().getVMExecutablePath(javaSdk);
    }

    // Helper Methods -----------------------

    @Nullable
    private Sdk getJavaSdk(Sdk sdk) {
        SdkAdditionalData sdkAdditionalData = sdk.getSdkAdditionalData();
        if (sdkAdditionalData instanceof SalesForceSdkAdditionalData) {
            return ((SalesForceSdkAdditionalData)sdkAdditionalData).getJavaSdk();
        }
        return null;
    }

    public static boolean isValidJavaSdk(JavaSdkVersion requiredSdkVersion, Sdk javaSdk) {
        SdkTypeId sdkType = javaSdk.getSdkType();
        if (sdkType instanceof JavaSdk) {
            JavaSdkVersion javaSdkVersion = JavaSdk.getInstance().getVersion(javaSdk);
            if (javaSdkVersion != null && requiredSdkVersion != null) {
                return javaSdkVersion.isAtLeast(requiredSdkVersion);
            }
        }
        return false;
    }


    public static JavaSdkVersion getRequiredSdkVersion(Sdk salesForceSdk) {

        VirtualFile classFile;

        File salesForcePluginJarFile = new File(salesForceSdk.getHomePath(), SALES_FORCE_PLUGIN_JAR_FILE_NAME);
        if (salesForcePluginJarFile.exists()) {
            classFile = JarFileSystem.getInstance().findFileByPath(FileUtil.toSystemIndependentName(salesForcePluginJarFile.getPath()) +
                    "!/au/com/borner/salesforce/plugin/sdk/SalesForceSdkType.class");
        } else {
            String url = VirtualFileManager.constructUrl(LocalFileSystem.PROTOCOL, FileUtil.toSystemIndependentName(salesForceSdk.getHomePath()) +
                    "/au/com/borner/salesforce/plugin/sdk/SalesForceSdkType.class");
            classFile = VirtualFileManager.getInstance().findFileByUrl(url);
        }

        if (classFile == null) {
            return null;
        }

        int classFileVersion = 0;
        final BytePointer ptr;
        try {
            ptr = new BytePointer(classFile.contentsToByteArray(), 6);
            classFileVersion = ClsUtil.readU2(ptr);
        }
        catch (IOException e) {
            // ignore
        }
        catch (ClsFormatException e) {
            // ignore
        }

        switch (classFileVersion) {
            case 48:
                return JavaSdkVersion.JDK_1_4;
            case 49:
                return JavaSdkVersion.JDK_1_5;
            case 50:
                return JavaSdkVersion.JDK_1_6;
            case 51:
                return JavaSdkVersion.JDK_1_7;
            default:
                return null;
        }
    }

    private JavaSdkVersion getJavaSdkVersion(Sdk sdk) {
        SdkTypeId sdkTypeId = sdk.getSdkType();
        if (sdkTypeId instanceof JavaSdkType) {
            return JavaSdk.getInstance().getVersion(sdk);
        }
        return null;
    }

    private void addJavaSdkPaths(SdkModificator sdkModificator, Sdk javaSdk, String salesForceSdkHomePath) {
        String[] entries = javaSdk.getRootProvider().getUrls(OrderRootType.CLASSES);

        for (String entry : entries) {
            VirtualFile virtualFile = VirtualFileManager.getInstance().findFileByUrl(entry);
            if (virtualFile != null) {
                sdkModificator.addRoot(virtualFile, OrderRootType.CLASSES);
            }
        }

        // Add Salesforce SDK to classes - it could either be from a JAR or from a classes folder
        File salesForcePluginJarFile = new File(salesForceSdkHomePath, SALES_FORCE_PLUGIN_JAR_FILE_NAME);
        if (salesForcePluginJarFile.exists()) {
            // TODO: need to fill this in.....
        } else {
            String url = VirtualFileManager.constructUrl(LocalFileSystem.PROTOCOL, FileUtil.toSystemIndependentName(salesForceSdkHomePath));
            VirtualFile virtualFile = VirtualFileManager.getInstance().findFileByUrl(url);
            sdkModificator.addRoot(virtualFile, OrderRootType.CLASSES);
        }

    }

}
