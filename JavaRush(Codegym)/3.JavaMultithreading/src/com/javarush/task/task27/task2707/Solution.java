package com.javarush.task.task27.task2707;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj2) {
            synchronized (obj1) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();

        synchronized (o1){
            thread1.start();
            solution.someMethodWithSynchronizedBlocks(o1,o2);
            Thread.sleep(500);
            synchronized (o2){
                thread2.start();
                solution.someMethodWithSynchronizedBlocks(o1,o2);
//                thread1.start();
//                thread2.start();
            }
        }

        if(thread2.getState() == thread1.getState()){
            return true;
        } else {
            return false;
        }





//        Object objMax = o1.hashCode() > o2.hashCode() ? o1:o2;
//        Object objMin = o1.hashCode() > o2.hashCode() ? o2:o1;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        solution.someMethodWithSynchronizedBlocks(o1,o2);
//        String str1 = o1.toString();
//        String[] str1arr = str1.split("@");
//        String str2 = o2.toString();
//        String[] str2arr = str2.split("@");
//
//
//        System.out.println(str1arr[1].hashCode());
//        System.out.println(str2arr[1].hashCode());
//
//
//        if(str1arr[1].hashCode()>str2arr[1].hashCode()){
//            return true;
//        } else {
//            return false;
//        }

        //return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));



    }
}
