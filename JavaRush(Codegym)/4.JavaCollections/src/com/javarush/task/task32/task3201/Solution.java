package com.javarush.task.task32.task3201;

import java.io.*;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        String text=args[2];

        RandomAccessFile raf = new RandomAccessFile(args[0],"rw");


        if(Long.parseLong(args[1])>raf.length()){
            raf.seek(raf.length());
            raf.write(args[2].getBytes());
            raf.close();
        } else {
            raf.seek(Integer.parseInt(args[1]));
            raf.write(args[2].getBytes());
            raf.close();
        }



    }
}
