package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();


        FileReader reader1 = new FileReader(file1);
        FileWriter writer2 = new FileWriter(file2);

        Integer flag = 1;

        while (reader1.ready()){
            int data = reader1.read();
            if(flag%2==0){
                writer2.write(data);
            }
            flag++;
        }

        reader1.close();
        writer2.close();

    }
}
