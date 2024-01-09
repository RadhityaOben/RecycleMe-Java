package com.recycleme.actionListener.masyarakat;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.model.masyarakat.Masyarakat;

import javax.swing.*;
import java.awt.event.*;


public class MasyarakatHapus implements ActionListener {
    private MasyarakatFrame masyarakatFrame;
    private MasyarakatDao masyarakatDao;
    private Masyarakat masyarakat;

    public MasyarakatHapus(MasyarakatFrame masyarakatFrame, MasyarakatDao masyarakatDao) {
        this.masyarakatFrame = masyarakatFrame;
        this.masyarakatDao = masyarakatDao;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == masyarakatFrame.getButtonDeleteMasyarakat()) {
            int row = masyarakatFrame.getSelectedMasyarakatRow();
            if(row == -1) {
                masyarakatFrame.showErrorMessage("Pilih masyarakat terlebih dahulu!");
                return;
            }

            int id = masyarakatFrame.getSelectedMasyarakatId();

            int confirm = JOptionPane.showConfirmDialog(masyarakatFrame, "Apakah anda yakin ingin menghapus masyarakat ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.NO_OPTION) {
                masyarakatFrame.showInfoMessage("Proses dibatalkan!");
                return;
            }

            if(masyarakatDao.delete(id) == 0) {
                masyarakatFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            masyarakatFrame.removeMasyarakat(row);
            masyarakatFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
