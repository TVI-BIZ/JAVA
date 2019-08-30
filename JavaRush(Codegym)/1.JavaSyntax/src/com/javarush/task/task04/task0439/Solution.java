package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        //String c1 = reader.readLine();

        //int counter = Integer.parseInt(c1);

        for (int i = 0; i < 10; i++){
            System.out.println(name + " любит меня.");
        }


    }
}
