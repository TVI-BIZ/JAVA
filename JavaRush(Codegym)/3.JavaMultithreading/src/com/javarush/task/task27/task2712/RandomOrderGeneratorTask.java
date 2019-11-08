package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tabletList;
    private int orderInterval;

    private StatisticManager statisticManager = StatisticManager.getInstance();


    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) throws InterruptedException {
        this.tabletList = tablets;
        this.orderInterval = interval;
    }

    @Override
    public void run() {
        try {
           for(Tablet elem: tabletList){
               Thread.sleep(orderInterval);
               elem.createTestOrder();
           }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
