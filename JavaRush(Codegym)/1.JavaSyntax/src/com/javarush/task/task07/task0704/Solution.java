package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] array = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int mi;

        for (int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }

        //System.out.println(array);
        for (int i = 0; i < array.length; i++){
            mi = 9 - i;
            System.out.println(array[mi]);
        }
    }
}

