package com.asrori;

import java.util.HashMap;
import java.util.Map;

public class Lokasi {
    private final int idLokasi;
    private final String keterangan;
    private final Map<String, Integer> keluar;

    public Lokasi(int idLokasi, String keterangan) {
        this.idLokasi = idLokasi;
        this.keterangan = keterangan;
        this.keluar = new HashMap<>();
    }

    public void tambahKeluar(String arah, int lokasi){
        keluar.put(arah, lokasi);
    }

    public int getIdLokasi() {
        return idLokasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    /*
        teknik ini sebenarnya hanya mengcopy data dari dalam kelas, tujuannya agar data dialam kelas tidak bisa diubah
     */
    public Map<String, Integer> getKeluar() {
        return new HashMap<>(keluar);
    }


}
