package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        ArrayList<String> list = new ArrayList<>();

        int cnt = 0;
        while (cnt < N){
            list.add(reader.readLine());
            cnt++;
        }

        int cnt2 = 0;
        String elem1;
        while (cnt2 < M){
            elem1 = list.get(0);
            list.add(elem1);
            list.remove(0);
            cnt2++;
        }

        int cnt3 = 0;
        while (cnt3 < list.size()){
            System.out.println(list.get(cnt3));
            cnt3++;
        }

    }
}
