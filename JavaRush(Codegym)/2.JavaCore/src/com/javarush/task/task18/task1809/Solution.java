package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

//import com.sun.tools.javac.util.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);
        int size = inputStream.available();

        byte[] buffer = new byte[size];
        byte[] wbuffer = new byte[size];



        while (inputStream.available()>0){
            int counter = inputStream.read(buffer);

            int iter = 1;
            for (byte elem:buffer){
                //System.out.println(elem);
                wbuffer[size-iter] = elem;
                iter ++;
            }
            outputStream.write(wbuffer);
        }
        inputStream.close();
        outputStream.close();
    }
}
