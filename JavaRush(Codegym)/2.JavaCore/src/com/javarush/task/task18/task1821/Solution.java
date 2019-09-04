package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution  {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        Map<Character,Integer> resList = new HashMap<>();

        while (inputStreamReader.ready()){
            int data = inputStreamReader.read();
            if(resList.containsKey((char)data)){
                 //resList.put((char)data,resList.get((char)data)+1);
                resList.put((char)data,2);
            } else {
                resList.put((char)data,1);
            }

            for (Map.Entry<Character,Integer> elem: resList.entrySet()){
                System.out.println(elem);



            }

        }


    }
}
