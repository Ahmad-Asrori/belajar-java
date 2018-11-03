package com.asrori;

import java.util.Scanner;

public class CallStack {
    public static void main(String[] args) {
        dibagi();

        /*
            jika kita menjalankan fungsi diatas maka akan kemungkinan akan terjadi error
            error 1 : divided by zero
            error 2 : input mismatch
            error 3 : no such element

            jika kita memasukkan nilai y = 0 maka akan terjadi error 1
            Exception in thread "main" java.lang.ArithmeticException: / by zero
	        at com.asrori.CallStack.dibagi(CallStack.java:37)
	        at com.asrori.CallStack.main(CallStack.java:7)

            jika kita memasukkan huruf kedalam variabel x maka akan terjadi error 2
            Exception in thread "main" java.util.InputMismatchException
	        at java.util.Scanner.throwFor(Scanner.java:864)
	        at java.util.Scanner.next(Scanner.java:1485)
	        at java.util.Scanner.nextInt(Scanner.java:2117)
	        at java.util.Scanner.nextInt(Scanner.java:2076)
	        at com.asrori.CallStack.getInt(CallStack.java:21)
	        at com.asrori.CallStack.dibagi(CallStack.java:11)
	        at com.asrori.CallStack.main(CallStack.java:7)

            jika kita menhentikan (termate) secara paksa saat memasukkan inputan maka otomatis scanner tidak berisi nilai apapun
            dan akan terjadi error 3
            Exception in thread "main" java.util.NoSuchElementException
	        at java.util.Scanner.throwFor(Scanner.java:862)
	        at java.util.Scanner.next(Scanner.java:1485)
	        at java.util.Scanner.nextInt(Scanner.java:2117)
	        at java.util.Scanner.nextInt(Scanner.java:2076)
	        at com.asrori.CallStack.getInt(CallStack.java:47)
	        at com.asrori.CallStack.dibagi(CallStack.java:37)
	        at com.asrori.CallStack.main(CallStack.java:7)

            setiap kali program mengalami kondisi error java secara otomatis menampilkan stack trace untuk
            menunjukkan callstack, callstack adalah daftar semua method, dimana method dijalankan setelah method yang lain selesai
            dijalankan.
	        cara membaca error yang disarankan adalah dimulai dari bawah
         */

    }

    private static int dibagi(){
        int x = getInt();
        int y = getInt();

        System.out.println("nilai x : " + x + "nilai y : " + y);
        return x / y;
    }

    private static int getInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("masukkan angka : ");
        return scanner.nextInt();
    }
}
