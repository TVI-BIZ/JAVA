package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        while (count < 10){
            list.add(reader.readLine());
            count++;
        }
        int min = list.get(0).length();
        int max = list.get(1).length();

        int count2 = 0;

        while (count2 < 10){
            if(list.get(count2).length() > max ){
                max = list.get(count2).length();
            } else if(list.get(count2).length() < min){
                min = list.get(count2).length();
            }
            count2++;
        }

        int count3 = 0;
        while (count3 < 10){
            if (list.get(count3).length() == min){
                System.out.println(list.get(count3));
                break;
            } else if (list.get(count3).length() == max){
                System.out.println(list.get(count3));
                break;
            }


            count3++;
        }



    }
}
