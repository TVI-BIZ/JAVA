package com.javarush.task.task38.task3804;

public class FactoryException {
    public static Exception  factoryException(Enum enumParam){
        if(enumParam.getClass().equals("ApplicationExceptionMessage")){
            return new Exception();
        } else if(enumParam.getClass().equals("DatabaseExceptionMessage")){
            return new RuntimeException();
        }else if(enumParam.getClass().equals("UserExceptionMessage")){
            return null;
        } else{
            return new IllegalArgumentException();
        }
    }
}
