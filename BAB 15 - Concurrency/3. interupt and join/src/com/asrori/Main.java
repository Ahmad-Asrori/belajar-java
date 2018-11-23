package com.asrori;

public class Main {

    public static void main(String[] args) {
        System.out.println("dari main thread");

        Thread threadLain = new ThreadLain(); //membuat objek bernama threadLain bertipe ThreadLain
        threadLain.start(); //jalankan threadLain

        //buat anonymous class
        new Thread(){
            public void run(){
                System.out.println("dari anonymous class");
                try {
                    threadLain.join();
                    System.out.println("threadLain dihentikan");
                }catch (InterruptedException e){
                    System.out.println("");
                }
            }
        }.start();

        threadLain.interrupt(); //untuk menghentikan secara paksa (terminate)

        System.out.println("dari main thread lagi");
    }
}
