package com.recycleme.actionListener.kurir;

import com.recycleme.dao.KurirDao;
import com.recycleme.frame.kurir.KurirFrame;
import com.recycleme.model.kurir.Kurir;

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
            int id = kurirFrame.getSelectedKurirId();
            if(kurirDao.delete(id) == 0) {
                kurirFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            kurirFrame.removeKurir(id);
            kurirFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
