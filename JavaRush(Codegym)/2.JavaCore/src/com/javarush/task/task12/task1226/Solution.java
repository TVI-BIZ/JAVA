package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {

    }

    public  class Cat implements CanRun,CanClimb{
        public void run(){

        }
        public void climb(){

        }
    }

    public class Dog implements CanRun {
        public void run(){

        }
    }

    public class Tiger extends Cat {

    }

    public class Duck implements CanFly,CanRun {
        public void fly(){

        }
        public void run(){

        }


    }


    public interface CanFly{
        void fly();
    }
    public static interface CanClimb{
        void climb();
    }
    public interface CanRun{
        void run();
    }
}
