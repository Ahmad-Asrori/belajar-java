package com.asrori;

public class Main {

    public static void main(String[] args) {
        ITelepon teleponAsrori = new TeleponRumah(23456);
        teleponAsrori.menekanTombolPower();

        teleponAsrori = new Smartphone(212345);
        teleponAsrori.menekanTombolPower();
    }
}
