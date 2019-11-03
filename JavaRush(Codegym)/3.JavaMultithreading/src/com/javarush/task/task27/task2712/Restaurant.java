package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import javafx.beans.InvalidationListener;

import java.io.IOException;
import java.util.Observable;

public class Restaurant {
    public static void main(String[] args) throws IOException {
       Tablet newTablet =  new Tablet(2);
       Cook newCook = new Cook("Piter Parker");
        Waiter newWaiter = new Waiter();

//          newTablet.createOrder();
//        newTablet.createOrder();
//        newTablet.createOrder();
//        newTablet.createOrder();




        newTablet.addObserver(newCook);
        newCook.addObserver(newWaiter);

        //System.out.println(newCook.update(newCook.,newTablet.createOrder()));
       System.out.println(newTablet.createOrder().getTotalCookingTime());

    }
}
