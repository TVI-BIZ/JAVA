package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
       Tablet newTablet =  new Tablet(2);

       newTablet.createOrder();
       newTablet.createOrder();
       newTablet.createOrder();
       newTablet.createOrder();


       //ConsoleHelper.getAllDishesForOrder();

    }
}
