package view.record;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class RecordTableModel extends AbstractTableModel {
    private int column = 6;
    private int rownum;

    private String[] colNames = {"ID","Фамилия клиента","Название услуги","Фамилия мастера","Дата","Время"};

    private ArrayList<String[]> resultSets;

    public RecordTableModel(ArrayList<String[]> resultSets) {
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
