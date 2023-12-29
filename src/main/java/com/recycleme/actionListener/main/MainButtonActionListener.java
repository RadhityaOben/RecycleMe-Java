package com.recycleme.actionListener.main;

import com.recycleme.main.MainFrame;

import java.awt.event.*;

public class MainButtonActionListener implements ActionListener {
    private MainFrame mainFrame;

    public MainButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainFrame.getButtonMasyarakat()) {
            mainFrame.showMasyarakatFrame();
        }
        if (e.getSource() == mainFrame.getButtonKurir()) {
            mainFrame.showKurirFrame();
        }
    }
}
