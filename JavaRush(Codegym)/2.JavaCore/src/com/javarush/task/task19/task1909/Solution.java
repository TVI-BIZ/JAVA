package com.javarush.task.task19.task1909;

/* 
Замена знаков
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

        while (bufferedReader.ready()){
            int data = bufferedReader.read();
            if (data == 46){
                data = 33;
                bufferedWriter.write((char)data);
            } else{
                bufferedWriter.write(data);
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
