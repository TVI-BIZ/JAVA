package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName;
//    reader.close();
    String partNum;
    String finalFileName;
        Map<Byte,String> fileMap = new HashMap<>();


    while (!(fileName=reader.readLine()).equals("end")){
       int index = fileName.lastIndexOf(".");
       finalFileName = fileName.substring(0,index);
       partNum = fileName.substring(index+1).replaceAll("[a-zA-Z]+","");


       BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
       while (reader1.ready()){

       }




    }
        File resFile = new File(fileName);


    }
}
