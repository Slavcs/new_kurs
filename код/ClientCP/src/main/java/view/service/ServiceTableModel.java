package view.service;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ServiceTableModel extends AbstractTableModel {
    private int column = 4;
    private int rownum;

    private String[] colNames = {"ID", "Название", "Стоимость", "Тип услуги"};

    private ArrayList<String[]> resultSets;

    public ServiceTableModel(ArrayList<String[]> resultSets) {
        this.resultSets = new ArrayList<>(resultSets);
    }

    @Override
    public int getRowCount() {
        return resultSets.size();
    }

    @Override
    public int getColumnCount() {
        return column;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = resultSets.get(rowIndex);
        return row[columnIndex];
    }

    @Override
    public String getColumnName(int param) {
        return colNames[param];
    }
}
