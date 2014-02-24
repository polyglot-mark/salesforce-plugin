package au.com.borner.salesforce.plugin.toolwindow;

import au.com.borner.salesforce.client.rest.AbstractRestClient;
import au.com.borner.salesforce.client.rest.domain.APIVersionResult;
import au.com.borner.salesforce.plugin.service.VersionsService;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.ui.treeStructure.SimpleNode;

import java.util.List;

/**
 * An abstract root node
 *
 * @author mark
 */
public abstract class AbstractExplorerRootNode extends AbstractExplorerNode {

    private static final String ERROR_MESSAGE = "Error retrieving API versions";
    private final VersionsService versionsService;

    public AbstractExplorerRootNode(Project project, AbstractRestClient client, String name) {
        super(project, client, name);
        this.versionsService = ServiceManager.getService(project, VersionsService.class);
    }

    @Override
    public boolean isAutoExpandNode() {
        return true;
    }

    @Override
    public void retrieveChildren() {
        retrievingChildren = true;

        List<APIVersionResult> apiVersions = versionsService.getApiVersions();

        if (apiVersions == null) {
            this.children = new SimpleNode[] { new ExplorerErrorNode(this, ERROR_MESSAGE) };
        } else {
            List<AbstractExplorerNode> children = getVersionNodes(apiVersions);
            this.children = children.toArray(new SimpleNode[apiVersions.size()]);
        }
        retrievingChildren = false;
    }

    protected abstract List<AbstractExplorerNode> getVersionNodes(List<APIVersionResult> apiVersions);
}
