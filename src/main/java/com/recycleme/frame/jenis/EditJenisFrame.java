package com.recycleme.frame.jenis;

import com.recycleme.actionListener.jenis.JenisDefault;
import com.recycleme.actionListener.jenis.JenisReset;
import com.recycleme.actionListener.jenis.JenisSimpan;
import com.recycleme.actionListener.jenis.JenisUpdate;
import com.recycleme.actionListener.jenis.JenisDefault;
import com.recycleme.actionListener.jenis.JenisUpdate;
import com.recycleme.dao.JenisDao;
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

    private JLabel jenisLabel;
    private JComboBox jenisComboBox;

    private JenisDao jenisDao;
    private JenisFrame jenisFrame;

    private List<Jenis> jenisList;

    private JLabel poinLabel;
    private JTextField poinField;
    private Jenis oldJenis;


    public EditJenisFrame(JenisFrame frame, int id) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);
        jenisDao = new JenisDao();
        jenisFrame = frame;

        oldJenis = jenisDao.findById(id);

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

        jenisLabel = new JLabel("Jenis");
        jenisLabel.setBounds(50, 150, 100, 30);

        jenisComboBox = new JComboBox();

        jenisComboBox.setBounds(200, 150, 200, 30);

        poinLabel = new JLabel("Jumlah Poin");
        poinLabel.setBounds(50, 200, 100, 30);

        poinField = new JTextField();
        poinField.setBounds(200, 200, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 250, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 250, 100, 30);

//        simpanButton.addActionListener();
        resetButton.addActionListener(jenisResetActionListener);
        simpanButton.addActionListener(jenisUpdateActionListener);

        populateJenisComboBox();

        this.add(labelFrame);
        this.add(namaLabel);
        this.add(namaField);
        this.add(jenisLabel);
        this.add(jenisComboBox);
        this.add(poinLabel);
        this.add(poinField);
        this.add(simpanButton);
        this.add(resetButton);
    }

    public void populateJenisComboBox() {
        jenisList = jenisDao.findAll();
        jenisList.forEach(jenis -> {
            jenisComboBox.addItem(jenis.getNama());
        });
    }

    public String getNama() {
        return namaField.getText();
    }

    public Jenis getJenis() {
        return jenisList.get(jenisComboBox.getSelectedIndex());
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

    public int getId() {
        return oldJenis.getId();
    }
    public int getPoin() {
        return Integer.parseInt(poinField.getText());
    }

    public Kategori getKategori() {
        return oldJenis.getKategori();
    }

    public String nama() {
        return oldJenis.getNama();
    }

    public void defaultValue() {
        namaField.setText(oldJenis.getNama());
        for(int i = 0; i < jenisComboBox.getItemCount(); i++) {
            if(jenisComboBox.getItemAt(i) == oldJenis.getKategori().getNama()) {
                jenisComboBox.setSelectedIndex(i);
                break;
            }
        }
        poinField.setText(Integer.toString(oldJenis.getPoin()));
    }
}