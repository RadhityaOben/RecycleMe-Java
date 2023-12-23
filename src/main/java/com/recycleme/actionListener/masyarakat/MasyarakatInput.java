package com.recycleme.actionListener.masyarakat;

import com.recycleme.frame.masyarakat.InputMasyarakatFrame;
import com.recycleme.frame.masyarakat.MasyarakatFrame;

import java.awt.event.*;

public class MasyarakatInput implements ActionListener {
    private InputMasyarakatFrame inputMasyarakatFrame;
    private MasyarakatFrame masyarakatFrame;

    public MasyarakatInput(MasyarakatFrame masyarakatFrame) {
        this.masyarakatFrame = masyarakatFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == masyarakatFrame.getButtonInputMasyarakat()) {
            masyarakatFrame.showInputMasyarakatFrame();
        }
    }
}
