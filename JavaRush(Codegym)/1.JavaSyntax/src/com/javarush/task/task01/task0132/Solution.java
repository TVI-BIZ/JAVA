package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int sum = 0;
        String[] str1 = Integer.toString(number).split("");

        for(int i=0;i<str1.length;i++){
            //System.out.println(str1[i]);
            sum += Integer.parseInt (str1[i]);
        }




        return  sum;
    }
}