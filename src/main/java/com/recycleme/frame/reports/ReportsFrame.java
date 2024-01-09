package com.recycleme.frame.reports;

import com.recycleme.actionListener.reports.CetakPDF;
import com.recycleme.actionListener.reports.PreviewPDF;

import javax.swing.*;

public class ReportsFrame extends JFrame {
    private JLabel labelTitle;

    private JComboBox comboBoxPilihan;

    private JButton cetakPDF;
    private JButton previewPDF;

    private CetakPDF cetakPDFListener;
    private PreviewPDF previewPDFListener;

    public ReportsFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        this.labelTitle = new JLabel("Cetak Laporan");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 18));

        this.comboBoxPilihan = new JComboBox();
        this.comboBoxPilihan.setBounds(50, 50, 150, 30);

        this.cetakPDF = new JButton("Cetak PDF");
        this.cetakPDF.setBounds(50, 100, 150, 30);

        this.previewPDF = new JButton("Preview PDF");
        this.previewPDF.setBounds(50, 150, 150, 30);

        this.cetakPDFListener = new CetakPDF(this);
        this.cetakPDF.addActionListener(cetakPDFListener);

        this.previewPDFListener = new PreviewPDF(this);
        this.previewPDF.addActionListener(previewPDFListener);

        this.populateComboBox();

        this.add(labelTitle);
        this.add(comboBoxPilihan);
        this.add(cetakPDF);
        this.add(previewPDF);

    }

    public void populateComboBox() {
        String[] pilihan = {"Masyarakat", "Kurir", "Dropbox"};
        for(String p : pilihan) {
            comboBoxPilihan.addItem(p);
        }
    }

    public String getComboBoxPilihan() {
        return comboBoxPilihan.getSelectedItem().toString();
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showPreviewPDF(String message) {
        JOptionPane.showMessageDialog(this, message, "Preview PDF", JOptionPane.INFORMATION_MESSAGE);
    }

}
