package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTreeStructure;

/**
 * A simple tree structure for explorer trees
 *
 * @author mark
 */
public class ExplorerTreeStructure extends SimpleTreeStructure {

    private final SimpleNode rootNode;

    public ExplorerTreeStructure(SimpleNode rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public Object getRootElement() {
        return rootNode;
    }
}
