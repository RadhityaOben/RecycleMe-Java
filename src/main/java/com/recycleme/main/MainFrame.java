package com.recycleme.main;

import com.recycleme.actionListener.main.MainButtonActionListener;
import com.recycleme.dao.*;
import com.recycleme.frame.dropbox.DropboxFrame;
import com.recycleme.frame.kurir.KurirFrame;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.frame.kategori.KategoriFrame;
import com.recycleme.dao.KurirDao;
import com.recycleme.frame.jenis.JenisFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private GridBagConstraints gbc;

    private MasyarakatFrame masyarakatFrame;
    private MasyarakatDao masyarakatDao = new MasyarakatDao();

    private KurirFrame kurirFrame;
    private KurirDao kurirDao = new KurirDao();

    private KategoriFrame kategoriFrame;
    private KategoriDao kategoriDao = new KategoriDao();

    private JenisFrame jenisFrame;
    private JenisDao jenisDao = new JenisDao();

    private DropboxFrame dropboxFrame;
    private DropboxDao dropboxDao = new DropboxDao();

    private JLabel labelTitle;
    private JButton buttonMasyarakat;
    private JButton buttonKurir;
    private JButton buttonKategori;
    private JButton buttonJenis;
    private JButton buttonDropbox;

    public MainFrame() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        MainFrame.this,
                        "Apakah anda yakin ingin keluar?",
                        "Exit", JOptionPane.YES_NO_OPTION
                );
                if(confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        this.setSize(850, 300);

        this.setLayout(null);

        this.labelTitle = new JLabel("RecycleMe");
        this.labelTitle.setBounds(0, 10, 850, 30);
        this.labelTitle.setHorizontalAlignment(JLabel.CENTER);

        this.buttonMasyarakat = new JButton("Masayarakat");
        this.buttonMasyarakat.setBounds(50, 50, 150, 30);

        this.buttonKurir = new JButton("Kurir");
        this.buttonKurir.setBounds(200, 50, 150, 30);

        this.buttonKategori = new JButton("Kategori");
        this.buttonKategori.setBounds(350, 50, 150, 30);

        this.buttonJenis = new JButton("Jenis");
        this.buttonJenis.setBounds(500, 50, 150, 30);

        this.buttonDropbox = new JButton("Dropbox");
        this.buttonDropbox.setBounds(650, 50, 150, 30);

        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonMasyarakat.addActionListener(actionListener);
        this.buttonKurir.addActionListener(actionListener);
        this.buttonKategori.addActionListener(actionListener);
        this.buttonJenis.addActionListener(actionListener);
        this.buttonDropbox.addActionListener(actionListener);

        this.add(labelTitle);
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

    public void showJenisFrame() {
        if(jenisFrame == null) {
            jenisFrame = new JenisFrame(jenisDao);
        }
        jenisFrame.setVisible(true);
    }

    public void showDropboxFrame() {
        if(dropboxFrame == null) {
            dropboxFrame = new DropboxFrame(dropboxDao);
        }
        dropboxFrame.setVisible(true);
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
