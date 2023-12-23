package com.recycleme.frame.masyarakat;

import javax.swing.*;
import java.awt.*;

import com.recycleme.actionListener.masyarakat.MasyarakatReset;
import com.recycleme.actionListener.masyarakat.MasyarakatSimpan;
import com.recycleme.dao.MasyarakatDao;

import static java.lang.Integer.parseInt;

public class InputMasyarakatFrame extends JFrame {
    private JLabel labelFrame;

    private JLabel namaLabel;
    private JTextField namaField;

    private JLabel alamatLabel;
    private JTextArea alamatField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JLabel noTelpLabel;
    private JTextField noTelpField;

    private JLabel statusRegistrasiLabel;
    private JComboBox statusRegistrasiComboBox;

    private JLabel statusPenjemputanLabel;
    private JComboBox statusPenjemputanComboBox;

    private JLabel metodePembayaranLabel;
    private JComboBox metodePembayaranComboBox;

    private JLabel poinLabel;
    private JTextField poinField;

    private JButton simpanButton;
    private JButton resetButton;

    private MasyarakatDao masyarakatDao;

    public InputMasyarakatFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);

        MasyarakatSimpan MasyarakatSimpanActionListener = new MasyarakatSimpan(this, masyarakatDao);
        MasyarakatReset MasyarakatResetActionListener = new MasyarakatReset(this);

        labelFrame = new JLabel("Input Masyarakat");
        labelFrame.setBounds(50, 10, 300, 30);
        labelFrame.setFont(new Font("Tahoma", 1, 18));

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 100, 100, 30);

        namaField = new JTextField();
        namaField.setBounds(200, 100, 200, 30);

        alamatLabel = new JLabel("Alamat");
        alamatLabel.setBounds(50, 150, 100, 30);

        alamatField = new JTextArea();
        alamatField.setBounds(200, 150, 200, 30);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 200, 100, 30);

        emailField = new JTextField();
        emailField.setBounds(200, 200, 200, 30);

        noTelpLabel = new JLabel("No Telp");
        noTelpLabel.setBounds(50, 250, 100, 30);
        noTelpField = new JTextField();
        noTelpField.setBounds(200, 250, 200, 30);

        statusRegistrasiLabel = new JLabel("Status Registrasi");
        statusRegistrasiLabel.setBounds(50, 300, 100, 30);

        statusRegistrasiComboBox = new JComboBox();
        statusRegistrasiComboBox.setBounds(200, 300, 200, 30);

        statusPenjemputanLabel = new JLabel("Status Penjemputan");
        statusPenjemputanLabel.setBounds(50, 350, 100, 30);
        statusPenjemputanComboBox = new JComboBox();
        statusPenjemputanComboBox.setBounds(200, 350, 200, 30);

        metodePembayaranLabel = new JLabel("Metode Pembayaran");
        metodePembayaranLabel.setBounds(50, 400, 100, 30);
        metodePembayaranComboBox = new JComboBox();
        metodePembayaranComboBox.setBounds(200, 400, 200, 30);

        poinLabel = new JLabel("Poin");
        poinLabel.setBounds(50, 450, 100, 30);
        poinField = new JTextField(20);
        poinField.setBounds(200, 450, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 500, 100, 30);
        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 500, 100, 30);

        simpanButton.addActionListener(MasyarakatSimpanActionListener);
        resetButton.addActionListener(MasyarakatResetActionListener);

        populateStatusRegistrasiComboBox();
        populateStatusPenjemputanComboBox();
        populateMetodePembayaranComboBox();

        add(labelFrame);
        add(namaLabel);
        add(namaField);
        add(alamatLabel);
        add(alamatField);
        add(emailLabel);
        add(emailField);
        add(noTelpLabel);
        add(noTelpField);
        add(statusRegistrasiLabel);
        add(statusRegistrasiComboBox);
        add(statusPenjemputanLabel);
        add(statusPenjemputanComboBox);
        add(metodePembayaranLabel);
        add(metodePembayaranComboBox);
        add(poinLabel);
        add(poinField);
        add(simpanButton);
        add(resetButton);

    }

    public void populateStatusRegistrasiComboBox() {
        statusRegistrasiComboBox.addItem("Aktif");
        statusRegistrasiComboBox.addItem("Tidak Aktif");
    }

    public void populateStatusPenjemputanComboBox() {
        statusPenjemputanComboBox.addItem("Aktif");
        statusPenjemputanComboBox.addItem("Tidak Aktif");
    }

    public void populateMetodePembayaranComboBox() {
        metodePembayaranComboBox.addItem("Cash");
        metodePembayaranComboBox.addItem("Poin");
    }

    public String getNama() {
        return this.namaField.getText();
    }

    public String getAlamat() {
        return this.alamatField.getText();
    }

    public String getEmail() {
        return this.emailField.getText();
    }

    public String getNoTelp() {
        return this.noTelpField.getText();
    }

    public String getStatusRegistrasi() {
        return this.statusRegistrasiComboBox.getSelectedItem().toString();
    }

    public String getStatusPenjemputan() {
        return this.statusPenjemputanComboBox.getSelectedItem().toString();
    }

    public String getMetodePembayaran() {
        return this.metodePembayaranComboBox.getSelectedItem().toString();
    }

    public int getPoin() {
        return parseInt(this.poinField.getText());
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
        this.alamatField.setText("");
        this.emailField.setText("");
        this.noTelpField.setText("");
        this.statusRegistrasiComboBox.setSelectedIndex(0);
        this.statusPenjemputanComboBox.setSelectedIndex(0);
        this.metodePembayaranComboBox.setSelectedIndex(0);
        this.poinField.setText("");
    }
}
