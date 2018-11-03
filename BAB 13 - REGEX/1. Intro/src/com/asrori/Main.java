package com.asrori;

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
        System.out.println(alphanumerikKedua.replaceAll("^abcDeee", "yyyy")); //yang digantin cuma yang pertama

        System.out.println(alphanumerikKedua.matches("^hello")); //false
        System.out.println(alphanumerikKedua.matches("^abcDeee")); //false
        //kenapa kok false ? karena ^abcDeee adalah sebagian kecil dari string
        System.out.println(alphanumeric.matches("abcDeeefg3405")); //true

        System.out.println(alphanumerikKedua.replaceAll("fd90$", "the end"));
        System.out.println(alphanumeric.replaceAll("[aei]", "x")); //setiap huruf a,e,i diganti dengan huruf x
        System.out.println(alphanumeric.replaceAll("[aei][f]", "k")); // setiap huruf a,e,i yang diikuti huruf f diiganti dengan huruf k
    }
}
