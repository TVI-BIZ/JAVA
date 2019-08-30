package com.javarush.task.task13.task1318;

//import com.sun.tools.classfile.ConstantPool;
//import jdk.nashorn.internal.runtime.ECMAException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String filename = reader.readLine();
            InputStream inputStream = new FileInputStream(filename);

            while (inputStream.available() > 0){
                //inputStream.read();
                System.out.print((char) inputStream.read());
            }

            reader.close();
            inputStream.close();

        } catch (Exception e){
            System.out.println(e);
        }




    }
}