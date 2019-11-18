package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;
    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        long res = 0;
        if(n==0){
            res = 1;
        } else if (n<0){
            res = 0;
        }


        return res;
    }
}

