package com.recycleme.actionListener.dropbox;

import com.recycleme.frame.dropbox.InputDropboxFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropboxReset implements ActionListener {
    private InputDropboxFrame inputDropboxFrame;

    public DropboxReset(InputDropboxFrame inputDropboxFrame) {
        this.inputDropboxFrame = inputDropboxFrame;
    }

    public void actionPerformed(ActionEvent e) {
        inputDropboxFrame.reset();
    }
}
