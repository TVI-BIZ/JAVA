package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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

           if ((a==c)&&(b==c)&&(a==c)){
               System.out.println(a+" "+b+" "+c);
        } else if (a==b){
            System.out.println(a+" "+b);
        } else if (b==c){
            System.out.println(b+" "+c);
        } else if (a==c){
               System.out.println(a+" "+c);
           }



    }
}