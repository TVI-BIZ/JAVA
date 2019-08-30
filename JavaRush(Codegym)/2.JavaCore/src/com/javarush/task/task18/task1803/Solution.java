package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);
        int count = 0;
        Map<Integer,Integer> bytemap = new HashMap<>();
        ArrayList<Integer> tempArr = new ArrayList<>();


        while (inputStream.available()>0){
            int data = inputStream.read();
            tempArr.add(data);

        }
        inputStream.close();

        for(Integer elem: tempArr){
            int cnt = 0;
            for (Integer elem2: tempArr){
                if (elem == elem2){
                    cnt ++;
                }
            }
            bytemap.put(elem,cnt);
        }

        int maxValue = (Collections.max(bytemap.values()));
        //System.out.println("Result!");
        for (Map.Entry<Integer,Integer> elem: bytemap.entrySet()){
            if(elem.getValue() == maxValue){
                System.out.print(elem.getKey()+ " ");
            }
        }


    }
}
