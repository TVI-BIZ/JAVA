package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dn = reader.readLine();
        int dayNumber = Integer.parseInt(dn);

        if (dayNumber < 1 || dayNumber > 7) {
            System.out.println("такого дня недели не существует");
        } else if (dayNumber == 1){
            System.out.println("понедельник");
        } else if (dayNumber == 2){
            System.out.println("вторник");
        } else if (dayNumber == 3){
            System.out.println("среда");
        } else if (dayNumber == 4){
            System.out.println("четверг");
        } else if (dayNumber == 5){
            System.out.println("пятница");
        } else if (dayNumber == 6){
            System.out.println("суббота");
        } else if (dayNumber == 7){
            System.out.println("воскресенье");
        }

    }
}