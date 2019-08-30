package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String c2 = reader.readLine();

        int age = Integer.parseInt(c2);

        if (age < 18){
            System.out.println("Подрасти еще");
        }

    }
}
