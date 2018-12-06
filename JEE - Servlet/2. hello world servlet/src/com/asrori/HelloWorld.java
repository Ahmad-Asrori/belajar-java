package com.asrori;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
    servlet adalah kelas yang melayani HTTP request dan mengimplenets interface javax.servlet.Servlet.
    developer web secara khusus menulis servlet dengan mengextend java.servlet.HttpServlet, dimana
    HttpServlet adalah sebuah abstract kelas yang mengimplents interface Servlet dan dikhususkan
    untuk menangani HTTP Request
 */

public class HelloWorld extends HttpServlet{

    private String pesan;

    @Override
    public void init() throws ServletException {
        pesan = "hello world";
    }

    /*
        void setContentType(String type) : Menetapkan jenis konten yang dikirim ke klien, jika response belum dilakukan.
        kelas PrintWriter : adalah kelas yang mengextends kelas Writer (java.io), kelas ini digunakan untuk mencetak
        representasi objek kedalam bentuk text
        void println() : digunakan untuk mencetak objek
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + pesan + "</h1>");
    }

    @Override
    public void destroy() {
        //tidak melakukan apa apa
    }
}
