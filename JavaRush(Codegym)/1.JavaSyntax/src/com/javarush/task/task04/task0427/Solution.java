package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c1 = reader.readLine();
        int n1 = Integer.parseInt(c1);
        int even_odd = n1 % 2;
        int symbols_count = c1.length();

        if (n1 >= 1 && n1 <= 999) {
            if (symbols_count == 1  && even_odd == 0){
                System.out.println("четное однозначное число" );
            } else if (symbols_count == 1  && even_odd > 0){
                System.out.println("нечетное однозначное число");
            } else if (symbols_count == 2  && even_odd == 0){
                System.out.println("четное двузначное число");
            } else if (symbols_count == 2 && even_odd > 0){
                System.out.println("нечетное двузначное число");
            } else if (symbols_count == 3  && even_odd == 0){
                System.out.println("четное трехзначное число");
            } else if (symbols_count == 3 && even_odd > 0){
                System.out.println("нечетное трехзначное число");
            }
        }

    }
}
