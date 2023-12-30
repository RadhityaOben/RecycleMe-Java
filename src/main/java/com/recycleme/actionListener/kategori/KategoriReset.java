package com.recycleme.actionListener.kategori;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.recycleme.frame.kategori.InputKategoriFrame;

public class KategoriReset implements ActionListener {

    private InputKategoriFrame inputKategoriFrame;

    public KategoriReset(InputKategoriFrame inputKategoriFrame) {
        this.inputKategoriFrame = inputKategoriFrame;
    }

    public void actionPerformed(ActionEvent e) {
        inputKategoriFrame.reset();
    }
}
