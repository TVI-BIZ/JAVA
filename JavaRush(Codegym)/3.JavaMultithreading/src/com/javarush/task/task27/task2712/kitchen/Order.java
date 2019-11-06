package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    public Tablet getTablet() {
        return tablet;
    }

    private final Tablet tablet;

    public List<Dish> getDishes() {
        return dishes;
    }

    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }


    @Override
    public String toString() {
        String res = "";
        if(dishes.size() == 0){
            return "";
        } else{
            res = dishes.toString();
            return "Your order: "+ res + " of " + tablet;
        }
    }

    public int getTotalCookingTime(){
        int res = 0;
        for (Dish elem:dishes){
            res += elem.getDuration();
        }
        return res;
    }

    public boolean isEmpty(){
        if(dishes.size()==0){
           return true;
        } else {
            return false;
        }
    }

}
