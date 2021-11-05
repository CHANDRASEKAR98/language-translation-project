package com.translate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Translation {

    public static void main(String[] args) throws IOException {
        String text = "\\Chandrasekar\\Welcome India!";
        String[] arrStr = text.split("\\\\");
        String test = Arrays.toString(arrStr);
        byte[] bytes = test.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        // Input String
        System.out.println("Your Input text = "+test);
        //Translated text: Hallo Welt!
        System.out.println("Translated text: " + translates("en", "ja", utf8EncodedString));
    }

    private static String translates(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbxFjaHrg3KqtS85RgS4UEe2tdIpxyXKl86nl79j5MsSSUiW5ocvSCP7mLxgB91_aESK9w/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}

