package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(file1);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(fileInputStream));
        LinkedList<Integer> mapI = new LinkedList<>();

        double tempEl;
        while (reader2.ready()){
            String line = reader2.readLine();
            String[] strArr = line.split(" ");
            for(String elem:strArr){

                mapI.add ((int) (Math.round(Double.parseDouble(elem))));
            }
        }
        reader2.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        PrintWriter writer = new PrintWriter(fileOutputStream);

        for(Integer elem:mapI){
            writer.write(String.valueOf(elem) + " ");
        }
        writer.close();



    }
}
