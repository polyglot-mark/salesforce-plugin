package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.ui.treeStructure.SimpleTreeBuilder;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * A Tree Expansion Listener which allows nodes to retrieve their children only
 * when they are expanded.  Otherwise, all children will be retrieved when the
 * Tree is displayed (and thus blowing your API limits!)
 *
 * @author mark
 */
public class ExplorerTreeExpansionListener implements TreeExpansionListener {

    private final SimpleTreeBuilder builder;

    public ExplorerTreeExpansionListener(SimpleTreeBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void treeExpanded(TreeExpansionEvent event) {
        if (event.getPath().getLastPathComponent() instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode)event.getPath().getLastPathComponent();
            if ((dmtn.getUserObject() instanceof AbstractExplorerNode)) {
                AbstractExplorerNode node = (AbstractExplorerNode)dmtn.getUserObject();
                boolean shouldUpdate = node.checkWhetherToRetrieveChildren();
                if (shouldUpdate) {
                    SwingWorker worker = new RetrieveChildrenSwingWorker(node, builder);
                    worker.execute();
                }
            }
        }
    }

    @Override
    public void treeCollapsed(TreeExpansionEvent event) {
        // do nothing
    }





    private class RetrieveChildrenSwingWorker extends SwingWorker<Void, Void> {

        private final AbstractExplorerNode node;
        private final SimpleTreeBuilder builder;

        private RetrieveChildrenSwingWorker(AbstractExplorerNode node, SimpleTreeBuilder builder) {
            this.node = node;
            this.builder = builder;
        }

        @Override
        protected Void doInBackground() throws Exception {
            node.retrieveChildren();
            return null;
        }

        @Override
        protected void done() {
            builder.updateFromRoot();
        }
    }
}
