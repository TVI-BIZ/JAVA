package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int c1 = 0;
        int sum = 0;
        double res = 0.0;
        double flag = 0.0;
//        boolean flag = false;

        while (true){
            c1 = Integer.parseInt(reader.readLine());
            if (c1 != -1){
                flag ++;
                sum += c1;
            } else if (c1 == -1){
                res = sum / flag;
                System.out.println(res);
                break;
            }

        }
    }
}

