package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text=args[2];

        RandomAccessFile rf = new RandomAccessFile(fileName,"rw");
        rf.seek(number);
        //System.out.println(rf.readLine());


        byte[] byteA = new byte[text.length()];
        rf.read(byteA,0,text.getBytes().length);
        String res = new String(byteA);


        if (res.equals(text)){
            rf.seek(rf.length());
            rf.write("true".getBytes());
        } else {
            rf.seek(rf.length());
            rf.write("false".getBytes());
        }
        rf.close();
    }
}
