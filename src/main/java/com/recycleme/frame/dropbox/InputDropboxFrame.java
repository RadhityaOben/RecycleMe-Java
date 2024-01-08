package com.recycleme.frame.dropbox;

import com.recycleme.actionListener.dropbox.DropboxReset;
import com.recycleme.actionListener.dropbox.DropboxSimpan;
import com.recycleme.dao.DropboxDao;

import javax.swing.*;
import java.awt.*;

public class InputDropboxFrame extends JFrame {

    private JLabel labelFrame;

    private JLabel labelNama;
    private JTextField fieldNama;

    private JLabel labelAlamat;
    private JTextArea fieldAlamat;

    private JLabel labelMasayarakat;
    private JTextField fieldMasyarakat;

    private JLabel labelKurir;
    private JTextField fieldKurir;

    private JLabel labelJenis;
    private JTextField fieldJenis;

    private JButton simpanButton;
    private JButton resetButton;

    public InputDropboxFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);

        labelFrame = new JLabel("Input Dropbox");
        labelFrame.setBounds(50, 10, 300, 30);
        labelFrame.setFont(new Font("Tahoma", 1, 18));

        labelNama = new JLabel("Nama");
        labelNama.setBounds(50, 100, 100, 30);

        fieldNama = new JTextField();
        fieldNama.setBounds(200, 100, 200, 30);

        labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(50, 150, 100, 30);

        fieldAlamat = new JTextArea();
        fieldAlamat.setBounds(200, 150, 200, 100);

        labelMasayarakat = new JLabel("Masyarakat");
        labelMasayarakat.setBounds(50, 250, 100, 30);

        fieldMasyarakat = new JTextField();
        fieldMasyarakat.setBounds(200, 250, 200, 30);

        labelKurir = new JLabel("Kurir");
        labelKurir.setBounds(50, 300, 100, 30);

        fieldKurir = new JTextField();
        fieldKurir.setBounds(200, 300, 200, 30);

        labelJenis = new JLabel("Jenis");
        labelJenis.setBounds(50, 350, 100, 30);

        fieldJenis = new JTextField();
        fieldJenis.setBounds(200, 350, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 400, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 400, 100, 30);

        DropboxDao dropboxDao = new DropboxDao();
        DropboxFrame dropboxFrame = new DropboxFrame(dropboxDao);

        DropboxSimpan dropboxSimpan = new DropboxSimpan(this, dropboxDao, dropboxFrame);
        DropboxReset dropboxReset = new DropboxReset(this);

        simpanButton.addActionListener(dropboxSimpan);
        resetButton.addActionListener(dropboxReset);

        add(labelFrame);
        add(labelNama);
        add(fieldNama);
        add(labelAlamat);
        add(fieldAlamat);
        add(labelMasayarakat);
        add(fieldMasyarakat);
        add(labelKurir);
        add(fieldKurir);
        add(labelJenis);
        add(fieldJenis);
        add(simpanButton);
        add(resetButton);
    }

    public String getNama() {
        return fieldNama.getText();
    }

    public String getAlamat() {
        return fieldAlamat.getText();
    }

    public String getMasyarakat() {
        return fieldMasyarakat.getText();
    }

    public String getKurir() {
        return fieldKurir.getText();
    }

    public String getJenis() {
        return fieldJenis.getText();
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void reset() {
        fieldNama.setText("");
        fieldAlamat.setText("");
        fieldMasyarakat.setText("");
        fieldKurir.setText("");
        fieldJenis.setText("");
    }
}
