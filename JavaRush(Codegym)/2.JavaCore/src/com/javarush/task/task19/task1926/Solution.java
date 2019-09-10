package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName1);
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream));

        while (reader1.ready()){
            String line = reader1.readLine();
            char[] tempChar = new char[line.length()];
            tempChar = line.toCharArray();
            char[] resChar = new char[tempChar.length];
            for(int i = 0; i < resChar.length; i++){
                resChar[i] = tempChar[tempChar.length - i-1];
            }
            String resStr = "";
            for(char elem: resChar){
                resStr += elem;
            }
            System.out.println(resStr);
        }
        reader1.close();
        fileInputStream.close();
        fileReader.close();

    }
}
