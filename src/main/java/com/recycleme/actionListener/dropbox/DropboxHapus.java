package com.recycleme.actionListener.dropbox;

import com.recycleme.dao.DropboxDao;
import com.recycleme.frame.dropbox.DropboxFrame;
import com.recycleme.model.dropbox.Dropbox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropboxHapus implements ActionListener {
    private DropboxFrame dropboxFrame;
    private DropboxDao dropboxDao;

    public DropboxHapus(DropboxFrame dropboxFrame, DropboxDao dropboxDao) {
        this.dropboxFrame = dropboxFrame;
        this.dropboxDao = dropboxDao;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dropboxFrame.getButtonDeleteDropbox()) {
            int id = dropboxFrame.getSelectedDropboxId();
            int row = dropboxFrame.getSelectedDropboxRow();
            if(row == -1) {
                dropboxFrame.showErrorMessage("Pilih dropbox terlebih dahulu!");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(dropboxFrame, "Apakah anda yakin ingin menghapus dropbox " +
                            "ini?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.NO_OPTION) {
                dropboxFrame.showInfoMessage("Proses dibatalkan!");
                return;
            }
            if(dropboxDao.delete(id) == 0) {
                dropboxFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            dropboxFrame.removeDropbox(row);
            dropboxFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
