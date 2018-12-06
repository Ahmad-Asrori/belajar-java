package com.asrori.concureency;

/*
    hal yang umu dilakukan dalam multithreading computing adalah meminta beberapa WORKER THREAD untuk
    menunggu PRODUCER untuk melakukan pekerjaan. terus menerus menunggu didalam perulangan dan memeriksa
    beberapa adalah pilihan yang kurang bagus. didalam kasus ini Thread.Sleep() juga tidak memberikan
    banyak kemudahan ketika kita memulai mengeksekusi kode dengan segera setelah disubmit.

    didalam bahasa pemrograman java punya solusi lain yang bisa digunakan untuk skenario tersebut.
    yaitu WAIT dan NOTIFY.
    method wait() fungsinya untuk menghentikan sementara thread yang sekarang ini bekerja dan menunggu
    sampau thread lain membangunkan menggunakan method notify(). Agar berfungsi dengan benar, thread yang memanggil
    metode waith() harus menahan kunci yang telah diperolehnya sebelum menggunakan synchronized keyword.
    Saat memanggil method wait() kunci dilepaskan dan thread menunggu hingga thread lain yang sekarang memiliki
    panggilan kunci memberi tahu () pada instance objek yang sama.


 */

public class WaitDanNotify_3 {

}
