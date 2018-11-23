package com.asrori;

/*
    generic dan collection bekerja dengan baik, bebrapa fitur baru seperti autoboxing dan unboxing, bentuk for loop yang baru dan
    fungsi yang menerima sebuah variabel angka dari argument. kita mulai dari contoh yang meinglustrasikan itu semua
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
           contoh sederhananya, kita masukkan 3 angka ke sebuah list dan menambahkan mereka
         */

        List<Integer> ints = Arrays.asList(1, 2, 3);
        int s = 0;
        for (int n : ints){
            s += n;
        }

        assert s == 6;

        /*
            kita mungkin lebih mmudah mengetahui maksud dari kode diatas tanpa banyak penjelasan.tapi mari kita lihat fitur nya.
            1. interface List dan kelas Arrays adalah bagian dari Collections framework (keduanya bisa ditemukan didalam package java.util).
            sekarang List sudah bertipe generic karena kita menulist List<E> untuk mengindikasikan sebuah list dengan elemen bertipe E.
            disini kita menulis LIst<Integer> untuk mengindikasikan elemen tersebut dimiliki oleh kelas Integer, kelas Integer adalah kelas
            pembungkus yang mirip dengan tipe data primitif int. BOXING dan AUTOBOXING dibutuhkan untuk mengkonversi dari tipe data privitive
            ke wrapper kelas, tetapi ini otomatis. static method asList mengambil seluruh nilai dari arguman, memasukkan nilai tersebut ke
            dalam array dan mengembalikan sebuah list baru yang berbentuk array.

            2.bentuk loop baru disebut foreach digunakan untuk membaca secara berurutan setiap variabel dari list. didalam badan loop kita
            jumlahkan n kedalam s. statement assert digunakan untuk mengecek apakah hasil penjumlahan sudah benar, ketika assertion di aktifkan
            ketika mengompile dia akan mereturn error ketika ada sebuah kondisi yang tidak sesuai
         */

        //kode sebelum ada fitur generic
//
//        List ints = Arrays.asList( new Integer[] {new Integer(1), new Integer(2), new Integer(3)});
//        int s = 0;
//        for (Iterator it = ints.iterator(); it.hasNext(); ) {
//            int n = ((Integer)it.next()).intValue();
//            s += n;
//        }
//        assert s == 6;

    }
}
