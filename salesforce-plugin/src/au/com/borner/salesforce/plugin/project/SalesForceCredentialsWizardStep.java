package au.com.borner.salesforce.plugin.project;

import au.com.borner.salesforce.client.rest.InstanceUtils;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.ui.JBColor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Wizard Step to collection the user's Salesforce credentials and
 * store them in the state bean.
 *
 * @author mark
 */
public class SalesForceCredentialsWizardStep extends ModuleWizardStep {

    private Logger logger = Logger.getInstance(getClass());
    private final SalesForceWizardStateBean stateBean;

//    private AuthenticateCredentialsWorker worker;
    private volatile boolean currentlyValidating = false;
    private volatile boolean validated = false;

    private JPanel credentialsPanel;
    private JTextField username;
    private JPasswordField password;
    private JPasswordField securityToken;
    private JComboBox environment;
    private JTextField otherUrlTextField;
    private JLabel otherUrlLabel;
    private JTextField consumerKey;
    private JPasswordField consumerSecret;
    private JProgressBar verifyCredentialsProgressBar;
    private JLabel verifyCredentialsLabel;

    public SalesForceCredentialsWizardStep(SalesForceWizardStateBean stateBean) {
        this.stateBean = stateBean;

        // This is temporary code so I don't have to keep retyping my credentials!
        // I hope I remember to remove this!
        username.setText("mark.borner@zurich.com.au");
        password.setText("steven01");
        securityToken.setText("xmakUlIARIWoa8KHLATy09bD");
        consumerKey.setText("3MVG9Y6d_Btp4xp7J1B0QV0UyiIoW2_gab3din4aKGnwJ5E1GPtm5PtvRhuJmeMlBHUnl5awzM7t5kzct_1mB");
        consumerSecret.setText("8385066708015408962");

        environment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean visible = false;
                if (environment.getSelectedItem().equals(InstanceUtils.OTHER)) {
                    visible = true;
                }
                otherUrlLabel.setVisible(visible);
                otherUrlTextField.setVisible(visible);
            }
        });

        verifyCredentialsLabel.setVisible(false);
        verifyCredentialsLabel.setVisible(false);
    }

    @Override
    public JComponent getComponent() {
        return credentialsPanel;
    }

    /**
     * Looks like validate() gets called before updateDataModel().  So we are going to validate
     * the user's login credentials here.
     *
     * @return <code>true</code> if the credentials are good - otherwise, <code>false</code>
     * @throws ConfigurationException
     */
    @Override
    public boolean validate() throws ConfigurationException {
        if (validated) {
            return true;
        }
        if (currentlyValidating) {
            return false;
        }
        currentlyValidating = true;

        verifyCredentialsLabel.setText("Verifying credentials....");
        verifyCredentialsLabel.setForeground(JBColor.RED);
        verifyCredentialsLabel.setVisible(true);
        verifyCredentialsProgressBar.setVisible(true);
        setFieldsEnabled(false);
        credentialsPanel.invalidate();
//        worker = new AuthenticateCredentialsWorker();
//        worker.execute();
        return false;
    }

    public void onStepLeaving() {
        // User has clicked Backward (the validate() method handles them clicking Forward)
//        if (currentlyValidating) {
//            if (worker != null) {
//                worker.cancel(true);
//            }
//            worker = null;
            currentlyValidating = false;
            validated = false;
            verifyCredentialsLabel.setText("");
            verifyCredentialsLabel.setVisible(false);
            verifyCredentialsProgressBar.setVisible(false);
            setFieldsEnabled(true);
//        }
    }

    @Override
    public void updateDataModel() {
//        stateBean.setUsername(username.getText());
//        stateBean.setPassword(new String(password.getPassword()));
//        stateBean.setSecurityToken(new String(securityToken.getPassword()));
//        stateBean.setConsumerKey(consumerKey.getText());
//        stateBean.setConsumerSecret(new String(consumerSecret.getPassword()));
//        stateBean.setEnvironment((String) environment.getSelectedItem());
//        stateBean.setOtherUrl(otherUrlTextField.getText());
    }

    private void setFieldsEnabled(boolean enabled) {
        username.setEnabled(enabled);
        password.setEnabled(enabled);
        securityToken.setEnabled(enabled);
        consumerKey.setEnabled(enabled);
        consumerSecret.setEnabled(enabled);
        environment.setEnabled(enabled);
        otherUrlTextField.setEnabled(enabled);
    }

    /**
     * A SwingWorker for authenticating the user's credentials on a separate thread
     * (and then updating the UI on the main thread)
     *
     */
//    private class AuthenticateCredentialsWorker extends SwingWorker <Boolean, Void> {
//
//        @Override
//        protected Boolean doInBackground() throws Exception {
//            String host = InstanceUtils.getOAuthHostForEnvironment((String) environment.getSelectedItem());
//            if (host == null) {
//                host = otherUrlTextField.getText();
//            }
//            ConnectionManager connectionManager = new ConnectionManager(host,
//                            username.getText(),
//                            new String(password.getPassword()),
//                            new String(securityToken.getPassword()),
//                            consumerKey.getText(),
//                            new String(consumerSecret.getPassword()));
//            stateBean.setConnectionManager(connectionManager);
//            try {
//                connectionManager.login();
//                return true;
//            } catch (ConnectionException e) {
//                logger.error("Could not log into Salesforce!", e);
//                return false;
//            }
//        }
//
//        @Override
//        protected void done() {
//            try {
//                Boolean successful = get();
//                if (successful) {
//                    verifyCredentialsProgressBar.setVisible(false);
//                    verifyCredentialsLabel.setForeground(JBColor.BLUE);
//                    verifyCredentialsLabel.setText("Your credentials have been verified.  Please click Next.");
//                    validated = true;
//                    currentlyValidating = false;
//                    credentialsPanel.invalidate();
//                } else {
//                    verifyCredentialsProgressBar.setVisible(false);
//                    verifyCredentialsLabel.setText("Your credentials could not be verified.  Please verify you have entered them correctly.");
//                    setFieldsEnabled(true);
//                    currentlyValidating = false;
//                    credentialsPanel.invalidate();
//                }
//            } catch (Exception e) {
//                verifyCredentialsProgressBar.setVisible(false);
//                verifyCredentialsLabel.setText("An error occurred trying to verify your credentials.  Please try again.");
//                setFieldsEnabled(true);
//                currentlyValidating = false;
//                credentialsPanel.invalidate();
//            }
//        }
//    }
}
