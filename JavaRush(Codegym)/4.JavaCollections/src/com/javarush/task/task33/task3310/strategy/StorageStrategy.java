package com.javarush.task.task33.task3310.strategy;

public interface StorageStrategy {
    public boolean containsKey(Long key);
    public void put(Long key, String value);
    public Long getKey(String value);
    boolean containsValue(String value);
    String getValue(Long key);
}
