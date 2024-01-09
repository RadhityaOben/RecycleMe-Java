package com.recycleme.model.jenis;

import com.recycleme.model.kategori.Kategori;

public class Jenis {
    private int id;
    private String nama;
    private Kategori kategori;

    public Jenis(int id, String nama, Kategori kategori) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
    }

    public Jenis() {}

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
}
