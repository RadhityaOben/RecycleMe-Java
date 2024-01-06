package com.recycleme.actionListener.masyarakat;

import com.recycleme.dao.MasyarakatDao;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.model.masyarakat.Masyarakat;

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
            if(masyarakatFrame.getSelectedMasyarakatId() == -1) {
                masyarakatFrame.showErrorMessage("Pilih data terlebih dahulu!");
                return;
            }

            if(masyarakatFrame.getSelectedMasyarakatStatusRegistrasi().equals("Disetujui")) {
                masyarakatFrame.showErrorMessage("Data sudah disetujui!");
                return;
            } else if(masyarakatFrame.getSelectedMasyarakatStatusRegistrasi().equals("Ditolak")) {
                masyarakatFrame.showErrorMessage("Data sudah ditolak!");
                return;
            }

            int col = masyarakatFrame.getSelectedMasyarakatRow();
            int row = masyarakatFrame.getSelectedMasyarakatRow();

            masyarakat = masyarakatDao.findById(masyarakatFrame.getSelectedMasyarakatId());
            masyarakat.setStatusRegistrasi("Ditolak");
            masyarakatDao.update(masyarakat);
            masyarakatFrame.updateMasyarakat(row, col, masyarakat);
            masyarakatFrame.showSuccessMessage("Data berhasil ditolak!");
        }
    }
}
