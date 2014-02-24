package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.icons.AllIcons;
import com.intellij.ui.treeStructure.SimpleNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * @author Mark Borner (gzhomzb)
 */
public class ExplorerCellRenderer extends DefaultTreeCellRenderer {

    public ExplorerCellRenderer() {
        setLeafIcon(AllIcons.Nodes.Property);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode)value;
        if (dmtn.getUserObject() instanceof SimpleNode) {
            SimpleNode node = (SimpleNode)dmtn.getUserObject();
            if (node instanceof ExplorerLoadingNode) {
                setIcon(null);
            }
        }
        return this;
    }
}
