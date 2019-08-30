package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man Piter = new Man("Piter",44,"London");
        Man Sidor = new Man("Viktor",43,"Murmansk");

        Woman Liza = new Woman("Lisa",33,"Lima");
        Woman Polli = new Woman("Polli",33,"Oslo");

        System.out.println(Liza.name + " " + Liza.age + " " + Liza.address);
        System.out.println(Polli.name + " " + Polli.age + " " + Polli.address);
        System.out.println(Piter.name + " " + Piter.age + " " + Piter.address);
        System.out.println(Sidor.name + " " + Sidor.age + " " + Sidor.address);

    }

    //напишите тут ваш код
    public static class Man{
        String name;
        int age;
        String address;
        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }
    public static class Woman{
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }
}
