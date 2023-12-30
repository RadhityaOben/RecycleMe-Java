package com.recycleme.main;

import com.recycleme.actionListener.main.MainButtonActionListener;
import com.recycleme.dao.KategoriDao;
import com.recycleme.dao.KurirDao;
import com.recycleme.frame.kategori.KategoriFrame;
import com.recycleme.frame.kurir.KurirFrame;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.dao.MasyarakatDao;


import java.awt.FlowLayout;
import javax.swing.*;

public class MainFrame extends JFrame {

    private MasyarakatFrame masyarakatFrame;
    private MasyarakatDao masyarakatDao = new MasyarakatDao();

    private KurirFrame kurirFrame;
    private KurirDao kurirDao = new KurirDao();

    private KategoriFrame kategoriFrame;

    private KategoriDao kategoriDao = new KategoriDao();

    private JButton buttonMasyarakat;
    private JButton buttonKurir;
    private JButton buttonKategori;
    private JButton buttonJenis;
    private JButton buttonDropbox;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(600, 500);

        this.setLayout(new FlowLayout());

        this.buttonMasyarakat = new JButton("Masayarakat");
        this.buttonKurir = new JButton("Kurir");
        this.buttonKategori = new JButton("Kategori");
        this.buttonJenis = new JButton("Jenis");
        this.buttonDropbox = new JButton("Dropbox");

        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonMasyarakat.addActionListener(actionListener);
        this.buttonKurir.addActionListener(actionListener);
        this.buttonKategori.addActionListener(actionListener);
        this.buttonJenis.addActionListener(actionListener);
        this.buttonDropbox.addActionListener(actionListener);

        this.add(buttonMasyarakat);
        this.add(buttonKurir);
        this.add(buttonKategori);
        this.add(buttonJenis);
        this.add(buttonDropbox);

    }

    public JButton getButtonMasyarakat() {
        return buttonMasyarakat;
    }

    public JButton getButtonKurir() {
        return buttonKurir;
    }

    public JButton getButtonKategori() {
        return buttonKategori;
    }

    public JButton getButtonJenis() {
        return buttonJenis;
    }

    public JButton getButtonDropbox() {
        return buttonDropbox;
    }

    public void showMasyarakatFrame() {
        if(masyarakatFrame == null) {
            masyarakatFrame = new MasyarakatFrame(masyarakatDao);
        }
        masyarakatFrame.setVisible(true);
    }

    public void showKurirFrame() {
        if(kurirFrame == null) {
            kurirFrame = new KurirFrame(kurirDao);
        }
        kurirFrame.setVisible(true);
    }

    public void showKategoriFrame() {
        if(kategoriFrame == null) {
            kategoriFrame = new KategoriFrame(kategoriDao);
        }
        kategoriFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
}