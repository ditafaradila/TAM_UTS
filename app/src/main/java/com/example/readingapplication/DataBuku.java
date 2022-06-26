package com.example.readingapplication;

public class DataBuku {
    private final int cover;
    private final String judul, penulis, waktu;

    public DataBuku(int cover, String judul, String penulis, String waktu) {
        this.cover = cover;
        this.judul = judul;
        this.penulis = penulis;
        this.waktu = waktu;
    }

    public int getCover() {
        return cover;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getWaktu() {
        return waktu;
    }
}
