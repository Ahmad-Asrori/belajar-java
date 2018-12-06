package com.asrori;

import java.io.*;
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
        out.println("<li>");
        out.println("membaca : " + req.getParameter("membaca"));
        out.println("</li>");
        out.println("<li>");
        out.println("menulis : " + req.getParameter("menulis"));
        out.println("</li>");
        out.println("<li>");
        out.println("memancing : " + req.getParameter("memancing"));
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
