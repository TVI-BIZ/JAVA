package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;

import java.util.Observable;



import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    static  java.util.logging.Logger logger =  Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){
        Order order = null;
        try {
            order = new Order(this);
                if(order.isEmpty()){
                    return null;
                } else{
                    new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
                    ConsoleHelper.writeMessage("Start cooking - "+order.toString()+", cooking time " +order.getTotalCookingTime()+ "min");
                    setChanged();
                    notifyObservers(order);
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






}
