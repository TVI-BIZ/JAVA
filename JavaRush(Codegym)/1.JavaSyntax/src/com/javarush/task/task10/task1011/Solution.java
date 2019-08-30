package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        List<Character> chars = new ArrayList<>();
        char[] arr = s.toCharArray();
        String resString = "Я не хочу изучать Java, я хочу большую зарплату";
        StringBuilder sb = new StringBuilder();

        int newCount = 0;
        int count = 0;


        while (count < 1) {
            if(newCount>39){
                break;
            }
            System.out.println(resString);
            resString ="";
            for (char elem : arr) {
                chars.add(elem);
            }
            chars.remove(count);
            sb = new StringBuilder();
            for (char elem : chars) {
                sb.append(elem);
            }
            resString = sb.toString();
            arr = resString.toCharArray();
            chars.clear();
            newCount++;
        }
    }

}

