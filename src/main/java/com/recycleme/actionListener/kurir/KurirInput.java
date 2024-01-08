package com.recycleme.actionListener.kurir;

import com.recycleme.frame.kurir.InputKurirFrame;
import com.recycleme.frame.kurir.KurirFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KurirInput implements ActionListener {
    private InputKurirFrame inputKurirFrame;
    private KurirFrame kurirFrame;

    public KurirInput(KurirFrame kurirFrame) {
        this.kurirFrame = kurirFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kurirFrame.getButtonInputKurir()) {
            kurirFrame.showInputKurirFrame();
        }
    }
}
