package com.asrori;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
    servlet menangani pelewatan data dari form HTML secara otomatis menggunakan method method dibawah
    ini berdasarkan situasi

    getParameter() : untuk mendapatkan nilai dari parameter form HTML (berdasarkan input namenya)
    getParameterValues() : kita bisa menggunakan method ini untuk nilai dari banyak parameter sekaligus
    getParameterNames() : kita bisa menggunakan method ini untuk mendapatkan daftar seluruh parameter
 */

public class GETMethodForm extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "BIODATA";
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println(title);
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
            out.println("<h1>biodata</h1>");
            out.println("<ul>");
                out.println("<li>");
                    out.println("nama depan : " + req.getParameter("nama_depan"));
                out.println("</li>");
                out.println("<li>");
                    out.println("nama belakang : " + req.getParameter("nama_belakang"));
                out.println("</li>");
            out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
