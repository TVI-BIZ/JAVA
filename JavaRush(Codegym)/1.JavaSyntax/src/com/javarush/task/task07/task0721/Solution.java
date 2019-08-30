package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arrayI = new int[20];

        int cn = 0;
        while(cn<arrayI.length){
            arrayI[cn] = Integer.parseInt(reader.readLine());
            cn++;
        }

        int maximum = arrayI[0];
        int minimum = arrayI[arrayI.length-1];


//        int cn2 = 0;
//        while (cn2 < arrayI.length){
//            if (arrayI[cn2] > maximum){
//                maximum = arrayI[cn2];
//            } else if (arrayI[cn2] < minimum) {
//                minimum = arrayI[cn2];
//            }
//            cn2++;
//        }

        for(int i = 0; i < arrayI.length; i++){
            if (arrayI[i] > maximum){
                maximum = arrayI[i];
            } else if (arrayI[i] < minimum) {
                minimum = arrayI[i];
            }
        }




        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
