package com.asrori;

public class Main {

    public static void main(String[] args) {
        System.out.println("dari main method");

        Thread runnable = new Thread(new myRunnable(){
            @Override
            public void run() {
                System.out.println("ini dari anonymous runnable");
            }
        });

        runnable.start();
    }
}
