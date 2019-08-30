package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Слова в обратном порядке
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

        list.remove(2);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(list.size() - 1 - i));
        }


    }
}
