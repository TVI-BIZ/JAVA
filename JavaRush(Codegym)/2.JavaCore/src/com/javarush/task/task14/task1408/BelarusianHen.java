package com.javarush.task.task14.task1408;


public class BelarusianHen extends Hen {

    public int getCountOfEggsPerMonth() {
        return 28;
    }

    public String getDescription() {

        return  BelarusianHen.super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

//<getDescription() родительского класса> + <" Моя страна - Sssss. Я несу N яиц в месяц.">

}



