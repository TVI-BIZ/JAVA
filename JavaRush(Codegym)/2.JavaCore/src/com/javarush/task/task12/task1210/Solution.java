package com.javarush.task.task12.task1210;

/* 
Три метода и максимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int max(int a, int b){
        if (a > b){
            return a;
        } else {
            return b;
        }

        //return a;
    }
    public static long max(long b, long c){
        if (b > c){
            return b;
        } else {
            return c;
        }
    }
    public static double max(double s, double v){
        if (s > v){
            return s;
        } else {
            return v;
        }
    }
}
