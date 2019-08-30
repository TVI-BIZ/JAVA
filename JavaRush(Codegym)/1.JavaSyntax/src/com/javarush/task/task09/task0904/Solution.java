package com.javarush.task.task09.task0904;

/* 
Стек-трейс длиной 10 вызовов
*/

public class Solution {
    public static void main(String[] args) {
        int stackTraceLength = method1().length - method10().length + 1;
        System.out.println(stackTraceLength);
    }

    public static StackTraceElement[] method1() {
        return method2();
    }

    public static StackTraceElement[] method2() {
        //напишите тут ваш код
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements.length);
        return method3();
    }

    public static StackTraceElement[] method3() {
        //напишите тут ваш код
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements.length);
        return method4();
    }

    public static StackTraceElement[] method4() {
        //напишите тут ваш код
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements.length);
        return method5();
    }

    public static StackTraceElement[] method5() {
        //напишите тут ваш код
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements.length);
        return method6();
    }

    public static StackTraceElement[] method6() {
        //напишите тут ваш код
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements.length);
        return method7();
    }

    public static StackTraceElement[] method7() {
        //напишите тут ваш код
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements.length);
        return method8();
    }

    public static StackTraceElement[] method8() {
        //напишите тут ваш код
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements.length);
        return method9();
    }

    public static StackTraceElement[] method9() {
        return method10();
    }

    public static StackTraceElement[] method10() {
        //System.out.println(Thread.currentThread().getStackTrace().length);

        return Thread.currentThread().getStackTrace();
    }
}
