package com.asrori;

/*
    program booking kursi

    kita akan membuat sebuah program untuk membooking kursi, langkah sederhanya adalah
    pertama tama kita buat kelas kursi untuk menampung kode kursi dan status pemesanan, terdapat 2 method utama yakni pesan dan batal
    kemusian kita buat kelas teater, didalam kelas ini kita membuat kode kursi kode kursi diawali dengan kode baris misal (A, B, C) dan
    diikuti dengan nomor kursi. contoh kode Kursi (A01, A02).
    setelah itu kita buat method untuk pesan kursi
 */

import java.util.ArrayList;
import java.util.List;

class Kursi {
    private final String kodeKursi;
    private boolean sudahDipesan = false;

    public Kursi(String kodeKursi) {
        this.kodeKursi = kodeKursi;
    }

    /*
        method ini bertujuan untuk mengecek apakah kode kursi yang dimasukkan sudah dipesan
     */
    public boolean pesan() {
        if(!this.sudahDipesan) {
            this.sudahDipesan = true;
            System.out.println("Kursi " + kodeKursi + " sudah Dipesan");
            return true;
        } else {
            return false;
        }
    }

    /*
        method ini bertujuan untuk membatalkan status sudahDipesan
     */
    public boolean batal() {
        if(this.sudahDipesan) {
            this.sudahDipesan = false;
            System.out.println("Pemesanan Kursi " + kodeKursi + " dibatalkan");
            return true;
        } else {
            return false;
        }
    }

    public String getKodeKursi() {
        return kodeKursi;
    }
}

public class Teater {
    private final String namaTeater;
    private List<Kursi> deretanKursi = new ArrayList<>();

    /*
        constructor dibawah ini tujuannya untuk membuat semua nomor kursi dan memasukkannya kedalam arraylist deretan kursi
        misal :  namaTeater = "bioskop 21", jumlahBaris = 11, kursiPerbaris = 15
        step 1 (baris ke 48) : masukkan valur namaTeater ke property namaTeater
        step 2 (baris ke 61) : masukkan character baris terakhir, A nilai ASCIInya 65 nanti ditambahkan dengan (jumlah baris-1).
        misal nilai jumlahBarisnya = 3, maka perhitungannya adalah 65 + (3-1) = 67, 67 adalah nilai ASCII dari huruf C
        step 3 (baris ke 54) : looping baris kursi
        step 4 (baris ke 56) : looping nomor kursi
        step 5 (baris ke 59) : buat objek kursi lalu masukkan baris kursi dan nomor kursi
        step 6 (baris ke ) : masukkan objek kursi yang sudah berisi kode kursi kedalam arraylist
    */
    public Teater(String namaTeater, int jumlahBaris, int kursiPerBaris) {
        this.namaTeater = namaTeater;

        int barisTerakhir = 'A' + (jumlahBaris - 1);
        for (char baris = 'A'; baris <= barisTerakhir; baris++) {
            for(int nomorKursi = 1; nomorKursi <= kursiPerBaris; nomorKursi++) {
                Kursi kursi = new Kursi(baris + String.format("%02d", nomorKursi));
                deretanKursi.add(kursi);
            }
        }
    }

    public String getNamaTeater() {
        return namaTeater;
    }

    /*
        method ini tujuannya untuk memesan kursi dengan memasukkan kode kursi
        (jika kode kursi cocok)
        step 1 : buat objek kursiYangDiminta isikan dengan null
        step 2 : looping deretankursi
        step 3 : jika kode kursi yang ada di deretan kursi sama dengan kode kursi yang dicari maka lanjutke step 4
        step 4 : isi objek kursiYangDiminta dengan kursi yang ditemukan
        step 5 : lakukan pemesanan kursi

        (jika kode kursi tidak cocok)
        step 1 : buat objek kursiYang Diminta isikan dengan null
        step 2 : looping deretankursi
        step 3 : jika kode kursi yang ada di deretan kursi tidak sama dengan kode kursi yang dicari maka lanjutke step 4
        step 4 : return false
     */
    public boolean pesamKursi(String kodeKursi) {
        Kursi kursiYangDiminta = null;
        for(Kursi kursi : deretanKursi) {
            if(kursi.getKodeKursi().equals(kodeKursi)) {
                kursiYangDiminta = kursi;
                break;
            }
        }

        if(kursiYangDiminta == null) {
            System.out.println("There is no seat " + kodeKursi);
            return false;
        }

        return kursiYangDiminta.pesan();
    }

    /*
        method ini bertujuan untuk mengiterasi objek kursi yang ada di dalam arraylist deretan kursi
     */

    public void listKursi() {
        for(Kursi kursi : deretanKursi) {
            System.out.println(kursi.getKodeKursi());
        }
    }
}
