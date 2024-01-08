package com.recycleme.frame.dropbox;

import com.recycleme.actionListener.dropbox.DropboxHapus;
import com.recycleme.actionListener.dropbox.DropboxInput;
import com.recycleme.dao.DropboxDao;
import com.recycleme.model.dropbox.Dropbox;
import com.recycleme.model.dropbox.DropboxTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DropboxFrame extends JFrame {
    private JLabel labelTitle;
    private JButton buttonInputDropBox;
    private JButton buttonEditDropBox;
    private JButton buttonDeleteDropBox;
    private JTable tableDropBox;
    private JScrollPane scrollPane;
    private InputDropboxFrame inputDropBoxFrame;
    private List<Dropbox> dropboxList;
    private DropboxDao dropboxDao;
    private DropboxTableModel tableModel;
    private DropboxInput dropboxInput;
    private DropboxHapus dropboxHapus;

    public DropboxFrame(DropboxDao dropboxDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLayout(null);

        this.labelTitle = new JLabel("Daftar Semua Dropbox");
        this.labelTitle.setBounds(50, 10, 300, 30);
        labelTitle.setFont(new Font("Tahoma", 1, 18));

        this.buttonInputDropBox = new JButton("Input Dropbox");
        this.buttonInputDropBox.setBounds(50, 50, 150, 30);

        this.buttonEditDropBox = new JButton("Edit Dropbox");
        this.buttonEditDropBox.setBounds(250, 50, 150, 30);

        this.buttonDeleteDropBox = new JButton("Delete Dropbox");
        this.buttonDeleteDropBox.setBounds(450, 50, 150, 30);

        this.dropboxInput = new DropboxInput(this);
        this.dropboxHapus = new DropboxHapus(this, dropboxDao);

        this.buttonInputDropBox.addActionListener(dropboxInput);
        this.buttonDeleteDropBox.addActionListener(dropboxHapus);

        this.buttonInputDropBox.addActionListener(dropboxInput);
        this.buttonDeleteDropBox.addActionListener(dropboxHapus);

        this.dropboxDao = dropboxDao;
        this.dropboxList = dropboxDao.findAll();

        tableDropBox = new JTable(new DropboxTableModel(dropboxList));
        scrollPane = new JScrollPane(tableDropBox);
        scrollPane.setBounds(50, 100, 900, 300);

        tableModel = new DropboxTableModel(dropboxList);
        tableDropBox.setModel(tableModel);

        this.add(labelTitle);
        this.add(buttonDeleteDropBox);
        this.add(buttonInputDropBox);
        this.add(buttonEditDropBox);
        this.add(scrollPane);
    }

    public void addDropbox(Dropbox dropbox) {
        tableModel.addRow(dropbox);
    }

    public void removeDropbox(int id) {
        tableModel.removeRow(id);
    }

    public JButton getButtonInputDropBox() {
        return buttonInputDropBox;
    }

    public JButton getButtonDeleteDropBox() {
        return buttonDeleteDropBox;
    }

    public int getSelectedDropboxId() {
        return tableDropBox.getSelectedRow();
    }

    public void showInputDropboxFrame() {
        if (inputDropBoxFrame == null) {
            inputDropBoxFrame = new InputDropboxFrame();
        }
        inputDropBoxFrame.setVisible(true);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

}
