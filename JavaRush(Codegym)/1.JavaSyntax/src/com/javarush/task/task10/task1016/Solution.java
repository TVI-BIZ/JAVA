package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        ArrayList<String> nonDupList = new ArrayList<>();

        //int occurrences = Collections.frequency(animals, "bat");
        for(String elem: list){
            if(!nonDupList.contains(elem)){
                nonDupList.add(elem);
            }
        }


        for(String elem: nonDupList){
            int occurences = Collections.frequency(list,elem);
            result.put(elem,occurences);
        }



//        for(Map.Entry<String,Integer> elem: result.entrySet()){
//            String key = elem.getKey();
//            Integer value = elem.getValue();
//        }


        //напишите тут ваш код


        return result;
    }

}

