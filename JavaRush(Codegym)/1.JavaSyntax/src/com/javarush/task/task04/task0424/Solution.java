package com.javarush.task.task04.task0424;

/* 
Три числа
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


        if (a == b) {
            System.out.println(3);
        } else  if (b == c){
            System.out.println(1);
        } else if (c == a) {
            System.out.println(2);
        }


        //if (a != b && a !=c){
            //System.out.println(1);
        //} else if (b != c && b !=1) {
          //  System.out.println(2);
        //} else if (c != a && a !=b) {
           // System.out.println(3);
        //}


    }
}
