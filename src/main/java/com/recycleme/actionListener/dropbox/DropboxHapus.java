package com.recycleme.actionListener.dropbox;

import com.recycleme.dao.DropboxDao;
import com.recycleme.frame.dropbox.DropboxFrame;
import com.recycleme.model.dropbox.Dropbox;

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
        if(e.getSource() == dropboxFrame.getButtonDeleteDropBox()) {
            int id = dropboxFrame.getSelectedDropboxId();
            if(dropboxDao.delete(id) == 0) {
                dropboxFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            dropboxFrame.removeDropbox(id);
            dropboxFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
