package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        //int[] hearr = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        int[] hearr = new int[array.length];
        Arrays.parallelSort(array);
        for(int i = 0; i < array.length; i++){
            hearr[i] = array[array.length - 1 - i];
        }

        for(int i = 0; i < array.length; i++){
            array[i] = hearr[i];
        }



    }
}
