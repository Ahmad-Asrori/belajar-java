package com.asrori;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Teater teater1 = new Teater("cinema 21", 11, 15);

//	    //mengacak urutan
//        Collections.shuffle(teater1.getDeretanKursi());
//	    printList(teater1.getDeretanKursi());
//	    //membalikkan urutan
//	    Collections.reverse(teater1.getDeretanKursi());
//        printList(teater1.getDeretanKursi());
//        //cari elemen terkecil
//        Kursi minKursi = Collections.min(teater1.getDeretanKursi());
//        //cari elemen terbesar
//        Kursi maxKursi = Collections.max(teater1.getDeretanKursi());
//        System.out.println("min : " + minKursi.getKodeKursi());
//        System.out.println("max : " + maxKursi.getKodeKursi());
    }

    private static void printList(List<Kursi> kursi){
        for (Kursi kursi1 : kursi){
            System.out.print(" " + kursi1.getKodeKursi());
        }

        System.out.println();
        System.out.println("============================");
    }
}
