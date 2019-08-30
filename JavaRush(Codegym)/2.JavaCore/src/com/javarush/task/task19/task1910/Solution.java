package com.javarush.task.task19.task1910;

/* 
Пунктуация
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

        String bigLine = "";
        while (bufferedReader.ready()){
            //int data = bufferedReader.read();
            String line = bufferedReader.readLine();
            bigLine += line;
        }
        bigLine = bigLine.replaceAll("\\p{P}+", "");
        bufferedWriter.write(bigLine);

        bufferedReader.close();
        bufferedWriter.close();
    }
}
