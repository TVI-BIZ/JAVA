package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        while (count < 5){
            list.add(reader.readLine());
            count++;
        }

        int count2 = 0;
        String last = "";
        while (count2 < 13){
            last = list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0,last);
            count2++;
        }

        for(int i=0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
