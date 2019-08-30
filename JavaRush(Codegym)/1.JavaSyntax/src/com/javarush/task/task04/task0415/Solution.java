package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c1 = reader.readLine();
        String c2 = reader.readLine();
        String c3 = reader.readLine();

        int a = Integer.parseInt(c1);
        int b = Integer.parseInt(c2);
        int c = Integer.parseInt(c3);

        int sum1 = a+b;
        int sum2 = a+c;
        int sum3 = b+c;

//        System.out.println(sum1);
//        System.out.println(sum2);
//        System.out.println(sum3);



        if (((sum1 > c)||(sum2>b)||(sum3>a)) && (((sum1 > c)&&(sum2>b)&&(sum3>a)))){
                System.out.println("Треугольник существует.");
        } else {
            System.out.println("Треугольник не существует.");
        }
    }
}