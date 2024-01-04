package com.recycleme.frame.jenis;

import com.recycleme.actionListener.kategori.KategoriHapus;
import com.recycleme.actionListener.kategori.KategoriInput;
import com.recycleme.dao.JenisDao;
import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.jenis.JenisTableModel;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JenisFrame extends JFrame {
    private JLabel labelTitle;
    private JButton buttonInputJenis;
    private JButton buttonEditJenis;
    private JButton buttonDeleteJenis;
    private JTable tableJenis;
    private JScrollPane scrollPane;
    private InputJenisFrame inputJenisFrame;
    private List<Jenis> jenisList;
    private JenisDao jenisDao;
    private JenisTableModel tableModel;
    private JenisInput jenisInput;
    private JenisHapus jenisHapus;

    public JenisFrame(JenisDao jenisDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLayout(null);

        this.labelTitle = new JLabel("Daftar Semua Kategori");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputJenis = new JButton("Input Kategori");
        this.buttonInputJenis.setBounds(50, 50, 150, 30);

        this.buttonEditJenis = new JButton("Edit Kategori");
        this.buttonEditJenis.setBounds(250, 50, 150, 30);

        this.buttonDeleteJenis = new JButton("Delete Kategori");
        this.buttonDeleteJenis.setBounds(450, 50, 150, 30);

        this.jenisInput = new KategoriInput(this);
        this.jenisHapus = new KategoriHapus(this, jenisDao);

        this.buttonInputJenis.addActionListener(jenisInput);
        this.buttonDeleteJenis.addActionListener(jenisHapus);

        this.jenisDao = jenisDao;
        this.jenisList = jenisDao.findAll();

        this.tableJenis = new JTable(tableModel);
        this.scrollPane = new JScrollPane(tableJenis);
        this.scrollPane.setBounds(50, 100, 800, 300);

        add(labelTitle);
        add(buttonInputJenis);
        add(buttonEditJenis);
        add(buttonDeleteJenis);
        add(scrollPane);

        this.setVisible(true);
    }
}
