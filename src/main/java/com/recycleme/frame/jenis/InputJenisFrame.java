package com.recycleme.frame.jenis;

import com.recycleme.actionListener.kategori.KategoriReset;
import com.recycleme.actionListener.kategori.KategoriSimpan;
import com.recycleme.dao.KategoriDao;
import com.recycleme.frame.kategori.KategoriFrame;

import javax.swing.*;
import java.awt.*;

public class InputJenisFrame extends JFrame{
    private JLabel labelFrame;

    private JLabel namaLabel;

    private JTextField namaField;

    private JButton simpanButton;

    private JButton resetButton;

    private KategoriDao kategoriDao;

    private KategoriFrame kategoriFrame;

    private JComboBox jenisKategoriSampahElektronikComboBox = new JComboBox();


    public InputJenisFrame(KategoriFrame frame) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);
        kategoriDao = new KategoriDao();
        kategoriFrame = frame;

        KategoriSimpan KategoriSimpanActionListener = new KategoriSimpan(this, kategoriDao, kategoriFrame);
        KategoriReset KategoriResetActionListener = new KategoriReset(this);

        labelFrame = new JLabel("Input Kategori");
        labelFrame.setBounds(50, 10, 300, 30);
        labelFrame.setFont(new Font("Tahoma", 1, 18));

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 100, 100, 30);

        namaField = new JTextField();
        namaField.setBounds(200, 100, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 500, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 500, 100, 30);


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

    public String getNamaField() {
        return namaField.getText();
    }

    public void setNamaField(String nama) {
        namaField.setText(nama);
    }

    public void showMessageSuccess(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void reset() {
        this.namaField.setText("");
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
