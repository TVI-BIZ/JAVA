package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы

    public static int min(int a, int b){
        if (a < b){
            return a;
        } else {
            return b;
        }

        //return a;
    }
    public static long min(long b, long c){
        if (b < c){
            return b;
        } else {
            return c;
        }
    }
    public static double min(double s, double v){
        if (s < v){
            return s;
        } else {
            return v;
        }
    }
}
