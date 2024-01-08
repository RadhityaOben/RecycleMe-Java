package com.recycleme.actionListener.masyarakat;

import java.awt.event.*;
import com.recycleme.frame.masyarakat.InputMasyarakatFrame;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.frame.masyarakat.MasyarakatFrame;
import com.recycleme.model.masyarakat.Masyarakat;

import javax.swing.*;
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
        int id = MasyarakatDao.lastId() + 1;
        String nama = inputMasyarakatFrame.getNama();
        String alamat = inputMasyarakatFrame.getAlamat();
        String email = inputMasyarakatFrame.getEmail();
        String noTelp = inputMasyarakatFrame.getNoTelp();
        String statusRegistrasi = "Diproses";
        String statusPenjemputan = "Tidak ada";
        String metodePembayaran = inputMasyarakatFrame.getMetodePembayaran();
        int poin = 0;

        if(nama.equals("")) {
            inputMasyarakatFrame.showErrorMessage("Nama tidak boleh kosong!");
            return;
        }

        if(alamat.equals("")) {
            inputMasyarakatFrame.showErrorMessage("Alamat tidak boleh kosong!");
            return;
        }

        if(email.equals("")) {
            inputMasyarakatFrame.showErrorMessage("Email tidak boleh kosong!");
            return;
        }

        if(noTelp.equals("")) {
            inputMasyarakatFrame.showErrorMessage("No. Telp tidak boleh kosong!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(inputMasyarakatFrame, "Apakah data yang dimasukkan sudah sesuai?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.NO_OPTION) {
            inputMasyarakatFrame.showInfoMessage("Silahkan periksa kembali!");
            return;
        }

        masyarakat = new Masyarakat(id, nama, alamat, email, noTelp, statusRegistrasi, statusPenjemputan, metodePembayaran, poin);
        masyarakatDao.insert(masyarakat);

        inputMasyarakatFrame.showSuccessMessage("Masyarakat berhasil ditambahkan! Tolong konfirmasi status registrasi.");
        masyarakat.setId(MasyarakatDao.lastId());
        inputMasyarakatFrame.reset();
        inputMasyarakatFrame.dispose();
        masyarakatFrame.addMasyarakat(masyarakat);
    }
}
