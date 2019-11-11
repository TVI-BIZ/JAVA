package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();


    @Override
    public boolean containsKey(Long key) {
        if(data.containsKey(key)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void put(Long key, String value) {
        data.put(key,value);
    }

    @Override
    public Long getKey(String value) {
        for(Map.Entry<Long,String> elem:data.entrySet()){
            if(elem.getValue().equals(value)){
                return elem.getKey();
            }
        }
        return null;
    }

    @Override
    public boolean containsValue(String value) {
        if(data.containsValue(value)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
