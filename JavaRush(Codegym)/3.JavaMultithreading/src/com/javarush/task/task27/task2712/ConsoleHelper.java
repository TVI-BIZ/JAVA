package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementStorage;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsoleHelper {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }



    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishList = new ArrayList<>();
        writeMessage("Choose dish.");
        writeMessage(Dish.allDishesToString());
        String choosedDish;

        Boolean dishFlag = false;

        while (!(choosedDish = readString()).equals("exit")){
           for(Dish elem:Dish.values()){
               if(elem.toString().equals(choosedDish)){
                    dishFlag = true;
               }
           }

           if(dishFlag == false){
               writeMessage("This not valid");
           } else {
               try {
                   Dish dishFromMenu = Dish.valueOf(choosedDish);
                   dishList.add(dishFromMenu);
                   } catch (Exception e){

               }
           }
        }



        return dishList;
    }

}
