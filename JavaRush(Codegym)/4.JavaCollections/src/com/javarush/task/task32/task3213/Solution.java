package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String ResStr = "";
        if(reader != null) {
            int num;
            StringBuilder sb = new StringBuilder();

            try {
//                while ((line = br.readLine()) != null) {
//                    res = line;
//                }
//                char[] charAr = res.toCharArray();
//                for (char elem : charAr) {
//                    int decodeEl = (int) elem - 3;
//                    ResStr += (char) decodeEl;
//                }

                while((num = reader.read()) != -1){
                    sb.append((char) (num+key));
                }
                ResStr = sb.toString();
            } catch (NullPointerException e) {
                ResStr = "";
            }

        } else {
            ResStr = "";
        }

        return ResStr;
    }
}
