package com.javarush.task.task09.task0908;

/* 
Исключение при работе со строками
*/

public class Solution {
    public static void main(String[] args){
        //напишите тут ваш код
        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (NullPointerException e){
            String s = e.toString();
            System.out.println(s);
        }



        //напишите тут ваш код
    }
}
