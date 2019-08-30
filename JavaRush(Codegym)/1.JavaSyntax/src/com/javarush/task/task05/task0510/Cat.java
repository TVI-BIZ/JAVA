package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name;
    int age;
    int weight;
    String address;
    String color;

    //напишите тут ваш код
    public void initialize (String name){
        this.name = name;
        age = 3;
        weight = 12;
        color = "Gray";



    }
    public void initialize (String name, int weight,int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        color = "Red";

    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        weight = 24;
        color = "Red";

    }
    public void initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
        age = 3;


    }


    public void initialize(int weight,String color,String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        age = 3;

    }



    public static void main(String[] args) {

    }
}
