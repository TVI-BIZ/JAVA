package com.javarush.task.task27.task2712.kitchen;


public enum Dish{
        Fish,
        Steak,
        Soup,
        Juice,
        Water;


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









