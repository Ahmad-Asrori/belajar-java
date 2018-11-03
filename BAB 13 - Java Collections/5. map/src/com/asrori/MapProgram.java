package com.asrori;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> bahasaPemrograman = new HashMap<>();
        bahasaPemrograman.put("java", "object oriented programming");
        bahasaPemrograman.put("python", "tanpa tanda titik koma");
        bahasaPemrograman.put("C++", "bahasa tua");
        bahasaPemrograman.put("javascript", "sedang hype");
        bahasaPemrograman.put("golang", "pembuatnya google");

        if (bahasaPemrograman.containsKey("java")){
            System.out.println("sudah ada dalam list");
        } else {
            bahasaPemrograman.put("java", "james gosling");
        }

        for (String key : bahasaPemrograman.keySet()){
            System.out.println(key + " : " + bahasaPemrograman.get(key));
        }
    }
}
