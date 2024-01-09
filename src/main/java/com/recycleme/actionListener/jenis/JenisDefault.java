package com.recycleme.actionListener.jenis;

import com.recycleme.frame.jenis.EditJenisFrame;

import java.awt.event.*;

public class JenisDefault implements ActionListener {
private EditJenisFrame editJenisFrame;

    public JenisDefault(EditJenisFrame editJenisFrame) {
        this.editJenisFrame = editJenisFrame;
    }

    public void actionPerformed(ActionEvent e) {editJenisFrame.defaultValue();}
}