package com.asrori;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String saya = "saya seorang mahasiswa ? ya, saya seorang mahasiswa";
        System.out.println(saya);
        String kamu = saya.replaceAll("saya", "kamu");
        System.out.println(kamu);

        String alphanumeric = "abcDeeefg3405";
        System.out.println(alphanumeric.replaceAll(".", "w"));
        System.out.println(alphanumeric.replaceAll("^abcDeee", "yyyy"));

        String alphanumerikKedua = "abcDeeehdethabcDeeeavgfd90";
        System.out.println(alphanumerikKedua.replaceAll("^abcDeee", "yyyy")); //yang digantin adalah abcDee yang pertama

        System.out.println(alphanumerikKedua.matches("^hello")); //false
        System.out.println(alphanumerikKedua.matches("^abcDeee")); //false
        //kenapa kok false ? karena ^abcDeee adalah sebagian kecil dari string
        System.out.println(alphanumeric.matches("abcDeeefg3405")); //true

        System.out.println(alphanumerikKedua.replaceAll("fd90$", "the end"));
        System.out.println(alphanumeric.replaceAll("[aei]", "x")); //setiap huruf a,e,i diganti dengan huruf x
        System.out.println(alphanumeric.replaceAll("[aei][f]", "k")); // setiap huruf a,e,i yang diikuti huruf f diiganti dengan huruf k

        System.out.println("Harry".replaceAll("[Hh]arry", "Harry")); //menggati huruf h entah itu huruf h nya lowercase atau uppercase

        String stringBaru = "abcDeeeF12ghhijkl199z";
        System.out.println(stringBaru.replaceAll("[^ej]", "O")); //menggati seluruh huruf dengan huruf O, tetapi selain huruf e dan j
        System.out.println(stringBaru.replaceAll("[abcdef345678]", "X")); //replace huruf a sampai f dan 3 sampai 8 dengan huruf X
        System.out.println(stringBaru.replaceAll("[a-f3-8]", "X")); //replace huruf a sampai f dan 3 sampai 8 dengan huruf X (shortcut)
        System.out.println(stringBaru.replaceAll("[a-fA-F3-8]", "X")); //replace huruf (kapital dan tidak) a sampai f dan 3 sampai 8 dengan huruf X
        System.out.println(stringBaru.replaceAll("(?i)[a-f3-8]", "X")); //ignore case sensitive
        System.out.println(stringBaru.replaceAll("[0-9]", "O")); //ganti seluaruh angka dengan huruf O
        System.out.println(stringBaru.replaceAll("\\d", "O")); //ganti seluaruh angka dengan huruf O (shortcut)
        System.out.println(stringBaru.replaceAll("\\D", "O")); //ganti seluaruh huruf yang bukan angka dengan huruf O

        String yangAdaSpasi = "saya harus pergi kesana,\t tunggu disini saja";
        System.out.println(yangAdaSpasi);
        System.out.println(yangAdaSpasi.replaceAll("\\s", "")); //hapus semua spasi dan tab
        System.out.println(yangAdaSpasi.replaceAll("\t", "O")); //ganti tab dengan huruf O
        System.out.println(yangAdaSpasi.replaceAll("\\S", "T")); //ganti karakter yang bukan spasi dengan huruf T

        String iniString = "abcDeeefghijkl1999z";
        System.out.println(iniString.replaceAll("^abcDe{3}", "FFF")); //mengganti huruf abcDe yang dimana huruf e nya diulang sebanyak 3 kali dengan huruf FFF
        System.out.println(iniString.replaceAll("^abcDe+", "FFF")); //ini sama seperti yang diatas namun dia tidak menspesifikasikan jumlah huruf e nya ada berapa
        System.out.println(iniString.replaceAll("^abcDe*", "GGG")); //mengganti huruf abcdDe dengan tidak memerdulikan setelah e ada hufuf e atau tidak
        System.out.println(iniString.replaceAll("^abcDe{2,5}", "PPP")); //mengganti huruf abcDe yang dimana huruf e nya berjumlah 2 sampai 5
        System.out.println(iniString.replaceAll("h+i*j", "SSS")); //mengganti huruf h yang diikuti oleh huruf i dan siikuti oleh minimal satu huruf j


        /*
            kita membuat sebuah text
         */
        StringBuilder htmlText = new StringBuilder("<h1>my heading</h1>");
        htmlText.append("<h2>sub hading</h2>");
        htmlText.append("<p>this is a paragraph about something</p>");
        htmlText.append("<p>this is a another paragraph about something else</p>");
        htmlText.append("<h2>summary</h2>");
        htmlText.append("<p>here is the summary</p>");

        String h2Pattern = ".*<h2>.*"; //kata2 yang ingin di cocokkan, .* berarti setiap kata sebelum dan sesudah h2 dicocokkan
        Pattern pattern = Pattern.compile(h2Pattern); //compile pattern
        Matcher matcher = pattern.matcher(htmlText); //pattern mau dicocokkan kemana (htmltext)
        System.out.println(matcher.matches()); //mencocokkan


    }
}
