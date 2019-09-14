package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter resStr = new StringWriter();
        String str = "";
        String line = "";
        StringBuilder sb = new StringBuilder();
        if(is != null){
            try{
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                while ((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                str = sb.toString();
               resStr.write(str);
            } catch (Exception e){
                resStr.write(" ");
            }
        }else {
            resStr.write(" ");
        }
        return resStr;
    }
}