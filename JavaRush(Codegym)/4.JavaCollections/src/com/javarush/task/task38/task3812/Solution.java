package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        for(Annotation elem: c.getAnnotations()){
            System.out.println(elem);
        }
        if(!c.getAnnotations()[0].equals("@PrepareMyTest")){
            System.out.println();
            return false;
        } else {
            return true;
        }
    }

    public static boolean printValues(Class c) {
        for(Annotation elem: c.getAnnotations()){
            System.out.println(elem.getClass().getSimpleName());
        }

        if(!c.getAnnotations()[0].equals("@PrepareMyTest")){
            return false;
        }
        return true;
    }
}
