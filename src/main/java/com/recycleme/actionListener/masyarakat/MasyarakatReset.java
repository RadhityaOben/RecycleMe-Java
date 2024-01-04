package com.recycleme.actionListener.masyarakat;

import com.recycleme.frame.masyarakat.InputMasyarakatFrame;
import com.recycleme.frame.masyarakat.UpdateMasyarakatFrame;

import java.awt.event.*;

public class MasyarakatReset implements ActionListener {
    private InputMasyarakatFrame inputMasyarakatFrame;

    private UpdateMasyarakatFrame updateMasyarakatFrame;

    public MasyarakatReset(InputMasyarakatFrame inputMasyarakatFrame) {
        this.inputMasyarakatFrame = inputMasyarakatFrame;
    }

    public MasyarakatReset(UpdateMasyarakatFrame updateMasyarakatFrame) {
        this.updateMasyarakatFrame = updateMasyarakatFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == inputMasyarakatFrame.getResetButton()) {
            inputMasyarakatFrame.reset();
        } else if(e.getSource() == updateMasyarakatFrame.getResetButton()) {
            updateMasyarakatFrame.update();
        }
    }
}
