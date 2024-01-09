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

        jenis = new Jenis(id, nama, kategori);
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