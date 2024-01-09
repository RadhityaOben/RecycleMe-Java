package com.recycleme.frame.kurir;

import com.recycleme.actionListener.kurir.KurirReset;
import com.recycleme.actionListener.kurir.KurirSimpan;
import com.recycleme.dao.KurirDao;
import com.recycleme.frame.kurir.KurirFrame;

import javax.swing.*;
import java.awt.*;

public class InputKurirFrame extends JFrame {
    private JLabel labelFrame;

    private JLabel namaLabel;
    private JTextField namaField;

    private JLabel noTelpLabel;
    private JTextField noTelpField;

    private JLabel jenisKendaranLabel;
    private JComboBox jenisKendaranComboBox;

    private JLabel kelengkapanBerkasLabel;
    private JComboBox kelengkapanBerkasComboBox;

    private JButton simpanButton;
    private JButton resetButton;

    private KurirDao kurirDao;
    private KurirFrame kurirFrame;

    public InputKurirFrame(KurirFrame frame) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 480);
        kurirDao = new KurirDao();
        kurirFrame = frame;

        KurirSimpan KurirSimpanActionListener = new KurirSimpan(this, kurirDao, kurirFrame);
        KurirReset KurirResetActionListener = new KurirReset(this);

        labelFrame = new JLabel("Input Kurir");
        labelFrame.setBounds(50, 10, 300, 30);
        labelFrame.setFont(new Font("Tahoma", 1, 18));

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 100, 100, 30);

        namaField = new JTextField();
        namaField.setBounds(200, 100, 200, 30);

        noTelpLabel = new JLabel("No Telp");
        noTelpLabel.setBounds(50, 150, 100, 30);

        noTelpField = new JTextField();
        noTelpField.setBounds(200, 150, 200, 30);

        jenisKendaranLabel = new JLabel("Jenis Kendaran");
        jenisKendaranLabel.setBounds(50, 200, 100, 30);

        jenisKendaranComboBox = new JComboBox();
        jenisKendaranComboBox.setBounds(200, 200, 200, 30);

        kelengkapanBerkasLabel = new JLabel("Kelengkapan Berkas");
        kelengkapanBerkasLabel.setBounds(50, 250, 100, 30);

        kelengkapanBerkasComboBox = new JComboBox();
        kelengkapanBerkasComboBox.setBounds(200, 250, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 340, 100, 30);
        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 340, 100, 30);

        simpanButton.addActionListener(KurirSimpanActionListener);
        resetButton.addActionListener(KurirResetActionListener);

        populateJenisKendaranComboBox();
        populateKelengkapanBerkasComboBox();

        add(labelFrame);
        add(namaLabel);
        add(namaField);
        add(noTelpLabel);
        add(noTelpField);
        add(jenisKendaranLabel);
        add(jenisKendaranComboBox);
        add(kelengkapanBerkasLabel);
        add(kelengkapanBerkasComboBox);
        add(simpanButton);
        add(resetButton);

    }

    public void populateJenisKendaranComboBox() {
        jenisKendaranComboBox.addItem("Roda 2");
        jenisKendaranComboBox.addItem("Roda 4");
        jenisKendaranComboBox.addItem("Lebih dari Roda 4");
    }

    public void populateKelengkapanBerkasComboBox() {
        kelengkapanBerkasComboBox.addItem("Lengkap");
        kelengkapanBerkasComboBox.addItem("Tidak Lengkap");
    }

    public String getNama() {
        return this.namaField.getText();
    }

    public String getNoTelp() {
        return this.noTelpField.getText();
    }

    public String getJenisKendaraan() {
        return this.jenisKendaranComboBox.getSelectedItem().toString();
    }

    public String getKelengkapanBerkas() {
        return this.kelengkapanBerkasComboBox.getSelectedItem().toString();
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void reset() {
        this.namaField.setText("");
        this.noTelpField.setText("");
        this.jenisKendaranComboBox.setSelectedIndex(0);
        this.kelengkapanBerkasComboBox.setSelectedIndex(0);
    }
}
