package com.asrori;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CallStack {
    public static void main(String[] args) {
        try{
            int hasil = dibagi();
            System.out.println(hasil);
        } catch (ArithmeticException | NoSuchElementException e){ //multi catch style (inclusive or)
            System.out.println(e.toString());
        }
    }

    /*
        didalam fungsi ini pengguna diminta untuk menginputkan angka, jika dia menterminate program maka akan muncul
        aritmethic exception, kita tidak bisa menghandle error yang diakibatkan pengguna menekan ctrl+d, maka kita ubah exception
        nosuchelement menjadi aritmethic
        jika pengguna memasukkan nilai y = 0 maka akan muncul aritmethic exception


        multi catch exception style (jika comment dihapus)
     */
    private static int dibagi(){
        int x, y;

//        try{
            x = getInt();
            y = getInt();
            System.out.println("nilai x : " + x + " nilai y : " + y);
            return x / y;
//        }catch (NoSuchElementException e){
//            throw new ArithmeticException("inputan tidak cocok");
//        }catch (ArithmeticException e){
//            throw new ArithmeticException("tidak boleh dibagi dengan 0")
//        }

    }

    //disini
    private static int getInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("masukkan angka : ");
        // pengguna diminta untuk memasukkan angka, jika ia tidak memasukkan angka maka akan terjadi error, error ini
        // dihandle oleh inputmismatch exception, jika terjadi input mismatch maka pengguna diminta menginputkan kembali
        while (true){
            try {
                return scanner.nextInt();
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("mohon masukkan angka : ");
            }
        }
    }
}
