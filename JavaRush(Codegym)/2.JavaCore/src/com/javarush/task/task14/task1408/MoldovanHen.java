package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 27;
    }
    static MoldovanHen mhen = new MoldovanHen();
    public String getDescription() {

        return  MoldovanHen.super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
