package com.recycleme.actionListener.jenis;

import com.recycleme.dao.JenisDao;
import com.recycleme.frame.jenis.JenisFrame;
import com.recycleme.model.jenis.Jenis;

import java.awt.event.*;

public class JenisHapus implements ActionListener {
    private JenisFrame jenisFrame;
    private JenisDao jenisDao;

    public JenisHapus(JenisFrame jenisFrame, JenisDao jenisDao) {
        this.jenisFrame = jenisFrame;
        this.jenisDao = jenisDao;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jenisFrame.getButtonDeleteJenis()) {
            int id = jenisFrame.getSelectedJenisId();
            int row = jenisFrame.getSelectedJenisRow();
            if(jenisDao.delete(id) == 0) {
                jenisFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            jenisFrame.removeJenis(row);
            jenisFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
