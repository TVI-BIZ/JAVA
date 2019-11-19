package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private CurrencyManipulatorFactory() {

    }
    private static CurrencyManipulatorFactory currencyManipulatorFactory_instance = null;

    public static CurrencyManipulatorFactory getInstance(){
        if(currencyManipulatorFactory_instance==null){
            currencyManipulatorFactory_instance = new CurrencyManipulatorFactory();
        }
        return currencyManipulatorFactory_instance;
    }


    private static Map<String,CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
            currencyCode = currencyCode.toUpperCase();
            if(!getInstance().map.containsKey(currencyCode.toUpperCase())){
                getInstance().map.put(currencyCode,new CurrencyManipulator(currencyCode.toUpperCase()));
            }
        return getInstance().map.get(currencyCode.toUpperCase());
    }
}
