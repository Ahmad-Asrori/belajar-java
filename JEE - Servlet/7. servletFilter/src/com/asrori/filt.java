package com.asrori;

/*
    Servlet Filter adalah sebuah kelas java yang dapat digunakan didalam servlet
    programming untuk tujuan

    - untuk menangkap rewuest dari client sebelum mereka mengakses resource di
    backend
    - untuk memanipulasi response dari server sebelum server mengirim balik
    resource ke client

    ada beberapa jenis filter

    1. Authentication Filter
    2. Data Compression Filter
    3. Encryption Filter
    4. filter yang dipicu ada kejadian ada objek yang mengakses resource
    5. Image Conversion Filter
    6. Logging dan Auditing Filter
    7. MIME-TYPE Chain FIlter
    8. Tokenizing FIlter
    9. XSL/T Filter yang merubah konten XML

    filter dideploy didalam descriptor file web.xml dan kemudian di petakan
    ke nama servlet atau url pattern

    ketika web container menjalankan web aplikasi. web container ini akan
    membuat instance dari setiap filter yang telah dideklarasikan di deployment descriptor
    filter mengeksekusi secara berurutan seperti yang dideklarasikan di deployment
    descriptor
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class filt implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //mendapatkan inisialisasi parameter
        String tesParameter = filterConfig.getInitParameter("tes-parameter");
        System.out.println("test param : " + tesParameter);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //mendapatkan IP address dari client
        String ipAddress = servletRequest.getRemoteAddr();
        System.out.println("IP " + ipAddress + ", waktu " + new Date().toString());
        // melewatkan request kembali ke filter chain
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
