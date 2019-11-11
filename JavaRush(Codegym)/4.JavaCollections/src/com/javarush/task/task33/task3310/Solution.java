package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args) {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        testStrategy(hashMapStorageStrategy,10000);

    }
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> resSet = new HashSet<>();
        for(String elem: strings){
            resSet.add(shortener.getId(elem));
        }
        return resSet;
    }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> resSet = new HashSet<>();
        for(Long elem: keys){
            resSet.add(shortener.getString(elem));
        }
        return resSet;
    }
    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());


        Set<String> genSetHelper = new HashSet<>();
        for(int i=0; i< elementsNumber;i++){
            genSetHelper.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        //Time measure.
        Date startDate = new Date();
        Set<Long> setStringId = getIds(shortener,genSetHelper);
        Date endDate = new Date();

        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.MICROSECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        Helper.printMessage("getId takes " +
                diff + " ms");

        Date startDate2 = new Date();
       Set<String> genSet2String=  getStrings(shortener,setStringId);
        Date endDate2 = new Date();

        long diffInMillies2 = Math.abs(endDate2.getTime() - startDate2.getTime());
        long diff2 = TimeUnit.MICROSECONDS.convert(diffInMillies2, TimeUnit.MILLISECONDS);

        Helper.printMessage("getString takes " +
                (diff2) + " ms");

        if( genSetHelper.equals(genSet2String)){
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }

    }


}
