package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        //System.out.println(a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        //return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        //return (a && b && c && !d);
        return c;

    }

    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        boolean c = true;
        boolean d = true;

        System.out.println(calculate(a,b,c,d));
    }
}
