package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<Integer> listTotal = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(fileName);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream));


        while (reader2.ready()){
            String data = reader2.readLine();
            listTotal.add(Integer.parseInt(data));
        }
        ArrayList<Integer> listEven = new ArrayList<>();
        for(Integer elem: listTotal){
            if(elem % 2 == 0){
                listEven.add(elem);
            }
        }

        Collections.sort(listEven);
        for(Integer elem: listEven){
            System.out.println(elem);
        }

        reader2.close();
    }
}
