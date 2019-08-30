package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private String familyName;
        private String wifeName;
        private boolean child;

        public Human(String name){
            this.name = name;
        }
        public Human(String name, String familyName){
            this.name = name;
            this.familyName = familyName;
        }
        public Human(String wifeName, boolean sex){
            this.wifeName = wifeName;
            this.sex = sex;
        }
        public Human(int age){
            this.age = age;
        }
        public  Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public  Human(String name, int age, String familyName){
            this.name = name;
            this.age = age;
            this.familyName = familyName;
        }
        public  Human(String name, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public  Human(String name, int age, boolean sex, String wifeName){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.wifeName = wifeName;
        }
        public  Human(String name, int age, boolean sex, String wifeName, boolean child){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.wifeName = wifeName;
            this.child = child;
        }
        public  Human(String name, boolean sex, boolean child){
            this.name = name;
            this.sex = sex;
            this.child = child;
        }




    }
}
