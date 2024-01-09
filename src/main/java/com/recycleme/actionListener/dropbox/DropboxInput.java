package com.recycleme.actionListener.dropbox;

import com.recycleme.frame.dropbox.DropboxFrame;
import com.recycleme.frame.dropbox.InputDropboxFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropboxInput implements ActionListener {
    private DropboxFrame dropboxFrame;

    public DropboxInput(DropboxFrame dropboxFrame) {
        this.dropboxFrame = dropboxFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dropboxFrame.getButtonInputDropbox()) {
            dropboxFrame.showInputDropboxFrame();
        }
    }
}
