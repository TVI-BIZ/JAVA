package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);

        FileOutputStream fileOutputStream1 = new FileOutputStream(file1,true);


        while (fileInputStream2.available()>0){
            int data = fileInputStream2.read();
            fileOutputStream1.write(data);
        }


        while (fileInputStream3.available()>0){
            int count = fileInputStream3.read();
            fileOutputStream1.write(count);
        }

        fileInputStream2.close();
        fileInputStream3.close();
        fileOutputStream1.close();

    }
}
