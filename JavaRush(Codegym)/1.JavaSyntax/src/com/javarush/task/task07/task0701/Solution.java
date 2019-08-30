package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        int arrayLength = 20;
        int[] array = new int[20];
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        for (int i=0; i < array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }

//        System.out.println(array.length);
//        System.out.println("Array");
//        for (int i=0; i < array.length; i++){
//            System.out.println(array[i]);
//        }

        return array;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int maxEl = array[0];

        for(int j = 1; j < array.length; j++){
            if (array[j] > maxEl){
                maxEl = array[j];
            }
        }

        return maxEl;
    }
}
