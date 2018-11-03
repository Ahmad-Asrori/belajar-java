package com.asrori;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Lokasi> lokasiLokasi = new HashMap<>();
    public static void main(String[] args) {
        lokasiLokasi.put(0, new Lokasi(0, "You are sitting in front of a computer learning Java"));
        lokasiLokasi.put(1, new Lokasi(1, "You are standing at the end of a road before a small brick building"));
        lokasiLokasi.put(2, new Lokasi(2, "You are at the top of a hill"));
        lokasiLokasi.put(3, new Lokasi(3, "You are inside a building, a well house for a small spring"));
        lokasiLokasi.put(4, new Lokasi(4, "You are in a valley beside a stream"));
        lokasiLokasi.put(5, new Lokasi(5, "You are in the forest"));

        int lokasi = 1; //sedang berda di lokasi 1
        while(true) {
            //tampilkan lokasi
            System.out.println(lokasiLokasi.get(lokasi).getKeterangan());
            //jika loc
            if(lokasi == 0) {
                break;
            }

            lokasi = scanner.nextInt();
            if(!lokasiLokasi.containsKey(lokasi)) {
                System.out.println("You cannot go in that direction");
            }
        }    }
}
