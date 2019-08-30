package com.javarush.task.task08.task0817;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String,String>();
        map.put("Smith","John");
        map.put("Johnson","James");
        map.put("Williams","John");
        map.put("Brown","Robert");
        map.put("Jones","John");
        map.put("Garcia","Michael");
        map.put("Miller","John");
        map.put("Davis","William");
        map.put("Garci","John");
        map.put("Millover","David");

        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String,String> copy = new HashMap<>(map);
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        Map<String, String> copyMap = new HashMap<>(map);




        for (Map.Entry<String, String> pair : copyMap.entrySet()) {
            String value = pair.getValue();
            if (Collections.frequency(map.values(),value) >1 ){
                removeItemFromMapByValue(map,value);
            }

        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {


    }
}
