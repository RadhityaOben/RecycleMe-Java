package com.recycleme.model.jenis;

import com.recycleme.model.kategori.Kategori;

public class Jenis {
    private int id;
    private String nama;
    private Kategori kategori;
    private int poin;

    public Jenis(int id, String nama, Kategori kategori, int poin) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.poin = poin;
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

    public int getPoin() {
        return poin;
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

    public void setPoin(int poin) {
        this.poin = poin;
    }
}
