package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String,String> map = new HashMap<String,String>();
        map.put("Peter","Parker");
        map.put("Peter","Stark");
        map.put("Peter","Pollok");
        map.put("John","Parker");
        map.put("Molli","Parker");
        map.put("Kotler","Parker");
        map.put("Serj","Parker");
        map.put("Oleg","Parker");
        map.put("Kolper","Parker");
        map.put("Peter","Mossri");


        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
