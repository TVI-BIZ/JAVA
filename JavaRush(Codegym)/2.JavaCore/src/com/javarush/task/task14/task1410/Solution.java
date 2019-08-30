package com.javarush.task.task14.task1410;

/* 
Дегустация вин
*/

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {
        Wine wine = new Wine();
        return wine;
    }

    public static Wine getWine() {
        Wine wine = new Wine();
        return wine;

    }

    public static Wine getBubblyWine() {
        BubblyWine bubwine = new BubblyWine();
        return bubwine;
    }


//    public static abstract class Drink {
//        public void taste(){
//            System.out.println("Вкусно");
//        }
//
//    }

//    public static class Wine extends Drink{
//        public String getHolidayName(){
//            return "День Рождения";
//        }
//    }
//    public static   class BubblyWine extends Wine {
//        public String getHolidayName(){
//            return "Новый Год";
//        }
//    }
}
