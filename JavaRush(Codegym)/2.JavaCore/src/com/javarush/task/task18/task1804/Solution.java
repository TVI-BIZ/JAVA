package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> tempArr = new ArrayList<>();
        Map<Integer,Integer> byteMap = new HashMap<>();



        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            tempArr.add(data);
        }
        fileInputStream.close();

        for(Integer elem: tempArr){
            int cnt = 0;
            for (Integer elem2: tempArr){
                if (elem == elem2){
                    cnt ++;
                }
            }
            byteMap.put(elem,cnt);
        }
        int minVal = (Collections.min(byteMap.values()));
        for(Map.Entry<Integer,Integer> elem: byteMap.entrySet()){
            if(elem.getValue() == minVal){
                System.out.print(elem.getKey() + " ");
            }
        }


    }
}
