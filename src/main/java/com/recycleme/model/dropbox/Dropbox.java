package com.recycleme.model.dropbox;

import com.recycleme.model.jenis.Jenis;
import com.recycleme.model.kurir.Kurir;
import com.recycleme.model.masyarakat.Masyarakat;

public class Dropbox {
    private int id;
    private String nama;
    private String alamat;
    private Masyarakat masyarakat;
    private Kurir kurir;
    private Jenis[] jenis;

    public Dropbox(int id, String nama, String alamat, Masyarakat masyarakat, Kurir kurir, Jenis[] jenis) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.masyarakat = masyarakat;
        this.kurir = kurir;
        this.jenis = jenis;
    }

    public Dropbox() {}

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setMasyarakat(Masyarakat masyarakat) {
        this.masyarakat = masyarakat;
    }

    public void setKurir(Kurir kurir) {
        this.kurir = kurir;
    }

    public void setJenis(Jenis[] jenis) {
        this.jenis = jenis;
    }
}
