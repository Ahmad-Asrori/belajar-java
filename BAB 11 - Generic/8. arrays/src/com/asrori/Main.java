package com.asrori;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] ints = new Integer[] {1,2,3};
        Number[] nums = ints;
        nums[2] = 3.14; // array store exception

        /*
            Integer[] adalah anak dari Number[], menurut prinsip substitusi proses assignment yang berada
            dibaris kedua maka diperbolehkan. masalahnya ada dibaris ketiga. ketika array dialokasikan
            (pada baris pertama). dia di tandai dengan tipe data Integer. sebuah rray store exception
            akan muncul jika tipe data tidak cocok dengan nilai yang akan dimasukkan kedalamnya.
            dalam contoh ini sebuah nilai double tidak dapat disimpan kedalam array yang bertipe Integer.
         */

        List<Integer> ints2 = Arrays.asList(1,2,3);
        List<Number> nums2 = ints2; // compile-time error
        nums2.set(2, 3.14);
        assert ints.toString().equals("[1, 2, 3.14]");

        /*
            List<Integer> tidak di pertimbangkan sebagai child dari List<Number>, masalahnya terletak di
            baris ke dua.

            wildcard mengenalkan kembali covariant subtyping untuk generic.
         */

        List<Integer> ints3 = Arrays.asList(1,2,3);
        List<? extends Number> nums3 = ints3;
        nums.set(2, 3.14); // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]");

        /*
            pada baris kedua tidak terjadi error, tetapi kita tidak bisa mengubah nilai di dalam variabel
            nums
         */
    }
}
