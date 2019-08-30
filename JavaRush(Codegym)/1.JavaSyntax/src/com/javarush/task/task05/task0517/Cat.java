package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;

    public Cat (String name)
    {
        this.name = name;
        this.age = 5;
        this.weight = 4;
        this.color = "grey";
    }
    public Cat (String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "pink";
    }
    public Cat (String name, int age)
    {
        this.name = name;
        this.weight = 10;
        this.age = age;
        this.color = "Brown";

    }

    public Cat (int weight, String color)
    {
        this.weight = weight;
        this.color = color;
        //this.name = null;
        this.age = 6;
        //this.address = null;

    }
    public Cat (int weight, String color, String address)
    {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 6;

    }




    public static void main(String[] args) {

    }
}
