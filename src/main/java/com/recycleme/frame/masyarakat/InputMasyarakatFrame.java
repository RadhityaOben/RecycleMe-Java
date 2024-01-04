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

    private JLabel metodePembayaranLabel;
    private JComboBox metodePembayaranComboBox;

    private JButton simpanButton;
    private JButton resetButton;

    private MasyarakatDao masyarakatDao;
    private MasyarakatFrame masyarakatFrame;

    public InputMasyarakatFrame(MasyarakatFrame frame) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);
        masyarakatDao = new MasyarakatDao();
        masyarakatFrame = frame;

        MasyarakatSimpan MasyarakatSimpanActionListener = new MasyarakatSimpan(this, masyarakatDao, masyarakatFrame);
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

        metodePembayaranLabel = new JLabel("Metode Pembayaran");
        metodePembayaranLabel.setBounds(50, 400, 100, 30);
        metodePembayaranComboBox = new JComboBox();
        metodePembayaranComboBox.setBounds(200, 400, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 500, 100, 30);
        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 500, 100, 30);

        simpanButton.addActionListener(MasyarakatSimpanActionListener);
        resetButton.addActionListener(MasyarakatResetActionListener);

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
        add(metodePembayaranLabel);
        add(metodePembayaranComboBox);
        add(simpanButton);
        add(resetButton);

    }

    public void populateMetodePembayaranComboBox() {
        metodePembayaranComboBox.addItem("Cash");
        metodePembayaranComboBox.addItem("Debit");
        metodePembayaranComboBox.addItem("Kredit");
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

    public String getMetodePembayaran() {
        return this.metodePembayaranComboBox.getSelectedItem().toString();
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
        this.metodePembayaranComboBox.setSelectedIndex(0);
    }

    public JButton getResetButton() {
        return resetButton;
    }
}
