package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file1);
        String bigStr = "";


        while (fileReader.ready()){
            int data = fileReader.read();
            bigStr += (char)data;
        }
        fileReader.close();
        // Redundant code - Bad code style DRY
//        bigStr = bigStr.replace(" 0 "," "+map.get(0)+" ");
//        bigStr = bigStr.replace(" 1 "," "+map.get(1)+" ");
//        bigStr = bigStr.replace(" 2 "," "+map.get(2)+" ");
//        bigStr = bigStr.replace(" 3 "," "+map.get(3)+" ");
//        bigStr = bigStr.replace(" 4 "," "+map.get(4)+" ");
//        bigStr = bigStr.replace(" 5 "," "+map.get(5)+" ");
//        bigStr = bigStr.replace(" 6 "," "+map.get(6)+" ");
//        bigStr = bigStr.replace(" 7 "," "+map.get(7)+" ");
//        bigStr = bigStr.replace(" 8 "," "+map.get(8)+" ");
//        bigStr = bigStr.replace(" 9 "," "+map.get(9)+" ");
//        bigStr = bigStr.replace(" 10 "," "+map.get(10)+" ");
//        bigStr = bigStr.replace(" 11 "," "+map.get(11)+" ");
//        bigStr = bigStr.replace(" 12 "," "+map.get(12)+" ");

       for(Map.Entry<Integer,String> elem: map.entrySet()){
           bigStr =  bigStr.replaceAll("\\b"+ elem.getKey()+"\\b", elem.getValue());
       }




        System.out.println(bigStr);


    }
}
