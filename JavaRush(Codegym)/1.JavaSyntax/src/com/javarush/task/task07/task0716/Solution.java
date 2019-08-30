package com.javarush.task.task07.task0716;

import java.io.IOException;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        ArrayList<String> strings2 = new ArrayList<>();
        for(String elem : strings){
            if(elem.contains("р") && elem.contains("л")){
                System.out.println("Contain!");
               // break;
                strings2.add(elem);
            } else if (elem.contains("р")){
                //strings.remove(elem);
                System.out.println("PPP");
            } else if (elem.contains("л")){
                strings2.add(elem);
                strings2.add(elem);
                System.out.println("LLL");
            } else if (!elem.contains("л")){
                strings2.add(elem);
            } else if (!elem.contains("р")){
                strings2.add(elem);
            }
        }

        return strings2;
    }
}