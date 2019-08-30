package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        List<Integer> list = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            try{
                int enterNum = Integer.parseInt(reader.readLine());
                list.add(enterNum);
            } catch (Exception e){
                //System.out.println(e);
                for(Integer elem: list){
                    System.out.println(elem);
                }
                break;
            }
        }


    }
}
