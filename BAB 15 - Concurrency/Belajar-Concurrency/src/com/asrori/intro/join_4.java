package com.asrori.intro;

/*
    pada sesi sleep dan interupt kita telah belajar bagaimana membuat thread "sleep" dan "dibangunkan" kembali oleh
    thread yang lain. fitur lain yang penting dari thread adalah kemampuan dari sebuah thread untuk menunggu thread lain
    berhenti/TERMINATED.

    kita umpamakan kita ingin melakukan beberapa task/pekerjaan yang dapat dibagi bagi dan dijalankan di beberapa thread secara
    paralel. main thread akan menjalankan WORKER THREAD (thread yang akan menangani perkerjaan). THREAD WORKER akan menunggu sampai
    semua CHILD THREAD berhenti/TERMINATED.
 */


import java.util.Random;

class JoinSaya implements Runnable{
    private Random rand = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        //kita berikan task yang berat untuk CPU
        for (int i=0; i<1000000000; i++){
            rand.nextInt();
        }

        System.out.println("[" + Thread.currentThread().getName() + "] telah selesai dieksekusi");
    }
}

public class join_4 {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threadSaya = new Thread[5];

        for (int j=0; j<threadSaya.length; j++){
            threadSaya[j] = new Thread(new JoinSaya(), "join thread-"+j);
            threadSaya[j].start();
        }

        for (int k=0; k<threadSaya.length; k++){
            threadSaya[k].join();
        }

        System.out.println("[" + Thread.currentThread().getName() + "} seluruh thread telah menyelesaikan task");

        /*
            didalam main method kita membuat lima thread menggunakan array yang kesemuanya akan dieksekusi satu persatu.
            kita menjalankan semua thread, main thread menunggu kelima thread tersebut berhenti. kelima thread tersebut
            masing masing merandom angka, setelah selesai setiap thread mengeluarkan pesan telah selesai dieksekusi.

            sekali lagi kita tidak dapat memprediksi thread mana yang akan dieksekusi pertama dan seterusnya. itu semua
            tergantung SCHEDULER
         */
    }

}
