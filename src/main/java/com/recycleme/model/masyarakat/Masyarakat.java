package com.recycleme.model.masyarakat;

public class Masyarakat {
    private int id;
    private String nama;
    private String alamat;
    private String email;
    private String noTelp;
    private String statusRegistrasi;
    private String statusPenjemputan;
    private String metodePembayaran;
    private int poin;

    public Masyarakat(int id, String nama, String alamat, String email, String noTelp, String statusRegistrasi, String statusPenjemputan, String metodePembayaran, int poin) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.noTelp = noTelp;
        this.statusRegistrasi = statusRegistrasi;
        this.statusPenjemputan = statusPenjemputan;
        this.metodePembayaran = metodePembayaran;
        this.poin = poin;
    }

    public Masyarakat() {}

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getEmail() {
        return email;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getStatusRegistrasi() {
        return statusRegistrasi;
    }

    public String getStatusPenjemputan() {
        return statusPenjemputan;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
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

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setStatusRegistrasi(String statusRegistrasi) {
        this.statusRegistrasi = statusRegistrasi;
    }

    public void setStatusPenjemputan(String statusPenjemputan) {
        this.statusPenjemputan = statusPenjemputan;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

}
