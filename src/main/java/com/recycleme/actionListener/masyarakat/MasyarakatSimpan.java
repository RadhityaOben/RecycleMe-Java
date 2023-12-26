package com.recycleme.actionListener.masyarakat;

import java.awt.event.*;
import com.recycleme.frame.masyarakat.InputMasyarakatFrame;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.model.masyarakat.Masyarakat;
import java.util.UUID;

public class MasyarakatSimpan implements ActionListener {
    private MasyarakatFrame masyarakatFrame;
    private InputMasyarakatFrame inputMasyarakatFrame;
    private MasyarakatDao masyarakatDao;
    private Masyarakat masyarakat;

    public MasyarakatSimpan(InputMasyarakatFrame inputMasyarakatFrame, MasyarakatDao masyarakatDao, MasyarakatFrame masyarakatFrame) {
        this.masyarakatFrame = masyarakatFrame;
        this.inputMasyarakatFrame = inputMasyarakatFrame;
        this.masyarakatDao = masyarakatDao;
    }

public void actionPerformed(ActionEvent e) {
        int id = UUID.randomUUID().hashCode();
        String nama = inputMasyarakatFrame.getNama();
        String alamat = inputMasyarakatFrame.getAlamat();
        String email = inputMasyarakatFrame.getEmail();
        String noTelp = inputMasyarakatFrame.getNoTelp();
        String statusRegistrasi = "Diproses";
        String statusPenjemputan = "Tidak ada";
        String metodePembayaran = inputMasyarakatFrame.getMetodePembayaran();
        int poin = 0;

        masyarakat = new Masyarakat(id, nama, alamat, email, noTelp, statusRegistrasi, statusPenjemputan, metodePembayaran, poin);
        inputMasyarakatFrame.showSuccessMessage("Daftar berhasil! Silahkan tunggu konfirmasi dari admin.");
        inputMasyarakatFrame.reset();
        inputMasyarakatFrame.dispose();
        masyarakatFrame.addMasyarakat(masyarakat);
        masyarakatDao.insert(masyarakat);
    }
}
