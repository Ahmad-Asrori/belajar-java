package com.asrori;

public abstract class Burung extends Binatang implements ITerbang{
    public Burung(String namaBinatang) {
        super(namaBinatang);
    }

    //implemen method abstract class
    @Override
    public void makan() {
        System.out.println(getNamaBinatang() + " makan dengan cara mematuk");
    }

    @Override
    public void bernafas() {
        System.out.println(getNamaBinatang() + " bernafas dengan paru paru");
    }

    //implemen interface
    @Override
    public void terbang() {
        System.out.println(getNamaBinatang() + " terbang dengan mngepakkan kedua sayapnya");
    }
}
