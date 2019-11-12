package com.javarush.task.task33.task3310.strategy;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class DualHashBidiMapStorageStrategy implements StorageStrategy {
    private DualHashBidiMap<Long,String> data = new DualHashBidiMap();

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
        return data.getKey(value);
    }

    @Override
    public boolean containsValue(String value) {
        if(data.containsValue(value)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
