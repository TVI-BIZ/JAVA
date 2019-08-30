package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int c1 = 0;
        int sum = 0;
//        boolean flag = false;

        while (true){
            c1 = Integer.parseInt(reader.readLine());
            if (c1 != -1){
                sum += c1;
            } else if (c1 == -1){
                sum += -1;
                System.out.println(sum);
                break;
            }

        }





    }
}
