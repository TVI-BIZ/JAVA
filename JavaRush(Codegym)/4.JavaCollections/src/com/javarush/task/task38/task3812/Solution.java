package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if(c.getAnnotations()[0].equals("PrepareMyTest")){
            System.out.println();
        }

        return true;
    }

    public static boolean printValues(Class c) {

        return true;
    }
}
