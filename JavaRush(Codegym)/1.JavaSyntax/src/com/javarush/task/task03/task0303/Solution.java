package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertEurToUsd(20,1.34));
        System.out.println(convertEurToUsd(15,1.12));

    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        double eur1 = eur * course;
        return eur1;

    }
}
