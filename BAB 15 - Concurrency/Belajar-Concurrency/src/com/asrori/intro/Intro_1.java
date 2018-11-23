package com.asrori.intro;
import java.lang.Thread;

public class Intro_1 {

    public static void main(String[] args) {
        /*
           setiap thread mempunyai identifier/ID yang itu adalah unik didalam JVM, setiap thread juga mempunyai nama yang berguna untuk mengidentifikasi
           thread didalam aplikasi monitoring (debugger atau testing tool yang lain ) yang berjalan menggunakan JVM.
           ketika satu thread dieksekusi, PRIORITY akan memutuskan task mana yang akan dieksekusi selanjutnya.

           sebenarnya, tidak semua thread benar benar di eksekusi secara simultan (bersamaan), tetapi waktu eksekusi pada disetiap core CPU, JVM akan
           membagi bagi menjadi potongan potongan kecil. JVM akan memasukkan potongan kecil selanjutnya kedalam waiting thread selanjutnya dengan
           berdasarkan prioritas tertinggi terlebih dahulu.

           setelah PRIORITY, sebuah thread juga mempunyai sebuah STATE/kondisi yang diantaranya

           - NEW : thread masih belum di jalankan
           - RUNNABLE : thread sedang dieksekusi didalam JVM
           - BLOCKED : thread yang di blok sedang menunggu untuk monitor lock
           - WAITING : thread yang menunggu thread yang lain untuk melakukan pekerjaan tertentu sampai selesai
           - TIMED_WAITING : thread yang menunggu thread yang lain untuk melakukan pekerjaan tertentu sampai batas waktu tertentu
           - TERMINATED : thread yang telah diberhentikan

            state BLOCKED jika tidak ditangani secara baik, maka thread dapat memblock thread lain yang akhirnya dapat membuat aplikasi
            menjadi hang atau not responding

            terakhir, ada THREAD GROUP yang mengartikan bahwa sebuah thread dimanage dalam satu group. THREAD GROUP memiliki beberapa thread.
            dengan THREAD GROUP kita bisa menghentikan sementara semua thread yang ada di dalam group tertentu atau mengatur PRIORITY thread yang
            berada di group tersebut
         */

        Long id = Thread.currentThread().getId();
        String nama = Thread.currentThread().getName();
        int prioritas = Thread.currentThread().getPriority();
        Thread.State state = Thread.currentThread().getState();
        String threadGroup = Thread.currentThread().getThreadGroup().getName();

        System.out.println("id : " + id);
        System.out.println("nama : " + nama);
        System.out.println("prioritas : " + prioritas);
        System.out.println("state : " + state);
        System.out.println("thread group : " + threadGroup);
    }

}
