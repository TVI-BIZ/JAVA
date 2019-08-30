package com.javarush.task.task09.task0909;

/* 
Исключение при работе с массивами
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch(ArrayIndexOutOfBoundsException e){
            String s = e.toString();
            System.out.println(s);
        }



        //напишите тут ваш код
    }
}
