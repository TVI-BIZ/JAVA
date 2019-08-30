package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        ArrayList<Integer> num = new ArrayList<Integer>();

        while(count < 5){
            Solution.strings.add(reader.readLine());
            count++;
        }
        int maxCount = strings.get(0).length();

        for (int i = 0; i < strings.size(); i++){
            if (strings.get(i).length() > maxCount){
                maxCount = strings.get(i).length();
            }
        }
        for (int i = 0; i < strings.size(); i++){
            if (strings.get(i).length() == maxCount){
                num.add(i);
            }
        }
        if(num.size() == 1) {
            System.out.println(strings.get(num.get(0)));
        } else {
            for (int i = 0; i < num.size(); i++){
                System.out.println(strings.get(num.get(i)));
            }

        }





    }
}
