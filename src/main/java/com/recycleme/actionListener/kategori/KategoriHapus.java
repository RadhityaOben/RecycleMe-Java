package com.recycleme.actionListener.kategori;

import com.recycleme.dao.KategoriDao;
import com.recycleme.frame.kategori.KategoriFrame;
import com.recycleme.model.kategori.Kategori;

import javax.swing.*;
import java.awt.event.*;

public class KategoriHapus implements ActionListener {
    private KategoriFrame kategoriFrame;
    private KategoriDao kategoriDao;
    private Kategori kategori;

    public KategoriHapus(KategoriFrame kategoriFrame, KategoriDao kategoriDao) {
        this.kategoriFrame = kategoriFrame;
        this.kategoriDao = kategoriDao;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kategoriFrame.getButtonDeleteKategori()) {
            int id = kategoriFrame.getSelectedKategoriId();
            int row = kategoriFrame.getSelectedKategoriRow();
            if(row == -1) {
                kategoriFrame.showErrorMessage("Pilih kategori terlebih dahulu!");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(kategoriFrame, "Apakah anda yakin ingin menghapus kategori " +
                            "ini?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.NO_OPTION) {
                kategoriFrame.showInfoMessage("Proses dibatalkan!");
                return;
            }
            if(kategoriDao.delete(id) == 0) {
                kategoriFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            kategoriFrame.removeKategori(row);
            kategoriFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
