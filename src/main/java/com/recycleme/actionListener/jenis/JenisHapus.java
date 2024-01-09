package com.recycleme.actionListener.jenis;

import com.recycleme.dao.JenisDao;
import com.recycleme.frame.jenis.JenisFrame;
import com.recycleme.model.jenis.Jenis;

import javax.swing.*;
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
            int row = jenisFrame.getSelectedJenisRow();
            if(row == -1) {
                jenisFrame.showErrorMessage("Pilih kategori terlebih dahulu!");
                return;
            }
            int id = jenisFrame.getSelectedJenisId();
            int confirm = JOptionPane.showConfirmDialog(jenisFrame, "Apakah anda yakin ingin menghapus jenis " +
                            "ini?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.NO_OPTION) {
                jenisFrame.showInfoMessage("Proses dibatalkan!");
                return;
            }
            if(jenisDao.delete(id) == 0) {
                jenisFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            jenisFrame.removeJenis(row);
            jenisFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
