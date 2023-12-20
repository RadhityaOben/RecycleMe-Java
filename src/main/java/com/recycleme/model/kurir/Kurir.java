package com.recycleme.model.kurir;

public class Kurir {
    private int id;
    private String nama;
    private String noHp;
    private String statusRegistrasi;
    private String statusPenjemputan;
    private String kelengkapanBerkas;
    private String jenisKendaraan;

    public Kurir(int id, String nama, String noHp, String statusRegistrasi, String statusPenjemputan, String kelengkapanBerkas, String jenisKendaraan) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
        this.statusRegistrasi = statusRegistrasi;
        this.statusPenjemputan = statusPenjemputan;
        this.kelengkapanBerkas = kelengkapanBerkas;
        this.jenisKendaraan = jenisKendaraan;
    }

    public Kurir() {}

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getStatusRegistrasi() {
        return statusRegistrasi;
    }

    public String getStatusPenjemputan() {
        return statusPenjemputan;
    }

    public String getKelengkapanBerkas() {
        return kelengkapanBerkas;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setStatusRegistrasi(String statusRegistrasi) {
        this.statusRegistrasi = statusRegistrasi;
    }

    public void setStatusPenjemputan(String statusPenjemputan) {
        this.statusPenjemputan = statusPenjemputan;
    }

    public void setKelengkapanBerkas(String kelengkapanBerkas) {
        this.kelengkapanBerkas = kelengkapanBerkas;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
}
