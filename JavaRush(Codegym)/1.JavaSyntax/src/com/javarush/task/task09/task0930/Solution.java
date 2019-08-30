package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        //System.out.println("print in main");
        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
//        Arrays.sort(array);
        ArrayList<String> arrS1 = new ArrayList<>(); // str
        ArrayList<Integer> arrS2 = new ArrayList<>(); // num
        ArrayList<String> ressSarr = new ArrayList<>(); // res

        int intElem;
//        String[] arr1 = new String[array.length/2]; //str
//        String[] arr2 = new String[array.length/2]; //num
//        String[] resarr = new String[array.length];

        for(String elem: array){
            if(isNumber(elem)){
                arrS2.add(Integer.parseInt(elem));
            } else if (!isNumber(elem)){
                arrS1.add(elem);
            }
        }

        Collections.sort(arrS2,Collections.reverseOrder());
//        for(Integer elem: arrS2){
//            System.out.println(elem);
//        }

        //System.out.println("*****");
        Collections.sort(arrS1);

//        for(String elem: arrS1){
//            System.out.println(elem);
//        }
        int k1 = 0; //arr1
        int k2 = 0; //arr2

        //String[] resArr = new String[arrS1.size()+arrS2.size()];

//        for(int k=0; k < array.length; k++){
//            if(k==0){
//                array[k] = arrS1.get(0);
//            } else if(k%2 !=0){
//                array[k] = String.valueOf(arrS2.get(k1));
//                k1++;
//            } else if(k%2 == 0){
//                array[k] = String.valueOf(arrS1.get(k2));
//                k2++;
//            }
//        }
        isGreaterThan("df", "fd");

        for(int k=0; k < array.length; k++){
            if (isNumber(array[k])){
                array[k] = String.valueOf(arrS2.get(k2));
                k2++;
            } else {
                array[k] = arrS1.get(k1);
                k1++;
            }
        }



//        for(int k=0; k < resarr.length; k++){
//            if(k==0){
//                resarr[0] = arr1[0];
//                //k1++;
//                System.out.println("k1 - 0" + k1);
//            } else if(k%2 == 0){
//                resarr[k] = arr2[k2];
//                k2++;
//                System.out.println("k2" + k2);
//            } else {
//                resarr[k] = arr1[k1];
//                k1++;
//                System.out.println("k1" + k1);
//            }
//        }

//        for(String elem: resarr){
//            System.out.println(elem);
//        }

        //array = resarr;

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
