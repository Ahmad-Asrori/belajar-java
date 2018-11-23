package com.asrori;

public class ThreadLain extends Thread {

    /*
        run method adalah method yang pertama kali dijalankan ketika objek yang bertipe ThreadLain dipanggil menggunakan method start
     */
    @Override
    public void run() {
        System.out.println("ini dari thread lain " + currentThread().getName());

        try {
            Thread.sleep(3000); //thread menunggu sampai 3 detik
        }catch (InterruptedException e){
            System.out.println("thread yang lain berjalan");
        }

        System.out.println("3 detik sudah berlalu");
    }
}
