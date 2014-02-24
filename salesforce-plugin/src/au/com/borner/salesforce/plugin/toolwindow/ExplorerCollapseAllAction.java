package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTreeBuilder;

/**
 * @author mark
 */
public class ExplorerCollapseAllAction extends DumbAwareAction {

    private final SimpleNode rootNode;
    private final SimpleTreeBuilder builder;

    public ExplorerCollapseAllAction(SimpleNode rootNode, SimpleTreeBuilder builder) {
        super("Collapse All", "Collapse all nodes", AllIcons.Actions.Collapseall);
        this.rootNode = rootNode;
        this.builder = builder;
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        builder.collapseChildren(rootNode, null);
    }

}
