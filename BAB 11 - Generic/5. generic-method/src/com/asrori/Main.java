package com.asrori;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Integer> angka = keList(new Integer[] {1, 2, 3});
        List<String> kata = keList(new String[] {"selamat ", "malam"});

        /*
            membungkus banyak argument kedalam array adalah tidak praktis, fitur VARARG bisa mempersingkat
         */

        //solusi
        List<Integer> angka1 = keListVARARG(1, 2, 3);
        List<String> kata1 = keListVARARG("selamat ", "malam");

    }
    /*
        tanpa VARARG
        ini adalah method yang menerima array bertipe apapun dan mengubahnya kebentuk list
     */
    private static <T> List<T> keList(T[] array){
        List<T> list = new ArrayList<T>();
        for (T elt : array) list.add(elt);
        //Collections.addAll(list, array); cara cepat
        return list;
    }

    /*
        method static toList menerima sebuah array dari bertipe t[] dan mengembelikan sebuah list dari list bertipe List<T>
        <T> diawal method adalah sebagai sebuah tipe variabel baru. sebuah method yang dideklarasikan dengan tipe variabel
        disebut juga GENERIC METHOD. scopenya local terhadap method itu sendiri
     */

    private static <T> List<T> keListVARARG(T... array){
        List<T> list = new ArrayList<T>();
        for (T elt : array) list.add(elt);
        return list;
    }

}
