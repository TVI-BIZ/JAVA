package com.javarush.task.task08.task0803;

import java.util.HashMap;
import java.util.Map;

/* 
Коллекция Map из котов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        Map<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static Map<String, Cat> addCatsToMap(String[] cats) {
        //напишите тут ваш код
        Map<String,Cat> map = new HashMap<String, Cat>();

        for(int i=0; i < cats.length; i++){
            map.put(cats[i],new Cat(cats[i]));
        }
        return map;



//        Cat васька = new Cat("васька");
//        Cat мурка = new Cat("мурка");
//        Cat дымка = new Cat("дымка");
//        Cat рыжик = new Cat("рыжик");
//        Cat серый = new Cat("серый");
//        Cat снежок = new Cat("снежок");
//        Cat босс = new Cat("босс");
//        Cat борис = new Cat("борис");
//        Cat визя = new Cat("визя");
//        Cat гарфи = new Cat("гарфи");
//
//
//        map.put("васька",васька);
//        map.put("мурка",мурка);
//        map.put("дымка",дымка);
//        map.put("рыжик",рыжик);
//        map.put("серый",серый);
//        map.put("снежок",снежок);
//        map.put("босс",босс);
//        map.put("борис",борис);
//        map.put("визя",визя);
//        map.put("гарфи",гарфи);




    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
