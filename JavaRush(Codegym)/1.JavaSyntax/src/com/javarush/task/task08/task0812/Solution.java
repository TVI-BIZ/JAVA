package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();

        int cn = 0;
        while (cn < 10){
            list.add(Integer.parseInt(reader.readLine()));
            cn++;
        }
        long count = 1;

        for(int i=0; i < 10; i++){
            if(i+1==9){
                if (count > 1){
                    list2.add(count+1);
                } else {
                    list2.add(count);
                }

            } else if(i+1<10) {
                if (list.get(i).equals(list.get(i+1))) {
                    count++;
                } else {
                    list2.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(list2);
        System.out.println(list2.get(list2.size()-1));

//        for(Integer elem: list2){
//            System.out.println(elem);
//        }

    }
}