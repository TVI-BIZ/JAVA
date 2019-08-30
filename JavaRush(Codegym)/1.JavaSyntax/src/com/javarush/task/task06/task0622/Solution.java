package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ar1 = new int[5];
        int[] ar2 = new int[5];
        int count = 0;


        while (count < 5){
            ar1[count] = Integer.parseInt(reader.readLine());
            count++;
        }

        Arrays.sort(ar1);

        int count1 = 0;
        while (count1 < 5){
            System.out.println(ar1[count1]);
            count1++;
        }


        //System.out.println(ar1);


//        int max = ar1[0];
//        int min = ar1[ar1.length-1];
//        int count1 = 0;
//
//
//
//        count1 = 0;
//        while (count1 < 5) {
//            for (int i = 0; i < ar1.length; i++) {
//                if (ar1[i] > max) {
//                    max = ar1[i];
//                } else if (ar1[i] < min) {
//                    min = ar1[i];
//                }
//            }
//            count1++;
//        }
//        ar2[ar2.length-1] = max;




        //напишите тут ваш код
    }
}
