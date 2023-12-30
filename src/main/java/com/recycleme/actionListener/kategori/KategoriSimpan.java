package com.recycleme.actionListener.kategori;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.recycleme.dao.KategoriDao;
import com.recycleme.frame.kategori.InputKategoriFrame;
import com.recycleme.frame.kategori.KategoriFrame;
import com.recycleme.model.kategori.Kategori;

public class KategoriSimpan implements ActionListener {

    private KategoriFrame kategoriFrame;
    private InputKategoriFrame inputKategoriFrame;
    private KategoriDao kategoriDao;
    private Kategori kategori;

    public KategoriSimpan(InputKategoriFrame inputKategoriFrame, KategoriDao kategoriDao, KategoriFrame kategoriFrame) {
        this.kategoriFrame = kategoriFrame;
        this.inputKategoriFrame = inputKategoriFrame;
        this.kategoriDao = kategoriDao;
    }

    public void actionPerformed(ActionEvent e) {
        int id = KategoriDao.lastId() + 1;
        String nama = inputKategoriFrame.getNamaField();

        kategori = new Kategori(id, nama);
        inputKategoriFrame.showMessageSuccess("Daftar berhasil! Silahkan tunggu konfirmasi dari admin.");
        inputKategoriFrame.reset();
        kategoriFrame.addKategori(kategori);
        kategoriDao.insert(kategori);
        inputKategoriFrame.dispose();
    }

}
