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
            }
        }.start();

        System.out.println("dari main thread lagi");
    }
}
