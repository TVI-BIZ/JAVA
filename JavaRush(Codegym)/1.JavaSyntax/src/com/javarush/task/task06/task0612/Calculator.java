package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код

        return a+b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a-b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a*b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double b1 = b;

        return a/b1;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double a1 = a;
        double b1 = b;
        return (a1/100)*b1;
    }

    public static void main(String[] args) {
        System.out.println(division(5,2));
        System.out.println(percent(100,67));
    }
}