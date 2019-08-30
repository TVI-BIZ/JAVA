package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        FileReader fileReader1 = new FileReader(file1);
        //119,111,114,108,100

        String bigStr = "";
        String tempStr;

        int count = 0;
        char midCh;

        while (fileReader1.ready()) {
            int data = fileReader1.read();

            if(((data>64)&(data<91))|((data>96)&(data<123))){
               midCh = (char)data;
               tempStr  = Character.toString(midCh);
               bigStr += tempStr;

            } else {
                data = 32;
                midCh = (char)data;
                tempStr  = Character.toString(midCh);
                bigStr += tempStr;
            }

        }

        String[] words = bigStr.split(" ");
        for(String elem: words){
            if (elem.equals("world")){
                count ++;
            }
        }


        fileReader1.close();
        System.out.println(count);

    }
}
