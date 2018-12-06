package com.asrori;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

public class Cekbox extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("cekbox");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<ul>");

        //tampung semua objek
        Enumeration<String> namaNamaParameter = req.getParameterNames();

        //iterasikan setiap objek
        while (namaNamaParameter.hasMoreElements()){
            //simpan nama parameter kedalam string
            String namaParameter = namaNamaParameter.nextElement();
            out.print("<li>"+ namaParameter + " : ");
            //simpan semua nilai dari parameter
            String[] nilaiParameter = req.getParameterValues(namaParameter);

            //jika hanya ada satu data
            if (nilaiParameter.length == 1){
                String nilai = nilaiParameter[0];
                if (nilai.length() == 0){
                    out.print("tidak ada data</li>");
                } else {
                    out.print(nilai + "</li>");
                }
            } else {
                for (String aNilaiParameter : nilaiParameter) {
                    out.print(aNilaiParameter + "</li>");
                }
            }
        }

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
