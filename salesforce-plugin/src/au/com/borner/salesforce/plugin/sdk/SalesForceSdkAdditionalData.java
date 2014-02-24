package au.com.borner.salesforce.plugin.sdk;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.projectRoots.*;
import org.jdom.Element;

/**
 * Salesforce SDK - Sdk Additional Data
 *
 * @author mark
 */
public class SalesForceSdkAdditionalData implements ValidatableSdkAdditionalData {

    private static final String JDK_NAME = "jdkName";

    private Sdk javaSdk;
    private Sdk salesForceSdk;
    private String javaSdkName;

    /**
     * Constructor which is used when we are creating a Salesforce SDK for the first time (brand new)
     *
     * @param javaSdk The Java SDK that the Salesforce SDK will use
     * @param salesForceSdk The Salesforce SDK
     */
    //
    public SalesForceSdkAdditionalData(Sdk javaSdk, Sdk salesForceSdk) {
        this.javaSdk = javaSdk;
        this.salesForceSdk = salesForceSdk;
    }

    /**
     * Constructor which is used when we are being de-serialised (from being persisted, saved, etc).
     *
     * @see au.com.borner.salesforce.plugin.sdk.SalesForceSdkAdditionalData#save
     *
     * @param salesForceSdk The Salesforce SDK
     * @param element The persisted Element
     */
    public SalesForceSdkAdditionalData(Sdk salesForceSdk, Element element) {
        this.salesForceSdk = salesForceSdk;
        this.javaSdkName = element.getAttributeValue(JDK_NAME);
    }

    public void save(Element element) {
        Sdk javaSdk = getJavaSdk();  // use getter because it may be lazy loaded
        if (javaSdk != null) {
            element.setAttribute(JDK_NAME, javaSdk.getName());
        }
    }

    @Override
    public void checkValid(SdkModel sdkModel) throws ConfigurationException {
        if (getJavaSdk() == null) {
            throw new ConfigurationException("Please configure a Java SDK");
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new SalesForceSdkAdditionalData(javaSdk, salesForceSdk);
    }

    public Sdk getJavaSdk() {
        ProjectJdkTable jdkTable = ProjectJdkTable.getInstance();
        if (javaSdk == null) {
            if (javaSdkName != null) {
                javaSdk = jdkTable.findJdk(javaSdkName);
                javaSdkName = null;
            }
            else {
                JavaSdkVersion requiredSdkVersion = SalesForceSdkType.getRequiredSdkVersion(salesForceSdk);
                for (Sdk sdk : jdkTable.getAllJdks()) {
                    if (SalesForceSdkType.isValidJavaSdk(requiredSdkVersion, sdk)) {
                        javaSdk = sdk;
                        break;
                    }
                }
            }
        }
        return javaSdk;
    }


}
