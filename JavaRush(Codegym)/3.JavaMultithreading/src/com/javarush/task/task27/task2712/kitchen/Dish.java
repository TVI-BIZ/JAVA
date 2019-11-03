package com.javarush.task.task27.task2712.kitchen;


public enum Dish{
        Fish(25),
        Steak(30),
        Soup(15),
        Juice(5),
        Water(3);

    private int duration;

    public int getDuration() {
        return duration;
    }


    Dish(int duration) {

    }

    public static String allDishesToString(){
        String res = "";
        for(Dish elem:Dish.values()){
            res += elem +","+ " ";
        }
        res = res.trim();
        String finres = res.substring(0,res.length()-1);
        return finres;
    }

}









