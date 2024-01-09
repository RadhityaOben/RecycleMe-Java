package com.recycleme.actionListener.jenis;

import com.recycleme.dao.JenisDao;
import com.recycleme.frame.jenis.EditJenisFrame;
import com.recycleme.frame.jenis.JenisFrame;
import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.kategori.Kategori;

import java.awt.event.*;

public class JenisUpdate implements ActionListener {
    private JenisFrame jenisFrame;
    private EditJenisFrame editJenisFrame;
    private JenisDao jenisDao;
    private Jenis jenis;

    public JenisUpdate(EditJenisFrame editJenisFrame, JenisDao jenisDao, JenisFrame jenisFrame) {
        this.editJenisFrame = editJenisFrame;
        this.jenisDao = jenisDao;
        this.jenisFrame = jenisFrame;
    }

    public void actionPerformed(ActionEvent e) {
        int id = editJenisFrame.getId();
        String nama = editJenisFrame.getNama();
        Kategori kategori = editJenisFrame.getKategori();
        int poin = editJenisFrame.getPoin();

        if(nama.equals("")) {
            editJenisFrame.showErrorMessage("Nama tidak boleh kosong");
            return;
        }

        if(poin < 0) {
            editJenisFrame.showErrorMessage("Poin tidak boleh kurang dari 0");
            return;
        }

        jenis = new Jenis(id, nama, kategori, poin);
        if(jenisDao.update(jenis) < 1) {
            editJenisFrame.showErrorMessage("Jenis gagal diupdate");
            return;
        }
        editJenisFrame.showSuccessMessage("Jenis berhasil diupdate");
        jenisFrame.updateJenis(jenis);
        editJenisFrame.dispose();
    }
}
