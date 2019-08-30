package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] intAr = new int[20];
        int[] intAr2 = new int[10];
        int[] intAr3 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i < intAr.length; i++){
            intAr[i] = Integer.parseInt(reader.readLine());
            if (i < (intAr.length/2)){
                intAr2[i] = intAr[i];
            } else {
                intAr3[i - 10] = intAr[i];
            }
        }

        for (int i=0; i < intAr3.length; i++) {
            System.out.println(intAr3[i]);
        }

    }
}
