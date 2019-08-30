package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c1 = reader.readLine();
        String c2 = reader.readLine();

        int n1 = Integer.parseInt(c1);
        int n2 = Integer.parseInt(c2);

        if (n1 > n2) {
            System.out.println(n2);
        } else if (n1 == n2) {
            System.out.println(n1);
        } else {
            System.out.println(n1);
        }
    }
}