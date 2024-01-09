package com.recycleme.actionListener.kurir;

import com.recycleme.dao.KurirDao;
import com.recycleme.frame.kurir.KurirFrame;
import com.recycleme.model.kurir.Kurir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class KurirHapus implements ActionListener {
    private KurirFrame kurirFrame;
    private KurirDao kurirDao;
    private Kurir kurir;

    public KurirHapus(KurirFrame kurirFrame, KurirDao kurirDao) {
        this.kurirFrame = kurirFrame;
        this.kurirDao = kurirDao;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kurirFrame.getButtonDeleteKurir()) {
            int row = kurirFrame.getSelectedKurirRow();
            if(row == -1) {
                kurirFrame.showErrorMessage("Pilih kurir terlebih dahulu!");
                return;
            }

            int id = kurirFrame.getSelectedKurirId();

            int confirm = JOptionPane.showConfirmDialog(kurirFrame, "Apakah anda yakin ingin menghapus masyarakat ini?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.NO_OPTION) {
                kurirFrame.showInfoMessage("Proses dibatalkan!");
                return;
            }

            System.out.println(id);

            if(kurirDao.delete(id) == 0) {
                kurirFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            kurirFrame.removeKurir(row);
            kurirFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
