package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] array = new int[2];
            int elem = array[5];

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String a = null;
            System.out.println(a.charAt(2));
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String a = "That";
            System.out.println(a.charAt(25));
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            File newFile = new File("E://tec");
            FileReader fr = new FileReader(newFile);
            System.out.println(newFile);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
           int newI = Integer.parseInt("yhhh");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            final String CLASS_TO_LOAD = "main.java.Utils";
            Class loadedClass = Class.forName(CLASS_TO_LOAD);
        } catch (Exception e){
            exceptions.add(e);
        }

        try{
            Thread t = new Thread();
            t.setPriority(1000);
        } catch (Exception e){
            exceptions.add(e);
        }
        try {
            Thread t = new Thread();
            t.start();
            t.start();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
          String s = new String("Online tutorials point");
        Object o = (Object) s;
        System.out.println("o : " + o);

        Object o1 = new Object();
        String s1 = (String) o1;
        System.out.println("s1 : " + s1);

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
