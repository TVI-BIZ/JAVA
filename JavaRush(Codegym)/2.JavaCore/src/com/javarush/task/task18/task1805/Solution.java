package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> tempArr = new ArrayList<>();
        ArrayList<Integer> noDupArr = new ArrayList<>();

        Map<Integer,Integer> byteMap = new HashMap<>();

        while (fileInputStream.available()>0){
            int data = fileInputStream.read();
            tempArr.add(data);
        }
        fileInputStream.close();

        for(Integer elem: tempArr){
            if(!noDupArr.contains(elem)){
                noDupArr.add(elem);
            }
        }

        Collections.sort(noDupArr);

        for(Integer elem: noDupArr){
            System.out.print(elem + " ");
        }


    }
}
