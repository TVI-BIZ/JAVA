package com.javarush.task.task08.task0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String,String> map = new HashMap<String, String>();
        map.put("Smith","Jim");
        map.put("Brown","Jim");
        map.put("Miller","Jim");
        map.put("Daniels","Jim");
        map.put("Smith1","Pol");
        map.put("Brown1","Mark");
        map.put("Miller1","David");
        map.put("Daniels1","Piter");
        map.put("Jonson","David");
        map.put("Miles","Piter");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int res = 0;
        for(Map.Entry<String, String> pair: map.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();

            if(value.equals(name)){
                res++;
            }
        }
        return res;

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int res = 0;
        for(Map.Entry<String, String> pair: map.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();

            if(key.equals(lastName)){
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
