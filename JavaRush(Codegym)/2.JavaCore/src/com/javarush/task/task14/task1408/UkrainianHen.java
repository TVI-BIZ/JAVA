package com.javarush.task.task14.task1408;

public  class UkrainianHen extends Hen {
    static UkrainianHen uhen = new UkrainianHen();
    public  int getCountOfEggsPerMonth(){
        return 26;
    }
    public String getDescription() {

        return  UkrainianHen.super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
