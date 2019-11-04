package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.*;

public class AdvertisementManager {

    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();



    public AdvertisementManager(int timeSeconds) {

        this.timeSeconds = timeSeconds;

    }


    private int timeSeconds;



    public void processVideos(){
        if(storage.list().isEmpty()){
            throw new NoVideoAvailableException();

        } else {
            int orderTime = this.timeSeconds;


            List<Advertisement> listBiggerZero = new ArrayList<>();
            List<Advertisement> listFinal = new ArrayList<>();


            for(Advertisement elem: storage.list()){
                if(elem.getDuration()>0&&elem.getHits()>0){
                    listBiggerZero.add(elem);
                }
            }

            listBiggerZero.sort(Comparator.comparingLong(Advertisement::getAmountPerOneDisplaying).thenComparingInt(Advertisement::getDuration));
            Collections.reverse(listBiggerZero);
            for(Advertisement elem:listBiggerZero){
                if(elem.getDuration()<orderTime){
                    listFinal.add(elem);
                    orderTime = orderTime-elem.getDuration();
                }
            }
            //Collections.sort(listFinal,Comparator.comparing(Advertisement::getDuration));
            //Collections.sort(listFinal,Comparator.comparingInt(o->(int)o.getAmountPerOneDisplaying()));


            for(Advertisement elem:listFinal){
                if(elem.getHits()>0) {
                    System.out.println(elem.getName() + " is displaying... "
                            + elem.getAmountPerOneDisplaying() + ", " + (elem.getAmountPerOneDisplaying() * 1000) / elem.getDuration());
                    elem.revalidate();
                }
            }
        }

    }

}
