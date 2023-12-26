package com.recycleme.frame.masyarakat;

import com.recycleme.actionListener.masyarakat.MasyarakatHapus;
import com.recycleme.actionListener.masyarakat.MasyarakatInput;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.model.masyarakat.Masyarakat;
import com.recycleme.model.masyarakat.MasyarakatTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MasyarakatFrame extends JFrame {
    private JLabel labelTitle;

    private JButton buttonInputMasyarakat;
    private JButton buttonEditMasyarakat;
    private JButton buttonSetujui;
    private JButton buttonDeleteMasyarakat;

    private JTable tableMasyarakat;
    private JScrollPane scrollPane;

    private InputMasyarakatFrame inputMasyarakatFrame;
    private List<Masyarakat> masyarakatList;
    private MasyarakatDao masyarakatDao;
    private MasyarakatTableModel tableModel;
    private MasyarakatInput masyarakatInput;
    private MasyarakatHapus masyarakatHapus;

    public MasyarakatFrame(MasyarakatDao masyarakatDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLayout(null);

        this.labelTitle = new JLabel("Daftar Semua Masyarakat");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputMasyarakat = new JButton("Input Masyarakat");
        this.buttonInputMasyarakat.setBounds(50, 50, 150, 30);

        this.buttonEditMasyarakat = new JButton("Edit Masyarakat");
        this.buttonEditMasyarakat.setBounds(250, 50, 150, 30);

        this.buttonSetujui = new JButton("Setujui Registrasi");
        this.buttonSetujui.setBounds(450, 50, 150, 30);

        this.buttonDeleteMasyarakat = new JButton("Delete Masyarakat");
        this.buttonDeleteMasyarakat.setBounds(650, 50, 150, 30);

        this.masyarakatInput = new MasyarakatInput(this);
        this.masyarakatHapus = new MasyarakatHapus(this, masyarakatDao);

        this.buttonInputMasyarakat.addActionListener(masyarakatInput);
        this.buttonDeleteMasyarakat.addActionListener(masyarakatHapus);

        this.masyarakatDao = masyarakatDao;
        this.masyarakatList = masyarakatDao.findAll();

        tableMasyarakat = new JTable(new MasyarakatTableModel(masyarakatList));
        scrollPane = new JScrollPane(tableMasyarakat);
        scrollPane.setBounds(50, 100, 900, 300);

        tableModel = new MasyarakatTableModel(masyarakatList);
        tableMasyarakat.setModel(tableModel);

        this.add(labelTitle);
        this.add(buttonInputMasyarakat);
        this.add(buttonEditMasyarakat);
        this.add(buttonSetujui);
        this.add(buttonDeleteMasyarakat);
        this.add(scrollPane);
    }

    public int getSelectedMasyarakatId() {
        return tableMasyarakat.getSelectedRow();
    }

    public JButton getButtonInputMasyarakat() {
        return buttonInputMasyarakat;
    }

    public JButton getButtonEditMasyarakat() {
        return buttonEditMasyarakat;
    }

    public JButton getButtonSetujui() {
        return buttonSetujui;
    }

    public JButton getButtonDeleteMasyarakat() {
        return buttonDeleteMasyarakat;
    }

    public void showInputMasyarakatFrame() {
        if(inputMasyarakatFrame == null) {
            inputMasyarakatFrame = new InputMasyarakatFrame();
        }
        inputMasyarakatFrame.setVisible(true);
    }

    public void addMasyarakat(Masyarakat masyarakat) {
        tableModel.add(masyarakat);
    }

    public void removeMasyarakat(int id) {
        tableModel.delete(id);
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
