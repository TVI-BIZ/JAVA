package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task32.task3209.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    static  java.util.logging.Logger logger =  Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }
    public void createOrder(){
        //ExceptionHandler.log("Console is unavailable.","SEVERE");

        logger.log(Level.parse("SEVERE"),"Console is unavailable.");
        //logger.log
        new Order(this);
    }

    @Override
    public String toString() {
//        Order currentOrder = new Order(this);
//        this.
        String res = "";
//        if(currentOrder.size() == 0){
//            return "";
//        } else{
//            for(Dish elem:Order){
//                res += elem.toString();
//            }
//            //return res;
//        }
//        return "Your order:"+ res + "of Tablet" + tablet;
        return res;
    }




}
