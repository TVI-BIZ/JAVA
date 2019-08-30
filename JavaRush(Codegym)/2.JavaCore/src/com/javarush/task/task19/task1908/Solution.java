package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));

        String biline = "";

        while (bufferedReader.ready()){
            //int data = bufferedReader.read();
            String line = bufferedReader.readLine();
            biline += line;

        }
        //System.out.println(biline);
        String[] strArr = biline.split( " ");
        for(String elem: strArr){
            if(!elem.matches("[0-9]+")){
            } else {
               bufferedWriter.write(elem + " ");
            }

        }

        bufferedReader.close();
        bufferedWriter.close();

    }
}
