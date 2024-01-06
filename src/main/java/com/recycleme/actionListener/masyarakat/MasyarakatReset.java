package com.recycleme.actionListener.masyarakat;

import com.recycleme.frame.masyarakat.InputMasyarakatFrame;

import java.awt.event.*;

public class MasyarakatReset implements ActionListener {
    private InputMasyarakatFrame inputMasyarakatFrame;

    public MasyarakatReset(InputMasyarakatFrame inputMasyarakatFrame) {
        this.inputMasyarakatFrame = inputMasyarakatFrame;
    }

    public void actionPerformed(ActionEvent e) {
        inputMasyarakatFrame.reset();
    }
}
