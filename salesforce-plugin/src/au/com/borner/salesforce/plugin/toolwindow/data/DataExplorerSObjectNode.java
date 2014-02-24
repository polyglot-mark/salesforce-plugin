package au.com.borner.salesforce.plugin.toolwindow.data;

import au.com.borner.salesforce.client.rest.AbstractRestClient;
import au.com.borner.salesforce.client.rest.domain.BasicDescribeResult;
import au.com.borner.salesforce.plugin.toolwindow.AbstractExplorerNode;
import com.intellij.ui.treeStructure.SimpleNode;

/**
 * A data explorer sObject node (which is always a leaf node)
 *
 * @author mark
 */
public class DataExplorerSObjectNode extends AbstractExplorerNode {

    private final BasicDescribeResult sObjectDescription;
    private final String versionUrl;

    public DataExplorerSObjectNode(SimpleNode parent, AbstractRestClient client, BasicDescribeResult sObjectDescription, String versionUrl) {
        super(parent, client, sObjectDescription.getLabel());
        this.sObjectDescription = sObjectDescription;
        this.versionUrl = versionUrl;
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
        // nothing to do
    }

    public AbstractRestClient getAPIClient() {
        return client;
    }

    public String getVersionUrl() {
        return versionUrl;
    }

    public String getSObjectName() {
        return sObjectDescription.getName();
    }

}
