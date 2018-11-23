package com.asrori.intro;

/*
    pada dasarnya ada 2 cara untuk membuat sebuah thread, cara yang pertama adalah membuat kelas lalu
    kelas tersebut mengextends kelas Thread java.lang.Thread, cara yang kedua adalah dengan membuat kelas, lalu
    kelas tersebut mengimplements interface Runnable
 */

/* cara pertama */
class ThreadSaya extends Thread {
    private String nama;

    public ThreadSaya(String nama){
        this.nama = nama;
    }

    @Override
    public void run() {
        System.out.println("sedang mengeksekusi thread : " + currentThread().getName());
    }
}

/* cara kedua */
class ThreadSayaLagi implements Runnable {
    @Override
    public void run() {
        System.out.println("sedang mengeksekusi thread : " + Thread.currentThread().getName());
    }
}

public class BuatThread_2 {

    public static void main(String[] args) throws InterruptedException {
        /*
            penggunaan thread dengan cara pertama
            pada cara pertama, kelas ThreadSaya mengextend kelas Thread dan mengoverrides method run(). method run()
            dieksekusi satu kali ketika JVM memulai eksekusi terhadap thread ini. JVM melakukan beberapa pekerjaan untuk mengatur eksekusi environment
            untuk thread ini. kita tidak dapat memanggil method run() secara langsung untuk membuat thread. sebagai gantinya, kita memanggil method
            start() melalui instance dari kelas ThreadSaya untuk membuat thread.
            pada kelas ini mendapatkan turunan method stop() dari superkelasnya, method ini bertujuan untuk memberitahu JVM
            untuk mengalokasikan semua resource yang dibutuhkan untuk thread dan menjalankannya.
         */
        ThreadSaya threadSaya = new ThreadSaya("thread-saya");
        threadSaya.start();

        /*
            penggunaan thread dengan cara kedua
            perbedaan utama cara pertama dengan cara kedua adalah kita membuat instance dari java.lang.Thread dan memasukkan
            instance yang mengimplemts Runnable interface sebagai argumen constructor. argumen bisa ditambahkan dengan nama
            thread
            misal seperti ini : Thread threadSayaLagi = new Thread(new ThreadSayaLagi(), "threadSayaLagi");
            menggunakan subkelas atau interface dalam membuat thread...?itu tergantung kebutuhan, interface lebih lightweuight
            dari subkelas
         */
        Thread threadSayaLagi = new Thread(new ThreadSayaLagi(){});
        threadSayaLagi.start();
    }

}
