package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.ui.treeStructure.SimpleNode;

/**
 * A generic error node which display a error message
 *
 * @author Mark Borner (gzhomzb)
 */
public class ExplorerErrorNode extends AbstractExplorerNode {

    public ExplorerErrorNode(SimpleNode parent, String message) {
        super(parent, message);
    }

    @Override
    public boolean isAlwaysLeaf() {
        return true;
    }

    @Override
    public SimpleNode[] getChildren() {
        return SimpleNode.NO_CHILDREN;
    }

    @Override
    public void retrieveChildren() {
        // nothing to do here - this node is always a leaf node
    }
}
