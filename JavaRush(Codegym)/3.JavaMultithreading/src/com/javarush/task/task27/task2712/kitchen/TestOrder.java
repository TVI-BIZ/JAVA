package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }
    //this random wrong for 21 task.
    //@Override
//    protected void initDishes() throws IOException {
//
//        //Todo random  init
//        List<Dish> randomDishes = new ArrayList<>();
//        randomDishes.add(Dish.Juice);
//        randomDishes.add(Dish.Fish);
//        randomDishes.add(Dish.Steak);
//        randomDishes.add(Dish.Water);
//        randomDishes.add(Dish.Soup);
//        randomDishes.add(Dish.Juice);
//        randomDishes.add(Dish.Steak);
//        randomDishes.add(Dish.Fish);
//        randomDishes.add(Dish.Water);
//        randomDishes.add(Dish.Soup);
//
//        double dishQuantity = Math.random()*5;
//        int roundNum = (int)dishQuantity;
//        List<Dish> realRandomList = new ArrayList<>();
//        if((int)dishQuantity==0){
//            roundNum = 1;
//        }
//
//        for(int i=0;i <roundNum;i++){
//            realRandomList.add(Dish.values()[i]);
//        }
//
//        super.dishes = realRandomList;
//        super.initDishes();
//
//    }
    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = new ArrayList<>();
        dishes.addAll(Arrays.asList(Dish.values()));
        int randDishCount = (int) (Math.random() * Dish.values().length) + 1;
        int countOfDishToDelete = dishes.size() - randDishCount;
        for (int i = 0; i < countOfDishToDelete; i++) {
            dishes.remove((int) (Math.random() * dishes.size()));
        }
    }


}
