package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;



/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
//          for (int i =0; i < array.length;i++){
//              System.out.println(array[array.length-1-i]);
//          }

    }

    public static void sort(int[] array) {
        //напишите тут ваш код
//        ArrayList<Integer> list = new ArrayList<>();
        int[] newArray = array.clone();
        Arrays.sort(array);
        //ArrayUtils.reverse(array);




//        newArray = array;
//
        int cn = 0;
        while(cn < array.length){
            newArray[cn] = array[array.length-cn-1];
            cn++;
        }
        //int[] newArray2 = newArray.clone();

//        int[] g = {1, 2, 3};
//        int[] h = new int[g.length];
        System.arraycopy(newArray, 0, array, 0, array.length);


        //array = newArray2.clone();

//        int cn2 = 0;
//        while(cn2 < array.length){
//            array[cn2] = 0;
//            cn2++;
//        }


//
//        array = newArray;
//
//        for (int x : newArray) {
//            System.out.println(x);
//        }
//        System.out.println("*");
    }
}
