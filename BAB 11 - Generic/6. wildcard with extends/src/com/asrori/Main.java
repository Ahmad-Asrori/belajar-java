package com.asrori;

/*
    ada sebuah method didalam interface Collection yaitu addAll yang fungsinya untuk menambahkan semua anggota
    dari satu Collection ke Collection lain

    interface Collection<E> {
        ....
        public boolean addAll(Collection<? extends E> c)
        ....
    }

    artinya diberikan sebuah Collection yang bertipe E, OK kamu bisa menambah semua anggota dari Collection
    lainnya dari element yang bertipe E.
    <? extends E> artinya, OK kamu boleh menambah semua anggota dari sebuah Collection dengan sembarang tipe data
    yang dimana tipe data tersebut adalah child dari E

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Number> nums = new ArrayList<>();
	    List<Integer> ints = Arrays.asList(1, 3);
	    List<Double> dbls = Arrays.asList(2.78, 3.14);
	    nums.addAll(ints);
	    nums.addAll(dbls);


	    /*
	        List<Number> adalah subtype dari Collection<Number> dan ints adalah nama variabel yang beripe List<Integer>
	        yang dimana dia adalah subtype dari Collection<? extends Number>
	     */
    }
}
