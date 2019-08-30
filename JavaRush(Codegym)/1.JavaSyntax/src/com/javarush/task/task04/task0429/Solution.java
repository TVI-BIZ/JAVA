package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);

        int counterPositive = 0;
        int counterNegative = 0;

        if (i1 > 0){
            counterPositive += 1;
        } else if (i1 < 0) {
            counterNegative += 1;
        }

        if (i2 > 0){
            counterPositive += 1;
        } else if (i2 < 0) {
            counterNegative += 1;
        }

        if (i3 > 0){
            counterPositive += 1;
        } else if (i3 < 0) {
            counterNegative += 1;
        }



        System.out.println("количество отрицательных чисел: " + counterNegative);
        System.out.println("количество положительных чисел: " + counterPositive);

    }
}
