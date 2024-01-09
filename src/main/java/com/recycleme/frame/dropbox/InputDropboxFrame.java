package com.recycleme.frame.dropbox;

import com.recycleme.actionListener.dropbox.DropboxSimpan;
import com.recycleme.dao.DropboxDao;
import com.recycleme.dao.KurirDao;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.dao.KategoriDao;
import com.recycleme.model.kategori.Kategori;
import com.recycleme.model.kurir.Kurir;
import com.recycleme.model.masyarakat.Masyarakat;

import javax.swing.*;
import java.util.List;

public class InputDropboxFrame extends JFrame {
    private JLabel labelTitle;

    private JLabel masyarakatLabel;
    private JLabel kurirLabel;
    private JLabel kategoriLabel;

    private JComboBox masyarakatComboBox;
    private JComboBox kurirComboBox;
    private JComboBox kategoriComboBox;

    private JButton simpanButton;
    private JButton resetButton;

    private DropboxDao dropboxDao;
    private DropboxFrame dropboxFrame;

    private MasyarakatDao masyarakatDao = new MasyarakatDao();
    private KurirDao kurirDao = new KurirDao();
    private KategoriDao kategoriDao = new KategoriDao();

    private List<Masyarakat> masyarakatList;
    private List<Kurir> kurirList;
    private List<Kategori> kategoriList;

    private DropboxSimpan dropboxSimpan;

    public InputDropboxFrame(DropboxFrame frame) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        this.setSize(500, 600);
        dropboxDao = new DropboxDao();

        dropboxSimpan = new DropboxSimpan(this, dropboxDao, frame);

        dropboxFrame = frame;

        labelTitle = new JLabel("Input Dropbox");
        labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 18));

        masyarakatLabel = new JLabel("Masyarakat");
        masyarakatLabel.setBounds(50, 100, 100, 30);

        masyarakatComboBox = new JComboBox();
        masyarakatComboBox.setBounds(200, 100, 200, 30);

        kurirLabel = new JLabel("Kurir");
        kurirLabel.setBounds(50, 150, 100, 30);

        kurirComboBox = new JComboBox();
        kurirComboBox.setBounds(200, 150, 200, 30);

        kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setBounds(50, 200, 100, 30);

        kategoriComboBox = new JComboBox();
        kategoriComboBox.setBounds(200, 200, 200, 30);

        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(50, 250, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 250, 100, 30);

        simpanButton.addActionListener(dropboxSimpan);

        populateComboBox();

        this.add(labelTitle);
        this.add(masyarakatLabel);
        this.add(masyarakatComboBox);
        this.add(kurirLabel);
        this.add(kurirComboBox);
        this.add(kategoriLabel);
        this.add(kategoriComboBox);
        this.add(simpanButton);
        this.add(resetButton);
    }

    public void populateComboBox() {
        masyarakatList = masyarakatDao.findAll();
        kurirList = kurirDao.findAll();
        kategoriList = kategoriDao.findAll();

        for(Masyarakat m : masyarakatList) {
            masyarakatComboBox.addItem(m.getNama());
        }

        for(Kurir k : kurirList) {
            kurirComboBox.addItem(k.getNama());
        }

        for(Kategori k : kategoriList) {
            kategoriComboBox.addItem(k.getNama());
        }
    }

    public Masyarakat getMasyarakat() {
        return masyarakatList.get(masyarakatComboBox.getSelectedIndex());
    }

    public Kurir getKurir() {
        return kurirList.get(kurirComboBox.getSelectedIndex());
    }

    public Kategori getKategori() {
        return kategoriList.get(kategoriComboBox.getSelectedIndex());
    }

    public JButton getSimpanButton() {
        return simpanButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void reset() {
        masyarakatComboBox.setSelectedIndex(0);
        kurirComboBox.setSelectedIndex(0);
        kategoriComboBox.setSelectedIndex(0);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
