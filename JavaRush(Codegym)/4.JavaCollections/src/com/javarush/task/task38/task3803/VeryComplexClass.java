package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.ArrayList;
import java.util.Arrays;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        String[] strArray = new String[]{"Piter","Elsid"};
        ArrayList<String> arrayList = (ArrayList<String>)Arrays.asList(strArray);
        System.out.println(arrayList);
    }

    public void methodThrowsNullPointerException() {
        String resString = null;
        System.out.println(resString.toString());
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.methodThrowsClassCastException();
        veryComplexClass.methodThrowsNullPointerException();
    }
}
