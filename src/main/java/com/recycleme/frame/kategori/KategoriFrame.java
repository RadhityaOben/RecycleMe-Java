package com.recycleme.frame.kategori;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.recycleme.actionListener.kategori.KategoriEdit;
import com.recycleme.actionListener.kategori.KategoriHapus;
import com.recycleme.actionListener.kategori.KategoriInput;
import com.recycleme.dao.KategoriDao;
import com.recycleme.model.kategori.Kategori;
import com.recycleme.model.kategori.KategoriTableModel;

public class KategoriFrame extends JFrame {
    private JLabel labelTitle;

    private JButton buttonInputKategori;
    private JButton buttonEditKategori;
    private JButton buttonDeleteKategori;

    private JTable tableKategori;
    private JScrollPane scrollPane;

    private InputKategoriFrame inputKategoriFrame;
    private List<Kategori> kategoriList;
    private KategoriTableModel tableModel;
    private KategoriInput kategoriInput;
    private KategoriEdit kategoriEdit;
    private KategoriHapus kategoriHapus;

    public KategoriFrame(KategoriDao kategoriDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(640, 500);
        this.setLayout(null);

        this.labelTitle = new JLabel("Daftar Semua Kategori");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputKategori = new JButton("Input Kategori");
        this.buttonInputKategori.setBounds(50, 50, 150, 30);

        this.buttonEditKategori = new JButton("Edit Kategori");
        this.buttonEditKategori.setBounds(250, 50, 150, 30);

        this.buttonDeleteKategori = new JButton("Delete Kategori");
        this.buttonDeleteKategori.setBounds(450, 50, 150, 30);

        this.kategoriInput = new KategoriInput(this);
        this.kategoriEdit = new KategoriEdit(this);
        this.kategoriHapus = new KategoriHapus(this, kategoriDao);

        this.buttonInputKategori.addActionListener(kategoriInput);
        this.buttonEditKategori.addActionListener(kategoriEdit);
        this.buttonDeleteKategori.addActionListener(kategoriHapus);

        this.kategoriList = kategoriDao.findAll();

        this.tableModel = new KategoriTableModel(kategoriList);

        this.tableKategori = new JTable(tableModel);
        tableKategori.setModel(tableModel);
        this.scrollPane = new JScrollPane(tableKategori);
        this.scrollPane.setBounds(50, 100, 550, 300);

        add(labelTitle);
        add(buttonInputKategori);
        add(buttonEditKategori);
        add(buttonDeleteKategori);
        add(scrollPane);

        this.setVisible(true);
    }

    public int getSelectedKategoriId() {
        return Integer.parseInt(tableKategori.getValueAt(tableKategori.getSelectedRow(), 0).toString());
    }

    public int getSelectedKategoriRow() {
        return tableKategori.getSelectedRow();
    }

    public JButton getButtonInputKategori() {
        return buttonInputKategori;
    }

    public JButton getButtonEditKategori() {
        return buttonEditKategori;
    }

    public JButton getButtonDeleteKategori() {
        return buttonDeleteKategori;
    }

    public static boolean isKategoriExist(String nama) {
        for(Kategori kategori : KategoriDao.findAll()) {
            if(kategori.getNama().equals(nama)) {
                return true;
            }
        }
        return false;
    }

    public void showInputKategoriFrame() {
        if(inputKategoriFrame == null) {
            inputKategoriFrame = new InputKategoriFrame(this);
        } else {
            inputKategoriFrame.setVisible(true);
        }
    }

    public JFrame getFrame() {
        return this;
    }

    public void addKategori(Kategori kategori) {
        kategoriList.add(kategori);
        tableModel.fireTableDataChanged();
    }

    public void updateKategori(Kategori kategori) {
        kategoriList.set(getSelectedKategoriRow(), kategori);
        tableModel.fireTableDataChanged();
    }

    public void removeKategori(int id) {
        kategoriList.remove(id);
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
