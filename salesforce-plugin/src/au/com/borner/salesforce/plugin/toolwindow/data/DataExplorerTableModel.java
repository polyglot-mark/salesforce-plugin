package au.com.borner.salesforce.plugin.toolwindow.data;

import au.com.borner.salesforce.client.rest.AbstractRestClient;
import au.com.borner.salesforce.client.rest.domain.DescribeField;
import au.com.borner.salesforce.client.rest.domain.DescribeResult;
import au.com.borner.salesforce.client.rest.domain.GenericJSONObject;
import au.com.borner.salesforce.client.rest.domain.QueryResult;
import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
public class DataExplorerTableModel extends AbstractTableModel {

    private final AbstractRestClient client;
    private final String versionUrl;
    private final String sObjectName;
    private final List<String> columnNames = new ArrayList<String>();
    private final List<GenericJSONObject> rows = new ArrayList<GenericJSONObject>();
    private final JBTable table;

    public DataExplorerTableModel(JBTable table, AbstractRestClient client, String versionUrl, String sObjectName) {
        this.table = table;
        this.client = client;
        this.versionUrl = versionUrl;
        this.sObjectName = sObjectName;
        refresh();
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String columnName = columnNames.get(columnIndex);
        GenericJSONObject row = rows.get(rowIndex);
        return row.get(columnName);
    }

    public void refresh() {
        columnNames.clear();
        rows.clear();
        fireTableStructureChanged();
        table.setPaintBusy(true);
        RetrieveColumnNamesWorker worker = new RetrieveColumnNamesWorker(client, versionUrl, sObjectName);
        worker.execute();
    }

    private class RetrieveColumnNamesWorker extends SwingWorker<Void,Void> {

        private final AbstractRestClient client;
        private final String versionUrl;
        private final String sObjectName;

        private RetrieveColumnNamesWorker(AbstractRestClient client, String versionUrl, String sObjectName) {
            this.client = client;
            this.versionUrl = versionUrl;
            this.sObjectName = sObjectName;
        }

        @Override
        protected Void doInBackground() throws Exception {
            // Get column names
            DescribeResult describeResult = client.describeObject(versionUrl, sObjectName);
            for (DescribeField field : describeResult.getFields()) {
                columnNames.add(field.getName());
            }

            // Get data
            StringBuilder selectStatement = new StringBuilder("select ");
            for (int i=0; i<columnNames.size(); i++) {
                selectStatement.append(columnNames.get(i));
                if (i < columnNames.size() -1) {
                    selectStatement.append(", ");
                }
            }
            selectStatement.append(" from ");
            selectStatement.append(sObjectName);
            QueryResult queryResult = client.executeQuery(selectStatement.toString());
            List<GenericJSONObject> results = queryResult.getEntities(QueryResult.RECORDS, GenericJSONObject.class);
            rows.addAll(results);
            return null;
        }

        @Override
        protected void done() {
            table.setPaintBusy(false);
            fireTableStructureChanged();
        }
    }
}
