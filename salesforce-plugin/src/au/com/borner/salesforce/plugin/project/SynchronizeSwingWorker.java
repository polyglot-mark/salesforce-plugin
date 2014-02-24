package au.com.borner.salesforce.plugin.project;

import au.com.borner.salesforce.client.rest.ToolingClient;
import au.com.borner.salesforce.client.rest.domain.*;
import au.com.borner.salesforce.plugin.util.FileUtilities;
import com.intellij.openapi.diagnostic.Logger;

import javax.swing.*;
import java.util.List;

/**
 * A Swing Worker which sucks down all the source code from Salesforce
 *
 * @author mark
 */
public class SynchronizeSwingWorker extends SwingWorker<Void, String> {

    protected final Logger logger = Logger.getInstance(getClass());
    protected final ToolingClient toolingClient;
    protected final JTextArea statusArea;
    protected final SalesForceWizardStateBean stateBean;
    protected final DoneCallBack callBack;

    public SynchronizeSwingWorker(ToolingClient toolingClient, JTextArea statusArea, SalesForceWizardStateBean stateBean, DoneCallBack callBack) {
        this.toolingClient = toolingClient;
        this.statusArea = statusArea;
        this.stateBean = stateBean;
        this.callBack = callBack;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Void doInBackground() throws Exception {
        publish("Starting synchronization\n");
        try {

            if (stateBean.isSyncClasses()) {
                publish("Synchronizing Apex Classes");
                QueryResult queryResult = toolingClient.getApexClasses();
                String folderPath = stateBean.getFolderPath(SalesForceWizardStateBean.FOLDER_NAMES.CLASSES);
                createClassFiles(queryResult.getEntities(QueryResult.RECORDS, ApexClass.class), folderPath);
                while (!isCancelled() && queryResult.getQueryLocator() != null) {
                    queryResult = toolingClient.executeQueryLocator(queryResult.getQueryLocator());
                    createClassFiles(queryResult.getEntities(QueryResult.RECORDS, ApexClass.class), folderPath);
                }
            }

            if (stateBean.isSyncTriggers()) {
                publish("Synchronizing Apex Triggers");
                QueryResult queryResult = toolingClient.getApexTriggers();
                String folderPath = stateBean.getFolderPath(SalesForceWizardStateBean.FOLDER_NAMES.TRIGGERS);
                createClassFiles(queryResult.getEntities(QueryResult.RECORDS, ApexTrigger.class), folderPath);
                while (!isCancelled() && queryResult.getQueryLocator() != null) {
                    queryResult = toolingClient.executeQueryLocator(queryResult.getQueryLocator());
                    createClassFiles(queryResult.getEntities(QueryResult.RECORDS, ApexTrigger.class), folderPath);
                }
            }

            if (stateBean.isSyncPages()) {
                publish("Synchronizing Visualforce Pages");
                QueryResult queryResult = toolingClient.getVisualForcePages();
                String folderPath = stateBean.getFolderPath(SalesForceWizardStateBean.FOLDER_NAMES.PAGES);
                createClassFiles(queryResult.getEntities(QueryResult.RECORDS, VisualForcePage.class), folderPath);
                while (!isCancelled() && queryResult.getQueryLocator() != null) {
                    queryResult = toolingClient.executeQueryLocator(queryResult.getQueryLocator());
                    createClassFiles(queryResult.getEntities(QueryResult.RECORDS, VisualForcePage.class), folderPath);
                }
            }

            if (stateBean.isSyncComponents()) {
                publish("Synchronizing Visualforce Components");
                QueryResult queryResult = toolingClient.getVisualForceComponent();
                String folderPath = stateBean.getFolderPath(SalesForceWizardStateBean.FOLDER_NAMES.COMPONENTS);
                createClassFiles(queryResult.getEntities(QueryResult.RECORDS, VisualForceComponent.class), folderPath);
                while (!isCancelled() && queryResult.getQueryLocator() != null) {
                    queryResult = toolingClient.executeQueryLocator(queryResult.getQueryLocator());
                    createClassFiles(queryResult.getEntities(QueryResult.RECORDS, VisualForceComponent.class), folderPath);
                }
            }


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
