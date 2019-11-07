package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import javafx.beans.InvalidationListener;

import java.io.IOException;
import java.util.Observable;

public class Restaurant {
    public static void main(String[] args) throws IOException {
       Tablet newTablet =  new Tablet(2);
       Cook newCook = new Cook("Piter Parker");
       Cook newCook2 = new Cook("COOK2");
        Waiter newWaiter = new Waiter();


        newTablet.addObserver(newCook);
        newTablet.createOrder();
        newCook.addObserver(newWaiter);

        newTablet.addObserver(newCook2);
        newTablet.createOrder();
        newCook2.addObserver(newWaiter);



        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
//
//        StatisticManager sm = StatisticManager.getInstance();
//        sm.getAdvDataStorage();


    }
}
