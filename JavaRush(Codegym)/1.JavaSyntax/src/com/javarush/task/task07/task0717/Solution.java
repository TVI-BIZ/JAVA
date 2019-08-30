package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (count < 10)
        {
            list.add(reader.readLine());
            count++;
        }

        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        for (int i =0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> newList = new ArrayList<String>();
        for (int i=0; i < list.size(); i++){
            newList.add(list.get(i));
            newList.add(list.get(i));
        }

        return newList;
    }
}
