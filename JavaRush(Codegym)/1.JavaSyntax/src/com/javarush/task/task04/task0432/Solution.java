package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();

        String n = reader.readLine();
        int n1 = Integer.parseInt(n);
        int counter = 0;

        while (n1 > counter){
            System.out.println(s1);
            counter ++;
        }

    }
}
