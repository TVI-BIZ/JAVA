package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    public  static  ArrayList<Cat> cats = new ArrayList<Cat>();

    public Cat() {
    }



    public static void main(String[] args) {
        //напишите тут ваш код
        int count = 0;

         while(count < 10){
             cats.add(new Cat());
             count++;
         }





        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
//        int count = 0;
//        while(count < cats.size()){
//            System.out.println(cats);
//        }

        for(Cat item: cats){
            System.out.println(item);
        }
    }
}
