package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;

import java.util.Observable;



import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    static  java.util.logging.Logger logger =  Logger.getLogger(Tablet.class.getName());


    public static void setLogger(Logger logger) {
        Tablet.logger = logger;
    }


    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    private  LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();




    public Tablet(int number) {

        this.number = number;
        //orderQueue =

    }




    public Order createOrder(){
        Order order = null;
        try {
            order = new Order(this);
                if(order.isEmpty()){
                    return null;
                } else{
                    ConsoleHelper.writeMessage("Start cooking - "+order.toString()+", cooking time " +order.getTotalCookingTime()+ "min");
                   // setChanged();
                    //notifyObservers(order);
                    queue.add(order);
                    new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
                    return order;
                }

        } catch (IOException e){
            logger.log(Level.SEVERE,"Console is unavailable.");
            return null;
        } catch (NoVideoAvailableException n){
            logger.log(Level.INFO,"No video is available for the order " + order);
            return null;
        }
    }


    @Override
    public String toString() {
        String res = "";
        res= "Tablet{number="+number+"}";
        return res;
    }


    public void createTestOrder() throws IOException {
        TestOrder testOrder = null;
        try {
            testOrder = new TestOrder(this);
            if(testOrder.isEmpty()){
            } else{
                ConsoleHelper.writeMessage("Start cooking - "+testOrder.toString()+", cooking time " +testOrder.getTotalCookingTime()+ "min");
                //setChanged();
                //notifyObservers(testOrder);
                queue.add(testOrder);
                new AdvertisementManager(testOrder.getTotalCookingTime()*60).processVideos();
            }

        } catch (IOException e){
            logger.log(Level.SEVERE,"Console is unavailable.");
        } catch (NoVideoAvailableException n){
            logger.log(Level.INFO,"No video is available for the order " + testOrder);

        }

    }





}
