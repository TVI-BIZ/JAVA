package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import javafx.beans.InvalidationListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();




    public static void main(String[] args) throws IOException, InterruptedException {
        Cook newCook = new Cook("Piter");
        Cook newCook2 = new Cook("Andrew");
        newCook.setQueue(orderQueue);
        newCook2.setQueue(orderQueue);


        Waiter newWaiter = new Waiter();
        StatisticManager statisticManager = StatisticManager.getInstance();


        List<Tablet> tabletList = new ArrayList<>();
        for(int i=1; i < 6; i++){
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tabletList.add(tablet);
        }

        newCook.addObserver(newWaiter);
        newCook2.addObserver(newWaiter);

        Runnable runnable = new RandomOrderGeneratorTask(tabletList,ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(1000);
        thread.interrupt();

        Thread threadCook = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    newCook.run();
                    newCook2.run();
                }catch (Exception e){

                }
            }
        });



        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();



    }
}
