package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);

        int counter = 0;

        if (i1 > 0){
            counter += 1;
        }
        if (i2 > 0) {
            counter += 1;
        }
        if (i3 > 0) {
            counter += 1;
        }

        System.out.println(counter);

    }
}
