package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.ui.treeStructure.SimpleNode;

/**
 * A placeholder node which displays a "Loading...." message
 *
 * Note: this class cannot extend AbstractExplorerNode, otherwise an infinite
 * loop could happen with the constructors!
 *
 * @author Mark Borner (gzhomzb)
 */
public class ExplorerLoadingNode extends SimpleNode {

    public ExplorerLoadingNode(SimpleNode parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return "Loading.....";
    }

    @Override
    public SimpleNode[] getChildren() {
        return SimpleNode.NO_CHILDREN;
    }
}
