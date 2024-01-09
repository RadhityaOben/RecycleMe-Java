package com.recycleme.actionListener.kategori;

import com.recycleme.frame.kategori.EditKategoriFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KategoriDefault implements ActionListener {

    private EditKategoriFrame editKategoriFrame;

    public KategoriDefault(EditKategoriFrame editKategoriFrame) {
        this.editKategoriFrame = editKategoriFrame;
    }

    public void actionPerformed(ActionEvent e) {
        editKategoriFrame.defaultValue();
    }
}
