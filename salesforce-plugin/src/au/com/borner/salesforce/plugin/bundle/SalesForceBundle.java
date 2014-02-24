package au.com.borner.salesforce.plugin.bundle;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ResourceBundle;

/**
 * @author mark
 */
public class SalesForceBundle {

    private static Reference<ResourceBundle> bundle;
    private static final String BUNDLE_NAME = "au.com.borner.salesforce.plugin.bundle.SalesForceBundle";

    public static String message(@PropertyKey(resourceBundle = BUNDLE_NAME)String key, Object... params) {
        return CommonBundle.message(getBundle(), key, params);
    }

    private static ResourceBundle getBundle() {
        ResourceBundle bundle;
        if (SalesForceBundle.bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE_NAME);
            SalesForceBundle.bundle = new SoftReference<ResourceBundle>(bundle);
        } else {
            bundle = SalesForceBundle.bundle.get();
        }
        return bundle;
    }

}
