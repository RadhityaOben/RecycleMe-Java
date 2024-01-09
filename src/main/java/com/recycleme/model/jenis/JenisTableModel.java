package com.recycleme.model.jenis;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class JenisTableModel extends AbstractTableModel{
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
                return jenis.getKategori().getNama();
            default:
                return "";
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Jenis jenis) {
        list.add(jenis);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void update(int row, int col, String value) {
        Jenis jenis = list.get(row);
        switch (col) {
            case 0:
                jenis.setId(Integer.parseInt(value));
                break;
            case 1:
                jenis.setNama(value);
                break;
            case 2:
                jenis.getKategori().setNama(value);
                break;
        }
        list.set(row, jenis);
        fireTableCellUpdated(row, col);
    }

    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
