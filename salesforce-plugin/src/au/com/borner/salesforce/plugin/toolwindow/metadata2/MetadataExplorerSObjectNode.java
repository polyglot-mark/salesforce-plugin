package au.com.borner.salesforce.plugin.toolwindow.metadata2;

import au.com.borner.salesforce.client.rest.AbstractRestClient;
import au.com.borner.salesforce.client.rest.domain.BasicDescribeResult;
import au.com.borner.salesforce.client.rest.domain.DescribeResult;
import au.com.borner.salesforce.plugin.toolwindow.AbstractExplorerNode;
import au.com.borner.salesforce.plugin.toolwindow.ExplorerErrorNode;
import com.intellij.ui.treeStructure.SimpleNode;

/**
 * @author mark
 */
public class MetadataExplorerSObjectNode extends AbstractExplorerNode {

    private static final String ERROR_MESSAGE = "Error retrieving sObject description for ";

    private final BasicDescribeResult sObjectDescription;
    private final String versionUrl;

    public MetadataExplorerSObjectNode(SimpleNode parent, AbstractRestClient apiClient, BasicDescribeResult sObjectDescription, String versionUrl) {
        super(parent, apiClient, sObjectDescription.getLabel());
        this.sObjectDescription = sObjectDescription;
        this.versionUrl = versionUrl;
    }

    @Override
    public void retrieveChildren() {
        retrievingChildren = true;

        DescribeResult describeResult;
        try {
            describeResult = client.describeObject(versionUrl, sObjectDescription.getName());
        } catch (Exception e) {
            logger.error(ERROR_MESSAGE + getName(), e);
            describeResult = null;
        }

        if (describeResult == null) {
            this.children = new SimpleNode[] { new ExplorerErrorNode(this, ERROR_MESSAGE + getName()) };
        } else {
            this.children = getChildrenFromJSONObject(describeResult);
        }
        retrievingChildren = false;
    }

}
