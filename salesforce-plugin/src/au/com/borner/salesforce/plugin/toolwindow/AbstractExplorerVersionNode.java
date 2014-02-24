package au.com.borner.salesforce.plugin.toolwindow;

import au.com.borner.salesforce.client.rest.AbstractRestClient;
import au.com.borner.salesforce.client.rest.domain.APIVersionResult;
import au.com.borner.salesforce.client.rest.domain.BasicDescribeResult;
import com.intellij.ui.treeStructure.SimpleNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * An abstract node for Version nodes
 *
 * @author mark
 */
public abstract class AbstractExplorerVersionNode extends AbstractExplorerNode {

    private static final String ERROR_MESSAGE = "Error retrieving descriptions";

    private final APIVersionResult apiVersionResult;

    public AbstractExplorerVersionNode(SimpleNode parent, AbstractRestClient apiClient, APIVersionResult apiVersionResult) {
        super(parent, apiClient, apiVersionResult.getLabel() + " (" + apiVersionResult.getAPIVersion() + ")");
        this.apiVersionResult = apiVersionResult;
    }

    @Override
    public void retrieveChildren() {
        retrievingChildren = true;

        List<AbstractExplorerNode> children = new ArrayList<AbstractExplorerNode>();
        List<BasicDescribeResult> sObjectDescriptions;
        try {
            sObjectDescriptions = client.describeAllObjects(apiVersionResult.getUrl());
        } catch (Exception e) {
            logger.error(ERROR_MESSAGE, e);
            sObjectDescriptions = null;
        }

        if (sObjectDescriptions == null) {
            children.add(new ExplorerErrorNode(this, ERROR_MESSAGE));
        } else {
            children.addAll(getSObjectNodes(sObjectDescriptions, apiVersionResult));
        }

        Collections.sort(children, new Comparator<SimpleNode>() {
            @Override
            public int compare(SimpleNode o1, SimpleNode o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        this.children = children.toArray(new SimpleNode[children.size()]);
        retrievingChildren = false;
    }

    protected abstract List<AbstractExplorerNode> getSObjectNodes(List<BasicDescribeResult> sObjectDescriptions, APIVersionResult apiVersionResult);
}
