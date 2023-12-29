package com.recycleme.actionListener.kategori;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.recycleme.frame.kategori.InputKategoriFrame;
import com.recycleme.frame.kategori.KategoriFrame;
public class KategoriInput implements ActionListener {

    private InputKategoriFrame inputKategoriFrame;
    private KategoriFrame kategoriFrame;

    public KategoriInput(KategoriFrame kategoriFrame) {
        this.kategoriFrame = kategoriFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kategoriFrame.getButtonInputKategori()) {
            kategoriFrame.showInputKategoriFrame();
        }
    }

}
