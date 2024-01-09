package com.recycleme.actionListener.kategori;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.recycleme.dao.KategoriDao;
import com.recycleme.frame.kategori.InputKategoriFrame;
import com.recycleme.frame.kategori.KategoriFrame;
import com.recycleme.model.kategori.Kategori;

import javax.swing.*;

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
        String nama = inputKategoriFrame.getNama();

        if(nama.equals("")) {
            inputKategoriFrame.showMessageError("Nama tidak boleh kosong!");
            return;
        }

////        jika nama sudah ada di database
//        if(kategoriDao.getKategori(nama) != null) {
//            inputKategoriFrame.showMessageError("Nama kategori sudah ada!");
//            return;
//        }

        int confirm = JOptionPane.showConfirmDialog(inputKategoriFrame, "Apakah data yang dimasukkan sudah sesuai?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.NO_OPTION) {
            inputKategoriFrame.showInfoMessage("Silahkan periksa kembali!");
            return;
        }



        kategori = new Kategori(id, nama);
        if(kategoriDao.insert(kategori) <1) {
            inputKategoriFrame.showMessageError("Kategori gagal ditambahkan.");
            return;
        }
        inputKategoriFrame.showMessageSuccess("Kategori berhasil ditambahkan.");
        kategori.setId(KategoriDao.lastId());
        inputKategoriFrame.reset();
        kategoriFrame.addKategori(kategori);
        inputKategoriFrame.dispose();
    }
}
