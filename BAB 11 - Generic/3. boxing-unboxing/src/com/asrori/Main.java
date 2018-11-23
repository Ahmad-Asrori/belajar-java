package com.asrori;


/*
    mengingat kembali, tipe data dijava ada yang primitive dan reference. tipe data reference bisa berupa kelas, interface
    atau array. semua tipe reference adalah subtipe dari kelas Object dan setiap variabel dari refenrence tipenya di set null

    konversi dari primitive ke reference dinamakan BOXING
    konversi dari reference ke primitive dinamakan UNBOXING

    java dengan generic secara otomatis memasukkan operasi BOXING dan UNBOXING secara paksa ketika ketika diperlukan.
    ketika sebuah ekspresi e tipe int muncul maka nilai dari tipe Integer dibutuhkan. BOXING mengkonversi ke new Integer(e)
    ketika sebuah ekspresi e tipe Integer muncul maka nilai dari tipe int dibutuhkan. UNBOXING mengkonversi ke expresi e.IntValue()

 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> angka = new ArrayList<>();
        angka.add(1);
        int n = angka.get(0);

        List<Integer> angka2 = new ArrayList<>();
        angka2.add(Integer.valueOf(1));
        int m = angka.get(0).intValue();

        /*
            memanggil method Integer.valueOf(1) sama dengan new Integer(1) tetapi menyita perfoma alasannya sudah dijelaskan diatas
         */
    }

    /*
        kenapa memakai List<Integer> bukan List<int> ? karena tipe parameter harus selalu dibungkus ke dalam tipe reference.
        kenapa method dibawah mereturn nilai dengan tipe int bukan Integer ? karena nilai returnnya kalau tidak bertipe int atau Integer
        UNBOXING terjadi ketika setiap Integer didalam list nilai di masukkan kedalam variabel n yang bertipe int
     */
    private static int penjumlahan(List<Integer> nilai){
        int s = 0;
        for (int n : nilai) s += n;
        return s;
    }

    /*
        kita tulis kembali method yang ada diatas dan ubah setiap tipe data int menjadi Integer
        method dibawah ini bisa dicompile tetapi kode dibawah ini melakukan pekerjaan yang tidak perlu. setiap perulangan mengUNBOXING
        nilai dari variabel s dan n. melakukan penjumlahan, dan BOXING hasil return ke tipe Integer.
        method dibawah ini lebih lambat dari yang diatas.
     */
    private static Integer penjumlahan2(List<Integer> nilai){
        Integer s = 0;
        for (Integer n : nilai) s += n;
        return s;
    }

}
