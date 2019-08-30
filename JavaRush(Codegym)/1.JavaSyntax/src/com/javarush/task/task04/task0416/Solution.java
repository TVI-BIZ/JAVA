package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double time = Double.parseDouble(reader.readLine());

        double cicleDel = time % 5.0;


        if (cicleDel >= 0 && cicleDel < 3.0){
            System.out.println("зелёный");
        } else if (cicleDel >= 3.0 && cicleDel < 4.0){
            System.out.println("жёлтый");
        } else if (cicleDel >= 4.0 && cicleDel < 5.0){
            System.out.println("красный");
        }

    }
}