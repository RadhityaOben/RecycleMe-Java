package com.recycleme.frame.kurir;

import com.recycleme.actionListener.kurir.KurirHapus;
import com.recycleme.actionListener.kurir.KurirInput;
import com.recycleme.dao.KurirDao;
import com.recycleme.frame.kurir.InputKurirFrame;
import com.recycleme.model.kurir.Kurir;
import com.recycleme.model.kurir.KurirTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
public class KurirFrame extends JFrame {
    private JLabel labelTitle;

    private JButton buttonInputKurir;
    private JButton buttonEditKurir;
    private JButton buttonSetujui;
    private JButton buttonDeleteKurir;

    private JTable tableKurir;
    private JScrollPane scrollPane;

    private InputKurirFrame inputKurirFrame;
    private List<Kurir> kurirList;
    private KurirDao kurirDao;
    private KurirTableModel tableModel;
    private KurirInput kurirInput;
    private KurirHapus kurirHapus;

    public KurirFrame(KurirDao kurirDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLayout(null);

        this.labelTitle = new JLabel("Daftar Semua Kurir");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputKurir = new JButton("Input Kurir");
        this.buttonInputKurir.setBounds(50, 50, 150, 30);

        this.buttonEditKurir = new JButton("Edit Kurir");
        this.buttonEditKurir.setBounds(250, 50, 150, 30);

        this.buttonSetujui = new JButton("Setujui Registrasi");
        this.buttonSetujui.setBounds(450, 50, 150, 30);

        this.buttonDeleteKurir = new JButton("Delete Kurir");
        this.buttonDeleteKurir.setBounds(650, 50, 150, 30);

        this.kurirInput = new KurirInput(this);
        this.kurirHapus = new KurirHapus(this, kurirDao);

        this.buttonInputKurir.addActionListener(kurirInput);
        this.buttonDeleteKurir.addActionListener(kurirHapus);

        this.kurirDao = kurirDao;
        this.kurirList = kurirDao.findAll();

        tableKurir = new JTable(new KurirTableModel(kurirList));
        scrollPane = new JScrollPane(tableKurir);
        scrollPane.setBounds(50, 100, 900, 300);

        tableModel = new KurirTableModel(kurirList);
        tableKurir.setModel(tableModel);

        this.add(labelTitle);
        this.add(buttonInputKurir);
        this.add(buttonEditKurir);
        this.add(buttonSetujui);
        this.add(buttonDeleteKurir);
        this.add(scrollPane);
    }

    public int getSelectedKurirId() {
        return tableKurir.getSelectedRow();
    }

    public JButton getButtonInputKurir() {
        return buttonInputKurir;
    }

    public JButton getButtonEditKurir() {
        return buttonEditKurir;
    }

    public JButton getButtonSetujui() {
        return buttonSetujui;
    }

    public JButton getButtonDeleteKurir() {
        return buttonDeleteKurir;
    }

    public void showInputKurirFrame() {
        if(inputKurirFrame == null) {
            inputKurirFrame = new InputKurirFrame(this);
        }
        inputKurirFrame.setVisible(true);
    }

    public JFrame getFrame() {
        return this;
    }

    public void addKurir(Kurir kurir) {
        tableModel.add(kurir);
    }

    public void removeKurir(int id) {
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
