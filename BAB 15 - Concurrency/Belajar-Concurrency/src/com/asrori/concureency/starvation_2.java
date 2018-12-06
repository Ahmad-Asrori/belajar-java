package com.asrori.concureency;

/*
    SCHEDULER memutuskan thread mana yang akan dieksekusi selanjutnya. keputusan ini berdasarkan THREAD PRIORITY
    karena itu thread dengan prority yang lebih rendah mendapatkan lebih sedikit CPU TIME daripada thread dengan
    priority yang lebih tinggi. jika thread dengan waktu eksekusi yang lama dengan priority tinggi dieksekusi.
    thread dengan priority rendah kelihatan "kelaparan", mereka tidak mendapatkan cukup waktu untuk mengeksekusi
    dirinya dengan baik.

    contoh lain dengan waktu eksekusi adalah masalah dimana tidak didefinisikan dimana urutan thread melewati
    blok synchronized ketika beberapa thread yang berjalan bersamaan mengeksekusi blok kode didalam synchronized
    kejadian tersebut dapat menyebabkan thread tertentu menunggu lebih lama sampai akhirnya dapat masuk ke blok.

    solusinya adalah dengan "fair" lock,


 */

public class starvation_2 {

}
