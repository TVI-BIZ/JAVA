package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {

        FileReader fileReader = new FileReader(args[0]);
        String strArr = "";

        while (fileReader.ready()){
           int data = fileReader.read();
            strArr += (char)data;
        }

        String[] strArr2 = strArr.split("\n");
        Map<String,Double> salMap = new HashMap<>();
        for(String elem: strArr2){
            String[] tempS = elem.split(" ");

            if(salMap.size() == 0){
                salMap.put(tempS[0],Double.parseDouble(tempS[1]));
            } else {
                if(salMap.containsKey(tempS[0])){
                    salMap.put(tempS[0],(salMap.get(tempS[0])+Double.parseDouble(tempS[1])));
                } else {
                    salMap.put(tempS[0],Double.parseDouble(tempS[1]));
                }
            }
        }
        for(Map.Entry<String,Double> elem: salMap.entrySet()){
            String getKey = elem.getKey();
            Double getValue = elem.getValue();
        }
        ArrayList <String> sortedKey = new ArrayList<>(salMap.keySet());
        Collections.sort(sortedKey);

        for(String elem: sortedKey){
            System.out.println(elem + " " + salMap.get(elem));
        }

        fileReader.close();

    }
}
