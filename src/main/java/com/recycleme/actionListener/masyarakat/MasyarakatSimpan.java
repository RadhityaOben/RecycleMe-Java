package com.recycleme.actionListener.masyarakat;

import java.awt.event.*;
import com.recycleme.frame.masyarakat.InputMasyarakatFrame;
import com.recycleme.dao.MasyarakatDao;
import com.recycleme.model.masyarakat.Masyarakat;
import java.util.UUID;

public class MasyarakatSimpan implements ActionListener {
    private InputMasyarakatFrame masyarakatFrame;
    private MasyarakatDao masyarakatDao;
    private Masyarakat masyarakat;

    public MasyarakatSimpan(InputMasyarakatFrame masyarakatFrame, MasyarakatDao masyarakatDao) {
        this.masyarakatFrame = masyarakatFrame;
        this.masyarakatDao = masyarakatDao;
    }

public void actionPerformed(ActionEvent e) {
        int id = UUID.randomUUID().hashCode();
        String nama = masyarakatFrame.getNama();
        String alamat = masyarakatFrame.getAlamat();
        String email = masyarakatFrame.getEmail();
        String noTelp = masyarakatFrame.getNoTelp();
        String statusRegistrasi = masyarakatFrame.getStatusRegistrasi();
        String statusPenjemputan = masyarakatFrame.getStatusPenjemputan();
        String metodePembayaran = masyarakatFrame.getMetodePembayaran();
        int poin = masyarakatFrame.getPoin();

        masyarakat = new Masyarakat(id, nama, alamat, email, noTelp, statusRegistrasi, statusPenjemputan, metodePembayaran, poin);
        masyarakatDao.insert(masyarakat);
        masyarakatFrame.reset();
    }
}
