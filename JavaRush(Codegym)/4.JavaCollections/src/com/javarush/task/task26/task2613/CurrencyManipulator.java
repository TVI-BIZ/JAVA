package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    public String getCurrencyCode() {
        return currencyCode;
    }

    private String currencyCode;
    private  Map<Integer, Integer> denominations = new HashMap<>();


    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination)){
          denominations.put(denomination,denominations.get(denomination)+count);
        } else {
            denominations.put(denomination,count);
        }
    }
    public int getTotalAmount(){
        return denominations.entrySet().stream().
                map(e -> e.getKey() * e.getValue()).mapToInt(Integer::intValue).sum();
    }
}
