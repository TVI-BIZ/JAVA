package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;

        while (fileInputStream.available()>0){
            int data = fileInputStream.read();
            //65-90 - big
            //97-122
            if(((data>=65)&(data<=90)) | ((data>=97)&(data<=122))){
                count++;
            }

        }
        fileInputStream.close();
        System.out.println(count);

    }
}
