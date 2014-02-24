package au.com.borner.salesforce.plugin.toolwindow;

import com.intellij.ui.treeStructure.SimpleNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A JSON Array Node which creates a child for each of the items in the array
 *
 * @author mark
 */
public class ExplorerJSONArrayNode extends AbstractExplorerNode {

    private final JSONArray jsonArray;

    public ExplorerJSONArrayNode(SimpleNode parent, JSONArray jsonArray, String name) {
        super(parent, name);
        this.jsonArray = jsonArray;
    }

    @Override
    public void retrieveChildren() {
        List<SimpleNode> children = new ArrayList<SimpleNode>(jsonArray.length());
        for (int i=0; i<jsonArray.length(); i++) {
            Object object = jsonArray.get(i);
            String name = getName().substring(0, getName().length()-1) + " " + i;
            SimpleNode child;
            if (object instanceof JSONArray) {
                child = new ExplorerJSONArrayNode(this, (JSONArray)object, name);
            } else if (object instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject)object;
                if (jsonObject.keySet().contains("name")) {
                    name = jsonObject.getString("name");
                }
                child = new ExplorerJSONObjectNode(this, (JSONObject)object, name);
            } else {
                child = new ExplorerLeafNode(this, name, object.toString());
            }
            children.add(child);
        }
        this.children = children.toArray(new SimpleNode[children.size()]);
    }

}
