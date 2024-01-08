package com.recycleme.frame.masyarakat;

import com.recycleme.actionListener.masyarakat.MasyarakatHapus;
import com.recycleme.actionListener.masyarakat.MasyarakatInput;
import com.recycleme.actionListener.masyarakat.MasyarakatSetujui;
import com.recycleme.actionListener.masyarakat.MasyarakatTolak;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.model.masyarakat.Masyarakat;
import com.recycleme.model.masyarakat.MasyarakatTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MasyarakatFrame extends JFrame {
    private JLabel labelTitle;

    private JButton buttonInputMasyarakat;
    private JButton buttonTolak;
    private JButton buttonSetujui;
    private JButton buttonDeleteMasyarakat;

    private JTable tableMasyarakat;
    private JScrollPane scrollPane;

    private InputMasyarakatFrame inputMasyarakatFrame;
    private List<Masyarakat> masyarakatList;
    private MasyarakatTableModel tableModel;
    private MasyarakatInput masyarakatInput;
    private MasyarakatHapus masyarakatHapus;
    private MasyarakatSetujui masyarakatSetujui;
    private MasyarakatTolak masyarakatTolak;

    public MasyarakatFrame(MasyarakatDao masyarakatDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLayout(null);

        this.masyarakatInput = new MasyarakatInput(this);
        this.masyarakatHapus = new MasyarakatHapus(this, masyarakatDao);
        this.masyarakatSetujui = new MasyarakatSetujui(this, masyarakatDao);
        this.masyarakatTolak = new MasyarakatTolak(this, masyarakatDao);

        this.labelTitle = new JLabel("Daftar Semua Masyarakat");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputMasyarakat = new JButton("Input Masyarakat");
        this.buttonInputMasyarakat.setBounds(50, 50, 150, 30);
        this.buttonInputMasyarakat.addActionListener(masyarakatInput);

        this.buttonDeleteMasyarakat = new JButton("Hapus Masyarakat");
        this.buttonDeleteMasyarakat.setBounds(250, 50, 150, 30);
        this.buttonDeleteMasyarakat.addActionListener(masyarakatHapus);

        this.buttonTolak = new JButton("Tolak Permintaan");
        this.buttonTolak.setBounds(600, 50, 150, 30);
        this.buttonTolak.addActionListener(masyarakatTolak);

        this.buttonSetujui = new JButton("Setujui Permintaan");
        this.buttonSetujui.setBounds(800, 50, 150, 30);
        this.buttonSetujui.addActionListener(masyarakatSetujui);

        this.masyarakatList = masyarakatDao.findAll();

        tableModel = new MasyarakatTableModel(masyarakatList);
        tableMasyarakat = new JTable(tableModel);
        tableMasyarakat.setModel(tableModel);
        scrollPane = new JScrollPane(tableMasyarakat);
        scrollPane.setBounds(50, 100, 900, 300);


        this.add(labelTitle);
        this.add(buttonInputMasyarakat);
        this.add(buttonTolak);
        this.add(buttonSetujui);
        this.add(buttonDeleteMasyarakat);
        this.add(scrollPane);
    }

    public int getSelectedMasyarakatId() {
        int row = tableMasyarakat.getSelectedRow();
        int col = 0;
        return (int) tableMasyarakat.getValueAt(row, col);
    }

    public String getSelectedMasyarakatStatusRegistrasi() {
        int row = tableMasyarakat.getSelectedRow();
        int col = 5;
        return (String) tableMasyarakat.getValueAt(row, col);
    }

    public JTable getTableMasyarakat() {
        return tableMasyarakat;
    }

    public int getSelectedMasyarakatRow() {
        return tableMasyarakat.getSelectedRow();
    }

    public int getSelectedMasyarakatCol() {
        return tableMasyarakat.getSelectedColumn();
    }

    public JButton getButtonInputMasyarakat() {
        return buttonInputMasyarakat;
    }

    public JButton getButtonTolak() {
        return buttonTolak;
    }

    public JButton getButtonSetujui() {
        return buttonSetujui;
    }

    public JButton getButtonDeleteMasyarakat() {
        return buttonDeleteMasyarakat;
    }

    public void showInputMasyarakatFrame() {
        if(inputMasyarakatFrame == null) {
            inputMasyarakatFrame = new InputMasyarakatFrame(this);
        }
        inputMasyarakatFrame.reset();
        inputMasyarakatFrame.setVisible(true);
    }

    public void addMasyarakat(Masyarakat masyarakat) {
        tableModel.add(masyarakat);
    }

    public void updateMasyarakat(int row, int col, Masyarakat masyarakat) {
        tableModel.update(row, col, masyarakat);
    }

    public void removeMasyarakat(int row) {
        tableModel.delete(row);
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
}
