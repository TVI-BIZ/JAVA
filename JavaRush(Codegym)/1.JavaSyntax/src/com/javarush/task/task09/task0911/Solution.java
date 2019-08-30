package com.javarush.task.task09.task0911;

import java.util.HashMap;

/* 
Исключение при работе с коллекциями Map
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        } catch (NullPointerException n){
            //String s = n.toString();
            //n instanceof
            if(n instanceof NullPointerException){
                NullPointerException exeptionN= n;
                // Now invoke all required methods on sqlException
                System.out.println(n.getClass().getSimpleName());
            }


        }




        //напишите тут ваш код
    }
}
