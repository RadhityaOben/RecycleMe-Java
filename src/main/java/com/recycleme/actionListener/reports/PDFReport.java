package com.recycleme.actionListener.reports;

import com.recycleme.frame.dropbox.DropboxFrame;
import com.recycleme.frame.reports.ReportsFrame;

import java.awt.event.*;

public class PDFReport implements ActionListener {
    private DropboxFrame dropboxFrame;

    public PDFReport(DropboxFrame dropboxFrame) {
        this.dropboxFrame = dropboxFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dropboxFrame.getCetakPDF()) {
            dropboxFrame.showCetakPDF();
        }
    }

}
