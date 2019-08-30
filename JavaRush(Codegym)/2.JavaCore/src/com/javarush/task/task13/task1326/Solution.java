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
        ArrayList<Integer> listTotal = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(fileName);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream));

        //int data;
        //listTotal.add(data);

        while (inputStream.available() > 0){
            int data =  Integer.parseInt(String.valueOf(inputStream.read()));
            int data2 = dataInputStream.read();
            int data3 = reader2.read();
            System.out.println("add data");
            System.out.println(data3);
            listTotal.add(data3);
        }
        inputStream.close();




        ArrayList<Integer> listEven = new ArrayList<>();
        System.out.println("fin_read!");
        for(Integer elem: listTotal){
            System.out.println(elem);
        }

        System.out.println("****");
        for(Integer elem: listTotal){
            if(elem % 2 == 0){
                listEven.add(elem);
            }
        }

        Collections.sort(listEven);
        for(Integer elem: listEven){
            System.out.println(elem);
        }


    }
}
