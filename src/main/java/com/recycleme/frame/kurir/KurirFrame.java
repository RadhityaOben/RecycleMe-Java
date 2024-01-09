package com.recycleme.frame.kurir;

import com.recycleme.actionListener.kurir.KurirHapus;
import com.recycleme.actionListener.kurir.KurirInput;
import com.recycleme.actionListener.kurir.KurirSetujui;
import com.recycleme.actionListener.kurir.KurirTolak;
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

    private JButton buttonTolak;
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
    private KurirSetujui kurirSetujui;
    private KurirTolak kurirTolak;


    public KurirFrame(KurirDao kurirDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 460);
        this.setLayout(null);

        this.labelTitle = new JLabel("Daftar Semua Kurir");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputKurir = new JButton("Input Kurir");
        this.buttonInputKurir.setBounds(50, 50, 150, 30);
        this.buttonInputKurir.addActionListener(kurirInput);

        this.buttonDeleteKurir = new JButton("Delete Kurir");
        this.buttonDeleteKurir.setBounds(250, 50, 150, 30);
        this.buttonDeleteKurir.addActionListener(kurirHapus);

        this.buttonSetujui = new JButton("Setujui Registrasi");
        this.buttonSetujui.setBounds(600, 50, 150, 30);
        this.buttonSetujui.addActionListener(kurirSetujui);

        this.buttonTolak = new JButton("Tolak Registrasi");
        this.buttonTolak.setBounds(800, 50, 150, 30);
        this.buttonTolak.addActionListener(kurirTolak);


        this.kurirInput = new KurirInput(this);
        this.kurirHapus = new KurirHapus(this, kurirDao);
        this.kurirSetujui = new KurirSetujui(this, kurirDao);
        this.kurirTolak = new KurirTolak(this, kurirDao);

        this.buttonInputKurir.addActionListener(kurirInput);
        this.buttonDeleteKurir.addActionListener(kurirHapus);
        this.buttonSetujui.addActionListener(kurirSetujui);
        this.buttonTolak.addActionListener(kurirTolak);

        this.kurirDao = kurirDao;
        this.kurirList = kurirDao.findAll();

        tableKurir = new JTable(new KurirTableModel(kurirList));
        scrollPane = new JScrollPane(tableKurir);
        scrollPane.setBounds(50, 100, 900, 300);

        tableModel = new KurirTableModel(kurirList);
        tableKurir.setModel(tableModel);

        this.add(labelTitle);
        this.add(buttonInputKurir);
        this.add(buttonSetujui);
        this.add(buttonTolak);
        this.add(buttonDeleteKurir);
        this.add(scrollPane);
    }

    public int getSelectedKurirId() {
        int row = tableKurir.getSelectedRow();
        int col = 0;
        return (int) tableKurir.getValueAt(row, col);
    }

    public int getSelectedKurirRow() {
        return tableKurir.getSelectedRow();
    }

    public String getSelectedKurirStatusRegistrasi() {
        int row = tableKurir.getSelectedRow();
        int col = 3;
        return (String) tableKurir.getValueAt(row, col);
    }

    public void updateKurir(int row, int col, Kurir kurir) {
        tableModel.update(row, col, kurir);
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

    public JButton getButtonTolak() {
        return buttonTolak;
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
