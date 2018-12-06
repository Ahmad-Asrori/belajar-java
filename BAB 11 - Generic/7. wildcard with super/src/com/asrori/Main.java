package com.asrori;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
        private static <T> void copy(List<? super T> dest, List<? extends T> source){
            for (int i=0; i<asal.size(); i++){
                tujuan.set(i, asal.get(i));
            }
        }

        ? super T berarti dest punya elemen yang bertipe data sembarang dimana tipe data tersebut
        adalah parent dari T. source punya element yang bertipe data sembarang dimana tipe data tersebut
        adalah child dari T

        kapan kita memakai super, kapan kita memakai extends, dan kapan kita tidak menggunakan wildcard sama sekali ?
        gunakan extends wildcard ketika kita hanya ingin MENDAPATKAN nilai dari sebuah struktur
        gunakan super wildcard ketika kita hanya ingin MEMASUKKAN nilai ke sebuah struktur
        jangan menggunakan wildcard ketika kita ingin mendapatkan dan menaruh nilai besamaan

        method diatas ingin MENDAPATKAN nilai dari source, jadi kita deklarasikan dengan extends wildcard
        dan MEMASUKKAN nilai kedalam dest, jadi kita seklarasikan dengan super wildcard

        ketika kita menggunakan iterator, kita mendapatkan nilai dari sebuah struktur. jadi kita gunakan
        extend wildcard

        private static Double tambah(Collection<? extends Number> nums){
            double s = 0.0;
            for (Number num : nums) s += num.doubleValue();
            return s;
        }
 */

public class Main {

    public static void main(String[] args) {
        List<Object> objek = Arrays.<Object>asList(3, 3.14, "empat");
        List<Integer> ints = Arrays.asList(5, 6);
        Collections.copy(objek, ints);
        Collections.<Number>copy(objek, ints);
        Collections.<Integer>copy(objek, ints);
    }

}
