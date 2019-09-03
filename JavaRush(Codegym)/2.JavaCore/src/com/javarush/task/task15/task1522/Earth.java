package com.javarush.task.task15.task1522;

public class Earth implements Planet {


    public static Earth getInstance(){
        if (instance == null){
            instance = new Earth();
        }
        return instance;
    }
    private static Earth instance;
    private Earth(){

    }

}
