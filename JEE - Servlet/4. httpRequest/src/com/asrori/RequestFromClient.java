package com.asrori;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

/*
    ketika sebuah browser meminta request untuk sebuah web page, browser tersebut
    mengirimkan banyak informasi kepada web server yang tidak bisa dibaca secara
    langsung karena informasi ini dikirimkan sebagai sebuah bagian dari HTTP request
    kita dapat mengecek HTTP PROTOCOL untuk mendapatkan informasi ini

    informasi header yang penting
    ACCEPT : header ini menspesifikasikan tipe MIME yang browser lain atau vlient
    lain dapat tangani. biasanya 2 nilai yang sering muncul adalah IMAGE/PNG dan
    IMAGE/JPEG

    ACCEPT-CHARSET : header ini menspesifikasikan set karakter yang browser dapat
    gunakan untuk menampilkan informasi contohnya ISO-8859-1

    ACCEPT-ENCODING : header ini menspesifikasikan tipe encoding yang browser bisa tahu
    cara menghandlenya. nilai yang biasa muncul adalah GZIP dan COMPRESS

    ACCEPt-LANGUAGE : header ini menspesifikasikan bahasa yang digunakan client.
    dalam header ini servlet dapat mengeluarkan hasil lebih dari satu misalnya
    en, en-us, ru dan lain lain

    AUTHORIZATION : header ini digunakan oleh client untuk mengidentifikasi mereka sendiri
    ketika mengakses halaman web yang diproteksi oleh password

    CONNECTION : Header ini menunjukkan apakah client dapat menangani koneksi HTTP yang stabil
    Koneksi yang stabil memungkinkan client atau browser lain untuk mengambil banyak file dengan satu request.
    Nilai Keep-Alive berarti bahwa koneksi yang stabil harus digunakan

    CONTENT-LENGTH : header ini hanya dapat digunakan untuk POST request dan header ini
    memberikan ukuran data dari POST data dalam ukuran bytes.

    COOKIE : header ini mengembalikan cookie ke server yang sebelumnya cookie ini dikirimkan
    ke browser

    HEADER : header ini menspesifikasikan host dan port dari sebuah url

    IF-MODIFIED-SINCE

    IF-UNMODIFIED-SINCE

    REFERRER

    USER-AGENT : header ini mengidentifikasi client yang melakukan request dan dapat mereturn
    konten yang berbeda berdasarkan tipe browsernya

 */

public class RequestFromClient extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("header");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");

        Enumeration<String> namaNamaHeader = req.getHeaderNames();

        while (namaNamaHeader.hasMoreElements()){
            String namaHeader = namaNamaHeader.nextElement();
            System.out.println("nama parameter : " + namaHeader);
            String nilaiHeader = req.getHeader(namaHeader);
            System.out.println("nilai header : " + nilaiHeader);
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
