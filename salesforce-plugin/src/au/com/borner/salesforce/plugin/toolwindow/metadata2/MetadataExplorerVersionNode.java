package au.com.borner.salesforce.plugin.toolwindow.metadata2;

import au.com.borner.salesforce.client.rest.AbstractRestClient;
import au.com.borner.salesforce.client.rest.domain.APIVersionResult;
import au.com.borner.salesforce.client.rest.domain.BasicDescribeResult;
import au.com.borner.salesforce.plugin.toolwindow.AbstractExplorerNode;
import au.com.borner.salesforce.plugin.toolwindow.AbstractExplorerVersionNode;
import com.intellij.ui.treeStructure.SimpleNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
public class MetadataExplorerVersionNode extends AbstractExplorerVersionNode {

    public MetadataExplorerVersionNode(SimpleNode parent, AbstractRestClient client, APIVersionResult apiVersionResult) {
        super(parent, client, apiVersionResult);
    }

    @Override
    protected List<AbstractExplorerNode> getSObjectNodes(List<BasicDescribeResult> sObjectDescriptions, APIVersionResult apiVersionResult) {
        List<AbstractExplorerNode> result = new ArrayList<AbstractExplorerNode>(sObjectDescriptions.size());
        for (BasicDescribeResult sObjectDescription : sObjectDescriptions) {
            MetadataExplorerSObjectNode child = new MetadataExplorerSObjectNode(this, client, sObjectDescription, apiVersionResult.getUrl());
            result.add(child);
        }
        return result;
    }
}
