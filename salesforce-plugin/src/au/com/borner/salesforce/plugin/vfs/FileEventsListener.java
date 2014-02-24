package au.com.borner.salesforce.plugin.vfs;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.*;

/**
 *
 * Note: Note that the VFS listeners are application-level, and will receive events for changes happening in
 * all the projects opened by the user. You may need to filter out events which aren't relevant to your task.
 * @author mark
 */
public class FileEventsListener implements VirtualFileListener {

    private Logger logger = Logger.getInstance(getClass());
    private final Project project;

    public FileEventsListener(Project project) {
        this.project = project;
    }

    @Override
    public void propertyChanged(VirtualFilePropertyEvent event) {
    }

    @Override
    public void contentsChanged(VirtualFileEvent event) {
    }

    @Override
    public void fileCreated(VirtualFileEvent event) {
    }

    @Override
    public void fileDeleted(VirtualFileEvent event) {
        // TODO: delete sfmd file (if it exists)
    }

    @Override
    public void fileMoved(VirtualFileMoveEvent event) {
    }

    @Override
    public void fileCopied(VirtualFileCopyEvent event) {
    }

    @Override
    public void beforePropertyChange(VirtualFilePropertyEvent event) {
    }

    @Override
    public void beforeContentsChange(VirtualFileEvent event) {
    }

    @Override
    public void beforeFileDeletion(VirtualFileEvent event) {
    }

    @Override
    public void beforeFileMovement(VirtualFileMoveEvent event) {
    }
}
