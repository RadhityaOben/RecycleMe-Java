package com.recycleme.actionListener.kategori;

import com.recycleme.frame.kategori.EditKategoriFrame;
import com.recycleme.frame.kategori.KategoriFrame;

import java.awt.event.*;

public class KategoriEdit implements ActionListener {
    private EditKategoriFrame editKategoriFrame;
    private KategoriFrame kategoriFrame;

    public KategoriEdit(KategoriFrame kategoriFrame) {
        this.kategoriFrame = kategoriFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kategoriFrame.getButtonEditKategori()) {
            int row = kategoriFrame.getSelectedKategoriRow();
            if(row == -1) {
                kategoriFrame.showErrorMessage("Pilih kategori yang akan diupdate.");
                return;
            }
            int id = kategoriFrame.getSelectedKategoriId();

            editKategoriFrame = new EditKategoriFrame(kategoriFrame, id);
            editKategoriFrame.setVisible(true);
        }
    }
}
