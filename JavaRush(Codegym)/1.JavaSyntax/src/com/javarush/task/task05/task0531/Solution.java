package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int f = Integer.parseInt(reader.readLine());
//        int[] array = new int[5];
//        int count = 0;
//
//        while (count < 5){
//            array[count] = Integer.parseInt(reader.readLine());
//            count++;
//        }



        int minimum = min(a,b,c,d,f);
//
       System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int f) {
        int[] array = new int[5];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        array[3] = d;
        array[4] = f;

        int min = array[0];

        for(int i=0; i < array.length; i++)
        {
            if (array[i] < min){
                min = array[i];
            }
        }

        return min;
    }
}
