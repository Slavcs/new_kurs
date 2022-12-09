package view.user;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
    private int column = 4;
    private int rownum;

    private String[] colNames = {"ID","ID парикмахерской","Фамилия","Имя"};

    private ArrayList<String[]> resultSets;

    public UserTableModel(ArrayList<String[]> resultSets) {
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
