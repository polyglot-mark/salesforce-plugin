package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.ui.treeStructure.SimpleNode;

/**
 * An Explorer leaf node (leaf nodes have no children)
 *
 * @author mark
 */
public class ExplorerLeafNode extends AbstractExplorerNode {

    public ExplorerLeafNode(SimpleNode parent, String name, String value) {
        super(parent, name + " -> " + value);
    }

    @Override
    public boolean isAlwaysLeaf() {
        return true;
    }

    @Override
    public void retrieveChildren() {
        children = SimpleNode.NO_CHILDREN;
    }

}
