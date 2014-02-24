package au.com.borner.salesforce.plugin.toolwindow.data;


import com.intellij.icons.AllIcons;
import com.intellij.ide.actions.RefreshAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.ui.table.JBTable;

/**
 * @author mark
 */
public class DataExplorerRefreshAction extends RefreshAction {

    private final JBTable table;

    public DataExplorerRefreshAction(JBTable table) {
        super("Refresh", "Refresh the data", AllIcons.Actions.Refresh);
        this.table = table;
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        DataExplorerTableModel model = (DataExplorerTableModel)table.getModel();
        model.refresh();
    }

    @Override
    public void update(AnActionEvent e) {
        // need to over super's method so the action is enabled
    }

}
