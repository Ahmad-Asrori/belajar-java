package com.asrori;

import java.util.ArrayList;

public class Main {

    //Integer sebenarnya adalah sebuah class
    //struktur data di java kebanyakan memakai tipe data objek

    public static void main(String[] args) {
        int angka1 = 1008;
        Integer angka2 = Integer.valueOf(angka1); //autoboxing
        int hasil = angka2.intValue(); //unboxing

        ArrayList<Integer> angka = new ArrayList<>(); //kalau tipe data int tidak bisa
        angka.add(90);
        angka.add(45);

        for (int i = 0; i < angka.size(); i++){
            System.out.println((i+1) + ". angka : " + angka.get(i)); //nilai masih dalam bentuk objek karena belum di unboxing
        }
    }
}
