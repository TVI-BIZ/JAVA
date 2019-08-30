package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        Map<String,Integer> monthCount = new HashMap<>();
        monthCount.put("January",1);
        monthCount.put("February",2);
        monthCount.put("March",3);
        monthCount.put("April",4);
        monthCount.put("May",5);
        monthCount.put("June",6);
        monthCount.put("July",7);
        monthCount.put("August",8);
        monthCount.put("September",9);
        monthCount.put("October",10);
        monthCount.put("November",11);
        monthCount.put("December",12);

        Iterator<Map.Entry<String,Integer>> iterator = monthCount.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String,Integer> pair = iterator.next();
            String key = pair.getKey();
            Integer value = pair.getValue();

            if (month.equals(key)){
                System.out.println(key + " is the " + value + " month");
            }
        }



    }
}
