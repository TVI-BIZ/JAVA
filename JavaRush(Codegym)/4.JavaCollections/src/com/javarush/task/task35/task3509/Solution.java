package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {


    public static void main(String[] args) {
    }

    public static <T> ArrayList<T>  newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> newArrayList = new ArrayList<>(Arrays.asList(elements));
        return newArrayList ;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> newSet = new HashSet<>(Arrays.asList(elements));
        return newSet;
    }

    public static <K, V > HashMap<K, V > newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size()!=values.size()){
            throw new IllegalArgumentException();
        }
        HashMap<K,V> newHasMap = new HashMap();
        for(int i=0;i<keys.size();i++){
            newHasMap.put(keys.get(i),values.get(i));
        }

        return newHasMap;

    }
}
