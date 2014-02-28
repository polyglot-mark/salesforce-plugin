package au.com.borner.salesforce.plugin.project;

import au.com.borner.salesforce.client.rest.ConnectionManager;
import au.com.borner.salesforce.client.rest.ToolingRestClient;
import au.com.borner.salesforce.client.rest.domain.*;
import au.com.borner.salesforce.client.wsc.SoapClient;
import au.com.borner.salesforce.util.FileUtilities;

import javax.swing.*;
import java.util.List;

/**
 * A Swing Worker which sucks down all the source code from Salesforce
 *
 * @author mark
 */
public class SynchronizeSwingWorker extends SwingWorker<Void, String> {

    protected final JTextArea statusArea;
    protected final SalesForceWizardStateBean stateBean;
    protected final DoneCallBack callBack;

    public SynchronizeSwingWorker(JTextArea statusArea, SalesForceWizardStateBean stateBean, DoneCallBack callBack) {
        this.statusArea = statusArea;
        this.stateBean = stateBean;
        this.callBack = callBack;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Void doInBackground() throws Exception {
        try {
            publish("Logging into Salesforce\n");
            SoapClient soapClient = new SoapClient();
            soapClient.login(stateBean.getInstanceCredentials(), true);
            ConnectionManager connectionManager = new ConnectionManager();
            connectionManager.setSessionDetails(soapClient.getSessionId(), soapClient.getServiceHost());
            ToolingRestClient toolingRestClient = new ToolingRestClient(connectionManager);

            if (stateBean.isSyncClasses()) {
                publish("Synchronizing Apex Classes");
                QueryResult queryResult = toolingRestClient.getApexClasses();
                String folderPath = stateBean.getFolderPath(SalesForceWizardStateBean.FOLDER_NAMES.CLASSES);
                createClassFiles(queryResult.getEntities(QueryResult.RECORDS, ApexClass.class), folderPath);
                while (!isCancelled() && queryResult.getQueryLocator() != null) {
                    queryResult = toolingRestClient.executeQueryLocator(queryResult.getQueryLocator());
                    createClassFiles(queryResult.getEntities(QueryResult.RECORDS, ApexClass.class), folderPath);
                }
            }

            if (stateBean.isSyncTriggers()) {
                publish("Synchronizing Apex Triggers");
                QueryResult queryResult = toolingRestClient.getApexTriggers();
                String folderPath = stateBean.getFolderPath(SalesForceWizardStateBean.FOLDER_NAMES.TRIGGERS);
                createClassFiles(queryResult.getEntities(QueryResult.RECORDS, ApexTrigger.class), folderPath);
                while (!isCancelled() && queryResult.getQueryLocator() != null) {
                    queryResult = toolingRestClient.executeQueryLocator(queryResult.getQueryLocator());
                    createClassFiles(queryResult.getEntities(QueryResult.RECORDS, ApexTrigger.class), folderPath);
                }
            }

            if (stateBean.isSyncPages()) {
                publish("Synchronizing Visualforce Pages");
                QueryResult queryResult = toolingRestClient.getVisualForcePages();
                String folderPath = stateBean.getFolderPath(SalesForceWizardStateBean.FOLDER_NAMES.PAGES);
                createClassFiles(queryResult.getEntities(QueryResult.RECORDS, VisualForcePage.class), folderPath);
                while (!isCancelled() && queryResult.getQueryLocator() != null) {
                    queryResult = toolingRestClient.executeQueryLocator(queryResult.getQueryLocator());
                    createClassFiles(queryResult.getEntities(QueryResult.RECORDS, VisualForcePage.class), folderPath);
                }
            }

            if (stateBean.isSyncComponents()) {
                publish("Synchronizing Visualforce Components");
                QueryResult queryResult = toolingRestClient.getVisualForceComponent();
                String folderPath = stateBean.getFolderPath(SalesForceWizardStateBean.FOLDER_NAMES.COMPONENTS);
                createClassFiles(queryResult.getEntities(QueryResult.RECORDS, VisualForceComponent.class), folderPath);
                while (!isCancelled() && queryResult.getQueryLocator() != null) {
                    queryResult = toolingRestClient.executeQueryLocator(queryResult.getQueryLocator());
                    createClassFiles(queryResult.getEntities(QueryResult.RECORDS, VisualForceComponent.class), folderPath);
                }
            }

            publish("Logging out of Salesforce\n");
            soapClient.logoff();

            return null;
        } catch (Exception e) {
            publish("\tERROR occurred" + e.getMessage());
            return null;
        }
    }

    @Override
    protected void process(List<String> chunks) {
        for (String message : chunks) {
            statusArea.append(message + "\n");
        }
    }

    @Override
    protected void done() {
        statusArea.append("Finished synchronizing");
        callBack.done();
    }

    protected void createClassFiles(List sources, String folderPath) {
        for (Object object : sources) {
            AbstractSourceCode source = (AbstractSourceCode)object;
            boolean successful = FileUtilities.createLocalFile(folderPath, source);
            if (successful) {
                publish("\tCreated " + source.getFullyQualifiedFileName(source.getName()));
            } else {
                publish("\tERROR creating " + source.getFullyQualifiedFileName(source.getName()));
            }
        }
    }

    public interface DoneCallBack {

        public void done();

    }
}
