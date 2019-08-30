package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    static RussianHen rhen = new RussianHen();
    public int getCountOfEggsPerMonth() {
        return 25;
    }

      public String getDescription() {

        return  RussianHen.super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}