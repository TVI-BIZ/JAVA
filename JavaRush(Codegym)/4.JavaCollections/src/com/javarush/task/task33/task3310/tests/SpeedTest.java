package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Long timeStart = System.currentTimeMillis();
        for(String elem:strings){
            ids.add(shortener.getId(elem));
        }
        Long timeFinish = System.currentTimeMillis();
        return timeFinish - timeStart;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Long timeStart = System.currentTimeMillis();
        for(Long elem:ids){
            strings.add(shortener.getString(elem));
        }
        Long timeFinish = System.currentTimeMillis();
        return timeFinish - timeStart;
    }
    @Test
    public void testHashMapStorage(){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();

        Shortener shortener1  = new Shortener(hashMapStorageStrategy);
        Shortener shortener2  = new Shortener(hashBiMapStorageStrategy);

        Set<String> origStrings = new HashSet<>();
        Set<Long> origId1 = new HashSet<>();
        Set<Long> origId2 = new HashSet<>();

        for(int i=0; i < 10000; i++){
            origStrings.add(Helper.generateRandomString());
        }


        Long time1 = getTimeToGetIds(shortener1,origStrings,origId1);
        Long time2 = getTimeToGetIds(shortener2,origStrings,origId2);

        Assert.assertTrue(time1>time2);


//
        Set<String> origStrings3 = new HashSet<>();
        Set<String> origStrings4 = new HashSet<>();
//
        Long time3 = getTimeToGetStrings(shortener1,origId1,origStrings3);
        Long time4 = getTimeToGetStrings(shortener2,origId2,origStrings4);

        Assert.assertEquals(time3,time4,30);

    }


}
