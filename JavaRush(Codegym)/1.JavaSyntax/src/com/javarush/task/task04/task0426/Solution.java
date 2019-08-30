package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c1 = reader.readLine();

        int a = Integer.parseInt(c1);
        int rest = a % 2;

        if (a > 0 && rest ==0) {
            System.out.println("положительное четное число");
        } else if (a < 0 && rest ==0) {
            System.out.println("отрицательное четное число");
        } else if (a > 0 && rest > 0) {
            System.out.println("положительное нечетное число");
        } else if (a < 0 && rest < 0) {
            System.out.println("отрицательное нечетное число");
        } else if (a == 0) {
            System.out.println("ноль");
        }

    }
}
