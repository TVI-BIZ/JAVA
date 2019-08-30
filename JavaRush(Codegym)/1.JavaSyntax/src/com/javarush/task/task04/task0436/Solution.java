package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n1 = reader.readLine();
        String n2 = reader.readLine();

        int n = Integer.parseInt(n1);
        int m = Integer.parseInt(n2);


        for (int i = 0; i < n; i ++){
            int count = 0;
            String line = "";

            for (int j = 0; m > j; j++){
                line += 8;
                count ++;
            }
            System.out.println(line);
        }

    }
}
