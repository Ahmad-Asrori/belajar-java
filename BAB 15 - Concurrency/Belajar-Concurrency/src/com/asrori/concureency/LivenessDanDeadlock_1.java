package com.asrori.concureency;

/*
    Saat mengembangkan aplikasi yang menggunakan konkurensi untuk mencapai tujuannya,
    kita mungkin menemukan situasi di mana berbagai thread dapat saling memblokir.
    kemudian seluruh aplikasi bekerja lebih lambat dari yang diharapkan,
    kita akan mengatakan bahwa aplikasi tidak selesai dalam hitungan waktu seperti yang diharapkan.
    Pada bagian ini kita akan melihat lebih dekat pada masalah yang dapat membahayakan liveness dari aplikasi meltithreading.

    Istilah deadlock terkenal bagi software developer dan bahkan sebagian besar pengguna komputer biasa menggunakan istilah ini dari waktu ke waktu,
    meskipun tidak selalu digunakan dalam pengertian yang benar. Dituturkan secara tegas artinya bahwa dua (atau lebih) thread masing-masing menunggu di thread lain
    untuk mengakses resource yang telah dikunci, sementara thread itu sendiri telah mengunci sumber daya yang menunggu thread lain:
 */

import java.util.Random;

public class LivenessDanDeadlock_1 implements Runnable {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();
    private final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Thread myThread1 = new Thread(new LivenessDanDeadlock_1(), "thread-1");
        Thread myThread2 = new Thread(new LivenessDanDeadlock_1(), "thread-2");
        myThread1.start();
        myThread2.start();
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            boolean b = random.nextBoolean();

            if (b) {
                System.out.println("[" + Thread.currentThread().getName() + "] mencoba mengunci resource 1.");
                synchronized (resource1) {
                    System.out.println("[" + Thread.currentThread().getName() + "] mengunci resource 1.");
                    System.out.println("[" + Thread.currentThread().getName() + "] mencoba mengunci resource 2.");
                    synchronized (resource2) {
                        System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
                    }
                }
            } else {
                System.out.println("[" + Thread.currentThread().getName() + "] mencoba mengunci resource 2.");
                synchronized (resource2) {
                    System.out.println("[" + Thread.currentThread().getName() + "] mengunci resource 2.");
                    System.out.println("[" + Thread.currentThread().getName() + "] mencoba mengunci resource 1.");
                    synchronized (resource1) {
                        System.out.println("[" + Thread.currentThread().getName() + "] mengunci resource 1.");
                    }
                }
            }
        }
    }

    /*
        Seperti dapat dilihat dari kode di atas, dua thread dimulai dijalankan dan mencoba mengunci dua resource statis.
        Tetapi untuk deadlock kita memerlukan urutan yang berbeda untuk kedua thread, maka kita menggunakan instance Random untuk memilih resource
         apa yang ingin dikunci thread pertama.
        Jika variabel boolean b benar, resource pertama dikunci terlebih dahulu dan threadnya kemudian mencoba untuk mengunci resource kedua.
        Jika b salah, thread mengunci resource kedua terlebih dahulu dan kemudian mencoba untuk mengunci resource pertama.

        secara umum ini yang dibutuhkan untuk memngidentifikasi deadlock (jenis jenis deadlock)

        1. MUTUAL EXCLUSION : ada seuatu resource yang hanya bisa diakses oleh satu thread pada satu waktu
        2. RESOURCE HOLDING : selagi mengunci satu resource, thread juga mencoba mengunci resource lainnya yang ekslusif
        3. NO PREEMTION : tidak ada mekanisme, yang membebaskan(unlock) resource jika satu thread melocc suatu resource dalam suatu periode waktu
        4. CIRCLULAR WAIT : Selama runtime terjadi konstelasi di mana dua (atau lebih) masing-masing thread menunggu di thread lainnya
            untuk membebaskan(unlock) resource yang telah dikunci.

        tetapi kita dapat mengatasi deadlock
        1. MUTUAL EXCLUSION : Ini adalah persyaratan yang seringkali tidak dapat dilonggarkan, karena sumber daya harus digunakan secara eksklusif.
        Tapi ini tidak harus selalu demikian. Ketika menggunakan sistem DBMS, solusi yang memungkinkan daripada menggunakan PESIMISTIC LOCKING pada beberapa baris tabel
        yang harus diperbarui, kita dapat menggunakan teknik yang disebut OPTIMISTIC LOCKING.

        2. RESOURCE HOLDING : Solusi yang mungkin untuk menghindari resource sambil menunggu resource eksklusif lainnya adalah dengan mengunci semua resource yang diperlukan di awal algoritma
        dan membebaskan(UNLOCK) semua resource jika tidak mungkin untuk mengunci semua resource.
        Ini tentu saja tidak selalu mungkin, mungkin resource yang ingin di lock tidak diketahui terlebih dahulu atau itu hanya mengahabiskan resource

        3. Jika lock tidak dapat diperoleh dengan segera, solusi yang mungkin untuk menghindari deadlosk mungkin adalah pengenalan timeout.
        Kelas SDK ReentrantLock misalnya menyediakan kemungkinan untuk menentukan batas waktu untuk mengunci.

        4. Seperti yang telah kita lihat dari contoh kode di atas, deadlosk tidak akan muncul jika urutan permintaan kunci tidak berbeda di antara thread
        Ini dapat dengan mudah dikontrol jika kita dapat memasukkan semua kode penguncian ke dalam satu metode di mana semua thread harus melewati.
     */
}
