package com.recycleme.model.dropbox;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DropboxTableModel extends AbstractTableModel {
    private String[] columnNames = {"Sampah", "Nama Pelanggan", "Nama Pengantar"};
    private List<Dropbox> list;

    public DropboxTableModel(List<Dropbox> list) {
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
        Dropbox dropbox = list.get(row);
        switch (col) {
            case 0:
                return dropbox.getNama();
            case 1:
                return dropbox.getAlamat();
            case 2:
                return dropbox.getMasyarakat();
            case 3:
                return dropbox.getKurir();
            case 4:
                return dropbox.getJenis();
            default:
                return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return super.isCellEditable(rowIndex, columnIndex);
    }

    public void addRow(Dropbox dropbox) {
        list.add(dropbox);
        fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
    }

    public void removeRow(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
