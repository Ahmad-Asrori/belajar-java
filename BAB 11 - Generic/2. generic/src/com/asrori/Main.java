package com.asrori;

/*
    sebuah interface atau kelas mungkin dideklarasikan dengan menggunakan satu atau lebih tipe parameter.
    yang ditulis didalam kurung siku <> dan nilai dialam <> di ambil dari sebuah variabel yang
    dimiliki oleh sebuah interface atau kelas
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> kata = new ArrayList<>();
        kata.add("Hello ");
        kata.add("World");
        String s = kata.get(0) + kata.get(1);

        assert s.equals("Hello World");

        /*
            didalam collections framework, kelas ArrayList<E> mengimplement interface List<E>. contoh diatas
            adalah contoh sederhana yang artinya kita deklarasikan variabel kata yang akan menyimpan daftar
            strint. buat instance dari ArrayList, tambahkan 2 string ke list, dan seterusnya.

         */

        //contoh tanpa generic
        List kata2 = new ArrayList();
        kata2.add("Hello ");
        kata2.add("world!");
        String t = ((String)kata2.get(0)) + ((String)kata2.get(1));

        assert t.equals("Hello world!");

        /*
            jika tanpa tipe parameter, kita harus mengcasting secara exlpisit ketika ada mengakses nilai didalam list.
            generic secara implicit sama dengan generic secara eksplisit. jika proses casting gagal maka kodingan akan
            susah didebug
         */
    }
}
