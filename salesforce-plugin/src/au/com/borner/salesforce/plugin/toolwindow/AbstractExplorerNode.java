package au.com.borner.salesforce.plugin.toolwindow;

import au.com.borner.salesforce.client.rest.AbstractRestClient;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.ui.treeStructure.SimpleNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mark Borner (gzhomzb)
 */
public abstract class AbstractExplorerNode extends SimpleNode {

    protected Logger logger = Logger.getInstance(getClass());

    private final String name;
    protected final AbstractRestClient client;
    protected final SimpleNode[] loadingNode = { new ExplorerLoadingNode(this) };
    protected SimpleNode[] children = loadingNode;
    protected volatile boolean retrievingChildren = false;

    /**
     * Constructor used for root node
     *
     * @param project The Project
     * @param name The name of the root node
     */
    public AbstractExplorerNode(Project project, AbstractRestClient client, String name) {
        super(project);
        this.name = name;
        this.client = client;
    }

    /**
     * Constructor used for child nodes that don't need an API client
     *
     * @param parent The parent node
     * @param name The name of the child node
     */
    public AbstractExplorerNode(SimpleNode parent, String name) {
        this(parent, null, name);
    }

    /**
     * Constructor used for child nodes
     *
     * @param parent The parent node
     * @param client The API client
     * @param name The name of the child node
     */
    public AbstractExplorerNode(SimpleNode parent, AbstractRestClient client, String name) {
        super(parent);
        this.client = client;
        this.name = name;
    }

    @Override
    public SimpleNode[] getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean checkWhetherToRetrieveChildren() {
        return children == loadingNode && !retrievingChildren;
    }

    public abstract void retrieveChildren();

    protected SimpleNode[] getChildrenFromJSONObject(JSONObject jsonObject) {

        List<SimpleNode> children = new ArrayList<SimpleNode>(jsonObject.keySet().size());
        Iterator iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            String name = (String)iterator.next();
            Object object = jsonObject.get(name);
            SimpleNode child;
            if (object instanceof JSONArray) {
                child = new ExplorerJSONArrayNode(this, (JSONArray)object, name);
            } else if (object instanceof JSONObject) {
                child = new ExplorerJSONObjectNode(this, (JSONObject)object, name);
            } else {
                child = new ExplorerLeafNode(this, name, object.toString());
            }
            children.add(child);
        }
        return children.toArray(new SimpleNode[children.size()]);

    }

}
