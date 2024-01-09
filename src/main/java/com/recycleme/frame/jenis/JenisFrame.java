package com.recycleme.frame.jenis;

import com.recycleme.actionListener.jenis.JenisEdit;
import com.recycleme.dao.JenisDao;
import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.jenis.JenisTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import com.recycleme.actionListener.jenis.JenisHapus;
import com.recycleme.actionListener.jenis.JenisInput;
import com.recycleme.dao.JenisDao;
import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.jenis.JenisTableModel;

public class JenisFrame extends JFrame {
    private JLabel labelTitle;

    private JButton buttonInputJenis;
    private JButton buttonEditJenis;
    private JButton buttonDeleteJenis;

    private JTable tableJenis;
    private JScrollPane scrollPane;

    private InputJenisFrame inputJenisFrame;
    private List<Jenis> jenisList;
    private JenisTableModel tableModel;
    private JenisInput jenisInput;
    private JenisEdit jenisEdit;
    private JenisHapus jenisHapus;

    public JenisFrame(JenisDao jenisDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLayout(null);

        this.labelTitle = new JLabel("Daftar Semua Jenis");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputJenis = new JButton("Input Jenis");
        this.buttonInputJenis.setBounds(50, 50, 150, 30);

        this.buttonEditJenis = new JButton("Edit Jenis");
        this.buttonEditJenis.setBounds(250, 50, 150, 30);

        this.buttonDeleteJenis = new JButton("Delete Jenis");
        this.buttonDeleteJenis.setBounds(450, 50, 150, 30);


        this.jenisInput = new JenisInput(this);
        this.jenisEdit = new JenisEdit(this);
        this.jenisHapus = new JenisHapus(this, jenisDao);

        this.buttonInputJenis.addActionListener(jenisInput);
        this.buttonEditJenis.addActionListener(jenisEdit);
        this.buttonDeleteJenis.addActionListener(jenisHapus);


        this.jenisList = jenisDao.findAll();

        this.tableModel = new JenisTableModel(jenisList);

        this.tableJenis = new JTable(tableModel);
        tableJenis.setModel(tableModel);
        this.scrollPane = new JScrollPane(tableJenis);
        this.scrollPane.setBounds(50, 100, 800, 300);

        this.add(labelTitle);
        this.add(buttonInputJenis);
        this.add(buttonEditJenis);
        this.add(buttonDeleteJenis);
        this.add(scrollPane);
    }

    public int getSelectedJenisId() {
        return Integer.parseInt(tableJenis.getValueAt(tableJenis.getSelectedRow(), 0).toString());
    }

    public int getSelectedJenisRow() {
        return tableJenis.getSelectedRow();
    }

    public JButton getButtonInputJenis() {
        return buttonInputJenis;
    }

    public JButton getButtonEditJenis() {
        return buttonEditJenis;
    }

    public JButton getButtonDeleteJenis() {
        return buttonDeleteJenis;
    }

    public void showInputJenisFrame() {
        if(inputJenisFrame == null) {
            inputJenisFrame = new InputJenisFrame(this);
        }
        inputJenisFrame.setVisible(true);
    }

    public JFrame getFrame() {
        return this;
    }

    public void addJenis(Jenis jenis) {
        tableModel.add(jenis);
        tableModel.fireTableDataChanged();
    }

    public void updateJenis(Jenis jenis) {
        jenisList.set(getSelectedJenisRow(), jenis);
        tableModel.fireTableDataChanged();
    }

    public void removeJenis(int id) {
        tableModel.delete(id);
        tableModel.fireTableDataChanged();
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

}
