package com.asrori;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList<String> daftarKota = new LinkedList<>();

        tambahDalamUrutan(daftarKota, "denpasar");
        tambahDalamUrutan(daftarKota, "surabaya");
        tambahDalamUrutan(daftarKota, "bandung");
        tambahDalamUrutan(daftarKota, "jakarta");

        cetakDaftarTempat(daftarKota);

        mengunjungi(daftarKota);
    }

    private static void cetakDaftarTempat(LinkedList<String> daftarKota){
        Iterator<String> i = daftarKota.iterator(); //iterator

        //cara selain menggunakan for loop
        while (i.hasNext()){
            System.out.println("sekarang mengunjungi " + i.next());
        }
        System.out.println("====================================");
    }

    private static boolean tambahDalamUrutan(LinkedList<String> daftarKota, String kotaBaru){
        ListIterator<String> stringIterator = daftarKota.listIterator(); //listIterator

        while (stringIterator.hasNext()){
            int compare = stringIterator.next().compareTo(kotaBaru);

            if (compare == 0){
                System.out.println(kotaBaru + " sudah ada dalam daftar");
                return false;
            } else if (compare > 0){
                stringIterator.previous();
                stringIterator.add(kotaBaru);
                return true;
            } else if (compare < 0){
                //ke list berikutnya
            }
        }

        stringIterator.add(kotaBaru);
        return true;
    }

    private static void mengunjungi(LinkedList kota){
        boolean quit = false;
        boolean maju = true;
        ListIterator<String> listIterator = kota.listIterator();

        if (kota.isEmpty()){
            System.out.println("tidak ada data didalam linked list");
            return;
        } else {
            System.out.println("sekarang mengunjungi kota " + listIterator.next());
            lihatMenu();
        }

        while (!quit){
            System.out.print("masukkan angka : ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu){
                case 0 :
                    System.out.println("liburan selesai");
                    quit = true;
                    break;

                case 1 :
                    if (!maju){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        maju = true;
                    }

                    if (listIterator.hasNext()){
                        System.out.println("sekarang berada di kota " + listIterator.next());
                    } else {
                        System.out.println("telah mencapai akhir linked list");
                        maju = false;
                    }
                    break;

                case 2 :
                    if (maju){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        maju = false;
                    }

                    if (listIterator.hasPrevious()){
                        System.out.println("sekarang berada di kota " + listIterator.previous());
                    } else {
                        System.out.println("berada di awal linked list");
                        maju = true;
                    }
                    break;

                case 3 :
                    lihatMenu();
            }
        }
    }


    private static void lihatMenu(){
        System.out.println("menu");
        System.out.println("======");
        System.out.println("0. keluar");
        System.out.println("1. pergi ke kota selanjutnya");
        System.out.println("2. pergi ke kota sebelumnya");
        System.out.println("3. lihat menu");
    }

}
