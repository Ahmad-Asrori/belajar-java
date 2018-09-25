package com.asrori;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISimpan{
    private String namaMonster;
    private int hitPoint;
    private int kekuatan;

    public Monster(String namaMonster, int hitPoint, int kekuatan) {
        this.namaMonster = namaMonster;
        this.hitPoint = hitPoint;
        this.kekuatan = kekuatan;
    }

    public String getNamaMonster() {
        return namaMonster;
    }

    public void setNamaMonster(String namaMonster) {
        this.namaMonster = namaMonster;
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

    @Override
    public String toString() {
        return "Monster{" +
                "namaMonster='" + namaMonster + '\'' +
                ", hitPoint=" + hitPoint +
                ", kekuatan=" + kekuatan +
                '}';
    }

    @Override
    public List<String> tulis() {
        List<String> nilai = new ArrayList<>();
        nilai.add(0, this.namaMonster);
        nilai.add(1, "" + this.hitPoint);
        nilai.add(2, "" + this.kekuatan);

        return nilai;
    }

    @Override
    public void baca(List<String> nilai) {
        if (nilai != null && nilai.size() > 0){
            this.namaMonster = nilai.get(0);
            this.hitPoint = Integer.parseInt(nilai.get(1));
            this.kekuatan = Integer.parseInt(nilai.get(2));
        }
    }
}
