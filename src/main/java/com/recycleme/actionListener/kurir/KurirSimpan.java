package com.recycleme.actionListener.kurir;

import com.recycleme.dao.KurirDao;
import com.recycleme.frame.kurir.InputKurirFrame;
import com.recycleme.frame.kurir.KurirFrame;
import com.recycleme.model.kurir.Kurir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class KurirSimpan implements ActionListener {
    private KurirFrame kurirFrame;
    private InputKurirFrame inputKurirFrame;
    private KurirDao kurirDao;
    private Kurir kurir;

    public KurirSimpan(InputKurirFrame inputKurirFrame, KurirDao kurirDao, KurirFrame kurirFrame) {
        this.kurirFrame = kurirFrame;
        this.inputKurirFrame = inputKurirFrame;
        this.kurirDao = kurirDao;
    }

    public void actionPerformed(ActionEvent e) {
        int id = KurirDao.lastId() + 1;
        String nama = inputKurirFrame.getNama();
        String noTelp = inputKurirFrame.getNoTelp();
        String statusRegistrasi = "Diproses";
        String statusPenjemputan = "Tidak ada";
        String jenisKendaraan = inputKurirFrame.getJenisKendaraan();
        String kelengkapanBerkas = inputKurirFrame.getKelengkapanBerkas();

        kurir = new Kurir(id, nama, noTelp, statusRegistrasi, statusPenjemputan, kelengkapanBerkas, jenisKendaraan);
        inputKurirFrame.showSuccessMessage("Daftar berhasil! Silahkan tunggu konfirmasi dari admin.");
        inputKurirFrame.reset();
        kurirFrame.addKurir(kurir);
        kurirDao.insert(kurir);
        inputKurirFrame.dispose();
    }
}
