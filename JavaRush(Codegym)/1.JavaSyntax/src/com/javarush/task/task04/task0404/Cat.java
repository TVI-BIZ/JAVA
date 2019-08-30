package com.javarush.task.task04.task0404;

/* 
Учет котов
*/

public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
        //напишите тут ваш код
        Cat.catsCount = Cat.catsCount + 1;
    }

    public static void main(String[] args) {

    }
}
