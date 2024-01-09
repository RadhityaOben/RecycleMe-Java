package com.recycleme.frame.dropbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import com.recycleme.actionListener.dropbox.DropboxHapus;
import com.recycleme.actionListener.dropbox.DropboxInput;
import com.recycleme.actionListener.reports.PDFReport;
import com.recycleme.dao.DropboxDao;
import com.recycleme.frame.reports.ReportsFrame;
import com.recycleme.model.dropbox.Dropbox;
import com.recycleme.model.dropbox.DropboxTableModel;

public class DropboxFrame extends JFrame{
    private JLabel labelTitle;

    private JButton buttonInputDropbox;
    private JButton buttonCetakPDF;
    private JButton buttonDeleteDropbox;

    private JTable tableDropbox;
    private JScrollPane scrollPane;

    private List<Dropbox> dropboxList;
    private DropboxTableModel tableModel;

    private InputDropboxFrame inputDropboxFrame;
    private DropboxInput dropboxInput;
    private DropboxHapus dropboxHapus;
//    TODO: uncomment this when PDFReport is ready
//    private ReportsFrame reportsFrame;
//    private PDFReport pdfReport;

    public DropboxFrame(DropboxDao dropboxDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLayout(null);

        this.dropboxInput = new DropboxInput(this);
        this.dropboxHapus = new DropboxHapus(this, dropboxDao);

//        TODO: uncomment this when PDFReport is ready
//        this.pdfReport = new PDFReport(this);

        this.labelTitle = new JLabel("Daftar Semua Dropbox");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputDropbox = new JButton("Input Dropbox");
        this.buttonInputDropbox.setBounds(50, 50, 150, 30);

        this.buttonDeleteDropbox = new JButton("Delete Dropbox");
        this.buttonDeleteDropbox.setBounds(250, 50, 150, 30);

        this.buttonCetakPDF = new JButton("Cetak Laporan PDF");
        this.buttonCetakPDF.setBounds(450, 50, 150, 30);

//        TODO: uncomment this when PDFReport is ready
//        this.buttonCetakPDF.addActionListener(pdfReport);

        this.buttonInputDropbox.addActionListener(dropboxInput);
        this.buttonDeleteDropbox.addActionListener(dropboxHapus);

        this.dropboxList = dropboxDao.findAll();

        this.tableModel = new DropboxTableModel(dropboxList);

        this.tableDropbox = new JTable(tableModel);
        tableDropbox.setModel(tableModel);
        this.scrollPane = new JScrollPane(tableDropbox);
        this.scrollPane.setBounds(50, 100, 900, 300);

        this.add(labelTitle);
        this.add(buttonInputDropbox);
        this.add(buttonCetakPDF);
        this.add(buttonDeleteDropbox);
        this.add(scrollPane);
    }

    public JButton getCetakPDF() {
        return buttonCetakPDF;
    }

    public JButton getButtonInputDropbox() {
        return buttonInputDropbox;
    }

    public JButton getButtonDeleteDropbox() {
        return buttonDeleteDropbox;
    }

    public int getSelectedDropboxId() {
        return Integer.parseInt(tableDropbox.getValueAt(tableDropbox.getSelectedRow(), 0).toString());
    }

    public int getSelectedDropboxRow() {
        return tableDropbox.getSelectedRow();
    }

//    TODO: uncomment this when PDFReport is ready
//    public void showCetakPDF() {
//        if(reportsFrame == null) {
//            reportsFrame = new ReportsFrame();
//        }
//        reportsFrame.setVisible(true);
//    }

    public void showInputDropboxFrame() {
        if(inputDropboxFrame == null) {
            inputDropboxFrame = new InputDropboxFrame(this);
        }
        inputDropboxFrame.setVisible(true);
    }

    public void addDropbox(Dropbox dropbox) {
        tableModel.add(dropbox);
    }

    public void removeDropbox(int id) {
        tableModel.delete(id);
        tableModel.fireTableDataChanged();
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccessMessage(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
