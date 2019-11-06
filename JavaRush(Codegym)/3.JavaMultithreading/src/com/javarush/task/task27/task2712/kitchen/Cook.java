package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object order) {
        //Order order1 = (Order) order;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        ConsoleHelper.writeMessage("Start cooking - "+order.toString()+", cooking time " +((Order)(order)).getTotalCookingTime()+ "min");

        //StatisticManager.getInstance().register(((Order) order).getDishes());

        StatisticManager.getInstance().register(new CookedOrderEventDataRow(((Order)(order)).getTablet().toString(),name,((Order)(order)).getTotalCookingTime(),((Order)(order)).dishes));
    }



}
