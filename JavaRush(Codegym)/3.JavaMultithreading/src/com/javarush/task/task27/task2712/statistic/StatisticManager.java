package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager {
    private static StatisticManager static_single_instance = null;
    private StatisticStorage statisticStorage = new StatisticStorage();
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

    public void register(Cook cook){
        cooks.add(cook);
    }

    public void getAdvDataStorage(){
        for(Map.Entry<EventType, List<EventDataRow>> elem:this.statisticStorage.storage.entrySet()){
            System.out.println(elem.getKey());
//            if(elem.getKey() == EventType.SELECTED_VIDEOS){
//                for(EventDataRow elem2:elem.getValue()){
//                    System.out.format("Date %s, Time %s, Type %s ",elem2.getDate(),elem2.getTime(),elem2.getType());
//                }
//
//            }
        }

    }




   private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType:EventType.values())
                storage.put(eventType,new ArrayList<EventDataRow>());

        }
        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);

        }
    }






}
