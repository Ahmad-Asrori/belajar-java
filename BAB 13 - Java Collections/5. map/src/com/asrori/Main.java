package com.asrori;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Teater teater1 = new Teater("cinema 21", 11, 15);

        List<Kursi> harga_kursi = new ArrayList<>();
        harga_kursi.add(new Kursi("A00", 10000));
        harga_kursi.add(new Kursi("B00", 30000));
        Collections.sort(harga_kursi, Teater.HARGA_KURSI);
        print(harga_kursi);
    }

    private static void print(List<Kursi> list){
        for (Kursi kursi : list){
            System.out.println(" " + kursi.getKodeKursi() + " " + kursi.getHarga());
        }
    }
}
