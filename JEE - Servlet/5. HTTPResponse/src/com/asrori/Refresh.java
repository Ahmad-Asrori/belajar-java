package com.asrori;

/*
    beberapa HTTP response header yang berguna

    ALLOW : header ini menentukan jenis request method apa yang disupport (GET, POST)
    CACHE-CONTROL : header ini menentukan keadaan dimana response dokumen dapat di cache
    dengan aman. biasanya berisi nilai PUBLUC, PRIVATE, NO-CACHE, dan lain lain.
    PUBLIC berarti dokumen dapat di cache, PRIVATE berarti dokumen untuk satu pengguna
    dan hanya dapat disimpan secara pribadi (non shared cache) dan NON-CACHE berarti
    dokumen tidak dapat di cache.
    CONNECTION : header ini memerintahkan kepada browser apakah mempunyai koneksi yang
    stabil atau tidak. biasanya berisi nilai CLOSE atau KEEP-ALIVE. close berarti browser
    tidak menmpunyai koneksi yang stabil. KEEP ALIVE berarti browser mempunyai koneksi yang
    stabil
    CONTENT DISPOSITION : heade ini memperbolehkan kita menanyakan ke browser user apakah
    menyimpan response ke dalam file yang diberi nama didalam HDD
    CONTENT-LENGTH : header ini untuk mengetahui ukuran bytes dari response. hanya bisa
    ditampilkan ketika mempunyai CONNECTION KEEP ALIVE
    EXPIRES : header ini menentukan kapan konten sudah kadahluarsa dan tidak lagi di cache
    REFRESH : header ini menentukan kapan browser harus mereload halaman. kita dapat
    menentukan waktu untuk merefresh dalam hitungan detik
    RETRY-AFTER : header ini dapat digunakan bersama dengan 503 (service unavailable) response
    untuk memberi tahu client kapan dia dapat mengulangi request
    SET-COOKIE : header ini menentukan cookie yang berkaitan dengan sebuah halaman
 */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Refresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setIntHeader("refresh", 5);
        resp.setContentType("text/html");

        //mendapatkan waktu sekarang
        Calendar kalender = new GregorianCalendar();
        String siang_malam;
        int jam = kalender.get(Calendar.HOUR);
        int menit = kalender.get(Calendar.MINUTE);
        int detik = kalender.get(Calendar.SECOND);

        if (kalender.get(Calendar.AM_PM) == 0){
            siang_malam = "Siang";
        } else {
            siang_malam = "Malam";
        }

        String waktuSekarang = jam + ":" + menit + ":" + detik + " " + siang_malam;

        PrintWriter out = resp.getWriter();
        String title = "auto refresh header setting";
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println(title);
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + title + "</h1>");
        out.println("waktu sekarang adalah " + waktuSekarang);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
