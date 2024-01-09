package com.recycleme.actionListener.jenis;

import com.recycleme.frame.jenis.InputJenisFrame;
import com.recycleme.frame.jenis.JenisFrame;
import java.awt.event.*;

public class JenisInput implements ActionListener {

    private InputJenisFrame inputJenisFrame;
    private JenisFrame jenisFrame;

    public JenisInput(JenisFrame jenisFrame) {
        this.jenisFrame = jenisFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jenisFrame.getButtonInputJenis()) {
            jenisFrame.showInputJenisFrame();
        }
    }
}