package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.ui.treeStructure.SimpleNode;
import org.json.JSONObject;

/**
 * A JSON Object Node which creates a child for each of its elements
 *
 * @author mark
 */
public class ExplorerJSONObjectNode extends AbstractExplorerNode {

    private final JSONObject jsonObject;

    public ExplorerJSONObjectNode(SimpleNode parent, JSONObject jsonObject, String name) {
        super(parent, name);
        this.jsonObject = jsonObject;
    }

    @Override
    public void retrieveChildren() {
        this.children = getChildrenFromJSONObject(jsonObject);
    }

}
