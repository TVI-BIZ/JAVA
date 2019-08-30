package com.javarush.task.task12.task1205;

/* 
Определимся с животным
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
        String obj = "";
        if (o instanceof Cow){
            obj = "Корова";
        } else if (o instanceof Dog){
            obj =  "Собака";
        } else if (o instanceof Whale){
            obj = "Кит";
        } else if (o instanceof Pig){
            obj = "Неизвестное животное";
        }

        return obj;
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
