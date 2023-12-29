package com.recycleme.frame.kategori;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
    private KategoriDao kategoriDao;
    private KategoriTableModel tableModel;
    private KategoriInput kategoriInput;
    private KategoriHapus kategoriHapus;

    public KategoriFrame(KategoriDao kategoriDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 500);
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
        this.kategoriHapus = new KategoriHapus(this, kategoriDao);

        this.buttonInputKategori.addActionListener(kategoriInput);
        this.buttonDeleteKategori.addActionListener(kategoriHapus);

        this.kategoriDao = kategoriDao;
        this.kategoriList = kategoriDao.findAll();

        this.tableKategori = new JTable(tableModel);
        this.scrollPane = new JScrollPane(tableKategori);
        this.scrollPane.setBounds(50, 100, 800, 300);

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

    public JButton getButtonInputKategori() {
        return buttonInputKategori;
    }

    public JButton getButtonEditKategori() {
        return buttonEditKategori;
    }

    public JButton getButtonDeleteKategori() {
        return buttonDeleteKategori;
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

    public void removeKategori(int id) {
        kategoriList.remove(id);
        tableModel.fireTableDataChanged();
    }

    public void showMessageSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMessageError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showMessageInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

}
