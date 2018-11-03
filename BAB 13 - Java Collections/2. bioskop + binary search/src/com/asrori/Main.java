package com.asrori;

public class Main {

    public static void main(String[] args) {
	    Teater teater = new Teater("cinema 21", 11, 15);
//	    teater.listKursi();
	    if (teater.pesamKursi("F01")){
            System.out.println("mohon segera bayar");
        } else {
            System.out.println("maaf, kursi sudah dipesan");
        }
    }
}
