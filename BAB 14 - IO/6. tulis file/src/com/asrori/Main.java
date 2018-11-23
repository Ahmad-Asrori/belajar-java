package com.asrori;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	    //1. writer ke file tujuan
        String namaFile = "/home/asrori/belajarJava/BAB 14 - IO/6. tulis file/src/com/asrori/output.txt";
        FileWriter output = new FileWriter(namaFile);

        //2.tangkap input dari command line ke buffered reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("masukkan data, ketik exit unruk keluar");
        String data;
        while ((data = reader.readLine()) != null){
            if ("exit".equalsIgnoreCase(data)) break;
            output.write(data);
            output.write("\r\n");
            output.flush();
        }

        reader.close();
    }
}
