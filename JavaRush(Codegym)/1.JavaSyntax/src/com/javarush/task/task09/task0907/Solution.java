package com.javarush.task.task09.task0907;

/* 
Исключение при работе с числами
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            int a = 42 / 0;
        } catch (Exception e) {
            String s = e.toString();
            System.out.println(s);
        }

        //напишите тут ваш код
    }
}
