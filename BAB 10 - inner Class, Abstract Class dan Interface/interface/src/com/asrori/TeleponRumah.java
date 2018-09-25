package com.asrori;

public class TeleponRumah implements ITelepon{
    private int nomorTeleponSaya;
    private boolean berdering = true;

    public TeleponRumah(int nomorTeleponSaya) {
        this.nomorTeleponSaya = nomorTeleponSaya;
    }

    @Override
    public void menekanTombolPower() {
        System.out.println("tidak perlu menekan tombol power karena telepon rumah tidak mempunyai tombol power");
    }

    @Override
    public void menelepon(int nomorTelepon) {
        System.out.println("memanggil " + nomorTelepon + " dari telepon rumah");
    }

    @Override
    public void menjawabPanggilan() {
        if (berdering){
            System.out.println("menjawab panggilan dari telepon rumah");
            berdering = false;
        }
    }

    @Override
    public boolean panggilanTelepon(int nomorTelepon) {
        if (nomorTelepon == nomorTeleponSaya){
            berdering = true;
            System.out.println("ring-ring");
        } else {
            berdering = false;
        }

        return berdering;
    }

    @Override
    public boolean teleponBerdering() {
        return this.berdering;
    }
}
