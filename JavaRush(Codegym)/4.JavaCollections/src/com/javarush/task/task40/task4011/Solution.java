package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
        //decodeURLString("https");
    }

    public static void decodeURLString(String s) throws MalformedURLException {
        URL newUrl = null;
        try {
            newUrl = new URL(s);
            System.out.println(newUrl.getProtocol());
            System.out.println(newUrl.getAuthority());
            System.out.println(newUrl.getFile());
            System.out.println(newUrl.getHost());
            System.out.println(newUrl.getPath());
            System.out.println(newUrl.getPort());
            System.out.println(newUrl.getDefaultPort());
            System.out.println(newUrl.getQuery());
            System.out.println(newUrl.getRef());
        } catch (MalformedURLException e) {
            System.out.println("Parameter "+s+" is not a valid URL.");
            //e.printStackTrace();
        }



    }
}

