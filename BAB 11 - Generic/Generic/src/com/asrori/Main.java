package com.asrori;

public class Main {

    public static void main(String[] args) {
	    PemainSepakbola david = new PemainSepakbola("david");
	    PemainSepakbola salah = new PemainSepakbola("salah");
	    PemainSepakbola martin = new PemainSepakbola("martin");

	    PemainSepakbola robert = new PemainSepakbola("robert");
	    PemainSepakbola rooney = new PemainSepakbola("rooney");
	    PemainSepakbola ronaldo = new PemainSepakbola("ronaldo");

	    Tim<PemainSepakbola> liverpool = new Tim<>("liverpool");
        liverpool.tambahPemain(david);
        liverpool.tambahPemain(salah);
        liverpool.tambahPemain(martin);

        Tim<PemainSepakbola> madrid = new Tim<>("real madrid");
        madrid.tambahPemain(robert);
        madrid.tambahPemain(rooney);
        madrid.tambahPemain(martin);

        liverpool.hasilPertandingan(madrid, 3, 1);
        liverpool.hasilPertandingan(madrid, 3, 1);

        System.out.println(liverpool.compareTo(madrid));
    }
}
