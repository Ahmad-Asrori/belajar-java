package com.asrori;

public abstract class Binatang {
    private String namaBinatang;

    public Binatang(String namaBinatang) {
        this.namaBinatang = namaBinatang;
    }

    public String getNamaBinatang() {
        return namaBinatang;
    }

    public abstract void makan();
    public abstract void bernafas();
}
