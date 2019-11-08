package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {

    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();



    public AdvertisementManager(int timeSeconds) {

        this.timeSeconds = timeSeconds;

    }


    private int timeSeconds;


    private int totalDurationCounter(List<Advertisement> list){
        int duration = 0;
        for(Advertisement elem: list){
            duration += elem.getDuration();
        }
        return duration;
    }
    private long totalAmountCounter(List<Advertisement> list){
        long result = 0;
        for(Advertisement elem: list){
            result += elem.getAmountPerOneDisplaying();
        }
        return result;
    }


    public void processVideos(){
        if(storage.list().isEmpty()){
            throw new NoVideoAvailableException();

        } else {
            int orderTime = this.timeSeconds;
            List<Advertisement> listBiggerZero = new ArrayList<>();
            List<Advertisement> listFinal = new ArrayList<>();

            storage.list().sort(Comparator.comparingLong(Advertisement::getAmountPerOneDisplaying).thenComparingInt(Advertisement::getDuration).reversed());

            for(Advertisement elem: storage.list()){
                if(elem.getDuration()>0&&elem.getHits()>0){
                    listBiggerZero.add(elem);
                }
            }


            for(Advertisement elem:listBiggerZero){
                if(elem.getDuration()<=orderTime ){
                    listFinal.add(elem);
                    orderTime = orderTime-elem.getDuration();
                }
            }

            if (listFinal.isEmpty()){
                throw new NoVideoAvailableException();
            }

            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(listFinal,totalAmountCounter(listFinal),totalDurationCounter(listFinal)));



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
