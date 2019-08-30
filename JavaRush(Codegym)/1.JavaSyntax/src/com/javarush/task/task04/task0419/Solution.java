package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c1 = reader.readLine();
        String c2 = reader.readLine();
        String c3 = reader.readLine();
        String c4 = reader.readLine();

        int a = Integer.parseInt(c1);
        int b = Integer.parseInt(c2);
        int c = Integer.parseInt(c3);
        int d = Integer.parseInt(c4);

        int res = 0;

        if (a >= b && a >= c && a >= d) {
            System.out.println(a);
        } else if (b >= c && b >= a && b >= d) {
            System.out.println(b);
        } else if ( c >= a && c >= b && c >= d){
            System.out.println(c);
        } else if ( d >= a && d >= b && d >= c){
            System.out.println(d);
        }
    }
}
