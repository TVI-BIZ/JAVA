package com.javarush.task.task08.task0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;

        while (count<20){
            set.add(count);
            count++;
        }
        return set;
    }


    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();

        while(iterator.hasNext()){
            Integer num = iterator.next();
            if (num > 10){
                iterator.remove();
            }
        }
        return set;
    }

    public static void main(String[] args) {
        removeAllNumbersGreaterThan10(createSet());
    }
}
