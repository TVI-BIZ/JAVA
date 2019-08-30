package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
*/

public class Solution {

    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("peter",100);
        map.put("polli",200);
        map.put("molli",300);
        map.put("luppi",400);
        map.put("steven",500);
        map.put("joe",600);
        map.put("josh",700);
        map.put("elvin",800);
        map.put("eshton",900);
        map.put("mary",1000);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        List<String> str = new ArrayList<>();

        while (iterator.hasNext()){
            Map.Entry<String,Integer> pair = iterator.next();
            int value = pair.getValue();
            String key = pair.getKey();
            if (value < 500){
                str.add(key);
                //map.values().remove(key);
                //map.remove(key);
                //map.values().remove(key);
                //System.out.println("less 500!");
            }
        }
        for(String elem: str){
            map.remove(elem);
        }



        //System.out.println(map.size());
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 =  Solution.createMap();
        Solution.removeItemFromMap(map1);
    }
}