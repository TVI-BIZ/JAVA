package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager single_instance = null;
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();


    public static StatisticAdvertisementManager getInstance(){
        if(single_instance == null){
            single_instance = new StatisticAdvertisementManager();
        }
        return single_instance;
    }

    private StatisticAdvertisementManager() {

    }

    public List<Advertisement> getActiveVideosFromStorage(){
        List<Advertisement> advertisementActiveList = new ArrayList<>();

        for (Advertisement elem: advertisementStorage.list()){
            if(elem.getHits()>0){
                advertisementActiveList.add(elem);
            }
        }
        return advertisementActiveList;
    }

    public List<Advertisement> getNonActiveVideosFromStorage(){
        List<Advertisement> advertisementNonActiveList = new ArrayList<>();
        for (Advertisement elem: advertisementStorage.list()){
            if (elem.getHits()==0){
                advertisementNonActiveList.add(elem);
            }
        }
        return advertisementNonActiveList;
    }







}
