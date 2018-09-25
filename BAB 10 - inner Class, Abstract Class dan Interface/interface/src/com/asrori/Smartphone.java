package com.asrori;

public class Smartphone implements ITelepon{
    private int nomorTeleponSaya;
    private boolean berdering;
    private boolean menyala = false;

    public Smartphone(int nomorTeleponSaya) {
        this.nomorTeleponSaya = nomorTeleponSaya;
    }

    @Override
    public void menekanTombolPower() {
        this.menyala = true;
        System.out.println("smartphone menyala");
    }

    @Override
    public void menelepon(int nomorTelepon) {
        if (menyala){
            System.out.println("menelepon " + nomorTelepon + " di smartphone");
        } else {
            System.out.println("smartphone masih belum menyala");
        }
    }

    @Override
    public void menjawabPanggilan() {
        if (berdering){
            System.out.println("menjawab panggilan di smartphone");
            this.berdering = false;
        }
    }

    @Override
    public boolean panggilanTelepon(int nomorTelepon) {
        if (nomorTelepon == nomorTeleponSaya && menyala){
            berdering = true;
            System.out.println("ring ring");
        } else {
            berdering = false;
            System.out.println("smartphone tidak menyala atau nomor telepon berbeda");
        }

        return berdering;
    }

    @Override
    public boolean teleponBerdering() {
        return this.berdering;
    }
}
