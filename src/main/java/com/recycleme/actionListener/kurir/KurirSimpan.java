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

        if(nama.equals("")) {
            inputKurirFrame.showErrorMessage("Nama tidak boleh kosong!");
            return;
        }

        if(noTelp.equals("")) {
            inputKurirFrame.showErrorMessage("No. Telp tidak boleh kosong!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(inputKurirFrame, "Apakah data yang dimasukkan sudah sesuai?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.NO_OPTION) {
            inputKurirFrame.showInfoMessage("Silahkan periksa kembali!");
            return;
        }

        kurir = new Kurir(id, nama, noTelp, statusRegistrasi, statusPenjemputan, kelengkapanBerkas, jenisKendaraan);
        kurirDao.insert(kurir);
        inputKurirFrame.showSuccessMessage("Kurir berhasil ditambahkan! Tolong konfirmasi status registrasi.");
        kurir.setId(KurirDao.lastId());
        inputKurirFrame.reset();
        kurirFrame.addKurir(kurir);
        inputKurirFrame.dispose();
    }
}
