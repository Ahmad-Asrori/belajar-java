package com.asrori;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1,2,3);
        int s = 0;

        //foreach
        for (int n : ints) { s += n; }

        //for loop biasa
        for (Iterator<Integer> it = ints. iterator(); it.hasNext(); ) {
            int n = it.next();
            s += n;
        }

        /*
            kedua perlulanga diatas melakukan hal yang sama.
            pada perulangan kedua ada variabel it yang bertipe Iterator<Integer> yang bertugas untuk mengiterasi terhadap list
            yang bertipe List<Integer>. pada umumnya compiler membuat sebuah nama baru that dapat memberikan garansi tidak bentrok
            dengan nama yang sudah ada di dalam kode. catatan UNBOXING terjadi saat ekspresi it.next() dari tipe data Integer
            dimasukkan kedalam variabel n

            perulangan foreach dapat diaplikasikan ke sembarang objek yang mengimplemts interface Iterable<E> yang menjadi refer
            interface Iterator<E>. mereke mendefine method Iterator, hasNext, dan next. yang digunakan untuk proses translasi dari
            perulangan foreach (iterator juga punya method remove, yang dimana method ini tidak digunakan oleh transltor )

            interface Iterable<E> {
                public Iterator<E> iterator();
            }

            interface Iterator<E> {
                public boolean hasNext();
                public E next();
                public void remove();
            }
         */
    }

    //foreach loop bisa digunakan pada array
    private static int jumlahkan(int[] a){
        int s = 0;
        for (int n : a) s += n;
        return s;
    }

    /*
        kita perlu mendefinisikan secara langsung Iterator jika kita ingin menggunakan method remove atau untuk mengiterasi
        lebih dari 1 list
     */
    public static void hapusBilanganNegatif(List<Double> d) {
        for (Iterator<Double> it = d.iterator(); it.hasNext();) {
            if (it.next() < 0) it.remove();
        }

        //jika menggunakan lambda expression
        //d.removeIf(aDouble -> aDouble < 0);
    }

    /*
        2 Iterator uIt dan vIt berguna mengiterasi list u dan list v.  while loop hanya memeriksa Iterator uIt tetapi assertion
        mengkonfirmasi kita bisa menggunakan Iterator kedua sebagai
     */
    public static double dot(List<Double> u, List<Double> v) {
        if (u.size() != v.size())
            throw new IllegalArgumentException("different sizes");
        double d = 0;
        Iterator<Double> uIt = u.iterator();
        Iterator<Double> vIt = v.iterator();
        while (uIt.hasNext()) {
            assert uIt.hasNext() && vIt.hasNext();
            d += uIt.next() * vIt.next();
        }
        assert !uIt.hasNext() && !vIt.hasNext();
        return d;
    }
}
