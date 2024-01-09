package com.recycleme.frame.jenis;

import com.recycleme.actionListener.jenis.JenisDefault;
import com.recycleme.actionListener.jenis.JenisReset;
import com.recycleme.actionListener.jenis.JenisSimpan;
import com.recycleme.actionListener.jenis.JenisUpdate;
import com.recycleme.actionListener.jenis.JenisDefault;
import com.recycleme.actionListener.jenis.JenisUpdate;
import com.recycleme.dao.JenisDao;
import com.recycleme.dao.KategoriDao;
import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.jenis.Jenis;
import com.recycleme.dao.JenisDao;
import com.recycleme.model.kategori.Kategori;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditJenisFrame extends JFrame {
    private JLabel labelFrame;

    private JLabel namaLabel;
    private JTextField namaField;

    private JButton simpanButton;
    private JButton resetButton;

    private JLabel kategoriLabel;
    private JComboBox kategoriComboBox;

    private JLabel poinLabel;
    private JTextField poinField;

    private JenisDao jenisDao;
    private JenisFrame jenisFrame;
    private Jenis oldJenis;

    private KategoriDao kategoriDao;
    private List<Kategori> kategoriList;

    public EditJenisFrame(JenisFrame frame, int id) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);
        jenisDao = new JenisDao();
        jenisFrame = frame;

        oldJenis = jenisDao.findById(id);
        kategoriDao = new KategoriDao();
        kategoriList = kategoriDao.findAll();

        JenisUpdate jenisUpdateActionListener = new JenisUpdate(this, jenisDao, jenisFrame);
        JenisDefault jenisResetActionListener = new JenisDefault(this);

        labelFrame = new JLabel("Input Jenis");
        labelFrame.setBounds(50, 10, 300, 30);
        labelFrame.setFont(new Font("Tahoma", 1, 18));

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 100, 100, 30);

        namaField = new JTextField();
        namaField.setText(oldJenis.getNama());
        namaField.setBounds(200, 100, 200, 30);

        kategoriLabel = new JLabel("Jenis");
        kategoriLabel.setBounds(50, 150, 100, 30);

        kategoriComboBox = new JComboBox();
        kategoriComboBox.setBounds(200, 150, 200, 30);
        populateKategoriComboBox(kategoriList);

        poinLabel = new JLabel("Jumlah Poin");
        poinLabel.setBounds(50, 200, 100, 30);

        poinField = new JTextField();
        poinField.setText(Integer.toString(oldJenis.getPoin()));
        poinField.setBounds(200, 200, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 250, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 250, 100, 30);

        resetButton.addActionListener(jenisResetActionListener);
        simpanButton.addActionListener(jenisUpdateActionListener);

        this.add(labelFrame);
        this.add(namaLabel);
        this.add(namaField);
        this.add(kategoriLabel);
        this.add(kategoriComboBox);
        this.add(poinLabel);
        this.add(poinField);
        this.add(simpanButton);
        this.add(resetButton);
    }

    public void populateKategoriComboBox(List<Kategori> kategoriList) {
        for(Kategori kategori : kategoriList) {
            kategoriComboBox.addItem(kategori.getNama());
        }
    }

    public int getId() {
        return oldJenis.getId();
    }

    public String getNama() {
        return namaField.getText();
    }

    public Kategori getKategori() {
        return kategoriList.get(kategoriComboBox.getSelectedIndex());
    }

    public int getPoin() {
        return Integer.parseInt(poinField.getText());
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

    public void defaultValue() {
        namaField.setText(oldJenis.getNama());
        for(int i = 0; i < kategoriComboBox.getItemCount(); i++) {
            if(kategoriComboBox.getItemAt(i) == oldJenis.getKategori().getNama()) {
                kategoriComboBox.setSelectedIndex(i);
                break;
            }
        }
        poinField.setText(Integer.toString(oldJenis.getPoin()));
    }

    public String getOldNama() {
        return oldJenis.getNama();
    }

    public Kategori getOldKategori() {
        return oldJenis.getKategori();
    }

    public int getOldPoin() {
        return oldJenis.getPoin();
    }
}