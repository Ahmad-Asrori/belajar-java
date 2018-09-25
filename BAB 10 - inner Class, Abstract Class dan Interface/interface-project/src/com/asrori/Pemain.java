package com.asrori;

import java.util.ArrayList;
import java.util.List;

public class Pemain implements ISimpan{
    private String namaPemain;
    private int hitPoint;
    private int kekuatan;
    private String senjata;

    public Pemain(String namaPemain, int hitPoint, int kekuatan) {
        this.namaPemain = namaPemain;
        this.hitPoint = hitPoint;
        this.kekuatan = kekuatan;
        this.senjata = "sword";
    }

    public String getNamaPemain() {
        return namaPemain;
    }

    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getKekuatan() {
        return kekuatan;
    }

    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    public String getSenjata() {
        return senjata;
    }

    public void setSenjata(String senjata) {
        this.senjata = senjata;
    }

    @Override
    public String toString() {
        return "Pemain{" +
                "namaPemain='" + namaPemain + '\'' +
                ", hitPoint=" + hitPoint +
                ", kekuatan=" + kekuatan +
                ", senjata='" + senjata + '\'' +
                '}';
    }

    @Override
    public List<String> tulis() {
        List<String> nilai = new ArrayList<>();
        nilai.add(0, this.namaPemain);
        nilai.add(1, "" + this.hitPoint); //untuk mengakali agar bisa di masukkan kedalam string
        nilai.add(2, "" + this.kekuatan);
        nilai.add(3, this.senjata);

        return nilai;
    }

    @Override
    public void baca(List<String> nilai) {
        if (nilai != null && nilai.size() > 0){
            this.namaPemain = nilai.get(0);
            this.hitPoint = Integer.parseInt(nilai.get(1)); //convert ke
            this.kekuatan = Integer.parseInt(nilai.get(2));
            this.senjata = nilai.get(3);
        }
    }
}
