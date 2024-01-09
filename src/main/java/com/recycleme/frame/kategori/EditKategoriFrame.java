package com.recycleme.frame.kategori;

import com.recycleme.actionListener.kategori.KategoriDefault;
import com.recycleme.actionListener.kategori.KategoriUpdate;
import com.recycleme.dao.KategoriDao;
import com.recycleme.model.kategori.Kategori;

import javax.swing.*;
import java.awt.*;


public class EditKategoriFrame extends JFrame{

    private JLabel labelFrame;

    private JLabel namaLabel;

    private JTextField namaField;

    private JButton simpanButton;

    private JButton resetButton;

    private KategoriDao kategoriDao;

    private KategoriFrame kategoriFrame;

    private JComboBox jenisKategoriSampahElektronikComboBox = new JComboBox();

    private Kategori oldKategori;


    public EditKategoriFrame(KategoriFrame frame, int id) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 400);
        kategoriDao = new KategoriDao();
        kategoriFrame = frame;

        oldKategori = kategoriDao.findById(id);

        KategoriUpdate KategoriUpdateActionListener = new KategoriUpdate(this, kategoriDao, kategoriFrame);
        KategoriDefault KategoriResetActionListener = new KategoriDefault(this);

        labelFrame = new JLabel("Edit Kategori");
        labelFrame.setBounds(50, 10, 300, 30);
        labelFrame.setFont(new Font("Tahoma", 1, 18));

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 100, 100, 30);

        namaField = new JTextField(oldKategori.getNama());
        namaField.setBounds(200, 100, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 150, 100, 30);

        resetButton = new JButton("Default");
        resetButton.setBounds(200, 150, 100, 30);


        simpanButton.addActionListener(KategoriUpdateActionListener);
        resetButton.addActionListener(KategoriResetActionListener);

        populateJenisKategoriSampahElektronikComboBox();

        add(labelFrame);
        add(namaLabel);
        add(namaField);
        add(simpanButton);
        add(resetButton);

        setVisible(true);
    }

    public int getId() {
        return oldKategori.getId();
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

    public void defaultValue() {
        namaField.setText(oldKategori.getNama());
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
