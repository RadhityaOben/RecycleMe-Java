package com.recycleme.actionListener.jenis;

import com.recycleme.frame.jenis.EditJenisFrame;
import com.recycleme.frame.jenis.JenisFrame;

import java.awt.event.*;

public class JenisEdit implements ActionListener {
    private EditJenisFrame editJenisFrame;
    private JenisFrame jenisFrame;
    public JenisEdit(JenisFrame jenisFrame) {this.jenisFrame = jenisFrame;}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jenisFrame.getButtonEditJenis()) {
//            jenisFrame.showInfoMessage("Edit jenis belum dibuat");
//            return;
            int row = jenisFrame.getSelectedJenisRow();
            if(row == -1) {
                jenisFrame.showErrorMessage("Pilih jenis yang akan dipilih");
                return;
            }

            int id = jenisFrame.getSelectedJenisId();
            editJenisFrame = new EditJenisFrame(jenisFrame, id);
            editJenisFrame.setVisible(true);
        }
    }
}
