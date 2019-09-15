package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream));

        int arg = Integer.parseInt(args[0]);
        while (reader1.ready()){
            String line = reader1.readLine();
            String[] tempS = line.split(" ");

            if(Integer.parseInt(tempS[0]) == arg){
                System.out.println(line);
            }
        }
        reader1.close();



    }
}
