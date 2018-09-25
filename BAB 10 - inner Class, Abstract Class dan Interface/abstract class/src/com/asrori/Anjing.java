package com.asrori;

public class Anjing extends Binatang{
    public Anjing(String namaBinatang) {
        super(namaBinatang);
    }

    @Override
    public void makan() {
        System.out.println(getNamaBinatang() + " makan daging");
    }

    @Override
    public void bernafas() {
        System.out.println(getNamaBinatang() + " bernafas dengan paru paru");
    }
}
