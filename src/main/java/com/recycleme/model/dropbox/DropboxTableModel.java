package com.recycleme.model.dropbox;

import javax.swing.table.*;
import java.sql.Date;
import java.util.List;

public class DropboxTableModel extends AbstractTableModel{
    private String[] columnNames = {"ID", "Tanggal", "Masyarakat", "Kurir", "Kategori", "Jenis"};
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
                return dropbox.getId();
            case 1:
                return dropbox.getTanggal();
            case 2:
                return dropbox.getMasyarakat().getNama();
            case 3:
                return dropbox.getKurir().getNama();
            case 4:
                return dropbox.getKategori().getNama();
            case 5:
                return dropbox.getJenis();
            default:
                return "";
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Dropbox dropbox) {
        list.add(dropbox);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void update(int row, int col, String value) {
        Dropbox dropbox = list.get(row);
        switch (col) {
            case 0:
                dropbox.setId(Integer.parseInt(value));
                break;
            case 1:
                dropbox.setTanggal(Date.valueOf(value));
                break;
            case 2:
                dropbox.getMasyarakat().setNama(value);
                break;
            case 3:
                dropbox.getKurir().setNama(value);
                break;
            case 4:
                dropbox.getKategori().setNama(value);
                break;
        }
        list.set(row, dropbox);
        fireTableCellUpdated(row, col);
    }

    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
