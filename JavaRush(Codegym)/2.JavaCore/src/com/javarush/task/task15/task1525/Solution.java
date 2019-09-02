package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution  {
    public static List<String> lines = new ArrayList<String>();

    static  {
        try {
            Statics stat = new Statics();
            FileReader fileReader = new FileReader(stat.FILE_NAME);
            String bigLine = "";
            String[] tempStr;

            while (fileReader.ready()){
                int line = fileReader.read();
                bigLine += (char)line;
            }
            tempStr = bigLine.split("\n");

            for(String elem: tempStr){
                lines.add(elem);
            }
        } catch (Exception e){

        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
