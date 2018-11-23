package com.asrori.intro;

import java.lang.Thread;

/*
    ketika kita membuat thread, thread tersebut berjalan dan hidup sampai method run() selesai dieksekusi.
    didalam contoh nyata. normalnya kita juga menjalankan beberapa task di belakang layar. contohnya seperti
    kita membuat background thread untuk mengecek beberapa n detik ketika sesuatu terjadi (misalnya ada file yang telah dibuat)
    atau dalam beberapa n detik melakukan beberapa pekerjaan / task
    dalam kasus ini kita diharuskan uktuk menanti/WAIT beberapa detik. kita dapat menggunakan while loop body untuk
    mendapatkan detik sekarang. meskipun cara ini berhasil tetapi cara ini dapat membebani kinerja CPU karena harus meretrieve
    waktu sekarang berulang ulang.
    cara yang efektif adalah dengan memanggil method sleep() dari java.util.Thread

    pemanggilan method sleep() membuat suatu thread "tidur" tanpa memakan waktu proses. yang artinya thread tersebut
    dihapus dari daftar ACTIVE THREAD dan JVM tidak mengeksekusi sampai beberapa waktu berlalu.

    perlu dicatat bahwa waktu yang dimasukkan sebagai parameter di sleep() untuk membuat SCHEDULER/PENJADWALAN, bukan waktu eksekusi
    thread akan kembali beberapa detik lebih awal atau beberapa detik lebih lama dari waktu yang telah ditetapkan SCHEDULER.
    karena itu jangan menggunakan method sleep() untuk penjadwalan/scheduling secara real time

    lalu kita juga membutuhkan interuptedException untuk menangani method sleep() jika sewaktu waktu terjadi interupsi.
    interupt adalah fitur dasar dari THREAD INTERACTION yang dapat mengetahui pesan interupsi sederhana yang suato thread
    kirimkan ke thread yang lain

    thread yang dikirimi pesan dapat secara langsung menanyakan jika dia diinterupsi atau tidak dengan memanggil method
    Thread.interupted()
 */

class InterupsiSaya implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() + "]" + " diinterupsi oleh exception");
        }

        while (!Thread.interrupted()){
            //tidak melakukan apa apa
        }

        System.out.println("[" + Thread.currentThread().getName() + "]" + " diinterupsi kedua kalinya");


    }
}


public class SleepdanInterupt_3 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadSaya = new Thread(new InterupsiSaya(), "thread 1");
        threadSaya.start();

        System.out.println("[" + Thread.currentThread().getName() + "] " + "sleep selama 5 detik");
        Thread.sleep(5000);

        System.out.println("[" + Thread.currentThread().getName() + "] " + "sedang menginterupsi threadSaya");
        threadSaya.interrupt();

        System.out.println("[" + Thread.currentThread().getName() + "] " + "sleep selama 5 detik");
        Thread.sleep(5000);

        System.out.println("[" + Thread.currentThread().getName() + "] " + "sedang menginterupsi threadSaya");
        threadSaya.interrupt();


        /*
            hal yang menarik disini adalah pada output baris 5 dan 4. kita mungkin berharap bahwa kalimat diinterupsi oleh exception akan
            muncul setelah thread main memanggil method sleep(). tetapi sudah kita lihat bahwa SCHEDULER mengeksekusi main thread sebelum
            memulai mengeksekusi lagi thread thread 1

            cara yang kita lakukan adalah cara pengamatan yang sederhana dengan mengetes setiap thread dengan log/output, log/output yang
            kita harapkan dengan apa yang kita lihat sangat sulit untuk diprediksi dan sangat sulit mengetahui thread mana yang akan
            dieksekusi selanjutnya
            akan menjadi lebih sulit ketika kita harus mengatasi lebih banyak thread yang "tidur". dalam contoh diatas terdapat proses
            yang dinamis didalam program sehingga concurrent programming menjadi sesuatu yang menantang untuk dikuasai
         */
    }

}
