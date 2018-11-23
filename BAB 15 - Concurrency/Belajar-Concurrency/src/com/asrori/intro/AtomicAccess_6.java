package com.asrori.intro;

/*
    pada contoh sebelumnya kita telah mempelajari bagaimana synchronized mengakses sebuah resource yang sama ketika semua
    thread berjalan secara bersamaan untuk menjalankan sebuah bagian dari kode tetapi hany adalah satu thread yang boleh
    mengeksekusi bagian dari kode tersebut dalam suatu waktu.

    java menyediakan bebrapa operasi dasar yang atomic dan dapat digunakan untuk memastikan thread yang berjalan bersamaan
    selalu mengakses resource yang sama

    - operasi baca dan tulis sebuah variabel dan primitive variabel (kecuali long dan double)
    - operasi baca dan tulis sebuah variabel yang dideklarasikan secara volatil

    untuk mengetahui hal ini lebih detail. mari kita mengasumsikan kita punya HashMap yang diisi dengan properti yang dibaca
    dari file dan beberapa thread yang mengakses properti tersebut. ini sudah jelas kita membutuhkan keyword synchronized.
    proses memcara file dan mengupdate element dari Map memakan waktu yang berdampak pada thread lainnya

    kita tidak bisa dengan mudah membagikan instance map diatara semua thread selama proses update  itu akan menyebabkan
    konsistenan kondisi didalam Map yang berarti jika kita membaca nilai dari map tersebut nilainya tidak sesuai dari apa
    yang kita harapkan. dengan apa yang kita pelajari sebelumnya kita telah mengetahui bahwa block synchronized  akan menjamin
    semua thread hanya melihat satu state/kondisi dan bukan mengupdate map secara terpisah. tetapi ini akan menyebabkan masalah
    performa dimana jika thread yang berjalan secara bersamaan sering membaca nilai dari map

    menduplikasi map untuk setiap thread juga merupakan solusi namun setiap thread juga harus mengecek secara periodik untuk
    update dan copy. solusi seperti ini tidak layak dan ada solusi yang lebih sederhana

    kita tahu bahwa operasi tulis ke sebuah reference adalah atomic. kita dapat membuat map baru setiap kita membaca file
    dan mengupdate reference yang dibagikan diantara thread di dalam satu operasi atomik.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AtomicAccess_6 implements Runnable{

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd ");
    private static Map<String, String> konfigurasi = new HashMap<>();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            Map<String, String> konfigurasiSekarang = konfigurasi;
            String nilai1 = konfigurasiSekarang.get("nilai-1");
            String nilai2 = konfigurasiSekarang.get("nilai-2");
            String nilai3 = konfigurasiSekarang.get("nilai-3");

            if (!(nilai1.equals(nilai2) && nilai2.equals(nilai3))){
                throw new IllegalStateException("nilai tidak sesuai");
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static void bacaKonfig(){
        Map<String, String> konfigBaru = new HashMap<String, String>(); //atomic operation
        Date now = new Date();
        konfigBaru.put("key-1", sdf.format(now));
        konfigBaru.put("key-2", sdf.format(now));
        konfigBaru.put("key-3", sdf.format(now));
        konfigurasi = konfigBaru; //atomic operation
    }


    public static void main(String[] args) throws InterruptedException {
        bacaKonfig();
        Thread configThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    bacaKonfig();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "configuration-thread");

        configThread.start();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new AtomicAccess_6(), "thread-" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        configThread.join();
        System.out.println("[" + Thread.currentThread().getName() + "] All threads have finished.");
    }
}
