package com.recycleme.model.jenis;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class JenisTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Nama", "Kategori"};
    private List<Jenis> list;

    public JenisTableModel(List<Jenis> list) {
        this.list = list;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return list.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Jenis jenis = list.get(row);
        switch (col) {
            case 0:
                return jenis.getId();
            case 1:
                return jenis.getNama();
            case 2:
                return jenis.getKategori();
            default:
                return "";
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Jenis jenis) {
        list.add(jenis);
        fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
    }

    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
