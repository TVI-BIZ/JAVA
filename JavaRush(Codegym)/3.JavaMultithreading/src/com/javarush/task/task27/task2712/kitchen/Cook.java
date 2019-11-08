package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Restaurant;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {   //implements Observer
    private String name;
    //private OrderManager orderManager = new OrderManager();
   //private Restaurant restaurant = new Restaurant();
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }


    public boolean isBusy() {
        return busy;
    }

    private boolean busy;

    public Cook(String name) throws InterruptedException {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public void update(Observable o, Object order) {
//        //Order order1 = (Order) order;
//        orderManager.getOrderQueue().add((Order) order);
//
//        ConsoleHelper.writeMessage("Start cooking - " + order);
//        setChanged();
//        notifyObservers(order);
//        ConsoleHelper.writeMessage("Start cooking - "+order.toString()+", cooking time " +((Order)(order)).getTotalCookingTime()+ "min");
//        StatisticManager.getInstance().register(new CookedOrderEventDataRow(((Order)(order)).getTablet().toString(),name,((Order)(order)).getTotalCookingTime(),((Order)(order)).dishes));
//    }

      public void startCookingOrder(Order order) throws InterruptedException {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        Thread.sleep(order.getTotalCookingTime()*10);
        notifyObservers(order);
        ConsoleHelper.writeMessage("Start cooking - "+order.toString()+", cooking time " +order.getTotalCookingTime()+ "min");
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),name,order.getTotalCookingTime(),order.dishes));
        setChanged();

        busy = false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                startCookingOrder(queue.take());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

  //Old Variant before 21
//    @Override
//    public void run() {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true) {
//                        if (!queue.isEmpty()) {
//                            Set<Cook> cooks = StatisticManager.getInstance().getCooks();
//                            for (Cook cook : cooks) {
//                                if (!cook.isBusy()) {
//                                    cook.startCookingOrder(queue.take());
//                                    if (queue.isEmpty()) {
//                                        break;
//                                    }
//                                }
//                            }
//                        }
//                        Thread.sleep(10);
//                    }
//                } catch (InterruptedException e) {
//                    return;
//                }
//            }
//        });
//
//
//        thread.setDaemon(true);
//        thread.start();
//    }


}
