package com.asrori;

public class Pinguin extends Burung {
    public Pinguin(String namaBinatang) {
        super(namaBinatang);
    }

    @Override
    public void terbang() {
        super.terbang();
        System.out.println("pinguin tidak bisa terbang, tetapi dia jago berenang");
    }
}
