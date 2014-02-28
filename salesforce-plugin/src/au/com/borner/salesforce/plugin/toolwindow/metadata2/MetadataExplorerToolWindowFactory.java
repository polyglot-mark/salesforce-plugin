package au.com.borner.salesforce.plugin.toolwindow.metadata2;

import au.com.borner.salesforce.plugin.service.RestClientService;
import au.com.borner.salesforce.plugin.service.ToolingRestClientService;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerCellRenderer;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerCollapseAllAction;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerTreeExpansionListener;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerTreeStructure;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.ui.treeStructure.SimpleTreeBuilder;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

/**
 * A Tool Window for browsing Salesforce metadata
 *
 * @author mark
 */
public class MetadataExplorerToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        JTabbedPane tabbedPane = new JTabbedPane();
        final Content content = ContentFactory.SERVICE.getInstance().createContent(tabbedPane, "", false);
        toolWindow.getContentManager().addContent(content);

        SimpleToolWindowPanel metadataPanel = new SimpleToolWindowPanel(true, true);
        setupMetadataPanel(project, metadataPanel);
        tabbedPane.add("Metadata", metadataPanel);

        SimpleToolWindowPanel toolingMetadataPanel = new SimpleToolWindowPanel(true, true);
        setupToolingMetadataPanel(project, toolingMetadataPanel);
        tabbedPane.add("Tooling Metadata", toolingMetadataPanel);
    }

    private void setupMetadataPanel(Project project, SimpleToolWindowPanel metadataPanel) {
        RestClientService restClientService = ServiceManager.getService(project, RestClientService.class);
        SimpleNode metadataRootNode = new MetadataExplorerRootNode(project, restClientService, "Metadata");

        SimpleTree metadataTree = new SimpleTree();
        SimpleTreeBuilder metadataTreeBuilder = new SimpleTreeBuilder(metadataTree, (DefaultTreeModel)metadataTree.getModel(), new ExplorerTreeStructure(metadataRootNode), null);
        Disposer.register(project, metadataTreeBuilder);
        metadataTree.addTreeExpansionListener(new ExplorerTreeExpansionListener(metadataTreeBuilder));
        metadataTree.setCellRenderer(new ExplorerCellRenderer());

        ActionToolbar toolbar = createToolbar(metadataRootNode, metadataTreeBuilder);
        toolbar.setTargetComponent(metadataPanel);
        metadataPanel.setToolbar(toolbar.getComponent());
        metadataPanel.setContent(ScrollPaneFactory.createScrollPane(metadataTree));

        metadataTree.setShowsRootHandles(true);

    }

    private void setupToolingMetadataPanel(Project project, SimpleToolWindowPanel toolingMetadataPanel) {
        ToolingRestClientService toolingRestClientService = ServiceManager.getService(project, ToolingRestClientService.class);
        SimpleNode toolingMetadataRootNode = new MetadataExplorerRootNode(project, toolingRestClientService, " Tooling Metadata");

        SimpleTree toolingMetadataTree = new SimpleTree();
        SimpleTreeBuilder toolingMetadataTreeBuilder = new SimpleTreeBuilder(toolingMetadataTree, (DefaultTreeModel)toolingMetadataTree.getModel(), new ExplorerTreeStructure(toolingMetadataRootNode), null);
        Disposer.register(project, toolingMetadataTreeBuilder);
        toolingMetadataTree.addTreeExpansionListener(new ExplorerTreeExpansionListener(toolingMetadataTreeBuilder));
        toolingMetadataTree.setCellRenderer(new ExplorerCellRenderer());

        ActionToolbar toolbar = createToolbar(toolingMetadataRootNode, toolingMetadataTreeBuilder);
        toolbar.setTargetComponent(toolingMetadataPanel);
        toolingMetadataPanel.setToolbar(toolbar.getComponent());
        toolingMetadataPanel.setContent(ScrollPaneFactory.createScrollPane(toolingMetadataTree));

        toolingMetadataTree.setShowsRootHandles(true);

    }

    private ActionToolbar createToolbar(SimpleNode rootNode, SimpleTreeBuilder builder) {
        DefaultActionGroup group = new DefaultActionGroup();
        group.add(new ExplorerCollapseAllAction(rootNode, builder));
        return ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, true);
    }

}
