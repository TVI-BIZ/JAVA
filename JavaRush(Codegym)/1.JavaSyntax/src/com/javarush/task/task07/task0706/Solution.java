package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int[] array = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int odd = 0;
        int even = 0;

        while(count < 15){
            array[count] = Integer.parseInt(reader.readLine());
            count++;
        }

        for(int i = 0; i < array.length; i ++){
            if(i == 0 || i % 2 ==0){
                odd += array[i];
            } else if (i % 2 > 0) {
                even += array[i];
            }
        }
        if (odd > even){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else if (odd < even){
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
