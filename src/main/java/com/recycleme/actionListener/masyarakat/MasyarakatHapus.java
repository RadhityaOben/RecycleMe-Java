package com.recycleme.actionListener.masyarakat;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.model.masyarakat.Masyarakat;
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
            int id = masyarakatFrame.getSelectedMasyarakatId();
            if(masyarakatDao.delete(id) == 0) {
                masyarakatFrame.showErrorMessage("Data gagal dihapus!");
                return;
            }
            masyarakatFrame.removeMasyarakat(id);
            masyarakatFrame.showSuccessMessage("Data berhasil dihapus!");
        }
    }
}
