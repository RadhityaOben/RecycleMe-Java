package com.recycleme.actionListener.dropbox;

import com.recycleme.dao.DropboxDao;
import com.recycleme.frame.dropbox.DropboxFrame;
import com.recycleme.frame.dropbox.InputDropboxFrame;
import com.recycleme.model.dropbox.Dropbox;
import com.recycleme.model.kurir.Kurir;
import com.recycleme.model.masyarakat.Masyarakat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

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
        int id = UUID.randomUUID().hashCode();
        String nama = inputDropboxFrame.getNama();
        String alamat = inputDropboxFrame.getAlamat();
        Masyarakat masyarakat = inputDropboxFrame.getMasyarakat();
        Kurir kurir = inputDropboxFrame.getKurir();
        jenis = inputDropboxFrame.getJenis();

        dropbox = new Dropbox(id, nama, alamat, masyarakat, kurir, jenis);
        inputDropboxFrame.showSuccessMessage("Dropbox berhasil ditambahkan!");
        inputDropboxFrame.reset();
        inputDropboxFrame.dispose();
        dropboxFrame.addDropbox(dropbox);
        dropboxDao.insert(dropbox);
    }
}
