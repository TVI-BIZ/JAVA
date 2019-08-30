package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {




        List<Integer> integerList = getIntegerList();


        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут
        int res = array.get(0);
        for (int i=0; i < array.size(); i++){
            if (res > array.get(i)){
                res = array.get(i);
            }
        }

        return res;
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int entN = Integer.parseInt(reader.readLine());
        int cn = 0;
        while (cn < entN){
            list.add(Integer.parseInt(reader.readLine()));
            cn++;
        }

        return list;
    }
}
