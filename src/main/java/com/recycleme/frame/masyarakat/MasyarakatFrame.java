package com.recycleme.frame.masyarakat;

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
    private JButton buttonDeleteMasyarakat;

    private JTable tableMasyarakat;
    private JScrollPane scrollPane;

    private InputMasyarakatFrame inputMasyarakatFrame;
    private List<Masyarakat> masyarakatList;
    private MasyarakatDao masyarakatDao;
    private MasyarakatTableModel tableModel;
    private MasyarakatInput masyarakatInput;

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

        this.buttonDeleteMasyarakat = new JButton("Delete Masyarakat");
        this.buttonDeleteMasyarakat.setBounds(450, 50, 150, 30);

        this.masyarakatInput = new MasyarakatInput(this);

        this.buttonInputMasyarakat.addActionListener(masyarakatInput);

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
        this.add(buttonDeleteMasyarakat);
        this.add(scrollPane);
    }

    public JButton getButtonInputMasyarakat() {
        return buttonInputMasyarakat;
    }

    public void showInputMasyarakatFrame() {
        if(inputMasyarakatFrame == null) {
            inputMasyarakatFrame = new InputMasyarakatFrame();
        }
        inputMasyarakatFrame.setVisible(true);
    }
}
