package com.recycleme.model.masyarakat;

import javax.swing.table.*;
import java.util.List;

public class MasyarakatTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Nama", "Alamat", "Email", "No. Telp", "Status Registrasi", "Status Penjemputan", "Metode Pembayaran", "Poin"};
    private List<Masyarakat> list;

    public MasyarakatTableModel(List<Masyarakat> list) {
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
        Masyarakat masyarakat = list.get(row);
        switch (col) {
            case 0:
                return masyarakat.getId();
            case 1:
                return masyarakat.getNama();
            case 2:
                return masyarakat.getAlamat();
            case 3:
                return masyarakat.getEmail();
            case 4:
                return masyarakat.getNoTelp();
            case 5:
                return masyarakat.getStatusRegistrasi();
            case 6:
                return masyarakat.getStatusPenjemputan();
            case 7:
                return masyarakat.getMetodePembayaran();
            case 8:
                return masyarakat.getPoin();
            default:
                return "";
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Masyarakat masyarakat) {
        list.add(masyarakat);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
