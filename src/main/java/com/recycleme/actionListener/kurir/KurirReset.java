package com.recycleme.actionListener.kurir;

import com.recycleme.frame.kurir.InputKurirFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class KurirReset implements ActionListener {
    private InputKurirFrame inputKurirFrame;

    public KurirReset(InputKurirFrame inputKurirFrame) {
        this.inputKurirFrame = inputKurirFrame;
    }

    public void actionPerformed(ActionEvent e) {
        inputKurirFrame.reset();
    }

}
