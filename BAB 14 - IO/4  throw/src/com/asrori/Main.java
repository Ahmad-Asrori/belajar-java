package com.asrori;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //kasus 1
//        int x = 63;
//        int y = 0;
//        System.out.println(dibagiDenganNolLBYL(x, y));
//        System.out.println(dibagiDenganNolEAFP(x, y));

        //kasus 2
        int x = getInt();
        System.out.println("nilai x : " + x);
    }

    //LBYL kasus 1
    /*
        method ini bertujuan untuk membagi bilangan x dengan y
        tetapi error handlingnya secara manual, kita semua tahu bahwa jika ada bilangan yang dibagi dengan 0
        maka hasilnya tidak terdefinisi
     */
    private static int dibagiDenganNolLBYL(int x, int y){
        if (y != 0){
            return x / y;
        } else {
            return 0;
        }
    }

    //EAFP kasus 1
    /*
        method ini bertujuan untuk membagi bilangan x dengan y
        tetapi mekanisme error handlingnya sudah diserahkan ke exception
        disini method berusaha untuk mebagi bilangan x dengan y lalu mereturn hasilnya,
        jika terjadi error bertipe Aritmetic maka return 0
     */
    private static int dibagiDenganNolEAFP(int x, int y){
        try {
            return x / y;
        } catch (ArithmeticException e){
            return 0;
        }
    }

    private static int getInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    //LBTL kasus 2
    /*
        didalam method ini pengguna diminta untuk memasukkan angka, lalu akan dicek apakah inputan yang dimasukkan
        oleh pengguna sudah benar benar berupa angka atau tidak, jika iya maka return hasilnya, jika tidak return angka 0
     */
    private static int getIntLBYL(){
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("masukkan angka : ");
        String input = scanner.next();
        for (int i=0; i<input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }

        if (isValid){
            return Integer.parseInt(input);
        }

        return 0;
    }

    //EAFP kasus 2
    /*
        didalam method ini pengguna diminta untuk memasukkan angka, jika terjadi kondisi error bertipe InputMismatchException
        maka return nilai 0, jika tidak return inputan pengguna
     */
    private static int getIntEAFP(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("masukkan angka : ");

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            return 0;
        }
    }
}
