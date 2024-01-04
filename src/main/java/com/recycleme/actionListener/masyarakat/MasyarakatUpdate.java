package com.recycleme.actionListener.masyarakat;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.frame.masyarakat.UpdateMasyarakatFrame;
import com.recycleme.dao.MasyarakatDao;

public class MasyarakatUpdate implements ActionListener {
    private UpdateMasyarakatFrame updateMasyarakatFrame;
    private MasyarakatDao masyarakatDao;
    private MasyarakatFrame masyarakatFrame;

    public MasyarakatUpdate(UpdateMasyarakatFrame updateMasyarakatFrame, MasyarakatDao masyarakatDao, MasyarakatFrame masyarakatFrame) {
        this.updateMasyarakatFrame = updateMasyarakatFrame;
        this.masyarakatDao = masyarakatDao;
        this.masyarakatFrame = masyarakatFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == masyarakatFrame.getButtonUpdateMasyarakat()) {
            masyarakatFrame.showUpdateMasyarakatFrame();
        }
    }
}
