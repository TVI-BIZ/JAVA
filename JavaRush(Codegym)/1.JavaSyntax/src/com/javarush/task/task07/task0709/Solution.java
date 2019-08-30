package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        ArrayList<String> res = new ArrayList<String>();

        while(count<5){
            list.add(reader.readLine());
            count++;
        }

        int minLen = list.get(0).length(); //length of the min string element.
        //int num = 0;

        for (int i=0; i < list.size(); i++){
            if (list.get(i).length() <= minLen ){
                minLen = list.get(i).length();
                //num = i;
            }
        }
        for (int i=0; i < list.size(); i++){
            if (list.get(i).length()== minLen){
                res.add(list.get(i));
            }
        }

        for (int i=0; i < res.size(); i++){
            System.out.println(res.get(i));
        }

    }
}
