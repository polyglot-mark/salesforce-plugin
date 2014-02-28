package au.com.borner.salesforce.plugin.toolwindow.data;

import au.com.borner.salesforce.plugin.service.RestClientService;
import au.com.borner.salesforce.plugin.service.ToolingRestClientService;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerCellRenderer;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerCollapseAllAction;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerTreeExpansionListener;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerTreeStructure;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.table.JBTable;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.ui.treeStructure.SimpleTreeBuilder;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

/**
 * A Tool Window for exploring Salesforce data
 *
 * @author mark
 */
public class DataExplorerToolWindowFactory implements ToolWindowFactory {

    private JPanel dataExplorerPanel;
    private JSplitPane dataSplitPane;
    private JSplitPane toolingDataSplitPane;

    @Override
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {

        SimpleToolWindowPanel panel = new SimpleToolWindowPanel(true, true);
        Content content = ContentFactory.SERVICE.getInstance().createContent(panel, "", false);
        toolWindow.getContentManager().addContent(content);
        panel.setContent(dataExplorerPanel);

        setupDataSplitPane(project);
        setupToolingDataSplitPane(project);

    }

    private void setupDataSplitPane(Project project) {
        RestClientService restClientService = ServiceManager.getService(project, RestClientService.class);
        SimpleNode dataRootNode = new DataExplorerRootNode(project, restClientService, "sObjects");

        SimpleTree dataTree = new SimpleTree();
        dataTree.setShowsRootHandles(true);
        SimpleTreeBuilder dataTreeBuilder = new SimpleTreeBuilder(dataTree, (DefaultTreeModel) dataTree.getModel(), new ExplorerTreeStructure(dataRootNode), null);
        Disposer.register(project, dataTreeBuilder);
        dataTree.addTreeExpansionListener(new ExplorerTreeExpansionListener(dataTreeBuilder));
        dataTree.setCellRenderer(new ExplorerCellRenderer());
        JBTable dataTable = new JBTable();
        dataTable.setStriped(true);
        dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Setup left panel which will display all the available sObjects
        SimpleToolWindowPanel treePanel = new SimpleToolWindowPanel(true, true);
        ActionToolbar treeToolbar = createTreeToolbar(dataRootNode, dataTreeBuilder);
        treeToolbar.setTargetComponent(treePanel);
        treePanel.setToolbar(treeToolbar.getComponent());
        treePanel.setContent(ScrollPaneFactory.createScrollPane(dataTree));
        dataSplitPane.add(treePanel, JSplitPane.LEFT);

        // Setup right panel which will display the data in the selected sObject
        SimpleToolWindowPanel dataPanel = new SimpleToolWindowPanel(true, true);
        ActionToolbar dataToolbar = createDataToolbar(dataTable);
        dataToolbar.setTargetComponent(dataPanel);
        dataPanel.setToolbar(dataToolbar.getComponent());
        dataPanel.setContent(ScrollPaneFactory.createScrollPane(dataTable));
        dataSplitPane.add(dataPanel, JSplitPane.RIGHT);

        dataSplitPane.getLeftComponent().setPreferredSize(new Dimension(250, 0));
        dataSplitPane.getRightComponent().setPreferredSize(new Dimension(0, 0));

        dataTree.addMouseListener(new DataExplorerMouseListener(dataTable, dataTree));

    }

    private void setupToolingDataSplitPane(Project project) {
        ToolingRestClientService toolingRestClientService = ServiceManager.getService(project, ToolingRestClientService.class);
        SimpleNode toolingDataRootNode = new DataExplorerRootNode(project, toolingRestClientService, "Tooling sObjects");

        SimpleTree toolingDataTree = new SimpleTree();
        toolingDataTree.setShowsRootHandles(true);
        SimpleTreeBuilder toolingDataTreeBuilder = new SimpleTreeBuilder(toolingDataTree, (DefaultTreeModel) toolingDataTree.getModel(), new ExplorerTreeStructure(toolingDataRootNode), null);
        Disposer.register(project, toolingDataTreeBuilder);
        toolingDataTree.addTreeExpansionListener(new ExplorerTreeExpansionListener(toolingDataTreeBuilder));
        toolingDataTree.setCellRenderer(new ExplorerCellRenderer());
        JBTable toolingDataTable = new JBTable();
        toolingDataTable.setStriped(true);
        toolingDataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Setup left panel which will display all the available sObjects
        SimpleToolWindowPanel treePanel = new SimpleToolWindowPanel(true, true);
        ActionToolbar treeToolbar = createTreeToolbar(toolingDataRootNode, toolingDataTreeBuilder);
        treeToolbar.setTargetComponent(treePanel);
        treePanel.setToolbar(treeToolbar.getComponent());
        treePanel.setContent(ScrollPaneFactory.createScrollPane(toolingDataTree));
        toolingDataSplitPane.add(treePanel, JSplitPane.LEFT);

        // Setup right panel which will display the data in the selected sObject
        SimpleToolWindowPanel dataPanel = new SimpleToolWindowPanel(true, true);
        ActionToolbar dataToolbar = createDataToolbar(toolingDataTable);
        dataToolbar.setTargetComponent(dataPanel);
        dataPanel.setToolbar(dataToolbar.getComponent());
        dataPanel.setContent(ScrollPaneFactory.createScrollPane(toolingDataTable));
        toolingDataSplitPane.add(dataPanel, JSplitPane.RIGHT);

        toolingDataSplitPane.getLeftComponent().setPreferredSize(new Dimension(250, 0));
        toolingDataSplitPane.getRightComponent().setPreferredSize(new Dimension(0, 0));

        toolingDataTree.addMouseListener(new DataExplorerMouseListener(toolingDataTable, toolingDataTree));
    }

    private ActionToolbar createTreeToolbar(SimpleNode rootNode, SimpleTreeBuilder builder) {
        DefaultActionGroup group = new DefaultActionGroup();
        group.add(new ExplorerCollapseAllAction(rootNode, builder));
        return ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, true);
    }

    private ActionToolbar createDataToolbar(JBTable table) {
        DefaultActionGroup group = new DefaultActionGroup();
        group.add(new DataExplorerRefreshAction(table));
        return ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, true);
    }

}
