package au.com.borner.salesforce.plugin.toolwindow.data;

import au.com.borner.salesforce.plugin.toolwindow.AbstractExplorerNode;
import com.intellij.ui.table.JBTable;
import com.intellij.ui.treeStructure.SimpleTree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A mouse listener which responds when the user clicks the sObject in the tree
 * and creates a new table model for the table
 *
 * @author mark
 */
public class DataExplorerMouseListener extends MouseAdapter {

    private final JBTable table;
    private final SimpleTree tree;

    public DataExplorerMouseListener(JBTable table, SimpleTree tree) {
        this.table = table;
        this.tree = tree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        TreePath path = tree.getPathForLocation(e.getX(), e.getY());
        if (path == null) return;
        tree.setSelectionPath(path);
        DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) path.getLastPathComponent();
        if ((dmtn.getUserObject() instanceof AbstractExplorerNode)) {
            AbstractExplorerNode node = (AbstractExplorerNode) dmtn.getUserObject();
            if (node instanceof DataExplorerSObjectNode) {
                DataExplorerSObjectNode sObjectNode = (DataExplorerSObjectNode) node;
                DataExplorerTableModel model = new DataExplorerTableModel(table, sObjectNode.getAPIClient(), sObjectNode.getVersionUrl(), sObjectNode.getSObjectName());
                table.setModel(model);
            }
        }
    }
}
