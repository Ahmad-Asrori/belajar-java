package com.asrori;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Pemain asrori = new Pemain("asrori", 9000, 500);
        System.out.println(asrori.toString());

        simpanObjek(asrori);
    }

    private static void menu(){
        System.out.println("menu");
        System.out.println("===============");
        System.out.println("1. masukkan data");
        System.out.println("2. keluar");
        System.out.println("masukkan pilihan kamu [1-2] : ");
    }

    private static ArrayList<String> bacaNilai(){
        ArrayList<String> nilai = new ArrayList<>();
        boolean stop = false;
        int indeks = 0;

        do {
            menu();
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 2) stop = true;
            if (pilihan == 1){
                System.out.println("masukkan kata : ");
                String stringInput = scanner.nextLine();
                nilai.add(stringInput);
                indeks++;
            }
        }while (!stop);

        return nilai;
    }

        //parameter masukan berupa Interface
    private static void simpanObjek(ISimpan nilai){

            //nilai.tulis() : memanggil method tulis melalui interface
            //nilai.tulis() mengembalikan list nilai
            //karena kita ingin mencetak semua nilai didalam list maka kita perlu menambahkan method size()
            //untuk mengetahui berapa banyak elemen yang disimpan di dalam list
            //List<String> hasil = nilai.tulis();
        for (int i=0; i<nilai.tulis().size(); i++){
            System.out.println("menyimpan " + nilai.tulis().get(i) + " ke tempat penyimpanan");
        }
    }

    private static void muatObjek(ISimpan nilai){
        ArrayList<String> hasil = bacaNilai();
        nilai.baca(hasil);
    }


}