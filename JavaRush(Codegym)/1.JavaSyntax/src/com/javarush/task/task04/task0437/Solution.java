package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 1; i < 11; i ++){
            String num = "";

            int count = 0;
            while (i > count) {
                System.out.print(8);
                count ++;
            }
            System.out.println(num);
        }

    }
}
