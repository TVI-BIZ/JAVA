package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        // Создай 10 котов
        int counter = 0;

        while (counter < 10){
            new Cat();
            counter += 1;
        }

        // Выведи значение переменной catCount
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        // Создай статическую переменную catCount
        public static int catCount;

        // Создай конструктор
        public Cat(){
            Cat.catCount += 1;
        }
    }
}
