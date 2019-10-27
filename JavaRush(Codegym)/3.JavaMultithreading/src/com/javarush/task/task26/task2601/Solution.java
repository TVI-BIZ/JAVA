package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] tempArray = new Integer[5];
        tempArray[0] = 13;
        tempArray[1] = 15;
        tempArray[2] = 17;
        tempArray[3] = 8;
        tempArray[4] = 5;
        sort(tempArray);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int medInd = array.length / 2;
        Collections.sort(Arrays.asList(array));
        int medVal = array[medInd];

//        Comparator<Integer> compareMedian = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return medInd - array.length;
//            }
//        };
//        Collections.sort(Arrays.asList(array),compareMedian);
//        for(Integer elem: array){
//            System.out.println(elem);
//        }



        return array;
    }
}
