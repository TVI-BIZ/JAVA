package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c1 = reader.readLine();
        //System.out.println(c1);

        int n = Integer.parseInt(c1);
        if (n > 0){
            System.out.println(n*2);
        }

        else if (n < 0){
            System.out.println(n + 1);
        }
        else {
            System.out.println(0);
        }
    }

}