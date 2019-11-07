package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {
   StatisticManager statisticManager = StatisticManager.getInstance();

   public void printAdvertisementProfit() {
      double totalMoney3 = 0;
       DecimalFormat df2 = new DecimalFormat("#.##");
      //long totalMoney2 = 0;
      //To DO REFACTOR!
      Map<String,Double> moneyList2 = statisticManager.getAdvDataStorage3();
      Map<Date,Double> finalMoneyList = statisticManager.stringToDataList(moneyList2);
      String pattern = "dd-MMM-yyyy";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      for(Map.Entry<Date,Double> elem:finalMoneyList.entrySet()){
         //totalMoney2 += elem.getValue();
         totalMoney3 += elem.getValue();
         if((double)elem.getValue()/100>0) {
            System.out.println(simpleDateFormat.format(elem.getKey()) + " - " + (double) elem.getValue() / 100);
         }
      }
      if(totalMoney3>0){
         System.out.println("Total - "+ (double)totalMoney3/100 );
      }
   }
   public void printCookWorkloading(){
      Map<String,Map<String,Integer>> cookList2 = statisticManager.getCookDataStorage2();
      Map<Date,Map<String,Integer>> finalCookList = statisticManager.stringToDataList2(cookList2);
      String pattern = "dd-MMM-yyyy";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      for(Map.Entry<Date,Map<String,Integer>> elem:finalCookList.entrySet() ){
         System.out.println(simpleDateFormat.format(elem.getKey()));
         Map<String,Integer> cookTime = elem.getValue();
         for (Map.Entry<String,Integer> elem2: cookTime.entrySet()){
            if(elem2.getValue() !=0){
               System.out.println(elem2.getKey()+ " - "+elem2.getValue()+" min");
            }
         }
         System.out.println("");
      }




   }
   public void printActiveVideoSet(){

   }
   public void printArchivedVideoSet(){

   }


}
