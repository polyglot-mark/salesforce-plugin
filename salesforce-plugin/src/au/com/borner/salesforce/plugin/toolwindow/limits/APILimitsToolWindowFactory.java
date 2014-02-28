package au.com.borner.salesforce.plugin.toolwindow.limits;

import au.com.borner.salesforce.client.rest.domain.LimitResult;
import au.com.borner.salesforce.client.rest.domain.LimitsResult;
import au.com.borner.salesforce.plugin.service.RestClientService;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;
import java.util.Map;

/**
 * @author mark
 */
public class APILimitsToolWindowFactory implements ToolWindowFactory {

    private JLabel apiRequestsMax;
    private JLabel apiRequestsRemaining;
    private JLabel apexExecutionsMax;
    private JLabel apexExecutionsRemaining;
    private JLabel bulkApiRequestsMax;
    private JLabel bulkApiRequestsRemaining;
    private JLabel streamingApiRequestsMax;
    private JLabel streamingApiRequestsRemaining;
    private JLabel streamingApiClientsMax;
    private JLabel streamingApiClientsRemaining;
    private JPanel limitsPanel;

    @Override
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        RestClientService restClientService = ServiceManager.getService(project, RestClientService.class);
        Map<LimitsResult.LimitType, LimitResult> limits = restClientService.getLimits();
        LimitResult limitResult = limits.get(LimitsResult.LimitType.DailyApiRequests);
        apiRequestsMax.setText(String.format("%d", limitResult.getMax()));
        apiRequestsRemaining.setText(String.format("%d", limitResult.getRemaining()));
        limitResult = limits.get(LimitsResult.LimitType.DailyAsyncApexExecutions);
        apexExecutionsMax.setText(String.format("%d", limitResult.getMax()));
        apexExecutionsRemaining.setText(String.format("%d", limitResult.getRemaining()));
        limitResult = limits.get(LimitsResult.LimitType.DailyBulkApiRequests);
        bulkApiRequestsMax.setText(String.format("%d", limitResult.getMax()));
        bulkApiRequestsRemaining.setText(String.format("%d", limitResult.getRemaining()));

        limitResult = limits.get(LimitsResult.LimitType.StreamingApiConcurrentClients);
        streamingApiClientsMax.setText(String.format("%d", limitResult.getMax()));
        streamingApiClientsRemaining.setText(String.format("%d", limitResult.getRemaining()));

        final SimpleToolWindowPanel panel = new SimpleToolWindowPanel(true, true);
        final Content content = ContentFactory.SERVICE.getInstance().createContent(panel, "", false);
        toolWindow.getContentManager().addContent(content);

        panel.setContent(limitsPanel);
    }
}
