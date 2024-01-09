package com.recycleme.actionListener.kategori;

import com.recycleme.dao.KategoriDao;
import com.recycleme.frame.kategori.EditKategoriFrame;
import com.recycleme.frame.kategori.KategoriFrame;
import com.recycleme.model.kategori.Kategori;

import java.awt.event.*;

public class KategoriUpdate implements ActionListener {

    private KategoriFrame kategoriFrame;
    private EditKategoriFrame editKategoriFrame;
    private KategoriDao kategoriDao;
    private Kategori kategori;

    public KategoriUpdate(EditKategoriFrame editKategoriFrame, KategoriDao kategoriDao, KategoriFrame kategoriFrame) {
        this.kategoriFrame = kategoriFrame;
        this.editKategoriFrame = editKategoriFrame;
        this.kategoriDao = kategoriDao;
    }

    public void actionPerformed(ActionEvent e) {
        int id = editKategoriFrame.getId();
        String nama = editKategoriFrame.getNama();

        if(nama.equals("")) {
            editKategoriFrame.showMessageError("Nama tidak boleh kosong!");
            return;
        }

        //jika nama kategori sama dengan nama kategori yang sudah ada
        if(kategoriFrame.isKategoriExist(nama)) {
            editKategoriFrame.showMessageError("Nama kategori sudah ada!");
            return;
        }

        kategori = new Kategori(id, nama);
        if(kategoriDao.update(kategori) <1) {
            editKategoriFrame.showMessageError("Kategori gagal diupdate.");
            return;
        }
        editKategoriFrame.showMessageSuccess("Kategori berhasil diupdate.");
        kategoriFrame.updateKategori(kategori);
        editKategoriFrame.dispose();
    }
}
