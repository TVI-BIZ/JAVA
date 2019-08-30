package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
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

        int a = Integer.parseInt(c1);
        int b = Integer.parseInt(c2);
        int c = Integer.parseInt(c3);

        int min = 0;
        int mid = 0;
        int max = 0;

        if (a >= b && a >= c){
            max = a;
        } else if (b >= a && b >= c) {
            max = b;
        } else if (c >= a && c >= b) {
            max = c;
        }

        if (a <= b && a <= c){
            min = a;
        } else if (b <= a && b <= c) {
            min = b;
        } else if (c <= a && c <= b) {
            min = c;
        }

        if ((max == a && min == b) || (max == b && min == a) ){
            mid = c;
        } else if ((max == a && min == c) || (max == c && min == a) ) {
            mid = b;
        }  else if ((max == b && min == c) || (max == c && min == b) ) {
            mid = a;
        }

        System.out.println(max + " " + mid + " " + min);

    }
}
