package com.recycleme.model.kurir;

import com.recycleme.model.kurir.Kurir;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class KurirTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Nama", "No. Telp", "Status Registrasi", "Status Penjemputan", "Jenis Kendaraan", "Kelengkapan Berkas"};
    private List<Kurir> list;

    public KurirTableModel(List<Kurir> list) {
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
        Kurir kurir = list.get(row);
        switch (col) {
            case 0:
                return kurir.getId();
            case 1:
                return kurir.getNama();
            case 2:
                return kurir.getNoHp();
            case 3:
                return kurir.getStatusRegistrasi();
            case 4:
                return kurir.getStatusPenjemputan();
            case 5:
                return kurir.getJenisKendaraan();
            case 6:
                return kurir.getKelengkapanBerkas();
            default:
                return "";
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Kurir kurir) {
        list.add(kurir);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void update(int row, int col, Kurir kurir) {
        Kurir rowItem = list.get(row);
        switch (col) {
            case 0:
                rowItem.setId(kurir.getId());
                break;
            case 1:
                rowItem.setNama(kurir.getNama());
                break;
            case 2:
                rowItem.setNoHp(kurir.getNoHp());
                break;
            case 3:
                rowItem.setStatusRegistrasi(kurir.getStatusRegistrasi());
                break;
            case 4:
                rowItem.setStatusPenjemputan(kurir.getStatusPenjemputan());
                break;
            case 5:
                rowItem.setJenisKendaraan(kurir.getJenisKendaraan());
                break;
            case 6:
                rowItem.setKelengkapanBerkas(kurir.getKelengkapanBerkas());
                break;
            default:
                break;
        }

        list.set(row, rowItem);
        fireTableCellUpdated(row, col);
    }

    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
