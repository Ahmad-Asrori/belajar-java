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
import java.util.Collections;
import java.util.List;

class Kursi implements Comparable<Kursi>{
    private final String kodeKursi;
    private boolean sudahDipesan = false;

    public Kursi(String kodeKursi) {
        this.kodeKursi = kodeKursi;
    }

    /*
        method untuk membandingkan dua buah kode kursi
     */

    @Override
    public int compareTo(Kursi kursi) {
        return this.kodeKursi.compareToIgnoreCase(kursi.getKodeKursi());
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

     */
    public boolean pesamKursi(String kodeKursi) {
        Kursi kursiYangDiminta = new Kursi(kodeKursi);
        int kursiDitemukan = Collections.binarySearch(deretanKursi, kursiYangDiminta, null);

        if (kursiDitemukan >= 0){
            return deretanKursi.get(kursiDitemukan).pesan();
        } else {
            System.out.println("tidak ada kode kursi " + kodeKursi);
            return false;
        }
    }

    /*
        method ini bertujuan untuk mengiterasi objek kursi yang ada di dalam arraylist deretan kursi
     */

    public void listKursi() {
        for(Kursi kursi : deretanKursi) {
            System.out.println(kursi.getKodeKursi());
        }
    }

    public List<Kursi> getDeretanKursi() {
        return deretanKursi;
    }
}
