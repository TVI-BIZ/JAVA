package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int counterThis = 0;
        int counterAnother = 0;

        if (this.age > anotherCat.age){
            counterThis ++;
        } else if (this.age < anotherCat.age)  {
            counterAnother ++;
        }

        if (this.weight > anotherCat.weight){
            counterThis ++;
        } else if (this.weight < anotherCat.weight) {
            counterAnother ++;
        }


        if (this.strength > anotherCat.strength){
            counterThis ++;
        } else if (this.strength < anotherCat.strength) {
            counterAnother ++;
        }


        if (counterThis > counterAnother) {
            return true;
        } else {
            return  false;
        }


//            int thiscatsum = this.age + this.strength + this.weight;
//            int anothercatsum = anotherCat.age + anotherCat.strength + anotherCat.weight;
//
//        if (thiscatsum > anothercatsum){
//            return true;
//        } else {
//            return false;
//        }

    }

    public static void main(String[] args) {

    }
}
