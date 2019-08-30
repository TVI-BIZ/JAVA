package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        //напишите тут ваш код
        int c = 0;
        while (c < 5){
            //System.out.print(s);
            result += s;
            c += 1;
        }

        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        //напишите тут ваш код
        int c = 0;
        while (c < count){
            //System.out.print(s);
            result += s;
            c += 1;
        }

        return result;
    }

    public static void main(String[] args) {
//        multiply("hey!");
//        multiply("Bingo!",3);
    }
}
