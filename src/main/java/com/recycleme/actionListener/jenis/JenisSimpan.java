package com.recycleme.actionListener.jenis;

import com.recycleme.dao.JenisDao;
import com.recycleme.frame.jenis.InputJenisFrame;
import com.recycleme.frame.jenis.JenisFrame;
import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.kategori.Kategori;

import java.awt.event.*;

public class JenisSimpan implements ActionListener {
    private JenisFrame jenisFrame;
    private InputJenisFrame inputJenisFrame;
    private JenisDao jenisDao;
    private Jenis jenis;

    public JenisSimpan(InputJenisFrame inputJenisFrame, JenisDao jenisDao, JenisFrame jenisFrame) {
        this.inputJenisFrame = inputJenisFrame;
        this.jenisDao = jenisDao;
        this.jenisFrame = jenisFrame;
    }

    public void actionPerformed(ActionEvent e) {
        int id = JenisDao.lastId() + 1;
        String nama = inputJenisFrame.getNama();
        Kategori kategori = inputJenisFrame.getKategori();
        int poin = inputJenisFrame.getPoin();

        if(nama.equals("")) {
            inputJenisFrame.showErrorMessage("Nama tidak boleh kosong!");
            return;
        }

        if(jenisFrame.isJenisExist(nama)) {
            inputJenisFrame.showErrorMessage("Nama jenis sudah ada!");
            return;
        }

        if(poin < 0) {
            inputJenisFrame.showErrorMessage("Poin tidak boleh kurang dari 0!");
            return;
        }

        jenis = new Jenis(id, nama, kategori, poin);
        if(jenisDao.insert(jenis) <1) {
            inputJenisFrame.showErrorMessage("Jenis gagal ditambahkan.");
            return;
        }
        inputJenisFrame.showSuccessMessage("Jenis berhasil ditambahkan.");
        jenis.setId(JenisDao.lastId());
        inputJenisFrame.reset();
        jenisFrame.addJenis(jenis);
        inputJenisFrame.dispose();
    }
}