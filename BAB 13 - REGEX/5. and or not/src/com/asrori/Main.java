package com.asrori;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        /*
            kita membuat sebuah text
         */
        StringBuilder htmlText = new StringBuilder("<h1>my heading</h1>");
        htmlText.append("<h2>sub hading</h2>");
        htmlText.append("<p>this is a paragraph about something</p>");
        htmlText.append("<p>this is a another paragraph about something else</p>");
        htmlText.append("<h2>summary</h2>");
        htmlText.append("<p>here is the summary</p>");

        String h2Pattern = "<h2>"; //kata2 yang ingin di cocokkan, .* berarti setiap kata sebelum dan sesudah h2 dicocokkan
        Pattern pattern = Pattern.compile(h2Pattern); //compile pattern
        Matcher matcher = pattern.matcher(htmlText); //pattern mau dicocokkan kemana (htmltext)
        System.out.println(matcher.matches()); //mencocokkan

        /*
            mencari banyak pattern, dengan diketahui dimana letak index pertama dan terakhir
         */
        matcher.reset(); //matcher harus direset karena sebelumnya sudah dijalankan satu kali
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("ada " + count + " : " + matcher.start() + " sampai " + matcher.end());
        }
        System.out.println();
        /*
            mencari banyak pattern dengan group, yang ditampilkan textnya
         */
        String h2GroupPattern = "(<h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        groupMatcher.reset();
        while (groupMatcher.find()){
            System.out.println("ada " + groupMatcher.group());
        }
        System.out.println();

        /*
            mencari pattern dimana dimulai dengan tag <h2> dan diakhiri dengan </h2>
         */
        //String h2GroupPattern2 = "(<h2>.*?</h2>)"; //greesy quantifier
        String h2GroupPattern2 = "(<h2>.*?</h2>)"; //lazy quantifier
        Pattern groupPattern2 = Pattern.compile(h2GroupPattern2);
        Matcher groupMatcher2 = groupPattern2.matcher(htmlText);
        groupMatcher2.reset();
        while (groupMatcher2.find()){
            System.out.println("ada " + groupMatcher2.group());
        }
        System.out.println();
        /*
            mencari pattern dimana dimulai dengan tag <h2> dan diakhiri dengan </h2> dan ditambah dengan test yang ditengah tengah keduanya
         */
        String h2GroupPattern3 = "(<h2>)(.*?)(</h2>)"; //lazy quantifier
        Pattern groupPattern3 = Pattern.compile(h2GroupPattern3);
        Matcher groupMatcher3 = groupPattern3.matcher(htmlText);
        groupMatcher3.reset();
        while (groupMatcher3.find()){
            System.out.println("ada " + groupMatcher3.group(2));
        }
        System.out.println();

        /*
            catatan :
            group 0 adalah seluruh string
            group 1 adalah <h2>
            group 2 adalah text diantara <h2> dan </h2>
            group 3 adalah </h2>
         */

        System.out.println("harry".replaceAll("[H|h]arry", "Larry")); //or operator
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        //[^abc] artinya semua kalimat akan cocok jika tidak ada huruf a dan b dan c (not)
        String tvTest = "tstvtkt";
        //String tNotReGexp = "t[^v]"; //mencari huruf t yang tidak diikuti selain huruf v
        String tNotReGexp = "t(?!v)"; //mencari huruf t yang tidak diikuti selain huruf v
        Pattern tNotTvPattern = Pattern.compile(tNotReGexp);
        Matcher tNotTvMacher = tNotTvPattern.matcher(tvTest);

        int nount = 0;
        while (tNotTvMacher.find()){
            count++;
            System.out.println("ada " + count + " : " + tNotTvMacher.start() + " sampai " + tNotTvMacher.end());
        }


        /*
            memberikan format data nomor telepon
         */

        String no1 = "1234567890";
        String no2 = "(123) 456-7890";
        String no3 = "123 456-7890";
        String no4 = "(123)456-7890";

         //^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        // artinya kalimat tidak akan cocok jika tidak berformat seperti patternnya
        // ([\\(]{1} artinya ( adalah string literal (simbol unik) dengan kodisi simbol ( harus muncul satu kali
        // [0-9]{3} artinya
        System.out.println(no1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(no2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(no3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(no4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
    }
}
