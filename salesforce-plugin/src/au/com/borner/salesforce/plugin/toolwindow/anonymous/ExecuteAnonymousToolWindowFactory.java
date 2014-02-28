package au.com.borner.salesforce.plugin.toolwindow.anonymous;

import au.com.borner.salesforce.client.rest.domain.ExecuteAnonymousResult;
import au.com.borner.salesforce.plugin.service.ToolingRestClientService;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Tool Window for executing anonymous Apex
 *
 * @author mark
 */
public class ExecuteAnonymousToolWindowFactory implements ToolWindowFactory {

    private JButton executeButton;
    private JTextArea inputTextArea;
    private JTextArea resultTextArea;
    private JPanel executeAnonymousPanel;

    private ToolingRestClientService toolingRestClientService;

    @Override
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {

        toolingRestClientService = ServiceManager.getService(project, ToolingRestClientService.class);

        SimpleToolWindowPanel panel = new SimpleToolWindowPanel(true, true);
        Content content = ContentFactory.SERVICE.getInstance().createContent(panel, "", false);
        toolWindow.getContentManager().addContent(content);

        panel.setContent(executeAnonymousPanel);

        resultTextArea.setEnabled(true);
        resultTextArea.setEditable(false);
        executeButton.setEnabled(false);
        inputTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkLength(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkLength(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkLength(e);
            }

            private void checkLength(DocumentEvent e) {
                if (e.getDocument().getLength() == 0) {
                    executeButton.setEnabled(false);
                } else {
                    executeButton.setEnabled(true);
                }
            }
        });
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputTextArea.getText().length() == 0) {
                    // error
                } else {
                    ExecuteAnonymousResult result = toolingRestClientService.executeAnonymous(inputTextArea.getText());
                    resultTextArea.setText(result.toString());
                    // Todo: get log results....
                }
            }
        });
    }
}
