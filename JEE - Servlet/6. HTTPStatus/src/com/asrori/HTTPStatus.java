package com.asrori;

/*
    HTTP Status yang dikembalikan oleh web server

    100 CONTINUE : hanya bagian tertentu yang diterima oleh server,
    sejauh tidak direject oleh server, maka client harus melanjutkan request ke sesrver

    101 SWITCHING PROTOCOLS : server berpindah protocol

    200 OK : request sudah diterima oleh server dengan baik

    201 CREATED : request sudah diterima oleh server dengan baik dan sebuah konten telah
    dibuat untuk dikirimkan ke client

    202 ACCEPTED : request sudah diterima oleh server untuk diproses, tetapi prosesnya
    masih belum selesai

    203 NON AUTHORITATIVE INFORMATION

    204 NO CONTENT

    205 RESET CONTENT

    206 PARTIAL CONTENT

    300 MULTIPLE CHOICE : sebuah daftar link, user dapat memilih link dan menuju ke alamat
    link tersebut, maksimal 5 link

    301 MOVED PERMANENTLY : halaman yang dituju telah berganti url (pindah ke url baru)

    302 FOUND : halaman yang dituju sementara berganti url  (pindah ke url baru, tapi pindahnya sementara)

    303 SEE OTHER : halaman yang dituju juga dapat dilihat di url yang lain

    304 NOT MODIFIED

    305 USE PROXY

    306 UNUSED :

    307 TEMPORARY REDIRECT : halaman yang diminta oleh client telah berpindah sementara ke url baru

    400 BAD REQUEST : server tidak mengerti request dari client

    401 UNAUTHORIZED : halaman yang diminta oleh client membutuhkan sebuah username dan password

    402 PAYMENT REQUiRED  ( jangan gunakan lagi status ini )

    403 FORBIDDEN : server melarang mengakses halaman yang diminta oleh client

    404 NOT FOUND : server tidak dapat menemukan halaman yang diminta oleh client

    405 METHOD NOT ALLOWED : method yang ditentukan oleh client saat request ke server tidak
    diperbolehkan

    406 NOT ACCEPTABLE :

    407 PROXY AUTHENTICATION REQUIRED : client harus melakukan otentifikasi dengan sebuah
    proxy server sebelum request dapat dilayani oleh server

    408 REQUEST TIMEOUT : request dari client terlalu lama, server sudah lama menunggu

    409 CONFLICT : request tidak dapat diselesaikan dengan baik karena ada kendala

    410 GONE : halaman yang diminta oleh client sudah tidak ada lagi

    411 CONTENT LENGTH : "CONTENT LENGTH" tidak ditentukan. server tidak akan melayani
    request jika "CONTENT LENGTH" tidak ditentukan

    412 PRECONDITION FAILED : prasyarat yang dibutuhkan saat request ke server tidak dipenuhi

    413 REQUEST ENTITY TOO LARGE : server tidak menerima request dari client karena request entitynya
    terlalu besar

    414 REQUEST URL TOO LONG : server tidak dapat menerima request karena URL terlalu panjang.
    ini terjadi ketika mengubah "POST" request ke "GET" request untuk mengquery informasi

    415 UNSUPPORTED MEDIA TYPE : server tidak akan menerima request karena tipe media tidak disupport

    417 EXPECTATION FAILED

    500 INTERNaL SERVER ERROR : request dari client tidak selesai, server menemui kondisi
    yang tidak diinginkan

    501 NOT IMPLEMENTED :  request dari client tidak selesai, server tidak mendukung apa yang
    diinginkan oleh client

    502 BAD GATEWAY : request dari client tidak selesai, server menerima sebuah response yang tidak
    valid dari server induk

    503 SEFVICE UNAVAILABLE : request dari client tidak selesai, server overloading atau down
    sementara

    504 GATEWAY TIMEOUT

    505 HTTP Version Not Supported : server tidak mendukung versi protokol HTTP


    ======================================
                    method
    HTTP status method bisa digunakan pada
    objek HTTPServletResponse
    ======================================
    public void setStatus(int status code)
    public void sendRedirect(String url)
    public void sendError(int code, String message)
 */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HTTPStatus extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(407, "Butuh Otentifikasi!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
