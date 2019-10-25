package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        for(StackTraceElement elem:e.getStackTrace()){
            System.out.println(elem.getClassName()+":"+elem.getMethodName());
        }

        System.out.println(e.getClass()+":"+e.getMessage());
    }

    public static void main(String[] args) {
    }
}
