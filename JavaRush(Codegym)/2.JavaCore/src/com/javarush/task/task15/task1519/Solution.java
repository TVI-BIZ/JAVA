package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String strVal = reader.readLine();
            if (!strVal.equals("exit")){
                if (strVal.matches(".*[a-zA-Z]+.*")){
                    print(strVal);
                } else if(strVal.contains(".")){
                    try {
                        print(Double.parseDouble(strVal));
                    } catch (Exception e){
                    }
                } else if ((strVal.chars().allMatch(Character::isDigit)) && ((Integer.parseInt(strVal) > 0) && (Integer.parseInt(strVal) < 128))) {
                    try {
                        print(Short.parseShort(strVal));
                    } catch (Exception e){
                    }
                }else if ((strVal.matches("-?[1-9]\\d*|0")) && ((Integer.parseInt(strVal) <= 0) || (Integer.parseInt(strVal) >= 128))){
                    try {
                        print(Integer.parseInt(strVal));
                    } catch (Exception e){
                    }
                }
            } else  {
                break;
            }
        }
    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
