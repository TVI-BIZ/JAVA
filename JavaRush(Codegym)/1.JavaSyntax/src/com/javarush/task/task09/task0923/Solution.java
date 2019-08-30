package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String entStr = reader.readLine();

        ArrayList<Character> gl = new ArrayList<>();
        ArrayList<Character> sg = new ArrayList<>();

        char[] ourArr = entStr.toCharArray();
       // List<Character> list = Arrays.asList(vowels);


        for (char elem: ourArr){
            if(isVowel(elem)){
                gl.add(elem);
            } else if (elem == ' ') {

            } else {
                sg.add(elem);
            }

//            for(char elem1: vowels){
//                if (elem1 == elem){
//                    gl.add(elem);
//                } else {
//                    sg.add(elem);
//                }
//            }
        }

        for(char elem3: gl){
            System.out.print(elem3 + " ");
        }
        System.out.println();
        for(char elem4: sg){
            System.out.print(elem4 + " ");
        }


    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}