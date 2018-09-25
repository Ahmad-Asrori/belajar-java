package com.asrori;

public class Main {

    public static void main(String[] args) {
	    Anjing anjing = new Anjing("fred");
	    anjing.bernafas();
	    anjing.makan();

	    BurungKakakTua burungKakakTua = new BurungKakakTua("goffy");
	    burungKakakTua.makan();
	    burungKakakTua.bernafas();
	    burungKakakTua.terbang();

	    Pinguin pinguin = new Pinguin("nox");
	    pinguin.terbang();
    }
}
