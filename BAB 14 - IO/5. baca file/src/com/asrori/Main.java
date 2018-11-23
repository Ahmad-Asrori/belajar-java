package com.asrori;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //baca perbaris - non delimiter
        try{
            //1. buat variabel bertipe filereader
            String namaFile = "/home/asrori/belajarJava/BAB 14 - IO/5. baca file/src/com/asrori/mahasiswa.txt";
            FileReader file = new FileReader(namaFile);

            //2. bugkus dengan buffered reader supaya ada method readline
            BufferedReader reader = new BufferedReader(file);

            //3. looping, baca data, tampilkan
            String data = reader.readLine();

            while (data != null){
                System.out.println(data);
                data = reader.readLine();
            }

            //4. tutup file
            reader.close();
        } catch (IOException e){
            System.out.println("file tidak ditemukan");
        }

        //baca perbaris (delimiter dengan koma)
        try{
            //1. buat variabel bertipe filereader
            String namaFile = "/home/asrori/belajarJava/BAB 14 - IO/5. baca file/src/com/asrori/mahasiswa.txt";
            FileReader file = new FileReader(namaFile);

            //2. bugkus dengan buffered reader supaya ada method readline
            BufferedReader reader = new BufferedReader(file);

            //3. looping, baca data, tampilkan
            String data = reader.readLine();
            while (data != null){
                String[] mahasiswa = data.split(",");
                System.out.println("nama : " + mahasiswa[0]);
                System.out.println("jurusan : " + mahasiswa[1]);
                System.out.println("=========================");
                data = reader.readLine();
            }

            //4. tutup file
            reader.close();
        } catch (IOException e){
            System.out.println("file tidak ditemukan");
        }

    }
}
