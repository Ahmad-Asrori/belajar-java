package com.asrori.intro;

/*
    telah kita lihat sebelumnya,
    urutan yang tepat di mana semua alur berjalan dieksekusi bergantung pada konfigurasi thread seperti prioritas juga pada resource
    CPU yang tersedia dan cara penjadwal memilih thread berikutnya untuk dieksekusi. Meskipun SCHEDULER sepenuhnya dapat memastikan

    sulit untuk memprediksi thread mana yang dieksekusi pada saat mana pada suatu waktu tertentu.
    Ini membuat akses ke shared resource menjadi penting karena sulit untuk memprediksi thread mana yang akan menjadi thread pertama yang mencoba untuk mengaksesnya.
    Dan seringkali akses ke shared resource bersifat eksklusif, yang berarti hanya satu thread pada waktu tertentu yang harus mengakses resource ini
    tanpa ada thread lain yang mengganggu akses ini.
 */

class CounterTidakSinkron implements Runnable{
    private static int counter = 0;

    @Override
    public void run() {
        while (counter < 10){
            System.out.println("[" + Thread.currentThread().getName() + "]" + "sebelum : " + counter);
            counter++;
            System.out.println("[" + Thread.currentThread().getName() + "]" + "sesudah : " + counter);
        }
    }
}

class CounterSinkron implements Runnable{
    private static Integer counter = 0;

    @Override
    public void run() {
        while (counter < 10){
            synchronized (counter){
                System.out.println("[" + Thread.currentThread().getName() + "]" + "sebelum : " + counter);
                counter++;
                System.out.println("[" + Thread.currentThread().getName() + "]" + "sesudah : " + counter);

            }
        }
    }
}

class CounterSinkronCaraLain implements Runnable{
    private static Integer counter = 0;

    @Override
    public synchronized void run() {
        while (counter < 10){
            System.out.println("[" + Thread.currentThread().getName() + "]" + "sebelum : " + counter);
            counter++;
            System.out.println("[" + Thread.currentThread().getName() + "]" + "sesudah : " + counter);
        }
    }
}



public class Synchronization_5 {

    public static void main(String[] args) throws InterruptedException{
//        Thread[] threadSaya = new Thread[5];
//
//        for (int i=0; i<threadSaya.length; i++){
//            threadSaya[i] = new Thread(new CounterTidakSinkron(), "thread-"+ i);
//            threadSaya[i].start();
//        }
//
//        for (int j=0; j<threadSaya.length; j++){
//            threadSaya[j].join();
//        }

        /*
            jika dijalankan maka akan keluar output seperti berikut

            [thread-0]sebelum : 0
            [thread-0]sesudah : 1
            [thread-0]sebelum : 1
            [thread-0]sesudah : 2
            [thread-0]sebelum : 2
            [thread-0]sesudah : 3
            [thread-0]sebelum : 3
            [thread-0]sesudah : 4
            [thread-0]sebelum : 4
            [thread-0]sesudah : 5
            [thread-3]sebelum : 4
            [thread-1]sebelum : 3
            [thread-3]sesudah : 6
            [thread-1]sesudah : 7
            [thread-1]sebelum : 7
            [thread-1]sesudah : 8
            [thread-1]sebelum : 8
            [thread-1]sesudah : 9
            [thread-1]sebelum : 9
            [thread-1]sesudah : 10
            [thread-4]sebelum : 5
            [thread-4]sesudah : 11
            [thread-0]sebelum : 5
            [thread-2]sebelum : 5
            [thread-2]sesudah : 12
            [thread-0]sesudah : 13
            [thread-3]sebelum : 7
            [thread-3]sesudah : 14

            terlihat bahwa hasilnya diluar prediksi, jika kita menjalankan lagi maka hasilnya akan berbeda dari sebelumnya
         */

//        Thread[] threadSayaSinkron = new Thread[5];
//
//        for (int i=0; i<threadSayaSinkron.length; i++){
//            threadSayaSinkron[i] = new Thread(new CounterSinkron(), "thread-"+ i);
//            threadSayaSinkron[i].start();
//        }
//
//        for (int j=0; j<threadSayaSinkron.length; j++){
//            threadSayaSinkron[j].join();
//        }

        /*
            jika dijalankan akan keluar hasil seperti ini

            [thread-0]sebelum : 0
            [thread-0]sesudah : 1
            [thread-0]sebelum : 1
            [thread-0]sesudah : 2
            [thread-0]sebelum : 2
            [thread-0]sesudah : 3
            [thread-0]sebelum : 3
            [thread-0]sesudah : 4
            [thread-0]sebelum : 4
            [thread-0]sesudah : 5
            [thread-0]sebelum : 5
            [thread-0]sesudah : 6
            [thread-0]sebelum : 6
            [thread-0]sesudah : 7
            [thread-0]sebelum : 7
            [thread-0]sesudah : 8
            [thread-0]sebelum : 8
            [thread-0]sesudah : 9
            [thread-0]sebelum : 9
            [thread-0]sesudah : 10

            Pernyataan synchronized berfungsi seperti penghalang di mana semua thread harus berhenti dan meminta masuk.
            Hanya thread pertama yang mengunci resource yang diizinkan untuk masuk.
            Setelah meninggalkan blok tersinkronisasi, thread yang menunggu tadi bisa masuk dan begitu seterusnya.
         */

        Thread[] threadSayaSinkronCaraLain = new Thread[5];

        for (int i=0; i<threadSayaSinkronCaraLain.length; i++){
            threadSayaSinkronCaraLain[i] = new Thread(new CounterSinkronCaraLain(), "thread-"+ i);
            threadSayaSinkronCaraLain[i].start();
        }

        for (int j=0; j<threadSayaSinkronCaraLain.length; j++){
            threadSayaSinkronCaraLain[j].join();
        }

        /*
            cara lain adalah dengan meletakkan keyword synchronized kedalam deklarasi method. hasilnya sama saja ketika menggunakan keyword
            synchronized di dalam body method
            perbedaan dengan cara synchronized yang pertama adalah kita bisa menghemat baris kode danperlu diingat bahwa blok synchronized
            dieksekusi hanya satu kali dalam satu waktu. oleh karena itu blok synchronized berpotensi mendapatkan masalah dalam performance.
            semua thread yang berjalan secara bersamaan harus menunggu thread yang sedang mengeksekusi blok synchronized sampai selesai.
            oleh karena itu kita harus mencoba menggunakan blok synchronized sesedikit mungkin.
         */
    }
}
