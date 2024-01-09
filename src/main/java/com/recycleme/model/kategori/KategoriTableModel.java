package com.recycleme.model.kategori;

import javax.swing.table.*;
import java.util.List;

public class KategoriTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Nama"};
    private List<Kategori> list;

    public KategoriTableModel(List<Kategori> list) {
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
        Kategori kategori = list.get(row);
        switch (col) {
            case 0:
                return kategori.getId();
            case 1:
                return kategori.getNama();
            default:
                return "";
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Kategori kategori) {
        list.add(kategori);
        fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
    }

    public void update(int row, int col, String value) {
        Kategori kategori = list.get(row);
        switch (col) {
            case 0:
                kategori.setId(Integer.parseInt(value));
                break;
            case 1:
                kategori.setNama(value);
                break;
        }
        list.set(row, kategori);
        fireTableCellUpdated(row, col);
    }

    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
