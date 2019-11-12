package com.javarush.task.task33.task3310.strategy;

import com.google.common.collect.HashBiMap;

public class HashBiMapStorageStrategy implements StorageStrategy{
    private HashBiMap<Long,String> data = HashBiMap.create();


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
        return data.inverse().get(value);
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
