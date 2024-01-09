package com.recycleme.actionListener.jenis;

import com.recycleme.frame.jenis.InputJenisFrame;

import java.awt.event.*;

public class JenisReset implements ActionListener {
    private InputJenisFrame inputJenisFrame;

    public JenisReset(InputJenisFrame inputJenisFrame) {
        this.inputJenisFrame = inputJenisFrame;
    }

    public void actionPerformed(ActionEvent e) {
        inputJenisFrame.reset();
    }
}