package com.recycleme.actionListener.masyarakat;

import com.recycleme.dao.MasyarakatDao;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.model.masyarakat.Masyarakat;

import javax.swing.*;
import java.awt.event.*;

public class MasyarakatTolak implements ActionListener {
    private MasyarakatFrame masyarakatFrame;
    private MasyarakatDao masyarakatDao;
    private Masyarakat masyarakat;

    public MasyarakatTolak(MasyarakatFrame masyarakatFrame, MasyarakatDao masyarakatDao) {
        this.masyarakatFrame = masyarakatFrame;
        this.masyarakatDao = masyarakatDao;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == masyarakatFrame.getButtonTolak()) {
            int row = masyarakatFrame.getSelectedMasyarakatRow();

            if(row == -1) {
                masyarakatFrame.showErrorMessage("Pilih masyarakat terlebih dahulu!");
                return;
            }

            if(masyarakatFrame.getSelectedMasyarakatStatusRegistrasi().equals("Disetujui")) {
                masyarakatFrame.showErrorMessage("Masyarakat sudah disetujui!");
                return;
            } else if(masyarakatFrame.getSelectedMasyarakatStatusRegistrasi().equals("Ditolak")) {
                masyarakatFrame.showErrorMessage("Masyarakat sudah ditolak!");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(masyarakatFrame, "Apakah anda yakin ingin menolak masyarakat ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.NO_OPTION) {
                masyarakatFrame.showInfoMessage("Proses dibatalkan!");
                return;
            }

            int col = 5;

            masyarakat = masyarakatDao.findById(masyarakatFrame.getSelectedMasyarakatId());
            masyarakat.setStatusRegistrasi("Ditolak");
            masyarakatDao.update(masyarakat);
            masyarakatFrame.updateMasyarakat(row, col, masyarakat);
            masyarakatFrame.showSuccessMessage("Masyarakat berhasil ditolak!");
        }
    }
}
