package com.recycleme.frame.kategori;

import com.recycleme.dao.KategoriDao;
import com.recycleme.actionListener.kategori.KategoriSimpan;
import com.recycleme.actionListener.kategori.KategoriReset;


import javax.swing.*;
import java.awt.*;


public class InputKategoriFrame extends JFrame{

    private JLabel labelFrame;

    private JLabel namaLabel;

    private JTextField namaField;

    private JButton simpanButton;

    private JButton resetButton;

    private KategoriDao kategoriDao;

    private KategoriFrame kategoriFrame;

    private JComboBox jenisKategoriSampahElektronikComboBox = new JComboBox();


    public InputKategoriFrame(KategoriFrame frame) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 400);
        kategoriDao = new KategoriDao();
        kategoriFrame = frame;

        KategoriSimpan KategoriSimpanActionListener = new KategoriSimpan(this, kategoriDao, kategoriFrame);
        KategoriReset KategoriResetActionListener = new KategoriReset(this);

        labelFrame = new JLabel("Input Kategori");
        labelFrame.setBounds(50, 10, 200, 30);
        labelFrame.setFont(new Font("Tahoma", 1, 18));

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 100, 100, 30);

        namaField = new JTextField();
        namaField.setBounds(200, 100, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 150, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 150, 100, 30);


        simpanButton.addActionListener(KategoriSimpanActionListener);
        resetButton.addActionListener(KategoriResetActionListener);

        populateJenisKategoriSampahElektronikComboBox();

        add(labelFrame);
        add(namaLabel);
        add(namaField);
        add(simpanButton);
        add(resetButton);

        setVisible(true);
    }

    public String getNama() {
        return namaField.getText();
    }

    public void setNama(String nama) {
        namaField.setText(nama);
    }

    public void showMessageSuccess(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showMessageError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showMessageWarning(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public int showConfirmMessage(String message, String title, int option) {
        return JOptionPane.showConfirmDialog(this, message, title, option);
    }

    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void reset() {
        this.namaField.setText("");
    }

    public void populateJenisKategoriSampahElektronikComboBox() {
        jenisKategoriSampahElektronikComboBox.removeAllItems();
        jenisKategoriSampahElektronikComboBox.addItem("Pilih Jenis Kategori Sampah Elektronik");
        jenisKategoriSampahElektronikComboBox.addItem("Handphone");
        jenisKategoriSampahElektronikComboBox.addItem("Laptop");
        jenisKategoriSampahElektronikComboBox.addItem("Televisi");
        jenisKategoriSampahElektronikComboBox.addItem("Kulkas");
        jenisKategoriSampahElektronikComboBox.addItem("Mesin Cuci");
    }



}
