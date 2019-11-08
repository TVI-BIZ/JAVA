package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
   StatisticManager statisticManager = StatisticManager.getInstance();
   StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

   public void printAdvertisementProfit() {
      double totalMoney4 = 0;
      Map<String,Double> moneyList4 = statisticManager.getAdvDataStorage4();
      for(Map.Entry<String,Double> elem:moneyList4.entrySet()){
         totalMoney4 += elem.getValue();
         if((double)elem.getValue()>0) {
            System.out.println((elem.getKey()) + " - " + (double) elem.getValue() / 100);
         }
      }
      if(totalMoney4>0){
         System.out.println("Total - "+ (double)totalMoney4/100 );
      }
   }

   public void printCookWorkloading(){
      Map<String,Map<String,Integer>> cookList2 = statisticManager.getCookDataStorage2();
      for(Map.Entry<String,Map<String,Integer>> elem:cookList2.entrySet() ){
         System.out.println(elem.getKey());
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
     List<Advertisement> advList =  statisticAdvertisementManager.getActiveVideosFromStorage();
      advList.sort(Comparator.comparing(Advertisement::getName));

      for(Advertisement elem: advList){
         System.out.println(elem.getName()+" - "+elem.getHits());
      }


   }
   public void printArchivedVideoSet(){
      List<Advertisement> advList =  statisticAdvertisementManager.getNonActiveVideosFromStorage();
      List<String> nameList = new ArrayList<>();
      for(Advertisement elem: advList){
         nameList.add(elem.getName());
      }
      nameList.sort(String::compareToIgnoreCase);
      for(String elem:nameList){
         System.out.println(elem);
      }

   }


}
