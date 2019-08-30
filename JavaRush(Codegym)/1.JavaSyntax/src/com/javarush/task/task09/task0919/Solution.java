package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {



        try {
            divideByZero();
        } catch (Exception e){
            //System.out.println(e);
            e.printStackTrace();
            //System.out.println("My array");
//            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//            for(StackTraceElement elem: stackTraceElements){
//                System.out.println(elem);
//            }
        }

    }

    public static void divideByZero(){
////        int a = 5;
       int b = 5;

        try{
            b = 5/0;
        } catch (Exception e){
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            for(StackTraceElement elem: stackTraceElements){
                System.out.println(elem);
            }
        }

    }
}
