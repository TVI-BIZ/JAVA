package com.javarush.task.task18.task1819;

/* 
Объединение файлов
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

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        //FileInputStream fileInputStream2 = new FileInputStream(file2);

        byte[] buffer1 = new byte[fileInputStream1.available()];
        byte[] buffer2 = new byte[fileInputStream1.available()];
//        byte[] bufferRes = new byte[fileInputStream1.available()+fileInputStream2.available()];
//
        int flag = 0;



        while (fileInputStream1.available()>0){
            int count = fileInputStream1.read(buffer1);
//            int data = fileInputStream1.read();
//            buffer1[flag] =(byte) data;
//            flag++;
//            System.out.println(data);
        }
        //System.out.println(buffer1.length + " Length");

        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);

       // FileOutputStream fileOutputStream2 = new FileOutputStream(file1,true);
//
        while (fileInputStream2.available()>0){
            int data = fileInputStream2.read();
            fileOutputStream1.write(data);
        }
        fileOutputStream1.write(buffer1);

        fileOutputStream1.close();

        //FileOutputStream fileOutputStream2 = new FileOutputStream(file1,true);
        //fileOutputStream2.write('\n');
        //fileOutputStream2.write(buffer1);

        fileInputStream1.close();
        fileInputStream2.close();
        //fileOutputStream1.close();
        //fileOutputStream2.close();


    }
}
