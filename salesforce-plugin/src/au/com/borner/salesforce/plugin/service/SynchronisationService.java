package au.com.borner.salesforce.plugin.service;

import au.com.borner.salesforce.plugin.vfs.FileEventsListener;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFileManager;
import org.jetbrains.annotations.NotNull;

/**
 * @author mark
 */
public class SynchronisationService implements ProjectComponent {

    private static Logger logger = Logger.getInstance(SynchronisationService.class);
    private final FileEventsListener fileEventsListener;
    private final Project project;
    private final ClientFactoryService clientFactoryService;

    public SynchronisationService(Project project, ClientFactoryService clientFactoryService) {
        this.project = project;
        this.clientFactoryService = clientFactoryService;
        fileEventsListener = new FileEventsListener(project);
    }

    @Override
    public void projectOpened() {
        // nothing for right now....
    }

    @Override
    public void projectClosed() {
        // nothing for right now
    }

    @Override
    public void initComponent() {
        VirtualFileManager.getInstance().addVirtualFileListener(fileEventsListener);
    }

    @Override
    public void disposeComponent() {
        VirtualFileManager.getInstance().removeVirtualFileListener(fileEventsListener);
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "Synchronization Service";
    }

}
