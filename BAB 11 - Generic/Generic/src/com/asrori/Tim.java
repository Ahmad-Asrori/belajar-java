package com.asrori;

import java.util.ArrayList;

public class Tim<T extends Pemain> implements Comparable<Tim<T>> {
    private String namaTim;
    private int bermain = 0;
    private int menang = 0;
    private int kalah = 0;
    private int seri = 0;
    private ArrayList<T> anggotaTIm = new ArrayList<>();

    public Tim(String namaTim) {
        this.namaTim = namaTim;
    }

    public String getNamaTim() {
        return namaTim;
    }

    public boolean tambahPemain(T pemain){
        if (anggotaTIm.contains(pemain)){
            System.out.println(pemain.getNamePemain() + " sudah ada dalam anggota tim");
            return false;
        } else {
            anggotaTIm.add(pemain);
            System.out.println(pemain.getNamePemain() + " di masukkan ke dalam tim " + this.namaTim);
            return true;
        }
    }

    public int jumlahPemain(){
        return this.anggotaTIm.size();
    }

    public void hasilPertandingan(Tim<T> lawan, int skorTim, int skorLawan){
        String pesan;

        if (skorTim > skorLawan){
            menang++;
            pesan = " mengalahkan ";
        } else if (skorTim == skorLawan){
            seri++;
            pesan = " imbang dengan ";
        } else {
            kalah++;
            pesan = " kalah dari ";
        }

        bermain++;

        if (lawan != null){
            System.out.println(this.getNamaTim() + pesan + lawan.getNamaTim());
            lawan.hasilPertandingan(null, skorLawan, skorTim);
        }
    }

    public int ranking(){
        return (menang*2) + seri;
    }

    @Override
    public int compareTo(Tim<T> tim) {
        if (this.ranking() > tim.ranking()){
            return 1;
        } else if (this.ranking() < tim.ranking()){
            return -1;
        } else {
            return 0;
        }
    }
}
