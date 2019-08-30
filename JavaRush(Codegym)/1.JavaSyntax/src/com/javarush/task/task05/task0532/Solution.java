package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int maximum = ;


        //напишите тут ваш код
        int countInt = Integer.parseInt(reader.readLine());
        int count = 0;
        int[] enterArr = new int[countInt];


        if (countInt > 0){
            //int[] enterArr = new int[countInt];
            while (count < countInt){
                enterArr[count] = Integer.parseInt(reader.readLine());
                count++;
            }
        }

        int maximum = enterArr[0];

        for(int i =0; i < enterArr.length; i++){
            if (enterArr[i] > maximum){
                maximum = enterArr[i];
            }

        }


        System.out.println(maximum);
    }
}
