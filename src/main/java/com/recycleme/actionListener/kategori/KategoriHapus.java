package com.recycleme.actionListener.kategori;

import java.awt.event.ActionListener;

import com.recycleme.dao.KategoriDao;
import com.recycleme.frame.kategori.KategoriFrame;
import com.recycleme.model.kategori.Kategori;

import java.awt.event.ActionEvent;

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
            if(kategoriDao.delete(id) == 0) {
                kategoriFrame.showMessageError("Data gagal dihapus!");
                return;
            }
            kategoriFrame.removeKategori(id);
            kategoriFrame.showMessageSuccess("Data berhasil dihapus!");
        }
    }
}
