package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) {
        this.tablet = tablet;
    }

    public Order(List<Dish> dishes, Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        String res = "";
        if(dishes.size() == 0){
            return "";
        } else{
            for(Dish elem:dishes){
                res += elem.toString();
            }
            //return res;
        }
        return "Your order:"+ res + "of Tablet" + tablet;
    }
}
