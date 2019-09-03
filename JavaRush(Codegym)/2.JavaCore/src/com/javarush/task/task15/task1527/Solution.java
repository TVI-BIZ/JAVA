package com.javarush.task.task15.task1527;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        String[] Qstr;
        String[] Qsr2;
        Map<String, String> keyVal = new LinkedHashMap<>();

            String line = fileName;
            line = line.split("\\?")[1];
            Qstr = line.split("&");

            for (String elem : Qstr) {
                Qsr2 = elem.split("=");
                if (Qsr2.length > 1) {
                    keyVal.put(Qsr2[0], Qsr2[1]);
                } else {
                    keyVal.put(Qsr2[0], "");
                }
            }

        reader.close();

        for (Map.Entry<String, String> elem3 : keyVal.entrySet()) {
            String key = elem3.getKey();
            System.out.print(key + " ");
        }

        for (Map.Entry<String, String> elem4 : keyVal.entrySet()) {
            String key = elem4.getKey();
            String val = elem4.getValue();
            if (key.equals("obj")) {
                try {
                    double ob = Double.parseDouble(val);
                    alert(ob);
                } catch (Exception e) {
                    alert(val);
                }
            }
        }
    }

            public static void alert(double value) {
                System.out.println("double: " + value);
            }


            public static void alert(String value) {
                System.out.println("String: " + value);
            }



}
