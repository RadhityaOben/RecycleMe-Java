package com.recycleme.frame.jenis;

import com.recycleme.actionListener.jenis.JenisReset;
import com.recycleme.actionListener.jenis.JenisSimpan;
import com.recycleme.dao.JenisDao;
import com.recycleme.model.kategori.Kategori;
import com.recycleme.dao.KategoriDao;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InputJenisFrame extends JFrame {

    private JLabel labelFrame;

    private JLabel namaLabel;
    private JTextField namaField;

    private JButton simpanButton;
    private JButton resetButton;

    private JLabel kategoriLabel;
    private JComboBox kategoriComboBox;

    private JenisDao jenisDao;
    private JenisFrame jenisFrame;

    private KategoriDao kategoriDao = new KategoriDao();
    private List<Kategori> kategoriList;


    public InputJenisFrame(JenisFrame frame) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);
        jenisDao = new JenisDao();

        jenisFrame = frame;

        JenisReset jenisResetActionListener = new JenisReset(this);
        JenisSimpan jenisSimpanActionListener = new JenisSimpan(this, jenisDao, jenisFrame);

        labelFrame = new JLabel("Input Jenis");
        labelFrame.setBounds(50, 10, 300, 30);
        labelFrame.setFont(new Font("Tahoma", 1, 18));

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 100, 100, 30);

        namaField = new JTextField();
        namaField.setBounds(200, 100, 200, 30);

        kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setBounds(50, 150, 100, 30);

        kategoriComboBox = new JComboBox();
        kategoriComboBox.setBounds(200, 150, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 200, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 200, 100, 30);

//        simpanButton.addActionListener();
        resetButton.addActionListener(jenisResetActionListener);
        simpanButton.addActionListener(jenisSimpanActionListener);

        populateKategoriComboBox();

        this.add(labelFrame);
        this.add(namaLabel);
        this.add(namaField);
        this.add(kategoriLabel);
        this.add(kategoriComboBox);
        this.add(simpanButton);
        this.add(resetButton);
    }

    public void populateKategoriComboBox() {
        kategoriList = kategoriDao.findAll();
        kategoriList.forEach(kategori -> {
            kategoriComboBox.addItem(kategori.getNama());
        });
    }

    public String getNama() {
        return namaField.getText();
    }

    public Kategori getKategori() {
        return kategoriList.get(kategoriComboBox.getSelectedIndex());
    }

    public JButton getSimpanButton() {
        return simpanButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void reset() {
        namaField.setText("");
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
