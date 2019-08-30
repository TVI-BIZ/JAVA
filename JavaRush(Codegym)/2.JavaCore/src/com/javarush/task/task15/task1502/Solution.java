package com.javarush.task.task15.task1502;

/* 
ООП - Наследование животных
*/

public class Solution {
    //добавьте классы Goose и Dragon тут

    public static class Goose extends SmallAnimal {
        SmallAnimal animal = new SmallAnimal();

        public String getSize(){
            return "Гусь маленький, " + animal.getSize() ;
        }

    }
    public static class Dragon extends BigAnimal {
        BigAnimal animal = new BigAnimal();

        public String getSize(){
            return "Дракон большой, " + animal.getSize();
        }

    }

    public static void main(String[] args) {

    }

    public static class BigAnimal {
        protected String getSize() {
            return "как динозавр";
        }
    }

    public static class SmallAnimal {
        String getSize() {
            return "как кошка";
        }
    }

}
