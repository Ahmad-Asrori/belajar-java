package com.asrori;

import java.util.List;

public class Teater {
    private final String namaTeater;
    private List<Kursi> deretanKursi = new List<>();

    public Teater(String namaTeater, int jumlahBaris, int jumlahKursiPerBaris) {
        this.namaTeater = namaTeater;

        int barisTerakhir = 'A' + (jumlahBaris-1);
        for (char baris = 'A'; baris <= barisTerakhir; baris){
            for (int nomorKursi = 1; nomorKursi <= jumlahKursiPerBaris; nomorKursi++){
                Kursi kursi = new Kursi(baris + String.format("%02d" + nomorKursi));
                deretanKursi.add(kursi);
            }
        }
    }

    public String getNamaTeater() {
        return namaTeater;
    }
}
