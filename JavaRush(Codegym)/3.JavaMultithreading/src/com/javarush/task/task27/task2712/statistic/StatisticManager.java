package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class StatisticManager {
    private static StatisticManager static_single_instance = null;
    private StatisticStorage statisticStorage = new StatisticStorage();

    public Set<Cook> getCooks() {
        return cooks;
    }


    private Set<Cook> cooks = new HashSet<>();



    public static StatisticManager getInstance(){
        if(static_single_instance == null){
            static_single_instance = new StatisticManager();
        }
        return static_single_instance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data){

        statisticStorage.put(data);
    }



    public Map<String,Double> getAdvDataStorage4(){
        Map<String,Double> dailyProfit = new TreeMap<>(Collections.reverseOrder());
        String pattern = "dd-MMM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Map<EventType, List<EventDataRow>> fromStorage =  this.statisticStorage.getStorage();
        for (Map.Entry<EventType, List<EventDataRow>> elem: fromStorage.entrySet()){
            if(elem.getKey() == EventType.SELECTED_VIDEOS){
                for (EventDataRow elem2:elem.getValue()){
                    VideoSelectedEventDataRow selectedVideos = (VideoSelectedEventDataRow)elem2;
                    String profitDate = simpleDateFormat.format(elem2.getDate());
                    if(dailyProfit.containsKey(profitDate)){
                        Double newSum = dailyProfit.get(profitDate)+(double)selectedVideos.getAmount();
                        dailyProfit.put(profitDate,newSum);
                    } else {
                        dailyProfit.put(profitDate, (double) selectedVideos.getAmount());
                    }
                }
            }
        }
        return dailyProfit;
    }

    public Map<Date,Double> stringToDataList(Map<String,Double> oldmap )  {
        Map<Date,Double> finalList = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<String,Double> elem: oldmap.entrySet()){
            try{
                finalList.put(new SimpleDateFormat("dd-MMM-yyyy").parse(elem.getKey()),elem.getValue());
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return finalList;
    }


    public Map<Date,Map<String,Integer>> stringToDataList2(Map<String,Map<String,Integer>> oldmap )  {
        Map<Date,Map<String,Integer>> finalList = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<String,Map<String,Integer>> elem: oldmap.entrySet()) {
            try{
                finalList.put(new SimpleDateFormat("dd-MMM-yyyy").parse(elem.getKey()),elem.getValue());
             } catch (Exception e){
                System.out.println(e);
            }
        }
        return finalList;
    }

    public Map<String,Map<String,Integer>> getCookDataStorage2(){
        Map<String,Map<String,Integer>> dailyCook = new TreeMap<>(Collections.reverseOrder());
        String pattern = "dd-MMM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Map<EventType, List<EventDataRow>> fromStorage =  this.statisticStorage.getStorage();

        for (Map.Entry<EventType, List<EventDataRow>> elem: fromStorage.entrySet()){
            if(elem.getKey() == EventType.COOKED_ORDER){
                for (EventDataRow elem2:elem.getValue()){
                    CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow)elem2;
                    String cookName = cookedOrder.getCookName();
                    String cookDate = simpleDateFormat.format(elem2.getDate());

                    if(dailyCook.containsKey(cookDate)){

                        Map<String,Integer> oldMap = dailyCook.get(cookDate);
                        for(Map.Entry<String,Integer> elem3: dailyCook.get(cookDate).entrySet()){
                            if(elem3.getKey().equals(cookName)){
                                Integer newSum = oldMap.get(cookName)+cookedOrder.getTime();
                                oldMap.put(cookName,newSum);
                            }else {
                                oldMap.put(cookName,cookedOrder.getTime());
                            }
                        }
                    } else {
                        Map<String,Integer> newMap = new TreeMap<>();
                        newMap.put(cookName,cookedOrder.getTime());
                        dailyCook.put(cookDate,newMap);
                    }
                }
            }
        }

        return dailyCook;
    }




   private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

       public Map<EventType, List<EventDataRow>> getStorage() {
           return storage;
       }

       public StatisticStorage() {
            for (EventType eventType:EventType.values())
                storage.put(eventType,new ArrayList<EventDataRow>());
        }
        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }
    }






}
