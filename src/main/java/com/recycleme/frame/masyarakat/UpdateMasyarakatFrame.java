package com.recycleme.frame.masyarakat;

import javax.swing.*;
import java.awt.*;

import com.recycleme.dao.MasyarakatDao;
import com.recycleme.actionListener.masyarakat.MasyarakatUpdate;
import com.recycleme.actionListener.masyarakat.MasyarakatReset;

public class UpdateMasyarakatFrame extends JFrame {
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
    private JComboBox<String> metodePembayaranComboBox;

    private JButton updateButton;
    private JButton resetButton;

    private MasyarakatDao masyarakatDao;
    private MasyarakatFrame masyarakatFrame;

    public UpdateMasyarakatFrame(MasyarakatFrame frame) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);
        masyarakatDao = new MasyarakatDao();
        masyarakatFrame = frame;

        labelFrame = new JLabel("Perbarui Informasi Masyarakat");
        labelFrame.setBounds(50, 10, 300, 30);
        labelFrame.setFont(new Font("Tahoma", Font.BOLD, 18));

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
        metodePembayaranLabel.setBounds(50, 400, 150, 30);
        metodePembayaranComboBox = new JComboBox<>();
        metodePembayaranComboBox.setBounds(200, 400, 200, 30);

        updateButton = new JButton("Perbarui");
        updateButton.setBounds(50, 500, 100, 30);
        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 500, 100, 30);

        metodePembayaranComboBox.setSelectedItem("Cash");

        updateButton.addActionListener(new MasyarakatUpdate(this, masyarakatDao, masyarakatFrame));
        resetButton.addActionListener(new MasyarakatReset(this));

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
        add(updateButton);
        add(resetButton);
    }

    // Tambahkan logika perbarui sesuai kebutuhan
    public void update() {
        String updatedNama = this.namaField.getText();
        String updatedAlamat = this.alamatField.getText();
        String updatedEmail = this.emailField.getText();
        String updatedNoTelp = this.noTelpField.getText();
        String updatedMetodePembayaran = this.metodePembayaranComboBox.getSelectedItem().toString();
    }
    public JButton getResetButton() {
        return resetButton;
    }

}
