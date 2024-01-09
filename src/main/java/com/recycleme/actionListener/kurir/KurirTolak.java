package com.recycleme.actionListener.kurir;

import com.recycleme.dao.KurirDao;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.frame.kurir.KurirFrame;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.model.kurir.Kurir;
import com.recycleme.model.masyarakat.Masyarakat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KurirTolak implements ActionListener {
    private KurirFrame kurirFrame;
    private KurirDao kurirDao;
    private Kurir kurir;

    public KurirTolak(KurirFrame kurirFrame, KurirDao kurirDao) {
        this.kurirFrame = kurirFrame;
        this.kurirDao = kurirDao;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kurirFrame.getButtonTolak()) {
            int row = kurirFrame.getSelectedKurirRow();

            if(row == -1) {
                kurirFrame.showErrorMessage("Pilih Kurir terlebih dahulu!");
                return;
            }

            if(kurirFrame.getSelectedKurirStatusRegistrasi().equals("Disetujui")) {
                kurirFrame.showErrorMessage("Kurir sudah disetujui!");
                return;
            } else if(kurirFrame.getSelectedKurirStatusRegistrasi().equals("Ditolak")) {
                kurirFrame.showErrorMessage("Kurir sudah ditolak!");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(kurirFrame, "Apakah anda yakin ingin menolak Kurir ini?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.NO_OPTION) {
                kurirFrame.showInfoMessage("Proses dibatalkan!");
                return;
            }

            int col = 3;

            kurir = kurirDao.findById(kurirFrame.getSelectedKurirId());
            kurir.setStatusRegistrasi("Ditolak");
            kurirDao.update(kurir);
            kurirFrame.updateKurir(row, col, kurir);
            kurirFrame.showSuccessMessage("Kurir berhasil ditolak!");
        }
    }
}
