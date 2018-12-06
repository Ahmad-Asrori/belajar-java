package com.asrori;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


/*
    siklus servlet dapat di jelaskan sebagai seluruh proses yang dimulai dari "penciptaan" sampai "penghancuran"
    berikut adalah cara kerja servlet dalam menangani request

    1. servlet diinisialisasi dengan memanggil method init()
    2. servlet memanggil method service() untuk memproses request dari user
    3. servlet di hentikan dengan memanggil method destroy()
    4. terakhir objek servlet di hapus oleh GC dari JVM

 */


public class BelajarServlet extends HttpServlet{

    /*
        method init() hanya dipanggil sekali. mthod init() dipanggil hanya ketika servlet dibuat dan tidak dipanggil
        lagi apabila ada request selanjutnya dari user. jadi method ini hanya dijalankan satu kali saat inisialisasi

        sebuah servlet biasanya dibuat ketika seorang user memanggil sebuah URL. tetapi kita bisa mengatur servlet
        mana yang diload ketika server pertama kali di jalankan

        ketika user memanggil servlet. satu instance dari servlet dibuat, dengan setiap request dari user di tangani
        oleh method doGet atau doPost didalam sebuah thread baru. method init() sederhanaya membuat atau meload data
        yang digunakan sepanjang servlet.
     */

    @Override
    public void init() throws ServletException {

    }

    /*
        method service() adalah method utama untuk melakukan pekerjaan yang sesungguhnya. servlet container (web server)
        memanggil method service() untuk menangani request yang datang dari client (browser) dan menulis format response
        yang ekan dikembalikan ke client

        setiap kali server menerima request untuk sebuah servlet, server membuat thread baru dan memanggil method service()
        method service() kemudian mengecek tipe dari HTTP request (GET, POST, PUT, DELETE) dan memanggil doGet(), doPost(),
        doPut(), doDelete() dst sesuai dengan kebutuhan.

        method service dipanggil oleh servlet container dan service method memanggil method doGet, doPost dst. jadi kita
        tidak perlu melakukan apa apa terhadap method service() ini tetapi kita perlu mengoverride antara method doGet()
        doPost tergantung dari tipe request yang kita terima dari client

        method doGet() dan doPost() adalah method yang paling sering kita gunakan disetiap melayani request dari client
     */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /*
        GET request dihasilkan dari sebuah request dari sebuah URL atau dari sebuah HTML form yang tidak ditentukan
        methodnya dan itu harus ditangani dengan method doGet()
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /*
        POST request dihasilkan dari sebuah request dari sebuah HTML from yang ditentukan POST sebagai methodnya
        dan itu harus di tangani dengan method doPOst()
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /*
        method destroy() dipanggil hanya satu kali saat end of lifecycle servlet. method ini memberikan kita kesempatan
        untuk menutup koneksi dengan database, menghentikan background thread, menulis daftar cookies atau menghitung
        hit ke disk dan melakukan pekerjaan akhir lainnya. setelah method destroy() dipanggil. objek servlet ditandai
        untuk dihapus oleh GC
     */
    @Override
    public void destroy() {

    }
}
