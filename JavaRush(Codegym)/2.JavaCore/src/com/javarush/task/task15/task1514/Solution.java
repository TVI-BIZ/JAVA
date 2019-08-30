package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }

    static {
        labels.put(5.0,"A");
        labels.put(1.1,"B");
        labels.put(2.2,"C");
        labels.put(5.5,"D");
        labels.put(3.2,"F");

    }
}
