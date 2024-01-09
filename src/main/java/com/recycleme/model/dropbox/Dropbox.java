package com.recycleme.model.dropbox;

import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.kategori.Kategori;
import com.recycleme.model.kurir.Kurir;
import com.recycleme.model.masyarakat.Masyarakat;

import java.sql.Date;

public class Dropbox {
    private int id;
    private Date tanggal;
    private Masyarakat masyarakat;
    private Kurir kurir;
    private Kategori kategori;
    private Jenis[] jenis;

    public Dropbox(int id, Date tanggal, Masyarakat masyarakat, Kurir kurir, Kategori kategori, Jenis[] jenis) {
        this.id = id;
        this.tanggal = tanggal;
        this.masyarakat = masyarakat;
        this.kurir = kurir;
        this.kategori = kategori;
        this.jenis = jenis;
    }

    public Dropbox() {}

    public int getId() {
        return id;
    }

    public Masyarakat getMasyarakat() {
        return masyarakat;
    }

    public Kurir getKurir() {
        return kurir;
    }

    public Jenis[] getJenis() {
        return jenis;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMasyarakat(Masyarakat masyarakat) {
        this.masyarakat = masyarakat;
    }

    public void setKurir(Kurir kurir) {
        this.kurir = kurir;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public void setJenis(Jenis[] jenis) {
        this.jenis = jenis;
    }
}
