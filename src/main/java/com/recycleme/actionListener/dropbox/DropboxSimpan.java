package com.recycleme.actionListener.dropbox;

import com.recycleme.dao.DropboxDao;
import com.recycleme.frame.dropbox.DropboxFrame;
import com.recycleme.frame.dropbox.InputDropboxFrame;
import com.recycleme.model.dropbox.Dropbox;
import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.kategori.Kategori;
import com.recycleme.model.kurir.Kurir;
import com.recycleme.model.masyarakat.Masyarakat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class DropboxSimpan implements ActionListener {
    private DropboxFrame dropboxFrame;
    private InputDropboxFrame inputDropboxFrame;
    private DropboxDao dropboxDao;
    private Dropbox dropbox;

    public DropboxSimpan(InputDropboxFrame inputDropboxFrame, DropboxDao dropboxDao, DropboxFrame dropboxFrame) {
        this.dropboxFrame = dropboxFrame;
        this.inputDropboxFrame = inputDropboxFrame;
        this.dropboxDao = dropboxDao;
    }
        @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == inputDropboxFrame.getSimpanButton()) {
            if(inputDropboxFrame.getMasyarakat() == null) {
                inputDropboxFrame.showErrorMessage("Masyarakat belum dipilih.");
                return;
            }
            if(inputDropboxFrame.getKurir() == null) {
                inputDropboxFrame.showErrorMessage("Kurir belum dipilih.");
                return;
            }
            if(inputDropboxFrame.getKategori() == null) {
                inputDropboxFrame.showErrorMessage("Kategori belum dipilih.");
                return;
            }

            int id = DropboxDao.lastId() + 1;
            Date tanggal = new Date(System.currentTimeMillis());
            Masyarakat masyarakat = inputDropboxFrame.getMasyarakat();
            Kurir kurir = inputDropboxFrame.getKurir();
            Kategori kategori = inputDropboxFrame.getKategori();
            Jenis[] jenis = null;
            dropbox = new Dropbox(id, tanggal, masyarakat, kurir, kategori, jenis);

            System.out.println(dropbox.getMasyarakat().getId());
            System.out.println(dropbox.getKurir().getId());
            System.out.println(dropbox.getKategori().getId());
            if(dropboxDao.insert(dropbox) <1) {
                inputDropboxFrame.showErrorMessage("Dropbox gagal ditambahkan.");
                return;
            }
            inputDropboxFrame.showSuccessMessage("Dropbox berhasil ditambahkan.");
            dropbox.setId(DropboxDao.lastId());
            inputDropboxFrame.reset();
            dropboxFrame.addDropbox(dropbox);
            inputDropboxFrame.dispose();
        }
    }
}
